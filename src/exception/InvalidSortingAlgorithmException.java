package exception;

/**
 * Exception to be thrown when no valid algorithm is given
 */
public class InvalidSortingAlgorithmException extends Exception {

	private static final long serialVersionUID = 411273181776430081L;

	/**
	 * Exception to be thrown when no valid algorithm is given
	 */
	public InvalidSortingAlgorithmException() {
		super("ERROR: The given sorting algorithm (-s) was invalid. The options are: b, s, i, m, q, or z");
	}

}
