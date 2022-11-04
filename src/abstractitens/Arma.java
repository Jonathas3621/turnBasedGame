package abstractitens;

public abstract class Arma extends Item {
	int dano;
	int estamina;
	int velocidade; //1 lenta, 2 normal, 3 rápida
	String[] classes;

	// Constructor
	public Arma(String nome, double peso, String raridade, String[] afinidades,String efeito_Desc, String desc, int dano, int estamina,
	int velocidade) { 
		super(nome, peso, raridade, afinidades, efeito_Desc, desc);
	
		this.dano = dano; 
		this.estamina = estamina; 
		this.velocidade = velocidade;
	}
	// Getters e Setters
	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public int getEstamina() {
		return estamina;
	}

	public void setEstamina(int estamina) {
		this.estamina = estamina;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public String[] getClasses() {
		return classes;
	}

	public void setClasses(String[] classes) {
		this.classes = classes;
	}
	
}

