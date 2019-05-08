package com.cyt.graduation_project.sys.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebConfig implements WebMvcConfigurer {
    //配置图片静态映射
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/UserInfo/**")
                .addResourceLocations("file:E://BD/")
                .setCachePeriod(31556926);
    }
}