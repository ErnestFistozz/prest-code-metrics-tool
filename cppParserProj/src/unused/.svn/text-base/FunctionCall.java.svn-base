package unused;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Tomi
 */
public class FunctionCall
{
	public static final int UNKNOWN = 0, MEMBER = 1, INHERITED = 2,
			FOREIGN = 3;
	/*
	 * These are ownerTypes UNKNOWN owner is not properly determined (yet)
	 * MEMBER function of currently analyzed class INHERITED inherited function
	 * FOREIGN function is not inherited from parent class and it's not not
	 * member of currently analyzed class
	 */

	public int ownerType = 0;
	public List<ParameterToken> owners = null;

	public String name = null;
	public List<List<ParameterToken>> parameters = new ArrayList<>();

	public FunctionCall(String name)
	{
		this.name = name;
	}

	public FunctionCall(List<ParameterToken> owners, String name)
	{
		this.owners = owners;
		this.name = name;
	}

	public FunctionCall(List<ParameterToken> owners, String name,
			List<List<ParameterToken>> parameters)
	{
		if (parameters == null)
		{
			throw new NullPointerException("Null params");
		}
		this.owners = owners;
		this.name = name;

		this.parameters = parameters;
	}

	public FunctionCall(String name, List<List<ParameterToken>> parameters)
	{
		if (parameters == null)
		{
			throw new NullPointerException("Null params");
		}
		this.name = name;
		this.parameters = parameters;
	}

	public String ownersToString()
	{
		String owner = "";
		if (owners != null)
		{
			if (!owners.isEmpty())
			{
				for (ParameterToken s : owners)
				{
					owner += s.toString();
				}
			}
		}
		return owner;
	}

	public String parametersToString()
	{
		String params = "";
		if (parameters != null)
		{
			for (int i = 0; i < parameters.size(); i++)
			{
				for (ParameterToken pt : parameters.get(i))
				{
					params += pt.toString();
				}
				if (i < (parameters.size() - 1))
				{
					params += ", ";
				}
			}
		}
		return params;
	}

	@Override
	public String toString()
	{
		String params = parametersToString();
		String owner = ownersToString();

		return (owner + name + "(" + params + ")");

	}

}
