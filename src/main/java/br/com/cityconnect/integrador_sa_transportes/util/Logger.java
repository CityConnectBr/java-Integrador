package br.com.cityconnect.integrador_sa_transportes.util;

import org.apache.log4j.PropertyConfigurator;

public class Logger {

    public static final String INFO = "info";
    public static final String WARN = "WARN";
    public static final String ERROR = "ERROR";
    public static final String FATAL = "FATAL";

    public static void sendLog(Class<?> c, String type, String log) {
        try {
            org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(c);
            
            PropertyConfigurator.configure(Logger.class.getResource("/log4j_logger.properties"));

            switch (type) {
                case INFO:
                    logger.info(log);
                    break;
                case WARN:
                    logger.warn(log);
                    break;
                case ERROR:
                	System.err.println(log);
                    logger.error(log);
                    break;
                case FATAL:
                	System.err.println(log);
                    logger.fatal(log);
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void sendLog(Class<?> c, String type, Exception e) {    	
        e.printStackTrace();    	
    	sendLog(c, type, e.toString());
    }

}
