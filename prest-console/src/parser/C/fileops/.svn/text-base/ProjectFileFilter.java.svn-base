package parser.C.fileops;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * This is a file filter for the project files.
 * It accepts only '.obj' files
 * 
 * @author Atac Deniz Oral
 */
public class ProjectFileFilter extends FileFilter {

	/**
	 * Tests whether or not the specified abstract pathname
	 * should be included in a pathname list.
	 * 
	 * @param file the file to be checked against the filter.
	 */
	public boolean accept(File file) {
		if(file.getName().endsWith(".obj") || file.isDirectory())
			return true;
		return false;
	}

	/**
	 * This method can be used to get a description of this filter.
	 * 
	 * @return the description of this filter
	 */
	public String getDescription() {
		return "obj files only";
	}

}
