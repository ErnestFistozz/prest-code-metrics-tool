package categorizer.core;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JOptionPane;

import categorizer.aiCategorizer.core.ConfusionMatrix;

import common.DataContext;

/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class CategorizerExecutor implements Validator, OptionHandler{
	
	/**
	 * Title of the categorizer
	 * Especially used in the UI sections, to store and load a specific categorizer.
	 */
	protected String title;	
	
	protected DataSet dataSet;
	
	/**
	 * dataSet to build the Categorizer
	 */
	protected DataSet trainDataSet;
	
	/**
	 * dataSet to test the Categorizer
	 */
	protected DataSet testSet;
	
	
	/**
	 * className of the categorizer
	 * Especially used in creating instances.
	 */
	
	protected String className = "categorizer.core.CategorizerExecutor";
	
	
	/**
	 *  Tag label of the Title
	 */
	private final String titleTag ="title";
	
	/**
	 *  Tag label of the ClassName
	 */
	
	private final String classNameTag ="className" ;
	
	/**
	 * Tag label of the DataHeaders
	 */
	private final String dataHeadersTag = "dataHeaders";
	
	/**
	 * Tag label of the Confusion Matrix
	 */
	private final String confusionMatrixTag = "confusionMatrix";
	
	/**
	 * Tag label of the Options
	 */
	private final String optionsTag = "options";
	
	/**
	 * Tag label of the Option
	 */
	private final String optionTag = "option";
	
	private final String SamplingOptionLabelValue = "Sampling";
	
	private final String PercentageOptionLabelValue = "TrainDataPercentage";
	
	private String SamplingOptionValue;
	
	private String PercentageOptionValue;
	
	/**
	 * options of the categorizerExecutor
	 */
	protected Option[] options;
	
	/**
	 * options of the categorizer
	 */
	protected Option[] categorizerOptions;
	
	/**
	 * name of the categorizer className
	 */
	private String categorizerClassName;
	
	/**
	 * Holds the confusionMatrix that results in building the categorizer
	 */
//	protected ConfusionMatrix confusionMatrix;
	
	protected Vector categorizers;
	
	
	/**
	 * default constructor 
	 */
	public CategorizerExecutor(){
		categorizers = new Vector();
	}
	
	public CategorizerExecutor(DataContext dataSetContext) throws Exception {
		categorizers = new Vector();
		dataSet = new DataSet();
		dataSet.load(dataSetContext);
	}
	
	public CategorizerExecutor(DataSet dataSet){
		categorizers = new Vector();
		this.dataSet = dataSet;
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
	}
	
	/**
	 * Loads a DataSet to Categorizer. This dataSet will be used in learning
	 * @param dataSet
	 */
	public void loadDataSet(DataSet dataSet)
	{
		this.dataSet = dataSet;
	}

	
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
		
	//	confusionMatrix = new ConfusionMatrix();
			
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
				if( option.getLabel().equals(SamplingOptionLabelValue) ){
					SamplingOptionValue = option.getValue(); // get the sampling type
				}
				
				else if( option.getLabel().equals(PercentageOptionLabelValue) ){
					PercentageOptionValue = option.getValue();
				}
			}
			
			createTrainAndTestSets(); // create data and test sets with the given
									// sampling and train data percentage options
		}
	}
	
	/**
	 * creates train and test DataSets with respect to the given sampling and percentage options 
	 */
	public void createTrainAndTestSets(){
		
		double trainDataPercentage = Double.parseDouble(PercentageOptionValue);
		Vector<DataItem>trainDataItems;
		Vector<DataItem>testDataItems;
		
		if(trainDataPercentage==0.0)
			trainDataPercentage=0.8;
		
		DataItem [] dataItems = dataSet.getDataItems();
		
		if( SamplingOptionValue.equals("equalDistribution") ){
			
		// get the index for class data header
			int classIndex = dataSet.getClassIndex();
			if(classIndex<0){
				dataSet.setClassIndex( dataSet.getDataHeaders().length-1 );
				classIndex = dataSet.getClassIndex();
			}
		
		// get the class DataHeader
			DataHeader classHeader = dataSet.getDataHeaders()[classIndex];
		
		// get available values for class DataHeader
			String[] availableValuesForClass = classHeader.getAvailableValue();
		
		// create array of DataItem vectors where each vector will keep DataItems 
		// that belongs to the same class, i.e. has the same value for class DataHeader
		// Therefore, dataItemsofEachClass array has availableValues.length DataItem vectors
		//	Vector<DataItem>[] dataItemsofEachClass = new Vector[availableValuesForClass.length];
			HashMap dataItemsofEachClass = new HashMap();
			for(int i=0; i<availableValuesForClass.length; i++){
			//	dataItemsofEachClass[i] = new Vector<DataItem>();
				Vector ItemsofOneClass = new Vector();
				dataItemsofEachClass.put(availableValuesForClass[i], ItemsofOneClass);
			}
		
			for(int i=0; i<dataItems.length; i++){
				((Vector)dataItemsofEachClass.get(dataItems[i].getDataFields()[classIndex].getStringValue())).add(dataItems[i]); 
			//	for(int j=0; j<availableValuesForClass.length; j++){
			//		if( dataItems[i].getDataFields()[classIndex].getStringValue().equals(availableValuesForClass[j]) )
			//			dataItemsofEachClass[j].add(dataItems[i]);
			//	}
			}
			
			// evaluate how many dataItems from each dataItemsofEachClass vector will be in trainDataItems vector
			int [] numOfDataItemsfromEachClass = new int[availableValuesForClass.length];
					
			// create dataItems vectors that will keep items of train and test data
			trainDataItems = new Vector<DataItem>();
			testDataItems = new Vector<DataItem>();
			
			// take given percentage of items from each dataItemsofEachClass vector
			for(int i=0; i<numOfDataItemsfromEachClass.length; i++){
				
				numOfDataItemsfromEachClass[i] = (int) (trainDataPercentage * ((Vector)dataItemsofEachClass.get(availableValuesForClass[i])).size());
				
				// copy that many dataItems to trainDataItems
				for(int j=0; j<numOfDataItemsfromEachClass[i]; j++)
					trainDataItems.add( (DataItem) ((Vector)dataItemsofEachClass.get(availableValuesForClass[i])).get(j) );
				
				// copy the rest to testDataItems
			//	for(int k=0; k < dataItemsofEachClass[i].size()-numOfDataItemsfromEachClass[i]; k++)
				for(int k=numOfDataItemsfromEachClass[i]; k < ((Vector)dataItemsofEachClass.get(availableValuesForClass[i])).size(); k++)
					testDataItems.add( (DataItem) ((Vector)dataItemsofEachClass.get(availableValuesForClass[i])).get(k) );
				
			}
			
			DataItem[]trainDataItemArray = new DataItem[trainDataItems.size()];
			
			for(int i=0;i<trainDataItemArray.length;i++)
				trainDataItemArray[i] = trainDataItems.get(i);

			trainDataSet = new DataSet();
			trainDataSet.setDataHeaders(dataSet.getDataHeaders());
			trainDataSet.setDataItems(trainDataItemArray);
			
			
			DataItem[]testDataItemArray = new DataItem[testDataItems.size()];
			
			for(int i=0;i<testDataItemArray.length;i++)
				testDataItemArray[i] = testDataItems.get(i);
			
			testSet = new DataSet();
			testSet.setDataHeaders(dataSet.getDataHeaders());
			testSet.setDataItems(testDataItemArray);
			
		}
		
		else{	// if sampling will be done randomly distributed
			
			int numOfDataItemsinTrainData = (int)(trainDataPercentage * dataItems.length);
			
			trainDataItems = new Vector<DataItem>();
			testDataItems = new Vector<DataItem>();
			
			for(int i=0; i<numOfDataItemsinTrainData; i++){
				
				trainDataItems.add(dataItems[i]);
			}
			
			for(int j=numOfDataItemsinTrainData; j < dataItems.length; j++){
			
				testDataItems.add(dataItems[j]);
			}

			DataItem[]trainDataItemArray = new DataItem[trainDataItems.size()];
			
			for(int i=0;i<trainDataItemArray.length;i++)
				trainDataItemArray[i] = trainDataItems.get(i);

			trainDataSet = new DataSet();
			trainDataSet.setDataHeaders(dataSet.getDataHeaders());
			trainDataSet.setDataItems(trainDataItemArray);

			
			DataItem[]testDataItemArray = new DataItem[testDataItems.size()];
			
			for(int i=0;i<testDataItemArray.length;i++)
				testDataItemArray[i] = testDataItems.get(i);

			testSet = new DataSet();
			testSet.setDataHeaders(dataSet.getDataHeaders());
			testSet.setDataItems(testDataItemArray);
			
		}
		
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
	}
	
	public DataSet getTrainDataSet() {
		return trainDataSet;
	}
	
	public void setTrainDataSet(DataSet dataSet) {
		this.trainDataSet = dataSet;
	}
	
	public DataSet getTestSet() {
		return testSet;
	}
	
	public void setTestSet(DataSet dataSet) {
		this.testSet = dataSet;
	}
	
	/**
	 * @return categorizer class name
	 */
	public String getcategorizerClassName(){
		return categorizerClassName;
	}
	
	public void setcategorizerClassName(String className){
		this.categorizerClassName = className;
	}

	public Option[] getOptions(){
		return options;
	}

	public void setOptions(Option[] Options){
		
		this.options = Options;
		
		for(int i=0; i<options.length; i++)
		{
		//	Option option = options[i];
			if( options[i].getLabel().equals(SamplingOptionLabelValue) ){
				SamplingOptionValue = options[i].getValue(); // get the sampling type
			}
			
			else if( options[i].getLabel().equals(PercentageOptionLabelValue) ){
				PercentageOptionValue = options[i].getValue();
			}
		}
		
		createTrainAndTestSets(); // create data and test sets with the given
								// sampling and train data percentage options
	}

	public ConfusionMatrix[] crossValidate(int numFolds) throws Exception {
	
		Vector confMatrices = new Vector();
		
		int numPerDataSet = (int)( dataSet.getDataItems().length / numFolds );
		
		DataSet [] dataSets = new DataSet[numFolds];
		
		for(int i=0; i<numFolds; i++){
			
			dataSets[i] = new DataSet();
			DataItem [] dataItems;
			
		
			
			if(i==numFolds-1){ // meaning last fold will be built
				
				dataItems = new DataItem[ dataSet.getDataItems().length-i*numPerDataSet ];
				int k=0;
				for(int j=i*numPerDataSet; j<dataSet.getDataItems().length; j++){
					dataItems[k] = new DataItem(); 
					dataItems[k].setDataHeaders(dataSet.getDataHeaders());
					dataItems[k].load(dataSet.getDataItems()[j].store().cloneDataContext());						
					k++;
				}
			}
			
			else{
				
				dataItems = new DataItem[numPerDataSet];
				int k=0;
				for(int j=i*numPerDataSet; j<(i+1)*numPerDataSet; j++){
					dataItems[k] = new DataItem(); 
					dataItems[k].setDataHeaders(dataSet.getDataHeaders());;
					dataItems[k].load(dataSet.getDataItems()[j].store().cloneDataContext());	
					k++;
				}
			}
			
			dataSets[i].setDataItems(dataItems);
		}
		
		for(int i=0; i<numFolds; i++){
			
			Vector trainDataItems = new Vector();
			
			// forming train data by excluding one fold at each loop
			for(int j=0; j<numFolds; j++){
				
				if(j!=i){
					for(int k=0; k<dataSets[i].getDataItems().length; k++)
						trainDataItems.add( dataSets[i].getDataItems()[k] );
				}
				
				else{ // if j==i, then this dataSet will be test fold
					setTestSet(dataSets[j]);
				}
			}
				
			DataItem [] trainDataItemsArray = new DataItem[trainDataItems.size()];
				
			for(int k=0; k<trainDataItemsArray.length; k++)
				trainDataItemsArray[k] = (DataItem) trainDataItems.get(k);
				
			DataHeader[] dataHeaders = new DataHeader[dataSet.getDataHeaders().length];
			for(int j=0; j<dataHeaders.length; j++)
			{
				dataHeaders[j] = new DataHeader();
				dataHeaders[j].load(dataSet.getDataHeaders()[j].store().cloneDataContext());
			}
			
			DataSet trainSet = new DataSet();
			trainSet.setDataHeaders(dataHeaders);
			trainSet.setDataItems(trainDataItemsArray);
			
			setTrainDataSet(trainSet);
				
			Class categorizer1 = Class.forName(getcategorizerClassName());
			Constructor constructor1 = categorizer1.getDeclaredConstructor(null);
			Categorizer categorizer = (Categorizer) constructor1.newInstance(null);
				
			if(this.categorizerOptions != null)
				categorizer.setOptions(this.categorizerOptions);
			
			categorizer.loadDataSet(trainDataSet);
			categorizer.setTestSet(testSet);
				
			categorizer.buildCategorizer();
				
			categorizers.add(categorizer);
				
			confMatrices.add(categorizer.getConfusionMatrix());
		}
		
		ConfusionMatrix [] confMatrixArray = new ConfusionMatrix[confMatrices.size()];
		
		for(int i=0; i<confMatrixArray.length; i++)
			confMatrixArray[i] = (ConfusionMatrix) confMatrices.get(i);
			
		return confMatrixArray;
			
	}

	public ConfusionMatrix instanceValidate() throws Exception {
	
	//	this.dataSet = data;
		Class categorizer1 = Class.forName(getcategorizerClassName());
		Constructor constructor1 = categorizer1.getDeclaredConstructor(null);
		Categorizer categorizer = (Categorizer) constructor1.newInstance(null);
		categorizer.setDataSet(dataSet);
		categorizer.setTestSet(testSet);
		
		if(this.categorizerOptions != null)
			categorizer.setOptions(this.categorizerOptions);
		
		categorizer.buildCategorizer();
		categorizers.add(categorizer);
		return categorizer.getConfusionMatrix();
	}

	public ConfusionMatrix portionValidate(Option[] Options) throws Exception {
		// TODO Auto-generated method stub
				setOptions(Options);
		
		Class categorizer1 = Class.forName(getcategorizerClassName());
		Constructor constructor1 = categorizer1.getDeclaredConstructor(null);
		Categorizer categorizer = (Categorizer) constructor1.newInstance(null);

		categorizer.loadDataSet(trainDataSet);
		categorizer.setTestSet(testSet);
		
		if(this.categorizerOptions != null)
			categorizer.setOptions(this.categorizerOptions);
		
		categorizer.buildCategorizer();
		
		categorizers.add(categorizer);
		
		return categorizer.getConfusionMatrix();
	}

	public DataContext storeOptions() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setCategorizers(Vector cats){
		this.categorizers = cats;
	}
	
	public Vector getCategorizers(){
		return this.categorizers;
	}

	/**
	 * @return the categorizerOptions
	 */
	public final Option[] getCategorizerOptions() {
		return categorizerOptions;
	}

	/**
	 * @param categorizerOptions the categorizerOptions to set
	 */
	public final void setCategorizerOptions(Option[] categorizerOptions) {
		this.categorizerOptions = categorizerOptions;
	}

//	/**
//	 * @return the confusionMatrix
//	 */
//	public ConfusionMatrix getConfusionMatrix() {
//		return confusionMatrix;
//	}
//	
//	/**
//	 * @param confusionMatrix the confusionMatrix to set
//	 */
//	public void setConfusionMatrix(ConfusionMatrix confusionMatrix) {
//		this.confusionMatrix = confusionMatrix;
//	}
	
	
	

}
