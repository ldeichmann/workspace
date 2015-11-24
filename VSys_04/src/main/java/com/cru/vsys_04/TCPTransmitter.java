package com.cru.vsys_04;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.BufferedReader;


public class TCPTransmitter implements Runnable {

	Socket sock;
	
	TCPTransmitter(Socket sock) {
		
		this.sock = sock;
		
	}

	public void run() {
		try {
			PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s;
			while ((s = br.readLine()) != null) {
				out.println(s);
			}
			
			sock.shutdownOutput();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
