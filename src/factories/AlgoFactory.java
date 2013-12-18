package factories;

import javax.swing.JOptionPane;

import creationAlgo.Aleatoire;
import creationAlgo.Algo;
import creationAlgo.Arpege;

public class AlgoFactory {

	public Algo getAlgo() throws Exception {
		Algo algo = null;
		
		Object[] possibleValues = {"Aleatoire", "Arpege"};
		Object typeAlgo = JOptionPane.showInputDialog(null, "Choose one", "Input",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[0]);
		
		if ("Aleatoire".equals(typeAlgo.toString())) {
			algo = new Aleatoire();
		} else if ("Arpege".equals(typeAlgo.toString())) {
			algo = new Arpege();
		} else {
			throw new Exception("Impossible de créer un " + typeAlgo.toString());
		}
		return algo;
	}

}
