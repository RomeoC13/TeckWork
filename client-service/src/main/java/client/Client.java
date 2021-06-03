package client;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import userIHM.WindowsMapping;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static java.lang.Thread.sleep;

public class Client {
    private final static Logger log = LoggerFactory.getLogger(Client.class.getName());
    private final static   String configur = "Configuration";
    private  static String configurations;
    private ClientProperties config;


    public static Map<String, Map<String, String>> map;

    public Client() {
    }



    public static void main(String[] args)
    {

        try {

            configurations = System.getenv(configur);
            String values = Files.readString(Path.of(configurations));
            System.out.println(values);

            String requestBuilding = "requestBuilding";
            String id_building = "2";
            ObjectMapper jmapper = new ObjectMapper(new JsonFactory());
            map = jmapper.readValue(values,
                    new TypeReference<Map<String, Map<String, String>>>() {});
            map.get(requestBuilding).put("id_building",id_building);

            Socket socket = new Socket(new ClientConfiguration().getConfig().getAdressIP(), new ClientConfiguration().getConfig().getPort());
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
           // ClientConfigurationJSON json = new ClientConfigurationJSON();
            ObjectMapper ob = new ObjectMapper(new JsonFactory());

            ObjectMapper objectMapper = new ObjectMapper();
            String data = objectMapper.writeValueAsString(map.get(requestBuilding));
            DataInputStream inputData = new DataInputStream(in);
            DataOutputStream outputData = new DataOutputStream(out);
            outputData.writeUTF(requestBuilding+"@"+data);
            String answer = inputData.readUTF();
            System.out.println(answer);



            sleep(1000);
           // String msg = inputData.readUTF();
           // log.debug("The server answered : {} ", msg);
            new WindowsMapping();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
