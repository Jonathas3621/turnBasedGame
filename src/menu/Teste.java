package menu;

import java.util.*;
import menu.chatmenu.*;

public class Teste {
    public static void main(String[] args) {
        ChatMenuOption opção_attack = new ChatMenuOption("Atacar", new GenericCommand("ataquei"));
        ChatMenuOption opção_walk = new ChatMenuOption("Andar", new GenericCommand("andei"));
        ChatMenuOption opção_run = new ChatMenuOption("Correr", new GenericCommand("fugi"));
        ChatMenuOption opção_magic = new ChatMenuOption("Magias",new GenericCommand("conjurei magia"));
       
        LinkedList<MenuOption> lista = new LinkedList<MenuOption>();
        lista.add(opção_attack);
        lista.add(opção_walk);
        lista.add(opção_run);
        lista.add(opção_magic);

        ChatMenu menu = new ChatMenu(lista);
        menu.open();
    }
}

class GenericCommand extends Command {
    String frase;
    GenericCommand(String frase) {
        this.frase = frase;
    }
    
    public boolean action(Object arg) {
        System.out.println(frase);
        return true;
    }
}

