package com.example.vblogservice.config;

import com.example.vblogservice.filter.VerifyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    VerifyInterceptor verifyInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(verifyInterceptor).excludePathPatterns("/user/login")
                .excludePathPatterns("/user/register");
    }
}
