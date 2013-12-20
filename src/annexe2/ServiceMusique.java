package annexe2;
/**
 * @author Kathy Sierra, Bert Bates : "Java Tête la Première" 
 */
import javax.sound.midi.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ServiceMusique implements Service {


    MonPanneauDessin monPanneau;


    public JPanel getIHM() {

       JPanel panneau = new JPanel();
       monPanneau = new MonPanneauDessin();
       JButton boutonJouer = new JButton("Jouer");
       boutonJouer.addActionListener(new EcouteJouer());
       panneau.add(monPanneau);
       panneau.add(boutonJouer);
       return panneau;
    }

    public class EcouteJouer implements ActionListener {
      public void actionPerformed(ActionEvent ev) {

        try {


	// créer (et ouvrir) un séquenceur, créer une séquence et une piste

         Sequencer sequenceur = MidiSystem.getSequencer();
         sequenceur.open();

         sequenceur.addControllerEventListener(monPanneau, new int[] {127});
         Sequence seq = new Sequence(Sequence.PPQ, 4);
         Track piste = seq.createTrack();

    // créer deux événements midi (contenant un message midi)


        for (int i = 0; i < 100; i+= 4) {

            int  rNum = (int) ((Math.random() * 50) + 1);
            if (rNum < 38) {  // ne faire que si num <38 (75% du temps)

              piste.add(makeEvent(144,1,rNum,100,i));

              piste.add(makeEvent(176,1,127,0,i));

              piste.add(makeEvent(128,1,rNum,100,i + 2));
            }
         } // fin de la boucle

			// ajouter les événements à la piste
			// ajouter la séquence au séquenceur, fixer le timing et démarrer

         sequenceur.setSequence(seq);

         sequenceur.start();
         sequenceur.setTempoInBPM(220);
      } catch (Exception ex) {ex.printStackTrace();}

    } // fin de actionPerformed()
   } // fin de la classe interne


public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
      MidiEvent evenement = null;
         try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            evenement = new MidiEvent(a, tick);

          }catch(Exception e) { }
      return evenement;
      }


 class MonPanneauDessin extends JPanel implements ControllerEventListener {

      // nous ne dessinons que si nous avons un evenement
      boolean msg = false;

      public void controlChange(ShortMessage evenement) {
         msg = true;
         repaint();
     }

      public Dimension getPreferredSize() {
        return new Dimension(300,300);
      }

      public void paintComponent(Graphics g) {
         if (msg) {

           Graphics2D g2 = (Graphics2D) g;

           int r = (int) (Math.random() * 250);
           int gr = (int) (Math.random() * 250);
           int b = (int) (Math.random() * 250);

           g.setColor(new Color(r,gr,b));

           int ht = (int) ((Math.random() * 120) + 10);
           int lg = (int) ((Math.random() * 120) + 10);

           int x = (int) ((Math.random() * 40) + 10);
           int y =  (int) ((Math.random() * 40) + 10);

           g.fillRect(x,y,ht, lg);
           msg = false;

       } // fin du if
     } // fin de la méthode
   }  // fin de la classe interne

} // fin de la classe
