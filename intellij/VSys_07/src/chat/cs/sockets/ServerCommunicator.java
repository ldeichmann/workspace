package chat.cs.sockets;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import chat.ChatEvent;
import chat.cs.ChatEventManager;

/**
 * Slave for managing connections received by Server
 */
public class ServerCommunicator extends Thread {
    private ChatEventManager manager;
    private Socket socket;

    public ServerCommunicator(Socket socket, ChatEventManager manager) {
        this.socket = socket;
        this.manager = manager;
    }

    public void run() {
        boolean finished = false;
        try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {
            while (!finished) { // don't exit unless we send logout
                Message msg = (Message) in.readObject();
                switch (msg.getMessageType()) {
                    case Message.LOGIN:
                        manager.login(msg.getName(), msg.getProxy());
                        out.writeObject(new Message(Message.CONFIRM));
                        break;
                    case Message.COMMENT:
                        manager.comment(msg.getName(), msg.getComment());
                        out.writeObject(new Message(Message.CONFIRM));
                        break;
                    case Message.LOGOUT:
                        manager.logout(msg.getName());
                        finished = true;
                        out.writeObject(new Message(Message.CONFIRM));
                        break;
                    case Message.POLLING:
                        ChatEvent evt = manager.poll(msg.getName());
                        out.writeObject(evt);
                        out.reset();
                        break;
                }
            }
            out.flush();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
