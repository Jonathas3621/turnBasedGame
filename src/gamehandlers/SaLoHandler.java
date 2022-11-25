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
import moves.Move; 
import abstractitens.*; 
import java.util.List;
import java.util.ArrayList;

public class SaLoHandler {

	public static File dir = new File("src");   //diretório pai
	public static String dir_s = "savedjson/";    //outro dir pai

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
			char_save.put("estamina", charac.getEstaminaBar().getClass().getName());
			List<String> string_moves = new ArrayList<String>();	// Gera uma lista com o nome da classe de cada Move
			for (Move move : charac.getMovimentos()) string_moves.add(move.getClass().getName());
			char_save.put("movimentos", string_moves);
			if (charac.getHolding() != null) char_save.put("holding", charac.getHolding().getClass().getName());
			if (charac.getBotas() != null) char_save.put("botas", charac.getBotas().getClass().getName());
			if (charac.getPeitoral() != null) char_save.put("peitoral", charac.getPeitoral().getClass().getName());
			if (charac.getElmo() != null) char_save.put("elmo", charac.getElmo().getClass().getName());
			// Falta inventário
			writeJsonIntoFile(char_save, fileName);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

    public static void saveToFile(Arma arma, String fileName) {
        try {
            JSONObject arma_save = armaToJsonObject(arma);
            writeJsonIntoFile(arma_save, fileName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void saveToFile(Armadura armadura, String fileName) {
        try {
            JSONObject armadura_save = armaduraToJsonObject(armadura);
            writeJsonIntoFile(armadura_save, fileName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
	
	public static JSONObject readFromFile(String pathName) {
		JSONObject json = null;
		
        try {
        	
        	//Lê o JSON e passa os dados para um buffer de leitura
            FileReader fileReader = new FileReader(new File(pathName));
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

    public static Object toClass(String class_name) {
        try {
    		Class[] parameters = {};
    		@SuppressWarnings("rawtypes")
			Class classe = Class.forName(class_name);
    		@SuppressWarnings("unchecked")
			Object objeto = classe.getDeclaredConstructor(parameters).newInstance();
            return objeto;
    	} catch (Exception e) {
    	    System.out.println("Exception: " + e);
    	}
        return null;
    }

	private static JSONObject itemToJsonObject(Item item) {
        JSONObject item_save = new JSONObject();
        item_save.put("nome", item.getNome());
        item_save.put("peso", item.getPeso());
        item_save.put("raridade", item.getRaridade());
        item_save.put("afinidades", item.getAfinidades());
        item_save.put("efeito_desc", item.getEfeito_Desc());
        item_save.put("desc", item.getDesc());
        return item_save;
    }

    private static JSONObject armaToJsonObject(Arma arma) {
        JSONObject arma_save = itemToJsonObject(arma);
        arma_save.put("dano", arma.getDano());
        arma_save.put("estamina", arma.getEstamina());
        arma_save.put("velocidade", arma.getVelocidade());
        //arma_save.put("tipo", arma.getType().getClass().getName());
        return arma_save;

    }

    private static JSONObject armaduraToJsonObject(Armadura armadura) {
        JSONObject armadura_save = itemToJsonObject(armadura);
        armadura_save.put("protecao", armadura.getProtecao());
        return armadura_save;
    }

    private static void writeJsonIntoFile(JSONObject data, String fileName) {   // Para reaproveitar código
        try {
            FileWriter out = new FileWriter(SaLoHandler.dir_s + fileName);
            out.write(data.toString());
            out.write("\n");
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
