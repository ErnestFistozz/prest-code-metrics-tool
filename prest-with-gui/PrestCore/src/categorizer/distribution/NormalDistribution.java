/**
 * 
 */
package categorizer.distribution;

import java.util.HashMap;
import java.util.Vector;

import categorizer.core.DataHeader;
import categorizer.core.DataItem;
import categorizer.core.DataSet;
import categorizer.core.ProbabilityDistribution;
import categorizer.core.UnsupportedDataContextException;

import common.DataContext;
import common.NodePair;

/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class NormalDistribution extends ProbabilityDistribution {


	/** current mean,
	 *  used while calculating the final mean of the given variables */
	private double n_mean;
	
	/** current standard deviation,
	 *  used while calculating the final std deviation of the given variables 
	 */
	private double n_standardDev;
	
	/**
	 * variance, i.e. the square of standard deviation
	 */
	private double n_variance;
	
	/**
	 * precision to be used in calculating probability for a random variable
	 */
	private double n_precision;
		
	/**
	 * Z Table used in calculating probabilities
	 */
	HashMap<Double, Double> z_Table;
	
	/**
	 * label of the distribution specific tag
	 */
	private final static String distributionSpecificTag = "distributionSpecific" ;
	
	/**
	 * boolean variable that keeps if all data values have a unique value 
	 */
	private boolean isUniqueData; 
	
	
	public NormalDistribution(){
		n_mean = 0.0;
		n_standardDev = 0.0;
		n_precision = 0.01;
		setZTable();
		className = "categorizer.distribution.NormalDistribution";
		isUniqueData = false;
	}
	
	public NormalDistribution(String classValue)
	{
		this.classValue = classValue;
		className = "categorizer.distribution.NormalDistribution" ;
	}
	
	/**
	 * @param dataItems
	 * @param index
	 * for each DataItem in dataItems array, gets the value of its DataField at the given index;
	 * saves all such values as a vector, and calls the corresponding methods to calculate
	 * the mean and standard deviation of this vector.
	 */
	public NormalDistribution(DataSet dataSet, int index, int classValueIndex)
	{
		
		
		className = "categorizer.distribution.NormalDistribution" ;
	
		Vector values = new Vector();
		
		int classIndex = dataSet.getDataHeaders().length - 1;
		if(dataSet.getClassIndex() != -1 && classIndex != dataSet.getClassIndex())
			classIndex = dataSet.getClassIndex();
		this.classValue = dataSet.getDataHeaders()[classIndex].getAvailableValue()[classValueIndex];
		
		DataItem[] dataItems = dataSet.getDataItems();
		
		for(int i=0;i<dataItems.length;i++){
			if( classValue.equals(dataItems[i].getDataFields()[classIndex].getStringValue()) ){
				double value = Double.parseDouble( dataItems[i].getDataFields()[index].getStringValue() );
				values.add(value);
			}
		}
		calculateMean(values);
		calculateStandardDeviation(values);
		
	}
	
	/* (non-Javadoc)
	 * @see categorizer.core.Distribution#getMean()
	 */
	@Override
	public double getMean() {
		// TODO Auto-generated method stub
		return super.getMean();
	}

	/* (non-Javadoc)
	 * @see categorizer.core.Distribution#getVariance()
	 */
	@Override
	public double getVariance() {
		// TODO Auto-generated method stub
		return super.getVariance();
	}

	/* (non-Javadoc)
	 * @see categorizer.core.Distribution#setMean(double)
	 */
	@Override
	public void setMean(double mean) {
		// TODO Auto-generated method stub
		super.setMean(mean);
	}

	/* (non-Javadoc)
	 * @see categorizer.core.Distribution#setVariance(double)
	 */
	@Override
	public void setVariance(double variance) {
		// TODO Auto-generated method stub
		super.setVariance(variance);
	}

	/* (non-Javadoc)
	 * @see categorizer.core.Distribution#weightedValue(double)
	 */
	@Override
	public Object weightedValue(Object value) {
		return weightedValue(((Double)value).doubleValue());
	}
	
	/* (non-Javadoc)
	 * @see categorizer.core.Distribution#probability(double)
	 */
	@Override
	public double probability(Object value) {
		return probability(((Double)value).doubleValue());
	}
	
	/* (non-Javadoc)
	 * @see categorizer.core.Distribution#logProbability(java.lang.Object)
	 */
	@Override
	public double logProbability(Object value){
		return logProbability(((Double)value).doubleValue());
	}
	
	/**
	 * @param variables variables whose mean will be calculated
	 * calculates the mean of the given variables
	 */
	public void calculateMean(Vector variables){
		
		for(int i=0;i<variables.size();i++){
			n_mean += (Double)(variables.get(i));
		}
		
		n_mean = n_mean / variables.size();
		
		super.setMean(n_mean);
		
	}
	
	/**
	 * @param variables variables whose standard deviation will be calculated
	 * calculates the standard deviation of the given variables
	 */
	public void calculateStandardDeviation(Vector variables){
		
		for(int i=0;i<variables.size();i++){
			n_standardDev+= Math.pow( ((Double)(variables.get(i)) - n_mean) , 2.0 );
		}
		
		n_standardDev = Math.sqrt( n_standardDev / variables.size() );
		
		n_variance = n_standardDev * n_standardDev;
		
		if(n_variance == 0)
		{
			isUniqueData = true;
			n_variance = Double.MIN_VALUE;
			n_standardDev = Double.MIN_VALUE;
		}
		
		super.setVariance(n_variance);
		
//		calculatePrecision();
		
	}
	
	/*
	 * calculates the precision with respect to the standard deviation
	 */
//	public void calculatePrecision(){
//		
//		n_precision = n_standardDev / 100;
//	}
	
	/**
	 * @param variable for which weighted value is calculated
	 * @return the value of the variable in standard normal distribution
	 */
	public double weightedValue(double variable){
		
		return ( (variable - n_mean) / n_standardDev );
		
	}
	
	/**
	 * @param variable for which probability is calculated
	 * @return the probability of occurence of the given variable
	 * with respect to standard normal distribution
	 */
//	public double probability(double variable){
//		
//		double z_value = weightedValue(variable);
//		double z_upper, z_lower;
//		double area_upper = 0.00;
//		double area_lower = 0.00;
//		
//		int castedValue = (int)(z_value * 100.0);
//				
//		z_value = (double)castedValue / 100.00;
//		
//		if(z_value>=0.00){
//			z_upper = z_value + n_precision;
//			z_lower = z_value - n_precision;
//			
//			area_upper = 0.50 + z_Table.get(z_upper);
//			
//			if(z_lower<0.00){
//				z_lower = -1.00 * z_lower;
//				area_lower = 0.50 - z_Table.get(z_lower);
//			}
//			else
//				area_lower = 0.50 + z_Table.get(z_lower);
//		}
//		
//		else{	// (z_value<0.00)
//			z_value = -1 * z_value;  // get the absolute value
//			z_upper = z_value + n_precision;
//			z_lower = z_value - n_precision;
//		//	area_upper = 0.50 - z_Table.get(z_upper);
//			area_upper = 0.50 - z_Table.get(z_lower);
//		//	area_lower = 0.50 - z_Table.get(z_lower);
//			area_lower = 0.50 - z_Table.get(z_upper);
//		}
//		
//		if(z_value == 3.09 || z_value==-3.09)
//			return 0.0001;
//		
//		else if( (area_upper - area_lower) == 0.0000 ){
//			return 0.00001;
//		}
//		else{		
//			return area_upper - area_lower;
//		}
//	}
	
	public double probability(double variable){
		
		double prob = 0.0;

		if(isUniqueData)
			prob = 1.0;
		
		else{
				
			double n_constant = Math.sqrt(2 * Math.PI);
		
			double normalVar = weightedValue(variable);
		
			prob = ( 1/(n_standardDev * n_constant) ) * Math.exp( -1*((normalVar*normalVar)/2) );
		
		//	prob = 0 - Math.log(n_standardDev) - Math.log(n_constant) + Math.log(Math.exp( -1*((normalVar*normalVar)/2) ));
		}
		
		return prob;
		
	}
	
	public double logProbability(double variable){
		
		double logProb = 0.0;

		if(isUniqueData)
			logProb = 1.0;
		
		else{
				
			double n_constant = Math.sqrt(2 * Math.PI);
		
			double normalVar = weightedValue(variable);
		
		//	prob = ( 1/(n_standardDev * n_constant) ) * Math.exp( -1*((normalVar*normalVar)/2) );
		
			logProb = 0 - Math.log(n_standardDev) - Math.log(n_constant) + Math.log(Math.exp( -1*((normalVar*normalVar)/2) ));
		}
		
		return logProb;
		
	}
	
	public void load(DataContext dataContext)throws UnsupportedDataContextException {

		super.load(dataContext);
		n_variance = variance;
		n_mean = mean; 
		n_standardDev = Math.sqrt(n_variance);

	}

/* (non-Javadoc)
* @see categorizer.core.Distribution#store()
*/
	public DataContext store() {
		
		mean = n_mean;
		variance = n_variance;
	
		DataContext dataContext = super.store();
	
		return dataContext;
	}
	
	/**
	 * sets the values in Z Table as the areas under Z curve between
	 * 0.0 and the corresponding value 
	 */
	public void setZTable(){
		
		z_Table = new HashMap<Double, Double>();
		
		z_Table.put(0.00, 0.00);
		z_Table.put(0.01, 0.004);
		z_Table.put(0.02, 0.008);
		z_Table.put(0.03, 0.012);
		z_Table.put(0.04, 0.016);
		z_Table.put(0.05, 0.0199);
		z_Table.put(0.06, 0.0239);
		z_Table.put(0.07, 0.0279);
		z_Table.put(0.08, 0.0319);
		z_Table.put(0.09, 0.0359);
		z_Table.put(0.10, 0.0398);
		z_Table.put(0.11, 0.0438);
		z_Table.put(0.12, 0.0478);
		z_Table.put(0.13, 0.0517);
		z_Table.put(0.14, 0.0557);
		z_Table.put(0.15, 0.0596);
		z_Table.put(0.16, 0.0636);
		z_Table.put(0.17, 0.0675);
		z_Table.put(0.18, 0.0714);
		z_Table.put(0.19, 0.0753);
		z_Table.put(0.20, 0.0793);
		z_Table.put(0.21, 0.0832);
		z_Table.put(0.22, 0.0871);
		z_Table.put(0.23, 0.091);
		z_Table.put(0.24, 0.0948);
		z_Table.put(0.25, 0.0987);
		z_Table.put(0.26, 0.1026);
		z_Table.put(0.27, 0.1064);
		z_Table.put(0.28, 0.1103);
		z_Table.put(0.29, 0.1141);
		z_Table.put(0.30, 0.1179);
		z_Table.put(0.31, 0.1217);
		z_Table.put(0.32, 0.1255);
		z_Table.put(0.33, 0.1293);
		z_Table.put(0.34, 0.1331);
		z_Table.put(0.35, 0.1368);
		z_Table.put(0.36, 0.1406);
		z_Table.put(0.37, 0.1443);
		z_Table.put(0.38, 0.148);
		z_Table.put(0.39, 0.1517);
		z_Table.put(0.40, 0.1554);
		z_Table.put(0.41, 0.1591);
		z_Table.put(0.42, 0.1628);
		z_Table.put(0.43, 0.1664);
		z_Table.put(0.44, 0.17);
		z_Table.put(0.45, 0.1736);
		z_Table.put(0.46, 0.1772);
		z_Table.put(0.47, 0.1808);
		z_Table.put(0.48, 0.1844);
		z_Table.put(0.49, 0.1879);
		z_Table.put(0.50, 0.1915);
		z_Table.put(0.51, 0.195);
		z_Table.put(0.52, 0.1985);
		z_Table.put(0.53, 0.2019);
		z_Table.put(0.54, 0.2054);
		z_Table.put(0.55, 0.2088);
		z_Table.put(0.56, 0.2123);
		z_Table.put(0.57, 0.2157);
		z_Table.put(0.58, 0.219);
		z_Table.put(0.59, 0.2224);
		z_Table.put(0.60, 0.2257);
		z_Table.put(0.61, 0.2291);
		z_Table.put(0.62, 0.2324);
		z_Table.put(0.63, 0.2357);
		z_Table.put(0.64, 0.2389);
		z_Table.put(0.65, 0.2422);
		z_Table.put(0.66, 0.2454);
		z_Table.put(0.67, 0.2486);
		z_Table.put(0.68, 0.2517);
		z_Table.put(0.69, 0.2549);
		z_Table.put(0.70, 0.258);
		z_Table.put(0.71, 0.2611);
		z_Table.put(0.72, 0.2642);
		z_Table.put(0.73, 0.2673);
		z_Table.put(0.74, 0.2704);
		z_Table.put(0.75, 0.2734);
		z_Table.put(0.76, 0.2764);
		z_Table.put(0.77, 0.2794);
		z_Table.put(0.78, 0.2823);
		z_Table.put(0.79, 0.2852);
		z_Table.put(0.80, 0.2881);
		z_Table.put(0.81, 0.291);
		z_Table.put(0.82, 0.2939);
		z_Table.put(0.83, 0.2967);
		z_Table.put(0.84, 0.2995);
		z_Table.put(0.85, 0.3023);
		z_Table.put(0.86, 0.3051);
		z_Table.put(0.87, 0.3078);
		z_Table.put(0.88, 0.3106);
		z_Table.put(0.89, 0.3133);
		z_Table.put(0.90, 0.3159);
		z_Table.put(0.91, 0.3186);
		z_Table.put(0.92, 0.3212);
		z_Table.put(0.93, 0.3238);
		z_Table.put(0.94, 0.3264);
		z_Table.put(0.95, 0.3289);
		z_Table.put(0.96, 0.3315);
		z_Table.put(0.97, 0.334);
		z_Table.put(0.98, 0.3365);
		z_Table.put(0.99, 0.3389);
		
		z_Table.put(1.00, 0.3413);
		z_Table.put(1.01, 0.3438);
		z_Table.put(1.02, 0.3461);
		z_Table.put(1.03, 0.3485);
		z_Table.put(1.04, 0.3508);
		z_Table.put(1.05, 0.3531);
		z_Table.put(1.06, 0.3554);
		z_Table.put(1.07, 0.3577);
		z_Table.put(1.08, 0.3599);
		z_Table.put(1.09, 0.3621);
		z_Table.put(1.10, 0.3643);
		z_Table.put(1.11, 0.3643);
		z_Table.put(1.12, 0.3686);
		z_Table.put(1.13, 0.3708);
		z_Table.put(1.14, 0.3729);
		z_Table.put(1.15, 0.3749);
		z_Table.put(1.16, 0.377);
		z_Table.put(1.17, 0.379);
		z_Table.put(1.18, 0.381);
		z_Table.put(1.19, 0.383);
		z_Table.put(1.20, 0.3849);
		z_Table.put(1.21, 0.3869);
		z_Table.put(1.22, 0.3888);
		z_Table.put(1.23, 0.3907);
		z_Table.put(1.24, 0.3925);
		z_Table.put(1.25, 0.3944);
		z_Table.put(1.26, 0.3962);
		z_Table.put(1.27, 0.398);
		z_Table.put(1.28, 0.3997);
		z_Table.put(1.29, 0.4015);
		z_Table.put(1.30, 0.4032);
		z_Table.put(1.31, 0.4049);
		z_Table.put(1.32, 0.4066);
		z_Table.put(1.33, 0.4082);
		z_Table.put(1.34, 0.4099);
		z_Table.put(1.35, 0.4115);
		z_Table.put(1.36, 0.4131);
		z_Table.put(1.37, 0.4147);
		z_Table.put(1.38, 0.4162);
		z_Table.put(1.39, 0.4177);
		z_Table.put(1.40, 0.4192);
		z_Table.put(1.41, 0.4207);
		z_Table.put(1.42, 0.4222);
		z_Table.put(1.43, 0.4236);
		z_Table.put(1.44, 0.4251);
		z_Table.put(1.45, 0.4265);
		z_Table.put(1.46, 0.4279);
		z_Table.put(1.47, 0.4292);
		z_Table.put(1.48, 0.4306);
		z_Table.put(1.49, 0.4319);
		z_Table.put(1.50, 0.4332);
		z_Table.put(1.51, 0.4345);
		z_Table.put(1.52, 0.4357);
		z_Table.put(1.53, 0.437);
		z_Table.put(1.54, 0.4382);
		z_Table.put(1.55, 0.4394);
		z_Table.put(1.56, 0.4406);
		z_Table.put(1.57, 0.4418);
		z_Table.put(1.58, 0.4429);
		z_Table.put(1.59, 0.4441);
		z_Table.put(1.60, 0.4452);
		z_Table.put(1.61, 0.4463);
		z_Table.put(1.62, 0.4474);
		z_Table.put(1.63, 0.4484);
		z_Table.put(1.64, 0.4495);
		z_Table.put(1.65, 0.4505);
		z_Table.put(1.66, 0.4515);
		z_Table.put(1.67, 0.4525);
		z_Table.put(1.68, 0.4535);
		z_Table.put(1.69, 0.4545);
		z_Table.put(1.70, 0.4554);
		z_Table.put(1.71, 0.4564);
		z_Table.put(1.72, 0.4573);
		z_Table.put(1.73, 0.4582);
		z_Table.put(1.74, 0.4591);
		z_Table.put(1.75, 0.4599);
		z_Table.put(1.76, 0.4608);
		z_Table.put(1.77, 0.4616);
		z_Table.put(1.78, 0.4625);
		z_Table.put(1.79, 0.4633);
		z_Table.put(1.80, 0.4641);
		z_Table.put(1.81, 0.4649);
		z_Table.put(1.82, 0.4656);
		z_Table.put(1.83, 0.4664);
		z_Table.put(1.84, 0.4671);
		z_Table.put(1.85, 0.4678);
		z_Table.put(1.86, 0.4686);
		z_Table.put(1.87, 0.4693);
		z_Table.put(1.88, 0.4699);
		z_Table.put(1.89, 0.4706);
		z_Table.put(1.90, 0.4713);
		z_Table.put(1.91, 0.4719);
		z_Table.put(1.92, 0.4726);
		z_Table.put(1.93, 0.4732);
		z_Table.put(1.94, 0.4738);
		z_Table.put(1.95, 0.4744);
		z_Table.put(1.96, 0.475);
		z_Table.put(1.97, 0.4756);
		z_Table.put(1.98, 0.4761);
		z_Table.put(1.99, 0.4767);
		
		z_Table.put(2.00, 0.4772);
		z_Table.put(2.01, 0.4778);
		z_Table.put(2.02, 0.4783);
		z_Table.put(2.03, 0.4788);
		z_Table.put(2.04, 0.4793);
		z_Table.put(2.05, 0.4798);
		z_Table.put(2.06, 0.4803);
		z_Table.put(2.07, 0.4808);
		z_Table.put(2.08, 0.4812);
		z_Table.put(2.09, 0.4817);
		z_Table.put(2.10, 0.4821);
		z_Table.put(2.11, 0.4826);
		z_Table.put(2.12, 0.483);
		z_Table.put(2.13, 0.4834);
		z_Table.put(2.14, 0.4838);
		z_Table.put(2.15, 0.4842);
		z_Table.put(2.16, 0.4846);
		z_Table.put(2.17, 0.485);
		z_Table.put(2.18, 0.4854);
		z_Table.put(2.19, 0.4857);
		z_Table.put(2.20, 0.4861);
		z_Table.put(2.21, 0.4864);
		z_Table.put(2.22, 0.4868);
		z_Table.put(2.23, 0.4871);
		z_Table.put(2.24, 0.4875);
		z_Table.put(2.25, 0.4878);
		z_Table.put(2.26, 0.4881);
		z_Table.put(2.27, 0.4884);
		z_Table.put(2.28, 0.4887);
		z_Table.put(2.29, 0.489);
		z_Table.put(2.30, 0.4893);
		z_Table.put(2.31, 0.4896);
		z_Table.put(2.32, 0.4898);
		z_Table.put(2.33, 0.4901);
		z_Table.put(2.34, 0.4904);
		z_Table.put(2.35, 0.4906);
		z_Table.put(2.36, 0.4909);
		z_Table.put(2.37, 0.4911);
		z_Table.put(2.38, 0.4913);
		z_Table.put(2.39, 0.4916);
		z_Table.put(2.40, 0.4918);
		z_Table.put(2.41, 0.492);
		z_Table.put(2.42, 0.4922);
		z_Table.put(2.43, 0.4925);
		z_Table.put(2.44, 0.4927);
		z_Table.put(2.45, 0.4929);
		z_Table.put(2.46, 0.4931);
		z_Table.put(2.47, 0.4932);
		z_Table.put(2.48, 0.4934);
		z_Table.put(2.49, 0.4936);
		z_Table.put(2.50, 0.4938);
		z_Table.put(2.51, 0.494);
		z_Table.put(2.52, 0.4941);
		z_Table.put(2.53, 0.4943);
		z_Table.put(2.54, 0.4945);
		z_Table.put(2.55, 0.4946);
		z_Table.put(2.56, 0.4948);
		z_Table.put(2.57, 0.4949);
		z_Table.put(2.58, 0.4951);
		z_Table.put(2.59, 0.4952);
		z_Table.put(2.60, 0.4953);
		z_Table.put(2.61, 0.4955);
		z_Table.put(2.62, 0.4956);
		z_Table.put(2.63, 0.4957);
		z_Table.put(2.64, 0.4959);
		z_Table.put(2.65, 0.496);
		z_Table.put(2.66, 0.4961);
		z_Table.put(2.67, 0.4962);
		z_Table.put(2.68, 0.4963);
		z_Table.put(2.69, 0.4964);
		z_Table.put(2.70, 0.4965);
		z_Table.put(2.71, 0.4966);
		z_Table.put(2.72, 0.4967);
		z_Table.put(2.73, 0.4968);
		z_Table.put(2.74, 0.4969);
		z_Table.put(2.75, 0.497);
		z_Table.put(2.76, 0.4971);
		z_Table.put(2.77, 0.4972);
		z_Table.put(2.78, 0.4973);
		z_Table.put(2.79, 0.4974);
		z_Table.put(2.80, 0.4974);
		z_Table.put(2.81, 0.4975);
		z_Table.put(2.82, 0.4976);
		z_Table.put(2.83, 0.4977);
		z_Table.put(2.84, 0.4977);
		z_Table.put(2.85, 0.4978);
		z_Table.put(2.86, 0.4979);
		z_Table.put(2.87, 0.4979);
		z_Table.put(2.88, 0.498);
		z_Table.put(2.89, 0.4981);
		z_Table.put(2.90, 0.4981);
		z_Table.put(2.91, 0.4982);
		z_Table.put(2.92, 0.4982);
		z_Table.put(2.93, 0.4983);
		z_Table.put(2.94, 0.4984);
		z_Table.put(2.95, 0.4984);
		z_Table.put(2.96, 0.4985);
		z_Table.put(2.97, 0.4985);
		z_Table.put(2.98, 0.4986);
		z_Table.put(2.99, 0.4986);
		
		z_Table.put(3.00, 0.4987);
		z_Table.put(3.01, 0.4987);
		z_Table.put(3.02, 0.4987);
		z_Table.put(3.03, 0.4988);
		z_Table.put(3.04, 0.4988);
		z_Table.put(3.05, 0.4989);
		z_Table.put(3.06, 0.4989);
		z_Table.put(3.07, 0.4989);
		z_Table.put(3.08, 0.499);
		z_Table.put(3.09, 0.499);
		z_Table.put(3.10, 0.499);
		z_Table.put(3.11, 0.4991);
		z_Table.put(3.12, 0.4991);
		z_Table.put(3.13, 0.4991);
		z_Table.put(3.14, 0.4992);
		z_Table.put(3.15, 0.4992);
		z_Table.put(3.16, 0.4992);
		z_Table.put(3.17, 0.4992);
		z_Table.put(3.18, 0.4993);
		z_Table.put(3.19, 0.4993);
		z_Table.put(3.20, 0.4993);
		z_Table.put(3.21, 0.4993);
		z_Table.put(3.22, 0.4994);
		z_Table.put(3.23, 0.4994);
		z_Table.put(3.24, 0.4994);
		z_Table.put(3.25, 0.4994);
		z_Table.put(3.26, 0.4994);
		z_Table.put(3.27, 0.4995);
		z_Table.put(3.28, 0.4995);
		z_Table.put(3.29, 0.4995);
		z_Table.put(3.30, 0.4995);
		z_Table.put(3.31, 0.4995);
		z_Table.put(3.32, 0.4995);
		z_Table.put(3.33, 0.4996);
		z_Table.put(3.34, 0.4996);
		z_Table.put(3.35, 0.4996);
		z_Table.put(3.36, 0.4996);
		z_Table.put(3.37, 0.4996);
		z_Table.put(3.38, 0.4996);
		z_Table.put(3.39, 0.4997);
		z_Table.put(3.40, 0.4997);
		z_Table.put(3.41, 0.4997);
		z_Table.put(3.42, 0.4997);
		z_Table.put(3.43, 0.4997);
		z_Table.put(3.44, 0.4997);
		z_Table.put(3.45, 0.4997);
		z_Table.put(3.46, 0.4997);
		z_Table.put(3.47, 0.4997);
		z_Table.put(3.48, 0.4997);
		z_Table.put(3.49, 0.4998);
		
	}

}
