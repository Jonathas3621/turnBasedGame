import chars.Charac;
import itens.Katana;
import java.util.Scanner;
import gamehandlers.SaLoHandler;
import estamina.*;
import moves.*;

// Exemplo de função Main, apenas experimentando
public class Main {
    public static void main(String[] args) {
    	Move[] kit_magico = {new IceFreeze(), new Fireball()};
    	Charac p1 = new Charac("Abelha", 20, 2, 7, 0, 1, 0, 1, new ManaBar(20));
    	Charac p2 = new Charac("Mosquito", 20, 2, 4, 0, 2, 0, 6, new ManaBar(30));
    	
    	p1.setHolding(new Katana());
    	
    	p1.setMovimentos(kit_magico);
    	p1.attack(p2, p1.getHolding());
    }
    public static void battle() {
    	Charac p1 = new Charac("Abelha", 20, 2, 7, 0, 0, 0, 1, new ManaBar(20));
        Charac p2 = new Charac("Mosquito", 20, 2, 4, 0, 0, 0, 6, new ManaBar(30));
        p1.setHolding(new Katana());
        p2.setHolding(new Katana());
        
        System.out.println(p1.getNome() + " tem mana = " + p1.getPE());
        System.out.println(p2.getNome() + " tem mana maxima = " + p2.getMaxPE());
        
        Scanner s = new Scanner(System.in);    
		Charac ordem[] = new Charac[2];
	    
        while (p1.getVida() > 0 && p2.getVida() > 0) {
            p1.print();
            p2.print();
            
            int command = s.nextInt();	// Le o ataque (não serve pra nada kk)
            
            System.out.println("Prioridade de " + p1.getNome() + " " + getPriority(p1));
            System.out.println("Prioridade de " + p2.getNome() + " " + getPriority(p2));
            
            if (getPriority(p1) > getPriority(p2)) {	//Decide a ordem de ataque (tomara que nunca seja igual kk)
            	ordem[0] = p1;
            	ordem[1] = p2;
            } else {
            	ordem[0] = p2;
            	ordem[1] = p1;
            }
            
            ordem[0].attack(ordem[1], ordem[0].getHolding());	//Nota: Verificar estado de vida antes de atacar
            ordem[1].attack(ordem[0], ordem[1].getHolding());
        }
        System.out.println("Uma batalha sangrenta");
        s.close();
    }
    
    public static int getPriority(Charac player) {	//grandeza do jogo chamada Priority usada pra ver quem vai primeiro
    	return player.getAgilidade() * player.getHolding().getVelocidade();
    }
}
