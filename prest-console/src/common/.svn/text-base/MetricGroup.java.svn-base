package common;

import java.util.ArrayList;
import java.util.List;

public class MetricGroup {
	private String groupName;
	private List<NodePair> nodePairList;
	
	public MetricGroup(){
		nodePairList = new ArrayList<NodePair>();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void addToMetricList(NodePair metric) {
		nodePairList.add(metric);
	}

	public List<NodePair> getNodePairList() {
		return nodePairList;
	}

	public void setNodePairList(List<NodePair> nodePairList) {
		this.nodePairList = nodePairList;
	}
	
	@Override
	public String toString() {
		return this.groupName;
	}
}
