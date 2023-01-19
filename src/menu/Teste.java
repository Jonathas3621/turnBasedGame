package menu;

import java.util.*;
import chars.Charac;
import menu.chatmenu.*;

public class Teste {
    public static void main(String[] args) {
        Charac genin = new Charac("Genin");

        Menu menu = new ChatMenu("Menu");
        Menu menuFísico = new ChatMenu("Físico");
        Menu menuMágico = new MovesMenu(genin);

        menuFísico.add(new ChatMenuOption("Andar", new GenericCommand("Andando!")));
        menuFísico.add(new ChatMenuOption("Esconder", new GenericCommand("Escondendo!")));

        menuMágico.add(new ChatMenuOption("Bola de Fogo", new GenericCommand("Halohar Infigare!")));
        menuMágico.add(new ChatMenuOption("Invisibilidade Caseira", new GenericCommand("Agora você me vê, agora não vê mais!")));

        menu.add(menuFísico);
        menu.add(menuMágico);

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

