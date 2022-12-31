package combate;

import java.util.*;
import chars.*;

public class Team extends LinkedList<Charac> {
    private String nome;
    
    public Team(String nome) {
        super();
        this.nome = nome;
    }

    @Override
    public boolean add(Charac charac) {
        boolean output = super.add(charac);
        charac.setTeam(this);
        return output;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
