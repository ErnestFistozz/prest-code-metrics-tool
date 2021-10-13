/*
 * PrestApp.java
 */

package prestgui;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.sd.dev.lib.ISDContext;
import common.gui.packageexplorer.CommandLineExplorer;

import definitions.application.ApplicationProperties;

/**
 * The main class of the application.
 */
public class PrestGuiApp implements IPrestViewListener
{

	// SciDesktop Modification TA_R001	--- Local folder to be created for settings under member home
	private static final String PRESTHOME = "PREST";
	
	private static boolean fromCommandLine = false;
	private static String [] cmdArguments;
	
	private static PrestGuiApp appInstance;
	
	// SciDesktop Modification TA_R001	--- additional variables are needed for the created instance
	private static ISDContext sdContext;
	
	private PrestGuiView prestView;
	private boolean disposed;
	
	/**
	 * At startup create and show the main frame of the application.
	 */
	
	public void startup() 
	{
		// SciDesktop Modification TA_R001	--- Changes to startup call
		// application.properties file is directed to member home folder
		// prestView is initialized with the context variable
		// exitlistener is added to the created instance
		String propPath = getPropertiesPath();
		ApplicationProperties.initiateManual(propPath);
		String repository = ApplicationProperties.get("repositorylocation");
		if (repository == null || repository.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null,
					"Please create a repository location for Prest Tool!",
					"Create Repository", JOptionPane.INFORMATION_MESSAGE);
			File repositoryFile = getProjectDirectoryFromUser();
			if (repositoryFile != null) {
				//TODO: HERE TAKE THE PROB PATH FROM THE USER!
				ApplicationProperties.setRepositoryLocation(propPath, repositoryFile.getAbsolutePath());
				
				ApplicationProperties.initiate();
			}
		}
		
		
		// if command line option is chosen, change working style to command line
		if(fromCommandLine)
		{
			System.out.println("Prest is selected to work from command line");
			CommandLineExplorer cmdLineExplorer = new CommandLineExplorer();
			cmdLineExplorer.startExecFromCmdLine(cmdArguments);
		}
		else {
				prestView = new PrestGuiView(sdContext); 
				prestView.setViewListener(this);
				prestView.updateProjectInfoDisplay();
		}
	}

	// SciDesktop Modification TA_R001	--- getPropertiesPath is added to get full path of application.properties
	private String getPropertiesPath()
	{
		if (sdContext != null && sdContext.getMode() == ISDContext.MODE_NATIVE)
			try
			{
				System.out.println(sdContext.getMemberHome());
				File home = new File(sdContext.getMemberHome());
				File prestHome = new File(home, PRESTHOME);
				if (!prestHome.exists())
					prestHome.mkdir();
				if (prestHome.exists())
				{
					File propF = new File(prestHome, ApplicationProperties.getPropertiesFileName());
					return propF.getPath();
				}
			}
			catch (Exception e)
			{
			}
			
		return ApplicationProperties.getPropertiesFileName();
	}

	public static void changeWorkStyle(String[] args)
	{
		fromCommandLine = true;
		cmdArguments = args;
	}

	public static PrestGuiApp getInstance()
	{
		return appInstance;
	}
	
	public static PrestGuiApp createInstance(String[] args)
	{
		if (appInstance != null)
			return appInstance;
		
		appInstance = new PrestGuiApp();
		if (args != null && args.length != 0)
			changeWorkStyle(args);
		appInstance.startup();
		
		return appInstance;
	}
	
	/**
	 * Main method launching the application.
	 */
	public static void main(String[] args) 
	{
		try
		{
			// UIManager.setLookAndFeel("net.infonode.gui.laf.InfoNodeLookAndFeel");
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		}
		catch (Exception e)
		{
		}
		
		createInstance(args);
	}

	public static File getProjectDirectoryFromUser() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Select folder for repository");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fileChooser.showOpenDialog(null);

		File dir = null;
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			dir = fileChooser.getSelectedFile();
		}
		if (dir == null) {
			dir.mkdir();
		}
		return dir;
	}

	// SciDesktop Modification TA_R001	--- added to externally set the static SciDesktop context 
	public static void setContext(ISDContext ctx)
	{
		sdContext = ctx;
	}
	
	// SciDesktop Modification TA_R001	--- added to externally check whether the instance has terminated or not 
	public boolean isDisposed()
	{
		return disposed;
	}
	
	// SciDesktop Modification TA_R001	--- added to externally get the active frame of instance 
	public JFrame getFrameInstance()
	{
		return prestView != null ? prestView : null;
	}

	public void viewDisposed()
	{
		appInstance = null;
		disposed = true;
	}
	
}
