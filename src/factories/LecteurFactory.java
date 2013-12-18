package factories;

import javax.swing.JOptionPane;

import lecteur.LecteurCreation;
import lecteur.Lecteur;
import lecteur.LecteurFichier;

public class LecteurFactory {
	public Lecteur getLecteur() throws Exception {
		//Creation de la fenetre de choix
		Object[] possibleValues = {"Creation", "Lecture"};
		Object typeLecteur = JOptionPane.showInputDialog(null, "Choose one", "Input",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[0]);
		
		Lecteur lecteur = null;
		if ("Creation".equals(typeLecteur.toString())) {
			lecteur = new LecteurCreation();
		} else if ("Lecture".equals(typeLecteur.toString())) {
			lecteur = new LecteurFichier();
		} else {
			throw new Exception("Impossible de créer un " + typeLecteur.toString());
		}
		return lecteur;
	}
}
