package com.ahmadkamal.cms.config;

import com.ahmadkamal.cms.filter.MyNewFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfig {

    @Bean
    public FilterRegistrationBean<MyNewFilter> filterFilterRegistrationBean(){
        FilterRegistrationBean<MyNewFilter> myNewFilterFilterRegistrationBean = new FilterRegistrationBean<>();
        myNewFilterFilterRegistrationBean.setFilter(new MyNewFilter());
        myNewFilterFilterRegistrationBean.addUrlPatterns("/customer/*");
        return myNewFilterFilterRegistrationBean;
    }
}
