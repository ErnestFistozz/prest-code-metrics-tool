package parser.Java.MetricsRelatedFiles;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import common.NodePair;
import definitions.metrics.ClassMetricTypes;
import definitions.metrics.CommonMetricTypes;

/*
 * this class will keep the metrics that are spesific to java classes
 * */

public class ClassMetrics {

	private static final String OVERLOADNUMBERSEPERATOR = "-OVERLOAD";
	private DecimalFormat df = new DecimalFormat("0.00");
	
	// the followings are likely metrics to keep from the sample tool
	int numberOfChildren = 0;
	public int depth = 1;
	int couplingBetweenObjects = 0;
	int fanIn = 0;
	int pubData = 0;
	int Data = 0;
	int wmc = 0; // weighted methods per class
	int rfc = 0; // response for a class

	// below is a hashmap for the methods of the class
	LinkedHashMap<String, MethodMetrics> methods;

	// below is the constructor function for the class
	public ClassMetrics(String name) {
		this.name = name;
		this.id = MethodMetrics.getGlobalIdCounter();
		methods = new LinkedHashMap<String, MethodMetrics>();
	}

	// the below function returns a class of type MethodMetrics
	// as long as this method is a member of this class
	public MethodMetrics getMethod(String methodToBeReturned) {
		return methods.get(methodToBeReturned);
	}
	
	public void deleteMethod(String methodName){
		methods.remove(methodName);
	}

	private HashMap<String, Integer> polyList = new HashMap<String, Integer>();

	public MethodMetrics getMethodCheckPoly(String methodToBeReturned) {
		Integer count = polyList.get(methodToBeReturned);
		if (count == null) {
			polyList.put(methodToBeReturned, new Integer(1));
			return getMethod(methodToBeReturned);
		} else {
			int poly = count;
			polyList.put(methodToBeReturned, count + 1);
			return getMethod(methodToBeReturned + OVERLOADNUMBERSEPERATOR
					+ poly);
		}
	}

	// checks if the method to be added is already in the class
	// if not, then the method is added and this method is returned
	public MethodMetrics addMethod(String methodToBeAdded) {

		String addingName = methodToBeAdded;
		MethodMetrics method = methods.get(addingName);
		int poly = 0;
		while (method != null) {
			poly++;
			addingName = methodToBeAdded + OVERLOADNUMBERSEPERATOR + poly;
			method = methods.get(addingName);
		}
		methods.put(addingName, new MethodMetrics(methodToBeAdded));

		return methods.get(addingName);
	}

	// returns the name of the methods within this class in the form of an
	// iterator of strings
	public Iterator<String> getMethodNames() {
		return methods.keySet().iterator();
	}
	
	public List<String> getMethodNameList() {
		List<String> list = new ArrayList<String>();
		Iterator<String> it = methods.keySet().iterator();
		while(it.hasNext()){
			list.add(it.next());
		}
		return list;
	}

	// returns the number of children of this class
	public int getNumberOfChildren() {
		return numberOfChildren;
	}

	public NodePair getNumberOfChildrenNode() {
		return new NodePair(ClassMetricTypes.NUMBEROFCHILDREN.getLabel(),
				String.valueOf(getNumberOfChildren()));
	}

	// increment the number of children of that class by one
	public void increaseNumberOfchildren() {
		this.numberOfChildren++;
	}

	// return the coupling number of that class
	public int getCouplingBetweenObjects() {
		return couplingBetweenObjects;
	}

	public NodePair getCouplingBetweenObjectsNode() {
		return new NodePair(ClassMetricTypes.COUPLINGBETWEENOBJECTS.getLabel(),
				String.valueOf(getCouplingBetweenObjects()));
	}

	// increment the coupling of that class by one
	public void increaseCouplingBetweenObjects() {
		this.couplingBetweenObjects++;
	}

	// return the fan-in number of that class
	public int getFanIn() {
		return fanIn;
	}

	public NodePair getFanInNode() {
		return new NodePair(ClassMetricTypes.FANIN.getLabel(), String
				.valueOf(getFanIn()));
	}

	// increment the fan-in number by one
	public void increaseFanIn() {
		this.fanIn++;
	}

	// return the number of pub-data
	public int getPubData() {
		return pubData;
	}

	// increment the number of pub-data and data by one
	public void increasePubData() {
		this.pubData++;
		Data++;
	}

	// SciDesktop Modification TA_R001	--- getNormalized (double) introduced to fix a localization bug when localization mandates a different decimal separator 
	public final float getNormalized(float d)
	{
		char dp = df.getDecimalFormatSymbols().getDecimalSeparator();
		return Float.parseFloat(df.format(d).replace((char) 8734, '0').replace((char) 65553,'0').replace(dp, '.'));
	}

	// SciDesktop Modification TA_R001	--- getNormalized (float) introduced to fix a localization bug when localization mandates a different decimal separator 
	public final double getNormalized(double d)
	{
		char dp = df.getDecimalFormatSymbols().getDecimalSeparator();
		try {
			return Double.parseDouble(df.format(d).replace((char) 8734, '0').replace((char) 65553,'0').replace(dp, '.'));
		} catch (Exception e) {
			return -1.0;
		}
	}
	
	// returns the percentage of pub-data among data
	public float getPercentageOfPubData() {
		if (Data == 0)
			return 0; // zero is returned instead of NaN
		// return Float.NaN;
		else{
			float temp;
			temp = (((float) pubData) / Data) * 100;
			// SciDesktop Modification TA_R001	--- calls getnormalization 
			return getNormalized(temp);
		}
	}

	public NodePair getPercentageOfPubDataNode() {
		return new NodePair(ClassMetricTypes.PERCENTAGEOFPUBDATA.getLabel(), String
				.valueOf(getPercentageOfPubData()));
	}

	// increment the data number by one
	public void increaseData() {
		Data++;
	}

	// the below function overrides the getBrachCount method that was defined in
	// CommonMetrics.java class and now the branchCount is the total number of
	// all the branchCounts of each function within this class
	public int getBranchCount() {
		int branchCount = 0;
		String key = null;
		for (Iterator<String> iterator = methods.keySet().iterator(); iterator
				.hasNext();) {
			key = iterator.next();
			branchCount += methods.get(key).getBranchCount();
		}
		return branchCount;
	}

	// the below function overrides the getConditionCount method that was
	// defined in
	// CommonMetrics.java class and now the conditionCount is the total number
	// of
	// all the conditionCounts of each function within this class
	public int getConditionCount() {
		int conditionCount = 0;
		String key = null;
		for (Iterator<String> iterator = methods.keySet().iterator(); iterator
				.hasNext();) {
			key = iterator.next();
			conditionCount += methods.get(key).getConditionCount();
		}
		return conditionCount;
	}

	// the below function overrides the getDecisionCount method that was defined
	// in
	// CommonMetrics.java class and now the decisionCount is the total number of
	// all the decisionCounts of each function within this class
	public int getDecisionCount() {
		int decisionCount = 0;
		String key = null;
		for (Iterator<String> iterator = methods.keySet().iterator(); iterator
				.hasNext();) {
			key = iterator.next();
			decisionCount += methods.get(key).getDecisionCount();
		}
		return decisionCount;
	}

	// returns the sum of all the operands in each method of that class
	public int getTotalOperands() {
		int count = 0;
		String key = null;
		for (Iterator<String> iterator = methods.keySet().iterator(); iterator
				.hasNext();) {
			key = iterator.next();
			count += methods.get(key).getTotalOperands();
		}
		return count;
	}

	// returns the sum of all the operators in each method of that class
	public int getTotalOperators() {
		int count = 0;
		String key = null;
		for (Iterator<String> iterator = methods.keySet().iterator(); iterator
				.hasNext();) {
			key = iterator.next();
			count += methods.get(key).getTotalOperators();
		}
		return count;
	}

	// the below function returns all the unique operands of every method
	// in that class in the form of an array of strings
	public String[] getUniqueOperands() {
		HashSet<String> operands = new HashSet<String>();
		String key = null;
		for (Iterator<String> iterator = methods.keySet().iterator(); iterator
				.hasNext();) {
			key = iterator.next();
			String tempOperands[] = methods.get(key).getUniqueOperands();
			for (int i = 0; i < tempOperands.length; i++) {
				operands.add(tempOperands[i]);
			}
		}

		String retval[] = new String[operands.size()];
		Iterator<String> iterator = operands.iterator();
		int index = 0;
		while (iterator.hasNext()) {
			retval[index++] = iterator.next();
		}
		return retval;
	}

	// returns the sum of the cyclomatic complexities of every method in that
	// class
	public int getCyclomaticComplexity() {
		int count = 0;
		String key = null;
		for (Iterator<String> iterator = methods.keySet().iterator(); iterator
				.hasNext();) {
			key = iterator.next();
			count += methods.get(key).getCyclomaticComplexity();
		}
		return count;
	}

	// returns the sum of the essential complexity of each method of that class
	public int getEssentialComplexity() {
		int count = 0;
		String key = null;
		for (Iterator<String> iterator = methods.keySet().iterator(); iterator
				.hasNext();) {
			key = iterator.next();
			count += methods.get(key).getEssentialComplexity();
		}
		return count;
	}

	// retuns the number of unique operands
	public int getUniqueOperandsCount() {
		return getUniqueOperands().length;
	}

	// return the number of the unique operators
	public int getUniqueOperatorsCount() {
		return getUniqueOperators().length;
	}

	// returns the unique operators in the form of an array of string
	// this array of string includes all the operators of every method
	public String[] getUniqueOperators() {
		HashSet<String> operators = new HashSet<String>();
		String key = null;
		for (Iterator<String> iterator = methods.keySet().iterator(); iterator
				.hasNext();) {
			key = iterator.next();
			String tempOperators[] = methods.get(key).getUniqueOperators();
			for (int i = 0; i < tempOperators.length; i++) {
				operators.add(tempOperators[i]);
			}
		}

		String retval[] = new String[operators.size()];
		Iterator<String> iterator = operators.iterator();
		int index = 0;
		while (iterator.hasNext()) {
			retval[index++] = iterator.next();
		}
		return retval;
	}

	// returns whether the class has a method or not
	public boolean hasMethod() {
		return methods.size() > 0;
	}

	// returns the number of weighted methods of that class
	public int getWeightedMethods() {
		return wmc;
	}

	public NodePair getWeightedMethodsNode() {
		return new NodePair(ClassMetricTypes.WMC.getLabel(), String
				.valueOf(getWeightedMethods()));
	}

	// increments the number of the weighted methods
	public void increaseWeightedMethods() {
		this.wmc++;
	}

	// returns the sum of the response for class and the weighted methods for
	// class
	public int getResponseForClass() {
		return rfc + wmc;
	}

	public NodePair getResponseForClassNode() {
		return new NodePair(ClassMetricTypes.RFC.getLabel(), String
				.valueOf(getResponseForClass()));
	}

	// sets the response for this class
	public void setInheritedResponseForClass(int rfc) {
		if (rfc == 0)
			this.rfc = rfc;
	}

	// returns the number of lines of code
	public int getLOC() {
		return LOC;
	}

	// sets the number of lines of code
	public void setLOC(int loc) {
		LOC = loc;

	}

	public NodePair getCyclomaticComplexityNode() {
		return new NodePair(CommonMetricTypes.CYCLOMATICCOMPLEXITY.getLabel(),
				String.valueOf(getCyclomaticComplexity()));
	}

	// /////////////////COMMON

	// below are the metrics common to all structures
	public String name; // the name of the method, class or package
	protected int id;
	protected int LOC = 0; // lines of code metric
	protected int branchCount;
	protected int totalOperators;
	protected int totalOperands;
	protected int conditionCount;
	protected int decisionCount;
	protected int uniqueOperatorsCount;
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

	public void setUniqueOperatorsCount(int myUniqueOperatorsCount) {
		this.uniqueOperatorsCount = myUniqueOperatorsCount;
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

	public NodePair getBranchCountNode() {
		return new NodePair(CommonMetricTypes.BRANCHCOUNT.getLabel(), String
				.valueOf(getBranchCount()));
	}

	public NodePair getTotalOperatorsNode() {
		return new NodePair(CommonMetricTypes.TOTALOPERATORS.getLabel(), String
				.valueOf(getTotalOperators()));
	}

	public NodePair getTotalOperandsNode() {
		return new NodePair(CommonMetricTypes.TOTALOPERANDS.getLabel(), String
				.valueOf(getTotalOperands()));
	}

	public NodePair getConditionCountNode() {
		return new NodePair(CommonMetricTypes.CONDITIONCOUNT.getLabel(), String
				.valueOf(getConditionCount()));
	}

	public NodePair getDecisionCountNode() {
		return new NodePair(CommonMetricTypes.DECISIONCOUNT.getLabel(), String
				.valueOf(getDecisionCount()));
	}

	public NodePair getUniqueOperatorsCountNode() {
		return new NodePair(CommonMetricTypes.UNIQUEOPERATORSCOUNT.getLabel(),
				String.valueOf(getUniqueOperatorsCount()));
	}

	public NodePair getUniqueOperandsCountNode() {
		return new NodePair(CommonMetricTypes.UNIQUEOPERANDSCOUNT.getLabel(),
				String.valueOf(getUniqueOperandsCount()));
	}

	public NodePair getEssentialComplexityNode() {
		return new NodePair(CommonMetricTypes.ESSENTIALCOMPLEXITY.getLabel(),
				String.valueOf(getEssentialComplexity()));
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
	public final double getHalsteadDifficulty() {
		if (getHalsteadLevel() == 0)
			return 0; // zero is returned instead of positive infinity
		// return Double.POSITIVE_INFINITY;
		else{
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
			if (getUniqueOperandsCount() == 0)
				return 0; // zero is returned instead of NaN
			// return Double.NaN;
			else
				return 0; // zero is returned instead of positive infinity
			// return Double.POSITIVE_INFINITY;
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
		return getNormalized(temp);
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
		return getNormalized(temp);
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
			return getNormalized(temp);
			
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
			temp = ((double) getEssentialComplexity() - 1)
			/ (getCyclomaticComplexity() - 1);
			// SciDesktop Modification TA_R001	--- calls getnormalization 
			return getNormalized(temp);
			
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
		return getNormalized(temp);
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
		return getNormalized(temp);
	}

	public NodePair getMaintenanceSeverityNode() {
		return new NodePair(CommonMetricTypes.MAINTENANCESEVERITY.getLabel(),
				String.valueOf(getMaintenanceSeverity()));
	}

}