package com.cib.icarus.core.logger.hide;

import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

/**
 * TODO
 */
public class HideHelper {

    public static String getMessage(String msg, Object arg) {
        FormattingTuple format = MessageFormatter.format(msg, arg);
        return format.getMessage();
    }

    public static String getMessage(String msg, Object... objects) {
        FormattingTuple format = MessageFormatter.arrayFormat(msg, objects);
        return format.getMessage();
    }

    public static String getMessage(String msg, Object arg1, Object arg2) {
        FormattingTuple format = MessageFormatter.format(msg, arg1, arg2);
        return format.getMessage();
    }


}
