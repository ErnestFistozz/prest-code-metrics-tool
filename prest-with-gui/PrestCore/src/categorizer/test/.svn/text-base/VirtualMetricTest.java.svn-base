/**
 * 
 */
package categorizer.test;

import categorizer.aiCategorizer.naiveBayes.NaiveBayes;
import categorizer.core.DataItem;
import categorizer.core.DataSet;
import categorizer.core.MetricOperator;
import categorizer.core.Operand;
import categorizer.core.VirtualMetric;
import categorizer.core.util.Arff2DataSet;

import common.DataContext;

/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class VirtualMetricTest {


	private final static String confMatFileName = "C:/Prest/Test/VirtualMetricConfusionMatrix.xml";
	private final static String virtualMetricCategorizerFileName = "C:/Prest/Test/VirtualMetricCategorizer.xml";
	private final static String virtualMetricCategorizerFileName2 = "C:/Prest/Test/VirtualMetricCategorizer2.xml";

	
	private final static String dataSetFileName = "C:/Prest/Test/iris.arff";
	private final static String testFileName = "C:/Prest/Test/iris2.arff";
	private final static String instanceFileName = "C:/Prest/Test/iris3.arff";
	private final static String classifierFileName = "C:/Prest/Test/iris3.arff";
	private final static String dataSetWriteFileName = "C:/Prest/Test/iris.xml";
	private final static String testWriteFileName = "C:/Prest/Test/iris2.xml";
	private final static String instanceWriteFileName = "C:/Prest/Test/iris_dataItem.xml";
	private final static String classifierWriteFileName = "C:/Prest/Test/iris3.xml";
	
	
	/*
	private final static String dataSetFileName = "C:/Prest/Test/weather.arff";
	private final static String testFileName = "C:/Prest/Test/weather2.arff";
	private final static String dataSetWriteFileName = "C:/Prest/Test/weather.xml";
	*/
	
	
//	private final static String dataSetFileName = "C:/Prest/Test/segment-test.arff";
//	private final static String testFileName = "C:/Prest/Test/segment-test2.arff";
//	private final static String classifierFileName = "C:/Prest/Test/segment-test3.arff";
//	private final static String dataSetWriteFileName = "C:/Prest/Test/segment-test.xml";
//	private final static String testWriteFileName = "C:/Prest/Test/segment-test2.xml";
//	private final static String classifierWriteFileName = "C:/Prest/Test/segment-test3.xml";
	

	
	private final static String categorizerTitle = "TestCategorizer";
	private final static String categorizerTag = "categorizer";
	private final static String dataSetTag = "dataSet" ;
	private final static String classNameTag = "className" ;
	private final static String confusionMatrixTag = "confusionMatrix" ;

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		try
		{
			
			Arff2DataSet converter = new Arff2DataSet(dataSetFileName);
			DataSet dataSet = converter.reader();
			
			
			dataSet.setClassIndex(dataSet.getDataHeaders().length - 1);
	
			Arff2DataSet converter2 = new Arff2DataSet(testFileName);
			DataSet testSet = converter2.reader();
			
			
			testSet.setClassIndex(testSet.getDataHeaders().length - 1);
			
			Operand[] operands = new Operand[2];
			operands[0] = new Operand(true,dataSet.getDataHeaders()[0].getLabel());
			operands[1] = new Operand(true,dataSet.getDataHeaders()[1].getLabel());
			
			VirtualMetric virtualMetric1 = new VirtualMetric(MetricOperator.MUL,"SepalArea",operands);
			

			operands = new Operand[2];
			operands[0] = new Operand(true,dataSet.getDataHeaders()[2].getLabel());
			operands[1] = new Operand(true,dataSet.getDataHeaders()[3].getLabel());
			VirtualMetric virtualMetric2 = new VirtualMetric(MetricOperator.MUL,"PetalArea",operands);
			
			
			VirtualMetric[] virtualMetrics = new VirtualMetric[2];
			virtualMetrics[0] = virtualMetric1;
			virtualMetrics[1] = virtualMetric2;
			
			dataSet = virtualMetric1.modifySet(dataSet);
			testSet = virtualMetric1.modifySet(testSet);
			
			dataSet.setVirtualHeaders(virtualMetrics);
			testSet.setVirtualHeaders(virtualMetrics);
			
			dataSet = virtualMetric2.modifySet(dataSet);
			testSet = virtualMetric2.modifySet(testSet);
			
			for(int i=0;i<dataSet.getDataItems().length; i++)
			{
				dataSet.getDataItems()[i].setVirtualHeaders(virtualMetrics);
			}
			
			for(int i=0;i<testSet.getDataItems().length; i++)
			{
				testSet.getDataItems()[i].setVirtualHeaders(virtualMetrics);
			}
			
			DataContext dataSetContext = new DataContext();
			dataSetContext.add(dataSetTag, dataSet.store());
			dataSetContext.writeToFile(dataSetWriteFileName);
			
			DataContext testSetContext = new DataContext();
			testSetContext.add(dataSetTag, testSet.store());
			testSetContext.writeToFile(testWriteFileName);
			
			
			NaiveBayes naiveBayes = new NaiveBayes();
			
			naiveBayes.setDataSet(dataSet);
			naiveBayes.setTestSet(testSet);
			
			naiveBayes.buildCategorizer();
			
			DataContext confusionMatrix = new DataContext();
			confusionMatrix.add(confusionMatrixTag,naiveBayes.getConfusionMatrix().store());
			confusionMatrix.writeToFile(confMatFileName);
			
			naiveBayes.setTitle("Virtual Deneme");
			
			DataContext bayesContext = new DataContext();
			bayesContext.add(categorizerTag, naiveBayes.store());
			bayesContext.writeToFile(virtualMetricCategorizerFileName);
			
			DataContext bayesContext2 = new DataContext();
			bayesContext2 = bayesContext2.readFromFile(virtualMetricCategorizerFileName);
			NaiveBayes naiveBayes2 = new NaiveBayes();
			naiveBayes2.load(bayesContext2.getNode(categorizerTag));
			
			DataContext bayesContext3 = new DataContext();
			bayesContext3.add(categorizerTag,naiveBayes2.store());
			bayesContext3.writeToFile(virtualMetricCategorizerFileName2);
			
			
			Arff2DataSet converter3 = new Arff2DataSet(instanceFileName);
			DataSet instanceDataSet = converter3.reader();
			
			DataItem instanceItem = instanceDataSet.getDataItems()[0];
			
			instanceItem = naiveBayes2.categorize(instanceItem);
			
			instanceDataSet.getDataItems()[0]= instanceItem;
			
			DataContext instanceContext = new DataContext();
			instanceContext.add(categorizerTag, instanceDataSet.store());
			instanceContext.writeToFile(instanceWriteFileName);
			
		}catch(Exception e){
			System.out.println("Failed");
			e.printStackTrace();
		}
		
		
	}

}
