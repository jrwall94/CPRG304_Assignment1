package exception;

/**
 * Exception to be thrown when no valid comparison type is given
 */
public class InvalidCompareTypeException extends Exception {

	private static final long serialVersionUID = -1703570835846017376L;

	/**
	 * Exception to be thrown when no valid comparison type is given
	 */
	public InvalidCompareTypeException() {
		super("ERROR: The given compare type (-t) was invalid. The options are: o, u, d");
	}
}
