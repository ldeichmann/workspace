package calc;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by lukas on 1/25/16.
 */

public interface RemoteCalc extends Remote {
    public String add(float af, float bf) throws RemoteException;
    public String sub(float af, float bf) throws RemoteException;
    public String multi(float af, float bf) throws RemoteException;
    public String div(float af, float bf) throws RemoteException;
}
