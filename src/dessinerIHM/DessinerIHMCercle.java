package dessinerIHM;

import java.awt.Graphics;
import java.util.Map;

import outils.BoiteAOutilsVue;

public class DessinerIHMCercle implements DessinerIHM {

	@Override
	public void dessinerIHM(Graphics g) {
		Map<String, Integer> map = BoiteAOutilsVue.genererForme(g);
		g.fillOval(map.get("x"), map.get("y"), map.get("ht"), map.get("width"));
	}
}
