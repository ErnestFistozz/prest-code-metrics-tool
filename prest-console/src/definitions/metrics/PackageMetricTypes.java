package definitions.metrics;

import java.util.List;

public class PackageMetricTypes extends BaseMetric {

	public PackageMetricTypes(String label, boolean isNominal) {
		super(label, isNominal);
	}

	public PackageMetricTypes(String label, boolean isNominal,
			List<String> nominalValues) {
		super(label, isNominal, nominalValues);
	}

}
