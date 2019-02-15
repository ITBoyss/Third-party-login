package com.yanqiancloud.control.configserver.login.gitlab.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SpringSocialConfigurer;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * @ProjectName: yqcloud
 * @Description: 启用第三方登录
 * @Author: lingyun.wei
 * @CreateDate: 2018/10/19 9:19
 * @Version: 1.0
 */
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private ConnectionSignUp connectionSignUp;

    /**
     * @param connectionFactoryLocator 检索系统中匹配的connectionFactory，每个social-login都有自己的connectionFactory
     * @return
     */
    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        //Encryptors.noOpText()对存入UserConnection表中的密码配置存储策略
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
        //默认表明UserConnection,此处配置表前缀yqcloud_
        repository.setTablePrefix("yqcloud_");
        if (!StringUtils.isEmpty(connectionSignUp)) {
            repository.setConnectionSignUp(connectionSignUp);
        }
        logger.info("UsersConnectionRepository自定义成功");
        logger.info("repository类型：[{}]", repository.getClass());

        return repository;
    }


    /**
     * 将social的过滤器注入到spring
     *
     * @return
     */
    @Bean
    public SpringSocialConfigurer yqcloudSocialSecurityConfig() {
        String filterProcessesUrl = securityProperties.getFilterProcessesUrl();
        String postLoginUrl = securityProperties.getPostLoginUrl();
        boolean alwaysUsePostLoginUrl = securityProperties.isAlwaysUsePostLoginUrl();
        SpringSocialConfigurer springSocialConfigurer = new GitLabSpringSocialConfigurer(filterProcessesUrl, postLoginUrl, alwaysUsePostLoginUrl);
        logger.info("social的过滤器注入到spring完毕");
        return springSocialConfigurer;
    }

    /**
     * 本地系统和第三方用户信息交换的工具
     *
     * @param connectionFactoryLocator
     * @return
     */
    @Bean
    public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator) {
        return new ProviderSignInUtils(connectionFactoryLocator, getUsersConnectionRepository
                (connectionFactoryLocator)) {
        };
    }
}
