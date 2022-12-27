package abstractitens;

import java.util.*;

public class Botas extends Armadura {
	public Botas(String nome, double peso, String raridade, ArrayList<String> afinidades, String efeito_Desc, String desc, int protecao) {
        super(  nome,
                peso,
                raridade,
                afinidades,
                efeito_Desc,
                desc,
                protecao);
    }

    public Botas(String armour_name) {
        super(armour_name, "abstractitens.Botas");
    }
}
