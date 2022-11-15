package moves;

import chars.Charac;

public abstract class Move {
	String nome;
	
	public Move(String nome) {
		this.nome = nome;
	}
	
	public abstract void activate(Charac user, Charac target);
	
	public String getNome() {
		return this.nome;
	}
}
