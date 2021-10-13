/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.gui.actions;

import categorizer.core.Chart;
import categorizer.core.DataSet;
import common.gui.statics.Components;
import executor.ParserExecutor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Gürhan
 */
public class HistogramActionAdapter implements ActionListener {
        
    private int column;

    public HistogramActionAdapter(int column) {
        super();
        this.column = column;
    }

    public void actionPerformed(ActionEvent e) {
        int selectedMetricGroup = Components.getSelectedMetricGroupIndex();
        DataSet ds = null;
        ds = ParserExecutor.getDataSetByMetricGroup(selectedMetricGroup,ParserExecutor.getCurrentLanguage(),Components.dataFileActive);
        if(ds != null) {
            Chart chart = new Chart(ds,(column-1));
            chart.createChartPanel();
            chart.pack();
            chart.setVisible(true);
        }
    }
}
