package com.cib.icarus.spring.module.xss;


import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import java.util.List;

@Aspect
public class XssAttackAopIntercept implements EnvironmentPostProcessor, EnvironmentAware {

    private static final Logger logger = LoggerFactory.getLogger(XssAttackAopIntercept.class);

    private static final String ILLEGAL_ATTACK_CHARS = "xss.illegal.attack.chars";

    private Environment environment;

    private List<String> interceptWords;


    public XssAttackAopIntercept() {
        init();
    }



    private void init() {
        if (environment != null) {
            List<String> target = environment.getProperty("xss.illegal.attack.chars", List.class);
            if (null == target || target.isEmpty()) {

            }
        }
    }


    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        ConfigurationPropertyName configurationPropertyName = ConfigurationPropertyName.of("xss.illegal.attack");

        List<String> target = environment.getProperty("xss.illegal.attack.chars", List.class);

//        environment.getPropertySources().get

        System.out.println("1111");
    }

    @Override
    public void setEnvironment(Environment environment) {
        ConfigurationPropertyName configurationPropertyName = ConfigurationPropertyName.of("xss.illegal.attack");

        String target = environment.getProperty("icarus.xss.intercept.words");
        System.out.println("1111");
    }
}
