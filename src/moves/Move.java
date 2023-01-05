package moves;

import chars.Charac;
import usable.*;
import gamehandlers.SavableObject;
import org.json.*;
import java.util.*;

public abstract class Move implements Usable {
	private String nome;
	private int custo;
	private String tipo;
	private List<Condition> conditions = new LinkedList<Condition>();
	
	final public void use(Charac user, Charac target) {
		if (!hasStamina(user)) return;
		if (!canUse(user, target)) return;
		user.spendPE(custo); 
		effect(use, target);
	}
	
	protected abstract void effect(Charac user, Charac target);

	private boolean canUse(Charac user, Charac target) {
		boolean output = true;
		for (Condition condition : conditions) {
			if (!condition.condition(user, target))
				output = false;
				break;
		}
		return output;
	}

	private boolean hasStamina(Charac user) {
		if (user.getPE() < custo)
			return false;
		else
			return true;
	}

	public Move(String nome, String tipo, int custo) {
		this.nome = nome;
		this.tipo = tipo;
		this.custo = custo;
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
