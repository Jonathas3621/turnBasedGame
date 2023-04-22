package menu;

import java.util.*;
import menu.chatmenu.*;

public class Teste {
    public static void main(String[] args) {
        Menu menu = new ChatMenu("Menu");
        Menu menuFísico = new ChatMenu("Físico");

        menuFísico.add(new ChatMenuOption("Andar", new GenericCommand("Andando!")));
        menuFísico.add(new ChatMenuOption("Esconder", new GenericCommand("Escondendo!")));

        menu.add(menuFísico);

        Object retorno = menu.open();
        System.out.println(retorno);
    }
}

class GenericCommand extends Command {
    String frase;
    GenericCommand(String frase) {
        this.frase = frase;
    }
    
    @Override
    public void action(Object[] arg) {
        System.out.println(frase);
    }
}

