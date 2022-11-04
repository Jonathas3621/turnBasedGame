package itens;

import abstractitens.EspadaGrande;

public class Katana extends EspadaGrande{
	String[] afinidades = {};
	String[] classes = {"Espadachim"};
	public Katana() {
		super("Katana", 		// nome
				0.75,			// peso
				"comum",		// raridade
				new String[0],	// afinidades
				"",				// efeito_desc
				"Posso sentir meu sangue ancestral correndo em minhas veias!!!", // desc
				13,				// dano
				5,				// estamina
				3);	// velocidade
		
		
	}
	
	public void activate() {
		
	}
}
