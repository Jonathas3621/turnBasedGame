package interfaceapi;

import java.util.*;

public class Janela {
    public int[] size;
    private char[][] conteudo;
    public int[] pos = {0, 0};
    private List<Janela> subjanelas = new ArrayList<Janela>();
    private Janela upperJanela = null;

    private char border_corner = '@'; 
    private char border_hor = '-'; 
    private char border_ver = '|'; 

    public Janela(int size_x, int size_y) {
	size = new int[]{size_x, size_y};
	initConteudo(size_x, size_y);
    }

    public Janela(int size_x, int size_y, int pos_x, int pos_y) {
	this(size_x, size_y);
	pos = new int[]{pos_x, pos_y};
    }

    public Janela(int pos_x, int pos_y, int size_x, int size_y, Janela upperJanela) {
	this(pos_x, pos_y, size_x, size_y);
	this.upperJanela = upperJanela;
    }

    public Janela(int pos_x, int pos_y, int size_x, int size_y, char[][] conteudo) {
	this(pos_x, pos_y, size_x, size_y);
	this.conteudo = conteudo;
    }

    public Janela(int pos_x, int pos_y, int size_x, int size_y, char[][] conteudo, List<Janela> subjanelas) {
	this(pos_x, pos_y, size_x, size_y, conteudo);
	this.subjanelas = subjanelas;
    }

    private void initConteudo(int x, int y) {
	conteudo = new char[y][x];
	for (int j=0; j<y; j++) {
	    for (int i=0; i<x; i++) {
		setChar(' ', i, j);
	    }
	}
    }

    public char[][] getConteudo() {
	return conteudo;
    }

    public void setPos(int x, int y) {
	pos[0] = x;
	pos[1] = y;
    }

    public void print() {
	Janela output = this.compor();
	output.print_Content();
    }

    private void print_Content() {
	String output = "";
	for (int j=0; j<size[1]; j++) {
	    for (int i=0; i<size[0]; i++) {
		output += conteudo[j][i];
	    }
	    if (j == size[1]-1)
		break;
	    output += '\n';
	}
	System.out.println(output);
    }

    public void clear() {
	drawWall(' ', 0, 0, size[0]-1, size[1]-1);
    }

    public void setChar(char c, int x, int y) {
	conteudo[y][x] = c;
    }

    public char getChar(int x, int y) {
	return conteudo[y][x];
    }

    public void drawLine(char c, int x, int y, int l) {
	for (int i=0; i<l; i++) {
	    setChar(c, x+i, y);
	}
    }

    public void drawLine(int x, int y, int l) {
	char c = border_hor;
	drawLine(c, x, y, l);
    }

    public void drawCollum(char c, int x, int y, int l) {
	for (int j=0; j<l; j++) {
	    setChar(c, x, y+j);
	}
    }

    public void drawCollum(int x, int y, int l) {
	char c = border_ver;
	drawCollum(c, x, y, l);
    }

    public void drawWall(char c, int x, int y, int width, int height) {
	for (int i=0; i<height; i++) {
	    drawLine(c, x, y+i, width);
	}
    }

    public void drawBorder() {
	drawLine(border_hor, 0, 0, size[0]);
	drawLine(border_hor, 0, size[1]-1, size[0]);
	drawCollum(border_ver, 0, 0, size[1]);
	drawCollum(border_ver, size[0]-1, 0, size[1]);
	setChar(border_corner, 0, 0);
	setChar(border_corner, 0, size[1]-1);
	setChar(border_corner, size[0]-1, 0);
	setChar(border_corner, size[0]-1, size[1]-1);
    }

    public void write(String text, int x, int y) {
	for (int i=0; i<text.length(); i++) {
	    setChar(text.charAt(i), x+i, y);
	}
    }

    private Janela juncaoJanela(Janela janelaInterna) {
	Janela output = new Janela(size[0], size[1], pos[0], pos[1], conteudo);
	int[] offset = janelaInterna.pos;
	
	for (int j=0; j<janelaInterna.size[1]; j++) {
	    for (int i=0; i<janelaInterna.size[0]; i++) {
		char caracter = janelaInterna.getChar(i, j);
		output.setChar(caracter, offset[0]+i, offset[1]+j);
	    }
	}
	return output;
    }

    private Janela compor() {
	Janela output = this.copy();
	for (Janela subJanela : subjanelas) {
	    output = output.juncaoJanela(subJanela.compor());
	}
	return output;
    }

    public void add(Janela subJanela) {
	this.subjanelas.add(subJanela);
	subJanela.setUpper(this);
    }

    public void setUpper(Janela upper) {
	upperJanela = upper;
    }

    public Janela copy() {
	return new Janela(size[0], size[1], pos[0], pos[1], conteudo);
    }

}
