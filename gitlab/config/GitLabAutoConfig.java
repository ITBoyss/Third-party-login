package com.yanqiancloud.control.configserver.login.gitlab.config;

import com.yanqiancloud.control.configserver.login.gitlab.connect.GitLabConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * @ProjectName: yqcloud
 * @Description: 配置GITLAB第三方登录的连接工厂
 * @Author: lingyun.wei
 * @CreateDate: 2018/10/19 10:11
 * @Version: 1.0
 */
@Configuration
public class GitLabAutoConfig extends SocialAutoConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private DataSource dataSource;


    @Autowired
    private ConnectionSignUp connectionSignUp;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        logger.info("连接工厂构建完毕");
        GitLabProperties gitLab = securityProperties.getGitLab();
        return new GitLabConnectionFactory(gitLab.getProviderId(), gitLab.getAppId(), gitLab.getAppSecret());
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
        //默认表明UserConnection,此处配置表前缀yqcloud_
        repository.setTablePrefix("yqcloud_");
        if (!StringUtils.isEmpty(connectionSignUp)){
            repository.setConnectionSignUp(connectionSignUp);
        }
        logger.info("GitLabAutoConfig============UsersConnectionRepository自定义成功");
        logger.info("repository类型：[{}]",repository.getClass());

        return repository;
    }
}

/**
 * 说明：
 *      --@ConditionalOnProperty(prefix = "yqcloud.security.gitlab", name = "app-id")
 *      表示当配置了yqcloud.security.gitlab.app-id时，这个连接工厂才会起作用
 */
