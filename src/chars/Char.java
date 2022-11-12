package chars;

import abstractitens.Arma;

public class Char {
    String nome;
    int vida;
    int forca;
    int destreza;
    int constituicao;
    int inteligencia;
    int sabedoria;
    int agilidade;
    Arma holding;
    
    public Char(String nome, int vida, int constituicao, Arma holding) {
        this.nome = nome;
        this.vida = vida;
        this.constituicao = constituicao;
        this.holding = holding;
    }
   
    public void attack(Char target, int power, Arma item) {
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

	public Arma getHolding() {
		return holding;
	}

	public void setHolding(Arma holding) {
		this.holding = holding;
	}
}
