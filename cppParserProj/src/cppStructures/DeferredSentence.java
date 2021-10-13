package cppStructures;

/**
 * Represents a sentence that was not handled in the first pass. These sentences
 * are normally context-aware, where a token or multiple tokens cause
 * ambiguities.
 * 
 * @author Harri Pellikka
 */
public class DeferredSentence
{

	/**
	 * Represents a context type of the original sentence.
	 * 
	 * @author Harri Pellikka
	 */
	enum ContextType
	{
		NONE, NAMESPACE, // Not yet implemented
		CLASS, // Not yet implemented
		FUNCTION, STRUCT // Not yet implemented
	}

	/**
	 * Constructs a new deferred sentence with the given tokens, without any
	 * context
	 * 
	 * @param tokens
	 *            The tokens that form the sentence
	 */
	public DeferredSentence(String[] tokens)
	{
	}

	/**
	 * Constructs a new deferred sentence with the given tokens and with the
	 * given context class
	 * 
	 * @param tokens
	 *            The tokens that form the sentence
	 * @param cc
	 *            The context class
	 */
	public DeferredSentence(String[] tokens, CppClass cc)
	{
	}

	/**
	 * Constructs a new deferred sentence with the given tokens and with the
	 * given context function
	 * 
	 * @param tokens
	 *            The tokens that form the sentence
	 * @param cf
	 *            The context function
	 */
	public DeferredSentence(String[] tokens, CppFunc cf)
	{
	}
}
