package categorizer.core;

import java.lang.reflect.Constructor;
import java.util.Vector;

import categorizer.aiCategorizer.core.ConfusionMatrix;
import categorizer.core.filter.Filter;

import common.DataContext;
import common.NodePair;

/**
 * 
 * <p>This class is an abstract super class of all categorizer classes.
 * It contains the common methods that apply to the other categorizer classes. They can
 * easily inherit this super class and override the inherited methods for their specific
 * implementation. 
 * 
 * <p>This class implements the interfaces ContextBuilder, OptionHandler and Validator.
 * Therefore class contains:
 * <ul>
 * 	<li>
 * 		the implementation of ContextBuilder interface(load, store) which
 * 	means that an instance of this class or subclasses can be stored as xml and can also be
 * 	loaded from its xml.
 *  </li>
 *  <li>
 * 		the implementation of OptionHandler interface(loadOptions, storeOptions) which
 *  enables any subclass can be used with options that are specific to itself.
 *  </li>
 *  <li>
 *  	the implementation of Validator interface(crossValidate, portionValidate, 
 *  instanceValidate) which the result of learning can be validated with these algorithms.
 *  </li>  
 * </ul>
 * <p>The execution flow of all subclasses that inherit from this class should be as follows :
 * At first an instance should be created. Then two dataSets should be loaded : one is for
 * learning purposes and the other one is for testing. Next the buildCategorizer method
 * should be called to process the machine learning algorithm. Once these steps are
 * completed categorizer is ready to classify a data instance. 
 * <p>To classify an instance one should call categorize method of this class with a dataItem
 * which will also be returned with its class set.
 *
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public abstract class Categorizer implements ContextBuilder, OptionHandler{
	
	/**
	 * Title of the categorizer
	 * Especially used in the UI sections, to store and load a specific categorizer.
	 */
	protected String title;	
	
	/**
	 * className of the categorizer
	 * Especially used in creating instances.
	 */
	protected String className = "categorizer.core.Categorizer";
	
	/**
	 *  Tag label of the Categorizer
	 */
	private final String currentTag = "categorizer";
	
	/**
	 *  Tag label of the Title
	 */
	private final String titleTag ="title";
	
	/**
	 *  Tag label of the ClassName
	 */
	private final String classNameTag ="className" ;
	
	/**
	 * Tag label of the Options
	 */
	private final String optionsTag = "options";
	
	/**
	 * Tag label of the Option
	 */
	private final String optionTag = "option";
	
	/**
	 * Tag label of the DataHeaders
	 */
	private final String dataHeadersTag = "dataHeaders";
	
	/**
	 * 
	 */
	private final String virtualHeadersTag = "virtualHeaders";
	
	
	/**
	 * Tag label of the Confusion Matrix
	 */
	private final String confusionMatrixTag = "confusionMatrix";
	
	/**
	 * Tag label of the Filters
	 */
	private final String filtersTag = "filters";
	
	/**
	 * Tag label of the Filter
	 */
	private final String filterTag = "filter";
	
	/**
	 * Tag label of the classLabel
	 */
	private final String classLabelTag = "filter";
	
	/**
	 * dataSet to build the Categorizer
	 */
	protected DataSet dataSet;
	
	
	/**
	 * dataSet to test the Categorizer
	 */
	protected DataSet testSet;
	
	/**
	 * options to build the Categorizer with 
	 */
	protected Option[] options;
	
	/**
	 * Holds the confusionMatrix that results in building the categorizer
	 */
	protected ConfusionMatrix confusionMatrix;
	
	/**
	 * Holds the performance metrics of the categorizer
	 */
	protected PerformanceMetric[] performanceMetrics;
	
	/**
	 * Indicates that the categorizer is built and ready to go
	 */
	protected boolean valid;
	
	/**
	 * Holds the index of the attribute to be classified
	 */
	protected int classIndex = -1;
	
	/**
	 * Holds the filters applied to this categorizer
	 */
	protected Filter[] filters;
	
	
	/**
	 * default constructor
	 */
	public Categorizer() {
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
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}


	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}


	/**
	 * Loads a DataSet in DataContext to Categorizer. This dataSet will be used in learning.
	 * @param dataSetContext
	 * @throws UnsupportedDataContextException 
	 */
	public void loadDataSet(DataContext dataSetContext) throws Exception
	{
		dataSet = new DataSet();
		dataSet.load(dataSetContext);
		valid = false;
	}
	
	/**
	 * Loads a DataSet to Categorizer. This dataSet will be used in learning
	 * @param dataSet
	 */
	public void loadDataSet(DataSet dataSet)
	{
		this.dataSet = dataSet;
		valid = false;
	}

	
	/**
	 * Loads the categorizer (Does not load the Data Set)
	 * In order a categorizer to be initialized, there is no need for dataItems, DataHeaders
	 * are sufficient for these purposes. So only dataHeaders are loaded from xml.
	 * 
	 * @see categorizer.core.ContextBuilder#load(common.DataContext)
	 * 
	 */

	public void load(DataContext categorizerDataContext) throws Exception {
		
		
		Vector elementVector = categorizerDataContext.getElements2(titleTag);
		
		if(elementVector == null || elementVector.size() == 0)
		{
			throw new UnsupportedDataContextException();
		}
		
		this.title = (String) elementVector.get(0);
		
		
		elementVector = categorizerDataContext.getElements2(classNameTag);
		
		if(elementVector == null || elementVector.size() == 0)
		{
			throw new UnsupportedDataContextException();
		}
		
		this.className = (String) elementVector.get(0);
	
		
		loadOptions(categorizerDataContext.getNode(optionsTag));
		
		
		dataSet = new DataSet();
		
		dataSet.loadDataHeaders(categorizerDataContext.getNode(dataHeadersTag));
		
		
		elementVector = categorizerDataContext.getElements2(classLabelTag);
		
		if(elementVector == null || elementVector.size() == 0)
		{
			throw new UnsupportedDataContextException();
		}

		dataSet.setClassIndex(dataSet.getDataHeaderIndex((String)(elementVector.get(0))));
		
		confusionMatrix = new ConfusionMatrix();
		
		dataSet.loadVirtualHeaders(categorizerDataContext.getNode(virtualHeadersTag));
		
		loadFilters(categorizerDataContext.getNode(filtersTag));
		
	}

	

	/** 
	 * Stores the categorizer in a dataContext where later categorizer can be loaded from this object
	 * 
	 * 
	 * (non-Javadoc)
	 * @see categorizer.core.ContextBuilder#store()
	 * 
	 */

	public DataContext store() throws Exception{
		
		DataContext dataContext = new DataContext();
		
		dataContext.add(new NodePair(titleTag, this.title));
		dataContext.add(new NodePair(classNameTag, this.className));
		dataContext.add(optionsTag, storeOptions());
		dataContext.add(dataHeadersTag,dataSet.storeDataHeaders());
		dataContext.add(classLabelTag,dataSet.getDataHeaders()[dataSet.getClassIndex()].getLabel());
		dataContext.add(virtualHeadersTag,dataSet.storeVirtualHeaders());
		dataContext.add(filtersTag,storeFilters());
		
		return dataContext;
	}
	
	/**
	 * 
	 * Trains the categorizer with the dataSet and returns the confusion matrix
	 * resulting from the validation of the categorizer with the test data set. 
	 * 
	 * @return the ConfusionMatrix where the result of the training is kept
	 */
	public ConfusionMatrix buildCategorizer() throws Exception
	{
		// Build Categorizer with the current dataSet
		
		
		return null;
	}
	
	/**
	 * @param dataItem
	 * @return dataItem with its class set
	 * Firstly, compares the DataHeaders of the given DataItem, dataItem, with
	 * the ones used in training the AICategorizer. If DataHeaders are not matched,
	 *  throws InvalidDataItem exception. Else if they match, returns the dataItem
	 *  with its class set
	 */
	public DataItem categorize(DataItem dataItem) throws Exception
	{
		DataHeader[] dataSetTotalDataHeaders = dataSet.getDataHeaders();
		
		DataHeader[] dataSetRealDataHeaders;
		
		if(dataSet.getVirtualHeaders()!=null){
			VirtualMetric[] dataSetVirtualDataHeaders = dataSet.getVirtualHeaders();
					
			dataSetRealDataHeaders = new DataHeader[dataSet.getDataHeaders().length - dataSet.getVirtualHeaders().length];
			
			boolean isVirtual = false;
			
			int realDataHeaderIndex=0;
		
			// get the dataSetRealDataHeaders, i.e. DataHeaders other than the virtual ones
			for(int i=0; i<dataSetTotalDataHeaders.length; i++){
				
				isVirtual = false;
				
				for(int j=0; j<dataSetVirtualDataHeaders.length; j++){
					
					if( dataSetTotalDataHeaders[i].getLabel().equals(dataSetVirtualDataHeaders[j].getLabel()) )
						isVirtual = true;
				}
				if(!isVirtual){
					dataSetRealDataHeaders[realDataHeaderIndex] = dataSetTotalDataHeaders[i];
					realDataHeaderIndex++;
				}
			}
		}
		
		else{
		//	dataSetRealDataHeaders = new DataHeader[dataSet.getDataHeaders().length];
			dataSetRealDataHeaders = dataSet.getDataHeaders();
		}
		
		
		
		DataHeader[] dataItemDataHeaders = dataItem.getDataHeaders();
		
		boolean invalidDataItem = true;
		
		// compare the real DataHeaders of the dataSet with the given DataItem instance;
		// if they don't match, throw exception
		for(int i=0; i<dataSetRealDataHeaders.length; i++){
			
			invalidDataItem = true;
			
			for(int j=0; j<dataItemDataHeaders.length; j++){
				
				if( dataSetRealDataHeaders[i].getLabel().equals(dataItemDataHeaders[j].getLabel()) )
					invalidDataItem = false; 
			}
			
			if(invalidDataItem)
				throw new InvalidDataItemException();
		}
		
		int numDataSetDataHeaders = dataSet.getDataHeaders().length;
		
		int numDataSetVirtualHeaders = 0;
		if(dataSet.getVirtualHeaders() != null)
		 numDataSetVirtualHeaders = dataSet.getVirtualHeaders().length;
		int numDataItemDataHeaders = dataItem.getDataHeaders().length;
		
		if( numDataSetDataHeaders-numDataSetVirtualHeaders == numDataItemDataHeaders )
			dataItem.setVirtualHeaders(dataSet.getVirtualHeaders());
		
		for(int i=0; dataSet.getVirtualHeaders() != null && i<dataSet.getVirtualHeaders().length; i++)
			dataItem = dataSet.getVirtualHeaders()[i].modifyItem(dataItem);
		
		return dataItem;
	}
	

	/**
	 * Loads only the Option from DataContext
	 * 
	 * @param dataContext
	 * @throws UnsupportedDataContextException
	 */
	public void loadOptions(DataContext dataContext) throws UnsupportedDataContextException
	{
		
		if(dataContext == null)
		{
			throw new UnsupportedDataContextException();
		}
		
		Vector elementVector = dataContext.getNodes(optionTag);
		
		if(elementVector != null && elementVector.size() != 0)
		{
			options = new Option[elementVector.size()];
			
			for(int i=0; i<elementVector.size(); i++)
			{
				Option option = new Option();
				option.load((DataContext)elementVector.get(i));
				options[i] = option;
			}
		}
	}
	
	/** (non-Javadoc)
	 * @see categorizer.core.OptionHandler#storeOptions()
	 * 
	 * Stores only the Options of the categorizer
	 */
	public DataContext storeOptions()
	{
		DataContext dataContext = new DataContext();
		
		if(options != null)
		{
			for(int i=0; i<options.length; i++)
			{
				dataContext.add(optionTag,options[i].store());
			}
		}
		
		return dataContext;
	}


	/**
	 * @return the dataSet
	 */
	public DataSet getDataSet() {
		return dataSet;
	}


	/**
	 * @param dataSet the dataSet to set
	 */
	public void setDataSet(DataSet dataSet) {
		this.dataSet = dataSet;
		valid = false;
	}


	/**
	 * @return the options
	 */
	public Option[] getOptions() {
		return options;
	}


	/**
	 * @param options the options to set
	 */
	public void setOptions(Option[] options) {
		this.options = options;
	}


	/**
	 * @return the testSet
	 */
	public DataSet getTestSet() {
		return testSet;
	}


	/**
	 * @param testSet the testSet to set
	 */
	public void setTestSet(DataSet testSet) {
		this.testSet = testSet;
	}


	/**
	 * Validates the categorizer with the dataSet in parameter
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public ConfusionMatrix validate(DataSet data) throws Exception {
		
		int classIndex = dataSet.getClassIndex();
	
		if(classIndex == -1)
		{
			for(int i=dataSet.getDataHeaders().length -1; i>=0; i--)
				if(dataSet.getDataHeaders()[i].isNominal())
				{
					classIndex = i;
					break;
				}
		}
			
//		System.out.println(classIndex);
		DataHeader dataHeader = dataSet.getDataHeaders()[classIndex];
		
		confusionMatrix = new ConfusionMatrix(dataHeader.getAvailableValue());
		
		for(int i=0 ; i < data.getDataItems().length ; i++)
		{
			String tempFieldValue = new String( data.getDataItems()[i].getDataFields()[classIndex].getStringValue() );	
			data.getDataItems()[i] = this.categorize(data.getDataItems()[i]);
			confusionMatrix.increment(tempFieldValue, data.getDataItems()[i].getDataFields()[classIndex].getStringValue());
		}
		
		createPerformanceMetrics();
		
		return confusionMatrix;
	}


	/**
	 * @return the confusionMatrix
	 */
	public ConfusionMatrix getConfusionMatrix() {
		return confusionMatrix;
	}


	/**
	 * @param confusionMatrix the confusionMatrix to set
	 */
	public void setConfusionMatrix(ConfusionMatrix confusionMatrix) {
		this.confusionMatrix = confusionMatrix;
	}


	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}


	/**
	 * @param valid the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	private void loadFilters(DataContext dataContext) throws Exception
	{
		if(dataContext == null)
			throw new UnsupportedDataContextException();
		
		Vector filterVector = dataContext.getNodes(filtersTag);
		
		if(filterVector != null && filterVector.size() > 0)
		{
			this.filters = new Filter[filterVector.size()];
			
			for(int i=0; i<filterVector.size(); i++)
			{
				DataContext filterContext = (DataContext)filterVector.get(i);
				
				String className = (String)filterContext.getElements2(classNameTag).get(0);
				
				Class filterClass = Class.forName(className);
				Constructor constructor = filterClass.getDeclaredConstructor(null);
				Filter filter = (Filter)constructor.newInstance(null);
				
				filter.load(filterContext);
				
				this.filters[i] = filter ;
			}
		}
	}
	
	private DataContext storeFilters() throws Exception
	{
		DataContext dataContext = new DataContext();
		
		for(int i=0; this.filters != null && i<this.filters.length; i++)
		{
			dataContext.add(filterTag,this.filters[i].store());
		}
		
		return dataContext;
	}


	/**
	 * @return the performanceMetrics
	 */
	public final PerformanceMetric[] getPerformanceMetrics() {
		return performanceMetrics;
	}


	/**
	 * @param performanceMetrics the performanceMetrics to set
	 */
	public final void setPerformanceMetrics(PerformanceMetric[] performanceMetrics) {
		this.performanceMetrics = performanceMetrics;
	}


	/**
	 * @return the filters
	 */
	public final Filter[] getFilters() {
		return filters;
	}


	/**
	 * @param filters the filters to set
	 */
	public final void setFilters(Filter[] filters) {
		this.filters = filters;
	}
	
	private void createPerformanceMetrics()
	{
		performanceMetrics = new PerformanceMetric[3];
		performanceMetrics[0] = new Accuracy(this.confusionMatrix);
		performanceMetrics[1] = new Precision(this.confusionMatrix);
		performanceMetrics[2] = new Recall(this.confusionMatrix);
	}
	
}
