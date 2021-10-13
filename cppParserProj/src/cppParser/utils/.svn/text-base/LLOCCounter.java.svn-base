package cppParser.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import cppParser.ParsedObjectManager;

/**
 * This class takes tokens from SentenceAnalyzer and counts how many logical
 * lines of code(aka logical source statements) it can find. This class does not
 * count preprocessor directives eg #include <iostream> and they should not be
 * given to it through processSentence(String[] tokens). Instead they should be
 * counted outside this class and added to the count by using addLloc();
 * 
 * @author Tomi
 */
public class LLOCCounter
{
	private static final boolean enableLogging = false;
	private static final int BEGIN = 0, SKIPTONEXT = 1, SKIPPARENTHESIS = 2,
			SKIPTOCOLON = 3, SKIPTOBRACKET = 4, FOR = 5;
	private int mode = BEGIN;
	private String currentForStatement;

	private int parenthesisDepth = 0;

	// Special cases for counting lloc in function bodies
	private static final String[] special = { "case", "catch", "class",
			"default", "do", "else", "for", "if", "private", "protected",
			"public", "struct", "switch", "try", "union", "while" };
	private static final List<String> specialCases = new ArrayList<>(
			Arrays.asList(special));
	private String file;
	private int lloc = 0;
	private int index;

	/**
	 * This method checks logical lines of code in the given tokens tokens
	 * should not contain preprocessor directives
	 * 
	 * @param tokens
	 */
	public void processSentence(String[] tokens)
	{

		String next;
		for (index = 0; index < tokens.length; index++)
		{// TBD bracket skipping
			next = null;
			if (tokensFormFunction(tokens))
			{// If tokens form a start of a function then they can be skipped
				if (enableLogging)
				{
					Log.d("LLOC FuncB");
				}
				addLloc();
				return;
			}
			if ((index + 1) < tokens.length)
			{
				next = tokens[index + 1];
			}
			// Log.d(tokens[index]+" "+next+mode);
			chooseAction(tokens[index], next);
		}
	}

	/**
	 * This method checks if tokens for beginning of a function eg. void hello()
	 * {
	 * 
	 * @param tokens
	 * @return true if tokens form start of a function definition
	 */
	private boolean tokensFormFunction(String[] tokens)
	{
		try
		{
			if (tokens[tokens.length - 1].contentEquals("{"))
			{
				if (tokens[tokens.length - 2].contentEquals(")"))
				{
					for (int i = 0; i < tokens.length; i++)
					{
						if (tokens[i].contentEquals("("))
						{
							if (StringTools.isKeyword(tokens[i - 1])
									|| StringTools
											.isPrimitiveType(tokens[i - 1]))
							{
								return false;
							}
							else
							{
								return true;
							}
						}
					}
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			return false;
		}
		return false;
	}

	/**
	 * This method decides how to handle the tokens depending on the mode that
	 * was chosen before. BEGIN is a mode that is selected by default and that
	 * mode is selected when a LLOC ends, eg ; is found
	 * 
	 * @param token
	 * @param next
	 */
	private void chooseAction(String token, String next)
	{
		switch (mode)
		{
		case BEGIN:
			takeFirstTokens(token, next);
			break;
		case FOR:
			handleFor(token, next);
			break;
		case SKIPTONEXT:
			skipToNextStatement(token);
			break;
		case SKIPTOCOLON:
			skipColon(token);
			break;
		case SKIPPARENTHESIS:
			skipParenthesis(token);
			break;
		case SKIPTOBRACKET:
			skipToBracket(token);
			break;
		}
	}

	private void takeFirstTokens(String token, String next)
	{
		if (token.contentEquals("{"))
		{
			return;
		}
		else if (token.contentEquals("}"))
		{
			return;
		}
		if (Collections.binarySearch(specialCases, token) >= 0)
		{
			handleSpecialCase(token, next);
		}
		else
		{
			switch (token)
			{
			case ";":
				reset(); // empty statements are not counted
				break;
			case "case":
			case "default":
				mode = SKIPTOCOLON;
				break;
			default:
				if (enableLogging)
				{
					Log.d("LLOC statement");
				}
				addLloc();
				mode = SKIPTONEXT;
			}

		}
	}

	/**
	 * There are some special cases in C++ that need different kind of handling
	 * this method does that depending on what the token is.
	 * 
	 * @param token
	 * @param next
	 */
	private void handleSpecialCase(String token, String next)
	{
		switch (token)
		{
		case "for":
			if (enableLogging)
			{
				Log.d("LLOC ForB");
			}
			addLloc();
			mode = FOR;
			currentForStatement = "";
			parenthesisDepth = 0;
			break;
		case "try":
		case "do":
			break; // Do and try are not counted separately
		case "switch":
		case "catch":
		case "while":
		case "if":
			if (enableLogging)
			{
				Log.d("LLOC switch/if/catch/while");
			}
			addLloc();
			mode = SKIPPARENTHESIS;
			break;
		case "default":
		case "case":
			if (enableLogging)
			{
				Log.d("LLOC case/default");
			}
			addLloc();
			mode = SKIPTOCOLON;
			break;
		case "else":
			if (next.equals("if"))
			{
				if (enableLogging)
				{
					Log.d("LLOC else-if");
				}
				addLloc();
				skip();
				mode = SKIPPARENTHESIS;
			}
			break;
		case "private":
		case "protected":
		case "public":
			if (enableLogging)
			{
				Log.d("LLOC private/protected/public");
			}
			addLloc();
			skip();
			break;
		case "class":
		case "struct":
		case "union":
			if (enableLogging)
			{
				Log.d("LLOC class/struct/union");
			}
			addLloc();
			mode = SKIPTOBRACKET;
		}
	}

	/**
	 * This method counts all statements that are inside parenthesis of a for
	 * loop. Empty statements are not counted and for-each loops are always
	 * counted as two llocs
	 * 
	 * @param token
	 * @param next
	 */
	private void handleFor(String token, String next)
	{
		switch (token)
		{
		case ";":
			if (!currentForStatement.isEmpty())
			{
				currentForStatement = "";
				if (enableLogging)
				{
					Log.d("LLOC for parenthesis");
				}
				addLloc();
			}
			break;
		case "(":
			parenthesisDepth++;
			break;
		case ")":
			parenthesisDepth--;
			if (parenthesisDepth == 0)
			{
				if (!currentForStatement.isEmpty())
				{
					if (enableLogging)
					{
						Log.d("LLOC for parenthesis end");
					}
					addLloc();
				}
				reset();
			}
			break;
		default:
			currentForStatement += token;
		}
	}

	public String getFile()
	{
		return file;
	}

	public void setFile(String file)
	{
		this.file = file;
	}

	public void addLloc()
	{
		lloc++;
		if (ParsedObjectManager.getInstance().currentFunc != null)
		{
			ParsedObjectManager.getInstance().currentFunc.getLOCMetrics().logicalLOC++;
		}
		if (ParsedObjectManager.getInstance().currentScope != null)
		{
			ParsedObjectManager.getInstance().currentScope.getLOCMetrics().logicalLOC++;
		}
	}

	public void addLloc(int count)
	{
		lloc += count;
		if (ParsedObjectManager.getInstance().currentFunc != null)
		{
			ParsedObjectManager.getInstance().currentFunc.getLOCMetrics().logicalLOC += count;
		}
		if (ParsedObjectManager.getInstance().currentScope != null)
		{
			ParsedObjectManager.getInstance().currentScope.getLOCMetrics().logicalLOC += count;
		}
	}

	public int getLloc()
	{
		return lloc;
	}

	public void setLloc(int lloc)
	{
		this.lloc = lloc;
	}

	private void skip()
	{
		index++;
	}

	private void reset()
	{
		mode = BEGIN;

	}

	private void skipToNextStatement(String token)
	{
		if (token.contentEquals(";"))
		{
			reset();
		}
	}

	private void skipParenthesis(String token)
	{
		switch (token)
		{
		case "(":
			parenthesisDepth++;
			break;
		case ")":
			parenthesisDepth--;
			if (parenthesisDepth <= 0)
			{
				reset();
			}
			break;

		}
	}

	private void skipColon(String token)
	{
		if (token.contentEquals(":"))
		{
			reset();
		}
	}

	private void skipToBracket(String token)
	{
		switch (token)
		{
		case ";":
		case "{":
			reset();
			// case ":":
		}
	}
}
