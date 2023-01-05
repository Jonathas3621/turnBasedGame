package moves;

import chars.Charac;

public class IceFreeze extends Move {
	public IceFreeze() {
		super("Ice Freeze", "normal", 3);
	}
	
	@Override
	protected void effect(Charac user, Charac target) {
		int damage = user.getInteligencia();
		target.receiveDamage(damage);
		//System.out.println(user.getNome() + " used " + this.getNome() + " in " + target.getNome());
		//System.out.println("it inflicts " + damage + " damage");
	}
}
