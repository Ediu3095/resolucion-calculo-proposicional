package calcprop.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConectivoUnario extends Formula {
    protected final Formula f1;

    public ConectivoUnario(Formula f1) {
        this.f1 = f1;
    }

    public Formula getFormula() {
        return f1;
    }

    @Override
    public Formula toConjuncionDisyuncion() {
        return new ConectivoUnario(f1.toConjuncionDisyuncion());
    }

    @Override
    public Formula applyLeyesDeMorgan() {
        Formula sol = null;
        if (f1 instanceof ConectivoUnario cu) {
            sol = cu.f1.applyLeyesDeMorgan(); // Ademas de aplicar las leyes de morgan se eliminan los dobles negadores
        } else if (f1 instanceof ConectivoBinario cb) {
            switch (cb.conectivo) {
                case AND ->
                    sol = new ConectivoBinario(Conectivo.OR, new ConectivoUnario(cb.f1).applyLeyesDeMorgan(), new ConectivoUnario(cb.f2).applyLeyesDeMorgan());
                case OR ->
                    sol = new ConectivoBinario(Conectivo.AND, new ConectivoUnario(cb.f1).applyLeyesDeMorgan(), new ConectivoUnario(cb.f2).applyLeyesDeMorgan());
                case IMPLIES, NAND, NOR, IFF, XOR ->
                    throw new RuntimeException("No se pueden aplicar las leyes de morgan en la formula: " + this);
            }
        } else if (f1 instanceof Atomo) {
            sol = this;
        }
        return sol;
    }

    @Override
    public Formula applyPropiedadDistributiva() {
        if (f1 instanceof Atomo)
            return this;
        else
            throw new RuntimeException("No se puede aplicar la propiedad distributiva sobre la formula: " + this);
    }

    @Override
    public List<Formula> desarrollar() throws RuntimeException {
        List<Formula> formulas = new ArrayList<>();
        if (f1 instanceof ConectivoUnario cu) {
            formulas.add(cu.f1);
        } else if (f1 instanceof ConectivoBinario cb) {
            switch (cb.conectivo) {
                case AND, OR -> {
                    formulas.add(new ConectivoUnario(cb.f1));
                    formulas.add(new ConectivoUnario(cb.f2));
                }
                case IMPLIES -> {
                    formulas.add(cb.f1);
                    formulas.add(new ConectivoUnario(cb.f2));
                }
                case NAND, NOR -> {
                    formulas.add(cb.f1);
                    formulas.add(cb.f2);
                }
                case IFF -> {
                    formulas.add(new ConectivoUnario(new ConectivoBinario(Conectivo.IMPLIES, cb.f1, cb.f2)));
                    formulas.add(new ConectivoUnario(new ConectivoBinario(Conectivo.IMPLIES, cb.f2, cb.f1)));
                }
                case XOR -> {
                    formulas.add(new ConectivoBinario(Conectivo.IMPLIES, cb.f1, cb.f2));
                    formulas.add(new ConectivoBinario(Conectivo.IMPLIES, cb.f2, cb.f1));
                }
            }
        } else if (f1 instanceof Atomo) {
            throw new RuntimeException("No se puede desarrollar un atomo negado");
        }
        return formulas;
    }

    @Override
    public boolean isAlpha() {
        if (f1 instanceof ConectivoUnario) return true;
        else if (f1 instanceof Atomo) return false;
        else return !f1.isAlpha();
    }

    @Override
    public boolean isBeta() {
        if (f1 instanceof ConectivoUnario) return false;
        else if (f1 instanceof Atomo) return false;
        else return !f1.isBeta();
    }

    @Override
    public String toString() {
        return "¬" + f1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConectivoUnario that = (ConectivoUnario) o;
        return f1.equals(that.f1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(f1);
    }
}
