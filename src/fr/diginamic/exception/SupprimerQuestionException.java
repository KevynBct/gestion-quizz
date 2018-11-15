package fr.diginamic.exception;

public class SupprimerQuestionException extends StockageException {
	private static final long serialVersionUID = 8690621924536040834L;
	
	public SupprimerQuestionException() {}
	
	public SupprimerQuestionException(String msg) {
		super(msg);
	}

}
