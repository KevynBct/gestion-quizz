package fr.diginamic.console;

import java.util.ArrayList;
import java.util.Scanner;

import fr.diginamic.model.Question;

public class QuizzAdminConsoleApp {
	public static ArrayList<Question> listeQuestions;

	public static void main(String[] args) {
		
		listeQuestions = new ArrayList<Question>();
		
		initQuizz();
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
		int choice = Integer.parseInt(scanner.nextLine());
		//scanner.close();
		
		switch (choice) {
			case 1 : {
				System.out.println("Liste des questions :\n");
				afficherQuestions();
				afficheMenu();
				break;
			}
			case 2 : {
				System.out.println("Ajout d’une nouvelle question :\n");
				ajouterQuestion();
				afficheMenu();
				break;
			}
			case 3 : {
				System.out.println("Suppression d’une question :\n");
				supprimerQuestion();
				afficheMenu();
				break;
			}
			case 4 : {
				System.out.println("Exécution du quizz :\n");
				executerQuizz();
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
	
	public static void afficherQuestions() {
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
	
	public static void ajouterQuestion() {
		Scanner scanner = new Scanner(System.in);
		
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
		
		listeQuestions.add(question);
		System.out.println("La question est ajoutée");
		
		
	}
	
	public static void supprimerQuestion() {
		System.out.println("Veuillez choisir le numéro de la question à supprimer.");
		
		Scanner scanner = new Scanner(System.in);
		int rep = Integer.parseInt(scanner.nextLine());
		while(rep > listeQuestions.size() || rep < 1) {
			System.out.println("Il n'y a pas de question "+rep+"\nChoisissez en une autre");
			rep = Integer.parseInt(scanner.nextLine());
		}
		listeQuestions.remove(rep-1);
	}
	
	public static void executerQuizz() {
		if(listeQuestions.isEmpty()) {
			System.out.println("Il n'y a pas de quizz");
		}else {
			int index = 0;
			int score = 0;
			Scanner scanner = new Scanner(System.in);
			for(Question question : listeQuestions) {
				index++;
				System.out.println(index+") "+question.toString()+"\nRéponse : ");
				if(question.verifierReponse(Integer.parseInt(scanner.nextLine()))){
					System.out.println("Bonne réponse");
					score++;
				}else {
					System.out.println("Mauvaise réponse, la bonne réponse était : "+question.getPropositions().get(question.getBonneReponse()-1));
				}				
			}
			System.out.println("Score final : "+score+"/"+listeQuestions.size());
		}
	}
	
	public static void initQuizz() {
		Question q1 = new Question("Capitale de la France", 4);
		q1.addProposition("Marseille");
		q1.addProposition("Paris");
		q1.addProposition("Lille");
		q1.addProposition("Nantes");
		q1.setBonneReponse(2);
		
		Question q2 = new Question("Capitale de l'Espagne", 4);
		q2.addProposition("Madrid");
		q2.addProposition("Barcelone");
		q2.addProposition("Valence");
		q2.addProposition("Bilbao");
		q2.setBonneReponse(1);
		
		Question q3 = new Question("Capitale du Japon", 4);
		q3.addProposition("Kyoto");
		q3.addProposition("Nara");
		q3.addProposition("Osaka");
		q3.addProposition("Tokyo");
		q3.setBonneReponse(4);
		
		listeQuestions.add(q1);
		listeQuestions.add(q2);
		listeQuestions.add(q3);
	}
}
