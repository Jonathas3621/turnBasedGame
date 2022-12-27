package abstractitens;

import org.json.*;
import java.util.*;
import gamehandlers.SaLoHandler;
 
public abstract class Armadura extends Item {
	private int protecao;
    private String tipo;
	
	// Construtor por código
	public Armadura(String nome, double peso, String raridade, ArrayList<String> afinidades, String efeito_Desc, String desc, int protecao, String tipo) {
        super(  nome,
                peso,
                raridade,
                afinidades,
                efeito_Desc,
                desc);
        this.setProtecao(protecao);
        this.setTipo(tipo);
    }
	
	// Construtor por JSON
    public Armadura(String armour_name) {
        super(armour_name, "abstractitens.Armadura");
        String armour_class = "abstractitens.Armadura"; 
        JSONObject data_armour = SaLoHandler.readFromFile(this.getSaveFileName());
        String[] key = {armour_class, armour_name};
        data_armour = (JSONObject) SaLoHandler.JSONHandler(data_armour, key);
        this.setProtecao( (int) data_armour.get("protecao"));
        this.setTipo(data_armour.getString("tipo"));
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

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

