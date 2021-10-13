/**
 * 
 */
package categorizer.core;

import java.util.Vector;

import common.DataContext;
import common.NodePair;

/**
* @author secil.karagulle
* @author ovunc.bozcan
*/
public class Operand implements ContextBuilder{
	
	/**
	 * indicates if the Operand is another field belonging to this dataHeader
	 */
	private boolean isDataHeader;
	
	/**
	 * Holds the value of the operand
	 * This can be a dataHeader or a double value
	 */
	private Object operandValue;
	
	/**
	 * label of the isDataHeaderTag
	 */
	private String isDataHeaderTag = "isDataHeader";
	
	/**
	 * label of the operandValueTag
	 */
	private String operandValueTag ="operandValue";

	/**
	 * default constructor
	 */
	public Operand() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor initializing private fields
	 * @param isDataHeader
	 * @param operandValue
	 */
	public Operand(boolean isDataHeader, Object operandValue)
	{
		this.isDataHeader = isDataHeader;
		this.operandValue = operandValue;
	}

	/**
	 * @return the isDataHeader
	 */
	public boolean isDataHeader() {
		return isDataHeader;
	}

	/**
	 * @param isDataHeader the isDataHeader to set
	 */
	public void setDataHeader(boolean isDataHeader) {
		this.isDataHeader = isDataHeader;
	}

	/**
	 * @return the operandValue
	 */
	public Object getOperandValue() {
		return operandValue;
	}

	/**
	 * @param operandValue the operandValue to set
	 */
	public void setOperandValue(Object operandValue) {
		this.operandValue = operandValue;
	}

	
	/* (non-Javadoc)
	 * @see categorizer.core.ContextBuilder#load(common.DataContext)
	 */
	public void load(DataContext dataContext) throws Exception {
		
		if(dataContext == null)
			throw new UnsupportedDataContextException();
		
		Vector tempVector = dataContext.getElements2(isDataHeaderTag);
		
		if(tempVector == null || tempVector.size() <= 0)
			throw new UnsupportedDataContextException();
		
		this.isDataHeader = Boolean.parseBoolean((String) tempVector.get(0));
		
		if(this.isDataHeader)
		{
			tempVector = dataContext.getElements2(operandValueTag);
			if(tempVector == null || tempVector.size() <= 0)
				throw new UnsupportedDataContextException();
			this.operandValue = (String) tempVector.get(0);
		}
		else
		{
			tempVector = dataContext.getElements2(operandValueTag);
			if(tempVector == null || tempVector.size() <= 0)
				throw new UnsupportedDataContextException();
			this.operandValue = Double.parseDouble((String) tempVector.get(0));
		}
	}

	
	/* (non-Javadoc)
	 * @see categorizer.core.ContextBuilder#store()
	 */
	public DataContext store() throws Exception {
		
		DataContext dataContext = new DataContext();
		
		dataContext.add(new NodePair(isDataHeaderTag,String.valueOf(isDataHeader)));
		
		if(isDataHeader)
		{
			dataContext.add(new NodePair(operandValueTag,(String)this.operandValue));
		}
		else
		{
			dataContext.add(new NodePair(operandValueTag,String.valueOf(this.operandValue)));
		}
		
		return dataContext;
	}
	
	

}
