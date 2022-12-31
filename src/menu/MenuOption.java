package menu;

public abstract class MenuOption {
    protected Command command;
    protected String nome;

    public abstract void run();

    public abstract String getNome();
}
