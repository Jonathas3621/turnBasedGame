package abstractitens;

public abstract class Item {
	String nome;
	double peso;
	String raridade;	//Inicialmente tipo String. Pode mudar
	String[] afinidades; //Elementos com os quais o item tem afinidade
	String efeito_Desc;
	String desc;

	// Constructor
	public Item() {}
	 
	// Abstract methods
	public abstract void activate();

	//Getters
	public String getNome() {
		return nome;
	}

	public double getPeso() {
		return peso;
	}

	public String getRaridade() {
		return raridade;
	}

	public String[] getAfinidades() {
		return afinidades;
	}

	public String getEfeito_Desc() {
		return efeito_Desc;
	}

	public String getDesc() {
		return desc;
	}
	// Setters
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setRaridade(String raridade) {
		this.raridade = raridade;
	}

	public void setAfinidades(String[] afinidades) {
		this.afinidades = afinidades;
	}

	public void setEfeito_Desc(String efeito_Desc) {
		this.efeito_Desc = efeito_Desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
