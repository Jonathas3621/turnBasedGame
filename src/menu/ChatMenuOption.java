package menu;

public class ChatMenuOption extends MenuOption {
    public ChatMenuOption(String nome, Command command) {
        this.nome = nome;
        this.command = command;
    }

    @Override
    public void run() {
        command.action();
    }

    @Override
    public String getNome() {
        return this.nome;
    }
}
