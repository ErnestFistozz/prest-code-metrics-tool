/**
 * 
 */
package categorizer.test;

import org.jfree.ui.RefineryUtilities;

import categorizer.core.Chart;
import categorizer.core.DataSet;
import categorizer.core.util.Arff2DataSet;

/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class ChartTest extends Thread{

	
	private final static String dataSetFileName = "C:/Prest/Test/iris.arff";
	
	
	
	public ChartTest(int index){
		try{
			
			Arff2DataSet converter = new Arff2DataSet(dataSetFileName);
			DataSet dataSet = converter.reader();
			
			Chart chart = new Chart(dataSet,index);
			chart.createChartPanel();
			chart.pack();
		    RefineryUtilities.centerFrameOnScreen(chart);
		    chart.setVisible(true);
			
		}catch(Exception e){
			System.out.println("Failed");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
			
		try
		{
			
			(new ChartTest(0)).start();
			(new ChartTest(4)).start();

		        
		}catch(Exception e){
			System.out.println("Failed");
			e.printStackTrace();
		}
		
		
	}


	@Override
	public void run() {
		
		
	}

}
