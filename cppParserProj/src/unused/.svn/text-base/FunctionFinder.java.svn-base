package unused;

import java.util.ArrayList;
import java.util.List;

import cppParser.FunctionAnalyzer;
import cppParser.ParsedObjectManager;
import cppParser.utils.StringTools;
import cppStructures.CppFunc;

/**
 * 
 * @author Tomi
 */
public class FunctionFinder
{
	/**
	 * Different modes RESET When currently analyzed part of sentence is
	 * definetly not a function call this mode is set. Mode is changed back to
	 * BEGIN once right kind of token has been processed BEGIN This is the
	 * default mode which expects the tokens to contain a function name or owner
	 * of a function eg Owner::func(); It switches to RESET or PARAMETERS
	 * depending on the tokens PARAMETERS This mode expects the tokens to
	 * contain parameters that are given to the function call. ANOTHER This mode
	 * comes after closing parenthesis of a function call. It waits for another
	 * function call eg getMyObj()->getName(); The new function call will get
	 * the previous function call to be it's owner.
	 */
	public static final int RESET = 0, BEGIN = 1, PARAMETERS = 2, ANOTHER = 3;
	private int mode = BEGIN;
	private String token, next;
	private boolean parameter = false; // Are the tokens given to the
										// FunctionFinder parameters for
										// function call?
	// When function calls are parsed recursively(function call as parameter)
	// all tokens must be also collected in this list
	private List<ParameterToken> currentParameter = new ArrayList<>();

	private int parenthesisDepth = 0; // used for finding parameters

	private int index, skip = 0;
	private List<ParameterToken> owners = new ArrayList<>();
	private List<String> parameterTokens = new ArrayList<>();

	private String currentOwner = "";
	private FunctionCall currentFc;
	private FunctionAnalyzer functionAnalyzer;
	private VarFinder varFinder;
	private CppFunc func;

	private int paramIndex = 0;
	private int tempParamIndex = 0;
	private List<Integer> handledIndices = new ArrayList<>();

	public FunctionFinder(FunctionAnalyzer functionAnalyzer,
			VarFinder varFinder, CppFunc currentFunc)
	{
		this.functionAnalyzer = functionAnalyzer;
		this.varFinder = varFinder;
		this.func = currentFunc;
	}

	/**
	 * This constructor should be used only by recursive function call search
	 * 
	 * @param f
	 * @param varFinder
	 * @param currentFunc
	 */
	private FunctionFinder(FunctionAnalyzer functionAnalyzer,
			VarFinder varFinder, CppFunc currentFunc, int paramIndex)
	{
		this.functionAnalyzer = functionAnalyzer;
		this.varFinder = varFinder;
		this.func = currentFunc;
		parameter = true;
		this.paramIndex = paramIndex;
		// Log.d("parameters start at token "+getIndex() );

	}

	/**
	 * Method converts the string to StringToken and puts it to currentParameter
	 * List if parameter==true
	 * 
	 * @param token
	 */
	private void addToken(String token)
	{
		if (parameter)
		{
			currentParameter.add(new StringToken(token));
		}
	}

	private void addToken(ParameterToken token)
	{
		if (parameter)
		{
			currentParameter.add(token);
		}
	}

	private List<ParameterToken> getCurrentParameter()
	{
		if (currentParameter == null)
		{
			throw new NullPointerException();
		}
		return currentParameter;
	}

	/**
	 * This method searches the given tokens and looks for function calls in
	 * them. Function calls are built one by one using pushTokens()
	 * 
	 * @param tokens
	 */
	public void findFunctions(String[] tokens)
	{
		for (index = 0; tokens.length > index; index++)
		{
			token = tokens[index];
			if (tokens.length > (index + 1))
			{
				next = tokens[index + 1];
			}
			else
			{
				next = null;
			}
			pushTokens(token, next);
		}
		// Log.d("Cleared ind1");
		handledIndices.clear();

	}

	/**
	 * returns index of current token that is pushed with pushToken()
	 * 
	 * @return
	 */
	public final int getIndex()
	{
		return index + paramIndex;
	}

	private void markIndex(int index)
	{
		// Log.d("Marked "+tokens[index] +" "+index);
		if (index < 0)
		{
			throw new Error("Negative index:" + token + " " + next);
		}

		if (handledIndices.isEmpty())
		{
			handledIndices.add(new Integer(index));
		}
		else if (handledIndices.get(handledIndices.size() - 1) != index)
		{
			handledIndices.add(new Integer(index));
		}
	}

	/**
	 * pushTokens decides what to do with the next token that is received. It
	 * directs it to correct place depending on if the tokens form function
	 * calls
	 * 
	 * @param token
	 *            current token
	 * @param next
	 *            next token in the source to allow "peeking"
	 */
	private void pushTokens(String token, String next)
	{
		// Log.d("t: "+token+" "+next+" "+mode);
		if (skip > 0)
		{
			skip--;
			if (parameter)
			{
				index++;
			}
			return;
		}
		// if(parameter) Log.d("PT: "+token+" "+next+" "+ mode);
		switch (mode)
		{
		case BEGIN:
			FunctionCall fc = lookForFirstPart(token, next);
			if (fc != null)
			{
				currentFc = fc;
			}
			break;
		case PARAMETERS:
			parseParameters(token, next);
			break;
		case RESET:
			checkForReset(token, next);
			break;
		case ANOTHER:
			waitForAnotherFunctionCall(token, next);
		}
		if (parameter)
		{
			index++;
		}
	}

	private void skip()
	{
		skip++;
	}

	/**
	 * This method looks for the first part of the function call which should
	 * contain owners of the function and the name. Finally it checks if there
	 * is a ( token and switches mode to parameter to allow pushTokens() to form
	 * parameters. If there is no ( token mode is set to reset and tell
	 * pushTokens() to wait for tokens that tell if new function call can be
	 * parsed.
	 * 
	 * @param token
	 * @param next
	 * @return FunctionCall object that contains name and owners but no
	 *         parameters
	 */
	private FunctionCall lookForFirstPart(String token, String next)
	{
		if (next == null)
		{
			addToken(token);
			reset();
			return null;
		}
		if (token.contentEquals(";") || token.contentEquals("return"))
		{
			addToken(token);
			reset();
			return null;
		}
		else
		{
			if (Constants.isWordToken(token))
			{
				if (Constants.isKeyword(token))
				{
					mode = RESET;
					addToken(token);
					return null;
				}
				String temp = null;
				switch (next)
				{
				case "::":
				case ".":
				case "->":
					temp = next;
					skip();
					break;
				case "(":
					mode = PARAMETERS;
					skip();
					tempParamIndex = getIndex() + 2;
					break;
				case "*":
					markIndex(getIndex() + 1);
					break;
				default:
					mode = RESET;
					return null;
				}
				// If (-token to is found (and therefor mode=PARAMETERS) then
				// FunctionCall object is created
				// It will contain all owners that were found and stored in
				// owners.
				if (mode == PARAMETERS)
				{
					if (temp != null)
					{
						owners.add(new StringToken(temp));
					}
					// FunctionCall is created here. It does not contain
					// parameters yet.
					// Log.d("index:"+index+" "+getIndex()+" "+paramIndex);
					markIndex(getIndex());
					FunctionCall fc = new FunctionCall(owners, token);
					// Log.d("Found fc:"+token+" parsing params...");
					return fc;
				}
				else
				{
					currentOwner += token;
					if (temp != null)
					{
						owners.add(new StringToken(currentOwner));
						owners.add(new StringToken(temp));
						currentOwner = "";

					}
				}

			}
			else if (token.contentEquals("*"))
			{
				currentOwner += token;

			}
			return null;
		}
	}

	/**
	 * This method resets FunctionFinder to allow collecting tokens for a new
	 * function call
	 */
	private void reset()
	{
		mode = BEGIN;
		owners = new ArrayList<>();
		parameterTokens = new ArrayList<>();
		currentOwner = "";
		parenthesisDepth = 0;
		skip = 0;
		currentFc = null;
		// if(!parameter)
		handledIndices.clear();
		// Log.d("Cleared ind2");

	}

	/**
	 * This method parses parameters that the function call has. Tokens are
	 * collected to a list and once ,-token is found the list is sent to
	 * parseParameter(List<String> tokens) which takes a closet look at the
	 * tokens.
	 * 
	 * @param token
	 * @param next
	 */
	private void parseParameters(String token, String next)
	{
		switch (token)
		{
		case ")":
			if (parenthesisDepth == 0)
			{
				currentFc.parameters.add(parseParameter(parameterTokens,
						tempParamIndex));
				// checkDependencies(currentFc.owners); //No time for proper
				// implementation
				if (next == null)
				{
					addToken(new FunctionCallToken(currentFc));
				}
				mode = ANOTHER;
			}
			else
			{
				parenthesisDepth--;
				parameterTokens.add(token);
			}
			break;
		case "(":
			parenthesisDepth++;
			parameterTokens.add(token);
			break;
		case ",":
			if (parenthesisDepth == 0)
			{
				currentFc.parameters.add(parseParameter(parameterTokens,
						tempParamIndex));
			}
			tempParamIndex = getIndex() + 1;
			break;
		default:
			parameterTokens.add(token);
		}
	}

	/**
	 * This method takes tokens which form one parameter of a function call.
	 * Tokens are checked if they form function calls which are then parsed
	 * recursively. Tokens are sent to another FunctionFinder. Special
	 * constructor is called which is only used by this method. It tells the
	 * FunctionFinder to keep all in currentParameters ArrayList.
	 * 
	 * @param tokens
	 * @return
	 */
	private List<ParameterToken> parseParameter(List<String> tokens,
			int paramIndex)
	{
		FunctionFinder ff = new FunctionFinder(functionAnalyzer, varFinder,
				func, paramIndex);

		for (int i = 0; i < tokens.size(); i++)
		{
			String currentToken = tokens.get(i);
			String nextToken;
			if (i == (tokens.size() - 1))
			{
				nextToken = null;
			}
			else
			{
				nextToken = tokens.get(i + 1);
			}
			ff.pushTokens(currentToken, nextToken);
		}
		handledIndices.addAll(ff.getIndices());
		return ff.getCurrentParameter();

	}

	/**
	 * This looks at the given token and resets FunctionFinder if the token can
	 * be followed by a function call.
	 * 
	 * @param token
	 * @param next
	 */
	private void checkForReset(String token, String next)
	{
		addToken(token);
		if (StringTools.isOperator(token))
		{
			reset();
		}
	}

	/**
	 * Function call can be followed by another function call. eg
	 * hello()->hello() This method adds the previously found function call as
	 * the owner of the next function call
	 * 
	 * @param token
	 * @param next
	 */
	private void waitForAnotherFunctionCall(String token, String next)
	{
		switch (token)
		{
		case "->":
		case ".":
		case "::":
			FunctionCall temp = currentFc;
			resetWithoutClearingIndices();
			owners.addAll(temp.owners);
			owners.add(new FunctionCallToken(temp));
			owners.add(new StringToken(token));
			break;
		default:
			if ((currentFc != null) && !parameter)
			{
				foundFunctionCall(currentFc);
			}
			addToken(token);
			reset();
		}
	}

	/**
	 * When a function call is found this method is called. If the found
	 * function call is an owner or parameter of another function call then this
	 * method should not be called Example: ownerFunc()->myFunc(paramFunc());
	 * 
	 * In above example foundFunctionCall should only be called with
	 * FunctionCall fc where fc.
	 * 
	 * @param fc
	 *            FunctionCall that is neither owner or parameter of another
	 *            function call
	 */
	private void foundFunctionCall(FunctionCall fc)
	{
		// Checking owners for function calls
		List<FunctionCall> listOfFunctionCalls = new ArrayList<>();
		List<FunctionCall> ownerFcs = getFunctionCallOwners(fc);
		for (FunctionCall f : ownerFcs)
		{
			if (f != null)
			{
				listOfFunctionCalls.add(f);
				listOfFunctionCalls.addAll(getParameterFunctionCalls(f));
			}
		}
		listOfFunctionCalls.add(fc);
		listOfFunctionCalls.addAll(getParameterFunctionCalls(fc));
		for (FunctionCall f : listOfFunctionCalls)
		{

			// Log.d("Found FC: "+f.toString());
			// String str="";

			// Log.d("indices "+str);
			ParsedObjectManager.getInstance().currentFunc.addOperand(f.name);
		}
		for (Integer i : handledIndices)
		{
			// Log.d("reported index "+i.intValue()+" "+ tokens[i.intValue()]);
			functionAnalyzer.storeHandledIndex(i);

		}
	}

	/**
	 * This method returns list of FunctionCalls that are owners of a given
	 * FunctionCall
	 * 
	 * @param fc
	 * @return
	 */
	private List<FunctionCall> getFunctionCallOwners(FunctionCall fc)
	{
		List<FunctionCall> ownerFcs = new ArrayList<>();
		for (ParameterToken pt : fc.owners)
		{
			if (pt instanceof FunctionCallToken)
			{
				ownerFcs.add(((FunctionCallToken) pt).functionCall);
			}
			else
			{
				switch (pt.toString())
				{
				case "::":
				case "->":
				case ".":

					ParsedObjectManager.getInstance().currentFunc
							.addOperator(pt.toString());
					break;
				default:
					// Add owner to halstead calculations
				}

			}

		}
		return ownerFcs;
	}

	/**
	 * This method goes through given FunctionCall and returns all function
	 * calls that are in the parameters. Function calls are searched
	 * recursively, so the list will include
	 * 
	 * @param fc
	 * @return list of parameter function calls.
	 */
	private List<FunctionCall> getParameterFunctionCalls(FunctionCall fc)
	{
		List<FunctionCall> parameterFcs = new ArrayList<>();

		if (fc.parameters == null)
		{
			throw new NullPointerException("Null params");
		}
		for (List<ParameterToken> ptl : fc.parameters)
		{
			for (ParameterToken pt : ptl)
			{
				// Log.d("Pt: "+pt.toString());
				if (pt instanceof FunctionCallToken)
				{
					// Log.d("FCT");
					parameterFcs.add(((FunctionCallToken) pt).functionCall);
					parameterFcs
							.addAll(getParameterFunctionCalls(((FunctionCallToken) pt).functionCall));
				}
			}
		}
		return parameterFcs;
	}

	private void resetWithoutClearingIndices()
	{
		mode = BEGIN;
		owners = new ArrayList<>();
		parameterTokens = new ArrayList<>();
		currentOwner = "";
		parenthesisDepth = 0;
		skip = 0;
		currentFc = null;
	}

	private List<Integer> getIndices()
	{
		return handledIndices;
	}

}
