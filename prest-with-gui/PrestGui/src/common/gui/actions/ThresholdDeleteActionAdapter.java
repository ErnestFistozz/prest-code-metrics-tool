/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.gui.actions;

import categorizer.core.DataHeader;
import categorizer.core.DataSet;
import categorizer.core.Threshold;
import categorizer.core.ThresholdOperator;
import common.gui.models.ThresholdContent;
import common.gui.models.ThresholdTableModel;
import common.gui.statics.Components;
import executor.ParserExecutor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import parser.enumeration.Language;


public class ThresholdDeleteActionAdapter implements ActionListener {
        
    private int row;
    private JTable table;
    private DataSet activeDataSet;

    public ThresholdDeleteActionAdapter(int row, JTable table) {
        super();
        this.row = row;
        this.table = table;
    }

    public void actionPerformed(ActionEvent e) {
        try {
			ThresholdTableModel model = (ThresholdTableModel)table.getModel();
			ThresholdContent thresholdDetails = model.getRowDetailsOfTable(row);
			
			int selectedMetricType = Components.getSelectedMetricGroupIndex();
			// TODO
			Language lang = Language.JAVA;//radioButtondan alinacak
//			activeDataSet = ParserExecutor.getDataSetByMetricGroup(selectedMetricType, lang);
			activeDataSet = ParserExecutor.getDataSetByMetricGroup(selectedMetricType, ParserExecutor.getCurrentLanguage(),Components.dataFileActive);
			
			DataHeader dataHeader = activeDataSet.getDataHeader(thresholdDetails.getThresholdDataHeader());
			
			HashMap hashMap = activeDataSet.getThresholds();
			
			if (hashMap.get(dataHeader.getLabel()) != null) {
			    Threshold[] thresholds = (Threshold[]) hashMap.get(dataHeader.getLabel());
			        for(Threshold threshold: thresholds) {
			                if(checkThreshold(threshold, thresholdDetails)) {
			                        dataHeader.deleteThreshold(threshold);
			                        break;
			                }
			        }
			}
			switch (Components.getSelectedMetricGroupIndex()) {
			    case 0:
			        displayThresholds(Components.packageMetricsThresholdPanel);
			        break;
			    case 1:
			        displayThresholds(Components.fileMetricsThresholdPanel);
			        break;
			    case 2:
			        displayThresholds(Components.classMetricsThresholdPanel);
			        break;
			    case 3:
			        displayThresholds(Components.methodMetricsThresholdPanel);
			        break;
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}

    }

    private void displayThresholds(JPanel panel) {
        try {
			panel.removeAll();
			
			List<ThresholdContent> thresholdList = new ArrayList<ThresholdContent>();
			
			HashMap hashMap = activeDataSet.getThresholds();
			DataHeader[] dataHeaders = activeDataSet.getDataHeaders();
			for (DataHeader dataHeader : dataHeaders) {
			    if (hashMap.get(dataHeader.getLabel()) != null) {
			        Threshold[] thresholds = (Threshold[]) hashMap.get(dataHeader.getLabel());
			            for(Threshold threshold: thresholds) {
			                ThresholdContent thresholdContent = new ThresholdContent();
			                thresholdContent.setThresholdDataHeader(dataHeader.getLabel());
			                thresholdContent.setThresholdOperator(threshold.getOperator().operator());
			                if(threshold.getOperands()[0].isDataHeader()) 
			                    thresholdContent.setThresholdFirstOperand(((DataHeader)(threshold.getOperands()[0].getOperandValue())).getLabel());
			                else
			                    thresholdContent.setThresholdFirstOperand(threshold.getOperands()[0].getOperandValue().toString());
			                
			                if(thresholdContent.getThresholdOperator().equals("<>")) {
			                    if(threshold.getOperands()[1].isDataHeader()) 
			                        thresholdContent.setThresholdFirstOperand(((DataHeader)(threshold.getOperands()[1].getOperandValue())).getLabel());
			                    else
			                        thresholdContent.setThresholdFirstOperand(threshold.getOperands()[1].getOperandValue().toString());
			                }
			                thresholdContent.setThresholdRiskLevel(threshold.getClassValue());
			                
			                thresholdList.add(thresholdContent);
			            }
			    }
			}
			
			ThresholdTableModel thresholdTableModel = new ThresholdTableModel(thresholdList);
			JTable newTable = new JTable(thresholdTableModel);
			
			ThresholdTableMouseListener mouseListener = new ThresholdTableMouseListener(newTable);
			newTable.addMouseListener(mouseListener);
			
			newTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			newTable.setAutoCreateRowSorter(false);
			newTable.setColumnSelectionAllowed(false);
			newTable.setRowSelectionAllowed(true);
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setViewportView(table);
			scrollPane.setVisible(true);
			javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
			panel.setLayout(null);
			panelLayout.setHorizontalGroup(
			        panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(panelLayout.createSequentialGroup().addContainerGap().addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)));
			panelLayout.setVerticalGroup(
			        panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(panelLayout.createSequentialGroup().addContainerGap().addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)));
			panel.setLayout(panelLayout);
			thresholdTableModel.fireTableDataChanged();
			panel.repaint();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
        
    private boolean checkThreshold(Threshold threshold, ThresholdContent thresholdDetails) {
        boolean returnValue = true;
        if(!threshold.getClassValue().equals(thresholdDetails.getThresholdRiskLevel())) 
            returnValue = false;
        if(!threshold.getOperator().operator().equals(thresholdDetails.getThresholdOperator()))
            returnValue = false;
        if(!threshold.getOperands()[0].getOperandValue().toString().equals(thresholdDetails.getThresholdFirstOperand()))
            returnValue = false;
        if(threshold.getOperator().operator().equals(ThresholdOperator.BTW.operator())) {
                if(!threshold.getOperands()[1].getOperandValue().equals(thresholdDetails.getThresholdSecondOperand()))
                    returnValue = false;
        }
        return returnValue;
    }
            
//    private JPanel activeThresholdPanel() {
//        switch (Components.cmbMetricGroups.getSelectedIndex()) {
//            case 0:
//                return Components.packageMetricsThresholdPanel;
//            case 1:
//                return Components.fileMetricsThresholdPanel;
//            case 2:
//                return Components.classMetricsThresholdPanel;
//            case 3:
//                return Components.methodMetricsThresholdPanel;
//            default:
//                return null;
//        }                
//    }

}
