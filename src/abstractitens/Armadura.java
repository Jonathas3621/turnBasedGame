package abstractitens;

public abstract class Armadura extends Item {
	int protecao;
	
	public Armadura() {}
	
	public int protectDamage(int damage) {
		return damage - protecao;
	}
	
	public int getProtecao() {
		return this.protecao;
	}
	
	public void setProtecao(int prot) {
		this.protecao = prot;
	}	
}

