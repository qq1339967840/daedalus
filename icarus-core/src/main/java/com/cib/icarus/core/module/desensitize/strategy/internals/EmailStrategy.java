package com.cib.icarus.core.module.desensitize.strategy.internals;

import com.cib.icarus.core.module.desensitize.strategy.DesensitizeStrategy;
import com.cib.icarus.core.utils.DesensitizeInfoUtils;

public class EmailStrategy extends DesensitizeStrategy {
    @Override
    public String doDesensitization(String source, char placeholder) {
        return DesensitizeInfoUtils.hideEmail(source, String.valueOf(placeholder));
    }
}
