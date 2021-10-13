package console;

public class CommandLineExplorer
{
	PackageExplorer packageExplorer;

	public void startExecFromCmdLine(String[] args)
	{
		packageExplorer = new PackageExplorer();
		//packafgeExplorer.traverseRepository();
		//console run format change
		if (args[0].equalsIgnoreCase("-addProject"))
		{
			packageExplorer.addNewProjectCmd(args[1]);
		}
		else if (args[0].equalsIgnoreCase("-setRepository"))
		{
			packageExplorer.setRepoCmd(args[1]);
		}
		else if (args[0].equalsIgnoreCase("-parse"))
		{
			if (args.length == 3)
				packageExplorer.parseManualCmd(args[1], args[2], "", "",  "");
			if (args.length > 3)
			{
				if (args[3].equals("-f"))
					packageExplorer.parseManualCmd(args[1], args[2], args[4], "", "");
				if (args[3].equals("-m"))
					packageExplorer.parseManualCmd(args[1], args[2], "", args[5], "");
				if (args[3].equals("-fm") || args[3].equals("-mf"))
					if (args.length == 6)
						packageExplorer.parseManualCmd(args[1], args[2], args[4], args[5] , "");
				if (args[3].equals("-fcm"))
					if (args.length == 7)
						packageExplorer.parseManualCmd(args[1], args[2], args[4], args[6], args[5]);
			}
		}
		else if (args[0].equalsIgnoreCase("-logFilter"))
		{
			packageExplorer.logFiltering(args[1]);
		}
		else if (args[0].equalsIgnoreCase("-convertCsvToArff"))
		{
			if (args.length == 2)
				packageExplorer.convertCsvToArff(args[1], null);
			if (args.length == 3)
				packageExplorer.convertCsvToArff(args[1], args[2]);
		}
		else if (args[0].equalsIgnoreCase("-aggregateMethodToFile"))
		{
			packageExplorer.aggregateMethod2File(args[1]);
		}
		else if (args[0].equalsIgnoreCase("-predict"))
		{
			if (args.length == 3)
				packageExplorer.predict(args[1], args[2], "", "", "");
			if (args.length == 4)
				packageExplorer.predict(args[1], args[2], args[3], "", "");
			if (args.length == 5)
				packageExplorer.predict(args[1], args[2], args[3], "", "");
			if (args.length == 6)
				packageExplorer.predict(args[1], args[2], args[3], "", args[5]);
		}
		else if (args[0].equalsIgnoreCase("-addChanges"))
		{
			packageExplorer.addChanges(args[1],args[2], args[3], args[4], args[5]);
		}
		else
		{
			listCommandLineOptions();
		}
	}

	public void listCommandLineOptions()
	{
		System.out.println("You entered a command with wrong syntax or wrong argument count.");
		System.out.println("The command line options are:");
		System.out.println("-setRepository repoPath");
		System.out.println("-addProject projectDirectory");
		System.out.println("-parse projectDirectory freezelabel");
		System.out.println("-parse projectDirectory freezelabel -f filelevelmetricsoutputdirectory");
		System.out.println("-parse projectDirectory freezelabel -m methodlevelmetricsoutputdirectory");
		System.out
				.println("-parse projectDirectory freezelabel -fm filelevelmetricsoutputdirectory methodlevelmetricsoutputdirectory");
		System.out.println("-parse projectDirectory freezelabel -fcm filelevelmetricsoutputdirectory classlevelmetricsoutputdirectory methodlevelmetricsoutputdirectory");
		System.out.println("aggregateMethodToFile methodpath");
		System.out.println("-logFilter filepath");
		System.out.println("-convertCsvToArff filepath");
		System.out.println("-convertCsvToArff filepath outfilepath");
		System.out.println("-predict trainfile testfile");
		System.out.println("-predict trainfile testfile resultoutputpath");
		System.out.println("-predict trainfile testfile  resultoutputpath filefilter");
		System.out.println("-addChanges sourceroot changesfile methodfile freeze outputfile");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
