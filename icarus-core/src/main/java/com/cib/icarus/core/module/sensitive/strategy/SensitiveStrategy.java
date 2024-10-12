package com.cib.icarus.core.module.sensitive.strategy;

import com.cib.icarus.core.module.sensitive.core.DesensitizationHelper;

/**
 * 脱敏策略接口
 */
public interface SensitiveStrategy {

    default String desensitization(final String source, char placeholder) {
        if (!DesensitizationHelper.canDesensitization(source)) {
            return source;
        }
        return doDesensitization(source, placeholder);
    }

    default String doDesensitization(final String source, char placeholder) {
        return source;
    }


}
