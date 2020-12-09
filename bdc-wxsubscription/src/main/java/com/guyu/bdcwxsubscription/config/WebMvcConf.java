package com.guyu.bdcwxsubscription.config;

import com.guyu.bdcwxsubscription.service.WxPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @创建人 黄盼
 * @创建时间 2020/12/7 0007 10:41
 * @描述 登录拦截
 **/
@Configuration
public class WebMvcConf implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private WxPersonnelService userService;

    /**
     * 添加拦截
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/") // 排除127.0.0.1进入登录页
                .excludePathPatterns("/login.html").excludePathPatterns("/personnel/submit"); // 排除127.0.0.1进入登录页
    }

    /**
     * 使用注解
     *
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new LoginUserArgumentResolver(userService));
    }

    /**
     * 文件上传
     *
     * @return
     */
    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        //resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
        resolver.setResolveLazily(true);
        resolver.setMaxInMemorySize(40960);
        //上传文件大小 50M 50*1024*1024
        resolver.setMaxUploadSize(50 * 1024 * 1024);
        return resolver;
    }


}
