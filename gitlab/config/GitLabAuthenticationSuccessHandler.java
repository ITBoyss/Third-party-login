package com.yanqiancloud.control.configserver.login.gitlab.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: yqcloud
 * @Description: 登陆成功处理器
 * @Author: WeiLingYun
 * @CreateDate: 2018/11/5 22:39
 * @Version: 1.0.0
 */
@Component("gitLabAuthenticationSuccessHandler")
public class GitLabAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        logger.info("登陆成功");
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
