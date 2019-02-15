package com.yanqiancloud.control.configserver.login.gitlab.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.io.IOException;

/**
 * @ProjectName: yqcloud
 * @Description: GITLAB-API实现
 * @Author: lingyun.wei
 * @CreateDate: 2018/10/18 15:12
 * @Version: 1.0
 */
public class GitLabImpl extends AbstractOAuth2ApiBinding implements GitLab {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final String URL_GET_USERINFO = "http://gitlab.hand-ams.com/api/v4/user?access_token=%s";

    private String userInfoUrl;

    private ObjectMapper objectMapper = new ObjectMapper();

    public GitLabImpl(String accessToken) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.userInfoUrl = String.format(URL_GET_USERINFO, accessToken);
    }

    @Override
    public GitLabUserInfo getUserInfo() {
        String result = getRestTemplate().getForObject(userInfoUrl, String.class);
        logger.info("当前用户信息：[{}]", result);
        GitLabUserInfo userInfo = null;
        try {
            userInfo = objectMapper.readValue(result, GitLabUserInfo.class);
            logger.info(userInfo.getName());
        } catch (IOException e) {
            throw new RuntimeException("获取用户信息失败", e);
        }
        return userInfo;
    }
}
