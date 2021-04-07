package edu.episen.si.ing1.pds.backend.server.release2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class ServerConfiguration {
    private final String configvar = "CONF";
    private final String configlocation;
    private ServerProperties config;

    public ServerConfiguration() {
        configlocation = System.getenv(configvar); // récupérer la valeur de la variable d'environnement
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            config = mapper.readValue(new File(configlocation),ServerProperties.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ServerProperties getConfig() {
        return config;
    }
}
