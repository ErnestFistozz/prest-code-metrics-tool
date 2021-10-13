/**
 * 
 */
package categorizer.core;

import java.lang.reflect.Constructor;
import java.util.Vector;

import common.monitor.Logger;

import categorizer.distribution.NormalDistribution;

/**
 * this class is intended to find the distribution for the
 * given data sets
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class DistributionFinder {

	/**
	 * default constructor
	 */
	public DistributionFinder() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dataSet
	 */
	public void findDistributions(DataSet dataSet, String[] classes) throws Exception{
		
		int classIndex = dataSet.getDataHeaders().length - 1;
		if(dataSet.getClassIndex() != -1 && classIndex != dataSet.getClassIndex())
			classIndex = dataSet.getClassIndex();
		
		for (int i = 0; i < dataSet.getDataHeaders().length; i++) {

			
				DataHeader dataHeader = ((DataHeader) dataSet.getDataHeaders()[i]);
				Distributions distributions = new Distributions(classes.length);
				distributions.setClasses(classes);
				if(!dataHeader.isNominal()) {
					for(int j=0; j<classes.length; j++)
					{
						NormalDistribution normalDistribution = new NormalDistribution(dataSet,i,j);
						distributions.setDistribution(j, normalDistribution);
					}
				} else {
					for(int j=0; j<classes.length; j++)
					{
						FrequencyDistribution frequencyDistribution = new FrequencyDistribution (dataSet,i,j);
						distributions.setDistribution(j, frequencyDistribution);
					}
				}
				
				dataHeader.setDistributions(distributions);
			
		}
	}

	public void setDistribution(DataSet dataSet, int index, int classValueIndex, String distributionName) throws Exception {
		
		Logger.debug("Creating Distribution");
		Logger.debug(distributionName);

		System.out.println("Creating Distribution");
		System.out.println(distributionName);
		
		
		int classIndex = dataSet.getDataHeaders().length - 1;
		if(dataSet.getClassIndex() != -1 && classIndex != dataSet.getClassIndex())
			classIndex = dataSet.getClassIndex();
		
		Class distribution = Class.forName(distributionName);

		Class[] paramTypes = new Class[4];
		paramTypes[0] = dataSet.getClass();
		paramTypes[1] = int.class;
		paramTypes[2] = int.class;

		Constructor constructor = distribution
				.getDeclaredConstructor(paramTypes);

		Object[] params = new Object[5];
		params[0] = dataSet;
		params[1] = index;
		params[2] = classValueIndex;

		Distributions distributions = dataSet.getDataHeaders()[index].getDistributions();
		distributions.setDistribution( classValueIndex, (Distribution) constructor.newInstance(params));
	}
	
	public void setDistribution(DataSet dataSet, int index, String distributionName) throws Exception {
		
		
		Logger.debug("Creating Distribution");
		Logger.debug(distributionName);

		System.out.println("Creating Distribution");
		System.out.println(distributionName);
		
		int classIndex = dataSet.getDataHeaders().length - 1;
		if(dataSet.getClassIndex() != -1 && classIndex != dataSet.getClassIndex())
			classIndex = dataSet.getClassIndex();
		
		for(int i=0; i<dataSet.getDataHeaders()[classIndex].getAvailableValue().length ; i++)
		{
			setDistribution(dataSet, index, i, distributionName);
		}
		
	}

}
