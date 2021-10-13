package common.gui.controls;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import common.gui.util.GUIUtilities;
import common.gui.util.TaggedList;

/**
 * Softlab June 2009  
 * @author TurgayA   
 */

public class ControlBar extends JPanel
implements ActionListener, IMenuButtonListener, MouseListener, 
		   DocumentListener, FocusListener, KeyListener, ItemListener, ComponentListener
{
	private BevelBorder NORMALBTNBORDER = null; // new BevelBorder(BevelBorder.RAISED);
	private BevelBorder PRSDBTNBORDER   = new BevelBorder(BevelBorder.LOWERED);

	private static final int ROW_WIDTH = 200;

	private static final int TOP_MARGIN = 5;
	private static final int BOT_MARGIN = 5;
	private static final int LEFT_MARGIN = 5;
	private static final int RIGHT_MARGIN = 5;
	
	private static final int TEXT_HEIGHT = 21;
	private static final int TEXT_WIDTH = 36;
	private static final int MINTEXT_WIDTH = 5;
	
	private static final int PBAR_HEIGHT = 10;
	private static final int PBAR_WIDTH  = 100;

	private static final int INVISIBMENU = -999999998;
	private static final int TERMINATOR  = -999999999;
	
	private static final String PRPHINS = "PROP_HORZINS";
	private static final String PRPRSZB = "PROP_RSZB";
	private static final String PRPMULS = "PROP_MULSEL";
	
	private static ImageIcon DOTSICON = null;
	
	private IControlBarListener m_CBListener;
	
	private Container m_LayoutOwner;
	private GridBagLayout m_Layout;
	private GridBagConstraints m_LayCons;
	
	private ArrayList<JComponent> m_Controls;
	private ArrayList<int[]> m_ToggleImageSets;
	private int m_MinRowWidth;
	private int m_MaxControlHeight;
	private double m_HorizontalWeight;
	private Dimension m_MinTextSize;
	private ImageIcon m_MarkIcon;
	private MenuButton m_Invisibles;
	private JLabel m_Terminator;
	
	private HashMap m_NBtnIcons;
	private HashMap m_IBtnIcons;
	
	private boolean m_NotifyFocusChange;
	
	public ControlBar()
	{
		super();
		setBorder(new BevelBorder(BevelBorder.RAISED));
		
		m_LayCons = new GridBagConstraints();
		
		m_Layout = new GridBagLayout();
		setLayout(m_Layout);
		m_LayoutOwner = this;
		
		m_Controls = new ArrayList<JComponent>();
		m_MinRowWidth = ROW_WIDTH;
		m_MinTextSize = new Dimension(MINTEXT_WIDTH, TEXT_HEIGHT);
		
		m_NBtnIcons = new HashMap();
		m_IBtnIcons = new HashMap();
		
		m_NotifyFocusChange = true;
		
		addComponentListener(this);
	}

	public int getMinRowWidth()
	{
		return m_MinRowWidth;
	}

	public void setMinRowWidth(int minRowWidth)
	{
		m_MinRowWidth = minRowWidth;
	}

	public IControlBarListener getCBListener()
	{
		return m_CBListener;
	}

	public void setCBListener(IControlBarListener listener)
	{
		m_CBListener = listener;
	}

	public ImageButton addImageButton(int ID, 
									 ImageIcon icon, 
									 int anchor, 
									 String hint,
									 int leftSpc, 
									 int rightSpc)
	{
		ImageButton btn = new ImageButton();
		btn.setIcon(icon);
		btn.addActionListener(this);
		btn.putClientProperty("Tag", new Integer(ID));
		btn.setToolTipText(hint);
		btn.setFocusable(false);
		
		Dimension pSize = btn.getPreferredSize();
		pSize.width += 2;
		pSize.height += 2;
		btn.setPreferredSize(pSize);
		btn.setMinimumSize(pSize);
		
		m_LayCons.anchor = anchor < 0  ? GridBagConstraints.CENTER : anchor;
		m_LayCons.insets = new Insets(TOP_MARGIN, Math.max(LEFT_MARGIN, leftSpc), BOT_MARGIN, Math.max(RIGHT_MARGIN, rightSpc));
		m_LayCons.gridwidth = 1;
		m_LayCons.weightx = 0;
		m_LayCons.weighty = 1;
		m_LayCons.fill = GridBagConstraints.NONE;
		
		addControl(btn);
		
		return btn;
	}
	
	public MenuButton addMenuButton(int ID, 
									ImageIcon icon, 
									TaggedList mItems, 
									int anchor, 
									String hint, 
									boolean allowMultiple,
									int leftSpc,
									int rightSpc)
	{
		MenuButton btn = new MenuButton();
		btn.setIcon(icon);
		btn.setMenuButtonListener(this);
		if (mItems != null)
			btn.setActions(mItems);
		btn.putClientProperty("Tag", new Integer(ID));
		btn.putClientProperty(PRPMULS, new Boolean(allowMultiple));
		btn.setToolTipText(hint);
		btn.setFocusable(false);

		Dimension pSize = btn.getPreferredSize();
		pSize.width += 2;
		pSize.height += 2;
		btn.setPreferredSize(pSize);
		btn.setMinimumSize(pSize);

		m_LayCons.anchor = anchor < 0
				? GridBagConstraints.CENTER
				: anchor;
		m_LayCons.insets = new Insets(TOP_MARGIN, Math.max(LEFT_MARGIN, leftSpc), BOT_MARGIN, Math.max(RIGHT_MARGIN, rightSpc));
		m_LayCons.gridwidth = 1;
		m_LayCons.weightx = 0;
		m_LayCons.weighty = 1;
		m_LayCons.fill = GridBagConstraints.NONE;

		addControl(btn);

		return btn;
	}

	public JComponent addToggleButton(int ID, 
										ImageIcon icon, 
										boolean toggleBorder,
										int anchor, 
										String hint,
										double wgt,
										int leftSpc, 
										int rightSpc)
	{
		JComponent ctrl = null;

		JLabel btn = new JLabel();
		btn.setIcon(icon);
		btn.addMouseListener(this);
		ctrl = btn;

		if (icon != null)
			m_NBtnIcons.put(new Integer(ID), icon);
		
		ctrl.putClientProperty("Tag", new Integer(ID));
		ctrl.putClientProperty("Press", new Boolean(toggleBorder));
		ctrl.setToolTipText(hint);
		ctrl.setFocusable(false);

		Dimension pSize = ctrl.getPreferredSize();
		pSize.width += 2;
		pSize.height += 2;
		ctrl.setPreferredSize(pSize);
		ctrl.setMinimumSize(pSize);
		if (toggleBorder)
			ctrl.setBorder(NORMALBTNBORDER);
		
		m_LayCons.anchor = anchor < 0
				? GridBagConstraints.CENTER
				: anchor;
		m_LayCons.insets = new Insets(TOP_MARGIN, Math.max(LEFT_MARGIN, leftSpc), BOT_MARGIN, Math.max(RIGHT_MARGIN, rightSpc));
		m_LayCons.gridwidth = 1;
		m_LayCons.weightx = wgt;
		m_LayCons.weighty = 1;
		m_LayCons.fill = GridBagConstraints.NONE;

		addControl(ctrl);

		return ctrl;
	}

	public JComponent addToggleButton(int ID, 
			ImageIcon icon, 
			boolean toggleBorder,
			int anchor, 
			String hint)
	{
		return addToggleButton(ID, icon, toggleBorder, anchor, hint, 0, 0, 0);
	}

	public void addButtonHLIcon(int ID, ImageIcon icon)
	{
		if (icon != null)
			m_IBtnIcons.put(new Integer(ID), icon);
	}
	
	public JTextField addEditor(int ID, 
								int anchor, 
								int width,
								double wght,
								String hint,
								int leftSpc, 
								int rightSpc)
	{
		JTextField edit = new JTextField();
		int eWidth = width > 0 ? width : TEXT_WIDTH;
		Dimension pSize = new Dimension(eWidth, TEXT_HEIGHT);
		edit.setPreferredSize(pSize);
		edit.setMinimumSize(m_MinTextSize);
		edit.addFocusListener(this);
		edit.addKeyListener(this);
		Integer tag = new Integer(ID);
		edit.getDocument().addDocumentListener(this);
		edit.getDocument().putProperty("Tag", tag);
		edit.putClientProperty("Tag", tag);
		edit.setToolTipText(hint);
		m_LayCons.anchor = anchor < 0  ? GridBagConstraints.CENTER : anchor;
		m_LayCons.insets = new Insets(TOP_MARGIN, Math.max(LEFT_MARGIN, leftSpc), BOT_MARGIN, Math.max(RIGHT_MARGIN, rightSpc));
		m_LayCons.gridwidth = 1;
		m_LayCons.weightx = wght;
		m_LayCons.weighty = 1;
		m_LayCons.fill = (wght > 0) ? GridBagConstraints.HORIZONTAL : GridBagConstraints.NONE;
		
		addControl(edit);
		
		return edit;
	}

	public JTextField addEditor(int ID, 
								int anchor, 
								int width,
								double wght,
								String hint)
	{
		return addEditor(ID, anchor, width, wght, hint, 0, 0);
	}
	
	public TaggedComboBox addCombobox(int ID, 
								  TaggedList cItems,
								  int anchor, 
								  int width,
								  double wght,
								  String hint,
								  int leftSpc, 
								  int rightSpc)
	{
		TaggedComboBox cmb = new TaggedComboBox(cItems);
		int eWidth = width > 0
				? width
				: TEXT_WIDTH;
		Dimension pSize = new Dimension(eWidth, TEXT_HEIGHT);
		cmb.setPreferredSize(pSize);
		cmb.setMinimumSize(m_MinTextSize);
		cmb.addFocusListener(this);
		cmb.addKeyListener(this);
		cmb.addItemListener(this);
		
		Integer tag = new Integer(ID);
		cmb.putClientProperty("Tag", tag);
		cmb.setToolTipText(hint);
		m_LayCons.anchor = anchor < 0
				? GridBagConstraints.CENTER
				: anchor;
		m_LayCons.insets = new Insets(TOP_MARGIN, Math.max(LEFT_MARGIN, leftSpc), BOT_MARGIN, Math.max(RIGHT_MARGIN, rightSpc));
		m_LayCons.gridwidth = 1;
		m_LayCons.weightx = wght;
		m_LayCons.weighty = 1;
		m_LayCons.fill = (wght > 0)
				? GridBagConstraints.HORIZONTAL
				: GridBagConstraints.NONE;

		addControl(cmb);

		return cmb;
	}

	public JLabel addLabel(int ID, 
							int anchor, 
							String text,
							double wgt,
							int leftSpc, 
							int rightSpc)
	{
		return addLabel(ID, anchor, false, text, wgt, leftSpc, rightSpc);
	}
	
	private JLabel addLabel(int ID, 
								int anchor, 
								boolean lineBreak,
								String text,
								double wgt,
								int leftSpc, 
								int rightSpc)
	{
		JLabel label = new JLabel(text);
		Integer tag = new Integer(ID);
		label.putClientProperty("Tag", tag);
		m_LayCons.anchor = anchor < 0
				? GridBagConstraints.CENTER
				: anchor;
		m_LayCons.insets = new Insets(TOP_MARGIN, Math.max(LEFT_MARGIN, leftSpc), BOT_MARGIN, Math.max(RIGHT_MARGIN, rightSpc));
		m_LayCons.gridwidth = lineBreak
				? GridBagConstraints.REMAINDER
				: 1;
		m_LayCons.weightx = wgt;
		m_LayCons.weighty = 1;
		m_LayCons.fill = GridBagConstraints.NONE;

		addControl(label);

		return label;
	}

	public JProgressBar addProgressBar(int ID, 
									int anchor, 
									int gridx,
									int width,
									int height,
									boolean withText,
									double wght,
									int leftSpc, 
									int rightSpc)
	{
		JProgressBar progBox = new JProgressBar();
		progBox.setBorder(null);
		progBox.setMinimum(0);
		progBox.setMaximum(100);
		progBox.setBackground(getBackground());
		progBox.setForeground(Color.DARK_GRAY);
		progBox.setOpaque(true);
		progBox.setStringPainted(withText);
		progBox.setString("");
		Dimension pSz = new Dimension();
		pSz.width = (width > 0) ? width : PBAR_WIDTH;
		pSz.height = (height > 0) ? height : PBAR_HEIGHT;
		progBox.setPreferredSize(pSz);
		progBox.setMinimumSize(pSz);
		Integer tag = new Integer(ID);
		progBox.putClientProperty("Tag", tag);
		m_LayCons.anchor = anchor < 0
				? GridBagConstraints.CENTER
				: anchor;
		m_LayCons.insets = new Insets(TOP_MARGIN, Math.max(LEFT_MARGIN, leftSpc), BOT_MARGIN, Math.max(RIGHT_MARGIN, rightSpc));
		m_LayCons.gridx = gridx;
		m_LayCons.gridwidth = 1;
		m_LayCons.weightx = wght;
		m_LayCons.weighty = 1;
		m_LayCons.fill = (wght > 0) ? GridBagConstraints.HORIZONTAL : GridBagConstraints.NONE;

		addControl(progBox);

		return progBox;
	}

	public void addControl(JComponent ctrl)
	{
		int horzIns = m_LayCons.insets != null ? m_LayCons.insets.left+m_LayCons.insets.right : 0;
		if (horzIns != 0)
			ctrl.putClientProperty(PRPHINS, new Integer(horzIns));
		ctrl.putClientProperty(PRPRSZB, new Boolean(m_LayCons.fill != GridBagConstraints.NONE));
		m_HorizontalWeight += m_LayCons.weightx;
		m_Layout.setConstraints(ctrl, m_LayCons);
		add(ctrl);
		m_Controls.add(ctrl);

		Dimension cSz = ctrl.getPreferredSize();
		if (cSz != null)
			m_MaxControlHeight = Math.max(m_MaxControlHeight, cSz.height);
	}
	
	public void addTerminators(boolean addInvisiblesMenu)
	{
		double tWgt = 0;
		if (addInvisiblesMenu)
		{
			m_Invisibles = (MenuButton) addMenuButton(INVISIBMENU, getDots(), null, GridBagConstraints.CENTER, "more...", false, 2, 0);
			m_Invisibles.setVisible(false);
			if (m_MaxControlHeight > 0)
			{
				Dimension iSz = m_Invisibles.getPreferredSize();
				if (iSz.height < m_MaxControlHeight)
				{
					iSz.height = m_MaxControlHeight;
					m_Invisibles.setPreferredSize(iSz);
					m_Invisibles.setMinimumSize(iSz);
				}
				else {
						Dimension barSz = getPreferredSize();
						if (barSz.height <= iSz.height)
						{
							barSz.height = iSz.height+2;
							setPreferredSize(barSz);
						}
				}
			}
			
			tWgt = m_HorizontalWeight==0 ? 1.0:0.001;
		}
		
		m_Terminator = (JLabel) addLabel(TERMINATOR, GridBagConstraints.CENTER, true, "", tWgt, 0, 0);
	}
	
	public void addToggleImageSet(int[] btnSet)
	{
		if (m_ToggleImageSets == null)
			m_ToggleImageSets = new ArrayList();
		m_ToggleImageSets.add(btnSet);
	}
	
	public void checkControls()
	{
		if (m_CBListener == null)
			return;
		
		int cCnt = m_Controls.size();
		
		for (int i = 0; i < cCnt; i++)
		{
			JComponent ctrl = (JComponent) m_Controls.get(i);
			Integer t = (Integer) ctrl.getClientProperty("Tag");
			if (t != null && ctrl != m_Invisibles)
				ctrl.setEnabled(m_CBListener.checkControlStatus(this, t.intValue(), ctrl, 0));
		}
	}

	public JComponent getControlWithTag(int tag)
	{
		if (m_Controls != null)
			for (int i = 0; i < m_Controls.size(); i++)
			{
				JComponent ctrl = (JComponent) m_Controls.get(i);
				Integer t = (Integer) ctrl.getClientProperty("Tag");
				if (t != null && t.intValue() == tag)
					return ctrl;
			}
		
		return null;
	}
	
	public int getMenuButtonSelection(int ID)
	{
		JComponent ctrl = getControlWithTag(ID);
		if (ctrl instanceof MenuButton)
			return ((MenuButton) ctrl).getActionIndex();
		
		return 0;
	}
	
	public void markMenuButtonSelection(MenuButton btn, int actID, ImageIcon markIcn)
	{
		if (markIcn == null)
			return;
		
		boolean selMult = canHaveMultipleSelections(btn);
		
		TaggedMenu menu = btn.getPopup();
		if (menu != null && hasButtonMarkOption(btn))
			for (int i = 0; i < menu.getMenuItemCount(); i++)
			{
				Object comp = menu.getMenuItem(i);
				if (comp instanceof TaggedMenuItem)
				{
					TaggedMenuItem item = (TaggedMenuItem) comp;
					if (selMult)
					{
						if (item.getId() == actID)
						{
							boolean marked = item.getIcon() != null;
							if (marked)
								item.setIcon(null);
							else
								item.setIcon(markIcn);
						}
					}
					else 
						if (item.getId() == actID)
							item.setIcon(markIcn);
						else
							item.setIcon(null);
				}
			}
	}
	
	private boolean hasButtonMarkOption(MenuButton btn)
	{
		Boolean flag = (Boolean) btn.getClientProperty("MARK");
		if (flag != null)
			return flag.booleanValue();
		
		return true;
	}
	
	private boolean canHaveMultipleSelections(MenuButton btn)
	{
		Boolean flag = (Boolean) btn.getClientProperty(PRPMULS);
		if (flag != null)
			return flag.booleanValue();
		
		return false;
	}
	
	public void setMenuButtonSelection(MenuButton btn, int actID, ImageIcon markIcn)
	{
		btn.setActionIndex(actID);
		markMenuButtonSelection(btn, actID, markIcn);
	}
	
	public void setMenuButtonSelection(int ID, int actID, ImageIcon markIcn)
	{
		JComponent ctrl = getControlWithTag(ID);
		if (ctrl instanceof MenuButton)
			setMenuButtonSelection((MenuButton) ctrl, actID, markIcn);
	}
	
	public void setMenuButtonSelection(int ID, int actID)
	{
		setMenuButtonSelection(ID, actID, m_MarkIcon);
	}

	public void setMenuButtonMark(int ID, boolean flag)
	{
		JComponent ctrl = getControlWithTag(ID);
		if (ctrl instanceof MenuButton)
			ctrl.putClientProperty("MARK", new Boolean(flag));
	}

	public void setMenuButtonItems(int tag, TaggedList items, int defTag)
	{
		JComponent mbtn = getControlWithTag(tag);
		if (mbtn instanceof MenuButton)
		{
			MenuButton m = (MenuButton) mbtn;
			m.setActions(items, true);
			setMenuButtonSelection(m, defTag, m_MarkIcon);
		}
	}

	public int[] getMenuButtonSet(MenuButton btn)
	{
		boolean selMult = canHaveMultipleSelections(btn);
		TaggedMenu menu = btn.getPopup();
		if (selMult && menu != null)
		{
			ArrayList<Integer> setL = new ArrayList<Integer>();
			for (int i = 0; i < menu.getMenuItemCount(); i++)
			{
				Object comp = menu.getMenuItem(i);
				if (comp instanceof TaggedMenuItem)
				{
					TaggedMenuItem item = (TaggedMenuItem) comp;
					if (item.getIcon() != null)
						setL.add(new Integer(item.getId()));
				}
			}
			
			if (setL.size() > 0)
			{
				int[] set = new int[setL.size()];
				for (int i = 0; i < set.length; i++)
					set[i] = setL.get(i).intValue();
				return set;
			}
		}
		
		return null;
	}
	
	public void setControlText(int ID, String text)
	{
		JComponent ctrl = getControlWithTag(ID);
		if (ctrl instanceof JTextField)
			((JTextField) ctrl).setText(text);
	}
	
	public String getControlText(int ID)
	{
		JComponent ctrl = getControlWithTag(ID);
		if (ctrl instanceof JTextField)
			return ((JTextField) ctrl).getText();
		
		return null;
	}
	
	public void toggleButton(int id)
	{
		if (m_ToggleImageSets != null)
			for (int i = 0; i < m_ToggleImageSets.size(); i++)
			{
				int[] set = (int[]) m_ToggleImageSets.get(i);
				if (isButtonIncluded(set, id))
				{
					for (int j = 0; j < set.length; j++)
						setToggleState(set[j], id == set[j]);
					return;
				}
			}
	}
	
	private void setToggleState(int id, boolean flag)
	{
		JComponent btn = getControlWithTag(id);
		if (btn instanceof JLabel)
		{
			JLabel imgBtn = (JLabel) btn;
			ImageIcon icn = flag ? (ImageIcon) m_IBtnIcons.get(new Integer(id)) : (ImageIcon) m_NBtnIcons.get(new Integer(id));
			if (icn != null)
				imgBtn.setIcon(icn);
		}
	}

	private boolean isButtonIncluded(int[] set, int id)
	{
		for (int i = 0; i < set.length; i++)
			if (id == set[i])
				return true;
		
		return false;
	}

	public void toggleButtonAction(JLabel btn, int tag)
	{
		toggleButton(tag);
		m_CBListener.controlAction(this, tag, btn, 0);
	}
	
	public void toggleButtonAction(int tag)
	{
		JComponent btn = getControlWithTag(tag);
		if (btn instanceof JLabel)
			toggleButtonAction((JLabel) btn, tag); 
	}
	
	public void setButtonIcon(int tag, ImageIcon icn)
	{
		JComponent btn = getControlWithTag(tag);
		if (btn instanceof JLabel)
			((JLabel) btn).setIcon(icn);
	}
	
	public void setPressedState(JComponent btn, boolean flag)
	{
		if (btn instanceof JLabel)
			((JLabel) btn).setBorder(flag ? PRSDBTNBORDER : NORMALBTNBORDER);
	}
	
	public void setPressedState(int id, boolean flag)
	{
		JComponent btn = getControlWithTag(id);
		setPressedState(btn, flag);
	}

	public boolean isPressed(JComponent btn)
	{
		if (btn instanceof JLabel)
		{
			Border b = btn.getBorder();
			return (b != null && b == PRSDBTNBORDER);
		}
		
		return false;
	}
	
	public boolean isPressed(int id)
	{
		JComponent btn = getControlWithTag(id);
		return isPressed(btn);
	}
	
	public void setComboItems(int tag, TaggedList items, int defTag)
	{
		JComponent cmb = getControlWithTag(tag);
		if (cmb instanceof TaggedComboBox)
		{
			TaggedComboBox c = (TaggedComboBox) cmb;
			c.setItems(items);
			c.setSelectedItemTag(defTag);
		}
	}
	
	public void setSelectedComboItem(JComponent cmb, int selTag)
	{
		if (cmb instanceof TaggedComboBox)
		{
			TaggedComboBox c = (TaggedComboBox) cmb;
			c.setSelectedItemTag(selTag);
		}
	}
	
	public void setSelectedComboItem(int tag, int selTag)
	{
		JComponent cmb = getControlWithTag(tag);
		setSelectedComboItem(cmb, selTag);
	}
	
	public void setSelectedComboItem(JComponent cmb, String selItm)
	{
		if (cmb instanceof TaggedComboBox)
		{
			TaggedComboBox c = (TaggedComboBox) cmb;
			if (selItm != null)
				c.setSelectedItem(selItm);
		}
	}
	
	public void setSelectedComboItem(int tag, String selItm)
	{
		JComponent cmb = getControlWithTag(tag);
		setSelectedComboItem(cmb, selItm);
	}

	public int getSelectedComboItemTag(int tag)
	{
		JComponent cmb = getControlWithTag(tag);
		if (cmb instanceof TaggedComboBox)
		{
			TaggedComboBox c = (TaggedComboBox) cmb;
			return c.getSelectedItemTag();
		}
		
		return 0;
	}
	
	public String getSelectedComboItem(int tag)
	{
		JComponent cmb = getControlWithTag(tag);
		if (cmb instanceof TaggedComboBox)
		{
			TaggedComboBox c = (TaggedComboBox) cmb;
			Object selObj = c.getSelectedItemValue();
			return (selObj instanceof String) ? (String) selObj : null;
		}
		
		return null;
	}

	public String getComboItem(JComponent cmb, int tag)
	{
		if (cmb instanceof TaggedComboBox)
		{
			TaggedComboBox c = (TaggedComboBox) cmb;
			return c.getItemTagString(tag);
		}
		
		return null;
	}
	
	public String getComboItem(int cTag, int tag)
	{
		JComponent cmb = getControlWithTag(cTag);
		return getComboItem(cmb, tag);
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		Object source = evt.getSource();
		if (source instanceof ImageButton && m_CBListener != null)
		{
			ImageButton btn = (ImageButton) source;
			int tag = getTagOf(btn);
			m_CBListener.controlAction(this, tag, btn, 0);
		}
	}

	private int getTagOf(JComponent c)
	{
		Integer t = (Integer) c.getClientProperty("Tag");
		return (t != null) ? t.intValue() : 0;
	}
	
	private int getHorizontalInsets(JComponent c)
	{
		Integer t = (Integer) c.getClientProperty(PRPHINS);
		return (t != null) ? t.intValue() : 0;
	}

	private int getControlWidth(JComponent c)
	{
		Boolean b = (Boolean) c.getClientProperty(PRPRSZB);
		boolean resizable = (b != null) ? b.booleanValue() : false;
		Dimension prefSize = c.getPreferredSize();
		return resizable || prefSize == null ? c.getWidth() : prefSize.width;
	}
	
	private boolean isControlResizable(JComponent c)
	{
		Boolean b = (Boolean) c.getClientProperty(PRPRSZB);
		return (b != null) ? b.booleanValue() : false;
	}

	public void actionPerformed(MenuButton button, int actionIndex)
	{
		if (button == m_Invisibles)
			showInvisibleControl(actionIndex);
		else {
				if (m_CBListener != null)
					m_CBListener.controlAction(this, getTagOf(button), button, actionIndex);
				if (m_MarkIcon != null)
					markMenuButtonSelection(button, actionIndex, m_MarkIcon);
		}
	}

	public boolean menuButtonActionFiltered(MenuButton button, int actionIndex)
	{
		return (button != m_Invisibles && m_CBListener != null) ? 
				m_CBListener.filterControl(this, getTagOf(button), button, actionIndex) : 
				true;
	}

	public boolean menuButtonActionValid(MenuButton button, int actionIndex)
	{
		return (button != m_Invisibles && m_CBListener != null) ? 
				m_CBListener.checkControlStatus(this, getTagOf(button), button, actionIndex) : 
				true;
	}

	public void popupButtonPressed(MenuButton button)
	{
	}

	public void changedUpdate(DocumentEvent evt)
	{
		notifyTextChange(evt.getDocument());
	}

	public void insertUpdate(DocumentEvent evt)
	{
		notifyTextChange(evt.getDocument());
	}

	public void removeUpdate(DocumentEvent evt)
	{
		notifyTextChange(evt.getDocument());
	}

	private void notifyTextChange(Document document)
	{
		if (m_CBListener != null)
		{
			Integer t = (Integer) document.getProperty("Tag");
			if (t != null)
				m_CBListener.controlContentChange(this, t.intValue(), getControlWithTag(t.intValue()));
		}
	}

	public void focusGained(FocusEvent arg0)
	{
	}

	public void focusLost(FocusEvent evt)
	{
		if (m_CBListener != null && !evt.isTemporary() && m_NotifyFocusChange)
		{
			Object source = evt.getSource();
			if (source instanceof JTextField)
			{
				JComponent editor = (JComponent) source;
				int tag = getTagOf(editor);
				m_CBListener.controlContentProcess(this, tag, editor);
			}
		}
	}

	public void keyPressed(KeyEvent evt)
	{
		Object source = evt.getSource();
		int keyCode = evt.getKeyCode();
		int keyModifiers = evt.getModifiers();
		if (keyModifiers == 0)
			switch (keyCode)
			{
				case KeyEvent.VK_ENTER:		
					if (source instanceof JTextField)
					{
						JComponent editor = (JComponent) source;
						int tag = getTagOf(editor);
						m_CBListener.controlContentProcess(this, tag, editor);
					}
					break;
			}
	}

	public void keyReleased(KeyEvent arg0)
	{
	}

	public void keyTyped(KeyEvent arg0)
	{
	}

	public ImageIcon getMarkIcon()
	{
		return m_MarkIcon;
	}

	public void setMarkIcon(ImageIcon markIcon)
	{
		m_MarkIcon = markIcon;
	}

	public void mouseClicked(MouseEvent evt)
	{
	}

	public void mouseEntered(MouseEvent evt)
	{
	}

	public void mouseExited(MouseEvent evt)
	{
	}

	public void mousePressed(MouseEvent evt)
	{
		Object source = evt.getSource();
		if (source instanceof JLabel)
		{
			JLabel btn = (JLabel) source;
			if (!btn.isEnabled()) return;
			Boolean tgState = (Boolean) btn.getClientProperty("Press");
			if (tgState == null || !tgState.booleanValue())
				btn.setBorder(PRSDBTNBORDER);
			else {
					Border b = btn.getBorder();
					boolean pressed = (b != null && b == PRSDBTNBORDER);
					btn.setBorder(pressed ? NORMALBTNBORDER : PRSDBTNBORDER);
			}
		}
	}

	public void mouseReleased(MouseEvent evt)
	{
		Object source = evt.getSource();
		if (source instanceof JLabel)
		{
			JLabel btn = (JLabel) source;
			if (!btn.isEnabled()) return;
			Boolean tgState = (Boolean) btn.getClientProperty("Press");
			if (tgState == null || !tgState.booleanValue())
				btn.setBorder(null);
			int tag = getTagOf(btn);
			toggleButtonAction(btn, tag);
		}
	}

	public void itemStateChanged(ItemEvent evt)
	{
		Object c = evt.getSource();
		if (c != null && (c instanceof TaggedComboBox) && ((TaggedComboBox) c).isPopupVisible() && evt.getStateChange() == ItemEvent.SELECTED)
		{
			TaggedComboBox combo = (TaggedComboBox) c;
			int tag = getTagOf(combo);
			int itm = combo.getTagOfItem(evt.getItem());
			if (m_CBListener != null)
				m_CBListener.controlAction(this, tag, combo, itm);		
		}
	}

	public void setNotifyFocusChange(boolean notifyFocusChange)
	{
		m_NotifyFocusChange = notifyFocusChange;
	}

	public synchronized void addKeyListener(KeyListener l)
	{
		super.addKeyListener(l);
		
		int cCnt = m_Controls.size();
		
		for (int i = 0; i < cCnt; i++)
		{
			JComponent ctrl = (JComponent) m_Controls.get(i);
			ctrl.addKeyListener(l);
		}
	}

	protected ImageIcon getDots()
	{
    	if (DOTSICON != null)
    		return DOTSICON;
    	
    	DOTSICON = GUIUtilities.getIcon(getClass(), "/prestgui/resources/dots.png");
    	return DOTSICON;
	}

	public void componentHidden(ComponentEvent e)
	{
	}

	public void componentMoved(ComponentEvent e)
	{
	}

	public void componentResized(ComponentEvent e)
	{
		if (e.getSource() == this && m_Invisibles != null)
		{
        	SwingUtilities.invokeLater(new Runnable() {
                public void run() 
                {
                	alignBarComponents();
                }
        	});
		}
	}

	protected void alignBarComponents()
	{
		Dimension barSize = getSize();
		if (barSize != null && barSize.width > 0)
		{
			int horzGain = 0;
			int horzReach = 0;
			int invCnt = 0;
			for (int i = 0; i < m_Controls.size(); i++)
			{
				JComponent ctrl = (JComponent) m_Controls.get(i);
				if (!ctrl.isVisible())
				{
					if (ctrl != m_Invisibles)
						invCnt++;
				}
				else {
						int w = getControlWidth(ctrl)+getHorizontalInsets(ctrl);
						horzReach += w;
						if (isTextComponent(ctrl))
							horzGain += isControlResizable(ctrl) ? Math.max(getControlWidth(ctrl)-MINTEXT_WIDTH, 0) : 0;
				}
			}
			
			if (horzReach > barSize.width)
			{
				int reqGain = horzReach - barSize.width; 
				if (!m_Invisibles.isVisible())
					reqGain += m_Invisibles.getWidth() + getHorizontalInsets(m_Invisibles);
				int i = m_Controls.size()-1;
				while (i >= 0 && reqGain > 0)
				{
					JComponent ctrl = (JComponent) m_Controls.get(i);
					if (ctrl != m_Invisibles && ctrl != m_Terminator)
						if (ctrl.isVisible())
						{
							reqGain -= getControlWidth(ctrl)+getHorizontalInsets(ctrl);
							ctrl.setVisible(false);
							invCnt++;
						}
					
					i--;
				}
			}
			else 
				if (horzReach <= barSize.width && invCnt > 0)
				{
					horzGain += barSize.width - horzReach;
					int i = 0;
					while (i < m_Controls.size() && horzGain > 0)
					{
						JComponent ctrl = (JComponent) m_Controls.get(i);
						if (ctrl != m_Invisibles && ctrl != m_Terminator)
							if (!ctrl.isVisible())
							{
								int rqW = isControlResizable(ctrl) ? MINTEXT_WIDTH : getControlWidth(ctrl)+getHorizontalInsets(ctrl);
								if (rqW <= horzGain)
								{
									ctrl.setVisible(true);
									horzGain -= rqW;
									invCnt--;
								}
							}
						
						i++;
					}
				}
			
			m_Invisibles.setVisible(invCnt > 0);
			if (m_Invisibles.isVisible())
				m_Invisibles.setActions(getInvisibles(), true);
        	
			m_Layout.invalidateLayout(m_LayoutOwner);
		}
	}

	private void showInvisibleControl(int ctrlTag)
	{
		JComponent invc = getControlWithTag(ctrlTag);
		if (invc != null)
		{
			int reqGain = getControlWidth(invc)+getHorizontalInsets(invc);
			int i = m_Controls.size()-1;
			while (i >= 0 && reqGain > 0)
			{
				JComponent ctrl = (JComponent) m_Controls.get(i);
				if (ctrl != m_Invisibles && ctrl != m_Terminator)
					if (ctrl.isVisible())
					{
						reqGain -= getControlWidth(ctrl)+getHorizontalInsets(ctrl);
						ctrl.setVisible(false);
					}
				
				i--;
			}
			
			if (reqGain <= 0)
			{
				invc.setVisible(true);
				m_Invisibles.setActions(getInvisibles(), true);
				m_Layout.invalidateLayout(m_LayoutOwner);
			}
		}
	}
	
	private TaggedList getInvisibles()
	{
		TaggedList iList = new TaggedList();
		for (int i = 0; i < m_Controls.size(); i++)
		{
			JComponent ctrl = (JComponent) m_Controls.get(i);
			if (ctrl != m_Invisibles && ctrl != m_Terminator)
				if (!ctrl.isVisible())
				{
					String cName = ctrl.getToolTipText();
					int tag = getTagOf(ctrl);
					if (cName == null || cName.length() == 0)
						cName = "Tool control "+tag;
					iList.add(cName, tag);
				}
		}
		
		return iList;
	}

	private boolean isTextComponent(JComponent ctrl)
	{
		return (ctrl instanceof TaggedComboBox ||
				ctrl instanceof JTextField ||
				ctrl instanceof JLabel);
	}

	public void componentShown(ComponentEvent e)
	{
	}

}
