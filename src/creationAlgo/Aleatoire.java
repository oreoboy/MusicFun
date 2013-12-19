package creationAlgo;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

import outils.BoiteAOutilsMidi;

public class Aleatoire implements Algo {
	public Sequence creerSequence() {
		Sequence sequence = null;
		
		try {
			//Création de la séquence
			sequence = new Sequence(Sequence.PPQ, 4);
			Track piste = sequence.createTrack();
			
			//Ajout de différentes pistes aléatoire
			int r = 0;
			for (int i = 0; i < 100; i+= 4) {
				r = (int) ((Math.random() * 50) + 1);

				piste.add(BoiteAOutilsMidi.makeEvent(144,1,r,100,i));
				piste.add(BoiteAOutilsMidi.makeEvent(176,1,127,0,i));		
				piste.add(BoiteAOutilsMidi.makeEvent(128,1,r,100,i + 2));
			}
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		
		//Renvoie de la séquence
		return sequence;
	}
}
