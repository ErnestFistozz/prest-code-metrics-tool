package definitions.metrics;

import java.util.List;

public class CommonMetricTypes extends BaseMetric {

	public static final BaseMetric NAME = new BaseMetric("name", false);
	public static final BaseMetric GLOBALIDCOUNTER = new BaseMetric(
			"global_id_counter", false);
	public static final BaseMetric ID = new BaseMetric("id", false);
	public static final BaseMetric LOC = new BaseMetric("lines_of_code", false);
	public static final BaseMetric BRANCHCOUNT = new BaseMetric("branch_count",
			false);
	public static final BaseMetric DECISIONCOUNT = new BaseMetric(
			"decision_count", false);
	public static final BaseMetric TOTALOPERATORS = new BaseMetric(
			"total_operators", false);
	public static final BaseMetric TOTALOPERANDS = new BaseMetric(
			"total_operands", false);
	public static final BaseMetric CONDITIONCOUNT = new BaseMetric(
			"condition_count", false);
	public static final BaseMetric UNIQUEOPERANDSCOUNT = new BaseMetric(
			"unique_operands_count", false);
	public static final BaseMetric UNIQUEOPERATORSCOUNT = new BaseMetric(
			"unique_operators_count", false);
	public static final BaseMetric CYCLOMATICCOMPLEXITY = new BaseMetric(
			"cyclomatic_complexity", false);
	public static final BaseMetric ESSENTIALCOMPLEXITY = new BaseMetric(
			"essential_complexity", false);
	public static final BaseMetric HALSTEADDIFFICULTY = new BaseMetric(
			"halstead_difficulty", false);
	public static final BaseMetric HALSTEADLENGTH = new BaseMetric(
			"halstead_length", false);
	public static final BaseMetric HALSTEADLEVEL = new BaseMetric(
			"halstead_level", false);
	public static final BaseMetric HALSTEADPROGRAMMINGEFFORT = new BaseMetric(
			"halstead_programming_effort", false);
	public static final BaseMetric HALSTEADPROGRAMMINGTIME = new BaseMetric(
			"halstead_programming_time", false);
	public static final BaseMetric HALSTEADVOLUME = new BaseMetric(
			"halstead_volume", false);
	public static final BaseMetric DECISIONDENSITY = new BaseMetric(
			"decision_density", false);
	public static final BaseMetric ESSENTIALDENSITY = new BaseMetric(
			"essential_density", false);
	public static final BaseMetric CYCLOMATICDENSITY = new BaseMetric(
			"cyclomatic_density", false);
	public static final BaseMetric MAINTENANCESEVERITY = new BaseMetric(
			"maintenance_complexity", false);
	public static final BaseMetric FORMALPARAMETERS = new BaseMetric(
			"formal_parameters", false);
	public static final BaseMetric CALLPAIRLENGTH = new BaseMetric(
			"call_pair_length", false);

	public static final BaseMetric[] LIST = { NAME, GLOBALIDCOUNTER, ID, LOC,
			BRANCHCOUNT, DECISIONCOUNT, TOTALOPERATORS, TOTALOPERANDS,
			CONDITIONCOUNT, UNIQUEOPERANDSCOUNT, UNIQUEOPERATORSCOUNT,
			CYCLOMATICCOMPLEXITY, ESSENTIALCOMPLEXITY, HALSTEADDIFFICULTY,
			HALSTEADLENGTH, HALSTEADLEVEL, HALSTEADPROGRAMMINGEFFORT,
			HALSTEADPROGRAMMINGTIME, HALSTEADVOLUME, DECISIONDENSITY,
			ESSENTIALDENSITY, CYCLOMATICDENSITY, MAINTENANCESEVERITY,
			FORMALPARAMETERS, CALLPAIRLENGTH };

	public CommonMetricTypes(String label, boolean isNominal) {
		super(label, isNominal);
	}

	public CommonMetricTypes(String label, boolean isNominal,
			List<String> nominalValues) {
		super(label, isNominal, nominalValues);
	}
}
