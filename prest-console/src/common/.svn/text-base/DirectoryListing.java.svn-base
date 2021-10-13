/*
 * DirectoryListing.java
 *
 * Created on December 22, 2007, 1:40 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import parser.Jsp.JspToJavaConvertor;

/**
 * 
 * @author Mert
 */
public class DirectoryListing {

	/** Creates a new instance of DirectoryListing */
	public DirectoryListing() {
		this.dirNames = new ArrayList();
		this.fileNames = new ArrayList();
		this.dirfileNames = new ArrayList();
		this.filteredfileNames = new ArrayList();
	}

	// Process all files and directories under dir
	public void visitAllDirsAndFiles(File dir) {

		this.dirfileNames.add(dir);

		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				visitAllDirsAndFiles(new File(dir, children[i]));
			}
		}
	}

	// Process only directories under dir
	public void visitAllDirs(File dir) {
		if (dir.isDirectory()) {

			this.dirNames.add(dir);

			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				visitAllDirs(new File(dir, children[i]));
			}
		}
	}
	
	// Process only directories under dir
	public void visitAllOneLevelDirs(File dir) {
		if (dir.isDirectory()) {

			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				File directoryCandidate = new File(dir,children[i]);
				if(directoryCandidate.isDirectory())
					this.dirNames.add(directoryCandidate);
			}
		}
	}

	// Process only files under dir
	public void visitAllFiles(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				visitAllFiles(new File(dir, children[i]));
			}
		} else {
			this.fileNames.add(dir);
		}
	}

	// Process only filtered files under dir
	public void visitAllFiles_Filtered(File dir, String extension) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				visitAllFiles_Filtered(new File(dir, children[i]), extension);
			}
		} else {
			if (dir.getName().endsWith(extension)) {
			  
				this.filteredfileNames.add(dir);
			}
		}
	}

	public List getDirNames() {
		return this.dirNames;
	}

	public List getFileNames() {
		return this.fileNames;
	}

	public List getDirFileNames() {
		return this.dirfileNames;
	}

	public List<File> getFilteredFileNames() {
		return this.filteredfileNames;
	}

	// Variables declaration - do not modify
	private List dirNames;
	private List fileNames;
	private List dirfileNames;
	private List<File> filteredfileNames;
	// End of variables declaration

}
