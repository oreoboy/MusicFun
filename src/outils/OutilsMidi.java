package outils;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

//Cette classe contient les méthodes qui sont utilisées dans d'autres classes pour éviter la redondance de code
public class OutilsMidi {
	//Sert à créer les différentes pistes
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
