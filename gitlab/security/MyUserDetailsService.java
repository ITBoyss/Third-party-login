package com.yanqiancloud.control.configserver.login.gitlab.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: yqcloud
 * @Description: SpringSocial根据第三方登录填写的信息，拿gitlab用户ID和providerId去本地的UserConnection
 * 表中查找出对应yqcloud系统中的用户ID,最后通过SocialUserDetailsService下的loadUserByUserId方法获取到yqcloud
 * 中的用户信息，放入session中
 * @Author: lingyun.wei
 * @CreateDate: 2018/10/19 9:40
 * @Version: 1.0
 */
@Component
public class MyUserDetailsService implements SocialUserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        logger.info("gitlab账户登录用户ID" + userId);
        //根据用户ID查找用户信息

        //根据查到的用户信息判断用户是否被冻结
        SocialUserDetails userDetails = new SocialUser(userId, "root", true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
        return userDetails;
    }
}
