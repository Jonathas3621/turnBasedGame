package menu.chatmenu;

import java.util.*;
import menu.*;

public class ChatMenu extends Menu {
    private VoltarOption opçãoDeVoltar;

    class VoltarOption extends ChatMenuOption {
        VoltarOption(Menu upperMenu) {
            super("Voltar", upperMenu);
        }

        @Override
        public Object run(Object[] args) {
            return upperMenu.open();
        }
    }

    public ChatMenu(String nome) {
        this.nome = nome;
    }

    public ChatMenu(String nome, List<Option> options) {
        this(nome);
        this.options = options;
    }

    @Override
    public Object open() { //Abre o próprio menu, apresentando as opções e perguntando qual o usuário deseja
        list();
        Option selectedOption = askOption();
        if (selectedOption instanceof Menu) {
            return run(selectedOption, new Object[]{this});
        }
        /*if (selectedOption instanceof VoltarOption) {
            return run(selectedOption, new Object[]{this.upper});
        }*/ 
        return run(selectedOption, new Object[]{});
    }

    @Override
    public Object open(Menu upperMenu) {
        this.upperMenu = upperMenu;
        this.opçãoDeVoltar = new VoltarOption(upperMenu);
        return open();
    }

    private void list() { //Lista todas as Optionts
        for (Option option : options) {
            System.out.println(option.getNome());
        }
        if (opçãoDeVoltar != null)
            System.out.println(opçãoDeVoltar.getNome());
    }
    
    private Option askOption() {    //Pergunta ao usuário qual opção ele deseja executar
        Scanner scanner = new Scanner(System.in);
        Option selectedOption = null;
        while (selectedOption == null) {
            //if (!scanner.hasNextLine())
            //    continue;
            System.out.println("Digite sua escolha: ");
            String name_selected_option = scanner.nextLine();
            for (Option option : options) {
                if (option.getNome().equals(name_selected_option)) {
                    selectedOption = option;
                    break;
                }
            }
            if (opçãoDeVoltar != null) {
                if (opçãoDeVoltar.getNome().equals(name_selected_option)) {
                    selectedOption = opçãoDeVoltar;
                }
            }

            if (selectedOption == null)
                System.out.println("Opção inválida");
        }
        //scanner.close();
        return selectedOption;
    }
   
    @Override
    protected Object run(Option option, Object[] args) {    //Executa a opção selecionada
        return option.run(args);
    }
}
