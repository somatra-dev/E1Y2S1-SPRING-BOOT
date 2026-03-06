package com.pesexpo.api.javabean;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("javabean/")
public class JavaBeanController {

    private final JavaBean javaBean;
//    private final JavaBean javaBean1;
// no need @@Qualifier("javaBean2") cuz name are the same with method bean that we already created in @Configuration

    public JavaBeanController(@Qualifier("javaBean1") JavaBean javaBean) {
        this.javaBean = javaBean;
    }


    @GetMapping("beans")
    public List<JavaBean> getJavaBeans() {
        return List.of(javaBean);
    }

}
