package categorizer.test;

import java.io.IOException;

import categorizer.core.CategorizerDefinition;
import categorizer.core.OptionDefinition;
import categorizer.core.UnsupportedDataContextException;

import common.DataContext;

/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class NaiveBayesCatDefTest {
	
	private final static String defFile = "C:/Prest/Test/CategorizerDefinition.xml";
	
	private final static String defFile2 = "C:/Prest/Test/CategorizerDefinition2.xml";

	private final static String categorizerTag = "categorizer";
	
	private static CategorizerDefinition catDef;

	public static void main(String[] args) {
		
		createAndStore(defFile);
		
		CategorizerDefinition catDef2 = load(defFile);
		
		DataContext dataContext = new DataContext();
		dataContext.add(categorizerTag, catDef2.store());
		
		dataContext.writeToFile(defFile2);
	}
	
	public static void createAndStore(String fileName){
		
		catDef = new CategorizerDefinition();
		
		catDef.setLabel("NaiveBayesCategorizerDef");
		catDef.setClassName("categorizer.aiCategorizer.naiveBayes.NaiveBayes");
		catDef.setDescription("Naive Bayes Categorizer Definition");
		
	//	catDef.setOptionDefinitions(new OptionDefinition[0]);
	
		DataContext dataContext = new DataContext();
	
		dataContext.add(categorizerTag, catDef.store());
	
		dataContext.writeToFile(fileName);

	}
	
	public static CategorizerDefinition load(String fileName){
		
		DataContext dataContext = new DataContext();
		try {
			dataContext = dataContext.readFromFile(fileName); 
		//	dataContext.writeToFile(defFile2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CategorizerDefinition catDef_loaded = new CategorizerDefinition();
		
		try {
			catDef_loaded.load(dataContext.getNode(categorizerTag));
		} catch (UnsupportedDataContextException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return catDef_loaded;
	}
}
