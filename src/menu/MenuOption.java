package menu;

public abstract class MenuOption {
    protected Command command;
    protected String nome;

    public abstract void run(Object arg);

    public abstract String getNome();
}
