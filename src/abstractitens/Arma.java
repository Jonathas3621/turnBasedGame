package abstractitens;

public abstract class Arma extends Item {
	int dano;
	int estamina;
	int velocidade; //1 lenta, 2 normal, 3 rápida
	protected String[] classes;
	
	// Constructor
	public Arma() {}
	
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

