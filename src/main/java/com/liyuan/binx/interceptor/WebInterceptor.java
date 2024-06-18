package com.liyuan.binx.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@AllArgsConstructor
public class WebInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getAttribute("token").toString();

        if (token.equals("1234")) {
            System.out.println("验证通过");
        } else {
            System.out.println("验证失败");
        }

        System.out.println(handler);
        return true;
    }
}
