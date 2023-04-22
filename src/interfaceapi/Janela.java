package interfaceapi

import java.util.*;

public class Janela {
    private int pos_x;
    private int pos_y;
    private List<Janela> conteudo = new ArrayList<Janela>();
    private Janela upperJanela;

    public Janela(int pos_x, int pos_y, Janela upperJanela) {
	this.pos_x = pos_x;
	this.pos_y = pos_y;
	this.upperJanela = upperJanela;
    }
}
