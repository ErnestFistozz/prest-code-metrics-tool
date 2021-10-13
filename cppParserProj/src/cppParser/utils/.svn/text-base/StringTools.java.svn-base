package cppParser.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * A collection of parsing and lexing -related string tools.
 * 
 * @author Harri Pellikka
 */
public class StringTools
{
	// List of "splitters" that are used to tokenize a single line of source
	// code
	public static String[] delims = new String[] { " ", "(", ")", "{", "}",
			"[", "]", "<", ">", "->", ";", ",", "=", "+", "-", "*", "/", "::",
			":", ".", "\"", "<<", ">>", "!", "~", "&", "|", "^" };
	public static HashSet<String> delimSet = new HashSet<String>();

	// List of C++11 keywords, types (char, int, bool etc.) and type-related
	// (signed, unsigned) words omitted
	public static String[] keywords_notypes = { "alignas", "alignof", "and",
			"and_eq", "asm", "auto", "bitand", "bitor", "break", "case",
			"catch", "class", "compl", "const", "constexpr", "const_cast",
			"continue", "decltype", "default", "delete", "do", "dynamic_cast",
			"else", "enum", "explicit", "export", "extern", "for", "friend",
			"goto", "if", "inline", "mutable", "namespace", "new", "noexcept",
			"not", "not_eq", "nullptr", "operator", "or", "or_eq", "private",
			"protected", "public", "register", "reinterpret_cast", "return",
			"sizeof", "static", "static_assert", "static_cast", "struct",
			"switch", "template", "this", "thread_local", "throw", "try",
			"typedef", "typeid", "typename", "union", "using", "virtual",
			"volatile", "while", "xor", "xor_eq" };

	// List of Halstead operators
	public static String[] operators = { ";", ")", "}", "[", "+", "-", "++",
			"--", "*", "/", "%", ".", ",", "->", "==", "<=", ">=", "!=", "<<",
			">>", "<<=", ">>=", "=", "<", ">", "&&", "&", "||", "|", "!", "^",
			"~", "::", "public", "private", "protected", "and", "not", "or",
			"+=", "-=", "*=", "/=", "%=", "^=", "&=", "|=" };
	public static HashSet<String> opSet = new HashSet<String>();

	// List of primitive types and values
	public static String[] primitivetypes = { "int", "double", "float", "true",
			"false", "char", "short", "long", "unsigned" };
	public static HashSet<String> primitiveSet = new HashSet<String>();

	private static boolean isSetup = false;

	public static void setup()
	{
		if (!isSetup)
		{
			for (String s : operators)
			{
				opSet.add(s);
			}
			for (String s : primitivetypes)
			{
				primitiveSet.add(s);
			}
			for (String s : delims)
			{
				delimSet.add(s);
			}
			isSetup = true;
		}
	}

	/**
	 * A simple non-regex-splitter that splits the given string into tokens with
	 * the given delimiters.
	 * 
	 * @param src
	 *            Source string to split
	 * @param delims
	 *            Array of delimiters
	 * @param includeDelims
	 *            if 'true', the delimiters are included in the resulting array
	 * @return Array of tokens representing the original string
	 */
	public static String[] split(String src, String[] delims,
			boolean includeDelims)
	{
		// If the delims list is null, use the default set
		if (delims == null)
		{
			delims = StringTools.delims;
		}

		// Bail out on trivial input
		if ((src == null) || (src.length() == 0))
		{
			return new String[] { src };
		}
		if ((src.length() == 1) || (delims == null) || (delims.length == 0))
		{
			return new String[] { src };
		}

		// Init the list of parts
		ArrayList<String> parts = new ArrayList<String>();

		// Loop through the input string
		String s = "";
		for (int i = 0; i < src.length(); ++i)
		{
			src.charAt(i);
			boolean shouldSplit = false;
			String includedDelim = null;

			// Check for string literal
			if (src.charAt(i) == '"')
			{
				/*
				 * if(s.length() > 0) { shouldSplit = true; i--; }
				 */

				s += src.charAt(i);
				i++;
				while (i < src.length())
				{
					s += src.charAt(i);
					if (src.charAt(i) == '"')
					{
						if ((src.charAt(i - 1) != '\\')
								|| ((src.charAt(i - 1) == '\\') && (src
										.charAt(i - 2) == '\\')))
						{
							break;
						}
					}
					i++;
				}
				shouldSplit = true;
			}
			else if (src.charAt(i) == '\'')
			{
				s += src.charAt(i);
				i++;
				while (i < src.length())
				{
					s += src.charAt(i);
					if (src.charAt(i) == '\'')
					{
						if ((src.charAt(i - 1) != '\\')
								|| ((src.charAt(i - 1) == '\\') && (src
										.charAt(i - 2) == '\\')))
						{
							break;
						}
					}
					i++;
				}
				shouldSplit = true;
			}
			else
			{
				// Check for deliminator
				for (int j = 0; j < delims.length; ++j)
				{
					int matched = 0;
					for (int k = 0; k < delims[j].length(); ++k)
					{
						if ((i + k) < src.length())
						{
							if (src.charAt(i + k) == delims[j].charAt(k))
							{
								matched++;
								if (matched == delims[j].length())
								{
									shouldSplit = true;
									includedDelim = delims[j];
									break;
								}
							}
						}
					}
					if (shouldSplit)
					{
						break;
					}
				}

			}

			// If a delim was found, split the string
			if (shouldSplit)
			{
				if (s.length() > 0)
				{
					parts.add(s);
				}
				if (includeDelims && (includedDelim != null))
				{
					if (src.charAt(i) != ' ')
					{
						parts.add(includedDelim);
						i += includedDelim.length() - 1;
						includedDelim = null;
					}
				}
				s = "";
			}
			else
			{
				// No delim was found yet, add the current char to the current
				// string
				s += src.charAt(i);
			}
		}

		if (!s.equals(""))
		{
			parts.add(s);
		}

		// Finally, convert the ArrayList to a simple array and return it
		return listToArray(parts);
	}

	/**
	 * A simple non-regex-splitter that splits the given string array into
	 * tokens with the given delimiters.
	 * 
	 * @param src
	 *            Array of strings to split
	 * @param delims
	 *            List of delimiters
	 * @param includeDelims
	 *            If 'true', delimiters are included in the resulting array
	 * @return String array of the produced tokens
	 */
	public static String[] split(String[] src, String[] delims,
			boolean includeDelims)
	{
		// ArrayList for storing the parts
		ArrayList<String> parts = new ArrayList<String>();

		// Call the single string version for each of the strings in the input
		// array
		for (String s : src)
		{
			String[] tmpParts = StringTools.split(s, delims, includeDelims);
			for (String s2 : tmpParts)
			{
				parts.add(s2);
			}
		}

		// Finally, convert the ArrayList to a simple array and return it
		return listToArray(parts);
	}

	/**
	 * Converts an arraylist into an array
	 * 
	 * @param list
	 *            An arraylist to convert
	 * @return An array
	 */
	public static String[] listToArray(ArrayList<String> list)
	{
		String[] retParts = new String[list.size()];
		for (int i = 0; i < retParts.length; ++i)
		{
			retParts[i] = list.get(i);
		}

		return retParts;
	}

	/**
	 * Counts the amount of quotes (") in a given string
	 * 
	 * @param line
	 *            The string to count the quotes in
	 * @return The count of quotes in the string
	 */
	public static int getQuoteCount(String line)
	{
		int count = 0;
		for (int i = 0; i < line.length(); ++i)
		{
			if (line.charAt(i) == '"')
			{
				count++;
			}
		}
		return count;
	}

	/**
	 * Checks whether or not a given string is a reserved keyword of C++.
	 * 
	 * @param s
	 *            The string to check
	 * @return 'True' if the string is a keyword, 'false' otherwise
	 */
	public static boolean isKeyword(String s)
	{
		for (int i = 0; i < keywords_notypes.length; ++i)
		{
			if (keywords_notypes[i].equals(s))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks whether or not a given string is an operator (according to
	 * Halstead).
	 * 
	 * @param s
	 *            The string to check
	 * @return 'true' if the string is an operator, 'false' otherwise
	 */
	public static boolean isOperator(String s)
	{
		return opSet.contains(s);
	}

	/**
	 * Checks whether or not the given string is a "primitive type", such as
	 * int, long, bool etc.
	 * 
	 * @param s
	 *            String to check
	 * @return True if the string is a primitive type identifier, false
	 *         otherwise
	 */
	public static boolean isPrimitiveType(String s)
	{
		return primitiveSet.contains(s);
	}

	/**
	 * Cleans up a given string array so that the resulting array will not
	 * contain empty strings or strings that are not compatible with the main
	 * pass (mainly preprocessor directives)
	 * 
	 * @param s
	 *            Array of strings to clean
	 * @return String array without empty strings or non-compatible tokens
	 */
	public static String[] cleanEntries(String[] s)
	{
		ArrayList<String> list = new ArrayList<String>();
		for (String t : s)
		{
			if (t.length() > 0)
			{
				if (!t.equals("#if") && !t.equals("#else")
						&& !t.equals("#endif"))
				{
					list.add(t);
				}
			}
		}
		return listToArray(list);
	}

	/**
	 * Reconstructs "splitted" tokens. For example, if operator "==" is split
	 * into two "="'s, this method will reconstruct them.
	 * 
	 * @param tokens
	 *            Original list of tokens
	 * @return Array of tokens with reconstructed operators
	 */
	public static String[] reconstructOperators(String[] tokens)
	{
		ArrayList<String> newTokens = new ArrayList<String>();

		for (int i = 0; i < tokens.length; ++i)
		{
			switch (tokens[i])
			{
			case "=":
				i = reconstructAssignmentOperator(tokens, newTokens, i);
				break;
			case ".":
				i = reconstructDotOperator(tokens, newTokens, i);
				break;
			case "<":
			case ">":
			case "<<":
			case ">>":
			case "!":
			case "+":
			case "-":
			case "*":
			case "/":
			case "%":
			case "&":
			case "|":
			case "^":
				i = reconstructCommonOperator(tokens, newTokens, i);
				break;
			default:
				newTokens.add(tokens[i]);
				break;
			}
		}

		return listToArray(newTokens);
	}

	/**
	 * @param tokens
	 * @param newTokens
	 * @param i
	 * @return
	 */
	private static int reconstructCommonOperator(String[] tokens,
			ArrayList<String> newTokens, int i)
	{
		if (i < (tokens.length - 1))
		{
			if (tokens[i + 1].equals("="))
			{
				newTokens.add(tokens[i] + "=");
				i++;
			}
			else if (tokens[i + 1].equals(tokens[i])
					&& !tokens[i].equals("*"))
			{
				i = reconstructCompundOperator(tokens, newTokens, i);
			}

			else if (tokens[i].equals("<"))
			{
				i = reconstructOpeningAngleBracketOperator(tokens, newTokens, i);
			}
			else
			{
				newTokens.add(tokens[i]);
			}
		}
		return i;
	}

	/**
	 * @param tokens
	 * @param newTokens
	 * @param i
	 * @return
	 */
	private static int reconstructCompundOperator(String[] tokens,
			ArrayList<String> newTokens, int i)
	{
		if (i < (tokens.length - 2))
		{
			if (tokens[i + 2].equals("="))
			{
				newTokens.add(tokens[i] + tokens[i + 1]
						+ tokens[i + 2]);
				i += 2;
			}
			else
			{
				newTokens.add(tokens[i] + tokens[i + 1]);
				i++;
			}
		}
		else
		{
			newTokens.add(tokens[i] + tokens[i + 1]);
			i++;
		}
		return i;
	}

	/**
	 * @param tokens
	 * @param newTokens
	 * @param i
	 * @return
	 */
	private static int reconstructOpeningAngleBracketOperator(String[] tokens,
			ArrayList<String> newTokens, int i)
	{
		String template = "<";
		int bCount = 1;
		for (int j = i + 1; j < tokens.length; ++j)
		{
			if (tokens[j].equals("<"))
			{
				template += "<";
				bCount++;
				continue;
			}

			if (isOperator(tokens[j]) && !tokens[j].equals(">")
					&& !tokens[j].equals(","))
			{
				// Abort.
				newTokens.add("<");
				break;
			}
			else if (tokens[j].equals(">"))
			{
				bCount--;
				template += ">";
				if (bCount == 0)
				{
					String tempType = newTokens.get(newTokens
							.size() - 1);
					newTokens.remove(newTokens.size() - 1);
					newTokens.add(tempType + template);
					i = j;
					break;
				}
			}
			else
			{
				template += (template.length() > 1 ? " " : "")
						+ tokens[j];
			}
		}
		return i;
	}

	/**
	 * @param tokens
	 * @param newTokens
	 * @param i
	 * @return
	 */
	private static int reconstructDotOperator(String[] tokens,
			ArrayList<String> newTokens, int i)
	{
		String left = tokens[i - 1];
		String right = tokens[i + 1];
		try
		{
			NumberFormat.getInstance().parse(left);
			NumberFormat.getInstance().parse(right);
			newTokens.remove(newTokens.size() - 1);
			newTokens.add(left + "." + tokens[i + 1]);
			i++;
		}
		catch (ParseException e)
		{
			// e.printStackTrace();
			newTokens.add(".");
		}
		return i;
	}

	/**
	 * @param tokens
	 * @param newTokens
	 * @param i
	 * @return
	 */
	private static int reconstructAssignmentOperator(String[] tokens,
			ArrayList<String> newTokens, int i)
	{
		if (i < (tokens.length - 1))
		{
			if (tokens[i + 1].equals("="))
			{
				newTokens.add("==");
				i++;
			}
			else
			{
				newTokens.add("=");
			}
		}
		return i;
	}

/**
	 * Searches for the matching pair for the given bracket ("(", "[", "{", "<")
	 * and retrieves the index to the found pair.
	 * If the starting index contains an opening bracket, it will search
	 * forward for the closing bracket. If the starting index contains a
	 * closing bracket, the search will be done backwards.
	 * @param tokens Array of tokens
	 * @param startIndex Index of the start bracket
	 * @return Index to the pairing bracket, or -1 if one is not found
	 */
	public static int getBracketPair(String[] tokens, int startIndex)
	{
		String b = tokens[startIndex];
		if (!b.equals("(") && !b.equals("[") && !b.equals("{")
				&& !b.equals("<") && !b.equals(")") && !b.equals("]")
				&& !b.equals("}") && !b.equals(">"))
		{
			return -1;
		}

		int pairCount = 1;

		if (b.equals("(") || b.equals("[") || b.equals("{") || b.equals("<"))
		{
			for (int i = startIndex + 1; i < tokens.length; ++i)
			{
				if (tokens[i].equals(b))
				{
					pairCount++;
				}
				else if ((b.equals("(") && tokens[i].equals(")"))
						|| (b.equals("[") && tokens[i].equals("]"))
						|| (b.equals("{") && tokens[i].equals("}"))
						|| (b.equals("<") && tokens[i].equals(">")))
				{
					pairCount--;
					if (pairCount == 0)
					{
						return i;
					}
				}
			}
		}
		else
		{
			for (int i = startIndex - 1; i >= 0; --i)
			{
				if (tokens[i].equals(b))
				{
					pairCount++;
				}
				else if ((b.equals("(") && tokens[i].equals(")"))
						|| (b.equals("[") && tokens[i].equals("]"))
						|| (b.equals("{") && tokens[i].equals("}"))
						|| (b.equals("<") && tokens[i].equals(">")))
				{
					pairCount--;
					if (pairCount == 0)
					{
						return i;
					}
				}
			}
		}

		return -1;
	}
}
