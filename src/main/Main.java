package main;

import javax.swing.JOptionPane;

import lecteur.Lecteur;
import factories.LecteurFactory;

public class Main {

	public static void main(String[] args) {
		Object[] possibleValues = {"Creation", "Lecture"};
		Object selectedValue = JOptionPane.showInputDialog(null, "Choose one", "Input",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[0]);
		
		try {
			Lecteur lecteur = new LecteurFactory().getLecteur(selectedValue.toString());
			lecteur.lancer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
