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
        public Object select(Menu selector) {
            return upperMenu.open();
        }
    }

    public ChatMenu(String nome) {
        this.nome = nome;
        this.keywords.add(this.nome);
    }

    public ChatMenu(String nome, List<Option> options) {
        this(nome);
        this.options = options;
    }

    @Override
    public Object open() { //Abre o próprio menu, apresentando as opções e perguntando qual o usuário deseja
        System.out.println(this.nome);
        list();
        Option selectedOption = askOption();
        if (selectedOption instanceof Menu) {
            return ((Menu) selectedOption).open(this);
        }
        return select(selectedOption);
    }

    @Override
    public Object open(Menu upperMenu) {
        this.upperMenu = upperMenu;
        this.opçãoDeVoltar = new VoltarOption(upperMenu);
        return open();
    }

    private void list() { //Lista todas as Optionts
        int i = 1;
        for (Option option : options) {
            System.out.println("(" + i + ") " + option.getNome()); i++;
        }
        if (opçãoDeVoltar != null)
            System.out.println(opçãoDeVoltar.getNome());
        if (textoExtra != null) {
            System.out.println(textoExtra);   // Print algo extra, no caso, será uma curiosidade
        }
    }
    
    private Option askOption() {    //Pergunta ao usuário qual opção ele deseja executar
        Scanner scanner = new Scanner(System.in);
        Option selectedOption = null;
        while (selectedOption == null) {
            System.out.println("Digite sua escolha: ");
            String name_selected_option = scanner.nextLine();
            for (Option option : options) { //Para cada opção
                for (String keyword : option.getKeywords()) {   //Procura em cada keyword
                    if (name_selected_option.equals(keyword)) { //Se o digitado corresponde à keyword
                        selectedOption = option;
                        break;
                    }
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
        return selectedOption;
    }
   
    @Override
    protected Object select(Option option) {    //Executa a opção selecionada
        return option.select(this);
    }
}
