package rmi;

import java.io.Serializable;

import javax.swing.JPanel;

public interface Service extends Serializable{
	public void lancerService();
	public JPanel getIHM();
}
