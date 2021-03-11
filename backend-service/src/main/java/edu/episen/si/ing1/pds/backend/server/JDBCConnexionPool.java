package edu.episen.si.ing1.pds.backend.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class JDBCConnexionPool {


    RetrieveProperties rp;
    private ArrayList<Connection> collection;

    public JDBCConnexionPool() {
        rp = new RetrieveProperties();
        collection = new ArrayList<>(10);
    }

    public void feedCollection() {
        for(int i=0; i<collection.size(); i++) {
            try{Class.forName(rp.getDriver());
                Connection con = DriverManager.getConnection(rp.getUrl(), rp.getLogin(), rp.getPassword());
                collection.add(con);
            }catch(ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection returnConnection() {
        Connection c;
        c=collection.get(0);
        collection.remove(0);
        return c;
    }

    public void retrieveConnection(Connection c) {
        collection.add(c);
    }

    public void closeConnections() {
        for (int i = 0; i < collection.size(); i++) {
            try {
                collection.get(i).close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}


