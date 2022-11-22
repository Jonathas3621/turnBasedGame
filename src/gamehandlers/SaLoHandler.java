package gamehandlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONObject;

import chars.Charac;

public class SaLoHandler {

	private static File dir = new File("src"); //diretório pai
	
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
	
	public static JSONObject readFromFile(String pathName) {
		
		JSONObject json = null;
		
        try {
        	
        	//Lê o JSON e passa os dados para um buffer de leitura
            FileReader fileReader = new FileReader(new File(dir, pathName));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //Passa o os dados do buffer para uma string
            List<String> collect = bufferedReader.lines().collect(Collectors.toList());
            StringBuilder jsonTemp = new StringBuilder();
            for (String s : collect) {
                jsonTemp.append(s);
            }
            
            //Cria um objeto JSON Java
            json = new JSONObject(jsonTemp.toString());
            
            fileReader.close();
           
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Não foi possível ler o arquivo json");
        }
        
        return json;
	}
	
	public static Object JSONHandler(JSONObject json, String[] keys) {
		JSONObject newJson = json;
		
		for(int key = 0; key < keys.length; key++) {
			
			if(key == keys.length-1) {
				return newJson.get(keys[key]);
			}
			
			newJson = (JSONObject) newJson.get(keys[key]);
		}
		
		//Só é chamado caso haja algum problema com a lista passada para o parâmetro keys
		return -1;
	}
}
