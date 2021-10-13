package cppParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Stack;

import cppParser.utils.*;
import cppStructures.CppClass;
import cppStructures.CppFile;
import cppStructures.CppFunc;
import cppStructures.CppNamespace;
import cppStructures.CppScope;

/**
 * Extractor.java Provides lexical analysis and metrics extraction of C++ source
 * and header files.
 * 
 * @author Harri Pellikka
 */
public class Extractor
{

	enum Pass
	{
		PREPASS, MAINPASS, POSTPASS
	}

	enum Mode
	{
		PREPASS_ONLY, MAINPASS_ONLY, ALL_PASSES
	}

	private Pass currentPass = Pass.PREPASS;
	private Mode currentMode = Mode.ALL_PASSES;

	// Filename or folder to process
	private String file = "";
	// Directory for the output files;
	private String outputDir = "";

	// File that is currently being processed
	public static String currentFile = "";

	// Current class stack under processing
	private Stack<CppScope> cppScopeStack = new Stack<CppScope>();

	// If 'true', all "std"-starting stuff is ignored
	// private boolean ignoreStd = true;

	// Current line in the source file (may not reflect the actual processing)
	public static int lineno = 0;
	public int loc = 0;
	public int lloc = 0;
	public int ploc = 0;

	// Reference to the singleton parsed object manager
	private ParsedObjectManager objManager;

	// The sentence analyzer used to analyze each "raw" sentence
	private SentenceAnalyzer sentenceAnalyzer;

	private PreprocessorPass prepassAnalyzer;
	private LOCMetrics locM;
	private PLOCCounter plocCounter = null;

	/**
	 * Constructor
	 * 
	 * @param file
	 *            Single file or a folder to process
	 */
	public Extractor(String file)
	{
		this.file = file;
		objManager = ParsedObjectManager.getInstance();
	}

	/**
	 * Constructor
	 * 
	 * @param file
	 *            Single file or a folder to process
	 * @param outputDir
	 *            Directory where metrics are stored
	 */
	public Extractor(String file, String outputDir)
	{
		this.file = file;
		this.outputDir = outputDir;
		objManager = ParsedObjectManager.getInstance();
	}

	/**
	 * Starts processing the files
	 */
	public void process()
	{
		// Setup the file loader and load files
		FileLoader fileLoader = new FileLoader(this.file);

		Log.d("Processing started.");

		// Setup the hashsets for stringtools
		StringTools.setup();

		Log.d("Finding files and sorting... ");

		long startTime = System.currentTimeMillis();

		// Initialize the analyzers
		sentenceAnalyzer = new SentenceAnalyzer();
		prepassAnalyzer = new PreprocessorPass();

		Log.d("Files sorted in "
				+ ((System.currentTimeMillis() - startTime) / 1000.0) + " s.");
		Log.d("Found " + fileLoader.getFiles().size() + " files.");

		// Execute the pre-pass if needed
		if (currentMode != Mode.MAINPASS_ONLY)
		{
			doPrePass(fileLoader, startTime);
		}

		// Execute the main pass if needed
		if (currentMode != Mode.PREPASS_ONLY)
		{
			doMainPass(fileLoader);
		}
		
		sumClassMetrics();
		sumFileMetrics();

		// Verify that no macro calls are in the operands
		// verifyToFile();

		// Debug dump
		// TODO REMOVE WHEN DONE
		dumpFunctions();
		dumpScopes();

		// Dump tree results to a file
		ResultExporter exp = new ResultExporter(outputDir,
				CmdLineParameterParser.includeStructs);
		exp.exportAll();

		Log.d("Dump done.");

		long duration = System.currentTimeMillis() - startTime;
		Log.d("Processing took " + (duration / 1000.0) + " s.");
	}

	/**
	 * @param fileLoader
	 */
	private void doMainPass(FileLoader fileLoader)
	{
		currentPass = Pass.MAINPASS;

		// Loop through the found files
		for (String s : fileLoader.getFiles())
		{
			ParsedObjectManager.getInstance().setCurrentFile(s);
			locM = new LOCMetrics();
			ParsedObjectManager.getInstance().addLocMetric(locM);
			sentenceAnalyzer.fileChanged(s, locM);

			process(s);
		}

		sentenceAnalyzer.lastFileProcessed();
		Log.d("Main pass done.");
	}

	/**
	 * @param fileLoader
	 * @param startTime
	 */
	private void doPrePass(FileLoader fileLoader, long startTime)
	{
		currentPass = Pass.PREPASS;

		// Parse preprocessor directives
		for (String s : fileLoader.getFiles())
		{
			CppFile cf = new CppFile(s);
			ParsedObjectManager.getInstance().addFile(cf);
			ParsedObjectManager.getInstance().setCurrentFile(cf);
			process(s);
		}

		// Expand #include paths
		for (CppFile cf : ParsedObjectManager.getInstance().getFiles())
		{
			cf.expandIncludes();
		}

		ParsedObjectManager.getInstance().setCurrentFile("");

		// Dump the #include tree for debuggin purposes
		dumpIncludeTree();

		// Calculate the pre-pass execution time
		long prepassDuration = System.currentTimeMillis() - startTime;
		Log.d("Found " + PreprocessorPass.defineCount + " #defines.");
		Log.d("Prepass done. (" + prepassDuration / 1000.0 + " s.)");
	}

	/**
	 * Processes a single file. Processing happens as follows: - The input file
	 * is read char-by-char - Based on special characters, the lines are turned
	 * into "sentences", which are basically strings ending with ";" or "{" - In
	 * the pre-pass mode, only sentences starting with "#" will be handled - In
	 * the main pass, macro calls are expanded - When a sentence is contructed,
	 * it will be delivered to the sentence analyzer for the actual analysis
	 * 
	 * @param file
	 *            File to process
	 */
	private void process(String file)
	{
		currentFile = file;
		Log.d("Processing: " + file);
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(new File(
					file)));

			char c; // Current char
			lineno = 1;
			String line = ""; // Sentence under construction
			int rawExpandStartIndex = 0; // Index of the char in line where the
											// last macro expansion ended
			boolean stringOpen = false, charOpen = false; // Booleans to
															// determine if
															// string or char is
															// open
			plocCounter = new PLOCCounter();

			// Loop through the file char-by-char
			while ((c = (char) reader.read()) != (char) -1)
			{
				if (currentPass == Pass.MAINPASS)
				{
					plocCounter.push(c);
				}

				// Skip system macros
				line = skipSystemMacros(line, reader);

				// Handle spaces, carriage returns and tabs
				if (c == '\r')
				{
					continue;
				}
				if (c == '\f')
				{
					continue;
				}
				if ((c == ' ') && line.endsWith(" "))
				{
					continue;
				}
				if (c == '\t')
				{
					if (line.length() > 0)
					{
						line += " ";
					}
					continue;
				}

				// Add the current char to the line
				if (c == '\\')
				{
					line += "\\";
				}
				else
				{
					line += c;
				}

				// Skip "empty" whitespaces
				if (line.equals("\n") || line.equals("\t") || line.equals(" "))
				{
					if (line.equals("\n"))
					{
						lineno++;
					}
					line = "";
					rawExpandStartIndex = 0;
					continue;
				}

				// Toggle string and char literals on / off
				stringOpen = handleStringLiteral(c, line, stringOpen, charOpen);
				charOpen = handleCharLiteral(c, line, stringOpen, charOpen);

				if (!stringOpen && !charOpen)
				{
					// Count line numbers
					if (line.endsWith("\n"))
					{
						lineno++;
					}

					if (line.endsWith("//"))
					{
						processSingleLineComment(line, reader);
						line = line.substring(0, line.indexOf("//"));
						if (rawExpandStartIndex > line.length())
						{
							rawExpandStartIndex = 0;
						}
						continue;
					}

					// Handle multi-line comments
					if (line.endsWith("/*"))
					{
						processMultiLineComment(
								line.substring(line.indexOf("/*")), reader);
						if (!line.startsWith("/*"))
						{
							line = line.substring(0, line.indexOf("/*"));
						}
						else
						{
							line = "";
							rawExpandStartIndex = 0;
						}
						continue;
					}

					// Handle newline
					if (line.endsWith("\n"))
					{
						// Handle preprocessor directives
						if (line.startsWith("#"))
						{
							line = handleEOLforPreProcessor(line);
							continue;
						}
						else
						{
							line = line.substring(0, line.length() - 1);
							line += " ";
						}
					}

					// Expand macros
					if (currentPass == Pass.MAINPASS)
					{
						if (!line.startsWith("#")
								&& MacroExpander.shouldExpandRaw(line, c))
						{
							String beginLine = line.substring(0,
									rawExpandStartIndex);
							String expandable = line
									.substring(rawExpandStartIndex);
							expandable = MacroExpander.expandRaw(expandable);
							line = beginLine + " " + expandable;
							if (line.trim().endsWith(";"))
							{
								line = line.trim();
							}
							rawExpandStartIndex = line.length() - 1;
						}
					}

					// Handle end-of-sentence
					if (!line.startsWith("#"))
					{
						if (line.endsWith(";") || line.endsWith("{")
								|| line.endsWith("}")
								|| isVisibilityStatement(c, line))
						{
							if (currentPass == Pass.MAINPASS)
							{
								sentenceAnalyzer.lexLine(line.trim());
							}

							line = "";
							rawExpandStartIndex = 0;
							continue;
						}
					}
				}
			}
			if (currentPass == Pass.MAINPASS)
			{
				plocCounter.push('\n');
				resetLOCCounter(plocCounter);
			}
			loc++;
			postCheck();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @param c
	 * @param line
	 * @param stringOpen
	 * @param charOpen
	 * @return
	 */
	private boolean handleCharLiteral(char c, String line, boolean stringOpen,
			boolean charOpen)
	{
		if ((c == '\'') && !stringOpen && !line.endsWith("\\\'"))
		{
			charOpen = !charOpen;
		}
		return charOpen;
	}

	/**
	 * @param c
	 * @param line
	 * @param stringOpen
	 * @param charOpen
	 * @return
	 */
	private boolean handleStringLiteral(char c, String line,
			boolean stringOpen, boolean charOpen)
	{
		if ((c == '"') && !charOpen && !line.endsWith("\\\""))
		{
			stringOpen = !stringOpen;
		}
		return stringOpen;
	}

	/**
	 * @param line
	 * @return
	 */
	private String handleEOLforPreProcessor(String line)
	{
		if (line.endsWith("\\\n"))
		{
			line = line.substring(0, line.length() - 2);
		}
		else
		{
			// Log.d("Found #: " + line);
			if (currentPass == Pass.PREPASS)
			{
				line = line.substring(0, line.length() - 1);
				prepassAnalyzer.process(line.trim());
			}
			line = "";
		}
		return line;
	}

	/**
	 * Does a small post-check of whether or not the commonly used temporary
	 * storages were cleared or not. These may be indicators of erroneous
	 * processing.
	 */
	private void postCheck()
	{
		// Check for non-cleared references
		if (ParsedObjectManager.getInstance().currentFunc != null)
		{
			Log.d("Warning: Current function was not null after processing.");
			ParsedObjectManager.getInstance().currentFunc = null;
		}
		if (ParsedObjectManager.getInstance().currentScope != null)
		{
			Log.d("Warning: Current scope was not null after processing.");
			ParsedObjectManager.getInstance().currentScope = null;
		}
		if (ParsedObjectManager.getInstance().currentNamespace != null)
		{
			Log.d("Warning: Current namespace was not null after processing.");
			ParsedObjectManager.getInstance().currentNamespace = null;
		}
		if (!ParsedObjectManager.getInstance().getCppScopeStack().isEmpty())
		{
			Log.d("Warning: CPP scope stack was not empty after processing.");
			ParsedObjectManager.getInstance().getCppScopeStack().clear();
		}
	}

	/**
	 * Skips system macros
	 * 
	 * @param line
	 *            Line read so far
	 * @param reader
	 *            Input reader
	 * @return Line without the system macros
	 * @throws IOException
	 *             Thrown if an error happens in reading
	 */
	private String skipSystemMacros(String line, BufferedReader reader)
			throws IOException
	{
		if (line.endsWith("__declspec"))
		{
			while ((char) reader.read() != ')')
			{
				;
			}
			line = line.substring(line.indexOf("__declspec"));
		}
		else if (line.endsWith("STDMETHODIMP"))
		{
			line = line.substring(line.indexOf("STDMETHODIMP"));
			line += (char) reader.read();
			if (line.endsWith("_"))
			{
				line = line.substring(0, line.length() - 1);
			}
		}
		return line;
	}

	/**
	 * Handles a single line comment. Advances the reader to the end of the
	 * comment.
	 */
	private void processSingleLineComment(String line, BufferedReader reader)
			throws IOException
	{
		char c;
		while (((c = (char) reader.read()) != '\n') && (c != '\r')
				&& (c != (char) -1))
		{
			if (currentPass == Pass.MAINPASS)
			{
				plocCounter.push(c);
			}
			line += c;
		}
		// lineno++;
	}

	/**
	 * Handles a multi-line comment. Advacnes the reader to the end of the
	 * comment.
	 */
	private void processMultiLineComment(String line, BufferedReader reader)
			throws IOException
	{
		char c;
		while (!line.endsWith("*/"))
		{
			c = (char) reader.read();
			if (currentPass == Pass.MAINPASS)
			{
				plocCounter.push(c);
			}
			line += c;
			if (line.endsWith("\n"))
			{
				lineno++;
			}
		}
	}

	private void resetLOCCounter(PLOCCounter ploc)
	{
		if (currentPass == Pass.MAINPASS)
		{
			locM.codeOnlyLines = ploc.codeLines;
			locM.emptyLines = ploc.emptyLines;
			locM.commentLines = ploc.commentOnlyLines;
			locM.commentedCodeLines = ploc.commentedCodeLines;
			locM.logicalLOC += ploc.preProcessorDirectives;

		}
	}

	/**
	 * Checks whether or not the line forms a 'visibility statement' found
	 * usually in headers
	 * 
	 * @param c
	 *            The latest char to add
	 * @param line
	 *            The line formed so far
	 * @return 'true' if the line forms either "public", "protected" or
	 *         "private" statement, 'false' otherwise
	 */
	private boolean isVisibilityStatement(char c, String line)
	{
		if (c != ':')
		{
			return false;
		}
		else
		{
			if (line.endsWith("public:") || line.endsWith("protected:")
					|| line.endsWith("private:"))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Dumps an "include" tree (NOT IN USE ATM)
	 */
	private void dumpIncludeTree()
	{
		BufferedWriter writer;
		try
		{
			writer = new BufferedWriter(new FileWriter("includetree.txt"));

			Log.d("Dumping include tree...");
			for (CppFile cf : ParsedObjectManager.getInstance().getFiles())
			{
				cf.dump(writer, new HashSet<CppFile>(), 0);
				writer.write("\n");
			}

			writer.close();
		}
		catch (Exception e)
		{

		}
	}

	/**
	 * Dumps functions into a text file
	 */
	private void dumpFunctions()
	{
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					"dump_functions.txt"));

			for (CppScope scope : ParsedObjectManager.getInstance().getScopes())
			{
				for (CppFunc func : scope.getFunctions())
				{
					writer.write(func.getType() + " " + func.getName() + "()"
							+ " | " + func.fileOfFunc + "\n");
					writer.write("------------------------\n");
					writer.write("LOC\n");
					writer.write("    LLOC: " + func.getLOCMetrics().logicalLOC
							+ "\n");
					writer.write("    Code-only: "
							+ func.getLOCMetrics().codeOnlyLines + "\n");
					writer.write("    Comment lines: "
							+ func.getLOCMetrics().commentLines + "\n");
					writer.write("    Commented code lines: "
							+ func.getLOCMetrics().commentedCodeLines + "\n");
					writer.write("    Empty lines: "
							+ func.getLOCMetrics().emptyLines + "\n");
					writer.write("------------------------\n");
					writer.write("Operands:\n");
					for (String s : func.getOperands())
					{
						writer.write("    " + s + "\n");
					}
					writer.write("Operators:\n");
					for (String s : func.getOperators())
					{
						writer.write("    " + s + "\n");
					}
					writer.write("Metrics:\n");
					writer.write("  Op count: " + func.getOperandCount() + "\n");
					writer.write("  Od count: " + func.getOperatorCount()
							+ "\n");
					writer.write("  Unique Op count: "
							+ func.getUniqueOperandCount() + "\n");
					writer.write("  Unique Od count: "
							+ func.getUniqueOperatorCount() + "\n");
					writer.write("  Cyclomatic complexity: "
							+ func.getCyclomaticComplexity() + "\n");
					writer.write("\n\n");
				}

			}

			writer.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Dumps namespaces into a text file
	 */
	private void dumpScopes()
	{
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					"dump_namespaces.txt"));

			writer.write("NAMESPACES\n**************\n");
			for (CppScope scope : ParsedObjectManager.getInstance().getScopes())
			{
				if (scope instanceof CppNamespace)
				{
					CppNamespace namespace = (CppNamespace) scope;
					writer.write(namespace.getName() + "\n");

					if (namespace.parents.size() > 0)
					{
						writer.write("Parents:\n");
						for (CppScope parent : namespace.parents)
						{
							writer.write("   " + parent.getName() + "\n");
						}
					}

					if (namespace.children.size() > 0)
					{
						writer.write("Children:\n");
						for (CppScope child : namespace.children)
						{
							writer.write("   " + child.getName() + "\n");
						}
					}
					writer.write("\n");
				}

			}
			writer.write("\n\n");

			writer.write("CLASSES\n**************\n");
			for (CppScope scope : ParsedObjectManager.getInstance().getScopes())
			{
				if ((scope instanceof CppClass)
						&& (scope.type == CppScope.CLASS))
				{
					CppClass cppClass = (CppClass) scope;
					writer.write(cppClass.getName()
							+ "("
							+ (cppClass.namespace != null ? cppClass.namespace
									.getName() : "__MAIN__") + ")" + "\n");

					writer.write("------------------------\n");
					writer.write("LOC\n");
					writer.write("    LLOC: "
							+ cppClass.getLOCMetrics().logicalLOC + "\n");
					writer.write("    Code-only: "
							+ cppClass.getLOCMetrics().codeOnlyLines + "\n");
					writer.write("    Comment lines: "
							+ cppClass.getLOCMetrics().commentLines + "\n");
					writer.write("    Commented code lines: "
							+ cppClass.getLOCMetrics().commentedCodeLines
							+ "\n");
					writer.write("    Empty lines: "
							+ cppClass.getLOCMetrics().emptyLines + "\n");
					writer.write("------------------------\n");

					if (cppClass.parents.size() > 0)
					{
						writer.write("Parents:\n");
						for (CppScope parent : cppClass.parents)
						{
							writer.write("   "
									+ parent.getName()
									+ "("
									+ (parent.namespace != null ? parent.namespace
											.getName() : "__MAIN__") + ")"
									+ "\n");
						}
					}

					if (cppClass.children.size() > 0)
					{
						writer.write("Children:\n");
						for (CppScope child : cppClass.children)
						{
							writer.write("   "
									+ child.getName()
									+ "("
									+ (child.namespace != null ? child.namespace
											.getName() : "__MAIN__") + ")"
									+ "\n");
						}
					}
					writer.write("\n");
				}

			}
			writer.write("\n\n");

			writer.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method sums the metrics that already have been separately calculated
	 * for each class. To get the averages from these they have to be divided
	 * with number of functions in the scope
	 */
	private void sumClassMetrics()
	{
		// CppFunc helper;
		for (CppScope s : ParsedObjectManager.getInstance().getScopes())
		{
			// helper=new CppFunc("void","helper");
			for (CppFunc func : s.getFunctions())
			{
				LOCMetrics locMetrics = func.getLOCMetrics();

				s.sumFuncLLOC += locMetrics.logicalLOC;
				s.sumFuncPLOC += (locMetrics.commentedCodeLines + locMetrics.codeOnlyLines);
				s.sumFuncCommentLines += (locMetrics.commentedCodeLines + locMetrics.commentLines);
				s.sumFuncEmptyLines += locMetrics.emptyLines;

				s.sumOperators += func.getOperatorCount();
				s.sumOperands += func.getOperandCount();
				s.sumUniqueOperators += func.getUniqueOperatorCount();
				s.sumUniqueOperands += func.getUniqueOperandCount();

				s.sumCalculatedLength += func.getCalculatedLength();
				s.sumDeliveredBugs += func.getDeliveredBugs();

				s.sumVocabulary += func.getVocabulary();
				s.sumLength += func.getLength();
				s.sumVolume += func.getVolume();
				s.sumDifficulty += func.getDifficulty();
				s.sumEffort += func.getEffort();
				s.sumTimeToProgram += func.getTimeToProgram();
				s.sumDeliveredBugs += func.getDeliveredBugs();
				s.sumLevel += func.getLevel();
				s.sumIntContent += func.getIntContent();
				s.sumFuncCC += func.getCyclomaticComplexity();

			}
		}
	}

	/**
	 * This method sums the metrics that already have been separately calculated
	 * for each file. To get the averages from these they have to be divided
	 * with number of functions in the scope
	 */
	private void sumFileMetrics()
	{
		CppFunc helper;
		for (CppFile f : ParsedObjectManager.getInstance().getFiles())
		{
			String filename = f.getFilename();
			helper = new CppFunc("void", "helper");
			int complexity = 0;
			for (CppScope s : ParsedObjectManager.getInstance().getScopes())
			{
				for (CppFunc func : s.getFunctions())
				{
					if (func.fileOfFunc.contentEquals(filename))
					{
						for (String op : func.getOperands())
						{
							helper.addOperand(op);
						}
						for (String op : func.getOperators())
						{
							helper.addOperator(op);
						}
						helper.getCyclomaticComplexity();
						complexity += func.getCyclomaticComplexity();
					}
				}
			}
			helper.setCyclomaticComplexity(complexity);
			f.setOtherMetrics(helper);

		}
	}
}
