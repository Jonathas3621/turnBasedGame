package abstractitens;

import org.json.*;
import java.util.*;
import gamehandlers.SaLoHandler;
 
public abstract class Armadura extends Item {
	private int protecao;
    private String tipo;
    private String armadura_address = "armaduras";
	
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
        super(armour_name, "armaduras");    //mAgIc WoRd!!!     armadura_address/getAddress()
        String armour_address = this.getAddress(); 
        JSONObject data_armour = SaLoHandler.readFromFile(this.getSaveFileName());
        String[] key = {armour_address, armour_name};
        data_armour = (JSONObject) SaLoHandler.JSONHandler(data_armour, key);
        this.setProtecao( (int) data_armour.get("protecao"));
        this.setTipo(data_armour.getString("tipo"));
    }
	
	@Override
	public JSONObject getSaveJson() {
		JSONObject armadura_save = super.getSaveJson();
        armadura_save.put("protecao", this.getProtecao());
        armadura_save.put("tipo", this.getTipo());
        return armadura_save;	
	}
    
    //SavableObject Interface
    @Override
    public String getAddress() {
        return armadura_address;
    }

    @Override
    public String className() {
        return this.getClass().getName();
    }
	
    //Armadura self interface
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

