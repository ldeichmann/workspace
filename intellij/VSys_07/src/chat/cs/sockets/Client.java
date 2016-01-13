package chat.cs.sockets;

import java.net.Socket;

import chat.cs.*;

public class Client {
	private IChat proxy;
	private GUI gui;
	private String ownName;
	private Poller poller;
	private ViewCommunicator vc;

    /**
     * Create Client instance
     * @param host server address
     * @param port server port
     * @throws Exception
     */
	public Client(String host, int port) throws Exception {
		Socket socket = new Socket(host, port);
		proxy  = new ServerProxy(socket);
		gui    = new GUI(proxy);
		this.vc = new ViewCommunicator(proxy, gui);
        new Thread(this.vc).start();
	}

    /**
     * start client
     * @throws Exception
     */
	public void startClient() throws Exception {
        ownName = gui.showLoginFrame();
        gui.showChatFrame();
//		System.out.println(this.vc.serverSocket.getInetAddress().getLocalHost());
        proxy.login(ownName, new ViewProxy(this.vc.serverSocket.getInetAddress().getLocalHost(), this.vc.serverSocket.getLocalPort()));
//        poller.setOwnName(ownName);
//        poller.start();
	}

	public static void main(String[] args) {
		try {
			if ((args.length == 0) || (args.length > 2)) {
				System.out.println("usage: client <host> <port>");
				return;
			}
			new Client(args[0], Integer.parseInt(args[1])).startClient();
		} catch (Exception e) {e.printStackTrace();}
	} 
} 
