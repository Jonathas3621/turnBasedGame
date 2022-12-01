package abstractitens;

import org.json.*;
import java.util.*;
import gamehandlers.SaLoHandler;

public abstract class Armadura extends Item {
	private int protecao;
	
	// Construtor por código
	public Armadura(String nome, double peso, String raridade, ArrayList<String> afinidades, String efeito_Desc, String desc, int protecao) {
        super(  nome,
                peso,
                raridade,
                afinidades,
                efeito_Desc,
                desc);
        this.setProtecao(protecao);
    }
	
	// Construtor por JSON
    public Armadura(String armour_fileName) {
        super(armour_fileName);
        JSONObject data_armour = SaLoHandler.readFromFile(armour_fileName);
        this.setProtecao( (int) data_armour.get("protecao"));
    }
	
	@Override
	public JSONObject getSaveJson() {
		JSONObject armadura_save = super.getSaveJson();
        armadura_save.put("protecao", this.getProtecao());
        return armadura_save;	
	}
	
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

