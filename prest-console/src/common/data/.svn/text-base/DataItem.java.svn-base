package common.data;

import java.util.Vector;

import common.NodePair;

/**
 * Class that keeps and handles operations on metric values of one instance
 */

public class DataItem implements ContextBuilder, Comparable{

	/**
	 * Label of the child tag
	 */
	private final static String valueTag = "value";
	
	/**
	 * Label of the dataFields tag
	 */
	private final static String dataFieldsTag = "dataFields";
	
	
	/**
	 * Label of the itemName tag
	 */
	private final static String itemNameTag = "itemName";
	
	
	/**
	 * Label of the current tag
	 */
	private final static String currentTag = "dataItem";
	
	
	/**
	 * Holds the value of all data fields
	 */
	private DataField[] dataFields;
	
	
	/**
	 * Holds the weighted values of all data fields
	 */
	private DataField[] weightedValues;
	
	
	/**
	 * Holds the dataHeaders of the data fields
	 */
	private DataHeader[] dataHeaders;
	
	/**
	 * indicate if the dataItem is valid
	 */
	private boolean isValid;
	
	/**
	 * holds the name of the Item
	 */
	private String itemName;
	

	
	
	/**
	 * default constructor
	 */
	public DataItem() {
	}

	/**
	 * @param dataFields
	 */
	public DataItem(DataField[] dataFields) {
		this.dataFields = dataFields;
	}

	/**
	 * @param dataFields
	 * @param weightedValues
	 */
	public DataItem(DataField[] dataFields, DataField[] weightedValues) {
		this.dataFields = dataFields;
		this.weightedValues = weightedValues;
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
	 * @return the weightedValues
	 */
	public DataField[] getWeightedValues() {
		return weightedValues;
	}

	/**
	 * @param weightedValues the weightedValues to set
	 */
	public void setWeightedValues(DataField[] weightedValues) {
		this.weightedValues = weightedValues;
	}

	/** 
	 * @param dataContext the dataContext to load the item from
	 * uses Data Headers to create DataField
	 * @throws UnsupportedDataContextException 
	 */
	public void load(DataContext item) throws UnsupportedDataContextException {
				
		dataFields = new DataField[dataHeaders.length];
		
		DataContext dataFieldsContext = item.getNode(dataFieldsTag);
		
		for(int i=0; i<dataHeaders.length; i++)
		{
			Vector values = dataFieldsContext.getElements2(dataHeaders[i].getLabel());
			
			if(values != null && values.size() > 0)
			{
				DataField dataField = new DataField(dataHeaders[i]);
				
				dataField.load((String)values.get(0));
				
				dataField.setDataHeader(dataHeaders[i]);
				
				dataFields[i] = dataField;
			}
			else{
				throw new UnsupportedDataContextException();
			}
		}
		
		Vector tempVector = item.getElements2(itemNameTag);
		
		if(tempVector != null && tempVector.size() > 0)
		{
			itemName = (String)tempVector.get(0);
		}
	}

	/**
	 * Stores an item in the form of DataContext
	 */

	public DataContext store() {
		
		DataContext dataContext = new DataContext();
		
		dataContext.add(new NodePair(itemNameTag,itemName));
		
		DataContext dataFieldsContext = new DataContext();
		
		for(int i=0; i<dataHeaders.length; i++)
		{
			dataFieldsContext.add(new NodePair(dataHeaders[i].getLabel(), (dataFields[i]).getStringValue()));
		}
		
		
		dataContext.add(dataFieldsTag,dataFieldsContext);
		
		return dataContext;
	}

	/**
	 * @return the dataFields
	 */
	public DataField[] getDataFields() {
		return dataFields;
	}

	/**
	 * @param dataFields the dataFields to set
	 */
	public void setDataFields(DataField[] dataFields) {
		this.dataFields = dataFields;
	}

	/**
	 * @return the dataHeaders
	 */
	public DataHeader[] getDataHeaders() {
		return dataHeaders;
	}

	/**
	 * @param dataHeaders the dataHeaders to set
	 */
	public void setDataHeaders(DataHeader[] dataHeaders) {
		this.dataHeaders = dataHeaders;
	}
	

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int compareTo(Object o) {
		return 0;
	}
	
}
