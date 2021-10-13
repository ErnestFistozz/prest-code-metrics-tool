/**
 * 
 */
package categorizer.core.filter;

import java.util.Vector;

import categorizer.core.ContextBuilder;
import categorizer.core.DataItem;
import categorizer.core.DataSet;
import categorizer.core.Option;
import categorizer.core.UnsupportedDataContextException;

import common.DataContext;

/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public abstract class Filter implements ContextBuilder{

	
	/**
	 * Label of the className tag
	 */
	private final static String classNameTag = "className";
	
	/**
	 * Label of the options tag
	 */
	private final static String optionsTag = "options";
	
	/**
	 * Label of the option tag
	 */
	private final static String optionTag = "option";
	
	/**
	 * holds the classname of the current filter
	 */
	protected String className;
	
	/**
	 * holds the options of the current filter
	 */
	protected Option[] options;
	
	/**
	 * true if the filter can only be applied to the whole set
	 */
	protected boolean isSetFilter; 
	
	/**
	 * default constructor
	 */
	public Filter() {
		// TODO Auto-generated constructor stub
		className = this.getClass().getName();
		isSetFilter = false;
	}
	
	/**
	 * Constructor with the options field
	 * @param options
	 */
	public Filter(Option[] options){
		
		this.options = options;
		isSetFilter = false;
		
	}

	/**
	 * Filters the whole dataset in the parameter
	 * @param dataSet
	 * @return
	 * @throws Exception
	 */
	public DataSet filter(DataSet dataSet) throws Exception
	{
		return null;
	}
	
	
	/**
	 * Filters the dataItem in the parameter
	 * @param dataItem
	 * @return
	 * @throws Exception
	 */
	public DataItem filter(DataItem dataItem) throws Exception 
	{
		
		return dataItem;
	}

	/**
	 * @return the options
	 */
	public Option[] getOptions() {
		return options;
	}

	/**
	 * @param options the options to set
	 */
	public void setOptions(Option[] options) {
		this.options = options;
	}

	/* (non-Javadoc)
	 * @see categorizer.core.ContextBuilder#load(common.DataContext)
	 */
	public void load(DataContext dataContext) throws Exception {
		
		DataContext optionsContext = dataContext.getNode(optionsTag);
		
		if(optionsContext != null )
			throw new UnsupportedDataContextException();
		
		Vector optionsVector = optionsContext.getNodes(optionTag);
		
		if(optionsVector != null && optionsVector.size() > 0)
		{
			this.options = new Option[optionsVector.size()];
			
			for(int i=0; i<options.length; i++)
			{
				options[i] = new Option();
				options[i].load((DataContext)optionsVector.get(i));
			}
		}
	
	}

	/* (non-Javadoc)
	 * @see categorizer.core.ContextBuilder#store()
	 */
	public DataContext store() throws Exception {

		DataContext dataContext = new DataContext();
		DataContext optionsContext = new DataContext();
		
		for(int i=0; this.options != null && i<this.options.length ; i++)
		{
			optionsContext.add(optionTag,this.options[i].store());
		}
		
		dataContext.add(optionsTag,optionsContext);
		
		return dataContext;
	}

	/**
	 * @return the isSetFilter
	 */
	public boolean isSetFilter() {
		return isSetFilter;
	}

	/**
	 * @param isSetFilter the isSetFilter to set
	 */
	public void setSetFilter(boolean isSetFilter) {
		this.isSetFilter = isSetFilter;
	}

	
	
	
	
}
