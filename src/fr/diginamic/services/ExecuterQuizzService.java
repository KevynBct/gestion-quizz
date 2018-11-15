package fr.diginamic.services;

import java.util.ArrayList;
import java.util.Scanner;

import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionDao;

public class ExecuterQuizzService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, QuestionDao questionDao) {
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
				if(question.verifierReponse(Integer.parseInt(scanner.nextLine()))){
					System.out.println("Bonne réponse !\n");
					score++;
				}else {
					System.out.println("Mauvaise réponse... La bonne réponse était : "+question.getPropositions().get(question.getBonneReponse()-1)+"\n");
				}				
			}
			System.out.println("Score final : "+score+"/"+listeQuestions.size()+"\n");
		}
	}

}
