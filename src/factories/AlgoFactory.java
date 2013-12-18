package factories;

import creationAlgo.Aleatoire;
import creationAlgo.Algo;
import creationAlgo.Arpege;

public class AlgoFactory {

	public Algo getAlgo(String typeAlgo) throws Exception {
		Algo algo;
		if ("Aleatoire".equals(typeAlgo)) {
			algo = new Aleatoire();
		} else if ("Arpege".equals(typeAlgo)) {
			algo = new Arpege();
		} else {
			throw new Exception("Impossible de créer un " + typeAlgo);
		}
		return algo;
	}

}
