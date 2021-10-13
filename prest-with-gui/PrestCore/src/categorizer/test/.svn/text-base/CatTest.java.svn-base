/**
 * 
 */
package categorizer.test;

import common.DataContext;
import common.NodePair;

/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class CatTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DataContext dataContext = new DataContext();
		
		dataContext.add("item",new DataContext());
		
		for(int i=0; i<100; i++)
		{
			//DataContext newDataContext = new DataContext();
			
			dataContext.getNode("item").add(new NodePair("value",String.valueOf(i)));
			//dataContext.getNode("item").add(new NodePair("value", "" + i));
		}
		
		dataContext.getNode("item").remove("value");
		
		dataContext.getNode("item").add(new NodePair("value","Acaba?"));
		
		/*
		
		dataContext.getNode("item").add("value",new DataContext());
		
		
		
		DataContext newDataContext = new DataContext();
		
		newDataContext.add("value",new DataContext());
		
		newDataContext.getNode("value").add(new NodePair("key","value"));
		
		dataContext.getNode("item").append(newDataContext);
		*/
		
		dataContext.writeToFile("c:/deneme.xml");
		/*
		
		DataContext node = dataContext.getNode("item");
		
		Vector vector = node.getNodes("value");
		
		
		
		//DataContext subnode = node.getNodeCount()
		
		//Vector vector = node.get("item/value");
		
		//System.out.println(node.getFirstNodeValue("value"));
		System.out.println(vector.size());
		System.out.println("Vector size :" +  node.getElementCount());
		// System.out.println("Vector size :" +  node.getNodeCount());
		
		
		for(int i=0; i<vector.size(); i++)
		{
			DataContext context = (DataContext)vector.get(i);
			System.out.println(context.toString());
			//System.out.println( i + " : " +  vector.get(i).getClass().cast("MyString") + " --- " + vector.get(i));
		}
		*/
	}

}
