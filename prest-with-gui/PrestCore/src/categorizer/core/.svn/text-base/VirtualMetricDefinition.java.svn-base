package categorizer.core;

import java.util.Vector;

import common.DataContext;

/**
 * @author secil.karagulle
 * @author ovunc.bozcan
 */
public class VirtualMetricDefinition implements ContextBuilder {

	/**
	 * label of the VirtualMetric
	 */
	private String label;
	
	/**
	 * operator of the VirtualMetric
	 */
	private String operator;
	
	/**
	 * operands of the VirtualMetric
	 */
	private DataHeader[] operands;
	
	/**
	 * Tag name of categorizer definition
	 */
	private final String currentTag = "virtualMetric";
	
	/**
	 * Tag name of the label
	 */
	private final String labelTag = "label";
	
	/**
	 * Tag name of the operator
	 */
	private final String operatorTag = "operator";
	
	/**
	 * Tag name of the operands
	 */
	private final String operandsTag = "operands";

	/**
	 * Tag name of the operand
	 */
	private final String operandTag = "operand";
	
	
	public VirtualMetricDefinition(){
		super();
	}

	public void load(DataContext dataContext) throws Exception {
		// TODO Auto-generated method stub
		if(dataContext == null)
			throw new UnsupportedDataContextException();

		Vector tempVector = dataContext.getElements2(labelTag);

		if (tempVector == null || tempVector.size() == 0)
			throw new UnsupportedDataContextException();

		this.label = new String((String) tempVector.get(0));

		tempVector = dataContext.getElements2(operatorTag);

		if (tempVector == null || tempVector.size() == 0)
			throw new UnsupportedDataContextException();

		this.operator = new String((String) tempVector.get(0));

		DataContext operandContext = dataContext.getNode(operandsTag);

		if (operandsTag == null)
			throw new UnsupportedDataContextException();

		Vector operands = operandContext.getNodes(operandTag);
		
		
		/*

		if (operands != null && operands.size() > 0) {
			this.operandContext = new O[operands.size()];

			for (int i = 0; i < options.size(); i++) {
				OptionDefinition optDef = new OptionDefinition();
				optDef.load((DataContext) options.get(i));
				this.optionDefinitions[i] = optDef;
			}
		}

		*/

	}

	public DataContext store() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public DataHeader[] getOperands() {
		return operands;
	}

	public void setOperands(DataHeader[] operands) {
		this.operands = operands;
	}

}
