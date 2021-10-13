package common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Properties;
import org.apache.log4j.Logger;

import console.PrestConsoleApp;

public class ApplicationProperties {

    private static final String propertiesFileName = "application.properties";
    private static Properties prop;
    public static String environment = null;
    public static boolean isInitializationSuccess = true;
    public static String initErrorDescription;
    static Logger logger = Logger.getLogger(PrestConsoleApp.class.getName());
    public static void initiate() {
        initiate(propertiesFileName);
    }

	// SciDesktop Modification TA_R001	--- getPropertiesFileName introduced to allow retrieval of properties file name 
    public static String getPropertiesFileName()
    {
    	return propertiesFileName;
    }
    
    public static synchronized void initiateManual(String propertiesFileFullPath) {
        initiate(propertiesFileFullPath);

    }

    protected static synchronized void initiate(String propertiesFileFullPath) {

        prop = new Properties();

        if (propertiesFileFullPath == null) {
            System.out.println("Missing propertiesFile parameter");
            isInitializationSuccess = false;
            initErrorDescription = "Missing propertiesFile parameter";
            return;
        }

        logger.info("Setting properties file name to " + propertiesFileFullPath);
        
        try {
            InputStream is = new java.io.FileInputStream(propertiesFileFullPath);
            
            prop.load(is);

        } catch (Exception e) {
            e.printStackTrace();

            logger.error("Could not read or find file '" + propertiesFileFullPath + "'");
            logger.error("Property file is needed for the application to operate.");

            isInitializationSuccess = false;
            initErrorDescription = "Could not read or find application.properties";

            return;
        }
    }

    public static String get(String key) {
        String value = prop.getProperty(key);
        if ((value == null) && !prop.containsKey(key)) {
     }
        return (value);
    }
    
    public static void set(String key, String value) {
        String oldValue = prop.getProperty(key);
        if ((oldValue == null) && !prop.containsKey(key)) {
      } else {
        	prop.setProperty(key, value);
        }
    }

    public static String get(String key, String defaultValue) {
        return get(key, defaultValue, true);
    }

    public static String get(String key, String defaultValue, boolean expected) {
        String value = prop.getProperty(key);

        if ((value == null) && !prop.containsKey(key)) {
            if (expected) {
          }
        }

        return (prop.getProperty(key, defaultValue));
    }
    
	// SciDesktop Modification TA_R001	--- setRepositoryLocation modified to allow specification of properties file path externally
    public static void setRepositoryLocation(String propFilePath, String fullPath) {
        Writer output = null;
        try {
      	
        	output = new BufferedWriter(
                    new FileWriter(
                    new File(propFilePath != null ? propFilePath : (propertiesFileName))));
        	
            output.write("repositorylocation = " + fullPath);
        } catch (Exception ex) {
        } finally {
            try {
                output.close();
            } catch (IOException ex) {
          }
        }
    }

	public static void reCreatePropertiesFile(String workspaceLocation) {
		
        try {
            OutputStream os = new java.io.FileOutputStream(workspaceLocation + File.separator + propertiesFileName);
            
            prop.store(os, "");

        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("Could not create file '" + propertiesFileName + "'");

            return;
        }
	}
}