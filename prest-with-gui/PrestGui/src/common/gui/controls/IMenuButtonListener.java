package common.gui.controls;

/**
 * Softlab 2009  
 * @author TurgayA   June 2009
 */

public interface IMenuButtonListener
{
	void actionPerformed(MenuButton button, int actionIndex);
	void popupButtonPressed(MenuButton button);
		
	boolean menuButtonActionFiltered(MenuButton button, int actionIndex);
	boolean menuButtonActionValid(MenuButton button, int actionIndex);
}
