package cppParser;

import java.util.ArrayList;
import java.util.Stack;

import cppParser.utils.LOCMetrics;
import cppParser.utils.Log;
import cppStructures.CppClass;
import cppStructures.CppFile;
import cppStructures.CppFunc;
import cppStructures.CppNamespace;
import cppStructures.CppScope;
import cppStructures.CppType;

/**
 * A singleton object manager for keeping record of the CPP structures created
 * in the parsing process.
 * 
 * @author Harri Pellikka
 */
public class ParsedObjectManager
{

	private static ParsedObjectManager instance = new ParsedObjectManager();

	// Reference to the function currently under processing
	public CppFunc currentFunc = null;

	// Reference to the class or namespace currently under processing
	public CppScope currentScope = null;

	// public String currentNameSpace = "";
	public CppNamespace currentNamespace = null;

	private CppFile currentFile = null;

	// List of files found in the target folder
	private ArrayList<CppFile> files = new ArrayList<CppFile>();

	// List of scopes found
	private ArrayList<CppScope> scopes = new ArrayList<CppScope>();
	private Stack<CppScope> cppScopeStack = new Stack<CppScope>();

	private CppScope defaultScope = new CppScope("DEFAULT");

	// Array lists for misc. stuff found from source code
	ArrayList<String> oneLineComments = new ArrayList<String>();
	ArrayList<String> multiLineComments = new ArrayList<String>();
	ArrayList<String> includes = new ArrayList<String>();
	ArrayList<String> classes = new ArrayList<String>();

	ArrayList<CppType> knownTypes = new ArrayList<>();
	ArrayList<LOCMetrics> locMetrics = new ArrayList<>();

	/**
	 * Retrieves the singleton instance
	 * 
	 * @return The singleton instance
	 */
	public static ParsedObjectManager getInstance()
	{
		return instance;
	}

	/**
	 * Private constructor. Called only once by the class itself.
	 */
	private ParsedObjectManager()
	{

	}

	/**
	 * Adds a new LOC Metrics object
	 * 
	 * @param loc
	 *            LOC Metrics object
	 */
	public void addLocMetric(LOCMetrics loc)
	{
		locMetrics.add(loc);
		currentFile.setLocMetrics(loc);

	}

	/**
	 * Retrieves all LOC metrics objects
	 * 
	 * @return Arraylist of loc metrics objects
	 */
	public ArrayList<LOCMetrics> getLocMetrics()
	{
		return locMetrics;
	}

	/**
	 * Retrieves a list of all known types
	 * 
	 * @return List of all known types
	 */
	public ArrayList<CppType> getKnownTypes()
	{
		return knownTypes;
	}

	/**
	 * Adds a new type
	 * 
	 * @param type
	 *            Type to add
	 */
	public void addKnownType(CppType type)
	{
		for (CppType ct : knownTypes)
		{
			if (ct.typeName.contentEquals(type.typeName))
			{
				if (ct.parent.contentEquals(type.parent))
				{
					return;
				}
			}
		}

		knownTypes.add(type);
	}

	/**
	 * Resets the current scope to the default scope
	 */
	public void setDefaultScope()
	{
		currentScope = defaultScope;
	}

	/**
	 * Retrieves all the scopes
	 * 
	 * @return List of scopes
	 */
	public ArrayList<CppScope> getScopes()
	{
		return scopes;
	}

	/**
	 * Adds a new file
	 * 
	 * @param file
	 *            File to add
	 */
	public void addFile(CppFile file)
	{
		this.files.add(file);
	}

	/**
	 * Retrieves all known files
	 * 
	 * @return List of files
	 */
	public ArrayList<CppFile> getFiles()
	{
		return files;
	}

	/**
	 * Retrieves a file by its filename
	 * 
	 * @param filename
	 *            Name of the file
	 * @return File which has the filename 'filename', or null if not found
	 */
	public CppFile getFileByFilename(String filename)
	{
		for (CppFile cf : files)
		{
			if (cf.getFilename().equals(filename))
			{
				return cf;
			}
		}
		return null;
	}

	/**
	 * Sets the current file to 'cf'
	 * 
	 * @param cf
	 *            File
	 */
	public void setCurrentFile(CppFile cf)
	{
		this.currentFile = cf;
	}

	/**
	 * Sets the current file to a file with the name 'name', or sets the current
	 * file to 'null' if no file with the given name was found.
	 * 
	 * @param name
	 *            Name of the file to set as the current file
	 */
	public void setCurrentFile(String name)
	{
		for (CppFile cf : files)
		{
			if (cf.getFilename().equals(name))
			{
				Log.d("File changed to " + name);
				currentFile = cf;
				return;
			}
		}

		currentFile = null;
	}

	/**
	 * Retrieves the current file
	 * 
	 * @return Current file
	 */
	public CppFile getCurrentFile()
	{
		return currentFile;
	}

	/**
	 * Method looks if given struct or class has already been defined
	 * 
	 * @param name
	 *            name of the class/struct
	 * @param namespace
	 *            namespace of the class
	 * @return null if given class/struct was not found with the namespace else
	 *         that class/struct is returned
	 */
	private CppClass searchForClassOrStruct(String name, CppNamespace namespace)
	{
		CppClass newClass = null;

		// Search for an existing class
		for (CppScope cs : scopes)
		{
			if (cs instanceof CppClass)
			{
				CppClass cClass = (CppClass) cs;
				if (cClass.getName().equals(name))
				{
					if ((namespace != null) && (cClass.namespace != null))
					{
						if (namespace.equals(cClass.namespace))
						{
							newClass = cClass;
							break;
						}
					}
					else
					{
						newClass = cClass;
						break;
					}
				}
			}
		}
		return newClass;
	}

	/**
	 * Adds a new class
	 * 
	 * @param name
	 *            Name of the class
	 * @param namespace
	 *            Namespace the class belongs to
	 * @return The newly constructed class object or an existing class if one
	 *         was found
	 */
	public CppClass addClass(String name, CppNamespace namespace)
	{
		// Search for an existing class
		CppClass newClass = searchForClassOrStruct(name, namespace);

		// If no existing class was found, create a new one
		if (newClass == null)
		{
			newClass = new CppClass(name);
			newClass.namespace = namespace;
			scopes.add(newClass);
			addKnownType(new CppType(name, CppType.CLASS));
		}

		return newClass;
	}

	/**
	 * Adds a new struct
	 * 
	 * @param name
	 *            Name of the struct
	 * @return The newly created struct, or an existing one if found
	 */
	public CppClass addStruct(String name, CppNamespace namespace)
	{
		CppClass newStruct = searchForClassOrStruct(name, namespace);

		// If no existing struct was found, create a new one
		if (newStruct == null)
		{
			newStruct = new CppClass(name);
			newStruct.type = CppScope.STRUCT;
			scopes.add(newStruct);
			addKnownType(new CppType(name, CppType.STRUCT));
		}

		return newStruct;
	}

	/**
	 * Adds a new union
	 * 
	 * @param name
	 *            Name of the union
	 * @return The newly created union, or an existing one if found
	 */
	public CppScope addUnion(String name)
	{
		CppScope newUnion = null;

		// Search for an existing union
		for (CppScope cs : scopes)
		{
			if (cs.type == CppScope.UNION)
			{
				if (cs.getName().equals(name))
				{
					newUnion = cs;
					break;
				}
			}
		}

		// If no existing union was found, create a new one
		if (newUnion == null)
		{
			newUnion = new CppScope(name);
			newUnion.type = CppScope.UNION;
			scopes.add(newUnion);
			addKnownType(new CppType(name, CppType.UNION));
		}

		return newUnion;
	}

	/**
	 * Adds a new namespace.
	 * 
	 * @param ns
	 *            Namespace to add
	 * @param addToStack
	 *            If 'true', the namespace is added to a scope stack. This
	 *            should be 'true' if the namespace was found as
	 *            "namespace Foo {...", and 'false if the namespace was found as
	 *            "namespace::Foo"
	 */
	public void addNamespace(CppNamespace ns, boolean addToStack)
	{
		// Check that namespace is not null
		if (ns == null)
		{
			throw new NullPointerException(
					"Tried to add namespace that is null.");
		}

		// Check that the name of the namespace is not null
		if (ns.getName() == null)
		{
			throw new NullPointerException(
					"Tried to add namespace which name is null.");
		}

		// Check that no namespace with the same name exists
		boolean canAdd = true;
		for (CppScope cs : scopes)
		{
			if (cs instanceof CppNamespace)
			{
				if (cs.getName().equals(ns.getName()))
				{
					canAdd = false;
				}
			}
		}

		// Set the parent namespace, if there is one
		if (addToStack && (currentNamespace != null))
		{
			currentNamespace.addChild(ns);
		}

		// Store the namespace, if it's not yet stored
		if (canAdd)
		{
			scopes.add(ns);
		}

		// Add to stack, if needed
		if (addToStack)
		{
			this.cppScopeStack.push(ns);
			currentNamespace = ns;
		}
	}

	/**
	 * Stores the given function
	 * 
	 * @param func
	 *            Function to store
	 * @param b
	 *            If 'true', set the new function as the current function
	 */
	public CppFunc addFunction(CppFunc func, boolean b)
	{
		func = currentScope.addFunc(func);
		if (b)
		{
			currentFunc = func;
		}
		return func;
	}

	/**
	 * Retrieves the scope stack. Scope stack holds the currently "open" scopes.
	 * For example, if there is a class "Foo" with an inner class "Bar", this
	 * stack will hold both "Foo" and "Bar" when processing "Bar".
	 * 
	 * @return Scope stack
	 */
	public Stack<CppScope> getCppScopeStack()
	{
		return this.cppScopeStack;
	}

	/**
	 * Retrieves a namespace called 'ns'
	 * 
	 * @param ns
	 *            Name of the namespace
	 * @return Namespace or null if not found
	 */
	public CppNamespace getNamespace(String ns)
	{
		for (CppScope scope : scopes)
		{
			if (scope instanceof CppNamespace)
			{
				if (scope.getName().equals(ns))
				{
					return (CppNamespace) scope;
				}
			}
		}
		return null;
	}
}
