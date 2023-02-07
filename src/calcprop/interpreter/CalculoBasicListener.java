package calcprop.interpreter;

import java.util.Stack;

import calcprop.form.*;

public class CalculoBasicListener extends CalculoBaseListener {
    private final Stack<Formula> formulas = new Stack<>();

    public Formula getFormula() {
        return formulas.pop();
    }

    @Override
    public void exitAtomo(CalculoParser.AtomoContext ctx) {
        formulas.add(new Atomo(ctx.ATOMO().getText()));
    }

    @Override
    public void exitUnario(CalculoParser.UnarioContext ctx) {
        formulas.add(new ConectivoUnario(formulas.pop()));
    }

    @Override
    public void exitBinario(CalculoParser.BinarioContext ctx) {
        Conectivo conectivo = null;
        switch (ctx.conectivo_binario().getText().charAt(0)) {
            case '∧' -> conectivo = Conectivo.AND;
            case '∨' -> conectivo = Conectivo.OR;
            case '→' -> conectivo = Conectivo.IMPLIES;
            case '↔' -> conectivo = Conectivo.IFF;
            case '⊕' -> conectivo = Conectivo.XOR;
            case '|' -> conectivo = Conectivo.NAND;
            case '↓' -> conectivo = Conectivo.NOR;
        }
        Formula f2 = formulas.pop();
        Formula f1 = formulas.pop();
        formulas.add(new ConectivoBinario(conectivo, f1, f2));
    }

    @Override
    public void exitConjuncion(CalculoParser.ConjuncionContext ctx) {
        Conectivo conectivo = Conectivo.AND;
        for (int i = 0; i < ctx.AND().size(); i++) {
            Formula f2 = formulas.pop();
            Formula f1 = formulas.pop();
            formulas.add(new ConectivoBinario(conectivo, f1, f2));
        }
    }

    @Override
    public void exitDisyuncion(CalculoParser.DisyuncionContext ctx) {
        Conectivo conectivo = Conectivo.OR;
        for (int i = 0; i < ctx.OR().size(); i++) {
            Formula f2 = formulas.pop();
            Formula f1 = formulas.pop();
            formulas.add(new ConectivoBinario(conectivo, f1, f2));
        }
    }
}
