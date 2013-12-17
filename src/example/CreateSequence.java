package example;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import CreationAlgo.Aleatoire;

@SuppressWarnings("unused")
public class CreateSequence extends Lecteur {

	@Override
	public void getSequence() {
		try {
			sequence = new Aleatoire().creerAlgo();
			sequenceur.setSequence(sequence);
			sequenceur.setTempoInBPM(120);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
