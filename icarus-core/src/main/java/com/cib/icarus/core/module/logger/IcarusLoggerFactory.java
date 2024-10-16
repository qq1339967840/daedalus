package com.cib.icarus.core.module.logger;

import com.cib.icarus.core.module.logger.deferred.DeferredLogger;
import com.cib.icarus.core.module.logger.desensitize.DesensitizeLogger;
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

    public static DesensitizeLogger getDesensitizeLogger(Class<?> clazz) {
        return new DesensitizeLogger(LoggerFactory.getLogger(clazz));
    }

    public static DesensitizeLogger getDesensitizeLogger(String name) {
        return new DesensitizeLogger(LoggerFactory.getLogger(name));
    }


}
