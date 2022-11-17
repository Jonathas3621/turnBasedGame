package moves;

import chars.Charac;

public class Fireball extends NormalMove {
	public Fireball() {
		super("Fireball");
	}
	
	public void use(Charac user, Charac target) {
		int damage = user.getInteligencia();
		target.receiveDamage(damage);
		//System.out.println(user.getNome() + " used " + this.getNome() + " in " + target.getNome());
		//System.out.println("it inflicts " + damage + " damage");
	}
}

