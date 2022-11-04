package itens;

import abstractitens.EspadaGrande;

public class Katana extends EspadaGrande{
	
	public Katana() {
		
		//this.setClasses(new String[1]);
		//this.classes[0] = "Espadachim";
		
		this.setNome("Katana");				// nome
		this.setEfeito_Desc("");			// efeito_desc
		this.setRaridade("comum");			// raridade
		this.setDesc("Posso sentir meu sangue ancestral correndo em minhas veias!!!"); // desc
		this.setDano(13);					//dano
		this.setPeso(0.75);					//peso
		this.setEstamina(5);				//estamina
		this.setVelocidade(3);				//velocidade
	}
	
	public void activate() {
		
	}
}
