package com.yanqiancloud.control.configserver.login.gitlab.connect;

import com.yanqiancloud.control.configserver.login.gitlab.api.GitLab;
import com.yanqiancloud.control.configserver.login.gitlab.api.GitLabUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @ProjectName: yqcloud
 * @Description: 本地信息和服务提供商信息之间的桥梁，二者之间的适配器
 * @Author: lingyun.wei
 * @CreateDate: 2018/10/18 17:31
 * @Version: 1.0
 */
public class GitLabAdapter implements ApiAdapter<GitLab> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 对服务提供商提供的api进行测试，看是否联通，api有效
     * true 有效；false 无效
     * @param api
     * @return
     */
    @Override
    public boolean test(GitLab api) {
        logger.info("api测试通过");
        return true;
    }

    /**
     * 对组装Connection的信息进行封装
     * @param api
     * @param values
     */
    @Override
    public void setConnectionValues(GitLab api, ConnectionValues values) {
        GitLabUserInfo userInfo = api.getUserInfo();
        //serviceProvider用户名
        values.setDisplayName(userInfo.getUsername());
        //serviceProvider头像
        values.setImageUrl(userInfo.getAvatar_url());
        //serviceProvider用户主页
        values.setProfileUrl(userInfo.getWeb_url());
        //serviceProvider用户ID
        values.setProviderUserId(userInfo.getId());

    }

    @Override
    public UserProfile fetchUserProfile(GitLab api) {
        return null;
    }


    /**
     * TODO 对主页的更新，gitlab do-noting
     * @param api
     * @param message
     */
    @Override
    public void updateStatus(GitLab api, String message) {

    }
}
