package com.cru.vsys_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTransceiver {

	ServerSocket serverSocket;
	Socket sock;

	public TCPTransceiver(Settings settings) {

		if (settings.isListenMode() && settings.getLocalPort() != 0) {

			try {
				this.serverSocket = new ServerSocket(settings.getLocalPort());
				this.sock = serverSocket.accept();

				(new Thread(new TCPReceiver(this.sock))).start();
				(new Thread(new TCPTransmitter(this.sock))).start();

			} catch (IOException e) {
				System.err.println(e);
			}

			// new Thread(TCPR)

		} else {

			try {

				this.sock = new Socket(settings.getRemoteHost(), settings.getRemotePort());
				(new Thread(new TCPReceiver(this.sock))).start();
				(new Thread(new TCPTransmitter(this.sock))).start();

			} catch (Exception e) {
				System.err.println(e);
			}

		}

		// this.sock = new UDPSocket(settings);
		// this.rec = new UDPReceiver(this.sock);
		// this.trans = new UDPTransmitter(this.sock);
		//
		// if ( (settings.getRemotePort() != 0) || (settings.getLocalPort() !=
		// 0) || (settings.getRemoteHost().length() > 6) ) {
		//
		// (new Thread(new UDPReceiver(this.sock))).start();
		// (new Thread(new UDPTransmitter(this.sock))).start();
		//
		// }

	}

}
