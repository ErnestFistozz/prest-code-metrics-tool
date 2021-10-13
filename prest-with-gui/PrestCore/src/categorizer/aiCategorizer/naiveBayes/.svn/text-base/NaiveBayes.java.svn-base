package categorizer.aiCategorizer.naiveBayes;

import java.util.HashMap;
import java.util.Vector;

import categorizer.aiCategorizer.core.AICategorizer;
import categorizer.aiCategorizer.core.ConfusionMatrix;
import categorizer.core.CategorizerNotValidException;
import categorizer.core.ClassNotNominalException;
import categorizer.core.DataHeader;
import categorizer.core.DataItem;
import categorizer.core.DistributionFinder;
import categorizer.core.UnsupportedDataContextException;

import common.DataContext;
import common.NodePair;

/**
 * This class is the implementation of the Naive Bayes Classifier.
 * @author secil.karagulle
 * @author ovunc.bozcan
 */

public class NaiveBayes extends AICategorizer {


	/**
	 * Holds the prior probabilities of the classes
	 */
	private DataContext priors;
	
	/**
	 * Holds the class values
	 * This object is just for ease of use
	 */
	private String[] classes;
	

	/**
	 * Label of the categorizer specific tag
	 */
	private final String categorizerSpecificTag = "categorizerSpecific";
	
	
	/**
	 * Label of the classIndex Tag
	 */
	private final String classIndexTag = "classIndex" ;
	
	
	private final String priorsTag = "priors" ;
	
	/**
	 * default constructor
	 */
	public NaiveBayes() {
		super();
		className = "categorizer.aiCategorizer.naiveBayes.NaiveBayes";
		priors = new DataContext();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Builds the naive bayes classifier by calculating prior and conditional probabilities. 
	 * @see categorizer.aiCategorizer.core.AICategorizer#buildCategorizer()
	 *  
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
					break;
				}
			}
		}
		
		classes = dataSet.getDataHeaders()[classIndex].getAvailableValue();
		
		if(!dataSet.getDataHeaders()[classIndex].isNominal())
			throw new ClassNotNominalException();
		
		for(int i=0; i<classes.length; i++)
		{
			priors.add(new NodePair(classes[i], String.valueOf(0)));
			System.out.println(classes[i]);
		}
	
		System.out.println("#######################");
		for(int i=0; i<dataSet.getDataItems().length; i++)
		{
			if(!dataSet.getDataItems()[i].getDataFields()[classIndex].getStringValue().equals("?"))
			{
				Vector tempVector = priors.getElements2(dataSet.getDataItems()[i].getDataFields()[classIndex].getStringValue());
				if(tempVector != null && tempVector.size() >= 0)
				{
					int count = Integer.parseInt((String)tempVector.get(0));
					count++;
					priors.remove(dataSet.getDataItems()[i].getDataFields()[classIndex].getStringValue());
					priors.add(new NodePair(dataSet.getDataItems()[i].getDataFields()[classIndex].getStringValue(),String.valueOf(count)));
				}
			}
//			System.out.println(dataSet.getDataItems()[i].getDataFields()[dataSet.getDataHeaders().length - 1].getStringValue());
		}
		
		for(int i=0; i<classes.length; i++)
		{		
			int count = 0 ;
			Vector tempVector = priors.getElements2(classes[i]);
			if(tempVector != null && tempVector.size() >= 0)
				count = Integer.parseInt((String)tempVector.get(0)) + 1;
			priors.remove(classes[i]);	
			priors.add(new NodePair(classes[i],String.valueOf(((double)count )/ (dataSet.getDataItems().length + classes.length))));
		}
		
		DistributionFinder distFinder = new DistributionFinder();
		distFinder.findDistributions(dataSet,classes);
		
//		return null;
		
		valid = true;
		return super.validate(testSet);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see categorizer.aiCategorizer.core.AICategorizer#categorize(categorizer.core.DataItem)
	 */
	@Override
	public DataItem categorize(DataItem dataItem) throws Exception{
		// TODO Auto-generated method stub

		dataItem = super.categorize(dataItem);
		
		if(!valid)
			throw new CategorizerNotValidException();
		
		HashMap priorMap = priors.getBaseMap();
		System.out.println("######## Categorize #############");
		
		classIndex = dataSet.getClassIndex();
		
		if(classIndex == -1)
		{
			for(int i=dataSet.getDataHeaders().length -1; i>=0; i--)
			{
				if(dataSet.getDataHeaders()[i].isNominal())
				{
					classIndex = i;
					break;
				}
			}
		}
		
		classes = dataSet.getDataHeaders()[classIndex].getAvailableValue();
			
		double[] probs = new double[classes.length];
		
		double maxValue = 0 - Double.MAX_VALUE;
		int maxIndex = 0;
		
		
		for(int i=0; i<classes.length; i++)
		{
			probs[i] = 0;
			for(int j=0; j<dataSet.getDataHeaders().length; j++)
			{
				DataHeader dataHeader = dataSet.getDataHeaders()[j];
				
				if(j != classIndex && dataHeader.isValid())
				{
					if(dataHeader.isNominal())
				//		probs[i] += Math.log(dataHeader.getDistributions().probability(classes[i], dataItem.getDataFields()[j].getStringValue()));
						probs[i] += dataHeader.getDistributions().probability(classes[i], dataItem.getDataFields()[j].getStringValue());
					else
				//		probs[i] += Math.log(dataHeader.getDistributions().probability(classes[i], Double.parseDouble(dataItem.getDataFields()[j].getStringValue())));
						probs[i] += dataHeader.getDistributions().probability(classes[i], Double.parseDouble(dataItem.getDataFields()[j].getStringValue()));
					
//					System.out.println("---------- : " + probs[i]);
				}
			}
			
			 probs[i] += Math.log(Double.parseDouble( String.valueOf(priorMap.get(classes[i]))));
			 
			 System.out.println("Class : " + classes[i] + "  prob: " + probs[i] );
			 
			 if(probs[i] > maxValue)
			 {
				 maxIndex = i;
				 maxValue = probs[i];	
			 }
		}
		
		System.out.println("Decided Class : " + classes[maxIndex] + "  prob: " + maxValue );
		
		dataItem.getDataFields()[classIndex].load(classes[maxIndex]);  
/*		
		System.out.println("##########################");
		for(int i=0; i<dataItem.getDataFields().length; i++)
		{
			System.out.println(" >>>>>> " + dataItem.getDataFields()[i].getDataHeader().getLabel() + " : " + dataItem.getDataFields()[i].getStringValue());
		}
*/			
		return dataItem;
	}

	
	/* (non-Javadoc)
	 * @see categorizer.core.Categorizer#load(common.DataContext)
	 */
	public void load(DataContext categorizerDataContext)
			throws Exception {
		super.load(categorizerDataContext);
		DataContext catSpecific = categorizerDataContext.getNode(categorizerSpecificTag); 
		priors = catSpecific.getNode(priorsTag);
		
		Vector tempVector = catSpecific.getElements2(classIndexTag);
		if(tempVector != null && tempVector.size() > 0)
		{
			for(int i=0; i<dataSet.getDataHeaders().length; i++)
			{
				if(dataSet.getDataHeaders()[i].getLabel().equals((String) tempVector.get(0)))
				{
					classIndex = i;
					break;
				}
			}
		}
		valid = true;
	}

	
	/* (non-Javadoc)
	 * @see categorizer.core.Categorizer#store()
	 */
	public DataContext store() throws Exception {
		if(!valid)
			throw new CategorizerNotValidException();
		
		DataContext dataContext = super.store();
		DataContext catSpecific = new DataContext();
		catSpecific.add(priorsTag, priors);
		catSpecific.add(new NodePair(classIndexTag, dataSet.getDataHeaders()[classIndex].getLabel()));
		dataContext.add(categorizerSpecificTag, catSpecific);
		return dataContext;
	}

	
	
}
