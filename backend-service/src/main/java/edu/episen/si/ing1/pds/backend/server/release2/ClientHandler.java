package edu.episen.si.ing1.pds.backend.server.release2;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
//import edu.episen.si.ing1.pds.backend.server.DataSource;
import org.graalvm.compiler.core.common.spi.ConstantFieldProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.sql.*;
import java.util.*;

import static edu.episen.si.ing1.pds.backend.server.release2.Crud.*;
import static java.lang.Thread.sleep;


public class ClientHandler implements Runnable {
    private final static Logger logger = LoggerFactory.getLogger(ClientHandler.class);
    private final Socket clientSocket;
    private final Connection connection;
    private static String[] requestList = new String[10];
    private  DataOutputStream ds;
    private ObjectMapper mapperPrincipal = new ObjectMapper();
    private Boolean done = false;


    // Constructor
    public ClientHandler(Socket socket, Connection connection) {
        this.clientSocket = socket;
        this.connection = connection;


    }

    public void run() {


        ObjectMapper mapper = new ObjectMapper(new JsonFactory());

        try {
            OutputStream out = clientSocket.getOutputStream();
            InputStream in = clientSocket.getInputStream();
             ds = new DataOutputStream(out);
            DataInputStream di = new DataInputStream(in);

            String request = di.readUTF();
            logger.info(request);

            Request mapRequest = mapper.readValue(request, Request.class);


            Map<String, String> map = mapper.readValue(request.split("@")[1], new TypeReference<Map<String, String>>() {
            });

            if (request.split("@")[0].equals("requestBuilding")) {
                ds.writeUTF(requestbuilding(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestFloor")) {
                ds.writeUTF(requestFloor(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestRoom")) {
                ds.writeUTF(requestRoom(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestCompany")) {
                ds.writeUTF(requestCompany(connection, map).toString());
            }

            if (request.split("@")[0].equals("request_id_building")) {
                ds.writeUTF(requestgetBuilding(connection, map).toString());
            }

            if (request.split("@")[0].equals("request_id_floor")) {
                ds.writeUTF(requestgetFloor(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestgetListBuilding")) {
                ds.writeUTF(requestgetListBuilding(connection, map).toString());
            }

            if(mapRequest.getEvent().equals("building"))
                allBuilding();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void allBuilding() {
        try {
            String request = "select * from building";
            ResultSet reSet = connection.createStatement().executeQuery(request);
            List<Map<String, String>> result = new ArrayList<>();

            while (reSet.next()) {
                Map<String, String> resultmap = new HashMap<String, String>();
                resultmap.put("build_id", reSet.getString(1));
                resultmap.put("build_name", reSet.getString(2));

                result.add(resultmap);
            }
            ds.writeUTF(mapperPrincipal.writeValueAsString(result));
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
        } finally {
            done = true;
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

        return sb;
    }

    public static StringBuilder requestFloor(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;


        try {

            String sql = "SELECT name_floor FROM floor INNER JOIN building ON building.id_building = floor.id_building WHERE building.id_building = '" + map.get("id_building") + "'";
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

    public StringBuilder requestRoom(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {
            String sql = "SELECT name_room FROM room INNER JOIN floor ON room.id_floor = floor.id_floor WHERE name_floor = '" + map.get("name_floor") + "'";

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

    public StringBuilder requestCompany(Connection connection, Map<String, String> map) {

        StringBuilder sb = null;

        try {

            String sql = "SELECT company_name FROM room INNER JOIN company ON  company.company_id = room.id_room";
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

    public StringBuilder requestgetBuilding(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {


            String sql = "SELECT id_building FROM building WHERE building_name = '" + map.get("name_building") + "'";
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

    public StringBuilder requestgetFloor(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "SELECT id_floor FROM floor WHERE name_floor = '" + map.get("name_floor") + "'";
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

    public StringBuilder requestgetListBuilding(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "SELECT DISTINCT building_name FROM company INNER JOIN location ON company.company_id = location.company_id INNER JOIN room ON location.id_location = room.id_location INNER JOIN floor ON floor.id_floor = room.id_floor INNER JOIN building ON building.id_building = floor.id_building WHERE company.company_name = '"+map.get("company_name")+"'";
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



