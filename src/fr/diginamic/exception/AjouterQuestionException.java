package fr.diginamic.exception;

public class AjouterQuestionException extends StockageException {
	private static final long serialVersionUID = 5420139024854096981L;

	public AjouterQuestionException() {}
	
	public AjouterQuestionException(String msg) {
		super(msg);
	}
}
