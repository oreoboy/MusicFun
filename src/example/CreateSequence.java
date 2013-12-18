package example;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.JOptionPane;

import factories.AlgoFactory;
import CreationAlgo.Aleatoire;
import CreationAlgo.Algo;

@SuppressWarnings("unused")
public class CreateSequence extends Lecteur {
	
	private Algo algo;
	
	public static void main(String[] args) throws Exception {
		CreateSequence creeSeq = new CreateSequence();
		
		Object[] possibleValues = { "Aleatoire", "Arpege"};
		Object selectedValue = JOptionPane.showInputDialog(null, "Choose one", "Input",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[0]);
		
		Algo algo = new AlgoFactory().getAlgo(selectedValue.toString());
		
		creeSeq.setAlgo(algo);
		
		creeSeq.start();
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

	public Algo getAlgo() {
		return algo;
	}

	public void setAlgo(Algo algo) {
		this.algo = algo;
	}
	
	
}
