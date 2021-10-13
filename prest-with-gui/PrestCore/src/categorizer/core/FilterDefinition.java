/**
 * 
 */
package categorizer.core;

import java.lang.reflect.Constructor;

import categorizer.core.filter.Filter;

import common.monitor.Logger;


/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class FilterDefinition extends APIDefinition {

	/* (non-Javadoc)
	 * @see categorizer.core.APIDefinition#createInstance()
	 */
	@Override
	public Object createInstance() throws Exception {

		Logger.debug("Creating Instance");
		Logger.debug(this.className);

		System.out.println("Creating Instance");
		System.out.println(this.className);
		
		Class filterClass = Class.forName(this.className);
		Constructor constructor = filterClass.getDeclaredConstructor(null);

		Filter filter = (Filter)constructor.newInstance(null);
		
		return filter;
	}

	/* (non-Javadoc)
	 * @see categorizer.core.APIDefinition#createInstance(categorizer.core.Option[])
	 */
	@Override
	public Object createInstance(Option[] options) throws Exception {
		
		Logger.debug("Creating Instance");
		Logger.debug(this.className);

		System.out.println("Creating Instance");
		System.out.println(this.className);
		
		Class filterClass = Class.forName(this.className);
		Constructor constructor = filterClass.getDeclaredConstructor(null);

		Filter filter = (Filter)constructor.newInstance(null);
		filter.setOptions(options);
		
		return filter;
	}

	
	
}
