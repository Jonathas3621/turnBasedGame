package itens;

import abstractitens.EspadaGrande;

public class Katana extends EspadaGrande{
	
	
	public Katana() {
		
		this.setClasses(new String[1]);
		this.classes[0] = "Espadachim";
		
		this.setNome("Katana");
		this.setPeso(0.75);
		this.setRaridade("comum");
		this.setDesc("Posso sentir meu sangue ancestral correndo em minhas veias!!!");
		this.setDano(13);
		this.setEstamina(5);
		this.setVelocidade(3);
	}
	
	public void activate() {
		
	}
}
