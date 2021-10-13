/**
 * 
 */
package categorizer.aiCategorizer.decisionTree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Vector;

import categorizer.core.ContextBuilder;
import categorizer.core.DataField;
import categorizer.core.DataHeader;
import categorizer.core.DataItem;
import categorizer.core.UnsupportedDataContextException;

import common.DataContext;
import common.NodePair;

/**
 * @author ovunc.bozcan
 *
 */
public class TreeNode implements ContextBuilder{

	private final static String trueTag = "true";
	
	private final static String falseTag = "false";
	
	private final static String isLeafTag = "isLeaf";
	
	private final static String childrenTag = "children";
	
	private final static String valueTag = "value";
	
	private final static String dataHeaderTag = "dataHeader";
	
	/**
	 * Indicates if the node is a leaf
	 */
	private boolean isLeaf;
	
	/**
	 * Holds the children of the treeNode
	 */
	private HashMap children;
	
	/**
	 * Holds the value to compare the DataField with
	 */
	private Object value;
	
	/**
	 * Holds the dataHeader whose field will be used in comparison
	 */
	private DataHeader dataHeader;
	
	/**
	 * Holds the dataHeader of this TreeNode
	 */
	private DataHeader ownDataHeader;
	
	/**
	 * Holds the value of this TreeNode, either a nominal or a numeric value 
	 */
	private String ownValue;

	
	/**
	 * @return the ownDataHeader
	 */
	public final DataHeader getOwnDataHeader() {
		return ownDataHeader;
	}

	/**
	 * @param ownDataHeader the ownDataHeader to set
	 */
	public final void setOwnDataHeader(DataHeader ownDataHeader) {
		this.ownDataHeader = ownDataHeader;
	}

	/**
	 * @return the ownValue
	 */
	public final String getOwnValue() {
		return ownValue;
	}

	/**
	 * @param ownValue the ownValue to set
	 */
	public final void setOwnValue(String ownValue) {
		this.ownValue = ownValue;
	}

	/**
	 * default constructor
	 */
	public TreeNode() {
		super();
	}
	
	/**
	 * @param isLeaf
	 */
	public TreeNode(boolean isLeaf){
		this.isLeaf = isLeaf;
	}

	/**
	 * @return the isLeaf
	 */
	public final boolean isLeaf() {
		return isLeaf;
	}

	/**
	 * @param isLeaf the isLeaf to set
	 */
	public final void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}


	
	/**
	 * @return the children
	 */
	public final HashMap getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public final void setChildren(HashMap children) {
		this.children = children;
	}

	/**
	 * @return the value
	 */
	public final Object getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public final void setValue(Object value) {
		this.value = value;
	}

	/**
	 * @return the dataHeader
	 */
	public final DataHeader getDataHeader() {
		return dataHeader;
	}

	/**
	 * @param dataHeader the dataHeader to set
	 */
	public final void setDataHeader(DataHeader dataHeader) {
		this.dataHeader = dataHeader;
	}
	
	public TreeNode compare(DataItem dataItem)
	{
		int index = 0;
		
		DataHeader []dataHeaders = dataItem.getDataHeaders();
		
		for(int i=0; i<dataHeaders.length; i++){
			
			if(dataHeader.getLabel().equals(dataHeaders[i].getLabel())){		// equals ile yapabilir miydim???????????????????????????
				index = i;
				break;
			}
		}
		
		if(this.dataHeader.isNominal())
			return (TreeNode)children.get(dataItem.getDataFields()[index].getStringValue());
		else
		{
			if(Double.parseDouble(dataItem.getDataFields()[index].getStringValue()) <= (Double)this.value)
				return (TreeNode)children.get(trueTag);
			else
				return (TreeNode)children.get(falseTag);	
		}
	}


	public void load(DataContext dataContext) throws Exception {

		this.isLeaf = Boolean.parseBoolean((String)dataContext.getFirstNodeValue2(isLeafTag));
		
		if(isLeaf)
			this.value = (String)dataContext.getFirstNodeValue2(valueTag);
		else
		{
			this.dataHeader = new DataHeader();
			this.dataHeader.load(dataContext.getNode(dataHeaderTag));
			
			this.children = new LinkedHashMap();
			if(this.dataHeader.isNominal())
			{
				String[] availableValues = this.dataHeader.getAvailableValue();
				for(int i=0; i<availableValues.length; i++)
				{
					TreeNode treeNode = new TreeNode();
					treeNode.load(dataContext.getNode(availableValues[i]));
					this.children.put(availableValues[i], treeNode);
				}
			}
			else
			{
				this.value = Double.parseDouble((String)dataContext.getFirstNodeValue2(valueTag));
				TreeNode treeNode = new TreeNode();
				treeNode.load(dataContext.getNode(trueTag));
				this.children.put(trueTag, treeNode);
				
				treeNode = new TreeNode();
				treeNode.load(dataContext.getNode(falseTag));
				this.children.put(falseTag, treeNode);
			}
		}
	}


	public DataContext store() throws Exception {
		DataContext dataContext = new DataContext();
		
		dataContext.add(new NodePair(isLeafTag,String.valueOf(this.isLeaf)));
		
		if(this.isLeaf)
			dataContext.add(new NodePair(valueTag,String.valueOf(this.value)));
		else
		{
			if(this.dataHeader.isNominal())
				dataContext.add(new NodePair(valueTag,""));
			else
				dataContext.add(new NodePair(valueTag,String.valueOf(this.value)));
				
			dataContext.add(dataHeaderTag,this.dataHeader.store());
			
			Set keySet = children.keySet();
			Iterator iterator = keySet.iterator();
			
			while(iterator.hasNext()){
				String childTitle = (String)iterator.next(); 
				TreeNode treeNode = (TreeNode)children.get(childTitle);
				dataContext.add(childTitle,treeNode.store());
			}
		}
		return dataContext;
	}
	
}
