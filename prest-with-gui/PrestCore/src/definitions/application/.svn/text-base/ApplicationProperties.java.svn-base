package definitions.application;

import common.monitor.Logger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Properties;

public class ApplicationProperties {

	static final String lineSeparator = System.getProperty ( "line.separator" );
    private static final String propertiesFileName = "application.properties";
    private static Properties prop;
    public static String environment = null;
    public static boolean isInitializationSuccess = true;
    public static String initErrorDescription;

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

        System.out.println("Setting properties file name to " + propertiesFileFullPath);
        
        try {
            InputStream is = new java.io.FileInputStream(propertiesFileFullPath);
            
            prop.load(is);

        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("Could not read or find file '" + propertiesFileFullPath + "'");
            System.out.println("This property file is needed for the application to operate.");

            isInitializationSuccess = false;
            initErrorDescription = "Could not read or find application.properties";

            return;
        }
    }

    public static String get(String key) {
        String value = prop.getProperty(key);
        if ((value == null) && !prop.containsKey(key)) {
            Logger.error(ApplicationProperties.class.getName() + " Could not find the key " + key + " in Properties file.");
        }
        return (value);
    }
    
    public static void set(String key, String value) {
        String oldValue = prop.getProperty(key);
        if ((oldValue == null) && !prop.containsKey(key)) {
            Logger.error(ApplicationProperties.class.getName() + " Could not find the key " + key + " in Properties file.");
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
                Logger.error(ApplicationProperties.class.getName() + " Could not find the key " + key + " in Properties file.");
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
            output.write(lineSeparator +"CurrentProject = ");
        } catch (Exception ex) {
            Logger.error(ApplicationProperties.class.getName() + 
                    " set repository location " + ex.getMessage());
        } finally {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.error(ApplicationProperties.class.getName() + 
                        "exception in closing the propeties file after write" +
                        ex.getMessage());
            }
        }
    }

	public static void reCreatePropertiesFile(String workspaceLocation) {
		
        try {
            OutputStream os = new java.io.FileOutputStream(workspaceLocation + propertiesFileName);
            
            prop.store(os, "");

        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("Could not create file '" + propertiesFileName + "'");

            return;
        }
	}
}