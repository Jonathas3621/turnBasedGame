package abstractitens;

import java.util.ArrayList;
import java.math.BigDecimal;
import org.json.*;
import gamehandlers.SaLoHandler;

public abstract class Item {
	private String nome;
	private double peso;
	private String raridade = "comum";	//Inicialmente tipo String. Pode mudar
	private ArrayList<String> afinidades = new ArrayList<String>(); //Elementos com os quais o item tem afinidade
	private String efeito_Desc = "";
	private String desc = "";

	// Constructor
	public Item(String nome, double peso, String raridade, ArrayList<String> afinidades, String efeito_Desc, String desc) {
        this.nome = nome;
        this.peso = peso;
        this.raridade = raridade;
        this.afinidades = afinidades;
        this.efeito_Desc = efeito_Desc;
        this.desc = desc;
    }

    public Item(String item_fileName) {
        JSONObject data_item = SaLoHandler.readFromFile(item_fileName);
        this.nome = (String) data_item.get("nome");
        this.peso = ((BigDecimal) data_item.get("peso")).doubleValue();
        this.raridade = (String) data_item.get("raridade");
        JSONArray arr = (JSONArray) data_item.get("afinidades");
        for (int i = 0; i < arr.length(); i++) {
           this.afinidades.add(arr.getJSONObject(i).toString());
        }
        //this.afinidades = (ArrayList<String>) data_item.get("afinidades");
        this.efeito_Desc = (String) data_item.get("efeito_desc");
        this.desc = (String) data_item.get("desc");
    }
	 
	// Abstract methods
	//public abstract void activate(); //Nem todo item necessita ter efeito ativo

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getRaridade() {
		return raridade;
	}

	public void setRaridade(String raridade) {
		this.raridade = raridade;
	}

	public ArrayList<String> getAfinidades() {
		return afinidades;
	}

	public void setAfinidades(ArrayList<String> afinidades) {
		this.afinidades = afinidades;
	}

	public String getEfeito_Desc() {
		return efeito_Desc;
	}

	public void setEfeito_Desc(String efeito_Desc) {
		this.efeito_Desc = efeito_Desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
