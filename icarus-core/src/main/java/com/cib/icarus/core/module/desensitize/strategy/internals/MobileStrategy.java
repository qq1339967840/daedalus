package com.cib.icarus.core.module.desensitize.strategy.internals;

import com.cib.icarus.core.utils.DesensitizeInfoUtils;
import com.cib.icarus.core.module.desensitize.strategy.DesensitizeStrategy;

public class MobileStrategy extends DesensitizeStrategy {

    @Override
    public String doDesensitization(String source, char placeholder) {
        return DesensitizeInfoUtils.hideMobile(source, placeholder);
    }
}
