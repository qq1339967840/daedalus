package com.cib.icarus.spring.adpater.spi;

import com.cib.icarus.core.spi.Ordered;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.type.AnnotationMetadata;

public interface IcarusConfigRegister extends Ordered {

    boolean support(String moduleName);

    void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry);
}
