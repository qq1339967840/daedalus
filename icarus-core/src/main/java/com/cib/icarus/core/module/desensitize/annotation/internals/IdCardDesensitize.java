package com.cib.icarus.core.module.desensitize.annotation.internals;

import com.cib.icarus.core.module.desensitize.annotation.StrategyDesensitize;
import com.cib.icarus.core.module.desensitize.strategy.internals.IdCardStrategy;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@StrategyDesensitize(strategy = IdCardStrategy.class)
public @interface IdCardDesensitize {
}
