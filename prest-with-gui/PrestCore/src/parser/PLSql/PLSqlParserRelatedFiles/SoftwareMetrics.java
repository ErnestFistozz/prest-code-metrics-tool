package parser.PLSql.PLSqlParserRelatedFiles;
//import SoftwareMetrics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.Map.Entry;
import java.util.ArrayList;

import parser.PLSql.MetricsRelatedFiles.PLSqlCommonMetrics;
import parser.PLSql.MetricsRelatedFiles.PLSqlConstants;
import parser.PLSql.MetricsRelatedFiles.PLSqlContainer;
import parser.PLSql.MetricsRelatedFiles.PLSqlFileMetrics;
import parser.PLSql.MetricsRelatedFiles.PLSqlMethodMetrics;
import parser.PLSql.MetricsRelatedFiles.PLSqlPackageMetrics;
/******************************************************************************
 * Software Metrics (with thanks to the Software Engineering Institute
 * (www.sei.cmu.edu), Julian M. Bucknall (www.boyet.com) and Tim Littlefair
 * (Tim_Littlefair@hotmail.com))
 ******************************************************************************
 * Copyright (c) E2 System Limited 2007.
 * All rights reserved.
 * 
 * GPL v.2 license is granted by 
 * David Edwards <dme@e2systems.co.uk>
 * Web Site http://www.e2systems.co.uk
 * 
 * ****************************************************************************
 * This is principally designed to carry out lexical-based code counting,
 * controlled by a table that details what to do with particular language
 * elements.
 *
 * The benefits of lexical-based scanning are:
 * -  We count everything, whether the parser recognises it correctly or not
 * -  So we don't have to get the parser exactly right.
 *
 * The drawbacks are:
 * -   Things like the Cyclomatic Effect of PL/SQL decode(), where the impact
 *     should  depend on the number of arguments to it, which are merely
 *     separated with pairs of ',', are only approximated
 * -   We are not necessarily taking account of the scope of a variable
 *     (e.g. is this 'x' really the same as some 'x' encountered earlier)?
 * -   Everything user-defined is an Operand, whereas functions should perhaps
 *     be Operators
 * -   Look-ahead is going to get allocated to the wrong method/function/
 *     procedure or whatever.
 *
 * I am hopeful that the rule table will make it possible for the output to be
 * tuned to match some arbitrary product; useful for validation purposes at any
 * rate.
 *
 * Note that more sophisticated processing driven off an accurate, complete
 * parser is also supported. In this case, a different adjustMetrics() is
 * called from everywhere in the parser. Putting these calls in entails a lot
 * more work than the lexical counting, and in addition you would need to
 * create dummy OPERATORS in the rules, that affect the cyclomatic factor but
 * not the operator or operand, to get the cyclomatic counting working
 * correctly, if you want to count all the 'if's or ','s, for instance, but
 * only want to increment the cyclomatic count when it is meaningful to do so
 * (from within the decode() in the latter case).
 * ****************************************************************************
 * Instructions
 * ****************************************************************************
 * There are three private classes in this file:
 * -   TokenDetails, which hold accumulators associated with a single token
 * -   ModuleDetails, which own TokenDetails, and child ModuleDetails
 * -   TokenRules, which hold processing rules
 *
 * The TokenRules live in a static HashMap
 *
 * The singleton SoftwareMetrics owns the root ModuleDetails.
 *
 * To use this stuff:
 * -   Call the static SoftwareMetrics.start() method to make sure the
 *     singleton is instantiated
 * -   Load up the rules (SoftwareMetrics.addRule())
 * -   Parse the source files
 *     -   wrap the recognition of code units with SoftwareMetrics.start() and
 *         SoftwareMetrics.finish()
 *     -   arrange for SoftwareMetrics.adjustMetrics() to be called by the lexer
 *         for every token potentially passed back to the parser
 *     -   track the white space discarded and count blank lines; call
 *         SoftwareMetrics.incBlanks() as appropriate
 *     -   likewise comments; call SoftwareMetrics.incComments() as appropriate
 * -   Call SoftwareMetrics.processTree() to dump out the data collected on
 *     stdout
 *
 * For details of the parameters, see the comments below the nested classes.
 *
 * See JAVAMain.java, PLSQLMain.java, PLSQLGrammar.g and java.g for examples
 */
public class SoftwareMetrics
{
	//START: user defined
	public static PLSqlContainer plsqlContainer;
	public static Vector<PLSqlFileMetrics> fileMetrics;
	public static Vector<PLSqlPackageMetrics> packageMetrics;
	public static Vector<PLSqlMethodMetrics> methodMetrics;
	
	public static void resetPLSqlContainer(){
		plsqlContainer = new PLSqlContainer();
		fileMetrics = new Vector<PLSqlFileMetrics>();
		packageMetrics = new Vector<PLSqlPackageMetrics>();
		methodMetrics = new Vector<PLSqlMethodMetrics>();
	}
	
	public static PLSqlContainer getPLSqlContainer(){
		return plsqlContainer;
	}
	
	private void addToContainer(int depth, ModuleDetails moduleDetails) {
		//add Method
		if("Function".equalsIgnoreCase(moduleDetails.moduleType) || "Procedure".equalsIgnoreCase(moduleDetails.moduleType)){
			addMethod(moduleDetails);
		}
		
		//add Package Body
		if("Package Body".equalsIgnoreCase(moduleDetails.moduleType) ){ //|| "Package".equalsIgnoreCase(moduleDetails.moduleType)
			addPackage(moduleDetails);
		}
		
		//means the file is done
		if("Source".equalsIgnoreCase(moduleDetails.moduleType)){	//1 == depth || 
			addFile(moduleDetails);
		}
		
		//means the parsing reached end
		//create container
		if(0 == depth){
			plsqlContainer.addFile(fileMetrics);
		}
		
	}
	

	private void addFile(ModuleDetails moduleDetails) {
		// TODO Auto-generated method stub
		//get module details
		//get all package vector and
		//add them to fileMetrics
		//clear package vector
		
		PLSqlCommonMetrics commonMetrics = new PLSqlCommonMetrics(moduleDetails);
		PLSqlFileMetrics tempFile = new PLSqlFileMetrics(commonMetrics, packageMetrics);
		fileMetrics.add(tempFile);
		packageMetrics.removeAllElements();
	}

	private void addPackage(ModuleDetails moduleDetails) {
		// TODO Auto-generated method stub
		//all methods will be used to create its method vector
		//get module details
		//add to packageMetrics
		//clear method vector
		
		PLSqlCommonMetrics commonMetrics = new PLSqlCommonMetrics(moduleDetails);
		PLSqlPackageMetrics tempPackage = new PLSqlPackageMetrics(commonMetrics, methodMetrics);
		packageMetrics.add(tempPackage);
		methodMetrics.removeAllElements();
	}

	private void addMethod(ModuleDetails moduleDetails) {
		//get module details
		//add to methodMetrics
		
		PLSqlCommonMetrics commonMetrics = new PLSqlCommonMetrics(moduleDetails);
		methodMetrics.add(new PLSqlMethodMetrics(commonMetrics));
	}
	
	//END: user defined
	
	
	public static final int OPERATOR = 1;
	public static final int OPERAND = 2;
	/**
	 * Inner class to hold statistics for a token (Operator or Operand or both)
	 */
	private class TokenDetails
	{
		String name;
		int operatorCnt;
		int operandCnt;

		/**
		 * Constructor
		 */
		TokenDetails (String nm)
		{
			this.name = nm;
		}
		/**
		 * Human-readable rendition
		 */
		public String toString()
		{
			return "name: " + name + " operatorCnt: " + operatorCnt
			+ " operandCnt: " + operandCnt;
		}
	}
	/**
	 * Inner class to hold language element processing rules. We use this to:
	 * -   Make the mechanics language-independent
	 * -   Make up for the limitations of lexical counting. Every 'if' will have
	 *     an 'end if', and so 'if' will be seen twice as often as its logical
	 *     impact on the complexity; thus, we set the 'if' cyclomatic factor to
	 *     0.5 rather than 1.
	 */
	private class TokenRules
	{
		String name;
		/*
		 * Set the following to a fraction for interesting elements that necessarily
		 * occur more than once in a stream (for example, if ... end if; we want a 
		 * total of 1.0)
		 */
		double cycloFactor;
		/*
		 * Default statistics impacts
		 *
		 * We could penalize some elements (e.g. goto)
		 *
		 * We could decide to ignore some (e.g. the '.' operator in PL/SQL), or
		 * even negate their effects (e.g. treat a.b as one thing rather than three).
		 *
		 * We can make up for the deficiencies of lexical-based counting by:
		 * -   Scaling down (handling 'if ... end if', for instance)
		 * -   Scaling up (we don't know how many elements there will be in a decode
		 *     block if we just pick up the 'decode', so we pick an 'average')
		 */
		int operatorAdjust;
		int operandAdjust;
		/*
		 * Flag indicating whether this token is case-sensitive or not. Even in
		 * PL/SQL, which is ordinarily case-insensitive, it is possible to coerce
		 * case-sensitivity (by using the "Double Quote" construct).
		 */
		boolean sensitive;

		/**
		 * Constructor
		 */
		TokenRules (String name, double cycloFactor, int operatorAdjust,
				int operandAdjust, boolean sensitive)
				{
			this.name = name;
			this.cycloFactor = cycloFactor;
			this.operatorAdjust = operatorAdjust;
			this.operandAdjust = operandAdjust;
			this.sensitive = sensitive;
				}
		/**
		 * Human-readable rendition
		 */
		public String toString()
		{
			return "name: " + name + " cycloFactor: " + cycloFactor
			+ " operatorAdjust: " + operatorAdjust
			+ " operandAdjust: " + operandAdjust;
		}
	}
	/**
	 * Inner class to hold details of a Code Element
	 */
	public class ModuleDetails
	{
		/**
		 * PL/SQL; Procedure, Function, Package, Package Body.
		 */
		public String name;
		public String moduleType;
		/**
		 * Line Counters
		 */
		public int blankLines;
		public int sourceLines;
		public int commentLines;
		public int lastParseLine;
		/**
		 * Statement/Comment Counters
		 */
		public int statementCnt;
		public int commentCnt;
		/**
		 * Halstead Metrics
		 */
		public int distinctOperands;
		public int totalOperands;
		public int distinctOperators;
		public int totalOperators;
		public int programLength;
		public int vocabulary;
		public double volume;
		public double difficulty;
		public double effort;
		
		//Ozan
		public int conditionCount;
		public int decisionCount;
		public int branchCount;
		public int unstructuredElement;
		//Ozan
				
		
		/**
		 * McCabe's Cyclomatic Complexity
		 */
		public double cyclomatic;
		/**
		 * Maintainability Index
		 */
		public int moduleCnt = 1;
		/*
		 * Four term  maintainabilityIndex;
		 */
		public double maintainabilityIndex;
		/*
		 * Three term  maintainabilityIndex, excluding comments
		 */
		public double maintainabilityIndexNC;
		/**
		 * Halstead Measures (lifted from www.sei.cmu.edu)
		 * =================
		 * The Halstead measures are based on four scalar numbers derived directly
		 * from a program's source code:
		 * n1 = the number of distinct operators
		 * 
		 * n2 = the number of distinct operands
		 * 
		 * N1 = the total number of operators
		 * 
		 * N2 = the total number of operands
		 * 
		 * From these numbers, five measures are derived:
		 * Measure Symbol Formula
		 * 
		 * Program length N N= N1 + N2
		 * 
		 * Program vocabulary n n= n1 + n2
		 * 
		 * Volume V V= N * (LOG2 n)
		 * 
		 * Difficulty D D= (n1/2) * (N2/n2)
		 * 
		 * Effort E E= D * V
		 */
		void computeHalstead()
		{
			programLength = totalOperands + totalOperators;
			vocabulary = distinctOperators + distinctOperands;
			if (distinctOperators > 0 && distinctOperands > 0)
			{
				volume = programLength * Math.log(vocabulary)/Math.log(2);
				difficulty = distinctOperators/2 * (totalOperands/distinctOperands); 
				effort = difficulty * volume;
			}
			return;
		}
		HashMap<String,TokenDetails> tokenMap = new HashMap<String,TokenDetails>(1024);
		/**
		 * countNewLines()
		 * Increment source lines by the number of new lines embedded in any of the
		 * tokens
		 */
		private int countNewLines(String s)
		{
			int cnt;
			int i;

			for (cnt = 0, i = 0; (i = s.indexOf('\n',i)) >= 0; cnt++, i++);
			return cnt;
		}
		/**
		 * trackParse()
		 * - Code that allows us to see how the parse is progressing based on
		 *   the call stack.
		 */
		private void trackParse(String token, int lineNo)
		{
			try
			{
				throw (new Throwable());
			}
			catch(Throwable e)
			{
				StackTraceElement stack[] = e.getStackTrace();
				/*  
				 *  stack[0] contains the method that created the exception (This one).
				 *  We don't want the calls in this file, so start from 4
				 *
				 *  stack[stack.length-1] contains the oldest method call.
				 *
				 *  We just print 22 for now
				 */
				for (int i= ((stack.length > 30) ? 30 : (stack.length - 1)); i > 3; i--)
				{
					String filename = stack[i].getFileName();
					String className = stack[i].getClassName();
					String methodName = stack[i].getMethodName();
					boolean isNativeMethod = stack[i].isNativeMethod();
					int line = stack[i].getLineNumber();

					if (filename == null) // The source filename is not available
						filename= "(Filename not available)";
					System.out.println("S:" +className+"."+methodName+ " line " + line);
				}
				System.out.println("R:" + token + ':' + lineNo);
			}
			return;
		}
		/**
		 * Adjust metrics.
		 * -  Look for the token in the hash map.
		 * -  If it is there, update the counts
		 * -  If it isn't there, add it.
		 *
		 * Also need to update the line counters; source code, comment,
		 * blank line.
		 *
		 * There is an issue with the line tracking. Comments are going to be seen
		 * by the lexical analyzer, whilst the tokens won't be handled until the parser
		 * gets to see them, which is some way behind.
		 *
		 * Thus, line counting ought to be handled exclusively by the lexical analyzer.
		 *
		 * We give this the job of incrementing blank lines when it is recognizing
		 * whitespace.
		 *
		 * We count comment in a similar way.
		 *
		 * Lines with source are counted from the parser, by comparing a line passed
		 * in with the last line passed in.
		 *
		 * Note that this means that 'trailing' comments and blank lines will go to
		 * the preceding object. O.K. for the file as a whole, though.
		 *
		 * Strings with embedded new lines should also increment the source count.
		 * This is done when the token is stored.
		 */
		private void adjustMetrics(String token, int opFlag, int lineNo, int diff)
		{
			/**
			 * Have we seen this token before?
			 * -  If not, we place it in the hashmap.
			 * -  Otherwise, we increment the appropriate count.
			 */
			TokenDetails tokenDetail = tokenMap.get(token);

//			trackParse(token, lineNo);
			if (tokenDetail == null)
			{
				tokenDetail = new TokenDetails(token);
				tokenMap.put(token, tokenDetail);
			}
			if (opFlag == OPERAND)
				tokenDetail.operandCnt += diff;
			else
				tokenDetail.operatorCnt += diff;
			/*
			 * Increment source lines.
			 */
			if (lineNo > lastParseLine)
			{
				sourceLines++;
				lastParseLine = lineNo;
//				System.out.println("Line: " + lastParseLine);
			}
			sourceLines += countNewLines(token);
			return;
		}
		/**
		 * Adjust metrics using the exported approach
		 * -  Look for the token in the hash map.
		 * -  If it is there, use the values from the rules table.
		 */
		private void adjustMetrics(String token, int opFlag, int lineNo)
		{
			adjustMetrics(token, opFlag, lineNo, 1);
			if (opFlag == OPERATOR)
				incCyclomatic(token);
		}
		/**
		 * Adjust metrics using the table of rules.
		 * -  Look for the token in the hash map.
		 * -  If it is there, use the values from the rules table.
		 * -  Otherwise use default values (it's an OPERAND, and we're interested in it)
		 */
		private void adjustMetrics(String token, int lineNo)
		{
			/**
			 * Adjust the cyclomatic count, and as a side effect find out if we
			 * know about this token.
			 */
			TokenRules tokenRule = incCyclomatic(token);

			if (tokenRule != null)
			{
				if (tokenRule.operatorAdjust != 0)
					adjustMetrics(token, OPERATOR, lineNo, tokenRule.operatorAdjust);
				if (tokenRule.operandAdjust != 0)
					adjustMetrics(token, OPERAND, lineNo, tokenRule.operandAdjust);
			}
			else
				adjustMetrics(token, OPERAND, lineNo, 1);
			return;
		}
		/**
		 * Increment comment-count and comment-lines
		 */
		void incComments(int lineCnt)
		{
			commentCnt++;
			commentLines += lineCnt;
			return;
		}
		/**
		 * Increment blank lines
		 */
		void incBlanks(int lineCnt)
		{
			blankLines += lineCnt;
			return;
		}
		/**
		 * Called to increment semantic statements
		 */
		void incStatements()
		{
			statementCnt++;
			return;
		}		
		
		//Ozan
		void incCondition(){
			conditionCount++;
			return;
		}
		void incDecision(){
			decisionCount++;
			return;
		}
		void incBranch(){
			branchCount++;
			return;
		}
		void incUnstructured(){
			unstructuredElement++;
		}
		//Ozan
		
		/**
		 * McCabe's Cyclomatic Complexity
		 * ==============================
		 * McCabe's method was defined in terms of decision points in flowcharts.
		 * 
		 * Tim Littlefair, in his CCCC Java/C++ Metrics program, used the following
		 * alternative (I have paraphrased the comments in cccc_tok.c).
		 * 
		 * "Token objects are used to count the occurences of states which 
		 * the analyser is interested in within the text.  Any metric which
		 * can be reduced to lexical counting on the text can be recorded
		 * this way.
		 * 
		 * The CCCC implementation counts the following features:
		 * -   tokens
		 * -   comment lines
		 * -   lines containing at least one token of code
		 * 
		 * It also makes a lexical count for the following tokens, each of which
		 * is expected to increase McCabe's cyclomatic complexity (Vg) for the 
		 * section of code by one unit:
		 * 
		 *   IF FOR WHILE SWITCH BREAK RETURN ? && ||
		 * 
		 * Note that && and || create additional paths through the code due to C/C++ 
		 * short circuit evaluation of logical expressions.
		 * 
		 * Also note the way SWITCH constructs are counted: the desired increment
		 * in Vg is equal to the number of cases provided for, including the 
		 * default case, whether or not an action is defined for it.  This is achieved
		 * by counting the SWITCH at the head of the construct as a surrogate for 
		 * the default case, and counting BREAKs as surrogates for the individual
		 * cases.  This approach yields the correct results provided that the
		 * coding style in use ensures the use of BREAK after all non-default
		 * cases, and forbids 'drop through' from one case to another other than
		 * in the case where two or more values of the switch variable require
		 * identical actions, and no executable code is defined between them."
		 * 
		 * PL/SQL doesn't have a switch statement. Additionally, SQL being declarative
		 * doesn't affect the flow of control, but intuitively it does impact
		 * complexity. nvl() and decode() functions imply multiple paths.
		 *
		 * The following approach is influenced by Julian Bucknall's suggestions.
		 * 
		 * This algorithm calculates the Cyclomatic Complexity value for a method using
		 * token counting (again).
		 * 
		 * 1. Start with 0.
		 * 2. Add 1 for each conditional statement or looping statement. (So, add 1 for
		 *    an if, or a while, or a foreach, or a ternary operator, etc.)
		 * 3. Add 1 for each AND or OR logical operator used in a condition.
		 * 4. Add 1 for each case in a case or switch statement (Java). If the
		 *    case/switch statement doesn't have an explicit default case, add 1.
		 * 5. Add 1 for each catch statement or 'when' (exception) statement.
		 * 6. Add 1 for each exit or return
		 * 7. Finally, if the answer is zero (i.e. no branches, and no return either)
		 *    set the answer to 1. All this means is that the method should finish;
		 *    there is at least one path through the method.
		 *
		 * Obviously this logic needs to be different for each language. Our approach
		 * is to:
		 * -  Look up the token in the rule map.
		 * -  Do what it says there
		 */
		/**
		 * Adjust the cyclomatic complexity
		 */
		TokenRules incCyclomatic(String token)
		{
			TokenRules tokenRule = ruleMap.get(token.toLowerCase());

			if (tokenRule != null
					&& (tokenRule.sensitive == false || tokenRule.name.equals(token)))
			{
				cyclomatic += tokenRule.cycloFactor;
				/*
				 *      if (tokenRule.cycloFactor > 0)
				 *          System.out.println( moduleType + ':' + name + ':' + token + ':' +
				 *              tokenRule.cycloFactor);
				 */
			}
			return tokenRule;
		}
		/**
		 * Maintainability Index (MI) (lifted from www.sei.cmu.edu)
		 * ==========================
		 * 171 - 5.2 * ln(aveV) - 0.23 * aveV(g') - 16.2 * ln (aveLOC) + 50 * sin
		 * (sqrt(2.4 * perCM))
		 * 
		 * The coefficients are derived from actual usage (see Usage
		 * Considerations). The terms are defined as follows:
		 * 
		 * aveV = average Halstead Volume V per module (see Halstead Complexity
		 * Measures)
		 * 
		 * aveV(g') = average extended cyclomatic complexity per module (see
		 * Cyclomatic Complexity)
		 * 
		 * aveLOC = the average count of lines of code (LOC) per module; and,
		 * optionally
		 * 
		 * perCM = average percent of lines of comments per module
		 * 
		 * Example of usage. Welker relates how a module containing a routine with
		 * some "very ugly" code was assessed as unmaintainable, when expressed in
		 * terms of the MI (note that just quantifying the problem is a step forward)
		 * [Welker 95]. The module was first redesigned, and then functionally
		 * enhanced. The measured results are shown in Table 7:
		 * 
		 * Table 7: Measured Results
		 * 
		 * Measure Initial Code Restructured Code After Enhancement Code Unit Routine
		 * Module Routine Module Routine Module MI (larger MI = more maintainable)
		 * 6.47 33.55 39.93 70.13 37.62 69.60
		 * 
		 * Halstead Effort1 2,216,499 2,233,072 182,216 480,261 201,429 499,474
		 * 
		 * Extended Cyclomatic Complexity2 45 49 18 64 21 67
		 * 
		 * Lines of Code 622 663 196 732 212 748
		 * 
		 * 1 Halstead Effort, rather than Halstead Volume, was used in this case
		 * study. See Halstead Complexity Measures for more information on both
		 * these measures. Generally, the lower a program's measure of effort,
		 * the simpler a change to the program will be (because Halstead measures
		 * are weighted toward measuring computational complexity, not all programs
		 * will behave this way).
		 * 
		 * 2 Note that a low Cyclomatic Complexity is generally indicative of a
		 * lower risk, hence more maintainable, program. In this case, restructuring
		 * increased the module complexity slightly (from 49 to 64), but reduced
		 * the "ugly" routine's complexity significantly. In both, the subsequent
		 * enhancement drove the complexity slightly higher.
		 * 
		 * If the enhancement had been made without first doing the restructuring,
		 * these figures indicate the change would have been much more risky.
		 * 
		 * Coleman, Pearse, and Welker provide detailed descriptions of how MI was
		 * calibrated and used at Hewlett-Packard [Coleman 94, Coleman 95, Pearse
		 * 95, Welker 95].
		 */
		void calculateMI()
		{
			if (moduleCnt > 0 && sourceLines > 0)
			{
				maintainabilityIndexNC = 171 - 5.2 * Math.log(volume/moduleCnt) - 0.23 *
				cyclomatic/moduleCnt - 16.2 * Math.log(sourceLines/moduleCnt);
				maintainabilityIndex = maintainabilityIndexNC + 50 *
				Math.sin((Math.sqrt(2.4 * commentCnt/sourceLines)));
			}
		}
		/**
		 * Constructor
		 */
		ModuleDetails (String nm, String mt, int base, ModuleDetails owner)
		{
			name = nm;
			moduleType = mt;
			parentModule = owner;
			lastParseLine = base;
			return;
		}
		/**
		 * Keep track of child modules
		 */
		ArrayList<ModuleDetails> moduleDetails = new ArrayList<ModuleDetails>(256);
		/**
		 * Note the parent, for handling nesting.
		 */
		ModuleDetails parentModule;

		/**
		 * Add another module, procedure, function, file or whatever to the analysis
		 */
		ModuleDetails add(String nm, String mt, int base)
		{
			ModuleDetails md = new ModuleDetails(nm, mt, base, this);

			moduleDetails.add(md);
			return md;
		}
		/**
		 * Count the token hash map
		 *
		 */
		void countTokenMap()
		{
			Iterator i = tokenMap.values().iterator();

			while (i.hasNext())
			{
				TokenDetails td = (TokenDetails) i.next();

				if (td.operandCnt > 0)
				{
					this.distinctOperands++;
					this.totalOperands += td.operandCnt;
				}
				if (td.operatorCnt > 0)
				{
					this.distinctOperators++;
					this.totalOperators += td.operatorCnt;
				}
			}
			return;
		}
		/**
		 * Process the module tree depth first, dumping out the metrics for each
		 * element.
		 */
		void processTree(int depth)
		{
			ModuleDetails md;

			/*
			 * Compute metrics that are derived from values solely belonging to this
			 * this particular module
			 */
			countTokenMap();
			computeHalstead();
			if (cyclomatic == 0)
				cyclomatic = 1;
			/*
			 * Add in contributions from any children 
			 */
			for (int i = 0; i < moduleDetails.size(); i++)
			{
				md = moduleDetails.get(i);
				md.processTree(depth + 1);
				this.blankLines += md.blankLines;
				md.blankLines = 0;
				this.sourceLines += md.sourceLines;
				md.sourceLines = 0;
				this.commentLines += md.commentLines;
				md.commentLines = 0;
				this.statementCnt += md.statementCnt;
				md.statementCnt = 0;
				this.commentCnt += md.commentCnt;
				md.commentCnt = 0;
				this.distinctOperands += md.distinctOperands;
				md.distinctOperands = 0;
				this.totalOperands += md.totalOperands;
				md.totalOperands = 0;
				this.distinctOperators += md.distinctOperators;
				md.distinctOperators = 0;
				this.totalOperators += md.totalOperators;
				md.totalOperators = 0;
				this.volume += md.volume;
				md.volume = 0;
				this.effort += md.effort;
				md.volume = 0;
				this.difficulty += md.difficulty;
				md.difficulty = 0;
				this.cyclomatic += md.cyclomatic;
				md.cyclomatic = 0;
				this.moduleCnt += md.moduleCnt;
				md.moduleCnt = 0;
				//Ozan
				this.conditionCount += md.conditionCount;
				md.conditionCount = 0;
				this.decisionCount += md.decisionCount;
				md.decisionCount = 0;
				this.branchCount += md.branchCount;
				md.branchCount = 0;
				this.unstructuredElement += md.unstructuredElement;
				md.unstructuredElement = 0;
				//Ozan
			}
			/*
			 * Compute metrics that are derived from rolled up values.
			 */
			calculateMI();

			/*
			 * StringBuilder sb = new StringBuilder(depth);
			 *
			 * for (int i = 0; i < depth; i++)
			 *      sb.append(' ');
			 *  System.out.println( sb + this.toString());
			 */
			if(PLSqlConstants.printScreen)
				System.out.println( "depth: "+ depth + " " + this.toString());
			addToContainer(depth,this);
		}
		
		/**
		 * String-ify all the interesting members
		 */
		public String toString()
		{

			return "type: " + moduleType + " name: " + name +
			" blankLines: " + blankLines +
			" sourceLines: " + sourceLines +
			" commentLines: " + commentLines +
			" lastParseLine: " + lastParseLine +
			" statementCnt: " + statementCnt +
			" commentCnt: " + commentCnt +
			" distinctOperands: " + distinctOperands +
			" totalOperands: " + totalOperands +
			" distinctOperators: " + distinctOperators +
			" totalOperators: " + totalOperators +
			" programLength: " + programLength +
			" vocabulary: " + vocabulary +
			" volume: " + volume +
			" difficulty: " + difficulty +
			" effort: " + effort +
			" cyclomatic: " + cyclomatic +
			" moduleCnt: " + moduleCnt +
			" maintainabilityIndex: " + maintainabilityIndex +
			" maintainabilityIndexNC: " + maintainabilityIndexNC +
			//ozan
			/*
			 * int conditionCount;
				int decisionCount;
				int branchCount;
			 */
			" conditionCount: " + conditionCount +
			" decisionCount: " + decisionCount +
			" branchCount: " + branchCount +
			" essential complexity: " + unstructuredElement;
			//ozan

			/*return '|' + moduleType + '|' + name +
			'|' + blankLines +
			'|' + sourceLines +
			'|' + commentLines +
			'|' + lastParseLine +
			'|' + statementCnt +
			'|' + commentCnt +
			'|' + distinctOperands +
			'|' + totalOperands +
			'|' + distinctOperators +
			'|' + totalOperators +
			'|' + programLength +
			'|' + vocabulary +
			'|' + volume +
			'|' + difficulty +
			'|' + effort +
			'|' + cyclomatic +
			'|' + moduleCnt +
			'|' + maintainabilityIndex +
			'|' + maintainabilityIndexNC;*/
		}
	}  /* End of Module Details */
	/**
	 * SoftwareMetrics itself. We want to have a single instance that potentially
	 * owns everything from runs of multiple parser incarnations over multiple
	 * source files.
	 *
	 * We restrict ourselves to a single language at a time.
	 *
	 * The public methods are all static:
	 * -  start(String moduleName, String moduleType, int lineNo);
	 * -  adjustMetrics(String token, int opFlag, int lineNo);
	 * -  adjustMetrics(String token, int lineNo);
	 * -  incComments(int count);
	 * -  incBlanks(int count);
	 * -  incStatements();
	 * -  finish();
	 * -  finishAll();
	 * Calling anything other than start() to begin with will give a
	 * Null Pointer Exception.
	 */
	private ModuleDetails rootModuleDetails;
	private ModuleDetails activeModuleDetails;
	private static HashMap<String,TokenRules> ruleMap = new HashMap<String,TokenRules>(1024);
	private volatile static SoftwareMetrics uniqueInstance;
	/**
	 * Private constructor, only called from getInstance()
	 */
	private SoftwareMetrics(String name, String mt, int lineNo )
	{
		rootModuleDetails = new ModuleDetails(name, mt, lineNo, null);
		activeModuleDetails = rootModuleDetails;
	}
	/**
	 * Singleton Method
	 */
	private static SoftwareMetrics getInstance(String nm, String mt, int lineNo)
	{
		if (uniqueInstance == null)
		{
			synchronized (SoftwareMetrics.class)
			{
				if (uniqueInstance == null)
					uniqueInstance = new SoftwareMetrics(nm, mt, lineNo);
			}
		}
		return uniqueInstance;
	}
	/**********************************************************************
	 *  start(String moduleName, String moduleType, int lineNo) - start
	 *  collecting data on a module.
	 */
	public static void start(String nm, String mt, int lineNo)
	{
		SoftwareMetrics sm = getInstance(nm,mt, lineNo);

		/*
		 * If we haven't just created the singleton, we need to add ourself
		 */
		if (!sm.rootModuleDetails.name.equals(nm)
				||!sm.rootModuleDetails.moduleType.equals(mt))
			sm.activeModuleDetails = sm.activeModuleDetails.add(nm,mt,lineNo);
		return;
	}
	/**
	 *  adjustMetrics(String token, int opFlag, int lineNo) - update the metrics
	 *  based on the token reported, using an OPERATOR/OPERAND value presumably
	 *  chosen by the parser.
	 */
	public static void  adjustMetrics(String token, int opFlag, int lineNo)
	{
		if (uniqueInstance != null
				&& uniqueInstance.activeModuleDetails != null)
			uniqueInstance.activeModuleDetails.adjustMetrics(token, opFlag, lineNo);
		return;
	}
	/**
	 *  adjustMetrics(String token, int lineNo) - update the metrics based on the
	 *  any token applicable token rules.
	 */
	public static void  adjustMetrics(String token, int lineNo)
	{
		if (uniqueInstance != null
				&& uniqueInstance.activeModuleDetails != null)
			uniqueInstance.activeModuleDetails.adjustMetrics(token, lineNo);
		return;
	}
	/**
	 * incComments(int count) - increment the count of comments, and the count
	 * of comment lines.
	 */
	public static void incComments(int count)
	{
		if (uniqueInstance != null
				&& uniqueInstance.activeModuleDetails != null)
			uniqueInstance.activeModuleDetails.incComments(count);
		return;
	}
	/**
	 * incBlanks(int count) - increment the count of blank lines
	 */
	public static void  incBlanks(int count)
	{
		if (uniqueInstance != null
				&& uniqueInstance.activeModuleDetails != null)
			uniqueInstance.activeModuleDetails.incBlanks(count);
		return;
	}
	/**
	 * incStatements() - increment the count of actual statements.
	 */
	public static void incStatements()
	{
		if (uniqueInstance != null
				&& uniqueInstance.activeModuleDetails != null)
			uniqueInstance.activeModuleDetails.incStatements();
		return;
	}
	
	/*
	 * int conditionCount;
		int decisionCount;
		int branchCount;
	 */
	//Ozan
	public static void incConditionCount(){
		if (uniqueInstance != null
				&& uniqueInstance.activeModuleDetails != null)
			uniqueInstance.activeModuleDetails.incCondition();
		return;
	}
	public static void incDecisionCount(){
		if (uniqueInstance != null
				&& uniqueInstance.activeModuleDetails != null)
			uniqueInstance.activeModuleDetails.incDecision();
		return;
	}
	public static void incBranchCount(){
		if (uniqueInstance != null
				&& uniqueInstance.activeModuleDetails != null)
			uniqueInstance.activeModuleDetails.incBranch();
		return;
	}
	public static void incUnstructuredElement(){
		if (uniqueInstance != null
				&& uniqueInstance.activeModuleDetails != null)
			uniqueInstance.activeModuleDetails.incUnstructured();
		return;
	}
	//Ozan
	
	/**
	 * finish() - indicate that we have finished with this module. Counting reverts
	 * to its parent. If there is no parent, we have finished, so call finishAll()
	 * to output the details.
	 */
	public static void finish()
	{
		if (uniqueInstance != null)
		{
			if (uniqueInstance.activeModuleDetails != null)
				uniqueInstance.activeModuleDetails
				= uniqueInstance.activeModuleDetails.parentModule;
			if (uniqueInstance.activeModuleDetails == null)
				finishAll();
		}
	}
	/**
	 * finishAll() - Called to dump out the Module tree from its root.
	 */
	public static void finishAll()
	{
		if (uniqueInstance != null && uniqueInstance.rootModuleDetails != null)
			uniqueInstance.rootModuleDetails.processTree(0);
		uniqueInstance = null;     /* Should mean we start over */
	}
	/**
	 * updateRuleMap() - Add or update the rules to follow for a token in the rule
	 *                   map.
	 *
	 * The table is keyed in a case-insensitive manner. However, whether the
	 * the accumulators are case-sensitive or not is a flag.
	 *
	 * It is assumed that there will be no language where distinct language elements
	 * (as opposed to mere variables) will be distinguishable merely on case.
	 */
	private void updateRuleMap(String token, double cycloFactor, int operatorAdjust,
			int operandAdjust, boolean sensitive)
	{
		/**
		 * Have we seen this token before?
		 * -  If not, we place it in the rule hashmap.
		 * -  Otherwise, we over-write the fields
		 */
		TokenRules tokenRule = ruleMap.get(token.toLowerCase());

		if (tokenRule == null)
		{
			tokenRule = new TokenRules(token, cycloFactor, operatorAdjust,
					operandAdjust, sensitive);
			ruleMap.put(token.toLowerCase(), tokenRule);
		}
		else
		{
			tokenRule.cycloFactor = cycloFactor;
			tokenRule.operatorAdjust = operatorAdjust;
			tokenRule.operandAdjust = operandAdjust;
			tokenRule.sensitive = sensitive;
		}
	}
	/**
	 * Public routine for adding rules
	 */
	public static void addRule(String token, double cycloFactor, int operatorAdjust,
			int operandAdjust, boolean sensitive)
	{
		if (uniqueInstance != null)
			uniqueInstance.updateRuleMap(token, cycloFactor, operatorAdjust,
					operandAdjust, sensitive);
	}
	
	public static void addAllStaticRules(){
		SoftwareMetrics.start("Whole", "Run", 0); // Make sure singleton exists
		SoftwareMetrics.addRule("^=", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("<<", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("<", 0.0, 1, 0, false);
		SoftwareMetrics.addRule(">", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("<>", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("=", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("=>", 0.0, 1, 0, false);
		SoftwareMetrics.addRule(">>", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("||", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("?", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("_", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("-", 0.0, 1, 0, false);
		SoftwareMetrics.addRule(",", 0.0, 0, 0, false);
		SoftwareMetrics.addRule(":=", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("!=", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("/", 0.0, 1, 0, false);
		SoftwareMetrics.addRule(".", 0.0, 1, 0, false);
		SoftwareMetrics.addRule(";", 0.0, 0, 0, false);
		SoftwareMetrics.addRule("..", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("(", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("(+)", 0.0, 1, 0, false);
		SoftwareMetrics.addRule(")", 0.0, 0, 0, false);
		SoftwareMetrics.addRule("@", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("*", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("**", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("%", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("+", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("abs", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("accept", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("access", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("add", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("add_months", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("all", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("all_rows", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("alter", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("always", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("analyze", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("analyzed", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("and", 1.0, 1, 0, false);
		SoftwareMetrics.addRule("any", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("archivelog", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("array", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("arraylen", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("as", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("asc", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("ascii", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("assert", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("assign", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("at", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("audit", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("authid", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("authorization", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("autoextend", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("automatic", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("avg", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("backup", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("backups", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("base_table", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("begin", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("between", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("binary_integer", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("blob", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("body", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("boolean", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("both", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("bulk", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("by", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("case", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("cast", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("ceil", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("char", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("character", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("char_base", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("chartorowid", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("check", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("choose", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("chr", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("clob", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("close", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("close_cached_open_cursors", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("cluster", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("clusters", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("colauth", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("collect", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("column", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("columns", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("comment", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("commit", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("commit_point_strength", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("compile", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("compress", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("compute", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("concat", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("connect", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("const", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("constant", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("constraint", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("constraints", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("contains", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("continue", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("convert", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("cos", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("cosh", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("count", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("crash", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("create", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("current", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("currval", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("cursor", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("database", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("data_base", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("datafile", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("datafiles", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("date", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("dba", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("'dd'", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("debugoff", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("debugon", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("decimal", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("declare", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("decode", 1.0, 1, 0, false);
		SoftwareMetrics.addRule("default", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("define", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("definition", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("delay", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("delete", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("delta", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("desc", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("describe", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("digits", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("dispose", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("distinct", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("do", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("double", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("drop", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("dual", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("dump", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("each", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("either", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("element", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("else", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("elsif", 1.0, 1, 0, false);
		SoftwareMetrics.addRule("enable", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("end", 0.0, 0, 0, false);
		SoftwareMetrics.addRule("entry", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("error", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("errorstack", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("escape", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("estimate", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("event", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("event#", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("events", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("everything", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("eword", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("except", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("exception", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("exception_init", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("exceptions", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("exclusive", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("exec", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("execute", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("exists", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("exit", 1.0, 1, 0, false);
		SoftwareMetrics.addRule("exp", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("explain", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("extend", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("extends", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("extent", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("extents", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("external", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("externally", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("false", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("fast", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("fatal", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("fetch", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("file", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("filename", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("files", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("filter", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("first", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("flag", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("flagger", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("float", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("floor", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("for", 1.0, 1, 0, false);
		SoftwareMetrics.addRule("forall", 1.0, 1, 0, false);
		SoftwareMetrics.addRule("force", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("foreign", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("forever", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("form", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("found", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("fragment", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("free", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("freelist", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("freelists", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("from", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("full", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("func", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("function", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("general", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("generic", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("get", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("gethitratio", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("gethits", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("getmisses", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("gets", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("glb", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("global", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("goto", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("grant", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("greatest", 1.0, 1, 0, false);
		SoftwareMetrics.addRule("greatest_lb", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("group", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("hash", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("hashed", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("have", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("having", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("hextoraw", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("'hh'", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("'hh24'", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("identified", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("if", 0.5, 1, 0, false);
		SoftwareMetrics.addRule("immediate", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("in", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("increment", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("index", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("indexes", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("indicator", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("initcap", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("initial", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("initrans", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("inner", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("insert", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("instance", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("instr", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("instrb", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("int", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("integer", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("intersect", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("intersection", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("into", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("invalid", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("is", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("isopen", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("java", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("join", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("julian", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("keep", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("kept", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("key", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("kill", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("label", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("language", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("last", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("last_day", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("leading", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("least", 1.0, 1, 0, false);
		SoftwareMetrics.addRule("least_ub", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("left", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("length", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("lengthb", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("level", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("like", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("limited", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("link", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("ln", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("lock", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("log", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("logfile", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("long", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("loop", 0.0, 0, 0, false);
		SoftwareMetrics.addRule("lower", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("lpad", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("ltrim", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("lub", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("matches", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("max", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("maxarchlogs", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("maxdatafiles", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("maxextents", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("maximum", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("maximum_connections", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("maxinstances", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("maxlogfiles", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("maxloghistory", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("maxlogmembers", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("maxsize", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("maxtrans", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("maxvalue", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("max_value", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("member", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("merge", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("merge_aj", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("message", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("'mi'", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("'mm'", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("min", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("minextents", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("minus", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("minvalue", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("min_value", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("mlslabel", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("mod", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("mode", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("modify", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("module", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("'mon'", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("'month'", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("monitor", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("months_between", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("mount", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("name", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("namespace", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("natural", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("nested", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("new", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("new_time", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("next", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("next_day", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("nextval", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("nextvalue", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("nls", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("nlssort", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("noarchivelog", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("noaudit", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("nocache", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("nocompress", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("nocycle", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("no_expand", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("noforce", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("nomaxvalue", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("no_merge", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("nominvalue", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("nomount", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("none", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("noorder", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("nooverride", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("noparallel", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("noparallelism", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("nopreempt", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("noresetlogs", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("noreverse", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("normal", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("nosort", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("not", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("notfound", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("nothing", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("noundo", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("nowait", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("null", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("number", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("number_base", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("numeric", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("num_rows", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("nvl", 1.0, 1, 0, false);
		SoftwareMetrics.addRule("object", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("occurred", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("occurrences", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("of", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("offline", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("on", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("online", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("only", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("open", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("optimizer", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("option", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("options", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("or", 1.0, 1, 0, false);
		SoftwareMetrics.addRule("order", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("others", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("out", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("outer", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("own", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("owned", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("owner", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("package", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("parallel", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("parameter", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("partition", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("partitions", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("path", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("pcm", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("pctfree", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("pctincrease", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("pctused", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("pending", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("percent", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("permanent", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("piece", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("plan", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("positive", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("power", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("pragma", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("precision", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("primary", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("prior", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("priro", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("private", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("privilege", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("priv_number", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("procedure", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("process", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("profile", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("program", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("protocol", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("public", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("query", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("queue", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("queued", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("quit", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("quota", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("raise", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("range", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("raw", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("rawtohex", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("rawtolab", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("rdbms", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("read", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("real", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("reason", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("receive", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("record", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("recover", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("recovery", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("recursive", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("redo", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("ref", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("refresh", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("release", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("remote", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("remote_dependencies_mode", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("remr", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("rename", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("replace", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("reply", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("request", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("resetlogs", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("resource", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("resource_limit", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("restricted", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("resume", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("return", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("returncode", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("reuse", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("reversal", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("reverse", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("revoke", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("right", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("role", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("rollback", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("round", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("row", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("rowcount", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("%rowcount", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("rowidtochar", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("rowlabel", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("row_locking", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("rownum", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("rowtype", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("rpad", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("rtrim", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("run", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("'rr'", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("'rrr'", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("sample", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("save", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("savedata", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("savepoint", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("scan", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("schema", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("score", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("segment", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("select", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("separate", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("sequence", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("serializable", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("server_type", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("service", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("session", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("sessionid", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("sessions", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("set", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("share", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("short", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("show", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("shrink", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("shutdown", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("sign", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("sin", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("sinh", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("size", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("smallint", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("snapshot", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("sort", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("soundex", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("source", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("space", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("split", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("spool", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("sql", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("sqlcode", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("sqlerrm", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("sqrt", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("'ss'", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("start", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("statement", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("statement_id", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("statistic", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("status", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("stddev", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("stop", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("subquery", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("substr", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("substrb", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("subtype", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("sum", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("suspend", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("switch", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("synonym", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("sysdate", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("tabauth", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("table", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("tables", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("tablespace", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("tan", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("tanh", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("task", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("temporary", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("terminate", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("the", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("then", 0.0, 0, 0, false);
		SoftwareMetrics.addRule("these", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("this", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("thread", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("to", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("to_char", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("to_date", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("to_label", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("to_multi_byte", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("to_number", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("to_single_byte", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("trace", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("trailing", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("transaction", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("translate", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("trigger", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("trim", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("true", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("trunc", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("truncate", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("type", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("uid", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("union", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("unique", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("unlimited", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("unsigned", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("until", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("updatable", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("update", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("upper", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("usage", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("use", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("use_anti", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("use_concat", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("used", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("use_hash", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("use_merge", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("use_nl", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("user", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("userenv", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("userid", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("username", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("using", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("validate", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("values", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("varchar", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("varchar2", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("variance", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("varray", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("view", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("views", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("vsize", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("when", 1.0, 1, 0, false);
		SoftwareMetrics.addRule("whenever", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("where", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("while", 1.0, 1, 0, false);
		SoftwareMetrics.addRule("with", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("work", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("write", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("xor", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("'yy'", 0.0, 1, 0, false);
		SoftwareMetrics.addRule("'yyyy'", 0.0, 1, 0, false);
	}
}
