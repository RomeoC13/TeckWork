//package edu.episen.si.ing1.pds.backend.connect;
//
//
//
//import java.io.File;
//import java.net.SocketImpl;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
//
//public class ServerConfig {
//
//	private final static Logger log = LoggerFactory.getLogger(ServerConfig.class.getName());
//
//	private static final String epsenServerConfig = "Episen_conf";
//
//	private  final String  episenServFile ;
//
//	private ServerCoreConfig config;
//
//	public ServerCoreConfig getConfig() {
//		return config;
//	}
//
//	public ServerConfig()  throws Exception{
//		episenServFile = System.getenv(epsenServerConfig);
//		log.debug("configFile = {}", episenServFile);
//
//		final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//		config = mapper.readValue(new File(episenServFile), ServerCoreConfig.class);
//
//	}
//
//
//
//
//
//
//
//}
