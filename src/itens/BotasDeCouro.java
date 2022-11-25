package itens;

import abstractitens.Botas;
import java.util.*;

public class BotasDeCouro extends Botas {
	public BotasDeCouro() {
        super(  "Botas de Couro",
                0.5,
                "comum",
                new ArrayList<String>(),
                "",
                "As mais baratas do mercado.",
	            2);
	}

    public BotasDeCouro(String fileName) {
        super(fileName);
    }
}
