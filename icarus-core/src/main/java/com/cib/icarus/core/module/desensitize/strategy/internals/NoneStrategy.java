package com.cib.icarus.core.module.desensitize.strategy.internals;

import com.cib.icarus.core.module.desensitize.strategy.DesensitizeStrategy;

/**
 * do nothing
 */
public class NoneStrategy extends DesensitizeStrategy {

    @Override
    public String doDesensitization(String source, char placeholder) {
        return source;
    }
}
