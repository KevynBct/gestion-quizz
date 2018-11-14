package fr.diginamic.console;

import java.util.Scanner;

public class QuizzAdminConsoleApp {

	public static void main(String[] args) {
		
		afficheMenu();

	}
	
	public static void afficheMenu() {
		System.out.println("***** Quizz Administration *****\n" + 
				"1. Lister les questions\n" + 
				"2. Ajouter une nouvelle question\n" + 
				"3. Supprimer une question\n" + 
				"4. Exécuter le quizz\n" + 
				"99. Sortir");
		
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		
		switch (choice) {
			case 1 : {
				System.out.println("Liste des questions :\n");
				afficheMenu();
				break;
			}
			case 2 : {
				System.out.println("Ajout d’une nouvelle question :\n");
				afficheMenu();
				break;
			}
			case 3 : {
				System.out.println("Suppression d’une question :\n");
				afficheMenu();
				break;
			}
			case 4 : {
				System.out.println("Exécution du quizz :\n");
				afficheMenu();
				break;
			}
			case 99 : {
				System.out.println("Aurevoir");
				break;
			}
		}
		
	}

}
