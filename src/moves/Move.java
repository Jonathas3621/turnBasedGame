package moves;

import chars.Charac;
import usable.Usable;

public abstract class Move implements Usable {
	String nome;
	int custo;
	
	public Move(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getCusto() {
		return this.custo;
	}
	
	public void setCusto(int custo) {
		this.custo = custo;
	}
}

