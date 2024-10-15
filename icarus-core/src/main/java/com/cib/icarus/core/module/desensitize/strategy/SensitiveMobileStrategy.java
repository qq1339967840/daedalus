package com.cib.icarus.core.module.desensitize.strategy;

import com.cib.icarus.core.module.desensitize.SensitiveInfoUtils;

public class SensitiveMobileStrategy extends SensitiveStrategy {

    @Override
    public String doDesensitization(String source, char placeholder) {
        return SensitiveInfoUtils.hideMobile(source, placeholder);
    }
}
