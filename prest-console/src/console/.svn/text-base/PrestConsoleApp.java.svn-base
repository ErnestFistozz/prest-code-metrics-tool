package console;

import java.io.File;

import org.apache.log4j.Logger;

import common.ApplicationProperties;


public class PrestConsoleApp {

	private static PrestConsoleApp appInstance;
	private static boolean fromCommandLine = false;
	private static String[] cmdArguments;
	static Logger logger = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Main method launching the application.
		 */
		ApplicationProperties.initiateManual(ApplicationProperties.getPropertiesFileName());
		System.setProperty("log.home", ApplicationProperties
				.get("repositorylocation")
				+ File.separator);
		logger = Logger.getLogger(PrestConsoleApp.class.getName());
		
		startup(args);

	}


	public static void startup(String[] args) {
		
		if (args == null || args.length == 0)
		{
			logger.error("No arguments provided.");
		}
		else
		{
			changeWorkStyle(args);
		}
		
		String repository = ApplicationProperties.get("repositorylocation");
		if (repository == null) {
			logger.error("check your application.properties file no repository location selected");
		}

		if (fromCommandLine) {
			CommandLineExplorer cmdLineExplorer = new CommandLineExplorer();
			cmdLineExplorer.startExecFromCmdLine(cmdArguments);
		}
	}



	public static void changeWorkStyle(String[] args) {
		fromCommandLine = true;
		cmdArguments = args;
	}

}
