package cppParser;

import cppStructures.CppNamespace;

/**
 * Analyses CPP scope internals and delegates the processing to ClassAnalyzer if
 * needed
 * 
 * @author Harri Pellikka
 */
public class ScopeAnalyzer extends Analyzer
{

	/**
	 * Constructs a new scope analyzer
	 * 
	 * @param sa
	 *            Sentence analyzer
	 */
	public ScopeAnalyzer(SentenceAnalyzer sa)
	{
		super(sa);
	}

	/**
	 * Processes an array of tokens. The goal is to find a new namespace from
	 * the tokens. If one is found, it will be stored and if necessary, it will
	 * be stored into the scope stack.
	 */
	@Override
	public boolean processSentence(String[] tokens)
	{
		// Loop through the tokens
		for (int i = 0; i < tokens.length; ++i)
		{
			if (tokens[i].equals("namespace"))
			{
				if (!tokens[i + 1].equals("{"))
				{
					// Namespace found
					CppNamespace ns = new CppNamespace(tokens[i + 1]);
					ns.braceCount = sentenceAnalyzer.braceCount;
					ns.nameOfFile = Extractor.currentFile;
					ParsedObjectManager.getInstance().addNamespace(ns, true);
					return true;
				}
			}
		}

		return false;
	}
}
