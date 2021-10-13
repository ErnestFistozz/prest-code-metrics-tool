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
public class Precision extends PerformanceMetric {
	
	/**
	 * keeps overall recall calculated as the sum of entries
	 * in recalls array
	 */
	private double overallPrecision;
	
	/**
	 * keeps recall for each class
	 */
	private HashMap precisions;
	
	private DataContext matrix;
	
	private String[] classLabels;
	
	public Precision(){
		
	}
	
	public Precision(ConfusionMatrix confusionMatrix){
		
		this.confusionMatrix = confusionMatrix;
		
		super.setConfusionMatrix(confusionMatrix);
		
		this.matrix = confusionMatrix.store();
		
		this.classLabels = confusionMatrix.getLabels().clone();
		
	//	recalls = new HashMap<String, Double>();
	}
	
	public double getOverallPrecision() {
		
		return overallPrecision;
	}


	public void setOverallPrecision(double overallPrecision) {
		
		this.overallPrecision = overallPrecision;
		
		super.setMetricValue(overallPrecision);
	}

	public HashMap getPrecisions(){
		
		return precisions;
	}
	
	public void setRecalls(HashMap precisions){
			
		this.precisions = precisions; 
	}
	
	public void calculateMetric(double accuracy){
		
		overallPrecision = calculatePrecisions();
	}
	
	public double calculatePrecisions(){
		
		precisions = new HashMap<String, Double>();
		
		HashMap baseMap = matrix.getBaseMap();
		
		Set set = baseMap.keySet();
		
		this.classLabels = new String[set.size()];
		
		Iterator iterator = set.iterator();
		
		for(int i=0; iterator.hasNext(); i++)
			classLabels[i] = (String)iterator.next();
		
		double []numOfCatInstances = new double[classLabels.length]; // number of instances categorized as belonging to a class
	
		double []numOfTrueCatInstances = new double[classLabels.length];  // number of instances in each class that are categorized correctly

		for(int i=0; i<classLabels.length; i++){
			
			numOfCatInstances[i]=0.0;
			numOfTrueCatInstances[i]=0.0;
		}
			
		for(int i=0; i<classLabels.length; i++)
		{
			for(int k=0; k<classLabels.length; k++)
			{
				for(int j=0; j<classLabels.length; j++)
				{
					// get the number of categorized DataItems
					Vector catVector = matrix.getNode(classLabels[k]).getElements2(classLabels[j]);
					double  numCategorized = Double.parseDouble((String)catVector.get(0));
				
					if( k==i && classLabels[i].equals(classLabels[j]) ){
						numOfTrueCatInstances[i]+= numCategorized;
						numOfCatInstances[i]+= numCategorized;
					}
					else if( classLabels[i].equals(classLabels[j]) ){
						numOfCatInstances[i]+= numCategorized;
					}
				}
			}
			precisions.put( classLabels[i], (double)numOfTrueCatInstances[i] / (double)numOfCatInstances[i] );
		}
	
		overallPrecision = 0.0;
		
		for(int i=0; i<classLabels.length; i++)
			overallPrecision += (Double)precisions.get(classLabels[i]);
		
		overallPrecision = overallPrecision / (double)classLabels.length;
		
		super.setMetricValue(overallPrecision);
		
		return overallPrecision;
		
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
			output += "Precision for " + classLabels[i] + ": " + (Double)precisions.get(classLabels[i]) + "\n";
			
		output +=  "\noverall Precision: " + overallPrecision + "\n";
		
		return output;
	//	return super.toString();
	}
	
}
