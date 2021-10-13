/**
 * 
 */
package categorizer.API;

import java.util.Vector;

import categorizer.aiCategorizer.decisionTree.DecisionTree;
import categorizer.aiCategorizer.naiveBayes.NaiveBayes;
import categorizer.core.CategorizerDefinition;
import categorizer.core.OptionDefinition;

import common.DataContext;

public class CategorizerAPI {

	
	
	private final static String categorizerDefinitionTag = "categorizerDefinition";
	private final static String categorizerDefinitionFileName = "./CategorizerDefinitions.xml";
	
	
	public static CategorizerDefinition[] readDefinitions() throws Exception
	{
		CategorizerDefinition[] categorizerDefinitions = null;
		DataContext dataContext = new DataContext();
		dataContext = dataContext.readFromFile(categorizerDefinitionFileName);
		
		if(dataContext != null)
		{
			Vector definitionVector = dataContext.getNodes(categorizerDefinitionTag);
			
			if(definitionVector != null && definitionVector.size() > 0)
			{
				categorizerDefinitions = new CategorizerDefinition[definitionVector.size()];
				for(int i=0; i<definitionVector.size(); i++)
				{
					DataContext definitionContext = (DataContext) definitionVector.get(i);
					CategorizerDefinition catDef = new CategorizerDefinition();
					catDef.load(definitionContext);
					
					categorizerDefinitions[i] = catDef;
				}
			}
		}
		
		return categorizerDefinitions;
	}
	
	public static CategorizerDefinition[] readDefinitions(String fileName) throws Exception
	{
		CategorizerDefinition[] categorizerDefinitions = null;
		DataContext dataContext = new DataContext();
		dataContext = dataContext.readFromFile(fileName);
		
		if(dataContext != null)
		{
			Vector definitionVector = dataContext.getNodes(categorizerDefinitionTag);
			
			if(definitionVector != null && definitionVector.size() > 0)
			{
				categorizerDefinitions = new CategorizerDefinition[definitionVector.size()];
				for(int i=0; i<definitionVector.size(); i++)
				{
					DataContext definitionContext = (DataContext) definitionVector.get(i);
					CategorizerDefinition catDef = new CategorizerDefinition();
					catDef.load(definitionContext);
					
					categorizerDefinitions[i] = catDef;
				}
			}
		}
		
		return categorizerDefinitions;
	}
	
	public static void main(String[] args) {
		
		try{
			CategorizerDefinition naiveBayesDefinition = new CategorizerDefinition();
			
			naiveBayesDefinition.setLabel("Naive Bayes");
			naiveBayesDefinition.setDescription("Uses naive bayes algorithm for learning.");
			naiveBayesDefinition.setClassName(NaiveBayes.class.getName());
			
			CategorizerDefinition decisionTreeDefinition = new CategorizerDefinition();
			
			decisionTreeDefinition.setLabel("Decision Tree");
			decisionTreeDefinition.setDescription("Uses C4.5 decision tree algorithm" +
													" for learning. Supports numeric attributes. " +
													"Based on simple entropy calculation." );
			
			decisionTreeDefinition.setClassName(DecisionTree.class.getName());
			
			OptionDefinition[] optionDefinitions = new OptionDefinition[1];
			
			optionDefinitions[0] = new OptionDefinition();
			optionDefinitions[0].setLabel("Class Percentage");
			optionDefinitions[0].setDescription("Indicates the accuracy of the tree");
			optionDefinitions[0].setNominal(false);
			optionDefinitions[0].setMinValue(50);
			optionDefinitions[0].setMaxValue(100);
			
			decisionTreeDefinition.setOptionDefinitions(optionDefinitions);
			
			DataContext dataContext = new DataContext();
			dataContext.add(categorizerDefinitionTag,naiveBayesDefinition.store());
			dataContext.add(categorizerDefinitionTag,decisionTreeDefinition.store());
			
			dataContext.writeToFile(categorizerDefinitionFileName);
			
			System.out.println("Wrote to File");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		try {
			CategorizerDefinition[] catDefs = readDefinitions();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
