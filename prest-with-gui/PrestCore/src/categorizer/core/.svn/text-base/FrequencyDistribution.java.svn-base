/**
 * 
 */
package categorizer.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import common.DataContext;
import common.NodePair;


/**
 * The superclass for the distribution of the nominal
 * variables
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class FrequencyDistribution extends Distribution {

	
	/**
	 * Holds the frequencies of the avaiableValues in the DataItems
	 */
	private DataContext frequencies;

	/**
	 * label of the distribution specific tag
	 */
	private final static String distributionSpecificTag = "distributionSpecific" ;

	
	/**
	 * Holds the available values of the dataField
	 */
	private String[] keys;


	/*
	 * (non-Javadoc)
	 * 
	 * @see categorizer.core.Distribution#weightedValue(java.lang.Object)
	 */
	@Override
	public Object weightedValue(Object variable) {
		try {
			Vector tempVector = frequencies.getElements2((String) variable);
			if(tempVector != null && tempVector.size() > 0)
				return tempVector.get(0);
			else
				return null;
		} catch (Exception e) {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see categorizer.core.Distribution#probability(java.lang.Object)
	 */
	@Override
	public double probability(Object variable) {
		try {
			Vector tempVector = frequencies.getElements2((String) variable);
			if(tempVector != null && tempVector.size() > 0)
				return Double.parseDouble((String)tempVector.get(0));
			else
				return 0.0;

		} catch (Exception e) {
			return 0.0;
		}
	}
	
	public double logProbability(Object variable) {
		try {
			Vector tempVector = frequencies.getElements2((String) variable);
			if(tempVector != null && tempVector.size() > 0)
				return Double.parseDouble((String)tempVector.get(0));
			else
				return Math.log(Double.MIN_VALUE);

		} catch (Exception e) {
			return Math.log(Double.MIN_VALUE);
		}
	}

	
	/**
	 * default constructor
	 */
	public FrequencyDistribution() {
		super();
		className = "categorizer.core.FrequencyDistribution" ;
	}

	/**
	 * @param classes
	 * @param keys
	 */
	public FrequencyDistribution(String classValue, String[] keys)
	{
		this.classValue = classValue;
		this.keys = keys;
		className = "categorizer.core.FrequencyDistribution" ;
	}
	
	/**
	 * @param keys is the array of attribute values
	 * @param dataItems
	 * @param index
	 * @param classes is the array of the attribute values of class
	 * @throws Exception 
	 */
	public FrequencyDistribution(DataSet dataSet,
			int index, int classValueIndex) throws Exception {

		DataHeader dataHeader = dataSet.getDataHeaders()[index];
		DataItem[] dataItems = dataSet.getDataItems();
		
		int classIndex = dataSet.getDataHeaders().length - 1;
		if(dataSet.getClassIndex() != -1 && classIndex != dataSet.getClassIndex())
			classIndex = dataSet.getClassIndex();
		
		this.keys = dataHeader.getAvailableValue();
		this.classValue = dataSet.getDataHeaders()[classIndex].getAvailableValue()[classValueIndex];
		
		className = "categorizer.core.FrequencyDistribution" ;
		
		frequencies = new DataContext();
		
		// counts will hold the counts until last line of the method
		
		for (int i = 0; i < keys.length; i++) {
			frequencies.add(new NodePair(keys[i], String.valueOf(0)));
		}
		

		for (int i = 0; i < dataItems.length; i++) {
			
			if(classValue.equals(dataItems[i].getDataFields()[classIndex].getStringValue()))
			{
				Vector tempVector = frequencies.getElements2(dataItems[i].getDataFields()[index].getStringValue());
				if(tempVector != null && tempVector.size() > 0)
				{
					int count = Integer.parseInt((String)tempVector.get(0));
					count++;
					frequencies.remove(dataItems[i].getDataFields()[index].getStringValue());
					frequencies.add(new NodePair(dataItems[i].getDataFields()[index].getStringValue(),String.valueOf(count)));
				}
				else
				{
					throw new IllegalDataException();
				}
			}
		}

		calculateNormalizedFrequencies(keys, classValue);
	}

	/**
	 * @return the HashMap containing normalized frequencies
	 */
	private void calculateNormalizedFrequencies(String[] keys, String classValue) {

		int totalCount = 0;
		for (int j = 0; j < keys.length; j++) {
			Vector count = frequencies.getElements2(keys[j]);
			totalCount += Integer.parseInt((String) count.get(0));
		}
		
		for (int j = 0; j<keys.length; j++){
			Vector count = frequencies.getElements2(keys[j]);
			frequencies.remove(keys[j]);
			frequencies.add(new NodePair(keys[j],String.valueOf((Double.parseDouble((String) count.get(0))+1) / (totalCount + keys.length))));
		}
	}

	/* (non-Javadoc)
	 * @see categorizer.core.Distribution#load(common.DataContext)
	 */
	public void load(DataContext dataContext)
			throws UnsupportedDataContextException {
		
		super.load(dataContext);
		frequencies = dataContext.getNode(distributionSpecificTag);
		
		if(frequencies == null)
			throw new UnsupportedDataContextException();
		
	}

	/* (non-Javadoc)
	 * @see categorizer.core.Distribution#store()
	 */
	public DataContext store() {
		
		DataContext dataContext = super.store();
		dataContext.add(distributionSpecificTag,frequencies);
		
		return dataContext;
	}
	
	

}
