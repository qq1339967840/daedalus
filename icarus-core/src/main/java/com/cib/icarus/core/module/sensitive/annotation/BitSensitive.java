package com.cib.icarus.core.module.sensitive.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface BitSensitive {

    char placeholder() default '*';

    int startBit() default 0;

    int endBit() default Integer.MAX_VALUE;
}
