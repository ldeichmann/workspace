import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by lukas on 1/25/16.
 */
public interface Receiver extends Remote {
    public void receive(String message) throws RemoteException;
}
