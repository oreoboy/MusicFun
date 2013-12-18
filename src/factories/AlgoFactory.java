package factories;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import creationAlgo.Aleatoire;
import creationAlgo.Algo;
import creationAlgo.Arpege;

public class AlgoFactory {
	//Définition d'une map des différents type d'algo
	private static Map<String, Algo> mapAlgo = new HashMap<String, Algo>();

	static {
		mapAlgo.put("Aléatoire", new Aleatoire());
		mapAlgo.put("Arpege", new Arpege());
	}

	public Algo getAlgo() throws Exception {
		//Fenetre de choix de l'algo
		Object[] possibleValues = { "Aléatoire", "Arpege" };
		Object typeAlgo = JOptionPane.showInputDialog(null, "Choose one", "Input", JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);

		//Création de l'algo
		Algo algo;
		algo = mapAlgo.get(typeAlgo);

		return algo;
	}

}
