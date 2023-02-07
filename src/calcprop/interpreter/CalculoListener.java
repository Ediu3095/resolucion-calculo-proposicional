// Generated from java-escape by ANTLR 4.11.1
package calcprop.interpreter;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculoParser}.
 */
public interface CalculoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code atomo}
	 * labeled alternative in {@link CalculoParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAtomo(CalculoParser.AtomoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomo}
	 * labeled alternative in {@link CalculoParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAtomo(CalculoParser.AtomoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unario}
	 * labeled alternative in {@link CalculoParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterUnario(CalculoParser.UnarioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unario}
	 * labeled alternative in {@link CalculoParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitUnario(CalculoParser.UnarioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binario}
	 * labeled alternative in {@link CalculoParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterBinario(CalculoParser.BinarioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binario}
	 * labeled alternative in {@link CalculoParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitBinario(CalculoParser.BinarioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conjuncion}
	 * labeled alternative in {@link CalculoParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterConjuncion(CalculoParser.ConjuncionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conjuncion}
	 * labeled alternative in {@link CalculoParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitConjuncion(CalculoParser.ConjuncionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code disyuncion}
	 * labeled alternative in {@link CalculoParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterDisyuncion(CalculoParser.DisyuncionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code disyuncion}
	 * labeled alternative in {@link CalculoParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitDisyuncion(CalculoParser.DisyuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculoParser#conectivo_binario}.
	 * @param ctx the parse tree
	 */
	void enterConectivo_binario(CalculoParser.Conectivo_binarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculoParser#conectivo_binario}.
	 * @param ctx the parse tree
	 */
	void exitConectivo_binario(CalculoParser.Conectivo_binarioContext ctx);
}