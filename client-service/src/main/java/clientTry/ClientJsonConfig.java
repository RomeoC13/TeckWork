package clientTry;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import client.ClientJsonProperties;

public class ClientJsonConfig {
    private final String configvar = "JSONCONF";
    private final String configlocation;
    private static Map<String, Map<String, String>> map;
    private static String values;

    public ClientJsonConfig() {
        configlocation = System.getenv(configvar); // récupérer la valeur de la variable d'environnement
        ObjectMapper mapper = new ObjectMapper(new JsonFactory());
        
        try {
        	values = Files.readString(Path.of(configlocation)); 
            map = mapper.readValue(values,new TypeReference<Map<String, Map<String, String>>>() {});
                       
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Map<String, Map<String, String>> getMap() {
		return map;
	}
    
    public String getValues() {
		return values;
	}
    
}
