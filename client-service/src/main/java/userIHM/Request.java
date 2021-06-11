/*
package userIHM;

import client.ClientConfiguration;
import client.ClientConfigurationJSON;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

import static java.lang.Thread.sleep;

public class Request {
    public static String[] getEquipment() {
        String[] equipment = null;
        String[] equipmentName = null;

        try {
            Socket socket = new Socket(new ClientConfiguration().getConfig().getAdressIP(), new ClientConfiguration().getConfig().getPort());
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            ClientConfigurationJSON json = new ClientConfigurationJSON();
            ObjectMapper ob = new ObjectMapper(new JsonFactory());
            out.write(ob.writeValueAsBytes(json.getConfig()));
            DataInputStream inputData = new DataInputStream(in);
            sleep(1000);
            String msg = inputData.readUTF();
            equipment = msg.split(",");
            int count = 0;
            for (int i = 0; i < equipment.length; i++) {
                if (equipment[i].equals("null")) {
                    count++;
                }
            }
            equipmentName = new String[equipment.length-count];
            for (int i = 0; i < equipmentName.length; i++) {
                equipmentName[i] = equipment[i];
            }
            System.out.println(Arrays.toString(equipmentName));


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return equipmentName;
    }

    public static String[] getBatiment() {
        String[] batiment = null;
        String[] batimentName = null;

        try {
            Socket socket = new Socket(new ClientConfiguration().getConfig().getAdressIP(), new ClientConfiguration().getConfig().getPort());
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            ClientConfigurationJSON json = new ClientConfigurationJSON();
            ObjectMapper ob = new ObjectMapper(new JsonFactory());
            out.write(ob.writeValueAsBytes(json.getConfig()));
            DataInputStream inputData = new DataInputStream(in);
            sleep(1000);
            String msg = inputData.readUTF();
            batiment = msg.split(",");
            int count = 0;
            for (int i = 0; i < batiment.length; i++) {
                if (batiment[i].equals("null")) {
                    count++;
                }
            }
            batimentName = new String[batiment.length-count];
            for (int i = 0; i < batimentName.length; i++) {
                batimentName[i] = batiment[i];
            }
            System.out.println(Arrays.toString(batimentName));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return batimentName;
    }
}

*/
