package cppParser;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 
 * @author Tomi
 */
public class CmdLineParameterParser
{
	public static boolean includeStructs = false;
	static String inputDir = "";
	static String outputDir = "";
	static boolean input = false;
	static boolean output = false;
	static boolean dir = false;
	static boolean stringLiteral = false;

	public static void parseParameters(String[] parameters) throws Exception
	{
		for (String s : parameters)
		{
			pushParams(s);
		}

		File f = new File(inputDir);
		if (!f.exists())
		{
			throw new FileNotFoundException("Input file/directory not found ("
					+ inputDir + ")");
			/*
			 * if(outputDir.isEmpty()){ //Log.d("outputting to "+f.getPath());
			 * outputDir=f.getPath();
			 * 
			 * } f = new File(outputDir);
			 * 
			 * if(!f.exists()) { if(f.mkdirs()) {
			 * System.out.println("Created dir: " + f.getAbsolutePath()); } else
			 * { throw new Exception("Could not write to directory: " +
			 * f.getAbsolutePath()); } }
			 */
		}

	}

	private static void pushParams(String param)
			throws InvalidParameterException
	{
		if (!dir)
		{
			if (param.equalsIgnoreCase("-parse"))
			{
				if (!inputDir.isEmpty())
				{
					throw new InvalidParameterException(
							"Invalid parameters: -parse used more than once");
				}
				input = true;
				output = false;
				dir = true;
			}
			else if (param.equalsIgnoreCase("-out"))
			{
				if (!outputDir.isEmpty())
				{
					throw new InvalidParameterException(
							"Invalid parameters: -out used more than once");
				}
				input = false;
				output = true;
				dir = true;
			}
			else if (param.equalsIgnoreCase("-includeStructs"))
			{
				includeStructs = true;
			}
			else
			{
				throw new InvalidParameterException("Invalid parameters");
			}

			stringLiteral = false;
		}
		else
		{
			// if dir==true then param should be a directory which is parased
			// here
			String directory;
			if (!stringLiteral)
			{
				if (param.charAt(0) == '\"')
				{
					directory = param;
					if (param.charAt(param.length() - 1) == '\"')
					{
						stringLiteral = false;
					}
					else
					{
						stringLiteral = true;
					}
				}
				else
				{
					directory = param;
					dir = false;
				}
			}
			else
			{
				if (param.charAt(param.length() - 1) == '\"')
				{
					stringLiteral = false;
					dir = false;
				}
				directory = param;
			}
			directory.replace('\\', '/');
			if (input)
			{
				inputDir += directory;
			}
			else
			{
				outputDir += directory;
			}
		}
	}

	public static String getOutputDir()
	{
		return outputDir;
	}

	public static String getInputDir()
	{
		return inputDir;
	}
}
