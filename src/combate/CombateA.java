package combate;

import chars.Charac;
import itens.*;
import gamehandlers.SaLoHandler;
import estamina.*;
import moves.*;
import usable.Usable;
import abstractitens.*;
import java.util.*;

public class CombateA extends Combate {
    public CombateA(List<Charac> teamA, List<Charac> teamB) {
        super(teamA, teamB);
    }

    public void battle() {
        Scanner s = new Scanner(System.in);    

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
                if (!charac.isAlive()) continue;
                System.out.println("Vez de " + ordem.indexOf(charac) + ". " + charac.getNome()); 
                System.out.println("Escolha sua ação: [attack|magic]");
                String acao = s.nextLine();
                String attack = "";
                int magic = -1;
                if (acao.equals("attack")) {
                    System.out.println("Escolha o Attack: [arma]");
                    attack = s.nextLine();
                } else if (acao.equals("magic")) {
                    System.out.println("Escolha a Magia:");
                    List<Move> moves = charac.getMovimentos();
                    for (Move magia : moves) {
                        System.out.println(moves.indexOf(magia) + " " + magia.getNome());
                    }
                    magic = s.nextInt();
                }
                System.out.println("Digite o ID do alvo:");
                int id = s.nextInt();
                Charac alvo = ordem.get(id);
                System.out.println();

                Usable usable = null;
                if (acao.equals("attack")) {
                    if (attack.equals("arma")) {
                        usable = charac.getHolding();
                    }
                } else if (acao.equals("magic")) {
                    usable = charac.getMovimentos().get(magic);
                }
                charac.attack(alvo, usable); // Nota: trocar getHolding por ataque no futuro
                if (!alvo.isAlive()) System.out.println(alvo.getNome() + " faleceu");
                System.out.println();
                s.nextLine();
            }
            // Ataque
            //ordem[0].attack(ordem[1], ordem[0].getHolding());	//Nota: Verificar estado de vida antes de atacar
            //ordem[1].attack(ordem[0], ordem[1].getHolding());
        }
        System.out.println("Uma batalha sangrenta");
        s.close();
    }
}


