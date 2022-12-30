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
            // Mostrar Nome Vida Arma
            System.out.println("Time A:");
            for (Charac teammate : teamA) {
                teammate.print();
            }
            System.out.println("Time B:");
            for (Charac teammate : teamB) {
                teammate.print();
            }
            System.out.println();
    
            ordem = getCharacOrder(teamA, teamB);  // Decide a ordem de ataque baseado na iniciativa
                
            for (Charac player : ordem) {   // Debug Iniciativa
                System.out.println("Iniciativa de " + player.getNome() + ": " + player.getIniciativa());
            }
            System.out.println();
            for (Charac charac : ordem) {   // Cada personagem ataca em sua vez
                if (!charac.isAlive()) continue;
                System.out.println("Vez de " + charac.getNome());
                //System.out.println("Digite o numero do ataque:");
                //int ataque = s.nextInt();               // Continua não fazendo nada por enquanto
                System.out.println("Digite o nome do alvo:");
                //s.nextLine();
                String nome = s.nextLine();             // Favor não errar o nome
                Charac alvo = searchName(nome, ordem);
                System.out.println();
                charac.attack(alvo, charac.getHolding()); // Nota: trocar getHolding por ataque no futuro
                if (!alvo.isAlive()) System.out.println(alvo.getNome() + " faleceu");
                System.out.println();
            }
            // Ataque
            //ordem[0].attack(ordem[1], ordem[0].getHolding());	//Nota: Verificar estado de vida antes de atacar
            //ordem[1].attack(ordem[0], ordem[1].getHolding());
        }
        System.out.println("Uma batalha sangrenta");
        s.close();
    }
}
