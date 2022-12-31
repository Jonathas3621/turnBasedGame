package menu;

import java.util.*;

public class ChatMenu extends Menu {

    public ChatMenu(List<MenuOption> opções) {
        this.options = opções;
    }

    @Override
    public void open() { //Abre o próprio menu, apresentando as opções e perguntando qual o usuário deseja
        list();
        MenuOption selectedOption = askOption();
        run(selectedOption);
    }

    private void list() { //Lista todas as MenuOptionts
        for (MenuOption option : options) {
            System.out.println(option.getNome());
        }
    }
    
    private MenuOption askOption() {    //Pergunta ao usuário qual opção ele deseja executar
        Scanner scanner = new Scanner(System.in);
        MenuOption selectedOption = null;
        while (selectedOption == null) {
            System.out.println("Digite sua escolha: ");
            String name_selected_option = scanner.nextLine();
            for (MenuOption option : options) {
                if (option.getNome().equals(name_selected_option)) {
                    selectedOption = option;
                    break;
                }
            }
            if (selectedOption == null)
                System.out.println("Opção inválida");
        }
        scanner.close();
        return selectedOption;
    }
   
    @Override
    protected void run(MenuOption option) {    //Executa a opção selecionada
        option.run();
    }
}
