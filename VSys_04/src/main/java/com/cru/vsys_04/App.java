package com.cru.vsys_04;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main(String args[]) {
        Settings settings = new Settings();
        new CLI(settings, args);

        if (settings.isTCP() && !settings.isError()) {

        	new TCPTransceiver(settings);
        
        } else if ( !settings.isError() ) {
        
        	new UDPTransceiver(settings);
        
        }

    }
}
