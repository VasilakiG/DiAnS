package com.dians.backend.web.filter;

import com.dians.backend.model.AdminUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;

import java.io.IOException;

@WebFilter(filterName = "auth-filter", urlPatterns = "/*",
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD},
        initParams = {
                @WebInitParam(name = "login-path", value = "/login"),
                @WebInitParam(name = "register-path", value = "/register"),
                @WebInitParam(name = "admin-login-path", value = "/login/admin")
        })
@Order(1)
public class LoginFilter implements Filter {

    private String loginPath;
    private String registerPath;
    private String adminLoginPath;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        loginPath = filterConfig.getInitParameter("login-path");
        registerPath = filterConfig.getInitParameter("register-path");
        adminLoginPath = filterConfig.getInitParameter("admin-login-path");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getServletPath();

        if (path.startsWith(loginPath) || path.startsWith(registerPath) || path.startsWith(adminLoginPath) || isUserLoggedIn(request)) {
            System.out.println("WebFilter preprocessing...");
            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("WebFilter postprocessing...");
        } else {
            response.sendRedirect("/login");
        }
    }

    private boolean isUserLoggedIn(HttpServletRequest request) {
        Object userObject = request.getSession().getAttribute("user");

        if (userObject instanceof AdminUser) {
            return true;
        }

        return userObject != null;
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}


