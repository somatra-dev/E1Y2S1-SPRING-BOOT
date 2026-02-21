package com.pesexpo.api;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
class BeanTest {

    private String name;

}
