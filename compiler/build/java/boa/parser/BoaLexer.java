// Generated from Boa.g by ANTLR 4.5
package boa.parser;

import java.util.ArrayList;

import boa.compiler.ast.*;
import boa.compiler.ast.expressions.*;
import boa.compiler.ast.literals.*;
import boa.compiler.ast.statements.*;
import boa.compiler.ast.types.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BoaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OF=1, IF=2, DO=3, MAP=4, STACK=5, SET=6, FOR=7, FOREACH=8, IFALL=9, EXISTS=10, 
		NOT=11, TYPE=12, ELSE=13, CASE=14, OUTPUT=15, FORMAT=16, WHILE=17, BREAK=18, 
		ARRAY=19, STATIC=20, SWITCH=21, RETURN=22, WEIGHT=23, DEFAULT=24, CONTINUE=25, 
		FUNCTION=26, VISITOR=27, BEFORE=28, AFTER=29, STOP=30, ENUM=31, SEMICOLON=32, 
		COLON=33, COMMA=34, DOT=35, LBRACE=36, RBRACE=37, LPAREN=38, RPAREN=39, 
		LBRACKET=40, RBRACKET=41, OR=42, ONEOR=43, TWOOR=44, AND=45, ONEAND=46, 
		TWOAND=47, INCR=48, DECR=49, EQEQ=50, NEQ=51, LT=52, LTEQ=53, GT=54, GTEQ=55, 
		PLUS=56, MINUS=57, XOR=58, STAR=59, DIV=60, MOD=61, RSHIFT=62, NEG=63, 
		INV=64, WILDCARD=65, QUESTION=66, DOLLAR=67, EQUALS=68, EMIT=69, RIGHT_ARROW=70, 
		IntegerLiteral=71, FloatingPointLiteral=72, CharacterLiteral=73, RegexLiteral=74, 
		StringLiteral=75, TimeLiteral=76, Identifier=77, WS=78, LINE_COMMENT=79;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"OF", "IF", "DO", "MAP", "STACK", "SET", "FOR", "FOREACH", "IFALL", "EXISTS", 
		"NOT", "TYPE", "ELSE", "CASE", "OUTPUT", "FORMAT", "WHILE", "BREAK", "ARRAY", 
		"STATIC", "SWITCH", "RETURN", "WEIGHT", "DEFAULT", "CONTINUE", "FUNCTION", 
		"VISITOR", "BEFORE", "AFTER", "STOP", "ENUM", "SEMICOLON", "COLON", "COMMA", 
		"DOT", "LBRACE", "RBRACE", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", 
		"OR", "ONEOR", "TWOOR", "AND", "ONEAND", "TWOAND", "INCR", "DECR", "EQEQ", 
		"NEQ", "LT", "LTEQ", "GT", "GTEQ", "PLUS", "MINUS", "XOR", "STAR", "DIV", 
		"MOD", "RSHIFT", "NEG", "INV", "WILDCARD", "QUESTION", "DOLLAR", "EQUALS", 
		"EMIT", "RIGHT_ARROW", "IntegerLiteral", "DecimalNumeral", "Digit", "NonZeroDigit", 
		"HexNumeral", "OctalNumeral", "BinaryNumeral", "FloatingPointLiteral", 
		"ExponentPart", "CharacterLiteral", "SingleCharacter", "RegexLiteral", 
		"RegexCharacter", "StringLiteral", "StringCharacter", "EscapeSequence", 
		"OctalEscape", "TimeLiteral", "Identifier", "WS", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'of'", "'if'", "'do'", "'map'", "'stack'", "'set'", "'for'", "'foreach'", 
		"'ifall'", "'exists'", "'not'", "'type'", "'else'", "'case'", "'output'", 
		"'format'", "'while'", "'break'", "'array'", "'static'", "'switch'", "'return'", 
		"'weight'", "'default'", "'continue'", "'function'", "'visitor'", "'before'", 
		"'after'", "'stop'", "'enum'", "';'", "':'", "','", "'.'", "'{'", "'}'", 
		"'('", "')'", "'['", "']'", "'or'", "'|'", "'||'", "'and'", "'&'", "'&&'", 
		"'++'", "'--'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", 
		"'^'", "'*'", "'/'", "'%'", "'>>'", "'~'", "'!'", "'_'", "'?'", "'$'", 
		"'='", "'<<'", "'->'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "OF", "IF", "DO", "MAP", "STACK", "SET", "FOR", "FOREACH", "IFALL", 
		"EXISTS", "NOT", "TYPE", "ELSE", "CASE", "OUTPUT", "FORMAT", "WHILE", 
		"BREAK", "ARRAY", "STATIC", "SWITCH", "RETURN", "WEIGHT", "DEFAULT", "CONTINUE", 
		"FUNCTION", "VISITOR", "BEFORE", "AFTER", "STOP", "ENUM", "SEMICOLON", 
		"COLON", "COMMA", "DOT", "LBRACE", "RBRACE", "LPAREN", "RPAREN", "LBRACKET", 
		"RBRACKET", "OR", "ONEOR", "TWOOR", "AND", "ONEAND", "TWOAND", "INCR", 
		"DECR", "EQEQ", "NEQ", "LT", "LTEQ", "GT", "GTEQ", "PLUS", "MINUS", "XOR", 
		"STAR", "DIV", "MOD", "RSHIFT", "NEG", "INV", "WILDCARD", "QUESTION", 
		"DOLLAR", "EQUALS", "EMIT", "RIGHT_ARROW", "IntegerLiteral", "FloatingPointLiteral", 
		"CharacterLiteral", "RegexLiteral", "StringLiteral", "TimeLiteral", "Identifier", 
		"WS", "LINE_COMMENT"
	};
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


	public BoaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Boa.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2Q\u0272\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3"+
		" \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3"+
		"+\3+\3,\3,\3-\3-\3-\3.\3.\3.\3.\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3"+
		"\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\66\3\66\3\66\3"+
		"\67\3\67\38\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3?\3@\3@\3"+
		"A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3F\3G\3G\3G\3H\3H\3H\3H\5H\u01d2\n"+
		"H\3I\3I\7I\u01d6\nI\fI\16I\u01d9\13I\3J\3J\5J\u01dd\nJ\3K\3K\3L\3L\3L"+
		"\6L\u01e4\nL\rL\16L\u01e5\3M\3M\7M\u01ea\nM\fM\16M\u01ed\13M\3N\3N\3N"+
		"\6N\u01f2\nN\rN\16N\u01f3\3O\6O\u01f7\nO\rO\16O\u01f8\3O\3O\7O\u01fd\n"+
		"O\fO\16O\u0200\13O\3O\5O\u0203\nO\3O\3O\6O\u0207\nO\rO\16O\u0208\3O\5"+
		"O\u020c\nO\3O\6O\u020f\nO\rO\16O\u0210\3O\3O\5O\u0215\nO\3P\3P\5P\u0219"+
		"\nP\3P\6P\u021c\nP\rP\16P\u021d\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\5Q\u0228\nQ\3"+
		"R\3R\3S\3S\7S\u022e\nS\fS\16S\u0231\13S\3S\3S\3T\3T\3U\3U\7U\u0239\nU"+
		"\fU\16U\u023c\13U\3U\3U\3V\3V\5V\u0242\nV\3W\3W\3W\5W\u0247\nW\3X\3X\3"+
		"X\3X\3X\3X\3X\3X\3X\5X\u0252\nX\3Y\3Y\5Y\u0256\nY\3Y\3Y\5Y\u025a\nY\3"+
		"Z\3Z\7Z\u025e\nZ\fZ\16Z\u0261\13Z\3[\6[\u0264\n[\r[\16[\u0265\3[\3[\3"+
		"\\\3\\\7\\\u026c\n\\\f\\\16\\\u026f\13\\\3\\\3\\\2\2]\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K"+
		"\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177"+
		"A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091\2\u0093"+
		"\2\u0095\2\u0097\2\u0099\2\u009b\2\u009dJ\u009f\2\u00a1K\u00a3\2\u00a5"+
		"L\u00a7\2\u00a9M\u00ab\2\u00ad\2\u00af\2\u00b1N\u00b3O\u00b5P\u00b7Q\3"+
		"\2\33\3\2\62\62\3\2\63;\4\2ZZzz\5\2\62;CHch\3\2\629\4\2DDdd\3\2\62\63"+
		"\4\2GGgg\4\2--//\3\2))\6\2\f\f\17\17))^^\3\2bb\5\2\f\f\17\17bb\3\2$$\6"+
		"\2\f\f\17\17$$^^\3\2^^\n\2$$))^^ddhhppttvv\3\2\62\65\4\2VVvv\3\2VV\4\2"+
		"C\\c|\6\2\62;C\\aac|\5\2\13\f\16\17\"\"\3\2%%\4\2\f\f\17\17\u0283\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3"+
		"\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2"+
		"\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2"+
		"o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3"+
		"\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2"+
		"\2\2\u008f\3\2\2\2\2\u009d\3\2\2\2\2\u00a1\3\2\2\2\2\u00a5\3\2\2\2\2\u00a9"+
		"\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2"+
		"\2\3\u00b9\3\2\2\2\5\u00bc\3\2\2\2\7\u00bf\3\2\2\2\t\u00c2\3\2\2\2\13"+
		"\u00c6\3\2\2\2\r\u00cc\3\2\2\2\17\u00d0\3\2\2\2\21\u00d4\3\2\2\2\23\u00dc"+
		"\3\2\2\2\25\u00e2\3\2\2\2\27\u00e9\3\2\2\2\31\u00ed\3\2\2\2\33\u00f2\3"+
		"\2\2\2\35\u00f7\3\2\2\2\37\u00fc\3\2\2\2!\u0103\3\2\2\2#\u010a\3\2\2\2"+
		"%\u0110\3\2\2\2\'\u0116\3\2\2\2)\u011c\3\2\2\2+\u0123\3\2\2\2-\u012a\3"+
		"\2\2\2/\u0131\3\2\2\2\61\u0138\3\2\2\2\63\u0140\3\2\2\2\65\u0149\3\2\2"+
		"\2\67\u0152\3\2\2\29\u015a\3\2\2\2;\u0161\3\2\2\2=\u0167\3\2\2\2?\u016c"+
		"\3\2\2\2A\u0171\3\2\2\2C\u0173\3\2\2\2E\u0175\3\2\2\2G\u0177\3\2\2\2I"+
		"\u0179\3\2\2\2K\u017b\3\2\2\2M\u017d\3\2\2\2O\u017f\3\2\2\2Q\u0181\3\2"+
		"\2\2S\u0183\3\2\2\2U\u0185\3\2\2\2W\u0188\3\2\2\2Y\u018a\3\2\2\2[\u018d"+
		"\3\2\2\2]\u0191\3\2\2\2_\u0193\3\2\2\2a\u0196\3\2\2\2c\u0199\3\2\2\2e"+
		"\u019c\3\2\2\2g\u019f\3\2\2\2i\u01a2\3\2\2\2k\u01a4\3\2\2\2m\u01a7\3\2"+
		"\2\2o\u01a9\3\2\2\2q\u01ac\3\2\2\2s\u01ae\3\2\2\2u\u01b0\3\2\2\2w\u01b2"+
		"\3\2\2\2y\u01b4\3\2\2\2{\u01b6\3\2\2\2}\u01b8\3\2\2\2\177\u01bb\3\2\2"+
		"\2\u0081\u01bd\3\2\2\2\u0083\u01bf\3\2\2\2\u0085\u01c1\3\2\2\2\u0087\u01c3"+
		"\3\2\2\2\u0089\u01c5\3\2\2\2\u008b\u01c7\3\2\2\2\u008d\u01ca\3\2\2\2\u008f"+
		"\u01d1\3\2\2\2\u0091\u01d3\3\2\2\2\u0093\u01dc\3\2\2\2\u0095\u01de\3\2"+
		"\2\2\u0097\u01e0\3\2\2\2\u0099\u01e7\3\2\2\2\u009b\u01ee\3\2\2\2\u009d"+
		"\u0214\3\2\2\2\u009f\u0216\3\2\2\2\u00a1\u0227\3\2\2\2\u00a3\u0229\3\2"+
		"\2\2\u00a5\u022b\3\2\2\2\u00a7\u0234\3\2\2\2\u00a9\u0236\3\2\2\2\u00ab"+
		"\u0241\3\2\2\2\u00ad\u0246\3\2\2\2\u00af\u0251\3\2\2\2\u00b1\u0259\3\2"+
		"\2\2\u00b3\u025b\3\2\2\2\u00b5\u0263\3\2\2\2\u00b7\u0269\3\2\2\2\u00b9"+
		"\u00ba\7q\2\2\u00ba\u00bb\7h\2\2\u00bb\4\3\2\2\2\u00bc\u00bd\7k\2\2\u00bd"+
		"\u00be\7h\2\2\u00be\6\3\2\2\2\u00bf\u00c0\7f\2\2\u00c0\u00c1\7q\2\2\u00c1"+
		"\b\3\2\2\2\u00c2\u00c3\7o\2\2\u00c3\u00c4\7c\2\2\u00c4\u00c5\7r\2\2\u00c5"+
		"\n\3\2\2\2\u00c6\u00c7\7u\2\2\u00c7\u00c8\7v\2\2\u00c8\u00c9\7c\2\2\u00c9"+
		"\u00ca\7e\2\2\u00ca\u00cb\7m\2\2\u00cb\f\3\2\2\2\u00cc\u00cd\7u\2\2\u00cd"+
		"\u00ce\7g\2\2\u00ce\u00cf\7v\2\2\u00cf\16\3\2\2\2\u00d0\u00d1\7h\2\2\u00d1"+
		"\u00d2\7q\2\2\u00d2\u00d3\7t\2\2\u00d3\20\3\2\2\2\u00d4\u00d5\7h\2\2\u00d5"+
		"\u00d6\7q\2\2\u00d6\u00d7\7t\2\2\u00d7\u00d8\7g\2\2\u00d8\u00d9\7c\2\2"+
		"\u00d9\u00da\7e\2\2\u00da\u00db\7j\2\2\u00db\22\3\2\2\2\u00dc\u00dd\7"+
		"k\2\2\u00dd\u00de\7h\2\2\u00de\u00df\7c\2\2\u00df\u00e0\7n\2\2\u00e0\u00e1"+
		"\7n\2\2\u00e1\24\3\2\2\2\u00e2\u00e3\7g\2\2\u00e3\u00e4\7z\2\2\u00e4\u00e5"+
		"\7k\2\2\u00e5\u00e6\7u\2\2\u00e6\u00e7\7v\2\2\u00e7\u00e8\7u\2\2\u00e8"+
		"\26\3\2\2\2\u00e9\u00ea\7p\2\2\u00ea\u00eb\7q\2\2\u00eb\u00ec\7v\2\2\u00ec"+
		"\30\3\2\2\2\u00ed\u00ee\7v\2\2\u00ee\u00ef\7{\2\2\u00ef\u00f0\7r\2\2\u00f0"+
		"\u00f1\7g\2\2\u00f1\32\3\2\2\2\u00f2\u00f3\7g\2\2\u00f3\u00f4\7n\2\2\u00f4"+
		"\u00f5\7u\2\2\u00f5\u00f6\7g\2\2\u00f6\34\3\2\2\2\u00f7\u00f8\7e\2\2\u00f8"+
		"\u00f9\7c\2\2\u00f9\u00fa\7u\2\2\u00fa\u00fb\7g\2\2\u00fb\36\3\2\2\2\u00fc"+
		"\u00fd\7q\2\2\u00fd\u00fe\7w\2\2\u00fe\u00ff\7v\2\2\u00ff\u0100\7r\2\2"+
		"\u0100\u0101\7w\2\2\u0101\u0102\7v\2\2\u0102 \3\2\2\2\u0103\u0104\7h\2"+
		"\2\u0104\u0105\7q\2\2\u0105\u0106\7t\2\2\u0106\u0107\7o\2\2\u0107\u0108"+
		"\7c\2\2\u0108\u0109\7v\2\2\u0109\"\3\2\2\2\u010a\u010b\7y\2\2\u010b\u010c"+
		"\7j\2\2\u010c\u010d\7k\2\2\u010d\u010e\7n\2\2\u010e\u010f\7g\2\2\u010f"+
		"$\3\2\2\2\u0110\u0111\7d\2\2\u0111\u0112\7t\2\2\u0112\u0113\7g\2\2\u0113"+
		"\u0114\7c\2\2\u0114\u0115\7m\2\2\u0115&\3\2\2\2\u0116\u0117\7c\2\2\u0117"+
		"\u0118\7t\2\2\u0118\u0119\7t\2\2\u0119\u011a\7c\2\2\u011a\u011b\7{\2\2"+
		"\u011b(\3\2\2\2\u011c\u011d\7u\2\2\u011d\u011e\7v\2\2\u011e\u011f\7c\2"+
		"\2\u011f\u0120\7v\2\2\u0120\u0121\7k\2\2\u0121\u0122\7e\2\2\u0122*\3\2"+
		"\2\2\u0123\u0124\7u\2\2\u0124\u0125\7y\2\2\u0125\u0126\7k\2\2\u0126\u0127"+
		"\7v\2\2\u0127\u0128\7e\2\2\u0128\u0129\7j\2\2\u0129,\3\2\2\2\u012a\u012b"+
		"\7t\2\2\u012b\u012c\7g\2\2\u012c\u012d\7v\2\2\u012d\u012e\7w\2\2\u012e"+
		"\u012f\7t\2\2\u012f\u0130\7p\2\2\u0130.\3\2\2\2\u0131\u0132\7y\2\2\u0132"+
		"\u0133\7g\2\2\u0133\u0134\7k\2\2\u0134\u0135\7i\2\2\u0135\u0136\7j\2\2"+
		"\u0136\u0137\7v\2\2\u0137\60\3\2\2\2\u0138\u0139\7f\2\2\u0139\u013a\7"+
		"g\2\2\u013a\u013b\7h\2\2\u013b\u013c\7c\2\2\u013c\u013d\7w\2\2\u013d\u013e"+
		"\7n\2\2\u013e\u013f\7v\2\2\u013f\62\3\2\2\2\u0140\u0141\7e\2\2\u0141\u0142"+
		"\7q\2\2\u0142\u0143\7p\2\2\u0143\u0144\7v\2\2\u0144\u0145\7k\2\2\u0145"+
		"\u0146\7p\2\2\u0146\u0147\7w\2\2\u0147\u0148\7g\2\2\u0148\64\3\2\2\2\u0149"+
		"\u014a\7h\2\2\u014a\u014b\7w\2\2\u014b\u014c\7p\2\2\u014c\u014d\7e\2\2"+
		"\u014d\u014e\7v\2\2\u014e\u014f\7k\2\2\u014f\u0150\7q\2\2\u0150\u0151"+
		"\7p\2\2\u0151\66\3\2\2\2\u0152\u0153\7x\2\2\u0153\u0154\7k\2\2\u0154\u0155"+
		"\7u\2\2\u0155\u0156\7k\2\2\u0156\u0157\7v\2\2\u0157\u0158\7q\2\2\u0158"+
		"\u0159\7t\2\2\u01598\3\2\2\2\u015a\u015b\7d\2\2\u015b\u015c\7g\2\2\u015c"+
		"\u015d\7h\2\2\u015d\u015e\7q\2\2\u015e\u015f\7t\2\2\u015f\u0160\7g\2\2"+
		"\u0160:\3\2\2\2\u0161\u0162\7c\2\2\u0162\u0163\7h\2\2\u0163\u0164\7v\2"+
		"\2\u0164\u0165\7g\2\2\u0165\u0166\7t\2\2\u0166<\3\2\2\2\u0167\u0168\7"+
		"u\2\2\u0168\u0169\7v\2\2\u0169\u016a\7q\2\2\u016a\u016b\7r\2\2\u016b>"+
		"\3\2\2\2\u016c\u016d\7g\2\2\u016d\u016e\7p\2\2\u016e\u016f\7w\2\2\u016f"+
		"\u0170\7o\2\2\u0170@\3\2\2\2\u0171\u0172\7=\2\2\u0172B\3\2\2\2\u0173\u0174"+
		"\7<\2\2\u0174D\3\2\2\2\u0175\u0176\7.\2\2\u0176F\3\2\2\2\u0177\u0178\7"+
		"\60\2\2\u0178H\3\2\2\2\u0179\u017a\7}\2\2\u017aJ\3\2\2\2\u017b\u017c\7"+
		"\177\2\2\u017cL\3\2\2\2\u017d\u017e\7*\2\2\u017eN\3\2\2\2\u017f\u0180"+
		"\7+\2\2\u0180P\3\2\2\2\u0181\u0182\7]\2\2\u0182R\3\2\2\2\u0183\u0184\7"+
		"_\2\2\u0184T\3\2\2\2\u0185\u0186\7q\2\2\u0186\u0187\7t\2\2\u0187V\3\2"+
		"\2\2\u0188\u0189\7~\2\2\u0189X\3\2\2\2\u018a\u018b\7~\2\2\u018b\u018c"+
		"\7~\2\2\u018cZ\3\2\2\2\u018d\u018e\7c\2\2\u018e\u018f\7p\2\2\u018f\u0190"+
		"\7f\2\2\u0190\\\3\2\2\2\u0191\u0192\7(\2\2\u0192^\3\2\2\2\u0193\u0194"+
		"\7(\2\2\u0194\u0195\7(\2\2\u0195`\3\2\2\2\u0196\u0197\7-\2\2\u0197\u0198"+
		"\7-\2\2\u0198b\3\2\2\2\u0199\u019a\7/\2\2\u019a\u019b\7/\2\2\u019bd\3"+
		"\2\2\2\u019c\u019d\7?\2\2\u019d\u019e\7?\2\2\u019ef\3\2\2\2\u019f\u01a0"+
		"\7#\2\2\u01a0\u01a1\7?\2\2\u01a1h\3\2\2\2\u01a2\u01a3\7>\2\2\u01a3j\3"+
		"\2\2\2\u01a4\u01a5\7>\2\2\u01a5\u01a6\7?\2\2\u01a6l\3\2\2\2\u01a7\u01a8"+
		"\7@\2\2\u01a8n\3\2\2\2\u01a9\u01aa\7@\2\2\u01aa\u01ab\7?\2\2\u01abp\3"+
		"\2\2\2\u01ac\u01ad\7-\2\2\u01adr\3\2\2\2\u01ae\u01af\7/\2\2\u01aft\3\2"+
		"\2\2\u01b0\u01b1\7`\2\2\u01b1v\3\2\2\2\u01b2\u01b3\7,\2\2\u01b3x\3\2\2"+
		"\2\u01b4\u01b5\7\61\2\2\u01b5z\3\2\2\2\u01b6\u01b7\7\'\2\2\u01b7|\3\2"+
		"\2\2\u01b8\u01b9\7@\2\2\u01b9\u01ba\7@\2\2\u01ba~\3\2\2\2\u01bb\u01bc"+
		"\7\u0080\2\2\u01bc\u0080\3\2\2\2\u01bd\u01be\7#\2\2\u01be\u0082\3\2\2"+
		"\2\u01bf\u01c0\7a\2\2\u01c0\u0084\3\2\2\2\u01c1\u01c2\7A\2\2\u01c2\u0086"+
		"\3\2\2\2\u01c3\u01c4\7&\2\2\u01c4\u0088\3\2\2\2\u01c5\u01c6\7?\2\2\u01c6"+
		"\u008a\3\2\2\2\u01c7\u01c8\7>\2\2\u01c8\u01c9\7>\2\2\u01c9\u008c\3\2\2"+
		"\2\u01ca\u01cb\7/\2\2\u01cb\u01cc\7@\2\2\u01cc\u008e\3\2\2\2\u01cd\u01d2"+
		"\5\u0091I\2\u01ce\u01d2\5\u0097L\2\u01cf\u01d2\5\u0099M\2\u01d0\u01d2"+
		"\5\u009bN\2\u01d1\u01cd\3\2\2\2\u01d1\u01ce\3\2\2\2\u01d1\u01cf\3\2\2"+
		"\2\u01d1\u01d0\3\2\2\2\u01d2\u0090\3\2\2\2\u01d3\u01d7\5\u0095K\2\u01d4"+
		"\u01d6\5\u0093J\2\u01d5\u01d4\3\2\2\2\u01d6\u01d9\3\2\2\2\u01d7\u01d5"+
		"\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u0092\3\2\2\2\u01d9\u01d7\3\2\2\2\u01da"+
		"\u01dd\t\2\2\2\u01db\u01dd\5\u0095K\2\u01dc\u01da\3\2\2\2\u01dc\u01db"+
		"\3\2\2\2\u01dd\u0094\3\2\2\2\u01de\u01df\t\3\2\2\u01df\u0096\3\2\2\2\u01e0"+
		"\u01e1\t\2\2\2\u01e1\u01e3\t\4\2\2\u01e2\u01e4\t\5\2\2\u01e3\u01e2\3\2"+
		"\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6"+
		"\u0098\3\2\2\2\u01e7\u01eb\t\2\2\2\u01e8\u01ea\t\6\2\2\u01e9\u01e8\3\2"+
		"\2\2\u01ea\u01ed\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec"+
		"\u009a\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ee\u01ef\t\2\2\2\u01ef\u01f1\t\7"+
		"\2\2\u01f0\u01f2\t\b\2\2\u01f1\u01f0\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3"+
		"\u01f1\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u009c\3\2\2\2\u01f5\u01f7\5\u0093"+
		"J\2\u01f6\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f8"+
		"\u01f9\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01fe\5G$\2\u01fb\u01fd\5\u0093"+
		"J\2\u01fc\u01fb\3\2\2\2\u01fd\u0200\3\2\2\2\u01fe\u01fc\3\2\2\2\u01fe"+
		"\u01ff\3\2\2\2\u01ff\u0202\3\2\2\2\u0200\u01fe\3\2\2\2\u0201\u0203\5\u009f"+
		"P\2\u0202\u0201\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0215\3\2\2\2\u0204"+
		"\u0206\5G$\2\u0205\u0207\5\u0093J\2\u0206\u0205\3\2\2\2\u0207\u0208\3"+
		"\2\2\2\u0208\u0206\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020b\3\2\2\2\u020a"+
		"\u020c\5\u009fP\2\u020b\u020a\3\2\2\2\u020b\u020c\3\2\2\2\u020c\u0215"+
		"\3\2\2\2\u020d\u020f\5\u0093J\2\u020e\u020d\3\2\2\2\u020f\u0210\3\2\2"+
		"\2\u0210\u020e\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0213"+
		"\5\u009fP\2\u0213\u0215\3\2\2\2\u0214\u01f6\3\2\2\2\u0214\u0204\3\2\2"+
		"\2\u0214\u020e\3\2\2\2\u0215\u009e\3\2\2\2\u0216\u0218\t\t\2\2\u0217\u0219"+
		"\t\n\2\2\u0218\u0217\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u021b\3\2\2\2\u021a"+
		"\u021c\5\u0093J\2\u021b\u021a\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u021b"+
		"\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u00a0\3\2\2\2\u021f\u0220\t\13\2\2"+
		"\u0220\u0221\5\u00a3R\2\u0221\u0222\t\13\2\2\u0222\u0228\3\2\2\2\u0223"+
		"\u0224\t\13\2\2\u0224\u0225\5\u00adW\2\u0225\u0226\t\13\2\2\u0226\u0228"+
		"\3\2\2\2\u0227\u021f\3\2\2\2\u0227\u0223\3\2\2\2\u0228\u00a2\3\2\2\2\u0229"+
		"\u022a\n\f\2\2\u022a\u00a4\3\2\2\2\u022b\u022f\t\r\2\2\u022c\u022e\5\u00a7"+
		"T\2\u022d\u022c\3\2\2\2\u022e\u0231\3\2\2\2\u022f\u022d\3\2\2\2\u022f"+
		"\u0230\3\2\2\2\u0230\u0232\3\2\2\2\u0231\u022f\3\2\2\2\u0232\u0233\t\r"+
		"\2\2\u0233\u00a6\3\2\2\2\u0234\u0235\n\16\2\2\u0235\u00a8\3\2\2\2\u0236"+
		"\u023a\t\17\2\2\u0237\u0239\5\u00abV\2\u0238\u0237\3\2\2\2\u0239\u023c"+
		"\3\2\2\2\u023a\u0238\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u023d\3\2\2\2\u023c"+
		"\u023a\3\2\2\2\u023d\u023e\t\17\2\2\u023e\u00aa\3\2\2\2\u023f\u0242\n"+
		"\20\2\2\u0240\u0242\5\u00adW\2\u0241\u023f\3\2\2\2\u0241\u0240\3\2\2\2"+
		"\u0242\u00ac\3\2\2\2\u0243\u0244\t\21\2\2\u0244\u0247\t\22\2\2\u0245\u0247"+
		"\5\u00afX\2\u0246\u0243\3\2\2\2\u0246\u0245\3\2\2\2\u0247\u00ae\3\2\2"+
		"\2\u0248\u0249\t\21\2\2\u0249\u0252\t\6\2\2\u024a\u024b\t\21\2\2\u024b"+
		"\u024c\t\6\2\2\u024c\u0252\t\6\2\2\u024d\u024e\t\21\2\2\u024e\u024f\t"+
		"\23\2\2\u024f\u0250\t\6\2\2\u0250\u0252\t\6\2\2\u0251\u0248\3\2\2\2\u0251"+
		"\u024a\3\2\2\2\u0251\u024d\3\2\2\2\u0252\u00b0\3\2\2\2\u0253\u0255\5\u008f"+
		"H\2\u0254\u0256\t\24\2\2\u0255\u0254\3\2\2\2\u0255\u0256\3\2\2\2\u0256"+
		"\u025a\3\2\2\2\u0257\u0258\t\25\2\2\u0258\u025a\5\u00a9U\2\u0259\u0253"+
		"\3\2\2\2\u0259\u0257\3\2\2\2\u025a\u00b2\3\2\2\2\u025b\u025f\t\26\2\2"+
		"\u025c\u025e\t\27\2\2\u025d\u025c\3\2\2\2\u025e\u0261\3\2\2\2\u025f\u025d"+
		"\3\2\2\2\u025f\u0260\3\2\2\2\u0260\u00b4\3\2\2\2\u0261\u025f\3\2\2\2\u0262"+
		"\u0264\t\30\2\2\u0263\u0262\3\2\2\2\u0264\u0265\3\2\2\2\u0265\u0263\3"+
		"\2\2\2\u0265\u0266\3\2\2\2\u0266\u0267\3\2\2\2\u0267\u0268\b[\2\2\u0268"+
		"\u00b6\3\2\2\2\u0269\u026d\t\31\2\2\u026a\u026c\n\32\2\2\u026b\u026a\3"+
		"\2\2\2\u026c\u026f\3\2\2\2\u026d\u026b\3\2\2\2\u026d\u026e\3\2\2\2\u026e"+
		"\u0270\3\2\2\2\u026f\u026d\3\2\2\2\u0270\u0271\b\\\2\2\u0271\u00b8\3\2"+
		"\2\2\35\2\u01d1\u01d7\u01dc\u01e5\u01eb\u01f3\u01f8\u01fe\u0202\u0208"+
		"\u020b\u0210\u0214\u0218\u021d\u0227\u022f\u023a\u0241\u0246\u0251\u0255"+
		"\u0259\u025f\u0265\u026d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}