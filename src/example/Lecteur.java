package example;
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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.swing.JFrame;
import javax.swing.JPanel;

// ce programme joue une musique al�atoire,et affiche des rectangles pleins, en rythme.
public abstract class Lecteur {
	static JFrame f = new JFrame("MusicFun");
	static MonPanneau ml;
	Sequencer sequenceur = null;
	Sequence sequence = null;
	
	public void start() {
		installerIHM();
		try {
			sequenceur = MidiSystem.getSequencer();
			sequenceur.open();
			
			getSequence();

			sequenceur.start();
			sequenceur.addControllerEventListener(ml, new int[] {127});
		} catch (Exception ex) {ex.printStackTrace();}
	} // fin de la m�thode go()

	public void stop() {
		sequenceur.stop();
	}
	
	public abstract void getSequence();

	public void installerIHM() {
		ml = new MonPanneau();
		f.setContentPane(ml);
		f.setBounds(30,30, 300,300);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			    stop();
			}
		});
		f.setVisible(true);
	}


	/* le panneau de dessin va �couter les ControllerEvents
	 * et donc doit impl�menter l'interface �couteur
	 */
	@SuppressWarnings("serial")
	class MonPanneau extends JPanel implements ControllerEventListener {

		// nous ne voulons d'images que si nous avons un �v�nement
		boolean msg = false;

		public void controlChange(ShortMessage evenement) {
			msg = true;
			repaint();
		}

		public void paintComponent(Graphics g) {
			if (msg) {

				int r = (int) (Math.random() * 250);
				int gr = (int) (Math.random() * 250);
				int b = (int) (Math.random() * 250);

				g.setColor(new Color(r,gr,b));

				int ht = (int) ((Math.random() * 120) + 10);
				int width = (int) ((Math.random() * 120) + 10);

				int x = (int) ((Math.random() * 40) + 10);
				int y = (int) ((Math.random() * 40) + 10);

				g.fillRect(x,y,ht, width);
				msg = false;
			} 
		} 
	}
} 

