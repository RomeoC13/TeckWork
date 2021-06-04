package edu.episen.si.ing1.pds.backend.server.release2;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
//import edu.episen.si.ing1.pds.backend.server.DataSource;
import org.graalvm.compiler.core.common.spi.ConstantFieldProvider;

import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.Map;
import java.util.Properties;

import static edu.episen.si.ing1.pds.backend.server.release2.Crud.read;
import static edu.episen.si.ing1.pds.backend.server.release2.Crud.requestbuilding;
import static java.lang.Thread.sleep;


public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final Connection connection;
    private static String[] requestList = new String[10];


    // Constructor
    public ClientHandler(Socket socket, Connection connection) {
        this.clientSocket = socket;
        this.connection = connection;
       // this.requestList[0] = "SELECT DISTINCT building_name FROM building";


    }

    public void run() {
        ObjectMapper mapper = new ObjectMapper(new JsonFactory());

        try {
            OutputStream out = clientSocket.getOutputStream();
            InputStream in = clientSocket.getInputStream();
            DataOutputStream ds = new DataOutputStream(out);
            DataInputStream di = new DataInputStream(in);

            String request = di.readUTF();
            System.out.println(request);
            System.out.println(" bbbbbbbbbbbbbbbbbbbbbbbb");


            Map<String, String> map = mapper.readValue(request.split("@")[1],new TypeReference<Map<String, String>>(){});

            if(request.split("@")[0].equals("requestBuilding")){

                ds.writeUTF(requestbuilding(connection, map).toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

