package menu;

import java.util.*;

public abstract class Menu {
    protected List<MenuOption> options;
    
    public abstract void open(); //Abre o próprio menu, apresentando as opções e perguntando qual o usuário deseja
                                 
    protected abstract void run(MenuOption option);    //Executa a opção selecionada
}
