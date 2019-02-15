package com.yanqiancloud.control.configserver.login.gitlab.connect;

import com.yanqiancloud.control.configserver.login.gitlab.api.GitLab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @ProjectName: yqcloud
 * @Description: 生产Connection工厂
 * @Author: lingyun.wei
 * @CreateDate: 2018/10/18 17:42
 * @Version: 1.0
 */
public class GitLabConnectionFactory extends OAuth2ConnectionFactory<GitLab> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public GitLabConnectionFactory(String providerId, String clientId, String clientSecret) {
        super(providerId, new GitLabServiceProvider(clientId, clientSecret), new GitLabAdapter());
        logger.info("GitLabConnectionFactory父类调用成功");
    }
}

/**
 * TODO：Spring Social 第三方登录基本流程
 * 1、Connection ：为统一管理各式各样的第三方用户信息,SpringSocial使用Connection接口用来存储用户第三方用户信息的标准的数据结构，
 *    他是由ConnectionFacotory的工厂方法创建的；
 * 2、ConnectionFacotory：提供工厂方法用来创建Connection对象，需提供两个核心组件：
 *      2.1、ServiceProvider 用来获取第三方用户信息 ，每种登录方式都要提供该登录方式
 *          特有的ServiceProvider的实现，需要提供两个组件：
 *          2.1.1、Oauth2Template  用来走整个Oauth流程获取accessToken,SpringSocial封装accessToken的对象为
 *                 AccessGrant ,他封装了Oauth2协议请求令牌时的标准的返回如令牌，刷新令牌，超时时间等。对Oauth2
 *                 协议不太了解的可以先去了解Oauth2的基本概念，这里不做赘述；
 *          2.1.2、Api ：拿Oauth2Template获得的accessToken,和一些必备参数,如openId（用户在服务提供商的id,在QQ
 *                 登录中需要通过accessToken去获取，而微信在返回accessToken时就返回用户在微信的openId了）等去第
 *                 三方应用获取用户信息。需要根据不同的登录方式提供自己的Api并实现获取用户信息的接口；
 *      2.2、ApiAdater ：用来将Api接口获得的用户信息适配成标准的第三方信息Connection对象
 * 3、UsersConnectionRepository ：用来对Connection对象做一些增删改查的操作。SpringSocial提供的表结构如下
 *          create table UserConnection (userId varchar(255) not null,
         *  providerId varchar(255) not null,
         *  providerUserId varchar(255),
         *  rank int not null,
         *  displayName varchar(255),
         *  profileUrl varchar(512),
         *  imageUrl varchar(512),
         *  accessToken varchar(512) not null,
         *  secret varchar(512),
         *  refreshToken varchar(512),
         *  expireTime bigint,
         *  primary key (userId, providerId, providerUserId));
         * create unique index UserConnectionRank on UserConnection(userId, providerId, rank);
 *      TODO:通过userId(用户在也业务系统的id),providerId（服务提供商的id）,providerUserId（即OpenId）
 *      TODO:做主键标识某个业务系统的用户已经与某个服务提供商的某个用户做了绑定了
 *
 */
