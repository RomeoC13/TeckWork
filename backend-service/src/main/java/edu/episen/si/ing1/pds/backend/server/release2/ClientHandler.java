package edu.episen.si.ing1.pds.backend.server.release2;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;

import static java.lang.Thread.sleep;

public  class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private  final Connection connection;

    // Constructor
    public ClientHandler(Socket socket, Connection connection) {
        this.clientSocket = socket;
        this.connection = connection;
    }

    public void run()
    {

        try {
            OutputStream out = clientSocket.getOutputStream();
            InputStream in = clientSocket.getInputStream();
            byte[] data;
            sleep(200);
            if (in.available() != 0 ) {
                data = new byte[in.available()];
                in.read(data);
                ObjectMapper om = new ObjectMapper(new JsonFactory());
             
                ClientJsonProperties json = om.readValue(data, ClientJsonProperties.class);
  
                System.out.print("Name received: ");
                System.out.println(json.getName());
                System.out.print("Age received: ");
                System.out.println(json.getAge());
                System.out.print("City received: ");
                System.out.println(json.getAddress());
     


                String sql = "INSERT INTO test(name, age, address) VALUES (?, ?, ?)";
					PreparedStatement stmt = connection.prepareStatement(sql);
					stmt.setString(1, json.getName());
					stmt.setInt(2, json.getAge());
					stmt.setString(3, json.getAddress());

					stmt.executeUpdate();
				}
            
            DataOutputStream outdata = new DataOutputStream(out);
            outdata.writeUTF("Your json has been stored in DB");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

