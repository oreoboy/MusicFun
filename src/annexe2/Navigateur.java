package annexe2;
/**
 * @author Kathy Sierra, Bert Bates : "Java T�te la Premi�re"  * 
 * Mise en forme des commentaires Fran�oise PERRIN
 */

import java.awt.*;
import javax.swing.*;
import java.rmi.*;

import java.awt.event.*;


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
	 * Le client doit acc�der � l'objet souche, 
	 * puisque c'est sur cette entit� qu'il va appeler les m�thodes.
	 * 
	 * le client consulte le registre RMI : Naming.lookup("rmi://127.0.0.1/ServeurServices");
	 * "ServeurServices" est le nom sous lequel le service a �t� enregistr�
	 * 
	 * le registre RMI retourne l'objet souche comme valeur de retour de la m�thode lookup()
	 * et RMI le d�s�rialise automatiquement. la classe de la souche (g�n�r�e) doit �tre sur le client.
	 * 
	 * le client invoque une m�thode sur la souche comme si elle �tait le service r�el :
	 * "serveur.getListeServices()"
	 */
	Object[] getListeServices() {

		Object obj = null;
		Object[] services = null;
		
		try {
			
			obj = Naming.lookup("rmi://127.0.0.1/ServeurServices");
//			obj = Naming.lookup("ServeurServices");
			
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

			// acc�der au service s�lectionn�

			Object selection =  listeServices.getSelectedItem();
			chargerService(selection);
		}
	}

	public static void main(String[] args) {
		new Navigateur().construireIHM();
	}
}


