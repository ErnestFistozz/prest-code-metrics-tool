package common.gui.controls;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import common.gui.util.GUIUtilities;
import common.gui.util.TaggedList;

/**
 * Softlab 2009  
 * @author TurgayA   
 */

public class TaggedComboBox extends JComboBox
{
	private static final long serialVersionUID = 1L;

	public static final int EMPTYTAG = 0;

	private ArrayList<TaggedComboItem> m_ItemList = new ArrayList();
	private IComboFilterListener m_FilterListener = null;
	private boolean m_DisableEvents;
	private boolean m_Internal = false;

	/**
	 * Default constructor
	 */
	public TaggedComboBox()
	{
		enableEvents(AWTEvent.KEY_EVENT_MASK);
	}


	/**
	 * This constructor initializes the combo items with the given list.
	 * @param list String list that contains the combo item captions and 
	 * optional tag values.
	 */
	public TaggedComboBox(TaggedList list)
	{
		this();
		setItems(list);
	}

	/**
	 * This constructor initializes the combo items with the given list.
	 * @param list String list that contains the combo item objects.
	 */
	public TaggedComboBox(Object[] list)
	{
		if (list != null)
			for (int i = 0; i < list.length; i++)
			{
				TaggedComboItem item = new TaggedComboItem(list[i], i);
				m_ItemList.add(item);
			}
		doFilterItems();
	}

	/**
	 * Adds an object to the combo item list.
	 * @param anObject Object to be added.
	 */
	public void addItem(Object anObject)
	{
		super.addItem(new TaggedComboItem(anObject, EMPTYTAG));
	}

	/**
	 * Adds an object to the combo item list.
	 * @param anObject Object to be added.
	 * @param iTag Tag value for the object.
	 */
	public void addItem(Object anObject, int iTag)
	{
		TaggedComboItem item = new TaggedComboItem(anObject, iTag);
		super.addItem(item);
		m_ItemList.add(item);
	}

	/**
	 * Adds a list of items whose captions and tag values are given
	 * as the argument.
	 * @param list List of combo items and optional tag values.
	 */
	public void addItems(TaggedList list)
	{
		if (list != null)
		{
			int iLen = list.size();
			for (int i = 0; i < iLen; i++)
				addItem(list.getValueAt(i), list.getTagAt(i));
		}
	}

	/**
	 * Remove all the combo items.
	 */
	public void clearItems()
	{
		super.removeAllItems();
		m_ItemList.clear();
	}

	/**
	 * Update the combo item list.
	 */
	public void setItems(TaggedList list)
	{
		clearItems();
		addItems(list);
		internalVerifyInput();
	}

	private boolean internalVerifyInput()
	{
		InputVerifier verifier = getInputVerifier();
		boolean verified = false;
		if (verifier != null)
		{
			verified = verifier.verify(this);
		}
		return verified;
	}

	/**
	 * Returns the tag value of the selected combo item.
	 */
	public int getSelectedItemTag()
	{
		Object selObject = getSelectedItem();
		if (selObject instanceof TaggedComboItem)
		{
			TaggedComboItem item = (TaggedComboItem) selObject;
			return item.getTag();
		}
		return EMPTYTAG;
	}

	/**
	 * Selects the combo item whose tag value is equal to <i>iTag</i>.
	 * @param iTag Tag value of the item to be selected.
	 */
	public boolean setSelectedItemTag(int iTag)
	{
		try
		{
			m_Internal = true;
			int iLen = getItemCount();
			for (int i = 0; i < iLen; i++)
			{
				Object itemObj = getItemAt(i);
				if (itemObj instanceof TaggedComboItem && ((TaggedComboItem) itemObj).getTag() == iTag)
				{
					setSelectedIndex(i);
					return true;
				}
			}

			return false;
		}
		finally
		{
			m_Internal = false;
		}
	}

	/**
	 * Returns the combo item object with the given tag.
	 * @param iTag Tag value to find.
	 */
	public TaggedComboItem getItemTagObject(int iTag)
	{
		int iLen = getItemCount();
		for (int i = 0; i < iLen; i++)
		{
			Object itemObj = getItemAt(i);
			if (itemObj instanceof TaggedComboItem && ((TaggedComboItem) itemObj).getTag() == iTag)
				return (TaggedComboItem) itemObj;
		}
		return null;
	}

	/**
	 * Checks whether the given item tag corresponds to an item or not.
	 * @param iTag Tag to search.
	 * @return true if the item tag exists, false otherwise.
	 */
	public boolean hasItemTag(int iTag)
	{
		return getItemTagObject(iTag) != null;
	}

	/**
	 * Returns the item value associated with the given item tag.
	 * @param iTag Tag value to search.
	 * @return The associated item value if exists, null otherwise.
	 */
	public Object getItemTagValue(int iTag)
	{
		TaggedComboItem item = getItemTagObject(iTag);
		return (item != null)
				? item.getValue()
				: null;
	}

	/**
	 * Returns the item string associated with the given item tag.
	 * @param iTag Tag value to search.
	 * @return The associated item string if exists, null otherwise.
	 */
	public String getItemTagString(int iTag)
	{
		Object v = getItemTagObject(iTag);
		return (v != null)
				? v.toString()
				: null;
	}

	/**
	 * Selects the combo item whose value is equal to <i>itemText</i>.
	 * @param itemText String value of the item to be selected.
	 */
	public boolean setSelectedItem(String itemText)
	{
		try
		{
			m_Internal = true;
			if (itemText == null)
			{
				setSelectedIndex(-1);
				return true;
			}
			int iLen = getItemCount();
			for (int i = 0; i < iLen; i++)
			{
				Object itemObj = getItemAt(i);
				if (itemObj != null && itemObj.toString().compareTo(itemText) == 0)
				{
					setSelectedIndex(i);
					return true;
				}
			}
			return false;
		}
		finally
		{
			m_Internal = false;
		}
	}

	public Object getSelectedItemValue()
	{
		Object obj = getSelectedItem();
		if (obj instanceof TaggedComboItem)
		{
			obj = ((TaggedComboItem) obj).getValue();
		}
		return obj;
	}

	public int setSelectedItemValue(Object value)
	{
		try
		{
			m_Internal = true;
			if (value != null)
				for (int i = 0; i < m_ItemList.size(); i++)
				{
					TaggedComboItem item = (TaggedComboItem) m_ItemList.get(i);
					Object itemValue = item.getValue();
					if (itemValue != null && itemValue.equals(value))
					{
						setSelectedItem(item);
						return i;
					}
				}
			return -1;
		}
		finally
		{
			m_Internal = false;
		}
	}

	public int getTagOfItem(Object item)
	{
		if (item instanceof TaggedComboItem)
			return ((TaggedComboItem) item).getTag();
		return 0;
	}

	public int findItemIndex(Object value)
	{
		return (value != null)
				? findItemIndex(value.toString())
				: -1;
	}

	public int findItemIndex(String value)
	{
		if (value != null)
			for (int i = 0; i < m_ItemList.size(); i++)
			{
				TaggedComboItem item = (TaggedComboItem) m_ItemList.get(i);
				Object itemValue = item.getValue();
				if (itemValue != null && itemValue.toString().compareTo(value) == 0)
					return i;
			}
		return -1;
	}

	public Object[] getItemlist()
	{
		int size = (m_ItemList != null)
				? m_ItemList.size()
				: 0;
		if (size == 0)
			return null;
		Object[] result = new Object[size];
		for (int i = 0; i < size; i++)
		{
			TaggedComboItem item = (TaggedComboItem) m_ItemList.get(i);
			result[i] = item.getValue();
		}
		return result;
	}

	public IComboFilterListener getFilterListener()
	{
		return m_FilterListener;
	}

	public void setFilterListener(IComboFilterListener listener)
	{
		m_FilterListener = listener;
	}

	public void doFilterItems()
	{
		m_DisableEvents = true;
		try
		{
			Object oSelected = getSelectedItem();
			if (m_FilterListener != null)
			{
				if (getItemCount() > 0)
					super.removeAllItems();
				int iLen = m_ItemList.size();
				for (int i = 0; i < iLen; i++)
				{
					TaggedComboItem item = (TaggedComboItem) m_ItemList.get(i);
					if (m_FilterListener.getFilterMask(this, i, item.getTag()))
						super.addItem(item);
				}
			}
			else
			{
				if (getItemCount() > 0)
					super.removeAllItems();
				int iLen = m_ItemList.size();
				for (int i = 0; i < iLen; i++)
					super.addItem(m_ItemList.get(i));
			}
			setSelectedItem(oSelected);
		}
		finally
		{
			m_DisableEvents = false;
		}
	}

	public void processKeyEvent(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		if (e.isAltDown() && (keyCode == KeyEvent.VK_1 || keyCode == KeyEvent.VK_DOWN))
		{
			e.consume();
			showPopup();
		}
		else if (e.getModifiers() == 0)
		{
			int index = -1;
			try
			{
				index = Integer.parseInt(e.getKeyChar() + "") - 1;
			}
			catch (Exception ex)
			{
			}
			if (index >= 0 && index < getItemCount())
			{
				e.consume();
				setSelectedIndex(index);
			}

		}
		if (!e.isConsumed())
			super.processKeyEvent(e);
	}

	public void addMouseListenerEx(MouseListener l)
	{
		if (l == null)
			return;
		setMouseListener(this, l);
	}

	private void setMouseListener(Component c, MouseListener l)
	{
		c.addMouseListener(l);
		if (c instanceof Container)
		{
			Container cc = (Container) c;
			for (int i = cc.getComponentCount() - 1; i >= 0; i--)
				setMouseListener(cc.getComponent(i), l);
		}
	}

	public static ComboPopup createComboBoxPopup(TaggedComboBox combo)
	{
		return new TaggedComboboxPopup(combo);
	}

	public String getItemsSList()
	{
		if (m_ItemList != null)
		{
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < m_ItemList.size(); i++)
			{
				TaggedComboItem item = (TaggedComboItem) m_ItemList.get(i);
				if (buffer.length() > 0)
					buffer.append("\n");
				buffer.append(item.toEditString());
			}
			return buffer.toString().replaceAll("\n", "|");
		}
		return null;
	}

	public void doSetSelectedItem(int actionID, Object item)
	{
		final Object mItem = item;
		this.setPopupVisible(true);
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					m_DisableEvents = true;
					setPopupVisible(true);
					setSelectedItemTag(GUIUtilities.strToInt((String) mItem, -1));
					setPopupVisible(false);
				}
				catch (Exception e)
				{
					return;
				}
				finally
				{
					m_DisableEvents = false;
				}
			}
		});
	}


	public void doRequestFocus(int actionID)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				requestFocus();
			}
		});
	}

	public boolean isFocusOwner()
	{
		return super.isFocusOwner();
	}

	public void setSelectedIndex(int anIndex)
	{
		if (!m_Internal)
			doFilterItems();
		super.setSelectedIndex(anIndex);
	}

	protected void selectedItemChanged()
	{
		if (!m_DisableEvents)
		{
			super.selectedItemChanged();
		}
	}


	public boolean canHaveLayoutManager()
	{
		return false;
	}
}

class JLbsComboBoxUI extends BasicComboBoxUI
{
	private TaggedComboBox m_ComboBox;

	public JLbsComboBoxUI(TaggedComboBox combo)
	{
		m_ComboBox = combo;
	}

	protected ComboPopup createPopup()
	{
		return TaggedComboBox.createComboBoxPopup(m_ComboBox);
	}

	protected JButton createArrowButton()
	{
		JButton btn = new BasicArrowButton(5, m_ComboBox.getBackground(), SystemColor.controlShadow, SystemColor.controlDkShadow,
				Color.white);
		btn.addMouseListener(new CMBMouseListener());
		return btn;
	}
}

class CMBMouseListener implements MouseListener
{
	public void mouseClicked(MouseEvent e)
	{
		//System.out.println("combo click");
	}

	public void mouseEntered(MouseEvent e)
	{
		//System.out.println("combo entered");
	}

	public void mouseExited(MouseEvent e)
	{
		//System.out.println("combo exit");
	}

	public void mousePressed(MouseEvent e)
	{
		//System.out.println("combo pressed");
	}

	public void mouseReleased(MouseEvent e)
	{
		//System.out.println("combo released");
	}
}

class TaggedComboboxPopup extends BasicComboPopup
{
	private static final long serialVersionUID = 1L;

	public TaggedComboboxPopup(TaggedComboBox combo)
	{
		super(combo);
	}

	public void show()
	{
		TaggedComboBox combo = (TaggedComboBox) comboBox;
		combo.doFilterItems();
		super.show();
	}

	public void hide()
	{
		super.hide();
		if (comboBox != null && comboBox.getInputVerifier() != null)
			comboBox.getInputVerifier().verify(comboBox);
	}

	public void show(Component invoker, int x, int y)
	{
		adjustPopupSize();
		super.show(invoker, x, y);
	}

	protected void adjustPopupSize()
	{
		TaggedComboBox combo = (TaggedComboBox) comboBox;
		combo.doFilterItems();
		int iCount = combo.getItemCount();
		if (iCount > 0)
		{
			int iWidth = combo.getWidth();
			int iExtra = (iCount > comboBox.getMaximumRowCount())
					? getScrollbarWidth()
					: 0;
			int iAddExt = 0;
			Font font = getFont();
			for (int i = 0; i < iCount; i++)
			{
				Object o = combo.getItemAt(i);
				String s = (o != null)
						? o.toString()
						: null;
				Dimension dim = GUIUtilities.measureString(s, null, font);
				if (dim != null && dim.width > (iWidth - 4))
				{
					iWidth = dim.width + 4;
					iAddExt = iExtra;
				}
			}
			Dimension popupSize = new Dimension(iWidth + iAddExt, getPopupHeightForRowCount(comboBox.getMaximumRowCount()));
			Rectangle popupBounds = computePopupBounds(0, comboBox.getBounds().height, popupSize.width, popupSize.height);
			scroller.setMaximumSize(popupBounds.getSize());
			scroller.setPreferredSize(popupBounds.getSize());
			scroller.setMinimumSize(popupBounds.getSize());
			list.invalidate();
		}
	}

	private int getScrollbarWidth()
	{
		try
		{
			return scroller.getVerticalScrollBar().getPreferredSize().width;
		}
		catch (Exception e)
		{
		}
		return 18;
	}

}
