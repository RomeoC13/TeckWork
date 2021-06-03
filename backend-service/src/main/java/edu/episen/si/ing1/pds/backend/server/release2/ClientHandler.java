package edu.episen.si.ing1.pds.backend.server.release2;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import edu.episen.si.ing1.pds.backend.server.DataSource;
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
import static java.lang.Thread.sleep;


public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final Connection connection;
    private static String[] requestList = new String[10];








    // Constructor
    public ClientHandler(Socket socket, Connection connection) {
        this.clientSocket = socket;
        this.connection = connection;
        this.requestList[0] = "SELECT DISTINCT building_name FROM building";


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
                String sql = "SELECT DISTINCT building_name FROM building WHERE id_building = " +map.get("id_building");
                ResultSet rs = connection.createStatement().executeQuery(sql);
                System.out.println(sql);
                StringBuilder sb = new StringBuilder();
                while(rs.next()) {
                  sb.append(rs.getString(1)+"  ? ");
                }
                ds.writeUTF(sb.toString());
            }






           /* sleep(200);
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
                System.out.println(requestAnswer);
                System.out.println(answer.toString());
                DataOutputStream outdata = new DataOutputStream(out);
                outdata.writeUTF(answer.toString());

            }*/


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

