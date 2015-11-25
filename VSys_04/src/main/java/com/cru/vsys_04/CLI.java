package com.cru.vsys_04;

import java.util.List;

import org.apache.commons.cli.*;


public class CLI {

    /**
     * print help
     * @param options to generate help from
     */
    private void help(Options options) {
        // automatically generate the help statement
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "jcat", options );
    }

    /**
     * Generate command line pptions and parse them
     * @param settings write options into settings
     * @param args
     */
    public CLI(Settings settings, String args[]) {
        // create Options object
        Options options = new Options();

        options.addOption("h", "help", false, "print this message");
        options.addOption("l", "listen", false, "listen mode, for inbound connects");
        options.addOption("p", "local-port", false, "local port number");
        options.addOption("t", "tcp", false, "TCP mode (default)");
        options.addOption("u", "udp", false, "UDP mode");
        options.addOption(Option.builder("s").longOpt("source").hasArg().argName("ADDRESS").desc("local source address (ip or hostname)").valueSeparator('=').build());

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine line = parser.parse( options, args );
            if(line.hasOption("help")) {
                help(options);
            }
            //listen mode
            if(line.hasOption("l")) {
                settings.setListenMode(true);
                List<String> argsRest = line.getArgList();
                //System.out.println(argsRest);
                if (argsRest.size() == 1) {
                	settings.setLocalPort(Integer.parseInt(argsRest.get(0)));
                }
            } else {
                List<String> argsRest = line.getArgList();
                //System.out.println(argsRest);
                if (argsRest.size() == 2) {
                    settings.setRemoteHost(argsRest.get(0));
                    settings.setRemotePort(Integer.parseInt(argsRest.get(1)));
                }
            }
            //TCP Mode
            if (line.hasOption("t") && !line.hasOption("u")) {
            	settings.setTCP(true);
            }
            //UDP Mode
            if (line.hasOption("u") && !line.hasOption("t")) {
            	settings.setTCP(false);
            }
            //TCP & UDP Mode, error
            if (line.hasOption("t") && line.hasOption("u")) {
            	System.out.println("Error, don't choose UDP and TCP!");
            	settings.setError(true);
//            	throw new ParseException("");
            }
            
        }
        catch( ParseException exp ) {
            // oops, something went wrong
            System.err.println( "Parsing failed.  Reason: " + exp.getMessage() );
        }
    }
}
