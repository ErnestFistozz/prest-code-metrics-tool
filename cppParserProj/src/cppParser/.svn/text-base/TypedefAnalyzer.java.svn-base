package cppParser;

public class TypedefAnalyzer extends Analyzer
{

	public TypedefAnalyzer(SentenceAnalyzer sa)
	{
		super(sa);

	}

	@Override
	public boolean processSentence(String[] tokens)
	{
		for (int i = 0; i < tokens.length; ++i)
		{
			if (tokens[i].equals("typedef"))
			{
				return true;
			}

		}
		return false;
	}

}
