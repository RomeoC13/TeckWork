package edu.episen.si.ing1.pds.backend.server.release2;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final static Logger log = LoggerFactory.getLogger(Server.class.getName());
    private ServerSocket server;
    public Server(ServerConfiguration c) {
        try {
            this.server = new ServerSocket(c.getConfig().getPort());
            log.debug("Server starting...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serverService()
    {
        try {

            while (true) {

                // socket object to receive incoming client
                // requests
                Socket client = server.accept();
                log.debug("A new client is here !");
                // create a new thread object
                ClientHandler clientSock = new ClientHandler(client);

                // This thread will handle the client
                // separately
                new Thread(clientSock).start();
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

    public static void main(String[] args) {
        new Server(new ServerConfiguration()).serverService();
    }
}



