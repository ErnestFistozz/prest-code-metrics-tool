package common.gui.util;

import java.util.ArrayList;

/**
 * Softlab June 2009
 * @author TurgayA   
 */

public class TaggedList
{
	private ArrayList<Object[]> m_List = new ArrayList();
	
	public TaggedList()
	{
		this(null);
	}
	
	public TaggedList(TaggedList source)
	{
		addAll(source);
	}
	
	public int add(String value, int tag)
	{
		if (value != null)
		{
			Object[] node = new Object[2];
			node[0] = value;
			node[1] = new Integer(tag);
			m_List.add(node);
			
			return m_List.size()-1;
		}
		
		return -1;
	}

	public boolean removeAt(int index)
	{
		if (m_List.size() > index && index >= 0)
		{
			m_List.remove(index);
			return true;
		}
		
		return false;
	}
	
	public boolean remove(int tag)
	{
		for (int i = 0; i < m_List.size(); i++)
		{
			Object[] node = (Object[]) m_List.get(i);
			if (tag == ((Integer) node[1]).intValue())
			{
				m_List.remove(i);
				return true;
			}
		} 

		return false;
	}
	
	public void removeAll()
	{
		m_List.clear();
	}
	
	public int getTagAt(int idx)
	{
		Object[] node = getNodeAt(idx);
		return (node != null) ? ((Integer) node[1]).intValue() : 0;
	}

	private Object[] getNodeAt(int idx)
	{
		return (m_List.size() > idx && idx >= 0) ? (Object[]) m_List.get(idx) : null;
	}

	private Object[] getNodeAtTag(int tag)
	{
		for (int i = 0; i < m_List.size(); i++)
		{
			Object[] node = (Object[]) m_List.get(i);
			if (tag == ((Integer) node[1]).intValue())
				return node;
		} 
		
		return null;
	}

	public String getValueAt(int idx)
	{
		Object[] node = getNodeAt(idx);
		return (node != null) ? (String) node[0] : null;
	}

	public String getValueAtTag(int tag)
	{
		Object[] node = getNodeAtTag(tag);
		return (node != null) ? (String) node[0] : null;
	}

	public int size()
	{
		return m_List.size();
	}

	public int indexOf(String value)
	{
		if (value != null)
			for (int i = 0; i < m_List.size(); i++)
			{
				Object[] node = (Object[]) m_List.get(i);
				if (node[0] instanceof String && value.equalsIgnoreCase((String) node[0]))
					return i;
			} 
		
		return -1;
	}

	public void addAll(TaggedList source)
	{
		if (source != null)
		{
			for (int i = 0; i < source.size(); i++)
				m_List.add(source.getNodeAt(i));
		}
	}
	
	public void addAll(String listText)
	{
		if (listText != null)
		{
			int x = 0;
			int y = listText.indexOf("|");
			while (y >= 0)
			{
				Object[] node = makeNode(listText.substring(x, y));
				if (node == null)
					y = -1;
				else {
						m_List.add(node);
						x = y + 1;
						y = listText.indexOf("|", x);
				}
			}
			
			if (x  < listText.length())
			{
				Object[] node = makeNode(listText.substring(x));
				if (node != null)
					m_List.add(node);
			}
		}
	}

	private Object[] makeNode(String nodeS)
	{
		if (nodeS != null && nodeS.length() > 0)
		{
			int x = nodeS.lastIndexOf("~");
			if (x > 0)
			{
				Object[] node = new Object[2];
				node[0] = nodeS.substring(0, x);
				node[1] = GUIUtilities.strToInteger(nodeS.substring(x+1));
				return node;
			}
		}
		
		return null;
	}
}
