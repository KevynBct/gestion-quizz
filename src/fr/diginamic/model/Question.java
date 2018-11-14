package fr.diginamic.model;

import java.util.ArrayList;

public class Question {
	private String intitule;
	private ArrayList<String> propositions;
	private int bonneReponse;
	
	public Question(String intitule, int nbReponse) {
		this.intitule = intitule;
		this.propositions = new ArrayList<String>(nbReponse);
	}
	
	public Boolean verifierReponse(int reponse){
		if (this.bonneReponse == reponse) 
			return true;
		else
			return false;
	}
	
	public void addProposition(String proposition) {
		this.propositions.add(proposition);
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public ArrayList<String> getPropositions() {
		return propositions;
	}

	public void setPropositions(ArrayList<String> propositions) {
		this.propositions = propositions;
	}

	public int getBonneReponse() {
		return bonneReponse;
	}

	public void setBonneReponse(int bonneReponse) {
		this.bonneReponse = bonneReponse;
	}
	
	public String toString() {
		String listeReponse ="\n";
		for(String rep : propositions) {
			listeReponse += "\t- "+rep+"\n";
		}
		return this.intitule+listeReponse;
	}
	

}
