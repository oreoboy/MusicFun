package lecteur;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LecteurFichier extends Lecteur {
	private File path = null;
	
	@Override
	protected Sequence getSequence() {
		Sequence sequence = null;
		try {
			//Récupération du fichier gr�ce � un JFileChooser
			JFileChooser fileChooser = new JFileChooser();
			
			//Ajout d'un filtre pour les fichiers midi
			FileFilter filter = new FileNameExtensionFilter("Fichier MIDI", "mid");
			fileChooser.addChoosableFileFilter(filter);
			fileChooser.setFileFilter(filter);
			fileChooser.setApproveButtonText("Choisir");

			//Récupération du fichier
			JPanel pan = new JPanel();
			int returnVal = fileChooser.showDialog(pan, null);
	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	        	path = fileChooser.getSelectedFile();
	        }
	        
	        //Récupération de la musique
			if(path != null) {
				sequence = (MidiSystem.getSequence(path));
			}
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sequence;
	}

	
}
