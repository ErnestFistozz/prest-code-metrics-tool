/**
 * 
 */
package categorizer.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.HistogramDataset;

/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class Chart extends JFrame{

	private DataSet dataSet;
	
	private int index = 0;
	/**
	 * default constructor
	 */
	public Chart() {
		super("Chart");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dataSet
	 * @param index
	 */
	public Chart(DataSet dataSet, int index)
	{
		super("Chart");
		this.dataSet = dataSet;
		this.index = index;
	}
	
	
	/**
	 * @return the dataSet
	 */
	public DataSet getDataSet() {
		return dataSet;
	}

	/**
	 * @param dataSet the dataSet to set
	 */
	public void setDataSet(DataSet dataSet) {
		this.dataSet = dataSet;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Creates a JFreeChart with the given attribute of the dataSet
	 * @return
	 */
	public JFreeChart createChart()
	{
		if(this.dataSet.getDataHeaders()[index].isNominal())
		{
			String[] availableValues =this.dataSet.getDataHeaders()[index].getAvailableValue();
			
			HashMap countMap = new HashMap();
			
			for(int i=0; i<availableValues.length; i++)
				countMap.put(availableValues[i],0);
			
			
			for(int i=0; i<this.dataSet.getDataItems().length; i++)
			{
				int count = (Integer)countMap.get(this.dataSet.getDataItems()[i].getDataFields()[index].getStringValue());
				count++;
				countMap.put(this.dataSet.getDataItems()[i].getDataFields()[index].getStringValue(), count);
			}
				
			DefaultCategoryDataset chartDataSet = new DefaultCategoryDataset();

			Set keySet = countMap.keySet();
			Iterator iterator = keySet.iterator();
			
			while(iterator.hasNext())
			{
				String classValue = (String)iterator.next();
				chartDataSet.addValue((Integer)countMap.get(classValue), dataSet.getDataHeaders()[index].getLabel(), classValue);
			}
			 
			JFreeChart chart = ChartFactory.createBarChart(
					 dataSet.getDataHeaders()[index].getLabel(), 
		             null, 
		             "Frequency", 
		             chartDataSet, 
		             PlotOrientation.VERTICAL, 
		             true, 
		             false, 
		             false
		     );
		     
		     return chart;
		}
		else
		{
			double[] dataArray = new double[dataSet.getDataItems().length];
			for(int i=0; i<dataSet.getDataItems().length; i++)
				dataArray[i] = Double.parseDouble(dataSet.getDataItems()[i].getDataFields()[index].getStringValue());
			
			 HistogramDataset dataset = new HistogramDataset();
		     dataset.addSeries(dataSet.getDataHeaders()[index].getLabel(), dataArray, 8);
			
		     JFreeChart chart = ChartFactory.createHistogram(
		             dataSet.getDataHeaders()[index].getLabel(), 
		             dataSet.getDataHeaders()[index].getLabel(), 
		             "Frequency", 
		             dataset, 
		             PlotOrientation.VERTICAL, 
		             true, 
		             false, 
		             false
		         );
		     
		     return chart;
		}
	}
	
	/**
	 * Creates a chart with the given attribute of the dataSet and creates an Application Frame out of that chart 
	 */
	public void createChartPanel()
	{
		JFreeChart chart = createChart();
		ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(480, 320));
        setContentPane(chartPanel);
	}
	
}
