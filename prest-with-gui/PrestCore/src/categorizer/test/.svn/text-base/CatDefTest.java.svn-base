/**
 * 
 */
package categorizer.test;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Vector;

import categorizer.aiCategorizer.core.ConfusionMatrix;
import categorizer.core.Categorizer;
import categorizer.core.CategorizerDefinition;
import categorizer.core.CategorizerExecutor;
import categorizer.core.DataItem;
import categorizer.core.DataSet;
import categorizer.core.Option;
import categorizer.core.OptionDefinition;
import categorizer.core.UnsupportedDataContextException;
import categorizer.core.util.Arff2DataSet;

import common.DataContext;

/**
 * A test class to test categorizer.core.CategorizerDefinition Class
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class CatDefTest {

	
	private final static String fileName = "C:/Prest/Test/CategorizerDefinition.xml";
	private final static String fileName2 = "C:/Prest/Test/CategorizerDefinition2.xml";
	private final static String fileName3 = "C:/Prest/Test/CategorizerDefinition3.xml";
	private final static String collMatFileName = "C:/Prest/Test/CatDefCollisionMatrix.xml";
	private final static String categorizerFileName = "C:/Prest/Test/Categorizer.xml";
	private final static String loadedCategorizerFileName = "C:/Prest/Test/LoadedCategorizer.xml";

/*
	private final static String dataSetFileName = "C:/Prest/Test/iris.arff";
//	private final static String testFileName = "C:/Prest/Test/iris2.arff";
	private final static String classifierFileName = "C:/Prest/Test/iris3.arff";
	private final static String dataSetWriteFileName = "C:/Prest/Test/iris.xml";
	private final static String testSetWriteFileName = "C:/Prest/Test/iris2.xml";
	private final static String classifierSetWriteFileName = "C:/Prest/Test/iris3.xml";
*/	
	
/*	
	private final static String dataSetFileName = "C:/Prest/Test/weather.arff";
//	private final static String testFileName = "C:/Prest/Test/weather2.arff";
	private final static String dataSetWriteFileName = "C:/Prest/Test/weather.xml";
	private final static String testSetWriteFileName = "C:/Prest/Test/weather2.xml";
	private final static String classifierFileName = "C:/Prest/Test/weather3.arff";
	private final static String classifierSetWriteFileName = "C:/Prest/Test/weather3.xml";
*/
	
	private final static String dataSetFileName = "C:/Prest/Test/pc5.arff";
//	private final static String testFileName = "C:/Prest/Test/weather2.arff";
	private final static String dataSetWriteFileName = "C:/Prest/Test/pc5.xml";
	private final static String testSetWriteFileName = "C:/Prest/Test/pc52.xml";
//	private final static String classifierFileName = "C:/Prest/Test/weather3.arff";
	private final static String classifierSetWriteFileName = "C:/Prest/Test/pc53.xml";
	
	
	
/*	
	private final static String dataSetFileName = "C:/Prest/Test/segment-test.arff";
//	private final static String testFileName = "C:/Prest/Test/iris2.arff";
	private final static String classifierFileName = "C:/Prest/Test/segment-test3.arff";
	private final static String dataSetWriteFileName = "C:/Prest/Test/segment-test.xml";
	private final static String testSetWriteFileName = "C:/Prest/Test/segment-test2.xml";
	private final static String classifierSetWriteFileName = "C:/Prest/Test/segment-test3.xml";
*/

	
	private final static String categorizerTitle = "TestCategorizer";
	private final static String categorizerTag = "categorizer";
	private final static String dataSetTag = "dataSet" ;
	private final static String classNameTag = "className" ;

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		createAndStore(fileName);
		
		CategorizerDefinition catDef = load(fileName);
		
		Option[] options = createOptions();
		
		try
		{
			CategorizerExecutor categorizerExec = catDef.createInstance();
			// DataSet is loaded and written in xml form for comparison
			Arff2DataSet converter = new Arff2DataSet(dataSetFileName);
			DataSet dataSet = converter.reader();
			categorizerExec.setDataSet(dataSet);
			
			categorizerExec.setOptions(options);
			DataContext dataContext = new DataContext();
			dataContext.add(dataSetTag,categorizerExec.getTrainDataSet().store());
			dataContext.writeToFile(dataSetWriteFileName);
						
			DataContext testDataContext = new DataContext();
			testDataContext.add(dataSetTag,categorizerExec.getTestSet().store());
			testDataContext.writeToFile(testSetWriteFileName);
			
			
			// Categorizer is built and the resulting collisionMatrix is written to file
			ConfusionMatrix collMatrix = categorizerExec.portionValidate(options);
			collMatrix.store().writeToFile(collMatFileName);
			
			// Categorizer Instance is stored into the file
			( (Categorizer) (categorizerExec.getCategorizers().get(categorizerExec.getCategorizers().size()-1)) ).setTitle(categorizerTitle);
			DataContext categorizerContext = new DataContext();
			if(!( (Categorizer) (categorizerExec.getCategorizers().get(categorizerExec.getCategorizers().size()-1)) ).isValid())
				( (Categorizer) (categorizerExec.getCategorizers().get(categorizerExec.getCategorizers().size()-1)) ).setValid(true);
			categorizerContext.add( categorizerTag, ( (Categorizer) (categorizerExec.getCategorizers().get(categorizerExec.getCategorizers().size()-1)) ).store() );
			categorizerContext.writeToFile(categorizerFileName);
			
			
			// Categorizer Instance is loaded from the file
			categorizerContext = DataContext.readFromFile(categorizerFileName);
			
			categorizerContext = categorizerContext.getNode(categorizerTag);
			
			if(categorizerContext == null)
				throw new UnsupportedDataContextException();
			
			Vector tempVector = categorizerContext.getElements2(classNameTag);
			
			if(tempVector == null || tempVector.size() <= 0)
				throw new UnsupportedDataContextException();
			
			String className = (String)tempVector.get(0);
			
			Class classCategorizer = Class.forName(className);
			Constructor constructor = classCategorizer.getDeclaredConstructor(null);

			Categorizer loadedCategorizer = (Categorizer) constructor.newInstance(null); 
			
			loadedCategorizer.load(categorizerContext);
			loadedCategorizer.setValid(true);
			
			categorizerContext = new DataContext();
			categorizerContext.add(categorizerTag,loadedCategorizer.store());
			categorizerContext.writeToFile(loadedCategorizerFileName);
			
			// Loaded categorizer will be test
/*			Arff2DataSet classifyConverter = new Arff2DataSet(classifierFileName);
			DataSet classifierSet = classifyConverter.reader();
			
			DataContext classifierDataContext = new DataContext();
			classifierDataContext.add(dataSetTag,classifierSet.store());
			classifierDataContext.writeToFile(classifierSetWriteFileName);
			
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println();
			DataItem toTest = classifierSet.getDataItems()[0];
			toTest = ( (Categorizer) (categorizerExec.getCategorizers().get(categorizerExec.getCategorizers().size()-1)) ).categorize(toTest);
			
			System.out.println("Loaded and a new dataItem is classified");
			System.out.println(toTest.getDataFields()[toTest.getDataFields().length -1].getStringValue());			
	*/		
			
		}catch(Exception e){
			System.out.println("Failed");
			e.printStackTrace();
		}
		
		
	}
	
	private static void createAndStore(String fileName)
	{

		CategorizerDefinition catDef = new CategorizerDefinition();
		
		catDef.setLabel("testCategorizer");
		catDef.setClassName("categorizer.aiCategorizer.naiveBayes.NaiveBayes");
		catDef.setDescription("A test categorizer to create");
		
		OptionDefinition[] optDefs = new OptionDefinition[4];
		
		OptionDefinition oneOptDef = new OptionDefinition();
		
		oneOptDef.setLabel("One Nominal Option");
		oneOptDef.setDescription("A test nominal option");
		oneOptDef.setNominal(true);
		
		String[] availVals = new String[3];
		availVals[0] = new String("a");
		availVals[1] = new String("b");
		availVals[2] = new String("c");
		oneOptDef.setAvailableValues(availVals);
		
		optDefs[0] = oneOptDef;
		
		oneOptDef = new OptionDefinition();
		
		oneOptDef.setLabel("One Numeric Option");
		oneOptDef.setDescription("A test numeric option");
		oneOptDef.setNominal(false);
		oneOptDef.setMinValue(0);
		oneOptDef.setMaxValue(100);

		optDefs[1] = oneOptDef;

		oneOptDef = new OptionDefinition();

		oneOptDef.setLabel("Sampling");
		oneOptDef.setDescription("Option to set sampling type");
		oneOptDef.setNominal(true);

		String[] availVals_2 = new String[2];
		availVals_2[0] = new String("equalDistribution");
		availVals_2[1] = new String("randomDistribution");
		oneOptDef.setAvailableValues(availVals_2);
		
		optDefs[2] = oneOptDef;

		oneOptDef = new OptionDefinition();
		
		oneOptDef.setLabel("TrainDataPercentage");
		oneOptDef.setDescription("Option indicating percentage of train data");
		oneOptDef.setNominal(false);
		oneOptDef.setMinValue(0.6);
		oneOptDef.setMaxValue(0.9);

		optDefs[3] = oneOptDef;

		catDef.setOptionDefinitions(optDefs) ;
		
		DataContext dataContext = new DataContext();
		
		dataContext.add(categorizerTag, catDef.store());
		
		dataContext.writeToFile(fileName);
	}
	
	
	/**
	 * @param fileName
	 * @return
	 */
	private static CategorizerDefinition load(String fileName)
	{
		DataContext dataContext = new DataContext();
		try {
			dataContext = DataContext.readFromFile(fileName); 
			dataContext.writeToFile(fileName2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CategorizerDefinition catDef = new CategorizerDefinition();
		
		try {
			catDef.load(dataContext.getNode(categorizerTag));
		} catch (UnsupportedDataContextException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return catDef;
	}
	
	public static Option[] createOptions(){
		
		Option [] options = new Option[2];
		
		options[0] = new Option();
		
		options[0].setLabel("Sampling");
		
		options[0].setValue("equalDistribution");
		
		options[1] = new Option();
		
		options[1].setLabel("TrainDataPercentage");
		
		options[1].setValue("0.8");
		
		return options;
	}

}
