package unused;

import java.util.ArrayList;

import cppParser.FunctionAnalyzer;
import cppParser.ParsedObjectManager;
import cppParser.utils.Log;
import cppParser.utils.StringTools;
import cppStructures.MemberVariable;

/**
 * This class is responsible for finding variable declarations inside a c++
 * function. Search is done in different modes and once ( or { token is found
 * 
 * @author Tomi
 */
public class VarFinder
{
	private static final boolean silenced = true, showTokens = false;
	private static final String[] delims = { "<", ">" };

	private VarFinder recursive = null;
	private VarFinder parent = null;

	// private boolean isRecursive=false;

	private static final int TYPE = 0, NAME = 1, ARRAY = 2, EQUALS = 3,
			RESET = 4, TEMPLATE = 5;
	private boolean foundStringLiteral = false;
	private int mode = TYPE;

	/*
	 * Mode determines how tokens are handled.
	 * 
	 * TYPE(default mode) is used for taking token that define variable type eg
	 * unsigned int or std::string NAME is used to take tokens that tell name of
	 * the variable or variables ARRAY is used to check if the variable is array
	 * or not. RESET is used when it's known that current statement/sentence
	 * will not contain variable declarations. It should switch back to TYPE
	 * when valid declarations can be received eg after ";" token. TEMPLATE
	 * picks template for variable eg std::vector<std::pair<std::string, int>>
	 * values;
	 */
	private boolean primitive = false;

	private String currentType = "", currentName = "", currentArray = "",
			currentTemplate = "", currentPtr = "";
	private int templateDepth = 0;
	private boolean checkForOperator;

	private int i = 0; // Current index in the token array

	private static String[] originalTokens = null;

	private VarFinder arrayVarFinder = null;
	private int arrays = 0; // This is for checking arrays inside arrays
	private String token, next;

	private FunctionAnalyzer functionAnalyzer;

	private static ArrayList<Integer> handledIndices = new ArrayList<>();

	public VarFinder(FunctionAnalyzer fa)
	{
		this.functionAnalyzer = fa;
	}

	/**
	 * Constructor for recursive search of variables
	 * 
	 * @param parent
	 */
	private VarFinder(VarFinder parent)
	{
		this.parent = parent;
		this.functionAnalyzer = parent.functionAnalyzer;
		// isRecursive = true;
	}

	public String[] getOriginalTokens()
	{
		if (parent == null)
		{
			return originalTokens;
		}
		else
		{
			return parent.getOriginalTokens();
		}
	}

	public void setOriginalTokens(String[] tokens)
	{
		if (parent == null)
		{
			originalTokens = tokens;
		}
		else
		{
			parent.setOriginalTokens(tokens);
		}
	}

	private int getIndex()
	{
		if (parent == null)
		{
			return i;
		}
		else
		{
			return parent.getIndex();
		}
	}

	public void findVariables(String[] tokens)
	{
		if (originalTokens == null)
		{
			originalTokens = tokens;
		}

		// Clear the handled indices when the processing starts
		for (i = 0; i < tokens.length; i++)
		{
			token = tokens[i];

			if ((i + 1) < tokens.length)
			{
				next = tokens[i + 1];
			}

			pushTokens(token, next);

		}
	}

	public boolean pushTokens(String token, String nextToken)
	{
		if ((recursive == null) && !silenced && showTokens)
		{
			Log.d("Pushing tokens " + token + " " + nextToken + " " + mode);
		}
		this.token = token;
		this.next = nextToken;

		if (recursive != null)
		{
			if (recursive.pushTokens(token, nextToken))
			{
				recursive = null;
				if (mode == RESET)
				{
					reset();
				}
			}
		}
		else if (token.contentEquals("(") || token.contentEquals("{"))
		{
			// Log.d("new Rec");
			recursive = new VarFinder(this);
		}
		else if (token.contentEquals(")") || token.contentEquals("}"))
		{
			return true;
		}
		else if (!foundStringLiteral)
		{
			decideAction();

		}

		return false;
	}

	/**
	 * This method decides what to do with the next tokens.
	 */
	private void decideAction()
	{
		// Log.d("token:"+token+" "+mode);
		switch (mode)
		{
		case TYPE:
			lookForType();
			break;
		case NAME:
			lookForNames(token, next);
			break;
		case RESET:
			checkForReset();
			break;
		case ARRAY:
			lookForArrays();
			break;
		case EQUALS:
			waitForEndOfAssign();
			break;
		case TEMPLATE:
			pushTokenForTemplate(token, true);
		}
	}

	/**
	 * Method finds next token that contains ",". It counts tokens to next ","
	 * after index and returns it. If statement ends( ";", bracket is found, or
	 * there are no more tokens) it returns -1;
	 * 
	 * @param index
	 * @param obj
	 * @return
	 */
	/*
	 * private int findNextComma(int index, ) {
	 * 
	 * for(x=0;(index+x)<size;x++){ obj1=obj.getChildren().get(index+x);
	 * if(obj1.getContent().contentEquals(",")) return x; else
	 * if(obj1.getContent().contentEquals(";") ||
	 * obj1.getContent().contentEquals(")") ||
	 * obj1.getContent().contentEquals("]") ||
	 * obj1.getContent().contentEquals("}")) return -1; } return -1; }
	 */

	private void checkForReset()
	{
		// Log.d("cReset "+token);
		if (token.contentEquals(";"))
		{
			;
		}
		else if (token.contentEquals("{"))
		{
			;
		}
		else
		{
			return;
		}
		reset();
	}

	private void endOfDeclaration()
	{
		// Log.d("eod");
		createVariable();
		reset();
	}

	private void reset()
	{
		templateDepth = 0;
		currentType = "";
		currentPtr = "";
		currentName = "";
		currentArray = "";
		currentTemplate = "";
		primitive = false;
		mode = TYPE;
		arrays = 0;
		checkForOperator = false;
		handledIndices.clear();
	}

	public ArrayList<Integer> getHandledIndices()
	{
		return handledIndices;
	}

	public int getIndexOfToken(String s)
	{
		for (int j = 0; j < getOriginalTokens().length; ++j)
		{
			if (getOriginalTokens()[j].equals(s))
			{
				return j;
			}
		}
		return -1;
	}

	private void createVariable()
	{
		if (!(currentType.isEmpty() || currentName.isEmpty()))
		{
			// This will sort out some of false positives, eg a * b; is
			// recognized as declaration of variable *b of type a, when a is
			// variable
			if (!primitive)
			{
				if (!currentPtr.isEmpty())
				{
					if (ParsedObjectManager.getInstance().currentFunc
							.isVariableDefined(currentName))
					{
						// Log.d("Found false positive " +
						// currentType+currentTemplate + " " +
						// currentPtr+currentName+currentArray);
						reset();
						return;
					}
				}
			}

			if (!silenced)
			{
				Log.d("Found variable " + currentType + currentTemplate + " "
						+ currentPtr + currentName + currentArray);
			}
			MemberVariable member = new MemberVariable(currentType, currentName);
			checkDependencies(currentType);
			member.setTemplate(currentTemplate);
			member.setArray(currentArray);
			ParsedObjectManager.getInstance().currentFunc.addMember(member);
			ParsedObjectManager.getInstance().currentFunc.addOperand(member
					.getName());
			ParsedObjectManager.getInstance().currentFunc.addOperand(member
					.getType());

			for (Integer integer : handledIndices)
			{
				functionAnalyzer.storeHandledIndex(integer);
			}

		}// else Log.d("Var without name or type "+ token+ " "+next+" "+mode);
		currentPtr = "";
		currentName = "";
		currentArray = "";
		currentTemplate = "";
		templateDepth = 0;
		checkForOperator = false;
		handledIndices.clear();
	}

	/**
	 * This method looks for the type of the variable for example int
	 */
	private void lookForType()
	{
		if (next == null)
		{
			return;
		}
		if (token.contentEquals(";"))
		{
			reset();
		}
		else if (token.contains("<"))
		{
			String[] splitted = StringTools.split(token, delims, true);
			mode = TEMPLATE;
			if (!splitted[0].contentEquals("<"))
			{
				currentType += splitted[0];
			}
			else
			{
				pushTokenForTemplate(splitted[0], false);
			}

			for (int a = 1; a < splitted.length; a++)
			{
				pushTokenForTemplate(splitted[a], false);
			}
		}
		else
		{
			// Log.d("lft:"+token);
			if (Constants.isWordToken(token))
			{
				if (canSkip(token))
				{
					return;
				}
				if (canSkip(next))
				{
					next = "";
				}
				// Log.d("lft:"+token);
				if (Constants.isPrimitiveType(token))
				{
					primitive = true;
				}
				if (primitive && !currentType.isEmpty())
				{
					currentType += " " + token;
				}
				else
				{
					currentType += token;
				}
				markIndex(getIndex());

				if (primitive)
				{
					// Log.d("found primitive type");
					if (!Constants.isPrimitiveType(next) && !next.isEmpty())
					{
						mode = NAME;
					}
					else
					{
						return;
					}

				}
				if (next.isEmpty())
				{
					return;
				}
				else if (next.contentEquals("->"))
				{
					mode = RESET;
					return;
				}
				else if (next.contentEquals("::"))
				{
					skip();
					currentType += next;
					markIndex(getIndex() + 1);
				}
				else if (Constants.isWordToken(next))
				{
					if (!primitive)
					{
						if (Constants.isKeyword(currentType))
						{
							mode = RESET;
							return;
						}
					}
					mode = NAME;
				}
				else if (next.contentEquals("*") || next.contentEquals("&"))
				{
					if (!primitive)
					{
						if (Constants.isKeyword(currentType))
						{
							mode = RESET;
							return;
						}
					}
					mode = NAME;
				}
				else if (next.contains("<"))
				{
					;
				}
				else
				{
					mode = RESET;
				}
			}
			else
			{
				mode = RESET;
			}
		}
	}

	/**
	 * Method checks if the token can form name for the variable
	 * 
	 * @param token
	 * @param next
	 */
	private void lookForNames(String token, String next)
	{
		if (token.contentEquals(";"))
		{
			endOfDeclaration();
			return;
		}
		// Log.d("lfn:"+token+" "+next);
		if (token.contentEquals("*") || token.contentEquals("&"))
		{
			currentPtr += token;
			markIndex(getIndex());
		}
		else if (Constants.isWordToken(token))
		{
			currentName += token;
			markIndex(getIndex());
			if (next != null)
			{
				switch (next)
				{
				case "=":
					mode = EQUALS;
					createVariable();
					// skip();
					break;
				case "{":
				case "(":
					createVariable();
					// reset();
					// skip();
					break;
				case ")":
					endOfDeclaration();
					break;
				case ";":
					endOfDeclaration();
					skip();
					break;
				case ",":
					createVariable();
					markIndex(getIndex() + 1);
					skip();
					break;
				case "[":
					mode = ARRAY;
					arrays++;
					currentArray += "[";
					markIndex(getIndex() + 1);
					arrayVarFinder = new VarFinder(this);
					skip();
					break;
				default:
					skip();
					reset();
				}
			}
			else
			{
				throw new Error("Unexpected nullpointer");
			}
		}
	}

	/**
	 * This method collects the tokens and builds an array from them eg. [9] in
	 * int a[9] This method also checks recursively if there is variable
	 * declarations inside the square brackets
	 */
	private void lookForArrays()
	{
		currentArray += token;
		markIndex(getIndex());
		if (token.contentEquals("]"))
		{
			arrays--;
			if (arrays > 0)
			{
				arrayVarFinder.pushTokens(token, next);
			}
		}
		if (next != null)
		{
			if (next.contentEquals("["))
			{
				currentArray += "[";
				arrays++;
				skip();
			}
			else if (next.contentEquals(";"))
			{
				arrayVarFinder = null;
				endOfDeclaration();
				skip();
			}
			else if (next.contentEquals(","))
			{
				if (arrays == 0)
				{
					createVariable();
					mode = NAME;
					skip();
				}
			}
		}
	}

	private void waitForEndOfAssign()
	{
		// Log.d("wfeoa" + token);
		switch (token)
		{
		case "(":
			recursive = new VarFinder(this);
			break;
		case ";":
			endOfDeclaration();
			break;
		case ",":
			createVariable();
			mode = NAME;
			break;
		}
	}

	/**
	 * This method collects tokens if template is used with the variable
	 * declaration
	 * 
	 * @param token
	 * @param needsSplitting
	 *            does the token need splitting? does it contain < or > chars?
	 */
	private void pushTokenForTemplate(String token, boolean needsSplitting)
	{

		if (needsSplitting)
		{
			String[] tokens = StringTools.split(token, delims, true);
			for (int a = 0; a < tokens.length; a++)
			{
				pushTokenForTemplate(tokens[a], false);
			}
		}
		else
		{
			// Log.d("ptft: "+token);
			if (token.contentEquals(";"))
			{
				reset();
			}
			else if (token.contentEquals("<"))
			{
				if (checkForOperator)
				{
					// Log.d("not template "+currentTemplate);
					reset();
					return;
				}

				templateDepth++;
				checkForOperator = true;
				currentTemplate += token;
				markIndex(getIndex());
				return;
			}
			else
			{
				checkForOperator = false;
			}

			if (checkForOperator)
			{
				if (token.contentEquals("="))
				{
					reset();
				}
			}

			if (templateDepth > 0)
			{
				currentTemplate += token;
				markIndex(getIndex());
				if (token.contentEquals(">"))
				{
					templateDepth--;
				}
			}
			else
			{
				mode = NAME;
				lookForNames(token, this.next);
			}
		}
	}

	/**
	 * Method checks if given token can be skipped in the variable declaration:
	 * returns true for if token is one of following: const, extern, mutable,
	 * register or thread_local
	 * 
	 * @param token
	 * @return
	 */
	private boolean canSkip(String token)
	{
		switch (token)
		{
		case "const":
		case "extern":
		case "mutable":
		case "register":
		case "thread_local":
			return true;
		default:
			return false;
		}
	}

	/**
	 * This method will skip the next token
	 */
	private void skip()
	{
		if (parent == null)
		{
			i++;
		}
		else
		{
			parent.skip();
		}
	}

	public void clearHandledIndices()
	{
		handledIndices.clear();
	}

	private void checkDependencies(String currentType)
	{
		if (!currentType.isEmpty())
		{
			String[] delim = { "::" };
			String[] tokens = StringTools.split(currentType, delim, false);
			for (String str : tokens)
			{
				ParsedObjectManager.getInstance().currentFunc
						.addDependency(str);
			}

		}
	}

	/**
	 * Method marks given index as handled for OperatorAnalyzer.
	 * 
	 * @param index
	 */
	private void markIndex(int index)
	{
		if (index < 0)
		{
			throw new Error("Negative index:" + token + " " + next);
		}
		// this will prevent duplicates caused by recursion
		if (handledIndices.isEmpty())
		{
			handledIndices.add(new Integer(index));
		}
		else if (handledIndices.get(handledIndices.size() - 1) != index)
		{
			handledIndices.add(new Integer(index));
		}
	}
}