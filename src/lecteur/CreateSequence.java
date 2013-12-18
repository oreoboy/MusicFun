package lecteur;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.JOptionPane;

import creationAlgo.Aleatoire;
import creationAlgo.Algo;
import factories.AlgoFactory;

@SuppressWarnings("unused")
public class CreateSequence extends Lecteur {
	private Algo algo;
	
	@Override
	public void lancer() {
		try {
			CreateSequence creeSeq = new CreateSequence();
			
			Object[] possibleValues = { "Aleatoire", "Arpege"};
			Object selectedValue = JOptionPane.showInputDialog(null, "Choose one", "Input",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[0]);
			
			Algo algo;
			algo = new AlgoFactory().getAlgo(selectedValue.toString());
			
			creeSeq.setAlgo(algo);
			
			creeSeq.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void getSequence() {
		try {
			sequence = this.getAlgo().creerAlgo();
			sequenceur.setSequence(sequence);
			sequenceur.setTempoInBPM(120);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
