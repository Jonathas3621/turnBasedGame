package menu;

public abstract class Option {
    protected Object content;
    protected String nome;
    protected Menu upper;

    public abstract Object run(Object[] args);

    public String getNome() {
        return this.nome;
    }

    public Object getContent() {
        return this.content;
    }

    public void setUpper(Menu upper) {
        this.upper = upper;
    }
}
