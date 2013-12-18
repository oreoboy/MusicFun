package lecteur;

import javax.sound.midi.Sequence;
import javax.swing.JOptionPane;

import creationAlgo.Algo;
import factories.AlgoFactory;

public class LecteurCreation extends Lecteur {
	private Algo algo = null;
	
	@Override
	protected Sequence getSequence() {
		try {
			Object[] possibleValues = { "Aleatoire", "Arpege"};
			Object selectedValue = JOptionPane.showInputDialog(null, "Choose one", "Input",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[0]);
			
			Algo algo;
			algo = new AlgoFactory().getAlgo(selectedValue.toString());
			
			this.setAlgo(algo);
			
			sequence = this.getAlgo().creerAlgo();
			
			sequenceur.setSequence(sequence);
			sequenceur.setTempoInBPM(200);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sequence;
	}
	
	public Algo getAlgo() {
		return algo;
	}

	public void setAlgo(Algo algo) {
		this.algo = algo;
	}
}
