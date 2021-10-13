/**
 * 
 */
package categorizer.test;

import java.util.Vector;

import categorizer.core.DataField;
import categorizer.core.DataHeader;
import categorizer.core.DataItem;
import categorizer.core.DataSet;

import common.DataContext;

/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class DataSetTest {

	private static DataSet dataSet = new DataSet();
	private final static String fileName = "c:/Prest/Test/DataSet.xml";
	private final static String fileName2 = "c:/Prest/Test/DataSet2.xml";
	private final static String fileName3 = "c:/Prest/Test/DataSet3.xml";
	
	private final static String currentTag = "dataSet";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			
			DataSet dataSet = createDataSet();
			
			DataContext dataContext = new DataContext();
			
			dataContext.add(currentTag,dataSet.store());
			
			dataContext.writeToFile(fileName);
			
			dataContext = dataContext.readFromFile(fileName);
			
			dataContext.writeToFile(fileName2);
			
			DataSet dataSet2 = new DataSet();
			
			dataSet2.load(dataContext.getNode(currentTag));
			
			DataContext dataContext2 = dataSet2.store();
			
			dataContext2.writeToFile(fileName3);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static DataSet createDataSet(){
		
		dataSet = new DataSet();
		
		dataSet.setTitle("Iris");
		
		DataHeader[] dataHeaders = new DataHeader[5];
		
		dataHeaders[0] = new DataHeader();
		
		dataHeaders[0].setLabel("sepalLength");
		dataHeaders[0].setNominal(false);
		
		dataHeaders[1] = new DataHeader();
		dataHeaders[1].setLabel("sepalwidth");
		dataHeaders[1].setNominal(false);
		
		dataHeaders[2] = new DataHeader();
		dataHeaders[2].setLabel("petallength");
		dataHeaders[2].setNominal(false);
		
		dataHeaders[3] = new DataHeader();
		dataHeaders[3].setLabel("petalwidth");
		dataHeaders[3].setNominal(false);
		
		dataHeaders[4] = new DataHeader();
		dataHeaders[4].setLabel("class");
		dataHeaders[4].setNominal(true);
		
		String[] availableValues = new String[3];
		availableValues[0] = "Iris-setosa";
		availableValues[1] = "Iris-versicolor";
		availableValues[2] = "Iris-virginica";
		
		dataHeaders[4].setAvailableValue(availableValues);
		
		dataSet.setDataHeaders(dataHeaders);
		
		DataItem[] dataItems = new DataItem[10];
		
		//////////////////
		
		dataItems[0] = new DataItem();
		DataField[] dataFields = new DataField[5];
		
		DataField dataField = new DataField();
		dataField.setDataHeader(dataHeaders[0]);
		dataField.setValue(5.1);
		dataFields[0] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue(3.5);
		dataFields[1] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[2]);
		dataField.setValue(1.4);
		dataFields[2] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue(0.2);
		dataFields[3] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue("Iris-setosa");
		dataFields[4] = dataField;
		
		dataItems[0].setDataFields(dataFields);
		dataItems[0].setDataHeaders(dataHeaders);
		
		//////////////////
		//////////////////
		
		dataItems[1] = new DataItem();
		dataFields = new DataField[5];
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[0]);
		dataField.setValue(4.9);
		dataFields[0] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue(3.0);
		dataFields[1] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[2]);
		dataField.setValue(1.4);
		dataFields[2] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue(0.2);
		dataFields[3] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue("Iris-setosa");
		dataFields[4] = dataField;
		
		dataItems[1].setDataFields(dataFields);
		dataItems[1].setDataHeaders(dataHeaders);
		
		//////////////////
		//////////////////
		
		dataItems[2] = new DataItem();
		dataFields = new DataField[5];
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[0]);
		dataField.setValue(4.7);
		dataFields[0] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue(3.2);
		dataFields[1] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[2]);
		dataField.setValue(1.3);
		dataFields[2] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue(0.2);
		dataFields[3] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue("Iris-setosa");
		dataFields[4] = dataField;
		
		dataItems[2].setDataFields(dataFields);
		dataItems[2].setDataHeaders(dataHeaders);
		
		//////////////////
		//////////////////
		
		dataItems[3] = new DataItem();
		dataFields = new DataField[5];
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[0]);
		dataField.setValue(4.6);
		dataFields[0] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue(3.1);
		dataFields[1] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[2]);
		dataField.setValue(1.5);
		dataFields[2] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue(0.2);
		dataFields[3] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue("Iris-setosa");
		dataFields[4] = dataField;
		
		dataItems[3].setDataFields(dataFields);
		dataItems[3].setDataHeaders(dataHeaders);
		
		
		//////////////////
		//////////////////
		
		dataItems[4] = new DataItem();
		dataFields = new DataField[5];
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[0]);
		dataField.setValue(7.0);
		dataFields[0] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue(3.2);
		dataFields[1] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[2]);
		dataField.setValue(4.7);
		dataFields[2] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue(1.4);
		dataFields[3] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue("Iris-versicolor");
		dataFields[4] = dataField;
		
		dataItems[4].setDataFields(dataFields);
		dataItems[4].setDataHeaders(dataHeaders);
		
		
		
		//////////////////
		//////////////////
		
		dataItems[5] = new DataItem();
		dataFields = new DataField[5];
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[0]);
		dataField.setValue(6.4);
		dataFields[0] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue(3.2);
		dataFields[1] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[2]);
		dataField.setValue(4.5);
		dataFields[2] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue(1.5);
		dataFields[3] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue("Iris-versicolor");
		dataFields[4] = dataField;
		
		dataItems[5].setDataFields(dataFields);
		dataItems[5].setDataHeaders(dataHeaders);
		
		//////////////////
		//////////////////
		
		dataItems[6] = new DataItem();
		dataFields = new DataField[5];
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[0]);
		dataField.setValue(6.9);
		dataFields[0] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue(3.1);
		dataFields[1] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[2]);
		dataField.setValue(4.9);
		dataFields[2] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue(1.5);
		dataFields[3] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue("Iris-versicolor");
		dataFields[4] = dataField;
		
		dataItems[6].setDataFields(dataFields);
		dataItems[6].setDataHeaders(dataHeaders);
		
		//////////////////
		//////////////////
		
		dataItems[7] = new DataItem();
		dataFields = new DataField[5];
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[0]);
		dataField.setValue(6.3);
		dataFields[0] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue(3.3);
		dataFields[1] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[2]);
		dataField.setValue(6.0);
		dataFields[2] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue(2.5);
		dataFields[3] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue("Iris-virginica");		
		dataFields[4] = dataField;
		
		dataItems[7].setDataFields(dataFields);
		dataItems[7].setDataHeaders(dataHeaders);
		//////////////////
		//////////////////
		
		dataItems[8] = new DataItem();
		dataFields = new DataField[5];
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[0]);
		dataField.setValue(5.8);
		dataFields[0] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue(2.7);
		dataFields[1] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[2]);
		dataField.setValue(5.1);
		dataFields[2] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue(1.9);
		dataFields[3] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue("Iris-virginica");
		dataFields[4] = dataField;
		
		dataItems[8].setDataFields(dataFields);
		dataItems[8].setDataHeaders(dataHeaders);
		
		//////////////////
		//////////////////
		
		dataItems[9] = new DataItem();
		dataFields = new DataField[5];
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[0]);
		dataField.setValue(7.1);
		dataFields[0] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue(3.0);
		dataFields[1] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[2]);
		dataField.setValue(5.9);
		dataFields[2] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue(2.1);
		dataFields[3] = dataField;
		
		dataField = new DataField();
		dataField.setDataHeader(dataHeaders[1]);
		dataField.setValue("Iris-virginica");
		dataFields[4] = dataField;
		
		dataItems[9].setDataFields(dataFields);
		dataItems[9].setDataHeaders(dataHeaders);
		
		//////////////////
		
		
		dataSet.setDataItems(dataItems);
		
		return dataSet;
		
	}
	

}
