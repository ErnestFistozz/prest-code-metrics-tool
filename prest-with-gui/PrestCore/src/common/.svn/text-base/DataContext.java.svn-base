package common;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Vector;

import parser.Java.MetricsRelatedFiles.MetricNamesMap;
import common.monitor.Logger;
import definitions.metrics.CommonMetricTypes;

/**
 * DataContext is a generic tree based data structure for storing variables.
 * Node SiblingNode SiblingElement For instance if there are multiple occurrence
 * of the same element in the same node to
 */
public class DataContext implements Serializable {

	static final long serialVersionUID = 0L;

	protected LinkedHashMap<Object, Object> baseMap;
	private static java.lang.String nl = (System.getProperty("line.separator") == null) ? "\n"
			: System.getProperty("line.separator");
	public static final String kBaseXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			+ nl;
	public static final String kRootName = "root";
	public static final String kOffset = "\t";
	public static final String kDelimiter = "$$";
	public static final String kScheduleBlock = "schedules";

	private static final int kOptimalStringBufferSize = 1024;
	public static final String RESULTSET_ROOT_NAME = "Row";

	public static final String BACKSLASH = "_BACKSLASH_";
	public static final String DOT = "_DOT_";
	public static final String SEPFILE = "___";
	public static final String COLON = "_COLON_";
	public static final String SPACE = "_SPACE_";
	public static final String TILDA = "_TILDA_";
	public static final String LESSTHAN = "_LT_";
	public static final String GREATERTHAN = "_GT_";

	/**
	 * DataContext null constructor. Creates a DataContext object with a single
	 * root node
	 * 
	 * @see java.lang.Object#Object()
	 */
	public DataContext() {
		baseMap = new LinkedHashMap<Object, Object>(1);
	}

	public static DataContext readFromFile(String fileName) throws IOException {
	
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	        	        
		DataContext biss = new DataContext();
		br.readLine();// for the line <?xml version="1.0" encoding="UTF-8"?>
		recurs(biss, br);
		return biss.getNodeBackReplaced(kRootName);

	}

	private static void recurs(DataContext dc, BufferedReader br)
			throws IOException {
		String line = br.readLine();
		while (line != null) {
			if (isClosingTag(line)) {
				return;
			}
			boolean isLeafNode = isLeafNode(line);
			if (isLeafNode) {
				dc.add(parseNodeName(line), parseNodeValue(line));
			} else {
				String nodeName = parseNodeName(line);
				DataContext addedDc = new DataContext();
				dc.add(nodeName, addedDc);
				recurs(addedDc, br);
			}
			line = br.readLine();
		}
	}

	private static String parseNodeName(String line) {
		line = line.replace("\t", "");
		String name = "";
		for (int i = 1; i < line.length(); i++) {
			char c = line.charAt(i);
			if (c != ' ' && c != '>' && c != '/') {
				name += c;
				
			} else {
				break;
			}
		}
		return name;
	}

	private static String parseNodeValue(String line) {
		String value = "";
		String s = line.split(">")[1].split("<")[0];
		for (char c : s.toCharArray()) {
			value += c;
		}
		return value;
	}

	private static boolean isLeafNode(String line) {
		if (-1 < line.replace("\t", "").split(">")[0].indexOf(" "))
			return true;
		else
			return false;
	}

	private static boolean isClosingTag(String line) {
		line = line.replace("\t", "");
		if (line.startsWith("</"))
			return true;
		else
			return false;
	}

	public void writeToFile(String fileName) {
		BufferedOutputStream bos = null;
		try {

			bos = new BufferedOutputStream(new FileOutputStream(fileName));

			String strOutput = this.toString();

			while (strOutput.length() >= kOptimalStringBufferSize) {
				bos.write(strOutput.substring(0, kOptimalStringBufferSize)
						.getBytes());
				bos.flush();
				strOutput = strOutput.substring(kOptimalStringBufferSize);
			}
			bos.write(strOutput.getBytes());
			bos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
				Logger.error("DataContext => writeToFile: " + e.getMessage());
			}
		}
	}

	public void add(NodePair nodePair) {
		add(nodePair.getName(), nodePair.getValue());
	}

	public void add(Object key, Object obj) {

		if (obj == null)
			return;

		int n = ((String) key).indexOf(kDelimiter);
		if (n < 0) {
			addSibling(key, obj);
			return;
		}

		String newKey = ((String) key).substring(0, n);
		Object object = getFirstSiblingNode(newKey);

		if (object == null) {
			DataContext newnode = new DataContext();
			addSibling(newKey, newnode);
			newnode.add(((String) key).substring(n + 1), obj);
		} else {
			DataContext node = (DataContext) object;
			node.add(((String) key).substring(n + 1), obj);
		}
	}

	private void addSibling(Object key, Object obj) {

		key = backReplaceProblemCharacters((String) key);

		Object current = baseMap.get(key);
		if (current == null) {
			try {
				int i = Integer.parseInt(ObjectToTypes.getString(obj));
				baseMap.put(key, i);
				return;
			} catch (Exception e) {
			}
			try {
				double d = Double.parseDouble(ObjectToTypes.getString(obj));
				baseMap.put(key, d);
				return;
			} catch (Exception e) {
			}
			baseMap.put(key, obj);
		} else if (current instanceof Vector)
			((Vector) current).add(obj);
		else {
			Vector v = new Vector(1, 3);
			v.add(current);
			v.add(obj);
			baseMap.put(key, v);
		}
	}

	public DataContext cloneDataContext() {
		return (DataContext) clone();
	}

	public Object clone() {

		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			// serialize and pass the object
			oos.writeObject(this);
			oos.flush();
			ByteArrayInputStream bin = new ByteArrayInputStream(bos
					.toByteArray());
			ois = new ObjectInputStream(bin);
			// return the new object
			return ois.readObject();
		} catch (Exception e) {
			// EventLog.report(EventLog.ERROR,
			// "DataContext", "Clone", e);
			Logger.error("DataContext: Clone => " + e.getMessage());
			return null;
		} finally {
			try {
				oos.close();
				ois.close();
			} catch (Exception e) {
				Logger.error("DataContext: Clone close streams => "
						+ e.getMessage());
			}
		}
	}

	public HashMap<Object, Object> getBaseMap() {
		return baseMap;
	}

	public Vector getElements2(Object key) {
		Vector v = getElements(key);
		if(v!= null)
		{
			for (int i = 0; i < v.size(); i++) {
				try {
					v.set(i, ((Double) v.get(i)).toString());
				} catch (Exception e) {
					try {
						v.set(i, ((Integer) v.get(i)).toString());
					} catch (Exception e2) {
						try {
							v.set(i, ((String) v.get(i)).toString());
						} catch (Exception e3) {
						}
					}
				}
			}
		}
		return v;
	}

	public Vector getElements(Object key) {

		int n = ((String) key).indexOf(kDelimiter);

		if (n < 0)
			return getSiblingElements(key);
		Vector nodes = getSiblingNodes(((String) key).substring(0, n));
		String s = ((String) key).substring(n + 1);

		if (nodes == null)
			return null;
		Iterator i = nodes.iterator();
		Vector elements = new Vector(10);
		Vector v;

		while (i.hasNext()) {
			v = ((DataContext) i.next()).getElements(s);

			if (v != null)
				elements.addAll(v);
		}
		if (elements.isEmpty())
			return null;
		return elements;
	}

	public String getFirstNodeValue2(Object key) {
		Object o = getFirstNodeValue(key);
		
		try {
			return ((Double) o).toString();
		} catch (Exception e) {
			try {
				return ((Integer) o).toString();
			} catch (Exception e2) {
				try {
					return ((String) o).toString();
				} catch (Exception e3) {
					return o.toString();
				}
			}
		}
	}

	public Object getFirstNodeValue(Object key) {

		Object object;
		Iterator i;
		int n = ((String) key).indexOf(kDelimiter);
		if (n < 0) {
			key = MetricNamesMap.get((String) key);
			object = baseMap.get(key);
			if (!((isNode(object)) || (object instanceof Vector)))
				return object;
			else if (object instanceof Vector) {
				Object next;
				i = ((Vector) object).iterator();
				while (i.hasNext())
					if (!(isNode(next = i.next())))
						return next;
				return null;
			} else
				return null;
		}
		String newKey = ((String) key).substring(0, n);
		Vector nodes = getSiblingNodes(newKey);
		if (nodes == null)
			return null;
		i = nodes.iterator();
		while (i.hasNext()) {
			object = ((DataContext) i.next()).getFirstNodeValue(((String) key)
					.substring(n + 1));
			if (object != null)
				return object;
		}
		return null;
	}

	protected DataContext getFirstSiblingNode(Object key) {
		key = MetricNamesMap.get((String) key);
		Object obj = baseMap.get(key);
		if (obj instanceof Vector) {
			Iterator i = ((Vector) obj).iterator();
			Object next;
			while (i.hasNext())
				if (isNode(next = i.next()))
					return (DataContext) next;
		} else if (isNode(obj))
			return (DataContext) obj;
		return null;
	}

	public DataContext getNode(Object key) {
		if (key.equals(""))
			return this;
		int n = ((String) key).indexOf(kDelimiter);
		if (n < 0)
			return getFirstSiblingNode(key);
		DataContext tmp = getFirstSiblingNode(((String) key).substring(0, n));
		if (tmp == null)
			return null;
		return tmp.getNode(((String) key).substring(n + 1));
	}

	public DataContext getNodeBackReplaced(Object key) {
		key = backReplaceProblemCharacters(key);

		if (key.equals(""))
			return this;
		int n = ((String) key).indexOf(kDelimiter);
		if (n < 0)
			return getFirstSiblingNode(key);
		DataContext tmp = getFirstSiblingNode(((String) key).substring(0, n));
		if (tmp == null)
			return null;
		return tmp.getNodeBackReplaced(((String) key).substring(n + 1));
	}

	public Vector getNodes(Object key) {
		int n = ((String) key).indexOf(kDelimiter);
		if (n < 0)
			return getSiblingNodes(key);
		DataContext tmp = getFirstSiblingNode(((String) key).substring(0, n));
		if (tmp == null)
			return null;
		return tmp.getNodes(((String) key).substring(n + 1));
	}

	protected Vector getSiblingElements(Object key) {
		key = MetricNamesMap.get((String) key);
		Object object = baseMap.get(key);
		if (object == null)
			return null;
		if (!((isNode(object)) || (object instanceof Vector))) {
			Vector v = new Vector(1);
			v.add(object);
			return v;
		} else if (object instanceof Vector) {
			Object next;
			Vector v = new Vector(1, 10);
			Iterator i = ((Vector) object).iterator();
			while (i.hasNext())
				if (!(isNode(next = i.next())))
					v.add(next);
			if (!(v.isEmpty()))
				return v;
		}
		return null;
	}

	protected Vector getSiblingNodes(Object key) {
		key = MetricNamesMap.get((String) key);
		Object object = baseMap.get(key);
		if (object == null)
			return null;
		if (isNode(object)) {
			Vector v = new Vector(1);
			v.add(object);
			return v;
		} else if (object instanceof Vector) {
			Object next;
			// initial size = 30
			// increment = 100
			Vector v = new Vector(30, 100);
			Iterator i = ((Vector) object).iterator();
			while (i.hasNext())
				if (isNode(next = i.next()))
					v.add(next);
			if (!(v.isEmpty()))
				return v;
		}
		return null;
	}

	public boolean isNode(Object object) {
		if (object == null)
			return false;
		return object.getClass().isAssignableFrom(getClass());
	}

	public Iterator<String> iterator() {
		Iterator<Object> ito = baseMap.keySet().iterator();
		java.util.List<String> stringList = new java.util.ArrayList<String>();
		while (ito.hasNext()) {
			Object o = ito.next();
			try {
				int id = Integer.parseInt(ObjectToTypes.getString(o));
				String s = MetricNamesMap.inverse(id);
				stringList.add(s);
			} catch (Exception e) {
				stringList.add(ObjectToTypes.getString(o));
			}

		}
		return stringList.iterator();
	}

	public void remove(Object key) {
		remove(key, null);
	}

	public void remove(Object key, Object val) {

		int n = ((String) key).indexOf(kDelimiter);

		if (n < 0) {
			key = MetricNamesMap.get((String) key);
			Object o = baseMap.get(key);
			if (o == null)
				return;
			if (o instanceof Vector) {
				Vector v = (Vector) o;
				int size = v.size();
				if ((val == null) || (size == 1)) {
					((Vector) o).remove(getFirstNodeValue(key));
				} else {
					int i;

					for (i = 0; i < size; i++) {
						if (val.equals(v.get(i)))
							break;
					}
					if (i < size) {
						v.remove(i);
						return;
					}
				}
			} else
				baseMap.remove(key);
			return;
		}
		String newKey = ((String) key).substring(0, n);
		DataContext node = getFirstSiblingNode(newKey);
		if (node != null)
			node.remove(((String) key).substring(n + 1));
	}

	public String toString() {
		java.io.StringWriter sw = new java.io.StringWriter(
				kOptimalStringBufferSize);
		try {
			write(this, sw);
		} catch (Exception e) {
			Logger.error("Data Context: toString => " + e.getMessage());
		}
		return sw.toString();
	}

	private static void write(DataContext dc, Writer out) throws IOException {
		out.write(kBaseXML);
		writeXMLNodes(dc, out, kRootName, "");
	}

	public static final String end_mark = "</";
	public static final String bgn_mark = "<";
	public static final String cls = ">";
	public static final String type_s = " type=\"";
	public static final String trm = "\">";

	private static void writeXMLNodes(DataContext dc, Writer out,
			String nodeName, String offset) throws IOException {
		Iterator i = dc.iterator();
		String next;
		Vector v;
		StringBuffer sb;

		sb = new StringBuffer(20).append(replaceProblemCharacters(nodeName))
				.append(cls).append(nl);
		String node_end = sb.toString();
		sb = new StringBuffer(32).append(offset).append(bgn_mark).append(
				node_end);
		out.write(sb.toString());
		sb = new StringBuffer(8).append(offset).append(kOffset);
		String new_offset = sb.toString();

		while (i.hasNext()) {
			next = (String) i.next();
			// Write Elements
			v = dc.getSiblingElements(next);
			if (v != null) {
				Iterator e = v.iterator();
				while (e.hasNext()) {
					Object nextelement = e.next();
					sb = new StringBuffer(60).append(new_offset).append(
							bgn_mark).append(next)
							.append(type_s)
							// .append(
							// nextelement.getClass().getName())
							.append("java.lang.String").append(trm).append(
									nextelement.toString()).append(end_mark)
							.append(next).append(cls).append(nl);
					out.write(sb.toString());
				}
			}
			// Traverse Sibling Nodes
			v = dc.getSiblingNodes(next);
			if (v != null) {
				Iterator n = v.iterator();
				while (n.hasNext()) {
					Object nextnode = n.next();
					writeXMLNodes(((DataContext) nextnode), out, next,
							new_offset);
				}
			}
		}
		sb = new StringBuffer(40).append(offset).append(end_mark).append(
				node_end);
		out.write(sb.toString());
	}

	public static String replaceProblemCharacters(String s) {
		s = s.replace(File.separator, SEPFILE);
		s = s.replace(":", COLON);
		s = s.replace(" ", SPACE);
		s = s.replace("~", TILDA);
		s = s.replace("<", LESSTHAN);
		s = s.replace(">", GREATERTHAN);
		if (s.startsWith(".")) {
			s = DOT + s.substring(1);
		}
		try {
			int mapId = Integer.parseInt(s);// TODO
			return CommonMetricTypes.LIST[mapId].getLabel();
		} catch (Exception e) {
			// do not throw
		}
		return s;
	}

	public static Object backReplaceProblemCharacters(Object so) {
		String s = (String) so;
		s = s.replace(SEPFILE, File.separator);
		s = s.replace(COLON, ":");
		s = s.replace(SPACE, " ");
		s = s.replace(TILDA, "~");
		s = s.replace(LESSTHAN, "<");
		s = s.replace(GREATERTHAN, ">");
		if (s.startsWith(DOT)) {
			s = "." + s.substring(DOT.length());
		}
		return MetricNamesMap.get((String) s);
	}
}