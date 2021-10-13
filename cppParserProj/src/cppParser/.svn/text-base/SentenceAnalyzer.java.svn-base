package cppParser;

import java.util.ArrayList;

import cppParser.utils.LLOCCounter;
import cppParser.utils.LOCMetrics;
import cppParser.utils.MacroExpander;
import cppParser.utils.StringTools;
import cppStructures.CppNamespace;
import cppStructures.CppScope;

public class SentenceAnalyzer
{
	// Open brace count
	public int braceCount = 0;

	public static boolean ignoreStd = false;

	// List of analyzers
	private ArrayList<Analyzer> analyzers = new ArrayList<Analyzer>();
	private FunctionAnalyzer functionAnalyzer;
	private ClassAnalyzer classAnalyzer;
	private ScopeAnalyzer scopeAnalyzer;
	private LLOCCounter llocCounter = null;
	private LOCMetrics loc = null;

	/**
	 * Constructs a new sentence analyzer
	 */
	public SentenceAnalyzer()
	{
		functionAnalyzer = new FunctionAnalyzer(this);
		classAnalyzer = new ClassAnalyzer(this);
		scopeAnalyzer = new ScopeAnalyzer(this);

		analyzers.add(new TypedefAnalyzer(this));
		analyzers.add(functionAnalyzer);
		analyzers.add(classAnalyzer);
		analyzers.add(scopeAnalyzer);
	}

	/**
	 * Sets the current scope to "scopeName". If the scope is already known, the
	 * existing scope will be used. Otherwise, a new scope is created. If
	 * 'addToStack' is 'true', the scope is also stored in a scope stack. This
	 * is useful for i.e. inner classes.
	 * 
	 * @param scopeName
	 *            The name of the scope
	 * @param addToStack
	 *            If 'true', store the scope in a scope stack
	 */
	public void setCurrentScope(String scopeName, boolean addToStack)
	{
		assert (scopeName != null);

		// Search for an existing scope with the given name
		boolean found = false;
		for (CppScope cc : ParsedObjectManager.getInstance().getScopes())
		{
			if (cc.getName().equals(scopeName))
			{
				if (addToStack)
				{
					ParsedObjectManager.getInstance().getCppScopeStack()
							.push(cc);
				}
				ParsedObjectManager.getInstance().currentScope = cc;
				found = true;
				break;
			}
		}

		if (!found)
		{
			CppScope cc = new CppScope(scopeName);
			cc.nameOfFile = Extractor.currentFile;
			ParsedObjectManager.getInstance().getScopes().add(cc);
			ParsedObjectManager.getInstance().currentScope = cc;
			if (addToStack)
			{
				ParsedObjectManager.getInstance().getCppScopeStack().push(cc);
			}
		}
	}

	/**
	 * Handles an ending brace. In the case of a function body, the current
	 * function handling is ended. In the case of a scope, the current scope
	 * handling is ended, and if the scope is in the scope stack, it is removed
	 * from there.
	 */
	private void lexEndBrace()
	{
		// If function body is ended
		if ((ParsedObjectManager.getInstance().currentFunc != null)
				&& (ParsedObjectManager.getInstance().currentFunc.funcBraceCount == braceCount))
		{
			ParsedObjectManager.getInstance().currentFunc = null;
		}

		// If scope body is ended
		if (!ParsedObjectManager.getInstance().getCppScopeStack().isEmpty()
				&& (ParsedObjectManager.getInstance().getCppScopeStack().peek().braceCount == braceCount))
		{
			ParsedObjectManager.getInstance().getCppScopeStack().pop();
			if (ParsedObjectManager.getInstance().getCppScopeStack().size() > 0)
			{
				ParsedObjectManager.getInstance().currentScope = ParsedObjectManager
						.getInstance().getCppScopeStack().peek();
			}
			else
			{
				if (ParsedObjectManager.getInstance().currentScope instanceof CppNamespace)
				{
					ParsedObjectManager.getInstance().currentNamespace = null;
				}
				ParsedObjectManager.getInstance().currentScope = null;
			}
		}

		braceCount--;
	}

	/**
	 * Does lexical analysis (tokenizing) of a given line of code
	 */
	public void lexLine(String line)
	{
		// Split the line into tokens
		String[] tokens = StringTools.split(line, null, true);
		tokens = (new MacroExpander()).expand(tokens);
		tokens = StringTools.reconstructOperators(tokens);
		tokens = StringTools.cleanEntries(tokens);

		// Handle braces
		boolean stringOpen = false;
		for (int i = 0; i < tokens.length; ++i)
		{
			if (tokens[i].equals("\""))
			{
				stringOpen = !stringOpen;
			}
			if (!stringOpen && (tokens[i].length() == 1))
			{
				if (tokens[i].equals("{"))
				{
					braceCount++;
					continue;
				}
				if (tokens[i].equals("}"))
				{
					lexEndBrace();
					continue;
				}
			}
		}

		// Process LOC metrics
		llocCounter.processSentence(tokens);

		// Loop through analyzers
		boolean handled = false;
		for (Analyzer a : analyzers)
		{
			if (handled = a.processSentence(tokens))
			{
				break;
			}
		}

		if (!handled)
		{
			// Log.d("Couldn't handle: " + Extractor.currentFile + ": " +
			// Extractor.lineno);
		}
	}

	/**
	 * Used by LLOC counting
	 * 
	 * @param file
	 */
	public void fileChanged(String file, LOCMetrics loc)
	{
		if (llocCounter != null)
		{
			this.loc.logicalLOC += llocCounter.getLloc();
			// System.out.println("LLoc:"+this.loc.logicalLOC);
		}

		this.loc = loc;

		llocCounter = new LLOCCounter();
		loc.file = file;
		llocCounter.setFile(file);
	}

	public void lastFileProcessed()
	{
		this.loc.logicalLOC += llocCounter.getLloc();
	}
}
