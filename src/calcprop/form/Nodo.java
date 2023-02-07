package calcprop.form;

import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.*;

/** Clase que modela los nodos de un tablero semantico */
public class Nodo {
    private final List<Formula> formulas = new ArrayList<>();
    private final List<Nodo> hijos = new ArrayList<>();
    private boolean cerrado = false;
    private final String id;

    public Nodo(Formula formula) {
        formulas.add(formula);
        id = "1";
    }

    private Nodo(List<Formula> formulas, String id) {
        this.formulas.addAll(formulas);
        this.id = id;
    }

    public void desarrollar() {
        // Antes de desarrollar el nodo eliminamos las formulas duplicadas
        for (int i = 0; i < formulas.size(); i++)
            for (int j = 0; j < i; j++)
                if (formulas.get(i).equals(formulas.get(j)))
                    formulas.remove(i--);

        // Antes de aplicar α-reglas o β-reglas, comprobamos que la rama no sea cerrada
        List<Atomo> atomos = new ArrayList<>();
        for (Formula f : formulas)
            if (f instanceof Atomo)
                atomos.add((Atomo) f);
        List<ConectivoUnario> conectivosUnarios = new ArrayList<>();
        for (Formula f : formulas)
            if (f instanceof ConectivoUnario)
                conectivosUnarios.add((ConectivoUnario) f);
        List<Atomo> atomosNegados = conectivosUnarios.stream()
                .map(ConectivoUnario::getFormula)
                .filter(f -> f instanceof Atomo)
                .map(f -> (Atomo)f)
                .toList();
        for (Atomo an : atomosNegados)
            for (Atomo a : atomos)
                if (an.equals(a)) {
                    cerrado = true;
                    return;
                }

        // Primero intentamos aplicar α-reglas
        List<Formula> formulasHijos = new ArrayList<>();
        Formula alpha = null;
        for (Formula formula : formulas)
            if (formula.isAlpha()) {
                alpha = formula;
                break;
            }
        if (alpha != null) {
            for (Formula f : formulas) {
                if (f.equals(alpha))
                    formulasHijos.addAll(alpha.desarrollar());
                else
                    formulasHijos.add(f);
            }
            Nodo h1 = new Nodo(formulasHijos, id + "1");
            h1.desarrollar();
            hijos.add(h1);
            return;
        }

        // Si no se puede aplicar α-regla, intentamos aplicar β-reglas
        Formula beta = null;
        for (Formula formula : formulas)
            if (formula.isBeta()) {
                beta = formula;
                break;
            }
        if (beta != null) {
            List<Formula> formulasHijosBeta = beta.desarrollar();
            for (Formula f : formulas) {
                if (f.equals(beta))
                    formulasHijos.add(formulasHijosBeta.get(0));
                else
                    formulasHijos.add(f);
            }
            Nodo h1 = new Nodo(formulasHijos, id + "1");
            h1.desarrollar();
            hijos.add(h1);
            formulasHijos.clear();
            for (Formula f : formulas) {
                if (f.equals(beta))
                    formulasHijos.add(formulasHijosBeta.get(1));
                else
                    formulasHijos.add(f);
            }
            Nodo h2 = new Nodo(formulasHijos, id + "2");
            h2.desarrollar();
            hijos.add(h2);
            return;
        }

        // Si no se puede aplicar α-regla ni β-regla, la rama es abierta
        cerrado = false;
    }

    public String toGraphviz() {
        StringBuilder str = new StringBuilder(this.toString());
        for (Nodo n : hijos)
            str.append(n.toGraphviz());
        return str.toString();
    }

    @Override
    public String toString() {
        StringBuilder sol = new StringBuilder();

        // Detalles del nodo actual
        sol.append("\t").append(id).append(" [label=\"");
        for (Formula f : formulas)
            sol.append(f).append(", ");
        sol.delete(sol.length() - 2, sol.length());
        if (hijos.size() == 0 && cerrado)
            sol.append("\\n×\""); // fillcolor="#FF5656"
        else if (hijos.size() == 0)
            sol.append("\\n⨀\""); // fillcolor="#6A7EFC"
        else
            sol.append("\""); // fillcolor="#EDF2F6"
        sol.append(" style=\"transparent\" penwidth=0 fontname=\"DejaVu Math Tex Gyre, Cambria Math, Latin Modern, XITS Math, Asana Math, Lucida Console\"");
        sol.append("];\n");

        // Conexiones con nodos hijos
        for (Nodo h : hijos)
            sol.append("\t").append(id).append(" -> ").append(h.id).append(";\n");

        return sol.toString();
    }
}
