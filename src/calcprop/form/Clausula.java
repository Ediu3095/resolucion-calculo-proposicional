package calcprop.form;

import org.antlr.v4.runtime.misc.Pair;

import java.util.*;

public class Clausula {
    private final Set<Pair<String, Boolean>> atomos;

    public Clausula() {
        this.atomos = new HashSet<>();
    }

    public void addAtomo(String atomo, boolean negado) {
        this.atomos.add(new Pair<>(atomo, negado));
    }

    public List<Clausula> resolvente(Clausula clausula) {
        List<Clausula> sol = new ArrayList<>();
        for (Pair<String, Boolean> atomo : this.atomos) {
            Pair<String, Boolean> atomo2 = new Pair<>(atomo.a, !atomo.b);
            if (clausula.atomos.contains(atomo2)) {
                Clausula c = new Clausula();
                for (Pair<String, Boolean> aux : this.atomos)
                    if (!atomo.equals(aux))
                        c.addAtomo(aux.a, aux.b);
                for (Pair<String, Boolean> aux : clausula.atomos)
                    if (!atomo2.equals(aux))
                        c.addAtomo(aux.a, aux.b);
                sol.add(c);
            }
        }
        return sol;
    }

    public boolean isEmpty() {
        return this.atomos.isEmpty();
    }

    public Formula toFormula() {
        Formula f = null;
        for (Pair<String, Boolean> atomo : this.atomos) {
            if (f == null) {
                if (atomo.b)
                    f = new ConectivoUnario(new Atomo(atomo.a));
                else
                    f = new Atomo(atomo.a);
            } else {
                if (atomo.b)
                    f = new ConectivoBinario(Conectivo.OR, f, new ConectivoUnario(new Atomo(atomo.a)));
                else
                    f = new ConectivoBinario(Conectivo.OR, f, new Atomo(atomo.a));
            }
        }
        return f;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (atomos.isEmpty())
            sb.append("□");
        else
            for (Pair<String, Boolean> atomo : atomos) {
                sb.append(atomo.a);
                if (atomo.b)
                    sb.append("\u0304");
            }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clausula clausula = (Clausula) o;
        return atomos.equals(clausula.atomos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atomos);
    }
}
