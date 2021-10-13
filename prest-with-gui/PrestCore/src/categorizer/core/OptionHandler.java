package categorizer.core;

import common.DataContext;

/**
 * <p>OptionHandler is the interface which enables to load and to store Options to/from 
 * the class which implements this interface. 
 * <p>This interface is implemented by all categorizers. Therefore all categorizers
 * can be loaded with options specific to itself. 
 *
 *
 * @author secil.karagulle
 * @author ovunc.bozcan
 */

public interface OptionHandler {

	/**
	 * @param options, the options in DataContext to load
	 * @throws UnsupportedDataContextException 
	 */
	public void loadOptions(DataContext options) throws UnsupportedDataContextException;
		
	/**
	 * @returns the Options in a DataContext
	 */
	public DataContext storeOptions();
	
}
