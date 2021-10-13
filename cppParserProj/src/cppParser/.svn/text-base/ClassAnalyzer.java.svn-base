package cppParser;

import cppParser.utils.Log;
import cppParser.utils.StringTools;
import cppStructures.CppClass;
import cppStructures.CppFunc;
import cppStructures.CppFuncParam;
import cppStructures.CppNamespace;
import cppStructures.CppScope;
import cppStructures.MemberVariable;

/**
 * Analyzer for header files / classes.
 * 
 * @author Harri Pellikka
 */
public class ClassAnalyzer extends Analyzer
{
	// List of tokens currently under analysis (stored here for performance)
	private String[] tokens = null;

	// Current index of the tokens (stored here for performance)
	private int i = 0;

	boolean enumOpen = false;
	boolean structOpen = false;

	/**
	 * Constructs a new class analyzer
	 * 
	 * @param sa
	 *            The sentence analyzer
	 */
	public ClassAnalyzer(SentenceAnalyzer sa)
	{
		super(sa);
	}

	@Override
	/**
	 * (Derived from Analyzer.java)
	 * Processes a sentence
	 */
	public boolean processSentence(String[] tokens)
	{
		if (ParsedObjectManager.getInstance().currentFunc != null)
		{
			return false;
		}

		if (!processNewClass(tokens)
				&& (ParsedObjectManager.getInstance().currentScope != null))
		{
			if (objManager.currentScope.type != CppScope.NAMESPACE)
			{
				return processCurrentClass(tokens);
			}
		}
		return false;
	}

	/**
	 * Processes a sentence in the current class definition
	 * 
	 * @param tokens
	 *            The tokens that form the current sentence
	 * @return 'true' if the line was processed successfully, 'false' otherwise.
	 */
	private boolean processCurrentClass(String[] tokens)
	{
		this.tokens = tokens;
		this.i = 0;

		// Index for an assignment operator (if there's one)
		int assignIndex = -1;

		// Check if the sentence forms a function declaration (or a function
		// with a body)
		for (i = 0; i < tokens.length; ++i)
		{
			switch (tokens[i])
			{
			case "(":
				return handleOpeningParenthesis();
			case "enum":
				// TODO handle enums properly
				if (tokens[i + 1].equals("class")
						|| tokens[i + 1].equals("struct")
						|| tokens[i + 1].equals("union"))
				{
					// Log.d("\tFound a scope enum " + tokens[i+2] + "\n");
				}
				else
				{
					// Log.d("\tFound an enum " + tokens[i + 1] + "\n");
				}
				enumOpen = true;

				return true;
			case "typedef":
				// TODO handle typedefs properly
				return true;
			case "=":
				assignIndex = i;
				break;
			case "}":
				if (enumOpen)
				{
					// Log.d("Enum closed on line: " + Extractor.lineno);
					enumOpen = false;
				}
				else if (structOpen)
				{
					structOpen = false;
				}
				return true;
			}
		}

		if (enumOpen || structOpen)
		{
			return true;
		}

		return checkVariableDeclaration(tokens, assignIndex);
	}

	/**
	 * @param tokens
	 * @param assignIndex
	 * @return
	 */
	private boolean checkVariableDeclaration(String[] tokens, int assignIndex)
	{
		// At this point, we know the line cannot be a function declaration.
		// Check for a member variable declaration
		if (tokens.length > 2)
		{
			String mvName = "", mvType = "";
			if (assignIndex > 0)
			{
				// Build the type backwards
				for (int j = assignIndex - 2; j >= 0; --j)
				{
					if (!StringTools.isKeyword(tokens[j]))
					{
						if (tokens[j].equals(":"))
						{
							if ((j > 0) && !tokens[j - 1].equals(":"))
							{
								break;
							}
						}

						mvType = tokens[j] + (mvType.equals("") ? "" : " ")
								+ mvType;

					}
				}
				mvName = tokens[assignIndex - 1];
			}
			else
			{
				// Build the type backwards
				for (int j = tokens.length - 3; j >= 0; --j)
				{
					if (!StringTools.isKeyword(tokens[j]))
					{
						if (tokens[j].equals(":"))
						{
							if ((j > 0) && !tokens[j - 1].equals(":"))
							{
								break;
							}
						}

						mvType = tokens[j] + (mvType.equals("") ? "" : " ")
								+ mvType;
					}
				}
				mvName = tokens[tokens.length - 2];
			}

			// Log.d("\tVar: " + mvType + " | " + mvName);
			MemberVariable mv = new MemberVariable(mvType, mvName);
			objManager.currentScope.addMember(mv);
			return true;
		}

		return false;
	}

	/**
	 * Handles function declarations. Currently working: - Function names -
	 * Return types - Parameter lists - Parameterless functions (either empty
	 * parameter list or 'void') Not yet implemented / problems: - Commas in
	 * template parameters cause false splitting of params (i.e. Foo<T, U> bar)
	 * - No separation between static, virtual, const etc. function attributes
	 * 
	 * @return
	 */
	private boolean handleFunctionDeclaration()
	{
		// Check if there's a body and bail out
		if (tokens[tokens.length - 1].equals("{"))
		{
			// Log.d("\t... with a body, don't handle it here.");
			return false;
		}

		// Find out the return type of the function
		String type = "";
		for (int j = i - 2; j >= 0; --j)
		{
			if (!tokens[j].equals("virtual"))
			{
				if (!StringTools.isKeyword(tokens[j]))
				{
					if (tokens[j].equals(":"))
					{
						if (j > 0)
						{
							if (!tokens[j - 1].equals(":"))
							{
								break;
							}
							else if (StringTools.isKeyword(tokens[j - 1]))
							{
								break;
							}
						}
					}
					type = tokens[j] + (type.length() > 0 ? " " : "") + type;
				}
			}
		}

		String name = tokens[i - 1];

		if (type.equals(""))
		{
			if (name.contains(objManager.currentScope.getName()))
			{
				type = "ctor";
				if (name.startsWith("~"))
				{
					type = "dtor";
				}
			}
		}
		else if (type.equals("~"))
		{
			type = "dtor";
		}

		// Log.d("\tFunction: " + type + " | " + name);

		// Create the CppFunc object
		CppFunc cf = new CppFunc(type, name);

		// Search for parameters
		if (!tokens[i + 1].equals(")"))
		{
			String paramType = "";
			String paramName = "";
			boolean skipCommas = false;
			for (int j = i + 1; j < (tokens.length - 1); ++j)
			{
				if (tokens[j].equals(")"))
				{
					break;
				}

				if (tokens[j].contains("<"))
				{
					skipCommas = true;
				}
				if (tokens[j].contains(">"))
				{
					skipCommas = false;
				}

				if (!skipCommas
						&& (tokens[j].equals(",") || tokens[j].equals("=")))
				{
					CppFuncParam attrib = new CppFuncParam(paramType, paramName);
					cf.parameters.add(attrib);
					paramType = "";
					paramName = "";
					try
					{
						if (tokens[j].equals("="))
						{
							while (!tokens[j].equals(",")
									&& !tokens[j + 1].equals(")"))
							{
								j++;
							}
						}
					}
					catch (ArrayIndexOutOfBoundsException e)
					{
						Log.e("Expected ')'.\n  File: " + Extractor.currentFile
								+ "\n  Line: " + Extractor.lineno);
					}
				}
				else
				{
					if (!skipCommas
							&& (tokens[j + 1].equals(",")
									|| tokens[j + 1].equals(")") || tokens[j + 1]
									.equals("=")))
					{
						if (!paramType.equals(""))
						{
							paramName = tokens[j];
						}
						else
						{
							paramType = tokens[j];
						}
					}
					else
					{
						paramType += (paramType.length() > 0 ? " " : "")
								+ tokens[j];
					}
				}
			}

			if (!paramType.equals("") || !paramName.equals(""))
			{
				if (!paramName.equals("") && !paramType.equals("void"))
				{
					CppFuncParam attrib = new CppFuncParam(paramType, paramName);
					cf.parameters.add(attrib);
				}
			}
		}

		// Finally, store the CppFunc object
		cf.fileOfFunc = Extractor.currentFile;

		// ParsedObjectManager.getInstance().currentScope.addFunc(cf);
		ParsedObjectManager.getInstance().addFunction(cf, false);

		return true;
	}

	private boolean handleOpeningParenthesis()
	{
		if ((i > 0) && tokens[i].equals("("))
		{
			return handleFunctionDeclaration();
		}
		return false;
	}

	/**
	 * Checks the tokens for a possible new class declaration
	 * 
	 * @param tokens
	 *            Tokens that form the sentence
	 * @return 'true' if new class was found, 'false' otherwise
	 */
	private boolean processNewClass(String[] tokens)
	{
		// Workaround for some problems caused by pre-processor directives
		if (tokens[0].equals(":"))
		{
			return false;
		}

		for (int i = 0; i < tokens.length; ++i)
		{
			if (tokens[i].equals("class") || tokens[i].equals("struct")
					|| tokens[i].equals("union"))
			{
				// Get the class keyword count (if > 1, preprocessor directives
				// do messy things)
				int classWordCount = 1;
				for (int z = i + 1; z < tokens.length; ++z)
				{
					if (tokens[z].equals("class"))
					{
						classWordCount++;
					}
				}
				if (classWordCount > 1)
				{
					Log.e("Two class declarations on the same line\n  File: "
							+ Extractor.currentFile + "\n  Line: "
							+ Extractor.lineno);
				}

				// Log.d("Found "+tokens[i]);
				if (tokens[tokens.length - 1].equals(";"))
				{
					CppScope cc = createScope(tokens[i],
							tokens[tokens.length - 2]);
					cc.nameOfFile = Extractor.currentFile;

					return true;
				}
				else
				{
					// Found a class with definition
					boolean isInheriting = false;
					// indices for templates if they are found. template0
					// contains < token, when the template starts and template1
					// index of end token
					int template0 = 0, template1 = 0;
					String template = "";
					int templates = 0; // This is used for checking templates
										// inside templates
					boolean templateFound = false;

					for (int j = i + 1; j < (tokens.length - 1); ++j)
					{

						if (tokens[j].equals(":"))
						{
							isInheriting = true;
							// Log.d("   ... called " + tokens[j-1]);

							CppClass cc;
							if (tokens[i].contentEquals("class"))
							{
								cc = ParsedObjectManager
										.getInstance()
										.addClass(
												tokens[j - 1],
												ParsedObjectManager
														.getInstance().currentNamespace);
							}
							else
							{
								cc = ParsedObjectManager
										.getInstance()
										.addStruct(
												tokens[j - 1],
												ParsedObjectManager
														.getInstance().currentNamespace);
							}
							cc.nameOfFile = Extractor.currentFile;
							cc.braceCount = sentenceAnalyzer.braceCount;
							cc.namespace = ParsedObjectManager.getInstance().currentNamespace;
							// cc.parentScope =
							// ParsedObjectManager.getInstance().currentScope;

							createClassWithParents(tokens, i, template0,
									template1, template, templates,
									templateFound, j, cc);

							break;
						}
					}

					createClassWithoutParents(tokens, i, isInheriting);

					return true;
				}
			}
		}

		return false;
	}

	/**
	 * @param tokens
	 * @param i
	 * @param template0
	 * @param template1
	 * @param template
	 * @param templates
	 * @param templateFound
	 * @param j
	 * @param cc
	 */
	private void createClassWithParents(String[] tokens, int i, int template0,
			int template1, String template, int templates,
			boolean templateFound, int j, CppClass cc)
	{
		// Check for all parents
		for (int k = j + 1; k < tokens.length; ++k)
		{
			if (templateFound)
			{
				template += tokens[k];
				if (tokens[k].equals(">"))
				{
					templates--;
					if (templates == 0)
					{
						templateFound = false;
						template1 = k;
					}
				}
				continue;
			}
			else
			{
				if (tokens[k].equals("<"))
				{
					template = "<";
					templates++;
					templateFound = true;
					template0 = k;
					continue;
				}
			}

			createClass(tokens, i, template0, template1, template, cc, k);
		}

		// ParsedObjectManager.getInstance().currentScope = cc;
		sentenceAnalyzer.setCurrentScope(cc.getName(), true);
	}

	/**
	 * @param tokens List of tokens
	 * @param i Index of the 'class', 'struct' or 'union' keyword
	 * @param template0
	 * @param template1
	 * @param template
	 * @param cc
	 * @param k
	 */
	private void createClass(String[] tokens, int i, int template0,
			int template1, String template, CppClass cc, int k)
	{
		if (tokens[k].equals(",") || tokens[k].equals("{"))
		{
			// Search for a possible namespace
			String ns = null;
			CppNamespace cppNS = null;
			if (tokens[k - 2].equals("::"))
			{
				ns = tokens[k - 3];
			}
			if (ns != null)
			{
				cppNS = ParsedObjectManager.getInstance().getNamespace(ns);
				if (cppNS == null)
				{
					cppNS = new CppNamespace(ns);
					ParsedObjectManager.getInstance()
							.addNamespace(cppNS, false);
				}
			}

			// Log.d("    ... inherited from " + tokens[k-1]);
			CppClass pcc;
			if (tokens[i].contentEquals("class"))
			{
				if (template1 != 0)
				{
					pcc = ParsedObjectManager.getInstance().addClass(
							tokens[template0 - 1] + template, cppNS);
				}
				else
				{
					pcc = ParsedObjectManager.getInstance().addClass(
							tokens[k - 1], cppNS);
				}
			}
			else
			{
				if (template1 != 0)
				{
					pcc = ParsedObjectManager.getInstance().addStruct(
							tokens[template0 - 1] + template, cppNS);
				}
				else
				{
					pcc = ParsedObjectManager.getInstance().addStruct(
							tokens[k - 1], cppNS);
				}
			}

			pcc.addChild(cc);
			pcc.nameOfFile = Extractor.currentFile;
		}
	}

	/**
	 * @param tokens
	 * @param i
	 * @param isInheriting
	 */
	private void createClassWithoutParents(String[] tokens, int i,
			boolean isInheriting)
	{
		// If no ancestors were found, create a class with no parents
		if (!isInheriting)
		{
			// Log.d("   ... called " + tokens[tokens.length - 2]);
			String name = tokens[tokens.length - 2];
			if (tokens[tokens.length - 2].contentEquals(">"))
			{
				name = getNameWithTemplate(tokens, 2);
			}
			CppScope cc = createScope(tokens[i], name);

			cc.nameOfFile = Extractor.currentFile;
			cc.braceCount = sentenceAnalyzer.braceCount;
			// cc.parentScope = ParsedObjectManager.getInstance().currentScope;
			sentenceAnalyzer.setCurrentScope(cc.getName(), true);
		}
	}

	/**
	 * Method returns struct/class name if it contains template. This method is
	 * to be used with classes that don't inherit.
	 * 
	 * @return
	 */
	private String getNameWithTemplate(String[] tokens, int index)
	{
		int x = index;
		int templates = 1;
		String name = "";
		try
		{
			while (true)
			{
				name = tokens[tokens.length - x] + name;
				if (tokens[tokens.length - x].contentEquals("<"))
				{

					templates--;
					if (templates == 0)
					{
						break;
					}
				}
				else if (tokens[tokens.length - x].contentEquals(">"))
				{
					templates++;
				}

				x++;
			}
			name = tokens[tokens.length - x - 1] + name;
		}
		catch (Exception e)
		{
			// This warning is caused by wrong handling of templates(and
			// possibly arrays in struct/class definitions
			Log.d("Warning: Index out of bounds while parsing template:"
					+ Extractor.currentFile + " line:" + Extractor.lineno + " "
					+ name);
		}
		return name;

	}

	/**
	 * Creates a scope based on the type and name
	 * @param type Type of the scope
	 * @param name Name of the scope
	 * @return The newly created scope
	 */
	private CppScope createScope(String type, String name)
	{
		CppScope cc = null;
		switch (type)
		{
		case "class":
			cc = ParsedObjectManager.getInstance().addClass(name,
					ParsedObjectManager.getInstance().currentNamespace);
			break;
		case "struct":
			cc = ParsedObjectManager.getInstance().addStruct(name,
					ParsedObjectManager.getInstance().currentNamespace);
			break;
		case "union":
			cc = ParsedObjectManager.getInstance().addUnion(name);
			break;
		}
		return cc;
	}
}
