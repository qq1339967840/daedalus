package com.cib.icarus.spring.annotation.spi.internals;

import com.cib.icarus.spring.annotation.IcarusSpringConsts;
import com.cib.icarus.spring.annotation.spi.IcarusConfigRegister;
import com.cib.icarus.spring.module.xss.XssAttackAopIntercept;
import com.cib.icarus.spring.module.xss.XssAttackConfig;
import com.cib.icarus.spring.utils.BeanRegistrationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.type.AnnotationMetadata;

@EnableConfigurationProperties(value = {XssAttackConfig.class})
public class XssAttackConfigRegister implements IcarusConfigRegister {

    private static final Logger logger = LoggerFactory.getLogger(XssAttackConfigRegister.class);

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public boolean support(String moduleName) {
        return IcarusSpringConsts.XSS_ATTACK_MODULE_NAME.equalsIgnoreCase(moduleName);
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        logger.info("do invoke XssAttackConfigRegister#registerBeanDefinitions");
        BeanRegistrationUtil.registerBeanDefinitionIfNotExists(registry, "xssAttackAopIntercept", XssAttackAopIntercept.class);
        BeanRegistrationUtil.registerBeanDefinitionIfNotExists(registry, "xssAttackConfiguration", XssAttackConfig.class);
    }
}
