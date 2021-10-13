package parser.C.fileops;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedList;

public class InputReader {

	//The buffer to hold the input characters
	//It is divided into equal two parts, and two positions (pointers)
	//front and back are maintained for it.
	//front serves as lookahead pointer, back is the beginning
	//of the current lexeme.  When front reaches the end of either half,
	//the other part is filled with new characters from the input file.
	private char[] buffer;
	//This contains the file to read.
	private File toRead;
	//This is the size of the buffer.
	public static final int BUFFER_SIZE = 4*4096;
	//These constants are used as flags for the method fillBufferHalf
	//to indicate which half is to be filled.
	public static final byte LEFT_HALF = 1;
	public static final byte RIGHT_HALF = 2;
	//This is the reader object to read characters from file toRead.
	private BufferedReader reader;
	//Variables to hold the positions in the stream(buffer)
	//The variable front should not be manipulated outside the method
	//nextChar().
	private int front;
	private int back;
	//Variables to count certain metrics
	private int loc, commentLoc, blankLoc, codeCommentLoc;
	//If the line is empty (it contains no char other than white space) 
	//this flag remains true, otherwise it is set to false
	private boolean lineIsBlank;
	//This varible is used to ensure that if front is retracted through a
	//a boundary, the buffer is not flushed and refilled.
	private boolean retractBoundaryFlag;
	//The String[] for keywords
	public static final String[] keywordArray = {"auto", "if", "break", "int"
										   , "case", "long", "char"
										   , "register", "continue", "return"
										   , "default", "short", "do"
										   , "sizeof", "double", "static"
										   , "else", "struct", "entry"
										   , "switch", "extern", "typedef"
										   , "float", "union", "for"
										   , "unsigned", "goto", "while"
										   , "enum", "void", "const", "signed"
										   , "volatile"};
	//The String[] for the operators
	public static final String[] operatorsArray = {";", "-", "(", ")", "()", "["
										   , "]", "[]", "->", ".", "++", "--"
										   , "~", "!", "&", "*", "/", "%", "+"
										   , "<<", ">>", "<", "<=", ">", ">="
										   , "==", "!=", "^", "|", "&&", "||"
										   , "?", ":", "=", "%=", "+=", "-="
										   , "*=", "/=", ">>=", "<<=", "&="
										   , "^=", "|=", ",", "{", "}", "{}"};
	//The hashset to contain the keywords
	Hashtable<String, Integer> keywords;
	//The hashtable to contain the operators.
	Hashtable<Integer, String> operators;
	//Another one for reverse lookup.
	Hashtable<String, Integer> operatorsReverse;
	//The variables necessary for input analysis
	//This variable keeps track of the state the DFA is in.
	int state;
	//token declarations
	public static final int EOF = 0;
	public static final int AUTO = 1;
	public static final int IF = 2;
	public static final int BREAK = 3;
	public static final int INT = 4;
	public static final int CASE = 5;
	public static final int LONG = 6;
	public static final int CHAR = 7;
	public static final int REGISTER = 8;
	public static final int CONTINUE = 9;
	public static final int RETURN = 10;
	public static final int DEFAULT = 11;
	public static final int SHORT = 12;
	public static final int DO = 13;
	public static final int SIZEOF = 14;
	public static final int DOUBLE = 15;
	public static final int STATIC = 16;
	public static final int ELSE = 17;
	public static final int STRUCT = 18;
	public static final int ENTRY = 19;
	public static final int SWITCH = 20;
	public static final int EXTERN = 21;
	public static final int TYPEDEF = 22;
	public static final int FLOAT = 23;
	public static final int UNION = 24;
	public static final int FOR = 25;
	public static final int UNSIGNED = 26;
	public static final int GOTO = 27;
	public static final int WHILE = 28;
	public static final int ENUM = 29;
	public static final int VOID = 30;
	public static final int CONST = 31;
	public static final int SIGNED = 32;
	public static final int VOLATILE = 33;
	public static final int NUMBER = 34;
	public static final int STRING = 35;
	public static final int CHARACTER = 36;
	public static final int COMMENT = 37;
	public static final int IDENTIFIER = 38;
	public static final int SEMICOLON = 39;
	public static final int MINUS = 40;
	public static final int LEFT_PARAN = 41;
	public static final int RIGHT_PARAN = 42;
	public static final int LEFT_RIGHT_PARAN = 43;
	public static final int LEFT_SQUARE_BRACKET = 44;
	public static final int RIGHT_SQUARE_BRACKET = 45;
	public static final int LEFT_RIGHT_SQUARE_BRACKET = 46;
	public static final int INDIRECTION = 47;
	public static final int MEMBER = 48;
	public static final int INCREMENT = 49;
	public static final int DECREMENT = 50;
	public static final int ONE_COMPLEMENT = 51;
	public static final int NEGATION = 52;
	public static final int ADDRESS = 53;
	public static final int DEREFERENCE = 54;
	public static final int DIVISION = 55;
	public static final int REMAINDER = 56;
	public static final int PLUS = 57;
	public static final int SHIFT_LEFT = 58;
	public static final int SHIFT_RIGHT = 59;
	public static final int LESS = 60;
	public static final int LESS_EQUAL = 61;
	public static final int GREATER = 62;
	public static final int GREATER_EQUAL = 63;
	public static final int EQUAL = 64;
	public static final int NOT_EQUAL = 65;
	public static final int XOR = 66;
	public static final int OR = 67;
	public static final int LOGICAL_AND = 68;
	public static final int LOGICAL_OR = 69;
	public static final int QUESTION = 70;
	public static final int COLON = 71;
	public static final int ASSIGNMENT = 72;
	public static final int REMAINDER_ASSIGNMENT = 73;
	public static final int PLUS_ASSIGNMENT = 74;
	public static final int MINUS_ASSIGNMENT = 75;
	public static final int DEREFERENCE_ASSIGNMENT = 76;
	public static final int DIVISION_ASSIGNMENT = 77;
	public static final int SHIFT_RIGHT_ASSIGNMENT = 78;
	public static final int SHIFT_LEFT_ASSIGNMENT = 79;
	public static final int ADDRESS_ASSIGNMENT = 80;
	public static final int XOR_ASSIGNMENT = 81;
	public static final int OR_ASSIGNMENT = 82;
	public static final int COMMA = 83;
	public static final int LEFT_CURLY_BRACKET = 84;
	public static final int RIGHT_CURLY_BRACKET = 85;
	public static final int LEFT_RIGHT_CURLY_BRACKET = 86;
	public static final int PREPROCESSOR = 87;
	
	//This linked list stores the identifiers recognized thus far,
	//It is the responsibility of the caller of the method nextToken
	//to ensure which IDENTIFIER instance returned corrensponds to
	//which String in this list.  They will be stored in the list in
	//the order they are recognized.
	private LinkedList<String> identifiers;
	
	/**
	 * 
	 * @param toRead The file which is going to be read.
	 * @throws FileNotFoundException If the file toRead cannot be opened.
	 * @throws IOException If an exception is thrown while reading the file.
	 */
	public InputReader(File toRead) throws FileNotFoundException, IOException {
		this.toRead = toRead;
		initialize();
	}
	
	/**
	 * Initialize the instance variables.
	 *
	 */
	private void initialize() throws FileNotFoundException, IOException {
		lineIsBlank = true;
		retractBoundaryFlag = false;
		buffer = new char[BUFFER_SIZE];
		reader = new BufferedReader(
				new FileReader(toRead));
		front = -1;
		back = commentLoc = blankLoc = codeCommentLoc = 0;
		loc = 1;
		fillBufferHalf(LEFT_HALF);
		//Create the hash set for the keywords
		keywords = new Hashtable<String, Integer>();
		for(int i = 0; i < keywordArray.length; i++) {
			keywords.put(keywordArray[i], new Integer(i+1));
		}
		state = 0;
		identifiers = new LinkedList<String>();
		operators = new Hashtable<Integer, String>();
		for(int i = SEMICOLON; i <= LEFT_RIGHT_CURLY_BRACKET; i++) {
			operators.put(new Integer(i), operatorsArray[i-SEMICOLON]);
		}
		operatorsReverse = new Hashtable<String, Integer>();
		for(int i = SEMICOLON; i <= LEFT_RIGHT_CURLY_BRACKET; i++) {
			operatorsReverse.put(operatorsArray[i-SEMICOLON], new Integer(i));
		}
	}
	
	/**
	 * A method for debugging purposes,
	 * returns the name of the token for a given integer code.
	 * 
	 * @param code The code for a token
	 * @return The name of the token, or null if this is not a valid token.
	 */
	public String getNameFromCode(Integer code) {
		if(code.intValue() == EOF) {
			return "EOF";
		}else if(operators.containsKey(code)) {
			return operators.get(code);
		}else if(code.intValue() == PREPROCESSOR) {
			return "PREPROCESSOR";
		}else if(code.intValue() == IDENTIFIER){
			return "IDENTIFIER";
		}else if(code.intValue() == NUMBER) {
			return "NUMBER";
		}else if(code.intValue() == STRING) {
			return "STRING";
		}else if(code.intValue() == CHARACTER) {
			return "CHARACTER";
		}else if(code.intValue() == COMMENT) {
			return "COMMENT";
		}else if(keywords.contains(code)) {
			return "KEYWORD";
		}else {
			return null;
		}
	}
	
	/**
	 * 
	 * @param half indicates which half of the buffer will be read.
	 * @throws IOException in case the file cannot be read.
	 * 
	 * Caution!!! The half that is to be read is flushed (filled with
	 * '\u0000') first.
	 */
	private int fillBufferHalf(byte half) throws IOException {
		nullifyBuffer(half);
		if(half == LEFT_HALF) {
			return reader.read(buffer, 0, BUFFER_SIZE/2);
		}else {
			return reader.read(buffer, BUFFER_SIZE/2, BUFFER_SIZE/2);
		}
	}
	
	/**
	 * 
	 * @return returns the next character in the buffer.
	 * @throws IOException if an io error occurs while reading the file.
	 */
	private char nextChar() throws IOException {
		int eof = 0;
		if( (front == (BUFFER_SIZE/2-1)) && !retractBoundaryFlag ) {
			if(eof == -1)
				throw new IOException("EOF");
			eof = fillBufferHalf(RIGHT_HALF);
			front++;
		}else if( (front == BUFFER_SIZE-1) && !retractBoundaryFlag ) {
			if(eof == -1)
				throw new IOException("EOF");
			eof = fillBufferHalf(LEFT_HALF);
			front = 0;
		}else if(retractBoundaryFlag){
			retractBoundaryFlag = false;
			if(front == (BUFFER_SIZE/2-1))
				front++;
			else if(front == BUFFER_SIZE-1)
				front = 0;
		}else {
			front++;
		}
		if( (buffer[front] == '\n') || isWhiteSpace(buffer[front]) ) {
			;
		}else {
			lineIsBlank = false;
		}
		if(buffer[front] == '\n') {
			if(lineIsBlank)
				blankLoc++;
			lineIsBlank = true;
			loc++;
		}
		
		return buffer[front];
	}
	
	/**
	 * This method can be used to peek at the previous char
	 * in the stream.  Leaves the stream pointers intact.
	 * 
	 * @param index 1 for previous character, 2 for the one before the previuos, etc.
	 * @return The previous character in the stream
	 */
	private char previousChar(int index) {
		if( (front - index) < 0 ) {
			return buffer[BUFFER_SIZE-(index-front)];
		}else {
			return buffer[front - index];
		}
	}
	
	/**
	 * This method can be used to get tokens from the input stream.
	 * The resulting Token object contains the type of the token
	 * and the actual lexeme.
	 * 
	 * @return returns the next token recognized in the stream.
	 */
	public Token nextToken() {
		char c;
		state = 0;
		while(true) {
			try {
				switch(state) {
					case 0:
						c = nextChar();
												
						if(c == '\u0000') {
							loc++;
							return new Token(EOF, "EOF", loc, blankLoc, commentLoc, codeCommentLoc);
						}else if( c == '\r' ) {
							state = 59;
						}else if(isWhiteSpace(c)) {
							if(back == BUFFER_SIZE - 1)
								back = 0;
							else
								back++;
						}else if(isNewline(c)) {
							if(back == BUFFER_SIZE - 1)
								back = 0;
							else
								back++;
						}else if( (c == '_') || isLetter(c) ) {
							state = 1;
						}else if( c == '"' ) {
							state = 2;
						}else if( c == '\'' ) {
							state = 5;
						}else if( c == '0' ) {
							state = 24;
						}else if( isDigit(c) ) {
							state = 9;
						}else if( c == '-' ) {
							state = 8;
						}else if( c == '.' ) {
							state = 26;
						}else if( c == '+' ) {
							state = 29;
						}else if( c == '<' ) {
							state = 34;
						}else if( c == '>' ) {
							state = 38;
						}else if( c == '=' ) {
							state = 42;
						}else if( c == '!' ) {
							state = 44;
						}else if( c == '&' ) {
							state = 46;
						}else if( c == '|' ) {
							state = 49;
						}else if( c == '%' ) {
							state = 52;
						}else if( c == '*' ) {
							state = 54;
						}else if( c == '^' ) {
							state = 56;
						}else if( isOperatorButNotFSlash(c) ) {
							state = 13;
						}else if( c == '/' ) {
							state = 14;
						}else if(c == '#') {
							state = 20;
						}
						break;
					case 1:
						c = nextChar();
						if( c == '_' || isLetter(c) || isDigit(c) ) {
							;
						}else {
							state = 0;
							char[] token = createToken();
							String tokenString = new String(token);
							if(keywords.containsKey(tokenString)) {
								back = front;
								retract();
								return new Token(keywords.get(tokenString).intValue(), tokenString, loc, blankLoc, commentLoc, codeCommentLoc);
							}
							identifiers.add( tokenString );
							back = front;
							retract();
							return new Token(IDENTIFIER, tokenString, loc, blankLoc, commentLoc, codeCommentLoc);
						}
						break;
					case 2:
						c = nextChar();
						if(c == '\\') {
							state = 3;
						}else if(c == '"') {
							state = 4;
						}else {
							;
						}
						break;
					case 3:
						c = nextChar();
						state = 2;
						break;
					case 4:
						c = nextChar();
						state = 0;
						char[] token = createToken();
						back = front;
						retract();
						return new Token(STRING, new String(token), loc, blankLoc, commentLoc, codeCommentLoc);
					case 5:
						c = nextChar();
						if(c == '\\') {
							state = 6;
						}else if(c == '\'') {
							state = 7;
						}else {
							;
						}
						break;
					case 6:
						c = nextChar();
						state = 5;
						break;
					case 7:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						return new Token(CHARACTER, new String(token), loc, blankLoc, commentLoc, codeCommentLoc);
					case 8:
						c = nextChar();
						if(isDigit(c)) {
							state = 9;
						}else if(isOperator(c)) {
							retract();
							state = 27;
						}else {
							state = 0;
							back = front;
							retract();
							return new Token(MINUS, "-", loc, blankLoc, commentLoc, codeCommentLoc);
						}
						break;
					case 9:
						c = nextChar();
						if( (c == 'e') || (c == 'E') ) {
							state = 11;
						}else if( c == '.' ) {
							state = 10;
						}else if( isDigit(c) ) {
							;
						}else if( (c == 'l') || (c == 'L') ){
							state  = 23;
						}else {
							state = 0;
							token = createToken();
							back = front;
							retract();
							return new Token(NUMBER, new String(token), loc, blankLoc, commentLoc, codeCommentLoc);
						}
						break;
					case 10:
						c = nextChar();
						if(isDigit(c)) {
							;
						}else if( (c == 'e') || (c == 'E') ) {
							state = 11;
						}else {
							state = 0;
							token = createToken();
							back = front;
							retract();
							return new Token(NUMBER, new String(token), loc, blankLoc, commentLoc, codeCommentLoc);
						}
						break;
					case 11:
						c = nextChar();
						if(isDigit(c) || (c == '-') ) {
							state = 12;
						}
						break;
					case 12:
						c = nextChar();
						if(isDigit(c)) {
							;
						}else {
							state = 0;
							token = createToken();
							back = front;
							retract();
							return new Token(NUMBER, new String(token), loc, blankLoc, commentLoc, codeCommentLoc);
						}
						break;
					case 13:
						c = nextChar();
						state = 0;
						token = createToken();
						String tokenString = new String(token);
						back = front;
						retract();
						return new Token(operatorsReverse.get(new String(tokenString)), tokenString, loc, blankLoc, commentLoc, codeCommentLoc);
					case 14:
						c = nextChar();
						char temp =previousChar(2);
						if(c == '*') {
							state = 15;
							if( ! ( (temp == '\n') || isWhiteSpace(temp) ) )
								codeCommentLoc++;
						}else if(c == '/') {
							state = 18;
							if( ! ( (temp == '\n') || isWhiteSpace(temp) ) )
								codeCommentLoc++;
						}else if(c == '=') {
							state = 58;
						}else if(isOperator(c)){
							retract();
							state = 13;
						} else {
							state = 0;
							back = front;
							retract();
							return new Token(DIVISION, "/", loc, blankLoc, commentLoc, codeCommentLoc);
						}
						break;
					case 15:
						c = nextChar();
						if(c == '*') {
							state = 16;
						}else {
							if(isNewline(c)) {
								commentLoc++;
								if(lineIsBlank)
									blankLoc--;
							}
						}
						break;
					case 16:
						c = nextChar();
						if(c == '/') {
							state = 17;
						}else if(c == '*') {
							;
						}else {
							if(isNewline(c)) {
								commentLoc++;
								if(lineIsBlank)
									blankLoc--;
							}
							state = 15;
						}
						break;
					case 17:
						c = nextChar();
						back = front;
						if( !(c == '\n' || isWhiteSpace(c) ) )
							codeCommentLoc++;
						retract();
						commentLoc++;
						return new Token(COMMENT, "COMMENT", loc, blankLoc, commentLoc, codeCommentLoc);
					case 18:
						c = nextChar();
						if(isNewline(c) || (c == '\u0000')) {
							state = 19;
							commentLoc++;
						}else {
							;
						}
						break;
					case 19:
						c = nextChar();
						back = front;
						retract();
						return new Token(COMMENT, "COMMENT", loc, blankLoc, commentLoc, codeCommentLoc);
					case 20:
						c = nextChar();
						if(isNewline(c) || (c == '\u0000')) {
							state = 22;
						}else if(c == '\\'){
							state = 21;
						}else if(c == '/') {
							state = 61;
						}else {
							;
						}
						break;
					case 21:
						c = nextChar();
						if (c != '\n' && c != '\r'){
						  state = 20;
						}
						break;
					case 22:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						String tokenStr = new String(token);
						System.out.println(tokenStr);
						String[] parts = tokenStr.split("#\\sdefine\\s");
						if(parts[0].startsWith("#"))
							return new Token(PREPROCESSOR, "PREPROCESSOR", loc, blankLoc, commentLoc, codeCommentLoc);
						else
							return new Token(PREPROCESSOR, "DEFINE", loc, blankLoc, commentLoc, codeCommentLoc);
					case 23:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						return new Token(NUMBER, new String(token), loc, blankLoc, commentLoc, codeCommentLoc);
					case 24:
						c = nextChar();
						if( (c == 'x') || (c == 'X') ) {
							state = 25;
						}else if(isDigit(c)) {
							state = 9;
						}else {
							state = 0;
							token = createToken();
							back = front;
							retract();
							return new Token(NUMBER, new String(token), loc, blankLoc, commentLoc, codeCommentLoc);
						}
						break;
					case 25:
						c = nextChar();
						if( (c == 'a') || (c == 'A') || (c == 'b') || (c == 'B')
							|| (c == 'c') || (c == 'C') || (c == 'd') || (c == 'D')
							|| (c == 'e') || (c == 'E') || (c == 'f') || (c == 'F') || (isDigit(c))) {
							;
						}else {
							state = 0;
							token = createToken();
							back = front;
							retract();
							return new Token(NUMBER, new String(token), loc, blankLoc, commentLoc, codeCommentLoc);
						}
						break;
					case 26:
						c = nextChar();
						if(isDigit(c)) {
							state = 9;
						}else if(isOperator(c)) {
							retract();
							state = 13;
						}else {
							state = 0;
							back = front;
							retract();
							return new Token(MEMBER, new String("."), loc, blankLoc, commentLoc, codeCommentLoc);
						}
						break;
					case 27:
						c = nextChar();
						System.out.println("char:::"+c);
						if( c == '-' ) {
							System.out.println("char:::-");
							state = 28;
						}else if( c == '>' ) {
							state = 32;
						}else if( c == '(' ) {
							state = 0;
						}else if( c == '=' ) {
							state = 33;
						}
						break;
					case 28:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						return new Token(DECREMENT, new String("--"), loc, blankLoc, commentLoc, codeCommentLoc);
					case 29:
						c = nextChar();
						if( c == '+' ) {
							state = 30;
						}else if( c == '=' ) {
							state = 31;
						}else {
							state = 0;
							token = createToken();
							back = front;
							retract();
							return new Token(PLUS, new String("+"), loc, blankLoc, commentLoc, codeCommentLoc);
						}
						break;
					case 30:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						return new Token(INCREMENT, new String("++"), loc, blankLoc, commentLoc, codeCommentLoc);
					case 31:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						return new Token(PLUS_ASSIGNMENT, new String("+="), loc, blankLoc, commentLoc, codeCommentLoc);
					case 32:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						return new Token(INDIRECTION, "->", loc, blankLoc, commentLoc, codeCommentLoc);
					case 33:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						return new Token(MINUS_ASSIGNMENT, "-=", loc, blankLoc, commentLoc, codeCommentLoc);
					case 34:
						c = nextChar();
						if( c == '=' ) {
							state = 35;
						}else if( c == '<' ) {
							state = 36;
						}else {
							state = 0;
							token = createToken();
							back = front;
							retract();
							return new Token(LESS, "<", loc, blankLoc, commentLoc, codeCommentLoc);
						}
						break;
					case 35:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						return new Token(LESS_EQUAL, "<=", loc, blankLoc, commentLoc, codeCommentLoc);
					case 36:
						c = nextChar();
						if( c == '=' ) {
							state = 37;
						}else {
							state = 0;
							token = createToken();
							back = front;
							retract();
							return new Token(SHIFT_LEFT, "<<", loc, blankLoc, commentLoc, codeCommentLoc);
						}
						break;
					case 37:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						return new Token(SHIFT_LEFT_ASSIGNMENT, "<<=", loc, blankLoc, commentLoc, codeCommentLoc);
					case 38:
						c = nextChar();
						if( c == '=' ) {
							state = 39;
						}else if( c == '>' ) {
							state = 40;
						}else {
							state = 0;
							token = createToken();
							back = front;
							retract();
							return new Token(GREATER, ">", loc, blankLoc, commentLoc, codeCommentLoc);
						}
						break;
					case 39:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						return new Token(GREATER_EQUAL, ">=", loc, blankLoc, commentLoc, codeCommentLoc);
					case 40:
						c = nextChar();
						if( c == '=' ) {
							state = 41;
						}else {
							state = 0;
							token = createToken();
							back = front;
							retract();
							return new Token(SHIFT_RIGHT, ">>", loc, blankLoc, commentLoc, codeCommentLoc);
						}
						break;
					case 41:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						return new Token(SHIFT_RIGHT_ASSIGNMENT, ">>=", loc, blankLoc, commentLoc, codeCommentLoc);
					case 42:
						c = nextChar();
						if( c == '=' ) {
							state = 43;
						}else {
							state = 0;
							token = createToken();
							back = front;
							retract();
							return new Token(ASSIGNMENT, "=", loc, blankLoc, commentLoc, codeCommentLoc);
						}
						break;
					case 43:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						return new Token(EQUAL, "==", loc, blankLoc, commentLoc, codeCommentLoc);
					case 44:
						c = nextChar();
						if( c == '=' ) {
							state = 45;
						}else {
							state = 0;
							token = createToken();
							back = front;
							retract();
							return new Token(NEGATION, "!", loc, blankLoc, commentLoc, codeCommentLoc);
						}
						break;
					case 45:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						return new Token(NOT_EQUAL, "!=", loc, blankLoc, commentLoc, codeCommentLoc);
					case 46:
						c = nextChar();
						if( c == '&' ) {
							state = 47;
						}else if( c == '=' ) {
							state = 48;
						}else {
							state = 0;
							token = createToken();
							back = front;
							retract();
							return new Token(ADDRESS, new String("&"), loc, blankLoc, commentLoc, codeCommentLoc);
						}
						break;
					case 47:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						return new Token(LOGICAL_AND, "&&", loc, blankLoc, commentLoc, codeCommentLoc);
					case 48:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						return new Token(ADDRESS_ASSIGNMENT, "&=", loc, blankLoc, commentLoc, codeCommentLoc);
					case 49:
						c = nextChar();
						if( c == '|' ) {
							state = 50;
						}else if( c == '=' ) {
							state = 51;
						}else {
							state = 0;
							token = createToken();
							back = front;
							retract();
							return new Token(OR, new String("|"), loc, blankLoc, commentLoc, codeCommentLoc);
						}
						break;
					case 50:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						return new Token(LOGICAL_OR, "||", loc, blankLoc, commentLoc, codeCommentLoc);
					case 51:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						return new Token(OR_ASSIGNMENT, "|=", loc, blankLoc, commentLoc, codeCommentLoc);
					case 52:
						c = nextChar();
						if( c == '=' ) {
							state = 53;
						}else {
							state = 0;
							token = createToken();
							back = front;
							retract();
							return new Token(REMAINDER, new String("%"), loc, blankLoc, commentLoc, codeCommentLoc);
						}
						break;
					case 53:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						return new Token(REMAINDER_ASSIGNMENT, "%=", loc, blankLoc, commentLoc, codeCommentLoc);
					case 54:
						c = nextChar();
						if( c == '=' ) {
							state = 55;
						}else {
							state = 0;
							token = createToken();
							back = front;
							retract();
							return new Token(DEREFERENCE, new String("*"), loc, blankLoc, commentLoc, codeCommentLoc);
						}
						break;
					case 55:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						return new Token(DEREFERENCE_ASSIGNMENT, "*=", loc, blankLoc, commentLoc, codeCommentLoc);
					case 56:
						c = nextChar();
						if( c == '=' ) {
							state = 57;
						}else {
							state = 0;
							token = createToken();
							back = front;
							retract();
							return new Token(XOR, new String("^"), loc, blankLoc, commentLoc, codeCommentLoc);
						}
						break;
					case 57:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						return new Token(XOR_ASSIGNMENT, "^=", loc, blankLoc, commentLoc, codeCommentLoc);
					case 58:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						return new Token(DIVISION_ASSIGNMENT, "/=", loc, blankLoc, commentLoc, codeCommentLoc);
					case 59:
						c = nextChar();
						if( c == '\n' ) {
							state = 60;
						}else {
							state = 0;
							token = createToken();
							back = front;
							retract();
						}
						break;
					case 60:
						c = nextChar();
						state = 0;
						token = createToken();
						back = front;
						retract();
						break;
					case 61:
						c = nextChar();
						if(c == '/'){
							state = 22;
							retract();
							retract();
						}else {
							state = 20;
							retract();
						}
						break;
				}
			}catch(IOException ioe) {
				return new Token(EOF, "EOF", loc, blankLoc, commentLoc, codeCommentLoc);
			}
		}
	}
	
	/**
	 * Retract the front pointer by one.
	 * This method sets retractBoundaryFlag to true
	 * if the pointer crosses a boundary.  This ensures that
	 * the part of the buffer after the boundary is not flushed twice.
	 */
	private void retract() {
		if(buffer[front] == '\n') {
			loc--;
			if(lineIsBlank)
				blankLoc--;
		}
		switch(front) {
			case 0:
				front = BUFFER_SIZE-1;
				retractBoundaryFlag = true;
				break;
			case (BUFFER_SIZE/2):
				front--;
				retractBoundaryFlag = true;
				break;
			default:
				front--;
				break;
		}
	}
	
	/**
	 * The back and front pointers are left unchanged after a call
	 * to this method.
	 * 
	 * @return The chars between the back and front pointers.
	 */
	private char[] createToken() {
		char[] token;
		if( ( front < BUFFER_SIZE/2 ) && ( back >= BUFFER_SIZE/2 ) ) {
			int leftSide = BUFFER_SIZE - back;
			token = new char[leftSide + front];
			for(int i = 0; i < leftSide; i++) {
				token[i] = buffer[i+back];
			}
			int j = 0;
			for(int i = leftSide; i < token.length; i++) {
				token[i] = buffer[j++];
			}
		}else {
			token = new char[front - back];
			for(int i = 0; i < token.length; i++) {
				token[i] = buffer[i+back];
			}
		}
		return token;
	}
	
	/**
	 * 
	 * @param identifier A char array to be searched for in the keywords
	 * hash set.
	 * @return True if the param is a keyword, false otherwise.
	 */
	public boolean isKeyword(char[] identifier) {
		String str = new String(identifier);
		return keywords.contains(str);
	}
	
	/**
	 * 
	 * @param c A char to be checked, wheter it is whitespace or not.
	 * @return True if the char is white space (except for \n), false
	 * otherwise.
	 */
	private boolean isWhiteSpace(char c) {
		switch(c) {
			case ' ':
			case '\t':
			case '\r':
				return true;
			default:
				return false;
		}
	}
	
	/**
	 * 
	 * @param c Checks whether this param is equal to '\n'
	 * @return True if param is equal to '\n', false otherwise.
	 */
	private boolean isNewline(char c) {
		return (c == '\n');
	}
	
	private boolean isLetter(char c) {
		return Character.isLetter(c);
	}
	
	private boolean isDigit(char c) {
		return Character.isDigit(c);
	}
	
	private boolean isOperator(char c) {
		return ( isOperatorButNotFSlash(c) || (c == '/') );
	}
	
	private boolean isOperatorButNotFSlash(char c) {
		switch(c) {
			case '(':
			case ')':
			case '[':
			case ']':
			case '-':
			case '>':
			case '.':
			case '+':
			case '~':
			case '!':
			case '&':
			case '*':
			case '%':
			case '<':
			case '=':
			case '^':
			case '|':
			case '?':
			case ':':
			case ',':
			case '{':
			case '}':
			case ';':
				return true;
			default:
				return false;					
		}
	}
	
	/**
	 * This method is used to flush one (left/right) half of a buffer.
	 * 
	 * @param half Specifies the half of the buffer to be flushed.
	 */
	private void nullifyBuffer(byte half) {
		if(half == LEFT_HALF) {
			for(int i = 0; i < BUFFER_SIZE/2; i++)
				buffer[i] = '\u0000';
		}else {
			for(int i = BUFFER_SIZE/2; i < BUFFER_SIZE; i++)
				buffer[i] = '\u0000';
		}
	}
	
	public LinkedList<String> getIdentifiers() {
		return identifiers;
	}
	
	public int getBlankLoc() {
		return blankLoc;
	}

	public int getCodeCommentLoc() {
		return codeCommentLoc;
	}

	public int getCommentLoc() {
		return commentLoc;
	}

	public int getLoc() {
		return loc;
	}

	/**
	 * Called upon finalization to ensure that the reader is closed.
	 */
	public void finalize() throws IOException, Throwable {
		super.finalize();
		reader.close();
	}
	
}
