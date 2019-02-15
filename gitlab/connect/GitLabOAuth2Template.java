package com.yanqiancloud.control.configserver.login.gitlab.connect;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * @ProjectName: yqcloud
 * @Description: 重写OAuth2Template（执行OAthu协议前五步）createRestTemplate方法，添加一个解析字符串文本的消息转换器类型，
 * @Author: lingyun.wei
 * @CreateDate: 2018/10/19 12:43
 * @Version: 1.0
 */
public class GitLabOAuth2Template extends OAuth2Template {


    public GitLabOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
        super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
        setUseParametersForClientAuthentication(true);
    }

    @Override
    protected RestTemplate createRestTemplate() {
        RestTemplate restTemplate = super.createRestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return restTemplate;
    }
}
