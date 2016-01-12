package com.cru.vsys_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by lukas on 11/7/15.
 */
public class UDPTransmitter implements Runnable {

    private UDPSocket sock;

    public UDPTransmitter(UDPSocket sock) {

        this.sock = sock;

    }

    public static void main(String args[]) {

/*
        try {
            UDPTransmitter t = new UDPTransmitter();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
*/

    }

    public void run() {

        String s;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            while ((s = br.readLine()) != null) {
                this.sock.send(s);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.sock.send("\u0004s");

    }
}
