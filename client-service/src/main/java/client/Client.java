package client;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class Client {
    private final static Logger log = LoggerFactory.getLogger(Client.class.getName());
    public static void main(String[] args)
    {
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
            log.debug("The server answered : {} ", msg);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
