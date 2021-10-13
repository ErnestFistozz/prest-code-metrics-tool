package definitions.metrics;

import java.util.List;

public class ClassMetricTypes extends BaseMetric {

	public static final BaseMetric NUMBEROFCHILDREN = new BaseMetric(
			"number_of_children", false);
	public static final BaseMetric PERCENTAGEOFPUBDATA = new BaseMetric(
			"percentage_of_pub_data", false);

	public static final BaseMetric DEPTH = new BaseMetric("depth", false);
	public static final BaseMetric COUPLINGBETWEENOBJECTS = new BaseMetric(
			"coupling_between_objects", false);
	public static final BaseMetric FANIN = new BaseMetric("fan_in", false);
	public static final BaseMetric PUBDATA = new BaseMetric("pub_data", false);
	public static final BaseMetric DATA = new BaseMetric("data", false);
	public static final BaseMetric WMC = new BaseMetric(
			"weighted_methods_per_class", false);

	public static final BaseMetric RFC = new BaseMetric("response_for_a_class",
			false);

	public static final BaseMetric[] LIST = { NUMBEROFCHILDREN, DEPTH,
			COUPLINGBETWEENOBJECTS, FANIN, PUBDATA, DATA, WMC, RFC,
			PERCENTAGEOFPUBDATA };

	public ClassMetricTypes(String label, boolean isNominal) {
		super(label, isNominal);
	}

	public ClassMetricTypes(String label, boolean isNominal,
			List<String> nominalValues) {
		super(label, isNominal, nominalValues);
	}

}
