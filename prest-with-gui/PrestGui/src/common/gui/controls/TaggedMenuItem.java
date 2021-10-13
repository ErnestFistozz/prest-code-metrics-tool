package common.gui.controls;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

/**
 * Softlab 2009  
 * @author TurgayA   
 */

public class TaggedMenuItem extends JMenuItem
{
	private static final long serialVersionUID = 1L;

	protected int m_iId = 0;
	protected int m_iIndex = 0;

	/**
	 * This constructor creates a menu item with the given caption.
	 * @param s caption of the menu item to be created.
	 */
	public TaggedMenuItem(String s)
	{
		super(s);
	}

	/**
	 * This constructor creates a menu item with the given caption.
	 * @param s caption of the menu item to be created.
	 * @param id unique id for the menu item.
	 * @param index index of the menu item in the menu item list.
	 */
	public TaggedMenuItem(String s, int id, int index)
	{
		this(s);
		m_iId = id;
		m_iIndex = index;
	}

	/**
	 * Returns the id of the menu item.
	 * @return id of the menu item.
	 */
	public int getId()
	{
		return m_iId;
	}

	/**
	 * Returns the index of the menu item.
	 * @return index of the menu item.
	 */
	public int getIndex()
	{
		return m_iIndex;
	}

	public String toEditString()
	{
		StringBuffer buffer = new StringBuffer();
		String text = getText();
		if (text != null)
			buffer.append(text);
		buffer.append('~');
		buffer.append(m_iId);
		return buffer.toString();
	}

	public int getUniqueIdentifier()
	{
		return m_iId;
	}

	public void doFireActionPerformed(ActionEvent event, int actionID)
	{
		final ActionEvent actionEvent = event;
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				paintAsSelected();
				fireActionPerformed(actionEvent);
			}
		});

	}

	public void paintAsSelected()
	{
		TaggedMenu popupMenu = null;
		//Just for giving the feeling selected (AbstractButton.doClick)
		if (getParent() != null && getParent() instanceof TaggedMenu)
		{
			popupMenu = (TaggedMenu) getParent();

			for (int i = 0; i < popupMenu.getMenuItemCount(); i++)
			{
				JMenuItem menuItem = popupMenu.getMenuItem(i);
				if (menuItem != null && menuItem.isVisible())
				{
					menuItem.getModel().setArmed(false);
					menuItem.getModel().setPressed(false);
					menuItem.paintImmediately(new Rectangle(0, 0, getSize().width, getSize().height));
				}
			}
		}

		getModel().setArmed(true);
		getModel().setPressed(true);
		paintImmediately(new Rectangle(0, 0, getSize().width, getSize().height));
		// [End] Just for giving the feeling selected
	}

	public boolean canHaveLayoutManager()
	{
		return false;
	}
}
