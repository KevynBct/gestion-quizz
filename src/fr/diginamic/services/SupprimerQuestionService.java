package fr.diginamic.services;

import java.util.ArrayList;
import java.util.Scanner;

import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionDao;

public class SupprimerQuestionService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, QuestionDao questionDao) {
		System.out.println("Suppression d’une question :\n");
		
		ArrayList<Question> listeQuestions = questionDao.findAll();
		
		System.out.println("Veuillez choisir le numéro de la question à supprimer.");

		int rep = Integer.parseInt(scanner.nextLine());
		while(rep > listeQuestions.size() || rep < 1) {
			System.out.println("Il n'y a pas de question "+rep+"\nChoisissez en une autre");
			rep = Integer.parseInt(scanner.nextLine());
		}
		questionDao.delete(listeQuestions.get(rep-1));
		System.out.println("La question a bien été supprimée.\n");		
	}

}
