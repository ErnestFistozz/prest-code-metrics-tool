/**
 * 
 */
package categorizer.test;

import categorizer.aiCategorizer.core.ConfusionMatrix;
import categorizer.core.DataHeader;
import categorizer.core.DataSet;
import categorizer.core.Operand;
import categorizer.core.Threshold;
import categorizer.core.ThresholdOperator;
import categorizer.core.util.Arff2DataSet;
import categorizer.staticCategorizer.StaticCategorizer;

import common.DataContext;

/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class StaticCategorizerTest {


	private final static String confMatFileName = "C:/Prest/Test/VirtualMetricConfusionMatrix.xml";
	private final static String virtualMetricCategorizerFileName = "C:/Prest/Test/VirtualMetricCategorizer.xml";

	
	private final static String dataSetFileName = "C:/Prest/Test/iris.arff";
	private final static String testFileName = "C:/Prest/Test/iris2.arff";
	private final static String classifierFileName = "C:/Prest/Test/iris3.arff";
	private final static String dataSetWriteFileName = "C:/Prest/Test/iris.xml";
	private final static String testWriteFileName = "C:/Prest/Test/iris2.xml";
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


		try
		{
			
			Arff2DataSet converter = new Arff2DataSet(dataSetFileName);
			DataSet dataSet = converter.reader();
			
			
			dataSet.setClassIndex(dataSet.getDataHeaders().length - 1);
	
			Arff2DataSet converter2 = new Arff2DataSet(testFileName);
			DataSet testSet = converter2.reader();
			
			
			testSet.setClassIndex(testSet.getDataHeaders().length - 1);
			
						
			StaticCategorizer staticCategorizer = new StaticCategorizer();
			
			
			//////////////////////////////////////////////////////////////////////////////////////////////////////
			
			DataHeader dataHeader = dataSet.getDataHeaders()[2];
			
			Threshold threshold = new Threshold();
			
			threshold.setOperator(ThresholdOperator.LT);
			threshold.setDataHeader(dataSet.getDataHeaders()[2]);
			threshold.setClassValue(dataSet.getDataHeaders()[dataSet.getClassIndex()].getAvailableValue()[0]);
			
			Operand[] operand = new Operand[1];
			operand[0] = new Operand(false,2.0);
			
			threshold.setOperands(operand);
			
			
			Threshold threshold4 = new Threshold();
			
			threshold4.setOperator(ThresholdOperator.EQU);
			threshold4.setDataHeader(dataSet.getDataHeaders()[2]);
			threshold4.setClassValue(dataSet.getDataHeaders()[dataSet.getClassIndex()].getAvailableValue()[1]);

			operand = new Operand[1];
			operand[0] = new Operand(true,dataSet.getDataHeaders()[2]);
			
			threshold4.setOperands(operand);
			
			Threshold[] thresholdArr1 = new Threshold[2];
			thresholdArr1[0] = threshold;
			thresholdArr1[1] = threshold4;
			
			dataHeader.setThresholds(thresholdArr1);
			
			
			//////////////////////////////////////////////////////////////////////////////////////////////////////
			
			DataHeader dataHeader2 = dataSet.getDataHeaders()[3];
			
			Threshold threshold2 = new Threshold();
			
			threshold2.setOperator(ThresholdOperator.LTE);
			threshold2.setDataHeader(dataSet.getDataHeaders()[3]);
			threshold2.setClassValue(dataSet.getDataHeaders()[dataSet.getClassIndex()].getAvailableValue()[1]);
			
			operand = new Operand[1];
			operand[0] = new Operand(false,1.8);
			
			threshold2.setOperands(operand);
			
			
			Threshold threshold3 = new Threshold();
			
			threshold3.setOperator(ThresholdOperator.GTE);
			threshold3.setDataHeader(dataSet.getDataHeaders()[3]);
			threshold3.setClassValue(dataSet.getDataHeaders()[dataSet.getClassIndex()].getAvailableValue()[1]);
			
			operand = new Operand[1];
			operand[0] = new Operand(false,1.0);
			
			threshold3.setOperands(operand);
			
			Threshold[] thresholdArr2 = new Threshold[2];
			thresholdArr2[0] = threshold2;
			thresholdArr2[1] = threshold3;
			
			dataHeader2.setThresholds(thresholdArr2);
			
			//////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
			staticCategorizer.setDataSet(dataSet);
			
			staticCategorizer.setTestSet(testSet);
			
			ConfusionMatrix confusionMatrix = staticCategorizer.buildCategorizer();
			
			DataContext confDataContext = new DataContext();
			confDataContext.add(confusionMatrixTag,confusionMatrix.store());
			
			confDataContext.writeToFile(confMatFileName);
			
			
		}catch(Exception e){
			System.out.println("Failed");
			e.printStackTrace();
		}
		
		
	}

}
