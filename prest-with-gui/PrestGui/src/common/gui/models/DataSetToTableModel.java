/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.gui.models;

import categorizer.core.DataHeader;
import categorizer.core.DataItem;
import categorizer.core.DataSet;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author handee
 */
public class DataSetToTableModel extends AbstractTableModel {
    
    private DataSet dataSet;
    private String [] columnNames;
    private boolean initializedSuccessfully;
    
    public DataSetToTableModel(DataSet ds) {
        this.dataSet = ds;
        if(ds.getDataHeaders() != null) {
            this.initializedSuccessfully = true;
            this.columnNames = new String[ds.getDataHeaders().length+1];
            columnNames[0] = " ";
            int index=1;
            for(DataHeader dt:ds.getDataHeaders())
            {
                columnNames[index] = dt.getLabel();
                index++;
            }
        } else {
            this.initializedSuccessfully = false;
        }
    }
    
    public int getRowCount() {
        return dataSet.getDataItems().length;
    }

    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    
    public Object getValueAt(int rowIndex, int columnIndex) {
        DataItem [] dItems = dataSet.getDataItems();

        try {
			if(columnIndex == 0) {
			    if(dItems[rowIndex].getItemName()==null)
			        return (rowIndex+1);
			    else { 
			        return dItems[rowIndex].getItemName();
			    }
			}
			else {
			    return dItems[rowIndex].getDataFields()[columnIndex-1].getValue();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }

    public boolean isInitializedSuccessfully() {
        return initializedSuccessfully;
    }

    public void setInitializedSuccessfully(boolean initializedSuccessfully) {
        this.initializedSuccessfully = initializedSuccessfully;
    }
    
    
}
