/**
 * 
 */
package categorizer.core;

import java.util.Vector;

import common.DataContext;
import common.NodePair;

/**
 * This class is used to hold an option with its value
 * 
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class Option implements ContextBuilder{
	
	/**
	 * Label of the option
	 */
	private String label ;
	
	/**
	 * Value of the option
	 */
	private String value ;
	
	/**
	 * Tag name of the Option
	 */
	private final String currentTag = "Option";
	
	/**
	 * Tag name of the label
	 */
	private final String labelTag = "Label" ;
	
	/**
	 * Tag name of the value
	 */
	private final String valueTag = "Value" ;

	/**
	 * default constructor
	 */
	public Option() {
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see categorizer.core.ContextBuilder#load(common.DataContext)
	 */

	public void load(DataContext optionDataContext)
			throws UnsupportedDataContextException {
		
		Vector optionVariables = optionDataContext.getElements2(labelTag);
		
		if(optionVariables == null)
		{
			throw new UnsupportedDataContextException();
		}
		
		this.label = (String)optionVariables.get(0);
		
		optionVariables = optionDataContext.getElements2(valueTag);
		
		if(optionVariables == null)
		{
			throw new UnsupportedDataContextException();
		}
		
		this.value = (String)optionVariables.get(0);
	}

	/* (non-Javadoc)
	 * @see categorizer.core.ContextBuilder#store()
	 */

	public DataContext store() {

		DataContext dataContext = new DataContext();
		
		dataContext.add(new NodePair(labelTag,this.label));
		
		dataContext.add(new NodePair(valueTag,this.value));
		
		return dataContext;
	}
	
	
}
