package outils;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

public class BoiteAOutilsVue {
	public static Map<String, Integer> genererForme(Graphics g) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int r = (int) (Math.random() * 250);
		int gr = (int) (Math.random() * 250);
		int b = (int) (Math.random() * 250);
	
		g.setColor(new Color(r,gr,b));
	
		int ht = (int) ((Math.random() * 120) + 10);
		int width = (int) ((Math.random() * 120) + 10);
	
		int x = (int) ((Math.random() * 240) + 10);
		int y = (int) ((Math.random() * 240) + 10);
		
		map.put("x", x);
		map.put("y", y);
		map.put("ht", ht);
		map.put("width", width);
		
		return map;
	}
}
