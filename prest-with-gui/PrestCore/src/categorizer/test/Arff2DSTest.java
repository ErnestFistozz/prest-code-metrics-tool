package categorizer.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import common.DataContext;

import categorizer.core.DataSet;
import categorizer.core.UnsupportedDataContextException;
import categorizer.core.util.Arff2DataSet;

/**
 * A test class to categorizer.core.util.ArfftoDataSet class
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class Arff2DSTest {

	private final static String currentTag = "dataSet";
	private final static String fileName = "C:/Documents and Settings/zuzu/Desktop/weka_data/ArfftoXml.xml";
	private final static String fileName2 = "C:/Documents and Settings/zuzu/Desktop/weka_data/Xml2Xml.xml";
	private final static String fileName3 = "C:/Documents and Settings/zuzu/Desktop/weka_data/Xml2DataSet2Xml.xml";
	
	public static void main(String[] args) throws Exception, FileNotFoundException, IOException, UnsupportedDataContextException{
		
		Arff2DataSet converter = new Arff2DataSet("C:/Documents and Settings/zuzu/Desktop/weka_data/weather.arff");
		
		DataSet dataSet = converter.reader();
		
		DataContext dataContext = new DataContext();
		dataContext.add(currentTag, dataSet.store());
		dataContext.writeToFile(fileName);
		
		dataContext = DataContext.readFromFile(fileName);
		
		dataContext.writeToFile(fileName2);
		
		DataSet dataSet2 = new DataSet();
		
		dataSet2.load(dataContext.getNode(currentTag));
		
		DataContext dataContext2 = dataSet2.store();
		
		dataContext2.writeToFile(fileName3);
	}
}
