package com.cru.vsys_04;

public class UDPTransceiver {
    private UDPSocket sock;


    public UDPTransceiver(Settings settings) {

        this.sock = new UDPSocket(settings);
//        this.rec = new UDPReceiver(this.sock);
//        this.trans = new UDPTransmitter(this.sock);
        
        if ( (settings.getRemotePort() != 0) || (settings.getLocalPort() != 0) || (settings.getRemoteHost().length() > 6) ) {
        
        	(new Thread(new UDPReceiver(this.sock))).start();
	        (new Thread(new UDPTransmitter(this.sock))).start();
        
        }


    }

}
