package ihm;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dessinerIHM.DessinerIHM;
import factories.DessinerFactory;


@SuppressWarnings("serial")
public class IHMDessin extends JPanel {
	private boolean msg = false;
	private boolean firstTime = true;
	private DessinerIHM dessinerIHM = null;
	
	public IHMDessin() {
		try {
			setDessinerIHM(new DessinerFactory().getDessin());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JFrame f = new JFrame("MusicFun");
		f.setContentPane(this);
		f.setBounds(30,30, 300,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		this.repaint();
	}
	
	public void paintComponent(Graphics g) {
		if(firstTime) {
			super.paintComponent(g);
		}
		
		if (msg) {
			firstTime = false;
			getDessinerIHM().dessinerIHM(g);
			msg = false;
		}
	}

	public boolean isMsg() {
		return msg;
	}

	public void setMsg(boolean msg) {
		this.msg = msg;
	}

	public DessinerIHM getDessinerIHM() {
		return dessinerIHM;
	}

	public void setDessinerIHM(DessinerIHM dessinerIHM) {
		this.dessinerIHM = dessinerIHM;
	}
}
