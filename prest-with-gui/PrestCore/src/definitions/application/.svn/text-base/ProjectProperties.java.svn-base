/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package definitions.application;

import common.monitor.Logger;
import java.io.InputStream;
import java.util.Properties;
/**
 *
 * @author Gürhan
 */
public class ProjectProperties {
    
    private static Properties prop;
    public static boolean isInitializationSuccess = true;
    public static String initErrorDescription;

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
            initErrorDescription = "Could not read or find project.metadata";

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
}
