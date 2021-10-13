/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.gui.statics;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import common.gui.controls.ControlBar;
import common.gui.controls.MenuButton;


public class Components {
    
    public static JPanel classMetricsDataSetPanel;
    public static JPanel fileMetricsDataSetPanel;
    public static JPanel methodMetricsDataSetPanel;
    public static JPanel packageMetricsDataSetPanel;
    public static JPanel classMetricsThresholdPanel;
    public static JPanel fileMetricsThresholdPanel;
    public static JPanel methodMetricsThresholdPanel;
    public static JPanel packageMetricsThresholdPanel;
    public static MenuButton mbMetricGroups;
    public static ControlBar analysisToolBar;
    public static int[] languageSet;
    public static JTextArea confuseMatrixDisplayArea;
    public static ButtonGroup languageButtonGroup;
    public static JPanel resultsDataPanel;
    public static boolean categorizerActive;
//    public static JPanel pnlCategorizeButtons;
//    public static JButton btnStoreCategorizer;
//    public static JButton btnLoadCategorizer;
//    public static JButton btnCategorize;
    public static boolean dataFileActive;

    public static String getSelectedMetricGroup() {
        if (mbMetricGroups != null) {
            return (String) mbMetricGroups.getActionText(mbMetricGroups.getActionIndex());
        }
        return null;
    }

    
    public static int getSelectedMetricGroupIndex() {
        if(mbMetricGroups != null) {
            return mbMetricGroups.getActionIndex();
        }
        return -1;
    }
}
