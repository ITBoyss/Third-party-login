package com.yanqiancloud.control.configserver.login.gitlab.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @ProjectName: yqcloud
 * @Description: springSecurity个性化配置
 * @Author: lingyun.wei
 * @CreateDate: 2018/10/19 15:49
 * @Version: 1.0
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private SpringSocialConfigurer yqcloudSocialSecurityConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //添加Social过滤器SocialAuthenticationFilter到springSecurity过滤器链
                .apply(yqcloudSocialSecurityConfig);

        logger.info("SocialAuthenticationFilter配置加载");
        //在UsernamePasswordAuthenticationFilter 前添加 ApplicationFilter
        //http.addFilterBefore(new ApplicationFilter(),UsernamePasswordAuthenticationFilter.class);
    }
}
