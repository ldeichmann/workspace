package chat.cs;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;

import chat.*;
import chat.cs.sockets.Message;

public class ViewProxy implements IView, Serializable {

	private Socket socket;
	private InetAddress host;
	private int port;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private boolean connected = false;

	public ViewProxy(InetAddress host, int port) {
		this.host = host;
		this.port = port;
	}
	
	@Override
	public void update(ChatEvent evt) throws Exception {
		
		if (!this.connected) {
			try {
				this.socket = new Socket(this.host, this.port);
				this.out = new ObjectOutputStream(this.socket.getOutputStream());
				this.in = new ObjectInputStream(this.socket.getInputStream());
				this.connected = true;
			} catch (Exception e) {
				System.out.println("ViewProxy could not connect");
			}
		}
		this.out.writeObject(evt);
		this.out.reset();
		if ( !( ( (Message)this.in.readObject() ).getMessageType() == Message.CONFIRM ) ) {
			System.out.println("Error");
		}
		
	}

	
	
	
	
}