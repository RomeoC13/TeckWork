package edu.episen.si.ing1.pds.backend.server.release2;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import static java.lang.Thread.sleep;

public  class ClientHandler implements Runnable {
    private final Socket clientSocket;

    // Constructor
    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run()
    {
//Recevoir les données envoyé par le client et de renvoyer de choses aux clients
        try {
            OutputStream out = clientSocket.getOutputStream();
            InputStream in = clientSocket.getInputStream();
            byte[] data; // permettre de recevoir les données envoyé par le outputstream du client
            sleep(200);
            if (in.available() != 0 ) {
                data = new byte[in.available()];
                in.read(data);
                System.out.println(data.toString());
                ObjectMapper om = new ObjectMapper(new JsonFactory());
                om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                ClientJsonProperties json = om.readValue(data, ClientJsonProperties.class);

                System.out.println(json.getName());
                System.out.println(json.getAge());
                System.out.println(json.getAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

