package com.cib.icarus.core.module.desensitize.strategy;

/**
 * do nothing
 */
public class NoneSensitiveStrategy extends SensitiveStrategy {

    @Override
    public String doDesensitization(String source, char placeholder) {
        return source;
    }
}
