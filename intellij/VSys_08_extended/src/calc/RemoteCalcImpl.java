package calc;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by lukas on 1/25/16.
 */
public class RemoteCalcImpl implements  RemoteCalc {

    public RemoteCalcImpl() throws RemoteException {

    }

    @Override
    public String add(float af, float bf) throws RemoteException {
        return String.valueOf(af + bf);
    }

    @Override
    public String sub(float af, float bf) throws RemoteException {
        return String.valueOf(af - bf);
    }

    @Override
    public String multi(float af, float bf) throws RemoteException {
        return String.valueOf(af * bf);
    }

    @Override
    public String div(float af, float bf) throws RemoteException {
        return String.valueOf(af / bf);
    }

    public static void main(String args[]) {
        try {
            RemoteCalc rec = new RemoteCalcImpl();
            RemoteCalc stub = (RemoteCalc) UnicastRemoteObject.exportObject(rec, 0);
            Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            registry.rebind("Calculator", stub);
            System.out.println("Calculator bound");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
