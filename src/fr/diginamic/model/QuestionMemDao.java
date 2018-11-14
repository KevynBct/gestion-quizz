package fr.diginamic.model;

import java.util.ArrayList;
import java.util.Scanner;

public class QuestionMemDao implements QuestionDao {
    public static ArrayList<Question> listeQuestions;

    public QuestionMemDao(){
        listeQuestions = this.findAll();
    }

    @Override
    public ArrayList<Question> findAll() {
        ArrayList<Question> listeQuestions = new ArrayList<Question>();

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

        return listeQuestions;
    }

    @Override
    public void save(Question question) {

    }

    @Override
    public void delete(Question question) {

    }

    public ArrayList<Question> getListeQuestions() {
        return listeQuestions;
    }

    public void setListeQuestions(ArrayList<Question> listeQuestions) {
        this.listeQuestions = listeQuestions;
    }
}
