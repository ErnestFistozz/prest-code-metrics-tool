/**
 * 
 */
package categorizer.core;

import java.util.Vector;

import common.DataContext;
import common.NodePair;

/**
 * <p>OptionDefinition is the class for presenting an option of a categorizer and its properties.
 * It is used in categorizerDefinition.  
 * <p>OptionDefinition implements ContextBuilder which means that an instance can be stored in
 * a DataContext and can be loaded from DataContext
 *
 *
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class OptionDefinition implements ContextBuilder{

	/**
	 * label of the option
	 */
	private String label;
	
	/**
	 * description of the option
	 */
	private String description;

	/**
	 * value of the option
	 */
	private String value;

	/**
	 * true if option is declared to be nominal
	 */
	private boolean isNominal;
	
	/**
	 * the minimum value option value can get
	 */
	private double minValue;
	
	/**
	 * the maximum value option value can get
	 */
	private double maxValue;
	
	/**
	 * a set of valid values option can get,
	 * used for nominal options
	 */
	private String[] availableValues;
	
	
	/**
	 * Label of the child label tag
	 */
	private final static String labelTag = "label";
	
	/**
	 * Tag name of the description
	 */
	private final static String descriptionTag = "description";
	
	/**
	 * Label of the child isNominal tag
	 */
	private final static String isNominalTag = "isNominal";
	
	/**
	 * Label of the child minValue tag
	 */
	private final static String minValueTag = "minVal";
	
	/**
	 * Label of the child maxValue tag
	 */
	private final static String maxValueTag = "maxVal";
	
	/**
	 * Label of the child availableValues tag
	 */
	private final static String availableValuesTag = "availableValues";
	
	/**
	 * Label of the child values tag
	 */
	private final static String valueTag = "value";
	
	/**
	 * Label of the current tag
	 */
	private final static String currentTag = "option";
	
	
	
	/**
	 * default constructor
	 */
	public OptionDefinition() {
		// TODO Auto-generated constructor stub
	}


	
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}



	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}



	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}



	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	/**
	 * @return the isNominal
	 */
	public boolean isNominal() {
		return isNominal;
	}



	/**
	 * @param isNominal the isNominal to set
	 */
	public void setNominal(boolean isNominal) {
		this.isNominal = isNominal;
	}



	/**
	 * @return the minValue
	 */
	public double getMinValue() {
		return minValue;
	}



	/**
	 * @param minValue the minValue to set
	 */
	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}



	/**
	 * @return the maxValue
	 */
	public double getMaxValue() {
		return maxValue;
	}



	/**
	 * @param maxValue the maxValue to set
	 */
	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}



	/**
	 * @return the availableValues
	 */
	public String[] getAvailableValues() {
		return availableValues;
	}



	/**
	 * @param availableValues the availableValues to set
	 */
	public void setAvailableValues(String[] availableValues) {
		this.availableValues = availableValues;
	}



	/* (non-Javadoc)
	 * @see categorizer.core.ContextBuilder#load(common.DataContext)
	 */

	public void load(DataContext dataContext)
			throws UnsupportedDataContextException {
		
		Vector tempVector = dataContext.getElements2(labelTag);
		
		if(tempVector == null || tempVector.size() == 0)
		{
			throw new UnsupportedDataContextException();
		}
		
		this.label = new String((String)tempVector.get(0));
		
		
		tempVector = dataContext.getElements2(descriptionTag);
		
		if(tempVector == null || tempVector.size() == 0)
		{
			throw new UnsupportedDataContextException();
		}
		
		this.description = new String((String)tempVector.get(0));
		
		
		tempVector = dataContext.getElements2(isNominalTag);
		
		if(tempVector == null || tempVector.size() == 0)
		{
			throw new UnsupportedDataContextException();
		}
		
		this.isNominal = Boolean.parseBoolean((String)tempVector.get(0));
		
		
		if(!isNominal)
		{
			tempVector = dataContext.getElements2(minValueTag);
			
			this.minValue = Double.MIN_VALUE;
			if(tempVector != null && tempVector.size() > 0)
			{
				this.minValue = Double.parseDouble((String)tempVector.get(0));
			}
			
			tempVector = dataContext.getElements2(maxValueTag);
			
			this.maxValue = Double.MAX_VALUE;
			if(tempVector != null || tempVector.size() == 0)
			{
				this.maxValue = Double.parseDouble((String)tempVector.get(0));
			}
		}
		else
		{
			DataContext tempDataContext = new DataContext();
			
			tempDataContext = dataContext.getNode(availableValuesTag);
			
			tempVector = tempDataContext.getElements2(valueTag);
			
			if( tempVector == null || tempVector.size() == 0 )
			{
				throw new UnsupportedClassVersionError();
			}
			
			availableValues = new String[tempVector.size()];
			for(int i=0; i<tempVector.size(); i++)
			{
				availableValues[i] = new String((String)tempVector.get(i));
			}
		}	
	}


	/* (non-Javadoc)
	 * @see categorizer.core.ContextBuilder#store()
	 */

	public DataContext store() {

		DataContext dataContext = new DataContext();
		
		dataContext.add(new NodePair(labelTag,this.label));
		
		dataContext.add(new NodePair(descriptionTag,this.description));
				
		dataContext.add(new NodePair(isNominalTag, String.valueOf(this.isNominal)));
		
		if(isNominal)
		{
			dataContext.add(availableValuesTag,new DataContext());
			for(int i=0; i<availableValues.length; i++)
			{
				dataContext.getNode(availableValuesTag).add(new NodePair(valueTag,availableValues[i]));
			}
		}
		else
		{
			dataContext.add(new NodePair(minValueTag,String.valueOf(this.minValue)));
			dataContext.add(new NodePair(maxValueTag,String.valueOf(this.maxValue)));
		}
		
		return dataContext;
	}

}
