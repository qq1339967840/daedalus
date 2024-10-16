package com.cib.icarus.core.module.desensitize.strategy;

import com.cib.icarus.core.module.desensitize.core.DesensitizationHelper;

/**
 * 脱敏策略接口
 */
public abstract class DesensitizeStrategy {

    public final String desensitization(final String source, final char placeholder) {
        if (!DesensitizationHelper.canDesensitization(source)) {
            return source;
        }
        return doDesensitization(source, placeholder);
    }

    public abstract String doDesensitization(String source, char placeholder);


}
