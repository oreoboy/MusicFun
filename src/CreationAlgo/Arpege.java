package CreationAlgo;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class Arpege implements Algo {
	private Track piste;
	
	public Sequence creerAlgo() {
		Sequence sequence = null;
		
		try {
			sequence = new Sequence(Sequence.PPQ, 4);
			piste = sequence.createTrack();
			
			int r = 0;
			for (int i = 0; i < 100; i+= 4) {
				r = (int) ((Math.random() * 50) + 1);

				piste.add(makeEvent(144,6,r,100,i));
				piste.add(makeEvent(176,6,127,0,i));		
				piste.add(makeEvent(128,6,r,100,i + 2));
			}
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		
		return sequence;
	}

	private MidiEvent makeEvent(int comd, int can, int un, int deux, int tic) {
		MidiEvent evenement = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, can, un, deux);
			evenement = new MidiEvent(a, tic);
		} catch(Exception e) {
			
		}
		
		return evenement;
	}
}
