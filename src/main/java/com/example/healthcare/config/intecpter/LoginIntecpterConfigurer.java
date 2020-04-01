package com.example.healthcare.config.intecpter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginIntecpterConfigurer implements WebMvcConfigurer {
    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
                                 /*参数为自己的拦截器类*/         /*如果对某个路径不进行拦截 链式调用.excludePathPatterns()*/
        //registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/**").excludePathPatterns("/login.html","/","/static/**"); //拦截全部 **表示拦截的方法
       //registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/**").excludePathPatterns("/login.html","/","/myresources/css/**","/myresources/jquery/**","/myresources/images/**","/myresources/bootstrap/**"); //拦截全部 **表示拦截的方法
        //registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/**").excludePathPatterns("/login.html","/","/static/**"); //拦截全部 **表示拦截的方法
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/*.html").excludePathPatterns("/login.html","/","/static/**","main.html"); //拦截全部 **表示拦截的方法
       WebMvcConfigurer.super.addInterceptors(registry);
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("login.html").setViewName("login");
        registry.addViewController("main.html").setViewName("pageshow");
        registry.addViewController("register.html").setViewName("Register");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/myresources/**").addResourceLocations("classpath:/static/myresources");
    }
}
