/**
 * 
 */
package categorizer.core;

/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class CategorizerException extends Exception {
	
	/**
	 * Exception without message
	 */
	public CategorizerException()
	{
		super();
	}

	/**
	 * @param message the exception message
	 * Exception with message
	 */
	public CategorizerException(String message)
	{
		super(message);
	}
}
