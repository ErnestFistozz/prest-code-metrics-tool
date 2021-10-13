package categorizer.test;

import categorizer.core.DataSet;
import categorizer.core.util.Arff2DataSet;
import categorizer.core.util.DataSet2Arff;

import common.DataContext;


/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class DataSet2ArffTest {


	private final static String currentTag = "dataSet";
	private final static String xmlFileName = "C:/Prest/Test/weather.xml";
	private final static String xmlFileName2 = "C:/Prest/Test/weatherXml.xml";
	private final static String arffFileName = "C:/Prest/Test/weatherXml2Arff.arff";
//	private final static String fileName3 = "C:/Documents and Settings/zuzu/Desktop/weka_data/Xml2DataSet2Xml.xml";
	
	public static void main(String[] args) throws Exception{
		
		DataContext dataContext = new DataContext();
		
		dataContext = DataContext.readFromFile(xmlFileName);
		
		DataSet dataSet = new DataSet();
		
		dataSet.load(dataContext.getNode(currentTag));
		
	//	dataContext.add(currentTag, dataSet.store());
		
	//	dataContext.writeToFile(xmlFileName2);
		
		DataSet2Arff exporter = new DataSet2Arff(dataSet.store(), arffFileName);
		
		exporter.exporter();
		
		Arff2DataSet reader = new Arff2DataSet(arffFileName);
		
		DataSet dataSet2 = reader.reader();
		
		DataContext dataContext2 = new DataContext();
		
		dataContext2.add(currentTag, dataSet2.store());
		dataContext2.writeToFile(xmlFileName2);
		
	}
}
