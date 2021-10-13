/**
 * 
 */
package categorizer.core;

import java.util.Vector;

import common.DataContext;
import common.NodePair;

/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class Distribution implements ContextBuilder{
	
	
	/**
	 * label of the classname tag
	 */
	protected final static String classNameTag = "className";
	
	/**
	 * classname of the current class
	 */
	protected String className = "categorizer.core.Distribution";
	
	/**
	 * Holds the value of the class
	 */
	protected String classValue;
	
	/**
	 * label of the classValue tag
	 */
	protected final static String classValueTag = "classValue";
	
	/**
	 * default constructor
	 */
	public Distribution() {
	}

	/**
	 * @param variable, the variable to find the distribution of
	 * @return the distribution of the variable
	 */
	public Object weightedValue(Object variable)
	{
		return variable;
	}
	
	public double probability(Object variable){
		
		return 1.00;
	}

	public double logProbability(Object variable){
		
		return 1.00;
	}

	
	/* (non-Javadoc)
	 * @see categorizer.core.ContextBuilder#load(common.DataContext)
	 */
	public void load(DataContext dataContext)
			throws UnsupportedDataContextException {

		Vector tempVector = dataContext.getElements2(classValueTag);
		
		if(tempVector != null && tempVector.size() > 0)
		{
			this.classValue = (String)tempVector.get(0);
		}
		
	}


	/* (non-Javadoc)
	 * @see categorizer.core.ContextBuilder#store()
	 */
	public DataContext store() {
		// TODO Auto-generated method stub
		DataContext dataContext = new DataContext();
		dataContext.add(new NodePair(classNameTag, className));
		dataContext.add(new NodePair(classValueTag, classValue));
		return dataContext;
	}

	/**
	 * @return
	 */
	public String getClassValue() {
		return this.classValue;
	}

	/**
	 * @param classValue
	 */
	public void setClassValue(String classValue) {
		this.classValue = classValue;
	}
	
	
	
}
