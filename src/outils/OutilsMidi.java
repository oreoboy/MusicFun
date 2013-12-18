package outils;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class OutilsMidi {
	
	public static MidiEvent makeEvent(int comd, int can, int un, int deux, int tic) {
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
