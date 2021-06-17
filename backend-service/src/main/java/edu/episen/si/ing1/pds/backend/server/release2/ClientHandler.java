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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static edu.episen.si.ing1.pds.backend.server.release2.Crud.*;
import static java.lang.Thread.sleep;


public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final Connection connection;
    private static String[] requestList = new String[10];
    private final static Logger log = LoggerFactory.getLogger(ClientHandler.class.getName());


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
            DataOutputStream ds = new DataOutputStream(out);
            DataInputStream di = new DataInputStream(in);

            String request = di.readUTF();
            System.out.println(request);


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

            if (request.split("@")[0].equals("requestGetIdRoom")) {
                ds.writeUTF(requestGetIdRoom(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestUpdate")) {
                ds.writeUTF(requestUpdate(connection, map).toString());
            }
            if (request.split("@")[0].equals("requestScreenIsEmpty")) {
                ds.writeUTF(requestScreenIsEmpty(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestUpdatePrise")) {
                ds.writeUTF(requestUpdatePrise(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestPriseIsEmpty")) {
                ds.writeUTF(requestPriseIsEmpty(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestUpdateSensor")) {
                ds.writeUTF(requestUpdateSensor(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestSensorIsEmpty")) {
                ds.writeUTF(requestSensorIsEmpty(connection, map).toString());
            }
            if (request.split("@")[0].equals("requestAllCompany")){
                ds.writeUTF(NberCompany(connection, map).toString());
            }
            if (request.split("@")[0].equals("comboxCompany")){
                ds.writeUTF(comboxNameCompany(connection, map).toString());
            }

            //starting condition for indicators

            if (request.split("@")[0].equals("rateOccupation")){
                ds.writeUTF(rateOccupation(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestUpdateWindows")) {
                ds.writeUTF(requestUpdateWindows(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestWindowsIsEmpty")) {
                ds.writeUTF(requestWindowsIsEmpty(connection, map).toString());
            }
            if (request.split("@")[0].equals("rateOccupation")) {
                ds.writeUTF(rateOccupation(connection, map).toString());
            }
            if (request.split("@")[0].equals("connectedObject")) {
                ds.writeUTF(getConnectedObjets(connection, map).toString());
            }
            if (request.split("@")[0].equals("AllEquipment")) {
                ds.writeUTF(getAllEquipments(connection, map).toString());
            }
            if (request.split("@")[0].equals("allSensor")) {
                ds.writeUTF(getAllSensor(connection, map).toString());
            }
            if (request.split("@")[0].equals("allCompany")) {
                ds.writeUTF(getAllCompany(connection, map).toString());
            }
            if (request.split("@")[0].equals("energyConsommation")) {
                ds.writeUTF(getEnergy(connection, map).toString());
            }

            //ending conditions for indicators

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getEnergy(Connection connection, Map<String, String> map) {
        String value = null;
        try{
            String sql = "select sum(energy) from building";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next())
                value = rs.getString(1);
            log.info(value);
        }catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }

    private String getAllCompany(Connection connection, Map<String, String> map) {
        String value = null;
        try{
            String sql = "select count(*) from company";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next())
                value = rs.getString(1);
            log.info(value);
        }catch (Exception e){
            e.printStackTrace();
        }
        return value;

    }

    private String getAllSensor(Connection connection, Map<String, String> map) {
        String value = null;
        String value2 = null;
        String resp = null;
        try{
            String sql = "select count(position_sensor) from room where position_sensor=true ";
            String sql2 = "select count(position_sensor) from room where position_sensor=false";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            ResultSet rs2 = connection.createStatement().executeQuery(sql2);
            while (rs.next())
                value = rs.getString(1);
            while (rs2.next())
                value2 = rs2.getString(1);
            log.info(resp);
            resp = value+"/"+value2;
        }catch (Exception e){
            e.printStackTrace();
        }
        return resp;
    }

    private StringBuilder getAllEquipments(Connection connection, Map<String, String> map) {
        return null;
    }

    private StringBuilder getConnectedObjets(Connection connection, Map<String, String> map) {
        return null;
    }

    private StringBuilder rateOccupation(Connection connection, Map<String, String> map) {
        StringBuilder value = null;

        try {
            String sql = "(select count(*) from room where status = 'booked'";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()){
                value.append(rs.getString(1));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }

    private List<String> comboxNameCompany(Connection connection, Map<String, String> map)  {
        List<String> name = new ArrayList<>();
        try {
            String request = "select company_name from company";
            ResultSet rs = connection.createStatement().executeQuery(request);
            while (rs.next()) {
                name.add(rs.getString(1));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return name;
    }

    private String NberCompany(Connection connection, Map<String, String> map) {
        String nbre = null;
        try {
            String sql = "select count(company_name) from company";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            log.info(sql);
            while (rs.next()){
                nbre = rs.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return nbre;
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
            String sql = "SELECT name_room FROM company INNER JOIN LOCATION ON company.company_id = location.company_id " +
                    "INNER JOIN room ON room.id_location = location.id_location INNER JOIN floor ON floor.id_floor = room.id_floor " +
                    "INNER JOIN building ON building.id_building = floor.id_building WHERE company.company_name = '" + map.get("company_name") +
                    "' AND floor.name_floor = '" + map.get("floor_name") +
                    "' AND building.building_name = '" + map.get("building_name") + "'";


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

            String sql = "SELECT DISTINCT building_name FROM company INNER JOIN location ON" +
                    " company.company_id = location.company_id INNER JOIN room" +
                    " ON location.id_location = room.id_location INNER JOIN floor ON" +
                    " floor.id_floor = room.id_floor INNER JOIN building ON" +
                    " building.id_building = floor.id_building " +
                    "WHERE company.company_name = '" + map.get("company_name") + "'";
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

    public StringBuilder requestGetIdRoom(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "SELECT id_room FROM company INNER JOIN LOCATION " +
                    "ON company.company_id = location.company_id INNER JOIN room " +
                    "ON room.id_location = location.id_location INNER JOIN floor " +
                    "ON floor.id_floor = room.id_floor INNER JOIN building " +
                    "ON building.id_building = floor.id_building WHERE room.name_room = '" + map.get("name_room") + "'";
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

    public StringBuilder requestUpdate(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "UPDATE room set position_screen = '" + map.get("value") +
                    "'" + "WHERE id_room = " + map.get("id_room") + "";

            connection.createStatement().executeUpdate(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            sb.append("Update done");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sb;
    }

    public StringBuilder requestScreenIsEmpty(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "SELECT position_screen FROM room" +
                    "    WHERE id_room = '" + map.get("id_room") + "'";
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

    public StringBuilder requestUpdatePrise(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "UPDATE room set position_plug = '" + map.get("value") +
                    "'" + "WHERE id_room = " + map.get("id_room") + "";

            connection.createStatement().executeUpdate(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            sb.append("Update done");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sb;
    }

    public StringBuilder requestPriseIsEmpty(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "SELECT position_plug FROM room" +
                    "    WHERE id_room = '" + map.get("id_room") + "'";
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

    public StringBuilder requestUpdateSensor(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "UPDATE room set position_sensor = '" + map.get("value") +
                    "'" + "WHERE id_room = " + map.get("id_room") + "";

            connection.createStatement().executeUpdate(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            sb.append("Update done");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sb;
    }

    public StringBuilder requestSensorIsEmpty(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "SELECT position_sensor FROM room" +
                    "    WHERE id_room = '" + map.get("id_room") + "'";
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

    public StringBuilder requestUpdateWindows(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "UPDATE room set position_windows = '" + map.get("value") + "'" + "WHERE id_room = " + map.get("id_room") + "";

            connection.createStatement().executeUpdate(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            sb.append("Update done");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sb;
    }

    public StringBuilder requestWindowsIsEmpty(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "SELECT position_windows FROM room" +
                    "    WHERE id_room = '" + map.get("id_room") + "'";
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



