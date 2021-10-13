/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.gui.actions;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Gürhan
 */
public class TableMouseListener extends MouseAdapter {
        
    public JTable table;

    public TableMouseListener(JTable table) {
        super();
        this.table = table;
    }

    public void mouseReleased(MouseEvent e)
    {
        if (e.isPopupTrigger())
        {
            JTableHeader header = (JTableHeader)e.getSource();
            TableColumnModel columns = header.getColumnModel();
            int column = header.columnAtPoint(e.getPoint());
            int count = table.getRowCount();

            if (count != 0)
                table.setRowSelectionInterval(0, count - 1);
            ListSelectionModel selection = columns.getSelectionModel();
            selection.setSelectionInterval(column, column);

            JPopupMenu popup = new JPopupMenu();
            
            JMenuItem histogramItem = new JMenuItem("Generate Histogram");
            histogramItem.addActionListener(new HistogramActionAdapter(column) );
            popup.add( histogramItem );

            popup.show(e.getComponent(), e.getX(), e.getY());
        }
    }
}
