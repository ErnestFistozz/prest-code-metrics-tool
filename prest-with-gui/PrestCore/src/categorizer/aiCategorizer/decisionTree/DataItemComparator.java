/**
 * 
 */
package categorizer.aiCategorizer.decisionTree;

import java.util.Comparator;

import categorizer.core.DataItem;

/**
 * @author TCOBOZCAN
 *
 */
public class DataItemComparator implements Comparator {

	/**
	 * Holds the index of the header which is used in comparison of the DataItems 
	 */
	private int headerIndex;
	
	/**
	 * default constructor
	 */
	public DataItemComparator() {
	}



	/**
	 * @param headerIndex
	 */
	public DataItemComparator(int headerIndex) {
		this.headerIndex = headerIndex;
	}



	/**
	 * @return the headerIndex
	 */
	public final int getHeaderIndex() {
		return headerIndex;
	}



	/**
	 * @param headerIndex the headerIndex to set
	 */
	public final void setHeaderIndex(int headerIndex) {
		this.headerIndex = headerIndex;
	}



	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */

	public int compare(Object o1, Object o2) {
		
		if( (Double)((DataItem) o1).getDataFields()[headerIndex].getValue() > 
			(Double)((DataItem) o2).getDataFields()[headerIndex].getValue()
		)
			return 1;
		else if( (Double)((DataItem) o1).getDataFields()[headerIndex].getValue() <
				(Double)((DataItem) o2).getDataFields()[headerIndex].getValue()
		)
			return -1;
		else
			return 0;
	}

}
