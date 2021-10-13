/**
 * 
 */
package categorizer.core;

import java.util.Vector;

import common.DataContext;
import common.NodePair;

/**
 * The superclass for the distribution of the numeric variables
 * 
 * @author secil.karagulle
 * @author ovunc.bozcan 
 */
public abstract class ProbabilityDistribution extends Distribution implements ContextBuilder{
	
	/**
	 * Mean of the distribution
	 */
	protected double mean;
	
	/**
	 * Variance of the distribution
	 */
	protected double variance;
	
	
	/**
	 * label of the current tag 
	 */
	private final static String currentTag = "current";
	
	/**
	 * label of the mean tag
	 */
	private final static String meanTag = "mean";
	
	/**
	 * label of the variance tag
	 */
	private final static String varianceTag = "variance";
	
	/**
	 * label of the mean-standardDeviation tag 
	 */
	private final static String mean_stdDevDiffTag = "mean_stdDevDiff";
	
	/**
	 * label of the mean+standardDeviation tag 
	 */
	private final static String mean_stdDevTotalTag = "mean_stdDevTotal";
	
	/**
	 * label of the distribution specific tag
	 */
	private final static String distributionSpecificTag = "distributionSpecific" ;
	
	/**
	 * 
	 */
	public ProbabilityDistribution(){
		className = "categorizer.distribution.NormalDistribution";
	}

	/**
	 * @param mean
	 * @param variance
	 */
	public ProbabilityDistribution(double mean, double variance) {
		super();
		this.mean = mean;
		this.variance = variance;
		className = "categorizer.distribution.NormalDistribution";
	}

	/**
	 * @param value
	 * @return the mapped Value of the parameter according to the probability distribution
	 */
	public Object weightedValue(Object value)
	{
		return value;
	}

	/**
	 * @return the mean
	 */
	public double getMean() {
		return mean;
	}

	/**
	 * @param mean the mean to set
	 */
	public void setMean(double mean) {
		this.mean = mean;
	}

	/**
	 * @return the variance
	 */
	public double getVariance() {
		return variance;
	}

	/**
	 * @param variance the variance to set
	 */
	public void setVariance(double variance) {
		this.variance = variance;
	}

	/* (non-Javadoc)
	 * @see categorizer.core.ContextBuilder#load(common.DataContext)
	 */
	@Override
	public void load(DataContext dataContext)
			throws UnsupportedDataContextException {
	
		super.load(dataContext);
		
		DataContext specificContext = dataContext.getNode(distributionSpecificTag);
		
		if(specificContext == null)
			throw new UnsupportedDataContextException();
		
		Vector tempVector = specificContext.getElements2(meanTag);
		
		if(tempVector == null || tempVector.size() == 0)
			throw new UnsupportedDataContextException();
		
		this.mean = Double.parseDouble((String)tempVector.get(0));
		
		tempVector = specificContext.getElements2(varianceTag);
		
		if(tempVector == null || tempVector.size() == 0)
			throw new UnsupportedDataContextException();
		
		this.variance = Double.parseDouble((String)tempVector.get(0));
		
	}

	/* (non-Javadoc)
	 * @see categorizer.core.ContextBuilder#store()
	 */
	@Override
	public DataContext store() {
		DataContext dataContext = super.store();
		
		DataContext specificContext = new DataContext();
		
		//dataContext.add(new NodePair(classNameTag, className));
		specificContext.add(new NodePair(meanTag, String.valueOf(mean)));
		specificContext.add(new NodePair(varianceTag, String.valueOf(variance)));
		
		double mean_stdDevDiff = mean - Math.sqrt(variance);
		specificContext.add(new NodePair(mean_stdDevDiffTag, String.valueOf(mean_stdDevDiff)));
		
		double mean_stdDevTotal = mean + Math.sqrt(variance);
		specificContext.add(new NodePair(mean_stdDevTotalTag, String.valueOf(mean_stdDevTotal)));
		
		dataContext.add(distributionSpecificTag,  specificContext);
		return dataContext;
	}
	
	

}
