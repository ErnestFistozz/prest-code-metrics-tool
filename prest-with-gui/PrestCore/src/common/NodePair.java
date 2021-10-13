package common;

/**
 * NodePair stores name-value pairs. This class can be used in xml input and
 * output.
 * 
 * @author Gürhan
 * 
 */
public class NodePair {

	private String name;
	private Object value;
	
	public NodePair(String name, Object value){
		this.name = name;
		this.value = value;
	}

	/**
	 * Returns name of the node.
	 * 
	 * @return <code>name</code>
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns <code>String</code> value of the node.
	 * 
	 * @return <code>value</code>
	 */
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
