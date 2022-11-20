package chars;

import abstractitens.*;
import estamina.*;
import org.json.JSONObject;
import moves.*;
import usable.Usable;
import java.util.LinkedList;
import java.util.List;

public class Charac {
    private String nome;
    private int vida;
    private int forca;
    private int destreza;
    private int constituicao;
    private int inteligencia;
    private int sabedoria;
    private int agilidade;
    private EstaminaBar estamina;
    private Move[] movimentos;
    private Arma holding;
    private Botas botas;
    private Peitoral peitoral;
    private Elmo elmo;
    private List<Item> inventario = new LinkedList<Item>();

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
    
    public void attack(Charac target, Usable usable) {
        usable.use(this, target);   			// Criado uma interface Usable.
        System.out.println(this.getNome() + " ataca " + target.getNome());
    }
    
    public void receiveDamage(int damage) {
    	int absorved_damage = this.botas.protectDamage(damage);
        this.vida -= absorved_damage - this.constituicao;
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

	public void equip(Arma holding) {
        if (this.holding != null) this.inventario.add(this.holding);
		this.holding = holding;
	}
	
	public Botas getBotas() {
		return this.botas;
	}

    public Peitoral getPeitoral() {
        return this.peitoral;
    }

    public Elmo getElmo() {
        return this.elmo;
    }

    public void equip(Botas new_botas) {
        if (botas != null) inventario.add(this.botas);
        this.botas = new_botas;
    }

    public void equip(Peitoral new_peitoral) {
        if (peitoral != null) inventario.add(this.peitoral);
        this.peitoral = new_peitoral;
    }

    public void equip(Elmo new_elmo) {
        if (this.elmo != null) inventario.add(this.elmo);
        this.elmo = new_elmo;
    }

    public int getIniciativa() {
        int multiplicador = 2;
        if (this.getholding() != null) multiplicador = this.getHolding().getVelocidade();
        return this.getAgilidade() * multiplicador;
    }
}
