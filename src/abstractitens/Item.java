package abstractitens;

public abstract class Item {
	private String nome;
	private double peso;
	private String raridade;	//Inicialmente tipo String. Pode mudar
	private String[] afinidades; //Elementos com os quais o item tem afinidade
	private String efeito_Desc = "";
	private String desc;

	// Constructor
	public Item() {}
	 
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

	public String[] getAfinidades() {
		return afinidades;
	}

	public void setAfinidades(String[] afinidades) {
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
