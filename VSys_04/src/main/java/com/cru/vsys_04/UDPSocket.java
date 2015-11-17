package com.cru.vsys_04;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @
 */
public class UDPSocket {
    private static final int BUFSIZE = 508;
    private InetAddress remoteAddr;
    private int remotePort, localPort;
    private DatagramSocket socket;

    public UDPSocket(Settings settings) {

        try {
            if (settings.isListenMode()) {
                this.localPort = settings.getLocalPort();
                this.socket = new DatagramSocket(this.localPort);
                if ((settings.getSource() != null) && (settings.getSource().length() > 0)) {
                    this.remoteAddr = InetAddress.getByName(settings.getSource());
                }
            } else {

                this.remotePort = settings.getRemotePort();
                this.remoteAddr = InetAddress.getByName(settings.getRemoteHost());
                this.socket = new DatagramSocket(); // anonymous



            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * Send string to remote host
     * @param s Content to send to remote host
     */
    public void send(String s) {

        try {
            byte data[] = s.getBytes();
            DatagramPacket packetOut = new DatagramPacket(data, data.length, this.remoteAddr, this.remotePort);
            this.socket.send(packetOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    /**
     * Recieve content from remote machine
     * @param maxBytes max bytes to be received
     * @return remote message
     */
    public String recieve(int maxBytes) {

        try {
            // paket empfangen
            DatagramPacket packetIn = new DatagramPacket(new byte[maxBytes], maxBytes);
            this.socket.receive(packetIn);
            String received = new String(packetIn.getData(), 0, packetIn.getLength());
            if (this.remoteAddr == null) {
	            this.remoteAddr = packetIn.getAddress();
	            this.remotePort = packetIn.getPort();
            }
            return received;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";


    }

}
