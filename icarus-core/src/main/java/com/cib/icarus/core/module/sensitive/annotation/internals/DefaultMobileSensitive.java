package com.cib.icarus.core.module.sensitive.annotation.internals;


import com.cib.icarus.core.module.sensitive.annotation.StrategySensitive;
import com.cib.icarus.core.module.sensitive.strategy.SensitiveMobileStrategy;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@StrategySensitive(strategy = SensitiveMobileStrategy.class)
public @interface DefaultMobileSensitive {
}
