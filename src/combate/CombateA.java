package combate;

import chars.Charac;
import itens.*;
import gamehandlers.SaLoHandler;
import estamina.*;
import moves.*;
import usable.Usable;
import abstractitens.*;
import java.util.*;
import menu.*;
import menu.chatmenu.*;

public class CombateA extends Combate {
    public CombateA(List<Charac> teamA, List<Charac> teamB) {
        super(teamA, teamB);
    }

    public void battle() {

        // Loop principal
        while (isAlive(teamA) && isAlive(teamB)) {
            // Decide a ordem de ataque baseado na iniciativa 
            ordem = getCharacOrder();  

            System.out.println("Ordem de batalha");
            for (Charac player : ordem) {   
                System.out.println(ordem.indexOf(player) + ". " + player.getTeam().getNome() + " " + player.toString());
            }
            System.out.println();

            // Cada personagem ataca em sua vez
            for (Charac charac : ordem) {   
                Usable selectedAction;
                Charac selectedTarget;
                
                if (!charac.isAlive()) continue;
                System.out.println("Vez de " + ordem.indexOf(charac) + ". " + charac.getNome()); 

                selectedAction = (Usable) openCharacsActionMenu(charac);
                selectedTarget = (Charac) openTargetsMenu(ordem);
                
            /*  System.out.println("Escolha sua ação: [attack|magic]");
             *  String acao = s.nextLine();
             *  String attack = "";
             *  int magic = -1;
             *  if (acao.equals("attack")) {
             *      System.out.println("Escolha o Attack: [arma]");
             *      attack = s.nextLine();
             *  } else if (acao.equals("magic")) {
             *      System.out.println("Escolha a Magia:");
             *      List<Move> moves = charac.getMovimentos();
             *      for (Move magia : moves) {
             *          System.out.println(moves.indexOf(magia) + " " + magia.getNome());
             *      }
             *      magic = s.nextInt();
             *  }
             *  System.out.println("Digite o ID do alvo:");
             *  int id = s.nextInt();
             *  Charac alvo = ordem.get(id);
             *  System.out.println();
             *
             *  Usable usable = null;
             *  if (acao.equals("attack")) {
             *      if (attack.equals("arma")) {
             *          usable = charac.getHolding();
             *      }
             *  } else if (acao.equals("magic")) {
             *      usable = charac.getMovimentos().get(magic);
             *  }
             */
                //charac.doAction(selectedTarget, selectedAction); 
                //if (!selectedTarget.isAlive()) System.out.println(selectedTarget.getNome() + " faleceu");
            }
        }
        System.out.println("Uma batalha sangrenta");
    }

    private Object openCharacsActionMenu(Charac character) {
        Menu actions_menu = new ChatMenu("Ações");
        Menu attack_menu = new ChatMenu("Ataques");
        Menu magical_menu = new MovesMenu(character);

        attack_menu.add(new ChatMenuOption("Ataque com Arma", character.getHolding()));

        actions_menu.add(attack_menu);
        actions_menu.add(magical_menu);
        return actions_menu.open();
    }

    private Object openTargetsMenu(List<Charac> targets) {
        Menu targets_menu = new ChatMenu("Alvos");
        for (Charac target : targets) {
            targets_menu.add(new ChatMenuOption(target.getNome(), target));
        }
        return targets_menu.open();
    }
}
