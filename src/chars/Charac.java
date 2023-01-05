package chars;

import abstractitens.*;
import estamina.*;
import org.json.*;
import moves.*;
import usable.Usable;
import java.util.*;
import gamehandlers.*;
import combate.*;

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
    private List<Move> movimentos = new LinkedList<Move>();
    private Arma holding;
    private Armadura botas;
    private Armadura peitoral;
    private Armadura elmo;
    private List<Item> inventario = new LinkedList<Item>();
    private String saveFileName = "savedjson/Characs.json";
    private String characs_address = "characs";
    private Team currentTeam = null;

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
    
    public Charac(String charac_name) {
        // Procura o personagem no Charac.JSON e retorna os atributes
        JSONObject atributes = SaLoHandler.readFromFile(this.getSaveFileName());
        String[] key = {this.getAddress(), charac_name};
        atributes = (JSONObject) SaLoHandler.JSONHandler(atributes, key);
    	
        this.nome = atributes.getString("nome");
        this.vida = atributes.getInt("vida");
        this.forca = atributes.getInt("forca");
        this.destreza = atributes.getInt("destreza");
        this.constituicao = atributes.getInt("constituicao");
        this.inteligencia = atributes.getInt("inteligencia");
        this.sabedoria = atributes.getInt("sabedoria");
        this.agilidade = atributes.getInt("agilidade");
        
        JSONObject estamina = atributes.getJSONObject("estamina");
        String estamina_name = estamina.getString("tipo");
        Object[] estamina_max = {estamina.getInt("pontosEstamina")};
        Class[] parameters_classes = {int.class};
        this.estamina = (EstaminaBar) SaLoHandler.toClass(estamina_name, parameters_classes, estamina_max);

        try {
            this.botas = (Armadura) SaLoHandler.toClass(atributes.getString("botas"));
        } catch (JSONException e) {
            this.botas = null;
        }

        try {
            this.peitoral = (Armadura) SaLoHandler.toClass(atributes.getString("peitoral"));
        } catch (JSONException e) {        
            this.peitoral = null;
        }

        try {
            this.elmo = (Armadura) SaLoHandler.toClass(atributes.getString("elmo"));
        } catch (JSONException e) {
            this.elmo = null;
        }

        try {
            this.holding = (Arma) SaLoHandler.toClass(atributes.getString("holding"));
        } catch (JSONException e) {
            this.holding = null;
        }    
        JSONArray move_list = atributes.getJSONArray("movimentos");
        for (int i = 0; i < move_list.length(); i++) {
            Move move = (Move) SaLoHandler.toClass(move_list.getString(i));
            this.movimentos.add(move);
        }
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

    public void spendPE(int count) {
        this.setPE(this.getPE() - count);
    }
    
    public String toString() {
        return " *" + this.nome + " " + this.vida + "hp " + this.getPE() + "pe";
    }
    

    // SavableObject interface

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
		char_save.put("estamina", this.getEstaminaBar().getSaveJson());
		List<String> string_moves = new ArrayList<String>();	// Gera uma lista com o nome da classe de cada Move
		for (Move move : this.getMovimentos()) string_moves.add(move.getClass().getName());
		char_save.put("movimentos", string_moves);
        try {
            char_save.put("holding", this.getHolding().className());
        } catch (NullPointerException e) {
            char_save.put("holding", JSONObject.NULL);
        }
        try {
            char_save.put("botas", this.getBotas().className());
        } catch (NullPointerException e) {
            char_save.put("botas", JSONObject.NULL);
        }
        try {
		    char_save.put("peitoral", this.getPeitoral().className());
        } catch (NullPointerException e) {
            char_save.put("peitoral", JSONObject.NULL);
        }
        try {
            char_save.put("elmo", this.getElmo().className());	
        } catch (NullPointerException e) {
            char_save.put("elmo", JSONObject.NULL);
        }
        return char_save;	
    }

    @Override
    public String getAddress() {
        return this.characs_address;
    }

    @Override
    public String className() {
        return this.getClass().getName();
    }

    @Override
    public String getSaveFileName() {
        return this.saveFileName;
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
	
	public void setMovimentos(List<Move> movimentos) {
		this.movimentos = movimentos;
	}
	
	public List<Move> getMovimentos() {
		return this.movimentos;
	}

	public void equip(Arma holding) {
        if (this.holding != null) this.inventario.add(this.holding);
		this.holding = holding;
	}
	
	public Armadura getBotas() {
		return this.botas;
	}

    public Armadura getPeitoral() {
        return this.peitoral;
    }

    public Armadura getElmo() {
        return this.elmo;
    }

    public void equip(Armadura new_armadura) {
        String tipo = new_armadura.getTipo();
        if (tipo.equals("elmo")) {
            if (this.elmo != null) inventario.add(this.elmo);
            this.elmo = new_armadura;
        } else if (tipo.equals("peitoral")) {
            if (peitoral != null) inventario.add(this.peitoral);
            this.peitoral = new_armadura;
        } else if (tipo.equals("botas")) {
            if (botas != null) inventario.add(this.botas);
            this.botas = new_armadura;
        }
    }

    public int getIniciativa() {
        int multiplicador = 2;
        if (this.getHolding() != null) multiplicador = this.getHolding().getVelocidade();
        return this.getAgilidade() * multiplicador;
    }

    public Team getTeam() {
        return this.currentTeam;
    }

    public void setTeam(Team team) {
        this.currentTeam = team;
    }
}
