package com.liyuan.binx.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@ServletComponentScan
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, ServletException, IOException {
        System.out.println(servletRequest.getRemoteAddr());
        System.out.println(servletRequest.getRemoteHost());
        System.out.println(servletRequest.getRemotePort());
        ((HttpServletRequest) servletRequest).setAttribute("token", "1234");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
