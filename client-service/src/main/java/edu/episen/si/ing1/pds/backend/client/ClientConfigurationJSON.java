package edu.episen.si.ing1.pds.backend.client;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class ClientConfigurationJSON {
    private final String configvar = "JSONCONF";
    private final String configlocation;
    private ClientJsonProperties config;

    public ClientConfigurationJSON() {
        configlocation = System.getenv(configvar); // récupérer la valeur de la variable d'environnement
        ObjectMapper mapper = new ObjectMapper(new JsonFactory());
        try {
            config = mapper.readValue(new File(configlocation),ClientJsonProperties.class);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ClientJsonProperties getConfig() {
        return config;
    }
}
