package fr.diginamic.services;

import java.util.ArrayList;
import java.util.Scanner;

import fr.diginamic.exception.AjouterQuestionException;
import fr.diginamic.exception.ExecuterQuizzException;
import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionDao;
import fr.diginamic.model.QuestionMemDao;
import fr.diginamic.model.TypeQuestion;

public class ExecuterQuizzService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, QuestionDao questionDao) throws ExecuterQuizzException{
		System.out.println("Exécution du quizz :\n");
		
		ArrayList<Question> listeQuestions = questionDao.findAll();
		
		if(listeQuestions.isEmpty()) {
			System.out.println("Il n'y a pas de quizz");
		}else {
			int index = 0;
			int score = 0;
			for(Question question : listeQuestions) {
				index++;
				System.out.println(index+") "+question.toString()+"\nRéponse : ");
				int rep;
				try {
					rep = Integer.parseInt(scanner.nextLine());
				}catch(Exception e) {
					throw new ExecuterQuizzException("Il faut saisir un nombre\n");
				}
				if(rep < 1 || rep > question.getNbPropositions()) throw new ExecuterQuizzException("Cette proposition n'est pas dans la liste\n");
				if(question.verifierReponse(rep)){
					System.out.println("Bonne réponse !\n");
					if(question.getType() == TypeQuestion.SIMPLE)
						score++;
					else
						score += 2;
						
				}else {
					System.out.println("Mauvaise réponse... La bonne réponse était : "+question.getPropositions().get(question.getBonneReponse()-1)+"\n");
				}				
			}
			System.out.println("Score final : "+score+"/"+((QuestionMemDao) questionDao).getMaxPoint()+"\n");
		}
	}

}
