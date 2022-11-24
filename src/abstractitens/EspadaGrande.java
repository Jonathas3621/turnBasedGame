package abstractitens;

import chars.Charac;
import abstractitens.Arma;

public class EspadaGrande extends ArmaType {
   /* public EspadaGrande() {
		//classes = new String[3];
		//classes[0] = "Espadachim";
		//classes[1] = "Tanque";
		//classes[2] = "Guerreiro";
	}*/
	
	public void use(Charac user, Charac target) {
		int power = user.getForca();			// Talvez criar movimentos que ataquem com armas, ou criar uma interface "ativavel".
        target.receiveDamage(power + referedArma.getDano());    
	}

}
