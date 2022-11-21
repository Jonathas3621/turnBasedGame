import java.util.*;
import chars.Charac;
import itens.Katana;
import gamehandlers.SaLoHandler;
import estamina.*;
import moves.*;

// Exemplo de função Main, apenas experimentando
public class Main {
    public static void main(String[] args) {
        Main.battle();
        /*
    	Move[] kit_magico = {new IceFreeze(), new Fireball()};
    	Charac p1 = new Charac("Abelha", 20, 2, 7, 0, 1, 0, 1, new ManaBar(20));
    	Charac p2 = new Charac("Mosquito", 20, 2, 4, 0, 2, 0, 6, new ManaBar(30));
    	
    	p1.equip(new Katana());
    	p2.equip(new Katana());
    	
    	p2.print();
    	p1.setMovimentos(kit_magico);
    	p1.attack(p2, p1.getMovimentos()[0]);
    	p2.print();
        */
    }
    
    public static void battle() {
        // Definição dos Personagens
    	Charac p1 = new Charac("Abelha", 20, 2, 7, 0, 0, 0, 1, new ManaBar(20));
        Charac p2 = new Charac("Mosquito", 20, 2, 4, 0, 0, 0, 6, new ManaBar(30));
        p1.equip(new Katana());
        p2.equip(new Katana());
        // Debug Mana
        System.out.println(p1.getNome() + " tem mana = " + p1.getPE());
        System.out.println(p2.getNome() + " tem mana maxima = " + p2.getMaxPE());
        
        Scanner s = new Scanner(System.in);    
        //Charac[] ordem = new Charac[2];
        List<Charac> ordem;

        // Definição dos Times
        Charac[] teamA = {p1};
        Charac[] teamB = {p2};
        
        // Loop principal
        while (isAlive(teamA) && isAlive(teamB)) {
            // Mostrar Nome Vida Arma
            p1.print();
            p2.print();
            
            // Debug Iniciativa
            System.out.println("Iniciativa de " + p1.getNome() + " " + p1.getIniciativa());
            System.out.println("Iniciativa de " + p2.getNome() + " " + p2.getIniciativa());
            
            /*Decide a ordem de ataque (tomara que nunca seja igual kk)
            if (p1.getIniciativa() > p2.getIniciativa()) {	
            	ordem[0] = p1;
            	ordem[1] = p2;
            } else {
            	ordem[0] = p2;
            	ordem[1] = p1;
            }*/
            
            ordem = Main.getCharacOrder(teamA, teamB);  // Decide a ordem de ataque baseado na iniciativa
            for (Charac charac : ordem) {               // Cada personagem ataca em sua vez
                System.out.println("Vez de " + charac.getNome());
                //System.out.println("Digite o numero do ataque:");
                //int ataque = s.nextInt();               // Continua não fazendo nada por enquanto
                System.out.println("Digite o nome do alvo:");
                //s.nextLine();
                String nome = s.nextLine();             // Favor não errar o nome
                Charac alvo = Main.searchName(nome, ordem);

                charac.attack(alvo, charac.getHolding()); // Nota: trocar getHolding por ataque no futuro
            }
            
            // Ataque
            //ordem[0].attack(ordem[1], ordem[0].getHolding());	//Nota: Verificar estado de vida antes de atacar
            //ordem[1].attack(ordem[0], ordem[1].getHolding());
        }
        System.out.println("Uma batalha sangrenta");
        s.close();
    }
    
    // Retorna uma lista com os personagens em ordem de iniciativa
    public static List<Charac> getCharacOrder(Charac[] teamA, Charac[] teamB) {
        List<Charac> order_list = new ArrayList<Charac>();
        
        for (Charac charac : teamA) {
            order_list.add(charac);
        }
        
        for (Charac charac : teamB) {
            order_list.add(charac);
        }

        Collections.sort(order_list, new InicComparator());
        return order_list;
    }

    // Verifica se algum integrante do time ainda vive
    public static boolean isAlive(Charac[] team) {
        for (Charac c : team) {
            if (c.getVida() != 0) return true;
        }
        return false;
    }
    
    // Procura o Charac com certo nome na lista
    public static Charac searchName(String name, List<Charac> charac_list) {
        for (Charac c : charac_list) {
            if (name.equals(c.getNome())) return c;
        }
        return null;
    }
}

// classe usada por getCharacOrder()
class InicComparator implements Comparator<Charac> {
    @Override
    public int compare(Charac c1, Charac c2) {
        Random rand = new Random();
        int dif = c2.getIniciativa() - c1.getIniciativa();
        if (dif == 0) dif = rand.nextInt(2)*2 - 1;
        return dif;
    }
}
