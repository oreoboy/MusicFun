package rmi;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.swing.JPanel;

public interface Service extends Serializable{
	public void lancerService() throws RemoteException;
	public JPanel getIHM() throws RemoteException;
}
