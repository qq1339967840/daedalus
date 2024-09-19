package com.cib.icarus.annotation.internals.spi;

import com.cib.icarus.spi.Ordered;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.type.AnnotationMetadata;

public class DefaultConfigRegister implements IcarusConfigRegister {

    private static final Logger logger = LoggerFactory.getLogger(DefaultConfigRegister.class);

    @Override
    public boolean support(String moduleName) {
        return false;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // ignore ...
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
