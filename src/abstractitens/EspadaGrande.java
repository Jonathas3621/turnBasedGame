package abstractitens;

public abstract class EspadaGrande extends Arma{

	public EspadaGrande(String nome, double peso, String raridade, String[] afinidades, String efeito_Desc, String desc,
			int dano, int estamina, int velocidade) {
		super(nome, peso, raridade, afinidades, efeito_Desc, desc, dano, estamina, velocidade);
		this.classes = new String[3];
		this.classes[0] = "Espadachim";
		this.classes[1] = "Tanque";
		this.classes[2] = "Guerreiro";
		// talvez faça mais sentido as habilidades de um personagem definirem se ele empunha a arma.
		// do que a arma definir se ele a empunha. (se bem que fazer umas armas especiais assim seria bem legal)
	}
	
}
