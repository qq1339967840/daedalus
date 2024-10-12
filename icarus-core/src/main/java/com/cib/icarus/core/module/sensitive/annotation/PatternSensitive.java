package com.cib.icarus.core.module.sensitive.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 按照正则表达式进行脱敏
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PatternSensitive {

    String placeholder() default "*";

    String pattern();
}
