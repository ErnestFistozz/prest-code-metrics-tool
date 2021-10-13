package common.gui.controls;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

/**
 * Softlab June 2009  
 * @author TurgayA   
 */

public class ImageButton extends JButton implements MouseListener
{
	public static boolean CUSTOM_BORDERS = true;

	private static final long serialVersionUID = 1L;

	public static BevelBorder m_normal = new BevelBorder(BevelBorder.RAISED);
	public static BevelBorder m_pressed = new BevelBorder(BevelBorder.LOWERED);

	public ImageButton()
	{
		super();

		setContentAreaFilled(false);

		if (CUSTOM_BORDERS)
		{
			setBorder(m_normal);
			setBorderPainted(false);
		}

		reinitialize();

		addMouseListener(this);

		//setMargin(new Insets(15,13,15,13));
	}

	public void reinitialize()
	{
		putClientProperty("JToolBar.isToolbarButton", Boolean.TRUE);
	}

	public void mouseClicked(MouseEvent evt)
	{
	}

	public void mousePressed(MouseEvent evt)
	{
		if (CUSTOM_BORDERS)
			setBorder(m_pressed);
		else
			getModel().setPressed(true);
	}

	public void mouseReleased(MouseEvent evt)
	{
		if (CUSTOM_BORDERS)
			setBorder(m_normal);
		else
			getModel().setPressed(false);
	}

	public void mouseEntered(MouseEvent evt)
	{
		if (!isEnabled())
			return;

		if (CUSTOM_BORDERS)
			setBorderPainted(true);
		else
			getModel().setSelected(true);
	}

	public void mouseExited(MouseEvent evt)
	{
		if (CUSTOM_BORDERS)
			setBorderPainted(false);
		else
			getModel().setSelected(false);
	}

	/**
	 * @see javax.swing.AbstractButton#setIcon(Icon)
	 */
	public void setIcon(Icon icon)
	{
		super.setIcon(icon);
		if (icon != null)
		{
			Dimension size = getPreferredSize();
			Dimension newSize = new Dimension(size.width + 4, size.height + 4);
			super.setPreferredSize(newSize);
		}
	}
}
