package example;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ReadSequence extends Lecteur {
	private File path = null;
	
	public static void main(String[] args) {
		/*
		 * Main pour le lecteur Reader
		 */
        Lecteur readSeq = new ReadSequence();
        readSeq.start();
	}
	
	@Override
	public void getSequence() {
		try {
			//Récupération du fichier grâce à un JFileChooser
			JFileChooser fileChooser = new JFileChooser();
			
			//Ajout d'un filtre pour les fichiers midi
			FileFilter filter = new FileNameExtensionFilter("Fichier MIDI", "mid");
			fileChooser.addChoosableFileFilter(filter);
			fileChooser.setFileFilter(filter);
			fileChooser.setApproveButtonText("Choisir");
			
			//Récupération du fichier
			int returnVal = fileChooser.showDialog(ml, null);
	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	        	path = fileChooser.getSelectedFile();
	        }
	        
	        //Récupération de la musique
			if(path != null) {
				sequenceur.setSequence(MidiSystem.getSequence(path));
			}
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
