// $ANTLR 2.7.5 (20050128): "PLSQLGrammar.g" -> "PLSqlParser.java"$
package parser.PLSql.PLSqlParserRelatedFiles;
import antlr.CommonToken;

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.collections.AST;
import java.util.Hashtable;
import antlr.ASTFactory;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;

public class PLSqlParser extends antlr.LLkParser       implements PLSqlTokenTypes
 {

protected PLSqlParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public PLSqlParser(TokenBuffer tokenBuf) {
  this(tokenBuf,4);
}

protected PLSqlParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public PLSqlParser(TokenStream lexer) {
  this(lexer,4);
}

public PLSqlParser(ParserSharedInputState state) {
  super(state,4);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final void start_rule() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST start_rule_AST = null;
		
		try {      // for error handling
			{
			_loop3:
			do {
				switch ( LA(1)) {
				case LITERAL_create:
				{
					create_package();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_set:
				case LITERAL_show:
				{
					sqlplus_command();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_begin:
				case LITERAL_declare:
				{
					begin_block();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case DIVIDE:
				{
					AST tmp1_AST = null;
					tmp1_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp1_AST);
					match(DIVIDE);
					break;
				}
				default:
				{
					break _loop3;
				}
				}
			} while (true);
			}
			AST tmp2_AST = null;
			tmp2_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp2_AST);
			match(Token.EOF_TYPE);
			if ( inputState.guessing==0 ) {
				start_rule_AST = (AST)currentAST.root;
				
				start_rule_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(START_RULE,"start_rule")).add(start_rule_AST));
				
				currentAST.root = start_rule_AST;
				currentAST.child = start_rule_AST!=null &&start_rule_AST.getFirstChild()!=null ?
					start_rule_AST.getFirstChild() : start_rule_AST;
				currentAST.advanceChildToEnd();
			}
			start_rule_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_0);
			} else {
			  throw ex;
			}
		}
		returnAST = start_rule_AST;
	}
	
	public final void create_package() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST create_package_AST = null;
		Token  cr = null;
		AST cr_AST = null;
		Token  or = null;
		AST or_AST = null;
		
		try {      // for error handling
			cr = LT(1);
			cr_AST = astFactory.create(cr);
			astFactory.addASTChild(currentAST, cr_AST);
			match(LITERAL_create);
			{
			switch ( LA(1)) {
			case LITERAL_or:
			{
				or = LT(1);
				or_AST = astFactory.create(or);
				astFactory.addASTChild(currentAST, or_AST);
				match(LITERAL_or);
				AST tmp3_AST = null;
				tmp3_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp3_AST);
				match(LITERAL_replace);
				break;
			}
			case LITERAL_package:
			case LITERAL_procedure:
			case LITERAL_function:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_procedure:
			{
				procedure_body();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_function:
			{
				function_body();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
				if ((LA(1)==LITERAL_package) && (_tokenSet_1.member(LA(2))) && (_tokenSet_2.member(LA(3))) && (_tokenSet_3.member(LA(4)))) {
					package_spec();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((LA(1)==LITERAL_package) && (_tokenSet_4.member(LA(2))) && (_tokenSet_5.member(LA(3))) && (_tokenSet_6.member(LA(4)))) {
					package_body();
					astFactory.addASTChild(currentAST, returnAST);
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				create_package_AST = (AST)currentAST.root;
				
				create_package_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CREATE_PACKAGE,"create_package")).add(create_package_AST));
				
				currentAST.root = create_package_AST;
				currentAST.child = create_package_AST!=null &&create_package_AST.getFirstChild()!=null ?
					create_package_AST.getFirstChild() : create_package_AST;
				currentAST.advanceChildToEnd();
			}
			create_package_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_7);
			} else {
			  throw ex;
			}
		}
		returnAST = create_package_AST;
	}
	
	public final void sqlplus_command() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST sqlplus_command_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_set:
			{
				AST tmp4_AST = null;
				tmp4_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp4_AST);
				match(LITERAL_set);
				break;
			}
			case LITERAL_show:
			{
				AST tmp5_AST = null;
				tmp5_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp5_AST);
				match(LITERAL_show);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			identifier();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop7:
			do {
				if ((_tokenSet_8.member(LA(1)))) {
					base_expression();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop7;
				}
				
			} while (true);
			}
			{
			_loop9:
			do {
				if ((LA(1)==SEMI)) {
					AST tmp6_AST = null;
					tmp6_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp6_AST);
					match(SEMI);
				}
				else {
					break _loop9;
				}
				
			} while (true);
			}
			sqlplus_command_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_7);
			} else {
			  throw ex;
			}
		}
		returnAST = sqlplus_command_AST;
	}
	
	public final CommonToken  begin_block() throws RecognitionException, TokenStreamException {
		CommonToken e= null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST begin_block_AST = null;
		Token  d = null;
		AST d_AST = null;
		Token  b = null;
		AST b_AST = null;
		Token  en = null;
		AST en_AST = null;
		
		CommonToken pn = null;
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_declare:
			{
				{
				d = LT(1);
				d_AST = astFactory.create(d);
				astFactory.addASTChild(currentAST, d_AST);
				match(LITERAL_declare);
				}
				{
				int _cnt187=0;
				_loop187:
				do {
					if ((_tokenSet_9.member(LA(1)))) {
						declare_spec();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						if ( _cnt187>=1 ) { break _loop187; } else {throw new NoViableAltException(LT(1), getFilename());}
					}
					
					_cnt187++;
				} while (true);
				}
				break;
			}
			case LITERAL_begin:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			b = LT(1);
			b_AST = astFactory.create(b);
			astFactory.addASTChild(currentAST, b_AST);
			match(LITERAL_begin);
			{
			switch ( LA(1)) {
			case LITERAL_set:
			case LITERAL_replace:
			case LITERAL_null:
			case OPEN_PAREN:
			case START_LABEL:
			case LITERAL_begin:
			case LITERAL_loop:
			case LITERAL_for:
			case LITERAL_while:
			case LITERAL_forall:
			case LITERAL_if:
			case LITERAL_goto:
			case LITERAL_raise:
			case LITERAL_exit:
			case LITERAL_return:
			case LITERAL_with:
			case LITERAL_select:
			case LITERAL_update:
			case LITERAL_insert:
			case LITERAL_delete:
			case LITERAL_alter:
			case LITERAL_lock:
			case LITERAL_execute:
			case LITERAL_commit:
			case LITERAL_rollback:
			case LITERAL_open:
			case LITERAL_fetch:
			case LITERAL_close:
			case LITERAL_declare:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_mod:
			case LITERAL_power:
			case LITERAL_round:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_rpad:
			case LITERAL_rtrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_avg:
			case LITERAL_max:
			case LITERAL_min:
			case LITERAL_stddev:
			case LITERAL_sum:
			case LITERAL_variance:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_rowidtochar:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_uid:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case LITERAL_savepoint:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				seq_of_statements();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_end:
			case LITERAL_exception:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_exception:
			{
				AST tmp7_AST = null;
				tmp7_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp7_AST);
				match(LITERAL_exception);
				{
				int _cnt191=0;
				_loop191:
				do {
					if ((LA(1)==LITERAL_when)) {
						e=exception_handler();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						if ( _cnt191>=1 ) { break _loop191; } else {throw new NoViableAltException(LT(1), getFilename());}
					}
					
					_cnt191++;
				} while (true);
				}
				break;
			}
			case LITERAL_end:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			en = LT(1);
			en_AST = astFactory.create(en);
			astFactory.addASTChild(currentAST, en_AST);
			match(LITERAL_end);
			{
			switch ( LA(1)) {
			case LITERAL_replace:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				pn=identifier();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOF:
			case DIVIDE:
			case LITERAL_set:
			case LITERAL_show:
			case SEMI:
			case LITERAL_create:
			case LITERAL_begin:
			case LITERAL_declare:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				begin_block_AST = (AST)currentAST.root;
				
				begin_block_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PLSQL_BLOCK,"begin_block")).add(begin_block_AST));
				
				currentAST.root = begin_block_AST;
				currentAST.child = begin_block_AST!=null &&begin_block_AST.getFirstChild()!=null ?
					begin_block_AST.getFirstChild() : begin_block_AST;
				currentAST.advanceChildToEnd();
			}
			begin_block_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_10);
			} else {
			  throw ex;
			}
		}
		returnAST = begin_block_AST;
		return e;
	}
	
	public final CommonToken  identifier() throws RecognitionException, TokenStreamException {
		 CommonToken id = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST identifier_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  d = null;
		AST d_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case IDENTIFIER:
			{
				i = LT(1);
				i_AST = astFactory.create(i);
				astFactory.addASTChild(currentAST, i_AST);
				match(IDENTIFIER);
				if ( inputState.guessing==0 ) {
					
					id = (CommonToken) i;
					
				}
				break;
			}
			case DOUBLE_QUOTED_STRING:
			{
				d = LT(1);
				d_AST = astFactory.create(d);
				astFactory.addASTChild(currentAST, d_AST);
				match(DOUBLE_QUOTED_STRING);
				if ( inputState.guessing==0 ) {
					
					id = (CommonToken) d;
					
				}
				break;
			}
			case LITERAL_replace:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			{
				id=keyword();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			identifier_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_11);
			} else {
			  throw ex;
			}
		}
		returnAST = identifier_AST;
		return id;
	}
	
	public final void base_expression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST base_expression_AST = null;
		Token  a1 = null;
		AST a1_AST = null;
		Token  a2 = null;
		AST a2_AST = null;
		Token  r = null;
		AST r_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  cp = null;
		AST cp_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_cast:
			{
				{
				cast_proc();
				astFactory.addASTChild(currentAST, returnAST);
				}
				base_expression_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_trim:
			{
				{
				trim_function();
				astFactory.addASTChild(currentAST, returnAST);
				}
				base_expression_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_case:
			{
				{
				case_expression();
				astFactory.addASTChild(currentAST, returnAST);
				}
				base_expression_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_all:
			case LITERAL_any:
			{
				{
				switch ( LA(1)) {
				case LITERAL_all:
				{
					a1 = LT(1);
					a1_AST = astFactory.create(a1);
					astFactory.addASTChild(currentAST, a1_AST);
					match(LITERAL_all);
					break;
				}
				case LITERAL_any:
				{
					a2 = LT(1);
					a2_AST = astFactory.create(a2);
					astFactory.addASTChild(currentAST, a2_AST);
					match(LITERAL_any);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				subquery();
				astFactory.addASTChild(currentAST, returnAST);
				base_expression_AST = (AST)currentAST.root;
				break;
			}
			case NUMBER:
			{
				numeric_literal();
				astFactory.addASTChild(currentAST, returnAST);
				base_expression_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_null:
			case LITERAL_true:
			case LITERAL_false:
			{
				boolean_literal();
				astFactory.addASTChild(currentAST, returnAST);
				base_expression_AST = (AST)currentAST.root;
				break;
			}
			default:
				boolean synPredMatched321 = false;
				if (((LA(1)==LITERAL_count) && (LA(2)==OPEN_PAREN) && (_tokenSet_12.member(LA(3))) && (_tokenSet_13.member(LA(4))))) {
					int _m321 = mark();
					synPredMatched321 = true;
					inputState.guessing++;
					try {
						{
						match(LITERAL_count);
						}
					}
					catch (RecognitionException pe) {
						synPredMatched321 = false;
					}
					rewind(_m321);
					inputState.guessing--;
				}
				if ( synPredMatched321 ) {
					{
					count_function();
					astFactory.addASTChild(currentAST, returnAST);
					}
					base_expression_AST = (AST)currentAST.root;
				}
				else {
					boolean synPredMatched332 = false;
					if (((_tokenSet_14.member(LA(1))) && (_tokenSet_15.member(LA(2))) && (_tokenSet_16.member(LA(3))) && (_tokenSet_17.member(LA(4))))) {
						int _m332 = mark();
						synPredMatched332 = true;
						inputState.guessing++;
						try {
							{
							{
							switch ( LA(1)) {
							case LITERAL_replace:
							case LITERAL_count:
							case LITERAL_intersect:
							case LITERAL_abs:
							case LITERAL_ascii:
							case LITERAL_ceil:
							case LITERAL_floor:
							case LITERAL_instr:
							case LITERAL_length:
							case LITERAL_power:
							case LITERAL_sign:
							case LITERAL_sqrt:
							case LITERAL_trunc:
							case LITERAL_chr:
							case LITERAL_concat:
							case LITERAL_initcap:
							case LITERAL_lower:
							case LITERAL_lpad:
							case LITERAL_ltrim:
							case LITERAL_soundex:
							case LITERAL_substr:
							case LITERAL_translate:
							case LITERAL_upper:
							case LITERAL_chartorowid:
							case LITERAL_convert:
							case LITERAL_hextoraw:
							case LITERAL_rawtohex:
							case LITERAL_to_char:
							case LITERAL_to_date:
							case LITERAL_to_number:
							case LITERAL_decode:
							case LITERAL_dump:
							case LITERAL_greatest:
							case LITERAL_least:
							case LITERAL_nvl:
							case LITERAL_userenv:
							case LITERAL_vsize:
							case LITERAL_user:
							case LITERAL_sysdate:
							case IDENTIFIER:
							case DOUBLE_QUOTED_STRING:
							{
								cursor_name();
								break;
							}
							case OPEN_PAREN:
							{
								subquery();
								break;
							}
							default:
							{
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
							}
							match(151);
							}
						}
						catch (RecognitionException pe) {
							synPredMatched332 = false;
						}
						rewind(_m332);
						inputState.guessing--;
					}
					if ( synPredMatched332 ) {
						{
						{
						switch ( LA(1)) {
						case LITERAL_replace:
						case LITERAL_count:
						case LITERAL_intersect:
						case LITERAL_abs:
						case LITERAL_ascii:
						case LITERAL_ceil:
						case LITERAL_floor:
						case LITERAL_instr:
						case LITERAL_length:
						case LITERAL_power:
						case LITERAL_sign:
						case LITERAL_sqrt:
						case LITERAL_trunc:
						case LITERAL_chr:
						case LITERAL_concat:
						case LITERAL_initcap:
						case LITERAL_lower:
						case LITERAL_lpad:
						case LITERAL_ltrim:
						case LITERAL_soundex:
						case LITERAL_substr:
						case LITERAL_translate:
						case LITERAL_upper:
						case LITERAL_chartorowid:
						case LITERAL_convert:
						case LITERAL_hextoraw:
						case LITERAL_rawtohex:
						case LITERAL_to_char:
						case LITERAL_to_date:
						case LITERAL_to_number:
						case LITERAL_decode:
						case LITERAL_dump:
						case LITERAL_greatest:
						case LITERAL_least:
						case LITERAL_nvl:
						case LITERAL_userenv:
						case LITERAL_vsize:
						case LITERAL_user:
						case LITERAL_sysdate:
						case IDENTIFIER:
						case DOUBLE_QUOTED_STRING:
						{
							cursor_name();
							astFactory.addASTChild(currentAST, returnAST);
							break;
						}
						case OPEN_PAREN:
						{
							subquery();
							astFactory.addASTChild(currentAST, returnAST);
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						r = LT(1);
						r_AST = astFactory.create(r);
						astFactory.addASTChild(currentAST, r_AST);
						match(151);
						}
						base_expression_AST = (AST)currentAST.root;
					}
					else {
						boolean synPredMatched336 = false;
						if (((LA(1)==OPEN_PAREN) && (LA(2)==OPEN_PAREN||LA(2)==LITERAL_with||LA(2)==LITERAL_select) && (_tokenSet_18.member(LA(3))) && (_tokenSet_19.member(LA(4))))) {
							int _m336 = mark();
							synPredMatched336 = true;
							inputState.guessing++;
							try {
								{
								match(OPEN_PAREN);
								match(LITERAL_select);
								}
							}
							catch (RecognitionException pe) {
								synPredMatched336 = false;
							}
							rewind(_m336);
							inputState.guessing--;
						}
						if ( synPredMatched336 ) {
							subquery();
							astFactory.addASTChild(currentAST, returnAST);
							base_expression_AST = (AST)currentAST.root;
						}
						else if ((LA(1)==OPEN_PAREN) && (_tokenSet_20.member(LA(2))) && (_tokenSet_13.member(LA(3))) && (_tokenSet_21.member(LA(4)))) {
							o = LT(1);
							o_AST = astFactory.create(o);
							astFactory.addASTChild(currentAST, o_AST);
							match(OPEN_PAREN);
							plsql_expression();
							astFactory.addASTChild(currentAST, returnAST);
							cp = LT(1);
							cp_AST = astFactory.create(cp);
							match(CLOSE_PAREN);
							base_expression_AST = (AST)currentAST.root;
						}
						else if ((LA(1)==QUOTED_STRING) && (_tokenSet_22.member(LA(2))) && (_tokenSet_23.member(LA(3))) && (_tokenSet_24.member(LA(4)))) {
							char_literal();
							astFactory.addASTChild(currentAST, returnAST);
							base_expression_AST = (AST)currentAST.root;
						}
						else if ((LA(1)==QUOTED_STRING) && (_tokenSet_22.member(LA(2))) && (_tokenSet_23.member(LA(3))) && (_tokenSet_24.member(LA(4)))) {
							date_literal();
							astFactory.addASTChild(currentAST, returnAST);
							base_expression_AST = (AST)currentAST.root;
						}
						else if ((LA(1)==LITERAL_user||LA(1)==LITERAL_sysdate) && (_tokenSet_22.member(LA(2))) && (_tokenSet_23.member(LA(3))) && (_tokenSet_24.member(LA(4)))) {
							pseudo_column();
							astFactory.addASTChild(currentAST, returnAST);
							base_expression_AST = (AST)currentAST.root;
						}
						else if ((_tokenSet_25.member(LA(1))) && (_tokenSet_26.member(LA(2))) && (_tokenSet_27.member(LA(3))) && (_tokenSet_24.member(LA(4)))) {
							lvalue();
							astFactory.addASTChild(currentAST, returnAST);
							base_expression_AST = (AST)currentAST.root;
						}
					else {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}}}
				}
				catch (RecognitionException ex) {
					if (inputState.guessing==0) {
						reportError(ex);
						recover(ex,_tokenSet_22);
					} else {
					  throw ex;
					}
				}
				returnAST = base_expression_AST;
			}
			
	public final CommonToken  package_spec() throws RecognitionException, TokenStreamException {
		CommonToken pn= null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST package_spec_AST = null;
		Token  pk = null;
		AST pk_AST = null;
		Token  au = null;
		AST au_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  a = null;
		AST a_AST = null;
		Token  en = null;
		AST en_AST = null;
		
		CommonToken id=null;
		
		
		try {      // for error handling
			pk = LT(1);
			pk_AST = astFactory.create(pk);
			astFactory.addASTChild(currentAST, pk_AST);
			match(LITERAL_package);
			pn=package_name();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_authid:
			{
				au = LT(1);
				au_AST = astFactory.create(au);
				astFactory.addASTChild(currentAST, au_AST);
				match(LITERAL_authid);
				id=identifier();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_is:
			case LITERAL_as:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				
				SoftwareMetrics.start(pn.getText(),"Package",pk.getLine());
				
			}
			{
			switch ( LA(1)) {
			case LITERAL_is:
			{
				i = LT(1);
				i_AST = astFactory.create(i);
				astFactory.addASTChild(currentAST, i_AST);
				match(LITERAL_is);
				break;
			}
			case LITERAL_as:
			{
				a = LT(1);
				a_AST = astFactory.create(a);
				astFactory.addASTChild(currentAST, a_AST);
				match(LITERAL_as);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			package_obj_spec();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop17:
			do {
				if ((_tokenSet_3.member(LA(1)))) {
					package_obj_spec();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop17;
				}
				
			} while (true);
			}
			en = LT(1);
			en_AST = astFactory.create(en);
			astFactory.addASTChild(currentAST, en_AST);
			match(LITERAL_end);
			{
			switch ( LA(1)) {
			case LITERAL_replace:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				package_name();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(SEMI);
			if ( inputState.guessing==0 ) {
				package_spec_AST = (AST)currentAST.root;
				
				SoftwareMetrics.finish();
				package_spec_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PACKAGE_SPEC,"package_spec")).add(package_spec_AST));
				
				currentAST.root = package_spec_AST;
				currentAST.child = package_spec_AST!=null &&package_spec_AST.getFirstChild()!=null ?
					package_spec_AST.getFirstChild() : package_spec_AST;
				currentAST.advanceChildToEnd();
			}
			package_spec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_7);
			} else {
			  throw ex;
			}
		}
		returnAST = package_spec_AST;
		return pn;
	}
	
	public final CommonToken  package_body() throws RecognitionException, TokenStreamException {
		CommonToken pn= null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST package_body_AST = null;
		Token  pk = null;
		AST pk_AST = null;
		Token  bo = null;
		AST bo_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  a = null;
		AST a_AST = null;
		Token  e = null;
		AST e_AST = null;
		
		try {      // for error handling
			pk = LT(1);
			pk_AST = astFactory.create(pk);
			astFactory.addASTChild(currentAST, pk_AST);
			match(LITERAL_package);
			{
			switch ( LA(1)) {
			case LITERAL_body:
			{
				bo = LT(1);
				bo_AST = astFactory.create(bo);
				astFactory.addASTChild(currentAST, bo_AST);
				match(LITERAL_body);
				break;
			}
			case LITERAL_replace:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			pn=package_name();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_is:
			{
				i = LT(1);
				i_AST = astFactory.create(i);
				astFactory.addASTChild(currentAST, i_AST);
				match(LITERAL_is);
				break;
			}
			case LITERAL_as:
			{
				a = LT(1);
				a_AST = astFactory.create(a);
				astFactory.addASTChild(currentAST, a_AST);
				match(LITERAL_as);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				
				SoftwareMetrics.start(pn.getText(),"Package Body",pn.getLine());
				
			}
			package_obj_body();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop23:
			do {
				if ((_tokenSet_28.member(LA(1)))) {
					package_obj_body();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop23;
				}
				
			} while (true);
			}
			e = LT(1);
			e_AST = astFactory.create(e);
			astFactory.addASTChild(currentAST, e_AST);
			match(LITERAL_end);
			{
			switch ( LA(1)) {
			case LITERAL_replace:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				pn=package_name();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(SEMI);
			if ( inputState.guessing==0 ) {
				package_body_AST = (AST)currentAST.root;
				
				SoftwareMetrics.finish();
				package_body_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PACKAGE_BODY,"package_body")).add(package_body_AST));
				
				currentAST.root = package_body_AST;
				currentAST.child = package_body_AST!=null &&package_body_AST.getFirstChild()!=null ?
					package_body_AST.getFirstChild() : package_body_AST;
				currentAST.advanceChildToEnd();
			}
			package_body_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_7);
			} else {
			  throw ex;
			}
		}
		returnAST = package_body_AST;
		return pn;
	}
	
	public final CommonToken  procedure_body() throws RecognitionException, TokenStreamException {
		 CommonToken pb = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST procedure_body_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  a = null;
		AST a_AST = null;
		
		try {      // for error handling
			pb=procedure_declaration();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_is:
			{
				i = LT(1);
				i_AST = astFactory.create(i);
				astFactory.addASTChild(currentAST, i_AST);
				match(LITERAL_is);
				break;
			}
			case LITERAL_as:
			{
				a = LT(1);
				a_AST = astFactory.create(a);
				astFactory.addASTChild(currentAST, a_AST);
				match(LITERAL_as);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_language:
			{
				foreign_lang_spec();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_replace:
			case LITERAL_subtype:
			case LITERAL_cursor:
			case LITERAL_begin:
			case LITERAL_type:
			case LITERAL_pragma:
			case LITERAL_procedure:
			case LITERAL_function:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				func_proc_statements();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				procedure_body_AST = (AST)currentAST.root;
				
				SoftwareMetrics.finish();
				procedure_body_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PROCEDURE_BODY,"procedure_body")).add(procedure_body_AST));
				
				currentAST.root = procedure_body_AST;
				currentAST.child = procedure_body_AST!=null &&procedure_body_AST.getFirstChild()!=null ?
					procedure_body_AST.getFirstChild() : procedure_body_AST;
				currentAST.advanceChildToEnd();
			}
			procedure_body_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_29);
			} else {
			  throw ex;
			}
		}
		returnAST = procedure_body_AST;
		return pb;
	}
	
	public final CommonToken  function_body() throws RecognitionException, TokenStreamException {
		 CommonToken fb = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_body_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  a = null;
		AST a_AST = null;
		
		try {      // for error handling
			fb=function_declaration();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_is:
			{
				i = LT(1);
				i_AST = astFactory.create(i);
				astFactory.addASTChild(currentAST, i_AST);
				match(LITERAL_is);
				break;
			}
			case LITERAL_as:
			{
				a = LT(1);
				a_AST = astFactory.create(a);
				astFactory.addASTChild(currentAST, a_AST);
				match(LITERAL_as);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_language:
			{
				foreign_lang_spec();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_replace:
			case LITERAL_subtype:
			case LITERAL_cursor:
			case LITERAL_begin:
			case LITERAL_type:
			case LITERAL_pragma:
			case LITERAL_procedure:
			case LITERAL_function:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				func_proc_statements();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				
				SoftwareMetrics.finish();
				
			}
			if ( inputState.guessing==0 ) {
				function_body_AST = (AST)currentAST.root;
				function_body_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FUNCTION_BODY,"function_body")).add(function_body_AST));
				currentAST.root = function_body_AST;
				currentAST.child = function_body_AST!=null &&function_body_AST.getFirstChild()!=null ?
					function_body_AST.getFirstChild() : function_body_AST;
				currentAST.advanceChildToEnd();
			}
			function_body_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_29);
			} else {
			  throw ex;
			}
		}
		returnAST = function_body_AST;
		return fb;
	}
	
	public final CommonToken  package_name() throws RecognitionException, TokenStreamException {
		CommonToken id= null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST package_name_AST = null;
		Token  d = null;
		AST d_AST = null;
		
		CommonToken s = null;
		
		
		try {      // for error handling
			id=schema_name();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case DOT:
			{
				d = LT(1);
				d_AST = astFactory.create(d);
				astFactory.addASTChild(currentAST, d_AST);
				match(DOT);
				s=identifier();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			case LITERAL_authid:
			case LITERAL_is:
			case LITERAL_as:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				
				if (s != null)
				id.setText(id.getText() + '.' +s.getText());
				
			}
			package_name_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_30);
			} else {
			  throw ex;
			}
		}
		returnAST = package_name_AST;
		return id;
	}
	
	public final void package_obj_spec() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST package_obj_spec_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_subtype:
			{
				subtype_declaration();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_procedure:
			{
				procedure_spec();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_function:
			{
				function_spec();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
				if ((_tokenSet_1.member(LA(1))) && (_tokenSet_31.member(LA(2))) && (_tokenSet_32.member(LA(3))) && (_tokenSet_33.member(LA(4)))) {
					variable_declaration();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((LA(1)==LITERAL_cursor) && (_tokenSet_1.member(LA(2))) && (LA(3)==LITERAL_is||LA(3)==OPEN_PAREN) && (_tokenSet_34.member(LA(4)))) {
					cursor_declaration();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((LA(1)==LITERAL_cursor) && (_tokenSet_1.member(LA(2))) && (LA(3)==OPEN_PAREN||LA(3)==LITERAL_return) && (_tokenSet_35.member(LA(4)))) {
					cursor_spec();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((_tokenSet_36.member(LA(1))) && (_tokenSet_35.member(LA(2))) && (_tokenSet_37.member(LA(3))) && (_tokenSet_38.member(LA(4)))) {
					record_declaration();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((_tokenSet_36.member(LA(1))) && (_tokenSet_35.member(LA(2))) && (_tokenSet_39.member(LA(3))) && (_tokenSet_40.member(LA(4)))) {
					plsql_table_declaration();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((_tokenSet_1.member(LA(1))) && (LA(2)==DOT||LA(2)==LITERAL_exception)) {
					exception_declaration();
					astFactory.addASTChild(currentAST, returnAST);
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			package_obj_spec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_41);
			} else {
			  throw ex;
			}
		}
		returnAST = package_obj_spec_AST;
	}
	
	public final void package_obj_body() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST package_obj_body_AST = null;
		
		try {      // for error handling
			{
			if ((LA(1)==LITERAL_function) && (_tokenSet_1.member(LA(2))) && (LA(3)==DOT||LA(3)==OPEN_PAREN||LA(3)==LITERAL_return) && (_tokenSet_35.member(LA(4)))) {
				{
				boolean synPredMatched44 = false;
				if (((LA(1)==LITERAL_function) && (_tokenSet_1.member(LA(2))) && (LA(3)==DOT||LA(3)==OPEN_PAREN||LA(3)==LITERAL_return) && (_tokenSet_35.member(LA(4))))) {
					int _m44 = mark();
					synPredMatched44 = true;
					inputState.guessing++;
					try {
						{
						function_declaration();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched44 = false;
					}
					rewind(_m44);
					inputState.guessing--;
				}
				if ( synPredMatched44 ) {
					function_body();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((LA(1)==LITERAL_function) && (_tokenSet_1.member(LA(2))) && (LA(3)==DOT||LA(3)==OPEN_PAREN||LA(3)==LITERAL_return) && (_tokenSet_35.member(LA(4)))) {
					function_spec();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
			}
			else if ((LA(1)==LITERAL_procedure) && (_tokenSet_1.member(LA(2))) && (_tokenSet_42.member(LA(3))) && (_tokenSet_43.member(LA(4)))) {
				{
				boolean synPredMatched47 = false;
				if (((LA(1)==LITERAL_procedure) && (_tokenSet_1.member(LA(2))) && (_tokenSet_44.member(LA(3))) && (_tokenSet_45.member(LA(4))))) {
					int _m47 = mark();
					synPredMatched47 = true;
					inputState.guessing++;
					try {
						{
						procedure_declaration();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched47 = false;
					}
					rewind(_m47);
					inputState.guessing--;
				}
				if ( synPredMatched47 ) {
					procedure_body();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((LA(1)==LITERAL_procedure) && (_tokenSet_1.member(LA(2))) && (LA(3)==SEMI||LA(3)==DOT||LA(3)==OPEN_PAREN) && (_tokenSet_41.member(LA(4)))) {
					procedure_spec();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
			}
			else if ((LA(1)==LITERAL_begin||LA(1)==LITERAL_declare)) {
				begin_block();
				astFactory.addASTChild(currentAST, returnAST);
				match(SEMI);
			}
			else if ((_tokenSet_3.member(LA(1))) && (_tokenSet_46.member(LA(2))) && (_tokenSet_47.member(LA(3))) && (_tokenSet_48.member(LA(4)))) {
				package_obj_spec();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			if ( inputState.guessing==0 ) {
				package_obj_body_AST = (AST)currentAST.root;
				
				package_obj_body_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PACKAGE_OBJ_BODY,"package_obj_body")).add(package_obj_body_AST));
				
				currentAST.root = package_obj_body_AST;
				currentAST.child = package_obj_body_AST!=null &&package_obj_body_AST.getFirstChild()!=null ?
					package_obj_body_AST.getFirstChild() : package_obj_body_AST;
				currentAST.advanceChildToEnd();
			}
			package_obj_body_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_41);
			} else {
			  throw ex;
			}
		}
		returnAST = package_obj_body_AST;
	}
	
	public final CommonToken  schema_name() throws RecognitionException, TokenStreamException {
		 CommonToken id = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST schema_name_AST = null;
		
		try {      // for error handling
			id=identifier();
			astFactory.addASTChild(currentAST, returnAST);
			schema_name_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_49);
			} else {
			  throw ex;
			}
		}
		returnAST = schema_name_AST;
		return id;
	}
	
	public final CommonToken  variable_declaration() throws RecognitionException, TokenStreamException {
		CommonToken v= null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST variable_declaration_AST = null;
		Token  c = null;
		AST c_AST = null;
		Token  n = null;
		AST n_AST = null;
		Token  a = null;
		AST a_AST = null;
		Token  d = null;
		AST d_AST = null;
		
		try {      // for error handling
			v=variable_name();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_constant:
			{
				c = LT(1);
				c_AST = astFactory.create(c);
				astFactory.addASTChild(currentAST, c_AST);
				match(LITERAL_constant);
				break;
			}
			case LITERAL_replace:
			case LITERAL_binary_integer:
			case LITERAL_natural:
			case LITERAL_positive:
			case LITERAL_number:
			case LITERAL_char:
			case LITERAL_long:
			case LITERAL_raw:
			case LITERAL_boolean:
			case LITERAL_date:
			case LITERAL_smallint:
			case LITERAL_real:
			case LITERAL_numeric:
			case LITERAL_int:
			case LITERAL_integer:
			case 104:
			case LITERAL_decimal:
			case 106:
			case LITERAL_varchar:
			case LITERAL_character:
			case LITERAL_mlslabel:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			type_spec();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_not:
			{
				n = LT(1);
				n_AST = astFactory.create(n);
				astFactory.addASTChild(currentAST, n_AST);
				match(LITERAL_not);
				AST tmp11_AST = null;
				tmp11_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp11_AST);
				match(LITERAL_null);
				break;
			}
			case SEMI:
			case ASSIGNMENT_EQ:
			case LITERAL_default:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case ASSIGNMENT_EQ:
			case LITERAL_default:
			{
				{
				switch ( LA(1)) {
				case ASSIGNMENT_EQ:
				{
					a = LT(1);
					a_AST = astFactory.create(a);
					astFactory.addASTChild(currentAST, a_AST);
					match(ASSIGNMENT_EQ);
					break;
				}
				case LITERAL_default:
				{
					d = LT(1);
					d_AST = astFactory.create(d);
					astFactory.addASTChild(currentAST, d_AST);
					match(LITERAL_default);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				plsql_expression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(SEMI);
			variable_declaration_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_50);
			} else {
			  throw ex;
			}
		}
		returnAST = variable_declaration_AST;
		return v;
	}
	
	public final CommonToken  subtype_declaration() throws RecognitionException, TokenStreamException {
		CommonToken t= null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subtype_declaration_AST = null;
		Token  s = null;
		AST s_AST = null;
		Token  i = null;
		AST i_AST = null;
		
		try {      // for error handling
			s = LT(1);
			s_AST = astFactory.create(s);
			astFactory.addASTChild(currentAST, s_AST);
			match(LITERAL_subtype);
			t=type_name();
			astFactory.addASTChild(currentAST, returnAST);
			i = LT(1);
			i_AST = astFactory.create(i);
			astFactory.addASTChild(currentAST, i_AST);
			match(LITERAL_is);
			type_spec();
			astFactory.addASTChild(currentAST, returnAST);
			match(SEMI);
			subtype_declaration_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_50);
			} else {
			  throw ex;
			}
		}
		returnAST = subtype_declaration_AST;
		return t;
	}
	
	public final CommonToken  cursor_declaration() throws RecognitionException, TokenStreamException {
		CommonToken cn= null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST cursor_declaration_AST = null;
		Token  c = null;
		AST c_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  co = null;
		AST co_AST = null;
		Token  cp = null;
		AST cp_AST = null;
		
		try {      // for error handling
			c = LT(1);
			c_AST = astFactory.create(c);
			astFactory.addASTChild(currentAST, c_AST);
			match(LITERAL_cursor);
			cn=cursor_name();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case OPEN_PAREN:
			{
				o = LT(1);
				o_AST = astFactory.create(o);
				match(OPEN_PAREN);
				parameter_spec();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop39:
				do {
					if ((LA(1)==COMMA)) {
						co = LT(1);
						co_AST = astFactory.create(co);
						match(COMMA);
						parameter_spec();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop39;
					}
					
				} while (true);
				}
				cp = LT(1);
				cp_AST = astFactory.create(cp);
				match(CLOSE_PAREN);
				break;
			}
			case LITERAL_is:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LITERAL_is);
			select_command();
			astFactory.addASTChild(currentAST, returnAST);
			match(SEMI);
			if ( inputState.guessing==0 ) {
				cursor_declaration_AST = (AST)currentAST.root;
				
				cursor_declaration_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CURSOR_DECLARATION,"cursor_declaration")).add(cursor_declaration_AST));
				
				currentAST.root = cursor_declaration_AST;
				currentAST.child = cursor_declaration_AST!=null &&cursor_declaration_AST.getFirstChild()!=null ?
					cursor_declaration_AST.getFirstChild() : cursor_declaration_AST;
				currentAST.advanceChildToEnd();
			}
			cursor_declaration_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_50);
			} else {
			  throw ex;
			}
		}
		returnAST = cursor_declaration_AST;
		return cn;
	}
	
	public final CommonToken  cursor_spec() throws RecognitionException, TokenStreamException {
		 CommonToken cs = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST cursor_spec_AST = null;
		Token  c = null;
		AST c_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  co = null;
		AST co_AST = null;
		Token  cp = null;
		AST cp_AST = null;
		Token  r = null;
		AST r_AST = null;
		
		CommonToken rt;
		
		
		try {      // for error handling
			c = LT(1);
			c_AST = astFactory.create(c);
			astFactory.addASTChild(currentAST, c_AST);
			match(LITERAL_cursor);
			cursor_name();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				
				cs = (CommonToken) c;
				
			}
			{
			switch ( LA(1)) {
			case OPEN_PAREN:
			{
				o = LT(1);
				o_AST = astFactory.create(o);
				match(OPEN_PAREN);
				{
				parameter_spec();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop138:
				do {
					if ((LA(1)==COMMA)) {
						co = LT(1);
						co_AST = astFactory.create(co);
						astFactory.addASTChild(currentAST, co_AST);
						match(COMMA);
						parameter_spec();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop138;
					}
					
				} while (true);
				}
				}
				cp = LT(1);
				cp_AST = astFactory.create(cp);
				match(CLOSE_PAREN);
				break;
			}
			case LITERAL_return:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			r = LT(1);
			r_AST = astFactory.create(r);
			astFactory.addASTChild(currentAST, r_AST);
			match(LITERAL_return);
			rt=return_type();
			astFactory.addASTChild(currentAST, returnAST);
			match(SEMI);
			cursor_spec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_41);
			} else {
			  throw ex;
			}
		}
		returnAST = cursor_spec_AST;
		return cs;
	}
	
	public final CommonToken  record_declaration() throws RecognitionException, TokenStreamException {
		 CommonToken rd = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST record_declaration_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_type:
			{
				rd=record_type_dec();
				astFactory.addASTChild(currentAST, returnAST);
				record_declaration_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_replace:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				rd=record_var_dec();
				astFactory.addASTChild(currentAST, returnAST);
				record_declaration_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_50);
			} else {
			  throw ex;
			}
		}
		returnAST = record_declaration_AST;
		return rd;
	}
	
	public final CommonToken  plsql_table_declaration() throws RecognitionException, TokenStreamException {
		 CommonToken pt = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST plsql_table_declaration_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_type:
			{
				pt=table_type_dec();
				astFactory.addASTChild(currentAST, returnAST);
				plsql_table_declaration_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_replace:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				pt=table_var_dec();
				astFactory.addASTChild(currentAST, returnAST);
				plsql_table_declaration_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_50);
			} else {
			  throw ex;
			}
		}
		returnAST = plsql_table_declaration_AST;
		return pt;
	}
	
	public final CommonToken  procedure_spec() throws RecognitionException, TokenStreamException {
		 CommonToken ps = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST procedure_spec_AST = null;
		
		try {      // for error handling
			ps=procedure_declaration();
			astFactory.addASTChild(currentAST, returnAST);
			match(SEMI);
			if ( inputState.guessing==0 ) {
				
				SoftwareMetrics.finish();
				
			}
			procedure_spec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_50);
			} else {
			  throw ex;
			}
		}
		returnAST = procedure_spec_AST;
		return ps;
	}
	
	public final CommonToken  function_spec() throws RecognitionException, TokenStreamException {
		 CommonToken fs = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_spec_AST = null;
		
		try {      // for error handling
			fs=function_declaration();
			astFactory.addASTChild(currentAST, returnAST);
			match(SEMI);
			if ( inputState.guessing==0 ) {
				
				SoftwareMetrics.finish();
				
			}
			function_spec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_50);
			} else {
			  throw ex;
			}
		}
		returnAST = function_spec_AST;
		return fs;
	}
	
	public final CommonToken  exception_declaration() throws RecognitionException, TokenStreamException {
		 CommonToken ed = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exception_declaration_AST = null;
		Token  ep = null;
		AST ep_AST = null;
		
		try {      // for error handling
			ed=exception_name();
			astFactory.addASTChild(currentAST, returnAST);
			ep = LT(1);
			ep_AST = astFactory.create(ep);
			astFactory.addASTChild(currentAST, ep_AST);
			match(LITERAL_exception);
			match(SEMI);
			if ( inputState.guessing==0 ) {
				
					SoftwareMetrics.incUnstructuredElement();
					SoftwareMetrics.incBranchCount();
				
			}
			exception_declaration_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_50);
			} else {
			  throw ex;
			}
		}
		returnAST = exception_declaration_AST;
		return ed;
	}
	
	public final void foreign_lang_spec() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST foreign_lang_spec_AST = null;
		Token  l = null;
		AST l_AST = null;
		Token  j = null;
		AST j_AST = null;
		Token  n = null;
		AST n_AST = null;
		
		try {      // for error handling
			l = LT(1);
			l_AST = astFactory.create(l);
			astFactory.addASTChild(currentAST, l_AST);
			match(LITERAL_language);
			j = LT(1);
			j_AST = astFactory.create(j);
			astFactory.addASTChild(currentAST, j_AST);
			match(LITERAL_java);
			n = LT(1);
			n_AST = astFactory.create(n);
			astFactory.addASTChild(currentAST, n_AST);
			match(LITERAL_name);
			char_literal();
			astFactory.addASTChild(currentAST, returnAST);
			match(SEMI);
			foreign_lang_spec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_29);
			} else {
			  throw ex;
			}
		}
		returnAST = foreign_lang_spec_AST;
	}
	
	public final CommonToken  char_literal() throws RecognitionException, TokenStreamException {
		 CommonToken cl = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST char_literal_AST = null;
		Token  q = null;
		AST q_AST = null;
		
		try {      // for error handling
			q = LT(1);
			q_AST = astFactory.create(q);
			astFactory.addASTChild(currentAST, q_AST);
			match(QUOTED_STRING);
			if ( inputState.guessing==0 ) {
				
				cl = (CommonToken) q;
				
			}
			char_literal_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_51);
			} else {
			  throw ex;
			}
		}
		returnAST = char_literal_AST;
		return cl;
	}
	
	public final CommonToken  variable_name() throws RecognitionException, TokenStreamException {
		 CommonToken id = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST variable_name_AST = null;
		
		try {      // for error handling
			id=identifier();
			astFactory.addASTChild(currentAST, returnAST);
			variable_name_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_52);
			} else {
			  throw ex;
			}
		}
		returnAST = variable_name_AST;
		return id;
	}
	
	public final CommonToken  type_spec() throws RecognitionException, TokenStreamException {
		 CommonToken ts = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_spec_AST = null;
		
		CommonToken c;
		
		
		try {      // for error handling
			{
			if ((_tokenSet_53.member(LA(1))) && (_tokenSet_54.member(LA(2))) && (_tokenSet_55.member(LA(3))) && (_tokenSet_56.member(LA(4)))) {
				ts=datatype();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else if ((_tokenSet_1.member(LA(1))) && (LA(2)==PERCENTAGE) && (LA(3)==LITERAL_type)) {
				{
				ts=variable_name();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp21_AST = null;
				tmp21_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp21_AST);
				match(PERCENTAGE);
				AST tmp22_AST = null;
				tmp22_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp22_AST);
				match(LITERAL_type);
				}
			}
			else if ((_tokenSet_1.member(LA(1))) && (LA(2)==DOT) && (_tokenSet_1.member(LA(3))) && (LA(4)==DOT||LA(4)==PERCENTAGE)) {
				{
				ts=table_name();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp23_AST = null;
				tmp23_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp23_AST);
				match(DOT);
				c=column_name();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp24_AST = null;
				tmp24_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp24_AST);
				match(PERCENTAGE);
				AST tmp25_AST = null;
				tmp25_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp25_AST);
				match(LITERAL_type);
				}
			}
			else if ((_tokenSet_1.member(LA(1))) && (LA(2)==PERCENTAGE) && (LA(3)==LITERAL_rowtype)) {
				{
				ts=table_name();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp26_AST = null;
				tmp26_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp26_AST);
				match(PERCENTAGE);
				AST tmp27_AST = null;
				tmp27_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp27_AST);
				match(LITERAL_rowtype);
				}
			}
			else if ((_tokenSet_35.member(LA(1))) && (_tokenSet_57.member(LA(2))) && (_tokenSet_55.member(LA(3))) && (_tokenSet_58.member(LA(4)))) {
				ts=type_name();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			type_spec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_59);
			} else {
			  throw ex;
			}
		}
		returnAST = type_spec_AST;
		return ts;
	}
	
	public final void plsql_expression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST plsql_expression_AST = null;
		Token  c = null;
		AST c_AST = null;
		
		try {      // for error handling
			{
			num_expression();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop312:
			do {
				if ((LA(1)==CONCAT) && (_tokenSet_20.member(LA(2))) && (_tokenSet_60.member(LA(3))) && (_tokenSet_61.member(LA(4)))) {
					c = LT(1);
					c_AST = astFactory.create(c);
					astFactory.addASTChild(currentAST, c_AST);
					match(CONCAT);
					num_expression();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop312;
				}
				
			} while (true);
			}
			}
			plsql_expression_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_62);
			} else {
			  throw ex;
			}
		}
		returnAST = plsql_expression_AST;
	}
	
	public final CommonToken  type_name() throws RecognitionException, TokenStreamException {
		 CommonToken tn = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_name_AST = null;
		Token  d = null;
		AST d_AST = null;
		
		CommonToken lv;
		
		
		try {      // for error handling
			{
			boolean synPredMatched125 = false;
			if (((_tokenSet_1.member(LA(1))) && (_tokenSet_63.member(LA(2))) && (_tokenSet_64.member(LA(3))) && (_tokenSet_58.member(LA(4))))) {
				int _m125 = mark();
				synPredMatched125 = true;
				inputState.guessing++;
				try {
					{
					identifier();
					match(DOT);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched125 = false;
				}
				rewind(_m125);
				inputState.guessing--;
			}
			if ( synPredMatched125 ) {
				tn=identifier();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop127:
				do {
					if ((LA(1)==DOT)) {
						d = LT(1);
						d_AST = astFactory.create(d);
						astFactory.addASTChild(currentAST, d_AST);
						match(DOT);
						lv=identifier();
						astFactory.addASTChild(currentAST, returnAST);
						if ( inputState.guessing==0 ) {
							
							tn.setText(tn.getText() + '.' + lv.getText());
							
						}
					}
					else {
						break _loop127;
					}
					
				} while (true);
				}
			}
			else if ((_tokenSet_1.member(LA(1))) && (_tokenSet_65.member(LA(2))) && (_tokenSet_64.member(LA(3))) && (_tokenSet_56.member(LA(4)))) {
				tn=identifier();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else if ((_tokenSet_53.member(LA(1)))) {
				tn=datatype();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			type_name_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_65);
			} else {
			  throw ex;
			}
		}
		returnAST = type_name_AST;
		return tn;
	}
	
	public final CommonToken  cursor_name() throws RecognitionException, TokenStreamException {
		 CommonToken cn = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST cursor_name_AST = null;
		
		try {      // for error handling
			cn=identifier();
			astFactory.addASTChild(currentAST, returnAST);
			cursor_name_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_66);
			} else {
			  throw ex;
			}
		}
		returnAST = cursor_name_AST;
		return cn;
	}
	
	public final CommonToken  parameter_spec() throws RecognitionException, TokenStreamException {
		 CommonToken pn = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameter_spec_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  d = null;
		AST d_AST = null;
		
		try {      // for error handling
			pn=parameter_name();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_in:
			{
				i = LT(1);
				i_AST = astFactory.create(i);
				match(LITERAL_in);
				break;
			}
			case LITERAL_replace:
			case ASSIGNMENT_EQ:
			case LITERAL_default:
			case COMMA:
			case CLOSE_PAREN:
			case LITERAL_binary_integer:
			case LITERAL_natural:
			case LITERAL_positive:
			case LITERAL_number:
			case LITERAL_char:
			case LITERAL_long:
			case LITERAL_raw:
			case LITERAL_boolean:
			case LITERAL_date:
			case LITERAL_smallint:
			case LITERAL_real:
			case LITERAL_numeric:
			case LITERAL_int:
			case LITERAL_integer:
			case 104:
			case LITERAL_decimal:
			case 106:
			case LITERAL_varchar:
			case LITERAL_character:
			case LITERAL_mlslabel:
			case LITERAL_out:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_out:
			{
				o = LT(1);
				o_AST = astFactory.create(o);
				match(LITERAL_out);
				break;
			}
			case LITERAL_replace:
			case ASSIGNMENT_EQ:
			case LITERAL_default:
			case COMMA:
			case CLOSE_PAREN:
			case LITERAL_binary_integer:
			case LITERAL_natural:
			case LITERAL_positive:
			case LITERAL_number:
			case LITERAL_char:
			case LITERAL_long:
			case LITERAL_raw:
			case LITERAL_boolean:
			case LITERAL_date:
			case LITERAL_smallint:
			case LITERAL_real:
			case LITERAL_numeric:
			case LITERAL_int:
			case LITERAL_integer:
			case 104:
			case LITERAL_decimal:
			case 106:
			case LITERAL_varchar:
			case LITERAL_character:
			case LITERAL_mlslabel:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_replace:
			case LITERAL_binary_integer:
			case LITERAL_natural:
			case LITERAL_positive:
			case LITERAL_number:
			case LITERAL_char:
			case LITERAL_long:
			case LITERAL_raw:
			case LITERAL_boolean:
			case LITERAL_date:
			case LITERAL_smallint:
			case LITERAL_real:
			case LITERAL_numeric:
			case LITERAL_int:
			case LITERAL_integer:
			case 104:
			case LITERAL_decimal:
			case 106:
			case LITERAL_varchar:
			case LITERAL_character:
			case LITERAL_mlslabel:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				type_spec();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case ASSIGNMENT_EQ:
			case LITERAL_default:
			case COMMA:
			case CLOSE_PAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			if ((LA(1)==LITERAL_default) && (_tokenSet_20.member(LA(2))) && (_tokenSet_67.member(LA(3))) && (_tokenSet_68.member(LA(4)))) {
				d = LT(1);
				d_AST = astFactory.create(d);
				astFactory.addASTChild(currentAST, d_AST);
				match(LITERAL_default);
				plsql_expression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else if ((_tokenSet_69.member(LA(1))) && (_tokenSet_70.member(LA(2))) && (_tokenSet_71.member(LA(3))) && (_tokenSet_72.member(LA(4)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			if ( inputState.guessing==0 ) {
				parameter_spec_AST = (AST)currentAST.root;
				
				parameter_spec_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PARAMETER_SPEC,"parameter_spec")).add(parameter_spec_AST));
				
				currentAST.root = parameter_spec_AST;
				currentAST.child = parameter_spec_AST!=null &&parameter_spec_AST.getFirstChild()!=null ?
					parameter_spec_AST.getFirstChild() : parameter_spec_AST;
				currentAST.advanceChildToEnd();
			}
			parameter_spec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_69);
			} else {
			  throw ex;
			}
		}
		returnAST = parameter_spec_AST;
		return pn;
	}
	
	public final void select_command() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST select_command_AST = null;
		
		try {      // for error handling
			if ((LA(1)==OPEN_PAREN||LA(1)==LITERAL_with||LA(1)==LITERAL_select) && (_tokenSet_18.member(LA(2))) && (_tokenSet_19.member(LA(3))) && (_tokenSet_73.member(LA(4)))) {
				select_expression();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					select_command_AST = (AST)currentAST.root;
					
					select_command_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SELECT_COMMAND,"select_command")).add(select_command_AST));
					
					currentAST.root = select_command_AST;
					currentAST.child = select_command_AST!=null &&select_command_AST.getFirstChild()!=null ?
						select_command_AST.getFirstChild() : select_command_AST;
					currentAST.advanceChildToEnd();
				}
				select_command_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==OPEN_PAREN) && (LA(2)==OPEN_PAREN||LA(2)==LITERAL_with||LA(2)==LITERAL_select) && (_tokenSet_18.member(LA(3))) && (_tokenSet_19.member(LA(4)))) {
				subquery();
				astFactory.addASTChild(currentAST, returnAST);
				select_command_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_74);
			} else {
			  throw ex;
			}
		}
		returnAST = select_command_AST;
	}
	
	public final CommonToken  function_declaration() throws RecognitionException, TokenStreamException {
		 CommonToken fn = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_declaration_AST = null;
		Token  f = null;
		AST f_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  co = null;
		AST co_AST = null;
		Token  cp = null;
		AST cp_AST = null;
		Token  r = null;
		AST r_AST = null;
		
		CommonToken rt;
		
		
		try {      // for error handling
			f = LT(1);
			f_AST = astFactory.create(f);
			astFactory.addASTChild(currentAST, f_AST);
			match(LITERAL_function);
			fn=function_name();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				
				SoftwareMetrics.start(fn.getText(),"Function",f.getLine());
				
			}
			{
			{
			switch ( LA(1)) {
			case OPEN_PAREN:
			{
				o = LT(1);
				o_AST = astFactory.create(o);
				match(OPEN_PAREN);
				argument();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop200:
				do {
					if ((LA(1)==COMMA)) {
						co = LT(1);
						co_AST = astFactory.create(co);
						astFactory.addASTChild(currentAST, co_AST);
						match(COMMA);
						argument();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop200;
					}
					
				} while (true);
				}
				cp = LT(1);
				cp_AST = astFactory.create(cp);
				match(CLOSE_PAREN);
				break;
			}
			case LITERAL_return:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			}
			r = LT(1);
			r_AST = astFactory.create(r);
			astFactory.addASTChild(currentAST, r_AST);
			match(LITERAL_return);
			rt=return_type();
			astFactory.addASTChild(currentAST, returnAST);
			function_declaration_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_75);
			} else {
			  throw ex;
			}
		}
		returnAST = function_declaration_AST;
		return fn;
	}
	
	public final CommonToken  procedure_declaration() throws RecognitionException, TokenStreamException {
		 CommonToken pr = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST procedure_declaration_AST = null;
		Token  p = null;
		AST p_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  co = null;
		AST co_AST = null;
		Token  cp = null;
		AST cp_AST = null;
		
		try {      // for error handling
			p = LT(1);
			p_AST = astFactory.create(p);
			astFactory.addASTChild(currentAST, p_AST);
			match(LITERAL_procedure);
			pr=procedure_name();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				
				SoftwareMetrics.start(pr.getText(),"Procedure",pr.getLine());
				
			}
			{
			{
			switch ( LA(1)) {
			case OPEN_PAREN:
			{
				o = LT(1);
				o_AST = astFactory.create(o);
				match(OPEN_PAREN);
				argument();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop171:
				do {
					if ((LA(1)==COMMA)) {
						co = LT(1);
						co_AST = astFactory.create(co);
						astFactory.addASTChild(currentAST, co_AST);
						match(COMMA);
						argument();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop171;
					}
					
				} while (true);
				}
				cp = LT(1);
				cp_AST = astFactory.create(cp);
				match(CLOSE_PAREN);
				break;
			}
			case SEMI:
			case LITERAL_is:
			case LITERAL_as:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			}
			procedure_declaration_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_75);
			} else {
			  throw ex;
			}
		}
		returnAST = procedure_declaration_AST;
		return pr;
	}
	
	public final void seq_of_statements() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST seq_of_statements_AST = null;
		
		try {      // for error handling
			statement();
			astFactory.addASTChild(currentAST, returnAST);
			match(SEMI);
			{
			_loop50:
			do {
				if ((_tokenSet_76.member(LA(1)))) {
					statement();
					astFactory.addASTChild(currentAST, returnAST);
					match(SEMI);
				}
				else {
					break _loop50;
				}
				
			} while (true);
			}
			seq_of_statements_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_77);
			} else {
			  throw ex;
			}
		}
		returnAST = seq_of_statements_AST;
	}
	
	public final CommonToken  statement() throws RecognitionException, TokenStreamException {
		 CommonToken l = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST statement_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case START_LABEL:
			{
				AST tmp30_AST = null;
				tmp30_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp30_AST);
				match(START_LABEL);
				l=label_name();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp31_AST = null;
				tmp31_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp31_AST);
				match(END_LABEL);
				break;
			}
			case LITERAL_set:
			case LITERAL_replace:
			case LITERAL_null:
			case OPEN_PAREN:
			case LITERAL_begin:
			case LITERAL_loop:
			case LITERAL_for:
			case LITERAL_while:
			case LITERAL_forall:
			case LITERAL_if:
			case LITERAL_goto:
			case LITERAL_raise:
			case LITERAL_exit:
			case LITERAL_return:
			case LITERAL_with:
			case LITERAL_select:
			case LITERAL_update:
			case LITERAL_insert:
			case LITERAL_delete:
			case LITERAL_alter:
			case LITERAL_lock:
			case LITERAL_execute:
			case LITERAL_commit:
			case LITERAL_rollback:
			case LITERAL_open:
			case LITERAL_fetch:
			case LITERAL_close:
			case LITERAL_declare:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_mod:
			case LITERAL_power:
			case LITERAL_round:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_rpad:
			case LITERAL_rtrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_avg:
			case LITERAL_max:
			case LITERAL_min:
			case LITERAL_stddev:
			case LITERAL_sum:
			case LITERAL_variance:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_rowidtochar:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_uid:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case LITERAL_savepoint:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_begin:
			case LITERAL_declare:
			{
				begin_block();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_forall:
			{
				forall_statement();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_if:
			{
				if_statement();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_goto:
			{
				goto_statement();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_raise:
			{
				raise_statement();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_exit:
			{
				exit_statement();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_null:
			{
				null_statement();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_return:
			{
				return_statement();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
				boolean synPredMatched57 = false;
				if (((_tokenSet_78.member(LA(1))) && (_tokenSet_79.member(LA(2))) && (_tokenSet_80.member(LA(3))) && (_tokenSet_81.member(LA(4))))) {
					int _m57 = mark();
					synPredMatched57 = true;
					inputState.guessing++;
					try {
						{
						switch ( LA(1)) {
						case LITERAL_loop:
						{
							match(LITERAL_loop);
							break;
						}
						case LITERAL_for:
						{
							match(LITERAL_for);
							break;
						}
						case LITERAL_while:
						{
							match(LITERAL_while);
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
					}
					catch (RecognitionException pe) {
						synPredMatched57 = false;
					}
					rewind(_m57);
					inputState.guessing--;
				}
				if ( synPredMatched57 ) {
					loop_statement();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					boolean synPredMatched71 = false;
					if (((_tokenSet_82.member(LA(1))) && (_tokenSet_83.member(LA(2))) && (_tokenSet_84.member(LA(3))) && (_tokenSet_85.member(LA(4))))) {
						int _m71 = mark();
						synPredMatched71 = true;
						inputState.guessing++;
						try {
							{
							switch ( LA(1)) {
							case LITERAL_with:
							{
								match(LITERAL_with);
								break;
							}
							case LITERAL_select:
							{
								match(LITERAL_select);
								break;
							}
							case LITERAL_update:
							{
								match(LITERAL_update);
								break;
							}
							case LITERAL_insert:
							{
								match(LITERAL_insert);
								break;
							}
							case LITERAL_delete:
							{
								match(LITERAL_delete);
								break;
							}
							case LITERAL_alter:
							{
								match(LITERAL_alter);
								break;
							}
							case LITERAL_set:
							{
								match(LITERAL_set);
								break;
							}
							case LITERAL_lock:
							{
								match(LITERAL_lock);
								break;
							}
							case LITERAL_grant:
							{
								match(LITERAL_grant);
								break;
							}
							case LITERAL_execute:
							{
								match(LITERAL_execute);
								break;
							}
							case LITERAL_commit:
							{
								match(LITERAL_commit);
								break;
							}
							case LITERAL_rollback:
							{
								match(LITERAL_rollback);
								break;
							}
							case LITERAL_open:
							{
								match(LITERAL_open);
								break;
							}
							case LITERAL_fetch:
							{
								match(LITERAL_fetch);
								break;
							}
							case LITERAL_close:
							{
								match(LITERAL_close);
								break;
							}
							default:
							{
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
							}
						}
						catch (RecognitionException pe) {
							synPredMatched71 = false;
						}
						rewind(_m71);
						inputState.guessing--;
					}
					if ( synPredMatched71 ) {
						sql_statement();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						boolean synPredMatched73 = false;
						if (((_tokenSet_25.member(LA(1))) && (_tokenSet_86.member(LA(2))) && (_tokenSet_87.member(LA(3))) && (_tokenSet_88.member(LA(4))))) {
							int _m73 = mark();
							synPredMatched73 = true;
							inputState.guessing++;
							try {
								{
								lvalue();
								match(ASSIGNMENT_EQ);
								}
							}
							catch (RecognitionException pe) {
								synPredMatched73 = false;
							}
							rewind(_m73);
							inputState.guessing--;
						}
						if ( synPredMatched73 ) {
							assignment_statement();
							astFactory.addASTChild(currentAST, returnAST);
						}
						else {
							boolean synPredMatched75 = false;
							if (((_tokenSet_89.member(LA(1))) && (_tokenSet_90.member(LA(2))) && (_tokenSet_91.member(LA(3))) && (_tokenSet_92.member(LA(4))))) {
								int _m75 = mark();
								synPredMatched75 = true;
								inputState.guessing++;
								try {
									{
									lvalue();
									lvalue();
									}
								}
								catch (RecognitionException pe) {
									synPredMatched75 = false;
								}
								rewind(_m75);
								inputState.guessing--;
							}
							if ( synPredMatched75 ) {
								procedure_call();
								astFactory.addASTChild(currentAST, returnAST);
							}
							else if ((_tokenSet_25.member(LA(1))) && (_tokenSet_93.member(LA(2))) && (_tokenSet_94.member(LA(3))) && (_tokenSet_95.member(LA(4)))) {
								lvalue();
								astFactory.addASTChild(currentAST, returnAST);
							}
						else {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}}}}
						}
						if ( inputState.guessing==0 ) {
							statement_AST = (AST)currentAST.root;
							
							statement_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(STATEMENT,"statement")).add(statement_AST));
							
							currentAST.root = statement_AST;
							currentAST.child = statement_AST!=null &&statement_AST.getFirstChild()!=null ?
								statement_AST.getFirstChild() : statement_AST;
							currentAST.advanceChildToEnd();
						}
						statement_AST = (AST)currentAST.root;
					}
					catch (RecognitionException ex) {
						if (inputState.guessing==0) {
							reportError(ex);
							recover(ex,_tokenSet_96);
						} else {
						  throw ex;
						}
					}
					returnAST = statement_AST;
					return l;
				}
				
	public final CommonToken  label_name() throws RecognitionException, TokenStreamException {
		 CommonToken l = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST label_name_AST = null;
		
		try {      // for error handling
			l=identifier();
			astFactory.addASTChild(currentAST, returnAST);
			label_name_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_97);
			} else {
			  throw ex;
			}
		}
		returnAST = label_name_AST;
		return l;
	}
	
	public final CommonToken  loop_statement() throws RecognitionException, TokenStreamException {
		 CommonToken l = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST loop_statement_AST = null;
		Token  w = null;
		AST w_AST = null;
		Token  f = null;
		AST f_AST = null;
		Token  lo = null;
		AST lo_AST = null;
		Token  e = null;
		AST e_AST = null;
		
		CommonToken la = null;
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_replace:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				l=label_name();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_loop:
			case LITERAL_for:
			case LITERAL_while:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_while:
			{
				{
				w = LT(1);
				w_AST = astFactory.create(w);
				astFactory.makeASTRoot(currentAST, w_AST);
				match(LITERAL_while);
				plsql_condition();
				astFactory.addASTChild(currentAST, returnAST);
				}
				break;
			}
			case LITERAL_for:
			{
				{
				f = LT(1);
				f_AST = astFactory.create(f);
				astFactory.makeASTRoot(currentAST, f_AST);
				match(LITERAL_for);
				{
				if ((_tokenSet_1.member(LA(1))) && (LA(2)==LITERAL_in) && (_tokenSet_14.member(LA(3))) && (_tokenSet_98.member(LA(4)))) {
					cursor_loop_param();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((_tokenSet_1.member(LA(1))) && (LA(2)==LITERAL_in) && (_tokenSet_99.member(LA(3))) && (_tokenSet_100.member(LA(4)))) {
					numeric_loop_param();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				}
				break;
			}
			case LITERAL_loop:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			lo = LT(1);
			lo_AST = astFactory.create(lo);
			astFactory.makeASTRoot(currentAST, lo_AST);
			match(LITERAL_loop);
			seq_of_statements();
			astFactory.addASTChild(currentAST, returnAST);
			e = LT(1);
			e_AST = astFactory.create(e);
			astFactory.addASTChild(currentAST, e_AST);
			match(LITERAL_end);
			AST tmp32_AST = null;
			tmp32_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp32_AST);
			match(LITERAL_loop);
			{
			switch ( LA(1)) {
			case LITERAL_replace:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				la=label_name();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				loop_statement_AST = (AST)currentAST.root;
				
				loop_statement_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOOP_STATEMENT,"loop_statement")).add(loop_statement_AST));
				
				currentAST.root = loop_statement_AST;
				currentAST.child = loop_statement_AST!=null &&loop_statement_AST.getFirstChild()!=null ?
					loop_statement_AST.getFirstChild() : loop_statement_AST;
				currentAST.advanceChildToEnd();
			}
			if ( inputState.guessing==0 ) {
				
					SoftwareMetrics.incConditionCount(); 
					SoftwareMetrics.incDecisionCount();
					SoftwareMetrics.incBranchCount();
				
			}
			loop_statement_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = loop_statement_AST;
		return l;
	}
	
	public final void forall_statement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST forall_statement_AST = null;
		
		try {      // for error handling
			AST tmp33_AST = null;
			tmp33_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp33_AST);
			match(LITERAL_forall);
			lvalue();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp34_AST = null;
			tmp34_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp34_AST);
			match(LITERAL_in);
			lvalue();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp35_AST = null;
			tmp35_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp35_AST);
			match(DOUBLEDOT);
			lvalue();
			astFactory.addASTChild(currentAST, returnAST);
			statement();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				
					SoftwareMetrics.incConditionCount(); 
					SoftwareMetrics.incDecisionCount();
					SoftwareMetrics.incBranchCount();
				
			}
			forall_statement_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = forall_statement_AST;
	}
	
	public final void if_statement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST if_statement_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  t = null;
		AST t_AST = null;
		Token  ei = null;
		AST ei_AST = null;
		Token  t1 = null;
		AST t1_AST = null;
		Token  el = null;
		AST el_AST = null;
		Token  ef = null;
		AST ef_AST = null;
		
		try {      // for error handling
			i = LT(1);
			i_AST = astFactory.create(i);
			astFactory.makeASTRoot(currentAST, i_AST);
			match(LITERAL_if);
			plsql_condition();
			astFactory.addASTChild(currentAST, returnAST);
			t = LT(1);
			t_AST = astFactory.create(t);
			astFactory.addASTChild(currentAST, t_AST);
			match(LITERAL_then);
			seq_of_statements();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop351:
			do {
				if ((LA(1)==LITERAL_elsif)) {
					ei = LT(1);
					ei_AST = astFactory.create(ei);
					astFactory.addASTChild(currentAST, ei_AST);
					match(LITERAL_elsif);
					plsql_condition();
					astFactory.addASTChild(currentAST, returnAST);
					t1 = LT(1);
					t1_AST = astFactory.create(t1);
					astFactory.addASTChild(currentAST, t1_AST);
					match(LITERAL_then);
					seq_of_statements();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop351;
				}
				
			} while (true);
			}
			{
			switch ( LA(1)) {
			case LITERAL_else:
			{
				el = LT(1);
				el_AST = astFactory.create(el);
				astFactory.addASTChild(currentAST, el_AST);
				match(LITERAL_else);
				seq_of_statements();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_end:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			ef = LT(1);
			ef_AST = astFactory.create(ef);
			astFactory.addASTChild(currentAST, ef_AST);
			match(LITERAL_end);
			AST tmp36_AST = null;
			tmp36_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp36_AST);
			match(LITERAL_if);
			if ( inputState.guessing==0 ) {
				if_statement_AST = (AST)currentAST.root;
				
				if_statement_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(IF_STATEMENT,"if_statement")).add(if_statement_AST));
				
				currentAST.root = if_statement_AST;
				currentAST.child = if_statement_AST!=null &&if_statement_AST.getFirstChild()!=null ?
					if_statement_AST.getFirstChild() : if_statement_AST;
				currentAST.advanceChildToEnd();
			}
			if ( inputState.guessing==0 ) {
				
					SoftwareMetrics.incConditionCount(); 
					SoftwareMetrics.incDecisionCount();
					SoftwareMetrics.incBranchCount();
				
			}
			if_statement_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = if_statement_AST;
	}
	
	public final CommonToken  goto_statement() throws RecognitionException, TokenStreamException {
		 CommonToken gs = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST goto_statement_AST = null;
		Token  g = null;
		AST g_AST = null;
		
		try {      // for error handling
			g = LT(1);
			g_AST = astFactory.create(g);
			astFactory.addASTChild(currentAST, g_AST);
			match(LITERAL_goto);
			gs=label_name();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				
					SoftwareMetrics.incBranchCount(); 
					SoftwareMetrics.incUnstructuredElement();
				
			}
			goto_statement_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = goto_statement_AST;
		return gs;
	}
	
	public final CommonToken  raise_statement() throws RecognitionException, TokenStreamException {
		 CommonToken en= null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST raise_statement_AST = null;
		Token  r = null;
		AST r_AST = null;
		
		try {      // for error handling
			r = LT(1);
			r_AST = astFactory.create(r);
			astFactory.addASTChild(currentAST, r_AST);
			match(LITERAL_raise);
			{
			switch ( LA(1)) {
			case LITERAL_replace:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				en=exception_name();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				SoftwareMetrics.incUnstructuredElement();
			}
			raise_statement_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = raise_statement_AST;
		return en;
	}
	
	public final CommonToken  exit_statement() throws RecognitionException, TokenStreamException {
		 CommonToken l = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exit_statement_AST = null;
		Token  e = null;
		AST e_AST = null;
		Token  w = null;
		AST w_AST = null;
		
		try {      // for error handling
			e = LT(1);
			e_AST = astFactory.create(e);
			astFactory.addASTChild(currentAST, e_AST);
			match(LITERAL_exit);
			{
			switch ( LA(1)) {
			case LITERAL_replace:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				l=label_name();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			case LITERAL_when:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_when:
			{
				w = LT(1);
				w_AST = astFactory.create(w);
				astFactory.addASTChild(currentAST, w_AST);
				match(LITERAL_when);
				plsql_condition();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				
				l = (CommonToken) e;
				
			}
			if ( inputState.guessing==0 ) {
				
					SoftwareMetrics.incBranchCount();
					SoftwareMetrics.incUnstructuredElement();
				
			}
			exit_statement_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = exit_statement_AST;
		return l;
	}
	
	public final void null_statement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST null_statement_AST = null;
		Token  n = null;
		AST n_AST = null;
		
		try {      // for error handling
			n = LT(1);
			n_AST = astFactory.create(n);
			astFactory.addASTChild(currentAST, n_AST);
			match(LITERAL_null);
			null_statement_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = null_statement_AST;
	}
	
	public final void return_statement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST return_statement_AST = null;
		Token  r = null;
		AST r_AST = null;
		
		try {      // for error handling
			r = LT(1);
			r_AST = astFactory.create(r);
			astFactory.addASTChild(currentAST, r_AST);
			match(LITERAL_return);
			{
			switch ( LA(1)) {
			case LITERAL_replace:
			case LITERAL_null:
			case OPEN_PAREN:
			case LITERAL_open:
			case NUMBER:
			case PLUS:
			case MINUS:
			case LITERAL_true:
			case LITERAL_false:
			case LITERAL_cast:
			case LITERAL_trim:
			case LITERAL_count:
			case LITERAL_case:
			case LITERAL_all:
			case LITERAL_any:
			case QUOTED_STRING:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_mod:
			case LITERAL_power:
			case LITERAL_round:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_rpad:
			case LITERAL_rtrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_avg:
			case LITERAL_max:
			case LITERAL_min:
			case LITERAL_stddev:
			case LITERAL_sum:
			case LITERAL_variance:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_rowidtochar:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_uid:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				plsql_expression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			return_statement_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = return_statement_AST;
	}
	
	public final void sql_statement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST sql_statement_AST = null;
		
		try {      // for error handling
			sql_command();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				sql_statement_AST = (AST)currentAST.root;
				
				sql_statement_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SQL_STATEMENT,"sql_statement")).add(sql_statement_AST));
				
				currentAST.root = sql_statement_AST;
				currentAST.child = sql_statement_AST!=null &&sql_statement_AST.getFirstChild()!=null ?
					sql_statement_AST.getFirstChild() : sql_statement_AST;
				currentAST.advanceChildToEnd();
			}
			sql_statement_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = sql_statement_AST;
	}
	
	public final CommonToken  lvalue() throws RecognitionException, TokenStreamException {
		CommonToken lv= null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST lvalue_AST = null;
		Token  d = null;
		AST d_AST = null;
		Token  de = null;
		AST de_AST = null;
		Token  d1 = null;
		AST d1_AST = null;
		Token  fi = null;
		AST fi_AST = null;
		Token  d2 = null;
		AST d2_AST = null;
		Token  la = null;
		AST la_AST = null;
		Token  d3 = null;
		AST d3_AST = null;
		
		CommonToken fn = null;
		
		
		try {      // for error handling
			lv=function_call();
			astFactory.addASTChild(currentAST, returnAST);
			{
			boolean synPredMatched87 = false;
			if (((LA(1)==DOT) && (LA(2)==LITERAL_delete) && (_tokenSet_101.member(LA(3))) && (_tokenSet_102.member(LA(4))))) {
				int _m87 = mark();
				synPredMatched87 = true;
				inputState.guessing++;
				try {
					{
					match(DOT);
					match(LITERAL_delete);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched87 = false;
				}
				rewind(_m87);
				inputState.guessing--;
			}
			if ( synPredMatched87 ) {
				d = LT(1);
				d_AST = astFactory.create(d);
				astFactory.addASTChild(currentAST, d_AST);
				match(DOT);
				de = LT(1);
				de_AST = astFactory.create(de);
				astFactory.addASTChild(currentAST, de_AST);
				match(LITERAL_delete);
			}
			else {
				boolean synPredMatched89 = false;
				if (((LA(1)==DOT) && (LA(2)==LITERAL_first))) {
					int _m89 = mark();
					synPredMatched89 = true;
					inputState.guessing++;
					try {
						{
						match(DOT);
						match(LITERAL_first);
						}
					}
					catch (RecognitionException pe) {
						synPredMatched89 = false;
					}
					rewind(_m89);
					inputState.guessing--;
				}
				if ( synPredMatched89 ) {
					d1 = LT(1);
					d1_AST = astFactory.create(d1);
					astFactory.addASTChild(currentAST, d1_AST);
					match(DOT);
					fi = LT(1);
					fi_AST = astFactory.create(fi);
					astFactory.addASTChild(currentAST, fi_AST);
					match(LITERAL_first);
				}
				else {
					boolean synPredMatched91 = false;
					if (((LA(1)==DOT) && (LA(2)==LITERAL_last))) {
						int _m91 = mark();
						synPredMatched91 = true;
						inputState.guessing++;
						try {
							{
							match(DOT);
							match(LITERAL_last);
							}
						}
						catch (RecognitionException pe) {
							synPredMatched91 = false;
						}
						rewind(_m91);
						inputState.guessing--;
					}
					if ( synPredMatched91 ) {
						d2 = LT(1);
						d2_AST = astFactory.create(d2);
						astFactory.addASTChild(currentAST, d2_AST);
						match(DOT);
						la = LT(1);
						la_AST = astFactory.create(la);
						astFactory.addASTChild(currentAST, la_AST);
						match(LITERAL_last);
					}
					else if ((_tokenSet_103.member(LA(1))) && (_tokenSet_102.member(LA(2))) && (_tokenSet_104.member(LA(3))) && (_tokenSet_105.member(LA(4)))) {
						{
						{
						_loop94:
						do {
							if ((LA(1)==DOT)) {
								d3 = LT(1);
								d3_AST = astFactory.create(d3);
								astFactory.addASTChild(currentAST, d3_AST);
								match(DOT);
								fn=function_call();
								astFactory.addASTChild(currentAST, returnAST);
							}
							else {
								break _loop94;
							}
							
						} while (true);
						}
						}
					}
					else if ((_tokenSet_101.member(LA(1))) && (_tokenSet_102.member(LA(2))) && (_tokenSet_104.member(LA(3))) && (_tokenSet_105.member(LA(4)))) {
					}
					else {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}}
					}
					lvalue_AST = (AST)currentAST.root;
				}
				catch (RecognitionException ex) {
					if (inputState.guessing==0) {
						reportError(ex);
						recover(ex,_tokenSet_101);
					} else {
					  throw ex;
					}
				}
				returnAST = lvalue_AST;
				return lv;
			}
			
	public final CommonToken  assignment_statement() throws RecognitionException, TokenStreamException {
		CommonToken l= null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST assignment_statement_AST = null;
		
		try {      // for error handling
			l=lvalue();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp37_AST = null;
			tmp37_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp37_AST);
			match(ASSIGNMENT_EQ);
			plsql_expression();
			astFactory.addASTChild(currentAST, returnAST);
			assignment_statement_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = assignment_statement_AST;
		return l;
	}
	
	public final CommonToken  procedure_call() throws RecognitionException, TokenStreamException {
		 CommonToken f = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST procedure_call_AST = null;
		
		try {      // for error handling
			f=function();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_replace:
			case LITERAL_null:
			case OPEN_PAREN:
			case LITERAL_open:
			case NUMBER:
			case PLUS:
			case MINUS:
			case LITERAL_true:
			case LITERAL_false:
			case LITERAL_cast:
			case LITERAL_trim:
			case LITERAL_count:
			case LITERAL_case:
			case LITERAL_all:
			case LITERAL_any:
			case QUOTED_STRING:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_mod:
			case LITERAL_power:
			case LITERAL_round:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_rpad:
			case LITERAL_rtrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_avg:
			case LITERAL_max:
			case LITERAL_min:
			case LITERAL_stddev:
			case LITERAL_sum:
			case LITERAL_variance:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_rowidtochar:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_uid:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				call_argument_list();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			procedure_call_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = procedure_call_AST;
		return f;
	}
	
	public final void declare_spec() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST declare_spec_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_subtype:
			{
				subtype_declaration();
				astFactory.addASTChild(currentAST, returnAST);
				declare_spec_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_cursor:
			{
				cursor_declaration();
				astFactory.addASTChild(currentAST, returnAST);
				declare_spec_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_pragma:
			{
				exception_pragma();
				astFactory.addASTChild(currentAST, returnAST);
				declare_spec_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_function:
			{
				{
				boolean synPredMatched79 = false;
				if (((LA(1)==LITERAL_function) && (_tokenSet_1.member(LA(2))) && (LA(3)==DOT||LA(3)==OPEN_PAREN||LA(3)==LITERAL_return) && (_tokenSet_35.member(LA(4))))) {
					int _m79 = mark();
					synPredMatched79 = true;
					inputState.guessing++;
					try {
						{
						function_declaration();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched79 = false;
					}
					rewind(_m79);
					inputState.guessing--;
				}
				if ( synPredMatched79 ) {
					function_body();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((LA(1)==LITERAL_function) && (_tokenSet_1.member(LA(2))) && (LA(3)==DOT||LA(3)==OPEN_PAREN||LA(3)==LITERAL_return) && (_tokenSet_35.member(LA(4)))) {
					function_spec();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				declare_spec_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_procedure:
			{
				{
				boolean synPredMatched82 = false;
				if (((LA(1)==LITERAL_procedure) && (_tokenSet_1.member(LA(2))) && (_tokenSet_44.member(LA(3))) && (_tokenSet_45.member(LA(4))))) {
					int _m82 = mark();
					synPredMatched82 = true;
					inputState.guessing++;
					try {
						{
						procedure_declaration();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched82 = false;
					}
					rewind(_m82);
					inputState.guessing--;
				}
				if ( synPredMatched82 ) {
					procedure_body();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((LA(1)==LITERAL_procedure) && (_tokenSet_1.member(LA(2))) && (LA(3)==SEMI||LA(3)==DOT||LA(3)==OPEN_PAREN) && (_tokenSet_106.member(LA(4)))) {
					procedure_spec();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				declare_spec_AST = (AST)currentAST.root;
				break;
			}
			default:
				if ((_tokenSet_1.member(LA(1))) && (_tokenSet_31.member(LA(2))) && (_tokenSet_32.member(LA(3))) && (_tokenSet_107.member(LA(4)))) {
					variable_declaration();
					astFactory.addASTChild(currentAST, returnAST);
					declare_spec_AST = (AST)currentAST.root;
				}
				else if ((_tokenSet_1.member(LA(1))) && (LA(2)==DOT||LA(2)==LITERAL_exception)) {
					exception_declaration();
					astFactory.addASTChild(currentAST, returnAST);
					declare_spec_AST = (AST)currentAST.root;
				}
				else if ((_tokenSet_36.member(LA(1))) && (_tokenSet_35.member(LA(2))) && (_tokenSet_37.member(LA(3))) && (_tokenSet_38.member(LA(4)))) {
					record_declaration();
					astFactory.addASTChild(currentAST, returnAST);
					declare_spec_AST = (AST)currentAST.root;
				}
				else if ((_tokenSet_36.member(LA(1))) && (_tokenSet_35.member(LA(2))) && (_tokenSet_39.member(LA(3))) && (_tokenSet_108.member(LA(4)))) {
					plsql_table_declaration();
					astFactory.addASTChild(currentAST, returnAST);
					declare_spec_AST = (AST)currentAST.root;
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_106);
			} else {
			  throw ex;
			}
		}
		returnAST = declare_spec_AST;
	}
	
	public final CommonToken  exception_pragma() throws RecognitionException, TokenStreamException {
		 CommonToken ep = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exception_pragma_AST = null;
		Token  p = null;
		AST p_AST = null;
		Token  e = null;
		AST e_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  c = null;
		AST c_AST = null;
		Token  cp = null;
		AST cp_AST = null;
		
		CommonToken or;
		
		
		try {      // for error handling
			p = LT(1);
			p_AST = astFactory.create(p);
			astFactory.addASTChild(currentAST, p_AST);
			match(LITERAL_pragma);
			e = LT(1);
			e_AST = astFactory.create(e);
			astFactory.addASTChild(currentAST, e_AST);
			match(LITERAL_exception_init);
			o = LT(1);
			o_AST = astFactory.create(o);
			match(OPEN_PAREN);
			ep=exception_name();
			astFactory.addASTChild(currentAST, returnAST);
			c = LT(1);
			c_AST = astFactory.create(c);
			astFactory.addASTChild(currentAST, c_AST);
			match(COMMA);
			or=oracle_err_number();
			astFactory.addASTChild(currentAST, returnAST);
			cp = LT(1);
			cp_AST = astFactory.create(cp);
			match(CLOSE_PAREN);
			match(SEMI);
			exception_pragma_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_106);
			} else {
			  throw ex;
			}
		}
		returnAST = exception_pragma_AST;
		return ep;
	}
	
	public final CommonToken  function_call() throws RecognitionException, TokenStreamException {
		 CommonToken f = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_call_AST = null;
		Token  ou = null;
		AST ou_AST = null;
		Token  op = null;
		AST op_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  cp = null;
		AST cp_AST = null;
		
		try {      // for error handling
			boolean synPredMatched217 = false;
			if (((_tokenSet_89.member(LA(1))) && (LA(2)==OUTER_JOIN))) {
				int _m217 = mark();
				synPredMatched217 = true;
				inputState.guessing++;
				try {
					{
					function();
					match(OUTER_JOIN);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched217 = false;
				}
				rewind(_m217);
				inputState.guessing--;
			}
			if ( synPredMatched217 ) {
				f=function();
				astFactory.addASTChild(currentAST, returnAST);
				ou = LT(1);
				ou_AST = astFactory.create(ou);
				astFactory.addASTChild(currentAST, ou_AST);
				match(OUTER_JOIN);
				function_call_AST = (AST)currentAST.root;
			}
			else {
				boolean synPredMatched219 = false;
				if (((_tokenSet_89.member(LA(1))) && (_tokenSet_103.member(LA(2))) && (_tokenSet_109.member(LA(3))) && (_tokenSet_104.member(LA(4))))) {
					int _m219 = mark();
					synPredMatched219 = true;
					inputState.guessing++;
					try {
						{
						function();
						matchNot(OPEN_PAREN);
						}
					}
					catch (RecognitionException pe) {
						synPredMatched219 = false;
					}
					rewind(_m219);
					inputState.guessing--;
				}
				if ( synPredMatched219 ) {
					f=function();
					astFactory.addASTChild(currentAST, returnAST);
					function_call_AST = (AST)currentAST.root;
				}
				else if ((_tokenSet_25.member(LA(1))) && (LA(2)==OPEN_PAREN) && (_tokenSet_110.member(LA(3))) && (_tokenSet_111.member(LA(4)))) {
					{
					switch ( LA(1)) {
					case LITERAL_open:
					{
						op = LT(1);
						op_AST = astFactory.create(op);
						astFactory.addASTChild(currentAST, op_AST);
						match(LITERAL_open);
						break;
					}
					case LITERAL_replace:
					case LITERAL_count:
					case LITERAL_intersect:
					case LITERAL_abs:
					case LITERAL_ascii:
					case LITERAL_ceil:
					case LITERAL_floor:
					case LITERAL_instr:
					case LITERAL_length:
					case LITERAL_mod:
					case LITERAL_power:
					case LITERAL_round:
					case LITERAL_sign:
					case LITERAL_sqrt:
					case LITERAL_trunc:
					case LITERAL_chr:
					case LITERAL_concat:
					case LITERAL_initcap:
					case LITERAL_lower:
					case LITERAL_lpad:
					case LITERAL_ltrim:
					case LITERAL_rpad:
					case LITERAL_rtrim:
					case LITERAL_soundex:
					case LITERAL_substr:
					case LITERAL_translate:
					case LITERAL_upper:
					case LITERAL_avg:
					case LITERAL_max:
					case LITERAL_min:
					case LITERAL_stddev:
					case LITERAL_sum:
					case LITERAL_variance:
					case LITERAL_chartorowid:
					case LITERAL_convert:
					case LITERAL_hextoraw:
					case LITERAL_rawtohex:
					case LITERAL_rowidtochar:
					case LITERAL_to_char:
					case LITERAL_to_date:
					case LITERAL_to_number:
					case LITERAL_decode:
					case LITERAL_dump:
					case LITERAL_greatest:
					case LITERAL_least:
					case LITERAL_nvl:
					case LITERAL_uid:
					case LITERAL_userenv:
					case LITERAL_vsize:
					case LITERAL_user:
					case LITERAL_sysdate:
					case IDENTIFIER:
					case DOUBLE_QUOTED_STRING:
					{
						f=function();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					o = LT(1);
					o_AST = astFactory.create(o);
					match(OPEN_PAREN);
					{
					switch ( LA(1)) {
					case LITERAL_replace:
					case LITERAL_null:
					case OPEN_PAREN:
					case LITERAL_open:
					case NUMBER:
					case PLUS:
					case MINUS:
					case LITERAL_true:
					case LITERAL_false:
					case LITERAL_cast:
					case LITERAL_trim:
					case LITERAL_count:
					case LITERAL_case:
					case LITERAL_all:
					case LITERAL_any:
					case QUOTED_STRING:
					case LITERAL_intersect:
					case LITERAL_abs:
					case LITERAL_ascii:
					case LITERAL_ceil:
					case LITERAL_floor:
					case LITERAL_instr:
					case LITERAL_length:
					case LITERAL_mod:
					case LITERAL_power:
					case LITERAL_round:
					case LITERAL_sign:
					case LITERAL_sqrt:
					case LITERAL_trunc:
					case LITERAL_chr:
					case LITERAL_concat:
					case LITERAL_initcap:
					case LITERAL_lower:
					case LITERAL_lpad:
					case LITERAL_ltrim:
					case LITERAL_rpad:
					case LITERAL_rtrim:
					case LITERAL_soundex:
					case LITERAL_substr:
					case LITERAL_translate:
					case LITERAL_upper:
					case LITERAL_avg:
					case LITERAL_max:
					case LITERAL_min:
					case LITERAL_stddev:
					case LITERAL_sum:
					case LITERAL_variance:
					case LITERAL_chartorowid:
					case LITERAL_convert:
					case LITERAL_hextoraw:
					case LITERAL_rawtohex:
					case LITERAL_rowidtochar:
					case LITERAL_to_char:
					case LITERAL_to_date:
					case LITERAL_to_number:
					case LITERAL_decode:
					case LITERAL_dump:
					case LITERAL_greatest:
					case LITERAL_least:
					case LITERAL_nvl:
					case LITERAL_uid:
					case LITERAL_userenv:
					case LITERAL_vsize:
					case LITERAL_user:
					case LITERAL_sysdate:
					case IDENTIFIER:
					case DOUBLE_QUOTED_STRING:
					{
						call_argument_list();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case CLOSE_PAREN:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					cp = LT(1);
					cp_AST = astFactory.create(cp);
					match(CLOSE_PAREN);
					function_call_AST = (AST)currentAST.root;
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_103);
				} else {
				  throw ex;
				}
			}
			returnAST = function_call_AST;
			return f;
		}
		
	public final CommonToken  field_name() throws RecognitionException, TokenStreamException {
		CommonToken id= null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST field_name_AST = null;
		
		try {      // for error handling
			id=identifier();
			astFactory.addASTChild(currentAST, returnAST);
			field_name_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_0);
			} else {
			  throw ex;
			}
		}
		returnAST = field_name_AST;
		return id;
	}
	
	public final CommonToken  host_variable() throws RecognitionException, TokenStreamException {
		CommonToken hv= null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST host_variable_AST = null;
		
		try {      // for error handling
			AST tmp39_AST = null;
			tmp39_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp39_AST);
			match(COLON);
			hv=identifier();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				
				hv.setText(':' + hv.getText());
				
			}
			host_variable_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_0);
			} else {
			  throw ex;
			}
		}
		returnAST = host_variable_AST;
		return hv;
	}
	
	public final void plsql_condition() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST plsql_condition_AST = null;
		
		try {      // for error handling
			boolean_exp();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				SoftwareMetrics.incConditionCount();
			}
			plsql_condition_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_112);
			} else {
			  throw ex;
			}
		}
		returnAST = plsql_condition_AST;
	}
	
	public final CommonToken  datatype() throws RecognitionException, TokenStreamException {
		 CommonToken dt = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST datatype_AST = null;
		Token  bi = null;
		AST bi_AST = null;
		Token  n = null;
		AST n_AST = null;
		Token  p = null;
		AST p_AST = null;
		Token  nu = null;
		AST nu_AST = null;
		Token  c = null;
		AST c_AST = null;
		Token  l = null;
		AST l_AST = null;
		Token  rw = null;
		AST rw_AST = null;
		Token  r2 = null;
		AST r2_AST = null;
		Token  bo = null;
		AST bo_AST = null;
		Token  da = null;
		AST da_AST = null;
		Token  sm = null;
		AST sm_AST = null;
		Token  r3 = null;
		AST r3_AST = null;
		Token  nc = null;
		AST nc_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  i2 = null;
		AST i2_AST = null;
		Token  db = null;
		AST db_AST = null;
		Token  dl = null;
		AST dl_AST = null;
		Token  v2 = null;
		AST v2_AST = null;
		Token  v = null;
		AST v_AST = null;
		Token  ch = null;
		AST ch_AST = null;
		Token  ml = null;
		AST ml_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_binary_integer:
			{
				bi = LT(1);
				bi_AST = astFactory.create(bi);
				astFactory.addASTChild(currentAST, bi_AST);
				match(LITERAL_binary_integer);
				if ( inputState.guessing==0 ) {
					
					dt = (CommonToken) bi;
					
				}
				break;
			}
			case LITERAL_natural:
			{
				n = LT(1);
				n_AST = astFactory.create(n);
				astFactory.addASTChild(currentAST, n_AST);
				match(LITERAL_natural);
				if ( inputState.guessing==0 ) {
					
					dt = (CommonToken) n;
					
				}
				break;
			}
			case LITERAL_positive:
			{
				p = LT(1);
				p_AST = astFactory.create(p);
				astFactory.addASTChild(currentAST, p_AST);
				match(LITERAL_positive);
				if ( inputState.guessing==0 ) {
					
					dt = (CommonToken) p;
					
				}
				break;
			}
			case LITERAL_number:
			{
				{
				nu = LT(1);
				nu_AST = astFactory.create(nu);
				astFactory.addASTChild(currentAST, nu_AST);
				match(LITERAL_number);
				{
				if ((LA(1)==OPEN_PAREN) && (LA(2)==NUMBER) && (LA(3)==COMMA||LA(3)==CLOSE_PAREN) && (_tokenSet_113.member(LA(4)))) {
					match(OPEN_PAREN);
					AST tmp41_AST = null;
					tmp41_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp41_AST);
					match(NUMBER);
					{
					switch ( LA(1)) {
					case COMMA:
					{
						AST tmp42_AST = null;
						tmp42_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp42_AST);
						match(COMMA);
						AST tmp43_AST = null;
						tmp43_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp43_AST);
						match(NUMBER);
						break;
					}
					case CLOSE_PAREN:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					match(CLOSE_PAREN);
				}
				else if ((_tokenSet_65.member(LA(1))) && (_tokenSet_64.member(LA(2))) && (_tokenSet_56.member(LA(3))) && (_tokenSet_114.member(LA(4)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				}
				if ( inputState.guessing==0 ) {
					
					dt = (CommonToken) nu;
					
				}
				break;
			}
			case LITERAL_char:
			{
				{
				c = LT(1);
				c_AST = astFactory.create(c);
				astFactory.addASTChild(currentAST, c_AST);
				match(LITERAL_char);
				{
				if ((LA(1)==OPEN_PAREN) && (LA(2)==NUMBER) && (LA(3)==CLOSE_PAREN) && (_tokenSet_65.member(LA(4)))) {
					match(OPEN_PAREN);
					AST tmp46_AST = null;
					tmp46_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp46_AST);
					match(NUMBER);
					match(CLOSE_PAREN);
				}
				else if ((_tokenSet_65.member(LA(1))) && (_tokenSet_64.member(LA(2))) && (_tokenSet_56.member(LA(3))) && (_tokenSet_114.member(LA(4)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				}
				if ( inputState.guessing==0 ) {
					
					dt = (CommonToken) c;
					
				}
				break;
			}
			case LITERAL_long:
			{
				{
				l = LT(1);
				l_AST = astFactory.create(l);
				astFactory.addASTChild(currentAST, l_AST);
				match(LITERAL_long);
				{
				switch ( LA(1)) {
				case LITERAL_raw:
				{
					rw = LT(1);
					rw_AST = astFactory.create(rw);
					astFactory.addASTChild(currentAST, rw_AST);
					match(LITERAL_raw);
					break;
				}
				case DIVIDE:
				case SEMI:
				case LITERAL_or:
				case LITERAL_replace:
				case LITERAL_is:
				case LITERAL_as:
				case LITERAL_end:
				case LITERAL_not:
				case ASSIGNMENT_EQ:
				case LITERAL_default:
				case OPEN_PAREN:
				case COMMA:
				case CLOSE_PAREN:
				case LITERAL_loop:
				case LITERAL_for:
				case LITERAL_when:
				case PERCENTAGE:
				case LITERAL_in:
				case PLUS:
				case MINUS:
				case LITERAL_index:
				case LITERAL_then:
				case DOUBLEDOT:
				case LITERAL_and:
				case LITERAL_like:
				case LITERAL_between:
				case ASTERISK:
				case CONCAT:
				case LITERAL_count:
				case LITERAL_else:
				case LITERAL_bulk:
				case LITERAL_into:
				case LITERAL_using:
				case EQ:
				case LITERAL_union:
				case LITERAL_intersect:
				case LITERAL_minus:
				case LITERAL_from:
				case LITERAL_right:
				case LITERAL_inner:
				case LITERAL_where:
				case LITERAL_abs:
				case LITERAL_ascii:
				case LITERAL_ceil:
				case LITERAL_floor:
				case LITERAL_instr:
				case LITERAL_length:
				case LITERAL_power:
				case LITERAL_sign:
				case LITERAL_sqrt:
				case LITERAL_trunc:
				case LITERAL_chr:
				case LITERAL_concat:
				case LITERAL_initcap:
				case LITERAL_lower:
				case LITERAL_lpad:
				case LITERAL_ltrim:
				case LITERAL_soundex:
				case LITERAL_substr:
				case LITERAL_translate:
				case LITERAL_upper:
				case LITERAL_chartorowid:
				case LITERAL_convert:
				case LITERAL_hextoraw:
				case LITERAL_rawtohex:
				case LITERAL_to_char:
				case LITERAL_to_date:
				case LITERAL_to_number:
				case LITERAL_decode:
				case LITERAL_dump:
				case LITERAL_greatest:
				case LITERAL_least:
				case LITERAL_nvl:
				case LITERAL_userenv:
				case LITERAL_vsize:
				case LITERAL_user:
				case LITERAL_sysdate:
				case 230:
				case LITERAL_escape:
				case LT:
				case GT:
				case NOT_EQ:
				case LE:
				case GE:
				case LITERAL_start:
				case LITERAL_connect:
				case LITERAL_group:
				case LITERAL_having:
				case LITERAL_order:
				case LITERAL_asc:
				case LITERAL_desc:
				case IDENTIFIER:
				case DOUBLE_QUOTED_STRING:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				}
				if ( inputState.guessing==0 ) {
					
					dt = (CommonToken) l;
					if (rw != null)
					dt.setText("long raw");
					
				}
				break;
			}
			case LITERAL_raw:
			{
				r2 = LT(1);
				r2_AST = astFactory.create(r2);
				astFactory.addASTChild(currentAST, r2_AST);
				match(LITERAL_raw);
				if ( inputState.guessing==0 ) {
					
					dt = (CommonToken) r2;
					
				}
				break;
			}
			case LITERAL_boolean:
			{
				bo = LT(1);
				bo_AST = astFactory.create(bo);
				astFactory.addASTChild(currentAST, bo_AST);
				match(LITERAL_boolean);
				if ( inputState.guessing==0 ) {
					
					dt = (CommonToken) bo;
					
				}
				break;
			}
			case LITERAL_date:
			{
				da = LT(1);
				da_AST = astFactory.create(da);
				astFactory.addASTChild(currentAST, da_AST);
				match(LITERAL_date);
				if ( inputState.guessing==0 ) {
					
					dt = (CommonToken) da;
					
				}
				break;
			}
			case LITERAL_smallint:
			{
				sm = LT(1);
				sm_AST = astFactory.create(sm);
				astFactory.addASTChild(currentAST, sm_AST);
				match(LITERAL_smallint);
				if ( inputState.guessing==0 ) {
					
					dt = (CommonToken) sm;
					
				}
				break;
			}
			case LITERAL_real:
			{
				r3 = LT(1);
				r3_AST = astFactory.create(r3);
				astFactory.addASTChild(currentAST, r3_AST);
				match(LITERAL_real);
				if ( inputState.guessing==0 ) {
					
					dt = (CommonToken) r3;
					
				}
				break;
			}
			case LITERAL_numeric:
			{
				nc = LT(1);
				nc_AST = astFactory.create(nc);
				astFactory.addASTChild(currentAST, nc_AST);
				match(LITERAL_numeric);
				if ( inputState.guessing==0 ) {
					
					dt = (CommonToken) nc;
					
				}
				break;
			}
			case LITERAL_int:
			{
				i = LT(1);
				i_AST = astFactory.create(i);
				astFactory.addASTChild(currentAST, i_AST);
				match(LITERAL_int);
				if ( inputState.guessing==0 ) {
					
					dt = (CommonToken) i;
					
				}
				break;
			}
			case LITERAL_integer:
			{
				i2 = LT(1);
				i2_AST = astFactory.create(i2);
				astFactory.addASTChild(currentAST, i2_AST);
				match(LITERAL_integer);
				if ( inputState.guessing==0 ) {
					
					dt = (CommonToken) i2;
					
				}
				break;
			}
			case 104:
			{
				db = LT(1);
				db_AST = astFactory.create(db);
				astFactory.addASTChild(currentAST, db_AST);
				match(104);
				if ( inputState.guessing==0 ) {
					
					dt = (CommonToken) db;
					
				}
				break;
			}
			case LITERAL_decimal:
			{
				dl = LT(1);
				dl_AST = astFactory.create(dl);
				astFactory.addASTChild(currentAST, dl_AST);
				match(LITERAL_decimal);
				if ( inputState.guessing==0 ) {
					
					dt = (CommonToken) dl;
					
				}
				break;
			}
			case 106:
			{
				{
				v2 = LT(1);
				v2_AST = astFactory.create(v2);
				astFactory.addASTChild(currentAST, v2_AST);
				match(106);
				{
				if ((LA(1)==OPEN_PAREN) && (LA(2)==NUMBER) && (LA(3)==CLOSE_PAREN) && (_tokenSet_65.member(LA(4)))) {
					match(OPEN_PAREN);
					AST tmp49_AST = null;
					tmp49_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp49_AST);
					match(NUMBER);
					match(CLOSE_PAREN);
				}
				else if ((_tokenSet_65.member(LA(1))) && (_tokenSet_64.member(LA(2))) && (_tokenSet_56.member(LA(3))) && (_tokenSet_114.member(LA(4)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				}
				if ( inputState.guessing==0 ) {
					
					dt = (CommonToken) v2;
					
				}
				break;
			}
			case LITERAL_varchar:
			{
				{
				v = LT(1);
				v_AST = astFactory.create(v);
				astFactory.addASTChild(currentAST, v_AST);
				match(LITERAL_varchar);
				{
				if ((LA(1)==OPEN_PAREN) && (LA(2)==NUMBER) && (LA(3)==CLOSE_PAREN) && (_tokenSet_65.member(LA(4)))) {
					match(OPEN_PAREN);
					AST tmp52_AST = null;
					tmp52_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp52_AST);
					match(NUMBER);
					match(CLOSE_PAREN);
				}
				else if ((_tokenSet_65.member(LA(1))) && (_tokenSet_64.member(LA(2))) && (_tokenSet_56.member(LA(3))) && (_tokenSet_114.member(LA(4)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				}
				if ( inputState.guessing==0 ) {
					
					dt = (CommonToken) v;
					
				}
				break;
			}
			case LITERAL_character:
			{
				{
				ch = LT(1);
				ch_AST = astFactory.create(ch);
				astFactory.addASTChild(currentAST, ch_AST);
				match(LITERAL_character);
				{
				if ((LA(1)==OPEN_PAREN) && (LA(2)==NUMBER) && (LA(3)==CLOSE_PAREN) && (_tokenSet_65.member(LA(4)))) {
					match(OPEN_PAREN);
					AST tmp55_AST = null;
					tmp55_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp55_AST);
					match(NUMBER);
					match(CLOSE_PAREN);
				}
				else if ((_tokenSet_65.member(LA(1))) && (_tokenSet_64.member(LA(2))) && (_tokenSet_56.member(LA(3))) && (_tokenSet_114.member(LA(4)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				}
				if ( inputState.guessing==0 ) {
					
					dt = (CommonToken) ch;
					
				}
				break;
			}
			case LITERAL_mlslabel:
			{
				ml = LT(1);
				ml_AST = astFactory.create(ml);
				astFactory.addASTChild(currentAST, ml_AST);
				match(LITERAL_mlslabel);
				if ( inputState.guessing==0 ) {
					
					dt = (CommonToken) ml;
					
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			datatype_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_65);
			} else {
			  throw ex;
			}
		}
		returnAST = datatype_AST;
		return dt;
	}
	
	public final CommonToken  table_name() throws RecognitionException, TokenStreamException {
		 CommonToken id = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST table_name_AST = null;
		
		try {      // for error handling
			id=identifier();
			astFactory.addASTChild(currentAST, returnAST);
			table_name_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_115);
			} else {
			  throw ex;
			}
		}
		returnAST = table_name_AST;
		return id;
	}
	
	public final CommonToken  column_name() throws RecognitionException, TokenStreamException {
		 CommonToken id = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST column_name_AST = null;
		Token  d = null;
		AST d_AST = null;
		
		CommonToken o = null;
		CommonToken i1 = null;
		
		
		try {      // for error handling
			id=identifier();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case DOT:
			{
				d = LT(1);
				d_AST = astFactory.create(d);
				astFactory.addASTChild(currentAST, d_AST);
				match(DOT);
				i1=identifier();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			case LITERAL_replace:
			case COMMA:
			case CLOSE_PAREN:
			case LITERAL_binary_integer:
			case LITERAL_natural:
			case LITERAL_positive:
			case LITERAL_number:
			case LITERAL_char:
			case LITERAL_long:
			case LITERAL_raw:
			case LITERAL_boolean:
			case LITERAL_date:
			case LITERAL_smallint:
			case LITERAL_real:
			case LITERAL_numeric:
			case LITERAL_int:
			case LITERAL_integer:
			case 104:
			case LITERAL_decimal:
			case 106:
			case LITERAL_varchar:
			case LITERAL_character:
			case LITERAL_mlslabel:
			case PERCENTAGE:
			case LITERAL_count:
			case LITERAL_using:
			case EQ:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case LITERAL_nowait:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				
				if (d != null)
				id.setText(i1.getText() + '.' + i1.getText());
				
			}
			column_name_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_116);
			} else {
			  throw ex;
			}
		}
		returnAST = column_name_AST;
		return id;
	}
	
	public final CommonToken  parameter_name() throws RecognitionException, TokenStreamException {
		 CommonToken pn = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameter_name_AST = null;
		
		try {      // for error handling
			pn=identifier();
			astFactory.addASTChild(currentAST, returnAST);
			parameter_name_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_117);
			} else {
			  throw ex;
			}
		}
		returnAST = parameter_name_AST;
		return pn;
	}
	
	public final CommonToken  return_type() throws RecognitionException, TokenStreamException {
		 CommonToken t = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST return_type_AST = null;
		
		try {      // for error handling
			t=type_spec();
			astFactory.addASTChild(currentAST, returnAST);
			return_type_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_75);
			} else {
			  throw ex;
			}
		}
		returnAST = return_type_AST;
		return t;
	}
	
	public final CommonToken  exception_name() throws RecognitionException, TokenStreamException {
		 CommonToken en = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exception_name_AST = null;
		Token  d = null;
		AST d_AST = null;
		
		CommonToken ep = null;
		
		
		try {      // for error handling
			en=exception_package_name();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case DOT:
			{
				d = LT(1);
				d_AST = astFactory.create(d);
				astFactory.addASTChild(currentAST, d_AST);
				match(DOT);
				ep=identifier();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			case LITERAL_or:
			case COMMA:
			case LITERAL_exception:
			case LITERAL_then:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			exception_name_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_118);
			} else {
			  throw ex;
			}
		}
		returnAST = exception_name_AST;
		return en;
	}
	
	public final CommonToken  exception_package_name() throws RecognitionException, TokenStreamException {
		 CommonToken ep = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exception_package_name_AST = null;
		
		try {      // for error handling
			ep=identifier();
			astFactory.addASTChild(currentAST, returnAST);
			exception_package_name_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_119);
			} else {
			  throw ex;
			}
		}
		returnAST = exception_package_name_AST;
		return ep;
	}
	
	public final CommonToken  oracle_err_number() throws RecognitionException, TokenStreamException {
		 CommonToken oen = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST oracle_err_number_AST = null;
		Token  p = null;
		AST p_AST = null;
		Token  m = null;
		AST m_AST = null;
		Token  n = null;
		AST n_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case PLUS:
			{
				p = LT(1);
				p_AST = astFactory.create(p);
				astFactory.addASTChild(currentAST, p_AST);
				match(PLUS);
				break;
			}
			case MINUS:
			{
				m = LT(1);
				m_AST = astFactory.create(m);
				astFactory.addASTChild(currentAST, m_AST);
				match(MINUS);
				break;
			}
			case NUMBER:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			n = LT(1);
			n_AST = astFactory.create(n);
			astFactory.addASTChild(currentAST, n_AST);
			match(NUMBER);
			if ( inputState.guessing==0 ) {
				
				oen = (CommonToken) n;
				
			}
			oracle_err_number_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_120);
			} else {
			  throw ex;
			}
		}
		returnAST = oracle_err_number_AST;
		return oen;
	}
	
	public final CommonToken  numeric_literal() throws RecognitionException, TokenStreamException {
		 CommonToken nl = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST numeric_literal_AST = null;
		Token  n = null;
		AST n_AST = null;
		
		try {      // for error handling
			n = LT(1);
			n_AST = astFactory.create(n);
			astFactory.addASTChild(currentAST, n_AST);
			match(NUMBER);
			if ( inputState.guessing==0 ) {
				
				nl = (CommonToken) n;
				
			}
			numeric_literal_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_51);
			} else {
			  throw ex;
			}
		}
		returnAST = numeric_literal_AST;
		return nl;
	}
	
	public final CommonToken  record_type_dec() throws RecognitionException, TokenStreamException {
		 CommonToken rt = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST record_type_dec_AST = null;
		Token  r = null;
		AST r_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  co = null;
		AST co_AST = null;
		Token  cp = null;
		AST cp_AST = null;
		Token  rf = null;
		AST rf_AST = null;
		Token  cu = null;
		AST cu_AST = null;
		Token  rg = null;
		AST rg_AST = null;
		Token  v = null;
		AST v_AST = null;
		Token  c2 = null;
		AST c2_AST = null;
		Token  o1 = null;
		AST o1_AST = null;
		
		try {      // for error handling
			rt=record_table_preamble();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_record:
			{
				{
				r = LT(1);
				r_AST = astFactory.create(r);
				astFactory.addASTChild(currentAST, r_AST);
				match(LITERAL_record);
				{
				o = LT(1);
				o_AST = astFactory.create(o);
				astFactory.addASTChild(currentAST, o_AST);
				match(OPEN_PAREN);
				field_spec();
				astFactory.addASTChild(currentAST, returnAST);
				type_spec();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop155:
				do {
					if ((LA(1)==COMMA)) {
						co = LT(1);
						co_AST = astFactory.create(co);
						astFactory.addASTChild(currentAST, co_AST);
						match(COMMA);
						field_spec();
						astFactory.addASTChild(currentAST, returnAST);
						type_spec();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop155;
					}
					
				} while (true);
				}
				cp = LT(1);
				cp_AST = astFactory.create(cp);
				match(CLOSE_PAREN);
				}
				}
				break;
			}
			case LITERAL_ref:
			{
				{
				rf = LT(1);
				rf_AST = astFactory.create(rf);
				astFactory.addASTChild(currentAST, rf_AST);
				match(LITERAL_ref);
				cu = LT(1);
				cu_AST = astFactory.create(cu);
				astFactory.addASTChild(currentAST, cu_AST);
				match(LITERAL_cursor);
				{
				switch ( LA(1)) {
				case LITERAL_return:
				{
					rg = LT(1);
					rg_AST = astFactory.create(rg);
					astFactory.addASTChild(currentAST, rg_AST);
					match(LITERAL_return);
					record_name();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SEMI:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				}
				break;
			}
			case LITERAL_varray:
			{
				{
				v = LT(1);
				v_AST = astFactory.create(v);
				astFactory.addASTChild(currentAST, v_AST);
				match(LITERAL_varray);
				match(OPEN_PAREN);
				plsql_expression();
				astFactory.addASTChild(currentAST, returnAST);
				c2 = LT(1);
				c2_AST = astFactory.create(c2);
				match(CLOSE_PAREN);
				o1 = LT(1);
				o1_AST = astFactory.create(o1);
				astFactory.addASTChild(currentAST, o1_AST);
				match(LITERAL_of);
				rt=type_name();
				astFactory.addASTChild(currentAST, returnAST);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(SEMI);
			record_type_dec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_50);
			} else {
			  throw ex;
			}
		}
		returnAST = record_type_dec_AST;
		return rt;
	}
	
	public final CommonToken  record_var_dec() throws RecognitionException, TokenStreamException {
		 CommonToken rv = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST record_var_dec_AST = null;
		
		try {      // for error handling
			record_name();
			astFactory.addASTChild(currentAST, returnAST);
			rv=type_name();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp59_AST = null;
			tmp59_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp59_AST);
			match(PERCENTAGE);
			AST tmp60_AST = null;
			tmp60_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp60_AST);
			match(LITERAL_rowtype);
			match(SEMI);
			record_var_dec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_50);
			} else {
			  throw ex;
			}
		}
		returnAST = record_var_dec_AST;
		return rv;
	}
	
	public final CommonToken  record_table_preamble() throws RecognitionException, TokenStreamException {
		 CommonToken rt = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST record_table_preamble_AST = null;
		Token  t = null;
		AST t_AST = null;
		Token  i = null;
		AST i_AST = null;
		
		try {      // for error handling
			t = LT(1);
			t_AST = astFactory.create(t);
			astFactory.addASTChild(currentAST, t_AST);
			match(LITERAL_type);
			rt=type_name();
			astFactory.addASTChild(currentAST, returnAST);
			i = LT(1);
			i_AST = astFactory.create(i);
			astFactory.addASTChild(currentAST, i_AST);
			match(LITERAL_is);
			record_table_preamble_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_121);
			} else {
			  throw ex;
			}
		}
		returnAST = record_table_preamble_AST;
		return rt;
	}
	
	public final CommonToken  field_spec() throws RecognitionException, TokenStreamException {
		 CommonToken fs = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST field_spec_AST = null;
		
		try {      // for error handling
			fs=column_spec();
			astFactory.addASTChild(currentAST, returnAST);
			field_spec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_35);
			} else {
			  throw ex;
			}
		}
		returnAST = field_spec_AST;
		return fs;
	}
	
	public final CommonToken  record_name() throws RecognitionException, TokenStreamException {
		 CommonToken id = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST record_name_AST = null;
		
		try {      // for error handling
			id=identifier();
			astFactory.addASTChild(currentAST, returnAST);
			record_name_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_122);
			} else {
			  throw ex;
			}
		}
		returnAST = record_name_AST;
		return id;
	}
	
	public final CommonToken  column_spec() throws RecognitionException, TokenStreamException {
		 CommonToken cs = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST column_spec_AST = null;
		Token  d1 = null;
		AST d1_AST = null;
		Token  d2 = null;
		AST d2_AST = null;
		
		try {      // for error handling
			{
			if ((_tokenSet_1.member(LA(1))) && (LA(2)==DOT) && (_tokenSet_1.member(LA(3))) && (_tokenSet_123.member(LA(4)))) {
				{
				if ((_tokenSet_1.member(LA(1))) && (LA(2)==DOT) && (_tokenSet_1.member(LA(3))) && (LA(4)==DOT)) {
					schema_name();
					astFactory.addASTChild(currentAST, returnAST);
					d1 = LT(1);
					d1_AST = astFactory.create(d1);
					astFactory.addASTChild(currentAST, d1_AST);
					match(DOT);
				}
				else if ((_tokenSet_1.member(LA(1))) && (LA(2)==DOT) && (_tokenSet_1.member(LA(3))) && (_tokenSet_123.member(LA(4)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				table_name();
				astFactory.addASTChild(currentAST, returnAST);
				d2 = LT(1);
				d2_AST = astFactory.create(d2);
				astFactory.addASTChild(currentAST, d2_AST);
				match(DOT);
			}
			else if ((_tokenSet_1.member(LA(1))) && (_tokenSet_123.member(LA(2))) && (_tokenSet_124.member(LA(3))) && (_tokenSet_125.member(LA(4)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			cs=column_name();
			astFactory.addASTChild(currentAST, returnAST);
			column_spec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_126);
			} else {
			  throw ex;
			}
		}
		returnAST = column_spec_AST;
		return cs;
	}
	
	public final CommonToken  table_type_dec() throws RecognitionException, TokenStreamException {
		 CommonToken tt = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST table_type_dec_AST = null;
		Token  t = null;
		AST t_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  b = null;
		AST b_AST = null;
		Token  bi = null;
		AST bi_AST = null;
		
		try {      // for error handling
			record_table_preamble();
			astFactory.addASTChild(currentAST, returnAST);
			t = LT(1);
			t_AST = astFactory.create(t);
			astFactory.addASTChild(currentAST, t_AST);
			match(LITERAL_table);
			o = LT(1);
			o_AST = astFactory.create(o);
			astFactory.addASTChild(currentAST, o_AST);
			match(LITERAL_of);
			{
			if ((_tokenSet_35.member(LA(1))) && (_tokenSet_127.member(LA(2))) && (_tokenSet_128.member(LA(3))) && (_tokenSet_129.member(LA(4)))) {
				type_spec();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else if ((_tokenSet_35.member(LA(1))) && (_tokenSet_130.member(LA(2))) && (_tokenSet_131.member(LA(3))) && (_tokenSet_132.member(LA(4)))) {
				type_name();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			i = LT(1);
			i_AST = astFactory.create(i);
			astFactory.addASTChild(currentAST, i_AST);
			match(LITERAL_index);
			b = LT(1);
			b_AST = astFactory.create(b);
			astFactory.addASTChild(currentAST, b_AST);
			match(LITERAL_by);
			bi = LT(1);
			bi_AST = astFactory.create(bi);
			astFactory.addASTChild(currentAST, bi_AST);
			match(LITERAL_binary_integer);
			match(SEMI);
			if ( inputState.guessing==0 ) {
				
				tt = (CommonToken) bi;
				
			}
			table_type_dec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_50);
			} else {
			  throw ex;
			}
		}
		returnAST = table_type_dec_AST;
		return tt;
	}
	
	public final CommonToken  table_var_dec() throws RecognitionException, TokenStreamException {
		 CommonToken tv = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST table_var_dec_AST = null;
		
		try {      // for error handling
			plsql_table_name();
			astFactory.addASTChild(currentAST, returnAST);
			tv=type_name();
			astFactory.addASTChild(currentAST, returnAST);
			match(SEMI);
			table_var_dec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_50);
			} else {
			  throw ex;
			}
		}
		returnAST = table_var_dec_AST;
		return tv;
	}
	
	public final CommonToken  plsql_table_name() throws RecognitionException, TokenStreamException {
		 CommonToken pt = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST plsql_table_name_AST = null;
		
		try {      // for error handling
			pt=identifier();
			astFactory.addASTChild(currentAST, returnAST);
			plsql_table_name_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_35);
			} else {
			  throw ex;
			}
		}
		returnAST = plsql_table_name_AST;
		return pt;
	}
	
	public final CommonToken  procedure_name() throws RecognitionException, TokenStreamException {
		 CommonToken pn = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST procedure_name_AST = null;
		Token  d = null;
		AST d_AST = null;
		
		CommonToken lv;
		
		
		try {      // for error handling
			{
			pn=identifier();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop210:
			do {
				if ((LA(1)==DOT)) {
					d = LT(1);
					d_AST = astFactory.create(d);
					astFactory.addASTChild(currentAST, d_AST);
					match(DOT);
					lv=identifier();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						
						pn.setText(pn.getText() + '.' + lv.getText());
						
					}
				}
				else {
					break _loop210;
				}
				
			} while (true);
			}
			}
			procedure_name_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_133);
			} else {
			  throw ex;
			}
		}
		returnAST = procedure_name_AST;
		return pn;
	}
	
	public final CommonToken  argument() throws RecognitionException, TokenStreamException {
		 CommonToken v = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST argument_AST = null;
		Token  a = null;
		AST a_AST = null;
		Token  d = null;
		AST d_AST = null;
		
		try {      // for error handling
			parameter_spec();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case ASSIGNMENT_EQ:
			case LITERAL_default:
			{
				{
				switch ( LA(1)) {
				case ASSIGNMENT_EQ:
				{
					a = LT(1);
					a_AST = astFactory.create(a);
					astFactory.addASTChild(currentAST, a_AST);
					match(ASSIGNMENT_EQ);
					break;
				}
				case LITERAL_default:
				{
					d = LT(1);
					d_AST = astFactory.create(d);
					astFactory.addASTChild(currentAST, d_AST);
					match(LITERAL_default);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				plsql_expression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case COMMA:
			case CLOSE_PAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			argument_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_134);
			} else {
			  throw ex;
			}
		}
		returnAST = argument_AST;
		return v;
	}
	
	public final CommonToken  func_proc_statements() throws RecognitionException, TokenStreamException {
		CommonToken e= null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST func_proc_statements_AST = null;
		Token  b = null;
		AST b_AST = null;
		Token  en = null;
		AST en_AST = null;
		
		CommonToken pn = null;
		
		
		try {      // for error handling
			{
			_loop177:
			do {
				if ((_tokenSet_9.member(LA(1)))) {
					declare_spec();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop177;
				}
				
			} while (true);
			}
			b = LT(1);
			b_AST = astFactory.create(b);
			astFactory.addASTChild(currentAST, b_AST);
			match(LITERAL_begin);
			{
			switch ( LA(1)) {
			case LITERAL_set:
			case LITERAL_replace:
			case LITERAL_null:
			case OPEN_PAREN:
			case START_LABEL:
			case LITERAL_begin:
			case LITERAL_loop:
			case LITERAL_for:
			case LITERAL_while:
			case LITERAL_forall:
			case LITERAL_if:
			case LITERAL_goto:
			case LITERAL_raise:
			case LITERAL_exit:
			case LITERAL_return:
			case LITERAL_with:
			case LITERAL_select:
			case LITERAL_update:
			case LITERAL_insert:
			case LITERAL_delete:
			case LITERAL_alter:
			case LITERAL_lock:
			case LITERAL_execute:
			case LITERAL_commit:
			case LITERAL_rollback:
			case LITERAL_open:
			case LITERAL_fetch:
			case LITERAL_close:
			case LITERAL_declare:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_mod:
			case LITERAL_power:
			case LITERAL_round:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_rpad:
			case LITERAL_rtrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_avg:
			case LITERAL_max:
			case LITERAL_min:
			case LITERAL_stddev:
			case LITERAL_sum:
			case LITERAL_variance:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_rowidtochar:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_uid:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case LITERAL_savepoint:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				seq_of_statements();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_end:
			case LITERAL_exception:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_exception:
			{
				AST tmp64_AST = null;
				tmp64_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp64_AST);
				match(LITERAL_exception);
				{
				int _cnt181=0;
				_loop181:
				do {
					if ((LA(1)==LITERAL_when)) {
						e=exception_handler();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						if ( _cnt181>=1 ) { break _loop181; } else {throw new NoViableAltException(LT(1), getFilename());}
					}
					
					_cnt181++;
				} while (true);
				}
				break;
			}
			case LITERAL_end:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			en = LT(1);
			en_AST = astFactory.create(en);
			astFactory.addASTChild(currentAST, en_AST);
			match(LITERAL_end);
			{
			switch ( LA(1)) {
			case LITERAL_replace:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				pn=identifier();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(SEMI);
			if ( inputState.guessing==0 ) {
				func_proc_statements_AST = (AST)currentAST.root;
				
				func_proc_statements_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PLSQL_BLOCK,"func_proc_statements")).add(func_proc_statements_AST));
				
				currentAST.root = func_proc_statements_AST;
				currentAST.child = func_proc_statements_AST!=null &&func_proc_statements_AST.getFirstChild()!=null ?
					func_proc_statements_AST.getFirstChild() : func_proc_statements_AST;
				currentAST.advanceChildToEnd();
			}
			func_proc_statements_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_29);
			} else {
			  throw ex;
			}
		}
		returnAST = func_proc_statements_AST;
		return e;
	}
	
	public final CommonToken  exception_handler() throws RecognitionException, TokenStreamException {
		 CommonToken eh = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exception_handler_AST = null;
		Token  w = null;
		AST w_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  t = null;
		AST t_AST = null;
		
		CommonToken e;
		
		
		try {      // for error handling
			w = LT(1);
			w_AST = astFactory.create(w);
			astFactory.addASTChild(currentAST, w_AST);
			match(LITERAL_when);
			eh=exception_name();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop195:
			do {
				if ((LA(1)==LITERAL_or)) {
					o = LT(1);
					o_AST = astFactory.create(o);
					astFactory.addASTChild(currentAST, o_AST);
					match(LITERAL_or);
					e=exception_name();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						
						eh.setText(eh.getText() + '+' + e.getText());
						
					}
				}
				else {
					break _loop195;
				}
				
			} while (true);
			}
			t = LT(1);
			t_AST = astFactory.create(t);
			astFactory.addASTChild(currentAST, t_AST);
			match(LITERAL_then);
			seq_of_statements();
			astFactory.addASTChild(currentAST, returnAST);
			exception_handler_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_135);
			} else {
			  throw ex;
			}
		}
		returnAST = exception_handler_AST;
		return eh;
	}
	
	public final CommonToken  function_name() throws RecognitionException, TokenStreamException {
		 CommonToken fn = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_name_AST = null;
		Token  d = null;
		AST d_AST = null;
		
		CommonToken lv;
		
		
		try {      // for error handling
			{
			fn=identifier();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case DOT:
			{
				d = LT(1);
				d_AST = astFactory.create(d);
				astFactory.addASTChild(currentAST, d_AST);
				match(DOT);
				lv=identifier();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					
					fn.setText(fn.getText() + '.' + lv.getText());
					
				}
				break;
			}
			case OPEN_PAREN:
			case LITERAL_return:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			}
			function_name_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_136);
			} else {
			  throw ex;
			}
		}
		returnAST = function_name_AST;
		return fn;
	}
	
	public final CommonToken  function() throws RecognitionException, TokenStreamException {
		 CommonToken f = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_AST = null;
		
		try {      // for error handling
			if ((_tokenSet_137.member(LA(1))) && (_tokenSet_138.member(LA(2))) && (_tokenSet_139.member(LA(3))) && (_tokenSet_104.member(LA(4)))) {
				f=built_in_function();
				astFactory.addASTChild(currentAST, returnAST);
				function_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_1.member(LA(1))) && (_tokenSet_138.member(LA(2))) && (_tokenSet_139.member(LA(3))) && (_tokenSet_104.member(LA(4)))) {
				f=user_defined_function();
				astFactory.addASTChild(currentAST, returnAST);
				function_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_138);
			} else {
			  throw ex;
			}
		}
		returnAST = function_AST;
		return f;
	}
	
	public final void call_argument_list() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST call_argument_list_AST = null;
		Token  c = null;
		AST c_AST = null;
		
		try {      // for error handling
			boolean synPredMatched421 = false;
			if (((_tokenSet_20.member(LA(1))) && (_tokenSet_140.member(LA(2))) && (_tokenSet_141.member(LA(3))) && (_tokenSet_142.member(LA(4))))) {
				int _m421 = mark();
				synPredMatched421 = true;
				inputState.guessing++;
				try {
					{
					call_argument();
					match(COMMA);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched421 = false;
				}
				rewind(_m421);
				inputState.guessing--;
			}
			if ( synPredMatched421 ) {
				{
				call_argument();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop424:
				do {
					if ((LA(1)==COMMA)) {
						c = LT(1);
						c_AST = astFactory.create(c);
						astFactory.addASTChild(currentAST, c_AST);
						match(COMMA);
						call_argument();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop424;
					}
					
				} while (true);
				}
				}
				call_argument_list_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_20.member(LA(1))) && (_tokenSet_143.member(LA(2))) && (_tokenSet_141.member(LA(3))) && (_tokenSet_142.member(LA(4)))) {
				call_argument();
				astFactory.addASTChild(currentAST, returnAST);
				call_argument_list_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_74);
			} else {
			  throw ex;
			}
		}
		returnAST = call_argument_list_AST;
	}
	
	public final void cursor_loop_param() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST cursor_loop_param_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  o1 = null;
		AST o1_AST = null;
		Token  c1 = null;
		AST c1_AST = null;
		Token  o2 = null;
		AST o2_AST = null;
		Token  c2 = null;
		AST c2_AST = null;
		
		try {      // for error handling
			record_name();
			astFactory.addASTChild(currentAST, returnAST);
			i = LT(1);
			i_AST = astFactory.create(i);
			astFactory.addASTChild(currentAST, i_AST);
			match(LITERAL_in);
			{
			switch ( LA(1)) {
			case LITERAL_replace:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				{
				cursor_name();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case OPEN_PAREN:
				{
					o1 = LT(1);
					o1_AST = astFactory.create(o1);
					match(OPEN_PAREN);
					plsql_exp_list();
					astFactory.addASTChild(currentAST, returnAST);
					c1 = LT(1);
					c1_AST = astFactory.create(c1);
					match(CLOSE_PAREN);
					break;
				}
				case LITERAL_loop:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				}
				break;
			}
			case OPEN_PAREN:
			{
				{
				o2 = LT(1);
				o2_AST = astFactory.create(o2);
				match(OPEN_PAREN);
				select_expression();
				astFactory.addASTChild(currentAST, returnAST);
				c2 = LT(1);
				c2_AST = astFactory.create(c2);
				match(CLOSE_PAREN);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			cursor_loop_param_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_144);
			} else {
			  throw ex;
			}
		}
		returnAST = cursor_loop_param_AST;
	}
	
	public final void numeric_loop_param() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST numeric_loop_param_AST = null;
		Token  in = null;
		AST in_AST = null;
		Token  r = null;
		AST r_AST = null;
		Token  d = null;
		AST d_AST = null;
		
		try {      // for error handling
			index_name();
			astFactory.addASTChild(currentAST, returnAST);
			in = LT(1);
			in_AST = astFactory.create(in);
			astFactory.addASTChild(currentAST, in_AST);
			match(LITERAL_in);
			{
			switch ( LA(1)) {
			case LITERAL_reverse:
			{
				r = LT(1);
				r_AST = astFactory.create(r);
				astFactory.addASTChild(currentAST, r_AST);
				match(LITERAL_reverse);
				break;
			}
			case LITERAL_replace:
			case LITERAL_null:
			case OPEN_PAREN:
			case LITERAL_open:
			case LITERAL_binary_integer:
			case LITERAL_natural:
			case LITERAL_positive:
			case LITERAL_number:
			case NUMBER:
			case LITERAL_char:
			case LITERAL_long:
			case LITERAL_raw:
			case LITERAL_boolean:
			case LITERAL_date:
			case LITERAL_smallint:
			case LITERAL_real:
			case LITERAL_numeric:
			case LITERAL_int:
			case LITERAL_integer:
			case 104:
			case LITERAL_decimal:
			case 106:
			case LITERAL_varchar:
			case LITERAL_character:
			case LITERAL_mlslabel:
			case PLUS:
			case MINUS:
			case LITERAL_true:
			case LITERAL_false:
			case LITERAL_cast:
			case LITERAL_trim:
			case LITERAL_count:
			case LITERAL_case:
			case LITERAL_all:
			case LITERAL_any:
			case QUOTED_STRING:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_mod:
			case LITERAL_power:
			case LITERAL_round:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_rpad:
			case LITERAL_rtrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_avg:
			case LITERAL_max:
			case LITERAL_min:
			case LITERAL_stddev:
			case LITERAL_sum:
			case LITERAL_variance:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_rowidtochar:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_uid:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			integer_expr();
			astFactory.addASTChild(currentAST, returnAST);
			d = LT(1);
			d_AST = astFactory.create(d);
			astFactory.addASTChild(currentAST, d_AST);
			match(DOUBLEDOT);
			integer_expr();
			astFactory.addASTChild(currentAST, returnAST);
			numeric_loop_param_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_144);
			} else {
			  throw ex;
			}
		}
		returnAST = numeric_loop_param_AST;
	}
	
	public final void boolean_exp() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST boolean_exp_AST = null;
		Token  o = null;
		AST o_AST = null;
		
		try {      // for error handling
			{
			boolean_term();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop242:
			do {
				if ((LA(1)==LITERAL_or)) {
					o = LT(1);
					o_AST = astFactory.create(o);
					astFactory.addASTChild(currentAST, o_AST);
					match(LITERAL_or);
					boolean_term();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop242;
				}
				
			} while (true);
			}
			}
			boolean_exp_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_145);
			} else {
			  throw ex;
			}
		}
		returnAST = boolean_exp_AST;
	}
	
	public final void boolean_term() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST boolean_term_AST = null;
		Token  a = null;
		AST a_AST = null;
		
		try {      // for error handling
			{
			maybe_negated_factor();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop246:
			do {
				if ((LA(1)==LITERAL_and)) {
					a = LT(1);
					a_AST = astFactory.create(a);
					astFactory.addASTChild(currentAST, a_AST);
					match(LITERAL_and);
					maybe_negated_factor();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop246;
				}
				
			} while (true);
			}
			}
			boolean_term_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_146);
			} else {
			  throw ex;
			}
		}
		returnAST = boolean_term_AST;
	}
	
	public final void maybe_negated_factor() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST maybe_negated_factor_AST = null;
		Token  n0 = null;
		AST n0_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_not:
			{
				n0 = LT(1);
				n0_AST = astFactory.create(n0);
				astFactory.addASTChild(currentAST, n0_AST);
				match(LITERAL_not);
				break;
			}
			case SEMI:
			case LITERAL_or:
			case LITERAL_replace:
			case LITERAL_null:
			case OPEN_PAREN:
			case CLOSE_PAREN:
			case LITERAL_loop:
			case LITERAL_open:
			case NUMBER:
			case PLUS:
			case MINUS:
			case LITERAL_then:
			case LITERAL_and:
			case LITERAL_true:
			case LITERAL_false:
			case LITERAL_cast:
			case LITERAL_trim:
			case LITERAL_count:
			case LITERAL_case:
			case LITERAL_all:
			case LITERAL_any:
			case QUOTED_STRING:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_mod:
			case LITERAL_power:
			case LITERAL_round:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_rpad:
			case LITERAL_rtrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_avg:
			case LITERAL_max:
			case LITERAL_min:
			case LITERAL_stddev:
			case LITERAL_sum:
			case LITERAL_variance:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_rowidtochar:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_uid:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			boolean_factor();
			astFactory.addASTChild(currentAST, returnAST);
			maybe_negated_factor_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_147);
			} else {
			  throw ex;
			}
		}
		returnAST = maybe_negated_factor_AST;
	}
	
	public final CommonToken  boolean_factor() throws RecognitionException, TokenStreamException {
		 CommonToken r = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST boolean_factor_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  cp = null;
		AST cp_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  no = null;
		AST no_AST = null;
		Token  n = null;
		AST n_AST = null;
		Token  n1 = null;
		AST n1_AST = null;
		Token  l = null;
		AST l_AST = null;
		Token  n2 = null;
		AST n2_AST = null;
		Token  b = null;
		AST b_AST = null;
		Token  a = null;
		AST a_AST = null;
		Token  n3 = null;
		AST n3_AST = null;
		Token  in = null;
		AST in_AST = null;
		Token  op = null;
		AST op_AST = null;
		Token  c2 = null;
		AST c2_AST = null;
		Token  pc = null;
		AST pc_AST = null;
		Token  nf = null;
		AST nf_AST = null;
		Token  fo = null;
		AST fo_AST = null;
		Token  io = null;
		AST io_AST = null;
		Token  p3 = null;
		AST p3_AST = null;
		Token  n4 = null;
		AST n4_AST = null;
		Token  f2 = null;
		AST f2_AST = null;
		Token  i2 = null;
		AST i2_AST = null;
		
		try {      // for error handling
			boolean synPredMatched251 = false;
			if (((LA(1)==OPEN_PAREN) && (_tokenSet_148.member(LA(2))) && (_tokenSet_149.member(LA(3))) && (_tokenSet_150.member(LA(4))))) {
				int _m251 = mark();
				synPredMatched251 = true;
				inputState.guessing++;
				try {
					{
					match(OPEN_PAREN);
					boolean_exp();
					match(CLOSE_PAREN);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched251 = false;
				}
				rewind(_m251);
				inputState.guessing--;
			}
			if ( synPredMatched251 ) {
				o = LT(1);
				o_AST = astFactory.create(o);
				astFactory.addASTChild(currentAST, o_AST);
				match(OPEN_PAREN);
				boolean_exp();
				astFactory.addASTChild(currentAST, returnAST);
				cp = LT(1);
				cp_AST = astFactory.create(cp);
				astFactory.addASTChild(currentAST, cp_AST);
				match(CLOSE_PAREN);
				boolean_factor_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_20.member(LA(1))) && (_tokenSet_151.member(LA(2))) && (_tokenSet_152.member(LA(3))) && (_tokenSet_153.member(LA(4)))) {
				{
				plsql_expression();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case EQ:
				case LT:
				case GT:
				case NOT_EQ:
				case LE:
				case GE:
				{
					{
					r=relational_op();
					astFactory.addASTChild(currentAST, returnAST);
					plsql_expression();
					astFactory.addASTChild(currentAST, returnAST);
					}
					break;
				}
				case LITERAL_is:
				{
					{
					i = LT(1);
					i_AST = astFactory.create(i);
					astFactory.addASTChild(currentAST, i_AST);
					match(LITERAL_is);
					{
					switch ( LA(1)) {
					case LITERAL_not:
					{
						no = LT(1);
						no_AST = astFactory.create(no);
						astFactory.addASTChild(currentAST, no_AST);
						match(LITERAL_not);
						break;
					}
					case LITERAL_null:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					n = LT(1);
					n_AST = astFactory.create(n);
					astFactory.addASTChild(currentAST, n_AST);
					match(LITERAL_null);
					}
					break;
				}
				case LITERAL_replace:
				case OPEN_PAREN:
				case LITERAL_count:
				case LITERAL_intersect:
				case LITERAL_abs:
				case LITERAL_ascii:
				case LITERAL_ceil:
				case LITERAL_floor:
				case LITERAL_instr:
				case LITERAL_length:
				case LITERAL_power:
				case LITERAL_sign:
				case LITERAL_sqrt:
				case LITERAL_trunc:
				case LITERAL_chr:
				case LITERAL_concat:
				case LITERAL_initcap:
				case LITERAL_lower:
				case LITERAL_lpad:
				case LITERAL_ltrim:
				case LITERAL_soundex:
				case LITERAL_substr:
				case LITERAL_translate:
				case LITERAL_upper:
				case LITERAL_chartorowid:
				case LITERAL_convert:
				case LITERAL_hextoraw:
				case LITERAL_rawtohex:
				case LITERAL_to_char:
				case LITERAL_to_date:
				case LITERAL_to_number:
				case LITERAL_decode:
				case LITERAL_dump:
				case LITERAL_greatest:
				case LITERAL_least:
				case LITERAL_nvl:
				case LITERAL_userenv:
				case LITERAL_vsize:
				case LITERAL_user:
				case LITERAL_sysdate:
				case IDENTIFIER:
				case DOUBLE_QUOTED_STRING:
				{
					{
					{
					switch ( LA(1)) {
					case LITERAL_replace:
					case LITERAL_count:
					case LITERAL_intersect:
					case LITERAL_abs:
					case LITERAL_ascii:
					case LITERAL_ceil:
					case LITERAL_floor:
					case LITERAL_instr:
					case LITERAL_length:
					case LITERAL_power:
					case LITERAL_sign:
					case LITERAL_sqrt:
					case LITERAL_trunc:
					case LITERAL_chr:
					case LITERAL_concat:
					case LITERAL_initcap:
					case LITERAL_lower:
					case LITERAL_lpad:
					case LITERAL_ltrim:
					case LITERAL_soundex:
					case LITERAL_substr:
					case LITERAL_translate:
					case LITERAL_upper:
					case LITERAL_chartorowid:
					case LITERAL_convert:
					case LITERAL_hextoraw:
					case LITERAL_rawtohex:
					case LITERAL_to_char:
					case LITERAL_to_date:
					case LITERAL_to_number:
					case LITERAL_decode:
					case LITERAL_dump:
					case LITERAL_greatest:
					case LITERAL_least:
					case LITERAL_nvl:
					case LITERAL_userenv:
					case LITERAL_vsize:
					case LITERAL_user:
					case LITERAL_sysdate:
					case IDENTIFIER:
					case DOUBLE_QUOTED_STRING:
					{
						cursor_name();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case OPEN_PAREN:
					{
						subquery();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					pc = LT(1);
					pc_AST = astFactory.create(pc);
					astFactory.addASTChild(currentAST, pc_AST);
					match(PERCENTAGE);
					{
					switch ( LA(1)) {
					case LITERAL_notfound:
					{
						nf = LT(1);
						nf_AST = astFactory.create(nf);
						astFactory.addASTChild(currentAST, nf_AST);
						match(LITERAL_notfound);
						break;
					}
					case LITERAL_found:
					{
						fo = LT(1);
						fo_AST = astFactory.create(fo);
						astFactory.addASTChild(currentAST, fo_AST);
						match(LITERAL_found);
						break;
					}
					case LITERAL_isopen:
					{
						io = LT(1);
						io_AST = astFactory.create(io);
						astFactory.addASTChild(currentAST, io_AST);
						match(LITERAL_isopen);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					}
					break;
				}
				default:
					boolean synPredMatched263 = false;
					if (((LA(1)==LITERAL_not||LA(1)==LITERAL_like) && (LA(2)==LITERAL_like||LA(2)==QUOTED_STRING) && (_tokenSet_154.member(LA(3))) && (_tokenSet_155.member(LA(4))))) {
						int _m263 = mark();
						synPredMatched263 = true;
						inputState.guessing++;
						try {
							{
							{
							switch ( LA(1)) {
							case LITERAL_not:
							{
								match(LITERAL_not);
								break;
							}
							case LITERAL_like:
							{
								break;
							}
							default:
							{
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
							}
							match(LITERAL_like);
							}
						}
						catch (RecognitionException pe) {
							synPredMatched263 = false;
						}
						rewind(_m263);
						inputState.guessing--;
					}
					if ( synPredMatched263 ) {
						{
						{
						switch ( LA(1)) {
						case LITERAL_not:
						{
							n1 = LT(1);
							n1_AST = astFactory.create(n1);
							astFactory.addASTChild(currentAST, n1_AST);
							match(LITERAL_not);
							break;
						}
						case LITERAL_like:
						{
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						l = LT(1);
						l_AST = astFactory.create(l);
						astFactory.addASTChild(currentAST, l_AST);
						match(LITERAL_like);
						match_string();
						astFactory.addASTChild(currentAST, returnAST);
						}
					}
					else {
						boolean synPredMatched268 = false;
						if (((LA(1)==LITERAL_not||LA(1)==LITERAL_between) && (_tokenSet_156.member(LA(2))) && (_tokenSet_157.member(LA(3))) && (_tokenSet_158.member(LA(4))))) {
							int _m268 = mark();
							synPredMatched268 = true;
							inputState.guessing++;
							try {
								{
								{
								switch ( LA(1)) {
								case LITERAL_not:
								{
									match(LITERAL_not);
									break;
								}
								case LITERAL_between:
								{
									break;
								}
								default:
								{
									throw new NoViableAltException(LT(1), getFilename());
								}
								}
								}
								match(LITERAL_between);
								}
							}
							catch (RecognitionException pe) {
								synPredMatched268 = false;
							}
							rewind(_m268);
							inputState.guessing--;
						}
						if ( synPredMatched268 ) {
							{
							switch ( LA(1)) {
							case LITERAL_not:
							{
								n2 = LT(1);
								n2_AST = astFactory.create(n2);
								astFactory.addASTChild(currentAST, n2_AST);
								match(LITERAL_not);
								break;
							}
							case LITERAL_between:
							{
								break;
							}
							default:
							{
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
							}
							b = LT(1);
							b_AST = astFactory.create(b);
							astFactory.addASTChild(currentAST, b_AST);
							match(LITERAL_between);
							plsql_expression();
							astFactory.addASTChild(currentAST, returnAST);
							a = LT(1);
							a_AST = astFactory.create(a);
							astFactory.addASTChild(currentAST, a_AST);
							match(LITERAL_and);
							plsql_expression();
							astFactory.addASTChild(currentAST, returnAST);
						}
						else if ((LA(1)==LITERAL_not||LA(1)==LITERAL_in) && (LA(2)==OPEN_PAREN||LA(2)==LITERAL_in) && (_tokenSet_20.member(LA(3))) && (_tokenSet_159.member(LA(4)))) {
							{
							{
							switch ( LA(1)) {
							case LITERAL_not:
							{
								n3 = LT(1);
								n3_AST = astFactory.create(n3);
								astFactory.addASTChild(currentAST, n3_AST);
								match(LITERAL_not);
								break;
							}
							case LITERAL_in:
							{
								break;
							}
							default:
							{
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
							}
							in = LT(1);
							in_AST = astFactory.create(in);
							astFactory.addASTChild(currentAST, in_AST);
							match(LITERAL_in);
							op = LT(1);
							op_AST = astFactory.create(op);
							astFactory.addASTChild(currentAST, op_AST);
							match(OPEN_PAREN);
							plsql_exp_list();
							astFactory.addASTChild(currentAST, returnAST);
							c2 = LT(1);
							c2_AST = astFactory.create(c2);
							astFactory.addASTChild(currentAST, c2_AST);
							match(CLOSE_PAREN);
							}
						}
					else {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}}
					}
					}
					boolean_factor_AST = (AST)currentAST.root;
				}
				else if ((_tokenSet_160.member(LA(1))) && (_tokenSet_161.member(LA(2))) && (_tokenSet_162.member(LA(3))) && (_tokenSet_163.member(LA(4)))) {
					{
					switch ( LA(1)) {
					case LITERAL_replace:
					case LITERAL_count:
					case LITERAL_intersect:
					case LITERAL_abs:
					case LITERAL_ascii:
					case LITERAL_ceil:
					case LITERAL_floor:
					case LITERAL_instr:
					case LITERAL_length:
					case LITERAL_power:
					case LITERAL_sign:
					case LITERAL_sqrt:
					case LITERAL_trunc:
					case LITERAL_chr:
					case LITERAL_concat:
					case LITERAL_initcap:
					case LITERAL_lower:
					case LITERAL_lpad:
					case LITERAL_ltrim:
					case LITERAL_soundex:
					case LITERAL_substr:
					case LITERAL_translate:
					case LITERAL_upper:
					case LITERAL_chartorowid:
					case LITERAL_convert:
					case LITERAL_hextoraw:
					case LITERAL_rawtohex:
					case LITERAL_to_char:
					case LITERAL_to_date:
					case LITERAL_to_number:
					case LITERAL_decode:
					case LITERAL_dump:
					case LITERAL_greatest:
					case LITERAL_least:
					case LITERAL_nvl:
					case LITERAL_userenv:
					case LITERAL_vsize:
					case LITERAL_user:
					case LITERAL_sysdate:
					case IDENTIFIER:
					case DOUBLE_QUOTED_STRING:
					{
						cursor_name();
						astFactory.addASTChild(currentAST, returnAST);
						{
						p3 = LT(1);
						p3_AST = astFactory.create(p3);
						astFactory.addASTChild(currentAST, p3_AST);
						match(PERCENTAGE);
						{
						switch ( LA(1)) {
						case LITERAL_notfound:
						{
							n4 = LT(1);
							n4_AST = astFactory.create(n4);
							astFactory.addASTChild(currentAST, n4_AST);
							match(LITERAL_notfound);
							break;
						}
						case LITERAL_found:
						{
							f2 = LT(1);
							f2_AST = astFactory.create(f2);
							astFactory.addASTChild(currentAST, f2_AST);
							match(LITERAL_found);
							break;
						}
						case LITERAL_isopen:
						{
							i2 = LT(1);
							i2_AST = astFactory.create(i2);
							astFactory.addASTChild(currentAST, i2_AST);
							match(LITERAL_isopen);
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						}
						break;
					}
					case SEMI:
					case LITERAL_or:
					case CLOSE_PAREN:
					case LITERAL_loop:
					case LITERAL_then:
					case LITERAL_and:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					boolean_factor_AST = (AST)currentAST.root;
				}
				else if ((LA(1)==LITERAL_null||LA(1)==LITERAL_true||LA(1)==LITERAL_false) && (_tokenSet_147.member(LA(2)))) {
					boolean_literal();
					astFactory.addASTChild(currentAST, returnAST);
					boolean_factor_AST = (AST)currentAST.root;
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_147);
				} else {
				  throw ex;
				}
			}
			returnAST = boolean_factor_AST;
			return r;
		}
		
	public final CommonToken  relational_op() throws RecognitionException, TokenStreamException {
		 CommonToken ro = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST relational_op_AST = null;
		Token  e = null;
		AST e_AST = null;
		Token  l1 = null;
		AST l1_AST = null;
		Token  g1 = null;
		AST g1_AST = null;
		Token  n = null;
		AST n_AST = null;
		Token  l2 = null;
		AST l2_AST = null;
		Token  g2 = null;
		AST g2_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case EQ:
			{
				e = LT(1);
				e_AST = astFactory.create(e);
				astFactory.addASTChild(currentAST, e_AST);
				match(EQ);
				if ( inputState.guessing==0 ) {
					
					ro = (CommonToken) e;
					
				}
				relational_op_AST = (AST)currentAST.root;
				break;
			}
			case LT:
			{
				l1 = LT(1);
				l1_AST = astFactory.create(l1);
				astFactory.addASTChild(currentAST, l1_AST);
				match(LT);
				if ( inputState.guessing==0 ) {
					
					ro = (CommonToken) l1;
					
				}
				relational_op_AST = (AST)currentAST.root;
				break;
			}
			case GT:
			{
				g1 = LT(1);
				g1_AST = astFactory.create(g1);
				astFactory.addASTChild(currentAST, g1_AST);
				match(GT);
				if ( inputState.guessing==0 ) {
					
					ro = (CommonToken) g1;
					
				}
				relational_op_AST = (AST)currentAST.root;
				break;
			}
			case NOT_EQ:
			{
				n = LT(1);
				n_AST = astFactory.create(n);
				astFactory.addASTChild(currentAST, n_AST);
				match(NOT_EQ);
				if ( inputState.guessing==0 ) {
					
					ro = (CommonToken) n;
					
				}
				relational_op_AST = (AST)currentAST.root;
				break;
			}
			case LE:
			{
				l2 = LT(1);
				l2_AST = astFactory.create(l2);
				astFactory.addASTChild(currentAST, l2_AST);
				match(LE);
				if ( inputState.guessing==0 ) {
					
					ro = (CommonToken) l2;
					
				}
				relational_op_AST = (AST)currentAST.root;
				break;
			}
			case GE:
			{
				g2 = LT(1);
				g2_AST = astFactory.create(g2);
				astFactory.addASTChild(currentAST, g2_AST);
				match(GE);
				if ( inputState.guessing==0 ) {
					
					ro = (CommonToken) g2;
					
				}
				if ( inputState.guessing==0 ) {
					SoftwareMetrics.incConditionCount();
				}
				relational_op_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_164);
			} else {
			  throw ex;
			}
		}
		returnAST = relational_op_AST;
		return ro;
	}
	
	public final CommonToken  match_string() throws RecognitionException, TokenStreamException {
		 CommonToken ms = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST match_string_AST = null;
		Token  q = null;
		AST q_AST = null;
		
		try {      // for error handling
			q = LT(1);
			q_AST = astFactory.create(q);
			astFactory.addASTChild(currentAST, q_AST);
			match(QUOTED_STRING);
			if ( inputState.guessing==0 ) {
				
				ms = (CommonToken) q;
				
			}
			match_string_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_147);
			} else {
			  throw ex;
			}
		}
		returnAST = match_string_AST;
		return ms;
	}
	
	public final void plsql_exp_list() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST plsql_exp_list_AST = null;
		Token  c = null;
		AST c_AST = null;
		
		try {      // for error handling
			{
			boolean synPredMatched306 = false;
			if (((_tokenSet_20.member(LA(1))) && (_tokenSet_165.member(LA(2))) && (_tokenSet_166.member(LA(3))) && (_tokenSet_167.member(LA(4))))) {
				int _m306 = mark();
				synPredMatched306 = true;
				inputState.guessing++;
				try {
					{
					plsql_expression();
					match(COMMA);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched306 = false;
				}
				rewind(_m306);
				inputState.guessing--;
			}
			if ( synPredMatched306 ) {
				plsql_expression();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop308:
				do {
					if ((LA(1)==COMMA)) {
						c = LT(1);
						c_AST = astFactory.create(c);
						astFactory.addASTChild(currentAST, c_AST);
						match(COMMA);
						plsql_expression();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop308;
					}
					
				} while (true);
				}
			}
			else if ((_tokenSet_20.member(LA(1))) && (_tokenSet_168.member(LA(2))) && (_tokenSet_166.member(LA(3))) && (_tokenSet_167.member(LA(4)))) {
				plsql_expression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			plsql_exp_list_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_169);
			} else {
			  throw ex;
			}
		}
		returnAST = plsql_exp_list_AST;
	}
	
	public final void subquery() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subquery_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  cp = null;
		AST cp_AST = null;
		
		try {      // for error handling
			o = LT(1);
			o_AST = astFactory.create(o);
			astFactory.addASTChild(currentAST, o_AST);
			match(OPEN_PAREN);
			select_command();
			astFactory.addASTChild(currentAST, returnAST);
			cp = LT(1);
			cp_AST = astFactory.create(cp);
			match(CLOSE_PAREN);
			if ( inputState.guessing==0 ) {
				subquery_AST = (AST)currentAST.root;
				
				subquery_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SUBQUERY,"subquery")).add(subquery_AST));
				
				currentAST.root = subquery_AST;
				currentAST.child = subquery_AST!=null &&subquery_AST.getFirstChild()!=null ?
					subquery_AST.getFirstChild() : subquery_AST;
				currentAST.advanceChildToEnd();
			}
			subquery_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_170);
			} else {
			  throw ex;
			}
		}
		returnAST = subquery_AST;
	}
	
	public final CommonToken  boolean_literal() throws RecognitionException, TokenStreamException {
		 CommonToken bl = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST boolean_literal_AST = null;
		Token  t = null;
		AST t_AST = null;
		Token  f = null;
		AST f_AST = null;
		Token  n = null;
		AST n_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_true:
			{
				t = LT(1);
				t_AST = astFactory.create(t);
				astFactory.addASTChild(currentAST, t_AST);
				match(LITERAL_true);
				if ( inputState.guessing==0 ) {
					
					bl = (CommonToken) t;
					
				}
				boolean_literal_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_false:
			{
				f = LT(1);
				f_AST = astFactory.create(f);
				astFactory.addASTChild(currentAST, f_AST);
				match(LITERAL_false);
				if ( inputState.guessing==0 ) {
					
					bl = (CommonToken) f;
					
				}
				boolean_literal_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_null:
			{
				n = LT(1);
				n_AST = astFactory.create(n);
				astFactory.addASTChild(currentAST, n_AST);
				match(LITERAL_null);
				if ( inputState.guessing==0 ) {
					
					bl = (CommonToken) n;
					
				}
				boolean_literal_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_22);
			} else {
			  throw ex;
			}
		}
		returnAST = boolean_literal_AST;
		return bl;
	}
	
	public final CommonToken  index_name() throws RecognitionException, TokenStreamException {
		 CommonToken id = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST index_name_AST = null;
		
		try {      // for error handling
			id=identifier();
			astFactory.addASTChild(currentAST, returnAST);
			index_name_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_171);
			} else {
			  throw ex;
			}
		}
		returnAST = index_name_AST;
		return id;
	}
	
	public final void integer_expr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST integer_expr_AST = null;
		
		try {      // for error handling
			if ((_tokenSet_20.member(LA(1))) && (_tokenSet_60.member(LA(2))) && (_tokenSet_61.member(LA(3))) && (_tokenSet_172.member(LA(4)))) {
				plsql_expression();
				astFactory.addASTChild(currentAST, returnAST);
				integer_expr_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_35.member(LA(1))) && (_tokenSet_173.member(LA(2))) && (_tokenSet_174.member(LA(3))) && (_tokenSet_175.member(LA(4)))) {
				type_spec();
				astFactory.addASTChild(currentAST, returnAST);
				integer_expr_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_62);
			} else {
			  throw ex;
			}
		}
		returnAST = integer_expr_AST;
	}
	
	public final void select_expression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST select_expression_AST = null;
		Token  u = null;
		AST u_AST = null;
		Token  a = null;
		AST a_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  m = null;
		AST m_AST = null;
		
		try {      // for error handling
			{
			select_first();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop378:
			do {
				if (((LA(1) >= LITERAL_union && LA(1) <= LITERAL_minus))) {
					{
					switch ( LA(1)) {
					case LITERAL_union:
					{
						{
						u = LT(1);
						u_AST = astFactory.create(u);
						astFactory.addASTChild(currentAST, u_AST);
						match(LITERAL_union);
						{
						switch ( LA(1)) {
						case LITERAL_all:
						{
							a = LT(1);
							a_AST = astFactory.create(a);
							astFactory.addASTChild(currentAST, a_AST);
							match(LITERAL_all);
							break;
						}
						case OPEN_PAREN:
						case LITERAL_with:
						case LITERAL_select:
						{
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						}
						break;
					}
					case LITERAL_intersect:
					{
						i = LT(1);
						i_AST = astFactory.create(i);
						astFactory.addASTChild(currentAST, i_AST);
						match(LITERAL_intersect);
						break;
					}
					case LITERAL_minus:
					{
						m = LT(1);
						m_AST = astFactory.create(m);
						astFactory.addASTChild(currentAST, m_AST);
						match(LITERAL_minus);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					select_subsequent();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop378;
				}
				
			} while (true);
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_order:
			{
				order_clause();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			case CLOSE_PAREN:
			case LITERAL_for:
			case LITERAL_using:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_for:
			{
				update_clause();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			case CLOSE_PAREN:
			case LITERAL_using:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				select_expression_AST = (AST)currentAST.root;
				
				select_expression_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SELECT_EXPRESSION,"select_expression")).add(select_expression_AST));
				
				currentAST.root = select_expression_AST;
				currentAST.child = select_expression_AST!=null &&select_expression_AST.getFirstChild()!=null ?
					select_expression_AST.getFirstChild() : select_expression_AST;
				currentAST.advanceChildToEnd();
			}
			select_expression_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_176);
			} else {
			  throw ex;
			}
		}
		returnAST = select_expression_AST;
	}
	
	public final void num_expression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST num_expression_AST = null;
		Token  p = null;
		AST p_AST = null;
		Token  m = null;
		AST m_AST = null;
		
		try {      // for error handling
			{
			num_term();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop294:
			do {
				if ((LA(1)==PLUS||LA(1)==MINUS) && (_tokenSet_20.member(LA(2))) && (_tokenSet_60.member(LA(3))) && (_tokenSet_61.member(LA(4)))) {
					{
					switch ( LA(1)) {
					case PLUS:
					{
						p = LT(1);
						p_AST = astFactory.create(p);
						astFactory.addASTChild(currentAST, p_AST);
						match(PLUS);
						break;
					}
					case MINUS:
					{
						m = LT(1);
						m_AST = astFactory.create(m);
						astFactory.addASTChild(currentAST, m_AST);
						match(MINUS);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					num_term();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop294;
				}
				
			} while (true);
			}
			}
			num_expression_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_62);
			} else {
			  throw ex;
			}
		}
		returnAST = num_expression_AST;
	}
	
	public final void num_term() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST num_term_AST = null;
		Token  a = null;
		AST a_AST = null;
		Token  d = null;
		AST d_AST = null;
		
		try {      // for error handling
			{
			num_factor();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop299:
			do {
				if ((LA(1)==DIVIDE||LA(1)==ASTERISK) && (_tokenSet_20.member(LA(2))) && (_tokenSet_60.member(LA(3))) && (_tokenSet_61.member(LA(4)))) {
					{
					switch ( LA(1)) {
					case ASTERISK:
					{
						a = LT(1);
						a_AST = astFactory.create(a);
						astFactory.addASTChild(currentAST, a_AST);
						match(ASTERISK);
						break;
					}
					case DIVIDE:
					{
						d = LT(1);
						d_AST = astFactory.create(d);
						astFactory.addASTChild(currentAST, d_AST);
						match(DIVIDE);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					num_factor();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop299;
				}
				
			} while (true);
			}
			}
			num_term_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_62);
			} else {
			  throw ex;
			}
		}
		returnAST = num_term_AST;
	}
	
	public final void num_factor() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST num_factor_AST = null;
		Token  p = null;
		AST p_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case PLUS:
			{
				AST tmp66_AST = null;
				tmp66_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp66_AST);
				match(PLUS);
				break;
			}
			case MINUS:
			{
				AST tmp67_AST = null;
				tmp67_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp67_AST);
				match(MINUS);
				break;
			}
			case LITERAL_replace:
			case LITERAL_null:
			case OPEN_PAREN:
			case LITERAL_open:
			case NUMBER:
			case LITERAL_true:
			case LITERAL_false:
			case LITERAL_cast:
			case LITERAL_trim:
			case LITERAL_count:
			case LITERAL_case:
			case LITERAL_all:
			case LITERAL_any:
			case QUOTED_STRING:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_mod:
			case LITERAL_power:
			case LITERAL_round:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_rpad:
			case LITERAL_rtrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_avg:
			case LITERAL_max:
			case LITERAL_min:
			case LITERAL_stddev:
			case LITERAL_sum:
			case LITERAL_variance:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_rowidtochar:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_uid:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			base_expression();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case 143:
			{
				p = LT(1);
				p_AST = astFactory.create(p);
				astFactory.addASTChild(currentAST, p_AST);
				match(143);
				integer_expr();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case DIVIDE:
			case SEMI:
			case LITERAL_or:
			case LITERAL_replace:
			case LITERAL_is:
			case LITERAL_as:
			case LITERAL_end:
			case LITERAL_not:
			case ASSIGNMENT_EQ:
			case LITERAL_default:
			case OPEN_PAREN:
			case COMMA:
			case CLOSE_PAREN:
			case LITERAL_loop:
			case LITERAL_for:
			case LITERAL_when:
			case LITERAL_in:
			case PLUS:
			case MINUS:
			case LITERAL_then:
			case DOUBLEDOT:
			case LITERAL_and:
			case LITERAL_like:
			case LITERAL_between:
			case ASTERISK:
			case CONCAT:
			case LITERAL_count:
			case LITERAL_else:
			case LITERAL_bulk:
			case LITERAL_into:
			case LITERAL_using:
			case EQ:
			case LITERAL_union:
			case LITERAL_intersect:
			case LITERAL_minus:
			case LITERAL_from:
			case LITERAL_right:
			case LITERAL_inner:
			case LITERAL_where:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case 230:
			case LITERAL_escape:
			case LT:
			case GT:
			case NOT_EQ:
			case LE:
			case GE:
			case LITERAL_start:
			case LITERAL_connect:
			case LITERAL_group:
			case LITERAL_having:
			case LITERAL_order:
			case LITERAL_asc:
			case LITERAL_desc:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			num_factor_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_62);
			} else {
			  throw ex;
			}
		}
		returnAST = num_factor_AST;
	}
	
	public final CommonToken  cast_proc() throws RecognitionException, TokenStreamException {
		CommonToken cp= null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST cast_proc_AST = null;
		Token  c = null;
		AST c_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  a = null;
		AST a_AST = null;
		Token  c2 = null;
		AST c2_AST = null;
		
		try {      // for error handling
			c = LT(1);
			c_AST = astFactory.create(c);
			astFactory.addASTChild(currentAST, c_AST);
			match(LITERAL_cast);
			o = LT(1);
			o_AST = astFactory.create(o);
			match(OPEN_PAREN);
			plsql_expression();
			astFactory.addASTChild(currentAST, returnAST);
			a = LT(1);
			a_AST = astFactory.create(a);
			match(LITERAL_as);
			type_name();
			astFactory.addASTChild(currentAST, returnAST);
			c2 = LT(1);
			c2_AST = astFactory.create(c2);
			match(CLOSE_PAREN);
			if ( inputState.guessing==0 ) {
				
				cp = (CommonToken) c;
				
			}
			cast_proc_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_22);
			} else {
			  throw ex;
			}
		}
		returnAST = cast_proc_AST;
		return cp;
	}
	
	public final CommonToken  trim_function() throws RecognitionException, TokenStreamException {
		 CommonToken tf = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST trim_function_AST = null;
		Token  t = null;
		AST t_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  l = null;
		AST l_AST = null;
		Token  tr = null;
		AST tr_AST = null;
		Token  b = null;
		AST b_AST = null;
		Token  f = null;
		AST f_AST = null;
		Token  cp = null;
		AST cp_AST = null;
		
		try {      // for error handling
			t = LT(1);
			t_AST = astFactory.create(t);
			astFactory.addASTChild(currentAST, t_AST);
			match(LITERAL_trim);
			o = LT(1);
			o_AST = astFactory.create(o);
			match(OPEN_PAREN);
			{
			switch ( LA(1)) {
			case LITERAL_leading:
			{
				l = LT(1);
				l_AST = astFactory.create(l);
				astFactory.addASTChild(currentAST, l_AST);
				match(LITERAL_leading);
				break;
			}
			case LITERAL_trailing:
			{
				tr = LT(1);
				tr_AST = astFactory.create(tr);
				astFactory.addASTChild(currentAST, tr_AST);
				match(LITERAL_trailing);
				break;
			}
			case LITERAL_both:
			{
				b = LT(1);
				b_AST = astFactory.create(b);
				astFactory.addASTChild(currentAST, b_AST);
				match(LITERAL_both);
				break;
			}
			case LITERAL_replace:
			case LITERAL_null:
			case OPEN_PAREN:
			case LITERAL_open:
			case NUMBER:
			case PLUS:
			case MINUS:
			case LITERAL_true:
			case LITERAL_false:
			case LITERAL_cast:
			case LITERAL_trim:
			case LITERAL_count:
			case LITERAL_case:
			case LITERAL_all:
			case LITERAL_any:
			case QUOTED_STRING:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_mod:
			case LITERAL_power:
			case LITERAL_round:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_rpad:
			case LITERAL_rtrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_avg:
			case LITERAL_max:
			case LITERAL_min:
			case LITERAL_stddev:
			case LITERAL_sum:
			case LITERAL_variance:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_rowidtochar:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_uid:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			plsql_expression();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_from:
			{
				f = LT(1);
				f_AST = astFactory.create(f);
				astFactory.addASTChild(currentAST, f_AST);
				match(LITERAL_from);
				plsql_expression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case CLOSE_PAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			cp = LT(1);
			cp_AST = astFactory.create(cp);
			match(CLOSE_PAREN);
			if ( inputState.guessing==0 ) {
				
				tf = (CommonToken) t;
				
			}
			trim_function_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_22);
			} else {
			  throw ex;
			}
		}
		returnAST = trim_function_AST;
		return tf;
	}
	
	public final void count_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST count_function_AST = null;
		Token  c = null;
		AST c_AST = null;
		Token  op = null;
		AST op_AST = null;
		Token  a = null;
		AST a_AST = null;
		Token  d = null;
		AST d_AST = null;
		Token  cp = null;
		AST cp_AST = null;
		
		try {      // for error handling
			c = LT(1);
			c_AST = astFactory.create(c);
			astFactory.addASTChild(currentAST, c_AST);
			match(LITERAL_count);
			op = LT(1);
			op_AST = astFactory.create(op);
			match(OPEN_PAREN);
			{
			switch ( LA(1)) {
			case ASTERISK:
			{
				a = LT(1);
				a_AST = astFactory.create(a);
				astFactory.addASTChild(currentAST, a_AST);
				match(ASTERISK);
				break;
			}
			case LITERAL_replace:
			case LITERAL_null:
			case OPEN_PAREN:
			case LITERAL_open:
			case NUMBER:
			case PLUS:
			case MINUS:
			case LITERAL_true:
			case LITERAL_false:
			case LITERAL_cast:
			case LITERAL_trim:
			case LITERAL_count:
			case LITERAL_case:
			case LITERAL_all:
			case LITERAL_any:
			case LITERAL_distinct:
			case QUOTED_STRING:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_mod:
			case LITERAL_power:
			case LITERAL_round:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_rpad:
			case LITERAL_rtrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_avg:
			case LITERAL_max:
			case LITERAL_min:
			case LITERAL_stddev:
			case LITERAL_sum:
			case LITERAL_variance:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_rowidtochar:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_uid:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				{
				{
				switch ( LA(1)) {
				case LITERAL_distinct:
				{
					d = LT(1);
					d_AST = astFactory.create(d);
					astFactory.addASTChild(currentAST, d_AST);
					match(LITERAL_distinct);
					break;
				}
				case LITERAL_replace:
				case LITERAL_null:
				case OPEN_PAREN:
				case LITERAL_open:
				case NUMBER:
				case PLUS:
				case MINUS:
				case LITERAL_true:
				case LITERAL_false:
				case LITERAL_cast:
				case LITERAL_trim:
				case LITERAL_count:
				case LITERAL_case:
				case LITERAL_all:
				case LITERAL_any:
				case QUOTED_STRING:
				case LITERAL_intersect:
				case LITERAL_abs:
				case LITERAL_ascii:
				case LITERAL_ceil:
				case LITERAL_floor:
				case LITERAL_instr:
				case LITERAL_length:
				case LITERAL_mod:
				case LITERAL_power:
				case LITERAL_round:
				case LITERAL_sign:
				case LITERAL_sqrt:
				case LITERAL_trunc:
				case LITERAL_chr:
				case LITERAL_concat:
				case LITERAL_initcap:
				case LITERAL_lower:
				case LITERAL_lpad:
				case LITERAL_ltrim:
				case LITERAL_rpad:
				case LITERAL_rtrim:
				case LITERAL_soundex:
				case LITERAL_substr:
				case LITERAL_translate:
				case LITERAL_upper:
				case LITERAL_avg:
				case LITERAL_max:
				case LITERAL_min:
				case LITERAL_stddev:
				case LITERAL_sum:
				case LITERAL_variance:
				case LITERAL_chartorowid:
				case LITERAL_convert:
				case LITERAL_hextoraw:
				case LITERAL_rawtohex:
				case LITERAL_rowidtochar:
				case LITERAL_to_char:
				case LITERAL_to_date:
				case LITERAL_to_number:
				case LITERAL_decode:
				case LITERAL_dump:
				case LITERAL_greatest:
				case LITERAL_least:
				case LITERAL_nvl:
				case LITERAL_uid:
				case LITERAL_userenv:
				case LITERAL_vsize:
				case LITERAL_user:
				case LITERAL_sysdate:
				case IDENTIFIER:
				case DOUBLE_QUOTED_STRING:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				plsql_expression();
				astFactory.addASTChild(currentAST, returnAST);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			cp = LT(1);
			cp_AST = astFactory.create(cp);
			match(CLOSE_PAREN);
			count_function_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_22);
			} else {
			  throw ex;
			}
		}
		returnAST = count_function_AST;
	}
	
	public final void case_expression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST case_expression_AST = null;
		Token  c = null;
		AST c_AST = null;
		Token  w = null;
		AST w_AST = null;
		Token  t = null;
		AST t_AST = null;
		Token  e = null;
		AST e_AST = null;
		Token  en = null;
		AST en_AST = null;
		
		try {      // for error handling
			c = LT(1);
			c_AST = astFactory.create(c);
			astFactory.addASTChild(currentAST, c_AST);
			match(LITERAL_case);
			{
			int _cnt347=0;
			_loop347:
			do {
				if ((LA(1)==LITERAL_when)) {
					w = LT(1);
					w_AST = astFactory.create(w);
					astFactory.addASTChild(currentAST, w_AST);
					match(LITERAL_when);
					condition();
					astFactory.addASTChild(currentAST, returnAST);
					t = LT(1);
					t_AST = astFactory.create(t);
					astFactory.addASTChild(currentAST, t_AST);
					match(LITERAL_then);
					plsql_expression();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt347>=1 ) { break _loop347; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt347++;
			} while (true);
			}
			{
			switch ( LA(1)) {
			case LITERAL_else:
			{
				e = LT(1);
				e_AST = astFactory.create(e);
				astFactory.addASTChild(currentAST, e_AST);
				match(LITERAL_else);
				plsql_expression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_end:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			en = LT(1);
			en_AST = astFactory.create(en);
			astFactory.addASTChild(currentAST, en_AST);
			match(LITERAL_end);
			if ( inputState.guessing==0 ) {
				SoftwareMetrics.incBranchCount();
			}
			case_expression_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_22);
			} else {
			  throw ex;
			}
		}
		returnAST = case_expression_AST;
	}
	
	public final CommonToken  date_literal() throws RecognitionException, TokenStreamException {
		 CommonToken dl = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST date_literal_AST = null;
		Token  q = null;
		AST q_AST = null;
		
		try {      // for error handling
			q = LT(1);
			q_AST = astFactory.create(q);
			astFactory.addASTChild(currentAST, q_AST);
			match(QUOTED_STRING);
			if ( inputState.guessing==0 ) {
				
				dl = (CommonToken) q;
				
			}
			date_literal_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_22);
			} else {
			  throw ex;
			}
		}
		returnAST = date_literal_AST;
		return dl;
	}
	
	public final CommonToken  pseudo_column() throws RecognitionException, TokenStreamException {
		 CommonToken pc = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST pseudo_column_AST = null;
		Token  u = null;
		AST u_AST = null;
		Token  s = null;
		AST s_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_user:
			{
				u = LT(1);
				u_AST = astFactory.create(u);
				astFactory.addASTChild(currentAST, u_AST);
				match(LITERAL_user);
				if ( inputState.guessing==0 ) {
					
					pc = (CommonToken) u;
					
				}
				pseudo_column_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_sysdate:
			{
				s = LT(1);
				s_AST = astFactory.create(s);
				astFactory.addASTChild(currentAST, s_AST);
				match(LITERAL_sysdate);
				if ( inputState.guessing==0 ) {
					
					pc = (CommonToken) s;
					
				}
				pseudo_column_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_22);
			} else {
			  throw ex;
			}
		}
		returnAST = pseudo_column_AST;
		return pc;
	}
	
	public final void commit_statement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST commit_statement_AST = null;
		Token  c = null;
		AST c_AST = null;
		
		try {      // for error handling
			c = LT(1);
			c_AST = astFactory.create(c);
			astFactory.addASTChild(currentAST, c_AST);
			match(LITERAL_commit);
			{
			switch ( LA(1)) {
			case LITERAL_work:
			{
				AST tmp68_AST = null;
				tmp68_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp68_AST);
				match(LITERAL_work);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			commit_statement_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = commit_statement_AST;
	}
	
	public final void condition() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST condition_AST = null;
		Token  o = null;
		AST o_AST = null;
		
		try {      // for error handling
			logical_term();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop471:
			do {
				if ((LA(1)==LITERAL_or)) {
					o = LT(1);
					o_AST = astFactory.create(o);
					astFactory.makeASTRoot(currentAST, o_AST);
					match(LITERAL_or);
					logical_term();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop471;
				}
				
			} while (true);
			}
			if ( inputState.guessing==0 ) {
				
					SoftwareMetrics.incConditionCount(); 
					SoftwareMetrics.incDecisionCount();
					SoftwareMetrics.incBranchCount();
				
			}
			condition_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_177);
			} else {
			  throw ex;
			}
		}
		returnAST = condition_AST;
	}
	
	public final void sql_command() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST sql_command_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_set:
			case OPEN_PAREN:
			case LITERAL_with:
			case LITERAL_select:
			case LITERAL_update:
			case LITERAL_insert:
			case LITERAL_delete:
			case LITERAL_alter:
			case LITERAL_execute:
			{
				to_modify_data();
				astFactory.addASTChild(currentAST, returnAST);
				sql_command_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_lock:
			case LITERAL_commit:
			case LITERAL_rollback:
			case LITERAL_open:
			case LITERAL_fetch:
			case LITERAL_close:
			case LITERAL_savepoint:
			{
				to_control_data();
				astFactory.addASTChild(currentAST, returnAST);
				sql_command_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = sql_command_AST;
	}
	
	public final void to_modify_data() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST to_modify_data_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case OPEN_PAREN:
			case LITERAL_with:
			case LITERAL_select:
			{
				select_command();
				astFactory.addASTChild(currentAST, returnAST);
				to_modify_data_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_insert:
			{
				insert_command();
				astFactory.addASTChild(currentAST, returnAST);
				to_modify_data_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_update:
			{
				update_command();
				astFactory.addASTChild(currentAST, returnAST);
				to_modify_data_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_delete:
			{
				delete_command();
				astFactory.addASTChild(currentAST, returnAST);
				to_modify_data_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_execute:
			{
				immediate_command();
				astFactory.addASTChild(currentAST, returnAST);
				to_modify_data_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_set:
			{
				set_transaction_command();
				astFactory.addASTChild(currentAST, returnAST);
				to_modify_data_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_alter:
			{
				alter_command();
				astFactory.addASTChild(currentAST, returnAST);
				to_modify_data_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = to_modify_data_AST;
	}
	
	public final void to_control_data() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST to_control_data_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_close:
			{
				close_statement();
				astFactory.addASTChild(currentAST, returnAST);
				to_control_data_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_commit:
			{
				commit_statement();
				astFactory.addASTChild(currentAST, returnAST);
				to_control_data_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_fetch:
			{
				fetch_statement();
				astFactory.addASTChild(currentAST, returnAST);
				to_control_data_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_lock:
			{
				lock_table_statement();
				astFactory.addASTChild(currentAST, returnAST);
				to_control_data_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_open:
			{
				open_statement();
				astFactory.addASTChild(currentAST, returnAST);
				to_control_data_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_rollback:
			{
				rollback_statement();
				astFactory.addASTChild(currentAST, returnAST);
				to_control_data_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_savepoint:
			{
				savepoint_statement();
				astFactory.addASTChild(currentAST, returnAST);
				to_control_data_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = to_control_data_AST;
	}
	
	public final void insert_command() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST insert_command_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  c1 = null;
		AST c1_AST = null;
		Token  v = null;
		AST v_AST = null;
		Token  cp = null;
		AST cp_AST = null;
		
		try {      // for error handling
			i = LT(1);
			i_AST = astFactory.create(i);
			astFactory.addASTChild(currentAST, i_AST);
			match(LITERAL_insert);
			AST tmp69_AST = null;
			tmp69_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp69_AST);
			match(LITERAL_into);
			table_spec();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_replace:
			case LITERAL_as:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				alias();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case OPEN_PAREN:
			case LITERAL_with:
			case LITERAL_select:
			case LITERAL_values:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			if ((LA(1)==OPEN_PAREN) && (_tokenSet_1.member(LA(2))) && (LA(3)==DOT||LA(3)==COMMA||LA(3)==CLOSE_PAREN) && (_tokenSet_178.member(LA(4)))) {
				match(OPEN_PAREN);
				column_spec();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop529:
				do {
					if ((LA(1)==COMMA)) {
						c1 = LT(1);
						c1_AST = astFactory.create(c1);
						astFactory.addASTChild(currentAST, c1_AST);
						match(COMMA);
						column_spec();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop529;
					}
					
				} while (true);
				}
				match(CLOSE_PAREN);
			}
			else if ((_tokenSet_179.member(LA(1))) && (_tokenSet_18.member(LA(2))) && (_tokenSet_19.member(LA(3))) && (_tokenSet_73.member(LA(4)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			{
			switch ( LA(1)) {
			case LITERAL_values:
			{
				{
				v = LT(1);
				v_AST = astFactory.create(v);
				astFactory.addASTChild(currentAST, v_AST);
				match(LITERAL_values);
				match(OPEN_PAREN);
				plsql_exp_list();
				astFactory.addASTChild(currentAST, returnAST);
				cp = LT(1);
				cp_AST = astFactory.create(cp);
				match(CLOSE_PAREN);
				}
				break;
			}
			case OPEN_PAREN:
			case LITERAL_with:
			case LITERAL_select:
			{
				select_expression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			insert_command_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = insert_command_AST;
	}
	
	public final void update_command() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST update_command_AST = null;
		
		try {      // for error handling
			boolean synPredMatched534 = false;
			if (((LA(1)==LITERAL_update) && (_tokenSet_1.member(LA(2))) && (_tokenSet_180.member(LA(3))) && (_tokenSet_181.member(LA(4))))) {
				int _m534 = mark();
				synPredMatched534 = true;
				inputState.guessing++;
				try {
					{
					subquery_update();
					}
				}
				catch (RecognitionException pe) {
					synPredMatched534 = false;
				}
				rewind(_m534);
				inputState.guessing--;
			}
			if ( synPredMatched534 ) {
				subquery_update();
				astFactory.addASTChild(currentAST, returnAST);
				update_command_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==LITERAL_update) && (_tokenSet_1.member(LA(2))) && (_tokenSet_180.member(LA(3))) && (_tokenSet_182.member(LA(4)))) {
				simple_update();
				astFactory.addASTChild(currentAST, returnAST);
				update_command_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = update_command_AST;
	}
	
	public final void delete_command() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST delete_command_AST = null;
		Token  d = null;
		AST d_AST = null;
		Token  w = null;
		AST w_AST = null;
		
		try {      // for error handling
			d = LT(1);
			d_AST = astFactory.create(d);
			astFactory.addASTChild(currentAST, d_AST);
			match(LITERAL_delete);
			{
			switch ( LA(1)) {
			case LITERAL_from:
			{
				AST tmp73_AST = null;
				tmp73_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp73_AST);
				match(LITERAL_from);
				break;
			}
			case LITERAL_replace:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			table_alias();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_where:
			{
				w = LT(1);
				w_AST = astFactory.create(w);
				astFactory.addASTChild(currentAST, w_AST);
				match(LITERAL_where);
				condition();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			delete_command_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = delete_command_AST;
	}
	
	public final void immediate_command() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST immediate_command_AST = null;
		Token  e = null;
		AST e_AST = null;
		Token  i1 = null;
		AST i1_AST = null;
		Token  i2 = null;
		AST i2_AST = null;
		
		try {      // for error handling
			e = LT(1);
			e_AST = astFactory.create(e);
			astFactory.addASTChild(currentAST, e_AST);
			match(LITERAL_execute);
			i1 = LT(1);
			i1_AST = astFactory.create(i1);
			astFactory.addASTChild(currentAST, i1_AST);
			match(LITERAL_immediate);
			plsql_expression();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_bulk:
			case LITERAL_into:
			{
				{
				switch ( LA(1)) {
				case LITERAL_bulk:
				{
					AST tmp74_AST = null;
					tmp74_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp74_AST);
					match(LITERAL_bulk);
					AST tmp75_AST = null;
					tmp75_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp75_AST);
					match(LITERAL_collect);
					break;
				}
				case LITERAL_into:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				i2 = LT(1);
				i2_AST = astFactory.create(i2);
				astFactory.addASTChild(currentAST, i2_AST);
				match(LITERAL_into);
				plsql_exp_list();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			case LITERAL_using:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_using:
			{
				AST tmp76_AST = null;
				tmp76_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp76_AST);
				match(LITERAL_using);
				plsql_exp_list();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			immediate_command_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = immediate_command_AST;
	}
	
	public final void set_transaction_command() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST set_transaction_command_AST = null;
		Token  s = null;
		AST s_AST = null;
		Token  t = null;
		AST t_AST = null;
		Token  r = null;
		AST r_AST = null;
		Token  o = null;
		AST o_AST = null;
		
		try {      // for error handling
			s = LT(1);
			s_AST = astFactory.create(s);
			astFactory.addASTChild(currentAST, s_AST);
			match(LITERAL_set);
			t = LT(1);
			t_AST = astFactory.create(t);
			astFactory.addASTChild(currentAST, t_AST);
			match(LITERAL_transaction);
			r = LT(1);
			r_AST = astFactory.create(r);
			astFactory.addASTChild(currentAST, r_AST);
			match(LITERAL_read);
			o = LT(1);
			o_AST = astFactory.create(o);
			astFactory.addASTChild(currentAST, o_AST);
			match(LITERAL_only);
			set_transaction_command_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = set_transaction_command_AST;
	}
	
	public final void alter_command() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST alter_command_AST = null;
		
		try {      // for error handling
			AST tmp77_AST = null;
			tmp77_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp77_AST);
			match(LITERAL_alter);
			{
			switch ( LA(1)) {
			case LITERAL_system:
			{
				AST tmp78_AST = null;
				tmp78_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp78_AST);
				match(LITERAL_system);
				break;
			}
			case LITERAL_session:
			{
				AST tmp79_AST = null;
				tmp79_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp79_AST);
				match(LITERAL_session);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_flush:
			{
				{
				AST tmp80_AST = null;
				tmp80_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp80_AST);
				match(LITERAL_flush);
				AST tmp81_AST = null;
				tmp81_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp81_AST);
				match(LITERAL_shared_pool);
				}
				break;
			}
			case LITERAL_set:
			case LITERAL_reset:
			{
				{
				switch ( LA(1)) {
				case LITERAL_set:
				{
					{
					AST tmp82_AST = null;
					tmp82_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp82_AST);
					match(LITERAL_set);
					identifier();
					astFactory.addASTChild(currentAST, returnAST);
					AST tmp83_AST = null;
					tmp83_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp83_AST);
					match(EQ);
					{
					switch ( LA(1)) {
					case QUOTED_STRING:
					{
						char_literal();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case NUMBER:
					{
						numeric_literal();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case LITERAL_replace:
					case LITERAL_count:
					case LITERAL_intersect:
					case LITERAL_abs:
					case LITERAL_ascii:
					case LITERAL_ceil:
					case LITERAL_floor:
					case LITERAL_instr:
					case LITERAL_length:
					case LITERAL_power:
					case LITERAL_sign:
					case LITERAL_sqrt:
					case LITERAL_trunc:
					case LITERAL_chr:
					case LITERAL_concat:
					case LITERAL_initcap:
					case LITERAL_lower:
					case LITERAL_lpad:
					case LITERAL_ltrim:
					case LITERAL_soundex:
					case LITERAL_substr:
					case LITERAL_translate:
					case LITERAL_upper:
					case LITERAL_chartorowid:
					case LITERAL_convert:
					case LITERAL_hextoraw:
					case LITERAL_rawtohex:
					case LITERAL_to_char:
					case LITERAL_to_date:
					case LITERAL_to_number:
					case LITERAL_decode:
					case LITERAL_dump:
					case LITERAL_greatest:
					case LITERAL_least:
					case LITERAL_nvl:
					case LITERAL_userenv:
					case LITERAL_vsize:
					case LITERAL_user:
					case LITERAL_sysdate:
					case IDENTIFIER:
					case DOUBLE_QUOTED_STRING:
					{
						identifier();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					}
					break;
				}
				case LITERAL_reset:
				{
					{
					AST tmp84_AST = null;
					tmp84_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp84_AST);
					match(LITERAL_reset);
					identifier();
					astFactory.addASTChild(currentAST, returnAST);
					}
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case LITERAL_sid:
				{
					AST tmp85_AST = null;
					tmp85_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp85_AST);
					match(LITERAL_sid);
					AST tmp86_AST = null;
					tmp86_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp86_AST);
					match(EQ);
					{
					switch ( LA(1)) {
					case QUOTED_STRING:
					{
						char_literal();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case ASTERISK:
					{
						AST tmp87_AST = null;
						tmp87_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp87_AST);
						match(ASTERISK);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					break;
				}
				case SEMI:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			alter_command_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = alter_command_AST;
	}
	
	public final void close_statement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST close_statement_AST = null;
		Token  c = null;
		AST c_AST = null;
		
		try {      // for error handling
			c = LT(1);
			c_AST = astFactory.create(c);
			astFactory.addASTChild(currentAST, c_AST);
			match(LITERAL_close);
			cursor_name();
			astFactory.addASTChild(currentAST, returnAST);
			close_statement_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = close_statement_AST;
	}
	
	public final void fetch_statement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST fetch_statement_AST = null;
		Token  f = null;
		AST f_AST = null;
		Token  b = null;
		AST b_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  c = null;
		AST c_AST = null;
		
		try {      // for error handling
			f = LT(1);
			f_AST = astFactory.create(f);
			astFactory.addASTChild(currentAST, f_AST);
			match(LITERAL_fetch);
			cursor_name();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_bulk:
			{
				b = LT(1);
				b_AST = astFactory.create(b);
				astFactory.addASTChild(currentAST, b_AST);
				match(LITERAL_bulk);
				AST tmp88_AST = null;
				tmp88_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp88_AST);
				match(LITERAL_collect);
				break;
			}
			case LITERAL_into:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			i = LT(1);
			i_AST = astFactory.create(i);
			astFactory.addASTChild(currentAST, i_AST);
			match(LITERAL_into);
			{
			if ((_tokenSet_1.member(LA(1))) && (LA(2)==SEMI||LA(2)==COMMA) && (_tokenSet_183.member(LA(3))) && (_tokenSet_184.member(LA(4)))) {
				{
				variable_name();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop553:
				do {
					if ((LA(1)==COMMA)) {
						c = LT(1);
						c_AST = astFactory.create(c);
						astFactory.addASTChild(currentAST, c_AST);
						match(COMMA);
						variable_name();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop553;
					}
					
				} while (true);
				}
				}
			}
			else if ((_tokenSet_1.member(LA(1))) && (LA(2)==SEMI) && (_tokenSet_183.member(LA(3))) && (_tokenSet_185.member(LA(4)))) {
				record_name();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			fetch_statement_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = fetch_statement_AST;
	}
	
	public final void lock_table_statement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST lock_table_statement_AST = null;
		Token  l = null;
		AST l_AST = null;
		Token  t = null;
		AST t_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  m = null;
		AST m_AST = null;
		Token  n = null;
		AST n_AST = null;
		
		try {      // for error handling
			l = LT(1);
			l_AST = astFactory.create(l);
			astFactory.addASTChild(currentAST, l_AST);
			match(LITERAL_lock);
			t = LT(1);
			t_AST = astFactory.create(t);
			astFactory.addASTChild(currentAST, t_AST);
			match(LITERAL_table);
			table_reference_list();
			astFactory.addASTChild(currentAST, returnAST);
			i = LT(1);
			i_AST = astFactory.create(i);
			astFactory.addASTChild(currentAST, i_AST);
			match(LITERAL_in);
			lock_mode();
			astFactory.addASTChild(currentAST, returnAST);
			m = LT(1);
			m_AST = astFactory.create(m);
			astFactory.addASTChild(currentAST, m_AST);
			match(LITERAL_mode);
			{
			switch ( LA(1)) {
			case LITERAL_nowait:
			{
				n = LT(1);
				n_AST = astFactory.create(n);
				astFactory.addASTChild(currentAST, n_AST);
				match(LITERAL_nowait);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			lock_table_statement_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = lock_table_statement_AST;
	}
	
	public final void open_statement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST open_statement_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  b = null;
		AST b_AST = null;
		Token  cp = null;
		AST cp_AST = null;
		Token  f = null;
		AST f_AST = null;
		
		try {      // for error handling
			o = LT(1);
			o_AST = astFactory.create(o);
			astFactory.addASTChild(currentAST, o_AST);
			match(LITERAL_open);
			cursor_name();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case OPEN_PAREN:
			{
				b = LT(1);
				b_AST = astFactory.create(b);
				astFactory.addASTChild(currentAST, b_AST);
				match(OPEN_PAREN);
				plsql_exp_list();
				cp = LT(1);
				cp_AST = astFactory.create(cp);
				match(CLOSE_PAREN);
				break;
			}
			case SEMI:
			case LITERAL_for:
			case LITERAL_using:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_for:
			{
				f = LT(1);
				f_AST = astFactory.create(f);
				astFactory.addASTChild(currentAST, f_AST);
				match(LITERAL_for);
				{
				if ((LA(1)==OPEN_PAREN||LA(1)==LITERAL_with||LA(1)==LITERAL_select) && (_tokenSet_18.member(LA(2))) && (_tokenSet_19.member(LA(3))) && (_tokenSet_73.member(LA(4)))) {
					select_expression();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((_tokenSet_20.member(LA(1))) && (_tokenSet_186.member(LA(2))) && (_tokenSet_187.member(LA(3))) && (_tokenSet_188.member(LA(4)))) {
					plsql_expression();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				break;
			}
			case SEMI:
			case LITERAL_using:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_using:
			{
				AST tmp89_AST = null;
				tmp89_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp89_AST);
				match(LITERAL_using);
				plsql_exp_list();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			open_statement_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = open_statement_AST;
	}
	
	public final void rollback_statement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rollback_statement_AST = null;
		Token  r = null;
		AST r_AST = null;
		Token  w = null;
		AST w_AST = null;
		Token  t = null;
		AST t_AST = null;
		Token  s = null;
		AST s_AST = null;
		Token  c = null;
		AST c_AST = null;
		
		try {      // for error handling
			r = LT(1);
			r_AST = astFactory.create(r);
			astFactory.addASTChild(currentAST, r_AST);
			match(LITERAL_rollback);
			{
			switch ( LA(1)) {
			case LITERAL_work:
			{
				w = LT(1);
				w_AST = astFactory.create(w);
				astFactory.addASTChild(currentAST, w_AST);
				match(LITERAL_work);
				break;
			}
			case SEMI:
			case LITERAL_to:
			case LITERAL_comment:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_to:
			{
				t = LT(1);
				t_AST = astFactory.create(t);
				astFactory.addASTChild(currentAST, t_AST);
				match(LITERAL_to);
				{
				switch ( LA(1)) {
				case LITERAL_savepoint:
				{
					s = LT(1);
					s_AST = astFactory.create(s);
					astFactory.addASTChild(currentAST, s_AST);
					match(LITERAL_savepoint);
					break;
				}
				case LITERAL_replace:
				case LITERAL_count:
				case LITERAL_intersect:
				case LITERAL_abs:
				case LITERAL_ascii:
				case LITERAL_ceil:
				case LITERAL_floor:
				case LITERAL_instr:
				case LITERAL_length:
				case LITERAL_power:
				case LITERAL_sign:
				case LITERAL_sqrt:
				case LITERAL_trunc:
				case LITERAL_chr:
				case LITERAL_concat:
				case LITERAL_initcap:
				case LITERAL_lower:
				case LITERAL_lpad:
				case LITERAL_ltrim:
				case LITERAL_soundex:
				case LITERAL_substr:
				case LITERAL_translate:
				case LITERAL_upper:
				case LITERAL_chartorowid:
				case LITERAL_convert:
				case LITERAL_hextoraw:
				case LITERAL_rawtohex:
				case LITERAL_to_char:
				case LITERAL_to_date:
				case LITERAL_to_number:
				case LITERAL_decode:
				case LITERAL_dump:
				case LITERAL_greatest:
				case LITERAL_least:
				case LITERAL_nvl:
				case LITERAL_userenv:
				case LITERAL_vsize:
				case LITERAL_user:
				case LITERAL_sysdate:
				case IDENTIFIER:
				case DOUBLE_QUOTED_STRING:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				savepoint_name();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			case LITERAL_comment:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_comment:
			{
				c = LT(1);
				c_AST = astFactory.create(c);
				astFactory.addASTChild(currentAST, c_AST);
				match(LITERAL_comment);
				char_literal();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			rollback_statement_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = rollback_statement_AST;
	}
	
	public final void savepoint_statement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST savepoint_statement_AST = null;
		Token  s = null;
		AST s_AST = null;
		
		try {      // for error handling
			s = LT(1);
			s_AST = astFactory.create(s);
			astFactory.addASTChild(currentAST, s_AST);
			match(LITERAL_savepoint);
			savepoint_name();
			astFactory.addASTChild(currentAST, returnAST);
			savepoint_statement_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = savepoint_statement_AST;
	}
	
	public final void select_first() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST select_first_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  c = null;
		AST c_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_with:
			case LITERAL_select:
			{
				select_up_to_list();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case LITERAL_bulk:
				case LITERAL_into:
				{
					{
					switch ( LA(1)) {
					case LITERAL_bulk:
					{
						AST tmp90_AST = null;
						tmp90_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp90_AST);
						match(LITERAL_bulk);
						AST tmp91_AST = null;
						tmp91_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp91_AST);
						match(LITERAL_collect);
						break;
					}
					case LITERAL_into:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					i = LT(1);
					i_AST = astFactory.create(i);
					astFactory.addASTChild(currentAST, i_AST);
					match(LITERAL_into);
					plsql_exp_list();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_from:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				table_reference_list_from();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case LITERAL_where:
				{
					where_condition_whole();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SEMI:
				case CLOSE_PAREN:
				case LITERAL_for:
				case LITERAL_using:
				case LITERAL_union:
				case LITERAL_intersect:
				case LITERAL_minus:
				case LITERAL_start:
				case LITERAL_connect:
				case LITERAL_group:
				case LITERAL_having:
				case LITERAL_order:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case LITERAL_start:
				case LITERAL_connect:
				{
					connect_clause();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SEMI:
				case CLOSE_PAREN:
				case LITERAL_for:
				case LITERAL_using:
				case LITERAL_union:
				case LITERAL_intersect:
				case LITERAL_minus:
				case LITERAL_group:
				case LITERAL_having:
				case LITERAL_order:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case LITERAL_group:
				case LITERAL_having:
				{
					group_clause();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SEMI:
				case CLOSE_PAREN:
				case LITERAL_for:
				case LITERAL_using:
				case LITERAL_union:
				case LITERAL_intersect:
				case LITERAL_minus:
				case LITERAL_order:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				select_first_AST = (AST)currentAST.root;
				break;
			}
			case OPEN_PAREN:
			{
				o = LT(1);
				o_AST = astFactory.create(o);
				astFactory.addASTChild(currentAST, o_AST);
				match(OPEN_PAREN);
				select_first();
				astFactory.addASTChild(currentAST, returnAST);
				c = LT(1);
				c_AST = astFactory.create(c);
				astFactory.addASTChild(currentAST, c_AST);
				match(CLOSE_PAREN);
				select_first_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_189);
			} else {
			  throw ex;
			}
		}
		returnAST = select_first_AST;
	}
	
	public final void select_subsequent() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST select_subsequent_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  c = null;
		AST c_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_with:
			case LITERAL_select:
			{
				select_up_to_list();
				astFactory.addASTChild(currentAST, returnAST);
				table_reference_list_from();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case LITERAL_where:
				{
					where_condition_whole();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SEMI:
				case CLOSE_PAREN:
				case LITERAL_for:
				case LITERAL_using:
				case LITERAL_union:
				case LITERAL_intersect:
				case LITERAL_minus:
				case LITERAL_start:
				case LITERAL_connect:
				case LITERAL_group:
				case LITERAL_having:
				case LITERAL_order:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case LITERAL_start:
				case LITERAL_connect:
				{
					connect_clause();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SEMI:
				case CLOSE_PAREN:
				case LITERAL_for:
				case LITERAL_using:
				case LITERAL_union:
				case LITERAL_intersect:
				case LITERAL_minus:
				case LITERAL_group:
				case LITERAL_having:
				case LITERAL_order:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case LITERAL_group:
				case LITERAL_having:
				{
					group_clause();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SEMI:
				case CLOSE_PAREN:
				case LITERAL_for:
				case LITERAL_using:
				case LITERAL_union:
				case LITERAL_intersect:
				case LITERAL_minus:
				case LITERAL_order:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				select_subsequent_AST = (AST)currentAST.root;
				break;
			}
			case OPEN_PAREN:
			{
				o = LT(1);
				o_AST = astFactory.create(o);
				astFactory.addASTChild(currentAST, o_AST);
				match(OPEN_PAREN);
				select_subsequent();
				astFactory.addASTChild(currentAST, returnAST);
				c = LT(1);
				c_AST = astFactory.create(c);
				astFactory.addASTChild(currentAST, c_AST);
				match(CLOSE_PAREN);
				select_subsequent_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_189);
			} else {
			  throw ex;
			}
		}
		returnAST = select_subsequent_AST;
	}
	
	public final void order_clause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST order_clause_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  c = null;
		AST c_AST = null;
		
		try {      // for error handling
			o = LT(1);
			o_AST = astFactory.create(o);
			astFactory.addASTChild(currentAST, o_AST);
			match(LITERAL_order);
			AST tmp92_AST = null;
			tmp92_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp92_AST);
			match(LITERAL_by);
			sorted_def();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop517:
			do {
				if ((LA(1)==COMMA)) {
					c = LT(1);
					c_AST = astFactory.create(c);
					astFactory.addASTChild(currentAST, c_AST);
					match(COMMA);
					sorted_def();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop517;
				}
				
			} while (true);
			}
			order_clause_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_190);
			} else {
			  throw ex;
			}
		}
		returnAST = order_clause_AST;
	}
	
	public final void update_clause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST update_clause_AST = null;
		Token  f = null;
		AST f_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  c = null;
		AST c_AST = null;
		Token  n = null;
		AST n_AST = null;
		
		try {      // for error handling
			f = LT(1);
			f_AST = astFactory.create(f);
			astFactory.addASTChild(currentAST, f_AST);
			match(LITERAL_for);
			AST tmp93_AST = null;
			tmp93_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp93_AST);
			match(LITERAL_update);
			{
			switch ( LA(1)) {
			case LITERAL_of:
			{
				o = LT(1);
				o_AST = astFactory.create(o);
				astFactory.addASTChild(currentAST, o_AST);
				match(LITERAL_of);
				column_name();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop523:
				do {
					if ((LA(1)==COMMA)) {
						c = LT(1);
						c_AST = astFactory.create(c);
						astFactory.addASTChild(currentAST, c_AST);
						match(COMMA);
						column_name();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop523;
					}
					
				} while (true);
				}
				break;
			}
			case SEMI:
			case CLOSE_PAREN:
			case LITERAL_using:
			case LITERAL_nowait:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_nowait:
			{
				n = LT(1);
				n_AST = astFactory.create(n);
				astFactory.addASTChild(currentAST, n_AST);
				match(LITERAL_nowait);
				break;
			}
			case SEMI:
			case CLOSE_PAREN:
			case LITERAL_using:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			update_clause_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_176);
			} else {
			  throw ex;
			}
		}
		returnAST = update_clause_AST;
	}
	
	public final void select_up_to_list() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST select_up_to_list_AST = null;
		Token  w = null;
		AST w_AST = null;
		Token  a1 = null;
		AST a1_AST = null;
		Token  c = null;
		AST c_AST = null;
		Token  a2 = null;
		AST a2_AST = null;
		Token  s = null;
		AST s_AST = null;
		Token  a3 = null;
		AST a3_AST = null;
		Token  d = null;
		AST d_AST = null;
		
		try {      // for error handling
			{
			{
			switch ( LA(1)) {
			case LITERAL_with:
			{
				w = LT(1);
				w_AST = astFactory.create(w);
				astFactory.addASTChild(currentAST, w_AST);
				match(LITERAL_with);
				alias();
				astFactory.addASTChild(currentAST, returnAST);
				a1 = LT(1);
				a1_AST = astFactory.create(a1);
				astFactory.addASTChild(currentAST, a1_AST);
				match(LITERAL_as);
				subquery();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop385:
				do {
					if ((LA(1)==COMMA)) {
						c = LT(1);
						c_AST = astFactory.create(c);
						astFactory.addASTChild(currentAST, c_AST);
						match(COMMA);
						alias();
						astFactory.addASTChild(currentAST, returnAST);
						a2 = LT(1);
						a2_AST = astFactory.create(a2);
						astFactory.addASTChild(currentAST, a2_AST);
						match(LITERAL_as);
						subquery();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop385;
					}
					
				} while (true);
				}
				break;
			}
			case LITERAL_select:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			s = LT(1);
			s_AST = astFactory.create(s);
			astFactory.makeASTRoot(currentAST, s_AST);
			match(LITERAL_select);
			{
			if ((LA(1)==LITERAL_all) && (_tokenSet_191.member(LA(2))) && (_tokenSet_192.member(LA(3))) && (_tokenSet_73.member(LA(4)))) {
				a3 = LT(1);
				a3_AST = astFactory.create(a3);
				match(LITERAL_all);
			}
			else if ((LA(1)==LITERAL_distinct)) {
				d = LT(1);
				d_AST = astFactory.create(d);
				match(LITERAL_distinct);
			}
			else if ((_tokenSet_191.member(LA(1))) && (_tokenSet_192.member(LA(2))) && (_tokenSet_73.member(LA(3))) && (_tokenSet_193.member(LA(4)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			select_list();
			astFactory.addASTChild(currentAST, returnAST);
			}
			select_up_to_list_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_194);
			} else {
			  throw ex;
			}
		}
		returnAST = select_up_to_list_AST;
	}
	
	public final CommonToken  alias() throws RecognitionException, TokenStreamException {
		 CommonToken id = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST alias_AST = null;
		Token  a = null;
		AST a_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_as:
			{
				a = LT(1);
				a_AST = astFactory.create(a);
				astFactory.addASTChild(currentAST, a_AST);
				match(LITERAL_as);
				break;
			}
			case LITERAL_replace:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			id=identifier();
			astFactory.addASTChild(currentAST, returnAST);
			alias_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_195);
			} else {
			  throw ex;
			}
		}
		returnAST = alias_AST;
		return id;
	}
	
	public final void select_list() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST select_list_AST = null;
		Token  c = null;
		AST c_AST = null;
		
		try {      // for error handling
			{
			displayed_column();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop400:
			do {
				if ((LA(1)==COMMA)) {
					c = LT(1);
					c_AST = astFactory.create(c);
					astFactory.addASTChild(currentAST, c_AST);
					match(COMMA);
					displayed_column();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop400;
				}
				
			} while (true);
			}
			}
			if ( inputState.guessing==0 ) {
				select_list_AST = (AST)currentAST.root;
				
				select_list_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SELECT_LIST,"select_list")).add(select_list_AST));
				
				currentAST.root = select_list_AST;
				currentAST.child = select_list_AST!=null &&select_list_AST.getFirstChild()!=null ?
					select_list_AST.getFirstChild() : select_list_AST;
				currentAST.advanceChildToEnd();
			}
			select_list_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_194);
			} else {
			  throw ex;
			}
		}
		returnAST = select_list_AST;
	}
	
	public final void table_reference_list_from() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST table_reference_list_from_AST = null;
		Token  f = null;
		AST f_AST = null;
		Token  c = null;
		AST c_AST = null;
		
		try {      // for error handling
			f = LT(1);
			f_AST = astFactory.create(f);
			astFactory.addASTChild(currentAST, f_AST);
			match(LITERAL_from);
			selected_table();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop405:
			do {
				switch ( LA(1)) {
				case LITERAL_right:
				case LITERAL_inner:
				case 230:
				{
					ansi_spec();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case COMMA:
				{
					c = LT(1);
					c_AST = astFactory.create(c);
					match(COMMA);
					selected_table();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default:
				{
					break _loop405;
				}
				}
			} while (true);
			}
			if ( inputState.guessing==0 ) {
				table_reference_list_from_AST = (AST)currentAST.root;
				
				table_reference_list_from_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TABLE_REFERENCE_LIST,"table_reference_list_from")).add(table_reference_list_from_AST));
				
				currentAST.root = table_reference_list_from_AST;
				currentAST.child = table_reference_list_from_AST!=null &&table_reference_list_from_AST.getFirstChild()!=null ?
					table_reference_list_from_AST.getFirstChild() : table_reference_list_from_AST;
				currentAST.advanceChildToEnd();
			}
			table_reference_list_from_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_196);
			} else {
			  throw ex;
			}
		}
		returnAST = table_reference_list_from_AST;
	}
	
	public final void where_condition_whole() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST where_condition_whole_AST = null;
		Token  w = null;
		AST w_AST = null;
		
		try {      // for error handling
			w = LT(1);
			w_AST = astFactory.create(w);
			astFactory.addASTChild(currentAST, w_AST);
			match(LITERAL_where);
			condition();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				where_condition_whole_AST = (AST)currentAST.root;
				
				where_condition_whole_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(WHERE_CONDITION,"where_condition_whole")).add(where_condition_whole_AST));
				
				currentAST.root = where_condition_whole_AST;
				currentAST.child = where_condition_whole_AST!=null &&where_condition_whole_AST.getFirstChild()!=null ?
					where_condition_whole_AST.getFirstChild() : where_condition_whole_AST;
				currentAST.advanceChildToEnd();
			}
			where_condition_whole_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_197);
			} else {
			  throw ex;
			}
		}
		returnAST = where_condition_whole_AST;
	}
	
	public final void connect_clause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST connect_clause_AST = null;
		Token  s1 = null;
		AST s1_AST = null;
		Token  w1 = null;
		AST w1_AST = null;
		Token  c1 = null;
		AST c1_AST = null;
		Token  c2 = null;
		AST c2_AST = null;
		Token  s2 = null;
		AST s2_AST = null;
		Token  w2 = null;
		AST w2_AST = null;
		
		try {      // for error handling
			if ((LA(1)==LITERAL_start||LA(1)==LITERAL_connect) && (LA(2)==LITERAL_with||LA(2)==LITERAL_by) && (_tokenSet_198.member(LA(3))) && (_tokenSet_199.member(LA(4)))) {
				{
				switch ( LA(1)) {
				case LITERAL_start:
				{
					s1 = LT(1);
					s1_AST = astFactory.create(s1);
					astFactory.addASTChild(currentAST, s1_AST);
					match(LITERAL_start);
					w1 = LT(1);
					w1_AST = astFactory.create(w1);
					astFactory.addASTChild(currentAST, w1_AST);
					match(LITERAL_with);
					condition();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_connect:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				c1 = LT(1);
				c1_AST = astFactory.create(c1);
				astFactory.addASTChild(currentAST, c1_AST);
				match(LITERAL_connect);
				AST tmp94_AST = null;
				tmp94_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp94_AST);
				match(LITERAL_by);
				condition();
				astFactory.addASTChild(currentAST, returnAST);
				connect_clause_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==LITERAL_start||LA(1)==LITERAL_connect) && (LA(2)==LITERAL_with||LA(2)==LITERAL_by) && (_tokenSet_198.member(LA(3))) && (_tokenSet_199.member(LA(4)))) {
				{
				switch ( LA(1)) {
				case LITERAL_connect:
				{
					c2 = LT(1);
					c2_AST = astFactory.create(c2);
					astFactory.addASTChild(currentAST, c2_AST);
					match(LITERAL_connect);
					AST tmp95_AST = null;
					tmp95_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp95_AST);
					match(LITERAL_by);
					condition();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_start:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				s2 = LT(1);
				s2_AST = astFactory.create(s2);
				astFactory.addASTChild(currentAST, s2_AST);
				match(LITERAL_start);
				w2 = LT(1);
				w2_AST = astFactory.create(w2);
				astFactory.addASTChild(currentAST, w2_AST);
				match(LITERAL_with);
				condition();
				astFactory.addASTChild(currentAST, returnAST);
				connect_clause_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_200);
			} else {
			  throw ex;
			}
		}
		returnAST = connect_clause_AST;
	}
	
	public final void group_clause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST group_clause_AST = null;
		Token  g1 = null;
		AST g1_AST = null;
		Token  h1 = null;
		AST h1_AST = null;
		Token  h2 = null;
		AST h2_AST = null;
		Token  g2 = null;
		AST g2_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_group:
			{
				g1 = LT(1);
				g1_AST = astFactory.create(g1);
				astFactory.addASTChild(currentAST, g1_AST);
				match(LITERAL_group);
				AST tmp96_AST = null;
				tmp96_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp96_AST);
				match(LITERAL_by);
				plsql_exp_list();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case LITERAL_having:
				{
					h1 = LT(1);
					h1_AST = astFactory.create(h1);
					astFactory.addASTChild(currentAST, h1_AST);
					match(LITERAL_having);
					condition();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SEMI:
				case CLOSE_PAREN:
				case LITERAL_for:
				case LITERAL_using:
				case LITERAL_union:
				case LITERAL_intersect:
				case LITERAL_minus:
				case LITERAL_order:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				group_clause_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_having:
			{
				h2 = LT(1);
				h2_AST = astFactory.create(h2);
				astFactory.addASTChild(currentAST, h2_AST);
				match(LITERAL_having);
				condition();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case LITERAL_group:
				{
					g2 = LT(1);
					g2_AST = astFactory.create(g2);
					astFactory.addASTChild(currentAST, g2_AST);
					match(LITERAL_group);
					AST tmp97_AST = null;
					tmp97_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp97_AST);
					match(LITERAL_by);
					plsql_exp_list();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SEMI:
				case CLOSE_PAREN:
				case LITERAL_for:
				case LITERAL_using:
				case LITERAL_union:
				case LITERAL_intersect:
				case LITERAL_minus:
				case LITERAL_order:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				group_clause_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_189);
			} else {
			  throw ex;
			}
		}
		returnAST = group_clause_AST;
	}
	
	public final CommonToken  displayed_column() throws RecognitionException, TokenStreamException {
		 CommonToken id = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST displayed_column_AST = null;
		Token  a0 = null;
		AST a0_AST = null;
		Token  d = null;
		AST d_AST = null;
		Token  a = null;
		AST a_AST = null;
		
		try {      // for error handling
			boolean synPredMatched413 = false;
			if (((LA(1)==ASTERISK))) {
				int _m413 = mark();
				synPredMatched413 = true;
				inputState.guessing++;
				try {
					{
					match(ASTERISK);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched413 = false;
				}
				rewind(_m413);
				inputState.guessing--;
			}
			if ( synPredMatched413 ) {
				a0 = LT(1);
				a0_AST = astFactory.create(a0);
				astFactory.addASTChild(currentAST, a0_AST);
				match(ASTERISK);
				displayed_column_AST = (AST)currentAST.root;
			}
			else {
				boolean synPredMatched415 = false;
				if (((_tokenSet_1.member(LA(1))) && (LA(2)==DOT) && (LA(3)==ASTERISK) && (_tokenSet_201.member(LA(4))))) {
					int _m415 = mark();
					synPredMatched415 = true;
					inputState.guessing++;
					try {
						{
						identifier();
						match(DOT);
						match(ASTERISK);
						}
					}
					catch (RecognitionException pe) {
						synPredMatched415 = false;
					}
					rewind(_m415);
					inputState.guessing--;
				}
				if ( synPredMatched415 ) {
					id=identifier();
					astFactory.addASTChild(currentAST, returnAST);
					d = LT(1);
					d_AST = astFactory.create(d);
					astFactory.addASTChild(currentAST, d_AST);
					match(DOT);
					a = LT(1);
					a_AST = astFactory.create(a);
					astFactory.addASTChild(currentAST, a_AST);
					match(ASTERISK);
					displayed_column_AST = (AST)currentAST.root;
				}
				else if ((_tokenSet_20.member(LA(1))) && (_tokenSet_192.member(LA(2))) && (_tokenSet_73.member(LA(3))) && (_tokenSet_193.member(LA(4)))) {
					plsql_expression();
					astFactory.addASTChild(currentAST, returnAST);
					{
					boolean synPredMatched418 = false;
					if (((_tokenSet_202.member(LA(1))) && (_tokenSet_203.member(LA(2))) && (_tokenSet_204.member(LA(3))) && (_tokenSet_205.member(LA(4))))) {
						int _m418 = mark();
						synPredMatched418 = true;
						inputState.guessing++;
						try {
							{
							match(LITERAL_as);
							}
						}
						catch (RecognitionException pe) {
							synPredMatched418 = false;
						}
						rewind(_m418);
						inputState.guessing--;
					}
					if ( synPredMatched418 ) {
						alias();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else if ((_tokenSet_1.member(LA(1))) && (_tokenSet_201.member(LA(2))) && (_tokenSet_206.member(LA(3))) && (_tokenSet_207.member(LA(4)))) {
						id=identifier();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else if ((_tokenSet_201.member(LA(1)))) {
					}
					else {
						throw new NoViableAltException(LT(1), getFilename());
					}
					
					}
					displayed_column_AST = (AST)currentAST.root;
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_201);
				} else {
				  throw ex;
				}
			}
			returnAST = displayed_column_AST;
			return id;
		}
		
	public final void selected_table() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST selected_table_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_table:
			{
				row_proc();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_the:
			{
				the_proc();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case OPEN_PAREN:
			{
				subquery();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_replace:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				table_spec();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			if ((_tokenSet_202.member(LA(1))) && (_tokenSet_208.member(LA(2))) && (_tokenSet_209.member(LA(3))) && (_tokenSet_210.member(LA(4)))) {
				alias();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else if ((_tokenSet_211.member(LA(1))) && (_tokenSet_209.member(LA(2))) && (_tokenSet_210.member(LA(3))) && (_tokenSet_212.member(LA(4)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			selected_table_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_211);
			} else {
			  throw ex;
			}
		}
		returnAST = selected_table_AST;
	}
	
	public final void ansi_spec() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST ansi_spec_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  l = null;
		AST l_AST = null;
		Token  r = null;
		AST r_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  j = null;
		AST j_AST = null;
		Token  on = null;
		AST on_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_inner:
			{
				i = LT(1);
				i_AST = astFactory.create(i);
				astFactory.addASTChild(currentAST, i_AST);
				match(LITERAL_inner);
				break;
			}
			case LITERAL_right:
			case 230:
			{
				{
				{
				switch ( LA(1)) {
				case 230:
				{
					l = LT(1);
					l_AST = astFactory.create(l);
					astFactory.addASTChild(currentAST, l_AST);
					match(230);
					break;
				}
				case LITERAL_right:
				{
					r = LT(1);
					r_AST = astFactory.create(r);
					astFactory.addASTChild(currentAST, r_AST);
					match(LITERAL_right);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				o = LT(1);
				o_AST = astFactory.create(o);
				astFactory.addASTChild(currentAST, o_AST);
				match(LITERAL_outer);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			j = LT(1);
			j_AST = astFactory.create(j);
			astFactory.addASTChild(currentAST, j_AST);
			match(LITERAL_join);
			selected_table();
			astFactory.addASTChild(currentAST, returnAST);
			on = LT(1);
			on_AST = astFactory.create(on);
			astFactory.addASTChild(currentAST, on_AST);
			match(LITERAL_on);
			condition();
			astFactory.addASTChild(currentAST, returnAST);
			ansi_spec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_213);
			} else {
			  throw ex;
			}
		}
		returnAST = ansi_spec_AST;
	}
	
	public final void table_reference_list() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST table_reference_list_AST = null;
		Token  c = null;
		AST c_AST = null;
		
		try {      // for error handling
			{
			selected_table();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop409:
			do {
				if ((LA(1)==COMMA)) {
					c = LT(1);
					c_AST = astFactory.create(c);
					match(COMMA);
					selected_table();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop409;
				}
				
			} while (true);
			}
			}
			if ( inputState.guessing==0 ) {
				table_reference_list_AST = (AST)currentAST.root;
				
				table_reference_list_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TABLE_REFERENCE_LIST,"table_reference_list")).add(table_reference_list_AST));
				
				currentAST.root = table_reference_list_AST;
				currentAST.child = table_reference_list_AST!=null &&table_reference_list_AST.getFirstChild()!=null ?
					table_reference_list_AST.getFirstChild() : table_reference_list_AST;
				currentAST.advanceChildToEnd();
			}
			table_reference_list_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_171);
			} else {
			  throw ex;
			}
		}
		returnAST = table_reference_list_AST;
	}
	
	public final void call_argument() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST call_argument_AST = null;
		Token  p = null;
		AST p_AST = null;
		
		try {      // for error handling
			{
			if ((_tokenSet_1.member(LA(1))) && (LA(2)==PASS_BY_NAME)) {
				variable_name();
				astFactory.addASTChild(currentAST, returnAST);
				p = LT(1);
				p_AST = astFactory.create(p);
				astFactory.addASTChild(currentAST, p_AST);
				match(PASS_BY_NAME);
			}
			else if ((_tokenSet_20.member(LA(1))) && (_tokenSet_214.member(LA(2)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			plsql_expression();
			astFactory.addASTChild(currentAST, returnAST);
			call_argument_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_215);
			} else {
			  throw ex;
			}
		}
		returnAST = call_argument_AST;
	}
	
	public final CommonToken  user_defined_function() throws RecognitionException, TokenStreamException {
		 CommonToken i1 = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST user_defined_function_AST = null;
		
		CommonToken i2 = null;
		CommonToken i3 = null;
		
		
		try {      // for error handling
			i1=identifier();
			astFactory.addASTChild(currentAST, returnAST);
			user_defined_function_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_138);
			} else {
			  throw ex;
			}
		}
		returnAST = user_defined_function_AST;
		return i1;
	}
	
	public final CommonToken  built_in_function() throws RecognitionException, TokenStreamException {
		 CommonToken f = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST built_in_function_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_mod:
			case LITERAL_power:
			case LITERAL_round:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			{
				f=number_function();
				astFactory.addASTChild(currentAST, returnAST);
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_replace:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_rpad:
			case LITERAL_rtrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			{
				f=char_function();
				astFactory.addASTChild(currentAST, returnAST);
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_count:
			case LITERAL_avg:
			case LITERAL_max:
			case LITERAL_min:
			case LITERAL_stddev:
			case LITERAL_sum:
			case LITERAL_variance:
			{
				f=group_function();
				astFactory.addASTChild(currentAST, returnAST);
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_rowidtochar:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			{
				f=conversion_function();
				astFactory.addASTChild(currentAST, returnAST);
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_uid:
			case LITERAL_userenv:
			case LITERAL_vsize:
			{
				f=other_function();
				astFactory.addASTChild(currentAST, returnAST);
				built_in_function_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_138);
			} else {
			  throw ex;
			}
		}
		returnAST = built_in_function_AST;
		return f;
	}
	
	public final CommonToken  number_function() throws RecognitionException, TokenStreamException {
		 CommonToken nf = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST number_function_AST = null;
		Token  a1 = null;
		AST a1_AST = null;
		Token  a2 = null;
		AST a2_AST = null;
		Token  c = null;
		AST c_AST = null;
		Token  f = null;
		AST f_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  l = null;
		AST l_AST = null;
		Token  m = null;
		AST m_AST = null;
		Token  p = null;
		AST p_AST = null;
		Token  r = null;
		AST r_AST = null;
		Token  s1 = null;
		AST s1_AST = null;
		Token  s2 = null;
		AST s2_AST = null;
		Token  t = null;
		AST t_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_abs:
			{
				a1 = LT(1);
				a1_AST = astFactory.create(a1);
				astFactory.addASTChild(currentAST, a1_AST);
				match(LITERAL_abs);
				if ( inputState.guessing==0 ) {
					
					nf = (CommonToken) a1;
					
				}
				number_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_ascii:
			{
				a2 = LT(1);
				a2_AST = astFactory.create(a2);
				astFactory.addASTChild(currentAST, a2_AST);
				match(LITERAL_ascii);
				if ( inputState.guessing==0 ) {
					
					nf = (CommonToken) a2;
					
				}
				number_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_ceil:
			{
				c = LT(1);
				c_AST = astFactory.create(c);
				astFactory.addASTChild(currentAST, c_AST);
				match(LITERAL_ceil);
				if ( inputState.guessing==0 ) {
					
					nf = (CommonToken) c;
					
				}
				number_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_floor:
			{
				f = LT(1);
				f_AST = astFactory.create(f);
				astFactory.addASTChild(currentAST, f_AST);
				match(LITERAL_floor);
				if ( inputState.guessing==0 ) {
					
					nf = (CommonToken) f;
					
				}
				number_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_instr:
			{
				i = LT(1);
				i_AST = astFactory.create(i);
				astFactory.addASTChild(currentAST, i_AST);
				match(LITERAL_instr);
				if ( inputState.guessing==0 ) {
					
					nf = (CommonToken) i;
					
				}
				number_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_length:
			{
				l = LT(1);
				l_AST = astFactory.create(l);
				astFactory.addASTChild(currentAST, l_AST);
				match(LITERAL_length);
				if ( inputState.guessing==0 ) {
					
					nf = (CommonToken) l;
					
				}
				number_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_mod:
			{
				m = LT(1);
				m_AST = astFactory.create(m);
				astFactory.addASTChild(currentAST, m_AST);
				match(LITERAL_mod);
				if ( inputState.guessing==0 ) {
					
					nf = (CommonToken) m;
					
				}
				number_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_power:
			{
				p = LT(1);
				p_AST = astFactory.create(p);
				astFactory.addASTChild(currentAST, p_AST);
				match(LITERAL_power);
				if ( inputState.guessing==0 ) {
					
					nf = (CommonToken) p;
					
				}
				number_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_round:
			{
				r = LT(1);
				r_AST = astFactory.create(r);
				astFactory.addASTChild(currentAST, r_AST);
				match(LITERAL_round);
				if ( inputState.guessing==0 ) {
					
					nf = (CommonToken) r;
					
				}
				number_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_sign:
			{
				s1 = LT(1);
				s1_AST = astFactory.create(s1);
				astFactory.addASTChild(currentAST, s1_AST);
				match(LITERAL_sign);
				if ( inputState.guessing==0 ) {
					
					nf = (CommonToken) s1;
					
				}
				number_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_sqrt:
			{
				s2 = LT(1);
				s2_AST = astFactory.create(s2);
				astFactory.addASTChild(currentAST, s2_AST);
				match(LITERAL_sqrt);
				if ( inputState.guessing==0 ) {
					
					nf = (CommonToken) s2;
					
				}
				number_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_trunc:
			{
				t = LT(1);
				t_AST = astFactory.create(t);
				astFactory.addASTChild(currentAST, t_AST);
				match(LITERAL_trunc);
				if ( inputState.guessing==0 ) {
					
					nf = (CommonToken) t;
					
				}
				number_function_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_138);
			} else {
			  throw ex;
			}
		}
		returnAST = number_function_AST;
		return nf;
	}
	
	public final CommonToken  char_function() throws RecognitionException, TokenStreamException {
		 CommonToken cf = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST char_function_AST = null;
		Token  c1 = null;
		AST c1_AST = null;
		Token  c2 = null;
		AST c2_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  l1 = null;
		AST l1_AST = null;
		Token  l2 = null;
		AST l2_AST = null;
		Token  l3 = null;
		AST l3_AST = null;
		Token  r1 = null;
		AST r1_AST = null;
		Token  r2 = null;
		AST r2_AST = null;
		Token  r3 = null;
		AST r3_AST = null;
		Token  s1 = null;
		AST s1_AST = null;
		Token  s2 = null;
		AST s2_AST = null;
		Token  t = null;
		AST t_AST = null;
		Token  u = null;
		AST u_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_chr:
			{
				c1 = LT(1);
				c1_AST = astFactory.create(c1);
				astFactory.addASTChild(currentAST, c1_AST);
				match(LITERAL_chr);
				if ( inputState.guessing==0 ) {
					
					cf = (CommonToken) c1;
					
				}
				char_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_concat:
			{
				c2 = LT(1);
				c2_AST = astFactory.create(c2);
				astFactory.addASTChild(currentAST, c2_AST);
				match(LITERAL_concat);
				if ( inputState.guessing==0 ) {
					
					cf = (CommonToken) c2;
					
				}
				char_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_initcap:
			{
				i = LT(1);
				i_AST = astFactory.create(i);
				astFactory.addASTChild(currentAST, i_AST);
				match(LITERAL_initcap);
				if ( inputState.guessing==0 ) {
					
					cf = (CommonToken) i;
					
				}
				char_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_lower:
			{
				l1 = LT(1);
				l1_AST = astFactory.create(l1);
				astFactory.addASTChild(currentAST, l1_AST);
				match(LITERAL_lower);
				if ( inputState.guessing==0 ) {
					
					cf = (CommonToken) l1;
					
				}
				char_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_lpad:
			{
				l2 = LT(1);
				l2_AST = astFactory.create(l2);
				astFactory.addASTChild(currentAST, l2_AST);
				match(LITERAL_lpad);
				if ( inputState.guessing==0 ) {
					
					cf = (CommonToken) l2;
					
				}
				char_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_ltrim:
			{
				l3 = LT(1);
				l3_AST = astFactory.create(l3);
				astFactory.addASTChild(currentAST, l3_AST);
				match(LITERAL_ltrim);
				if ( inputState.guessing==0 ) {
					
					cf = (CommonToken) l3;
					
				}
				char_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_replace:
			{
				r1 = LT(1);
				r1_AST = astFactory.create(r1);
				astFactory.addASTChild(currentAST, r1_AST);
				match(LITERAL_replace);
				if ( inputState.guessing==0 ) {
					
					cf = (CommonToken) r1;
					
				}
				char_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_rpad:
			{
				r2 = LT(1);
				r2_AST = astFactory.create(r2);
				astFactory.addASTChild(currentAST, r2_AST);
				match(LITERAL_rpad);
				if ( inputState.guessing==0 ) {
					
					cf = (CommonToken) r2;
					
				}
				char_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_rtrim:
			{
				r3 = LT(1);
				r3_AST = astFactory.create(r3);
				astFactory.addASTChild(currentAST, r3_AST);
				match(LITERAL_rtrim);
				if ( inputState.guessing==0 ) {
					
					cf = (CommonToken) r3;
					
				}
				char_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_soundex:
			{
				s1 = LT(1);
				s1_AST = astFactory.create(s1);
				astFactory.addASTChild(currentAST, s1_AST);
				match(LITERAL_soundex);
				if ( inputState.guessing==0 ) {
					
					cf = (CommonToken) s1;
					
				}
				char_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_substr:
			{
				s2 = LT(1);
				s2_AST = astFactory.create(s2);
				astFactory.addASTChild(currentAST, s2_AST);
				match(LITERAL_substr);
				if ( inputState.guessing==0 ) {
					
					cf = (CommonToken) s2;
					
				}
				char_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_translate:
			{
				t = LT(1);
				t_AST = astFactory.create(t);
				astFactory.addASTChild(currentAST, t_AST);
				match(LITERAL_translate);
				if ( inputState.guessing==0 ) {
					
					cf = (CommonToken) t;
					
				}
				char_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_upper:
			{
				u = LT(1);
				u_AST = astFactory.create(u);
				astFactory.addASTChild(currentAST, u_AST);
				match(LITERAL_upper);
				if ( inputState.guessing==0 ) {
					
					cf = (CommonToken) u;
					
				}
				char_function_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_138);
			} else {
			  throw ex;
			}
		}
		returnAST = char_function_AST;
		return cf;
	}
	
	public final CommonToken  group_function() throws RecognitionException, TokenStreamException {
		 CommonToken gf = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST group_function_AST = null;
		Token  a = null;
		AST a_AST = null;
		Token  c = null;
		AST c_AST = null;
		Token  m1 = null;
		AST m1_AST = null;
		Token  m2 = null;
		AST m2_AST = null;
		Token  s1 = null;
		AST s1_AST = null;
		Token  s2 = null;
		AST s2_AST = null;
		Token  v = null;
		AST v_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_avg:
			{
				a = LT(1);
				a_AST = astFactory.create(a);
				astFactory.addASTChild(currentAST, a_AST);
				match(LITERAL_avg);
				if ( inputState.guessing==0 ) {
					
					gf = (CommonToken) a;
					
				}
				group_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_count:
			{
				c = LT(1);
				c_AST = astFactory.create(c);
				astFactory.addASTChild(currentAST, c_AST);
				match(LITERAL_count);
				if ( inputState.guessing==0 ) {
					
					gf = (CommonToken) c;
					
				}
				group_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_max:
			{
				m1 = LT(1);
				m1_AST = astFactory.create(m1);
				astFactory.addASTChild(currentAST, m1_AST);
				match(LITERAL_max);
				if ( inputState.guessing==0 ) {
					
					gf = (CommonToken) m1;
					
				}
				group_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_min:
			{
				m2 = LT(1);
				m2_AST = astFactory.create(m2);
				astFactory.addASTChild(currentAST, m2_AST);
				match(LITERAL_min);
				if ( inputState.guessing==0 ) {
					
					gf = (CommonToken) m2;
					
				}
				group_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_stddev:
			{
				s1 = LT(1);
				s1_AST = astFactory.create(s1);
				astFactory.addASTChild(currentAST, s1_AST);
				match(LITERAL_stddev);
				if ( inputState.guessing==0 ) {
					
					gf = (CommonToken) s1;
					
				}
				group_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_sum:
			{
				s2 = LT(1);
				s2_AST = astFactory.create(s2);
				astFactory.addASTChild(currentAST, s2_AST);
				match(LITERAL_sum);
				if ( inputState.guessing==0 ) {
					
					gf = (CommonToken) s2;
					
				}
				group_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_variance:
			{
				v = LT(1);
				v_AST = astFactory.create(v);
				astFactory.addASTChild(currentAST, v_AST);
				match(LITERAL_variance);
				if ( inputState.guessing==0 ) {
					
					gf = (CommonToken) v;
					
				}
				group_function_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_138);
			} else {
			  throw ex;
			}
		}
		returnAST = group_function_AST;
		return gf;
	}
	
	public final CommonToken  conversion_function() throws RecognitionException, TokenStreamException {
		 CommonToken cf = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST conversion_function_AST = null;
		Token  c1 = null;
		AST c1_AST = null;
		Token  c2 = null;
		AST c2_AST = null;
		Token  h = null;
		AST h_AST = null;
		Token  r1 = null;
		AST r1_AST = null;
		Token  r2 = null;
		AST r2_AST = null;
		Token  t1 = null;
		AST t1_AST = null;
		Token  t2 = null;
		AST t2_AST = null;
		Token  t3 = null;
		AST t3_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_chartorowid:
			{
				c1 = LT(1);
				c1_AST = astFactory.create(c1);
				astFactory.addASTChild(currentAST, c1_AST);
				match(LITERAL_chartorowid);
				if ( inputState.guessing==0 ) {
					
					cf = (CommonToken) c1;
					
				}
				conversion_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_convert:
			{
				c2 = LT(1);
				c2_AST = astFactory.create(c2);
				astFactory.addASTChild(currentAST, c2_AST);
				match(LITERAL_convert);
				if ( inputState.guessing==0 ) {
					
					cf = (CommonToken) c2;
					
				}
				conversion_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_hextoraw:
			{
				h = LT(1);
				h_AST = astFactory.create(h);
				astFactory.addASTChild(currentAST, h_AST);
				match(LITERAL_hextoraw);
				if ( inputState.guessing==0 ) {
					
					cf = (CommonToken) h;
					
				}
				conversion_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_rawtohex:
			{
				r1 = LT(1);
				r1_AST = astFactory.create(r1);
				astFactory.addASTChild(currentAST, r1_AST);
				match(LITERAL_rawtohex);
				if ( inputState.guessing==0 ) {
					
					cf = (CommonToken) r1;
					
				}
				conversion_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_rowidtochar:
			{
				r2 = LT(1);
				r2_AST = astFactory.create(r2);
				astFactory.addASTChild(currentAST, r2_AST);
				match(LITERAL_rowidtochar);
				if ( inputState.guessing==0 ) {
					
					cf = (CommonToken) r2;
					
				}
				conversion_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_to_char:
			{
				t1 = LT(1);
				t1_AST = astFactory.create(t1);
				astFactory.addASTChild(currentAST, t1_AST);
				match(LITERAL_to_char);
				if ( inputState.guessing==0 ) {
					
					cf = (CommonToken) t1;
					
				}
				conversion_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_to_date:
			{
				t2 = LT(1);
				t2_AST = astFactory.create(t2);
				astFactory.addASTChild(currentAST, t2_AST);
				match(LITERAL_to_date);
				if ( inputState.guessing==0 ) {
					
					cf = (CommonToken) t2;
					
				}
				conversion_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_to_number:
			{
				t3 = LT(1);
				t3_AST = astFactory.create(t3);
				astFactory.addASTChild(currentAST, t3_AST);
				match(LITERAL_to_number);
				if ( inputState.guessing==0 ) {
					
					cf = (CommonToken) t3;
					
				}
				conversion_function_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_138);
			} else {
			  throw ex;
			}
		}
		returnAST = conversion_function_AST;
		return cf;
	}
	
	public final CommonToken  other_function() throws RecognitionException, TokenStreamException {
		 CommonToken of = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST other_function_AST = null;
		Token  d1 = null;
		AST d1_AST = null;
		Token  d2 = null;
		AST d2_AST = null;
		Token  g = null;
		AST g_AST = null;
		Token  l = null;
		AST l_AST = null;
		Token  n = null;
		AST n_AST = null;
		Token  u1 = null;
		AST u1_AST = null;
		Token  u2 = null;
		AST u2_AST = null;
		Token  v = null;
		AST v_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_decode:
			{
				d1 = LT(1);
				d1_AST = astFactory.create(d1);
				astFactory.addASTChild(currentAST, d1_AST);
				match(LITERAL_decode);
				if ( inputState.guessing==0 ) {
					
					of = (CommonToken) d1;
					
				}
				other_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_dump:
			{
				d2 = LT(1);
				d2_AST = astFactory.create(d2);
				astFactory.addASTChild(currentAST, d2_AST);
				match(LITERAL_dump);
				if ( inputState.guessing==0 ) {
					
					of = (CommonToken) d2;
					
				}
				other_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_greatest:
			{
				g = LT(1);
				g_AST = astFactory.create(g);
				astFactory.addASTChild(currentAST, g_AST);
				match(LITERAL_greatest);
				if ( inputState.guessing==0 ) {
					
					of = (CommonToken) g;
					
				}
				other_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_least:
			{
				l = LT(1);
				l_AST = astFactory.create(l);
				astFactory.addASTChild(currentAST, l_AST);
				match(LITERAL_least);
				if ( inputState.guessing==0 ) {
					
					of = (CommonToken) l;
					
				}
				other_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_nvl:
			{
				n = LT(1);
				n_AST = astFactory.create(n);
				astFactory.addASTChild(currentAST, n_AST);
				match(LITERAL_nvl);
				if ( inputState.guessing==0 ) {
					
					of = (CommonToken) n;
					
				}
				other_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_uid:
			{
				u1 = LT(1);
				u1_AST = astFactory.create(u1);
				astFactory.addASTChild(currentAST, u1_AST);
				match(LITERAL_uid);
				if ( inputState.guessing==0 ) {
					
					of = (CommonToken) u1;
					
				}
				other_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_userenv:
			{
				u2 = LT(1);
				u2_AST = astFactory.create(u2);
				astFactory.addASTChild(currentAST, u2_AST);
				match(LITERAL_userenv);
				if ( inputState.guessing==0 ) {
					
					of = (CommonToken) u2;
					
				}
				other_function_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_vsize:
			{
				v = LT(1);
				v_AST = astFactory.create(v);
				astFactory.addASTChild(currentAST, v_AST);
				match(LITERAL_vsize);
				if ( inputState.guessing==0 ) {
					
					of = (CommonToken) v;
					
				}
				other_function_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_138);
			} else {
			  throw ex;
			}
		}
		returnAST = other_function_AST;
		return of;
	}
	
	public final CommonToken  row_proc() throws RecognitionException, TokenStreamException {
		 CommonToken rp = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST row_proc_AST = null;
		Token  t = null;
		AST t_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  cp = null;
		AST cp_AST = null;
		
		try {      // for error handling
			t = LT(1);
			t_AST = astFactory.create(t);
			astFactory.addASTChild(currentAST, t_AST);
			match(LITERAL_table);
			o = LT(1);
			o_AST = astFactory.create(o);
			astFactory.addASTChild(currentAST, o_AST);
			match(OPEN_PAREN);
			{
			switch ( LA(1)) {
			case OPEN_PAREN:
			case LITERAL_with:
			case LITERAL_select:
			{
				select_command();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_cast:
			{
				cast_proc();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			cp = LT(1);
			cp_AST = astFactory.create(cp);
			match(CLOSE_PAREN);
			if ( inputState.guessing==0 ) {
				
				rp = (CommonToken) t;
				
			}
			row_proc_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_216);
			} else {
			  throw ex;
			}
		}
		returnAST = row_proc_AST;
		return rp;
	}
	
	public final CommonToken  the_proc() throws RecognitionException, TokenStreamException {
		CommonToken tp= null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST the_proc_AST = null;
		Token  t = null;
		AST t_AST = null;
		
		try {      // for error handling
			t = LT(1);
			t_AST = astFactory.create(t);
			astFactory.addASTChild(currentAST, t_AST);
			match(LITERAL_the);
			subquery();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				
				tp = (CommonToken) t;
				
			}
			the_proc_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_216);
			} else {
			  throw ex;
			}
		}
		returnAST = the_proc_AST;
		return tp;
	}
	
	public final void table_spec() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST table_spec_AST = null;
		
		try {      // for error handling
			{
			if ((_tokenSet_1.member(LA(1))) && (LA(2)==DOT)) {
				schema_name();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp98_AST = null;
				tmp98_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp98_AST);
				match(DOT);
			}
			else if ((_tokenSet_1.member(LA(1))) && (_tokenSet_217.member(LA(2)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			table_name();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case AT_SIGN:
			{
				AST tmp99_AST = null;
				tmp99_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp99_AST);
				match(AT_SIGN);
				link_name();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_set:
			case SEMI:
			case LITERAL_replace:
			case LITERAL_as:
			case OPEN_PAREN:
			case COMMA:
			case CLOSE_PAREN:
			case LITERAL_for:
			case LITERAL_with:
			case LITERAL_select:
			case LITERAL_in:
			case LITERAL_count:
			case LITERAL_using:
			case LITERAL_union:
			case LITERAL_intersect:
			case LITERAL_minus:
			case LITERAL_right:
			case LITERAL_inner:
			case LITERAL_where:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case 230:
			case LITERAL_on:
			case LITERAL_start:
			case LITERAL_connect:
			case LITERAL_group:
			case LITERAL_having:
			case LITERAL_order:
			case LITERAL_values:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			table_spec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_218);
			} else {
			  throw ex;
			}
		}
		returnAST = table_spec_AST;
	}
	
	public final CommonToken  link_name() throws RecognitionException, TokenStreamException {
		 CommonToken ln = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST link_name_AST = null;
		
		try {      // for error handling
			ln=identifier();
			astFactory.addASTChild(currentAST, returnAST);
			link_name_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_218);
			} else {
			  throw ex;
			}
		}
		returnAST = link_name_AST;
		return ln;
	}
	
	public final void table_alias() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST table_alias_AST = null;
		
		try {      // for error handling
			table_spec();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_replace:
			case LITERAL_as:
			case LITERAL_count:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_power:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				alias();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_set:
			case SEMI:
			case LITERAL_where:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			table_alias_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_219);
			} else {
			  throw ex;
			}
		}
		returnAST = table_alias_AST;
	}
	
	public final void logical_term() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logical_term_AST = null;
		Token  a = null;
		AST a_AST = null;
		
		try {      // for error handling
			maybe_neg_factor();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop474:
			do {
				if ((LA(1)==LITERAL_and)) {
					a = LT(1);
					a_AST = astFactory.create(a);
					astFactory.makeASTRoot(currentAST, a_AST);
					match(LITERAL_and);
					maybe_neg_factor();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop474;
				}
				
			} while (true);
			}
			logical_term_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_220);
			} else {
			  throw ex;
			}
		}
		returnAST = logical_term_AST;
	}
	
	public final void maybe_neg_factor() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST maybe_neg_factor_AST = null;
		Token  n0 = null;
		AST n0_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_not:
			{
				n0 = LT(1);
				n0_AST = astFactory.create(n0);
				astFactory.addASTChild(currentAST, n0_AST);
				match(LITERAL_not);
				break;
			}
			case LITERAL_replace:
			case LITERAL_null:
			case OPEN_PAREN:
			case LITERAL_open:
			case NUMBER:
			case PLUS:
			case MINUS:
			case LITERAL_true:
			case LITERAL_false:
			case LITERAL_cast:
			case LITERAL_trim:
			case LITERAL_count:
			case LITERAL_case:
			case LITERAL_all:
			case LITERAL_any:
			case QUOTED_STRING:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_mod:
			case LITERAL_power:
			case LITERAL_round:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_rpad:
			case LITERAL_rtrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_avg:
			case LITERAL_max:
			case LITERAL_min:
			case LITERAL_stddev:
			case LITERAL_sum:
			case LITERAL_variance:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_rowidtochar:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_uid:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case LITERAL_exists:
			case LITERAL_prior:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			logical_factor();
			astFactory.addASTChild(currentAST, returnAST);
			maybe_neg_factor_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_221);
			} else {
			  throw ex;
			}
		}
		returnAST = maybe_neg_factor_AST;
	}
	
	public final void logical_factor() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logical_factor_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  cp = null;
		AST cp_AST = null;
		Token  es = null;
		AST es_AST = null;
		Token  n = null;
		AST n_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  n1 = null;
		AST n1_AST = null;
		Token  l = null;
		AST l_AST = null;
		Token  e = null;
		AST e_AST = null;
		Token  q = null;
		AST q_AST = null;
		Token  n2 = null;
		AST n2_AST = null;
		Token  b = null;
		AST b_AST = null;
		Token  a = null;
		AST a_AST = null;
		Token  i2 = null;
		AST i2_AST = null;
		Token  n3 = null;
		AST n3_AST = null;
		Token  n4 = null;
		AST n4_AST = null;
		
		try {      // for error handling
			boolean synPredMatched479 = false;
			if (((LA(1)==OPEN_PAREN) && (_tokenSet_198.member(LA(2))) && (_tokenSet_199.member(LA(3))) && (_tokenSet_222.member(LA(4))))) {
				int _m479 = mark();
				synPredMatched479 = true;
				inputState.guessing++;
				try {
					{
					match(OPEN_PAREN);
					condition();
					match(CLOSE_PAREN);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched479 = false;
				}
				rewind(_m479);
				inputState.guessing--;
			}
			if ( synPredMatched479 ) {
				o = LT(1);
				o_AST = astFactory.create(o);
				astFactory.addASTChild(currentAST, o_AST);
				match(OPEN_PAREN);
				condition();
				astFactory.addASTChild(currentAST, returnAST);
				cp = LT(1);
				cp_AST = astFactory.create(cp);
				match(CLOSE_PAREN);
				logical_factor_AST = (AST)currentAST.root;
			}
			else {
				boolean synPredMatched481 = false;
				if (((LA(1)==LITERAL_exists))) {
					int _m481 = mark();
					synPredMatched481 = true;
					inputState.guessing++;
					try {
						{
						match(LITERAL_exists);
						}
					}
					catch (RecognitionException pe) {
						synPredMatched481 = false;
					}
					rewind(_m481);
					inputState.guessing--;
				}
				if ( synPredMatched481 ) {
					es = LT(1);
					es_AST = astFactory.create(es);
					astFactory.addASTChild(currentAST, es_AST);
					match(LITERAL_exists);
					subquery();
					astFactory.addASTChild(currentAST, returnAST);
					logical_factor_AST = (AST)currentAST.root;
				}
				else {
					boolean synPredMatched483 = false;
					if (((_tokenSet_164.member(LA(1))) && (_tokenSet_223.member(LA(2))) && (_tokenSet_224.member(LA(3))) && (_tokenSet_225.member(LA(4))))) {
						int _m483 = mark();
						synPredMatched483 = true;
						inputState.guessing++;
						try {
							{
							prior_plsql_expression();
							relational_op();
							prior_plsql_expression();
							}
						}
						catch (RecognitionException pe) {
							synPredMatched483 = false;
						}
						rewind(_m483);
						inputState.guessing--;
					}
					if ( synPredMatched483 ) {
						prior_plsql_expression();
						astFactory.addASTChild(currentAST, returnAST);
						relational_op();
						astFactory.addASTChild(currentAST, returnAST);
						prior_plsql_expression();
						astFactory.addASTChild(currentAST, returnAST);
						logical_factor_AST = (AST)currentAST.root;
					}
					else {
						boolean synPredMatched486 = false;
						if (((_tokenSet_164.member(LA(1))) && (_tokenSet_226.member(LA(2))) && (_tokenSet_227.member(LA(3))) && (_tokenSet_225.member(LA(4))))) {
							int _m486 = mark();
							synPredMatched486 = true;
							inputState.guessing++;
							try {
								{
								prior_plsql_expression();
								{
								switch ( LA(1)) {
								case LITERAL_not:
								{
									match(LITERAL_not);
									break;
								}
								case LITERAL_in:
								{
									break;
								}
								default:
								{
									throw new NoViableAltException(LT(1), getFilename());
								}
								}
								}
								match(LITERAL_in);
								}
							}
							catch (RecognitionException pe) {
								synPredMatched486 = false;
							}
							rewind(_m486);
							inputState.guessing--;
						}
						if ( synPredMatched486 ) {
							{
							prior_plsql_expression();
							astFactory.addASTChild(currentAST, returnAST);
							{
							switch ( LA(1)) {
							case LITERAL_not:
							{
								n = LT(1);
								n_AST = astFactory.create(n);
								astFactory.addASTChild(currentAST, n_AST);
								match(LITERAL_not);
								break;
							}
							case LITERAL_in:
							{
								break;
							}
							default:
							{
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
							}
							i = LT(1);
							i_AST = astFactory.create(i);
							astFactory.makeASTRoot(currentAST, i_AST);
							match(LITERAL_in);
							exp_set();
							astFactory.addASTChild(currentAST, returnAST);
							}
							logical_factor_AST = (AST)currentAST.root;
						}
						else {
							boolean synPredMatched491 = false;
							if (((_tokenSet_164.member(LA(1))) && (_tokenSet_228.member(LA(2))) && (_tokenSet_229.member(LA(3))) && (_tokenSet_230.member(LA(4))))) {
								int _m491 = mark();
								synPredMatched491 = true;
								inputState.guessing++;
								try {
									{
									prior_plsql_expression();
									{
									switch ( LA(1)) {
									case LITERAL_not:
									{
										match(LITERAL_not);
										break;
									}
									case LITERAL_like:
									{
										break;
									}
									default:
									{
										throw new NoViableAltException(LT(1), getFilename());
									}
									}
									}
									match(LITERAL_like);
									}
								}
								catch (RecognitionException pe) {
									synPredMatched491 = false;
								}
								rewind(_m491);
								inputState.guessing--;
							}
							if ( synPredMatched491 ) {
								{
								prior_plsql_expression();
								astFactory.addASTChild(currentAST, returnAST);
								{
								switch ( LA(1)) {
								case LITERAL_not:
								{
									n1 = LT(1);
									n1_AST = astFactory.create(n1);
									astFactory.addASTChild(currentAST, n1_AST);
									match(LITERAL_not);
									break;
								}
								case LITERAL_like:
								{
									break;
								}
								default:
								{
									throw new NoViableAltException(LT(1), getFilename());
								}
								}
								}
								l = LT(1);
								l_AST = astFactory.create(l);
								astFactory.makeASTRoot(currentAST, l_AST);
								match(LITERAL_like);
								prior_plsql_expression();
								astFactory.addASTChild(currentAST, returnAST);
								{
								switch ( LA(1)) {
								case LITERAL_escape:
								{
									e = LT(1);
									e_AST = astFactory.create(e);
									astFactory.addASTChild(currentAST, e_AST);
									match(LITERAL_escape);
									q = LT(1);
									q_AST = astFactory.create(q);
									astFactory.addASTChild(currentAST, q_AST);
									match(QUOTED_STRING);
									break;
								}
								case SEMI:
								case LITERAL_or:
								case COMMA:
								case CLOSE_PAREN:
								case LITERAL_for:
								case LITERAL_then:
								case LITERAL_and:
								case LITERAL_using:
								case LITERAL_union:
								case LITERAL_intersect:
								case LITERAL_minus:
								case LITERAL_right:
								case LITERAL_inner:
								case LITERAL_where:
								case 230:
								case LITERAL_start:
								case LITERAL_connect:
								case LITERAL_group:
								case LITERAL_having:
								case LITERAL_order:
								{
									break;
								}
								default:
								{
									throw new NoViableAltException(LT(1), getFilename());
								}
								}
								}
								}
								logical_factor_AST = (AST)currentAST.root;
							}
							else {
								boolean synPredMatched497 = false;
								if (((_tokenSet_164.member(LA(1))) && (_tokenSet_231.member(LA(2))) && (_tokenSet_232.member(LA(3))) && (_tokenSet_233.member(LA(4))))) {
									int _m497 = mark();
									synPredMatched497 = true;
									inputState.guessing++;
									try {
										{
										prior_plsql_expression();
										{
										switch ( LA(1)) {
										case LITERAL_not:
										{
											match(LITERAL_not);
											break;
										}
										case LITERAL_between:
										{
											break;
										}
										default:
										{
											throw new NoViableAltException(LT(1), getFilename());
										}
										}
										}
										match(LITERAL_between);
										}
									}
									catch (RecognitionException pe) {
										synPredMatched497 = false;
									}
									rewind(_m497);
									inputState.guessing--;
								}
								if ( synPredMatched497 ) {
									{
									prior_plsql_expression();
									astFactory.addASTChild(currentAST, returnAST);
									{
									switch ( LA(1)) {
									case LITERAL_not:
									{
										n2 = LT(1);
										n2_AST = astFactory.create(n2);
										astFactory.addASTChild(currentAST, n2_AST);
										match(LITERAL_not);
										break;
									}
									case LITERAL_between:
									{
										break;
									}
									default:
									{
										throw new NoViableAltException(LT(1), getFilename());
									}
									}
									}
									b = LT(1);
									b_AST = astFactory.create(b);
									astFactory.makeASTRoot(currentAST, b_AST);
									match(LITERAL_between);
									prior_plsql_expression();
									astFactory.addASTChild(currentAST, returnAST);
									a = LT(1);
									a_AST = astFactory.create(a);
									match(LITERAL_and);
									prior_plsql_expression();
									astFactory.addASTChild(currentAST, returnAST);
									}
									logical_factor_AST = (AST)currentAST.root;
								}
								else if ((_tokenSet_164.member(LA(1))) && (_tokenSet_234.member(LA(2))) && (_tokenSet_235.member(LA(3))) && (_tokenSet_225.member(LA(4)))) {
									{
									prior_plsql_expression();
									astFactory.addASTChild(currentAST, returnAST);
									i2 = LT(1);
									i2_AST = astFactory.create(i2);
									astFactory.addASTChild(currentAST, i2_AST);
									match(LITERAL_is);
									{
									switch ( LA(1)) {
									case LITERAL_not:
									{
										n3 = LT(1);
										n3_AST = astFactory.create(n3);
										astFactory.addASTChild(currentAST, n3_AST);
										match(LITERAL_not);
										break;
									}
									case LITERAL_null:
									{
										break;
									}
									default:
									{
										throw new NoViableAltException(LT(1), getFilename());
									}
									}
									}
									n4 = LT(1);
									n4_AST = astFactory.create(n4);
									astFactory.addASTChild(currentAST, n4_AST);
									match(LITERAL_null);
									}
									logical_factor_AST = (AST)currentAST.root;
								}
								else {
									throw new NoViableAltException(LT(1), getFilename());
								}
								}}}}}
							}
							catch (RecognitionException ex) {
								if (inputState.guessing==0) {
									reportError(ex);
									recover(ex,_tokenSet_221);
								} else {
								  throw ex;
								}
							}
							returnAST = logical_factor_AST;
						}
						
	public final void prior_plsql_expression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST prior_plsql_expression_AST = null;
		Token  p1 = null;
		AST p1_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_prior:
			{
				p1 = LT(1);
				p1_AST = astFactory.create(p1);
				astFactory.addASTChild(currentAST, p1_AST);
				match(LITERAL_prior);
				break;
			}
			case LITERAL_replace:
			case LITERAL_null:
			case OPEN_PAREN:
			case LITERAL_open:
			case NUMBER:
			case PLUS:
			case MINUS:
			case LITERAL_true:
			case LITERAL_false:
			case LITERAL_cast:
			case LITERAL_trim:
			case LITERAL_count:
			case LITERAL_case:
			case LITERAL_all:
			case LITERAL_any:
			case QUOTED_STRING:
			case LITERAL_intersect:
			case LITERAL_abs:
			case LITERAL_ascii:
			case LITERAL_ceil:
			case LITERAL_floor:
			case LITERAL_instr:
			case LITERAL_length:
			case LITERAL_mod:
			case LITERAL_power:
			case LITERAL_round:
			case LITERAL_sign:
			case LITERAL_sqrt:
			case LITERAL_trunc:
			case LITERAL_chr:
			case LITERAL_concat:
			case LITERAL_initcap:
			case LITERAL_lower:
			case LITERAL_lpad:
			case LITERAL_ltrim:
			case LITERAL_rpad:
			case LITERAL_rtrim:
			case LITERAL_soundex:
			case LITERAL_substr:
			case LITERAL_translate:
			case LITERAL_upper:
			case LITERAL_avg:
			case LITERAL_max:
			case LITERAL_min:
			case LITERAL_stddev:
			case LITERAL_sum:
			case LITERAL_variance:
			case LITERAL_chartorowid:
			case LITERAL_convert:
			case LITERAL_hextoraw:
			case LITERAL_rawtohex:
			case LITERAL_rowidtochar:
			case LITERAL_to_char:
			case LITERAL_to_date:
			case LITERAL_to_number:
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_uid:
			case LITERAL_userenv:
			case LITERAL_vsize:
			case LITERAL_user:
			case LITERAL_sysdate:
			case IDENTIFIER:
			case DOUBLE_QUOTED_STRING:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			plsql_expression();
			astFactory.addASTChild(currentAST, returnAST);
			prior_plsql_expression_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_236);
			} else {
			  throw ex;
			}
		}
		returnAST = prior_plsql_expression_AST;
	}
	
	public final void exp_set() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exp_set_AST = null;
		Token  b = null;
		AST b_AST = null;
		Token  cp = null;
		AST cp_AST = null;
		
		try {      // for error handling
			boolean synPredMatched507 = false;
			if (((LA(1)==OPEN_PAREN) && (LA(2)==OPEN_PAREN||LA(2)==LITERAL_with||LA(2)==LITERAL_select) && (_tokenSet_18.member(LA(3))) && (_tokenSet_19.member(LA(4))))) {
				int _m507 = mark();
				synPredMatched507 = true;
				inputState.guessing++;
				try {
					{
					match(OPEN_PAREN);
					match(LITERAL_select);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched507 = false;
				}
				rewind(_m507);
				inputState.guessing--;
			}
			if ( synPredMatched507 ) {
				subquery();
				astFactory.addASTChild(currentAST, returnAST);
				exp_set_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==OPEN_PAREN) && (_tokenSet_20.member(LA(2))) && (_tokenSet_159.member(LA(3))) && (_tokenSet_237.member(LA(4)))) {
				b = LT(1);
				b_AST = astFactory.create(b);
				astFactory.addASTChild(currentAST, b_AST);
				match(OPEN_PAREN);
				plsql_exp_list();
				astFactory.addASTChild(currentAST, returnAST);
				cp = LT(1);
				cp_AST = astFactory.create(cp);
				match(CLOSE_PAREN);
				exp_set_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_20.member(LA(1))) && (_tokenSet_238.member(LA(2))) && (_tokenSet_239.member(LA(3))) && (_tokenSet_167.member(LA(4)))) {
				plsql_expression();
				astFactory.addASTChild(currentAST, returnAST);
				exp_set_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_221);
			} else {
			  throw ex;
			}
		}
		returnAST = exp_set_AST;
	}
	
	public final void sorted_def() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST sorted_def_AST = null;
		Token  a = null;
		AST a_AST = null;
		Token  d = null;
		AST d_AST = null;
		
		try {      // for error handling
			plsql_expression();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_asc:
			{
				a = LT(1);
				a_AST = astFactory.create(a);
				astFactory.addASTChild(currentAST, a_AST);
				match(LITERAL_asc);
				break;
			}
			case LITERAL_desc:
			{
				d = LT(1);
				d_AST = astFactory.create(d);
				astFactory.addASTChild(currentAST, d_AST);
				match(LITERAL_desc);
				break;
			}
			case SEMI:
			case COMMA:
			case CLOSE_PAREN:
			case LITERAL_for:
			case LITERAL_using:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			sorted_def_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_240);
			} else {
			  throw ex;
			}
		}
		returnAST = sorted_def_AST;
	}
	
	public final void subquery_update() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subquery_update_AST = null;
		Token  u = null;
		AST u_AST = null;
		Token  s = null;
		AST s_AST = null;
		Token  o = null;
		AST o_AST = null;
		Token  c = null;
		AST c_AST = null;
		Token  cp = null;
		AST cp_AST = null;
		Token  e = null;
		AST e_AST = null;
		Token  w = null;
		AST w_AST = null;
		
		try {      // for error handling
			u = LT(1);
			u_AST = astFactory.create(u);
			astFactory.addASTChild(currentAST, u_AST);
			match(LITERAL_update);
			table_alias();
			astFactory.addASTChild(currentAST, returnAST);
			s = LT(1);
			s_AST = astFactory.create(s);
			astFactory.addASTChild(currentAST, s_AST);
			match(LITERAL_set);
			o = LT(1);
			o_AST = astFactory.create(o);
			match(OPEN_PAREN);
			column_spec();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop544:
			do {
				if ((LA(1)==COMMA)) {
					c = LT(1);
					c_AST = astFactory.create(c);
					astFactory.addASTChild(currentAST, c_AST);
					match(COMMA);
					column_spec();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop544;
				}
				
			} while (true);
			}
			cp = LT(1);
			cp_AST = astFactory.create(cp);
			match(CLOSE_PAREN);
			e = LT(1);
			e_AST = astFactory.create(e);
			astFactory.addASTChild(currentAST, e_AST);
			match(EQ);
			subquery();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_where:
			{
				w = LT(1);
				w_AST = astFactory.create(w);
				astFactory.addASTChild(currentAST, w_AST);
				match(LITERAL_where);
				condition();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			subquery_update_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = subquery_update_AST;
	}
	
	public final void simple_update() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST simple_update_AST = null;
		Token  u = null;
		AST u_AST = null;
		Token  s = null;
		AST s_AST = null;
		Token  e1 = null;
		AST e1_AST = null;
		Token  c = null;
		AST c_AST = null;
		Token  e2 = null;
		AST e2_AST = null;
		Token  w = null;
		AST w_AST = null;
		
		try {      // for error handling
			u = LT(1);
			u_AST = astFactory.create(u);
			astFactory.addASTChild(currentAST, u_AST);
			match(LITERAL_update);
			table_alias();
			astFactory.addASTChild(currentAST, returnAST);
			s = LT(1);
			s_AST = astFactory.create(s);
			astFactory.addASTChild(currentAST, s_AST);
			match(LITERAL_set);
			column_spec();
			astFactory.addASTChild(currentAST, returnAST);
			e1 = LT(1);
			e1_AST = astFactory.create(e1);
			astFactory.addASTChild(currentAST, e1_AST);
			match(EQ);
			plsql_expression();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop537:
			do {
				if ((LA(1)==COMMA)) {
					c = LT(1);
					c_AST = astFactory.create(c);
					astFactory.addASTChild(currentAST, c_AST);
					match(COMMA);
					column_spec();
					astFactory.addASTChild(currentAST, returnAST);
					e2 = LT(1);
					e2_AST = astFactory.create(e2);
					astFactory.addASTChild(currentAST, e2_AST);
					match(EQ);
					plsql_expression();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop537;
				}
				
			} while (true);
			}
			{
			switch ( LA(1)) {
			case LITERAL_where:
			{
				w = LT(1);
				w_AST = astFactory.create(w);
				astFactory.addASTChild(currentAST, w_AST);
				match(LITERAL_where);
				condition();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			simple_update_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_96);
			} else {
			  throw ex;
			}
		}
		returnAST = simple_update_AST;
	}
	
	public final void lock_mode() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST lock_mode_AST = null;
		Token  r1 = null;
		AST r1_AST = null;
		Token  s1 = null;
		AST s1_AST = null;
		Token  r2 = null;
		AST r2_AST = null;
		Token  e1 = null;
		AST e1_AST = null;
		Token  s2 = null;
		AST s2_AST = null;
		Token  u = null;
		AST u_AST = null;
		Token  s3 = null;
		AST s3_AST = null;
		Token  s4 = null;
		AST s4_AST = null;
		Token  r3 = null;
		AST r3_AST = null;
		Token  e2 = null;
		AST e2_AST = null;
		Token  e3 = null;
		AST e3_AST = null;
		
		try {      // for error handling
			if ((LA(1)==LITERAL_row) && (LA(2)==LITERAL_share)) {
				r1 = LT(1);
				r1_AST = astFactory.create(r1);
				astFactory.addASTChild(currentAST, r1_AST);
				match(LITERAL_row);
				s1 = LT(1);
				s1_AST = astFactory.create(s1);
				astFactory.addASTChild(currentAST, s1_AST);
				match(LITERAL_share);
				lock_mode_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==LITERAL_row) && (LA(2)==LITERAL_exclusive)) {
				r2 = LT(1);
				r2_AST = astFactory.create(r2);
				astFactory.addASTChild(currentAST, r2_AST);
				match(LITERAL_row);
				e1 = LT(1);
				e1_AST = astFactory.create(e1);
				astFactory.addASTChild(currentAST, e1_AST);
				match(LITERAL_exclusive);
				lock_mode_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==LITERAL_share) && (LA(2)==LITERAL_update)) {
				s2 = LT(1);
				s2_AST = astFactory.create(s2);
				astFactory.addASTChild(currentAST, s2_AST);
				match(LITERAL_share);
				u = LT(1);
				u_AST = astFactory.create(u);
				astFactory.addASTChild(currentAST, u_AST);
				match(LITERAL_update);
				lock_mode_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==LITERAL_share) && (LA(2)==LITERAL_mode)) {
				s3 = LT(1);
				s3_AST = astFactory.create(s3);
				astFactory.addASTChild(currentAST, s3_AST);
				match(LITERAL_share);
				lock_mode_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==LITERAL_share) && (LA(2)==LITERAL_row)) {
				s4 = LT(1);
				s4_AST = astFactory.create(s4);
				astFactory.addASTChild(currentAST, s4_AST);
				match(LITERAL_share);
				r3 = LT(1);
				r3_AST = astFactory.create(r3);
				astFactory.addASTChild(currentAST, r3_AST);
				match(LITERAL_row);
				e2 = LT(1);
				e2_AST = astFactory.create(e2);
				astFactory.addASTChild(currentAST, e2_AST);
				match(LITERAL_exclusive);
				lock_mode_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==LITERAL_exclusive)) {
				e3 = LT(1);
				e3_AST = astFactory.create(e3);
				astFactory.addASTChild(currentAST, e3_AST);
				match(LITERAL_exclusive);
				lock_mode_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_241);
			} else {
			  throw ex;
			}
		}
		returnAST = lock_mode_AST;
	}
	
	public final CommonToken  savepoint_name() throws RecognitionException, TokenStreamException {
		 CommonToken sn = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST savepoint_name_AST = null;
		
		try {      // for error handling
			sn=identifier();
			astFactory.addASTChild(currentAST, returnAST);
			savepoint_name_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_242);
			} else {
			  throw ex;
			}
		}
		returnAST = savepoint_name_AST;
		return sn;
	}
	
	public final CommonToken  keyword() throws RecognitionException, TokenStreamException {
		 CommonToken k = null ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST keyword_AST = null;
		Token  a1 = null;
		AST a1_AST = null;
		Token  a2 = null;
		AST a2_AST = null;
		Token  c1 = null;
		AST c1_AST = null;
		Token  c2 = null;
		AST c2_AST = null;
		Token  c3 = null;
		AST c3_AST = null;
		Token  c4 = null;
		AST c4_AST = null;
		Token  c5 = null;
		AST c5_AST = null;
		Token  c6 = null;
		AST c6_AST = null;
		Token  d1 = null;
		AST d1_AST = null;
		Token  d2 = null;
		AST d2_AST = null;
		Token  f = null;
		AST f_AST = null;
		Token  g = null;
		AST g_AST = null;
		Token  h = null;
		AST h_AST = null;
		Token  i1 = null;
		AST i1_AST = null;
		Token  i2 = null;
		AST i2_AST = null;
		Token  i3 = null;
		AST i3_AST = null;
		Token  l4 = null;
		AST l4_AST = null;
		Token  l5 = null;
		AST l5_AST = null;
		Token  l6 = null;
		AST l6_AST = null;
		Token  l7 = null;
		AST l7_AST = null;
		Token  l8 = null;
		AST l8_AST = null;
		Token  n = null;
		AST n_AST = null;
		Token  p = null;
		AST p_AST = null;
		Token  r1 = null;
		AST r1_AST = null;
		Token  r2 = null;
		AST r2_AST = null;
		Token  s1 = null;
		AST s1_AST = null;
		Token  s2 = null;
		AST s2_AST = null;
		Token  s3 = null;
		AST s3_AST = null;
		Token  s5 = null;
		AST s5_AST = null;
		Token  s7 = null;
		AST s7_AST = null;
		Token  t1 = null;
		AST t1_AST = null;
		Token  t2 = null;
		AST t2_AST = null;
		Token  t3 = null;
		AST t3_AST = null;
		Token  t4 = null;
		AST t4_AST = null;
		Token  t5 = null;
		AST t5_AST = null;
		Token  u1 = null;
		AST u1_AST = null;
		Token  u2 = null;
		AST u2_AST = null;
		Token  u3 = null;
		AST u3_AST = null;
		Token  v = null;
		AST v_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_abs:
			{
				a1 = LT(1);
				a1_AST = astFactory.create(a1);
				astFactory.addASTChild(currentAST, a1_AST);
				match(LITERAL_abs);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) a1;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_ascii:
			{
				a2 = LT(1);
				a2_AST = astFactory.create(a2);
				astFactory.addASTChild(currentAST, a2_AST);
				match(LITERAL_ascii);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) a2;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_ceil:
			{
				c1 = LT(1);
				c1_AST = astFactory.create(c1);
				astFactory.addASTChild(currentAST, c1_AST);
				match(LITERAL_ceil);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) c1;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_chartorowid:
			{
				c2 = LT(1);
				c2_AST = astFactory.create(c2);
				astFactory.addASTChild(currentAST, c2_AST);
				match(LITERAL_chartorowid);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) c2;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_chr:
			{
				c3 = LT(1);
				c3_AST = astFactory.create(c3);
				astFactory.addASTChild(currentAST, c3_AST);
				match(LITERAL_chr);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) c3;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_concat:
			{
				c4 = LT(1);
				c4_AST = astFactory.create(c4);
				astFactory.addASTChild(currentAST, c4_AST);
				match(LITERAL_concat);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) c4;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_convert:
			{
				c5 = LT(1);
				c5_AST = astFactory.create(c5);
				astFactory.addASTChild(currentAST, c5_AST);
				match(LITERAL_convert);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) c5;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_count:
			{
				c6 = LT(1);
				c6_AST = astFactory.create(c6);
				astFactory.addASTChild(currentAST, c6_AST);
				match(LITERAL_count);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) c6;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_decode:
			{
				d1 = LT(1);
				d1_AST = astFactory.create(d1);
				astFactory.addASTChild(currentAST, d1_AST);
				match(LITERAL_decode);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) d1;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_dump:
			{
				d2 = LT(1);
				d2_AST = astFactory.create(d2);
				astFactory.addASTChild(currentAST, d2_AST);
				match(LITERAL_dump);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) d2;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_floor:
			{
				f = LT(1);
				f_AST = astFactory.create(f);
				astFactory.addASTChild(currentAST, f_AST);
				match(LITERAL_floor);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) f;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_greatest:
			{
				g = LT(1);
				g_AST = astFactory.create(g);
				astFactory.addASTChild(currentAST, g_AST);
				match(LITERAL_greatest);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) g;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_hextoraw:
			{
				h = LT(1);
				h_AST = astFactory.create(h);
				astFactory.addASTChild(currentAST, h_AST);
				match(LITERAL_hextoraw);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) h;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_initcap:
			{
				i1 = LT(1);
				i1_AST = astFactory.create(i1);
				astFactory.addASTChild(currentAST, i1_AST);
				match(LITERAL_initcap);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) i1;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_instr:
			{
				i2 = LT(1);
				i2_AST = astFactory.create(i2);
				astFactory.addASTChild(currentAST, i2_AST);
				match(LITERAL_instr);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) i2;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_intersect:
			{
				i3 = LT(1);
				i3_AST = astFactory.create(i3);
				astFactory.addASTChild(currentAST, i3_AST);
				match(LITERAL_intersect);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) i3;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_least:
			{
				l4 = LT(1);
				l4_AST = astFactory.create(l4);
				astFactory.addASTChild(currentAST, l4_AST);
				match(LITERAL_least);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) l4;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_length:
			{
				l5 = LT(1);
				l5_AST = astFactory.create(l5);
				astFactory.addASTChild(currentAST, l5_AST);
				match(LITERAL_length);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) l5;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_lower:
			{
				l6 = LT(1);
				l6_AST = astFactory.create(l6);
				astFactory.addASTChild(currentAST, l6_AST);
				match(LITERAL_lower);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) l6;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_lpad:
			{
				l7 = LT(1);
				l7_AST = astFactory.create(l7);
				astFactory.addASTChild(currentAST, l7_AST);
				match(LITERAL_lpad);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) l7;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_ltrim:
			{
				l8 = LT(1);
				l8_AST = astFactory.create(l8);
				astFactory.addASTChild(currentAST, l8_AST);
				match(LITERAL_ltrim);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) l8;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_nvl:
			{
				n = LT(1);
				n_AST = astFactory.create(n);
				astFactory.addASTChild(currentAST, n_AST);
				match(LITERAL_nvl);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) n;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_power:
			{
				p = LT(1);
				p_AST = astFactory.create(p);
				astFactory.addASTChild(currentAST, p_AST);
				match(LITERAL_power);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) p;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_rawtohex:
			{
				r1 = LT(1);
				r1_AST = astFactory.create(r1);
				astFactory.addASTChild(currentAST, r1_AST);
				match(LITERAL_rawtohex);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) r1;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_replace:
			{
				r2 = LT(1);
				r2_AST = astFactory.create(r2);
				astFactory.addASTChild(currentAST, r2_AST);
				match(LITERAL_replace);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) r2;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_sign:
			{
				s1 = LT(1);
				s1_AST = astFactory.create(s1);
				astFactory.addASTChild(currentAST, s1_AST);
				match(LITERAL_sign);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) s1;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_soundex:
			{
				s2 = LT(1);
				s2_AST = astFactory.create(s2);
				astFactory.addASTChild(currentAST, s2_AST);
				match(LITERAL_soundex);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) s2;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_sqrt:
			{
				s3 = LT(1);
				s3_AST = astFactory.create(s3);
				astFactory.addASTChild(currentAST, s3_AST);
				match(LITERAL_sqrt);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) s3;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_substr:
			{
				s5 = LT(1);
				s5_AST = astFactory.create(s5);
				astFactory.addASTChild(currentAST, s5_AST);
				match(LITERAL_substr);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) s5;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_sysdate:
			{
				s7 = LT(1);
				s7_AST = astFactory.create(s7);
				astFactory.addASTChild(currentAST, s7_AST);
				match(LITERAL_sysdate);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) s7;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_to_char:
			{
				t1 = LT(1);
				t1_AST = astFactory.create(t1);
				astFactory.addASTChild(currentAST, t1_AST);
				match(LITERAL_to_char);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) t1;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_to_date:
			{
				t2 = LT(1);
				t2_AST = astFactory.create(t2);
				astFactory.addASTChild(currentAST, t2_AST);
				match(LITERAL_to_date);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) t2;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_to_number:
			{
				t3 = LT(1);
				t3_AST = astFactory.create(t3);
				astFactory.addASTChild(currentAST, t3_AST);
				match(LITERAL_to_number);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) t2;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_translate:
			{
				t4 = LT(1);
				t4_AST = astFactory.create(t4);
				astFactory.addASTChild(currentAST, t4_AST);
				match(LITERAL_translate);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) t4;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_trunc:
			{
				t5 = LT(1);
				t5_AST = astFactory.create(t5);
				astFactory.addASTChild(currentAST, t5_AST);
				match(LITERAL_trunc);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) t5;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_upper:
			{
				u1 = LT(1);
				u1_AST = astFactory.create(u1);
				astFactory.addASTChild(currentAST, u1_AST);
				match(LITERAL_upper);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) u1;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_user:
			{
				u2 = LT(1);
				u2_AST = astFactory.create(u2);
				astFactory.addASTChild(currentAST, u2_AST);
				match(LITERAL_user);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) u2;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_userenv:
			{
				u3 = LT(1);
				u3_AST = astFactory.create(u3);
				astFactory.addASTChild(currentAST, u3_AST);
				match(LITERAL_userenv);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) u3;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_vsize:
			{
				v = LT(1);
				v_AST = astFactory.create(v);
				astFactory.addASTChild(currentAST, v_AST);
				match(LITERAL_vsize);
				if ( inputState.guessing==0 ) {
					
					k = (CommonToken) v;
					
				}
				keyword_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_11);
			} else {
			  throw ex;
			}
		}
		returnAST = keyword_AST;
		return k;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"START_RULE",
		"CREATE_PACKAGE",
		"PACKAGE_SPEC",
		"PACKAGE_BODY",
		"PACKAGE_OBJ_BODY",
		"SELECT_EXPRESSION",
		"PLSQL_BLOCK",
		"CURSOR_DECLARATION",
		"PROCEDURE_BODY",
		"FUNCTION_BODY",
		"PARAMETER_SPEC",
		"SQL_STATEMENT",
		"IF_STATEMENT",
		"LOOP_STATEMENT",
		"STATEMENT",
		"SELECT_COMMAND",
		"SELECT_LIST",
		"TABLE_REFERENCE_LIST",
		"WHERE_CONDITION",
		"SUBQUERY",
		"SQL_IDENTIFIER",
		"SQL_LITERAL",
		"FUNCTION",
		"GROUP_FUNCTION",
		"USER_FUNCTION",
		"MULTIPLY",
		"ARGUMENT",
		"DIVIDE",
		"\"set\"",
		"\"show\"",
		"SEMI",
		"\"create\"",
		"\"or\"",
		"\"replace\"",
		"\"package\"",
		"\"authid\"",
		"\"is\"",
		"\"as\"",
		"\"end\"",
		"\"body\"",
		"DOT",
		"\"language\"",
		"\"java\"",
		"\"name\"",
		"\"constant\"",
		"\"not\"",
		"\"null\"",
		"ASSIGNMENT_EQ",
		"\"default\"",
		"\"subtype\"",
		"\"cursor\"",
		"OPEN_PAREN",
		"COMMA",
		"CLOSE_PAREN",
		"START_LABEL",
		"END_LABEL",
		"\"begin\"",
		"\"declare \"",
		"\"loop\"",
		"\"for\"",
		"\"while\"",
		"\"forall\"",
		"\"if\"",
		"\"goto\"",
		"\"raise\"",
		"\"exit\"",
		"\"return\"",
		"\"with\"",
		"\"select\"",
		"\"update\"",
		"\"insert\"",
		"\"delete\"",
		"\"alter\"",
		"\"lock\"",
		"\"grant\"",
		"\"execute\"",
		"\"commit\"",
		"\"rollback\"",
		"\"open\"",
		"\"fetch\"",
		"\"close\"",
		"\"first\"",
		"\"last\"",
		"COLON",
		"\"when\"",
		"\"binary_integer\"",
		"\"natural\"",
		"\"positive\"",
		"\"number\"",
		"NUMBER",
		"\"char\"",
		"\"long\"",
		"\"raw\"",
		"\"boolean\"",
		"\"date\"",
		"\"smallint\"",
		"\"real\"",
		"\"numeric\"",
		"\"int\"",
		"\"integer\"",
		"\"double precision\"",
		"\"decimal\"",
		"\"varchar2\"",
		"\"varchar\"",
		"\"character\"",
		"\"mlslabel\"",
		"PERCENTAGE",
		"\"type\"",
		"\"rowtype\"",
		"\"in\"",
		"\"out\"",
		"\"exception\"",
		"\"pragma\"",
		"\"exception_init\"",
		"PLUS",
		"MINUS",
		"\"record\"",
		"\"ref\"",
		"\"varray\"",
		"\"of\"",
		"\"table\"",
		"\"index\"",
		"\"by\"",
		"\"procedure\"",
		"\"declare\"",
		"\"then\"",
		"\"function\"",
		"OUTER_JOIN",
		"DOUBLEDOT",
		"\"and\"",
		"\"like\"",
		"\"between\"",
		"\"notfound\"",
		"\"found\"",
		"\"isopen\"",
		"\"true\"",
		"\"false\"",
		"\"reverse\"",
		"ASTERISK",
		"\"**\"",
		"CONCAT",
		"\"cast\"",
		"\"trim\"",
		"\"count\"",
		"\"case\"",
		"\"all\"",
		"\"any\"",
		"\"%rowcount\"",
		"\"distinct\"",
		"QUOTED_STRING",
		"\"work\"",
		"\"else\"",
		"\"elsif\"",
		"\"immediate\"",
		"\"bulk\"",
		"\"collect\"",
		"\"into\"",
		"\"using\"",
		"\"system\"",
		"\"session\"",
		"\"flush\"",
		"\"shared_pool\"",
		"EQ",
		"\"reset\"",
		"\"sid\"",
		"\"union\"",
		"\"intersect\"",
		"\"minus\"",
		"\"from\"",
		"\"left\"",
		"\"right\"",
		"\"inner\"",
		"\"where\"",
		"PASS_BY_NAME",
		"\"abs\"",
		"\"ascii\"",
		"\"ceil\"",
		"\"floor\"",
		"\"instr\"",
		"\"length\"",
		"\"mod\"",
		"\"power\"",
		"\"round\"",
		"\"sign\"",
		"\"sqrt\"",
		"\"trunc\"",
		"\"chr\"",
		"\"concat\"",
		"\"initcap\"",
		"\"lower\"",
		"\"lpad\"",
		"\"ltrim\"",
		"\"rpad\"",
		"\"rtrim\"",
		"\"soundex\"",
		"\"substr\"",
		"\"translate\"",
		"\"upper\"",
		"\"avg\"",
		"\"max\"",
		"\"min\"",
		"\"stddev\"",
		"\"sum\"",
		"\"variance\"",
		"\"chartorowid\"",
		"\"convert\"",
		"\"hextoraw\"",
		"\"rawtohex\"",
		"\"rowidtochar\"",
		"\"to_char\"",
		"\"to_date\"",
		"\"to_number\"",
		"\"decode\"",
		"\"dump\"",
		"\"greatest\"",
		"\"least\"",
		"\"nvl\"",
		"\"uid\"",
		"\"userenv\"",
		"\"vsize\"",
		"\"leading\"",
		"\"trailing\"",
		"\"both\"",
		"\"user\"",
		"\"sysdate\"",
		"\"the\"",
		"\"left \"",
		"\"outer\"",
		"\"join\"",
		"\"on\"",
		"AT_SIGN",
		"\"exists\"",
		"\"escape\"",
		"\"prior\"",
		"LT",
		"GT",
		"NOT_EQ",
		"LE",
		"GE",
		"\"start\"",
		"\"connect\"",
		"\"group\"",
		"\"having\"",
		"\"order\"",
		"\"asc\"",
		"\"desc\"",
		"\"nowait\"",
		"\"values\"",
		"\"transaction\"",
		"\"read\"",
		"\"only\"",
		"\"mode\"",
		"\"row\"",
		"\"share\"",
		"\"exclusive\"",
		"\"to\"",
		"\"savepoint\"",
		"\"comment\"",
		"IDENTIFIER",
		"DOUBLE_QUOTED_STRING",
		"ANY_CHARACTER",
		"VERTBAR",
		"N",
		"WS",
		"SL_COMMENT",
		"ML_COMMENT"
	};
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = new long[10];
		data[0]=137438953472L;
		data[2]=-361409472049446912L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 21440476741632L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = new long[10];
		data[0]=27021735203176448L;
		data[1]=-9223231299366420480L;
		data[2]=-361409472049446908L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = new long[10];
		data[0]=8933531975680L;
		data[2]=-361409472049446912L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = new long[10];
		data[0]=21028159881216L;
		data[2]=-361409472049446912L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = new long[10];
		data[0]=1179964130530951168L;
		data[1]=-9223231299366420480L;
		data[2]=-361409472049446907L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 1152921553998970882L, 0L, 1L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = new long[10];
		data[0]=37154834364760064L;
		data[1]=537133056L;
		data[2]=-1121501818513408L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = new long[10];
		data[0]=27021735203176448L;
		data[1]=-9218727699739049984L;
		data[2]=-361409472049446908L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 1152921571178840066L, 0L, 1L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = new long[10];
		data[0]=-2333119970700951550L;
		data[1]=2363967591889747967L;
		data[2]=-35994862626565L;
		data[3]=1152875707370569727L;
		data[4]=240L;
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = new long[10];
		data[0]=37154834364760064L;
		data[1]=54043196065579008L;
		data[2]=-1121501801719808L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = new long[10];
		data[0]=181287616774144000L;
		data[1]=54043196082356608L;
		data[2]=-1121501810010104L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = new long[10];
		data[0]=36028934457917440L;
		data[2]=-361409472049446912L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	private static final long[] mk_tokenSet_15() {
		long[] data = { 36028797018963968L, 384L, 8388608L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	private static final long[] mk_tokenSet_16() {
		long[] data = new long[10];
		data[0]=-3198110716074655742L;
		data[1]=54606146035777920L;
		data[2]=-600044319287053L;
		data[3]=288177981845667839L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());
	private static final long[] mk_tokenSet_17() {
		long[] data = new long[10];
		data[0]=-2882840875094769662L;
		data[1]=-2820660741632180225L;
		data[2]=-600041894979329L;
		data[3]=288225948040429567L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());
	private static final long[] mk_tokenSet_18() {
		long[] data = new long[10];
		data[0]=37157033388015616L;
		data[1]=54043196065579392L;
		data[2]=-1121501801719808L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());
	private static final long[] mk_tokenSet_19() {
		long[] data = new long[10];
		data[0]=109232221759471616L;
		data[1]=54043196082356608L;
		data[2]=-1103904238479352L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());
	private static final long[] mk_tokenSet_20() {
		long[] data = new long[10];
		data[0]=37154834364760064L;
		data[1]=54043196065579008L;
		data[2]=-1121501818513408L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());
	private static final long[] mk_tokenSet_21() {
		long[] data = new long[10];
		data[0]=-3198093123888611326L;
		data[1]=54676514215823744L;
		data[2]=-600044310898437L;
		data[3]=288221992375549951L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_21 = new BitSet(mk_tokenSet_21());
	private static final long[] mk_tokenSet_22() {
		long[] data = new long[10];
		data[0]=-3198110716074655742L;
		data[1]=54606146035777536L;
		data[2]=-600044336064269L;
		data[3]=288177981845667839L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_22 = new BitSet(mk_tokenSet_22());
	private static final long[] mk_tokenSet_23() {
		long[] data = new long[10];
		data[0]=-2882840875094769662L;
		data[1]=-2820660741632180225L;
		data[2]=-600041911756545L;
		data[3]=288225948040429567L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_23 = new BitSet(mk_tokenSet_23());
	private static final long[] mk_tokenSet_24() {
		long[] data = new long[10];
		data[0]=-2882515419652947966L;
		data[1]=-2810527642464305153L;
		data[2]=-37039797968897L;
		data[3]=1729382256910270463L;
		data[4]=255L;
		return data;
	}
	public static final BitSet _tokenSet_24 = new BitSet(mk_tokenSet_24());
	private static final long[] mk_tokenSet_25() {
		long[] data = new long[10];
		data[0]=137438953472L;
		data[1]=262144L;
		data[2]=-1121501859807232L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_25 = new BitSet(mk_tokenSet_25());
	private static final long[] mk_tokenSet_26() {
		long[] data = new long[10];
		data[0]=-3198093123888611326L;
		data[1]=54606146035777536L;
		data[2]=-600044336064261L;
		data[3]=288177981845667839L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_26 = new BitSet(mk_tokenSet_26());
	private static final long[] mk_tokenSet_27() {
		long[] data = new long[10];
		data[0]=-2882840875094769662L;
		data[1]=-2820660741625888769L;
		data[2]=-600041911756545L;
		data[3]=288225948040429567L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_27 = new BitSet(mk_tokenSet_27());
	private static final long[] mk_tokenSet_28() {
		long[] data = new long[10];
		data[0]=1179943239810023424L;
		data[1]=-9223231299366420480L;
		data[2]=-361409472049446907L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_28 = new BitSet(mk_tokenSet_28());
	private static final long[] mk_tokenSet_29() {
		long[] data = new long[10];
		data[0]=1179947687248658434L;
		data[1]=-9218727699739049984L;
		data[2]=-361409472049446907L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_29 = new BitSet(mk_tokenSet_29());
	private static final long[] mk_tokenSet_30() {
		long[] data = { 3865470566400L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_30 = new BitSet(mk_tokenSet_30());
	private static final long[] mk_tokenSet_31() {
		long[] data = new long[10];
		data[0]=281612415664128L;
		data[1]=70368173752320L;
		data[2]=-361409472049446912L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_31 = new BitSet(mk_tokenSet_31());
	private static final long[] mk_tokenSet_32() {
		long[] data = new long[10];
		data[0]=43364893218308096L;
		data[1]=140736917929984L;
		data[2]=-361409472049446912L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_32 = new BitSet(mk_tokenSet_32());
	private static final long[] mk_tokenSet_33() {
		long[] data = new long[10];
		data[0]=1224438293542731776L;
		data[1]=-9168836255284985856L;
		data[2]=-1121501818513403L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_33 = new BitSet(mk_tokenSet_33());
	private static final long[] mk_tokenSet_34() {
		long[] data = new long[10];
		data[0]=36028934457917440L;
		data[1]=384L;
		data[2]=-361409472049446912L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_34 = new BitSet(mk_tokenSet_34());
	private static final long[] mk_tokenSet_35() {
		long[] data = new long[10];
		data[0]=137438953472L;
		data[1]=70368173752320L;
		data[2]=-361409472049446912L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_35 = new BitSet(mk_tokenSet_35());
	private static final long[] mk_tokenSet_36() {
		long[] data = new long[10];
		data[0]=137438953472L;
		data[1]=140737488355328L;
		data[2]=-361409472049446912L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_36 = new BitSet(mk_tokenSet_36());
	private static final long[] mk_tokenSet_37() {
		long[] data = { 36047488716636160L, 70373039144960L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_37 = new BitSet(mk_tokenSet_37());
	private static final long[] mk_tokenSet_38() {
		long[] data = new long[10];
		data[0]=1236950581248L;
		data[1]=504755002523254784L;
		data[2]=-361409472049446912L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_38 = new BitSet(mk_tokenSet_38());
	private static final long[] mk_tokenSet_39() {
		long[] data = { 36047505896505344L, 4294967296L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_39 = new BitSet(mk_tokenSet_39());
	private static final long[] mk_tokenSet_40() {
		long[] data = new long[10];
		data[0]=1179948754548031488L;
		data[1]=-8070309794222702592L;
		data[2]=-361409472049446907L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_40 = new BitSet(mk_tokenSet_40());
	private static final long[] mk_tokenSet_41() {
		long[] data = new long[10];
		data[0]=1179947637856534528L;
		data[1]=-9223231299366420480L;
		data[2]=-361409472049446907L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_41 = new BitSet(mk_tokenSet_41());
	private static final long[] mk_tokenSet_42() {
		long[] data = { 36049704919760896L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_42 = new BitSet(mk_tokenSet_42());
	private static final long[] mk_tokenSet_43() {
		long[] data = new long[10];
		data[0]=1179982822228623360L;
		data[1]=-9218727699739049984L;
		data[2]=-361409472049446907L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_43 = new BitSet(mk_tokenSet_43());
	private static final long[] mk_tokenSet_44() {
		long[] data = { 36049687739891712L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_44 = new BitSet(mk_tokenSet_44());
	private static final long[] mk_tokenSet_45() {
		long[] data = new long[10];
		data[0]=1179978424182112256L;
		data[1]=-9218727699739049984L;
		data[2]=-361409472049446908L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_45 = new BitSet(mk_tokenSet_45());
	private static final long[] mk_tokenSet_46() {
		long[] data = new long[10];
		data[0]=299204601708544L;
		data[1]=2322167987437568L;
		data[2]=-361409472049446912L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_46 = new BitSet(mk_tokenSet_46());
	private static final long[] mk_tokenSet_47() {
		long[] data = new long[10];
		data[0]=43365992729935872L;
		data[1]=140736917930048L;
		data[2]=-361409472049446912L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_47 = new BitSet(mk_tokenSet_47());
	private static final long[] mk_tokenSet_48() {
		long[] data = new long[10];
		data[0]=1224439393054359552L;
		data[1]=-7509189428720172672L;
		data[2]=-1121501818513403L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_48 = new BitSet(mk_tokenSet_48());
	private static final long[] mk_tokenSet_49() {
		long[] data = { 21457656610816L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_49 = new BitSet(mk_tokenSet_49());
	private static final long[] mk_tokenSet_50() {
		long[] data = new long[10];
		data[0]=1179947637856534528L;
		data[1]=-9218727699739049984L;
		data[2]=-361409472049446907L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_50 = new BitSet(mk_tokenSet_50());
	private static final long[] mk_tokenSet_51() {
		long[] data = new long[10];
		data[0]=-3198110716074655742L;
		data[1]=54606146035777536L;
		data[2]=-598944824436493L;
		data[3]=288177981845667839L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_51 = new BitSet(mk_tokenSet_51());
	private static final long[] mk_tokenSet_52() {
		long[] data = new long[10];
		data[0]=72339223633461248L;
		data[1]=140736917929984L;
		data[2]=-360846522096025600L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_52 = new BitSet(mk_tokenSet_52());
	private static final long[] mk_tokenSet_53() {
		long[] data = { 0L, 70368173752320L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_53 = new BitSet(mk_tokenSet_53());
	private static final long[] mk_tokenSet_54() {
		long[] data = new long[10];
		data[0]=-4352158167832985600L;
		data[1]=2360449159007305728L;
		data[2]=-360888014567030542L;
		data[3]=288177981307683791L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_54 = new BitSet(mk_tokenSet_54());
	private static final long[] mk_tokenSet_55() {
		long[] data = new long[10];
		data[0]=-2882805965600587774L;
		data[1]=-514817732418486273L;
		data[2]=-600041911756553L;
		data[3]=288225948040429567L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_55 = new BitSet(mk_tokenSet_55());
	private static final long[] mk_tokenSet_56() {
		long[] data = new long[10];
		data[0]=-2882453847001792510L;
		data[1]=-2810527642464305153L;
		data[2]=-37039797968897L;
		data[3]=1729382226845499391L;
		data[4]=255L;
		return data;
	}
	public static final BitSet _tokenSet_56 = new BitSet(mk_tokenSet_56());
	private static final long[] mk_tokenSet_57() {
		long[] data = new long[10];
		data[0]=-4352140575646941184L;
		data[1]=2360449159007305728L;
		data[2]=-360888014567030542L;
		data[3]=288177981307683791L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_57 = new BitSet(mk_tokenSet_57());
	private static final long[] mk_tokenSet_58() {
		long[] data = new long[10];
		data[0]=-2882453847001792510L;
		data[1]=-504684633250611201L;
		data[2]=-37039797968897L;
		data[3]=1729382226845499391L;
		data[4]=255L;
		return data;
	}
	public static final BitSet _tokenSet_58 = new BitSet(mk_tokenSet_58());
	private static final long[] mk_tokenSet_59() {
		long[] data = new long[10];
		data[0]=-4352158167832985600L;
		data[1]=2360449154712338432L;
		data[2]=-360888014567030542L;
		data[3]=288177981307683791L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_59 = new BitSet(mk_tokenSet_59());
	private static final long[] mk_tokenSet_60() {
		long[] data = new long[10];
		data[0]=-4351014675740098560L;
		data[1]=54606146035777920L;
		data[2]=-600044327675654L;
		data[3]=288177981845667839L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_60 = new BitSet(mk_tokenSet_60());
	private static final long[] mk_tokenSet_61() {
		long[] data = new long[10];
		data[0]=-2882841149972676606L;
		data[1]=-2820660741625888769L;
		data[2]=-600041894979329L;
		data[3]=288225978105200639L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_61 = new BitSet(mk_tokenSet_61());
	private static final long[] mk_tokenSet_62() {
		long[] data = new long[10];
		data[0]=-4352158167832985600L;
		data[1]=54606145498644480L;
		data[2]=-360888014567030542L;
		data[3]=288177981307683791L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_62 = new BitSet(mk_tokenSet_62());
	private static final long[] mk_tokenSet_63() {
		long[] data = new long[10];
		data[0]=-4352140575646941184L;
		data[1]=2360519523456516096L;
		data[2]=-360888014567030542L;
		data[3]=288177981307683791L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_63 = new BitSet(mk_tokenSet_63());
	private static final long[] mk_tokenSet_64() {
		long[] data = new long[10];
		data[0]=-2882805965600587774L;
		data[1]=-2315976108389974017L;
		data[2]=-600041911756553L;
		data[3]=288225948040429567L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_64 = new BitSet(mk_tokenSet_64());
	private static final long[] mk_tokenSet_65() {
		long[] data = new long[10];
		data[0]=-4352158167832985600L;
		data[1]=2360519523456516096L;
		data[2]=-360888014567030542L;
		data[3]=288177981307683791L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_65 = new BitSet(mk_tokenSet_65());
	private static final long[] mk_tokenSet_66() {
		long[] data = { -4575656104716926976L, 70368744177728L, 13967032320L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_66 = new BitSet(mk_tokenSet_66());
	private static final long[] mk_tokenSet_67() {
		long[] data = new long[10];
		data[0]=260100610253127680L;
		data[1]=54043196082356608L;
		data[2]=-1121501810010104L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_67 = new BitSet(mk_tokenSet_67());
	private static final long[] mk_tokenSet_68() {
		long[] data = new long[10];
		data[0]=260666875921301504L;
		data[1]=54113564262402496L;
		data[2]=-1121501793232888L;
		data[3]=44117904064511L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_68 = new BitSet(mk_tokenSet_68());
	private static final long[] mk_tokenSet_69() {
		long[] data = { 222928181554839552L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_69 = new BitSet(mk_tokenSet_69());
	private static final long[] mk_tokenSet_70() {
		long[] data = new long[10];
		data[0]=37158150079512576L;
		data[1]=54043196065579072L;
		data[2]=-1121501818513408L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_70 = new BitSet(mk_tokenSet_70());
	private static final long[] mk_tokenSet_71() {
		long[] data = new long[10];
		data[0]=1440083295042797568L;
		data[1]=-9162925285622677120L;
		data[2]=-1121501810010099L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_71 = new BitSet(mk_tokenSet_71());
	private static final long[] mk_tokenSet_72() {
		long[] data = new long[10];
		data[0]=-2882489417920937984L;
		data[1]=-9152158867755384833L;
		data[2]=-1121501793232883L;
		data[3]=44117904064511L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_72 = new BitSet(mk_tokenSet_72());
	private static final long[] mk_tokenSet_73() {
		long[] data = new long[10];
		data[0]=253910359788748800L;
		data[1]=1207035068869249408L;
		data[2]=-1103902090995704L;
		data[3]=44255343017983L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_73 = new BitSet(mk_tokenSet_73());
	private static final long[] mk_tokenSet_74() {
		long[] data = { 144115205255725056L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_74 = new BitSet(mk_tokenSet_74());
	private static final long[] mk_tokenSet_75() {
		long[] data = { 3315714752512L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_75 = new BitSet(mk_tokenSet_75());
	private static final long[] mk_tokenSet_76() {
		long[] data = new long[10];
		data[0]=-3133379299009101824L;
		data[1]=2080767L;
		data[2]=-1121501859807231L;
		data[3]=107374182399L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_76 = new BitSet(mk_tokenSet_76());
	private static final long[] mk_tokenSet_77() {
		long[] data = { 4398046511104L, 2251799830462464L, 402653184L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_77 = new BitSet(mk_tokenSet_77());
	private static final long[] mk_tokenSet_78() {
		long[] data = new long[10];
		data[0]=-4611685880988434432L;
		data[1]=1L;
		data[2]=-361409472049446912L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_78 = new BitSet(mk_tokenSet_78());
	private static final long[] mk_tokenSet_79() {
		long[] data = new long[10];
		data[0]=-3132816280336203776L;
		data[1]=54043196067397631L;
		data[2]=-1121501818513375L;
		data[3]=107374182399L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_79 = new BitSet(mk_tokenSet_79());
	private static final long[] mk_tokenSet_80() {
		long[] data = new long[10];
		data[0]=-2959402386587648000L;
		data[1]=-8008877880536743937L;
		data[2]=-1103578290726673L;
		data[3]=1155103043050536959L;
		data[4]=248L;
		return data;
	}
	public static final BitSet _tokenSet_80 = new BitSet(mk_tokenSet_80());
	private static final long[] mk_tokenSet_81() {
		long[] data = new long[10];
		data[0]=-2310602565269585920L;
		data[1]=-7999800313101959169L;
		data[2]=-258525221617681L;
		data[3]=3460994598279577599L;
		data[4]=248L;
		return data;
	}
	public static final BitSet _tokenSet_81 = new BitSet(mk_tokenSet_81());
	private static final long[] mk_tokenSet_82() {
		long[] data = new long[10];
		data[0]=36028801313931264L;
		data[1]=2080640L;
		data[4]=16L;
		return data;
	}
	public static final BitSet _tokenSet_82 = new BitSet(mk_tokenSet_82());
	private static final long[] mk_tokenSet_83() {
		long[] data = new long[10];
		data[0]=37157050567884800L;
		data[1]=1206964700672426368L;
		data[2]=-1103853177120768L;
		data[3]=1152921611981029375L;
		data[4]=232L;
		return data;
	}
	public static final BitSet _tokenSet_83 = new BitSet(mk_tokenSet_83());
	private static final long[] mk_tokenSet_84() {
		long[] data = new long[10];
		data[0]=-3061297496388009984L;
		data[1]=1209216500504707071L;
		data[2]=-821801793890295L;
		data[3]=2305847652073340927L;
		data[4]=248L;
		return data;
	}
	public static final BitSet _tokenSet_84 = new BitSet(mk_tokenSet_84());
	private static final long[] mk_tokenSet_85() {
		long[] data = new long[10];
		data[0]=-2887345849111674878L;
		data[1]=-8008877881100877825L;
		data[2]=-822228539156433L;
		data[3]=6341116928727187455L;
		data[4]=248L;
		return data;
	}
	public static final BitSet _tokenSet_85 = new BitSet(mk_tokenSet_85());
	private static final long[] mk_tokenSet_86() {
		long[] data = { 38298189018693632L, 0L, 8L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_86 = new BitSet(mk_tokenSet_86());
	private static final long[] mk_tokenSet_87() {
		long[] data = new long[10];
		data[0]=183539414440345600L;
		data[1]=54043196071872512L;
		data[2]=-1121501818513408L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_87 = new BitSet(mk_tokenSet_87());
	private static final long[] mk_tokenSet_88() {
		long[] data = new long[10];
		data[0]=255597027805626368L;
		data[1]=54043196088650112L;
		data[2]=-558551856588792L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_88 = new BitSet(mk_tokenSet_88());
	private static final long[] mk_tokenSet_89() {
		long[] data = new long[10];
		data[0]=137438953472L;
		data[2]=-1121501859807232L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_89 = new BitSet(mk_tokenSet_89());
	private static final long[] mk_tokenSet_90() {
		long[] data = new long[10];
		data[0]=37154851544629248L;
		data[1]=54043196065579008L;
		data[2]=-1121501818513408L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_90 = new BitSet(mk_tokenSet_90());
	private static final long[] mk_tokenSet_91() {
		long[] data = new long[10];
		data[0]=-3061299695411265536L;
		data[1]=56294995897860095L;
		data[2]=-558551453935607L;
		data[3]=107374182399L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_91 = new BitSet(mk_tokenSet_91());
	private static final long[] mk_tokenSet_92() {
		long[] data = new long[10];
		data[0]=-2887345849111674878L;
		data[1]=-8009440831054299137L;
		data[2]=-1103852765980625L;
		data[3]=1152965622510911487L;
		data[4]=248L;
		return data;
	}
	public static final BitSet _tokenSet_92 = new BitSet(mk_tokenSet_92());
	private static final long[] mk_tokenSet_93() {
		long[] data = { 36046406384877568L, 0L, 8L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_93 = new BitSet(mk_tokenSet_93());
	private static final long[] mk_tokenSet_94() {
		long[] data = new long[10];
		data[0]=-2989242103520821248L;
		data[1]=56294995904151551L;
		data[2]=-1121501415860223L;
		data[3]=107374182399L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_94 = new BitSet(mk_tokenSet_94());
	private static final long[] mk_tokenSet_95() {
		long[] data = new long[10];
		data[0]=-2887345849111674878L;
		data[1]=-8009511199228051457L;
		data[2]=-540902812559313L;
		data[3]=1152921611981029375L;
		data[4]=248L;
		return data;
	}
	public static final BitSet _tokenSet_95 = new BitSet(mk_tokenSet_95());
	private static final long[] mk_tokenSet_96() {
		long[] data = { 17179869184L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_96 = new BitSet(mk_tokenSet_96());
	private static final long[] mk_tokenSet_97() {
		long[] data = { -4035225248944095232L, 16777217L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_97 = new BitSet(mk_tokenSet_97());
	private static final long[] mk_tokenSet_98() {
		long[] data = { 4647714815446351872L, 384L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_98 = new BitSet(mk_tokenSet_98());
	private static final long[] mk_tokenSet_99() {
		long[] data = new long[10];
		data[0]=37154834364760064L;
		data[1]=54113564239331328L;
		data[2]=-1121501818505216L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_99 = new BitSet(mk_tokenSet_99());
	private static final long[] mk_tokenSet_100() {
		long[] data = new long[10];
		data[0]=37172428698288128L;
		data[1]=54183933000286592L;
		data[2]=-1121501810010088L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_100 = new BitSet(mk_tokenSet_100());
	private static final long[] mk_tokenSet_101() {
		long[] data = new long[10];
		data[0]=-2909880339922943998L;
		data[1]=54606146037596159L;
		data[2]=-600044336064269L;
		data[3]=288177981845667839L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_101 = new BitSet(mk_tokenSet_101());
	private static final long[] mk_tokenSet_102() {
		long[] data = new long[10];
		data[0]=-2882840875094769662L;
		data[1]=-2820660741632180225L;
		data[2]=-599989751392001L;
		data[3]=1441147452647276543L;
		data[4]=248L;
		return data;
	}
	public static final BitSet _tokenSet_102 = new BitSet(mk_tokenSet_102());
	private static final long[] mk_tokenSet_103() {
		long[] data = new long[10];
		data[0]=-2909862747736899582L;
		data[1]=54606146037596159L;
		data[2]=-600044336064269L;
		data[3]=288177981845667839L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_103 = new BitSet(mk_tokenSet_103());
	private static final long[] mk_tokenSet_104() {
		long[] data = new long[10];
		data[0]=-2306054667349524478L;
		data[1]=-2810527642464305153L;
		data[2]=-36421322678273L;
		data[3]=4035225266123964415L;
		data[4]=255L;
		return data;
	}
	public static final BitSet _tokenSet_104 = new BitSet(mk_tokenSet_104());
	private static final long[] mk_tokenSet_105() {
		long[] data = new long[10];
		data[0]=-2305983748849532926L;
		data[1]=-2810246167487594497L;
		data[2]=-36283883716609L;
		data[3]=-1L;
		data[4]=255L;
		return data;
	}
	public static final BitSet _tokenSet_105 = new BitSet(mk_tokenSet_105());
	private static final long[] mk_tokenSet_106() {
		long[] data = new long[10];
		data[0]=1179943239810023424L;
		data[1]=-9218727699739049984L;
		data[2]=-361409472049446908L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_106 = new BitSet(mk_tokenSet_106());
	private static final long[] mk_tokenSet_107() {
		long[] data = new long[10];
		data[0]=1224433895496220672L;
		data[1]=-9164332655657615360L;
		data[2]=-1121501818513404L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_107 = new BitSet(mk_tokenSet_107());
	private static final long[] mk_tokenSet_108() {
		long[] data = new long[10];
		data[0]=1179944356501520384L;
		data[1]=-8065806194595332096L;
		data[2]=-361409472049446908L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_108 = new BitSet(mk_tokenSet_108());
	private static final long[] mk_tokenSet_109() {
		long[] data = new long[10];
		data[0]=-2882840875094769662L;
		data[1]=-2820660741625888769L;
		data[2]=-599989751392001L;
		data[3]=1441147452647276543L;
		data[4]=248L;
		return data;
	}
	public static final BitSet _tokenSet_109 = new BitSet(mk_tokenSet_109());
	private static final long[] mk_tokenSet_110() {
		long[] data = new long[10];
		data[0]=181270022440615936L;
		data[1]=54043196065579008L;
		data[2]=-1121501818513408L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_110 = new BitSet(mk_tokenSet_110());
	private static final long[] mk_tokenSet_111() {
		long[] data = new long[10];
		data[0]=-2909862747736899582L;
		data[1]=54606146037596159L;
		data[2]=-37094374254341L;
		data[3]=288177981845667839L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_111 = new BitSet(mk_tokenSet_111());
	private static final long[] mk_tokenSet_112() {
		long[] data = { 4611686035607257088L, 0L, 2L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_112 = new BitSet(mk_tokenSet_112());
	private static final long[] mk_tokenSet_113() {
		long[] data = new long[10];
		data[0]=-4352158167832985600L;
		data[1]=2360519523993387008L;
		data[2]=-360888014567030542L;
		data[3]=288177981307683791L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_113 = new BitSet(mk_tokenSet_113());
	private static final long[] mk_tokenSet_114() {
		long[] data = new long[10];
		data[0]=-2305843561116991486L;
		data[1]=-2810246167487594497L;
		data[2]=-36421322678273L;
		data[3]=-5188146770730811393L;
		data[4]=255L;
		return data;
	}
	public static final BitSet _tokenSet_114 = new BitSet(mk_tokenSet_114());
	private static final long[] mk_tokenSet_115() {
		long[] data = new long[10];
		data[0]=-8971150507598938112L;
		data[1]=633318697599360L;
		data[2]=-360905887133990912L;
		data[3]=646273525311538127L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_115 = new BitSet(mk_tokenSet_115());
	private static final long[] mk_tokenSet_116() {
		long[] data = new long[10];
		data[0]=216172936732606464L;
		data[1]=140736917929984L;
		data[2]=-361409188581605376L;
		data[3]=288230482987910095L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_116 = new BitSet(mk_tokenSet_116());
	private static final long[] mk_tokenSet_117() {
		long[] data = new long[10];
		data[0]=222928318993793024L;
		data[1]=1759218034016256L;
		data[2]=-361409472049446912L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_117 = new BitSet(mk_tokenSet_117());
	private static final long[] mk_tokenSet_118() {
		long[] data = { 72057679937273856L, 2251799813685248L, 2L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_118 = new BitSet(mk_tokenSet_118());
	private static final long[] mk_tokenSet_119() {
		long[] data = { 72075272123318272L, 2251799813685248L, 2L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_119 = new BitSet(mk_tokenSet_119());
	private static final long[] mk_tokenSet_120() {
		long[] data = { 144115188075855872L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_120 = new BitSet(mk_tokenSet_120());
	private static final long[] mk_tokenSet_121() {
		long[] data = { 0L, 1657324662872342528L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_121 = new BitSet(mk_tokenSet_121());
	private static final long[] mk_tokenSet_122() {
		long[] data = new long[10];
		data[0]=154618822656L;
		data[1]=633318127173632L;
		data[2]=-361409472049446912L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_122 = new BitSet(mk_tokenSet_122());
	private static final long[] mk_tokenSet_123() {
		long[] data = new long[10];
		data[0]=216190511738781696L;
		data[1]=70368173752320L;
		data[2]=-361409197171539968L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_123 = new BitSet(mk_tokenSet_123());
	private static final long[] mk_tokenSet_124() {
		long[] data = new long[10];
		data[0]=253345208664588288L;
		data[1]=54113569104724352L;
		data[2]=-1121226940606464L;
		data[3]=576460859677605887L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_124 = new BitSet(mk_tokenSet_124());
	private static final long[] mk_tokenSet_125() {
		long[] data = new long[10];
		data[0]=253347427015196672L;
		data[1]=54535776721174912L;
		data[2]=-839751938615288L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_125 = new BitSet(mk_tokenSet_125());
	private static final long[] mk_tokenSet_126() {
		long[] data = new long[10];
		data[0]=216172919552737280L;
		data[1]=70368173752320L;
		data[2]=-361409197171539968L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_126 = new BitSet(mk_tokenSet_126());
	private static final long[] mk_tokenSet_127() {
		long[] data = { 36046389205008384L, 2305913382252838912L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_127 = new BitSet(mk_tokenSet_127());
	private static final long[] mk_tokenSet_128() {
		long[] data = new long[10];
		data[0]=137438953472L;
		data[1]=6917951240643018752L;
		data[2]=-361409472049446912L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_128 = new BitSet(mk_tokenSet_128());
	private static final long[] mk_tokenSet_129() {
		long[] data = { 216190374299828224L, 6917599396418813952L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_129 = new BitSet(mk_tokenSet_129());
	private static final long[] mk_tokenSet_130() {
		long[] data = { 36046389205008384L, 2305843013508661248L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_130 = new BitSet(mk_tokenSet_130());
	private static final long[] mk_tokenSet_131() {
		long[] data = new long[10];
		data[0]=137438953472L;
		data[1]=6917529028177952768L;
		data[2]=-361409472049446912L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_131 = new BitSet(mk_tokenSet_131());
	private static final long[] mk_tokenSet_132() {
		long[] data = { 216190374299828224L, 6917529027674636288L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_132 = new BitSet(mk_tokenSet_132());
	private static final long[] mk_tokenSet_133() {
		long[] data = { 36032112733716480L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_133 = new BitSet(mk_tokenSet_133());
	private static final long[] mk_tokenSet_134() {
		long[] data = { 216172782113783808L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_134 = new BitSet(mk_tokenSet_134());
	private static final long[] mk_tokenSet_135() {
		long[] data = { 4398046511104L, 16777216L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_135 = new BitSet(mk_tokenSet_135());
	private static final long[] mk_tokenSet_136() {
		long[] data = { 36028797018963968L, 64L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_136 = new BitSet(mk_tokenSet_136());
	private static final long[] mk_tokenSet_137() {
		long[] data = new long[8];
		data[0]=137438953472L;
		data[2]=-1125899906318336L;
		data[3]=4294967295L;
		return data;
	}
	public static final BitSet _tokenSet_137 = new BitSet(mk_tokenSet_137());
	private static final long[] mk_tokenSet_138() {
		long[] data = new long[10];
		data[0]=-2909862747736899582L;
		data[1]=54606146037596159L;
		data[2]=-600044336064261L;
		data[3]=288177981845667839L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_138 = new BitSet(mk_tokenSet_138());
	private static final long[] mk_tokenSet_139() {
		long[] data = new long[10];
		data[0]=-2882840875094769662L;
		data[1]=-2820660741625888769L;
		data[2]=-37039797970689L;
		data[3]=1441147452647276543L;
		data[4]=248L;
		return data;
	}
	public static final BitSet _tokenSet_139 = new BitSet(mk_tokenSet_139());
	private static final long[] mk_tokenSet_140() {
		long[] data = new long[10];
		data[0]=253345227991941120L;
		data[1]=54043196082356608L;
		data[2]=-558551856588792L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_140 = new BitSet(mk_tokenSet_140());
	private static final long[] mk_tokenSet_141() {
		long[] data = new long[10];
		data[0]=-2909862747736899582L;
		data[1]=56928314031325183L;
		data[2]=-600044042462981L;
		data[3]=288221992375549951L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_141 = new BitSet(mk_tokenSet_141());
	private static final long[] mk_tokenSet_142() {
		long[] data = new long[10];
		data[0]=-2882840875094769662L;
		data[1]=-2820660741625888769L;
		data[2]=-37039797970689L;
		data[3]=1441147482712047615L;
		data[4]=248L;
		return data;
	}
	public static final BitSet _tokenSet_142 = new BitSet(mk_tokenSet_142());
	private static final long[] mk_tokenSet_143() {
		long[] data = new long[10];
		data[0]=181287633954013184L;
		data[1]=54043196082356608L;
		data[2]=-558551856588792L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_143 = new BitSet(mk_tokenSet_143());
	private static final long[] mk_tokenSet_144() {
		long[] data = { 4611686018427387904L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_144 = new BitSet(mk_tokenSet_144());
	private static final long[] mk_tokenSet_145() {
		long[] data = { 4755801223683112960L, 0L, 2L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_145 = new BitSet(mk_tokenSet_145());
	private static final long[] mk_tokenSet_146() {
		long[] data = { 4755801292402589696L, 0L, 2L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_146 = new BitSet(mk_tokenSet_146());
	private static final long[] mk_tokenSet_147() {
		long[] data = { 4755801292402589696L, 0L, 34L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_147 = new BitSet(mk_tokenSet_147());
	private static final long[] mk_tokenSet_148() {
		long[] data = new long[10];
		data[0]=181833041113513984L;
		data[1]=54043196065579008L;
		data[2]=-1121501818513376L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_148 = new BitSet(mk_tokenSet_148());
	private static final long[] mk_tokenSet_149() {
		long[] data = new long[10];
		data[0]=4793537770565926912L;
		data[1]=54676514779955584L;
		data[2]=-1121226932102934L;
		data[3]=2181538443689983L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_149 = new BitSet(mk_tokenSet_149());
	private static final long[] mk_tokenSet_150() {
		long[] data = new long[10];
		data[0]=-2988675784165556224L;
		data[1]=56998682775502847L;
		data[2]=-1121226512670741L;
		data[3]=2225548973572095L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_150 = new BitSet(mk_tokenSet_150());
	private static final long[] mk_tokenSet_151() {
		long[] data = new long[10];
		data[0]=37736478163337216L;
		data[1]=54606146035777920L;
		data[2]=-1121226932102968L;
		data[3]=2181538443689983L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_151 = new BitSet(mk_tokenSet_151());
	private static final long[] mk_tokenSet_152() {
		long[] data = new long[10];
		data[0]=181853865262448640L;
		data[1]=54746882960001408L;
		data[2]=-1121226915325752L;
		data[3]=2225548973572095L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_152 = new BitSet(mk_tokenSet_152());
	private static final long[] mk_tokenSet_153() {
		long[] data = new long[10];
		data[0]=4865597563627110400L;
		data[1]=54746882960001408L;
		data[2]=-540679407149078L;
		data[3]=2225548973572095L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_153 = new BitSet(mk_tokenSet_153());
	private static final long[] mk_tokenSet_154() {
		long[] data = { 4755801292402589696L, 0L, 33554466L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_154 = new BitSet(mk_tokenSet_154());
	private static final long[] mk_tokenSet_155() {
		long[] data = new long[10];
		data[0]=-2988696677033967616L;
		data[1]=56294995897860095L;
		data[2]=-1121501415860189L;
		data[3]=107374182399L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_155 = new BitSet(mk_tokenSet_155());
	private static final long[] mk_tokenSet_156() {
		long[] data = new long[10];
		data[0]=37154834364760064L;
		data[1]=54043196065579008L;
		data[2]=-1121501818513280L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_156 = new BitSet(mk_tokenSet_156());
	private static final long[] mk_tokenSet_157() {
		long[] data = new long[10];
		data[0]=37172428698288128L;
		data[1]=54043196082356608L;
		data[2]=-1121501810010072L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_157 = new BitSet(mk_tokenSet_157());
	private static final long[] mk_tokenSet_158() {
		long[] data = new long[10];
		data[0]=181852765750820864L;
		data[1]=54113564262402432L;
		data[2]=-1121501793232856L;
		data[3]=44117904064511L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_158 = new BitSet(mk_tokenSet_158());
	private static final long[] mk_tokenSet_159() {
		long[] data = new long[10];
		data[0]=253345210812071936L;
		data[1]=54043196082356608L;
		data[2]=-1121501810010104L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_159 = new BitSet(mk_tokenSet_159());
	private static final long[] mk_tokenSet_160() {
		long[] data = new long[10];
		data[0]=4755801429841543168L;
		data[2]=-361409472049446878L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_160 = new BitSet(mk_tokenSet_160());
	private static final long[] mk_tokenSet_161() {
		long[] data = new long[10];
		data[0]=-2988696677033967616L;
		data[1]=56365364642037759L;
		data[2]=-1121501415860189L;
		data[3]=107374182399L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_161 = new BitSet(mk_tokenSet_161());
	private static final long[] mk_tokenSet_162() {
		long[] data = new long[10];
		data[0]=-2959402343637975038L;
		data[1]=-8008877880536743937L;
		data[2]=-1103577888071697L;
		data[3]=1155103043050536959L;
		data[4]=248L;
		return data;
	}
	public static final BitSet _tokenSet_162 = new BitSet(mk_tokenSet_162());
	private static final long[] mk_tokenSet_163() {
		long[] data = new long[10];
		data[0]=-2310602247442006014L;
		data[1]=-7999800313101959169L;
		data[2]=-258524818972689L;
		data[3]=3460994598279577599L;
		data[4]=248L;
		return data;
	}
	public static final BitSet _tokenSet_163 = new BitSet(mk_tokenSet_163());
	private static final long[] mk_tokenSet_164() {
		long[] data = new long[10];
		data[0]=37154834364760064L;
		data[1]=54043196065579008L;
		data[2]=-1121501818513408L;
		data[3]=35291746271231L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_164 = new BitSet(mk_tokenSet_164());
	private static final long[] mk_tokenSet_165() {
		long[] data = new long[10];
		data[0]=-8970026808862834688L;
		data[1]=54043196082356608L;
		data[2]=-1092905917753336L;
		data[3]=54043302902628351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_165 = new BitSet(mk_tokenSet_165());
	private static final long[] mk_tokenSet_166() {
		long[] data = new long[10];
		data[0]=-2882841149972676606L;
		data[1]=-3397121493929312257L;
		data[2]=-600044042462977L;
		data[3]=288224328837758975L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_166 = new BitSet(mk_tokenSet_166());
	private static final long[] mk_tokenSet_167() {
		long[] data = new long[10];
		data[0]=-2882559400118059006L;
		data[1]=-2811653542371147777L;
		data[2]=-37039797968897L;
		data[3]=1729382256910270463L;
		data[4]=255L;
		return data;
	}
	public static final BitSet _tokenSet_167 = new BitSet(mk_tokenSet_167());
	private static final long[] mk_tokenSet_168() {
		long[] data = new long[10];
		data[0]=-9042084402900762624L;
		data[1]=54043196082356608L;
		data[2]=-1092905917753336L;
		data[3]=54043302902628351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_168 = new BitSet(mk_tokenSet_168());
	private static final long[] mk_tokenSet_169() {
		long[] data = new long[8];
		data[0]=-9079256831599050752L;
		data[2]=32993938767872L;
		data[3]=54043195528445952L;
		return data;
	}
	public static final BitSet _tokenSet_169 = new BitSet(mk_tokenSet_169());
	private static final long[] mk_tokenSet_170() {
		long[] data = new long[10];
		data[0]=-3198110716074655742L;
		data[1]=54676514779955456L;
		data[2]=-600044327675661L;
		data[3]=288180180868923391L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_170 = new BitSet(mk_tokenSet_170());
	private static final long[] mk_tokenSet_171() {
		long[] data = { 0L, 562949953421312L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_171 = new BitSet(mk_tokenSet_171());
	private static final long[] mk_tokenSet_172() {
		long[] data = new long[10];
		data[0]=-2882524215745970174L;
		data[1]=-2810527642464305153L;
		data[2]=-37039797968897L;
		data[3]=1729382256910270463L;
		data[4]=255L;
		return data;
	}
	public static final BitSet _tokenSet_172 = new BitSet(mk_tokenSet_172());
	private static final long[] mk_tokenSet_173() {
		long[] data = new long[10];
		data[0]=-4352140575646941184L;
		data[1]=54676518537789440L;
		data[2]=-360888014567030542L;
		data[3]=288177981307683791L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_173 = new BitSet(mk_tokenSet_173());
	private static final long[] mk_tokenSet_174() {
		long[] data = new long[10];
		data[0]=-2882841149972676606L;
		data[1]=-2820379266655469569L;
		data[2]=-600041911756553L;
		data[3]=288225948040429567L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_174 = new BitSet(mk_tokenSet_174());
	private static final long[] mk_tokenSet_175() {
		long[] data = new long[10];
		data[0]=-2882524215745970174L;
		data[1]=-2810527642464305153L;
		data[2]=-37039797968897L;
		data[3]=1729382226845499391L;
		data[4]=255L;
		return data;
	}
	public static final BitSet _tokenSet_175 = new BitSet(mk_tokenSet_175());
	private static final long[] mk_tokenSet_176() {
		long[] data = { 144115205255725056L, 0L, 8589934592L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_176 = new BitSet(mk_tokenSet_176());
	private static final long[] mk_tokenSet_177() {
		long[] data = new long[8];
		data[0]=-9007199237561122816L;
		data[2]=507982961967106L;
		data[3]=69806069102149632L;
		return data;
	}
	public static final BitSet _tokenSet_177 = new BitSet(mk_tokenSet_177());
	private static final long[] mk_tokenSet_178() {
		long[] data = new long[10];
		data[0]=36028934457917440L;
		data[1]=384L;
		data[2]=-361409472049446912L;
		data[3]=576460859139621839L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_178 = new BitSet(mk_tokenSet_178());
	private static final long[] mk_tokenSet_179() {
		long[] data = new long[8];
		data[0]=36028797018963968L;
		data[1]=384L;
		data[3]=576460752303423488L;
		return data;
	}
	public static final BitSet _tokenSet_179 = new BitSet(mk_tokenSet_179());
	private static final long[] mk_tokenSet_180() {
		long[] data = new long[10];
		data[0]=19932943220736L;
		data[2]=-361409472049446912L;
		data[3]=4504882709455L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_180 = new BitSet(mk_tokenSet_180());
	private static final long[] mk_tokenSet_181() {
		long[] data = new long[10];
		data[0]=36028938752884736L;
		data[2]=-361409472049446912L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_181 = new BitSet(mk_tokenSet_181());
	private static final long[] mk_tokenSet_182() {
		long[] data = new long[10];
		data[0]=141733920768L;
		data[2]=-361409472049446912L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_182 = new BitSet(mk_tokenSet_182());
	private static final long[] mk_tokenSet_183() {
		long[] data = new long[10];
		data[0]=-3133374900962590720L;
		data[1]=2251799832543231L;
		data[2]=-1121501457154047L;
		data[3]=107374182399L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_183 = new BitSet(mk_tokenSet_183());
	private static final long[] mk_tokenSet_184() {
		long[] data = new long[10];
		data[0]=-3031461037187530750L;
		data[1]=-8009511199234342913L;
		data[2]=-1103853177120721L;
		data[3]=1152921611981029375L;
		data[4]=248L;
		return data;
	}
	public static final BitSet _tokenSet_184 = new BitSet(mk_tokenSet_184());
	private static final long[] mk_tokenSet_185() {
		long[] data = new long[10];
		data[0]=-3103518631225458686L;
		data[1]=-8009511199234342913L;
		data[2]=-1103853177120721L;
		data[3]=1152921611981029375L;
		data[4]=248L;
		return data;
	}
	public static final BitSet _tokenSet_185 = new BitSet(mk_tokenSet_185());
	private static final long[] mk_tokenSet_186() {
		long[] data = new long[10];
		data[0]=37172445878157312L;
		data[1]=54043196082356608L;
		data[2]=-1121493220075512L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_186 = new BitSet(mk_tokenSet_186());
	private static final long[] mk_tokenSet_187() {
		long[] data = new long[10];
		data[0]=-2988676952396660736L;
		data[1]=56365364077903871L;
		data[2]=-1121492800645111L;
		data[3]=44117904064511L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_187 = new BitSet(mk_tokenSet_187());
	private static final long[] mk_tokenSet_188() {
		long[] data = new long[10];
		data[0]=-2887344749600047102L;
		data[1]=-8008807512356700161L;
		data[2]=-540618270975761L;
		data[3]=1155147053580419071L;
		data[4]=248L;
		return data;
	}
	public static final BitSet _tokenSet_188 = new BitSet(mk_tokenSet_188());
	private static final long[] mk_tokenSet_189() {
		long[] data = new long[8];
		data[0]=-9079256831599050752L;
		data[2]=15401752723456L;
		data[3]=36028797018963968L;
		return data;
	}
	public static final BitSet _tokenSet_189 = new BitSet(mk_tokenSet_189());
	private static final long[] mk_tokenSet_190() {
		long[] data = { -9079256831599050752L, 0L, 8589934592L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_190 = new BitSet(mk_tokenSet_190());
	private static final long[] mk_tokenSet_191() {
		long[] data = new long[10];
		data[0]=37154834364760064L;
		data[1]=54043196065579008L;
		data[2]=-1121501818497024L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_191 = new BitSet(mk_tokenSet_191());
	private static final long[] mk_tokenSet_192() {
		long[] data = new long[10];
		data[0]=109232221759471616L;
		data[1]=54043196082356608L;
		data[2]=-1103904255256568L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_192 = new BitSet(mk_tokenSet_192());
	private static final long[] mk_tokenSet_193() {
		long[] data = new long[10];
		data[0]=-8969460560374530048L;
		data[1]=1207668387566848384L;
		data[2]=-37092344211256L;
		data[3]=72036153561186303L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_193 = new BitSet(mk_tokenSet_193());
	private static final long[] mk_tokenSet_194() {
		long[] data = { 0L, 0L, 17597554753536L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_194 = new BitSet(mk_tokenSet_194());
	private static final long[] mk_tokenSet_195() {
		long[] data = new long[8];
		data[0]=-8971168237223936000L;
		data[1]=562949953421696L;
		data[2]=525580516720640L;
		data[3]=646269020428828672L;
		return data;
	}
	public static final BitSet _tokenSet_195 = new BitSet(mk_tokenSet_195());
	private static final long[] mk_tokenSet_196() {
		long[] data = new long[8];
		data[0]=-9079256831599050752L;
		data[2]=296876729434112L;
		data[3]=69805794224242688L;
		return data;
	}
	public static final BitSet _tokenSet_196 = new BitSet(mk_tokenSet_196());
	private static final long[] mk_tokenSet_197() {
		long[] data = new long[8];
		data[0]=-9079256831599050752L;
		data[2]=15401752723456L;
		data[3]=69805794224242688L;
		return data;
	}
	public static final BitSet _tokenSet_197 = new BitSet(mk_tokenSet_197());
	private static final long[] mk_tokenSet_198() {
		long[] data = new long[10];
		data[0]=37717784318181376L;
		data[1]=54043196065579008L;
		data[2]=-1121501818513408L;
		data[3]=44087839293439L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_198 = new BitSet(mk_tokenSet_198());
	private static final long[] mk_tokenSet_199() {
		long[] data = new long[10];
		data[0]=37736478163337216L;
		data[1]=54606146035777920L;
		data[2]=-1121226932102968L;
		data[3]=2225518908801023L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_199 = new BitSet(mk_tokenSet_199());
	private static final long[] mk_tokenSet_200() {
		long[] data = new long[8];
		data[0]=-9079256831599050752L;
		data[2]=15401752723456L;
		data[3]=63050394783186944L;
		return data;
	}
	public static final BitSet _tokenSet_200 = new BitSet(mk_tokenSet_200());
	private static final long[] mk_tokenSet_201() {
		long[] data = { 72057594037927936L, 0L, 17597554753536L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_201 = new BitSet(mk_tokenSet_201());
	private static final long[] mk_tokenSet_202() {
		long[] data = new long[10];
		data[0]=2336462209024L;
		data[2]=-361409472049446912L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_202 = new BitSet(mk_tokenSet_202());
	private static final long[] mk_tokenSet_203() {
		long[] data = new long[10];
		data[0]=72057731476881408L;
		data[2]=-361391874494693376L;
		data[3]=106836198351L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_203 = new BitSet(mk_tokenSet_203());
	private static final long[] mk_tokenSet_204() {
		long[] data = new long[10];
		data[0]=109212428402688000L;
		data[1]=1206964700672425984L;
		data[2]=-1103902116259840L;
		data[3]=244813135871L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_204 = new BitSet(mk_tokenSet_204());
	private static final long[] mk_tokenSet_205() {
		long[] data = new long[10];
		data[0]=-8970024609839579136L;
		data[1]=1206964700689203584L;
		data[2]=-600317192316920L;
		data[3]=69810711961796607L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_205 = new BitSet(mk_tokenSet_205());
	private static final long[] mk_tokenSet_206() {
		long[] data = new long[10];
		data[0]=37154834364760064L;
		data[1]=1206964700672425984L;
		data[2]=-1121499671013376L;
		data[3]=244813135871L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_206 = new BitSet(mk_tokenSet_206());
	private static final long[] mk_tokenSet_207() {
		long[] data = new long[10];
		data[0]=-8970024609839579136L;
		data[1]=54043196082356608L;
		data[2]=-600319339800568L;
		data[3]=69810574522843135L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_207 = new BitSet(mk_tokenSet_207());
	private static final long[] mk_tokenSet_208() {
		long[] data = new long[10];
		data[0]=-9007199100122169344L;
		data[1]=562949953421312L;
		data[2]=-360905887133990912L;
		data[3]=69808374961603535L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_208 = new BitSet(mk_tokenSet_208());
	private static final long[] mk_tokenSet_209() {
		long[] data = new long[10];
		data[0]=-2882858742158721022L;
		data[1]=-3397191862109356033L;
		data[2]=-600044059240201L;
		data[3]=288225948040429567L;
		data[4]=215L;
		return data;
	}
	public static final BitSet _tokenSet_209 = new BitSet(mk_tokenSet_209());
	private static final long[] mk_tokenSet_210() {
		long[] data = new long[10];
		data[0]=-2882559400118059006L;
		data[1]=-2811653542377439233L;
		data[2]=-599989751390209L;
		data[3]=-7493989810009276417L;
		data[4]=255L;
		return data;
	}
	public static final BitSet _tokenSet_210 = new BitSet(mk_tokenSet_210());
	private static final long[] mk_tokenSet_211() {
		long[] data = new long[8];
		data[0]=-9007199237561122816L;
		data[1]=562949953421312L;
		data[2]=507982961967104L;
		data[3]=69808268125405184L;
		return data;
	}
	public static final BitSet _tokenSet_211 = new BitSet(mk_tokenSet_211());
	private static final long[] mk_tokenSet_212() {
		long[] data = new long[10];
		data[0]=-2306054667349524478L;
		data[1]=-2810527642464305153L;
		data[2]=-36421322678273L;
		data[3]=-5188146770730811393L;
		data[4]=255L;
		return data;
	}
	public static final BitSet _tokenSet_212 = new BitSet(mk_tokenSet_212());
	private static final long[] mk_tokenSet_213() {
		long[] data = new long[8];
		data[0]=-9007199237561122816L;
		data[2]=507982961967104L;
		data[3]=69806069102149632L;
		return data;
	}
	public static final BitSet _tokenSet_213 = new BitSet(mk_tokenSet_213());
	private static final long[] mk_tokenSet_214() {
		long[] data = new long[10];
		data[0]=253345227991941120L;
		data[1]=54043196082356608L;
		data[2]=-1121501810010104L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_214 = new BitSet(mk_tokenSet_214());
	private static final long[] mk_tokenSet_215() {
		long[] data = { 216172799293652992L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_215 = new BitSet(mk_tokenSet_215());
	private static final long[] mk_tokenSet_216() {
		long[] data = new long[10];
		data[0]=-9007196901098913792L;
		data[1]=562949953421312L;
		data[2]=-360905887133990912L;
		data[3]=69808374961603535L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_216 = new BitSet(mk_tokenSet_216());
	private static final long[] mk_tokenSet_217() {
		long[] data = new long[10];
		data[0]=-8971168099784982528L;
		data[1]=562949953421696L;
		data[2]=-360905887133990912L;
		data[3]=646273525311538127L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_217 = new BitSet(mk_tokenSet_217());
	private static final long[] mk_tokenSet_218() {
		long[] data = new long[10];
		data[0]=-8971168099784982528L;
		data[1]=562949953421696L;
		data[2]=-360905887133990912L;
		data[3]=646269127265027023L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_218 = new BitSet(mk_tokenSet_218());
	private static final long[] mk_tokenSet_219() {
		long[] data = { 21474836480L, 0L, 281474976710656L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_219 = new BitSet(mk_tokenSet_219());
	private static final long[] mk_tokenSet_220() {
		long[] data = new long[8];
		data[0]=-9007199168841646080L;
		data[2]=507982961967106L;
		data[3]=69806069102149632L;
		return data;
	}
	public static final BitSet _tokenSet_220 = new BitSet(mk_tokenSet_220());
	private static final long[] mk_tokenSet_221() {
		long[] data = new long[8];
		data[0]=-9007199168841646080L;
		data[2]=507982961967138L;
		data[3]=69806069102149632L;
		return data;
	}
	public static final BitSet _tokenSet_221 = new BitSet(mk_tokenSet_221());
	private static final long[] mk_tokenSet_222() {
		long[] data = new long[10];
		data[0]=181853865262448640L;
		data[1]=54676514215823744L;
		data[2]=-1121226915325752L;
		data[3]=2225548973572095L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_222 = new BitSet(mk_tokenSet_222());
	private static final long[] mk_tokenSet_223() {
		long[] data = new long[10];
		data[0]=37172428698288128L;
		data[1]=54043196082356608L;
		data[2]=-1121226932103160L;
		data[3]=2181538443689983L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_223 = new BitSet(mk_tokenSet_223());
	private static final long[] mk_tokenSet_224() {
		long[] data = new long[10];
		data[0]=181852765750820864L;
		data[1]=54113564262402432L;
		data[2]=-1121226915325944L;
		data[3]=2225548973572095L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_224 = new BitSet(mk_tokenSet_224());
	private static final long[] mk_tokenSet_225() {
		long[] data = new long[10];
		data[0]=-8969460491655053312L;
		data[1]=54746882960001408L;
		data[2]=-37094491694870L;
		data[3]=72031618075721727L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_225 = new BitSet(mk_tokenSet_225());
	private static final long[] mk_tokenSet_226() {
		long[] data = new long[10];
		data[0]=37735378651709440L;
		data[1]=54606146035777920L;
		data[2]=-1121501810010104L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_226 = new BitSet(mk_tokenSet_226());
	private static final long[] mk_tokenSet_227() {
		long[] data = new long[10];
		data[0]=181852765750820864L;
		data[1]=54676514215823744L;
		data[2]=-1121501793232888L;
		data[3]=44117904064511L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_227 = new BitSet(mk_tokenSet_227());
	private static final long[] mk_tokenSet_228() {
		long[] data = new long[10];
		data[0]=37735378651709440L;
		data[1]=54043196082356608L;
		data[2]=-1121501810010040L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_228 = new BitSet(mk_tokenSet_228());
	private static final long[] mk_tokenSet_229() {
		long[] data = new long[10];
		data[0]=181852765750820864L;
		data[1]=54113564262402432L;
		data[2]=-1121501793232824L;
		data[3]=44117904064511L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_229 = new BitSet(mk_tokenSet_229());
	private static final long[] mk_tokenSet_230() {
		long[] data = new long[10];
		data[0]=-8969460491655053312L;
		data[1]=54746882960001408L;
		data[2]=-37094491694870L;
		data[3]=72049210261766143L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_230 = new BitSet(mk_tokenSet_230());
	private static final long[] mk_tokenSet_231() {
		long[] data = new long[10];
		data[0]=37735378651709440L;
		data[1]=54043196082356608L;
		data[2]=-1121501810009976L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_231 = new BitSet(mk_tokenSet_231());
	private static final long[] mk_tokenSet_232() {
		long[] data = new long[10];
		data[0]=181852765750820864L;
		data[1]=54113564262402432L;
		data[2]=-1121501793232760L;
		data[3]=44117904064511L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_232 = new BitSet(mk_tokenSet_232());
	private static final long[] mk_tokenSet_233() {
		long[] data = new long[10];
		data[0]=253911459300376576L;
		data[1]=54746882960001408L;
		data[2]=-540679407150872L;
		data[3]=2225548973572095L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_233 = new BitSet(mk_tokenSet_233());
	private static final long[] mk_tokenSet_234() {
		long[] data = new long[10];
		data[0]=37173528209915904L;
		data[1]=54043196082356608L;
		data[2]=-1121501810010104L;
		data[3]=107374182399L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_234 = new BitSet(mk_tokenSet_234());
	private static final long[] mk_tokenSet_235() {
		long[] data = new long[10];
		data[0]=181853865262448640L;
		data[1]=54113564262402432L;
		data[2]=-1121501793232888L;
		data[3]=44117904064511L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_235 = new BitSet(mk_tokenSet_235());
	private static final long[] mk_tokenSet_236() {
		long[] data = new long[8];
		data[0]=-9006635119376596992L;
		data[1]=562949953421312L;
		data[2]=508257839874274L;
		data[3]=72005092357701632L;
		return data;
	}
	public static final BitSet _tokenSet_236 = new BitSet(mk_tokenSet_236());
	private static final long[] mk_tokenSet_237() {
		long[] data = new long[10];
		data[0]=-8969461591166681088L;
		data[1]=54113564262402432L;
		data[2]=-617916877776854L;
		data[3]=69850187006214143L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_237 = new BitSet(mk_tokenSet_237());
	private static final long[] mk_tokenSet_238() {
		long[] data = new long[10];
		data[0]=-8970026740143357952L;
		data[1]=54043196082356608L;
		data[2]=-617916894554070L;
		data[3]=69806176476332031L;
		data[4]=192L;
		return data;
	}
	public static final BitSet _tokenSet_238 = new BitSet(mk_tokenSet_238());
	private static final long[] mk_tokenSet_239() {
		long[] data = new long[10];
		data[0]=-2882841149972676606L;
		data[1]=-3397121493929312257L;
		data[2]=-600044042462977L;
		data[3]=288225978105200639L;
		data[4]=208L;
		return data;
	}
	public static final BitSet _tokenSet_239 = new BitSet(mk_tokenSet_239());
	private static final long[] mk_tokenSet_240() {
		long[] data = { -9007199237561122816L, 0L, 8589934592L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_240 = new BitSet(mk_tokenSet_240());
	private static final long[] mk_tokenSet_241() {
		long[] data = new long[8];
		data[3]=-9223372036854775808L;
		return data;
	}
	public static final BitSet _tokenSet_241 = new BitSet(mk_tokenSet_241());
	private static final long[] mk_tokenSet_242() {
		long[] data = new long[10];
		data[0]=17179869184L;
		data[4]=32L;
		return data;
	}
	public static final BitSet _tokenSet_242 = new BitSet(mk_tokenSet_242());
	
	}
