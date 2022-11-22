package gamehandlers;

import org.json.*;
import java.io.*;
import chars.Charac;
import moves.Move;
import java.util.List;
import java.util.ArrayList;

public class SaLoHandler {
	public static void saveToFile(Charac charac, String fileName) {
		try {
			JSONObject char_save = new JSONObject(); //Só alguns atributos por enquanto
			char_save.put("nome", charac.getNome());
			char_save.put("vida", charac.getVida());
			char_save.put("forca", charac.getForca());
			char_save.put("destreza", charac.getDestreza());
			char_save.put("constituicao", charac.getConstituicao());
			char_save.put("inteligencia", charac.getInteligencia());
			char_save.put("sabedoria", charac.getSabedoria());
			char_save.put("agilidade", charac.getAgilidade());
			char_save.put("estamina", charac.getEstaminaBar().getClass().toString());
			List<String> string_moves = new ArrayList<String>();	// Gera uma lista com o nome da classe de cada Move
			for (Move move : charac.getMovimentos()) string_moves.add(move.getClass().toString());
			char_save.put("movimentos", string_moves.toString());
			if (charac.getHolding() != null) char_save.put("holding", charac.getHolding().getClass().getName());
			if (charac.getBotas() != null) char_save.put("botas", charac.getBotas().getClass().getName());
			if (charac.getPeitoral() != null) char_save.put("peitoral", charac.getPeitoral().getClass().getName());
			if (charac.getElmo() != null) char_save.put("elmo", charac.getElmo().getClass().getName());
			// Falta inventário
			FileWriter out = new FileWriter("savedcharacters/"+fileName);
			out.write(char_save.toString());
			out.write("\n");
			out.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
