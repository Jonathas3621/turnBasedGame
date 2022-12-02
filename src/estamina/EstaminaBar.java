package estamina;

import gamehandlers.SavableObject;
import org.json.JSONObject;

public abstract class EstaminaBar implements SavableObject{
	private int max;
	private int pontosEstamina; 
    private String save_filename = "";

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
    
    public JSONObject getSaveJson() {
        JSONObject estamina_save = new JSONObject();
        estamina_save.put("tipo", this.getClass().getName());
        estamina_save.put("pontosEstamina", this.getMax());
        return estamina_save;
    }

    public String getSaveFileName() { // Método inutilizado...
        return this.save_filename;
    }

}
