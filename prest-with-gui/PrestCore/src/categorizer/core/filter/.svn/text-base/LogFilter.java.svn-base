/**
 * 
 */
package categorizer.core.filter;

import categorizer.core.DataField;
import categorizer.core.DataItem;
import categorizer.core.DataSet;
import categorizer.core.Option;

/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class LogFilter extends Filter{

	private int index = 0;

	

	
	/**
	 * default constructor
	 */
	public LogFilter() {
		super();
		isSetFilter = false;
	}


	/**
	 * constructor using options field
	 * @param options
	 */
	public LogFilter(Option[] options) {
		super(options);
		isSetFilter = false;
		if(options !=  null && options.length > 0)
			index = Integer.parseInt(options[0].getValue());
	}


	/* (non-Javadoc)
	 * @see categorizer.core.filter.Filter#filter(categorizer.core.DataSet)
	 */
	public DataSet filter(DataSet dataSet) throws Exception {
		
		DataItem[] dataItems = dataSet.getDataItems();
		for(int i=0; i<dataItems.length; i++)
		{
			dataItems[i] = filter(dataItems[i]);
		}
		return dataSet;
	}

	
	/* (non-Javadoc)
	 * @see categorizer.core.filter.Filter#filter(categorizer.core.DataItem)
	 */
	public DataItem filter(DataItem dataItem) throws Exception {
		
		DataField dataField = dataItem.getDataFields()[index];
		
		dataField.setValue(Math.log((Double)dataField.getValue()));
		
		return dataItem;

	}


	/* (non-Javadoc)
	 * @see categorizer.core.filter.Filter#setOptions(categorizer.core.Option[])
	 */
	public void setOptions(Option[] options) {
		if(options !=  null && options.length > 0)
			index = Integer.parseInt(options[0].getValue());
		super.setOptions(options);
	}


	
	
	
	
	
	
}
