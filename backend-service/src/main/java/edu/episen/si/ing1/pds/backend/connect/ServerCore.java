package edu.episen.si.ing1.pds.backend.connect;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.episen.si.ing1.pds.backend.connect.ServerConfig;

public class ServerCore {
	
	private ServerSocket  sSocket;
	private final static Logger log = LoggerFactory.getLogger(serverCore.class.getName());
	
	
	public ServerCore(final ServerConfig config) throws IOException {
		
		sSocket = new ServerSocket(config.getConfig().getListenPort());
		sSocket.setSoTimeout(config.getConfig().getSoTime());
	}
	
	public void serve() throws Exception {
		
		try {
			final Socket socket = sSocket.accept();
			log.debug("ok got timeout");
			
			final ClientRequestManager clientRequestManager = new ClientRequestManager(socket); 
			/*wait for the thread*/
			clientRequestManager.join();
		}catch (Exception e) {
			log.debug("ok got timeout");
		}
		
		
	}
}