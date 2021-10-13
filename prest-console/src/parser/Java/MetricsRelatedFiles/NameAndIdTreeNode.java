package parser.Java.MetricsRelatedFiles;

public class NameAndIdTreeNode {
	public String name = null;
	public int id;
	public NameAndIdTreeNode leftChild = null;
	public NameAndIdTreeNode rightChild = null;

	public static boolean put(NameAndIdTreeNode root, NameAndIdTreeNode newNode) {
		if (root.name.equals(newNode.name)) {
			return false;
		}
		if (root.name.compareTo(newNode.name) < 0) {
			if (root.leftChild == null) {
				root.leftChild = newNode;
				return true;
			} else {
				return put(root.leftChild, newNode);
			}
		} else {
			if (root.rightChild == null) {
				root.rightChild = newNode;
				return true;
			} else {
				return put(root.rightChild, newNode);
			}
		}
	}

	public static int getIdOf(NameAndIdTreeNode root, String name) {
		if (root.name.equals(name)) {
			return root.id;
		}
		if (root.name.compareTo(name) < 0) {
			if (root.leftChild != null) {
				return getIdOf(root.leftChild, name);
			} else {
				return -1;
			}
		} else {
			if (root.rightChild != null) {
				return getIdOf(root.rightChild, name);
			} else {
				return -1;
			}
		}
	}
}
