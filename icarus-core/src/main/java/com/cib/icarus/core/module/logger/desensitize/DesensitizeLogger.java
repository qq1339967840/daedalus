package com.cib.icarus.core.module.logger.desensitize;

import com.cib.icarus.core.module.desensitize.core.ObjectWrapper;
import org.slf4j.Logger;
import org.slf4j.Marker;

public class DesensitizeLogger implements Logger {

    private final Logger logger;

    private final ObjectWrapper objectWrapper;

    public DesensitizeLogger(Logger logger) {
        this.logger = logger;
        this.objectWrapper = new ObjectWrapper();
    }

    @Override
    public String getName() {
        return this.logger.getName();
    }

    @Override
    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled();
    }

    @Override
    public void trace(String s) {
        this.logger.trace(s);
    }

    @Override
    public void trace(String s, Object o) {
        this.logger.trace(s, desensitize(o));
    }

    @Override
    public void trace(String s, Object o, Object o1) {
        this.logger.trace(s, desensitize(o), desensitize(o1));
    }

    @Override
    public void trace(String s, Object... objects) {
        this.logger.trace(s, desensitize(objects));
    }

    @Override
    public void trace(String s, Throwable throwable) {
        this.logger.trace(s, throwable);
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return this.logger.isTraceEnabled(marker);
    }

    @Override
    public void trace(Marker marker, String s) {
        this.logger.trace(marker, s);
    }

    @Override
    public void trace(Marker marker, String s, Object o) {
        this.logger.trace(marker, s, desensitize(o));
    }

    @Override
    public void trace(Marker marker, String s, Object o, Object o1) {
        this.logger.trace(marker, s, desensitize(o), desensitize(o1));
    }

    @Override
    public void trace(Marker marker, String s, Object... objects) {
        this.logger.trace(marker, s, desensitize(objects));
    }

    @Override
    public void trace(Marker marker, String s, Throwable throwable) {
        this.logger.trace(marker, s, throwable);
    }

    @Override
    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    @Override
    public void debug(String s) {
        this.logger.debug(s);
    }

    @Override
    public void debug(String s, Object o) {
        this.logger.debug(s, desensitize(o));
    }

    @Override
    public void debug(String s, Object o, Object o1) {
        this.logger.debug(s, desensitize(o), desensitize(o1));
    }

    @Override
    public void debug(String s, Object... objects) {
        this.logger.debug(s, desensitize(objects));
    }

    @Override
    public void debug(String s, Throwable throwable) {
        this.logger.debug(s, throwable);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return this.logger.isDebugEnabled(marker);
    }

    @Override
    public void debug(Marker marker, String s) {
        this.logger.debug(marker, s);
    }

    @Override
    public void debug(Marker marker, String s, Object o) {
        this.logger.debug(marker, s, desensitize(o));
    }

    @Override
    public void debug(Marker marker, String s, Object o, Object o1) {
        this.logger.debug(marker, s, desensitize(o), desensitize(o1));
    }

    @Override
    public void debug(Marker marker, String s, Object... objects) {
        this.logger.debug(marker, s, desensitize(objects));
    }

    @Override
    public void debug(Marker marker, String s, Throwable throwable) {
        this.logger.debug(marker, s, throwable);
    }

    @Override
    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    @Override
    public void info(String s) {
        this.logger.info(s);
    }

    @Override
    public void info(String s, Object o) {
        this.logger.info(s, desensitize(o));
    }

    @Override
    public void info(String s, Object o, Object o1) {
        this.logger.info(s, desensitize(o), desensitize(o1));
    }

    @Override
    public void info(String s, Object... objects) {
        this.logger.info(s, desensitize(objects));
    }

    @Override
    public void info(String s, Throwable throwable) {
        this.logger.info(s, throwable);
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return this.logger.isInfoEnabled(marker);
    }

    @Override
    public void info(Marker marker, String s) {
        this.logger.info(marker, s);
    }

    @Override
    public void info(Marker marker, String s, Object o) {
        this.logger.info(marker, s, desensitize(o));
    }

    @Override
    public void info(Marker marker, String s, Object o, Object o1) {
        this.logger.info(marker, s, desensitize(o1), desensitize(o1));
    }

    @Override
    public void info(Marker marker, String s, Object... objects) {
        this.logger.info(marker, s, desensitize(objects));
    }

    @Override
    public void info(Marker marker, String s, Throwable throwable) {
        this.logger.info(marker, s, throwable);
    }

    @Override
    public boolean isWarnEnabled() {
        return this.logger.isWarnEnabled();
    }

    @Override
    public void warn(String s) {
        this.logger.warn(s);
    }

    @Override
    public void warn(String s, Object o) {
        this.logger.warn(s, desensitize(o));
    }

    @Override
    public void warn(String s, Object... objects) {
        this.logger.warn(s, desensitize(objects));
    }

    @Override
    public void warn(String s, Object o, Object o1) {
        this.logger.warn(s, desensitize(o), desensitize(o1));
    }

    @Override
    public void warn(String s, Throwable throwable) {
        this.logger.warn(s, throwable);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return this.logger.isWarnEnabled(marker);
    }

    @Override
    public void warn(Marker marker, String s) {
        this.logger.warn(marker, s);
    }

    @Override
    public void warn(Marker marker, String s, Object o) {
        this.logger.warn(marker, s, desensitize(o));
    }

    @Override
    public void warn(Marker marker, String s, Object o, Object o1) {
        this.logger.warn(marker, s, desensitize(o), desensitize(o1));
    }

    @Override
    public void warn(Marker marker, String s, Object... objects) {
        this.logger.warn(marker, s, desensitize(objects));
    }

    @Override
    public void warn(Marker marker, String s, Throwable throwable) {
        this.logger.warn(marker, s, throwable);
    }

    @Override
    public boolean isErrorEnabled() {
        return this.logger.isErrorEnabled();
    }

    @Override
    public void error(String s) {
        this.logger.error(s);
    }

    @Override
    public void error(String s, Object o) {
        this.logger.error(s, desensitize(o));
    }

    @Override
    public void error(String s, Object o, Object o1) {
        this.logger.error(s, desensitize(o), desensitize(o1));
    }

    @Override
    public void error(String s, Object... objects) {
        this.logger.error(s, desensitize(objects));
    }

    @Override
    public void error(String s, Throwable throwable) {
        this.logger.error(s, throwable);
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return this.logger.isErrorEnabled(marker);
    }

    @Override
    public void error(Marker marker, String s) {
        this.logger.error(marker, s);
    }

    @Override
    public void error(Marker marker, String s, Object o) {
        this.logger.error(marker, s, desensitize(o));
    }

    @Override
    public void error(Marker marker, String s, Object o, Object o1) {
        this.logger.error(marker, s, desensitize(o), desensitize(o1));
    }

    @Override
    public void error(Marker marker, String s, Object... objects) {
        this.logger.error(marker, s, desensitize(objects));
    }

    @Override
    public void error(Marker marker, String s, Throwable throwable) {
        this.logger.error(marker, s, throwable);
    }


    private Object[] desensitize(Object[] objects) {
        Object[] newObjects = new Object[objects.length];
        for (int i = 0; i < objects.length; i++) {
            newObjects[i] = desensitize(objects[i]);
        }
        return newObjects;
    }

    private Object desensitize(Object object) {
        try {
            return objectWrapper.desensitize(object);
        } catch (Exception ex) {
            this.logger.warn("DesensitizeLogger convert desensitize error {}, ignore desensitize", ex.getMessage());
            return object;
        }
    }
}
