package parser.C.fileops;

import java.util.LinkedList;
import java.util.HashSet;

import parser.C.constants.CConstants;

/**
 * This class is an abstraction for a module (function).
 * It has fields for all the metrics that are currently being used
 * 
 * @author Atac Deniz Oral
 */
public class Module {

	private String name;
	private String file;
	private int startLineNo;
	private int endLineNo;
	private boolean hasBlock;
	private int startBlankLoc;
	private int endBlankLoc;
	private int startCommentLoc;
	private int endCommentLoc;
	private int startCodeCommentLoc;
	private int endCodeCommentLoc;
	private LinkedList<Token> operators;
	private LinkedList<Token> operands;
	// added by ekrem
	private LinkedList<String> calledFunctions;
	private int uniqueOperands;
	private int uniqueOperators;
	private int formalParam;
	private int type;
	private int forCount;
	private int whileCount;
	private int ifCount;
	private int elseCount;
	private int caseCount;
	private int defaultCount;
	private int questionCount;
	private int switchCount;
	private int callCount;
	private int observedDefects;
	private String defectContent;
	/**	The type of the module is unknown */
	public static final int UNKNOWN = 0;
	/**	The module is a function */
	public static final int FUNCTION = 1;
	/**	The module is an external definition */
	public static final int EXTERNALDEFINITION = 2;
	
	/**
	 * Zero argument constructor for this class.
	 * It initializes all fields to 0 and type is set to function.
	 * defectContent is set to "No".
	 */
	public Module() {
		super();
		this.name = "";
		hasBlock = false;
		operators = new LinkedList<Token>();
		operands = new LinkedList<Token>();
		//		 added by ekrem
		calledFunctions = new LinkedList<String>();
		uniqueOperands = 0;
		uniqueOperators = 0;
		type = FUNCTION;
		formalParam = 0;
		forCount = 0;
		whileCount = 0;
		ifCount = 0;
		elseCount = 0;
		caseCount = 0;
		defaultCount = 0;
		questionCount = 0;
		switchCount = 0;
		callCount = 0;
		observedDefects = 0;
		defectContent = "No";
	}

	/**
	 * This constructor initializes all fields to 0 and type is set to function.
	 * defectContent is set to "No".
	 * 
	 * @param name	The name of the module.
	 * @param file	The source file containing the module.
	 */
	public Module(String name, String file) {
		super();
		this.name = name;
		this.file = file;
		hasBlock = false;
		operators = new LinkedList<Token>();
		operands = new LinkedList<Token>();
		// added by ekrem
		calledFunctions = new LinkedList<String>();
		uniqueOperands = 0;
		uniqueOperators = 0;
		type = FUNCTION;
		formalParam = 0;
		forCount = 0;
		whileCount = 0;
		ifCount = 0;
		elseCount = 0;
		caseCount = 0;
		defaultCount = 0;
		questionCount = 0;
		switchCount = 0;
		callCount = 0;
		observedDefects = 0;
		defectContent = "No";
	}

	/**
	 * Getter for the name of the module.
	 * 
	 * @return	The name of the module
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for the name of the module
	 * 
	 * @param name The name to be used for this module
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method can be used for adding operators to the
	 * operator list of this module
	 * 
	 * @param op	token to be added to the operator list of this module
	 */
	public void addOperator(Token op) {
		operators.add(op);
	}
	
	/**
	 * This method can be used to get the number of operators in this module
	 * 
	 * @return	the number of operators in the operator list of this module
	 */
	public int getOperators() {
		return operators.size();
	}
	
	/**
	 * This method can be used for adding operands to the
	 * operand list of this module
	 * 
	 * @param op	token to be added to the operand list of this module
	 */
	public void addOperand(Token op) {
		operands.add(op);
	}
	
	/**
	 * This method can be used to get the number of operands in this module
	 * 
	 * @return	the number of operands in the operand list of this module
	 */
	public int getOperands() {
		return operands.size();
	}
	
	/**
	 * This method can be used to get the total number of lines in this module
	 * 
	 * @return	total number of lines in the module
	 */
	public int getTotalLoc() {
		return endLineNo-startLineNo+1;
	}

	/**
	 * This method can be used for getting the line number on which this
	 * module ends
	 * 
	 * @return the line number on which this module ends
	 */
	public int getEndLineNo() {
		return endLineNo;
	}

	/**
	 * Setter method for the line number on which the module ends
	 * 
	 * @param endLineNo	the line number on which the module ends
	 */
	public void setEndLineNo(int endLineNo) {
		this.endLineNo = endLineNo;
	}

	/**
	 * This method can be used for getting the line number on which this
	 * module starts
	 * 
	 * @return the line number on which this module starts
	 */
	public int getStartLineNo() {
		return startLineNo;
	}

	/**
	 * Setter method for the line number on which the module starts
	 * 
	 * @param startLineNo	the line number on which the module starts
	 */
	public void setStartLineNo(int startLineNo) {
		this.startLineNo = startLineNo;
	}

	/**
	 * This method can be used to determine wheter this module has a block or not.
	 * A module does not have block when there is no {} after its signature
	 * (i.e. it is only the signature for a function)
	 * 
	 * @return	true if the module has a block, false otherwise
	 */
	public boolean isHasBlock() {
		return hasBlock;
	}

	/**
	 * Setter method for wheter this module has a block or not
	 * 
	 * @param hasBlock true if the module has a block, false otherwise
	 */
	public void setHasBlock(boolean hasBlock) {
		this.hasBlock = hasBlock;
	}

	/**
	 * Setter method for how many blank lines of code were found
	 * in the source file containing this module when the module
	 * ended
	 * 
	 * @param endBlankLoc	The number of blank lines of code in the source file
	 * 						when this module ended
	 */
	public void setEndBlankLoc(int endBlankLoc) {
		this.endBlankLoc = endBlankLoc;
	}

	/**
	 * Setter method for how many blank lines of code were found
	 * in the source file containing this module when the module
	 * started
	 * 
	 * @param startBlankLoc	The number of blank lines of code in the source file
	 * 						when this module started
	 */
	public void setStartBlankLoc(int startBlankLoc) {
		this.startBlankLoc = startBlankLoc;
	}
	
	/**
	 * Getter method for the number of blank lines of code in this module
	 * @return	number of blank lines of code in the module
	 */
	public int getBlankLoc() {
		int blankLoc = endBlankLoc - startBlankLoc;
		return blankLoc >= 0 ? blankLoc : 0;
	}

	/**
	 * Getter method for how many lines of code that contain 
	 * both code and comment in the source file containing this module 
	 * when the module ended
	 * 
	 * @param endCodeCommentLoc	The number of lines of code in the source
	 * 							file that contain both comment and code
	 * 							when this module ended
	 */
	public int getEndCodeCommentLoc() {
		return endCodeCommentLoc;
	}

	/**
	 * Getter method for how many lines of code that contain
	 * both code and comment in the source file containing this module 
	 * when the module ended
	 * 
	 * @return	The number of lines of code in the source
	 * 			file that contain both comment and code when this module ended
	 */
	public void setEndCodeCommentLoc(int endCodeCommentLoc) {
		this.endCodeCommentLoc = endCodeCommentLoc;
	}

	/**
	 * Getter method for the number of commented lines of code in the source file
	 * when this module ended
	 * 
	 * @return number of commented lines of code when this module ended
	 */
	public int getEndCommentLoc() {
		return endCommentLoc;
	}

	/**
	 * Setter method for the number of commented lines of code in the source file
	 * when this module ended
	 * 
	 * @param	endCommentLoc the number of commented lines of code in the source file
	 * 			when this module ended
	 */
	public void setEndCommentLoc(int endCommentLoc) {
		this.endCommentLoc = endCommentLoc;
	}

	/**
	 * Getter method for the number of lines that contain both comment and code
	 * in the source file containing this module when this module started
	 * 
	 * @return  number of lines that contain both code and comment when this
	 * 			this module started
	 */
	public int getStartCodeCommentLoc() {
		return startCodeCommentLoc;
	}

	
	/**
	 * Setter method for the number of lines that contain both comment and code
	 * in the source file containing this module when this module started
	 * 
	 * @param startCodeCommentLoc	number of lines that contain both code
	 * 								and comment when this this module started
	 */
	public void setStartCodeCommentLoc(int startCodeCommentLoc) {
		this.startCodeCommentLoc = startCodeCommentLoc;
	}

	/**
	 * Getter method for the number of commented lines of code in the source file
	 * when this module started
	 * 
	 * @return the number of commented lines of code when this module started
	 */
	public int getStartCommentLoc() {
		return startCommentLoc;
	}

	/**
	 * Setter method for the number of commented lines of code in the source file
	 * when this module started
	 * 
	 * @param startCommentLoc	the number of commented lines of
	 * 							code when this module started
	 */
	public void setStartCommentLoc(int startCommentLoc) {
		this.startCommentLoc = startCommentLoc;
	}

	/**
	 * Getter method for the number of blank lines of code found in the source file
	 * when this module ended
	 *  
	 * @return	the number of blank lines of code found in the source file
	 * 			when this module ended
	 */
	public int getEndBlankLoc() {
		return endBlankLoc;
	}

	/**
	 * Getter method for the number of blank lines of code found in the source file
	 * when this module started
	 *  
	 * @return	the number of blank lines of code found in the source file
	 * 			when this module started
	 */
	public int getStartBlankLoc() {
		return startBlankLoc;
	}
	
	/**
	 * This method returns the number of commented lines of code in this module
	 * 
	 * @return number of commented lines of code in this module
	 */
	public int getCommentLoc() {
		return endCommentLoc-startCommentLoc;
	}
	
	/**
	 * This method returns the number of lines that contain both comment
	 * and code in this module
	 * 
	 * @return number of lines that contain both code and comment
	 */
	public int getCodeCommentLoc() {
		return endCodeCommentLoc-startCodeCommentLoc;
	}
	
	/**
	 * This method returns the number of executable lines of code in a module.
	 * These lines contain only code or white space
	 * 
	 * @return number of executable lines of code
	 */
	public int getExecutableLoc() {
		return getTotalLoc() - (getBlankLoc()+getCommentLoc());
	}

	/**
	 * This method can be used for determining the type of this module
	 * 
	 * @return	Module.UNKNOWN if a type has not been set
	 * 			Module.FUNCTION if this module is a function
	 * 			Module.EXTERNALDEFINITION if this module is an external
	 * 			external definition (i.e. starts with the keyword extern)
	 */
	public int getType() {
		return type;
	}

	/**
	 * This method can be used for setting the type of this module
	 * 
	 * @param type	Module.UNKNOWN if the type is unknown
	 * 				Module.FUNCTION if this module is a function
	 * 				Module.EXTERNALDEFINITION if this module is an external
	 * 				external definition (i.e. starts with the keyword extern)
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * This method can be used to determine the number of formal parameters
	 * to this module
	 * 
	 * @return number of formal parameters to this module
	 */
	public int getFormalParam() {
		return formalParam;
	}

	/**
	 * This method can be used to set the number of formal parameters
	 * to this module
	 * 
	 * @param formalParam the number of formal parameters to this module
	 */
	public void setFormalParam(int formalParam) {
		this.formalParam = formalParam;
	}
	
	/**
	 * This method is used to increment the number of 'for' keywords
	 * found in this module
	 */
	public void incrementForCount() {
		forCount++;
	}
	
	/**
	 * This method is used to increment the number of 'while' keywords
	 * found in this module
	 */
	public void incrementWhileCount() {
		whileCount++;
	}
	
	/**
	 * This method is used to increment the number of 'if' keywords
	 * found in this module
	 */
	public void incrementIfCount() {
		ifCount++;
	}
	
	/**
	 * This method is used to increment the number of 'else' keywords
	 * found in this module
	 */
	public void incrementElseCount() {
		elseCount++;
	}
	
	/**
	 * This method is used to increment the number of 'case' keywords
	 * found in this module
	 */
	public void incrementCaseCount() {
		caseCount++;
	}
	
	/**
	 * This method is used to increment the number of 'default' keywords
	 * found in this module
	 */
	public void incrementDefaultCount() {
		defaultCount++;
	}
	
	/**
	 * This method is used to increment the number of '?' keywords
	 * found in this module
	 */
	public void incrementQuestionCount() {
		questionCount++;
	}
	
	/**
	 * This method is used to increment the number of 'switch' keywords
	 * found in this module
	 */
	public void incrementSwitchCount() {
		switchCount++;
	}
	
	/**
	 * This method is used to increment the number of calls to other modules
	 * from this module
	 */
	public void incrementCallCount() {
		callCount++;
	}

	/**
	 * This method is used to add the name of the newly called module
	 * from this module*/
	public void addCalledFunctions(String calledFunctionName){
		calledFunctions.add(calledFunctionName);
	}
	
	/**
	 * This method is used to return the list of the called modules
	 * from this module
	 * added by ekrem
	 */
	public LinkedList<String> getCalledFunctions( ){
		return calledFunctions;
	}
	
	/**
	 * This method can be used to get the number of functions called from this module
	 * 
	 * @return	the number of functions in the calledFunctions list of this module
	 */
	public int getCalledFunctionCount() {
		return calledFunctions.size();
	}
	
	/**
	 * This method can be used to determine the number of decision points in this
	 * module
	 * 
	 * @return the number of decision points
	 */
	public int getDecisionCount() {
		return (forCount+whileCount+ifCount+elseCount+caseCount+defaultCount+questionCount);
	}
	
	/**
	 * This method can be used to determine the number of branches in this
	 * module
	 * 
	 * @return the number of branches
	 */
	public int getBranchCount() {
		return 2*getDecisionCount();
	}
	
	/**
	 * This method can be used to determine the number of conditions in this
	 * module
	 * 
	 * @return the number conditions
	 */
	public int getConditionCount() {
		return (ifCount+elseCount+caseCount+defaultCount);
	}
	
	/**
	 * This method can be used to determine the number of multiple conditions
	 * in this module
	 * 
	 * @return the number multiple conditions
	 */
	public int getMultipleConditionCount() {
		return (elseCount+switchCount);
	}
	
	/**
	 * This method can be used to determine the cyclomatic complexity of this
	 * module
	 * 
	 * @return cyclomatic complexity number
	 */
	public int getCyclomaticComplexity() {
		return (ifCount+forCount+whileCount+(caseCount+defaultCount-2*switchCount)+questionCount)+1;
	}
	
	/**
	 * This method can be used to determine the number of unique operands
	 * in this module
	 * 
	 * @return the number of unique operands
	 */
	public int getUniqueOperands() {
		if(uniqueOperands == 0) {
			HashSet<String> unique = new HashSet<String>();
			java.util.Iterator<Token> itr = operands.iterator();
			while(itr.hasNext()) {
				String current = itr.next().getActual();
				if( !(unique.contains(current)) )
					unique.add(current);
			}
			return uniqueOperands = unique.size();
		}else {
			return uniqueOperands;
		}
	}
	
	/**
	 * This method can be used to determine the number of unique operators
	 * in this module
	 * 
	 * @return the number of unique operators
	 */
	public int getUniqueOperators() {
		if(uniqueOperators == 0) {
			HashSet<String> unique = new HashSet<String>();
			java.util.Iterator<Token> itr = operators.iterator();
			while(itr.hasNext()) {
				String current = itr.next().getActual();
				if( !(unique.contains(current)) )
					unique.add(current);
			}
			return uniqueOperators = unique.size();
		}else {
			return uniqueOperators;
		}
	}
	
	/**
	 * Getter method for Halstead vocabulary
	 * 
	 * @return the Halstead vocabulary
	 */
	public int getHalsteadVocabulary() {
		return getUniqueOperands() + getUniqueOperators();
	}
	
	/**
	 * Getter method for Halstead length
	 * 
	 * @return the Halstead length
	 */
	public int getHalsteadLength() {
		return getOperands() + getOperators();
	}
	
	/**
	 * Getter method for Halstead volume
	 * 
	 * @return the Halstead volume
	 */
	public int getHalsteadVolume() {
		if(getHalsteadVocabulary() > 0)
			return (int)(getHalsteadLength()*Math.log(getHalsteadVocabulary()));
		else
			return 0;
	}
	
	/**
	 * Getter method for Halstead potential volume
	 * 
	 * @return the Halstead potential volume
	 */
	public double getHalsteadPotentialVolume() {
		double denominator = uniqueOperators*operands.size();
		if( denominator != 0 )
			return round(((2*getUniqueOperands())/denominator)*getHalsteadVolume());
		else
			return 0;
	}
	
	/**
	 * Getter method for Halstead level
	 * 
	 * @return the Halstead level
	 */
	public double getHalsteadLevel() {
		double volume = getHalsteadVolume();
		if(volume != 0)
			return round(getHalsteadPotentialVolume()/volume);
		else
			return 0;
	}
	
	/**
	 * Getter method for Halstead difficulty
	 * 
	 * @return the Halstead difficulty
	 */
	public double getHalsteadDifficulty() {
		double level = getHalsteadLevel();
		if(level != 0)
			return round(1/level);
		else
			return 0;
	}
	
	/**
	 * Getter method for Halstead effort
	 * 
	 * @return the Halstead effort
	 */
	public double getHalsteadEffort() {
		double level = getHalsteadLevel();
		if(level != 0)
			return round(getHalsteadVolume()/level);
		else
			return 0;
	}
	
	/**
	 * Getter method for Halstead error
	 * 
	 * @return the Halstead error
	 */
	public double getHalsteadError() {
		return round(((double)getHalsteadVolume()/3000));
	}
	
	/**
	 * Getter method for Halstead time
	 * 
	 * @return the Halstead time
	 */
	public double getHalsteadTime() {
		return round(getHalsteadEffort()/18);
	}
	
	/**
	 * This method can be used to determine the cyclomatic density of this
	 * module
	 * 
	 * @return the cyclomatic density of this module
	 */
	public double getCyclomaticDensity() {
		int exec = this.getExecutableLoc();
		if(exec != 0) {
			return round(((double)getCyclomaticComplexity())/exec);
		}else
			return 0;
	}
	
	/**
	 * This method can be used to determine the decision density of this
	 * module
	 * 
	 * @return the decision density of this module
	 */
	public double getDecisionDensity() {
		if(getConditionCount() != 0)
			return round(((double)(getDecisionCount()))/getConditionCount());
		else
			return 0;
	}
	
	/**
	 * This method is used to determine the number of calls to other modules
	 * from this module
	 * 
	 * @return number of calls to other modules
	 */
	public int getCallCount() {
		return callCount;
	}
	
	/**
	 * This method can be used to determine the design complexity of this
	 * module
	 * 
	 * @return the design complexity of this module
	 */
	public int getDesignComplexity() {
		return getCallCount();
	}
	
	/**
	 * This method can be used to determine the design density of this
	 * module
	 * 
	 * @return the design density of this module
	 */
	public double getDesignDensity() {
		double design = getDesignComplexity(); 
		if(design != 0)
			return round(design/getCyclomaticComplexity());
		else
			return 0;
	}
	
	/**
	 * This method can be used to determine the normalized cyclomatic
	 * complexity of this module
	 * 
	 * @return the normalized cyclomatic complexity
	 */
	public double getNormalizedCyclomaticComplexity() {
		double loc = getTotalLoc(); 
		if(loc != 0)
			return round(getCyclomaticComplexity()/loc);
		else
			return 0;
	}

	/**
	 * This method can be used to determine the number of occurences of the
	 * 'case' keyword in this module
	 * 
	 * @return number of occurences of the 'case' keyword
	 */
	public int getCaseCount() {
		return caseCount;
	}

	/**
	 * This method can be used to set the number of occurences of the
	 * 'case' keyword in this module
	 * 
	 * @param caseCount number of occurences of the 'case' keyword
	 */
	public void setCaseCount(int caseCount) {
		this.caseCount = caseCount;
	}

	/**
	 * This method can be used to determine the number of occurences of the
	 * 'default' keyword in this module
	 * 
	 * @return number of occurences of the 'default' keyword
	 */
	public int getDefaultCount() {
		return defaultCount;
	}

	/**
	 * This method can be used to set the number of occurences of the
	 * 'default' keyword in this module
	 * 
	 * @param defaultCount number of occurences of the 'default' keyword
	 */
	public void setDefaultCount(int defaultCount) {
		this.defaultCount = defaultCount;
	}

	/**
	 * This method can be used to determine the number of occurences of the
	 * 'else' keyword in this module
	 * 
	 * @return number of occurences of the 'else' keyword
	 */
	public int getElseCount() {
		return elseCount;
	}

	/**
	 * This method can be used to set the number of occurences of the
	 * 'else' keyword in this module
	 * 
	 * @param elseCount number of occurences of the 'else' keyword
	 */
	public void setElseCount(int elseCount) {
		this.elseCount = elseCount;
	}

	/**
	 * This method can be used to determine the number of occurences of the
	 * 'for' keyword in this module
	 * 
	 * @return number of occurences of the 'for' keyword
	 */
	public int getForCount() {
		return forCount;
	}

	/**
	 * This method can be used to set the number of occurences of the
	 * 'for' keyword in this module
	 * 
	 * @param forCount number of occurences of the 'for' keyword
	 */
	public void setForCount(int forCount) {
		this.forCount = forCount;
	}

	/**
	 * This method can be used to determine the number of occurences of the
	 * 'if' keyword in this module
	 * 
	 * @return number of occurences of the 'if' keyword
	 */
	public int getIfCount() {
		return ifCount;
	}

	/**
	 * This method can be used to set the number of occurences of the
	 * 'if' keyword in this module
	 * 
	 * @param ifCount number of occurences of the 'if' keyword
	 */
	public void setIfCount(int ifCount) {
		this.ifCount = ifCount;
	}

	/**
	 * This method can be used to determine the number of occurences of the
	 * '?' keyword in this module
	 * 
	 * @return number of occurences of the '?' keyword
	 */
	public int getQuestionCount() {
		return questionCount;
	}

	/**
	 * This method can be used to set the number of occurences of the
	 * '?' keyword in this module
	 * 
	 * @param questionCount number of occurences of the '?' keyword
	 */
	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}

	/**
	 * This method can be used to determine the number of occurences of the
	 * 'switch' keyword in this module
	 * 
	 * @return number of occurences of the 'switch' keyword
	 */
	public int getSwitchCount() {
		return switchCount;
	}

	/**
	 * This method can be used to set the number of occurences of the
	 * 'switch' keyword in this module
	 * 
	 * @param switchCount number of occurences of the 'switch' keyword
	 */
	public void setSwitchCount(int switchCount) {
		this.switchCount = switchCount;
	}

	/**
	 * This method can be used to determine the number of occurences of the
	 * 'while' keyword in this module
	 * 
	 * @return number of occurences of the 'while' keyword
	 */
	public int getWhileCount() {
		return whileCount;
	}

	/**
	 * This method can be used to set the number of occurences of the
	 * 'while' keyword in this module
	 * 
	 * @param whileCount number of occurences of the 'while' keyword
	 */
	public void setWhileCount(int whileCount) {
		this.whileCount = whileCount;
	}

	/**
	 * This method can be used to determine the name of the file
	 * that contains this module
	 * 
	 * @return the name of the file that contains this module
	 */
	public String getFile() {
		return file;
	}

	/**
	 * This method can be used to set the name of the file
	 * that contains this module
	 * 
	 * @param file the name of the file that contains this module
	 */
	public void setFile(String file) {
		this.file = file;
	}
	
	/**
	 * This method can be used to determine the number of observed defects
	 * in this module
	 * 
	 * @return the number of observed defects in this module
	 */
	public int getObservedDefects() {
		return observedDefects;
	}

	/**
	 * This method can be used to set the number of observed defects
	 * in this module
	 * 
	 * @param observedDefects the number of observed defects in this module
	 */
	public void setObservedDefects(int observedDefects) {
		this.observedDefects = observedDefects;
	}

	/**
	 * This method can be used to determine whether there are defects
	 * in this module or not
	 * 
	 * @return "Yes" or "No"
	 */
	public String getDefectContent() {
		return defectContent;
	}

	/**
	 * This method can be used to set whether there are defects
	 * in this module or not
	 * 
	 * @param defectContent "Yes" or "No"
	 */
	public void setDefectContent(String defectContent) {
		this.defectContent = defectContent;
	}

	/**
	 * This method can be used to get all metrics of this module
	 * (currently 29) as a String array
	 * 
	 * @return a String[] containing the metrics of this module
	 */
	public String[] getAllMetrics() {
		String[] metrics = new String[CConstants.MAX_COLUMNS];
		metrics[0] = getTotalLoc()+"";
		metrics[1] = getBlankLoc()+"";
		metrics[2] = getCommentLoc()+"";
		metrics[3] = getCodeCommentLoc()+"";
		metrics[4] = getExecutableLoc()+"";
		metrics[5] = getUniqueOperands()+"";
		metrics[6] = getUniqueOperators()+"";
		metrics[7] = getOperands()+"";
		metrics[8] = getOperators()+"";
		metrics[9] = getHalsteadVocabulary()+"";
		metrics[10] = getHalsteadLength()+"";
		metrics[11] = getHalsteadVolume()+"";
		metrics[12] = getHalsteadLevel()+"";
		metrics[13] = getHalsteadDifficulty()+"";
		metrics[14] = getHalsteadEffort()+"";
		metrics[15] = getHalsteadError()+"";
		metrics[16] = getHalsteadTime()+"";
		metrics[17] = getBranchCount()+"";
		metrics[18] = getDecisionCount()+"";
		metrics[19] = getCallCount()+"";
		metrics[20] = getConditionCount()+"";
		metrics[21] = getMultipleConditionCount()+"";
		metrics[22] = getCyclomaticComplexity()+"";
		metrics[23] = getCyclomaticDensity()+"";
		metrics[24] = getDecisionDensity()+"";
		metrics[25] = getDesignComplexity()+"";
		metrics[26] = getDesignDensity()+"";
		metrics[27] = getNormalizedCyclomaticComplexity()+"";
		metrics[28] = getFormalParam()+"";
		return metrics;
	}
	
	/**
	 * A utility method for rounding a double.
	 * Current version leaves two digits after the decimal point
	 * 
	 * @param	d the number to be rounded
	 * @return	the resulting (rounded) number
	 */
	public double round(double d) {
		double result = 0;
		result = 100*d;
		long temp = Math.round(result);
		if(temp != 0)
			return ((double)temp)/100;
		else
			return 0;
	}
	
}
