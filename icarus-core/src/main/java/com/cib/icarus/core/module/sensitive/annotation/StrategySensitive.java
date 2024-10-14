package com.cib.icarus.core.module.sensitive.annotation;

import com.cib.icarus.core.consts.IcarusGeneralConsts;
import com.cib.icarus.core.module.sensitive.strategy.NoneSensitiveStrategy;
import com.cib.icarus.core.module.sensitive.strategy.SensitiveStrategy;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * 策略模式的敏感信息脱敏注解，用来指定一个实现了{@link SensitiveStrategy}的类进行脱敏
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface StrategySensitive {

    Class<? extends SensitiveStrategy> strategy() default NoneSensitiveStrategy.class;

    char placeholder() default IcarusGeneralConsts.DEFAULT_PLACEHOLDER_CHAR;

}
