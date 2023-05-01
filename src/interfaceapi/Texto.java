package interfaceapi;

public class Texto extends Janela {
    private String texto;

    public Texto(String texto) {
	super(texto.length(), 1);
	setTexto(texto);
    }

    public void setTexto(String texto) {
	this.texto = texto;
    }

    public String getTexto() {
	return texto;
    }
}
