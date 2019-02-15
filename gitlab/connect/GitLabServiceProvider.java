package com.yanqiancloud.control.configserver.login.gitlab.connect;

import com.yanqiancloud.control.configserver.login.gitlab.api.GitLab;
import com.yanqiancloud.control.configserver.login.gitlab.api.GitLabImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * @ProjectName: yqcloud
 * @Description: 服务提供商，控制OAuth协议的执行
 * @Author: lingyun.wei
 * @CreateDate: 2018/10/18 17:03
 * @Version: 1.0
 */
public class GitLabServiceProvider extends AbstractOAuth2ServiceProvider<GitLab> {

    private static final String AUTHORIZE_URL = "http://gitlab.hand-ams.com/oauth/authorize";
    private static final String ACCESS_TOKEN_URL = "http://gitlab.hand-ams.com/oauth/token";

    public GitLabServiceProvider(String clientId, String clientSecret) {
        super(new GitLabOAuth2Template(clientId, clientSecret, AUTHORIZE_URL, ACCESS_TOKEN_URL));
    }

    @Override
    public GitLab getApi(String accessToken) {
        return new GitLabImpl(accessToken);
    }
}
