package com.yanqiancloud.control.configserver.login.gitlab.config;

import com.yanqiancloud.control.configserver.login.gitlab.filter.ApplicationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: yqcloud
 * @Description: 对自定义过滤器进行配置注册
 * @Author: lingyun.wei
 * @CreateDate: 2018/10/20 21:30
 * @Version: 1.0
 */
@Configuration
public class FilterConfig {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SecurityProperties securityProperties;



    @Bean
    public FilterRegistrationBean applicationFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        ApplicationFilter applicationFilter = new ApplicationFilter();
        registrationBean.setFilter(applicationFilter);
        String filterUrls = securityProperties.getFilterUrls();
        logger.info("被过滤的地址：{}", filterUrls);
        List<String> urls = Arrays.asList(filterUrls.split(","));
        registrationBean.setUrlPatterns(urls);

        return registrationBean;
    }
}
