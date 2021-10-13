package categorizer.test;

import java.util.HashMap;

import categorizer.aiCategorizer.core.ConfusionMatrix;
import categorizer.core.Precision;
import categorizer.core.Recall;

/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class PerfMetricTest {

//	private static Accuracy accuracyMetric;
//	private static Recall recallMetric;
	private static Precision precisionMetric;
	
	private static ConfusionMatrix confMatrix;
	
//	private static DataContext matrixDataContext;
	
	public static void main(String []args){
		
		String []labels = {"yes", "no"};
		
		confMatrix = new ConfusionMatrix(labels);
		
		confMatrix.increment("yes", "yes");
		confMatrix.increment("yes", "yes");
		confMatrix.increment("yes", "yes");
		confMatrix.increment("yes", "yes");
		confMatrix.increment("yes", "no");
		
		confMatrix.increment("no", "no");
		confMatrix.increment("no", "no");
		confMatrix.increment("no", "yes");
		confMatrix.increment("no", "yes");
		confMatrix.increment("no", "yes");
		
		String confMatrixFileName = "C:/Prest/Test/PerfMetricTest.xml";
		
		confMatrix.store().writeToFile(confMatrixFileName);
		
		precisionMetric = new Precision(confMatrix);
		
		double recall = precisionMetric.calculatePrecisions();
		
		System.out.println("recall: " + precisionMetric.getMetricValue());
		
		HashMap recalls = precisionMetric.getPrecisions();
		
		for(int i=0; i<labels.length; i++)
			System.out.println("precision for " + labels[i] + ": " + recalls.get(labels[i]));
		
	}
}
