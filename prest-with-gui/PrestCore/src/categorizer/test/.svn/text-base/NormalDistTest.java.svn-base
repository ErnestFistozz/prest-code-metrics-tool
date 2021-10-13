package categorizer.test;

import java.util.Vector;

import categorizer.distribution.NormalDistribution;

/**
 * a test class to test categorizer.distribution.NormalDistribution class
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class NormalDistTest {

	static Vector variables = new Vector();
	static Vector<Double> probs = new Vector();
	
	public NormalDistTest(){
		
	}
	
	public static void main(String[] args){
		
		variables.add(5.0);
		variables.add(6.0);
		variables.add(7.0);
		variables.add(8.0);
		variables.add(9.0);
		
		NormalDistribution normDist = new NormalDistribution();
		
		normDist.calculateMean(variables);
		
		normDist.calculateStandardDeviation(variables);
		
		double mean = normDist.getMean();
		
		double stdDev = normDist.getVariance();
		
		double probSum=0.0;
		
		System.out.println("mean: "+mean);
		System.out.println("standard dev: "+stdDev);
		
		for(int i=0;i<5;i++){
			probs.add(normDist.probability(variables.get(i)));
			probSum += probs.get(i);
			System.out.println( "Original data: " + variables.get(i) + ", weighted value: "
					+ normDist.weightedValue(variables.get(i)) + ", probability: "
			//		+ normDist.probability(variables.get(i)) );
					+ probs.get(i) );
		}
		
		System.out.println("Sum of all probabilities = " + probSum);
		
	}
}
