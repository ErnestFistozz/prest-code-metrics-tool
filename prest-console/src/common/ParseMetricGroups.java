/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import common.data.DataContext;

/**
 * 
 * @author Gürhan
 */
public class ParseMetricGroups {

	private List<MetricGroup> packageMetrics;
	private List<MetricGroup> fileMetrics;
	private List<MetricGroup> classMetrics;
	private List<MetricGroup> methodMetrics;

	public ParseMetricGroups() {
	}

	public ParseMetricGroups(List<MetricGroup> packageMetrics,
			List<MetricGroup> fileMetrics, List<MetricGroup> classMetrics,
			List<MetricGroup> methodMetrics) {
		this.packageMetrics = packageMetrics;
		this.fileMetrics = fileMetrics;
		this.classMetrics = classMetrics;
		this.methodMetrics = methodMetrics;
	}

	public ParseMetricGroups(DataContext metrics) {
		this.packageMetrics = new ArrayList<MetricGroup>();
		this.fileMetrics = new ArrayList<MetricGroup>();
		this.classMetrics = new ArrayList<MetricGroup>();
		this.methodMetrics = new ArrayList<MetricGroup>();

		Iterator<String> packageIterator = metrics.iterator();
		while (packageIterator.hasNext()) {
			String packageKey = packageIterator.next();
			MetricGroup packageMetricGroup = new MetricGroup();
			packageMetricGroup.setGroupName(packageKey);
			DataContext packageCandidate = metrics.getNode(packageKey);
			if (packageCandidate != null) {

				Iterator<String> fileIterator = packageCandidate.iterator();
				while (fileIterator.hasNext()) {
					String fileKey = fileIterator.next();
					MetricGroup fileMetricGroup = new MetricGroup();
					fileMetricGroup.setGroupName(fileKey);
					DataContext fileCandidate = packageCandidate
							.getNode(fileKey);
					if (fileCandidate == null) {
						Object fileObject = packageCandidate
								.getFirstNodeValue(fileKey);
						if (fileObject != null) {
							// String valuefile = fileObject.toString();
							NodePair aMetric = new NodePair(fileKey, fileObject);
							packageMetricGroup.addToMetricList(aMetric);
						}
					} else {

						Iterator<String> classIterator = fileCandidate
								.iterator();
						while (classIterator.hasNext()) {
							String classKey = classIterator.next();
							MetricGroup clasMetricGroup = new MetricGroup();
							clasMetricGroup.setGroupName(classKey);
							DataContext classCandidate = fileCandidate
									.getNode(classKey);
							if (classCandidate == null) {
								Object classObject = fileCandidate
										.getFirstNodeValue(classKey);
								if (classObject != null) {
									// String valueclas =
									// classObject.toString();
									NodePair aMetric = new NodePair(classKey,
											classObject);
									fileMetricGroup.addToMetricList(aMetric);
								}
							} else {

								Iterator<String> methodIterator = classCandidate
										.iterator();
								while (methodIterator.hasNext()) {
									String methodKey = methodIterator.next();
									DataContext methodCandidate = classCandidate
											.getNode(methodKey);
									if (methodCandidate == null) {
										Object methodObject = classCandidate
												.getFirstNodeValue(methodKey);
										if (methodObject != null) {
											// String valuemethod =
											// methodObject.toString();
											NodePair aMetric = new NodePair(
													methodKey, methodObject);
											clasMetricGroup
													.addToMetricList(aMetric);
										}
									} else {
										MetricGroup methodMetricGroup = new MetricGroup();
										methodMetricGroup
												.setGroupName(methodKey);
										Iterator<String> insideMethodIterator = methodCandidate
												.iterator();
										while (insideMethodIterator.hasNext()) {
											String methodMetric = insideMethodIterator
													.next();
											Object value = methodCandidate
													.getFirstNodeValue(methodMetric);
											NodePair aMetric = new NodePair(
													methodMetric, value);
											methodMetricGroup
													.addToMetricList(aMetric);
										}
										if (methodMetricGroup.getNodePairList()
												.size() > 0) {
											methodMetrics
													.add(methodMetricGroup);
										}
									}
									methodCandidate = null;
								}
							}
							if (clasMetricGroup.getNodePairList().size() > 0) {
								classMetrics.add(clasMetricGroup);
							}
							classCandidate = null;
						}
					}
					if (fileMetricGroup.getNodePairList().size() > 0) {
						fileMetrics.add(fileMetricGroup);
					}
					fileCandidate = null;
				}

			}
			if (packageMetricGroup.getNodePairList().size() > 0) {
				packageMetrics.add(packageMetricGroup);
			}
			packageCandidate = null;
		}
	}

	public List<MetricGroup> getClassMetrics() {
		return this.classMetrics;
	}

	public void setClassMetrics(List<MetricGroup> classMetrics) {
		this.classMetrics = classMetrics;
	}

	public List<MetricGroup> getFileMetrics() {
		return this.fileMetrics;
	}

	public void setFileMetrics(List<MetricGroup> fileMetrics) {
		this.fileMetrics = fileMetrics;
	}

	public List<MetricGroup> getMethodMetrics() {
		return this.methodMetrics;
	}

	public void setMethodMetrics(List<MetricGroup> methodMetrics) {
		this.methodMetrics = methodMetrics;
	}

	public List<MetricGroup> getPackageMetrics() {
		return this.packageMetrics;
	}

	public void setPackageMetrics(List<MetricGroup> packageMetrics) {
		this.packageMetrics = packageMetrics;
	}

}
