package fr.diginamic.services;

import java.util.Scanner;

import fr.diginamic.exception.AjouterQuestionException;
import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionDao;
import fr.diginamic.model.TypeQuestion;

public class AjouterQuestionService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, QuestionDao questionDao) throws AjouterQuestionException {
		System.out.println("Ajout d’une nouvelle question :\n");
		
		System.out.println("Veuillez saisir l’intitulé de la question :\n");
		String intitule = scanner.nextLine();

		System.out.println("Veuillez saisir le nombre de propositions : (exemple : 3)\n");
		int nbReponse;
		try {
			nbReponse = Integer.parseInt(scanner.nextLine());
		}catch(Exception e) {
			throw new AjouterQuestionException("Il faut saisir un nombre\n");
		}
		if(nbReponse < 2) throw new AjouterQuestionException("Il faut au moins 2 propositions !\n");

		Question question = new Question(intitule, nbReponse);

		for(int i = 1 ; i <= nbReponse; i++) {
			System.out.println("Veuillez saisir la proposition de réponse n°"+i+" :");
			question.addProposition(scanner.nextLine());
		}

		System.out.println("Veuillez saisir le numéro de la bonne réponse (entre 1 et "+nbReponse+") :\n");
		int rep;
		try{
			rep = Integer.parseInt(scanner.nextLine());
		}catch(Exception e) {
			throw new AjouterQuestionException("Il faut saisir un nombre\n");
		}
		if(rep > nbReponse || rep < 1) throw new AjouterQuestionException("La réponse doit être comprise entre 1 et "+nbReponse+" !\n");
		question.setBonneReponse(rep);
		
		System.out.println("Est-ce que c'est une question compte double ?\n\t1 - Oui\n\t2 - Non\n");
		int type;
		try{
			type = Integer.parseInt(scanner.nextLine());
		}catch(Exception e) {
			throw new AjouterQuestionException("Il faut saisir un nombre\n");
		}
		if(type > 2 || type < 1) throw new AjouterQuestionException("La réponse doit être comprise entre 1 et 2 !\n");
		if(type == 1)
			question.setType(TypeQuestion.DOUBLE);
		else 
			question.setType(TypeQuestion.SIMPLE);

		questionDao.save(question);
		System.out.println("La question est ajoutée\n");
		
	}

}
