package factories;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import lecteur.Lecteur;
import lecteur.LecteurCreation;
import lecteur.LecteurFichier;

public class LecteurFactory {
	//Définition d'une map des différents type de lecteurs
	private static Map<String, Lecteur> mapLecteur = new HashMap<String, Lecteur>();

	static {
		mapLecteur.put("Création", new LecteurCreation());
		mapLecteur.put("Lecture", new LecteurFichier());
	}
	
	public Lecteur getLecteur() throws Exception {
		//Creation de la fenetre de choix
		Object[] possibleValues = {"Création", "Lecture"};
		Object typeLecteur = JOptionPane.showInputDialog(null, "Choose one", "Input",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[0]);
		
		//Création du lecteur et renvoie
		return mapLecteur.get(typeLecteur);
	}
}
