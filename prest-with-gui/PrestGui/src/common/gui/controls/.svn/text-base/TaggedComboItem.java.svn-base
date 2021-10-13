package common.gui.controls;

import common.gui.util.GUIUtilities;

/**
 * Softlab 2009  
 * @author TurgayA   
 */

public class TaggedComboItem
{
	private Object m_Value;
	private int m_iTag;
	public static final String EMPTYVALUE = "#";

	public TaggedComboItem(Object value, int iTag)
	{
		m_Value = value;
		if (m_Value instanceof String && GUIUtilities.areEqual((String) m_Value, EMPTYVALUE))
			m_Value = "";
		m_iTag = iTag;
	}

	public String toString()
	{
		return (m_Value != null)
				? m_Value.toString()
				: "";
	}

	public int getTag()
	{
		return m_iTag;
	}

	public Object getValue()
	{
		return m_Value;
	}

	public String toEditString()
	{
		StringBuffer buffer = new StringBuffer();
		if (m_Value != null)
			buffer.append(m_Value.toString());
		buffer.append('~');
		buffer.append(m_iTag);
		return buffer.toString();
	}

}
