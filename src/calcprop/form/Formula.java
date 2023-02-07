package calcprop.form;

import java.util.*;

public abstract class Formula {

    public Formula toFormaNormalCojuntiva() {
        Formula sol = this.toConjuncionDisyuncion().applyLeyesDeMorgan().applyPropiedadDistributiva();
        // TODO: eliminar atomos duplicados en clausulas, clausulas vacias, etc.
        return sol;
    }

    public abstract Formula toConjuncionDisyuncion();
    public abstract Formula applyLeyesDeMorgan();
    public abstract Formula applyPropiedadDistributiva();
//    public abstract Formula

    public abstract List<Formula> desarrollar() throws RuntimeException;

    public abstract boolean isAlpha();
    public abstract boolean isBeta();
}
