package com.cib.icarus.core.logger;

import com.cib.icarus.core.logger.deferred.DeferredLogger;
import org.slf4j.LoggerFactory;

/**
 * 日志工厂。用来创建各类日志
 *
 * @author goomba
 */
public class IcarusLoggerFactory {

    public static DeferredLogger getDeferredLogger(Class<?> clazz) {
        return new DeferredLogger(LoggerFactory.getLogger(clazz));
    }

    public static DeferredLogger getDeferredLogger(String name) {
        return new DeferredLogger(LoggerFactory.getLogger(name));
    }


}
