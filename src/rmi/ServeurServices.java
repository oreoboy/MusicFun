package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServeurServices extends Remote {
    public Object[] getListeServices() throws RemoteException;
    public Service getService(Object cleService) throws RemoteException;
}
