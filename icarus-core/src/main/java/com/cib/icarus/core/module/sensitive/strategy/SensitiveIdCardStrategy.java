package com.cib.icarus.core.module.sensitive.strategy;

import com.cib.icarus.core.module.sensitive.SensitiveInfoUtils;

public class SensitiveIdCardStrategy implements SensitiveStrategy {

    @Override
    public String doDesensitization(String source, char placeholder) {
        return SensitiveInfoUtils.hideIdCard(source, placeholder);
    }
}
