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

/**
 *
 * @author handee
 */
public class ThresholdTableMouseListener extends MouseAdapter {
        
    public JTable table;

    public ThresholdTableMouseListener(JTable table) {
        super();
        this.table = table;
    }

    public void mouseReleased(MouseEvent e)
    {
        if (e.isPopupTrigger())
        {
            int row = table.rowAtPoint(e.getPoint());

            JPopupMenu popup = new JPopupMenu();
            JMenuItem deleteThresholdItem = new JMenuItem("Delete Threshold");
            
            deleteThresholdItem.addActionListener(new ThresholdDeleteActionAdapter(row,table));
            
            popup.add(deleteThresholdItem);

            popup.show(e.getComponent(), e.getX(), e.getY());
        }
    }
}