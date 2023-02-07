// Generated from java-escape by ANTLR 4.11.1
package calcprop.interpreter;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CalculoLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, AND=3, OR=4, IMPLIES=5, IFF=6, XOR=7, NAND=8, NOR=9, CONECTIVO_UNARIO=10, 
		ATOMO=11, LC=12, WS=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "AND", "OR", "IMPLIES", "IFF", "XOR", "NAND", "NOR", 
			"CONECTIVO_UNARIO", "ATOMO", "LC", "WS"
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


	public CalculoLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calculo.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\rA\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0005\u000b4\b\u000b\n\u000b\f\u000b7\t\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0004\f<\b\f\u000b\f\f\f=\u0001\f\u0001\f\u0000\u0000\r"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u0001\u0000"+
		"\u0003\u0001\u0000az\u0002\u0000\n\n\r\r\u0003\u0000\t\n\r\r  B\u0000"+
		"\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"+
		"\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"+
		"\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r"+
		"\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0001\u001b\u0001\u0000\u0000\u0000\u0003\u001d"+
		"\u0001\u0000\u0000\u0000\u0005\u001f\u0001\u0000\u0000\u0000\u0007!\u0001"+
		"\u0000\u0000\u0000\t#\u0001\u0000\u0000\u0000\u000b%\u0001\u0000\u0000"+
		"\u0000\r\'\u0001\u0000\u0000\u0000\u000f)\u0001\u0000\u0000\u0000\u0011"+
		"+\u0001\u0000\u0000\u0000\u0013-\u0001\u0000\u0000\u0000\u0015/\u0001"+
		"\u0000\u0000\u0000\u00171\u0001\u0000\u0000\u0000\u0019;\u0001\u0000\u0000"+
		"\u0000\u001b\u001c\u0005(\u0000\u0000\u001c\u0002\u0001\u0000\u0000\u0000"+
		"\u001d\u001e\u0005)\u0000\u0000\u001e\u0004\u0001\u0000\u0000\u0000\u001f"+
		" \u0005\u2227\u0000\u0000 \u0006\u0001\u0000\u0000\u0000!\"\u0005\u2228"+
		"\u0000\u0000\"\b\u0001\u0000\u0000\u0000#$\u0005\u2192\u0000\u0000$\n"+
		"\u0001\u0000\u0000\u0000%&\u0005\u2194\u0000\u0000&\f\u0001\u0000\u0000"+
		"\u0000\'(\u0005\u2295\u0000\u0000(\u000e\u0001\u0000\u0000\u0000)*\u0005"+
		"|\u0000\u0000*\u0010\u0001\u0000\u0000\u0000+,\u0005\u2193\u0000\u0000"+
		",\u0012\u0001\u0000\u0000\u0000-.\u0005\u00ac\u0000\u0000.\u0014\u0001"+
		"\u0000\u0000\u0000/0\u0007\u0000\u0000\u00000\u0016\u0001\u0000\u0000"+
		"\u000015\u0005;\u0000\u000024\b\u0001\u0000\u000032\u0001\u0000\u0000"+
		"\u000047\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001\u0000"+
		"\u0000\u000068\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000089\u0006"+
		"\u000b\u0000\u00009\u0018\u0001\u0000\u0000\u0000:<\u0007\u0002\u0000"+
		"\u0000;:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=;\u0001\u0000"+
		"\u0000\u0000=>\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?@\u0006"+
		"\f\u0000\u0000@\u001a\u0001\u0000\u0000\u0000\u0003\u00005=\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}