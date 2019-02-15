package com.yanqiancloud.control.configserver.login.gitlab.connect;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: yqcloud
 * @Description: 默认将gitlab账户注册为控制台账户
 * @Author: lingyun.wei
 * @CreateDate: 2018/10/19 13:38
 * @Version: 1.0
 */
@Component
public class GitLabConnectionSignUp implements ConnectionSignUp {

    @Override
    public String execute(Connection<?> connection) {
        //根据社交用户的信息默认创建用户并返回用户唯一标识
        return connection.getKey().getProviderUserId();
    }
}
