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

	/**
	 * Start TCP Transceiver using settings
	 * @param settings
	 */
	public TCPTransceiver(Settings settings) {

		// are we listening?
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

		} else { // nope

			try {

				this.sock = new Socket(settings.getRemoteHost(), settings.getRemotePort());
				(new Thread(new TCPReceiver(this.sock))).start();
				(new Thread(new TCPTransmitter(this.sock))).start();

			} catch (Exception e) {
				System.err.println(e);
			}

		}
	}

}
