/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.gui.models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author handee
 */
public class ThresholdTableModel extends AbstractTableModel {
    private List<String> columnNames;
    private List<ThresholdContent> rowData;
    
    public ThresholdTableModel(List <ThresholdContent> data) {
        this.columnNames = new ArrayList<String>();
        columnNames.add("Metric Name");
        columnNames.add("Operator");
        columnNames.add("First Operand");
        columnNames.add("Second Operand");
        columnNames.add("Expression");
        columnNames.add("Risk Level");
       
        rowData = data;
    }
    
    public int getRowCount() {
        return rowData.size();
    }

    public int getColumnCount() {
        return columnNames.size();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames.get(columnIndex);
    }

   
    public Object getValueAt(int rowIndex, int columnIndex) {
            ThresholdContent thresholdContent = rowData.get(rowIndex);
            
          switch(columnIndex) {
              case 0:
                  return thresholdContent.getThresholdDataHeader();
              case 1:
                  return thresholdContent.getThresholdOperator();
              case 2:
                  return thresholdContent.getThresholdFirstOperand();
              case 3:
                  return thresholdContent.getThresholdSecondOperand();
              case 4:
                  return composeExpression(thresholdContent);
              case 5:
                  return thresholdContent.getThresholdRiskLevel();
              default:
                  return "";
          }
    }
    
    public ThresholdContent getRowDetailsOfTable(int rowIndex) {
        return rowData.get(rowIndex);
    }
    
    private String composeExpression(ThresholdContent thresholdContent) {
        String expression = "";
        String operator = thresholdContent.getThresholdOperator();
        if(!operator.equals("<>")) {
            expression = thresholdContent.getThresholdDataHeader() + " " + 
                    operator + " " + thresholdContent.getThresholdFirstOperand();
        }
        else {
            expression = thresholdContent.getThresholdFirstOperand() + " <= " + thresholdContent.getThresholdDataHeader()
                    + " <= " + thresholdContent.getThresholdSecondOperand();
        }
        return expression;
    }
}
