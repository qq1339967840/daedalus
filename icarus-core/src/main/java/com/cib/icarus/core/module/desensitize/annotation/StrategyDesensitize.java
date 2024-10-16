package com.cib.icarus.core.module.desensitize.annotation;

import com.cib.icarus.core.consts.IcarusGeneralConsts;
import com.cib.icarus.core.module.desensitize.strategy.DesensitizeStrategy;
import com.cib.icarus.core.module.desensitize.strategy.internals.NoneStrategy;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * 策略模式的敏感信息脱敏注解，用来指定一个实现了{@link DesensitizeStrategy}的类进行脱敏
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface StrategyDesensitize {

    Class<? extends DesensitizeStrategy> strategy() default NoneStrategy.class;

    char placeholder() default IcarusGeneralConsts.DEFAULT_PLACEHOLDER_CHAR;

}
