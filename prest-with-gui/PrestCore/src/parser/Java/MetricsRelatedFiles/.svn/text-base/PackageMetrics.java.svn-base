package parser.Java.MetricsRelatedFiles;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import common.NodePair;

import definitions.metrics.CommonMetricTypes;

/**
 * 
 * this class will keep the metrics that are spesific to java packages
 */
public class PackageMetrics {

	private DecimalFormat df = new DecimalFormat("0.00");
	
	// below is the constructor of the class
	public PackageMetrics(String name) {
		this.name = name;
		this.id = MethodMetrics.getGlobalIdCounter();
		files = new LinkedHashMap<String, FileMetrics>();
	}

	LinkedHashMap<String, FileMetrics> files;

	// returns true if there exists a file within the package
	public boolean hasFile() {
		return files.size() > 0;
	}

	// returns the desired file of the package
	public FileMetrics getFile(String fileName) {
		return files.get(fileName);
	}
	
	public FileMetrics deleteFile(String fileName) {
		return files.remove(fileName);
	}

	// returns the filenames in the form of an iterator
	public Iterator<String> getFileNames() {
		return files.keySet().iterator();
	}
	
	public List<String> getFileNameList() {
		List<String> list = new ArrayList<String>();
		Iterator<String> it = files.keySet().iterator();
		while(it.hasNext()){
			list.add(it.next());
		}
		return list;
	}

	// adds the new file to the package and returns the newly added file
	public FileMetrics addFile(String fileToBeAdded) {
		FileMetrics file = files.get(fileToBeAdded);
		if (file == null)
			files.put(fileToBeAdded, new FileMetrics(fileToBeAdded));
		return files.get(fileToBeAdded);
	}

	// calculates the branch count
	public int getBranchCount() {
		int count = 0;
		String key = null;
		for (Iterator<String> iterator = files.keySet().iterator(); iterator
				.hasNext();) {
			key = iterator.next();
			count += files.get(key).getBranchCount();
		}
		return count;
	}

	// calculates the condition count
	public int getConditionCount() {
		int count = 0;
		String key = null;
		for (Iterator<String> iterator = files.keySet().iterator(); iterator
				.hasNext();) {
			key = iterator.next();
			count += files.get(key).getConditionCount();
		}
		return count;
	}

	// calculates the decision count
	public int getDecisionCount() {
		int count = 0;
		String key = null;
		for (Iterator<String> iterator = files.keySet().iterator(); iterator
				.hasNext();) {
			key = iterator.next();
			count += files.get(key).getDecisionCount();
		}
		return count;
	}

	// returns the number of the total operands
	public int getTotalOperands() {
		int count = 0;
		String key = null;
		for (Iterator<String> iterator = files.keySet().iterator(); iterator
				.hasNext();) {
			key = iterator.next();
			count += files.get(key).getTotalOperands();
		}
		return count;
	}

	// returns the number of the total operators
	public int getTotalOperators() {
		int count = 0;
		String key = null;
		for (Iterator<String> iterator = files.keySet().iterator(); iterator
				.hasNext();) {
			key = iterator.next();
			count += files.get(key).getTotalOperators();
		}
		return count;
	}

	// returns the unique operands in the form of an array of strings
	public String[] getUniqueOperands() {
		HashSet<String> operands = new HashSet<String>();
		String key = null;
		for (Iterator<String> iterator = files.keySet().iterator(); iterator
				.hasNext();) {
			key = iterator.next();
			String tempOperands[] = files.get(key).getUniqueOperands();
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

	// returns the number of the unique operands
	public int getUniqueOperandsCount() {
		return getUniqueOperands().length;
	}

	// returns the number of the unique operators
	public int getUniqueOperatorsCount() {
		return getUniqueOperators().length;
	}

	// returns the unique operators in the form of an array of strings
	public String[] getUniqueOperators() {
		HashSet<String> operators = new HashSet<String>();
		String key = null;
		for (Iterator<String> iterator = files.keySet().iterator(); iterator
				.hasNext();) {
			key = iterator.next();
			String tempOperators[] = files.get(key).getUniqueOperators();
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

	// calculates the cyclomatic complexity
	public int getCyclomaticComplexity() {
		int count = 0;
		String key = null;
		for (Iterator<String> iterator = files.keySet().iterator(); iterator
				.hasNext();) {
			key = iterator.next();
			count += files.get(key).getCyclomaticComplexity();
		}
		return count;
	}

	public NodePair getCyclomaticComplexityNode() {
		return new NodePair(CommonMetricTypes.CYCLOMATICCOMPLEXITY.getLabel(),
				String.valueOf(getCyclomaticComplexity()));
	}

	// calculates the essential complexity
	public int getEssentialComplexity() {
		int count = 0;
		String key = null;
		for (Iterator<String> iterator = files.keySet().iterator(); iterator
				.hasNext();) {
			key = iterator.next();
			count += files.get(key).getEssentialComplexity();
		}
		return count;
	}

	// returns the number of lines of code
	public int getLOC() {
		int count = 0;
		String key = null;
		for (Iterator<String> iterator = files.keySet().iterator(); iterator
				.hasNext();) {
			key = iterator.next();
			count += files.get(key).getLOC();
		}
		return count;
	}

	// sets the number of lines of code
	public void setLOC(int loc) {
		LOC = loc;
	}

	// /////////////////////COMMON

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

	public NodePair getUniqueOperandsCountNode() {
		return new NodePair(CommonMetricTypes.UNIQUEOPERANDSCOUNT.getLabel(),
				String.valueOf(getUniqueOperandsCount()));
	}

	public NodePair getUniqueOperatorsCountNode() {
		return new NodePair(CommonMetricTypes.UNIQUEOPERATORSCOUNT.getLabel(),
				String.valueOf(getUniqueOperatorsCount()));
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
	
	public final double getHalsteadDifficulty() {
		if (getHalsteadLevel() == 0)
			return 0; // zero is returned instead of positive infinity
		// return Double.POSITIVE_INFINITY;
		else{
			double temp;
			temp = 1 / getHalsteadLevel();
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
		else
		{
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
		else
		{
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