package common.gui.controls;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import common.gui.util.TaggedList;

/**
 * Softlab June 2009  
 * @author TurgayA   
 */

public class TaggedMenu extends JPopupMenu implements PopupMenuListener
{
	private static final long serialVersionUID = 1L;

	private static final String CONTROL_TAG_PROPERTY = "TAG";
	private static final String CONTROL_VALUE_PROPERTY = "VALUE";
	
	private static TaggedMenu ms_ActivePopup;

	protected int m_iIndex = -1;
	protected ArrayList<TaggedMenuItem> m_Items = new ArrayList();
	protected ActionListener m_ActionListener = null;
	protected IMenuFilter m_ItemFilter = null;

	private boolean m_ItemsAddedToParent = false;

	/**
	 * Default constructor.
	 */
	public TaggedMenu()
	{
		addPopupMenuListener(this);
	}

	/**
	 * Adds a menu item with a given caption. The <i>id</i> value is used to
	 * distinguish menu items in the action listener.
	 * @param s menu item caption.
	 * @param id unique id for the menu item.
	 * @return index value of the menu item in the list.
	 */
	public int add(String s, int id)
	{
		m_iIndex++;
		if (s == null || s.length() == 0)
			s = "-";
		TaggedMenuItem item = new TaggedMenuItem(s, id, m_iIndex);
		// While recording Parent(JLbsPopupMenu) is found by component's parent swing component in JLbsXUIComponentHelper.getParentTag
		item.putClientProperty(CONTROL_TAG_PROPERTY, new Integer(id));
		item.putClientProperty(CONTROL_VALUE_PROPERTY, "");
		item.setComponentOrientation(getComponentOrientation());

		if (m_ActionListener != null)
			item.addActionListener(m_ActionListener);

		m_Items.add(item);
		return m_iIndex;
	}

	public int insert(int index, String s, int id)
	{
		m_iIndex++;
		if (s == null || s.length() == 0)
			s = "-";
		TaggedMenuItem item = new TaggedMenuItem(s, id, index);
		item.setComponentOrientation(getComponentOrientation());

		if (m_ActionListener != null)
			item.addActionListener(m_ActionListener);

		m_Items.add(index, item);
		return m_iIndex;
	}

	public void addSeparator()
	{
		if (m_ItemsAddedToParent)
		{
			JSeparator separator = new JPopupMenu.Separator();
			separator.setComponentOrientation(getComponentOrientation());
			super.add(separator);
		}
		else
			add("-", 0);
	}

	public void addItems(TaggedList list)
	{
		if (list != null)
		{
			int iLen = list.size();
			for (int i = 0; i < iLen; i++)
			{
				add(list.getValueAt(i), list.getTagAt(i));
			}
		}
	}

	public String getItemsSList()
	{
		if (m_Items != null)
		{
			StringBuffer buffer = new StringBuffer();
			Object obj;
			for (int i = 0; i < m_Items.size(); i++)
			{
				obj = m_Items.get(i);
				if (obj instanceof TaggedMenuItem)
				{
					TaggedMenuItem item = (TaggedMenuItem) obj;

					if (buffer.length() > 0)
						buffer.append("\n");
					buffer.append(item.toEditString());
				}
			}
			return buffer.toString().replaceAll("\n", "|");
		}
		return null;
	}

	public void clearItems()
	{
		m_Items.clear();
		m_iIndex = -1;
	}

	/**
	 * Updates the default action listener for newly created menu items.
	 * @param actionListener default action listener for menu items.
	 */
	public void setActionListener(ActionListener actionListener)
	{
		m_ActionListener = actionListener;
	}

	/**
	 * Updates the item filter listener.
	 * @param listener new item filter listener for menu items.
	 */
	public void setItemFilter(IMenuFilter listener)
	{
		m_ItemFilter = listener;
	}

	/**
	 * @see javax.swing.event.PopupMenuListener#popupMenuCanceled(PopupMenuEvent)
	 */
	public void popupMenuCanceled(PopupMenuEvent arg0)
	{
	}

	/**
	 * @see javax.swing.event.PopupMenuListener#popupMenuWillBecomeInvisible(PopupMenuEvent)
	 */
	public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0)
	{
	}

	/**
	 * @see javax.swing.event.PopupMenuListener#popupMenuWillBecomeVisible(PopupMenuEvent)
	 */
	public void popupMenuWillBecomeVisible(PopupMenuEvent arg0)
	{
		super.removeAll();
		boolean bSepWanted = false;
		for (int i = 0; i < m_Items.size(); i++)
		{
			JMenuItem item = (JMenuItem) m_Items.get(i);

			boolean bInclude = (m_ItemFilter != null) && (item instanceof TaggedMenuItem)
					? m_ItemFilter.isItemVisible(item)
					: true;
			if (bInclude)
			{
				if ("-".compareTo(item.getText()) == 0)
					bSepWanted = true;
				else
				{
					if (bSepWanted && item.isVisible())
					{
						bSepWanted = false;
						super.addSeparator();
					}
					if (item instanceof TaggedMenuItem)
						item.setEnabled(m_ItemFilter == null || m_ItemFilter.isItemEnabled(item));
					super.add(item);
				}
			}
		}

		m_ItemsAddedToParent = false;
	}

	public void doPopupMenuWillBecomeVisible(PopupMenuEvent arg0, int actionID)
	{
		final PopupMenuEvent event = arg0;
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				popupMenuWillBecomeVisible(event);
				setVisible(true);
			}
		});
	}

	public void doShow(Component invoker, int x, int y, int actionID)
	{
		final int fX = x;
		final int fY = y;
		final Component fInvoker = invoker;
		
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				show(fInvoker, fX, fY);
			}
		});
	}

	public boolean hasItemTag(int tag)
	{
		for (int i = 0; i < m_Items.size(); i++)
		{
			Object obj = m_Items.get(i);
			if (obj instanceof TaggedMenuItem)
			{
				TaggedMenuItem item = (TaggedMenuItem) obj;
				if (item.getId() == tag)
					return true;
			}
		}
		return false;
	}

	public boolean isItemWTagEnabled(int tag)
	{
		for (int i = 0; i < m_Items.size(); i++)
		{
			Object obj = m_Items.get(i);
			if (obj instanceof TaggedMenuItem)
			{
				TaggedMenuItem item = (TaggedMenuItem) obj;
				if (item.getId() == tag)
					return item.isEnabled() && (m_ItemFilter == null || m_ItemFilter.isItemEnabled(item));
			}
		}
		return false;
	}

	public boolean isItemWTagVisible(int tag)
	{
		for (int i = 0; i < m_Items.size(); i++)
		{
			Object obj = m_Items.get(i);
			if (obj instanceof TaggedMenuItem)
			{
				TaggedMenuItem item = (TaggedMenuItem) obj;
				if (item.getId() == tag)
					return item.isVisible() && (m_ItemFilter == null || m_ItemFilter.isItemVisible(item));
			}
		}
		return false;
	}

	public int getMenuItemCount()
	{
		return m_Items.size();
	}

	public JMenuItem getMenuItem(int index)
	{
		return (index < m_Items.size() && index >= 0)
				? (JMenuItem) m_Items.get(index)
				: null;
	}

	public JMenuItem getMenuItemByTag(int tag)
	{
		for (int i = 0; i < m_Items.size(); i++)
		{
			Object obj = m_Items.get(i);
			if (obj instanceof TaggedMenuItem)
			{
				TaggedMenuItem item = (TaggedMenuItem) obj;
				if (item.getId() == tag)
					return item;
			}
		}
		return null;
	}

	public void setIcon(int index, Icon icon)
	{
		setIcon(index, icon, null);
	}

	public void setIcon(int index, Icon icon, KeyStroke key)
	{
		JMenuItem item = getMenuItem(index);
		if (item != null)
		{
			item.setIcon(icon);
			if (key != null)
				item.setAccelerator(key);
		}
	}

	public void setVisible(boolean b)
	{
		if (b)
		{
			ComponentOrientation o = getComponentOrientation();
			applyComponentOrientation(o);
			Component item;
			for (int i = 0; i < m_Items.size(); i++)
			{
				Object obj = m_Items.get(i);
				if (obj instanceof Component)
				{
					item = (Component) m_Items.get(i);
					item.setComponentOrientation(o);
				}
			}
		}

		super.setVisible(b);
		setActivePopup((b)
				? this
				: null);
	}

	public static TaggedMenu getActivePopup()
	{
		synchronized (TaggedMenu.class)
		{
			return ms_ActivePopup;
		}
	}

	public static void setActivePopup(TaggedMenu activePopup)
	{
		synchronized (TaggedMenu.class)
		{
			ms_ActivePopup = activePopup;
		}
	}

	public static void closeActivePopup()
	{
		final TaggedMenu popup;
		synchronized (TaggedMenu.class)
		{
			popup = ms_ActivePopup;
		}
		if (popup != null)
			SwingUtilities.invokeLater(new Runnable()
			{
				public void run()
				{
					popup.setVisible(false);
				}
			});
	}

	protected JMenuItem createActionComponent(Action a)
	{
		JMenuItem mi = super.createActionComponent(a);
		mi.setComponentOrientation(getComponentOrientation());
		return mi;
	}

	public boolean canHaveLayoutManager()
	{
		return false;
	}

	public void addDirect(TaggedMenuItem menuItem)
	{
		if (menuItem != null)
			m_Items.add(menuItem);
	}

	public void updateUI()
	{
		super.updateUI();

		if (m_Items == null)
			return;

		Object obj;
		for (int i = 0; i < m_Items.size(); i++)
		{
			obj = m_Items.get(i);

			if (obj instanceof Component)
				SwingUtilities.updateComponentTreeUI((Component) obj);
		}
	}

}
