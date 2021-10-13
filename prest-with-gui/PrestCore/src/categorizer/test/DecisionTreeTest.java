package categorizer.test;

import common.DataContext;

import categorizer.API.CategorizerAPI;
import categorizer.aiCategorizer.decisionTree.DecisionTree;
import categorizer.core.APIDefinition;
import categorizer.core.Categorizer;
import categorizer.core.CategorizerExecutor;
import categorizer.core.DataSet;
import categorizer.core.Option;
import categorizer.core.util.Arff2DataSet;

public class DecisionTreeTest {
	

		private final static String dataSetFileName = "C:/Prest/Test/pc5.arff";
	//	private final static String testSetFileName = "C:/Prest/Test/segment-test2.arff";
		private final static String dataSetWriteFileName = "C:/Prest/Test/pc5.xml";
		private final static String decisionTreeFileName = "C:/Prest/Test/DTCategorizer";
		
		private final static String categorizerLabel = "categorizer";
		

		
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			try{
				Arff2DataSet converter = new Arff2DataSet(dataSetFileName);
				DataSet dataSet = converter.reader();
				
	//			Arff2DataSet converter2 = new Arff2DataSet(testSetFileName);
	//			DataSet testSet = converter2.reader();
				
				DataContext dataContext = new DataContext();
				dataContext.add(categorizerLabel,dataSet.store());
				dataContext.writeToFile(dataSetWriteFileName);
				
				CategorizerExecutor catEx = new CategorizerExecutor();
				catEx.setcategorizerClassName(DecisionTree.class.getName());
				
				catEx.loadDataSet(dataSet);
			//	catEx.setTestSet(testSet);
			//	catEx.instanceValidate();
				catEx.portionValidate(createOptions());
				
				for(int i=0; i<catEx.getCategorizers().size(); i++)
				{
					System.out.println(((Categorizer)catEx.getCategorizers().get(i)).getConfusionMatrix().toString());
					((Categorizer)catEx.getCategorizers().get(i)).setTitle(categorizerLabel + i);
					DataContext categorizerContext = new DataContext();
					categorizerContext.add(categorizerLabel,((Categorizer)catEx.getCategorizers().get(i)).store());
					categorizerContext.writeToFile(decisionTreeFileName + i + ".xml");
				}
				
				DataContext dtContext = new DataContext();
				dtContext = dtContext.readFromFile(decisionTreeFileName + 0 + ".xml");
				DecisionTree decisionTree = new DecisionTree();
				decisionTree.load(dtContext.getNode(categorizerLabel));
				
			}catch(Exception e){
				e.printStackTrace();
			}
				
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

