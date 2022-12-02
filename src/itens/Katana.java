package itens;

import abstractitens.Arma;
import abstractitens.EspadaGrande;
import java.util.*;

public class Katana extends Arma {
	
	public Katana() {
	    //super("Katana", 0.75, "comum", new ArrayList<String>(), "", "Posso sentir meu sangue ancestral correndo em minhas veias!!!", 13, 5, 2, new EspadaGrande());
		super("savedjson/Katana.json");
	}
}
