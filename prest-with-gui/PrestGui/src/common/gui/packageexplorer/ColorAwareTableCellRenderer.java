package common.gui.packageexplorer;

import javax.swing.table.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Component;

public class ColorAwareTableCellRenderer  extends DefaultTableCellRenderer implements TableCellRenderer {

    public ColorAwareTableCellRenderer( ) {
    	
    }

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int col) {
		
		Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
		int columnSize = table.getColumnModel().getColumnCount();

		String s = table.getModel().getValueAt(row, (columnSize-1)).toString();
		if (s.equalsIgnoreCase("True")) {
			comp.setBackground(Color.getHSBColor(0.955f,1.00f,1.00f));
		} else {
			comp.setBackground(Color.getHSBColor(0.3f, 0.6f, 0.89f));
		}

		return (comp);
	}
}
