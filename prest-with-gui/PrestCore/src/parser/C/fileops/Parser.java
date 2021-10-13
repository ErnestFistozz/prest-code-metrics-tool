package parser.C.fileops;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class Parser {

	private InputReader ir;
	private SourceFile file;
	private LinkedList<Module> modules;
	private File sourceFile;
	public final boolean HEADERFILE = true;
	public final boolean DEFINITIONFILE = false;
	/** This is a queue for the tokens */
	LinkedList<Token> tokenQueue;
	private final int BUFFER_LENGTH = 50;
	private Module currentModule;

	public Parser(File sourceFile) throws FileNotFoundException, IOException {
		// System.out.println(sourceFile.getName());
		this.sourceFile = sourceFile;
		this.file = new SourceFile(sourceFile.getName(), determineFileType());
		this.file.setStartLineNo(1);
		this.file.setStartBlankLoc(0);
		this.file.setStartCodeCommentLoc(0);
		this.file.setStartCommentLoc(0);
		modules = new LinkedList<Module>();
		process();
	}

	private void process() throws FileNotFoundException, IOException {
		try {
			ir = new InputReader(sourceFile);
			tokenQueue = new LinkedList<Token>();
			parse();
		} catch (FileNotFoundException fnfe) {
			throw fnfe;
		} catch (IOException ioe) {
			throw ioe;
		}
	}

	private void parse() {
		Token currentToken;
		while ((currentToken = nextToken()).getCode() != InputReader.EOF) {
			switch (currentToken.getCode()) {
			case InputReader.COMMENT:
				break;
			case InputReader.PREPROCESSOR:
				break;
			case InputReader.TYPEDEF:
				consumeTypeDef();
				break;
			case InputReader.EXTERN:
				consumeExternalDefinition();
				break;
			default:
				retract(currentToken);
				currentModule = new Module();
				modules.add(currentModule);
				currentModule.setFile(file.getName());
				currentModule.setStartLineNo(currentToken.getLineNo());
				currentModule.setStartBlankLoc(currentToken.getBlankLoc());
				currentModule.setStartCommentLoc(currentToken.getCommentLoc());
				currentModule.setStartCodeCommentLoc(currentToken
						.getCodeCommentLoc());
				consumeModule();
				break;
			}
		}
	}

	private void consumeModule() {
		Token token = nextToken();
		// System.out.println("------>"+token.getActual()+":"+token.getLineNo());
		boolean isNameSet = false;
		boolean hasSeenAssignment = false;
		int numLeftCurlyBrace = 0;
		int numComma = 0;
		boolean typeSpecSeenInArgs = false;
		if (token.getCode() == InputReader.STATIC) {
			token = nextToken();
		}
		System.out.println(token.getCode());
		switch (token.getCode()) {
		case InputReader.VOID:
			break;
		case InputReader.UNSIGNED:
		case InputReader.SIGNED:
			token = peek();
			switch (token.getCode()) {
			case InputReader.CHAR:
			case InputReader.INT:
				nextToken();
				break;
			case InputReader.SHORT:
			case InputReader.LONG:
				nextToken();
				token = peek();
				if (token.getCode() == InputReader.INT) {
					nextToken();
				}
				break;
			}
			break;
		case InputReader.CHAR:
		case InputReader.INT:
		case InputReader.FLOAT:
		case InputReader.DOUBLE:
			break;
		case InputReader.SHORT:
			if (peek().getCode() == InputReader.INT)
				nextToken();
			break;
		case InputReader.LONG:
			if ((peek().getCode() == InputReader.INT)
					|| (peek().getCode() == InputReader.FLOAT))
				nextToken();
			break;
		case InputReader.STRUCT:
		case InputReader.UNION:
			break;
		case InputReader.ENUM:
			break;
		case InputReader.IDENTIFIER:
			// consume until next is a ( or ) or * or a ;
			Token previousToken = null;
			while (!((token.getCode() == InputReader.LEFT_PARAN)
					|| (token.getCode() == InputReader.RIGHT_PARAN)
					|| (token.getCode() == InputReader.DEREFERENCE) || (token
					.getCode() == InputReader.SEMICOLON || (token.getCode() == InputReader.ASSIGNMENT)))) {
				previousToken = token;
				token = nextToken();
				if (token.getCode() == InputReader.EOF)
					return;
			}
			retract(token);
			if (previousToken != null)
				retract(previousToken);
			break;
		case InputReader.CONST:
		case InputReader.VOLATILE:
			break;
		default:
			//System.out.println("Type Specifier Missing!!!");
			break;
		}
		// the first IDENTIFIER is the name of the module
		while (token.getCode() != InputReader.EOF) {
			token = nextToken();
			if (token.getCode() == InputReader.IDENTIFIER) {

				// added by ekrem
				// get the name of the called function here
				String tempName = token.getActual();
				if (isNameSet) {
					if (peek().getCode() == InputReader.LEFT_PARAN) {
						currentModule.incrementCallCount();
						file.incrementCallCount();
						// added by ekrem
						currentModule.addCalledFunctions(tempName);
					}
				} else {
					if ((peek().getCode() == InputReader.LEFT_PARAN)
							|| (peek().getCode() == InputReader.RIGHT_PARAN)) {
						isNameSet = true;
						currentModule.setName(token.getActual());
						if (peek().getCode() == InputReader.LEFT_PARAN) {
							Token arg1 = nextToken();
							Token arg2 = nextToken();
							if ((arg2.getCode() != InputReader.VOID)
									&& (arg2.getCode() != InputReader.RIGHT_PARAN)) {
								typeSpecSeenInArgs = true;
							}
							retract(arg2);
							retract(arg1);
						}
					}
				}
			} else if (token.getCode() == InputReader.LEFT_CURLY_BRACKET) {
				if (numLeftCurlyBrace++ == 0) {
					currentModule.setHasBlock(true);
					if (numComma == 0) {
						if (typeSpecSeenInArgs)
							currentModule.setFormalParam(1);
						else
							currentModule.setFormalParam(0);
					} else
						currentModule.setFormalParam(numComma + 1);
				} else {
					;
				}
			} else if (token.getCode() == InputReader.RIGHT_CURLY_BRACKET) {
				if (--numLeftCurlyBrace == 0) {
					currentModule.setEndLineNo(token.getLineNo());
					currentModule.setEndBlankLoc(token.getBlankLoc());
					currentModule.setEndCommentLoc(token.getCommentLoc());
					currentModule.setEndCodeCommentLoc(token
							.getCodeCommentLoc());
					if (peek().getCode() == InputReader.SEMICOLON)
						nextToken();
					currentModule = null;
					return;
				}
			} else if (token.getCode() == InputReader.SEMICOLON) {
				if (numLeftCurlyBrace == 0) {
					currentModule.setEndLineNo(token.getLineNo());
					currentModule = null;
					return;
				}
			} else if ((token.getCode() == InputReader.ASSIGNMENT)
					&& (!hasSeenAssignment)) {
				hasSeenAssignment = true;
				if (numLeftCurlyBrace == 0) {
					currentModule.setType(Module.EXTERNALDEFINITION);
				}
			} else if (token.getCode() == InputReader.COMMA) {
				numComma++;
			}
		}
	}

	private void consumeExternalDefinition() {
		Token currentToken = nextToken();
		while (currentToken.getCode() != InputReader.SEMICOLON) {
			if (currentToken.getCode() == InputReader.LEFT_CURLY_BRACKET) {
				currentToken = nextToken();
				while (currentToken.getCode() != InputReader.RIGHT_CURLY_BRACKET) {
					currentToken = nextToken();
				}
			} else if (currentToken.getCode() == InputReader.EOF)
				return;
			currentToken = nextToken();
		}
		return;
	}

	private void consumeTypeDef() {
		Token currentToken = nextToken();
		while (currentToken.getCode() != InputReader.SEMICOLON) {
			if (currentToken.getCode() == InputReader.LEFT_CURLY_BRACKET) {
				currentToken = nextToken();
				while (currentToken.getCode() != InputReader.RIGHT_CURLY_BRACKET) {
					currentToken = nextToken();
				}
			} else if (currentToken.getCode() == InputReader.EOF)
				return;
			currentToken = nextToken();
		}
		return;
	}

	public LinkedList<Module> getModules() {
		return modules;
	}

	public SourceFile getSourceFile() {
		return file;
	}

	public boolean determineFileType() {
		String fileName = sourceFile.getName();
		int lastDotIndex = fileName.lastIndexOf(".");
		String extension = fileName.substring(lastDotIndex + 1);
		if (extension.equalsIgnoreCase("c"))
			return DEFINITIONFILE;
		else
			return HEADERFILE;
	}

	private boolean isOperator(Token t) {
		switch (t.getCode()) {
		case InputReader.NEGATION:
		case InputReader.REMAINDER:
		case InputReader.ADDRESS:
		case InputReader.DEREFERENCE:
		case InputReader.PLUS:
		case InputReader.COMMA:
		case InputReader.MINUS:
		case InputReader.MEMBER:
		case InputReader.DIVISION:
		case InputReader.SEMICOLON:
		case InputReader.LESS:
		case InputReader.GREATER:
		case InputReader.QUESTION:
		case InputReader.XOR:
		case InputReader.ONE_COMPLEMENT:
		case InputReader.ASSIGNMENT:
		case InputReader.LESS_EQUAL:
		case InputReader.GREATER_EQUAL:
		case InputReader.EQUAL:
		case InputReader.NOT_EQUAL:
		case InputReader.SHIFT_LEFT:
		case InputReader.SHIFT_RIGHT:
		case InputReader.PLUS_ASSIGNMENT:
		case InputReader.MINUS_ASSIGNMENT:
		case InputReader.DEREFERENCE_ASSIGNMENT:
		case InputReader.DIVISION_ASSIGNMENT:
		case InputReader.ADDRESS_ASSIGNMENT:
		case InputReader.REMAINDER_ASSIGNMENT:
		case InputReader.XOR_ASSIGNMENT:
		case InputReader.OR_ASSIGNMENT:
		case InputReader.SHIFT_LEFT_ASSIGNMENT:
		case InputReader.SHIFT_RIGHT_ASSIGNMENT:
		case InputReader.LOGICAL_AND:
		case InputReader.LOGICAL_OR:
		case InputReader.INCREMENT:
		case InputReader.DECREMENT:
		case InputReader.INDIRECTION:
		case InputReader.OR:
		case InputReader.RETURN:
		case InputReader.SIZEOF:
		case InputReader.ENUM:
		case InputReader.STRUCT:
		case InputReader.CONTINUE:
		case InputReader.BREAK:
		case InputReader.UNION:
		case InputReader.IF:
		case InputReader.SWITCH:
		case InputReader.DEFAULT:
		case InputReader.CASE:
		case InputReader.GOTO:
		case InputReader.WHILE:
		case InputReader.FOR:
		case InputReader.LEFT_CURLY_BRACKET:
		case InputReader.LEFT_PARAN:
		case InputReader.LEFT_SQUARE_BRACKET:
			return true;
		default:
			return false;
		}
	}

	private boolean isOperand(Token t) {
		switch (t.getCode()) {
		case InputReader.IDENTIFIER:
		case InputReader.STRING:
		case InputReader.NUMBER:
		case InputReader.CHARACTER:
			return true;
		default:
			return false;
		}
	}

	private Token peek() {
		if (tokenQueue.size() == 0) {
			fillTokenQueue();
		}
		return tokenQueue.peek();
	}

	private Token nextToken() {
		if (tokenQueue.size() == 0) {
			fillTokenQueue();
		}
		Token t = tokenQueue.poll();
		if (currentModule != null) {
			if (this.isOperator(t)) {
				currentModule.addOperator(t);
			}
			if (this.isOperand(t)) {
				currentModule.addOperand(t);
			}
			if (t.getCode() == InputReader.FOR) {
				currentModule.incrementForCount();
			} else if (t.getCode() == InputReader.WHILE) {
				currentModule.incrementWhileCount();
			} else if (t.getCode() == InputReader.IF) {
				currentModule.incrementIfCount();
			} else if (t.getCode() == InputReader.ELSE) {
				currentModule.incrementElseCount();
			} else if (t.getCode() == InputReader.CASE) {
				currentModule.incrementCaseCount();
			} else if (t.getCode() == InputReader.DEFAULT) {
				currentModule.incrementDefaultCount();
			} else if (t.getCode() == InputReader.QUESTION) {
				currentModule.incrementQuestionCount();
			} else if (t.getCode() == InputReader.SWITCH) {
				currentModule.incrementSwitchCount();
			}
		}
		if (isOperator(t)) {
			file.addOperator(t);
		}
		if (this.isOperand(t)) {
			file.addOperand(t);
		}
		if (t.getCode() == InputReader.FOR) {
			file.incrementForCount();
		} else if (t.getCode() == InputReader.WHILE) {
			file.incrementWhileCount();
		} else if (t.getCode() == InputReader.IF) {
			file.incrementIfCount();
		} else if (t.getCode() == InputReader.ELSE) {
			file.incrementElseCount();
		} else if (t.getCode() == InputReader.CASE) {
			file.incrementCaseCount();
		} else if (t.getCode() == InputReader.DEFAULT) {
			file.incrementDefaultCount();
		} else if (t.getCode() == InputReader.QUESTION) {
			file.incrementQuestionCount();
		} else if (t.getCode() == InputReader.SWITCH) {
			file.incrementSwitchCount();
		} else if (t.getCode() == InputReader.EOF) {
			file.setEndLineNo(t.getLineNo());
			file.setEndBlankLoc(t.getBlankLoc());
			file.setEndCodeCommentLoc(t.getCodeCommentLoc());
			file.setEndCommentLoc(t.getCommentLoc());
		}
		// System.out.println(t.getActual()+":"+t.getCode()+":"+t.getLineNo());
		return t;
	}

	private void retract(Token toPutBack) {
		tokenQueue.addFirst(toPutBack);
	}

	private void fillTokenQueue() {
		int count = 0;
		Token token = new Token();
		while ((count < BUFFER_LENGTH)
				&& ((token = ir.nextToken()).getCode() != InputReader.EOF)) {
			tokenQueue.add(token);
			count++;
		}
		if (token.getCode() == InputReader.EOF)
			tokenQueue.add(token);
	}

}
