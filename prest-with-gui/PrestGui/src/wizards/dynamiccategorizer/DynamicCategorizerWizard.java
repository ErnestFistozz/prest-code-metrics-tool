package wizards.dynamiccategorizer;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import categorizer.API.CategorizerAPI;
import categorizer.core.CategorizerDefinition;
import categorizer.core.CategorizerExecutor;
import categorizer.core.Option;
import categorizer.core.OptionDefinition;

import common.gui.statics.Components;
import common.monitor.Logger;

import definitions.application.ApplicationProperties;
import executor.ParserExecutor;

public class DynamicCategorizerWizard extends JPanel {

    private JDialog dialog;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JSplitPane splitPane;
    private JLabel step1;
    private JLabel step2;
    private JLabel step3;
    private JTextArea categorizerDesc;
    private JComboBox cmbCategorizerClass;
    private int currentStep = 0;
    private List<OptionDefinition> optionList;
    private JTable optionTable;
    private JList jOptionList;
    private JTextField txtOptionType;
    private JTextField minValue;
    private JTextField maxValue;
    private JTextField userValue;
    private JComboBox cmbNominalValues;
    private JScrollPane scrollPaneForDesc = null;
    private List<String> availableValueList;
    private DefaultListModel defaultListModel;
    private JButton setButton;
    private CategorizerDefinition[] categorizerDefinitions = null;
    private String[] categorizerClassNames = {"Naive Bayes", "Decision Tree"};
    private String[] categorizerDescriptions = {"Naive Bayes method will be applied.",
        "Decision Tree method will be applied."
    };
    private int selectedCategorizerDefIndex = -1;
    private List<Option> newOptionList;

    public DynamicCategorizerWizard(JDialog dialog) {

        this.dialog = dialog;
        newOptionList = new ArrayList<Option>();
        availableValueList = new ArrayList<String>();
        initLeftPanel();
        clearRightPanel();
        initStep(currentStep);

    }

    public void initLeftPanel() {
        SpringLayout springLayout1 = new SpringLayout();

        leftPanel = new JPanel();
        leftPanel.setLayout(springLayout1);

        step1 = new JLabel("1. Class Name");
        step1.setAlignmentX(Component.LEFT_ALIGNMENT);
        step1.setEnabled(true);
        step2 = new JLabel("2. Options");
        step2.setAlignmentX(Component.LEFT_ALIGNMENT);
        step2.setEnabled(false);
        step3 = new JLabel("3. Finish");
        step3.setAlignmentX(Component.LEFT_ALIGNMENT);
        step3.setEnabled(false);

        leftPanel.add(step1);
        leftPanel.add(step2);
        leftPanel.add(step3);

        springLayout1.putConstraint(SpringLayout.WEST, step1, 10,
                SpringLayout.WEST, leftPanel);
        springLayout1.putConstraint(SpringLayout.NORTH, step1, 20,
                SpringLayout.NORTH, leftPanel);
        springLayout1.putConstraint(SpringLayout.WEST, step2, 10,
                SpringLayout.WEST, leftPanel);
        springLayout1.putConstraint(SpringLayout.NORTH, step2, 30,
                SpringLayout.NORTH, step1);
        springLayout1.putConstraint(SpringLayout.WEST, step3, 10,
                SpringLayout.WEST, leftPanel);
        springLayout1.putConstraint(SpringLayout.NORTH, step3, 30,
                SpringLayout.NORTH, step2);

        rightPanel = new JPanel();

        // Create a split pane with the two scroll panes in it.
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel,
                rightPanel);
        splitPane.setOneTouchExpandable(false);
        splitPane.setEnabled(false);
        splitPane.setDividerLocation(170);

        // Provide minimum sizes for the two components in the split pane.
        Dimension minimumSize = new Dimension(170, 600);
        leftPanel.setMinimumSize(minimumSize);
        rightPanel.setMinimumSize(minimumSize);

        // Provide a preferred size for the split pane.
        splitPane.setPreferredSize(new Dimension(700, 600));

    }

    public void initStep(int stepIndex) {
        if (stepIndex == 0) {
            initFirstStep();
        } else if (stepIndex == 1) {
            initSecondStep();
        } else {
            initThirdStep();
        }
    }

    public void initFirstStep() {

        step1.setEnabled(true);

        SpringLayout springLayout2 = new SpringLayout();
        rightPanel = new JPanel();
        rightPanel.setLayout(springLayout2);

        try {
            //XX categorizerDefinitions = CategorizerAPI.readDefinitions(ApplicationProperties.get("categorizerdefinitions"));
        	categorizerDefinitions = CategorizerAPI.readDefinitions("./CategorizerDefinitions.xml");
        } catch (Exception e) {
            Logger.error(e.getMessage());
        }

        if (categorizerDefinitions != null && categorizerDefinitions.length > 0) {
            int size = categorizerDefinitions.length;
            categorizerClassNames = new String[size];
            categorizerDescriptions = new String[size];
            for (int i = 0; i < size; i++) {
                categorizerClassNames[i] = categorizerDefinitions[i].getLabel();
                categorizerDescriptions[i] = categorizerDefinitions[i].getDescription();
            }
            selectedCategorizerDefIndex = 0;
        }

        JLabel cLabel = new JLabel("Categorizer Class:");
        cLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        if (cmbCategorizerClass == null) {
            cmbCategorizerClass = new JComboBox();
            cmbCategorizerClass.setModel(new DefaultComboBoxModel(
                    categorizerClassNames));
            cmbCategorizerClass.setSelectedIndex(0);
            cmbCategorizerClass.setAlignmentX(Component.LEFT_ALIGNMENT);
            CategorizerClassSelectionAction ccsAction = new CategorizerClassSelectionAction();
            cmbCategorizerClass.addActionListener(ccsAction);
        }

        JLabel desc0 = new JLabel("Description:");
        if (scrollPaneForDesc == null) {
            if (categorizerDesc == null) {
                categorizerDesc = new JTextArea(4, 40);
                categorizerDesc.setEditable(false);
                if (categorizerDescriptions != null) {
                    categorizerDesc.setText(categorizerDescriptions[0]);
                }
                scrollPaneForDesc = new JScrollPane(categorizerDesc);
            }
        }

        JLabel desc1 = new JLabel("Here please choose a class that");
        JLabel desc2 = new JLabel("will be used for categorizer construction.");
        JLabel desc3 = new JLabel("To see your own classes here, please add");
        JLabel desc4 = new JLabel(
                "your own categorizer class and its definitions.xml");
        JLabel desc5 = new JLabel("file to PrestTool/categorizers folder");
        desc1.setAlignmentX(Component.LEFT_ALIGNMENT);
        desc2.setAlignmentX(Component.LEFT_ALIGNMENT);
        desc3.setAlignmentX(Component.LEFT_ALIGNMENT);
        desc4.setAlignmentX(Component.LEFT_ALIGNMENT);
        desc5.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton backButton = new JButton("Back");
        backButton.setVisible(true);
        backButton.setMinimumSize(new Dimension(30, 30));
        BackAction backAction = new BackAction();
        backButton.addActionListener(backAction);
        JButton nextButton = new JButton("Next");
        nextButton.setVisible(true);
        nextButton.setMinimumSize(new Dimension(30, 30));
        NextAction nextAction = new NextAction();
        nextButton.addActionListener(nextAction);

        rightPanel.add(cLabel);
        rightPanel.add(cmbCategorizerClass);
        rightPanel.add(desc0);
        rightPanel.add(scrollPaneForDesc);
        rightPanel.add(desc1);
        rightPanel.add(desc2);
        rightPanel.add(desc3);
        rightPanel.add(desc4);
        rightPanel.add(desc5);
        rightPanel.add(nextButton);

        springLayout2.putConstraint(SpringLayout.WEST, cLabel, 20,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, cLabel, 100,
                SpringLayout.NORTH, rightPanel);
        springLayout2.putConstraint(SpringLayout.WEST, cmbCategorizerClass,
                150, SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, cmbCategorizerClass,
                100, SpringLayout.NORTH, rightPanel);
        springLayout2.putConstraint(SpringLayout.WEST, desc0, 20,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, desc0, 30,
                SpringLayout.NORTH, cmbCategorizerClass);
        springLayout2.putConstraint(SpringLayout.WEST, scrollPaneForDesc, 20,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, scrollPaneForDesc, 20,
                SpringLayout.NORTH, desc0);
        springLayout2.putConstraint(SpringLayout.WEST, desc1, 20,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, desc1, 100,
                SpringLayout.NORTH, scrollPaneForDesc);
        springLayout2.putConstraint(SpringLayout.WEST, desc2, 20,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, desc2, 30,
                SpringLayout.NORTH, desc1);
        springLayout2.putConstraint(SpringLayout.WEST, desc3, 20,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, desc3, 30,
                SpringLayout.NORTH, desc2);
        springLayout2.putConstraint(SpringLayout.WEST, desc4, 20,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, desc4, 30,
                SpringLayout.NORTH, desc3);
        springLayout2.putConstraint(SpringLayout.WEST, desc5, 20,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, desc5, 30,
                SpringLayout.NORTH, desc4);
        springLayout2.putConstraint(SpringLayout.WEST, nextButton, 400,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, nextButton, 500,
                SpringLayout.NORTH, rightPanel);

        splitPane.add(rightPanel, 1);
    }

    public void initSecondStep() {
        step2.setEnabled(true);

        if (optionList == null) {
            optionList = new ArrayList<OptionDefinition>();

            if (selectedCategorizerDefIndex != -1) {
                //XX OptionDefinition[] optionDefinitions = categorizerDefinitions[selectedCategorizerDefIndex].getOptionDefinitions();
                if (categorizerDefinitions != null) {
                	OptionDefinition[] optionDefinitions = categorizerDefinitions[selectedCategorizerDefIndex].getOptionDefinitions();
                    for (int i = 0; i < optionDefinitions.length; i++) {
                        optionList.add(optionDefinitions[i]);
                    }
                }
            }
        }
        SpringLayout springLayout2 = new SpringLayout();
        rightPanel = new JPanel();
        rightPanel.setLayout(springLayout2);

        if (optionTable == null) {
            optionTable = new JTable(new OptionsTableModel());
            optionTable.setPreferredScrollableViewportSize(new Dimension(400,
                    100));
            optionTable.setFillsViewportHeight(true);
            optionTable.setAlignmentX(Component.LEFT_ALIGNMENT);
            optionTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            optionTable.getSelectionModel().addListSelectionListener(
                    new RowListener());
        }

        JScrollPane tablePane = new JScrollPane(optionTable);
        tablePane.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel optionType = new JLabel("Option Type:");
        optionType.setAlignmentX(Component.LEFT_ALIGNMENT);

        txtOptionType = new JTextField("");
        txtOptionType.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtOptionType.setColumns(20);
        txtOptionType.setEditable(false);

        JLabel minValueLabel = new JLabel("Min. Value:");
        minValueLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        minValue = new JTextField("");
        minValue.setEditable(false);
        minValue.setAlignmentX(Component.LEFT_ALIGNMENT);
        minValue.setColumns(6);
        JLabel maxValueLabel = new JLabel("Max. Value:");
        maxValueLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        maxValue = new JTextField("");
        maxValue.setEditable(false);
        maxValue.setAlignmentX(Component.LEFT_ALIGNMENT);
        maxValue.setColumns(6);
        JLabel userValueLabel = new JLabel("User Value:");
        userValueLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        userValue = new JTextField("");
        userValue.setAlignmentX(Component.LEFT_ALIGNMENT);
        userValue.setColumns(6);

        JLabel nominalValuesLabel = new JLabel("Available Values:");
        nominalValuesLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        cmbNominalValues = new JComboBox();
        cmbNominalValues.setAlignmentX(Component.LEFT_ALIGNMENT);

        if (setButton == null) {
            setButton = new JButton("Set Option Value");
            setButton.setAlignmentX(Component.LEFT_ALIGNMENT);
            setButton.setMinimumSize(new Dimension(30, 30));
            setButton.setEnabled(false);
            setButton.addActionListener(new SetOptionAction());
        }

        JButton backButton = new JButton("Back");
        backButton.setVisible(true);
        backButton.setMinimumSize(new Dimension(30, 30));
        BackAction backAction = new BackAction();
        backButton.addActionListener(backAction);
        JButton nextButton = new JButton("Next");
        nextButton.setVisible(true);
        nextButton.setMinimumSize(new Dimension(30, 30));
        NextAction nextAction = new NextAction();
        nextButton.addActionListener(nextAction);

        rightPanel.add(tablePane);
        rightPanel.add(optionType);
        rightPanel.add(txtOptionType);
        rightPanel.add(minValueLabel);
        rightPanel.add(minValue);
        rightPanel.add(maxValueLabel);
        rightPanel.add(maxValue);
        rightPanel.add(userValueLabel);
        rightPanel.add(userValue);
        rightPanel.add(nominalValuesLabel);
        rightPanel.add(cmbNominalValues);
        rightPanel.add(setButton);
        rightPanel.add(backButton);
        rightPanel.add(nextButton);

        springLayout2.putConstraint(SpringLayout.WEST, tablePane, 20,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, tablePane, 30,
                SpringLayout.NORTH, rightPanel);
        springLayout2.putConstraint(SpringLayout.WEST, optionType, 20,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, optionType, 20,
                SpringLayout.SOUTH, tablePane);
        springLayout2.putConstraint(SpringLayout.WEST, txtOptionType, 110,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, txtOptionType, 20,
                SpringLayout.SOUTH, tablePane);

        springLayout2.putConstraint(SpringLayout.WEST, minValueLabel, 20,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, minValueLabel, 20,
                SpringLayout.SOUTH, optionType);
        springLayout2.putConstraint(SpringLayout.WEST, minValue, 110,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, minValue, 20,
                SpringLayout.SOUTH, optionType);
        springLayout2.putConstraint(SpringLayout.WEST, maxValueLabel, 190,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, maxValueLabel, 20,
                SpringLayout.SOUTH, optionType);
        springLayout2.putConstraint(SpringLayout.WEST, maxValue, 280,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, maxValue, 20,
                SpringLayout.SOUTH, optionType);

        springLayout2.putConstraint(SpringLayout.WEST, userValueLabel, 20,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, userValueLabel, 20,
                SpringLayout.SOUTH, minValueLabel);
        springLayout2.putConstraint(SpringLayout.WEST, userValue, 110,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, userValue, 20,
                SpringLayout.SOUTH, minValueLabel);

        springLayout2.putConstraint(SpringLayout.WEST, nominalValuesLabel, 20,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, nominalValuesLabel, 20,
                SpringLayout.SOUTH, userValueLabel);
        springLayout2.putConstraint(SpringLayout.WEST, cmbNominalValues, 130,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, cmbNominalValues, 20,
                SpringLayout.SOUTH, userValueLabel);

        springLayout2.putConstraint(SpringLayout.WEST, setButton, 330,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, setButton, 300,
                SpringLayout.NORTH, rightPanel);

        springLayout2.putConstraint(SpringLayout.WEST, backButton, 330,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, backButton, 500,
                SpringLayout.NORTH, rightPanel);
        springLayout2.putConstraint(SpringLayout.WEST, nextButton, 400,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, nextButton, 500,
                SpringLayout.NORTH, rightPanel);

        disableAllOptionValues();

        splitPane.add(rightPanel, 1);
    }

    private class RowListener implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent event) {
            if (event.getValueIsAdjusting()) {
                return;
            } else {
                int selectedRowIndex = optionTable.getSelectedRow();
                if (selectedRowIndex >= 0) {
                    int correctIndex = optionTable.convertRowIndexToModel(selectedRowIndex);
                    OptionDefinition def = optionList.get(correctIndex);

                    if (def != null) {
                        txtOptionType.setEnabled(true);
                        setButton.setEnabled(true);
                        if (def.isNominal()) {
                            txtOptionType.setText("NOMINAL");
                            cmbNominalValues.setModel(new DefaultComboBoxModel(def.getAvailableValues()));
                            cmbNominalValues.setEnabled(true);
                            cmbNominalValues.requestFocusInWindow();
                            setButton.setEnabled(true);
                        } else {
                            txtOptionType.setText("REEL");
                            minValue.setText(String.valueOf(def.getMinValue()));
                            maxValue.setText(String.valueOf(def.getMaxValue()));
                            userValue.setText("");
                            for (Option opt : newOptionList) {
                                if (opt.getLabel().equals(def.getLabel())) {
                                    userValue.setText(opt.getValue());
                                }
                            }
                            userValue.setEnabled(true);
                            minValue.setEnabled(true);
                            maxValue.setEnabled(true);
                            minValue.setEditable(false);
                            maxValue.setEditable(false);
                            userValue.requestFocusInWindow();
                        }
                    }
                }
            }
        }
    }

    public void initThirdStep() {
        step3.setEnabled(true);

        SpringLayout springLayout2 = new SpringLayout();
        rightPanel = new JPanel();
        rightPanel.setLayout(springLayout2);

        JLabel finalResult = new JLabel("The Categorizer is ready for use.");

        JButton finishButton = new JButton("Finish");
        finishButton.setVisible(true);
        finishButton.setMinimumSize(new Dimension(30, 30));
        FinishAction finishAction = new FinishAction();
        finishButton.addActionListener(finishAction);

        rightPanel.add(finalResult);
        rightPanel.add(finishButton);

        springLayout2.putConstraint(SpringLayout.WEST, finalResult, 20,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, finalResult, 130,
                SpringLayout.NORTH, rightPanel);

        springLayout2.putConstraint(SpringLayout.WEST, finishButton, 400,
                SpringLayout.WEST, rightPanel);
        springLayout2.putConstraint(SpringLayout.NORTH, finishButton, 500,
                SpringLayout.NORTH, rightPanel);
        splitPane.add(rightPanel, 1);
    }

    public void clearRightPanel() {
        rightPanel.removeAll();
        splitPane.remove(rightPanel);
    }

    public void disableLeftPanel() {
        step1.setEnabled(false);
        step2.setEnabled(false);
        step3.setEnabled(false);
    }

    public boolean checkInputs(int stepIndex) {
        if (stepIndex == 0) {
            if (cmbCategorizerClass != null) {
                if (cmbCategorizerClass.getSelectedIndex() >= 0) {
                    return true;
                }
            }
            JOptionPane.showMessageDialog(rightPanel,
                    "A Categorizer Class must be selected!",
                    "Please Check Your Input", JOptionPane.ERROR_MESSAGE);
        } else if(stepIndex == 1) {
            return true;
        }

        return false;
    }

    public class CategorizerClassSelectionAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	try{
            JComboBox cb = (JComboBox) e.getSource();
            selectedCategorizerDefIndex = cb.getSelectedIndex();
            categorizerDesc.setText(categorizerDescriptions[selectedCategorizerDefIndex]);
        	}
        	catch (Exception ex)
        	{
        		Logger.error(ex.getMessage());
        	}
        }
    }

    public class NextAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (checkInputs(currentStep)) {
                clearRightPanel();
                disableLeftPanel();
                currentStep = increaseStep();
                initStep(currentStep);
            }
        }
    }

    public class BackAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            clearRightPanel();
            disableLeftPanel();
            currentStep = decreaseStep();
            initStep(currentStep);
        }
    }

    public class FinishAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
				if (categorizerDefinitions != null) {
					CategorizerExecutor ex = new CategorizerExecutor();
					ex
							.setcategorizerClassName(categorizerDefinitions[selectedCategorizerDefIndex]
									.getClassName());
					Option[] optionArray = new Option[newOptionList.size()];
					for (int i = 0; i < optionArray.length; i++) {
						optionArray[i] = newOptionList.get(i);
					}
					ex.setCategorizerOptions(optionArray);
					ParserExecutor.setCategorizerExecutor(ex);
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			finally
			{
				dialog.dispose();
			}
        }
    }

    public int increaseStep() {
        if (currentStep == 0) {
            if (cmbCategorizerClass != null) {
                if (cmbCategorizerClass.getSelectedItem().equals("Naive Bayes")) {
                    return (currentStep + 2);
                }
            }
        }
        return (currentStep + 1);
    }

    public int decreaseStep() {
        if (currentStep == 2) {
            if (cmbCategorizerClass != null) {
                if (cmbCategorizerClass.getSelectedItem().equals("Naive Bayes")) {
                    return (currentStep - 2);
                }
            }
        }
        return (currentStep - 1);
    }

    public class SetOptionAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int selectedRowIndex = optionTable.getSelectedRow();
            if (selectedRowIndex >= 0) {
                int correctIndex = optionTable.convertRowIndexToModel(selectedRowIndex);
                OptionDefinition def = optionList.get(correctIndex);

                if (def != null) {
                    Option op = new Option();
                    op.setLabel(def.getLabel());
                    if (def.isNominal()) {
                        op.setValue((String) cmbNominalValues.getSelectedItem());
                    } else {
                        op.setValue(userValue.getText());
                    }
                    newOptionList.add(op);
                }
                clearAllInputs();
            }
        }
    }

    private void clearAllInputs() {
        txtOptionType.setEnabled(false);
        txtOptionType.setText("");
        minValue.setEnabled(false);
        minValue.setText("");
        maxValue.setEnabled(false);
        maxValue.setText("");
        userValue.setEnabled(false);
        userValue.setText("");
        cmbNominalValues.setEnabled(false);
        setButton.setEnabled(false);
        optionTable.clearSelection();
    }

    public void enableAllOptionValues() {
        cmbCategorizerClass.setEnabled(true);
        jOptionList.setEnabled(true);
    }

    public void disableAllOptionValues() {
        txtOptionType.setEnabled(false);
        minValue.setEnabled(false);
        maxValue.setEnabled(false);
        userValue.setEnabled(false);
        cmbNominalValues.setEnabled(false);
        setButton.setEnabled(false);
    }

    class OptionsTableModel extends AbstractTableModel {

        private String[] columnNames = {"NAME", "TYPE", "DESCRIPTION"};

        public int getRowCount() {
            if (optionList != null) {
                return optionList.size();
            }
            return -1;
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            if (optionList != null) {
                if (optionList.get(rowIndex) != null) {
                    if (columnIndex == 0) {
                        return ((OptionDefinition) optionList.get(rowIndex)).getLabel();
                    } else if (columnIndex == 1) {
                        if (((OptionDefinition) optionList.get(rowIndex)).isNominal()) {
                            return "NOMINAL";
                        } else {
                            return "REEL";
                        }
                    }
                    if (columnIndex == 2) {
                        return ((OptionDefinition) optionList.get(rowIndex)).getDescription();
                    }
                }
            }
            return null;
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }
}
