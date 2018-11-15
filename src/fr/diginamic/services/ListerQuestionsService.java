package fr.diginamic.services;

import java.util.ArrayList;
import java.util.Scanner;

import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionDao;

public class ListerQuestionsService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, QuestionDao questionDao) {
		System.out.println("Liste des questions :\n");
		ArrayList<Question> listeQuestions = questionDao.findAll();
		if(listeQuestions.isEmpty()) {
			System.out.println("Il n'y a pas de question");
		}else {
			int index = 0;
			for(Question question : listeQuestions) {
				index++;
				System.out.println(index+") "+question.toString());
			}
		}
	}

}
