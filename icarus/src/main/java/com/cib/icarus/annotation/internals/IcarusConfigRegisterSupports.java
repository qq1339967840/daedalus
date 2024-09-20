package com.cib.icarus.annotation.internals;

import com.cib.icarus.annotation.EnableIcarusConfig;
import com.cib.icarus.spi.IcarusConfigRegister;
import com.cib.icarus.spi.ServiceBootstrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;
import java.util.List;

public class IcarusConfigRegisterSupports implements ImportBeanDefinitionRegistrar {

    private static final Logger logger = LoggerFactory.getLogger(IcarusConfigRegisterSupports.class);

    private List<IcarusConfigRegister> registers;

    public IcarusConfigRegisterSupports() {
        init();
    }

    private void init() {
        List<IcarusConfigRegister> list = ServiceBootstrap.loadAllOrdered(IcarusConfigRegister.class);
        if (list.isEmpty()) {
            throw new IllegalArgumentException("load IcarusConfigRegister Service failed!!!");
        }

        registers = list;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // register bean def
        AnnotationAttributes attributes = AnnotationAttributes
                .fromMap(importingClassMetadata.getAnnotationAttributes(EnableIcarusConfig.class.getName()));

        if (null == attributes) {
            logger.warn("【IcarusConfigRegister can't scan EnableIcarusConfig.class AnnotationAttributes】");
            return;
        }

        final String[] modules = attributes.getStringArray("value");

        logger.info("【IcarusConfigRegister scan modules {}, stared deal with register.】", Arrays.asList(modules));

        for (String module : modules) {
            for (IcarusConfigRegister register : registers) {
                if (register.support(module)) {
                    logger.info("【IcarusConfigRegister {} deal with module {}】", register.getClass(), module);
                    register.registerBeanDefinitions(importingClassMetadata, registry);
                }
            }
        }
    }
}
