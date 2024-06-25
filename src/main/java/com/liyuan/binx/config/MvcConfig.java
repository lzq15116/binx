//package com.liyuan.binx.config;
//
//import com.liyuan.binx.interceptor.WebInterceptor;
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@AllArgsConstructor
//public class MvcConfig implements WebMvcConfigurer {
//
//    private final WebInterceptor webInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        registry.addInterceptor(webInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/error");
//    }
//}
