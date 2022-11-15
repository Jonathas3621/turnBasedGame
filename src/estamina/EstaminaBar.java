package estamina;

public abstract class EstaminaBar {
	int max;
	int pontosEstamina;
	
	public EstaminaBar(int max) {
		this.max = max;
		this.pontosEstamina = max;
	}
	
	public void usar(int quantidade) throws IllegalArgumentException {
		if (quantidade > this.pontosEstamina) {
			throw new IllegalArgumentException("Pontos Insuficientes");
		} else {
			this.pontosEstamina -= quantidade;		
		}
	}
	
	public abstract void update();
	
	public int getMax() {
		return this.max;
	}
	
	public void setMax(int max) {
		this.max = max;
	}
	
	public int getPE() {
		return this.pontosEstamina;
	}
	
	public void setPE(int pe) {
		this.pontosEstamina = pe;
	}
}
