package parser.C.fileops;

import java.util.LinkedList;

/**
 * This class can be used as an abstraction for a source file.
 * It extends the class Module, and contains a collection of Module
 * instances, which are the modules that are found in this source file
 * 
 * @author Atac Deniz Oral
 *
 */
public class SourceFile extends Module {

	private LinkedList<Module> modules;
	private boolean fileType;
	
	/**
	 * Constructs a new SourceFile instance with the given type
	 * 
	 * @param fileType	the type of the source file
	 * 					Parser.HEADERFILE or Parser.DEFINITIONFILE
	 */
	public SourceFile(boolean fileType) {
		super();
		modules = new LinkedList<Module>();
		this.fileType = fileType;
	}
	
	/**
	 * Constructs a new SourceFile instance with the given type and name
	 * 
	 * @param name	The name of this source file
	 * @param fileType	the type of the source file
	 * 					Parser.HEADERFILE or Parser.DEFINITIONFILE
	 */
	public SourceFile(String name, boolean fileType) {
		super(name, "");
		modules = new LinkedList<Module>();
		this.fileType = fileType;
	}

	/**
	 * Getter method for the modules found in this source file
	 * 
	 * @return	a LinkedList<Module> of the modules in this file
	 */
	public LinkedList<Module> getModules() {
		return modules;
	}

	/**
	 * Setter method for the modules of this file
	 * 
	 * @param modules the modules found in this file
	 */
	public void setModules(LinkedList<Module> modules) {
		this.modules = modules;
	}

	/**
	 * This method can be used to add a module to the module list of this
	 * source file
	 * 
	 * @param m the module to be added
	 */
	public void addModule(Module m) {
		modules.add(m);
	}

	/**
	 * This method can be used to determine the type of this source file
	 * 
	 * @return	the type of the source file
	 * 			Parser.HEADERFILE or Parser.DEFINITIONFILE
	 */
	public boolean isFileType() {
		return fileType;
	}

	/**
	 * This method can be used to set the type of this source file
	 * 
	 * @param fileType	the type of the source file
	 * 					Parser.HEADERFILE or Parser.DEFINITIONFILE
	 */
	public void setFileType(boolean fileType) {
		this.fileType = fileType;
	}
	
}
