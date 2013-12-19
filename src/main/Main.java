package main;

import java.util.Scanner;

import controler.Controller;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//Création du scanner
		String str = "";
		Scanner sc = new Scanner(System.in);
		Controller controller = new Controller();
		
		try {
			controller.start();
			
			//Arret du lecteur
			while(!str.equals("0")) {
				System.out.println("Tapez 0 pour arreter");
				str = sc.nextLine();
				
				if(str.equals("0")) {
					controller.stop();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fin de la chanson");
	}
}
