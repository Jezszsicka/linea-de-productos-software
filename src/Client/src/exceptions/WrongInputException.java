package exceptions;

@SuppressWarnings("serial")
public class WrongInputException extends Exception {
	private String error;
	public WrongInputException(String error,String message){
		super(message);
		this.error = error;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	
	
}
