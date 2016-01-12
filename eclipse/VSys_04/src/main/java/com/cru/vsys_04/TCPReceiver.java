package com.cru.vsys_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPReceiver implements Runnable {

	Socket sock;
	
	/**
	 * TCP Receiver
	 * @param sock Opened Socket
	 */
	TCPReceiver(Socket sock) {
		
		this.sock = sock;
		
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			String input;
			while ((input = in.readLine()) != null) {
				System.out.println(input);
			}
			sock.shutdownInput();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
}
