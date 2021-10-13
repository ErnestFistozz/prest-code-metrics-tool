package definitions.metrics;

import java.util.List;

public class MethodMetricTypes extends BaseMetric {
	
	public static final BaseMetric BRANCHCOUNT = new BaseMetric("branch_count", false);
	public static final BaseMetric TOTALOPERATORS = new BaseMetric("total_operators", false);
	public static final BaseMetric TOTALOPERANDS = new BaseMetric("total_operands", false);
	public static final BaseMetric CONDITIONCOUNT = new BaseMetric("condition_count", false);
	public static final BaseMetric DECISIONCOUNT = new BaseMetric("decision_count", false);
	public static final BaseMetric BASECC = new BaseMetric("base_cc", false);
	public static final BaseMetric UNSTRUCTUREDELEMENT = new BaseMetric("unstructured_element", false);

	public static final BaseMetric[] LIST = {BRANCHCOUNT, TOTALOPERATORS,
		TOTALOPERANDS, CONDITIONCOUNT, DECISIONCOUNT, BASECC, UNSTRUCTUREDELEMENT};
	
	public MethodMetricTypes(String label, boolean isNominal) {
		super(label, isNominal);
	}

	public MethodMetricTypes(String label, boolean isNominal,
			List<String> nominalValues) {
		super(label, isNominal, nominalValues);
	}
}
