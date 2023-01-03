package menu.chatmenu;

import menu.*;

public class ChatMenuOption extends MenuOption {
    public ChatMenuOption(String nome, Command command) {
        this.nome = nome;
        this.command = command;
    }

    @Override
    public void run(Object arg) {
        command.action(arg);
    }

    @Override
    public String getNome() {
        return this.nome;
    }
}
