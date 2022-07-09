package com.example.demo.interceptor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan
public class InterceptorConfig implements WebMvcConfigurer {
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 拦截的路径
    String[] addPathPatterns = {"/login/**"};

    // 不拦截的路径
    String[] excludePathPatterns = {"/logout/**"};

    registry
        .addInterceptor(new UserInterceptor())
        .addPathPatterns(addPathPatterns)
        .excludePathPatterns(excludePathPatterns);
  }
}
