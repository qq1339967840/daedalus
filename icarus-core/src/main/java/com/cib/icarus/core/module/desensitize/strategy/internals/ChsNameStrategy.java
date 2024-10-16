package com.cib.icarus.core.module.desensitize.strategy.internals;

import com.cib.icarus.core.module.desensitize.DesensitizeInfoUtils;
import com.cib.icarus.core.module.desensitize.strategy.DesensitizeStrategy;

public class ChsNameStrategy  extends DesensitizeStrategy {
    @Override
    public String doDesensitization(String source, char placeholder) {
        return DesensitizeInfoUtils.hideChsName(source, placeholder);
    }
}
