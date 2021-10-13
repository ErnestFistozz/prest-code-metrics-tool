package cppParser;

import java.util.HashSet;

import cppParser.utils.StringTools;

/**
 * Analyses lists of tokens and tries to figure out operands and operators.
 * 
 * @author Harri Pellikka
 */
public class OperatorAnalyzer extends Analyzer
{
	// List of operators that tend to pop up in the operand list (and thus they
	// should be skipped)
	private String[] operandSkipList = { "{", "(", ";", "=", "]", "::" };

	// Extra splitters
	private String[] splitters = { "!", "~" };

	private int i = -1;
	private String[] tokens = null;

	private boolean openString = false;

	private HashSet<Integer> handledIndices = new HashSet<Integer>();

	private FunctionAnalyzer functionAnalyzer = null;

	/**
	 * Constructs a new operator analyze
	 * 
	 * @param sa
	 *            Sentence analyzer
	 * @param fa
	 *            Function analyzer
	 */
	public OperatorAnalyzer(SentenceAnalyzer sa, FunctionAnalyzer fa)
	{
		super(sa);
		this.functionAnalyzer = fa;
	}

	private void storeOperand(String operand)
	{
		if (!handledIndices.contains(new Integer(i)))
		{
			objManager.currentFunc.addOperand(operand);
			handledIndices.add(new Integer(i));
		}
	}

	private void storeOperator(String operator)
	{
		if (!handledIndices.contains(new Integer(i)))
		{
			objManager.currentFunc.addOperator(operator);
			handledIndices.add(new Integer(i));
		}
	}

	@Override
	/**
	 * Processes the tokens in order to find operators and operands
	 */
	public boolean processSentence(String[] tokens)
	{

		handledIndices.clear();

		// Split and reconstruct the tokens
		this.tokens = StringTools.reconstructOperators(StringTools.split(
				tokens, splitters, true));

		// Loop through the tokens
		for (i = 0; i < this.tokens.length; ++i)
		{
			if (this.tokens[i].equals("\""))
			{
				openString = !openString;
			}

			if (!openString)
			{
				if (StringTools.isOperator(this.tokens[i]))
				{
					handleOperator();
				}
				else if (StringTools.isKeyword(this.tokens[i])
						&& !StringTools.isPrimitiveType(this.tokens[i]))
				{
					// objManager.currentFunc.addOperator(this.tokens[i]);
					storeOperator(this.tokens[i]);
					if (tokens[i].equals("do"))
					{
						break;
					}
				}
				else
				{
					if ((i < (this.tokens.length - 1))
							&& this.tokens[i + 1].equals("*"))
					{
						i++;
						handleAsterisk();
					}
					// else objManager.currentFunc.addOperand(this.tokens[i]);
					else if (!this.tokens[i].equals("("))
					{
						storeOperand(this.tokens[i]);
					}
				}
			}
		}

		return true;
	}

	private void handleAsterisk()
	{
		if (i == 0)
		{
			String operand = "";
			for (; i < tokens.length; ++i)
			{
				if (tokens[i].equals("*"))
				{
					operand += "*";
				}
				else
				{
					break;
				}
			}
			operand = tokens[i] + operand;

			// String operand = tokens[i+1] + "*";

			// Log.d("Found operand: " + operand);
			// objManager.currentFunc.addOperand(operand);
			storeOperand(operand);
			return;
		}

		if (i == 1)
		{
			// String operand = tokens[0] + "*";
			String operand = tokens[0];
			for (; i < tokens.length; ++i)
			{
				if (tokens[i].equals("*"))
				{
					operand += "*";
				}
				else
				{
					break;
				}
			}
			i--;

			// Log.d("Found operand: " + operand);
			// objManager.currentFunc.addOperand(operand);
			storeOperand(operand);
			return;
		}
	}

	/**
	 * When an operator is found, this method handles the line, searching for
	 * operators and operands in the sentence.
	 */
	private void handleOperator()
	{
		if (tokens[i].equals(";"))
		{
			// objManager.currentFunc.addOperator(";");
			storeOperator(";");
			return;
		}
		else if (tokens[i].equals("*"))
		{
			handleAsterisk();
			return;
		}
		
		handleBracketPairs();

		int origIndex = i;
		String op = tokens[i];

		op = handlePrePostOp(op);
		storeOperator(op);

		handleLeftSideOperand(origIndex);

		// Process the rest of the tokens
		for (i = i + 1; i < tokens.length; ++i)
		{
			if (StringTools.isOperator(tokens[i]))
			{
				constructOperand();
			}
			else
			{
				if (StringTools.isKeyword(tokens[i]))
				{
					storeOperator(tokens[i]);
				}
				else
				{
					// Operand found, construct and store it
					String operand = tokens[i];
					if (operand.equals("\""))
					{
						operand = constructStringLiteral(i, false);
					}
					if ((operand != null) && canAddOperand(i))
					{
						storeOperand(operand);
						
						// Check for possible post-increment or post-decrement
						// operator
						if (i < (tokens.length - 1))
						{
							if (tokens[i + 1].equals("++")
									|| tokens[i + 1].equals("--"))
							{
								i++;
								storeOperator(tokens[i] + " POST");
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 
	 */
	private void constructOperand()
	{
		int origIndex;
		String op;
		// Operator found, construct and store it
		origIndex = i;
		op = tokens[i];
		if (canAddOperator(i))
		{
			if (op.equals("++") || op.equals("--"))
			{
				op += " PRE";
			}
			storeOperator(op);
			// objManager.currentFunc.addOperator(op);
			// functionAnalyzer.getHandledIndices().add(new
			// Integer(origIndex));
		}
	}

	/**
	 * @param origIndex
	 */
	private void handleLeftSideOperand(int origIndex)
	{
		// If there's a "left side" for the operator, handle that
		if (i > 0)
		{
			String leftSide = tokens[origIndex - 1];

			/*
			 * if(leftSide.equals("\"")) { leftSide =
			 * constructStringLiteral(origIndex-i, true); }
			 */

			// Add the leftside operand
			if (!StringTools.isOperator(leftSide))
			{
				if ((leftSide != null) && canAddOperand(origIndex - 1))
				{
					storeOperand(leftSide);
					// objManager.currentFunc.addOperand(leftSide);
					// functionAnalyzer.getHandledIndices().add(new
					// Integer(origIndex-1));
				}
			}
		}
	}

	/**
	 * @param op
	 * @return
	 */
	private String handlePrePostOp(String op)
	{
		// If the operator is inc. or dec., set the PRE or POST label
		// accordingly
		if (op.equals("++") || op.equals("--"))
		{
			if (i == 0)
			{
				op += " PRE";
			}
			else
			{
				op += " POST";
			}
		}
		return op;
	}

	/**
	 * 
	 */
	private void handleBracketPairs()
	{
		// Handle bracket pairs
		int bracketPairIndex = StringTools.getBracketPair(tokens, i);
		if (bracketPairIndex > -1)
		{
			// Log.d("Found brace pair " + tokens[Math.min(i, bracketPairIndex)]
			// + " " + tokens[Math.max(i, bracketPairIndex)]);
			if (functionAnalyzer.getHandledIndices().contains(
					new Integer(bracketPairIndex)))
			{
				// Log.d("  Already handled.");
			}
			else
			{
				// functionAnalyzer.getHandledIndices().add(new
				// Integer(bracketPairIndex));
				handledIndices.add(new Integer(bracketPairIndex));
			}
		}
	}

	/**
	 * Checks if the operand at index 'index' isn't added already by VarFinder
	 * and if the operand is in fact not a suitable operand.
	 * 
	 * @param index
	 *            The index of the operand
	 * @return 'true' if the operand isn't yet added, 'false' if it is already
	 *         added
	 */
	private boolean canAddOperand(int index)
	{
		// Check if the index is already handled
		for (Integer integer : functionAnalyzer.getHandledIndices())
		{
			if (integer.intValue() == index)
			{
				return false;
			}
		}

		// Check if the token at the index is in the "skip list"
		for (String s : operandSkipList)
		{
			if (tokens[index].equals(s))
			{
				return false;
			}
		}

		// If the operator is '.', check that it's a method call, not a decimal
		// point
		if ((index < (tokens.length - 2)) && tokens[index + 1].equals("."))
		{
			try
			{
				Integer.parseInt(tokens[index]);
				return false;
			}
			catch (NumberFormatException e)
			{
				return true;
			}
		}

		return true;
	}

	private boolean canAddOperator(int index)
	{
		switch (tokens[index])
		{
		case ".":
			try
			{
				Integer.parseInt(tokens[index - 1]);
				return false;
			}
			catch (NumberFormatException e)
			{
				return true;
			}
		}
		return true;
	}

	/**
	 * Constructs a string literal from the given index onwards until the
	 * closing '"' is found.
	 * 
	 * @param index
	 *            The index of the beginning '"'
	 * @param reverse
	 *            If 'true', the search is done backwards (the current index is
	 *            the ending '"')
	 * @return The string literal
	 */
	private String constructStringLiteral(int index, boolean reverse)
	{
		String literal = "";
		if (!reverse)
		{
			for (int j = index; j < tokens.length; ++j)
			{
				literal += tokens[j];
				if ((j != index) && tokens[j].equals("\""))
				{
					i = j;
					break;
				}
			}
		}
		else
		{
			for (int j = index; j >= 0; --j)
			{
				literal = tokens[j] + literal;
				if ((j != index) && tokens[j].equals("\""))
				{
					i = index;
					break;
				}
			}
		}
		if (!literal.startsWith("\"") || !literal.endsWith("\""))
		{
			return null;
		}
		return literal;
	}
}
