package chat.cs.sockets;

import chat.cs.ChatEventManager;
import java.net.*;

public class Server  {

    public static void main (String args[]) {
        //create ChatEventManager which manages our session
        ChatEventManager manager = new ChatEventManager();

        try (ServerSocket serverSocket = new ServerSocket(8205)){

            System.out.println("Server waiting for clients...");

            while (true) { // listen to incoming connections indefinitely
                Socket incoming = serverSocket.accept();
                System.out.println("new client from " + incoming.getInetAddress() + ":" + incoming.getPort());
                ServerCommunicator communicator = new ServerCommunicator(incoming, manager); // hand over new client to slave
                communicator.start(); // and launch the slave
            }
        } catch ( Exception e) { System.err.println(e); }
    }
}
