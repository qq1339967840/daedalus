package com.cib.icarus.core.module.sensitive.annotation;

import com.cib.icarus.core.consts.IcarusGeneralConsts;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface BitSensitive {

    char placeholder() default IcarusGeneralConsts.DEFAULT_PLACEHOLDER_CHAR;

    int startBit() default 0;

    int endBit() default Integer.MAX_VALUE;
}
