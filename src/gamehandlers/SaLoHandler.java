package gamehandlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.List;

import org.json.JSONObject;

import chars.Charac;
import moves.Move; 
import abstractitens.*; 

public class SaLoHandler {
    private static int identation = 4;
	public static File dir = new File("src");   //diretório pai
	//public static String dir_s = "savedjson/";    //outro dir pai

	public static void saveToFile(SavableObject object) {
        String fileName = object.getSaveFileName();
        try {
			JSONObject object_json_save = object.getSaveJson();
			JSONObject final_json_save = readFromFile(fileName);
            String index = object.getNome();

            if (!final_json_save.has(object.getAddress()))
                final_json_save.put(object.getAddress(), new JSONObject());
            
            final_json_save.getJSONObject(object.getAddress()).put(index, object_json_save);
            writeJsonIntoFile(final_json_save, fileName);
		} catch (Exception e) {
			System.out.println("SaveToFile Exception: " + e);
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
			
			if (key == keys.length-1) {
				return newJson.get(keys[key]);
			}
			
			newJson = (JSONObject) newJson.get(keys[key]);
		}
		
		//Só é chamado caso haja algum problema com a lista passada para o parâmetro keys
		return -1;
	}

    public static Object toClass(String class_name) {
        try {
            @SuppressWarnings("rawtypes")
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

    // toClass with arguments
    @SuppressWarnings("rawtypes")
    public static Object toClass(String class_name, Class[] parameters, Object[] arguments) {
        try {
            @SuppressWarnings("rawtypes")
            Class classe = Class.forName(class_name);
            @SuppressWarnings("unchecked")
            Object objeto = classe.getDeclaredConstructor(parameters).newInstance(arguments);
            return objeto;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return null;
    }

    private static void writeJsonIntoFile(JSONObject data, String fileName) {   // Para reaproveitar código
        try {
            FileWriter out = new FileWriter(fileName);
            out.write(data.toString(SaLoHandler.identation));
            out.write("\n");
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
