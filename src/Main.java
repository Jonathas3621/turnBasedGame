import chars.Charac;
import itens.Katana;
import java.util.Scanner;
import gamehandlers.SaLoHandler;

// Exemplo de função Main, apenas experimentando
public class Main {
    public static void main(String[] args) {
    	Charac p1 = new Charac("Abelha", 20, 4, new Katana());
        SaLoHandler.saveToFile(p1, "teste.txt");
    }
    public static void battle() {
    	Charac p1 = new Charac("Abelha", 20, 4, new Katana());
        Charac p2 = new Charac("Mosquito", 19, 6, new Katana());
        
        Scanner s = new Scanner(System.in);    
	    
        while (p1.getVida() > 0 && p2.getVida() > 0) {
            p1.print();
            p2.print();
            
            int com = s.nextInt();	// Le o ataque
            
            if (com == 1) {	//Quando digitar 1, Abelha manda um ataque fraco, power 8
            	p1.attack(p2, p1.getForca(), p1.getHolding());
            } else if (com == 2) {	//Quando digitar 2, Abelha manda um ataque forte, power 14
            	p1.attack(p2, p1.getForca(), p1.getHolding());	 
            }
            
            p2.attack(p1, 10, p2.getHolding());
        }
        System.out.println("Uma batalha sangrenta");
        s.close();
    }
}
