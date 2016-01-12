package com.cru.vsys_04;

/**
 * Created by lukas on 11/7/15.
 */
public class UDPReceiver implements Runnable {

    private UDPSocket sock;

    public UDPReceiver(UDPSocket sock) {

        this.sock = sock;

    }

    public void run() {

        String s;

        while (!(s = this.sock.recieve(508)).equals("\u0004s")) {
            System.out.println(s);
        }

    }
}
