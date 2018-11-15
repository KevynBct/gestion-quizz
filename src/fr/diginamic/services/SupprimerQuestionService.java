package fr.diginamic.services;

import java.util.ArrayList;
import java.util.Scanner;

import fr.diginamic.exception.AjouterQuestionException;
import fr.diginamic.exception.SupprimerQuestionException;
import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionDao;

public class SupprimerQuestionService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, QuestionDao questionDao) throws SupprimerQuestionException {
		System.out.println("Suppression d’une question :\n");
		
		ArrayList<Question> listeQuestions = questionDao.findAll();
		
		System.out.println("Veuillez choisir le numéro de la question à supprimer.");

		int rep;
		try{
			rep = Integer.parseInt(scanner.nextLine());
		}catch(Exception e) {
			throw new SupprimerQuestionException("Il faut saisir un nombre\n");
		}
		if(rep > listeQuestions.size() || rep < 1) throw new SupprimerQuestionException("Il n'y a pas de question "+rep+"\n");

		questionDao.delete(listeQuestions.get(rep-1));
		System.out.println("La question a bien été supprimée.\n");		
	}

}
