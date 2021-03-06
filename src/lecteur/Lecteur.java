package lecteur;
/**
 * @author Kathy Sierra, Bert Bates : "Java T�te la Premi�re" 
 * Mise en forme des commentaires Fran�oise PERRIN
 */

/**
 * Le programme suivant affiche des formes dans un panneau 
 * au rythme d'une partition de musique qu'il a pr�alablement construite
 * 
 * Pour qu�un son sorte des haut-parleurs, il faut envoyer les donn�es MIDI � un �quipement MIDI,
 * qui lit les instructions et les transforme en son, 
 * en d�clenchant un instrument r�el ou un instrument � virtuel � (un programme synth�tiseur).
 * 
 * Il faut QUATRE composants :
 * 1 - Celui qui joue la musique et restitue r�ellement le son : le s�quenceur (le voir comme un lecteur de CD)
 * 2 - la musique � jouer : la s�quence est le morceau jou� par le s�quenceur (la voir comme 1 CD)
 * 3 - La partie de la s�quence qui contient les vraies informations : une piste (la voir comme 1 morceau du CD)
 * 4 - Les vraies informations contenues dans une piste sont des �v�nements MIDI : quelles notes jouer, combien de temps, etc.
 * Un �v�nement MIDI est un message compr�hensible par le s�quenceur. Il pourrait dire (s�il parlait) : 
 * � Maintenant joue un do, joue-le � cette vitesse et tiens la note pendant tant de temps �.
 * Un �v�nement MIDI pourrait �galement dire par exemple : � Change l�instrument courant en fl�te �.
 */

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

// Ce programme joue une musique al�atoire,et affiche des rectangles pleins, en rythme.
public abstract class Lecteur {
	protected Sequencer sequenceur = null;
	protected Sequence sequence = null;
	
	// Template/Factory Method
	public void start() {
		try {
			/*
			 * On défine la "recette" à suivre ici
			 * 1/ On crée un séquenceur qu'on ouvre
			 * 2/ On récupère une séquence pour le séquenceur 
			 * 3/ On lance le séquenceur
			 */
			this.sequenceur = MidiSystem.getSequencer();
			this.sequenceur.open();
			
			sequence = getSequence();  // Définie ds classes dérivées
			sequenceur.setSequence(sequence);
			
			this.sequenceur.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void stop() {
		this.sequenceur.stop();
	}
	
	protected abstract Sequence getSequence();
	
	protected void setSequence(Sequence sequence) {
		this.sequence=sequence;		
	}

	public Sequencer getSequenceur() {
		return sequenceur;
	}

	public void setSequenceur(Sequencer sequenceur) {
		this.sequenceur = sequenceur;
	}
} 

