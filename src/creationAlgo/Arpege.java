package creationAlgo;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

import outils.BoiteAOutils;

public class Arpege implements Algo {	
	public Sequence creerSequence() {
		Sequence sequence = null;
		
		try {
			//Création de la séquence
			sequence = new Sequence(Sequence.PPQ, 4);
			Track piste = sequence.createTrack();

			//Ajout de pistes de plus en plus aigues
			for (int i = 0; i < 100; i+= 4) {
				piste.add(BoiteAOutils.makeEvent(144,1,i,100,i));
				piste.add(BoiteAOutils.makeEvent(176,1,127,0,i));		
				piste.add(BoiteAOutils.makeEvent(128,1,i,100,i + 2));
			}
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		
		return sequence;
	}
}
