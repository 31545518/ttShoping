package com.tt.cart.config;

import com.tt.cart.interceptor.UserLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置类
 * @Auther: blackcat
 * @Date: 2020-03-05
 * @Description: com.tt.cart.config
 * @version:
 */
@Configuration
public class WebApplication implements WebMvcConfigurer {
    @Autowired
    private UserLoginInterceptor userLoginInterceptor;

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(this.userLoginInterceptor);
        // 拦截器的URL
        interceptorRegistration.addPathPatterns("/cart/goSettlement/**");
    }
}
