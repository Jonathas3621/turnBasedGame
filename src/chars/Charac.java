package chars;

import abstractitens.Arma;
import org.json.JSONObject;

public class Charac {
	JSONObject atributes;
    String nome;
    int vida;
    int forca;
    int destreza;
    int constituicao;
    int inteligencia;
    int sabedoria;
    int agilidade;
    Arma holding;
    
    public Charac(String nome, int vida, int forca, int destreza, int constituicao, int inteligencia, int sabedoria, int agilidade, Arma holding) {
        this.atributes.put("nome", nome);
        this.atributes.put("vida", vida);
        this.atributes.put("forca", forca);
        this.atributes.put("destreza", destreza);
        this.atributes.put("constituicao", constituicao);
        this.atributes.put("inteligencia", inteligencia);
        this.atributes.put("sabedoria", sabedoria);
        this.atributes.put("agilidade", agilidade);
        this.atributes.put("holding", holding);
    }
    
    public Charac(JSONObject atributes_data) {
    	this.atributes = atributes_data
    }
   
    public void attack(Charac target, int power, Arma item) {
        target.receive_damage(power + item.getDano());    
    }
    
    public void receive_damage(int damage) {
        this.vida -= damage - this.constituicao;
        if (this.vida < 0) this.vida = 0;
    }
    
    public void print() {
        System.out.println(this.nome + " " + this.vida + " " + this.constituicao + " " + this.holding.getNome());
    }
    
    // Getters e Setters
	public String getNome() {
		return this.atributes.get("nome");
	}

	public void setNome(String nome) {
		this.atributes.put("nome", nome);
	}

	public int getVida() {
		return this.atributes.get("vida");
	}

	public void setVida(int vida) {
		this.atributes.put("vida", vida);
	}

	public int getForca() {
		return this.atributes.get("forca");
	}

	public void setForca(int forca) {
		this.atributes.put("forca", forca);
	}

	public int getDestreza() {
		return this.atributes.get("destreza");
	}

	public void setDestreza(int destreza) {
		this.atributes.put("destreza", destreza);
	}

	public int getConstituicao() {
		return this.atributes.get("constituicao");
	}

	public void setConstituicao(int constituicao) {
		this.atributes.put("constituicao", constituicao);;
	}

	public int getInteligencia() {
		return this.atributes.get("inteligencia");
	}

	public void setInteligencia(int inteligencia) {
		this.atributes.put("inteligencia", inteligencia);
	}

	public int getSabedoria() {
		return this.atributes.get("sabedoria");
	}

	public void setSabedoria(int sabedoria) {
		this.sabedoria = sabedoria;
	}

	public int getAgilidade() {
		return this.atributes.get("agilidade");
	}

	public void setAgilidade(int agilidade) {
		this.atributes.put("sabedoria", sabedoria);
	}

	public Arma getHolding() {
		return this.atributes.get("holding");
	}

	public void setHolding(Arma holding) {
		this.atributes.put("holding", holding);
	}
}
