package common.monitor;

import org.apache.log4j.BasicConfigurator;

public class Logger {
	
private static org.apache.log4j.Logger log4jLogger;
	
	/**
	 * Static initializer for <code>Logger</code> class.
	 */
	static{
		log4jLogger = org.apache.log4j.Logger.getRootLogger();
		if( log4jLogger.getAppender("file") == null )
			BasicConfigurator.configure();
	}
	
	/**
	 * Logging informational messages.
	 * @param info
	 */
	public static void info( String info ){
		log4jLogger.info( info );
	}
	
	/**
	 * Logging erroneous messages.
	 * @param error
	 */
	public static void error( String error ){
		log4jLogger.error( error );
	}
	
	/**
	 * Logging warning messages.
	 * @param warn
	 */
	public static void warning( String warn ){
		log4jLogger.warn( warn );
	}
	
	/**
	 * Logging debugging messages. 
	 * @param debug
	 */
	public static void debug( String debug ){
		log4jLogger.debug( debug );
	}

}