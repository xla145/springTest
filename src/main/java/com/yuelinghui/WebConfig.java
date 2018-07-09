package com.yuelinghui;


import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("com.yuelinghui.controller")
public class WebConfig extends WebMvcConfigurerAdapter{


//    /**
//     * 配置视图解析器
//     * @return
//     */
//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//        internalResourceViewResolver.setPrefix("/WEB-INF/view2.0/");
//        internalResourceViewResolver.setSuffix(".html");
//        internalResourceViewResolver.setExposeContextBeansAsAttributes(true);
//        return internalResourceViewResolver;
//    }


    @Bean
    public FreeMarkerConfigurer getFreemarkerConfig() {
        FreeMarkerConfigurer result = new FreeMarkerConfigurer();
        result.setTemplateLoaderPath("/WEB-INF/view2.0/");
        Properties properties = new Properties();
        properties.setProperty("default_encoding","UTF-8");
        properties.setProperty("locale","zh_CN");
        result.setFreemarkerSettings(properties);
        return result;

    }
//
    @Bean
    public ViewResolver getViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setCache(false);
//        resolver.setPrefix("/WEB-INF/view2.0/");
        resolver.setSuffix(".html");
        resolver.setOrder(1);
        resolver.setContentType("text/html; charset=utf-8");
        resolver.setRequestContextAttribute("request");
        return resolver;

    }


    /**
     * 配置静态资源
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 上传文件
     * @return
     */
    @Bean
    public MultipartResolver multipartResolver() throws IOException {
//        return new StandardServletMultipartResolver();
        CommonsMultipartResolver commonsMultipartResolver =  new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(20000000);
//        commonsMultipartResolver.setUploadTempDir(new FileSystemResource("g:/"));
        commonsMultipartResolver.setMaxInMemorySize(0);
        return commonsMultipartResolver;
    }


}
