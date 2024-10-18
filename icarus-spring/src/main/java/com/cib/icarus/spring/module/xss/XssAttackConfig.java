package com.cib.icarus.spring.module.xss;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "xss.illegal.attack")
public class XssAttackConfig {

    private List<String> chars;

    public List<String> getChars() {
        return chars;
    }

    public void setChars(List<String> chars) {
        this.chars = chars;
    }
}
