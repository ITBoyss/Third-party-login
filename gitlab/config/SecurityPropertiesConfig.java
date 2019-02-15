package com.yanqiancloud.control.configserver.login.gitlab.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: yqcloud
 * @Description: 让SecurityProperties类的配置生效
 * @Author: lingyun.wei
 * @CreateDate: 2018/10/19 14:38
 * @Version: 1.0
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityPropertiesConfig {

}
