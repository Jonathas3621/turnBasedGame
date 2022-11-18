package itens;

import abstractitens.Botas;

public class BotasDeCouro extends Botas {
	public BotasDeCouro() {
		this.setNome("Botas de Couro");
		this.setPeso(0.5);
		this.setRaridade("comum");
		this.setDesc("As mais baratas do mercado.");
		this.setProtecao(2); // Um pra cada pé
	}
}
