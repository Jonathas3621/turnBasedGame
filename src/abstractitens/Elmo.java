package abstractitens;

import java.util.ArrayList;

public class Elmo extends Armadura {
    public Elmo(String nome, double peso, String raridade, ArrayList<String> afinidades, String efeito_Desc, String desc, int protecao) {
        super(  nome,
                peso,
                raridade,
                afinidades,
                efeito_Desc,
                desc,
                protecao);
    }

    public Elmo(String armour_fileName) {
        super(armour_fileName, "abstractitens.Elmo");
    }
}
