package common.gui.controls;

import javax.swing.JMenuItem;

/**
 * Softlab June 2009  
 * @author TurgayA   
 */

public interface IMenuFilter
{
	boolean isItemVisible(JMenuItem item);
	boolean isItemEnabled(JMenuItem item);
}
