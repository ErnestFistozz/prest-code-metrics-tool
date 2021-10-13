package categorizer.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import categorizer.aiCategorizer.core.ConfusionMatrix;

import common.DataContext;

/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class Recall extends PerformanceMetric {

	/**
	 * keeps overall recall calculated as the sum of entries
	 * in recalls array
	 */
	private double overallRecall;
	
	/**
	 * keeps recall for each class
	 */
	private HashMap recalls;
	
	private DataContext matrix;
	
	private String[] classLabels;
	
	public Recall(){
		
	}
	
	public Recall(ConfusionMatrix confusionMatrix){
		
		this.confusionMatrix = confusionMatrix;
		
		super.setConfusionMatrix(confusionMatrix);
		
		this.matrix = confusionMatrix.store();
		
		this.classLabels = confusionMatrix.getLabels().clone();
		
	//	recalls = new HashMap<String, Double>();
	}
	
	public double getOverallRecall() {
		
		return overallRecall;
	}


	public void setOverallRecall(double overallRecall) {
		
		this.overallRecall = overallRecall;
		
		super.setMetricValue(overallRecall);
	}

	public HashMap getRecalls(){
		
		return recalls;
	}
	
	public void setRecalls(HashMap recalls){
			
		this.recalls = recalls; 
	}
	
	public void calculateMetric(double accuracy){
		
		overallRecall = calculateRecalls();
	}
	
	public double calculateRecalls(){
		
		recalls = new HashMap<String, Double>();
		
		HashMap baseMap = matrix.getBaseMap();
		
		Set set = baseMap.keySet();
		
		this.classLabels = new String[set.size()];
		
		Iterator iterator = set.iterator();
		
		for(int i=0; iterator.hasNext(); i++)
			classLabels[i] = (String)iterator.next();
		
		double []numOfInstances = new double[classLabels.length]; // number of instances belonging to a class
	
		double []numOfTrueCatInstances = new double[classLabels.length];  // number of instances in each class that are categorized correctly

		for(int i=0; i<classLabels.length; i++){
			
			numOfInstances[i]=0.0;
			numOfTrueCatInstances[i]=0.0;
		}
			
		for(int i=0; i<classLabels.length; i++)
		{
			for(int j=0; j<classLabels.length; j++)
			{
				// get the number of categorized DataItems
				Vector catVector = matrix.getNode(classLabels[i]).getElements2(classLabels[j]);
				double  numCategorized = Double.parseDouble((String)catVector.get(0));
				
				if( classLabels[i].equals(classLabels[j]) ){
					numOfTrueCatInstances[i]+= numCategorized;
				}
				
				numOfInstances[i]+= numCategorized;
			}
			
			recalls.put( classLabels[i], (double)numOfTrueCatInstances[i] / (double)numOfInstances[i] );
		}
	
		overallRecall = 0.0;
		
		for(int i=0; i<classLabels.length; i++)
			overallRecall += (Double)recalls.get(classLabels[i]);
		
		overallRecall = overallRecall / (double)classLabels.length;
		
		super.setMetricValue(overallRecall);
		
		return overallRecall;
		
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
		String output = "";
		
		for(int i=0; i<classLabels.length; i++)
			output += "Recall for " + classLabels[i] + ": " + (Double)recalls.get(classLabels[i]) + "\n";
			
		output +=  "\noverall Recall: " + overallRecall + "\n";
		
		return output;
	//	return super.toString();
	}
	
}

