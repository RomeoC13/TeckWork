package edu.episen.si.ing1.pds.backend.server.release2;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import edu.episen.si.ing1.pds.backend.server.DataSource;

import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import static edu.episen.si.ing1.pds.backend.server.release2.Crud.read;
import static java.lang.Thread.sleep;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final Connection connection;
    private static String[] requestList = new String[1];

    // Constructor
    public ClientHandler(Socket socket, Connection connection) {
        this.clientSocket = socket;
        this.connection = connection;
        this.requestList[0] = "SELECT DISTINCT name FROM equipment";
    }

    public void run() {

        try {
            OutputStream out = clientSocket.getOutputStream();
            InputStream in = clientSocket.getInputStream();
            byte[] data;
            sleep(200);
            if (in.available() != 0) {
                data = new byte[in.available()];
                in.read(data);
                ObjectMapper om = new ObjectMapper(new JsonFactory());

                ClientJsonProperties json = om.readValue(data, ClientJsonProperties.class);

                System.out.println(json.getRequestId());

                String[] requestAnswer = read(requestList[Integer.parseInt(json.getRequestId())], connection);
                StringBuilder answer = new StringBuilder();
                for (String s : requestAnswer) {
                    answer.append(s).append(",");
                }
                System.out.println(answer.toString());
                DataOutputStream outdata = new DataOutputStream(out);
                outdata.writeUTF(answer.toString());


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

