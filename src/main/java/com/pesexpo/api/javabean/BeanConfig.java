package com.pesexpo.api.javabean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public JavaBean javaBean1() {

        JavaBean javaBean = new JavaBean();
        javaBean.setId("ISTAD-01");

        return javaBean;
    }
    @Bean
    public JavaBean javaBean2() {

        JavaBean javaBean = new JavaBean();
        javaBean.setId("ISTAD-02");

        return javaBean;
    }

}
