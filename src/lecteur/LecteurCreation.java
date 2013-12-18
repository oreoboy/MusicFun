package lecteur;

import javax.sound.midi.Sequence;

import creationAlgo.Algo;
import factories.AlgoFactory;

public class LecteurCreation extends Lecteur {
	@Override
	protected Sequence getSequence() {
		Algo algo = null;
		try {
			algo = new AlgoFactory().getAlgo();
			sequenceur.setTempoInBPM(200);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return algo.creerSequence();
	}
}
