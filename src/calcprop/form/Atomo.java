package calcprop.form;

import java.util.List;
import java.util.Objects;

public class Atomo extends Formula {
    protected final String nombre;

    public Atomo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Formula toConjuncionDisyuncion() {
        return this;
    }

    @Override
    public Formula applyLeyesDeMorgan() {
        return this;
    }

    @Override
    public Formula applyPropiedadDistributiva() {
        return this;
    }

    @Override
    public List<Formula> desarrollar() throws RuntimeException {
        throw new RuntimeException("No se puede desarrollar un atomo");
    }

    @Override
    public boolean isAlpha() {
        return false;
    }

    @Override
    public boolean isBeta() {
        return false;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atomo atomo = (Atomo) o;
        return nombre.equals(atomo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
