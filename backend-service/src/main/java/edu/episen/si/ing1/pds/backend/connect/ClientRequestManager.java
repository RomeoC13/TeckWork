package edu.episen.si.ing1.pds.backend.connect;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.security.AccessControlContext;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientRequestManager implements Runnable {

	
	private final static Logger log = LoggerFactory.getLogger(ClientRequestManager.class.getName());
	private final InputStream input;
	private final OutputStream output;
	private Thread self;
	private final static String name = "client_server";
	
	
	public ClientRequestManager(final Socket socket) throws Exception {
		
		input = socket.getInputStream();
		output = socket.getOutputStream();
		self = new Thread(name);
		self.start();
	}
	
	public void run() {
		byte [] inputData;
		try {
			inputData = new byte[input.available()];
			input.read(inputData);
			log.debug("data received {} bytes , content={}" ,inputData.length, new String(inputData));
			
			
			final ObjectMapper mapper = new ObjectMapper();
			
			final Map<String, String> result = new HashMap<String, String>();
			result.put("result", "ok");
			output.write(mapper.writeValueAsBytes(result));
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void join() throws InterruptedException {
		self.join();
		
	}
	
}

