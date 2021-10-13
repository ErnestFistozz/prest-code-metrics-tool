package unused;

/**
 * 
 * @author Tomi
 */
public class StringToken implements ParameterToken
{
	public StringToken(String content)
	{
		token = content;
	}

	public String token;

	@Override
	public String toString()
	{
		return token;
	}

	@Override
	public boolean isFunctionCall()
	{
		return false;
	}

}
