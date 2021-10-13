/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.gui.actions;

import categorizer.core.Categorizer;
import categorizer.core.PerformanceMetric;
import common.gui.statics.Components;
import executor.ParserExecutor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;



public class CategorizerListMouseListener extends MouseAdapter {
        
    public CategorizerListMouseListener() {
        super();
    }

    public void mouseReleased(MouseEvent e)
    {
        JList source = (JList)e.getSource();
        int selectedIndex = source.getSelectedIndex();
        String displayText = "";
        if(selectedIndex != -1) {
            Categorizer selectedCategorizer = 
                    (Categorizer)ParserExecutor.getCategorizerExecutor().getCategorizers().get(selectedIndex);
            if(selectedCategorizer != null) {
                displayText = selectedCategorizer.getConfusionMatrix().toString();
                PerformanceMetric[] performanceMetrics = selectedCategorizer.getPerformanceMetrics();
                if(performanceMetrics!=null) {
                    for(int i=0;i<performanceMetrics.length;i++) {
                        try {
                            displayText += "\n" + performanceMetrics[i].toString();
                        } catch (Exception ex){
                            
                        }
                    }
                }
                Components.confuseMatrixDisplayArea.setText(displayText);

                if (e.isPopupTrigger())
                {
                    JPopupMenu popup = new JPopupMenu();
                    JMenuItem useCategorizer = new JMenuItem("Use");
                    useCategorizer.addActionListener(new UseCategorizerAdapter(selectedCategorizer) );
                    popup.add( useCategorizer );
                    popup.show(e.getComponent(), e.getX(), e.getY());
                    JMenuItem storeCategorizer = new JMenuItem("Store");
                    storeCategorizer.addActionListener(new StoreCategorizerAdapter(selectedCategorizer) );
                    popup.add( storeCategorizer );
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        }     
    }
}
