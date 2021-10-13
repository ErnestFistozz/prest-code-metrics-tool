/**
 * 
 */
package categorizer.core;

import java.lang.reflect.InvocationTargetException;
import java.util.Vector;

import common.DataContext;
import common.NodePair;
import common.monitor.Logger;

/**
 * <p>CategorizerDefinition is used to hold the definition of a categorizer. It is
 * used to present a categorizer and its options and to create an instance of
 * the categorizer presented. This class is especially created for modularity
 * purposes. With the help of this class User interface can be completely
 * independent from categorizer part. New categorizers can be developed without
 * changing the User-Interface part. The idea is that definition of all
 * categorizers will be stored in xml and with reading that xml in the run-time,
 * user interface part can be present categorizers and can create an instance of
 * anyone desired. As one can figure out from above CategorizerDefinition
 * implements the ContextBuilder interface which means that
 * CategorizerDefinition can be loaded and store as DataContext.
 * 
 * @author secil.karagulle
 * @author ovunc.bozcan
 */

public class CategorizerDefinition implements ContextBuilder {

	/**
	 * label of the Categorizer
	 */
	private String label;

	/**
	 * name of the categorizer className
	 */
	private String className;

	/**
	 * description of the Categorizer
	 */
	private String description;

	/**
	 * optionDefinitions of the categorizer
	 */
	private OptionDefinition[] optionDefinitions;

	/**
	 * Tag name of categorizer definition
	 */
	private final String currentTag = "categorizer";
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
	 * default constructor
	 */
	public CategorizerDefinition() {
		super();
	}

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
	 * Creates an instance of the categorizer presented with this
	 * CategorizerDefinition
	 * @return Categorizer Instance
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * 
	 */
	public CategorizerExecutor createInstance()  throws ClassNotFoundException,
			SecurityException, NoSuchMethodException, IllegalArgumentException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {


		Logger.debug("Creating Instance");
		Logger.debug(this.className);

		System.out.println("Creating Instance");
		System.out.println(this.className);
		
		CategorizerExecutor categorizerExec = new CategorizerExecutor();
		categorizerExec.setcategorizerClassName(this.className);
	//	Class categorizer = Class.forName(this.className);
	//	Constructor constructor = categorizer.getDeclaredConstructor(null);

	//	return (CategorizerExecutor) constructor.newInstance(null);
		return categorizerExec;
	}
	
	
	/**
	 * Creates an instance of the categorizer presented with this
	 * CategorizerDefinition
	 * @return Categorizer Instance
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * 
	 */
	public CategorizerExecutor createInstance(Option[] categorizerOptions)  throws ClassNotFoundException,
			SecurityException, NoSuchMethodException, IllegalArgumentException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {


		Logger.debug("Creating Instance");
		Logger.debug(this.className);

		System.out.println("Creating Instance");
		System.out.println(this.className);
		
		CategorizerExecutor categorizerExec = new CategorizerExecutor();
		categorizerExec.setcategorizerClassName(this.className);
	//	Class categorizer = Class.forName(this.className);
	//	Constructor constructor = categorizer.getDeclaredConstructor(null);

	//	return (CategorizerExecutor) constructor.newInstance(null);
		categorizerExec.setCategorizerOptions(categorizerOptions);
		return categorizerExec;
	}

}
