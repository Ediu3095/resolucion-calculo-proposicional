// Generated from java-escape by ANTLR 4.11.1
package calcprop.interpreter;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CalculoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, AND=3, OR=4, IMPLIES=5, IFF=6, XOR=7, NAND=8, NOR=9, CONECTIVO_UNARIO=10, 
		ATOMO=11, LC=12, WS=13;
	public static final int
		RULE_formula = 0, RULE_conectivo_binario = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"formula", "conectivo_binario"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'\\u2227'", "'\\u2228'", "'\\u2192'", "'\\u2194'", 
			"'\\u2295'", "'|'", "'\\u2193'", "'\\u00AC'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "AND", "OR", "IMPLIES", "IFF", "XOR", "NAND", "NOR", 
			"CONECTIVO_UNARIO", "ATOMO", "LC", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CalculoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FormulaContext extends ParserRuleContext {
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
	 
		public FormulaContext() { }
		public void copyFrom(FormulaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnarioContext extends FormulaContext {
		public TerminalNode CONECTIVO_UNARIO() { return getToken(CalculoParser.CONECTIVO_UNARIO, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public UnarioContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculoListener ) ((CalculoListener)listener).enterUnario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculoListener ) ((CalculoListener)listener).exitUnario(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtomoContext extends FormulaContext {
		public TerminalNode ATOMO() { return getToken(CalculoParser.ATOMO, 0); }
		public AtomoContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculoListener ) ((CalculoListener)listener).enterAtomo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculoListener ) ((CalculoListener)listener).exitAtomo(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinarioContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public Conectivo_binarioContext conectivo_binario() {
			return getRuleContext(Conectivo_binarioContext.class,0);
		}
		public BinarioContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculoListener ) ((CalculoListener)listener).enterBinario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculoListener ) ((CalculoListener)listener).exitBinario(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DisyuncionContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(CalculoParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(CalculoParser.OR, i);
		}
		public DisyuncionContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculoListener ) ((CalculoListener)listener).enterDisyuncion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculoListener ) ((CalculoListener)listener).exitDisyuncion(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConjuncionContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(CalculoParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(CalculoParser.AND, i);
		}
		public ConjuncionContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculoListener ) ((CalculoListener)listener).enterConjuncion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculoListener ) ((CalculoListener)listener).exitConjuncion(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_formula);
		int _la;
		try {
			setState(33);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new AtomoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(4);
				match(ATOMO);
				}
				break;
			case 2:
				_localctx = new UnarioContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(5);
				match(CONECTIVO_UNARIO);
				setState(6);
				formula();
				}
				break;
			case 3:
				_localctx = new BinarioContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(7);
				match(T__0);
				setState(8);
				formula();
				setState(9);
				conectivo_binario();
				setState(10);
				formula();
				setState(11);
				match(T__1);
				}
				break;
			case 4:
				_localctx = new ConjuncionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(13);
				match(T__0);
				setState(14);
				formula();
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(15);
					match(AND);
					setState(16);
					formula();
					}
					}
					setState(19); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==AND );
				setState(21);
				match(T__1);
				}
				break;
			case 5:
				_localctx = new DisyuncionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(23);
				match(T__0);
				setState(24);
				formula();
				setState(27); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(25);
					match(OR);
					setState(26);
					formula();
					}
					}
					setState(29); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==OR );
				setState(31);
				match(T__1);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Conectivo_binarioContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(CalculoParser.AND, 0); }
		public TerminalNode OR() { return getToken(CalculoParser.OR, 0); }
		public TerminalNode IMPLIES() { return getToken(CalculoParser.IMPLIES, 0); }
		public TerminalNode IFF() { return getToken(CalculoParser.IFF, 0); }
		public TerminalNode XOR() { return getToken(CalculoParser.XOR, 0); }
		public TerminalNode NAND() { return getToken(CalculoParser.NAND, 0); }
		public TerminalNode NOR() { return getToken(CalculoParser.NOR, 0); }
		public Conectivo_binarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conectivo_binario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculoListener ) ((CalculoListener)listener).enterConectivo_binario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculoListener ) ((CalculoListener)listener).exitConectivo_binario(this);
		}
	}

	public final Conectivo_binarioContext conectivo_binario() throws RecognitionException {
		Conectivo_binarioContext _localctx = new Conectivo_binarioContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_conectivo_binario);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 1016L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\r&\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0004\u0000\u0012\b\u0000\u000b\u0000\f\u0000\u0013\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000"+
		"\u001c\b\u0000\u000b\u0000\f\u0000\u001d\u0001\u0000\u0001\u0000\u0003"+
		"\u0000\"\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0002"+
		"\u0000\u0002\u0000\u0001\u0001\u0000\u0003\t)\u0000!\u0001\u0000\u0000"+
		"\u0000\u0002#\u0001\u0000\u0000\u0000\u0004\"\u0005\u000b\u0000\u0000"+
		"\u0005\u0006\u0005\n\u0000\u0000\u0006\"\u0003\u0000\u0000\u0000\u0007"+
		"\b\u0005\u0001\u0000\u0000\b\t\u0003\u0000\u0000\u0000\t\n\u0003\u0002"+
		"\u0001\u0000\n\u000b\u0003\u0000\u0000\u0000\u000b\f\u0005\u0002\u0000"+
		"\u0000\f\"\u0001\u0000\u0000\u0000\r\u000e\u0005\u0001\u0000\u0000\u000e"+
		"\u0011\u0003\u0000\u0000\u0000\u000f\u0010\u0005\u0003\u0000\u0000\u0010"+
		"\u0012\u0003\u0000\u0000\u0000\u0011\u000f\u0001\u0000\u0000\u0000\u0012"+
		"\u0013\u0001\u0000\u0000\u0000\u0013\u0011\u0001\u0000\u0000\u0000\u0013"+
		"\u0014\u0001\u0000\u0000\u0000\u0014\u0015\u0001\u0000\u0000\u0000\u0015"+
		"\u0016\u0005\u0002\u0000\u0000\u0016\"\u0001\u0000\u0000\u0000\u0017\u0018"+
		"\u0005\u0001\u0000\u0000\u0018\u001b\u0003\u0000\u0000\u0000\u0019\u001a"+
		"\u0005\u0004\u0000\u0000\u001a\u001c\u0003\u0000\u0000\u0000\u001b\u0019"+
		"\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u001b"+
		"\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u001f"+
		"\u0001\u0000\u0000\u0000\u001f \u0005\u0002\u0000\u0000 \"\u0001\u0000"+
		"\u0000\u0000!\u0004\u0001\u0000\u0000\u0000!\u0005\u0001\u0000\u0000\u0000"+
		"!\u0007\u0001\u0000\u0000\u0000!\r\u0001\u0000\u0000\u0000!\u0017\u0001"+
		"\u0000\u0000\u0000\"\u0001\u0001\u0000\u0000\u0000#$\u0007\u0000\u0000"+
		"\u0000$\u0003\u0001\u0000\u0000\u0000\u0003\u0013\u001d!";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}