//package edu.episen.si.ing1.pds.backend.connect;
//
//import org.apache.commons.cli.CommandLine;
//import org.apache.commons.cli.CommandLineParser;
//import org.apache.commons.cli.DefaultParser;
//import org.apache.commons.cli.Option;
//import org.apache.commons.cli.Options;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import essai.serverCore;
//
//public class Experimental {
//
//
//	private final static Logger log = LoggerFactory.getLogger(Experimental.class.getName());
//
//	public static ServerConfig serverConfig;
//	public ServerCore serverCore;
//
//
//	public static void main(String[] args) {
//
//		final Options options  = new Options();
//
//		final Option serverMode = Option.builder().longOpt("server").build();
//		final Option clientMode = Option.builder().longOpt("client").build();
//
//
//		options.addOption(serverMode);
//		options.addOption(clientMode);
//
//		final CommandLineParser parser = new DefaultParser();
//		final CommandLine commandLine = parser.parse(options, args);
//
//		if(commandLine.hasOption("serverMode")) {
//			log.debug("what do you want");
//		}
//		serverConfig = new ServerConfig();
//		if(commandLine.hasOption("server")) {
//			log.info(null);
//		}
//
//
//
//}
