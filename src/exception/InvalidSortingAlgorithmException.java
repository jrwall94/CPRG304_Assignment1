package exception;

public class InvalidSortingAlgorithmException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 411273181776430081L;

	public InvalidSortingAlgorithmException() {
		super("ERROR: The given sorting algorithm (-s) was invalid. The options are: b, s, i, m, q, or z");
	}

}
