package com.cib.icarus.spring.module.xss;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface XssAttackAnnotation {
}
