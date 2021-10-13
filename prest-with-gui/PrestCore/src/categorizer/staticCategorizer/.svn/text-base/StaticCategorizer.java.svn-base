package categorizer.staticCategorizer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import categorizer.aiCategorizer.core.ConfusionMatrix;
import categorizer.core.Categorizer;
import categorizer.core.DataItem;
import categorizer.core.Threshold;

public class StaticCategorizer extends Categorizer {

	
	
	/* (non-Javadoc)
	 * @see categorizer.core.Categorizer#buildCategorizer()
	 */
	public ConfusionMatrix buildCategorizer() throws Exception {
		return validate(dataSet);
	}

	/* (non-Javadoc)
	 * @see categorizer.core.Categorizer#categorize(categorizer.core.DataItem)
	 * TODO 
	 * threshold compare'deki sorun burada da var
	 */
	public DataItem categorize(DataItem dataItem) throws Exception {
		
		HashMap classMap = new HashMap();
		int classIndex = dataSet.getDataHeaders().length - 1;
		if(dataSet.getClassIndex() != -1 && classIndex != dataSet.getClassIndex())
			classIndex = dataSet.getClassIndex();
		
		String[] classes = dataSet.getDataHeaders()[classIndex].getAvailableValue();
		String classValue = classes[0];		
		
		for(int i=0; i<dataItem.getDataFields().length; i++)
		{
			if(dataSet.getDataHeaders()[i].isValid())
			{
				Threshold thresholds[] = dataSet.getDataHeaders()[i].getThresholds();
				for(int j=0; thresholds!=null && j<thresholds.length; j++)
				{
					if(thresholds[j].compare(dataItem))
					{
						int count = 0;
						if(classMap.containsKey(thresholds[j].getClassValue()))
							count = (Integer)classMap.get(thresholds[j].getClassValue());
						count++; 
						classMap.put(thresholds[j].getClassValue(), count);
					}
				}
			}
		}
		
	
		Set classSet = classMap.keySet();
		
		if(classSet != null && classSet.size() > 0)
		{
			int classCount = 0;
			Iterator iterator = classSet.iterator();
			while(iterator.hasNext())
			{
				String temp = (String)iterator.next();
				if(classMap.containsKey(temp))
				{
					int count = (Integer)classMap.get(temp);
					if(count > classCount)
					{
						classCount = count;
						classValue = temp;
					}
				}
			}
		}
		
		
		dataItem.getDataFields()[classIndex].load(classValue);		
		
		return dataItem;
	}



	

}
