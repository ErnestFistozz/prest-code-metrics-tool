package common.data;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Vector;

import common.NodePair;


public class DataSet implements ContextBuilder, Cloneable{

	/**
	 * label of the current tag
	 */
	private final static String currentTag = "dataSet";
	
	/**
	 * label of the dataHeaders tag
	 */
	private final static String dataHeadersTag = "dataHeaders";
	
	/**
	 * label of the dataItems tag
	 */
	private final static String dataItemsTag = "dataItems";
	
	/**
	 * label of the dataHeader tag
	 */
	private final static String dataHeaderTag = "dataHeader";
	
	/**
	 * label of the dataItem tag
	 */
	private final static String dataItemTag = "dataItem";
	
	/**
	 * label of the title tag
	 */
	private final static String titleTag = "title";
	
	/**
	 * label of the virtualHeader tag
	 */
	private final static String virtualHeaderTag = "virtualHeader" ;
	
	
	/**
	 * label of the virtualHeaders tag
	 */
	private final String virtualHeadersTag = "virtualHeaders" ;
	
	
	/**
	 * Title of the DataSet
	 */
	private String title;
	/**
	 * array of data items that make up the data set 
	 */
	private DataItem[] dataItems;
	
	/**
	 * array of data headers that will be used
	 * for the data in the data set
	 */
	private DataHeader[] dataHeaders;
	
	
	/**
	 * index of the Class Column
	 */
	private int classIndex = -1;
	
	/**
	 * default constructor
	 */
	public DataSet() {
	}

	/**
	 * @param dataItems
	 * @param dataHeaders
	 */
	public DataSet(DataItem[] dataItems, DataHeader[] dataHeaders) {
		super();
		this.dataItems = dataItems;
		this.dataHeaders = dataHeaders;
	}

	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the dataItems
	 */
	public DataItem[] getDataItems() {
		return dataItems;
	}

	/**
	 * @param dataItems the dataItems to set
	 */
	public void setDataItems(DataItem[] dataItems) {
		this.dataItems = dataItems;
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
	 * @param label
	 * @return the dataHeader whose label is the same as parameter
	 */
	public DataHeader getDataHeader(String label){
		for(int i=0; dataHeaders !=null && i<dataHeaders.length; i++)
			if(dataHeaders[i].getLabel().equals(label))
				return dataHeaders[i];
		
		return null;
	}
	
	/**
	 * @param label
	 * @return the dataHeader index whose label is the same as parameter
	 */
	public int getDataHeaderIndex(String label){
		for(int i=0; dataHeaders !=null && i<dataHeaders.length; i++)
			if(dataHeaders[i].getLabel().equals(label))
				return i;
		
		return -1;
	}

	/**
	 * Loads a DataSet from a DataContext 
	 * @throws UnsupportedDataContextException 
	 */

	public void load(DataContext dataSetContext) throws Exception {
		
		
		try{
			this.title = (String)dataSetContext.getElements2(titleTag).get(0);
		}catch(Exception e){
			this.title ="defaultRelation";
		}
			
		DataContext dataHeadersContext = dataSetContext.getNode(dataHeadersTag);
		
		loadDataHeaders(dataHeadersContext);
		
		DataContext dataItemsContext = dataSetContext.getNode(dataItemsTag);
		
		loadDataItems(dataItemsContext);
		
		DataContext virtualHeadersContext = dataSetContext.getNode(virtualHeadersTag);
	}

	/** 
	 * Stores a DataSet into a DataContext 
	 */
	public DataContext store() throws Exception{

		DataContext dataContext = new DataContext();
		
		dataContext.add(new NodePair(titleTag, this.title));
		
		dataContext.add(dataHeadersTag, storeDataHeaders());
		
		dataContext.add(dataItemsTag, storeDataItems());
		
		
		return dataContext;
		
	}
	
	/**
	 * @param dataContext
	 * @throws UnsupportedDataContextException
	 * 
	 * loads  only the Data Headers part of the Data Set
	 */
	public void loadDataHeaders(DataContext dataHeadersContext) throws Exception
	{
		if(dataHeadersContext == null)
		{
			throw new UnsupportedDataContextException();
		}
		
		Vector dataHeaderNodes = dataHeadersContext.getNodes(dataHeaderTag);
		
		if(dataHeaderNodes==null || dataHeaderNodes.size()==0){
			throw new UnsupportedDataContextException();
		}
		
		dataHeaders = new DataHeader[dataHeaderNodes.size()];
		for(int i=0; i<dataHeaderNodes.size(); i++)
		{
			DataHeader dataHeader = new DataHeader();
			
			dataHeader.load((DataContext)dataHeaderNodes.get(i));	
			
			dataHeaders[i] = dataHeader;
		}
	}
	
	
	/**
	 * @return the DataContext of DataHeaders
	 */
	public DataContext storeDataHeaders() throws Exception 
	{
		DataContext dataContext = new DataContext();
		for(int i=0; dataHeaders!= null && i<dataHeaders.length; i++)
		{
			dataContext.add(dataHeaderTag, ((DataHeader)dataHeaders[i]).store());
		}
		
		return dataContext;
	}
	


	
	/**
	 * loads only the Data Items part of the Data Set
	 * 
	 * @param dataContext
	 * @throws UnsupportedDataContextException
	 * 
	 */
	public void loadDataItems(DataContext dataItemsContext) throws UnsupportedDataContextException
	{
		
		if(dataItemsContext == null)
		{
			throw new UnsupportedDataContextException();
		}
		
		Vector dataItemNodes = dataItemsContext.getNodes(dataItemTag);
		
		if(dataItemNodes==null || dataItemNodes.size()==0){
			throw new UnsupportedDataContextException();
		}
		
		dataItems = new DataItem[dataItemNodes.size()];
		
		for(int i=0; i<dataItemNodes.size(); i++)
		{
			DataItem dataItem = new DataItem();
			
			dataItem.setDataHeaders(dataHeaders);
			
			dataItem.load((DataContext)dataItemNodes.get(i));	
			
			dataItems[i] = dataItem ;
		}
	}
	
	
	/**
	 * @return the DataContext of the DataItems 
	 */
	public DataContext storeDataItems()
	{
		DataContext dataContext = new DataContext();
		for(int i=0; dataItems != null && i<dataItems.length; i++)
		{
			dataContext.add(dataItemTag, ((DataItem)dataItems[i]).store());
		}
		
		return dataContext;
	}

	/**
	 * @return
	 */
	public int getClassIndex() {
		return classIndex;
	}

	/**
	 * @param classIndex
	 */
	public void setClassIndex(int classIndex) {
		this.classIndex = classIndex;
	}

	
	/**
	 * Adds one DataItem to the DataItem array
	 */
	public void AddDataItem(DataItem dataItem)
	{
		DataItem[] tempDataItems = new DataItem[this.dataItems.length + 1];
		int i=0;
		if(this.dataItems != null)
		{
			for(i=0; i<this.dataItems.length; i++)
			{
				tempDataItems[i] = this.dataItems[i];
			}
		}
		tempDataItems[i] = dataItem;
		this.dataItems = tempDataItems;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public DataSet clone()
	{
		DataSet tempDataSet = new DataSet();
		try {
			tempDataSet.load(this.store().cloneDataContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempDataSet;
	}

}
