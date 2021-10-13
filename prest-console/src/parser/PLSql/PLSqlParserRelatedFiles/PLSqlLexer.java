// $ANTLR 2.7.5 (20050128): "PLSQLGrammar.g" -> "PLSqlLexer.java"$
package parser.PLSql.PLSqlParserRelatedFiles;
import antlr.CommonToken;

import java.io.InputStream;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.CharStreamException;
import antlr.CharStreamIOException;
import antlr.ANTLRException;
import java.io.Reader;
import java.util.Hashtable;
import antlr.CharScanner;
import antlr.InputBuffer;
import antlr.ByteBuffer;
import antlr.CharBuffer;
import antlr.Token;
import antlr.CommonToken;
import antlr.RecognitionException;
import antlr.NoViableAltForCharException;
import antlr.MismatchedCharException;
import antlr.TokenStream;
import antlr.ANTLRHashString;
import antlr.LexerSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.SemanticException;

public class PLSqlLexer extends antlr.CharScanner implements PLSqlTokenTypes, TokenStream
 {
public PLSqlLexer(InputStream in) {
	this(new ByteBuffer(in));
}
public PLSqlLexer(Reader in) {
	this(new CharBuffer(in));
}
public PLSqlLexer(InputBuffer ib) {
	this(new LexerSharedInputState(ib));
}
public PLSqlLexer(LexerSharedInputState state) {
	super(state);
	caseSensitiveLiterals = false;
	setCaseSensitive(false);
	literals = new Hashtable();
	literals.put(new ANTLRHashString("raw", this), new Integer(96));
	literals.put(new ANTLRHashString("type", this), new Integer(111));
	literals.put(new ANTLRHashString("constant", this), new Integer(48));
	literals.put(new ANTLRHashString("chartorowid", this), new Integer(208));
	literals.put(new ANTLRHashString("name", this), new Integer(47));
	literals.put(new ANTLRHashString("lpad", this), new Integer(194));
	literals.put(new ANTLRHashString("isopen", this), new Integer(138));
	literals.put(new ANTLRHashString("cursor", this), new Integer(54));
	literals.put(new ANTLRHashString("sysdate", this), new Integer(228));
	literals.put(new ANTLRHashString("smallint", this), new Integer(99));
	literals.put(new ANTLRHashString("between", this), new Integer(135));
	literals.put(new ANTLRHashString("comment", this), new Integer(261));
	literals.put(new ANTLRHashString("case", this), new Integer(148));
	literals.put(new ANTLRHashString("while", this), new Integer(64));
	literals.put(new ANTLRHashString("delete", this), new Integer(75));
	literals.put(new ANTLRHashString("transaction", this), new Integer(252));
	literals.put(new ANTLRHashString("end", this), new Integer(42));
	literals.put(new ANTLRHashString("greatest", this), new Integer(218));
	literals.put(new ANTLRHashString("hextoraw", this), new Integer(210));
	literals.put(new ANTLRHashString("uid", this), new Integer(221));
	literals.put(new ANTLRHashString("concat", this), new Integer(191));
	literals.put(new ANTLRHashString("language", this), new Integer(45));
	literals.put(new ANTLRHashString("abs", this), new Integer(178));
	literals.put(new ANTLRHashString("distinct", this), new Integer(152));
	literals.put(new ANTLRHashString("insert", this), new Integer(74));
	literals.put(new ANTLRHashString("declare ", this), new Integer(61));
	literals.put(new ANTLRHashString("reset", this), new Integer(167));
	literals.put(new ANTLRHashString("notfound", this), new Integer(136));
	literals.put(new ANTLRHashString("where", this), new Integer(176));
	literals.put(new ANTLRHashString("grant", this), new Integer(78));
	literals.put(new ANTLRHashString("alter", this), new Integer(76));
	literals.put(new ANTLRHashString("trailing", this), new Integer(225));
	literals.put(new ANTLRHashString("integer", this), new Integer(103));
	literals.put(new ANTLRHashString("rowidtochar", this), new Integer(212));
	literals.put(new ANTLRHashString("then", this), new Integer(129));
	literals.put(new ANTLRHashString("ascii", this), new Integer(179));
	literals.put(new ANTLRHashString("decimal", this), new Integer(105));
	literals.put(new ANTLRHashString("raise", this), new Integer(68));
	literals.put(new ANTLRHashString("system", this), new Integer(162));
	literals.put(new ANTLRHashString("select", this), new Integer(72));
	literals.put(new ANTLRHashString("to", this), new Integer(259));
	literals.put(new ANTLRHashString("lock", this), new Integer(77));
	literals.put(new ANTLRHashString("trunc", this), new Integer(189));
	literals.put(new ANTLRHashString("rtrim", this), new Integer(197));
	literals.put(new ANTLRHashString("and", this), new Integer(133));
	literals.put(new ANTLRHashString("outer", this), new Integer(231));
	literals.put(new ANTLRHashString("not", this), new Integer(49));
	literals.put(new ANTLRHashString("exclusive", this), new Integer(258));
	literals.put(new ANTLRHashString("package", this), new Integer(38));
	literals.put(new ANTLRHashString("return", this), new Integer(70));
	literals.put(new ANTLRHashString("fetch", this), new Integer(83));
	literals.put(new ANTLRHashString("share", this), new Integer(257));
	literals.put(new ANTLRHashString("%rowcount", this), new Integer(151));
	literals.put(new ANTLRHashString("mlslabel", this), new Integer(109));
	literals.put(new ANTLRHashString("numeric", this), new Integer(101));
	literals.put(new ANTLRHashString("floor", this), new Integer(181));
	literals.put(new ANTLRHashString("date", this), new Integer(98));
	literals.put(new ANTLRHashString("using", this), new Integer(161));
	literals.put(new ANTLRHashString("dump", this), new Integer(217));
	literals.put(new ANTLRHashString("from", this), new Integer(172));
	literals.put(new ANTLRHashString("null", this), new Integer(50));
	literals.put(new ANTLRHashString("count", this), new Integer(147));
	literals.put(new ANTLRHashString("real", this), new Integer(100));
	literals.put(new ANTLRHashString("last", this), new Integer(86));
	literals.put(new ANTLRHashString("to_number", this), new Integer(215));
	literals.put(new ANTLRHashString("sqrt", this), new Integer(188));
	literals.put(new ANTLRHashString("variance", this), new Integer(207));
	literals.put(new ANTLRHashString("the", this), new Integer(229));
	literals.put(new ANTLRHashString("mod", this), new Integer(184));
	literals.put(new ANTLRHashString("nvl", this), new Integer(220));
	literals.put(new ANTLRHashString("upper", this), new Integer(201));
	literals.put(new ANTLRHashString("rpad", this), new Integer(196));
	literals.put(new ANTLRHashString("open", this), new Integer(82));
	literals.put(new ANTLRHashString("like", this), new Integer(134));
	literals.put(new ANTLRHashString("ref", this), new Integer(121));
	literals.put(new ANTLRHashString("natural", this), new Integer(90));
	literals.put(new ANTLRHashString("authid", this), new Integer(39));
	literals.put(new ANTLRHashString("when", this), new Integer(88));
	literals.put(new ANTLRHashString("flush", this), new Integer(164));
	literals.put(new ANTLRHashString("inner", this), new Integer(175));
	literals.put(new ANTLRHashString("exit", this), new Integer(69));
	literals.put(new ANTLRHashString("leading", this), new Integer(224));
	literals.put(new ANTLRHashString("found", this), new Integer(137));
	literals.put(new ANTLRHashString("exception_init", this), new Integer(117));
	literals.put(new ANTLRHashString("character", this), new Integer(108));
	literals.put(new ANTLRHashString("function", this), new Integer(130));
	literals.put(new ANTLRHashString("trim", this), new Integer(146));
	literals.put(new ANTLRHashString("body", this), new Integer(43));
	literals.put(new ANTLRHashString("with", this), new Integer(71));
	literals.put(new ANTLRHashString("out", this), new Integer(114));
	literals.put(new ANTLRHashString("set", this), new Integer(32));
	literals.put(new ANTLRHashString("escape", this), new Integer(236));
	literals.put(new ANTLRHashString("positive", this), new Integer(91));
	literals.put(new ANTLRHashString("initcap", this), new Integer(192));
	literals.put(new ANTLRHashString("only", this), new Integer(254));
	literals.put(new ANTLRHashString("ceil", this), new Integer(180));
	literals.put(new ANTLRHashString("to_date", this), new Integer(214));
	literals.put(new ANTLRHashString("varchar2", this), new Integer(106));
	literals.put(new ANTLRHashString("round", this), new Integer(186));
	literals.put(new ANTLRHashString("intersect", this), new Integer(170));
	literals.put(new ANTLRHashString("work", this), new Integer(154));
	literals.put(new ANTLRHashString("**", this), new Integer(143));
	literals.put(new ANTLRHashString("shared_pool", this), new Integer(165));
	literals.put(new ANTLRHashString("join", this), new Integer(232));
	literals.put(new ANTLRHashString("rollback", this), new Integer(81));
	literals.put(new ANTLRHashString("commit", this), new Integer(80));
	literals.put(new ANTLRHashString("of", this), new Integer(123));
	literals.put(new ANTLRHashString("subtype", this), new Integer(53));
	literals.put(new ANTLRHashString("is", this), new Integer(40));
	literals.put(new ANTLRHashString("close", this), new Integer(84));
	literals.put(new ANTLRHashString("binary_integer", this), new Integer(89));
	literals.put(new ANTLRHashString("or", this), new Integer(36));
	literals.put(new ANTLRHashString("any", this), new Integer(150));
	literals.put(new ANTLRHashString("create", this), new Integer(35));
	literals.put(new ANTLRHashString("if", this), new Integer(66));
	literals.put(new ANTLRHashString("record", this), new Integer(120));
	literals.put(new ANTLRHashString("length", this), new Integer(183));
	literals.put(new ANTLRHashString("forall", this), new Integer(65));
	literals.put(new ANTLRHashString("least", this), new Integer(219));
	literals.put(new ANTLRHashString("min", this), new Integer(204));
	literals.put(new ANTLRHashString("as", this), new Integer(41));
	literals.put(new ANTLRHashString("first", this), new Integer(85));
	literals.put(new ANTLRHashString("minus", this), new Integer(171));
	literals.put(new ANTLRHashString("by", this), new Integer(126));
	literals.put(new ANTLRHashString("vsize", this), new Integer(223));
	literals.put(new ANTLRHashString("chr", this), new Integer(190));
	literals.put(new ANTLRHashString("pragma", this), new Integer(116));
	literals.put(new ANTLRHashString("all", this), new Integer(149));
	literals.put(new ANTLRHashString("union", this), new Integer(169));
	literals.put(new ANTLRHashString("order", this), new Integer(247));
	literals.put(new ANTLRHashString("double precision", this), new Integer(104));
	literals.put(new ANTLRHashString("both", this), new Integer(226));
	literals.put(new ANTLRHashString("connect", this), new Integer(244));
	literals.put(new ANTLRHashString("show", this), new Integer(33));
	literals.put(new ANTLRHashString("values", this), new Integer(251));
	literals.put(new ANTLRHashString("goto", this), new Integer(67));
	literals.put(new ANTLRHashString("start", this), new Integer(243));
	literals.put(new ANTLRHashString("number", this), new Integer(92));
	literals.put(new ANTLRHashString("declare", this), new Integer(128));
	literals.put(new ANTLRHashString("sign", this), new Integer(187));
	literals.put(new ANTLRHashString("int", this), new Integer(102));
	literals.put(new ANTLRHashString("for", this), new Integer(63));
	literals.put(new ANTLRHashString("exception", this), new Integer(115));
	literals.put(new ANTLRHashString("savepoint", this), new Integer(260));
	literals.put(new ANTLRHashString("ltrim", this), new Integer(195));
	literals.put(new ANTLRHashString("sid", this), new Integer(168));
	literals.put(new ANTLRHashString("boolean", this), new Integer(97));
	literals.put(new ANTLRHashString("collect", this), new Integer(159));
	literals.put(new ANTLRHashString("varchar", this), new Integer(107));
	literals.put(new ANTLRHashString("char", this), new Integer(94));
	literals.put(new ANTLRHashString("substr", this), new Integer(199));
	literals.put(new ANTLRHashString("soundex", this), new Integer(198));
	literals.put(new ANTLRHashString("index", this), new Integer(125));
	literals.put(new ANTLRHashString("loop", this), new Integer(62));
	literals.put(new ANTLRHashString("default", this), new Integer(52));
	literals.put(new ANTLRHashString("rowtype", this), new Integer(112));
	literals.put(new ANTLRHashString("false", this), new Integer(140));
	literals.put(new ANTLRHashString("convert", this), new Integer(209));
	literals.put(new ANTLRHashString("exists", this), new Integer(235));
	literals.put(new ANTLRHashString("table", this), new Integer(124));
	literals.put(new ANTLRHashString("bulk", this), new Integer(158));
	literals.put(new ANTLRHashString("asc", this), new Integer(248));
	literals.put(new ANTLRHashString("userenv", this), new Integer(222));
	literals.put(new ANTLRHashString("session", this), new Integer(163));
	literals.put(new ANTLRHashString("left", this), new Integer(173));
	literals.put(new ANTLRHashString("lower", this), new Integer(193));
	literals.put(new ANTLRHashString("instr", this), new Integer(182));
	literals.put(new ANTLRHashString("desc", this), new Integer(249));
	literals.put(new ANTLRHashString("replace", this), new Integer(37));
	literals.put(new ANTLRHashString("max", this), new Integer(203));
	literals.put(new ANTLRHashString("power", this), new Integer(185));
	literals.put(new ANTLRHashString("sum", this), new Integer(206));
	literals.put(new ANTLRHashString("on", this), new Integer(233));
	literals.put(new ANTLRHashString("cast", this), new Integer(145));
	literals.put(new ANTLRHashString("begin", this), new Integer(60));
	literals.put(new ANTLRHashString("varray", this), new Integer(122));
	literals.put(new ANTLRHashString("prior", this), new Integer(237));
	literals.put(new ANTLRHashString("translate", this), new Integer(200));
	literals.put(new ANTLRHashString("row", this), new Integer(256));
	literals.put(new ANTLRHashString("nowait", this), new Integer(250));
	literals.put(new ANTLRHashString("into", this), new Integer(160));
	literals.put(new ANTLRHashString("execute", this), new Integer(79));
	literals.put(new ANTLRHashString("reverse", this), new Integer(141));
	literals.put(new ANTLRHashString("to_char", this), new Integer(213));
	literals.put(new ANTLRHashString("else", this), new Integer(155));
	literals.put(new ANTLRHashString("java", this), new Integer(46));
	literals.put(new ANTLRHashString("right", this), new Integer(174));
	literals.put(new ANTLRHashString("rawtohex", this), new Integer(211));
	literals.put(new ANTLRHashString("in", this), new Integer(113));
	literals.put(new ANTLRHashString("elsif", this), new Integer(156));
	literals.put(new ANTLRHashString("mode", this), new Integer(255));
	literals.put(new ANTLRHashString("avg", this), new Integer(202));
	literals.put(new ANTLRHashString("decode", this), new Integer(216));
	literals.put(new ANTLRHashString("update", this), new Integer(73));
	literals.put(new ANTLRHashString("procedure", this), new Integer(127));
	literals.put(new ANTLRHashString("true", this), new Integer(139));
	literals.put(new ANTLRHashString("left ", this), new Integer(230));
	literals.put(new ANTLRHashString("stddev", this), new Integer(205));
	literals.put(new ANTLRHashString("long", this), new Integer(95));
	literals.put(new ANTLRHashString("read", this), new Integer(253));
	literals.put(new ANTLRHashString("group", this), new Integer(245));
	literals.put(new ANTLRHashString("immediate", this), new Integer(157));
	literals.put(new ANTLRHashString("having", this), new Integer(246));
	literals.put(new ANTLRHashString("user", this), new Integer(227));
}

public Token nextToken() throws TokenStreamException {
	Token theRetToken=null;
tryAgain:
	for (;;) {
		Token _token = null;
		int _ttype = Token.INVALID_TYPE;
		resetText();
		try {   // for char stream error handling
			try {   // for lexical error handling
				switch ( LA(1)) {
				case 'a':  case 'b':  case 'c':  case 'd':
				case 'e':  case 'f':  case 'g':  case 'h':
				case 'i':  case 'j':  case 'k':  case 'l':
				case 'm':  case 'n':  case 'o':  case 'p':
				case 'q':  case 'r':  case 's':  case 't':
				case 'u':  case 'v':  case 'w':  case 'x':
				case 'y':  case 'z':
				{
					mIDENTIFIER(true);
					theRetToken=_returnToken;
					break;
				}
				case '\'':
				{
					mQUOTED_STRING(true);
					theRetToken=_returnToken;
					break;
				}
				case '"':
				{
					mDOUBLE_QUOTED_STRING(true);
					theRetToken=_returnToken;
					break;
				}
				case ';':
				{
					mSEMI(true);
					theRetToken=_returnToken;
					break;
				}
				case ',':
				{
					mCOMMA(true);
					theRetToken=_returnToken;
					break;
				}
				case '*':
				{
					mASTERISK(true);
					theRetToken=_returnToken;
					break;
				}
				case '@':
				{
					mAT_SIGN(true);
					theRetToken=_returnToken;
					break;
				}
				case ')':
				{
					mCLOSE_PAREN(true);
					theRetToken=_returnToken;
					break;
				}
				case '+':
				{
					mPLUS(true);
					theRetToken=_returnToken;
					break;
				}
				case '%':
				{
					mPERCENTAGE(true);
					theRetToken=_returnToken;
					break;
				}
				case '\t':  case '\n':  case '\r':  case ' ':
				{
					mWS(true);
					theRetToken=_returnToken;
					break;
				}
				default:
					if ((LA(1)=='.') && (LA(2)=='.')) {
						mDOUBLEDOT(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='|') && (LA(2)=='|')) {
						mCONCAT(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='(') && (LA(2)=='+')) {
						mOUTER_JOIN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='<') && (LA(2)=='<')) {
						mSTART_LABEL(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='>') && (LA(2)=='>')) {
						mEND_LABEL(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)==':') && (LA(2)=='=')) {
						mASSIGNMENT_EQ(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='=') && (LA(2)=='>')) {
						mPASS_BY_NAME(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='-') && (LA(2)=='-')) {
						mSL_COMMENT(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='/') && (LA(2)=='*')) {
						mML_COMMENT(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)==':') && (true)) {
						mCOLON(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='.') && (true)) {
						mDOT(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='(') && (true)) {
						mOPEN_PAREN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='-') && (true)) {
						mMINUS(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='/') && (true)) {
						mDIVIDE(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='=') && (true)) {
						mEQ(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='|') && (true)) {
						mVERTBAR(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='!'||LA(1)=='<'||LA(1)=='^') && (true)) {
						mNOT_EQ(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='>') && (true)) {
						mGT(true);
						theRetToken=_returnToken;
					}
					else if ((_tokenSet_0.member(LA(1))) && (true)) {
						mNUMBER(true);
						theRetToken=_returnToken;
					}
				else {
					if (LA(1)==EOF_CHAR) {uponEOF(); _returnToken = makeToken(Token.EOF_TYPE);}
				else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
				}
				if ( _returnToken==null ) continue tryAgain; // found SKIP token
				_ttype = _returnToken.getType();
				_returnToken.setType(_ttype);
				return _returnToken;
			}
			catch (RecognitionException e) {
				throw new TokenStreamRecognitionException(e);
			}
		}
		catch (CharStreamException cse) {
			if ( cse instanceof CharStreamIOException ) {
				throw new TokenStreamIOException(((CharStreamIOException)cse).io);
			}
			else {
				throw new TokenStreamException(cse.getMessage());
			}
		}
	}
}

	public final void mIDENTIFIER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = IDENTIFIER;
		int _saveIndex;
		
		matchRange('a','z');
		{
		_loop575:
		do {
			switch ( LA(1)) {
			case 'a':  case 'b':  case 'c':  case 'd':
			case 'e':  case 'f':  case 'g':  case 'h':
			case 'i':  case 'j':  case 'k':  case 'l':
			case 'm':  case 'n':  case 'o':  case 'p':
			case 'q':  case 'r':  case 's':  case 't':
			case 'u':  case 'v':  case 'w':  case 'x':
			case 'y':  case 'z':
			{
				matchRange('a','z');
				break;
			}
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':
			{
				matchRange('0','9');
				break;
			}
			case '_':
			{
				match('_');
				break;
			}
			case '$':
			{
				match('$');
				break;
			}
			case '#':
			{
				match('#');
				break;
			}
			default:
			{
				break _loop575;
			}
			}
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			
			SoftwareMetrics.adjustMetrics(getText(), getLine());
			
		}
		_ttype = testLiteralsTable(_ttype);
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mANY_CHARACTER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ANY_CHARACTER;
		int _saveIndex;
		
		matchRange('a','z');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mQUOTED_STRING(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = QUOTED_STRING;
		int _saveIndex;
		
		{
		int _cnt583=0;
		_loop583:
		do {
			if ((LA(1)=='\'')) {
				match('\'');
				{
				_loop582:
				do {
					if ((LA(1)=='\n'||LA(1)=='\r')) {
						{
						switch ( LA(1)) {
						case '\n':
						{
							match('\n');
							break;
						}
						case '\r':
						{
							match('\r');
							{
							if ((LA(1)=='\n') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
								match('\n');
							}
							else if (((LA(1) >= '\u0003' && LA(1) <= '\u00ff')) && (true)) {
							}
							else {
								throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
							}
							
							}
							break;
						}
						default:
						{
							throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
						}
						}
						}
						if ( inputState.guessing==0 ) {
							newline();
						}
					}
					else if ((_tokenSet_1.member(LA(1)))) {
						matchNot('\'');
					}
					else {
						break _loop582;
					}
					
				} while (true);
				}
				match('\'');
			}
			else {
				if ( _cnt583>=1 ) { break _loop583; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt583++;
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			
			SoftwareMetrics.adjustMetrics(getText(), getLine());
			
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDOUBLE_QUOTED_STRING(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DOUBLE_QUOTED_STRING;
		int _saveIndex;
		
		{
		int _cnt588=0;
		_loop588:
		do {
			if ((LA(1)=='"')) {
				match('"');
				{
				_loop587:
				do {
					if ((_tokenSet_2.member(LA(1)))) {
						matchNot('"');
					}
					else {
						break _loop587;
					}
					
				} while (true);
				}
				match('"');
			}
			else {
				if ( _cnt588>=1 ) { break _loop588; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt588++;
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			
			SoftwareMetrics.adjustMetrics(getText(), getLine());
			
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSEMI(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SEMI;
		int _saveIndex;
		
		match(';');
		if ( inputState.guessing==0 ) {
			
			SoftwareMetrics.adjustMetrics(getText(),getLine());
			SoftwareMetrics.incStatements();
			
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOLON(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COLON;
		int _saveIndex;
		
		match(':');
		if ( inputState.guessing==0 ) {
			SoftwareMetrics.adjustMetrics(getText(),getLine());
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDOT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DOT;
		int _saveIndex;
		
		match('.');
		if ( inputState.guessing==0 ) {
			SoftwareMetrics.adjustMetrics(getText(),getLine());
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOMMA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMMA;
		int _saveIndex;
		
		match(',');
		if ( inputState.guessing==0 ) {
			SoftwareMetrics.adjustMetrics(getText(),getLine());
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mASTERISK(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ASTERISK;
		int _saveIndex;
		
		match('*');
		if ( inputState.guessing==0 ) {
			SoftwareMetrics.adjustMetrics(getText(),getLine());
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mAT_SIGN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = AT_SIGN;
		int _saveIndex;
		
		match('@');
		if ( inputState.guessing==0 ) {
			SoftwareMetrics.adjustMetrics(getText(),getLine());
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOPEN_PAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OPEN_PAREN;
		int _saveIndex;
		
		match('(');
		if ( inputState.guessing==0 ) {
			SoftwareMetrics.adjustMetrics(getText(),getLine());
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCLOSE_PAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CLOSE_PAREN;
		int _saveIndex;
		
		match(')');
		if ( inputState.guessing==0 ) {
			SoftwareMetrics.adjustMetrics(getText(),getLine());
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mPLUS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PLUS;
		int _saveIndex;
		
		match('+');
		if ( inputState.guessing==0 ) {
			SoftwareMetrics.adjustMetrics(getText(),getLine());
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mMINUS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = MINUS;
		int _saveIndex;
		
		match('-');
		if ( inputState.guessing==0 ) {
			SoftwareMetrics.adjustMetrics(getText(),getLine());
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDIVIDE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DIVIDE;
		int _saveIndex;
		
		match('/');
		if ( inputState.guessing==0 ) {
			SoftwareMetrics.adjustMetrics(getText(),getLine());
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mEQ(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EQ;
		int _saveIndex;
		
		match('=');
		if ( inputState.guessing==0 ) {
			SoftwareMetrics.adjustMetrics(getText(),getLine());
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mPERCENTAGE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PERCENTAGE;
		int _saveIndex;
		
		match('%');
		if ( inputState.guessing==0 ) {
			SoftwareMetrics.adjustMetrics(getText(),getLine());
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDOUBLEDOT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DOUBLEDOT;
		int _saveIndex;
		
		match("..");
		if ( inputState.guessing==0 ) {
			SoftwareMetrics.adjustMetrics(getText(),getLine());
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCONCAT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CONCAT;
		int _saveIndex;
		
		match("||");
		if ( inputState.guessing==0 ) {
			SoftwareMetrics.adjustMetrics(getText(),getLine());
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOUTER_JOIN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OUTER_JOIN;
		int _saveIndex;
		
		match("(+)");
		if ( inputState.guessing==0 ) {
			SoftwareMetrics.adjustMetrics(getText(),getLine());
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSTART_LABEL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = START_LABEL;
		int _saveIndex;
		
		match("<<");
		if ( inputState.guessing==0 ) {
			
			SoftwareMetrics.adjustMetrics(getText(), getLine());
			
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mEND_LABEL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = END_LABEL;
		int _saveIndex;
		
		match(">>");
		if ( inputState.guessing==0 ) {
			
			SoftwareMetrics.adjustMetrics(getText(), getLine());
			
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mASSIGNMENT_EQ(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ASSIGNMENT_EQ;
		int _saveIndex;
		
		match(":=");
		if ( inputState.guessing==0 ) {
			
			SoftwareMetrics.adjustMetrics(getText(), getLine());
			
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mPASS_BY_NAME(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PASS_BY_NAME;
		int _saveIndex;
		
		match("=>");
		if ( inputState.guessing==0 ) {
			
			SoftwareMetrics.adjustMetrics(getText(), getLine());
			
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mVERTBAR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = VERTBAR;
		int _saveIndex;
		
		match('|');
		if ( inputState.guessing==0 ) {
			SoftwareMetrics.adjustMetrics(getText(),getLine());
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mNOT_EQ(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NOT_EQ;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case '<':
		{
			match('<');
			if ( inputState.guessing==0 ) {
				_ttype = LT;
			}
			{
			switch ( LA(1)) {
			case '>':
			{
				{
				match('>');
				if ( inputState.guessing==0 ) {
					_ttype = NOT_EQ;
				}
				}
				break;
			}
			case '=':
			{
				{
				match('=');
				if ( inputState.guessing==0 ) {
					_ttype = LE;
				}
				}
				break;
			}
			default:
				{
				}
			}
			}
			break;
		}
		case '!':
		{
			match("!=");
			break;
		}
		case '^':
		{
			match("^=");
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		if ( inputState.guessing==0 ) {
			
			SoftwareMetrics.adjustMetrics(getText(), getLine());
			
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mGT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = GT;
		int _saveIndex;
		
		match('>');
		{
		if ((LA(1)=='=')) {
			match('=');
			if ( inputState.guessing==0 ) {
				_ttype = GE;
			}
		}
		else {
		}
		
		}
		if ( inputState.guessing==0 ) {
			SoftwareMetrics.adjustMetrics(getText(), getLine());
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mNUMBER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NUMBER;
		int _saveIndex;
		
		{
		boolean synPredMatched620 = false;
		if ((((LA(1) >= '0' && LA(1) <= '9')) && (_tokenSet_0.member(LA(2))))) {
			int _m620 = mark();
			synPredMatched620 = true;
			inputState.guessing++;
			try {
				{
				mN(false);
				mDOT(false);
				mN(false);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched620 = false;
			}
			rewind(_m620);
			inputState.guessing--;
		}
		if ( synPredMatched620 ) {
			mN(false);
			mDOT(false);
			mN(false);
		}
		else if ((LA(1)=='.')) {
			mDOT(false);
			mN(false);
		}
		else if (((LA(1) >= '0' && LA(1) <= '9')) && (true)) {
			mN(false);
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		}
		{
		if ((LA(1)=='e')) {
			match("e");
			{
			switch ( LA(1)) {
			case '+':
			{
				mPLUS(false);
				break;
			}
			case '-':
			{
				mMINUS(false);
				break;
			}
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			}
			}
			mN(false);
		}
		else {
		}
		
		}
		if ( inputState.guessing==0 ) {
			
			SoftwareMetrics.adjustMetrics(getText(), getLine());
			
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = N;
		int _saveIndex;
		
		matchRange('0','9');
		{
		_loop625:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9'))) {
				matchRange('0','9');
			}
			else {
				break _loop625;
			}
			
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mWS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = WS;
		int _saveIndex;
		
		int lcnt = 0;
		
		
		{
		int _cnt630=0;
		_loop630:
		do {
			switch ( LA(1)) {
			case ' ':
			{
				match(' ');
				break;
			}
			case '\t':
			{
				match('\t');
				break;
			}
			case '\n':  case '\r':
			{
				{
				switch ( LA(1)) {
				case '\n':
				{
					match('\n');
					break;
				}
				case '\r':
				{
					match('\r');
					{
					if ((LA(1)=='\n') && (true)) {
						match('\n');
					}
					else {
					}
					
					}
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				}
				}
				if ( inputState.guessing==0 ) {
					lcnt++; newline();
				}
				break;
			}
			default:
			{
				if ( _cnt630>=1 ) { break _loop630; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			}
			_cnt630++;
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			if (lcnt > 0) SoftwareMetrics.incBlanks(lcnt - 1);
		}
		if ( inputState.guessing==0 ) {
			_ttype = Token.SKIP;
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSL_COMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SL_COMMENT;
		int _saveIndex;
		
		match("--");
		{
		_loop634:
		do {
			if ((_tokenSet_3.member(LA(1)))) {
				{
				match(_tokenSet_3);
				}
			}
			else {
				break _loop634;
			}
			
		} while (true);
		}
		{
		switch ( LA(1)) {
		case '\n':
		{
			match('\n');
			break;
		}
		case '\r':
		{
			match('\r');
			{
			if ((LA(1)=='\n')) {
				match('\n');
			}
			else {
			}
			
			}
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		if ( inputState.guessing==0 ) {
			newline();
		}
		if ( inputState.guessing==0 ) {
			SoftwareMetrics.incComments(1);
		}
		if ( inputState.guessing==0 ) {
			_ttype = Token.SKIP;
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mML_COMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ML_COMMENT;
		int _saveIndex;
		
		int lcnt = 0;
		
		
		match("/*");
		{
		_loop640:
		do {
			if (((LA(1)=='*') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff')))&&( LA(2)!='/' )) {
				match('*');
			}
			else if ((LA(1)=='\r') && (LA(2)=='\n')) {
				match('\r');
				match('\n');
				if ( inputState.guessing==0 ) {
					lcnt++; newline();
				}
			}
			else if ((LA(1)=='\r') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
				match('\r');
				if ( inputState.guessing==0 ) {
					lcnt++; newline();
				}
			}
			else if ((LA(1)=='\n')) {
				match('\n');
				if ( inputState.guessing==0 ) {
					lcnt++; newline();
				}
			}
			else if ((_tokenSet_4.member(LA(1)))) {
				{
				match(_tokenSet_4);
				}
			}
			else {
				break _loop640;
			}
			
		} while (true);
		}
		match("*/");
		if ( inputState.guessing==0 ) {
			SoftwareMetrics.incComments(lcnt);
		}
		if ( inputState.guessing==0 ) {
			_ttype = Token.SKIP;
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 288019269919178752L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = new long[8];
		data[0]=-549755823112L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = new long[8];
		data[0]=-17179869192L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = new long[8];
		data[0]=-9224L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = new long[8];
		data[0]=-4398046520328L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	
	}
