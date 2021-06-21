package client;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.Home;
import userIHM.WindowsMapping;

import javax.swing.*;
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


    public static void main(String[] args) {

        try {

            configurations = System.getenv(configur);
            String values = Files.readString(Path.of(configurations));
            // System.out.println(values);


            ObjectMapper jmapper = new ObjectMapper(new JsonFactory());

            map = jmapper.readValue(values,
                    new TypeReference<Map<String, Map<String, String>>>() {
                    });
            System.out.println("finis");

            sleep(1000);
/****** setting a beautiful lookandfeel******/
            try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());

                        new Home();
                        break;
                    } else {
                        UIManager.setLookAndFeel  ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    }
                }
            } catch (Exception e) {
                // If Nimbus is not available, you can set to another look and feel.
                // I can't get it to compile or work.
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static String getSend(String request) {


        String answer = null;

        try {
            Socket socket = new Socket(new ClientConfiguration().getConfig().getAdressIP(), new ClientConfiguration().getConfig().getPort());
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();


            ObjectMapper objectMapper = new ObjectMapper();
            String data = objectMapper.writeValueAsString(map.get(request));
            DataInputStream inputData = new DataInputStream(in);
            DataOutputStream outputData = new DataOutputStream(out);
            // System.out.println(request);
            //System.out.println(data);
            outputData.writeUTF(request + "@" + data);
            answer = inputData.readUTF();
            // System.out.println(answer);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

}
