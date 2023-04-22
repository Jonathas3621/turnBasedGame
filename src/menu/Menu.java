package menu;

import java.util.*;

public abstract class Menu extends Option {
    protected List<Option> options = new LinkedList<Option>();
    protected Menu upperMenu;
    protected String textoExtra;

    public abstract Object open(); //Abre o próprio menu, apresentando as opções e perguntando qual o usuário deseja.
    
    //Talvez trocar de public para default
    public abstract Object open(Menu upperMenu);  //Abre o Menu, upperMenu salva qual é o menu de cima, cria uma Option para voltar ao upperMenu
                                 
    protected abstract Object select(Option option);    //Executa a opção selecionada

    public Object select(Menu selector) {    //Ativado quando Menu é selecionado como uma opção
        return this.open(selector);
    }

    public void add(Option opção) {
        options.add(opção);
        opção.setUpper(this);

        String index_keyword = Integer.toString(options.indexOf(opção)+1);
        opção.addKeyword(index_keyword);
    }

    public void setExtra(String texto) {
        this.textoExtra = texto;
    }
}
