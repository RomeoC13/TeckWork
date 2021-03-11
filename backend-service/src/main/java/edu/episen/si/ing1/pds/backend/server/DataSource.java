package edu.episen.si.ing1.pds.backend.server;

public class DataSource {

    static JDBCConnexionPool connectionPool;

    public DataSource() {
        connectionPool = new JDBCConnexionPool();
    }


}
