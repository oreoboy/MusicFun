package creationAlgo;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

import outils.OutilsMidi;

public class Aleatoire implements Algo {
	private Track piste;
	
	public Sequence creerSequence() {
		Sequence sequence = null;
		
		try {
			sequence = new Sequence(Sequence.PPQ, 4);
			piste = sequence.createTrack();
			
			int r = 0;
			for (int i = 0; i < 100; i+= 4) {
				r = (int) ((Math.random() * 50) + 1);

				piste.add(OutilsMidi.makeEvent(144,1,r,100,i));
				piste.add(OutilsMidi.makeEvent(176,1,127,0,i));		
				piste.add(OutilsMidi.makeEvent(128,1,r,100,i + 2));
			}
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		
		return sequence;
	}
}
