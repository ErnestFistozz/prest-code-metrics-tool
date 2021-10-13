package parser.Java.MetricsRelatedFiles;

import java.util.HashMap;

import definitions.metrics.ClassMetricTypes;
import definitions.metrics.CommonMetricTypes;

public class MetricNamesMap {

	static HashMap<String, Integer> map;
	static {
		map = new HashMap<String, Integer>();
		int i = 0;
		for (; i < CommonMetricTypes.LIST.length; i++) {
			map.put(CommonMetricTypes.LIST[i].getLabel(), i);
		}
		for (int j = 0; j < ClassMetricTypes.LIST.length; j++) {
			map.put(ClassMetricTypes.LIST[j].getLabel(), i);
			i++;
		}
	}

	public static Object get(String name) {
		Integer i = map.get(name);
		if (i == null)
			return name;
		else
			return i;
	}

	public static String inverse(int id) {
		if (id < CommonMetricTypes.LIST.length) {
			return CommonMetricTypes.LIST[id].getLabel();
		} else {
			id -= CommonMetricTypes.LIST.length;
			if (id < ClassMetricTypes.LIST.length) {
				return ClassMetricTypes.LIST[id].getLabel();
			} else {
				return String.valueOf(id + CommonMetricTypes.LIST.length);
			}
		}
	}
}
