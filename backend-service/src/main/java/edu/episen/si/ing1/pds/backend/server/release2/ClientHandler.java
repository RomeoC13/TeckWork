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
import java.sql.*;
import java.util.Map;
import java.util.Properties;

import static edu.episen.si.ing1.pds.backend.server.release2.Crud.*;
import static java.lang.Thread.sleep;


public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final Connection connection;
    private static String[] requestList = new String[10];


    // Constructor
    public ClientHandler(Socket socket, Connection connection) {
        this.clientSocket = socket;
        this.connection = connection;


    }

    public void run() {
        System.out.println("cvcvcvcvcvcvcvc");

        ObjectMapper mapper = new ObjectMapper(new JsonFactory());

        try {
            OutputStream out = clientSocket.getOutputStream();
            InputStream in = clientSocket.getInputStream();
            DataOutputStream ds = new DataOutputStream(out);
            DataInputStream di = new DataInputStream(in);

            String request = di.readUTF();
            System.out.println(request);




            Map<String, String> map = mapper.readValue(request.split("@")[1], new TypeReference<Map<String, String>>() {
            });

            if (request.split("@")[0].equals("requestBuilding")) {

                ds.writeUTF(requestbuilding(connection, map).toString());

            }
            System.out.println(request.split("@")[0]);


            if (request.split("@")[0].equals("requestFloor")) {
                ds.writeUTF(requestFloor(connection, map).toString());
                System.out.println();
                System.out.println("tutu2");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static StringBuilder requestbuilding(Connection connection, Map<String, String> map) {

        StringBuilder sb = null;
        try {
            String sql = "SELECT building_name FROM building";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getString(1) + "@");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
        return sb;
    }

    public static StringBuilder requestFloor(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;
        System.out.println("tutu4");
        try {

            String sql = "SELECT name_floor FROM Floor INNER JOIN Building ON floor.id_floor = building.id_building WHERE Building.id_building = 3";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getString(1) + "@");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sb;

    }

}

