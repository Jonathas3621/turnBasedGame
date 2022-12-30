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

public abstract class Combate {
    protected List<Charac> teamA;
    protected List<Charac> teamB;
    protected List<Charac> ordem;
    
    public abstract void battle();

    public Combate(List<Charac> teamA, List<Charac> teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.ordem = this.getCharacOrder(teamA, teamB);
    }

    // Retorna uma lista com os personagens em ordem de iniciativa
    public List<Charac> getCharacOrder(List<Charac> teamA, List<Charac> teamB) {
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
    public boolean isAlive(List<Charac> team) {
        for (Charac c : team) {
            if (c.getVida() != 0) return true;
        }
        return false;
    }

    // Procura o Charac com certo nome na lista
    public Charac searchName(String name, List<Charac> charac_list) {
        for (Charac c : charac_list) {
            if (name.equals(c.getNome())) return c;
        }
        return null;
    }
}

// classe usada por getCharacOrder()
class InicComparator implements Comparator<Charac> {
    // Comparator de Iniciativa
    @Override
    public int compare(Charac c1, Charac c2) {
        Random rand = new Random();
        int dif = c2.getIniciativa() - c1.getIniciativa();
        if (dif == 0) dif = rand.nextInt(2)*2 - 1;
        return dif;
    }
}
