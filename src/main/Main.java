package main;

import java.util.Scanner;

import lecteur.Lecteur;
import lecteur.LecteurDecore;
import factories.LecteurFactory;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//Création du scanner
		String str = "";
		Scanner sc = new Scanner(System.in);
		
		try {
			//Lancement du lecteur
			Lecteur lecteur = new LecteurDecore(new LecteurFactory().getLecteur());
			lecteur.start();
			
			//Arret du lecteur
			while(!str.equals("0")) {
				System.out.println("Tapez 0 pour arreter");
				str = sc.nextLine();
				
				if(str.equals("0")) {
					lecteur.stop();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fin de la chanson");
	}
}
