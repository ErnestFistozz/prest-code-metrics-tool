package definitions.metrics;

import java.util.List;

public class BaseMetric {

	private String label;
	private boolean isNominal;
	private List<String> nominalValues;
	
	public BaseMetric(String label) {
		this.label = label;
	}
	
	public BaseMetric(String label, boolean isNominal) {
		this.label = label;
		this.isNominal = isNominal;
		this.nominalValues = null;
	}
	
	public BaseMetric(String label, boolean isNominal, List<String> nominalValues) {
		this.label = label;
		this.isNominal = isNominal;
		this.nominalValues = nominalValues;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isNominal() {
		return isNominal;
	}

	public void setNominal(boolean isNominal) {
		this.isNominal = isNominal;
	}

	public List<String> getNominalValues() {
		return nominalValues;
	}

	public void setNominalValues(List<String> nominalValues) {
		this.nominalValues = nominalValues;
	}

}
