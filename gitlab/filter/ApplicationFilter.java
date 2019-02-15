package com.yanqiancloud.control.configserver.login.gitlab.filter;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: yqcloud
 * @Description: 自定义过滤器拦截控制台应用访问
 * @Author: lingyun.wei
 * @CreateDate: 2018/10/20 18:28
 * @Version: 1.0
 */
public class ApplicationFilter extends GenericFilterBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("request：[{}]", request.getServletContext());
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!StringUtils.isEmpty(authentication)) {
            boolean authenticateFlag = authentication.isAuthenticated();
            if (authenticateFlag && !(authentication instanceof AnonymousAuthenticationToken)) {
                chain.doFilter(request, response);
            } else {
                //request.getRequestDispatcher("/oauth/gitlab").forward(request,response);
                redirectStrategy.sendRedirect(servletRequest, servletResponse, "/oauth/gitlab");
                return;
            }
        }
    }
}
