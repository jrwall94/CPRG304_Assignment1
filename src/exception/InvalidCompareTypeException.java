package exception;

public class InvalidCompareTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1703570835846017376L;

	public InvalidCompareTypeException() {
		super("ERROR: The given compare type (-t) was invalid. The options are: o, u, d");
	}
}
