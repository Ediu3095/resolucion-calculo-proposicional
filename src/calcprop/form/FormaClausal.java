package calcprop.form;

import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.misc.Triple;

import java.util.*;

public class FormaClausal {
    private final Set<Clausula> clausulas;

    public FormaClausal() {
        this.clausulas = new HashSet<>();
    }

    public void addClausula(Clausula clausula) {
        this.clausulas.add(clausula);
    }

    public static FormaClausal fromFormula(Formula formula) {
        Formula f = formula.toFormaNormalCojuntiva();
        FormaClausal sol = new FormaClausal();
        Stack<Formula> conjunciones = new Stack<>();
        Stack<Formula> disyunciones = new Stack<>();
        conjunciones.push(f);
        Clausula c;
        while (!(conjunciones.isEmpty())) {
            f = conjunciones.pop();
            if (f instanceof ConectivoBinario cb && cb.conectivo == Conectivo.AND) {
                    conjunciones.push(cb.f2);
                    conjunciones.push(cb.f1);
            } else {
                disyunciones.push(f);
                c = new Clausula();
                while (!(disyunciones.isEmpty())) {
                    f = disyunciones.pop();
                    if (f instanceof ConectivoBinario cb && cb.conectivo == Conectivo.OR) {
                        disyunciones.push(cb.f2);
                        disyunciones.push(cb.f1);
                    } else if (f instanceof ConectivoUnario cu && cu.f1 instanceof Atomo a) {
                        c.addAtomo(a.nombre, true);
                    } else if (f instanceof Atomo a) {
                        c.addAtomo(a.nombre, false);
                    } else {
                        throw new RuntimeException("Error al construir la forma clausal de la formula: " + formula);
                    }
                }
                sol.addClausula(c);
            }
        }
        return sol;
    }

    public List<Triple<Clausula, Pair<Integer, Integer>, Integer>> resolucion() {
        List<Triple<Clausula, Pair<Integer, Integer>, Integer>> sol = new ArrayList<>();
        Set<Clausula> aux = new HashSet<>(this.clausulas);
        Set<Pair<Integer, Integer>> comb = new HashSet<>();
        HashMap<Clausula, Integer> pos = new HashMap<>();
        int temp = 0;
        for (Clausula c : clausulas) {
            sol.add(new Triple<>(c, null, null));
            pos.put(c, temp++);
        }
        boolean cambio = true;
        while (cambio) {
            cambio = false;
            for (int i = 0; i < sol.size(); i++) {
                Clausula c1 = sol.get(i).a;
                for (int j = i + 1; j < sol.size(); j++) {
                    Clausula c2 = sol.get(j).a;
                    Pair<Integer, Integer> p = new Pair<>(i, j);
                    List<Clausula> res = c1.resolvente(c2);
                    for (Clausula c : res) {
                        if (!aux.contains(c)) {
                            aux.add(c);
                            pos.put(c, temp++);
                            comb.add(p);
                            sol.add(new Triple<>(c, p, null));
                            if (c.isEmpty())
                                return sol;
                            cambio = true;
                        } else if (!comb.contains(p)) {
                            sol.add(new Triple<>(c, p, pos.get(c)));
                        }
                    }
                }
            }
        }
        return sol;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Clausula clausula : clausulas) {
            sb.append(clausula.toString());
            sb.append(", ");
        }
        sb.replace(sb.length() - 2, sb.length(), "}");
        return sb.toString();
    }
}
