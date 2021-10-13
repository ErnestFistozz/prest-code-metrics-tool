package categorizer.core;

import java.lang.reflect.Constructor;
import java.util.Vector;

import common.DataContext;
import common.NodePair;

/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */

public class DataHeader implements ContextBuilder {
	
	
	/**
	 * Label of the child label tag
	 */
	private final static String labelTag = "label";
	

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
	private final static String currentTag = "dataHeader";
	
	/**
	 * Label of the useLimits tag
	 */
	private final static String useLimitsTag = "useLimits";
	
	/**
	 * Label of the isValid tag 
	 */
	private final static String isValidTag = "isValid";
	
	
	/**
	 * Label of the thresholds tag 
	 */
	private final static String thresholdsTag = "thresholds";
	
	/**
	 * Label of the threshold tag
	 */
	private final static String thresholdTag = "threshold" ;
	
	/**
	 * Label of the distribution tag
	 */
	private final static String distributionsTag = "distributions";
	
	
	/**
	 * label of the field
	 */
	private String label;
	
	/**
	 * true if field is declared to be nominal
	 */
	private boolean isNominal;
	
	/**
	 * the minimum value data can get
	 */
	private double minValue = -Double.MAX_VALUE;
	
	/**
	 * the maximum value data can get
	 */
	private double maxValue = Double.MAX_VALUE;
	
	/**
	 * a set of valid values data can get,
	 * used for nominal data
	 */
	private String[] availableValues;
	
	/**
	 * distribution for the fields
	 */
	private Distributions distributions;
	
	/**
	 * indicates if the data Header is valid  
	 */
	private boolean isValid;
	
	
	/**
	 * indicates if the limits will be used or not
	 */
	private boolean useLimits;
	
	/**
	 * holds the thresholds related to this data header
	 */
	private Threshold[] thresholds;
	
	/**
	 * default constructor
	 */
	public DataHeader() {
		// These fields are added later and they are for further usage
		// Thus for convenience we set them as so
		isValid = true;
		useLimits = false;
	}


	/**
	 * @param title
	 * @param type
	 * @param isNominal
	 * @param minValue
	 * @param maxValue
	 * @param availableValue
	 */
	public DataHeader(String title, boolean isNominal,
			double minValue, double maxValue, String[] availableValue) {
		super();
		this.label = title;
		this.isNominal = isNominal;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.availableValues = availableValue;
	}


	

	/**
	 * @return the availableValues
	 */
	public String[] getAvailableValue() {
		return availableValues;
	}


	/**
	 * @param availableValues the availableValues to set
	 */
	public void setAvailableValue(String[] availableValues) {
		this.availableValues = availableValues;
	}

	
	

	/**
	 * @return the useLimits
	 */
	public boolean isUseLimits() {
		return useLimits;
	}


	/**
	 * @param useLimits the useLimits to set
	 */
	public void setUseLimits(boolean useLimits) {
		this.useLimits = useLimits;
	}


	/**
	 * @return the isValid
	 */
	public boolean isValid() {
		return isValid;
	}


	/**
	 * @param isValid the isValid to set
	 */
	public void setValid(boolean isValid) {
		this.isValid = isValid;
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
	 * @return the distribution
	 */
	public Distributions getDistributions() {
		return this.distributions;
	}


	/**
	 * @param distribution the distribution to set
	 */
	public void setDistributions(Distributions distributions) {
		this.distributions = distributions;
	}

	

	/**
	 * @return the thresholds
	 */
	public Threshold[] getThresholds() {
		return thresholds;
	}


	/**
	 * @param thresholds the thresholds to set
	 */
	public void setThresholds(Threshold[] thresholds) {
		this.thresholds = thresholds;
	}


	/**
	 * @param dataContext the dataContext to load the DataHeader from
	 */
	public void load(DataContext item) throws Exception {
		
		Vector tempVector = item.getElements2(labelTag);
		
		if(tempVector == null || tempVector.size() == 0)
		{
			throw new UnsupportedDataContextException();
		}
		
		this.label = new String((String)tempVector.get(0));
		
		
		tempVector = item.getElements2(isNominalTag);
		
		if(tempVector == null || tempVector.size() == 0)
		{
			throw new UnsupportedDataContextException();
		}
		
		this.isNominal = Boolean.parseBoolean((String)tempVector.get(0));
		
		
		tempVector = item.getElements2(isValidTag);
		
		if(tempVector == null || tempVector.size() == 0)
		{
			throw new UnsupportedDataContextException();
		}
		
		this.isValid = Boolean.parseBoolean((String)tempVector.get(0));
		
		
		
		if(!isNominal)
		{
			tempVector = item.getElements2(useLimitsTag);
			
			this.useLimits = false;
			if(tempVector != null && tempVector.size() > 0)
			{
				this.useLimits = Boolean.parseBoolean((String)tempVector.get(0));
			}
			
			tempVector = item.getElements2(minValueTag);
			
			this.minValue = Double.MIN_VALUE;
			if(tempVector != null && tempVector.size() > 0)
			{
				this.minValue = Double.parseDouble((String)tempVector.get(0));
			}
			
			tempVector = item.getElements2(maxValueTag);
			
			this.maxValue = Double.MAX_VALUE;
			if(tempVector == null || tempVector.size() == 0)
			{
				this.maxValue = Double.parseDouble((String)tempVector.get(0));
			}
		}
		else
		{
			DataContext tempDataContext = null;
			
			tempDataContext = item.getNode(availableValuesTag);
			
			if(tempDataContext == null)
				throw new UnsupportedDataContextException();
			
			tempVector = tempDataContext.getElements2(valueTag);
			
			if( tempVector == null || tempVector.size() == 0 )
			{
				throw new UnsupportedDataContextException();
			}
			
			availableValues = new String[tempVector.size()];
			for(int i=0; i<tempVector.size(); i++)
			{
				availableValues[i] = new String((String)tempVector.get(i));
			}
		}	
		
		DataContext tempDataContext = null ;
		
		tempDataContext = item.getNode(thresholdsTag);
		
		if(tempDataContext == null)
			throw new UnsupportedDataContextException();
		
		tempVector = tempDataContext.getNodes(thresholdTag);
		
		if( tempVector != null && tempVector.size() > 0 )
		{
			thresholds = new Threshold[tempVector.size()];
			
			for(int i=0; i<tempVector.size(); i++)
			{
				thresholds[i] = new Threshold();
				thresholds[i].load((DataContext)tempVector.get(i));
                                thresholds[i].setDataHeader(this);
			}
		}
		
		
		tempDataContext = item.getNode(distributionsTag);
		
		if(tempDataContext == null)
			throw new UnsupportedDataContextException();
		
		try{
			this.distributions = new Distributions();
			this.distributions.load(tempDataContext);
		}catch(Exception e){
			throw new UnsupportedDataContextException();
		}
		
	}


	/*
	 * return dataContext the dataContext of the DataHeader
	 */
	public DataContext store() throws Exception{
	
		DataContext dataContext = new DataContext();
		
		dataContext.add(new NodePair(labelTag,this.label));
		
		dataContext.add(new NodePair(isNominalTag, String.valueOf(this.isNominal)));
		
		dataContext.add(new NodePair(isValidTag, String.valueOf(this.isValid)));
		
		if(isNominal)
		{
			DataContext availableValuesContext = new DataContext();
			for(int i=0; i<availableValues.length; i++)
			{
				availableValuesContext.add(new NodePair(valueTag,availableValues[i]));
			}
			dataContext.add(availableValuesTag,availableValuesContext);
		}
		else
		{
			dataContext.add(new NodePair(useLimitsTag,String.valueOf(this.useLimits)));
			dataContext.add(new NodePair(minValueTag,String.valueOf(this.minValue)));
			dataContext.add(new NodePair(maxValueTag,String.valueOf(this.maxValue)));
		}
		
		DataContext thresholdContext = new DataContext();
		
		for(int i=0; thresholds != null && i<thresholds.length ; i++)
		{
			thresholdContext.add(thresholdTag,thresholds[i].store());
		}
		
		dataContext.add(thresholdsTag,thresholdContext);
		
		if(this.distributions != null)
			dataContext.add(distributionsTag,this.distributions.store());
		else
			dataContext.add(distributionsTag,new DataContext());
		
		return dataContext;
	}
	
	
	/**
	 * Adds a threshold to the Threshold set
	 * @param threshold
	 */
	public void addThreshold(Threshold threshold)
	{
		if(this.thresholds == null){
			this.thresholds = new Threshold[1];
			this.thresholds[0] = threshold;
		}
		else{
			Threshold [] temp = new Threshold[this.thresholds.length + 1];
			int i = 0;
			for(i=0; i<this.thresholds.length; i++)
				temp[i] = this.thresholds[i];
			temp[i] = threshold;
			
			this.thresholds = temp;
		}
	}
	
	/**
	 * Deletes the threshold whose id is index in the parameter
	 * @param index
	 */
	public void deleteThreshold(int index)
	{
		Threshold[] temp = new Threshold[this.thresholds.length - 1];
		int j=0;
		for(int i=0; i<this.thresholds.length; i++)
		{
			if(i != index)
			{
				temp[j] = this.thresholds[i];
				j++;
			}
		}
		
		this.thresholds = temp;
	}

	/**
	 * Deletes the threshold in the parameter from the threshold set
	 * @param threshold
	 */
	public void deleteThreshold(Threshold threshold)
	{
		Threshold[] temp = new Threshold[this.thresholds.length - 1];
		int j=0;
		for(int i=0; i<this.thresholds.length; i++)
		{
			if(this.thresholds[i] != threshold)
			{
				temp[j] = this.thresholds[i];
				j++;
			}
		}
		
		this.thresholds = temp;
		
	}
}
