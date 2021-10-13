package cppStructures;

/**
 * Represents a member variable
 * 
 * @author Harri Pellikka
 */
public class MemberVariable
{

	private String type = "";
	private String template = "";
	private String pointer = ""; // This is for storing pointer and reference
									// operators
	private String name = "";
	private String array = "";
	private String value = "";
	private boolean valueSet = false;

	public MemberVariable(String type, String name)
	{
		this.type = type;
		this.name = name;
	}

	public MemberVariable(String type, String name, String value)
	{
		this.type = type;
		this.name = name;
		this.value = value;
		valueSet = true;
	}

	public String getType()
	{
		return type;
	}

	public String getName()
	{
		return name;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
		valueSet = true;
	}

	public boolean isValueSet()
	{
		return valueSet;
	}

	public String getPointer()
	{
		return pointer;
	}

	public void setPointer(String pointer)
	{
		this.pointer = pointer;
	}

	public String getTemplate()
	{
		return template;
	}

	public void setTemplate(String template)
	{
		this.template = template;
	}

	public String getArray()
	{
		return array;
	}

	public void setArray(String array)
	{
		this.array = array;
	}
}
