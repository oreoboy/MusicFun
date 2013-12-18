package factories;

import java.util.HashMap;
import java.util.Map;

import creationAlgo.Algo;

public class AlgoFactory {
	
	private static Map<String, String> mapAlgo = new HashMap<String, String>();
	
	static {
		mapAlgo.put("Aléatoire", "Aleatoire");
		mapAlgo.put("Arpege", "Arpege");
	}

	public Algo getAlgo(String typeAlgo) throws Exception {
		Algo algo;
//		if ("Aleatoire".equals(typeAlgo)) {
//			algo = new Aleatoire();
//		} else if ("Arpege".equals(typeAlgo)) {
//			algo = new Arpege();
//		} else {
//			throw new Exception("Impossible de créer un " + typeAlgo);
//		}
		
		algo = (Algo) Class.forName(mapAlgo.get(typeAlgo)).newInstance();
		
		
		
		return algo;
	}

}
