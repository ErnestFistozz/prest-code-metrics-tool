package common.gui.controls;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import common.gui.util.GUIUtilities;
import common.gui.util.TaggedList;

/**
 * Softlab 2009  
 * @author TurgayA   
 */

public class MenuButton extends JPanel implements MouseListener, ActionListener, IMenuFilter
{
	private static final long serialVersionUID = 1L;

	private ImageButton m_mainButton;
	private ImageButton m_popupButton;
	private TaggedMenu m_popup;
	private TaggedList m_Items;

	private int m_actionIndex;
	private int m_actionId;

	private IMenuButtonListener m_listener;

	public MenuButton()
	{
		super();

		setLayout(new BorderLayout());

		m_popupButton = new ImageButton();

		if (ImageButton.CUSTOM_BORDERS)
		{
			m_popupButton.setBorder(ImageButton.m_pressed);
			m_popupButton.setContentAreaFilled(false);
			m_popupButton.setBorderPainted(false);
		}

		m_popupButton.setIcon(GUIUtilities.getIcon(getClass(), "/prestgui/resources/smalldnarw.png"));
		m_popupButton.setFocusPainted(false);
		m_popupButton.addActionListener(this);
		m_popupButton.addMouseListener(this);
		m_popupButton.setPreferredSize(new Dimension(12, 12));
		add(m_popupButton, BorderLayout.EAST);

		m_actionIndex = 0;

		m_popup = new TaggedMenu();
		m_popup.setActionListener(this);
		m_popup.setItemFilter(this);

		setIcon(null);

	}

	public MenuButton(ImageIcon main, TaggedList actions)
	{
		this();

		setIcon(main);

		setActions(actions);
	}

	public void setBounds(int x, int y, int width, int height)
	{
		super.setBounds(x, y, width, height);
	}

	public void setIcon(ImageIcon main)
	{
		if (m_mainButton == null)
		{
			m_mainButton = new ImageButton();
			m_mainButton.addMouseListener(this);
			m_mainButton.addActionListener(this);
		}

		m_mainButton.setIcon(main);

		if (ImageButton.CUSTOM_BORDERS)
		{
			m_mainButton.setBorder(ImageButton.m_normal);
			m_mainButton.setBorderPainted(false);
		}

		m_mainButton.setToolTipText(m_popupButton.getToolTipText());
		add(m_mainButton, BorderLayout.CENTER);
	}

	public void reinitialize()
	{
		if (m_mainButton != null)
			m_mainButton.reinitialize();
		if (m_popupButton != null)
			m_popupButton.reinitialize();
	}

	public ImageIcon getIcon()
	{
		if (m_mainButton != null)
		{
			Icon icon = m_mainButton.getIcon();
			if (icon instanceof ImageIcon)
				return (ImageIcon) icon;
		}
		return null;
	}

	public void setActions(TaggedList actions, boolean clear)
	{
		if (actions != null)
		{
			if (clear)
			{
				m_popup.clearItems();
			}
			if (clear || m_Items == null)
				m_Items = new TaggedList(actions);
			else
				m_Items.addAll(actions);
			m_popup.addItems(actions);
			if (actions.size() > 0)
				m_actionIndex = actions.getTagAt(0);
		}
	}

	public void setActions(TaggedList actions)
	{
		setActions(actions, false);
	}

	public void setMenuButtonListener(IMenuButtonListener listener)
	{
		m_listener = listener;
	}

	public String getActionText(int id)
	{
		if (m_Items != null)
			return m_Items.getValueAtTag(id);
		return null;
	}
	
	public IMenuButtonListener getMenuButtonListener()
	{
		return m_listener;
	}

	public void mouseClicked(MouseEvent evt)
	{
	}

	public void mousePressed(MouseEvent evt)
	{
		//		if (evt.getSource() instanceof JButton)
		//			((JButton) evt.getSource()).setBorder(ImageButton.m_pressed);

		if (evt.getSource() instanceof JButton)
		{
			if (ImageButton.CUSTOM_BORDERS)
				((JButton) evt.getSource()).setBorder(ImageButton.m_pressed);
			else
				((JButton) evt.getSource()).getModel().setPressed(true);
		}
	}

	public void mouseReleased(MouseEvent evt)
	{
		//		if (evt.getSource() instanceof JButton)
		//			((JButton) evt.getSource()).setBorder(ImageButton.m_normal);

		if (evt.getSource() instanceof JButton)
		{
			if (ImageButton.CUSTOM_BORDERS)
				((JButton) evt.getSource()).getModel().setPressed(false);
			else
				((JButton) evt.getSource()).setBorder(ImageButton.m_normal);
		}
	}

	public void mouseEntered(MouseEvent evt)
	{
		if (ImageButton.CUSTOM_BORDERS)
		{
			m_mainButton.setBorderPainted(true);
			m_popupButton.setBorderPainted(true);
		}
		else
		{
			m_mainButton.getModel().setSelected(true);
			m_popupButton.getModel().setSelected(true);
		}
	}

	public void mouseExited(MouseEvent evt)
	{
		if (ImageButton.CUSTOM_BORDERS)
		{
			m_mainButton.setBorderPainted(false);
			m_popupButton.setBorderPainted(false);
		}
		else
		{
			m_mainButton.getModel().setSelected(false);
			m_popupButton.getModel().setSelected(false);
		}
	}

	public void doPerformAction(int actionID)
	{
		m_actionIndex = actionID;
		if (m_listener != null)
			m_listener.actionPerformed(this, actionID);
	}

	public void doClick()
	{
		if (m_listener != null)
			m_listener.popupButtonPressed(this);

		Point p = getLocation();
		p.y += getHeight();
		Container parent = getParent();

		if (getComponentOrientation().isLeftToRight())
		{
			m_popup.show(parent, p.x, p.y);
		}
		else
		{
			int popupWidth = m_popup.getPreferredSize().width;
			m_popup.show(parent, p.x - popupWidth + getWidth(), p.y);
		}
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent evt)
	{
		Object source = evt.getSource();

		if (source instanceof TaggedMenuItem)
		{
			int actionID = ((TaggedMenuItem) source).getId();
			doPerformAction(actionID);

		}
		else if (source instanceof JButton)
		{
			JButton button = (JButton) source;
			if (button == m_popupButton)
			{
				doClick();
			}
			else if (m_listener != null)
			{
				if (m_popup != null)
				{
					// if the selected action is non-visible or disabled, try to find the first visible-enabled item to execute action
					if (!m_popup.isItemWTagVisible(m_actionIndex) || !m_popup.isItemWTagEnabled(m_actionIndex))
					{
						int tag;
						int i = 0;
						for (; i < m_Items.size(); i++)
						{
							tag = m_Items.getTagAt(i);
							if (m_popup.isItemWTagVisible(tag) && m_popup.isItemWTagEnabled(tag))
							{
								m_actionIndex = tag;
								break;
							}
						}

						// if no item is visible or enabled, just do nothing
						if (i == m_Items.size())
							return;
					}
				}

				this.putClientProperty("Event", evt);
				m_listener.actionPerformed(this, m_actionIndex);

			}
		}
	}

	/**
	 * Returns the m_actionIndex.
	 * 
	 * @return int
	 */
	public int getActionIndex()
	{
		return m_actionIndex;
	}

	public void setActionIndex(int index)
	{
		m_actionIndex = index;
	}

	/**
	 * @see com.lbs.controls.menu.ILbsMenuFilter#isItemVisible(JMenuItem)
	 */
	public boolean isItemVisible(JMenuItem item)
	{
		if (m_listener != null)
			return m_listener.menuButtonActionFiltered(this, ((TaggedMenuItem) item).getId());

		return true;
	}

	/**
	 * @see javax.swing.JComponent#setToolTipText(String)
	 */
	public void setToolTipText(String hint)
	{
		super.setToolTipText(hint);

		if (m_mainButton != null)
			m_mainButton.setToolTipText(hint);
		m_popupButton.setToolTipText(hint);
	}

	public String getToolTipText()
	{
		if (m_mainButton != null)
			return m_mainButton.getToolTipText();
		return null;
	}

	/**
	 * @see com.lbs.controls.menu.ILbsMenuFilter#isItemEnabled(JMenuItem)
	 */
	public boolean isItemEnabled(JMenuItem item)
	{
		if (m_listener != null)
			return m_listener.menuButtonActionValid(this, ((TaggedMenuItem) item).getId());

		return true;
	}

	/**
	 * @see java.awt.Component#addKeyListener(KeyListener)
	 */
	public synchronized void addKeyListener(KeyListener listener)
	{
		super.addKeyListener(listener);
		if (m_mainButton != null)
			m_mainButton.addKeyListener(listener);
		if (m_popupButton != null)
			m_popupButton.addKeyListener(listener);
	}

	/**
	 * @see java.awt.Component#addMouseListener(MouseListener)
	 */
	public synchronized void addMouseListener(MouseListener listener)
	{
		super.addMouseListener(listener);
		if (m_mainButton != null)
			m_mainButton.addMouseListener(listener);
		if (m_popupButton != null)
			m_popupButton.addMouseListener(listener);
	}

	public void putClientPropertyInternal(Object property, Object value)
	{
		if (m_mainButton != null)
			m_mainButton.putClientProperty(property, value);
		if (m_popupButton != null)
			m_popupButton.putClientProperty(property, value);
	}

	public boolean hasItemTag(int tag)
	{
		if (m_popup != null)
			return m_popup.hasItemTag(tag);

		return false;
	}

	public boolean isItemWTagEnabled(int tag)
	{
		if (m_popup != null)
			return m_popup.isItemWTagEnabled(tag);

		return false;
	}

	public TaggedList getItems()
	{
		return new TaggedList(m_Items);
	}

	public TaggedMenu getPopup()
	{
		return m_popup;
	}

	public void doActionPerformed(ActionEvent evt, int actionID)
	{
		final ActionEvent event = evt;
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				if (event.getSource() instanceof JButton || event.getSource() instanceof TaggedMenuItem)
				{
					((TaggedMenuItem) event.getSource()).paintAsSelected();
				}
				actionPerformed(event);
			}
		});
	}

	public void recordRequestFocus()
	{
	}

	public int getActionId()
	{
		return m_actionId;
	}

	public void setActionId(int actionId)
	{
		m_actionId = actionId;
	}

	public void setComponentOrientation(ComponentOrientation o)
	{
		super.setComponentOrientation(o);

		if (o.isLeftToRight())
		{
			remove(m_popupButton);
			add(m_popupButton, BorderLayout.EAST);
		}
		else
		{
			remove(m_popupButton);
			add(m_popupButton, BorderLayout.WEST);
		}

		doLayout();
		m_popup.setComponentOrientation(o);
	}

	public boolean canHaveLayoutManager()
	{
		return false;
	}

	public void updateUI()
	{
		super.updateUI();

		if (m_popup != null)
			m_popup.updateUI();
	}


}
