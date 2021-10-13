/**
 * 
 */
package categorizer.core;

import java.util.Vector;

import common.DataContext;
import common.NodePair;

/**
 * Holds a threshold for a dataHeader
 * One important notice is about loading the threshold from a dataContext, 
 * after loading the threshold, its dataHeader object should be set.
 * 
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
 
public class Threshold implements ContextBuilder{
	
	/**
	 * Holds a reference to the bounded dataHeader
	 */
	private DataHeader dataHeader;
	
	/**
	 * the operator in the threshold
	 */
	private ThresholdOperator thresholdOperator;
	
	/**
	 *  the value to compare in the threshold
	 */
	private Operand[] operands;
	
	/**
	 * the value of the class when the operation is successful
	 */
	private String classValue;
	
	
	/**
	 * label of the current tag
	 */
	private final String currentTag = "threshold";
	
	/**
	 * label of the operator tag
	 */
	private final String operatorTag = "operator";
	
	/**
	 * label of the value tag
	 */
	private final String operandTag = "operand";
	
	/**
	 * label of the class value tag
	 */
	private final String classTag = "class";
	
	/**
	 * label of the current tag
	 */
	private final String operandsTag = "operands";
	

	
	public Threshold(){
		
	}


	/**
	 * @param dataHeader
	 * @param thresholdOperator
	 * @param value
	 */
	public Threshold(DataHeader dataHeader, ThresholdOperator thresholdOperator, Operand[] value) {
		super();
		this.dataHeader = dataHeader;
		this.thresholdOperator = thresholdOperator;
		this.operands = value;
	}



	/**
	 * @return the dataHeader
	 */
	public DataHeader getDataHeader() {
		return dataHeader;
	}


	/**
	 * @param dataHeader the dataHeader to set
	 */
	public void setDataHeader(DataHeader dataHeader) {
		this.dataHeader = dataHeader;
	}


	/**
	 * @return the operator
	 */
	public ThresholdOperator getOperator() {
		return thresholdOperator;
	}


	/**
	 * @param thresholdOperator the operator to set
	 */
	public void setOperator(ThresholdOperator thresholdOperator) {
		this.thresholdOperator = thresholdOperator;
	}


	/**
	 * @return the operand
	 */
	public Operand[] getOperands() {
		return operands;
	}


	/**
	 * @param operandValue the operand to set
	 */
	public void setOperands(Operand[] operands) {
		this.operands = operands;
	}


	/**
	 * @param value
	 * @return the comparison of the value in the parameter due to threshold settings
	 * @throws UnsupportedThresholdException 
	 */
	
	/* TODO
	 * su an icin Operator sonuclari ile classlar eslenmedi
	 * bundan dolayi true yerine ilk class, ikincisi yerine ikinci class
	 * donuyor
	 * 
	 */
	public boolean compare(DataItem dataItem) throws UnsupportedThresholdException{
		
		
		Object value = null;
		for(int i=0; i<dataItem.getDataFields().length; i++)
		{
			DataField dataField = dataItem.getDataFields()[i];
			
			try {
				if(dataField.getDataHeader().getLabel().equalsIgnoreCase(dataHeader.getLabel()))
				{
					value = dataField.getValue();
					break;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
		
		if(dataHeader.isNominal())
		{
			if(thresholdOperator.equals(ThresholdOperator.EQU))
			{
				if(((String)getValue(dataItem, operands[0])).equals((String)value))
					return true;
				else
					return false;
			}
			else
			{
				throw new UnsupportedThresholdException();
			}
			
		}
		else
		{
			if(thresholdOperator.equals(ThresholdOperator.GT))
			{
				if(((Double)getValue(dataItem, operands[0])).doubleValue() < ((Double)value).doubleValue())
					return true;
				else
					return false;
			}
			else if(thresholdOperator.equals(ThresholdOperator.GTE))
			{
				if(((Double)getValue(dataItem, operands[0])).doubleValue() <= ((Double)value).doubleValue())
					return true;
				else
					return false;
			}
			else if(thresholdOperator.equals(ThresholdOperator.LT))
			{
				if(((Double)getValue(dataItem, operands[0])).doubleValue() > ((Double)value).doubleValue())
					return true;
				else
					return false;
			}
			else if(thresholdOperator.equals(ThresholdOperator.LTE))
			{
				if(((Double)getValue(dataItem, operands[0])).doubleValue() >= ((Double)value).doubleValue())
					return true;
				else
					return false;
			}
			else if(thresholdOperator.equals(ThresholdOperator.EQU))
			{
				if(((Double)getValue(dataItem, operands[0])).doubleValue() == ((Double)value).doubleValue())
					return true;
				else
					return false;
			}
			else if(thresholdOperator.equals(ThresholdOperator.BTW))
			{
				if((((Double)getValue(dataItem, operands[0])).doubleValue() <= ((Double)value).doubleValue() &&
					((Double)getValue(dataItem, operands[1])).doubleValue() >= ((Double)value).doubleValue()))
					return true;
				else
					return false;
			}
		}
		
		return false;
	}


	/* (non-Javadoc)
	 * @see categorizer.core.ContextBuilder#load(common.DataContext)
	 */

	public void load(DataContext dataContext)
			throws Exception {
		
		Vector tempVector = dataContext.getElements2(operatorTag);
		
		if(tempVector == null || tempVector.size()<1)
		{
			throw new UnsupportedDataContextException();
		}
		
		this.thresholdOperator = ThresholdOperator.valueOf((String)tempVector.get(0));

		
		DataContext operandsContext = dataContext.getNode(operandsTag);
		
		if(operandsTag == null)
			throw new UnsupportedDataContextException();
		
		Vector operandsVector = operandsContext.getNodes(operandTag);
		
		if(operandsVector != null && operandsVector.size() > 0)
		{
			this.operands = new Operand[operandsVector.size()];
			for(int i=0; i<operandsVector.size(); i++)
			{
                            this.operands[i] = new Operand();
			    this.operands[i].load((DataContext)operandsVector.get(i));
			}
		}

		tempVector = dataContext.getElements2(classTag);
		
		if(tempVector == null || tempVector.size()<1)
		{
			throw new UnsupportedDataContextException();
		}
		
		this.classValue = (String)tempVector.get(0);	
		
	}


	/* (non-Javadoc)
	 * @see categorizer.core.ContextBuilder#store()
	 */

	public DataContext store() throws Exception{
		DataContext dataContext = new DataContext();
		
		dataContext.add(new NodePair(operatorTag, this.thresholdOperator.name()));
		
		DataContext operandsContext = new DataContext();
		for(int i=0; i<operands.length; i++){
                    if(operands[i] != null){
			operandsContext.add(operandTag,operands[i].store());
                    }
                }
		dataContext.add(operandsTag, operandsContext);
		dataContext.add(new NodePair(classTag, String.valueOf(this.classValue)));
		
		return dataContext;
	}


	/**
	 * @return the classValue
	 */
	public String getClassValue() {
		return classValue;
	}


	/**
	 * @param classValue the classValue to set
	 */
	public void setClassValue(String classValue) {
		this.classValue = classValue;
	}

	/**
	 * Returns the value to be used in the operation regarding to an operand
	 * @param dataItem
	 * @param operand
	 * @return
	 */
	private Object getValue(DataItem dataItem, Operand operand)
	{
		if(operand.isDataHeader())
		{
			DataHeader dataHeader = (DataHeader)operand.getOperandValue();
			
			for(int i=0; i<dataItem.getDataFields().length; i++)
			{
				DataField dataField = dataItem.getDataFields()[i];
				
				if(dataField.getDataHeader().getLabel().equalsIgnoreCase(dataHeader.getLabel()))
				{
					return dataField.getValue();
				}
			}
		}
		else
		{
			return operand.getOperandValue();
		}
		
		return null;
	}
}
