/**
 * 
 */
package categorizer.test;

import common.DataContext;

import categorizer.aiCategorizer.naiveBayes.NaiveBayes;
import categorizer.core.Categorizer;
import categorizer.core.CategorizerExecutor;
import categorizer.core.DataSet;
import categorizer.core.util.Arff2DataSet;

/**
 * @author TCOBOZCAN
 *
 */
public class CategorizerExecutorTest {

	/**
	 * @param args
	 */
	
	private final static String dataSetFileName = "C:/Prest/Test/iris.arff";
	private final static String testSetFileName = "C:/Prest/Test/iris2.arff";
	private final static String testSetWriteFileName = "C:/Prest/Test/iris.xml";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			Arff2DataSet converter = new Arff2DataSet(dataSetFileName);
			DataSet dataSet = converter.reader();
			
			
			/*Arff2DataSet converter2 = new Arff2DataSet(testSetFileName);
			DataSet testSet = converter2.reader();
			
			DataContext setContext = new DataContext();
			setContext.add("dataSet", testSet.store());
			setContext.writeToFile(testSetWriteFileName);
			*/
			
			CategorizerExecutor catEx = new CategorizerExecutor();
			catEx.setcategorizerClassName(NaiveBayes.class.getName());
			
			catEx.loadDataSet(dataSet);
			catEx.crossValidate(5);
			//catEx.setTestSet(testSet);
			
			//catEx.instanceValidate();
			
			for(int i=0; i<catEx.getCategorizers().size(); i++)
			{
				System.out.println(((Categorizer)catEx.getCategorizers().get(i)).getConfusionMatrix().toString());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
			
	}

}
