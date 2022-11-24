package itens;

import abstractitens.Arma;
import abstractitens.EspadaGrande;
import java.util.*;

public class Katana extends Arma {
	
	public Katana() {
	    super("Katana", 0.75, "comum", new ArrayList<String>(), "", "Posso sentir meu sangue ancestral correndo em minhas veias!!!", 13, 5, 2, new EspadaGrande());
		//this.setNome("Katana");				// nome
		//this.setEfeito_Desc("");			// efeito_desc
		//this.setRaridade("comum");			// raridade
		//this.setDesc("Posso sentir meu sangue ancestral correndo em minhas veias!!!"); // desc
		//this.setDano(13);					//dano
		//this.setPeso(0.75);					//peso
		//this.setEstamina(5);				//estamina
		//this.setVelocidade(3);				//velocidade
        //this.categoria = EspadaGrande(this);
	}
}
