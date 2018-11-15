package fr.diginamic.exception;

public class StockageException extends Exception {
	private static final long serialVersionUID = -503296217210467242L;

	public StockageException() {
		
	}
	
	public StockageException(String msg) {
		super(msg);
	}	
}
