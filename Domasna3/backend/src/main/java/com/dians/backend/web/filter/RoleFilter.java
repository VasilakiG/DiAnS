package com.dians.backend.web.filter;

import com.dians.backend.model.AdminUser;
import com.dians.backend.model.AppUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;

import java.io.IOException;

@WebFilter(filterName = "role-filter", urlPatterns = {"/home/admin/*"})
@Order(2)
public class RoleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        AppUser user = (AppUser) request.getSession().getAttribute("user");

        // Check if the user is an admin
        if (user instanceof AdminUser) {
            System.out.println("RoleFilter processing...");
            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("RoleFilter postprocessing...");
        } else {
            response.sendRedirect("/home");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
