package edu.episen.si.ing1.pds.backend.client;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    // driver code
    public static void main(String[] args)
    {
        try {
            Socket socket = new Socket(new ClientConfiguration().getConfig().getAdressIP(), new ClientConfiguration().getConfig().getPort());
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            ClientConfigurationJSON json = new ClientConfigurationJSON();
            ObjectMapper ob = new ObjectMapper(new JsonFactory());
            out.write(ob.writeValueAsBytes(json.getConfig()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
