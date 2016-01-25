import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by lukas on 1/25/16.
 */
public class ReceiverImpl implements Receiver {

    public ReceiverImpl() throws RemoteException {
    }

    @Override
    public void receive(String message) throws RemoteException {
        System.out.println(message);
    }

    public static void main(String args[]) {
        try {
            ReceiverImpl rec = new ReceiverImpl();
            Receiver stub = (Receiver) UnicastRemoteObject.exportObject(rec, 0);
            Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            registry.rebind("Receiver", stub);
            System.out.println("Rec bound");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
