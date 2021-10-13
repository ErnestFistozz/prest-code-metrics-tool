package cppParser;

import java.util.ArrayList;

import cppParser.utils.Log;
import cppParser.utils.MacroExpander;
import cppParser.utils.StringTools;
import cppStructures.CppDefine;

/**
 * Pass for analyzing the preprocessor directives. This pass is done for all the
 * files before the actual analysis takes place.
 * 
 * @author Harri Pellikka
 */
public class PreprocessorPass
{

	// Simple counter for #defines found
	public static int defineCount = 0;

	// List of deliminators used for tokenization
	private String[] delims = { " ", "#", "(", ")", ",", "*", "/", "+", "-",
			"<", ">" };

	// Current index of tokens
	private int i = 0;

	// List of current tokens
	private String[] tokens = null;

	// Determines whether or not the current #define is "function-like"
	private boolean functionLike = false;

	/**
	 * Constructs a new preprocess pass analyzer
	 */
	public PreprocessorPass()
	{

	}

	/**
	 * Checks whether or not the line forms a "function-like" macro
	 * 
	 * @param line
	 *            Line to check
	 * @return True if the macro is function-like, false if not
	 */
	private boolean isFunctionLike(String line)
	{
		String[] spaceDelim = new String[] { " " };
		String[] tmpTokens = StringTools.split(line, spaceDelim, false);
		if (tmpTokens[1].contains("("))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Processes a given line.
	 * 
	 * @param Line
	 *            to process
	 */
	public void process(String line)
	{
		if (line.startsWith("#def") || line.startsWith("#inc"))
		{
			functionLike = isFunctionLike(line);

			String[] tokens = StringTools.split(line, delims, true);
			analyze(tokens);
		}
	}

	/**
	 * Analyzes the given list of tokens
	 * 
	 * @param tokens
	 *            Tokens that form the sentence under analysis
	 */
	private void analyze(String[] tokens)
	{
		this.tokens = tokens;

		for (i = 0; i < tokens.length; ++i)
		{
			switch (tokens[i])
			{
			case "include":
				// handleInclude();
				break;
			case "define":
				handleDefine();
				defineCount++;
				break;
			case "ifdef":
			case "ifndef":
				handleIf();
				break;
			}
		}
	}

	private void handleIf()
	{
		Log.d("Found " + tokens[i]);
	}

	/**
	 * Handles #define statements (constants, macros etc.) and extracts
	 * CppDefine objects from them.
	 */
	private void handleDefine()
	{
		if (!functionLike)
		{
			// Constant definition
			String def = "";
			for (i = 3; i < tokens.length; ++i)
			{
				def += (def.length() > 0 ? " " : "") + tokens[i];
			}

			MacroExpander.addDefine(tokens[2], new CppDefine(def));
			Log.d("#define: " + tokens[2] + " " + def);
		}
		else
		{
			// Search for the parameters
			ArrayList<String> params = new ArrayList<String>();
			String param = "";
			for (i = 4; i < tokens.length; ++i)
			{
				if (tokens[i].equals(")"))
				{
					params.add(param);
					i++;
					break;
				}
				else if (tokens[i].equals(","))
				{
					params.add(param);
					param = "";
					continue;
				}
				else
				{
					param += tokens[i];
				}
			}

			// Construct the "replacement" definition
			String def = "";
			for (; i < tokens.length; ++i)
			{
				def += (def.length() > 0 ? " " : "") + tokens[i];
			}

			if (def.length() > 0)
			{
				MacroExpander.addDefine(tokens[2], new CppDefine(params, def));
				Log.d("#define: " + tokens[2] + " " + params + " " + def);
			}
			else
			{
				// The parameter list was actually the definition
				String par = "";
				for (int k = 0; k < params.size(); ++k)
				{
					par += (par.length() > 0 ? " " : "") + params.get(k);
				}

				MacroExpander.addDefine(tokens[2], new CppDefine(par));
				Log.d("#define: " + tokens[2] + " " + par);
			}
		}
	}
}
