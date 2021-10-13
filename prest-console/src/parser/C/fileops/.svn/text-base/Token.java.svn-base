package parser.C.fileops;

/**
 * This class is an abstraction for a token.
 * A token is the minimal meaningful unit in a C source file
 * 
 * @author Atac Deniz Oral
 */
public class Token {

	/** The int code of this token */
	private Integer code;
	/** The actual lexeme */
	private String actual;
	/** The line of the lexeme */
	private int lineNo;
	/** The amount of blank loc when this token was read */
	private int blankLoc;
	/** The amount of commentLoc when this token was read */
	private int commentLoc;
	/** The amount of codeCommentLoc when this token was read */
	private int codeCommentLoc;
	
	/**
	 * Zero parameter constructor for creating a Token object.
	 * All the fields are initialized to zero
	 *
	 */
	public Token() {
		this.code = -1;
		this.actual = "";
		this.lineNo = 0;
	}
	
	/**
	 * A new Token instance is constructed with the given parameters
	 * 
	 * @param code	The code of this token selected from codes in the
	 * 				InputReader
	 * @param actual	the actual string of characters this token comprises
	 * @param lineNo	the line number this token was found on
	 * @param blankLoc	the number of blank lines of code found in the source
	 * 					file when this token was read
	 * @param commentLoc	the number of commented lines of code in the
	 * 						source file when this token was read
	 * @param codeCommentLoc	the number of lines that contain both code
	 * 							and comment in the source file when this
	 * 							token was read
	 */
	public Token(Integer code, String actual, int lineNo, int blankLoc, int commentLoc, int codeCommentLoc) {
		this.code = code;
		this.actual = actual;
		this.lineNo = lineNo;
		this.blankLoc = blankLoc;
		this.commentLoc = commentLoc;
		this.codeCommentLoc = codeCommentLoc;
	}

	/**
	 * Getter method for the actual string of characters this token comprises
	 * 
	 * @return	the string of characters this token comprises
	 */
	public String getActual() {
		return actual;
	}

	/**
	 * Setter method for the characters in this token
	 * 
	 * @param actual the string of characters found in this token
	 */
	public void setActual(String actual) {
		this.actual = actual;
	}

	/**
	 * Getter method for determining the code for this token
	 * 
	 * @return	the code for this token, selected from InputReader
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * Setter method for the code of this token
	 * 
	 * @param code	the code to be used for this token, selected from
	 * 				the codes in InputReader
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * This method can be used for determining the line number on which this token
	 * was found in the source file
	 * 
	 * @return the line number this token was found on
	 */
	public int getLineNo() {
		return lineNo;
	}

	/**
	 * This method can be used for setting the line number on which this token
	 * was found in the source file
	 * 
	 * @param lineNo the line number this token was found on
	 */
	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}

	/**
	 * This method can be used for determining the number of blank lines in the
	 * source file when this token was read
	 *  
	 * @return 	the number of blank lines in the source file when this token
	 * 			was read
	 */
	public int getBlankLoc() {
		return blankLoc;
	}

	/**
	 * This method can be used for setting the number of blank lines in the
	 * source file when this token was read
	 * 
	 * @param blankLoc	the number of blank lines in the source file when this token
	 * 					was read
	 */
	public void setBlankLoc(int blankLoc) {
		this.blankLoc = blankLoc;
	}

	/**
	 * This method can be used for determining the number of lines in the
	 * source file that contain both code and comment when this token was read
	 *  
	 * @return 	the number of lines in the source file that contain both code
	 * 			and comment when this token was read
	 */
	public int getCodeCommentLoc() {
		return codeCommentLoc;
	}

	/**
	 * This method can be used for setting the number of lines in the
	 * source file that contain both code and comment when this token was read
	 * 
	 * @param codeCommentLoc	the number of lines in the source file that
	 * 							contain both code and comment when this token
	 * 							was read
	 */
	public void setCodeCommentLoc(int codeCommentLoc) {
		this.codeCommentLoc = codeCommentLoc;
	}

	/**
	 * This method can be used for determining the number of commented lines
	 * of code in the source file when this token was read
	 * 
	 * @return	number of commented lines of code in the source file
	 * 			when this token was read
	 */
	public int getCommentLoc() {
		return commentLoc;
	}

	/**
	 * This method can be used for setting the number of commented lines
	 * of code in the source file when this token was read
	 * 
	 * @param commentLoc	number of commented lines of code in the source file
	 * 						when this token was read
	 */
	public void setCommentLoc(int commentLoc) {
		this.commentLoc = commentLoc;
	}
	
}
