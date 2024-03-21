package com.fn.qms.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppLog {
	public Logger logger = LogManager.getLogger(this.getClass());

    static {
//        logger = LogManager.getLogger(this.getClass());
    }

    public static void info(String logString) {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        String clsName = ste.getClassName();
        Logger subLog = LogManager.getLogger(clsName);
        if (subLog == null) {
            return;
        }
        subLog.info(logString);
       
    }

    public static void error(String logString) {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        String clsName = ste.getClassName();
        Logger subLog = LogManager.getLogger(clsName);
        if (subLog == null) {
            return;
        }
        subLog.error( ste.getClassName() + " " + ste.getMethodName() + " " + ste.getLineNumber() + " - " + logString);
    
    }

    public static void error(Exception e) {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        String clsName = ste.getClassName();
        Logger subLog = LogManager.getLogger(clsName);
        if (subLog == null) {
            return;
        }
        subLog.error(ste.getClassName() + " " + ste.getMethodName() + " " + ste.getLineNumber() + " - " + e);
        subLog.error("", e);
        e.printStackTrace();
    }

    public static void error(String info, Exception e) {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        String clsName = ste.getClassName();
        Logger subLog = LogManager.getLogger(clsName);
        if (subLog == null) {
            return;
        }
        subLog.error(ste.getClassName() + " " + ste.getMethodName() + " " + ste.getLineNumber() + " - " + e);
        subLog.error(info, e);
        
    }

    public static void debug(String logString) {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        String clsName = ste.getClassName();
        Logger subLog = LogManager.getLogger(clsName);
        if (subLog == null) {
            return;
        }
        subLog.debug(ste.getClassName() + " " + ste.getMethodName() + " " + ste.getLineNumber() + " - " + logString);
    }

    public static void warning(String logString) {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        String clsName = ste.getClassName();
        Logger subLog = LogManager.getLogger(clsName);
        if (subLog == null) {
            return;
        }
        subLog.warn(ste.getClassName() + " " + ste.getMethodName() + " " + ste.getLineNumber() + " - " + logString);
    }
}
