import java.util.*;
import java.lang.reflect.*;
import chars.Charac;
import itens.*;
import gamehandlers.SaLoHandler;
import estamina.*;
import moves.*;
import usable.Usable;
import abstractitens.*;
import org.json.*;

// Exemplo de função Main, apenas experimentando
public class Main {
    public static void main(String[] args) {
        //Botas katana = (Botas) SaLoHandler.toClass("itens.BotasDeCouro");
        Arma item = new Katana();
        System.out.println(item.getNome());
        System.out.println(item.getRaridade());
        
        Armadura novo_peitoral = new PeitoralDeAco();
        System.out.println(novo_peitoral.getNome());
        System.out.println(novo_peitoral.getProtecao());

        Arma wooden_sword = new EspadaDeMadeira();
        System.out.println(wooden_sword.getNome());
        System.out.println(wooden_sword.getPeso());

        Charac player = new Charac("Abelha");
        player.equip(new BotasDeCouro());
        player.equip(new ElmoDeCouro());
        player.equip(new PeitoralDeAco());
        player.equip(new Katana());

        System.out.println();
        System.out.println(player.getNome());
        System.out.println("Vida: " + player.getVida());
        System.out.println("Forca: " + player.getForca());
        System.out.println("Destreza:" + player.getDestreza());
        System.out.println("Constituicao: " + player.getConstituicao());
        System.out.println("Inteligencia: " + player.getInteligencia());
        System.out.println("Sabedoria: " + player.getSabedoria());
        System.out.println("Agilidade: " + player.getAgilidade());
        System.out.println("Arma: " + player.getHolding());
        System.out.println("Botas: " + player.getBotas());
        System.out.println("Peitoral: " + player.getPeitoral());
        System.out.println("Elmo: " + player.getElmo());
        System.out.println("Estamina: " + player.getEstaminaBar());
        System.out.println("PE atuais: " + player.getPE());
        System.out.println("PE máximo: " + player.getMaxPE());
        System.out.println("Movimentos: " + player.getMovimentos());

        SaLoHandler.saveToFile(player);
        SaLoHandler.saveToFile(item);
        SaLoHandler.saveToFile(novo_peitoral);

        //Arma katana = new Arma("Katana");
        //System.out.println(katana.getDano());
    	
        //Charac p1 = new Charac("Abelha");
        //System.out.println(p1.getNome());
        //p1.equip(new Arma("Katana"));
        //Charac p1 = new Charac("Mosquito", 20, 2, 4, 0, 0, 0, 6, new ManaBar(30)); 
        //SaLoHandler.saveToFile(p1);
        //System.out.println(p1.getSaveJson().toString());
        
        /*BotasDeCouro couro = new BotasDeCouro;
        System.out.println(couro.getNome() + " foi carregado! :3");
        System.out.println("Protecao: " + couro.getProtecao()); 
        System.out.println("Raridade: " + couro.getRaridade());
        System.out.println("Classe: " + couro.getClass());*/
        //Katana katana = new Katana();
        //System.out.println(katana.getNome()+" foi carregada! :3");
        //System.out.println("Peso: " + katana.getPeso());
        //System.out.println("Descrição: " + katana.getDesc());
        //System.out.println("Raridade: " + katana.getRaridade());
        //battle();
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
