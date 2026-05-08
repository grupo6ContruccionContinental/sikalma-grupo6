package com.example.demo.Login;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/login",
                        "/logout",
                        "/acceso-denegado",
                        "/",
                        "/css/**",
                        "/js/**",
                        "/images/**",
                        "/favicon.ico"
                );
    }
}
