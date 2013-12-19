package lecteur;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.Sequence;


public class LecteurDecore extends Lecteur{
	private Lecteur lecteur;

	public LecteurDecore(Lecteur lecteur) {
		this.lecteur = lecteur;
	}
	
	public void start() {
		this.lecteur.start();
	}

	public void stop() {
		this.lecteur.stop();
	}
	
	public void addControllerEventListener(ControllerEventListener cont, int[] controllers) {
		this.lecteur.getSequenceur().addControllerEventListener(cont, controllers);
	}

	@Override
	protected Sequence getSequence() {
		return this.lecteur.getSequence();
	}
}
