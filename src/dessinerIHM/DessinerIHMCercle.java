package dessinerIHM;

import java.awt.Color;
import java.awt.Graphics;

public class DessinerIHMCercle implements DessinerIHM {

	@Override
	public void dessinerIHM(Graphics g) {
		int r = (int) (Math.random() * 250);
		int gr = (int) (Math.random() * 250);
		int b = (int) (Math.random() * 250);
	
		g.setColor(new Color(r,gr,b));
	
		int ht = (int) ((Math.random() * 120) + 10);
		int width = (int) ((Math.random() * 120) + 10);
	
		int x = (int) ((Math.random() * 40) + 10);
		int y = (int) ((Math.random() * 40) + 10);
	
		g.fillOval(x, y, ht, width);
	}

}
