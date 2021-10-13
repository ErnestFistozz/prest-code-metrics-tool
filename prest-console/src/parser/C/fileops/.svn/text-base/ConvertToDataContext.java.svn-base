package parser.C.fileops;

import java.io.IOException;

import parser.C.constants.CConstants;

import common.NodePair;
import common.data.DataContext;

public class ConvertToDataContext {

	public static DataContext createMetricsDataContext(Module m, boolean type)
			throws IOException {

		String[] header;
		String[] value;
		int shift = 0;
		if (type == CConstants.FILE_METRICS_HEADER) {
			header = new String[CConstants.MAX_COLUMNS + 1];
			header[0] = "name";
			value = new String[CConstants.MAX_COLUMNS + 1];
			value[0] = m.getName();
			shift = 1;
		} else {
			header = new String[CConstants.MAX_COLUMNS + 2];
			header[0] = "name";
			value = new String[CConstants.MAX_COLUMNS + 2];
			value[0] = m.getName();
			shift = 1;
		}
		for (int i = 0; i < CConstants.COLUMN_NAMES.length; i++) {
			header[shift + i] = CConstants.COLUMN_NAMES[i];
		}

		String[] metrics = m.getAllMetrics();
		for (int i = 0; i < metrics.length; i++) {
			value[shift + i] = metrics[i];
		}

		DataContext dataContext = new DataContext();
		for (int i = 0; i < header.length; i++) {
			NodePair nodePair = new NodePair(header[i], value[i]);
			dataContext.add(nodePair);
		}
		// dataContext.writeToFile(fileName);
		return dataContext;
	}
}
