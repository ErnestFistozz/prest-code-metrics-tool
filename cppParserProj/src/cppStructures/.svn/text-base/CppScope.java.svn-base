package cppStructures;

import java.util.ArrayList;

import cppParser.utils.LOCMetrics;
import cppParser.utils.Log;

/**
 * CPP Scope
 * 
 * A scope can be either a namespace or a class (whatever 'foo' is in
 * 'foo::bar'). All 'foos' like this are first stored as CppScope objects and as
 * more information is parsed, they are converted to CppClass (if they are
 * classes)
 * 
 * @author Harri Pellikka
 * 
 */
public class CppScope
{
	public static final int NAMESPACE = 0, CLASS = 1, STRUCT = 2, UNION = 3;
	public int type = NAMESPACE;
	public String name = "_MAIN_";

	public String getName()
	{
		return name;
	}

	public ArrayList<CppScope> parents = null;
	public ArrayList<CppScope> children = null;
	public CppNamespace namespace = null;

	public int braceCount = 0;
	public String nameOfFile = "";

	protected ArrayList<MemberVariable> members = new ArrayList<MemberVariable>();
	protected ArrayList<CppFunc> functions = new ArrayList<CppFunc>();

	private LOCMetrics locMetrics = new LOCMetrics();
	// Sum of each metric
	public int sumFuncPLOC;
	public int sumFuncLLOC;
	public int sumFuncCommentLines;
	public int sumFuncEmptyLines;
	public int sumFuncCC;
	// Halstead
	public int sumOperators;
	public int sumOperands;
	public int sumUniqueOperators;
	public int sumUniqueOperands;

	public int sumVocabulary = 0;
	public int sumLength = 0;
	public double sumCalculatedLength = 0.0;
	public double sumVolume = 0.0;
	public double sumDifficulty = 0.0;
	public double sumEffort = 0.0;
	public double sumTimeToProgram = 0.0;
	public double sumDeliveredBugs = 0.0;
	public double sumLevel = 0.0;
	public double sumIntContent = 0.0;

	public LOCMetrics getLOCMetrics()
	{
		return locMetrics;
	}

	/**
	 * Constructs a new scope with the given name
	 * 
	 * @param name
	 *            Name of the scope
	 */
	public CppScope(String name)
	{
		// Log.d("created scope "+name);
		/*
		 * if(name.contentEquals(">")){ throw new
		 * Error("> found "+ParsedObjectManager
		 * .getInstance().getCurrentFile().getFilename()+ Extractor.lineno); }
		 */
		this.name = name;
		this.children = new ArrayList<CppScope>();
		this.parents = new ArrayList<CppScope>();
	}

	/**
	 * Adds a new member variable to the scope
	 * 
	 * @param mv
	 *            Member variable to add
	 */
	public void addMember(MemberVariable mv)
	{
		members.add(mv);
	}

	/**
	 * Adds a new function to the scope
	 * 
	 * @param func
	 *            Function to add
	 * @return The function itself, or an existing one
	 */
	public CppFunc addFunc(CppFunc func)
	{
		if (!hasFunc(func))
		{
			functions.add(func);
			return func;
		}
		else
		{
			return getFunc(func);
		}
	}

	/**
	 * Retrieves the list of member variables of this scope
	 * 
	 * @return The list of member variables
	 */
	public ArrayList<MemberVariable> getMembers()
	{
		return members;
	}

	/**
	 * Retrieves the list of functions in this scope
	 * 
	 * @return The list of functions
	 */
	public ArrayList<CppFunc> getFunctions()
	{
		return functions;
	}

	/**
	 * Retrieves the given function
	 * 
	 * @param mf
	 *            The function to retrieve
	 * @return The function, or null if not found
	 */
	public CppFunc getFunc(CppFunc mf)
	{
		String mfName = mf.getName();
		for (CppFunc mem : functions)
		{
			if (mem.getName().equals(mfName))
			{
				// If the parameter count differs, skip the parameter check
				if (mem.parameters.size() != mf.parameters.size())
				{
					continue;
				}

				// Compare the parameters
				int paramCount = mem.parameters.size();
				int matchingParams = 0;

				for (int i = 0; i < paramCount; ++i)
				{
					if (mem.parameters.get(i).type
							.equals(mf.parameters.get(i).type))
					{
						matchingParams++;
					}
				}

				if (!mf.getType().equals(mem.getType()))
				{
					continue;
				}
				else if (matchingParams == paramCount)
				{
					return mem;
				}
			}
		}
		return null;
	}

	/**
	 * Checks whether or not a given function can be found in this scope
	 * 
	 * @param mf
	 *            The function to search for
	 * @return 'true' if the function was found, 'false' otherwise
	 */
	public boolean hasFunc(CppFunc mf)
	{
		String mfName = mf.getName();
		for (CppFunc mem : functions)
		{
			if (mem.getName().equals(mfName))
			{
				// If the parameter count differs, skip the parameter check
				if (mem.parameters.size() != mf.parameters.size())
				{
					continue;
				}

				// Compare the parameters
				int paramCount = mem.parameters.size();
				int matchingParams = 0;

				for (int i = 0; i < paramCount; ++i)
				{
					if (mem.parameters.get(i).type
							.equals(mf.parameters.get(i).type))
					{
						matchingParams++;
					}
				}

				if (!mf.getType().equals(mem.getType()))
				{
					continue;
				}
				else if (matchingParams == paramCount)
				{
					return true;
				}
			}

		}
		return false;
	}

	/**
	 * Checks whether or not a given member variable can be found in this scope
	 * 
	 * @param mv
	 *            The member variable to search for
	 * @return 'true' if the member variable was found, 'false' otherwise
	 */
	public boolean hasMember(MemberVariable mv)
	{
		String mvName = mv.getName();
		for (MemberVariable mem : members)
		{
			if (mem.getName().equals(mvName))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds a new child to this scope
	 * 
	 * @param cc
	 *            The child scope
	 */
	public void addChild(CppScope cc)
	{
		if (cc == this)
		{
			Log.d("Tried to add self as child: " + this.getName());
		}

		boolean canAdd = true;
		for (CppScope c : children)
		{
			if (c.getName().equals(cc.getName()))
			{
				canAdd = false;
				break;
			}
		}

		if (canAdd)
		{
			children.add(cc);
			cc.addParent(this);
		}
	}

	/**
	 * Adds a new parent for this scope
	 * 
	 * @param cc
	 *            The parent scope
	 */
	private void addParent(CppScope cc)
	{
		if (cc == this)
		{
			Log.d("Tried to add self as parent: " + this.getName());
		}
		else
		{
			parents.add(cc);
		}
	}
}
