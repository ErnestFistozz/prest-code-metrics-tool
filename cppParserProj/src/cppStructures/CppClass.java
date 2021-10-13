package cppStructures;

/**
 * Represents a C++ class
 * 
 * @author Harri Pellikka
 */
public class CppClass extends CppScope
{
	// Depth of inheritance (0 is the 'root' class)
	private int depthOfInheritance = -1;

	/**
	 * Constructs a new class object
	 * 
	 * @param name
	 *            Name of the class
	 */
	public CppClass(String name)
	{
		super(name);
		type = CLASS;
	}

	/**
	 * Constructs a new class from an existing scope
	 * 
	 * @param scope
	 *            Scope to convert into a class
	 */
	public CppClass(CppScope scope)
	{
		super(scope.name);
		this.braceCount = scope.braceCount;
		this.functions = scope.functions;
		this.members = scope.members;
		this.nameOfFile = scope.nameOfFile;
		type = CLASS;
	}

	/**
	 * Retrieves the depth of inheritance
	 * 
	 * @return Depth of inheritance
	 */
	public int getDepthOfInheritance()
	{
		if (depthOfInheritance == -1)
		{
			calculateDepthOfInheritance();
		}
		return depthOfInheritance;
	}

	/**
	 * Calculates the depth of inheritance tree for this class. The depth is the
	 * highest depth of inheritance, in case of multiple inheritance.
	 */
	public void calculateDepthOfInheritance()
	{
		for (CppScope cs : this.parents)
		{
			if (cs instanceof CppClass)
			{
				if ((((CppClass) cs).getDepthOfInheritance() + 1) > depthOfInheritance)
				{
					this.depthOfInheritance = ((CppClass) cs)
							.getDepthOfInheritance() + 1;
				}
			}
		}

		if (depthOfInheritance == -1)
		{
			depthOfInheritance = 0;
		}
	}
}
