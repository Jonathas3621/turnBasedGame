package abstractitens;

import usable.Usable;
import abstractitens.Arma;

public abstract class ArmaType implements Usable {
    protected Arma referedArma;
    
    public ArmaType() {}

    public ArmaType(Arma referedArma) {
        this.setReferedArma(referedArma);
    }

    public Arma getReferedArma() {
        return this.referedArma;
    }

    public void setReferedArma(Arma arma) {
        this.referedArma = arma;
    }
}
