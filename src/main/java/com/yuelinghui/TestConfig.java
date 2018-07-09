package com.yuelinghui;

import com.yuelinghui.filter.LoginFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletRegistration;


/**
 * 实现spring MVC
 * @author xla
 */
public class TestConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

//    ServletContainerInitializer 百
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


    /**
     * 拦截器
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] {new LoginFilter()};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement("g:/",2097152,4194304,0));
    }
}
