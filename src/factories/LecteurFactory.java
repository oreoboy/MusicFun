package factories;

import lecteur.CreateSequence;
import lecteur.Lecteur;
import lecteur.ReadSequence;

public class LecteurFactory {
	public Lecteur getLecteur(String typeLecteur) throws Exception {
		Lecteur lecteur = null;
		if ("Creation".equals(typeLecteur)) {
			lecteur = new CreateSequence();
		} else if ("Lecture".equals(typeLecteur)) {
			lecteur = new ReadSequence();
		} else {
			throw new Exception("Impossible de créer un " + typeLecteur);
		}
		return lecteur;
	}
}
