package com.iris.serviceprovider.config;

import com.iris.serviceprovider.web.servlet.TimeoutAnnotationHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    public void addInterceptors(InterceptorRegistry registry) {
        // 注册一个拦截器
        registry.addInterceptor(new TimeoutAnnotationHandlerInterceptor());
    }
}
