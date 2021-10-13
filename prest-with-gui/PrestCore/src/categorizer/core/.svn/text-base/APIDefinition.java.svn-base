/**
 * 
 */
package categorizer.core;

import java.util.Vector;

import common.DataContext;
import common.NodePair;

/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public abstract class APIDefinition {

	/**
	 * label of the Categorizer
	 */
	protected String label;

	/**
	 * name of the categorizer className
	 */
	protected String className;

	/**
	 * description of the Categorizer
	 */
	protected String description;

	/**
	 * optionDefinitions of the categorizer
	 */
	protected OptionDefinition[] optionDefinitions;

	/**
	 * Tag name of the label
	 */
	private final String labelTag = "label";

	/**
	 * Tag name of the class name
	 */
	private final String classNameTag = "className";

	/**
	 * Tag name of the description
	 */
	private final String descriptionTag = "description";

	/**
	 * Tag name of the option definitions
	 */
	private final String optionsTag = "options";

	/**
	 * Tag name of a single option definition
	 */
	private final String optionTag = "option";

	

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className
	 *            the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the optionDefinitions
	 */
	public OptionDefinition[] getOptionDefinitions() {
		return optionDefinitions;
	}

	/**
	 * @param optionDefinitions
	 *            the optionDefinitions to set
	 */
	public void setOptionDefinitions(OptionDefinition[] optionDefinitions) {
		this.optionDefinitions = optionDefinitions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see categorizer.core.ContextBuilder#load(common.DataContext)
	 */

	public void load(DataContext dataContext)
			throws UnsupportedDataContextException {

		if (dataContext == null)
			throw new UnsupportedDataContextException();

		Vector tempVector = dataContext.getElements2(labelTag);

		if (tempVector == null || tempVector.size() == 0)
			throw new UnsupportedDataContextException();

		this.label = new String((String) tempVector.get(0));

		tempVector = dataContext.getElements2(classNameTag);

		if (tempVector == null || tempVector.size() == 0)
			throw new UnsupportedDataContextException();

		this.className = new String((String) tempVector.get(0));

		tempVector = dataContext.getElements2(descriptionTag);

		if (tempVector == null || tempVector.size() == 0)
			throw new UnsupportedDataContextException();

		this.description = new String((String) tempVector.get(0));

		DataContext optionDefinitions = dataContext.getNode(optionsTag);

		if (optionsTag == null)
			throw new UnsupportedDataContextException();

		Vector options = optionDefinitions.getNodes(optionTag);

		if (options != null && options.size() > 0) {
			this.optionDefinitions = new OptionDefinition[options.size()];

			for (int i = 0; i < options.size(); i++) {
				OptionDefinition optDef = new OptionDefinition();
				optDef.load((DataContext) options.get(i));
				this.optionDefinitions[i] = optDef;
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see categorizer.core.ContextBuilder#store()
	 */

	public DataContext store() {

		DataContext dataContext = new DataContext();

		dataContext.add(new NodePair(labelTag, this.label));
		dataContext.add(new NodePair(classNameTag, this.className));
		dataContext.add(new NodePair(descriptionTag, this.description));

		dataContext.add(optionsTag, new DataContext());
		
		if(optionDefinitions!=null){
			for (int i = 0; i < optionDefinitions.length; i++) {
				dataContext.getNode(optionsTag).add(optionTag,
						optionDefinitions[i].store());
			}
		}
		
		return dataContext;
	}


	/**
	 * Creates an instance of the Object presented with this definition
	 * @return
	 * @throws Exception
	 */
	public Object createInstance()  throws Exception {
		return null;
	}
	
	
	
	/**
	 * Creates an instance of the Object presented with this definition
	 * @param options
	 * @return
	 * @throws Exception
	 */
	public Object createInstance(Option[] options)  throws Exception {

		return null;
	}

	
	

}
