package com.yanqiancloud.control.configserver.login.gitlab.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ProjectName: yqcloud
 * @Description: 第三方登录配置文件
 * @Author: lingyun.wei
 * @CreateDate: 2018/10/19 10:00
 * @Version: 1.0
 */
@ConfigurationProperties(prefix = "yqcloud.security")
public class SecurityProperties {

    /**
     * gitlab相关配置
     */
    private GitLabProperties gitLab = new GitLabProperties();

    /**
     * 被保护的url
     */
    private String filterUrls;


    /**
     * Spring Social拦截器SocialAuthenticationFilter拦截路径前缀配置
     */
    private String filterProcessesUrl;


    private String postLoginUrl;

    private boolean alwaysUsePostLoginUrl;

    public String getPostLoginUrl() {
        return postLoginUrl;
    }

    public void setPostLoginUrl(String postLoginUrl) {
        this.postLoginUrl = postLoginUrl;
    }

    public boolean isAlwaysUsePostLoginUrl() {
        return alwaysUsePostLoginUrl;
    }

    public void setAlwaysUsePostLoginUrl(boolean alwaysUsePostLoginUrl) {
        this.alwaysUsePostLoginUrl = alwaysUsePostLoginUrl;
    }

    public String getFilterProcessesUrl() {
        return filterProcessesUrl;
    }

    public void setFilterProcessesUrl(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    public GitLabProperties getGitLab() {
        return gitLab;
    }

    public void setGitLab(GitLabProperties gitLab) {
        this.gitLab = gitLab;
    }

    public String getFilterUrls() {
        return filterUrls;
    }

    public void setFilterUrls(String filterUrls) {
        this.filterUrls = filterUrls;
    }
}
