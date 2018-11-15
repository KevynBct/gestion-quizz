package fr.diginamic.services;

import java.util.Scanner;

import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionDao;

public class AjouterQuestionService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, QuestionDao questionDao) {
		System.out.println("Ajout d’une nouvelle question :\n");
		
		System.out.println("Veuillez saisir l’intitulé de la question :\n");
		String intitule = scanner.nextLine();

		System.out.println("Veuillez saisir le nombre de propositions : (exemple : 3)\n");
		int nbReponse = Integer.parseInt(scanner.nextLine());

		Question question = new Question(intitule, nbReponse);

		for(int i = 1 ; i <= nbReponse; i++) {
			System.out.println("Veuillez saisir la proposition de réponse n°"+i+" :");
			question.addProposition(scanner.nextLine());
		}

		System.out.println("Veuillez saisir le numéro de la bonne réponse (entre 1 et "+nbReponse+") :\n");
		int rep = Integer.parseInt(scanner.nextLine());
		while(rep > nbReponse || rep < 1) {
			System.out.println("Saisissez un numéro entre 1 et "+nbReponse+"\n");
			rep = Integer.parseInt(scanner.nextLine());
		}
		question.setBonneReponse(rep);

		questionDao.save(question);
		System.out.println("La question est ajoutée\n");
		
	}

}
