package chat.cs.sockets;

import java.net.Socket;

import chat.cs.Poller;
import chat.cs.GUI;
import chat.cs.IChat;

public class Client {
	private IChat proxy;
	private GUI gui;
	private String ownName;
	private Poller poller;

	public Client(String host, int port) throws Exception {
		Socket socket = new Socket(host, port);
		proxy  = new ServerProxy(socket);
		gui    = new GUI(proxy);
		poller = new Poller(proxy, gui);
	}

	public void startClient() throws Exception {
		ownName = gui.showLoginFrame();
		gui.showChatFrame();
		proxy.login(ownName);
		poller.setOwnName(ownName);
		poller.start();
	}

	public static void main(String[] args) {
		try {
			if ((args.length == 0) || (args.length > 2)) {
				System.out.println("usage: client <host> <port>");
				return;
			}
			new Client(args[0], Integer.parseInt(args[1])).startClient();
		} catch (Exception e) {System.err.println(e);}
	} 
} 
