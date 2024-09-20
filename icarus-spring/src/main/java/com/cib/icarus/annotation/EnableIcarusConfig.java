package com.cib.icarus.annotation;

import com.cib.icarus.annotation.internals.IcarusConfigRegisterSupports;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(IcarusConfigRegisterSupports.class)
public @interface EnableIcarusConfig {

    String[] value() default {};


}
