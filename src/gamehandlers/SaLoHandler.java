package gamehandlers;

import org.json.JSONObject;
import org.json.JSONWriter;
import java.io.*;
import chars.Charac;

public class SaLoHandler {
	public static void saveToFile(Charac charac, String fileName) {
		try {
			JSONObject char_save = new JSONObject(); //Só alguns atributos por enquanto
			char_save.put("nome", charac.getNome());
			char_save.put("vida", charac.getVida());
			char_save.put("forca", charac.getForca());
			char_save.put("destreza", charac.getDestreza());
			
			FileWriter out = new FileWriter(fileName);
			out.write(char_save.toString());
			out.write("\n");
			out.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
