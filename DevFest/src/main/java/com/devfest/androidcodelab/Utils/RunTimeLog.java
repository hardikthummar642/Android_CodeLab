package com.devfest.androidcodelab.Utils;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * @author: Kioko
 * @description: This Class enables users to log events in the application using the Log class.
 */


public class RunTimeLog {

    //Declaration
    public static final int MODE_DEBUG = 1;
    public static final int MODE_RELEASE = 2;
    public static final int ERROR = 3;
    public static final int WARNING = 4;
    public static final int INFO = 5;
    public static final int DEBUG = 6;
    public static final int VERBOSE = 7;
    /**
     * There two types of of MODES:
     * 1. MODE_DEBUG (In-House Debugging): This enables you to Log data when you are Testing the Application
     * 2. MODE_RELEASE (Release Debugging): This enables you to store the Log file is a File
     */

    static int Mode = MODE_RELEASE;
    static String logFilePath = "/sdcard/DevFestLog.log";
    static Logger logger;
    static LogRecord logRecord;

    /** Initiate the Log on when the class is used for the fist time.
     *  This method will format the file name and add: Time
     **/
    static {
        try {
            FileHandler fileHandler = new FileHandler(logFilePath, true);
            fileHandler.setFormatter(new Formatter() {
                @Override
                public String format(LogRecord logRecord) {

                    StringBuffer stringBuffer = new StringBuffer(1000);
                    stringBuffer.append(new Date().getTime());
                    stringBuffer.append("/");
                    stringBuffer.append(new Date().getYear());
                    stringBuffer.append("\n");

                    return stringBuffer.toString();
                }
            });

            logger = Logger.getLogger(logFilePath);
            logger.addHandler(fileHandler);

        } catch (IOException iO) {
            //Print out the Error
            iO.printStackTrace();
        }
    }

    /**
     * @param logLevel
     * @param message  This is the message added to the Log File
     */
    public static void log(int logLevel, String message) {
        // Don't log DEBUG and VERBOSE statements in RELEASE_MODE to avoid large files
        if ((Mode == MODE_RELEASE) && (logLevel >= DEBUG))
            return;
            logRecord = new LogRecord(Level.ALL, message);
            logRecord.setLoggerName(logFilePath);

            try {
                switch (logLevel) {
                    case ERROR:
                        logRecord.setLevel(Level.SEVERE);
                        logger.log(logRecord);
                        break;
                    case WARNING:
                        logRecord.setLevel(Level.WARNING);
                        logger.log(logRecord);
                        break;
                    /** FINE and FINEST levels may not work for some API Versions. So we use INFO**/
                    case INFO:
                        logRecord.setLevel(Level.INFO);
                        logger.log(logRecord);
                        break;
                    case DEBUG:
                        logRecord.setLevel(Level.INFO);
                        logger.log(logRecord);
                        break;
                    case VERBOSE:
                        logRecord.setLevel(Level.INFO);
                        logger.log(logRecord);
                        break;
                }
            } catch (Exception exc) {
                exc.printStackTrace();
            }
    }

}
