/**
 * 
 */
package categorizer.core;

import categorizer.aiCategorizer.core.ConfusionMatrix;

import common.DataContext;
import common.NodePair;

/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class PerformanceMetric implements ContextBuilder{

	/**
	 * Name of the current class
	 */
	protected final static String className = "categorizer.core.PerformanceMetric";
	
	/**
	 * Holds the confusionMatrix where the performance metric will be derived from
	 */
	protected ConfusionMatrix confusionMatrix;
	
	/**
	 * Holds the value of the performance metric
	 */
	protected Object metricValue;
	
	/**
	 * Holds the label of the PerformanceMetric
	 */
	protected final String title = "defaultPerformanceMetric";
	
	
	/**
	 * label of the title tag
	 */
	private final static String titleTag = "title" ;
	
	/**
	 * label of the value tag
	 */
	private final static String valueTag = "value" ;
	
	/**
	 * default constructor
	 */
	public PerformanceMetric() {
	}
	
	/**
	 * @param confusionMatrix
	 */
	public PerformanceMetric(ConfusionMatrix confusionMatrix){
		
		this.confusionMatrix = confusionMatrix;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}


	/**
	 * @return the confusionMatrix
	 */
	public ConfusionMatrix getConfusionMatrix() {
		return confusionMatrix;
	}

	/**
	 * @param confusionMatrix the confusionMatrix to set
	 */
	public void setConfusionMatrix(ConfusionMatrix confusionMatrix) {
		this.confusionMatrix = confusionMatrix;
	}

	/**
	 * @return the metricValue
	 */
	public Object getMetricValue() {
		return metricValue;
	}

	/**
	 * @param metricValue the metricValue to set
	 */
	public void setMetricValue(Object metricValue) {
		this.metricValue = metricValue;
	}

	/**
	 * Calculates the value of the performance metric
	 */
	public void calculateMetric()
	{
		
	}

	/* (non-Javadoc)
	 * @see categorizer.core.ContextBuilder#load(common.DataContext)
	 */
	public void load(DataContext dataContext) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see categorizer.core.ContextBuilder#store()
	 */
	public DataContext store() throws Exception {
		DataContext dataContext = new DataContext();
		dataContext.add(new NodePair(titleTag, this.title));
		dataContext.add(new NodePair(valueTag, String.valueOf(this.metricValue)));
		return dataContext;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	
	
}
