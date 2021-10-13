package common.gui.util;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.text.StyleContext;

/**
 * Softlab 2009  
 * @author TurgayA   
 */
 
public class GUIUtilities
{ 
	public static int strToInt(String s)
	{
		return strToInt(s, 0);
	}

	public static int strToInt(String s, int defVal)
	{
		try
		{
			//			return new Integer(s).intValue();
			return Integer.parseInt(s);
		}
		catch (Exception e)
		{
			return defVal;
		}
	}

	public static Integer strToInteger(String s)
	{
		try
		{
			//			return new Integer(s).intValue();
			return new Integer(s);
		}
		catch (Exception e)
		{
			return 0;
		}
	}

	public static boolean areEqual(String s1, String s2)
	{
		if (s1 == null || s2 == null)
			return s1 == s2;
		return s1.compareTo(s2) == 0;
	}

	public static boolean areEqualNoCase(String s1, String s2)
	{
		if (s1 == null || s2 == null)
			return s1 == s2;
		return s1.compareToIgnoreCase(s2) == 0;
	}
	
	public static Dimension measureString(String s, Graphics g, Font f)
	{
		if (s == null || s.length() == 0 || f == null)
			return null;
		FontMetrics fm;
		if (g == null)
		{
			StyleContext context = new StyleContext();
			fm = context.getFontMetrics(f);
		}
		else
			fm = g.getFontMetrics();

		int dotCount = getCountOfChar(s, '.');
		float delta = 1.1f;
		int width = fm.stringWidth(s) - Math.round(delta * dotCount);
		return new Dimension(width, fm.getHeight());
	}

	private static int getCountOfChar(String s, char c)
	{
		if (s == null || s.length() == 0)
			return 0;
		int idx = 0;
		int pos = 0;
		int count = 0;
		while (idx < s.length() && pos >= 0)
		{
			pos = s.indexOf(c, idx);
			if (pos >= 0)
			{
				idx = pos + 1;
				count++;
			}
		}
		return count;
	}
	
	public static ImageIcon getIcon(Class cls, String imgFile)
	{
		Image image = null;			
		try
		{
			InputStream stream = cls.getResourceAsStream(imgFile);
			if (stream != null)
			{
				ByteArrayOutputStream outStream = new ByteArrayOutputStream();
				byte []buffer = new byte[4096];
				int read;
				while ((read = stream.read(buffer, 0, buffer.length)) > 0)
					outStream.write(buffer, 0, read);
				image = Toolkit.getDefaultToolkit().createImage(outStream.toByteArray());
				stream.close();
				
				return new ImageIcon(image);
			}
		}
		catch (Exception e)
		{
		}

		return null;
	}	

	public static ResourceBundle getResources(Class cls, String resURL)
	{
		try
		{
			InputStream strm = cls.getResourceAsStream(resURL);
			return new PropertyResourceBundle(strm);
		}
		catch (Exception e)
		{
		}

		return null;
	}	

	public static ImageIcon getIcon(ResourceBundle resources, String key, String root)
	{
		try
		{
			String icnFile = resources.getString(key);
			return getIcon(resources.getClass(), root+"/"+icnFile);
		}
		catch (Exception e)
		{
		}

		return null;
	}	
	
	public static int getResourceInt(ResourceBundle resources, String key, int def)
	{
		try
		{
			return strToInt(resources.getString(key));
		}
		catch (Exception e)
		{
		}

		return def;
	}	
	
	public static Font getResourceFont(ResourceBundle resources, String key)
	{
		try
		{
			String[] fdsc = resources.getString(key).split("-");
			return new Font(fdsc[0], strToInt(fdsc[1]), strToInt(fdsc[2]));
		}
		catch (Exception e)
		{
		}

		return new Font("Tahoma", Font.PLAIN, 9);
	}	
}
