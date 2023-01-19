package menu;

import java.util.*;

public abstract class Menu extends Option {
    protected List<Option> options = new LinkedList<Option>();
    protected Menu upperMenu;

    public abstract Object open(); //Abre o próprio menu, apresentando as opções e perguntando qual o usuário deseja.
                
    public abstract Object open(Menu upperMenu);  //Abre o Menu, upperMenu salva qual é o menu de cima, cria uma Option para voltar ao upperMenu
                                 
    protected abstract Object run(Option option, Object[] args);    //Executa a opção selecionada

    public Object run(Object[] args) {    //Ativado quando Menu é selecionado como uma opção
        if (args.length == 1)
            return this.open((Menu) args[0]);
        return this.open();
    }

    public void add(Option opção) {
        options.add(opção);
        opção.setUpper(this);
    }
}
