package com.cib.icarus.spring.adpater;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(IcarusConfigRegisterSupports.class)
public @interface EnableIcarusConfig {

    /**
     * @return module name. 将要引入哪些模块
     */
    String[] value() default {};


}
