/**
 * 
 */
package categorizer.aiCategorizer.core;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import categorizer.core.ContextBuilder;

import common.DataContext;
import common.NodePair;
import common.monitor.Logger;


/**
 * This class is used to hold the result of the validation of the AICategorizer
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class ConfusionMatrix implements ContextBuilder{
	
	/**
	 * Holds the label of the categories
	 */
	private String[] labels;
	
	/**
	 * DataContext to hold the confusion matrix
	 */
	private DataContext matrix;
	
	
	
	/**
	 * default constructor
	 */
	public ConfusionMatrix() {
	}

	/**
	 * default constructor
	 */
	public ConfusionMatrix(String[] labels) {
		this.labels = labels;
		
		matrix = new DataContext();
		for(int i=0; i<labels.length; i++)
		{
			matrix.add(labels[i], new DataContext());
			for(int j=0; j<labels.length; j++)
			{
				matrix.getNode(labels[i]).add(new NodePair(labels[j],String.valueOf(0)));
			}
		}
	}

	/**
	 * @param rowName
	 * @param columnName
	 * 
	 * Increments the count of the DataItems that are actually rowName, 
	 * categorized as columnName
	 */
	public void increment(String rowName, String columnName)
	{
		try{
			Vector oldValueVector = matrix.getNode(rowName).getElements2(columnName);
			double oldValue = Double.parseDouble((String)oldValueVector.get(0));
			matrix.getNode(rowName).remove(columnName);
			matrix.getNode(rowName).add(new NodePair(columnName, String.valueOf(oldValue+1)));
		}catch(Exception e)
		{
			Logger.error("Error in " + this.getClass().getName() + ".add");
			Logger.error(e.getMessage());
			System.out.println("Error in " + this.getClass().getName() + ".add");
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * @param out
	 * prints the matrix into the PrintStream in the parameter
	 */
	public void print(PrintStream out)
	{
		String outputString = this.toString();
		out.println(outputString);
	}


	/**
	 * @return the matrix in the DataContext format
	 */
	public DataContext store() {
		return matrix;
	}
	
	/**
	 * Loads the confusionMatrix from the matrix below
	 * @param matrix
	 */
	public void load(DataContext matrix){
		this.matrix = matrix;
		
		HashMap baseMap = matrix.getBaseMap();
		
		Set set = baseMap.keySet();
		
		this.labels = new String[set.size()];
		
		Iterator iterator = set.iterator();
		
		for(int i=0; iterator.hasNext(); i++)
		{
			labels[i] = (String)iterator.next();
		}
		
	}
	
	/**
	 * @param realClass
	 * @param resultClass
	 * @return
	 */
	public int getCount(String realClass, String resultClass)
	{
		try{
			return Integer.parseInt((String)(matrix.getNode(realClass).getElements2(resultClass).get(0)));
		}catch(Exception e){
			Logger.error(e.getMessage());
			return 0;
		}
	}

	/**
	 * @return the proportion of all instances categorized falsely to all instances being categorized 
	 */
	public double falseRate(){
		
		int numOfInstances = 0; // number of all instances
		int numOfErrCatInstances = 0;  // number of erroneously categorized instances
		double rate;
		
		for(int i=0; i<labels.length; i++)
		{
			for(int j=0; j<labels.length; j++)
			{
				if( !(labels[i].equals(matrix.getNode(labels[i]).getElements2(labels[j]))) ){
					numOfErrCatInstances++;
				}
				numOfInstances++;
			}
		}
		
		rate = (double)numOfErrCatInstances / (double)(numOfInstances);
		
		return rate;
	}

	public String toString()
	{
		Vector stringVector = new Vector();
		
		String output = "%20s";
		
		stringVector.add("RealValues/Result");
		
		for(int i=0; i<labels.length ; i++)
		{
			output += "%20s";
			stringVector.add(labels[i]);
		}
		output += "\n";
		
		for(int i=0; i<labels.length; i++)
		{
			output += "%20s";
			stringVector.add(labels[i]);
			for(int j=0; j<labels.length; j++)
			{
				output += "%20s";
				stringVector.add(matrix.getNode(labels[i]).getElements2(labels[j]));
			}
			output += "\n";
		}
		
		return String.format(output, stringVector.toArray());
	}

	/**
	 * @return the labels
	 */
	public String[] getLabels() {
		return labels;
	}

	/**
	 * @param labels the labels to set
	 */
	public void setLabels(String[] labels) {
		this.labels = labels;
	}

	/**
	 * @return the matrix
	 */
	public DataContext getMatrix() {
		return matrix;
	}

	/**
	 * @param matrix the matrix to set
	 */
	public void setMatrix(DataContext matrix) {
		this.matrix = matrix;
	}
	
	
}
