package com.yanqiancloud.control.configserver.login.gitlab.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @ProjectName: yqcloud
 * @Description: 配置Social过滤器拦截的路径
 * @Author: lingyun.wei
 * @CreateDate: 2018/10/19 11:23
 * @Version: 1.0
 */
public class GitLabSpringSocialConfigurer extends SpringSocialConfigurer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String filterProcessesUrl;

    private String postLoginUrl;

    private boolean alwaysUsePostLoginUrl;

    public GitLabSpringSocialConfigurer(String filterProcessesUrl, String postLoginUrl, boolean alwaysUsePostLoginUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
        this.postLoginUrl = postLoginUrl;
        this.alwaysUsePostLoginUrl = alwaysUsePostLoginUrl;
    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        filter.setAlwaysUsePostLoginUrl(alwaysUsePostLoginUrl);
        filter.setPostLoginUrl(postLoginUrl);
        logger.info("成功配置拦截路径：[{}]", filterProcessesUrl);
        return (T) filter;
    }
}
