/**
 * 
 */
package categorizer.core;

import java.lang.reflect.Constructor;
import java.util.Vector;

import common.DataContext;

/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class Distributions implements ContextBuilder{

	
	/**
	 * Holds the classes
	 */
	private String[] classes;
	
	/**
	 * Holds all of the distributions belonging to one Columns
	 */
	private Distribution[] distributions;
	
	/**
	 * label of the classDistribution Tag
	 */
	private String classDistributionTag = "classDistribution";
	
	/**
	 * label of the classname tag
	 */
	private final static String classNameTag = "className";
	
	/**
	 * Default constructor
	 */
	public Distributions() {
		
	}
	/**
	 * 
	 */
	public Distributions(int n) {
		classes = new String[n];
		distributions = new Distribution[n];
	}
	
	
	public void setDistribution(int index,Distribution distribution)
	{
		distributions[index] = distribution ;
	}
	
	public void setClass(int index, String classValue)
	{
		classes[index] = classValue;
	}
	
	public void load(DataContext dataContext)
			throws Exception {
	
		Vector tempVector = dataContext.getNodes(classDistributionTag);
		if(tempVector != null && tempVector.size() > 0)
		{
			distributions = new Distribution[tempVector.size()];
			classes = new String[tempVector.size()];
			for(int i=0; i<distributions.length; i++)
			{
				Vector distributionTempVector = ((DataContext)tempVector.get(i)).getElements2(classNameTag);
				
				if( distributionTempVector!= null && distributionTempVector.size() > 0)
				{
					String distributionName = (String)distributionTempVector.get(0);
					Class distribution = Class.forName(distributionName);
					
					Constructor constructor = distribution.getDeclaredConstructor(null);
					
					distributions[i] = (Distribution)constructor.newInstance(null);
					
					distributions[i].load((DataContext)tempVector.get(i));
					
					classes[i] = distributions[i].getClassValue();
				}
				else
					throw new UnsupportedDataContextException();
			}
		}
		
	}
	
	public DataContext store() {
		
		DataContext dataContext = new DataContext();
		
		for(int i=0; distributions != null && i<distributions.length; i++)
		{
			dataContext.add(classDistributionTag,distributions[i].store());
		}
		return dataContext;
	}
	/**
	 * @return the classes
	 */
	public String[] getClasses() {
		return classes;
	}
	/**
	 * @param classes the classes to set
	 */
	public void setClasses(String[] classes) {
		this.classes = classes;
	}
	/**
	 * @return the distributions
	 */
	public Distribution[] getDistributions() {
		return distributions;
	}
	/**
	 * @param distributions the distributions to set
	 */
	public void setDistributions(Distribution[] distributions) {
		this.distributions = distributions;
	}

	public double probability(String classValue, Object value)
	{
		for(int i=0; i<distributions.length ; i++)
		{
			if(distributions[i].getClassValue().equals(classValue))
			{
			//	return distributions[i].probability(value);
				return distributions[i].logProbability(value);
			}
		}
		
		return 0.0;
	}
}
