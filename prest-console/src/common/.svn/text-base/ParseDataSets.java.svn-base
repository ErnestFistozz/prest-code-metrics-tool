/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common;

import java.util.ArrayList;
import java.util.List;

import common.data.DataField;
import common.data.DataHeader;
import common.data.DataItem;
import common.data.DataSet;

import definitions.metrics.MetricTypeNames;

public class ParseDataSets {

	private DataSet packageDataSet;
	private DataSet fileDataSet;
	private DataSet classDataSet;
	private DataSet methodDataSet;

	private static int methodMetricDivideAndConquerNumber = 0;
	private int divideSize = 4000;

	public ParseDataSets() {
	}

	public ParseDataSets(DataSet packageDataSet, DataSet fileDataSet,
			DataSet classDataSet, DataSet methodDataSet) {
		this.packageDataSet = packageDataSet;
		this.fileDataSet = fileDataSet;
		this.classDataSet = classDataSet;
		this.methodDataSet = methodDataSet;
	}

	public ParseDataSets(ParseMetricGroups parseMetricGroups) {
		this.packageDataSet = new DataSet();
		this.packageDataSet.setTitle("Package DataSet");
		List<DataHeader> dataHeaderList = new ArrayList<DataHeader>();

		if (parseMetricGroups.getPackageMetrics().size() > 0) {
			List<NodePair> packageMetricList = parseMetricGroups
					.getPackageMetrics().get(0).getNodePairList();
			for (NodePair aPair : packageMetricList) {
				if (!aPair.getName().equals("name")
						&& !aPair.getName().equals("id")) {
					DataHeader dataHeader = new DataHeader();
					dataHeader.setLabel(aPair.getName());
					dataHeader.setNominal(false);
					dataHeaderList.add(dataHeader);
				}
			}
			DataHeader riskLevelDataHeader = new DataHeader();
			riskLevelDataHeader.setLabel("Risk Level");
			riskLevelDataHeader.setNominal(true);
			String[] riskLevels = { "False", "True" };
			riskLevelDataHeader.setAvailableValue(riskLevels);
			dataHeaderList.add(riskLevelDataHeader);
			this.packageDataSet.setDataHeaders(dataHeaderList
					.toArray(new DataHeader[0]));
			this.packageDataSet.setClassIndex(dataHeaderList.size() - 1);

			List<DataItem> dataItemList = new ArrayList<DataItem>();

			for (MetricGroup metricGroup : parseMetricGroups
					.getPackageMetrics()) {
				List<DataField> dataFieldList = new ArrayList<DataField>();
				packageMetricList = metricGroup.getNodePairList();
				int i = 0;
				for (NodePair nodePair : packageMetricList) {
					if (!nodePair.getName().equals("name")
							&& !nodePair.getName().equals("id")) {
						DataField dataField = new DataField();
						dataField.setDataHeader(dataHeaderList.get(i));
						dataField.load(nodePair.getValue());
						dataFieldList.add(dataField);
						i++;
					}
				}
				DataField dataField = new DataField();
				dataField.setDataHeader(riskLevelDataHeader);
				dataField.load("False");
				dataFieldList.add(dataField);

				DataItem dataItem = new DataItem();
				dataItem.setItemName(metricGroup.getGroupName());
				dataItem.setDataFields(dataFieldList.toArray(new DataField[0]));
				dataItem.setDataHeaders(dataHeaderList
						.toArray(new DataHeader[0]));
				dataItemList.add(dataItem);
			}
			this.packageDataSet.setDataItems(dataItemList
					.toArray(new DataItem[0]));
		}
		parseMetricGroups.setPackageMetrics(null);

		this.fileDataSet = new DataSet();
		this.fileDataSet.setTitle("File DataSet");
		dataHeaderList = new ArrayList<DataHeader>();
		if (parseMetricGroups.getFileMetrics().size() > 0) {
			List<NodePair> fileMetricList = parseMetricGroups.getFileMetrics()
					.get(0).getNodePairList();
			for (NodePair aPair : fileMetricList) {
				if (!aPair.getName().equals("name")
						&& !aPair.getName().equals("id")) {
					DataHeader dataHeader = new DataHeader();
					dataHeader.setLabel(aPair.getName());
					dataHeader.setNominal(false);
					dataHeaderList.add(dataHeader);
				}
			}
			DataHeader riskLevelDataHeader = new DataHeader();
			riskLevelDataHeader.setLabel("Risk Level");
			riskLevelDataHeader.setNominal(true);
			String[] riskLevels = { "False", "True" };
			riskLevelDataHeader.setAvailableValue(riskLevels);
			dataHeaderList.add(riskLevelDataHeader);
			this.fileDataSet.setDataHeaders(dataHeaderList
					.toArray(new DataHeader[0]));
			this.fileDataSet.setClassIndex(dataHeaderList.size() - 1);

			List<DataItem> dataItemList = new ArrayList<DataItem>();

			for (MetricGroup metricGroup : parseMetricGroups.getFileMetrics()) {
				List<DataField> dataFieldList = new ArrayList<DataField>();
				fileMetricList = metricGroup.getNodePairList();
				int i = 0;
				for (NodePair nodePair : fileMetricList) {
					// for (int i = 0; i < fileMetricList.size(); i++) {
					if (!nodePair.getName().equals("name")
							&& !nodePair.getName().equals("id")) {
						DataField dataField = new DataField();
						dataField.setDataHeader(dataHeaderList.get(i));
						dataField.load(nodePair.getValue());
						dataFieldList.add(dataField);
						i++;
					}
				}

				DataField dataField = new DataField();
				dataField.setDataHeader(riskLevelDataHeader);
				dataField.load("False");
				dataFieldList.add(dataField);

				DataItem dataItem = new DataItem();
				dataItem.setItemName(metricGroup.getGroupName());
				dataItem.setDataFields(dataFieldList.toArray(new DataField[0]));
				dataItem.setDataHeaders(dataHeaderList
						.toArray(new DataHeader[0]));
				dataItemList.add(dataItem);
			}
			this.fileDataSet
					.setDataItems(dataItemList.toArray(new DataItem[0]));
		}
		parseMetricGroups.setFileMetrics(null);

		this.classDataSet = new DataSet();
		this.classDataSet.setTitle("Class DataSet");
		dataHeaderList = new ArrayList<DataHeader>();
		if (parseMetricGroups.getClassMetrics().size() > 0) {
			List<NodePair> classMetricList = parseMetricGroups
					.getClassMetrics().get(0).getNodePairList();
			for (NodePair aPair : classMetricList) {
				if (!aPair.getName().equals("name")
						&& !aPair.getName().equals("id")) {
					DataHeader dataHeader = new DataHeader();
					dataHeader.setLabel(aPair.getName());
					dataHeader.setNominal(false);
					dataHeaderList.add(dataHeader);
				}
			}
			DataHeader riskLevelDataHeader = new DataHeader();
			riskLevelDataHeader.setLabel("Risk Level");
			riskLevelDataHeader.setNominal(true);
			String[] riskLevels = { "False", "True" };
			riskLevelDataHeader.setAvailableValue(riskLevels);
			dataHeaderList.add(riskLevelDataHeader);
			this.classDataSet.setDataHeaders(dataHeaderList
					.toArray(new DataHeader[0]));
			this.classDataSet.setClassIndex(dataHeaderList.size() - 1);

			List<DataItem> dataItemList = new ArrayList<DataItem>();

			for (MetricGroup metricGroup : parseMetricGroups.getClassMetrics()) {
				List<DataField> dataFieldList = new ArrayList<DataField>();
				classMetricList = metricGroup.getNodePairList();
				int i = 0;
				for (NodePair nodePair : classMetricList) {
					if (!nodePair.getName().equals("name")
							&& !nodePair.getName().equals("id")) {
						DataField dataField = new DataField();
						dataField.setDataHeader(dataHeaderList.get(i));
						dataField.load(nodePair.getValue());
						dataFieldList.add(dataField);
					}
				}
				DataField dataField = new DataField();
				dataField.setDataHeader(riskLevelDataHeader);
				dataField.load("False");
				dataFieldList.add(dataField);

				DataItem dataItem = new DataItem();
				dataItem.setItemName(metricGroup.getGroupName());
				dataItem.setDataFields(dataFieldList.toArray(new DataField[0]));
				dataItem.setDataHeaders(dataHeaderList
						.toArray(new DataHeader[0]));
				dataItemList.add(dataItem);
			}
			this.classDataSet.setDataItems(dataItemList
					.toArray(new DataItem[0]));
		}
		parseMetricGroups.setClassMetrics(null);

		// methods
		this.methodDataSet = new DataSet();
		this.methodDataSet.setTitle("Method DataSet");
		dataHeaderList = new ArrayList<DataHeader>();
		if (parseMetricGroups.getMethodMetrics().size() > 0) {
			List<NodePair> methodMetricList = parseMetricGroups
					.getMethodMetrics().get(0).getNodePairList();
			for (NodePair aPair : methodMetricList) {
				if (!aPair.getName().equals("name")
						&& !aPair.getName().equals("id")) {
					DataHeader dataHeader = new DataHeader();
					dataHeader.setLabel(aPair.getName());
					dataHeader.setNominal(false);
					dataHeaderList.add(dataHeader);
				}
			}
			DataHeader riskLevelDataHeader = new DataHeader();
			riskLevelDataHeader.setLabel("Risk Level");
			riskLevelDataHeader.setNominal(true);
			String[] riskLevels = { "False", "True" };
			riskLevelDataHeader.setAvailableValue(riskLevels);
			dataHeaderList.add(riskLevelDataHeader);
			this.methodDataSet.setDataHeaders(dataHeaderList
					.toArray(new DataHeader[0]));
			this.methodDataSet.setClassIndex(dataHeaderList.size() - 1);

			List<DataItem> dataItemList = new ArrayList<DataItem>();

			List<MetricGroup> metricGroupList = parseMetricGroups
					.getMethodMetrics();

			int listSize = metricGroupList.size();
			int totalGroupCount = 1 + (int) ((listSize - 1) / divideSize);
			methodMetricDivideAndConquerNumber++;
			if (methodMetricDivideAndConquerNumber > totalGroupCount) {
				methodMetricDivideAndConquerNumber = 1;
			}
			System.out.println(methodMetricDivideAndConquerNumber);
			int start = ((methodMetricDivideAndConquerNumber - 1) * divideSize);
			int end = start + divideSize;

			for (int mgIndex = start; mgIndex < listSize && mgIndex < end; mgIndex++) {
				MetricGroup metricGroup = metricGroupList.get(mgIndex);
				List<DataField> dataFieldList = new ArrayList<DataField>();
				methodMetricList = metricGroup.getNodePairList();
				int i = 0;
				for (NodePair nodePair : methodMetricList) {
					if (!nodePair.getName().equals("name")
							&& !nodePair.getName().equals("id")) {
						DataField dataField = new DataField();
						dataField.setDataHeader(dataHeaderList.get(i));
						dataField.load(nodePair.getValue());
						dataFieldList.add(dataField);
					}
				}
				DataField dataField = new DataField();
				dataField.setDataHeader(riskLevelDataHeader);
				dataField.load("False");
				dataFieldList.add(dataField);

				DataItem dataItem = new DataItem();
				dataItem.setItemName(metricGroup.getGroupName());
				dataItem.setDataFields(dataFieldList.toArray(new DataField[0]));
				dataItem.setDataHeaders(dataHeaderList
						.toArray(new DataHeader[0]));
				dataItemList.add(dataItem);

				if (mgIndex == listSize - 1) {// real end
					DataField[] dummy = new DataField[dataFieldList
							.toArray(new DataField[0]).length];
					for (int k = 0; k < dummy.length; k++) {
						dummy[k] = new DataField();
						dummy[k].setValue("");
					}
//					DataItem realEnd = new DataItem();
//					realEnd.setItemName("--END OF METHODS--");
//					realEnd.setDataFields(dummy);
//					realEnd.setDataHeaders(dataHeaderList
//							.toArray(new DataHeader[0]));
//					dataItemList.add(realEnd);
				} else if (mgIndex == end - 1) {// group end
					DataField[] dummy = new DataField[dataFieldList
							.toArray(new DataField[0]).length];
					for (int k = 0; k < dummy.length; k++) {
						dummy[k] = new DataField();
						dummy[k].setValue("");
					}
					DataItem groupend = new DataItem();
					groupend
							.setItemName("--END OF PAGE, TRANSFER AGAIN FOR NEXT PAGE--");
					groupend.setDataFields(dummy);
					groupend.setDataHeaders(dataHeaderList
							.toArray(new DataHeader[0]));
					dataItemList.add(groupend);
				}

				metricGroupList.set(mgIndex, null);
			}
			this.methodDataSet.setDataItems(dataItemList
					.toArray(new DataItem[0]));
		}
		parseMetricGroups.setMethodMetrics(null);

	}

	public DataSet getClassDataSet() {
		return this.classDataSet;
	}

	public void setClassDataSet(DataSet classDataSet) {
		this.classDataSet = classDataSet;
	}

	public DataSet getFileDataSet() {
		return this.fileDataSet;
	}

	public void setFileDataSet(DataSet fileDataSet) {
		this.fileDataSet = fileDataSet;
	}

	public DataSet getMethodDataSet() {
		return this.methodDataSet;
	}

	public void setMethodDataSet(DataSet methodDataSet) {
		this.methodDataSet = methodDataSet;
	}

	public DataSet getPackageDataSet() {
		return this.packageDataSet;
	}

	public void setPackageDataSet(DataSet packageDataSet) {
		this.packageDataSet = packageDataSet;
	}

	public DataSet getByMetricType(int metricType) {
		if (metricType == MetricTypeNames.PACKAGE_METRICS) {
			return packageDataSet;
		} else if (metricType == MetricTypeNames.FILE_METRICS) {
			return fileDataSet;
		} else if (metricType == MetricTypeNames.CLASS_METRICS) {
			return classDataSet;
		} else if (metricType == MetricTypeNames.METHOD_METRICS) {
			return methodDataSet;
		} else {
			return null;
		}
	}

	public void setByMetricTypes(int metricType, DataSet ds) {
		if (metricType == MetricTypeNames.PACKAGE_METRICS) {
			this.packageDataSet = ds;
		} else if (metricType == MetricTypeNames.FILE_METRICS) {
			this.fileDataSet = ds;
		} else if (metricType == MetricTypeNames.CLASS_METRICS) {
			this.classDataSet = ds;
		} else if (metricType == MetricTypeNames.METHOD_METRICS) {
			this.methodDataSet = ds;
		}
	}

}
