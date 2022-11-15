package estamina;

public class ManaBar extends EstaminaBar {
	public ManaBar(int max) {
		super(max);
	}
	
	public void update() {
		this.setPE(this.getMax());
	}
}
