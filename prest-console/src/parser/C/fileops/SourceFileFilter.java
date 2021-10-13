package parser.C.fileops;

import java.io.File;
import java.io.FileFilter;

/**
 * This class is a file filter that accepts only C source files
 * (i.e. files with the extensions '.c' and '.h').
 * 
 * @author Atac Deniz Oral
 */
public class SourceFileFilter implements FileFilter {

	/**
	 * Tests whether or not the specified abstract pathname
	 * should be included in a pathname list.
	 * 
	 * @param file the file to be checked against the filter.
	 */
	public boolean accept(File sourceFile) {
		String fileName = sourceFile.getName();
		int lastDotIndex = fileName.lastIndexOf(".");
		String extension = fileName.substring(lastDotIndex+1);
		if( (extension.equalsIgnoreCase("c")) || (extension.equalsIgnoreCase("h")) )
			return true;
		return false;
	}

}
