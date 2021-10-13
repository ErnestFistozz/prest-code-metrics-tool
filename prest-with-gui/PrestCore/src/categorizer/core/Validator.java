package categorizer.core;

import categorizer.aiCategorizer.core.ConfusionMatrix;

/**
 * <p>This is the validator interface which is implemented by all categorizers.
 * This interface is especially useful in AICategorizers because with the implementation
 * of Validator, the result of the learning can easily be obtained.
 *
 * @author secil.karagulle
 * @author ovunc.bozcan
 */

public interface Validator {

	/**
	 * This is the method for cross validation.
	 * @throws Exception 
	 */
	public ConfusionMatrix[] crossValidate(int numFolds) throws Exception;

	/**
	 * This is the method that will divide the original dataSet into two parts : one for
	 * the learning and the other is for the validating the categorizer(the parameter
	 * decides the length of the test portion).  
	 * 
	 * @param percent
	 * @throws Exception 
	 */
	public ConfusionMatrix portionValidate(Option[] Options) throws Exception; // (double percent);

	/**
	 * This is the method that another dataSet is used for validation.
	 * @param data
	 * @throws Exception 
	 */
	public ConfusionMatrix instanceValidate() throws Exception;

}
