package edu.episen.si.ing1.pds.backend.server;

import java.io.IOException;
import java.sql.Connection;

public class DataSource {
	
	private static JDBCConnectionPool pool;
	
	
	public DataSource(int size) {
		try {
			pool = new JDBCConnectionPool();
			pool.turnConnection(size);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Connection addData() {
		return pool.addConnection();
	}
	
	public void removeData(Connection con) {
		pool.removeConnection(con);
	}
	
	public static void closeAllConnection() {
		pool.closeConnection();
	}
}
