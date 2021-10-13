package categorizer.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import categorizer.aiCategorizer.core.ConfusionMatrix;

import common.DataContext;

/**
 *
 * the class to calculate the accuracy of the categorizer
 * it evaluates the accuracy with respect to the formula:
 *                          (number of true positives + number of true negatives)
 * accuracy = --------------------------------------------------------------------------------
 *             numbers of true positives + false positives + true negatives + false negatives
 *             
 * @author secil.karagulle
 * @author ovunc.bozcan
 * 
 */

public class Accuracy extends PerformanceMetric {

	/**
	 * keeps the accuracy related 
	 */
	private double accuracy;	
	
	private DataContext matrix;
	
	private String[] classLabels;
	
	public Accuracy(){
		
	}
	
	public Accuracy(ConfusionMatrix confusionMatrix){
		
		this.confusionMatrix = confusionMatrix;
		
		super.setConfusionMatrix(confusionMatrix);
		
		this.matrix = confusionMatrix.store();
		
		this.classLabels = confusionMatrix.getLabels().clone();
	}
	
	public DataContext getMatrix(){
		return matrix;
	}
	
	public void setMatrix(DataContext matrix){
		this.matrix = matrix;
	}
	
	public double getAccuracy() {
		
		return accuracy;
	}

	public void setAccuracy(double accuracy) {
		
		this.accuracy = accuracy;
		
		super.setMetricValue(accuracy);
	}

	public void calculateMetric(double accuracy){
		
		accuracy = calculateAccuracy();
	}
	
	public double calculateAccuracy(){
		
		HashMap baseMap = matrix.getBaseMap();
		
		Set set = baseMap.keySet();
		
		this.classLabels = new String[set.size()];
		
		Iterator iterator = set.iterator();
		
		for(int i=0; iterator.hasNext(); i++)
			classLabels[i] = (String)iterator.next();
		
		double numOfInstances = 0.0; // number of all instances categorized DataItems in matrix
		double numOfTrueCatInstances = 0.0;  // number of instances categorized correctly
		
		for(int i=0; i<classLabels.length; i++)
		{
			for(int j=0; j<classLabels.length; j++)
			{
				// get the number of categorized DataItems
				Vector catVector = matrix.getNode(classLabels[i]).getElements2(classLabels[j]);
				double  numCategorized = Double.parseDouble((String)catVector.get(0));
				
				// if they are categorized correctly, add numCategorized value both to 
				// numOfTrueCatInstances and also to numOfInstances
			//	if( classLabels[i].equals(matrix.getNode(classLabels[i]).getElements(classLabels[j])) )
				if( classLabels[i].equals(classLabels[j]) )
				{
					numOfTrueCatInstances+= numCategorized;
					numOfInstances+= numCategorized;
				}
				
				// else, add it only to numOfInstances
				else
				{
					numOfInstances+= numCategorized;
				}
			}
		}
		
		accuracy = (double)numOfTrueCatInstances / (double)numOfInstances;
		
		super.setMetricValue(accuracy);
		
	//	System.out.println("numOfTrueCatInstances: " + numOfTrueCatInstances);
	//	System.out.println("numOfInstances: " + numOfInstances);
		
		return accuracy;
		
	}

	
	public String[] getClassLabels() {
		return classLabels;
	}

	public void setClassLabels(String[] classLabels) {
		this.classLabels = classLabels;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String output = "Accuracy: " + this.accuracy + "\n";
		
		return output;
	//	return super.toString();
	}
	
	
	
}
