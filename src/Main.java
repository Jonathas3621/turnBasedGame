import java.util.*;
import java.lang.reflect.*;
import chars.Charac;
import itens.*;
import gamehandlers.SaLoHandler;
import estamina.*;
import moves.*;
import usable.Usable;
import abstractitens.Item;

// Exemplo de função Main, apenas experimentando
public class Main {
    public static void main(String[] args) {
        //Main.battle();
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
    	
    	try {
    		Scanner scanner = new Scanner(System.in);
    		String name = scanner.next();
    		
    		Class[] parameters = {};
    		
    		@SuppressWarnings("rawtypes")
			Class classe = Class.forName(name);
    		
    		@SuppressWarnings("unchecked")
			Item item = (Item) classe.getDeclaredConstructor(parameters).newInstance();
    		
    		System.out.println("Peso: " + item.getPeso());
    		
    		scanner.close();
    	}catch(Exception e) {
    		System.out.println("Exception: " + e);
    	}
    }
    
    public static void battle() {
        // Definição dos Personagens
    	Charac p1 = new Charac("Abelha", 20, 2, 7, 0, 0, 0, 1, new ManaBar(20));
        Charac p2 = new Charac("Mosquito", 20, 2, 4, 0, 0, 0, 6, new ManaBar(30));
        Charac p3 = new Charac("Boneco Treino", 50, 2, 4, 0, 1, 3, 0, new ManaBar(10));
        Charac p4 = new Charac("Sapo Cururu", 40, 10, 5, 5, 5, 5, 5, new ManaBar(5));
        p1.equip(new Katana());
        p2.equip(new Katana());
        p3.equip(new Katana());
        p4.equip(new Katana());
        p4.equip(new BotasDeCouro());
        p4.equip(new PeitoralDeCouro());
        p4.equip(new ElmoDeCouro());
        // Debug Mana
        //System.out.println(p1.getNome() + " tem mana = " + p1.getPE());
        //System.out.println(p2.getNome() + " tem mana maxima = " + p2.getMaxPE());
        
        Scanner s = new Scanner(System.in);    
        //Charac[] ordem = new Charac[2];
        List<Charac> ordem;

        // Definição dos Times
        Charac[] teamA = {p1, p3};
        Charac[] teamB = {p2, p4};
        
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
    
            /*Decide a ordem de ataque (tomara que nunca seja igual kk)
            if (p1.getIniciativa() > p2.getIniciativa()) {	
            	ordem[0] = p1;
            	ordem[1] = p2;
            } else {
            	ordem[0] = p2;
            	ordem[1] = p1;
            }*/

            ordem = Main.getCharacOrder(teamA, teamB);  // Decide a ordem de ataque baseado na iniciativa
       
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
                Charac alvo = Main.searchName(nome, ordem);
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
