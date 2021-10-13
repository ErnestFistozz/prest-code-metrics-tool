package parser.PLSql.MetricsRelatedFiles;

import parser.PLSql.PLSqlParserRelatedFiles.SoftwareMetrics.ModuleDetails;

import common.NodePair;
import common.data.DataContext;

public class PLSqlCommonMetrics {
	private String name;
	private double cyclomatic_density;
	private double decision_density;
	private double essential_density;
	private int branch_count;
	private int condition_count;
	private double cyclomatic_complexity;
	private int decision_count;
	private double essential_complexity;
	private int lines_of_code;
	private int total_operands;
	private int total_operators;
	private int unique_operands_count;
	private int unique_operators_count;
	private double halstead_difficulty;
	private double halstead_length;
	private double halstead_level;
	private double halstead_programming_effort;
	private double halstead_programming_time;
	private double halstead_volume;
	private double maintenance_complexity;
	//private String Risk_Level;
	
	public PLSqlCommonMetrics() {
		super();
	}
	
	public PLSqlCommonMetrics(ModuleDetails moduleDetails) {
		super();
		this.name = moduleDetails.name;
		this.cyclomatic_density = moduleDetails.cyclomatic / moduleDetails.statementCnt; //ratio of cyclomatic complexity to executable lines of code
		this.decision_density = getDecisionDensity(moduleDetails);		//This number is the ratio of decision points and conditions.
											//It measures the density of decision points.
		this.essential_density = getEssentialDensity(moduleDetails);
		this.branch_count = moduleDetails.branchCount;
		this.condition_count = moduleDetails.conditionCount;
		this.cyclomatic_complexity = moduleDetails.cyclomatic;
		this.decision_count = moduleDetails.decisionCount;
		this.essential_complexity = getEssentialComplexity(moduleDetails);;
		this.lines_of_code = moduleDetails.sourceLines;
		this.total_operands = moduleDetails.totalOperands;
		this.total_operators = moduleDetails.totalOperators;
		this.unique_operands_count = moduleDetails.distinctOperands;
		this.unique_operators_count = moduleDetails.distinctOperators;
		this.halstead_difficulty = moduleDetails.difficulty;
		this.halstead_length = moduleDetails.programLength;
		this.halstead_level = getHalsteadLevel(moduleDetails);
		this.halstead_programming_effort = moduleDetails.effort;
		this.halstead_programming_time = moduleDetails.effort / 18;	//Halstead Time = (Halstead Effort)/18.
		this.halstead_volume = moduleDetails.volume;
		this.maintenance_complexity = getMaintenanceComplexity(moduleDetails);	// = essential complexity/cyclomatic complexity
		//this.Risk_Level = "False";
	}

	private double getMaintenanceComplexity(ModuleDetails moduleDetails) {
		if(0 == moduleDetails.cyclomatic)
			return 0;
		else{
			return getEssentialComplexity(moduleDetails) / moduleDetails.cyclomatic;
		}
	}

	private double getEssentialComplexity(ModuleDetails moduleDetails) {
		if(0 == moduleDetails.unstructuredElement)
			return 1;
		else{
			return moduleDetails.unstructuredElement;
		}
	}

	private double getEssentialDensity(ModuleDetails moduleDetails) {
		if(moduleDetails.cyclomatic == 1)
			return 0;	// zero is returned instead of NaN
		else{
			return (getEssentialComplexity(moduleDetails) - 1) / (moduleDetails.cyclomatic -1);
		}
	}

	private double getDecisionDensity(ModuleDetails moduleDetails) {
		if(0 == moduleDetails.decisionCount)
			return 0;
		else{
			return (double)moduleDetails.conditionCount / moduleDetails.decisionCount;
		}
	}

	private double getHalsteadLevel(ModuleDetails moduleDetails) {
		//Halstead Level = (Halstead Potential Volume)/(Halstead Volume)
		//where Halstead Potential Volume is:
		//if unique operators = n1, unique operands = n2
		//and total operands = N2, Halstead Volume = V
		//Halstead Potential Volume = (2*n2/n1*N2)*V
		double potentialVolume =  (2*moduleDetails.distinctOperands/moduleDetails.distinctOperators*moduleDetails.totalOperands)*moduleDetails.volume;
		return potentialVolume / moduleDetails.volume;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCyclomatic_density() {
		return cyclomatic_density;
	}

	public void setCyclomatic_density(double cyclomatic_density) {
		this.cyclomatic_density = cyclomatic_density;
	}

	public double getDecision_density() {
		return decision_density;
	}

	public void setDecision_density(double decision_density) {
		this.decision_density = decision_density;
	}

	public double getEssential_density() {
		return essential_density;
	}

	public void setEssential_density(double essential_density) {
		this.essential_density = essential_density;
	}

	public int getBranch_count() {
		return branch_count;
	}

	public void setBranch_count(int branch_count) {
		this.branch_count = branch_count;
	}

	public int getCondition_count() {
		return condition_count;
	}

	public void setCondition_count(int condition_count) {
		this.condition_count = condition_count;
	}

	public double getCyclomatic_complexity() {
		return cyclomatic_complexity;
	}

	public void setCyclomatic_complexity(double cyclomatic_complexity) {
		this.cyclomatic_complexity = cyclomatic_complexity;
	}

	public int getDecision_count() {
		return decision_count;
	}

	public void setDecision_count(int decision_count) {
		this.decision_count = decision_count;
	}

	public double getEssential_complexity() {
		return essential_complexity;
	}

	public void setEssential_complexity(double essential_complexity) {
		this.essential_complexity = essential_complexity;
	}

	public int getLines_of_code() {
		return lines_of_code;
	}

	public void setLines_of_code(int lines_of_code) {
		this.lines_of_code = lines_of_code;
	}

	public int getTotal_operands() {
		return total_operands;
	}

	public void setTotal_operands(int total_operands) {
		this.total_operands = total_operands;
	}

	public int getTotal_operators() {
		return total_operators;
	}

	public void setTotal_operators(int total_operators) {
		this.total_operators = total_operators;
	}

	public int getUnique_operands_count() {
		return unique_operands_count;
	}

	public void setUnique_operands_count(int unique_operands_count) {
		this.unique_operands_count = unique_operands_count;
	}

	public int getUnique_operators_count() {
		return unique_operators_count;
	}

	public void setUnique_operators_count(int unique_operators_count) {
		this.unique_operators_count = unique_operators_count;
	}

	public double getHalstead_difficulty() {
		return halstead_difficulty;
	}

	public void setHalstead_difficulty(double halstead_difficulty) {
		this.halstead_difficulty = halstead_difficulty;
	}

	public double getHalstead_length() {
		return halstead_length;
	}

	public void setHalstead_length(double halstead_length) {
		this.halstead_length = halstead_length;
	}

	public double getHalstead_level() {
		return halstead_level;
	}

	public void setHalstead_level(double halstead_level) {
		this.halstead_level = halstead_level;
	}

	public double getHalstead_programming_effort() {
		return halstead_programming_effort;
	}

	public void setHalstead_programming_effort(double halstead_programming_effort) {
		this.halstead_programming_effort = halstead_programming_effort;
	}

	public double getHalstead_programming_time() {
		return halstead_programming_time;
	}

	public void setHalstead_programming_time(double halstead_programming_time) {
		this.halstead_programming_time = halstead_programming_time;
	}

	public double getHalstead_volume() {
		return halstead_volume;
	}

	public void setHalstead_volume(double halstead_volume) {
		this.halstead_volume = halstead_volume;
	}

	public double getMaintenance_complexity() {
		return maintenance_complexity;
	}

	public void setMaintenance_complexity(double maintenance_complexity) {
		this.maintenance_complexity = maintenance_complexity;
	}

	
	
	public String[] getAllMetrics() {
		String[] metrics = new String[PLSqlConstants.MAX_COLUMNS+1]; //22
		metrics[0] = getName();
		metrics[1] = getCyclomatic_density()+"";
		metrics[2] = getDecision_density()+"";
		metrics[3] = getEssential_density()+"";
		metrics[4] = getBranch_count()+"";
		metrics[5] = getCondition_count()+"";
		metrics[6] = getCyclomatic_complexity()+"";
		metrics[7] = getDecision_count()+"";
		metrics[8] = getEssential_complexity()+"";
		metrics[9] = getLines_of_code()+"";
		metrics[10] = getTotal_operands()+"";
		metrics[11] = getTotal_operators()+"";
		metrics[12] = getUnique_operands_count()+"";
		metrics[13] = getUnique_operators_count()+"";
		metrics[14] = getHalstead_difficulty()+"";
		metrics[15] = getHalstead_length()+"";
		metrics[16] = getHalstead_level()+"";
		metrics[17] = getHalstead_programming_effort()+"";
		metrics[18] = getHalstead_programming_time()+"";
		metrics[19] = getHalstead_volume()+"";
		metrics[20] = getMaintenance_complexity()+"";
		//metrics[21] = getRisk_Level();
		return metrics;
	}
	
	public String[] getAllMetrics_Rounded() {
		String[] metrics = new String[PLSqlConstants.MAX_COLUMNS+1]; //22
		metrics[0] = getName();
		metrics[1] = round(getCyclomatic_density())+"";
		metrics[2] = round(getDecision_density())+"";
		metrics[3] = round(getEssential_density())+"";
		metrics[4] = getBranch_count()+"";
		metrics[5] = getCondition_count()+"";
		metrics[6] = round(getCyclomatic_complexity())+"";
		metrics[7] = getDecision_count()+"";
		metrics[8] = round(getEssential_complexity())+"";
		metrics[9] = getLines_of_code()+"";
		metrics[10] = getTotal_operands()+"";
		metrics[11] = getTotal_operators()+"";
		metrics[12] = getUnique_operands_count()+"";
		metrics[13] = getUnique_operators_count()+"";
		metrics[14] = round(getHalstead_difficulty())+"";
		metrics[15] = round(getHalstead_length())+"";
		metrics[16] = round(getHalstead_level())+"";
		metrics[17] = round(getHalstead_programming_effort())+"";
		metrics[18] = round(getHalstead_programming_time())+"";
		metrics[19] = round(getHalstead_volume())+"";
		metrics[20] = round(getMaintenance_complexity())+"";
		//metrics[21] = getRisk_Level();
		return metrics;
	}
	
	public DataContext convertToDataContext(){
		String[] metrics;
		if(PLSqlConstants.roundTheDoubles){
			metrics = this.getAllMetrics_Rounded();
		}
		else{
			metrics = this.getAllMetrics();
		}
		DataContext dataContext = new DataContext();
		
		//add name
		NodePair nodePair = new NodePair("name", metrics[0]);
		dataContext.add(nodePair);
		
		//metrics[0] is the name, skip it
		for (int i = 1; i < metrics.length; i++) {
			nodePair = new NodePair(PLSqlConstants.COLUMN_NAMES[i-1], metrics[i]);
			dataContext.add(nodePair);
		}
		return dataContext;
	}
	
	/**
	 * A utility method for rounding a double.
	 * Current version leaves two digits after the decimal point
	 * 
	 * @param	d the number to be rounded
	 * @return	the resulting (rounded) number
	 */
	public double round(double d) {
		double result = 0;
		result = 100*d;
		long temp = Math.round(result);
		if(temp != 0)
			return ((double)temp)/100;
		else
			return 0;
	}
}
