package categorizer.aiCategorizer.decisionTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.Vector;

import categorizer.aiCategorizer.core.AICategorizer;
import categorizer.aiCategorizer.core.ConfusionMatrix;
import categorizer.core.CategorizerNotValidException;
import categorizer.core.ClassNotNominalException;
import categorizer.core.DataItem;
import categorizer.core.DataSet;
import categorizer.core.Option;

import common.DataContext;

/**
 * The Decision Tree class that implements C4.5 unpruned decision tree.
 * It is based on a simple gain calculation and supports numeric attributes.
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class DecisionTree extends AICategorizer{


	private final static String trueTag = "true";
	
	private final static String falseTag = "false";
	
	private final static String rootTag = "rootNode";
	
	private double maxEntropy;
	
	private double binProportion = 1;

	
	/**
	 * Label of the categorizer specific tag
	 */
	private final String categorizerSpecificTag = "categorizerSpecific";
	
	private TreeNode root;
	
	
	
	/**
	 * default categorizer
	 */
	public DecisionTree() {
		super();
		className = "categorizer.aiCategorizer.decisionTree.DecisionTree";
	}

	
	/* (non-Javadoc)
	 * @see categorizer.core.ContextBuilder#load(common.DataContext)
	 */
	public void load(DataContext dataContext) throws Exception{
		super.load(dataContext);
		DataContext catSpecific = dataContext.getNode(categorizerSpecificTag); 
		this.root = new TreeNode();
		this.root.load(catSpecific.getNode(rootTag));		
		valid = true;		
	}

	/* (non-Javadoc)
	 * @see categorizer.core.ContextBuilder#store()
	 */
	@Override
	public DataContext store() throws Exception{
		if(!valid)
			throw new CategorizerNotValidException();
		
		DataContext dataContext = super.store();
		DataContext catSpecific = new DataContext();
		catSpecific.add(rootTag, root.store());
		dataContext.add(categorizerSpecificTag, catSpecific);
		return dataContext;
	}

	
	/* (non-Javadoc)
	 * @see categorizer.core.Categorizer#setOptions(categorizer.core.Option[])
	 */
	@Override
	public void setOptions(Option[] options) {
		// TODO Auto-generated method stub
		super.setOptions(options);
		if(options !=  null && options.length > 0)
			this.binProportion = Double.parseDouble(options[0].getValue()) / 100.0;
	}


	/* (non-Javadoc)
	 * @see categorizer.aiCategorizer.core.AICategorizer#buildCategorizer()
	 */
	@Override
	public ConfusionMatrix buildCategorizer() throws Exception {
		
		classIndex = dataSet.getClassIndex();
		
		if(classIndex == -1)
		{
			for(int i=dataSet.getDataHeaders().length -1; i>=0; i--)
			{
				if(dataSet.getDataHeaders()[i].isNominal())
				{
					classIndex = i;
					dataSet.setClassIndex(i);
					break;
				}
			}
		}
		
		
		if(!dataSet.getDataHeaders()[classIndex].isNominal())
			throw new ClassNotNominalException();
		
		// the starting Entropy
		maxEntropy = -Math.log(1.0/(double)dataSet.getDataHeaders()[classIndex].getAvailableValue().length)/Math.log(2);
		
		System.out.println(maxEntropy);
	
		root = findMaxGainAndSplit(maxEntropy, dataSet);
		
		valid = true;
		return super.validate(testSet);
	}

	
	/* (non-Javadoc)
	 * @see categorizer.aiCategorizer.core.AICategorizer#categorize(categorizer.core.DataItem)
	 */
	@Override
	public DataItem categorize(DataItem dataItem) throws Exception {
		
		dataItem = super.categorize(dataItem);
		
		if(!valid)
			throw new CategorizerNotValidException();
		
		classIndex = dataSet.getClassIndex();
		
		if(classIndex == -1)
		{
			for(int i=dataSet.getDataHeaders().length -1; i>=0; i--)
			{
				if(dataSet.getDataHeaders()[i].isNominal())
				{
					classIndex = i;
					dataSet.setClassIndex(i);
					break;
				}
			}
		}

		
		System.out.println("######## Categorize #############");
		
		TreeNode treeNode = root;
		while(!treeNode.isLeaf())
		{
			treeNode = treeNode.compare(dataItem);
		}
		
		
		dataItem.getDataFields()[classIndex].load((String)treeNode.getValue());  

		return dataItem;
	}

	
	/*
	 * The recursive version of the findMaxGainAndSplit.
	 * Suffers from the StackOverFlowError for large and accurate dataSets
	 */
	
	/*
	private TreeNode findGainAndSplit(double entropy, DataSet dataSet) throws Exception
	{	
		depth ++;
		String classValue = findClassValue(dataSet);
		if(classValue == null)
		{
			Object value = null;
			double gain = -Double.MAX_VALUE;
			int index = 0;
			for(int i=0; i<dataSet.getDataHeaders().length; i++)
			{	
				if(i != classIndex)
				{
					Vector gainDetails = getGain(entropy, dataSet, i);
					
					if((Double)gainDetails.get(0) > gain)
					{
						gain = (Double)gainDetails.get(0);
						value = gainDetails.get(1);
						index = i;				
					}
				}
			}
			
			DataSet[] splits = null;
		
			if(dataSet.getDataHeaders()[index].isNominal())
				splits = splitDataSet(dataSet, index);
			else
				splits = splitDataSet(dataSet, index, value);
			
			
			HashMap hashMap = new LinkedHashMap();
			for(int i=0; i<splits.length; i++)
			{
				TreeNode treeNode = findGainAndSplit(maxEntropy, splits[i]);	//
//				TreeNode treeNode = findGainAndSplit(entropy-gain, splits[i]);	//
				if(dataSet.getDataHeaders()[index].isNominal())
					hashMap.put(dataSet.getDataHeaders()[index].getAvailableValue()[i], treeNode);
				else if(i==0)
					hashMap.put(trueTag , treeNode);
				else
					hashMap.put(falseTag, treeNode);
				
			}
			
			TreeNode treeNode = new TreeNode(false);
			treeNode.setDataHeader(dataSet.getDataHeaders()[index]);
			
			if(!dataSet.getDataHeaders()[index].isNominal())
				treeNode.setValue(value);
			
			treeNode.setChildren(hashMap);
			return treeNode;
		}
		else{
			
			System.out.println("depth >> " + this.depth + " --> " + dataSet.getDataItems().length);
			TreeNode treeNode = new TreeNode(true);
			treeNode.setValue(classValue);
			return treeNode;
		}
	}
	
	*/
	
	/**
	 * The method that builds up the tree.
	 * At first creates a LinkedList and adds the dataSet in the parameter to it. Then 
	 * in a loop until the LinkedList is empty, a DataSet is polled from the 
	 * LinkedList and if the dataSet is not a leaf, 
	 * finds gains that will be achieved when the dataSet is split according to each dataHeader.
	 * Later splits the dataSet using the dataHeader with the maximum gain and
	 * adds each split to the LinkedList.
	 * @param entropy the starting Entropy
	 * @param dataSet the DataSet that the decision tree is built upon
	 * @return the root node of the decision tree.
	 * @throws Exception
	 */
	private TreeNode findMaxGainAndSplit(double entropy,DataSet dataSet) throws Exception
	{	
		LinkedList dataSetLinkedList = new LinkedList();
		dataSetLinkedList.add(dataSet);
		TreeNode root = new TreeNode();
		LinkedList treeNodeLinkedList = new LinkedList();
		treeNodeLinkedList.add(root);
		
		while(dataSetLinkedList.size() > 0)
		{
			TreeNode currentTreeNode = (TreeNode)treeNodeLinkedList.poll();
			DataSet currentDataSet = (DataSet)dataSetLinkedList.poll();
			
			String classValue = findClassValue(currentDataSet);
			if(classValue == null)
			{
				currentTreeNode.setLeaf(false);
				
				Object value = null;
				double gain = -Double.MAX_VALUE;
				int index = 0;
				for(int i=0; i<currentDataSet.getDataHeaders().length; i++)
				{	
					if(i != classIndex)
					{
						Vector gainDetails = getGain(entropy, currentDataSet, i);
						
						if((Double)gainDetails.get(0) > gain)
						{
							gain = (Double)gainDetails.get(0);
							value = gainDetails.get(1);					// indicates the best split value for numeric attributes
							index = i;				
						}
					}
				}
				
				DataSet[] splits = null;
				
				if(currentDataSet.getDataHeaders()[index].isNominal())
					splits = splitDataSet(currentDataSet, index);
				else
					splits = splitDataSet(currentDataSet, index, value);
				
				HashMap children = new LinkedHashMap();
				
				for(int i=0; i<splits.length; i++)
				{
					TreeNode treeNode = new TreeNode();
					
					if(currentDataSet.getDataHeaders()[index].isNominal())
						children.put(currentTreeNode.getDataHeader().getAvailableValue()[i], treeNode);
					else if(i==0)
						children.put(trueTag, treeNode);
					else
						children.put(falseTag, treeNode);
					
					dataSetLinkedList.add(splits[i]);
					treeNodeLinkedList.add(treeNode);
				}
				
				currentTreeNode.setChildren(children);
				currentTreeNode.setDataHeader(currentDataSet.getDataHeaders()[index]);
				if(!currentDataSet.getDataHeaders()[index].isNominal())
					currentTreeNode.setValue(value);
			}
			else{
				currentTreeNode.setLeaf(true);
				currentTreeNode.setValue(classValue);
			}
		}
		return root;
	}
	
	
	/**
	 * Finds the classValue of a dataSet.
	 * The classValue of a dataSet is decided if the most of the 
	 * dataItems (binProportion determines the proportion) in the dataSet
	 * belongs to one class.
	 * @param dataSet
	 * @return the classValue of a dataSet or null if there is none
	 */
	private String findClassValue(DataSet dataSet)
	{
		if(dataSet.getDataItems() == null)
			return "Inconclusive";
		
		String classValue = "";
		HashMap classCounts = new HashMap();
		String[] classes = dataSet.getDataHeaders()[classIndex].getAvailableValue();
		if(classes == null)
			return classValue;
		for(int i=0; i<classes.length; i++)
			classCounts.put(classes[i],0);
		
		for(int i=0; i<dataSet.getDataItems().length; i++)
		{
			int count = (Integer)classCounts.get(dataSet.getDataItems()[i].getDataFields()[classIndex].getStringValue());
			count++;
			classCounts.put(dataSet.getDataItems()[i].getDataFields()[classIndex].getStringValue(), count);
		}
		
		for(int i=0; i<classes.length; i++)
		{
			if( (Integer) classCounts.get(classes[i]) >= dataSet.getDataItems().length * binProportion)
				return classes[i];
		}
		
		return null;
	}
	
	/**
	 * For nominal DataHeaders calculates the gain that will be achieved when 
	 * the dataSet is split using that DataHeader
	 * For numeric DataHeaders in addition to calculating gain, calculates the best split value 
	 * when the dataSet is split using that DataHeader  
	 * @param entropy the entropy before the dataSet is split
	 * @param dataSet the dataSet to be splitted
	 * @param headerIndex the index of the dataHeader according to which the dataSet will be split
	 * @return the vector containing gain and the best split value in the case of numeric dataHeader.
	 * @throws Exception
	 */
	private Vector getGain(double entropy, DataSet dataSet, int headerIndex) throws Exception
	{
		Vector retVal = new Vector();
		// index 0 will indicate the gain
		// index 1 will indicate the value ( for nominal dataHeaders --> empty
		//									 for numeric dataHeaders --> Best split value ) 
		if(dataSet.getDataHeaders()[headerIndex].isNominal())
		{
			HashMap availableCounts = new HashMap();
			for(int i=0; i<dataSet.getDataHeaders()[headerIndex].getAvailableValue().length; i++)
			{
				HashMap classCounts = new HashMap();
				for(int j=0; j<dataSet.getDataHeaders()[classIndex].getAvailableValue().length; j++)
				{
					classCounts.put(dataSet.getDataHeaders()[classIndex].getAvailableValue()[j], 0);
				}
				availableCounts.put(dataSet.getDataHeaders()[headerIndex].getAvailableValue()[i], classCounts);
			}
			
			for(int i=0; i<dataSet.getDataItems().length; i++)
			{
				DataItem dataItem = dataSet.getDataItems()[i];
				HashMap classCounts = (HashMap)availableCounts.get(dataItem.getDataFields()[headerIndex].getStringValue());
				int count = (Integer)classCounts.get(dataItem.getDataFields()[classIndex].getStringValue());
				count++;
				classCounts.put(dataItem.getDataFields()[classIndex].getStringValue(),count);
				availableCounts.put(dataItem.getDataFields()[headerIndex].getStringValue(),classCounts);
			}
			
			retVal.add(calculateGain(entropy,availableCounts,dataSet.getDataItems().length));
			retVal.add("");
			
			return retVal;
		}
		else
		{
			
			ArrayList itemList = new ArrayList();
			for(int i=0; i<dataSet.getDataItems().length; i++)
				itemList.add(dataSet.getDataItems()[i]);
			
			DataItemComparator dataItemComparator = new DataItemComparator(headerIndex);
			
			Collections.sort(itemList,dataItemComparator);
			
			
//			int chunkSize = (int)Math.sqrt(itemList.size());
			int chunkSize = 1;
			
			double gain = 0.0;
			int length = chunkSize;
			
			for(int k=1; k < itemList.size()/chunkSize - 1; k++)
			{
				int tempLength = k*chunkSize  ;
				HashMap availableCounts = new HashMap();
				for(int i=0; i<2; i++)
				{
					HashMap classCounts = new HashMap();
					for(int j=0; j<dataSet.getDataHeaders()[classIndex].getAvailableValue().length; j++)
					{
						classCounts.put(dataSet.getDataHeaders()[classIndex].getAvailableValue()[j], 0);
					}
					if(i==0)
						availableCounts.put(trueTag, classCounts);
					else
						availableCounts.put(falseTag, classCounts);
				}
		
				HashMap classCounts = (HashMap)availableCounts.get(trueTag);
				for(int i=0; i<tempLength; i++)
				{
					DataItem dataItem = (DataItem)itemList.get(i);
					int count = (Integer)classCounts.get(dataItem.getDataFields()[classIndex].getStringValue());
					count++;
					classCounts.put(dataItem.getDataFields()[classIndex].getStringValue(),count);
				}
				availableCounts.put(trueTag, classCounts);
				
				classCounts = (HashMap)availableCounts.get(falseTag);
				for(int i=tempLength; i<itemList.size(); i++)
				{
					DataItem dataItem = (DataItem)itemList.get(i);
					int count = (Integer)classCounts.get(dataItem.getDataFields()[classIndex].getStringValue());
					count++;
					classCounts.put(dataItem.getDataFields()[classIndex].getStringValue(),count);
				}
				
				availableCounts.put(falseTag, classCounts);
				
				double tempGain = calculateGain(entropy,availableCounts,itemList.size());
				if( tempGain >= gain)
				{
					gain = tempGain;
					length = tempLength;
				}
				
				// System.out.println( gain + " >> " + tempGain);
			}
			
//			System.out.println(dataSet.getDataHeaders()[headerIndex].getLabel());
//			System.out.println(gain + " >> " + itemList.size() + " >> "  + chunkSize+ " >> " +length);
			
			retVal.add(gain);
			retVal.add(((DataItem)itemList.get(length-1)).getDataFields()[headerIndex].getValue());
			return retVal;
		}
	}
	
	
	/**
	 * Calculates the gain that will be achieved
	 * @param entropy
	 * @param availableCounts
	 * @param totalSize
	 * @return the gain calculated
	 */
	public double calculateGain(double entropy,HashMap availableCounts,int totalSize)
	{
		HashMap totalCounts = new HashMap();
		Set set = availableCounts.keySet();
		Iterator iterator = set.iterator();
		double gain = entropy;
		
		while(iterator.hasNext())
		{	
			String key = (String)iterator.next();
			
			HashMap classCounts = (HashMap)availableCounts.get(key);
			Iterator classIterator = classCounts.keySet().iterator();
			int count = 0;
			while(classIterator.hasNext())
			{
				String classLabel = (String)classIterator.next();
				count += (Integer)classCounts.get(classLabel);
			}
			
			totalCounts.put(key, count);
		}
		
		
		iterator = set.iterator();
		
		while(iterator.hasNext())
		{
			String key = (String)iterator.next();
			int count = (Integer)totalCounts.get(key);
			double proportion = ((double)count)/((double)totalSize) ;
			
			HashMap classCounts = (HashMap)availableCounts.get(key);
			Iterator classIterator = classCounts.keySet().iterator();
			
			double localEntropy = 0;
			while(classIterator.hasNext())
			{
				String classLabel = (String)classIterator.next();
				
				int classCount = (Integer)classCounts.get(classLabel);
				double classProportion = ((double)classCount / (double) count);
				
				if(classProportion != 0)
					localEntropy -= classProportion*Math.log(classProportion)/Math.log(2);				
				
			}
			
			gain -= proportion*localEntropy;
			
		}
		
		return gain;
	}
	
	
	
	/**
	 * Splits the dataSet with respect to numeric dataHeader
	 * DataItems whose datafield at dataHeaderIndex is less than or equal to the value will compose the first split
	 * DataItems whose datafield at dataHeaderIndex is larger than the value will compose the second split
	 * @param dataSet
	 * @param dataHeaderIndex
	 * @param value
	 * @return the two dataSets which are splits of the dataSet in the parameter
	 * @throws Exception
	 */
	public DataSet[] splitDataSet(DataSet dataSet, int dataHeaderIndex, Object value) throws Exception
	{
		DataSet[] splitSets = new DataSet[2];
		
		splitSets[0] = new DataSet();
		splitSets[0].setDataHeaders(dataSet.getDataHeaders());
		
		splitSets[1] = new DataSet();
		splitSets[1].setDataHeaders(dataSet.getDataHeaders());
		
		Vector itemList_0 = new Vector();
		Vector itemList_1 = new Vector();
		
		if(dataSet.getDataItems() != null)
		{
			for(int i=0; i<dataSet.getDataItems().length; i++)
			{
				DataItem dataItem = dataSet.getDataItems()[i];
			
				if((Double)dataItem.getDataFields()[dataHeaderIndex].getValue() <= (Double)value)
					itemList_0.add(dataItem);
				else
					itemList_1.add(dataItem);
				
			}
		}
		
		/*
		 * There can be the case that second vector is empty (When the value is equal to the 
		 * values of the dataFields of the DataItems that are supposed to be in the second
		 * vector).
		 * In order to overcome this irregularity last element of the first vector is 
		 * removed and added to the second vector.
		 *  
		 */
		if(itemList_1.size() == 0)
		{
			itemList_1.add(itemList_0.lastElement());
			itemList_0.remove(itemList_0.size() - 1);
		}
		
		DataItem[] dataItems = new DataItem[0];
		
		splitSets[0].setDataItems((DataItem[])itemList_0.toArray(dataItems));
	
		splitSets[1].setDataItems((DataItem[])itemList_1.toArray(dataItems));
		
		
		return splitSets;
	}
	
	
	/**
	 * Splits the dataSet with respect to the nominal DataHeader
	 * Each split contains the DataItems with only one kind of availableValues of that DataHeader
	 * @param dataSet
	 * @param dataHeaderIndex
	 * @return
	 * @throws Exception
	 */
	public DataSet[] splitDataSet(DataSet dataSet, int dataHeaderIndex) throws Exception
	{
		
		String[] availableValues = dataSet.getDataHeaders()[dataHeaderIndex].getAvailableValue();		
		
		DataSet[] splitSets = new DataSet[availableValues.length];
		Vector[] vectors = new Vector[availableValues.length];
		
		for(int i=0; i<splitSets.length; i++)
		{
			splitSets[i] = new DataSet();
			splitSets[i].setDataHeaders(dataSet.getDataHeaders());
			vectors[i] = new Vector();
		}
		
		if(dataSet.getDataItems() != null)
		{
//			System.out.println("ItemList >> " + dataSet.getDataItems().length);
			for(int i=0; i<dataSet.getDataItems().length; i++)
			{
				DataItem dataItem = dataSet.getDataItems()[i];
				for(int j=0; j<availableValues.length; j++)
				{
//					System.out.println(availableValues[j] + " >> " + dataItem.getDataFields()[dataHeaderIndex].getStringValue());
					if(dataItem.getDataFields()[dataHeaderIndex].getStringValue().equalsIgnoreCase((String)availableValues[j]))
					{
						vectors[j].add(dataItem);
						break;
					}
				}
			}
		}
		
		DataItem[] dataItems = new DataItem[0];
		for(int i=0; i<splitSets.length; i++)
		{
//			System.out.println( i + " >>> " + availableValues[i] + " : " + vectors[i].size());
			if(vectors[i].size() !=  0)
				splitSets[i].setDataItems((DataItem[])vectors[i].toArray(dataItems));
			else
				splitSets[i].setDataItems(null);
		}
		
		return splitSets;
	}




}
