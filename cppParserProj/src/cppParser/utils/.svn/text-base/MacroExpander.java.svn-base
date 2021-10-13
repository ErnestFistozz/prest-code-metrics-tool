package cppParser.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import cppStructures.CppDefine;

/**
 * Expands preprocessor macros during the main pass analysis
 * 
 * @author Harri Pellikka
 * 
 */
public class MacroExpander
{

	private static final String[] rawExpandDelims = new String[] { " ", ";",
			":", "?", "{", ")", "]", ",", "+", "-", "*", "/", "%", "=", "==",
			"!=", "!" };
	private static HashSet<String> rawExpandSet = new HashSet<String>();

	private static HashMap<String, CppDefine> currentDefines = new HashMap<String, CppDefine>();

	private int callEnd = -1;
	private String[] tokens = null;

	public MacroExpander()
	{
		if (rawExpandSet.isEmpty())
		{
			for (String s : rawExpandDelims)
			{
				rawExpandSet.add(s);
			}
		}
	}

	public static String expandRaw(String line)
	{
		char c = line.charAt(line.length() - 1);
		if ((c != ' ') && (c != ';') && (c != '{') && (c != '}') && (c != ')'))
		{
			return line;
		}

		MacroExpander me = new MacroExpander();
		String[] pieces = StringTools.split(line, null, true);
		pieces = me.expand(pieces);

		String result = "";
		for (String s : pieces)
		{
			result += (result.length() > 0 ? " " : "") + s;
		}
		return result + (line.endsWith(" ") ? " " : "");
		// return line;
	}

	/**
	 * Checks a given list of tokens for possible macro expansions. If macros
	 * are found, the resulting list will contain the "final" form of the
	 * sentence.
	 * 
	 * @param tokens
	 *            Original list of tokens
	 * @return List of tokens with possible macros expanded
	 */
	public String[] expand(String[] t)
	{
		this.tokens = t;
		ArrayList<String> newTokens = new ArrayList<String>();

		for (int i = 0; i < tokens.length; ++i)
		{
			boolean matched = false;

			if (currentDefines.containsKey(tokens[i]))
			{
				CppDefine cd = currentDefines.get(tokens[i]);
				if ((cd.getParameters() != null)
						&& (cd.getParameters().size() > 0))
				{
					ArrayList<String> params = isolateMacroCall(tokens, i);
					if (params.size() == cd.getParameters().size())
					{
						newTokens.addAll(handleExpansion(params, cd));
						i = callEnd;
						matched = true;
					}
				}
				else
				{
					newTokens.addAll(replace(cd));
					matched = true;
				}
			}

			if (!matched)
			{
				newTokens.add(tokens[i]);
			}
		}

		return StringTools.listToArray(newTokens);
	}

	/**
	 * Replaces a simple constant-like macro call with the expanded macro
	 * 
	 * @param tokens
	 *            Tokens of the original line
	 * @param i
	 *            Index of the macro call token
	 * @param cd
	 *            CppDefine containing the macro expansion
	 * @return Token array with the given macro call expanded
	 */
	private ArrayList<String> replace(CppDefine cd)
	{
		String[] spaceDelim = new String[] { " " };
		String[] definitionTokens = StringTools.split(cd.getDefinition(),
				spaceDelim, true);
		String[] expandedDefinition = (new MacroExpander())
				.expand(definitionTokens);

		ArrayList<String> newTokens = new ArrayList<String>();
		for (String s : expandedDefinition)
		{
			newTokens.add(s);
		}
		return newTokens;
	}

	/**
	 * Isolates a macro call from the list of tokens. After this method is
	 * executed, the private static variables "callStart" and "callEnd" will be
	 * populated by the index of the macro name and the index of the closing
	 * parenthesis, respectively.
	 * 
	 * @param tokens
	 *            Original list of tokens
	 * @param i
	 *            Index of the macro name
	 * @return List of parameters
	 */
	private ArrayList<String> isolateMacroCall(String[] tokens, int i)
	{
		String repString = "";
		ArrayList<String> params = new ArrayList<String>();
		String param = "";
		int pCount = 0;
		int j = i;

		// Build the parameter list
		for (; j < tokens.length; ++j)
		{
			repString += (repString.length() > 0 ? " " : "") + tokens[j];

			if (tokens[j].equals("("))
			{
				pCount++;
			}
			else if (tokens[j].equals(")"))
			{
				pCount--;
				if (pCount == 0)
				{
					params.add(param);
					break;
				}
			}
			else if ((j > (i + 1)) && (pCount == 1) && tokens[j].equals(","))
			{
				params.add(param);
				param = "";
			}

			if (!tokens[j].equals(","))
			{
				if (j > (i + 1))
				{
					param += (param.length() > 0 ? " " : "") + tokens[j];
				}
			}
		}

		callEnd = j;

		return params;
	}

	/**
	 * Replaces a function-like macro call with the expanded macro
	 * 
	 * @param tokens
	 *            Tokens of the original line
	 * @param i
	 *            Index of the macro call (the name of the macro)
	 * @param cd
	 *            CppDefine containing the macro expansion
	 * @return Token array with the given macro call expanded
	 */
	private static ArrayList<String> handleExpansion(ArrayList<String> params,
			CppDefine cd)
	{
		// Expand all the parameters in case they are macro calls
		ArrayList<String> tmpParams = new ArrayList<String>(params);
		for (int k = 0; k < params.size(); ++k)
		{
			String[] tmpParamsArray = (new MacroExpander())
					.expand(new String[] { params.get(k) });
			String tmpParamString = "";
			for (String s : tmpParamsArray)
			{
				tmpParamString += (tmpParamString.length() > 0 ? " " : "") + s;
			}
			tmpParams.remove(k);
			tmpParams.add(k, tmpParamString);
		}
		params = tmpParams;

		// Retrieve the macro expansion and split it into tokens
		String[] defLine = StringTools.split(cd.getDefinition(), null, true);
		for (int k = 0; k < params.size(); ++k)
		{
			for (int l = 0; l < defLine.length; ++l)
			{
				if (defLine[l].equals(cd.getParameters().get(k)))
				{
					defLine[l] = params.get(k);
				}
			}
		}

		// Form the new array of tokens
		ArrayList<String> newTokensList = new ArrayList<String>();

		/*
		 * // First, add all the tokens before the macro call for(int k = 0; k <
		 * callStart; ++k) { if(newTokens[k].length() > 0)
		 * newTokensList.add(newTokens[k]); }
		 */

		// Second, add all the tokens expanded from the macro
		for (int k = 0; k < defLine.length; ++k)
		{
			if (defLine[k].length() > 0)
			{
				newTokensList.add(defLine[k]);
			}
		}

		// Third, add the rest of the tokens from the original list of tokens
		/*
		 * for(int k = callEnd + 1; k < newTokens.length; ++k) {
		 * if(newTokens[k].length() > 0) newTokensList.add(newTokens[k]); }
		 */

		// Finally, expand the newly-created list of tokens in case of macro
		// calls inside the macro expansion

		// return (new
		// MacroExpander()).expand(StringTools.listToArray(newTokensList));
		// String[] newTokensListArray = (new
		// MacroExpander()).expand(StringTools.listToArray(newTokensList));

		String[] recArray = (new MacroExpander()).expand(newTokensList
				.toArray(new String[] {}));
		ArrayList<String> recList = new ArrayList<String>();
		for (String s : recArray)
		{
			recList.add(s);
		}
		// return newTokensList;
		return recList;
	}

	/**
	 * Stores a given define with the name as the key
	 * 
	 * @param name
	 *            Name of the define
	 * @param define
	 *            The definition
	 */
	public static void addDefine(String name, CppDefine define)
	{
		currentDefines.put(name, define);
	}

	public static boolean containsDefinition(String s)
	{
		return currentDefines.containsKey(s);
	}

	public static CppDefine getDefinition(String s)
	{
		return currentDefines.get(s);
	}

	public static boolean shouldExpandRaw(String line, char c)
	{
		if ((c == ' ') || (c == ';'))
		{
			return true;
		}
		return false;
	}

}
