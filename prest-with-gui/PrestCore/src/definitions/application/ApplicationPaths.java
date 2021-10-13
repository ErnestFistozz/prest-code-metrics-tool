package definitions.application;

import java.io.InputStream;
import java.net.URL;

/**
 * 
 * @author Gürhan
 */
public class ApplicationPaths {

    private static String binFolder = "";
    private static String logFolder = "";
    private static String libFolder = "";
    private static String rscFolder = "";
    private static String tmpFolder = "";
    private static String appRoot = "";
    private static String campaignsFolder = "";
    

    static {
        initiate();
    }

    /**
     * VeriBranchApp constructor comment.
     */
    public ApplicationPaths() {
        super();
    }

    /**
     * Insert the method's description here.
     * Creation date: (20.12.2001 17:45:32)
     * @return java.lang.String
     */
    public static String getApplicationRoot() {
        return appRoot;
    }

    /**
     * Insert the method's description here.
     * Creation date: (20.12.2001 17:45:32)
     * @return java.lang.String
     */
    public static String getBinFolder() {
        return binFolder;
    }

    /**
     * Insert the method's description here.
     * Creation date: (20.12.2001 17:45:32)
     * @return java.lang.String
     */
    public static String getLibFolder() {
        return libFolder;
    }

    /**
     * Insert the method's description here.
     * Creation date: (20.12.2001 17:45:32)
     * @return java.lang.String
     */
    public static String getLogFolder() {
        return logFolder;
    }

    /**
     * Insert the method's description here.
     * Creation date: (20.12.2001 17:45:32)
     * @return java.lang.String
     */
    public static String getResFolder() {
        return rscFolder;
    }

    public static String getTempFolder() {
        return tmpFolder;
    }

    public static String getTempFolderSlashed() {
        if (tmpFolder.endsWith("/")) {
            return tmpFolder;
        } else {
            return tmpFolder + "/";
        }
    }

    /**
     * Insert the method's description here.
     * Creation date: (21.12.2001 16:38:53)
     * @return java.net.URL
     * @param name java.lang.String
     */
    public static URL getResource(String name) throws java.io.FileNotFoundException, java.net.MalformedURLException {

        URL url = (new java.io.File(getResFolder() + "/" + name)).toURL();

        if (url == null) {
            throw new java.io.FileNotFoundException(name);
        }

        return url;
    }

    /**
     * Insert the method's description here.
     * Creation date: (21.12.2001 17:03:41)
     * @return java.io.InputStream
     * @param name java.lang.String
     */
    public static InputStream getResourceAsStream(String name) throws java.io.FileNotFoundException {

        InputStream is = new java.io.FileInputStream(getResFolder() + "/" + name);

        if (is == null) {
            throw new java.io.FileNotFoundException(name);
        }

        return is;

    }

    /**
     * Insert the method's description here.
     * Creation date: (20.12.2001 17:54:00)
     */
    public static synchronized void initiate() {
        try {

            libFolder = ApplicationProperties.get("LibFolder");

            appRoot = ApplicationProperties.get("AppRoot");

            binFolder = ApplicationProperties.get("BinFolder");

            logFolder = ApplicationProperties.get("LogFolder");

            rscFolder = ApplicationProperties.get("ResourceFolder");

            tmpFolder = ApplicationProperties.get("TempFolder");

            campaignsFolder = ApplicationProperties.get("CampaignDataFolder");

        } catch (Throwable t) {
            return;
        }
    }

    /**
     * Insert the method's description here.
     * Creation date: (21.12.2001 11:13:52)
     * @return java.lang.String
     * @param newPath java.lang.String
     * @param defPath java.lang.String
     */
    public static String safePath(String newPath, String defPath) {

        if (defPath == null) {
            defPath = "";
        }
        if (newPath == null) {
            return defPath;
        }
        try {
            java.io.File file = new java.io.File(newPath);

            if (file.exists() || file.isDirectory()) {
                return newPath;
            } else {
                return defPath;
            }
        } catch (Throwable t) {
            return defPath;
        }

    }

    public static String getCampaignsFolder() {
        return campaignsFolder;
    }

    public static void setCampaignsFolder(String campaignsFolder) {
        ApplicationPaths.campaignsFolder = campaignsFolder;
    }
}