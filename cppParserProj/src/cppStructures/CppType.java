package cppStructures;

/**
 * 
 * @author Tomi
 */
public class CppType
{
	public static final int NOTDEFINED = 0, CLASS = 1, STRUCT = 2, UNION = 3,
			NAMESPACE = 4;
	public String parent;// this should store the owner of this type eg std is
							// owner
	// of string in std::string
	public String typeName;
	public int type;

	public CppType(String typeName, int type)
	{
		this.typeName = typeName;
		this.type = type;
		parent = "";
	}

	public CppType(String typeName, int type, String parent)
	{
		this.typeName = typeName;
		this.type = type;
		this.parent = parent;
	}

}
