package chars;

import abstractitens.Arma;
import estamina.*;
import org.json.JSONObject;
import moves.*;

public class Charac {
    String nome;
    int vida;
    int forca;
    int destreza;
    int constituicao;
    int inteligencia;
    int sabedoria;
    int agilidade;
    EstaminaBar estamina;
    Move[] movimentos;
    Arma holding;
    
    public Charac(String nome, int vida, int forca, int destreza, int constituicao, int inteligencia, int sabedoria, int agilidade, EstaminaBar estamina) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
        this.destreza = destreza;
        this.constituicao = constituicao;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.agilidade = agilidade;
        this.estamina = estamina;
    }
    
    /*public Charac(JSONObject atributes) {
    	this.nome = atributes.getString("nome");
        this.vida = atributes.getInt("vida");
        this.forca = atributes.getInt("forca");
        this.destreza = atributes.getInt("destreza");
        this.constituicao = atributes.getInt("constituicao");
        this.inteligencia = atributes.getInt("inteligencia");
        this.sabedoria = atributes.getInt("sabedoria");
        this.agilidade = atributes.getInt("agilidade");
    }*/
    
    public void attack(Charac target, Arma item) {	// Dois metodos attack, um para armas outro para movimentos... algo deve mudar aí
    	int power = this.getForca();			// Talvez criar movimentos que ataquem com armas, ou criar uma interface "ativavel".
        target.receiveDamage(power + item.getDano());   
        System.out.println(this.getNome() + " ataca " + target.getNome()); 
    }
    
    public void attack(Charac target, Move move) {
    	move.activate(this, target);
    }
    
    public void receiveDamage(int damage) {
        this.vida -= damage - this.constituicao;
        if (this.vida < 0) this.vida = 0;
    }
    
    public void print() {
        System.out.println(this.nome + " " + this.vida + " " + this.holding.getNome());
    }
    
    // Getters e Setters
    
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public int getConstituicao() {
		return constituicao;
	}

	public void setConstituicao(int constituicao) {
		this.constituicao = constituicao;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public int getSabedoria() {
		return sabedoria;
	}

	public void setSabedoria(int sabedoria) {
		this.sabedoria = sabedoria;
	}

	public int getAgilidade() {
		return agilidade;
	}

	public void setAgilidade(int agilidade) {
		this.agilidade = agilidade;
	}

	public int getPE() {
		return this.estamina.getPE();
	}

	public void setPE(int pe) {
		this.estamina.setPE(pe);
	}
	
	public int getMaxPE() {
		return this.estamina.getMax();
	}
	
	public void setMaxPE(int max) {
		this.estamina.setMax(max);
	}

	public Arma getHolding() {
		return this.holding;
	}
	
	public void setMovimentos(Move[] movimentos) {
		this.movimentos = movimentos;
	}
	
	public Move[] getMovimentos() {
		return this.movimentos;
	}

	public void setHolding(Arma holding) {
		this.holding = holding;
	}
}
