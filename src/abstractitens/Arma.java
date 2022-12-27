package abstractitens;

import usable.Usable;
import java.util.*;
import chars.Charac;
import org.json.*;
import gamehandlers.*;

public abstract class Arma extends Item implements Usable, SavableObject {
	private int dano;
	private int estamina;
	private int velocidade; //1 lenta, 2 normal, 3 rápida
	private ArmaType categoria;  //ArmaType implements Usable
    private String arma_address = "armas";
    //protected String[] classes;
	
	// Constructor
	public Arma(String nome, double peso, String raridade, ArrayList<String> afinidades, String efeito_Desc, String desc, int dano, int estamina, int velocidade, ArmaType categoria) {
        super(nome, peso, raridade, afinidades, efeito_Desc, desc);
        this.dano = dano;
        this.estamina = estamina;
        this.velocidade = velocidade;
        this.categoria = categoria;
        this.categoria.setReferedArma(this);
    }

    /*public Arma(String arma_fileName) {
        super(arma_fileName);
        JSONObject data_arma = SaLoHandler.readFromFile(arma_fileName);
        this.dano = (int) data_arma.get("dano");
        this.estamina = (int) data_arma.get("estamina");
        this.velocidade = (int) data_arma.get("velocidade");
    }*/

    public Arma(String arma_name) {
        super(arma_name, "armas"); // MAgIc wOrD! arma_address/getAddress()
        JSONObject data_arma = SaLoHandler.readFromFile(this.getSaveFileName());
        String[] key = {this.getAddress(), arma_name};
        data_arma = (JSONObject) SaLoHandler.JSONHandler(data_arma, key );
        this.dano = (int) data_arma.get("dano");
        this.estamina = (int) data_arma.get("estamina");
        this.velocidade = (int) data_arma.get("velocidade");
        this.categoria = (ArmaType) SaLoHandler.toClass(data_arma.getString("tipo"));
        this.categoria.setReferedArma(this);
    }
    
    @Override
    public JSONObject getSaveJson() {
		JSONObject arma_save = super.getSaveJson();
        arma_save.put("dano", this.getDano());
        arma_save.put("estamina", this.getEstamina());
        arma_save.put("velocidade", this.getVelocidade());
        arma_save.put("tipo", this.getType().getClass().getName());
        return arma_save;
    }

    @Override
    public String getAddress() {
        return this.arma_address;
    }

    public String className() {
        return this.getClass().getName();
    }
	
    // Use
    public void use(Charac user, Charac target) {
        this.categoria.use(user, target); 
    }

	// Getters e Setters
	public ArmaType getType() {
        return this.categoria;
    }

    public void setType(ArmaType type) {
        this.categoria = type;
    }

    public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public int getEstamina() {
		return estamina;
	}

	public void setEstamina(int estamina) {
		this.estamina = estamina;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

//	public String[] getClasses() {
//		return classes;
//	}

//	public void setClasses(String[] classes) {
//		this.classes = classes;
//	}
	
}

