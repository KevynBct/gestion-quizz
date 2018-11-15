package fr.diginamic.console;

import java.util.ArrayList;
import java.util.Scanner;

import fr.diginamic.model.*;
import fr.diginamic.services.*;

public class QuizzAdminConsoleApp {
	private static QuestionMemDao questionMemDao;

	public static void main(String[] args) {

		questionMemDao = new QuestionMemDao();

		afficheMenu();

	}
	
	private static void afficheMenu() {
		
		System.out.println("***** Quizz Administration *****\n" + 
				"1. Lister les questions\n" + 
				"2. Ajouter une nouvelle question\n" + 
				"3. Supprimer une question\n" + 
				"4. Exécuter le quizz\n" + 
				"99. Sortir");
		
		Scanner scanner = new Scanner(System.in);
		int choice = Integer.parseInt(scanner.nextLine());
		
		switch (choice) {
			case 1 : {
				new ListerQuestionsService().executeUC(scanner, questionMemDao);
				afficheMenu();
				break;
			}
			case 2 : {
				new AjouterQuestionService().executeUC(scanner, questionMemDao);
				afficheMenu();
				break;
			}
			case 3 : {
				new SupprimerQuestionService().executeUC(scanner, questionMemDao);
				afficheMenu();
				break;
			}
			case 4 : {
				new ExecuterQuizzService().executeUC(scanner, questionMemDao);
				afficheMenu();
				break;
			}
			case 99 : {
				System.out.println("Au revoir");
				break;
			}
			default : {
				System.out.println("Veuillez choisir une proposition\n");
				afficheMenu();
				break;
			}
		}	
	}
}
