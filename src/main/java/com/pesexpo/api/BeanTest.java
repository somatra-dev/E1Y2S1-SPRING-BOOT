package com.pesexpo.api;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;


@Getter
@Setter
@NoArgsConstructor
@Scope(scopeName = "singleton") // default scope
class Bean {

    private String name;

}
