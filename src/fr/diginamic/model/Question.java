package fr.diginamic.model;

public class Question {
	private String intitule;
	private String[] propositions;
	private String bonneReponse;
	
	public Question(String intitule, int nbReponse) {
		this.intitule = intitule;
		this.propositions = new String[nbReponse];
	}
	
	public Boolean verifierReponse(String reponse){
		if (this.bonneReponse == reponse) 
			return true;
		else
			return false;
	}
	
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String[] getPropositions() {
		return propositions;
	}
	public void setPropositions(String[] propositions) {
		this.propositions = propositions;
	}
	public String getBonneReponse() {
		return bonneReponse;
	}
	public void setBonneReponse(String bonneReponse) {
		this.bonneReponse = bonneReponse;
	}

}
