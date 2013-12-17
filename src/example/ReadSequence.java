package example;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;

public class ReadSequence extends Lecteur {

	@Override
	public void getSequence() {
		try {
			File chanson = new File("Chanson.mid");
			sequenceur.setSequence(MidiSystem.getSequence(chanson));
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
