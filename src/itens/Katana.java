package itens;

import abstractitens.EspadaGrande;

public class Katana extends EspadaGrande{
	
	public Katana() {
		super();
		this.nome = "Katana"; 				// nome
		this.dano =	13;						// dano
		this.estamina = 5;					// estamina
		this.velocidade = 3;				// velocidade
		this.peso =	0.75;					// peso
		this.afinidades = new String[0];	// afinidades
		this.raridade =	"comum";			// raridade
		this.efeito_Desc = "";				// efeito_desc
		this.desc = "Posso sentir meu sangue ancestral correndo em minhas veias!!!"; // desc
		
		
	}
	
	public void activate() {
		
	}
}
