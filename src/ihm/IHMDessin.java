package ihm;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class IHMDessin extends JPanel {
	private boolean msg = false;
	
	public IHMDessin() {
		JFrame f = new JFrame("MusicFun");
		f.setContentPane(this);
		f.setBounds(30,30, 300,300);
		f.setVisible(true);
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

			g.fillRect(x, y, ht, width);
			msg = false;
		} 
	}

	public boolean isMsg() {
		return msg;
	}

	public void setMsg(boolean msg) {
		this.msg = msg;
	}
}
