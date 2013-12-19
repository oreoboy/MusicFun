package rmi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controler.Controller;

@SuppressWarnings("serial")
public class ServiceLecteur implements Service {
	JPanel monPanneau;
	
	@Override
	public void lancerService() {
		Controller controller = new Controller();
		controller.start();
	}
	
	public JPanel getIHM() {

	       JPanel panneau = new JPanel();
	       monPanneau = new JPanel();
	       JButton boutonJouer = new JButton("Jouer");
	       boutonJouer.addActionListener(new EcouteJouer());
	       panneau.add(monPanneau);
	       panneau.add(boutonJouer);
	       return panneau;
    }
	
	public class EcouteJouer implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			ServiceLecteur serv = new ServiceLecteur();
			serv.lancerService();
		} // fin de actionPerformed()
	} // fin de la classe interne
}
