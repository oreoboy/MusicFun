package rmi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Navigateur {
	JPanel panneau;
	JComboBox listeServices;
	ServeurServices serveur;
	
	public void construireIHM() {
		JFrame cadre = new JFrame("Navigateur RMI");
		panneau = new JPanel();
		cadre.getContentPane().add(BorderLayout.CENTER, panneau);

		Object[] services = getListeServices();

		listeServices = new JComboBox(services);
		cadre.getContentPane().add(BorderLayout.NORTH, listeServices);

		listeServices.addActionListener(new EcouteMaListe());

		cadre.setSize(500,500);
		cadre.setVisible(true);

	}
	
	void chargerService(Object serviceChoisi) {
		try {
			Service svc = serveur.getService(serviceChoisi);

			panneau.removeAll();
			panneau.add(svc.getIHM());
			panneau.validate();
			panneau.repaint();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/*
	 * Le client doit accéder à l'objet souche, 
	 * puisque c'est sur cette entité qu'il va appeler les méthodes.
	 * 
	 * le client consulte le registre RMI : Naming.lookup("rmi://127.0.0.1/ServeurServices");
	 * "ServeurServices" est le nom sous lequel le service a été enregistré
	 * 
	 * le registre RMI retourne l'objet souche comme valeur de retour de la méthode lookup()
	 * et RMI le désérialise automatiquement. la classe de la souche (générée) doit être sur le client.
	 * 
	 * le client invoque une méthode sur la souche comme si elle était le service réel :
	 * "serveur.getListeServices()"
	 */
	Object[] getListeServices() {

		Object obj = null;
		Object[] services = null;
		
		try {
			//obj = Naming.lookup("rmi://127.0.0.1/ServeurServices");
			obj = Naming.lookup("ServeurServices");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		serveur = (ServeurServices) obj;

		try {
			services = serveur.getListeServices();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return services;
	}

	class EcouteMaListe implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			// accéder au service sélectionné
			Object selection =  listeServices.getSelectedItem();
			chargerService(selection);
		}
	}

	public static void main(String[] args) {
		new Navigateur().construireIHM();
	}
}
