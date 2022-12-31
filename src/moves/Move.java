package moves;

import chars.Charac;
import usable.Usable;
import gamehandlers.SavableObject;
import org.json.*;

public abstract class Move implements Usable {
	private String nome;
	private int custo;
	
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

