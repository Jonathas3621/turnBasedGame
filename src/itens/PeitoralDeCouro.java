package itens;

import abstractitens.Peitoral;

public class PeitoralDeCouro extends Peitoral {
	public PeitoralDeCouro() {
		this.setNome("Peitoral de Couro");
		this.setPeso(0.75);
		this.setRaridade("comum");
		this.setDesc("O mais simples do mercado.");
		this.setProtecao(4); // Um pra cada pé
	}
}
