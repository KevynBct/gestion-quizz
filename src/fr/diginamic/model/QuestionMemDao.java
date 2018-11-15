package fr.diginamic.model;

import java.util.ArrayList;

public class QuestionMemDao implements QuestionDao {
    public ArrayList<Question> listeQuestions;

    public QuestionMemDao(){
        listeQuestions = new ArrayList<Question>();
        this.init();
    }

    @Override
    public ArrayList<Question> findAll() {
        return listeQuestions;
    }

    @Override
    public void save(Question question) {
    	this.listeQuestions.add(question);
    }

    @Override
    public void delete(Question question) {
    	this.listeQuestions.remove(question);

    }

    public ArrayList<Question> getListeQuestions() {
        return listeQuestions;
    }

    public void setListeQuestions(ArrayList<Question> listeQuestions) {
        this.listeQuestions = listeQuestions;
    }
    
    public void init() {
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

        this.listeQuestions.add(q1);
        this.listeQuestions.add(q2);
        this.listeQuestions.add(q3);
    }
}
