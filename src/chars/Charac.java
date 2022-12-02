package chars;

import abstractitens.*;
import estamina.*;
import org.json.JSONObject;
import moves.*;
import usable.Usable;
import java.util.*;
import gamehandlers.*;

public class Charac implements SavableObject {
    private String nome;
    private int vida;
    private int forca;
    private int destreza;
    private int constituicao;
    private int inteligencia;
    private int sabedoria;
    private int agilidade;
    private EstaminaBar estamina;
    private Move[] movimentos = {};
    private Arma holding;
    private Botas botas;
    private Peitoral peitoral;
    private Elmo elmo;
    private List<Item> inventario = new LinkedList<Item>();
    private String saveFileName = "savedjson/Characs.JSON";

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
    
    public Charac(String fileName) {
        JSONObject atributes = SaLoHandler.readFromFile(fileName);
    	this.nome = atributes.getString("nome");
        this.vida = atributes.getInt("vida");
        this.forca = atributes.getInt("forca");
        this.destreza = atributes.getInt("destreza");
        this.constituicao = atributes.getInt("constituicao");
        this.inteligencia = atributes.getInt("inteligencia");
        this.sabedoria = atributes.getInt("sabedoria");
        this.agilidade = atributes.getInt("agilidade");
        String estamina_name = atributes.getString("estamina");
        this.estamina = (EstaminaBar) SaLoHandler.toClass(estamina_name);
    }

    public void attack(Charac target, Usable usable) {
        if (usable != null) usable.use(this, target);   			
        System.out.println(this.getNome() + " ataca " + target.getNome());
    }
    
    public void receiveDamage(int damage) {
    	if (this.botas != null) damage = this.botas.protectDamage(damage);
    	if (this.peitoral != null) damage = this.peitoral.protectDamage(damage);
    	if (this.elmo != null) damage = this.elmo.protectDamage(damage);
    	
        this.vida -= damage - this.constituicao;
        if (this.vida < 0) this.vida = 0;
    }
    
    public void print() {
        System.out.println(" *" + this.nome + " " + this.vida + "hp, equipa " + this.holding.getNome());
    }
    
    @Override
    public JSONObject getSaveJson() {	// Gera objeto JSON com os dados do Charac
    	JSONObject char_save = new JSONObject();
		char_save.put("nome", this.getNome());
		char_save.put("vida", this.getVida()); 
        char_save.put("forca", this.getForca());
		char_save.put("destreza", this.getDestreza());
		char_save.put("constituicao", this.getConstituicao());
		char_save.put("inteligencia", this.getInteligencia());
		char_save.put("sabedoria", this.getSabedoria());
		char_save.put("agilidade", this.getAgilidade());
		//char_save.put("estamina", this.getEstaminaBar().getClass().getName());
		char_save.put("estamina", this.getEstaminaBar().getSaveJson());
		List<String> string_moves = new ArrayList<String>();	// Gera uma lista com o nome da classe de cada Move
		for (Move move : this.getMovimentos()) string_moves.add(move.getNome());
		char_save.put("movimentos", string_moves);
		if (this.getHolding() != null) char_save.put("holding", this.getHolding().getClass().getName());
		if (this.getBotas() != null) char_save.put("botas", this.getBotas().getClass().getName());
		if (this.getPeitoral() != null) char_save.put("peitoral", this.getPeitoral().getClass().getName());
		if (this.getElmo() != null) char_save.put("elmo", this.getElmo().getClass().getName());	
		return char_save;	
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

    public boolean isAlive() {
        if (this.vida > 0) return true;
        else return false;
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
	
	public EstaminaBar getEstaminaBar() {
		return this.estamina;
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
        if (this.getHolding() != null) multiplicador = this.getHolding().getVelocidade();
        return this.getAgilidade() * multiplicador;
    }
    
    @Override
    public String getSaveFileName() {
        return this.saveFileName;
    }
}
