/**
 * 
 */
package categorizer.core;

import java.util.Vector;

import common.DataContext;
import common.NodePair;


public class VirtualMetric implements ContextBuilder{

	/**
	 * Label of the label tag
	 */
	private final String labelTag = "label";
	
	/**
	 * Label of the operator tag
	 */
	private final String operatorTag = "operator";
	
	/**
	 * Label of the operands tag
	 */
	private final String operandsTag = "operands";
	
	/**
	 * Label of the operand tag
	 */
	private final String operandTag = "operand" ;
	
	
	/**
	 * Label of the dataHeader Tag
	 */
	private final String dataHeaderTag = "dataHeader" ;
	
	/**
	 * Label(title) of the user defined metric
	 */
	private String label;
	
	/**
	 * Operator of the user defined metric
	 */
	private MetricOperator operator;
	
	/**
	 * Indexes of the dataFields
	 */
	private Operand[] operands;
	
	/**
	 * DataHeader for this virtualMetric
	 */
	private DataHeader dataHeader;
	
	/**
	 * default constructor
	 */
	public VirtualMetric() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param operator
	 * @param indexes
	 */
	public VirtualMetric(MetricOperator operator, String label, Operand[] operands) {
		super();
		this.label = label;
		this.operator = operator;
		this.operands = operands;
		dataHeader = new DataHeader();
		dataHeader.setLabel(label);
		dataHeader.setNominal(false);
	}


	/**
	 * @return the operator
	 */
	public MetricOperator getOperator() {
		return operator;
	}


	/**
	 * @param operator the operator to set
	 */
	public void setOperator(MetricOperator operator) {
		this.operator = operator;
	}
	

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}


	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	
	/**
	 * @return the operands
	 */
	public Operand[] getOperands() {
		return operands;
	}


	/**
	 * @param operands the operands to set
	 */
	public void setOperands(Operand[] operands) {
		this.operands = operands;
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
	 * Modifies the whole dataSet according to the attributes of the new metric
	 * @param dataSet
	 * @return
	 */
	public DataSet modifySet(DataSet dataSet)
	{
		DataHeader[] dataHeaders = new DataHeader[dataSet.getDataHeaders().length + 1];
		
		for(int i=0; i<dataHeaders.length-1 ; i++)
		{
			dataHeaders[i] = dataSet.getDataHeaders()[i];
		}
		dataHeader = new DataHeader();
		dataHeader.setLabel(label);
		dataHeader.setNominal(false);
		
		dataHeaders[dataHeaders.length-1] = dataHeader;
		
		dataSet.setDataHeaders(dataHeaders);
				
		DataItem[] dataItems = dataSet.getDataItems();
		
		for(int i=0; i<dataItems.length; i++)
		{
			DataItem dataItem = dataItems[i];
			dataItem = modifyItem(dataItem);
		}
		
		dataSet.setDataItems(dataItems);
		
		return dataSet;
	}
	
	/**
	 * Modifies one Item according to the attributes of the new metric
	 * @param dataItem
	 * @return
	 */
	public DataItem modifyItem(DataItem dataItem)
	{
		DataField[] dataFields = new DataField[dataItem.getDataFields().length + 1];
		
		for(int i=0; i<dataFields.length-1; i++)
		{
			dataFields[i] = dataItem.getDataFields()[i];
		}
		
		DataField dataField = new DataField();
		dataField.setDataHeader(dataHeader);

		if(this.operator.equals(MetricOperator.ADD)){
			dataField.load(String.valueOf(((Double)getValue(dataItem, operands[0])  + (Double)getValue(dataItem, operands[1]))));
		}else if(this.operator.equals(MetricOperator.SUB)){
			dataField.load(String.valueOf(((Double)getValue(dataItem, operands[0])  - (Double)getValue(dataItem, operands[1]))));
		}else if(this.operator.equals(MetricOperator.MUL)){
			dataField.load(String.valueOf(((Double)getValue(dataItem, operands[0]) * (Double)getValue(dataItem, operands[1]))));
		}else if(this.operator.equals(MetricOperator.DIV)){
			dataField.load(String.valueOf(((Double)getValue(dataItem, operands[0])  / (Double)getValue(dataItem, operands[1]))));
		}else if(this.operator.equals(MetricOperator.NOT)){
			dataField.load(String.valueOf((0 - (Double)getValue(dataItem, operands[0]))));
		}else if(this.operator.equals(MetricOperator.LOG)){
			dataField.load(String.valueOf(Math.log((Double)getValue(dataItem, operands[0]))));
		}else if(this.operator.equals(MetricOperator.POW)){
			dataField.load(String.valueOf(Math.pow((Double)getValue(dataItem, operands[0]),(Double)getValue(dataItem, operands[1]))));
		}else if(this.operator.equals(MetricOperator.EXP)){
			dataField.load(String.valueOf(Math.exp((Double)getValue(dataItem, operands[0]))));
		}
		
		dataFields[dataFields.length - 1] = dataField;
		dataItem.setDataFields(dataFields);
		
		return dataItem;
	}



	/* (non-Javadoc)
	 * @see categorizer.core.ContextBuilder#load(common.DataContext)
	 */
	public void load(DataContext dataContext) throws Exception {
		
		Vector tempVector = dataContext.getElements2(labelTag);
		
		if(tempVector == null || tempVector.size() <= 0 )
			throw new UnsupportedDataContextException();
		
		this.label = (String)tempVector.get(0);
		
		tempVector = dataContext.getElements2(operatorTag);
		
		if(tempVector == null || tempVector.size() <= 0 )
			throw new UnsupportedDataContextException();
		
		this.operator = MetricOperator.valueOf((String)tempVector.get(0));
		
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
		
		DataContext dataHeaderContext = dataContext.getNode(dataHeaderTag);
		
		if(dataHeaderContext == null)
			throw new UnsupportedDataContextException();
		
		dataHeader = new DataHeader();
		
		dataHeader.load(dataHeaderContext);		
		
	}


	
	/* (non-Javadoc)
	 * @see categorizer.core.ContextBuilder#store()
	 */
	public DataContext store() throws Exception {
		
		DataContext dataContext = new DataContext();
		
		dataContext.add(new NodePair(labelTag, this.label));
		dataContext.add(new NodePair(operatorTag, this.operator.name()));
		
		DataContext operandsContext = new DataContext();
		for(int i=0; i<operands.length; i++)
			operandsContext.add(operandTag,operands[i].store());
		
		dataContext.add(operandsTag, operandsContext);
		
		dataContext.add(dataHeaderTag, dataHeader.store());		
		
		return dataContext;
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
			String headerName = (String)operand.getOperandValue();
			
			for(int i=0; i<dataItem.getDataFields().length; i++)
			{
				DataField dataField = dataItem.getDataFields()[i];
				
				if(dataField.getDataHeader().getLabel().equalsIgnoreCase(headerName))
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
