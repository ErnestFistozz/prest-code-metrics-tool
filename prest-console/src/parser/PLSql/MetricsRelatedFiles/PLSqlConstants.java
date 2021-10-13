package parser.PLSql.MetricsRelatedFiles;

public class PLSqlConstants {

	public static final boolean roundTheDoubles = true;
	public static final boolean printScreen = true;
	
	//20
	public static final String COLUMN_NAMES[] = { "cyclomatic_density","decision_density","essential_density",
		"branch_count","condition_count","cyclomatic_complexity","decision_count","essential_complexity",
		"lines_of_code","total_operands","total_operators","unique_operands_count", "unique_operators_count",
		"halstead_difficulty","halstead_length","halstead_level","halstead_programming_effort",
		"halstead_programming_time","halstead_volume","maintenance_complexity" };//,"Risk Level"

	
	public static int MAX_COLUMNS = COLUMN_NAMES.length;
}
