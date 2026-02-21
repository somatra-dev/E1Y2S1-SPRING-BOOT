package com.pesexpo.api;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class BeanController {

    private final ObjectProvider<BeanTest> beanProvider;

    public BeanController(ObjectProvider<BeanTest> beanProvider) {
        this.beanProvider = beanProvider;
    }


    @GetMapping("/bean1")
    public String getBeanTest1() {
        BeanTest bean1 = beanProvider.getObject();
        bean1.setName(UUID.randomUUID().toString());
        return "bean1@" + System.identityHashCode(bean1) + " name=" + bean1.getName();

    }

    @GetMapping("/bean2")
    public String getBeanTest2() {
        BeanTest bean2 = beanProvider.getObject();
        bean2.setName(UUID.randomUUID().toString());
        return "bean2@" + System.identityHashCode(bean2) + " name=" + bean2.getName();

    }
}
