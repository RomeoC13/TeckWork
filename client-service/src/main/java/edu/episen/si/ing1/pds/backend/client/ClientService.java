package edu.episen.si.ing1.pds.backend.client;

import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientService {
    private static final Logger logger = LoggerFactory.getLogger(ClientService.class.getName());

    public static void main(String[] args) {
        boolean isInTestMode = false;
        int maxCo = 10;

        Options options = new Options();
        options.addOption("testMode", false, "a simple cli option to run this service as test, default is false");

        final Option maxConnection = Option.builder().longOpt("maxConnections")
                .hasArg()
                .argName("maxConnections")
                .desc("specify max connections in this run, default set to 10")
                .build();

        options.addOption(maxConnection);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            logger.error("Options parser error : " + e.getMessage());
        }

        String loggerInfo = "ClientService is running.";
        if (cmd.hasOption("testMode")) {
            isInTestMode = true;
            loggerInfo += "\n Test mode is on";
        }
        if (cmd.hasOption("maxConnections")) {
            maxCo = Integer.parseInt(cmd.getOptionValue("maxConnections"));
            loggerInfo += "\n Max connections has been set to " + maxCo;

        }
        logger.info(loggerInfo);
    }

}
