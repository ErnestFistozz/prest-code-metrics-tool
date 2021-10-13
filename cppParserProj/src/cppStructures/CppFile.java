package cppStructures;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import cppParser.ParsedObjectManager;
import cppParser.utils.LOCMetrics;

/**
 * Represents a CPP file
 * 
 * @author Harri Pellikka
 */
public class CppFile
{

	// Filename (absolute file path)
	private String filename = null;

	// List of #includes in the file
	private ArrayList<String> includes = null;

	// List of #defines in the file
	private ArrayList<CppDefine> defines = null;

	private LOCMetrics locMetrics = new LOCMetrics();
	private CppFunc otherMetrics = null;// This variable will contain complexity
										// and halstead metrics

	public CppFunc getOtherMetrics()
	{
		return otherMetrics;
	}

	public void setOtherMetrics(CppFunc otherMetrics)
	{
		this.otherMetrics = otherMetrics;
	}

	public void setLocMetrics(LOCMetrics locMetrics)
	{
		this.locMetrics = locMetrics;
	}

	public LOCMetrics getLOCMetrics()
	{
		return locMetrics;
	}

	/**
	 * Constructs a new CPP file object
	 * 
	 * @param filename
	 *            Absolute file path
	 */
	public CppFile(String filename)
	{
		this.filename = filename;
		includes = new ArrayList<String>();
		defines = new ArrayList<CppDefine>();
	}

	/**
	 * Adds a new #include to this file
	 * 
	 * @param include
	 *            Include to add
	 */
	public void addInclude(String include)
	{
		this.includes.add(include);
	}

	/**
	 * Retrieves the list of #includes
	 * 
	 * @return List of #includes
	 */
	public ArrayList<String> getIncludes()
	{
		return includes;
	}

	/**
	 * Adds a new #define
	 * 
	 * @param cd
	 *            #define to add
	 */
	public void addDefine(CppDefine cd)
	{
		this.defines.add(cd);
	}

	/**
	 * Retrieves teh list of #defines
	 * 
	 * @return List of #defines
	 */
	public ArrayList<CppDefine> getDefines()
	{
		return defines;
	}

	/**
	 * Retrieves the absolute file path of this file
	 * 
	 * @return Absolute path to this file
	 */
	public String getFilename()
	{
		return filename;
	}

	/**
	 * Expands #includes so that the filenames become absolute paths
	 */
	public void expandIncludes()
	{
		ArrayList<String> expandedIncludes = new ArrayList<String>();

		for (String s : includes)
		{
			for (CppFile cf : ParsedObjectManager.getInstance().getFiles())
			{
				if (cf.getFilename().endsWith(s))
				{
					expandedIncludes.add(cf.getFilename());
					break;
				}
			}
		}

		includes = expandedIncludes;
	}

	/**
	 * Retrieves #defines recursively from this file and all #included files.
	 * 
	 * @param incs
	 *            #include files from previous recursive stages
	 * @return List of #defines in this file and all #included files
	 */
	public ArrayList<CppDefine> getDefinesRecursively(ArrayList<String> incs)
	{

		if (incs == null)
		{
			incs = new ArrayList<String>();
		}
		ArrayList<CppDefine> defs = new ArrayList<CppDefine>();
		incs.add(filename);

		// Add the current file's #defines
		for (CppDefine cd : defines)
		{
			defs.add(cd);
		}

		// Recurse through #includes
		for (String s : includes)
		{
			if (incs.contains(s))
			{
				continue;
			}

			CppFile cf = ParsedObjectManager.getInstance().getFileByFilename(s);
			defs.addAll(cf.getDefinesRecursively(incs));

			incs.add(s);
		}

		return defs;
	}

	/**
	 * Dumps the include tree for this file
	 * 
	 * @param writer
	 *            Writer to write the debug dump to
	 * @param visited
	 *            Set of files already visited
	 * @param depth
	 *            Depth of the include tree
	 * @throws IOException
	 *             Thrown if the writer cannot handle the writing operation
	 */
	public void dump(BufferedWriter writer, HashSet<CppFile> visited, int depth)
			throws IOException
	{
		visited.add(this);
		for (int i = 0; i < depth; ++i)
		{
			writer.write("   ");
		}
		writer.write(this.getFilename() + "\n");
		for (String s : includes)
		{
			CppFile next = ParsedObjectManager.getInstance().getFileByFilename(
					s);
			if (!visited.contains(next))
			{
				next.dump(writer, visited, depth + 1);
			}
		}
	}
}
