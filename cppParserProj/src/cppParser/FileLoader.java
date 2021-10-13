package cppParser;

import java.io.File;
import java.util.ArrayList;

/**
 * Handles file loading and checks if there already exists up-to-date metrics
 * information.
 * 
 * @author Harri Pellikka
 */
public class FileLoader
{

	// List of allowed file extensions
	private String[] allowedExtensions = new String[] { ".cpp", ".h", ".hpp",
			".cxx" };
	// private String[] allowedExtensions = new String[] {".h"};

	// If 'true', files are sorted in "headers first, sources last" order
	private boolean shouldSort = true;

	private static String targetPath = "";

	public static String getTargetPath()
	{
		return targetPath;
	}

	// The original path to the file / folder
	// private String path = "";

	// List of files found
	private ArrayList<String> files = new ArrayList<String>();

	/**
	 * Retrieves a list of files found
	 * 
	 * @return A list of file paths found
	 */
	public ArrayList<String> getFiles()
	{
		return files;
	}

	/**
	 * Constructs a new file loader with a given path (folder or a single file)
	 * 
	 * @param path
	 *            A path to a file or a folder
	 */
	public FileLoader(String path)
	{
		File f = new File(path);

		if (f.isDirectory())
		{
			files = getFilesFrom(path);
			FileLoader.targetPath = f.getPath();
		}
		else
		{
			files.add(path);
			FileLoader.targetPath = f.getParent();
		}

		if (shouldSort)
		{
			files = sortFiles(files);
		}
	}

	/**
	 * Checks if the given file name has a valid file extension
	 * 
	 * @param s
	 *            The file to check
	 * @return True if valid extension, false otherwise
	 */
	private boolean isValidExtension(String s)
	{
		for (int i = 0; i < allowedExtensions.length; ++i)
		{
			if (s.endsWith(allowedExtensions[i]))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Searches recursively for files in the given folder and all the
	 * subfolders.
	 * 
	 * @param folder
	 *            The root folder to search from
	 * @return List of files in the given folder and all the subfolders
	 */
	private ArrayList<String> getFilesFrom(String folder)
	{
		ArrayList<String> files = new ArrayList<String>();
		File f = new File(folder);
		File[] entries = f.listFiles();
		for (File entry : entries)
		{
			if (entry.isFile())
			{
				String s = entry.getPath();
				if (isValidExtension(s))
				{
					files.add(s);
				}
			}
			else if (entry.isDirectory())
			{
				ArrayList<String> subFiles = getFilesFrom(entry.getPath());
				for (String s : subFiles)
				{
					if (isValidExtension(s))
					{
						files.add(s);
					}
				}
			}
		}

		return files;
	}

	/**
	 * Sorts the given list of files so that header files are before the source
	 * files
	 * 
	 * @param files
	 *            The list of files to sort
	 * @return A sorted list where header files are first before the source
	 *         files
	 */
	private ArrayList<String> sortFiles(ArrayList<String> files)
	{
		ArrayList<String> ordered = new ArrayList<String>();

		for (int i = 0; i < files.size(); ++i)
		{
			String s = files.get(i);
			if (s.charAt(s.lastIndexOf('.') + 1) == 'c')
			{
				ordered.add(s);
			}
			else
			{
				ordered.add(0, s);
			}
		}

		return ordered;
	}
}
