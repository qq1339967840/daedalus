package com.cib.icarus.core.module.sensitive.strategy;

import com.cib.icarus.core.module.sensitive.SensitiveInfoUtils;

public class SensitiveMobileStrategy implements SensitiveStrategy {

    @Override
    public String doDesensitization(String source, char placeholder) {
        return SensitiveInfoUtils.hideMobile(source, placeholder);
    }
}
