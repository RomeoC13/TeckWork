package edu.episen.si.ing1.pds.backend.server;

import java.sql.Connection;

public class DataSource {
	
	private static JDBCConnectionPool pool;
	
	public static Connection sendBackData() {
		return pool.sendBackConnection();
	}
	
	public static void putBackData(Connection con) {
		pool.putBackConnection(con);
	}
	
	public static void closeData() {
		pool.closeConnexion();
	}
}
