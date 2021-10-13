package parser.Java.MetricsRelatedFiles;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Iterator;

import common.NodePair;
import definitions.metrics.CommonMetricTypes;

/*
 * this class will keep the metrics that are specific to methods of java classes
 * */
public class MethodMetrics {
	
	private DecimalFormat df = new DecimalFormat("0.00");
	
	private int baseCC = 1;
	private int unstructuredElement = 1;

	private HashSet<String> uniqueOperands = new HashSet<String>();
	private HashSet<String> uniqueOperators = new HashSet<String>();
	private int formalParameters = 0;
	private HashSet<String> callPairs = new HashSet<String>();

	// below is the builder for the class
	// that initializes the name
	public MethodMetrics(String name) {
		this.name = name;
		this.id = getGlobalIdCounter();
	}

	// branch count of the class is incremented by one
	public void increaseBranchCount() {
		this.branchCount++;
	}

	// returns the branch-count
	// public int getBranchCount()
	// {
	// return branchCount;
	// }

	// get the number of the total operators
	// public int getTotalOperators()
	// {
	// return totalOperators;
	// }

	// return the number of total operands
	// public int getTotalOperands()
	// {
	// return totalOperands;
	// }

	// this function increments the condition count by one
	public void increaseConditionCount() {
		this.conditionCount++;
	}

	// returns the condition count
	// public int getConditionCount()
	// {
	// return conditionCount;
	// }

	// increments the decision count by one
	public void increaseDecisionCount() {
		this.decisionCount++;
	}

	// returns decision count
	// public int getDecisionCount()
	// {
	// return decisionCount;
	// }

	// adds the name of the operand
	// and increments the total operand number
	// regardless of whether its unique or not
	public void addOperand(String uniqueOperand) {
		this.uniqueOperands.add(uniqueOperand);
		totalOperands++;
	}

	// returns the number of the unique operands
	public int getUniqueOperandsCount() {
		return uniqueOperands.size();
	}

	public NodePair getUniqueOperandsCountNode() {
		return new NodePair(CommonMetricTypes.UNIQUEOPERANDSCOUNT.getLabel(),
				String.valueOf(getUniqueOperandsCount()));
	}

	// returns the unique operands in the form of an array of strings
	public String[] getUniqueOperands() {
		String toBeReturned[] = new String[uniqueOperands.size()];
		Iterator<String> iterator = uniqueOperands.iterator();
		int index = 0;

		while (iterator.hasNext()) {
			toBeReturned[index++] = iterator.next();
		}
		return toBeReturned;
	}

	// adds a unique operator and increments the total number of operators
	public void addOperator(String uniqueOperator) {
		this.uniqueOperators.add(uniqueOperator);
		totalOperators++;
	}

	// returns the number of the unique operators
	public int getUniqueOperatorsCount() {
		return uniqueOperators.size();
	}

	// returns the unique operators in the form of an array of strings
	public String[] getUniqueOperators() {
		String toBeReturned[] = new String[uniqueOperators.size()];
		Iterator<String> iterator = uniqueOperators.iterator();
		int index = 0;

		while (iterator.hasNext()) {
			toBeReturned[index++] = iterator.next();
		}
		return toBeReturned;
	}

	// returns the number of the formal parameters
	public int getFormalParameters() {
		return formalParameters;
	}

	public NodePair getFormalParametersNode() {
		return new NodePair(CommonMetricTypes.FORMALPARAMETERS.getLabel(),
				String.valueOf(getFormalParameters()));
	}

	// increments the number of the formal parameters
	public void increaseFormalParameters() {
		this.formalParameters++;
	}

	// retuns the call pairs in the form of an array of strings
	public String[] getCallPair() {
		String toBeReturned[] = new String[callPairs.size()];
		Iterator<String> iterator = callPairs.iterator();
		int index = 0;

		while (iterator.hasNext()) {
			toBeReturned[index++] = iterator.next();
		}
		return toBeReturned;
	}

	public NodePair getCallPairLengthNode() {
		return new NodePair(CommonMetricTypes.CALLPAIRLENGTH.getLabel(), String
				.valueOf(getCallPair().length));
	}

	// adds a new call pair to the hashset of the call pairs
	public void addCallPair(String call) {
		this.callPairs.add(call);
	}

	// calculate and return the cyclomatic complexity
	public int getCyclomaticComplexity() {
		return baseCC + branchCount;
	}

	// increment the base CC
	public void increaseBaseCC() {
		this.baseCC++;
	}

	// return the essential complexity
	public int getEssentialComplexity() {
		return unstructuredElement;
	}

	// increase unstructured element
	public void increaseUnstructuredElement() {
		this.unstructuredElement++;
	}

	// returns the number of lines of code
	public int getLOC() {
		return LOC;
	}

	// the set function for the lines of code

	public void setLOC(int loc) {
		this.LOC = loc;
	}

	public NodePair getCyclomaticComplexityNode() {
		return new NodePair(CommonMetricTypes.CYCLOMATICCOMPLEXITY.getLabel(),
				String.valueOf(getCyclomaticComplexity()));
	}

	// ////////////////////////COMMON

	// below are the metrics common to all structures
	public String name; // the name of the method, class or package
	protected static int globalIdCounter = 0;
	protected int id;
	protected int LOC = 0; // lines of code metric
	protected int branchCount;
	protected int totalOperators;
	protected int totalOperands;
	protected int conditionCount;
	protected int decisionCount;
	protected int cyclomaticComplexity;
	protected int essentialComplexity;

	// below are the set functions of the common metrics
	public void setName(String myName) {
		this.name = myName;
	}

	public void setBranchCount(int myBranchCount) {
		this.branchCount = myBranchCount;
	}

	public void setTotalOperators(int myTotalOperators) {
		this.totalOperators = myTotalOperators;
	}

	public void setTotalOperands(int myTotalOperands) {
		this.totalOperands = myTotalOperands;
	}

	public void setConditionCount(int myConditionCount) {
		this.conditionCount = myConditionCount;
	}

	public void setDecisionCount(int myDecisionCount) {
		this.decisionCount = myDecisionCount;
	}

	public void setCyclomaticComplexity(int myCyclomaticComplexity) {
		this.cyclomaticComplexity = myCyclomaticComplexity;
	}

	public void setEssentialComplexity(int myEssentialComplexity) {
		this.essentialComplexity = myEssentialComplexity;
	}

	// below are the get functions of the common metrics

	public String getName() {
		return this.name;
	}

	public NodePair getNameNode() {
		return new NodePair(CommonMetricTypes.NAME.getLabel(), getName());
	}

	public NodePair getLOCNode() {
		return new NodePair(CommonMetricTypes.LOC.getLabel(), String
				.valueOf(getLOC()));
	}

	public int getBranchCount() {
		return this.branchCount;
	}

	public NodePair getBranchCountNode() {
		return new NodePair(CommonMetricTypes.BRANCHCOUNT.getLabel(), String
				.valueOf(getBranchCount()));
	}

	public int getTotalOperators() {
		return this.totalOperators;
	}

	public NodePair getTotalOperatorsNode() {
		return new NodePair(CommonMetricTypes.TOTALOPERATORS.getLabel(), String
				.valueOf(getTotalOperators()));
	}

	public int getTotalOperands() {
		return this.totalOperands;
	}

	public NodePair getTotalOperandsNode() {
		return new NodePair(CommonMetricTypes.TOTALOPERANDS.getLabel(), String
				.valueOf(getTotalOperands()));
	}

	public int getConditionCount() {
		return this.conditionCount;
	}

	public NodePair getConditionCountNode() {
		return new NodePair(CommonMetricTypes.CONDITIONCOUNT.getLabel(), String
				.valueOf(getConditionCount()));
	}

	public int getDecisionCount() {
		return this.decisionCount;
	}

	public NodePair getDecisionCountNode() {
		return new NodePair(CommonMetricTypes.DECISIONCOUNT.getLabel(), String
				.valueOf(getDecisionCount()));
	}

	public NodePair getUniqueOperatorsCountNode() {
		return new NodePair(CommonMetricTypes.UNIQUEOPERATORSCOUNT.getLabel(),
				String.valueOf(getUniqueOperatorsCount()));
	}

	public NodePair getEssentialComplexityNode() {
		return new NodePair(CommonMetricTypes.ESSENTIALCOMPLEXITY.getLabel(),
				String.valueOf(getEssentialComplexity()));
	}

	public static int getGlobalIdCounter() {
		return globalIdCounter++;
	}

	public int getId() {
		return id;
	}

	public NodePair getIdNode() {
		return new NodePair(CommonMetricTypes.ID.getLabel(), String
				.valueOf(getId()));
	}

	// below are the calculation and get functions of more complex metrics that
	// will be common to methods, classes and packages
	
	// SciDesktop Modification TA_R001	--- getNormalized introduced to fix a localization bug when localization mandates a different decimal separator 
	public final double getNormalized(double d)
	{
		char dp = df.getDecimalFormatSymbols().getDecimalSeparator();
		try {
			return Double.parseDouble(df.format(d).replace((char) 8734, '0').replace((char) 65553,'0').replace(dp, '.'));
		} catch (Exception e) {
			return -1.0;
		}
	}
	
	// SciDesktop Modification TA_R001	--- getNormalizedRV introduced to fix a localization bug when localization mandates a different decimal separator 
	public final double getNormalizedRV(double d)
	{
		char dp = df.getDecimalFormatSymbols().getDecimalSeparator();
		return Double.parseDouble(df.format(d).replace("?","0").replace(dp, '.'));
	}

	public final double getHalsteadDifficulty() {
		if (getHalsteadLevel() == 0)
			return 0; // zero is returned instead of positive infinity
		// return Double.POSITIVE_INFINITY;
		else {
			double temp;
			temp = 1 / getHalsteadLevel();
			// SciDesktop Modification TA_R001	--- calls getnormalization 
			return getNormalized(temp);
		}
	}

	public NodePair getHalsteadDifficultyNode() {
		return new NodePair(CommonMetricTypes.HALSTEADDIFFICULTY.getLabel(),
				String.valueOf(getHalsteadDifficulty()));
	}

	public final int getHalsteadLength() {
		return getTotalOperands() + getTotalOperators();
	}

	public NodePair getHalsteadLengthNode() {
		return new NodePair(CommonMetricTypes.HALSTEADLENGTH.getLabel(), String
				.valueOf(getHalsteadLength()));
	}

	public final double getHalsteadLevel() {
		if (getUniqueOperatorsCount() == 0 || getTotalOperands() == 0) {
			return 0;
		} else {
			double Level = 2;
			Level *= getUniqueOperandsCount();
			Level /= getUniqueOperatorsCount();
			Level /= getTotalOperands();
			
			double temp;
			temp = Level;
			// SciDesktop Modification TA_R001	--- calls getnormalization 
			return getNormalized(temp);
			
		}
	}

	public NodePair getHalsteadLevelNode() {
		return new NodePair(CommonMetricTypes.HALSTEADLEVEL.getLabel(), String
				.valueOf(getHalsteadLevel()));
	}

	public final double getHalsteadProgrammingEffort() {
		
		double temp;
		temp = getHalsteadDifficulty() * getHalsteadVolume();
		// SciDesktop Modification TA_R001	--- calls getnormalization 
		return getNormalized(temp);
		
	}

	public NodePair getHalsteadProgrammingEffortNode() {
		return new NodePair(CommonMetricTypes.HALSTEADPROGRAMMINGEFFORT
				.getLabel(), String.valueOf(getHalsteadProgrammingEffort()));
	}

	public final double getHalsteadProgrammingTime() {
		double temp;
		temp = getHalsteadProgrammingEffort() / 18;
		// SciDesktop Modification TA_R001	--- calls getnormalization 
		return getNormalizedRV(temp);
		
	}

	public NodePair getHalsteadProgrammingTimeNode() {
		return new NodePair(CommonMetricTypes.HALSTEADPROGRAMMINGTIME
				.getLabel(), String.valueOf(getHalsteadProgrammingTime()));
	}

	public final double getHalsteadVolume() {
		double N = getHalsteadLevel();
		double n = getUniqueOperatorsCount() + getUniqueOperandsCount();
		if (n == 0)
			return 0;
		
		double temp;
		temp = java.lang.Math.log10(n) * N;
		// SciDesktop Modification TA_R001	--- calls getnormalization 
		return getNormalizedRV(temp);
	}

	public NodePair getHalsteadVolumeNode() {
		return new NodePair(CommonMetricTypes.HALSTEADVOLUME.getLabel(), String
				.valueOf(getHalsteadVolume()));
	}

	public final double getDecisionDensity() {
		if (getDecisionCount() == 0)
			return 0; // zero is returned instead of NaN
		// return Double.NaN;
		else{
			double temp;
			temp = ((double) getConditionCount()) / getDecisionCount();
			// SciDesktop Modification TA_R001	--- calls getnormalization 
			return getNormalizedRV(temp);
		}
	}

	public NodePair getDecisionDensityNode() {
		return new NodePair(CommonMetricTypes.DECISIONDENSITY.getLabel(),
				String.valueOf(getDecisionDensity()));
	}

	public final double getEssentialDensity() {
		if (getCyclomaticComplexity() == 1)
			return 0; // zero is returned instead of NaN
		// return Double.NaN;
		else{
			double temp;
			temp = ((double) getEssentialComplexity() - 1)	/ (getCyclomaticComplexity() - 1);
			// SciDesktop Modification TA_R001	--- calls getnormalization 
			return getNormalizedRV(temp);
			
		}
	}

	public NodePair getEssentialDensityNode() {
		return new NodePair(CommonMetricTypes.ESSENTIALDENSITY.getLabel(),
				String.valueOf(getEssentialDensity()));
	}

	public final double getCylomaticDensity() {
		double temp;
		temp = ((double) getLOC()) / (getCyclomaticComplexity());
		// SciDesktop Modification TA_R001	--- calls getnormalization 
		return getNormalizedRV(temp);
	}

	public NodePair getCylomaticDensityNode() {
		return new NodePair(CommonMetricTypes.CYCLOMATICDENSITY.getLabel(),
				String.valueOf(getCylomaticDensity()));
	}

	public final double getMaintenanceSeverity() {
		int cc = getCyclomaticComplexity();
		if (cc == 0)
			return 0;
		
		double temp;
		temp = ((double) getEssentialComplexity()) / (cc);
		// SciDesktop Modification TA_R001	--- calls getnormalization 
		return getNormalizedRV(temp);
	}

	public NodePair getMaintenanceSeverityNode() {
		return new NodePair(CommonMetricTypes.MAINTENANCESEVERITY.getLabel(),
				String.valueOf(getMaintenanceSeverity()));
	}

}