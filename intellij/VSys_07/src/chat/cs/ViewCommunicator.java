package chat.cs;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import chat.ChatEvent;
import chat.IView;
import chat.cs.sockets.Message;

/**
 * Client side ServerSocket for Events
 */
public class ViewCommunicator implements Runnable {

    public ServerSocket serverSocket;
    private IView view;

    public ViewCommunicator(IChat server, IView view) {

        this.view = view;

    }

    public void run() {

        try {
            serverSocket = new ServerSocket(0);
            Socket incoming = serverSocket.accept();
            ObjectOutputStream out = new ObjectOutputStream(incoming.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(incoming.getInputStream());
            while (true) {

                ChatEvent msg = (ChatEvent) in.readObject();
                view.update(msg);
                out.writeObject(new Message(Message.CONFIRM));


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
