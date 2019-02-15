package com.yanqiancloud.control.configserver.login.gitlab.config;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @ProjectName: yqcloud
 * @Description: Gitlab第三方登录中的配置信息
 * @Author: lingyun.wei
 * @CreateDate: 2018/10/19 9:57
 * @Version: 1.0
 */
public class GitLabProperties extends SocialProperties {

    private String providerId = "gitlab";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
