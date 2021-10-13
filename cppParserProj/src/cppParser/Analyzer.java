package cppParser;

/**
 * Base class for all the analyzers (except SentenceAnalyzer)
 * 
 * @author Harri Pellikka
 */
public class Analyzer
{

	protected SentenceAnalyzer sentenceAnalyzer;

	// Reference to the singleton parsed object manager
	protected ParsedObjectManager objManager;

	public Analyzer(SentenceAnalyzer sa)
	{
		this.sentenceAnalyzer = sa;
		objManager = ParsedObjectManager.getInstance();
	}

	/**
	 * Processes the given sentence. Should be overridden.
	 * 
	 * @param tokens
	 *            Tokens that form the sentence
	 * @return 'True' if the sentence was processed, 'false' if it should be
	 *         passed to the next analyzer
	 */
	public boolean processSentence(String[] tokens)
	{
		// TODO Do some basic processing / checking here?

		return false;
	}
}
