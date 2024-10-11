package com.cib.icarus.core.logger.hide;

import com.google.common.base.Splitter;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 */
public class HideLoggerManager {

    private final Logger logger;

    private final Map<String, Splitter> groupSplitter = new HashMap<>();

    private final Map<String, Splitter> kvSplitter = new HashMap<>();


    public HideLoggerManager(Logger logger) {
        this.logger = logger;
    }


}
