package client;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.Home;
import userIHM.WindowsMapping;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static java.lang.Thread.sleep;

public class Client {
    private final static Logger log = LoggerFactory.getLogger(Client.class.getName());
    private final static String configur = "Configuration";
    private static String configurations;
    private ClientProperties config;


    public static Map<String, Map<String, String>> map;
    private static Socket socket;
    private static InputStream in;
    private static OutputStream out;

    public static Socket getSocket() {
        return socket;
    }

    public static InputStream getIn() {
        return in;
    }

    public static OutputStream getOut() {
        return out;
    }

    public Client() {
    }




    public static void main(String[] args) {

        try {





            socket = new Socket(new ClientConfiguration().getConfig().getAdressIP(), new ClientConfiguration().getConfig().getPort());

            // ClientConfigurationJSON json = new ClientConfigurationJSON();
            // ObjectMapper ob = new ObjectMapper(new JsonFactory());




            sleep(1000);
            // String msg = inputData.readUTF();
            //log.debug("The server answered : {} ", msg);
            new WindowsMapping(socket);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String[] getBuilding(Socket socket) {
        String answer = null;
        try {
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            configurations = System.getenv(configur);

            String values = Files.readString(Path.of(configurations));
            System.out.println(values);

            String requestBuilding = "requestBuilding";
            String id_building = "2";
            ObjectMapper jmapper = new ObjectMapper(new JsonFactory());
            map = jmapper.readValue(values,
                    new TypeReference<Map<String, Map<String, String>>>() {
                    });
            map.get(requestBuilding).put("id_building", id_building);

            ObjectMapper objectMapper = new ObjectMapper();
            String data = objectMapper.writeValueAsString(map.get(requestBuilding));
            DataInputStream inputData = new DataInputStream(in);
            DataOutputStream outputData = new DataOutputStream(out);
            outputData.writeUTF(requestBuilding + "@" + data);
            answer = inputData.readUTF();
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] building = answer.split("@");
        for (String b : building) {
            if (b.contains("@")) {
                b.replace("@", "");
            }
            System.out.println(b);
        }
        return building;
    }
}
