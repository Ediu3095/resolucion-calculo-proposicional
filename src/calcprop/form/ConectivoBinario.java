package calcprop.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConectivoBinario extends Formula {
    protected final Conectivo conectivo;
    protected final Formula f1;
    protected final Formula f2;
    private ConectivoBinario padre;

    public ConectivoBinario(Conectivo conectivo, Formula f1, Formula f2) {
        this.conectivo = conectivo;
        this.f1 = f1;
        this.f2 = f2;
        this.padre = null;
    }

    public void setPadre(ConectivoBinario padre) {
        this.padre = padre;
    }

    @Override
    public Formula toConjuncionDisyuncion() {
        Formula sol = null;
        switch (conectivo) {
            case AND, OR -> {
                sol = new ConectivoBinario(conectivo,
                        f1.toConjuncionDisyuncion(),
                        f2.toConjuncionDisyuncion()
                );
            }
            case IMPLIES -> { // p -> q == !p | q
                sol = new ConectivoBinario(Conectivo.OR,
                        new ConectivoUnario(f1.toConjuncionDisyuncion()),
                        f2.toConjuncionDisyuncion()
                );
            }
            case NAND -> { // !(p & q) == !p | !q
                sol = new ConectivoBinario(Conectivo.OR,
                        new ConectivoUnario(f1.toConjuncionDisyuncion()),
                        new ConectivoUnario(f2.toConjuncionDisyuncion())
                );
            }
            case NOR -> { // !(p | q) == !p & !q
                sol = new ConectivoBinario(Conectivo.AND,
                        new ConectivoUnario(f1.toConjuncionDisyuncion()),
                        new ConectivoUnario(f2.toConjuncionDisyuncion())
                );
            }
            case IFF -> { // p <-> q == (!p | q) & (!q | p)
                sol = new ConectivoBinario(Conectivo.AND,
                        new ConectivoBinario(Conectivo.OR,
                                new ConectivoUnario(f1.toConjuncionDisyuncion()),
                                f2.toConjuncionDisyuncion()
                        ),
                        new ConectivoBinario(Conectivo.OR,
                                new ConectivoUnario(f2.toConjuncionDisyuncion()),
                                f1.toConjuncionDisyuncion()
                        )
                );
            }
            case XOR -> { // p ^ q == (!p & q) | (p & !q)
                sol = new ConectivoBinario(Conectivo.OR,
                        new ConectivoBinario(Conectivo.AND,
                                new ConectivoUnario(f1.toConjuncionDisyuncion()),
                                f2.toConjuncionDisyuncion()
                        ),
                        new ConectivoBinario(Conectivo.AND,
                                f1.toConjuncionDisyuncion(),
                                new ConectivoUnario(f2.toConjuncionDisyuncion())
                        )
                );
            }
        }
        return sol;
    }

    @Override
    public Formula applyLeyesDeMorgan() {
        return new ConectivoBinario(conectivo, f1.applyLeyesDeMorgan(), f2.applyLeyesDeMorgan());
    }

    @Override
    public Formula applyPropiedadDistributiva() {
        Formula sol = null;
        switch (conectivo) {
            case AND -> {
                sol = new ConectivoBinario(Conectivo.AND,
                        f1.applyPropiedadDistributiva(),
                        f2.applyPropiedadDistributiva()
                );
            }
            case OR -> {
                if (f1 instanceof ConectivoBinario cb && cb.conectivo != Conectivo.OR) {
                    // (A x B) ∨ C  ---->  (A ∨ C) x (B ∨ C)
                    sol = new ConectivoBinario(cb.conectivo,
                            new ConectivoBinario(Conectivo.OR, cb.f1, f2),
                            new ConectivoBinario(Conectivo.OR, cb.f2, f2)
                    ).applyPropiedadDistributiva();
                } else if (f2 instanceof ConectivoBinario cb && cb.conectivo != Conectivo.OR) {
                    // C ∨ (A x B)  ---->  (C ∨ A) x (C ∨ B)
                    sol = new ConectivoBinario(cb.conectivo,
                            new ConectivoBinario(Conectivo.OR, f1, cb.f1),
                            new ConectivoBinario(Conectivo.OR, f1, cb.f2)
                    ).applyPropiedadDistributiva();
                } else {
                    sol = new ConectivoBinario(Conectivo.OR,
                            f1.applyPropiedadDistributiva(),
                            f2.applyPropiedadDistributiva()
                    );
                }
            }
            default -> {
                    throw new RuntimeException("No se puede aplicar la propiedad distributiva a la formula: " + this);
            }
        }
        return sol;
    }


    @Override
    public List<Formula> desarrollar() throws RuntimeException {
        List<Formula> formulas = new ArrayList<>();
        switch (conectivo) {
            case AND, OR -> {
                formulas.add(f1);
                formulas.add(f2);
            }
            case IMPLIES -> {
                formulas.add(new ConectivoUnario(f1));
                formulas.add(f2);
            }
            case NAND, NOR -> {
                formulas.add(new ConectivoUnario(f1));
                formulas.add(new ConectivoUnario(f2));
            }
            case IFF -> {
                formulas.add(new ConectivoBinario(Conectivo.IMPLIES, f1, f2));
                formulas.add(new ConectivoBinario(Conectivo.IMPLIES, f2, f1));
            }
            case XOR -> {
                formulas.add(new ConectivoUnario(new ConectivoBinario(Conectivo.IMPLIES, f1, f2)));
                formulas.add(new ConectivoUnario(new ConectivoBinario(Conectivo.IMPLIES, f2, f1)));
            }
        }
        return formulas;
    }


    @Override
    public boolean isAlpha() {
        return switch (conectivo) {
            case AND, IFF, NOR -> true;
            case OR, IMPLIES, XOR, NAND -> false;
        };
    }

    @Override
    public boolean isBeta() {
        return switch (conectivo) {
            case AND, IFF, NOR -> false;
            case OR, IMPLIES, XOR, NAND -> true;
        };
    }


    @Override
    public String toString() {
        if (f1 instanceof ConectivoBinario)
            ((ConectivoBinario) f1).setPadre(this);
        if (f2 instanceof ConectivoBinario)
            ((ConectivoBinario) f2).setPadre(this);

        String sol = "";
        if (padre == null || conectivo != padre.conectivo || (conectivo != Conectivo.AND && conectivo != Conectivo.OR))
            sol += "(";
        sol += f1;
        switch (conectivo) {
            case AND -> sol += " ∧ ";
            case OR -> sol += " ∨ ";
            case IMPLIES -> sol += " → ";
            case IFF -> sol += " ↔ ";
            case XOR -> sol += " ⊕ ";
            case NAND -> sol += " | ";
            case NOR -> sol += " ↓ ";
        }
        sol += f2;
        if (padre == null || conectivo != padre.conectivo || (conectivo != Conectivo.AND && conectivo != Conectivo.OR))
            sol += ")";

        if (f1 instanceof ConectivoBinario)
            ((ConectivoBinario) f1).setPadre(null);
        if (f2 instanceof ConectivoBinario)
            ((ConectivoBinario) f2).setPadre(null);

        return sol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConectivoBinario that = (ConectivoBinario) o;
        return conectivo == that.conectivo && f1.equals(that.f1) && f2.equals(that.f2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conectivo, f1, f2);
    }
}
