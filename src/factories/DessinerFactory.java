package factories;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import dessinerIHM.DessinerIHM;
import dessinerIHM.DessinerIHMCercle;
import dessinerIHM.DessinerIHMRectangle;

public class DessinerFactory {
	//Définition d'une map des différents type de lecteurs
	private static Map<String, DessinerIHM> mapDessin = new HashMap<String, DessinerIHM>();

	static {
		mapDessin.put("Rectangle", new DessinerIHMRectangle());
		mapDessin.put("Cercle", new DessinerIHMCercle());
	}
	
	public DessinerIHM getDessin() throws Exception {
		//Creation de la fenetre de choix
		Object[] possibleValues = {"Rectangle", "Cercle"};
		Object typeDessin = JOptionPane.showInputDialog(null, "Choose one", "Input",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[0]);
		
		//Création du lecteur et renvoie
		return mapDessin.get(typeDessin);
	}
}
