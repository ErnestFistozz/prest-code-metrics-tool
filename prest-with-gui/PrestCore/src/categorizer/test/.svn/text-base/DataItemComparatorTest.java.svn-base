/**
 * 
 */
package categorizer.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import categorizer.aiCategorizer.decisionTree.DataItemComparator;
import categorizer.core.DataItem;
import categorizer.core.DataSet;
import categorizer.core.util.Arff2DataSet;

/**
 * @author TCOBOZCAN
 *
 */
public class DataItemComparatorTest {

	private final static String dataSetFileName = "C:/Prest/Test/iris.arff";
	private final static int headerIndex = 0;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Arff2DataSet converter = new Arff2DataSet(dataSetFileName);
			DataSet dataSet = converter.reader();
			
			List itemList = new ArrayList();
			for(int i=0; i<dataSet.getDataItems().length; i++)
			{
				itemList.add(dataSet.getDataItems()[i]);
			}
			
			DataItemComparator dataItemComparator = new DataItemComparator(headerIndex);
			
			Collections.sort(itemList, dataItemComparator);
			
			for(int i=0; i<itemList.size(); i++)
			{
				System.out.println(((DataItem)itemList.get(i)).getDataFields()[headerIndex].getStringValue());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
