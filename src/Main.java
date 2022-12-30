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
        Charac geninA = new Charac("Genin");
        Charac geninB = new Charac("Genin");

        List<Charac> teamA = new ArrayList<Charac();
        List<Charac> teamB = new ArrayList<Charac>();

        teamA.add(geninA);
        teamB.add(geninB);
        
        Combate campo_de_batalha = new CombateA(teamA, teamB);

        campo_de_batalha.battle();
    }
}
