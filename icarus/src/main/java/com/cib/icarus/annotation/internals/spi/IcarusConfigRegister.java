package com.cib.icarus.annotation.internals.spi;

import com.cib.icarus.spi.Ordered;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.type.AnnotationMetadata;

public interface IcarusConfigRegister extends Ordered {

    boolean support(String moduleName);

    void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry);
}
