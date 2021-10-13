package categorizer.core.util;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import categorizer.core.DataField;
import categorizer.core.DataHeader;
import categorizer.core.DataItem;
import categorizer.core.DataSet;

import common.DataContext;

/**
 * Class to read DataSet object from files given in xml format, and create the corresponding arff file
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class DataSet2Arff {
	
//	private File f;
	private FileWriter fstream;
	private BufferedWriter out;
	private String arffFileName;
	private DataSet dataSet;
	private DataContext dataContext;
	
	public DataSet2Arff(DataContext dataContext, String arffFileName) throws Exception{
		
		if( !(arffFileName.endsWith(".arff")) ){
			System.out.println("file mismatch error\n");
		}
		else{
			this.dataContext = dataContext;
			
			dataSet = new DataSet();	
			dataSet.load(this.dataContext);
			
			this.arffFileName = arffFileName;
			
			try{
				
				fstream = new FileWriter(this.arffFileName);
				out = new BufferedWriter(fstream);
				
			}catch(Exception e){
				System.err.println("Error: " + e.getMessage());
			}
		}
	}
	
	public void readAttributes() throws IOException{
		
		out.write("@relation\n");
	
		DataHeader[] dataHeaders = dataSet.getDataHeaders();
		
		for(int i=0; i<dataHeaders.length; i++){
			
			String ln = "";
			
			ln += "@attribute ";
			
			ln += dataHeaders[i].getLabel() + " ";
			
			if(dataHeaders[i].isNominal()){
				
				ln += "{";
				String[] availableValues = dataHeaders[i].getAvailableValue();
				
				for(int j=0; j<availableValues.length -1; j++){
					ln += availableValues[j] + ", ";
				}
				
				ln += availableValues[availableValues.length-1] + "}";
			}
			
			else{  // if dataHeader is numeric
				
				ln += "real";
			}
			
			out.write(ln + "\n");
		}
		
	}
	
	public void readData() throws IOException{
		
		out.write("\n@data\n");
		
		DataItem[] dataItems = dataSet.getDataItems();
		
		for(int i=0; i<dataItems.length; i++){
			
			String ln = "";
			
			DataField[] dataFields = dataItems[i].getDataFields();
			
			for(int j=0; j<dataFields.length-1; j++){
				
				ln += dataFields[j].getStringValue() + ", "; 
			}
			
			ln += dataFields[dataFields.length-1].getStringValue();
			
			out.write(ln + "\n");
		}
		
	}
	
	public void exporter() throws IOException{
	
		readAttributes();
		
		readData();
		
		out.close();
		
		fstream.close();
	}

}
