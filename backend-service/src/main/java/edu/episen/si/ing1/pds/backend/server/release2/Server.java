package edu.episen.si.ing1.pds.backend.server.release2;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.episen.si.ing1.pds.backend.server.DataSource;

public class Server {
	

    private final static Logger log = LoggerFactory.getLogger(Server.class.getName());
    private ServerSocket server;
    private static DataSource ds;
    public Server(ServerConfiguration c) throws Exception {
        try {
            this.server = new ServerSocket(c.getConfig().getPort());
            Properties props = new Properties();
            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("app.properties"));
            this.ds = new DataSource(c.getN(), props);
            
            log.debug("Server starting...");
            serverService();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serverService() throws Exception
    {
    	Thread currentThread = null;
        try {
        		
            while (true) {

                // socket object to receive incoming client
                // requests
                Socket client = server.accept();
                log.debug("A new client is here !");
                // create a new thread object
                Connection connection = ds.addData();
                ClientHandler clientSock = new ClientHandler(client, connection);
                // This thread will handle the client
                // separately
                currentThread = clientSock.getClientThread();
                currentThread.join();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (server != null) {
                try {
                    server.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(new ServerConfiguration(25));
       // server.serverService();
    }
}





