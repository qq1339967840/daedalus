package com.cib.icarus.core.module.sensitive.annotation.internals;

import com.cib.icarus.core.module.sensitive.annotation.StrategySensitive;
import com.cib.icarus.core.module.sensitive.strategy.SensitiveIdCardStrategy;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@StrategySensitive(strategy = SensitiveIdCardStrategy.class)
public @interface DefaultIdCardSensitive {
}
