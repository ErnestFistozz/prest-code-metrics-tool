/*
 * PrestGuiView.java
 */
package prestgui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import parser.enumeration.Language;
import predictor.WekaRunner;
import wizards.dynamiccategorizer.DynamicCategorizerWizard;
import categorizer.core.Categorizer;
import categorizer.core.CategorizerExecutor;
import categorizer.core.DataHeader;
import categorizer.core.DataSet;
import categorizer.core.MetricOperator;
import categorizer.core.Operand;
import categorizer.core.Option;
import categorizer.core.PerformanceMetric;
import categorizer.core.Threshold;
import categorizer.core.ThresholdOperator;
import categorizer.core.VirtualMetric;
import categorizer.core.filter.LogFilter;
import categorizer.core.util.Arff2DataSet;
import categorizer.staticCategorizer.StaticCategorizer;

import com.sd.dev.lib.ISDContext;
import common.DataContext;
import common.ExtensionFileFilter;
import common.MetricGroup;
import common.gui.actions.ThresholdTableMouseListener;
import common.gui.controls.ControlBar;
import common.gui.controls.IControlBarListener;
import common.gui.controls.MenuButton;
import common.gui.models.ThresholdContent;
import common.gui.models.ThresholdTableModel;
import common.gui.packageexplorer.PackageExplorer;
import common.gui.statics.Components;
import common.gui.util.ComponentState;
import common.gui.util.GUIUtilities;
import common.gui.util.TaggedList;

import definitions.application.ApplicationProperties;
import executor.ParserExecutor;

/**
 * The application's main frame.
 */

// SciDesktop Modification TA_R001	--- class implements WindowListener
public class PrestGuiView extends JFrame implements ActionListener, WindowListener, PopupMenuListener, IControlBarListener
{
	private static final int VIEWWIDTH     = 800;
	private static final int VIEWHEIGHT    = 600;
	
	// SciDesktop Modification TA_R001	--- additional variables are needed for the created instance
	private ISDContext sdContext;
	private ResourceBundle resources;
	private ActionListener buttonExecutor;
	
	// Component custom properties
	
	private static final String TAGPROPERTY    = "TAG";
	
	// Application menu identifiers
	
	private static final int MI_ADDPROJECT     = 1;
	private static final int MI_PARSEPROJECT   = 2;
	private static final int MI_TABLETRANSFER  = 3;
	private static final int MI_CVS2ARFF       = 4;
	private static final int MI_DELETEPROJECT  = 11;
	private static final int MI_SWITCHWS       = 21;
	private static final int MI_EXIT           = 91;
	private static final int MI_NEWTHRESHOLD   = 201;
	private static final int MI_NEWVMETRIC     = 202;
	private static final int MI_FILTER	       = 203;
	private static final int MI_HELPCONTENTS   = 301;
	private static final int MI_REFERENCES     = 302;
	private static final int MI_ABOUT          = 303;
	
	private static final int MI_LOADSTORE      = 1001;
	private static final int MI_METRICS        = 1002;
	private static final int MI_LANGUAGES      = 1003;
	private static final int MI_SWITCHVW       = 1004;
	
	private static final int MI_LOADDATA       = 2001;
	private static final int MI_PREDOPTS       = 2002;
	private static final int MI_ALGORITHM      = 2003;
	private static final int MI_RUNPRED        = 2004;
	
	private static final int MI_SOFTLAB        = 9998;
	private static final int MI_FILLER         = 9999;
	
	// Metrics Panels
	
	private static final int MP_PACKAGE     = 0;
	private static final int MP_FILE        = 1;
	private static final int MP_CLASS       = 2;
	private static final int MP_METHOD      = 3;
	
	// WEKA Attributes
	
	private static final int WA_CRSVALD     = 1;
	private static final int WA_NORMALIZE   = 2;
	private static final int WA_LOGFILTER 	= 3;
	
	private IPrestViewListener viewListener;
	
	// components & dialogs

	private ControlBar analysisToolbar;
	private ControlBar predictionToolbar;
	private ImageIcon okMark;
	private MenuButton metricsMenuButton;
	private MenuButton languagesMenuButton;
	private MenuButton wekaAtrbsMenuButton;
	private MenuButton algorithmMenuButton;
	
    private javax.swing.JPanel analysisResultsPanel;
    private javax.swing.JPanel projectPanel;
    private javax.swing.JTextField projectTitleDisplay;
    private JTextArea projectInfoDisplay;
    private JTabbedPane[] metricsPanels;
    private javax.swing.JMenu analyzeMenu;
    private javax.swing.JButton btnApplyFilter;
    private javax.swing.JButton btnCancelFilter;
    private javax.swing.JButton btnCategorize;
    private javax.swing.JButton btnLoadCategorizer;
    private javax.swing.JTextField predictionTitleDisplay;
    private javax.swing.JButton btnLoadTest;
    private javax.swing.JButton btnLoadTraining;
    private javax.swing.JButton btnStartWeka;
    private javax.swing.JButton btnStoreCategorizer;
    private javax.swing.JButton btnThresholdWizardBack;
    private javax.swing.JButton btnThresholdWizardCancel;
    private javax.swing.JButton btnThresholdWizardNext;
    private javax.swing.JButton btnTransferAllToFilter;
    private javax.swing.JButton btnTransferAllToLeft;
    private javax.swing.JButton btnTransferLeft;
    private javax.swing.JButton btnTransferToFilter;
    private javax.swing.JButton btnVmBack;
    private javax.swing.JButton btnVmNext;
    private javax.swing.ButtonGroup btngFirstOperand;
    private javax.swing.ButtonGroup btngLanguageGroup;
    private javax.swing.ButtonGroup btngRiskLevel;
    private javax.swing.ButtonGroup btngSecondOperand;
    private javax.swing.ButtonGroup btngVmOperand1;
    private javax.swing.ButtonGroup btngVmOperand2;
    private javax.swing.JButton cancelVirtualMetricButton;
    private javax.swing.JCheckBox chkboxCrossValidate;
    private javax.swing.JCheckBox chkboxLogFilter;
    private javax.swing.JPanel classMetricsDataSetPanel;
    private javax.swing.JTabbedPane classMetricsTabbedPane;
    private javax.swing.JPanel classMetricsThresholdPanel;
    private javax.swing.JComboBox cmbMetricGroups;
    private javax.swing.JComboBox cmbRiskLevels;
    private javax.swing.JComboBox cmbThresholdMetricList;
    private javax.swing.JComboBox cmbThresholdOperator;
    private javax.swing.JComboBox cmbThresholdOperator1;
    private javax.swing.JComboBox cmbThresholdOperator2;
    private javax.swing.JComboBox cmbVmMetricOperator;
    private javax.swing.JComboBox cmbVmOperand1;
    private javax.swing.JComboBox cmbVmOperand2;
    private javax.swing.JPanel fileMetricsDataSetPanel;
    private javax.swing.JTabbedPane fileMetricsTabbedPane;
    private javax.swing.JPanel fileMetricsThresholdPanel;
    private javax.swing.JDialog filterWizardDialog;
    private javax.swing.JCheckBox jCheckBoxNormalize;
    private javax.swing.JComboBox jComboBoxChooseAlgorithm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel predictionPanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblThresholdExpression;
    private javax.swing.JLabel lblThresholdOperand2;
    private javax.swing.JLabel lblThresholdRiskLevel;
    private javax.swing.JLabel lblVirtualMetricEquation;
    private javax.swing.JLabel lblVirtualMetricName;
    private javax.swing.JLabel lblVmOperand2;
    private javax.swing.JList listAllMetrics;
    private javax.swing.JList listFilterMetrics;
    private javax.swing.JSplitPane dataSplitPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel methodMetricsDataSetPanel;
    private javax.swing.JTabbedPane methodMetricsTabbedPane;
    private javax.swing.JPanel methodMetricsThresholdPanel;
    private javax.swing.JPanel metricsCardLayoutPanel;
    private javax.swing.JPanel packageMetricsDataSetPanel;
    private javax.swing.JTabbedPane packageMetricsTabbedPane;
    private javax.swing.JPanel packageMetricsThresholdPanel;
    private javax.swing.JPanel pnlCategorizeButtons;
    private javax.swing.JPanel pnlDataCardLayout;
    private javax.swing.JPanel pnlDataFile;
    private javax.swing.JPanel pnlDataFileAnalyze;
    private javax.swing.JPanel resultsDataPanel;
    private javax.swing.JPanel pnlFilterButtons;
    private javax.swing.JPanel pnlFilterHeader;
    private javax.swing.JPanel pnlFilterMain;
    private javax.swing.JPanel pnlLanguageRadioPanel;
    private javax.swing.JPanel pnlParseResultsAnalyze;
    private javax.swing.JPanel pnlThresholdApprove;
    private javax.swing.JPanel pnlThresholdSettings;
    private javax.swing.JPanel pnlThresholdSettingsCardLayout;
    private javax.swing.JPanel pnlThresholdWizardButtons;
    private javax.swing.JPanel pnlThresholdWizardHeader;
    private javax.swing.JPanel pnlVmApproval;
    private javax.swing.JPanel pnlVmButtons;
    private javax.swing.JPanel pnlVmCardLayout;
    private javax.swing.JPanel pnlVmHeader;
    private javax.swing.JPanel pnlVmSettings;
    private javax.swing.JPanel pnlthresholdWizardMain;
    private javax.swing.JRadioButton rbtnThresholdOperator1Cmb;
    private javax.swing.JRadioButton rbtnThresholdOperator2Cmb;
    private javax.swing.JRadioButton rbtnThresholdOperator2Txt;
    private javax.swing.JRadioButton rbtnThresholdOperatorOneTxt;
    private javax.swing.JRadioButton rbtnVmOperand1Cmb;
    private javax.swing.JRadioButton rbtnVmOperand1Txt;
    private javax.swing.JRadioButton rbtnVmOperand2Cmb;
    private javax.swing.JRadioButton rbtnVmOperand2Txt;
    private javax.swing.JTabbedPane tabPaneAnalysisResults;
    private javax.swing.JTabbedPane tabPaneDataFileAnalyze;
    private javax.swing.ButtonGroup testOptionsButtonGroup;
    private javax.swing.JDialog thresholdWizardDialog;
    private javax.swing.JTextField txtThresholdOperator1;
    private javax.swing.JTextField txtThresholdOperator2;
    private javax.swing.JTextField txtVmMetricName;
    private javax.swing.JTextField txtVmOperand1;
    private javax.swing.JTextField txtVmOperand2;
    private javax.swing.JDialog virtualMetricWizardDialog;
	
    private StaticCategorizer staticCategorizer;
	private DefaultListModel leftListModel;
	private DefaultListModel rightListModel;
	private boolean doubleOperands;
	private MetricOperator virtualMetricOperator;
	private String virtualMetricName;
	private Operand[] virtualMetricOperands;
	private String virtualMetricOperand1;
	private String virtualMetricOperand2;
	private ThresholdOperator thresholdOperator;
	private String thresholdSelectedMetric;
	private String thresholdOperand1;
	private String thresholdOperand2;
	private Operand[] thresholdOperands;
	private PackageExplorer packageExplorer;
	private DataHeader thresholdDataHeader;
	private Operand[] operands;
	private MetricOperator metricOperator;
	private List<MetricGroup> packageMetrics;
	private List<MetricGroup> fileMetrics;
	private List<MetricGroup> classMetrics;
	private List<MetricGroup> methodMetrics;
	private DataSet arffDataSet;
	private CategorizerExecutor categorizerExecutor;
	private String trainingSetPath;
	private String testSetPath;
	private String wekaAlgorithmType = "Naive Bayes";
	private String wekaCrossValidate = "false";
	private String wekaPreProcess = "false";
	private String wekaLogFilter = "false";
	private JDialog aboutBox;
	// </editor-fold>
	
	// SciDesktop Modification TA_R001	--- constructor is modified to allow initialization and handling of context
	public PrestGuiView(ISDContext ctx) 
	{
		super();
		addWindowListener(this);
		
		// SciDesktop Modification TA_R001	--- context initialization and modification of JFrame instance
		sdContext = ctx;
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		if (sdContext != null && sdContext.getMode() == ISDContext.MODE_NATIVE && sdContext.getApplicationIcon() != null)
			setIconImage(sdContext.getApplicationIcon().getImage());
		
		resources = GUIUtilities.getResources(getClass(), "/prestgui/resources/PrestGuiView.properties");
		okMark = getResourceIcon("OKMark.png");
		setTitle(resources.getString("application.name"));
		
		initExecutor();
		initMenu();
		initComponents();

		setStaticComponents();
		
		pack();
		setPosition(null);
		
		setVisible(true);
	}

	private void initExecutor()
	{
		class Executor implements ActionListener
		{
			public Object Parent;
			
			public void actionPerformed(ActionEvent evt)
			{
				Object src = evt.getSource();
				if (src instanceof AbstractButton)
				{
					String xCmd = ((AbstractButton) src).getActionCommand();
					try
					{
						Method m = Parent.getClass().getMethod(xCmd, (Class[]) null);
						if (m != null)
							m.invoke(Parent, (Object[]) null);
							
					}
					catch (Exception e)
					{
					}
				}
			}
			
		}
		
		Executor ex  = new Executor();
		ex.Parent = this;
		buttonExecutor = ex;
	}

	public void disposeView()
	{
		if (viewListener != null)
			viewListener.viewDisposed();
		
		if (sdContext == null || sdContext.getMode() == ISDContext.MODE_OFFLINE)
			System.exit(0);
		else
			dispose();
	}
	
	public void setViewListener(IPrestViewListener listener)
	{
		viewListener = listener;
	}
	
	public void setPosition(Point customPos)
	{
		Point position = null;
		Dimension size = null;
		if (customPos != null)
			position = customPos;
			
		if (size == null)
			size = new Dimension(VIEWWIDTH, VIEWHEIGHT);
		setSize(size);
		
		if (position == null)
		{
			Dimension sDim = Toolkit.getDefaultToolkit().getScreenSize();
			int x = (sDim.width - getWidth()) / 2;
			int y = (sDim.height - getHeight()) / 2;
			position = new Point(x, y);
		}

		setLocation(position);
	}

	private void initMenu()
	{
        menuBar = new javax.swing.JMenuBar();
        menuBar.setName("menuBar"); // NOI18N

        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        fileMenu.setText(resources.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N
        fileMenu.getPopupMenu().addPopupMenuListener(this);
        fileMenu.add(createMenuItem(MI_ADDPROJECT, "addProjectMenuItem", "addProjectMenuItem.text"));
        fileMenu.addSeparator();
        fileMenu.add(createMenuItem(MI_PARSEPROJECT, "parseProjectMenuItem", "parseProjectMenuItem.text"));
        fileMenu.add(createMenuItem(MI_TABLETRANSFER, "tableTransferItem", "tableTransferMenuItem.text"));
        fileMenu.add(createMenuItem(MI_CVS2ARFF, "cvs2ArffItem", "convertCVS2ArffMenuItem.text"));
        fileMenu.addSeparator();
        fileMenu.add(createMenuItem(MI_DELETEPROJECT, "deleteProjectItem", "deleteProjectMenuItem.text"));
        fileMenu.addSeparator();
        fileMenu.add(createMenuItem(MI_SWITCHWS, "switchWSItem", "switchWorkspaceMenuItem.text"));
        fileMenu.addSeparator();
        fileMenu.add(createMenuItem(MI_EXIT, "exitItem", "exitMenuItem.text"));
        
        menuBar.add(fileMenu);
        
        analyzeMenu = new javax.swing.JMenu();
        analyzeMenu.setText(resources.getString("analyzeMenu.text")); // NOI18N
        analyzeMenu.setName("analyzeMenu"); // NOI18N
        analyzeMenu.getPopupMenu().addPopupMenuListener(this);
        analyzeMenu.add(createMenuItem(MI_NEWTHRESHOLD, "thresholdMenuItem", "thresholdMenuItem.text"));
        analyzeMenu.add(createMenuItem(MI_NEWVMETRIC, "virtualMetricMenuItem", "virtualMetricMenuItem.text"));
        analyzeMenu.add(createMenuItem(MI_FILTER, "filterMenuItem", "filterMenuItem.text"));
		
        menuBar.add(analyzeMenu);

        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        helpMenu.setText(resources.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N
        helpMenu.getPopupMenu().addPopupMenuListener(this);
        helpMenu.add(createMenuItem(MI_HELPCONTENTS, "helpContentsMenuItem", "helpContentsMenuItem.text"));
        helpMenu.add(createMenuItem(MI_REFERENCES, "referencesMenuItem", "referencesMenuItem.text"));
        helpMenu.addSeparator();
        helpMenu.add(createMenuItem(MI_ABOUT, "aboutMenuItem", "aboutMenuItem.text"));

        menuBar.add(helpMenu);
        
        setJMenuBar(menuBar);
	}
	
	private JMenuItem createMenuItem(int id, String name, String key)
	{
		JMenuItem item = new javax.swing.JMenuItem();
		item.setName(name);
		item.putClientProperty(TAGPROPERTY, new Integer(id));
		item.setText(resources.getString(key));
		item.addActionListener(this);
		return item;
	}
	
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        createAnalysisResults();
        createPredictionPanel();
        createVMetricsDialog();
        createThresholdDialog();
        createFilterDialog();
        
        
        testOptionsButtonGroup = new javax.swing.ButtonGroup();
        btngRiskLevel = new javax.swing.ButtonGroup();
        btngLanguageGroup = new javax.swing.ButtonGroup();
        
        mainPanel.add(analysisResultsPanel);
        predictionPanel.setVisible(false);
        mainPanel.add(predictionPanel);
        mainPanel.validate();
        
        getContentPane().add(mainPanel);
        
        checkToolBars();
    }

    private void checkToolBars()
    {
        analysisToolbar.checkControls();
        predictionToolbar.checkControls();
    }
    
	private void createAnalysisResults()
	{
        analysisResultsPanel = new javax.swing.JPanel();
        analysisResultsPanel.setName("analysisResultsPanel"); // NOI18N
        analysisResultsPanel.setLayout(new BorderLayout());
        
        analysisResultsPanel.add(createAnalysisToolbar(), BorderLayout.NORTH);
        
        dataSplitPanel = new javax.swing.JSplitPane();
        dataSplitPanel.setDividerLocation(150);
        dataSplitPanel.setResizeWeight(0.25);
        dataSplitPanel.setDividerSize(6);
        dataSplitPanel.setOneTouchExpandable(true);
        dataSplitPanel.setMinimumSize(new java.awt.Dimension(90, 80));
        dataSplitPanel.setName("dataSplitPanel"); // NOI18N

		packageExplorer = new PackageExplorer();
		packageExplorer.generateRepositoryTree(dataSplitPanel);
		packageExplorer.traverseRepository();
        
        dataSplitPanel.setRightComponent(createProjectPanel());
        analysisResultsPanel.add(dataSplitPanel, BorderLayout.CENTER);
	}

	private Component createAnalysisToolbar()
	{
		analysisToolbar = new ControlBar();
		analysisToolbar.setCBListener(this);
		analysisToolbar.setMarkIcon(okMark);
		
		analysisToolbar.addImageButton(MI_ADDPROJECT, getResourceIcon("addproject.png"), -1, resources.getString("addProjectMenuItem.text"), 0, 2);
		analysisToolbar.addImageButton(MI_PARSEPROJECT, getResourceIcon("parseproject.png"), -1, resources.getString("parseProjectMenuItem.text"), 0, 2);
		analysisToolbar.addImageButton(MI_DELETEPROJECT, getResourceIcon("delete.png"), -1, resources.getString("deleteProjectMenuItem.text"), 0, 2);
		analysisToolbar.addImageButton(MI_NEWTHRESHOLD, getResourceIcon("newthreshold.png"), -1, resources.getString("thresholdMenuItem.text"), 0, 2);
		analysisToolbar.addMenuButton(MI_LOADSTORE, getResourceIcon("load.png"), getResourceList("loadstore.button.items"), -1, resources.getString("loadstore.button.text"), false, 0, 2);
		analysisToolbar.addImageButton(MI_FILTER, getResourceIcon("filter.png"), -1, resources.getString("filterMenuItem.text"), 0, 2);
		analysisToolbar.addImageButton(MI_NEWVMETRIC, getResourceIcon("newmetric.png"), -1, resources.getString("virtualMetricMenuItem.text"), 0, 20);
		analysisToolbar.addLabel(MI_FILLER, -1, "", 1.0, 0, 0);
		metricsMenuButton = analysisToolbar.addMenuButton(MI_METRICS, getResourceIcon("metrics.png"), getResourceList("metrics.button.items"), -1, resources.getString("metrics.button.text"), false, 0, 2);
		languagesMenuButton = analysisToolbar.addMenuButton(MI_LANGUAGES, getResourceIcon("language.png"), getResourceList("language.button.items"), -1, resources.getString("language.button.text"), false, 0, 2);
		analysisToolbar.addImageButton(MI_SWITCHWS, getResourceIcon("switchws.png"), -1, resources.getString("switchWorkspaceMenuItem.text"), 0, 2);
		analysisToolbar.addImageButton(MI_SWITCHVW, getResourceIcon("switchpn.png"), -1, resources.getString("switchView.button.text"), 0, 2);
		analysisToolbar.addImageButton(MI_SOFTLAB, getResourceIcon("softlab24.PNG"), -1, null, 0, 2);
		
		analysisToolbar.addTerminators(true);
		analysisToolbar.setMenuButtonMark(MI_LOADSTORE, false);
		analysisToolbar.markMenuButtonSelection(metricsMenuButton, 0, okMark);
		analysisToolbar.markMenuButtonSelection(languagesMenuButton, 0, okMark);
		
		return analysisToolbar;
	}

	private ImageIcon getResourceIcon(String name)
	{
		return GUIUtilities.getIcon(getClass(), "/prestgui/resources/"+name);
	}
	
	private TaggedList getResourceList(String key)
	{
		String lStr = resources.getString(key);
		if (lStr != null)
		{
			TaggedList l =  new TaggedList();
			l.addAll(lStr);
			return l;
		}
		
		return null;
	}
	
	private Component createProjectPanel()
	{
        projectPanel = new JPanel();
        projectPanel.setName("project");
        projectPanel.setLayout(new BorderLayout());
        
        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());
        
        projectTitleDisplay = new JTextField();
        projectTitleDisplay.setEditable(false);
        projectTitleDisplay.setFocusable(false);
        projectTitleDisplay.setBackground(Color.DARK_GRAY);
        projectTitleDisplay.setForeground(Color.WHITE);
		Font font = new Font("Tahoma", Font.BOLD, 10);
		projectTitleDisplay.setFont(font);
		projectTitleDisplay.setText("Project");
		projectTitleDisplay.setPreferredSize(new Dimension(50, 18));
		
		header.add(projectTitleDisplay, BorderLayout.NORTH);
		
		projectInfoDisplay = new JTextArea();
		projectInfoDisplay.setPreferredSize(new Dimension(48, 48));
		projectInfoDisplay.setEditable(false);
		projectInfoDisplay.setBorder(new LineBorder(Color.BLACK, 2));
		projectInfoDisplay.setMinimumSize(new Dimension(10, 10));
				
		header.add(projectInfoDisplay, BorderLayout.CENTER);
		
		projectPanel.add(header, BorderLayout.NORTH);
        		
		metricsPanels = new JTabbedPane[4];
        
		resultsDataPanel = new javax.swing.JPanel();
        resultsDataPanel.setName("resultsDataPanel"); // NOI18N
        resultsDataPanel.setLayout(new BoxLayout(resultsDataPanel, BoxLayout.Y_AXIS));
                
        packageMetricsTabbedPane = new javax.swing.JTabbedPane();
        packageMetricsTabbedPane.setMinimumSize(new Dimension(30, 25));
        packageMetricsTabbedPane.setName("packageMetricsTabbedPane"); // NOI18N
        
        packageMetricsDataSetPanel = new javax.swing.JPanel();
        packageMetricsDataSetPanel.setName("packageMetricsDataSetPanel"); // NOI18N
        
        javax.swing.GroupLayout packageMetricsDataSetPanelLayout = new javax.swing.GroupLayout(packageMetricsDataSetPanel);
        packageMetricsDataSetPanel.setLayout(packageMetricsDataSetPanelLayout);
        packageMetricsDataSetPanelLayout.setHorizontalGroup(
            packageMetricsDataSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 895, Short.MAX_VALUE)
        );
        packageMetricsDataSetPanelLayout.setVerticalGroup(
            packageMetricsDataSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        packageMetricsTabbedPane.addTab(resources.getString("packageMetricsDataSetPanel.TabConstraints.tabTitle"), packageMetricsDataSetPanel); // NOI18N
        
        packageMetricsThresholdPanel = new javax.swing.JPanel();
        packageMetricsThresholdPanel.setName("packageMetricsThresholdPanel"); // NOI18N
        
        javax.swing.GroupLayout packageMetricsThresholdPanelLayout = new javax.swing.GroupLayout(packageMetricsThresholdPanel);
        packageMetricsThresholdPanel.setLayout(packageMetricsThresholdPanelLayout);
        packageMetricsThresholdPanelLayout.setHorizontalGroup(
            packageMetricsThresholdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 895, Short.MAX_VALUE)
        );
        packageMetricsThresholdPanelLayout.setVerticalGroup(
            packageMetricsThresholdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        packageMetricsTabbedPane.addTab(resources.getString("packageMetricsThresholdPanel.TabConstraints.tabTitle"), packageMetricsThresholdPanel); // NOI18N
        packageMetricsTabbedPane.setSelectedIndex(0);
        metricsPanels[MP_PACKAGE] = packageMetricsTabbedPane;
        
//        metricsCardLayoutPanel.add(packageMetricsTabbedPane, "card3");
        resultsDataPanel.add(packageMetricsTabbedPane);
        
        fileMetricsTabbedPane = new javax.swing.JTabbedPane();
        fileMetricsTabbedPane.setMinimumSize(new Dimension(30, 25));
        fileMetricsTabbedPane.setName("fileMetricsTabbedPane"); // NOI18N
        fileMetricsDataSetPanel = new javax.swing.JPanel();
        fileMetricsDataSetPanel.setName("fileMetricsDataSetPanel"); // NOI18N
        javax.swing.GroupLayout fileMetricsDataSetPanelLayout = new javax.swing.GroupLayout(fileMetricsDataSetPanel);
        fileMetricsDataSetPanel.setLayout(fileMetricsDataSetPanelLayout);
        fileMetricsDataSetPanelLayout.setHorizontalGroup(
            fileMetricsDataSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 895, Short.MAX_VALUE)
        );
        fileMetricsDataSetPanelLayout.setVerticalGroup(
            fileMetricsDataSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        fileMetricsTabbedPane.addTab(resources.getString("fileMetricsDataSetPanel.TabConstraints.tabTitle"), fileMetricsDataSetPanel); // NOI18N
        
        fileMetricsThresholdPanel = new javax.swing.JPanel();
        fileMetricsThresholdPanel.setName("fileMetricsThresholdPanel"); // NOI18N
        
        javax.swing.GroupLayout fileMetricsThresholdPanelLayout = new javax.swing.GroupLayout(fileMetricsThresholdPanel);
        fileMetricsThresholdPanel.setLayout(fileMetricsThresholdPanelLayout);
        fileMetricsThresholdPanelLayout.setHorizontalGroup(
            fileMetricsThresholdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 895, Short.MAX_VALUE)
        );
        fileMetricsThresholdPanelLayout.setVerticalGroup(
            fileMetricsThresholdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        fileMetricsTabbedPane.addTab(resources.getString("fileMetricsThresholdPanel.TabConstraints.tabTitle"), fileMetricsThresholdPanel); // NOI18N
        fileMetricsTabbedPane.setSelectedIndex(0);
        fileMetricsTabbedPane.setVisible(false);
        metricsPanels[MP_FILE] = fileMetricsTabbedPane;
        
//        metricsCardLayoutPanel.add(fileMetricsTabbedPane, "card2");
        resultsDataPanel.add(fileMetricsTabbedPane);
        
        classMetricsTabbedPane = new javax.swing.JTabbedPane();
        classMetricsTabbedPane.setMinimumSize(new Dimension(30, 25));
        classMetricsTabbedPane.setName("classMetricsTabbedPane"); // NOI18N
        classMetricsDataSetPanel = new javax.swing.JPanel();
        classMetricsDataSetPanel.setName("classMetricsDataSetPanel"); // NOI18N
        javax.swing.GroupLayout classMetricsDataSetPanelLayout = new javax.swing.GroupLayout(classMetricsDataSetPanel);
        classMetricsDataSetPanel.setLayout(classMetricsDataSetPanelLayout);
        classMetricsDataSetPanelLayout.setHorizontalGroup(
            classMetricsDataSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 895, Short.MAX_VALUE)
        );
        classMetricsDataSetPanelLayout.setVerticalGroup(
            classMetricsDataSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        classMetricsTabbedPane.addTab(resources.getString("classMetricsDataSetPanel.TabConstraints.tabTitle"), classMetricsDataSetPanel); // NOI18N
        classMetricsThresholdPanel = new javax.swing.JPanel();
        classMetricsThresholdPanel.setName("classMetricsThresholdPanel"); // NOI18N
        javax.swing.GroupLayout classMetricsThresholdPanelLayout = new javax.swing.GroupLayout(classMetricsThresholdPanel);
        classMetricsThresholdPanel.setLayout(classMetricsThresholdPanelLayout);
        classMetricsThresholdPanelLayout.setHorizontalGroup(
            classMetricsThresholdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 895, Short.MAX_VALUE)
        );
        classMetricsThresholdPanelLayout.setVerticalGroup(
            classMetricsThresholdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        classMetricsTabbedPane.addTab(resources.getString("classMetricsThresholdPanel.TabConstraints.tabTitle"), classMetricsThresholdPanel); // NOI18N
        classMetricsTabbedPane.setSelectedIndex(0);
        classMetricsTabbedPane.setVisible(false);
        metricsPanels[MP_CLASS] = classMetricsTabbedPane;

//        metricsCardLayoutPanel.add(classMetricsTabbedPane, "card5");
        resultsDataPanel.add(classMetricsTabbedPane);
        
        methodMetricsTabbedPane = new javax.swing.JTabbedPane();
        methodMetricsTabbedPane.setMinimumSize(new Dimension(30, 25));
        methodMetricsTabbedPane.setName("methodMetricsTabbedPane"); // NOI18N
        methodMetricsDataSetPanel = new javax.swing.JPanel();
        methodMetricsDataSetPanel.setName("methodMetricsDataSetPanel"); // NOI18N
        javax.swing.GroupLayout methodMetricsDataSetPanelLayout = new javax.swing.GroupLayout(methodMetricsDataSetPanel);
        methodMetricsDataSetPanel.setLayout(methodMetricsDataSetPanelLayout);
        methodMetricsDataSetPanelLayout.setHorizontalGroup(
            methodMetricsDataSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 895, Short.MAX_VALUE)
        );
        methodMetricsDataSetPanelLayout.setVerticalGroup(
            methodMetricsDataSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        methodMetricsTabbedPane.addTab(resources.getString("methodMetricsDataSetPanel.TabConstraints.tabTitle"), methodMetricsDataSetPanel); // NOI18N
        methodMetricsThresholdPanel = new javax.swing.JPanel();
        methodMetricsThresholdPanel.setName("methodMetricsThresholdPanel"); // NOI18N
        javax.swing.GroupLayout methodMetricsThresholdPanelLayout = new javax.swing.GroupLayout(methodMetricsThresholdPanel);
        methodMetricsThresholdPanel.setLayout(methodMetricsThresholdPanelLayout);
        methodMetricsThresholdPanelLayout.setHorizontalGroup(
            methodMetricsThresholdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 895, Short.MAX_VALUE)
        );
        methodMetricsThresholdPanelLayout.setVerticalGroup(
            methodMetricsThresholdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        methodMetricsTabbedPane.addTab(resources.getString("methodMetricsThresholdPanel.TabConstraints.tabTitle"), methodMetricsThresholdPanel); // NOI18N
        methodMetricsTabbedPane.setSelectedIndex(0);
        methodMetricsTabbedPane.setVisible(false);
        metricsPanels[MP_METHOD] = methodMetricsTabbedPane;
        resultsDataPanel.add(methodMetricsTabbedPane);
        projectPanel.add(resultsDataPanel, BorderLayout.CENTER);
        
        return projectPanel;
	}

	private Component createPredictionPanel()
	{
        predictionPanel = new javax.swing.JPanel();
        predictionPanel.setName("predictionPanel"); // NOI18N
        predictionPanel.setLayout(new BorderLayout());       
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane4.setName("jScrollPane4"); // NOI18N
        jTextArea1 = new javax.swing.JTextArea();
        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(GUIUtilities.getResourceFont(resources, "jTextArea1.font")); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText(resources.getString("jTextArea1.text")); // NOI18N
        jTextArea1.setName("jTextArea1"); // NOI18N
        jTextArea1.setMinimumSize(new Dimension(10, 10));
        jScrollPane4.setViewportView(jTextArea1);
        
        jPanel3 = new javax.swing.JPanel();
        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setLayout(new BorderLayout());
        
        predictionTitleDisplay = new JTextField();
        predictionTitleDisplay.setEditable(false);
        predictionTitleDisplay.setFocusable(false);
        predictionTitleDisplay.setBackground(Color.DARK_GRAY);
        predictionTitleDisplay.setForeground(Color.WHITE);
		Font font = new Font("Tahoma", Font.BOLD, 10);
		predictionTitleDisplay.setFont(font);
		predictionTitleDisplay.setText(resources.getString("predictionDisplay.text"));
		predictionTitleDisplay.setPreferredSize(new Dimension(50, 18));
		
		jPanel3.add(predictionTitleDisplay, BorderLayout.NORTH);
		jPanel3.add(jScrollPane4, BorderLayout.CENTER);
       
        predictionPanel.add(createPredictionToolbar(), BorderLayout.NORTH);
        predictionPanel.add(jPanel3, BorderLayout.CENTER);


		return predictionPanel;
	}
	
	private Component createPredictionToolbar()
	{
		predictionToolbar = new ControlBar();
		predictionToolbar.setCBListener(this);
		predictionToolbar.setMarkIcon(okMark);
		
		predictionToolbar.addMenuButton(MI_LOADDATA, getResourceIcon("load.png"), getResourceList("loadset.button.items"), -1, resources.getString("loadset.button.text"), false, 0, 2);
		wekaAtrbsMenuButton = predictionToolbar.addMenuButton(MI_PREDOPTS, getResourceIcon("options.png"), getResourceList("predoptions.button.items"), -1, resources.getString("predoptions.button.text"), true, 0, 2);
		algorithmMenuButton = predictionToolbar.addMenuButton(MI_ALGORITHM, getResourceIcon("algorithm.png"), getResourceList("algort.button.items"), -1, resources.getString("algort.button.text"), false, 0, 2);
		predictionToolbar.addImageButton(MI_RUNPRED, getResourceIcon("start.png"), -1, resources.getString("runpred.button.text"), 0, 20);
		predictionToolbar.addLabel(MI_FILLER, -1, "", 1.0, 0, 0);
		predictionToolbar.addImageButton(MI_SWITCHVW, getResourceIcon("switchpn.png"), -1, resources.getString("switchView.button.text"), 0, 2);
		predictionToolbar.addImageButton(MI_SOFTLAB, getResourceIcon("softlab24.PNG"), -1, null, 0, 2);
		
		predictionToolbar.markMenuButtonSelection(algorithmMenuButton, 0, okMark);
		predictionToolbar.setMenuButtonMark(MI_LOADDATA, false);
		predictionToolbar.addTerminators(true);
		
		return predictionToolbar;
	}
	
	public void createVMetricsDialog()
	{
        virtualMetricWizardDialog = new javax.swing.JDialog();
        virtualMetricWizardDialog.setTitle(resources.getString("virtualMetricWizardDialog.title")); // NOI18N
        virtualMetricWizardDialog.setAlwaysOnTop(true);
        virtualMetricWizardDialog.setName("virtualMetricWizardDialog"); // NOI18N
        virtualMetricWizardDialog.setResizable(false);
        
        pnlVmCardLayout = new javax.swing.JPanel();
        pnlVmCardLayout.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlVmCardLayout.setName("pnlVmCardLayout"); // NOI18N
        pnlVmCardLayout.setLayout(new java.awt.CardLayout());
        pnlVmSettings = new javax.swing.JPanel();
        pnlVmSettings.setName("pnlVmSettings"); // NOI18N
        
        
        lblVmOperand2 = new javax.swing.JLabel();
        lblVmOperand2.setText(resources.getString("lblVmOperand2.text")); // NOI18N
        lblVmOperand2.setName("lblVmOperand2"); // NOI18N

        rbtnVmOperand2Txt = new javax.swing.JRadioButton();
        rbtnVmOperand2Txt.setSelected(true);
        rbtnVmOperand2Txt.setText(resources.getString("rbtnVmOperand2Txt.text")); // NOI18N
        rbtnVmOperand2Txt.setName("rbtnVmOperand2Txt"); // NOI18N
        rbtnVmOperand2Txt.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbtnVmOperand2TxtStateChanged(evt);
            }
        });
        
        rbtnVmOperand2Cmb = new javax.swing.JRadioButton();
        rbtnVmOperand2Cmb.setText(resources.getString("rbtnVmOperand2Cmb.text")); // NOI18N
        rbtnVmOperand2Cmb.setName("rbtnVmOperand2Cmb"); // NOI18N
        rbtnVmOperand2Cmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtnVmOperand2CmbItemStateChanged(evt);
            }
        });
        
        txtVmOperand2 = new javax.swing.JTextField();
        txtVmOperand2.setText(resources.getString("txtVmOperand2.text")); // NOI18N
        txtVmOperand2.setName("txtVmOperand2"); // NOI18N

        cmbVmOperand2 = new javax.swing.JComboBox();
        cmbVmOperand2.setEnabled(false);
        cmbVmOperand2.setName("cmbVmOperand2"); // NOI18N
        
        cmbVmMetricOperator = new javax.swing.JComboBox();
        cmbVmMetricOperator.setName("cmbVmMetricOperator"); // NOI18N
        cmbVmMetricOperator.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbVmMetricOperatorItemStateChanged(evt);
            }
        });
        
        txtVmMetricName = new javax.swing.JTextField();
        txtVmMetricName.setText(resources.getString("txtVmMetricName.text")); // NOI18N
        txtVmMetricName.setName("txtVmMetricName"); // NOI18N
        
        rbtnVmOperand1Txt = new javax.swing.JRadioButton();
        rbtnVmOperand1Txt.setSelected(true);
        rbtnVmOperand1Txt.setText(resources.getString("rbtnVmOperand1Txt.text")); // NOI18N
        rbtnVmOperand1Txt.setName("rbtnVmOperand1Txt"); // NOI18N
        rbtnVmOperand1Txt.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbtnVmOperand1TxtStateChanged(evt);
            }
        });
        
        txtVmOperand1 = new javax.swing.JTextField();
        txtVmOperand1.setText(resources.getString("txtVmOperand1.text")); // NOI18N
        txtVmOperand1.setName("txtVmOperand1"); // NOI18N
        
        rbtnVmOperand1Cmb = new javax.swing.JRadioButton();
        rbtnVmOperand1Cmb.setText(resources.getString("rbtnVmOperand1Cmb.text")); // NOI18N
        rbtnVmOperand1Cmb.setName("rbtnVmOperand1Cmb"); // NOI18N
        rbtnVmOperand1Cmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtnVmOperand1CmbItemStateChanged(evt);
            }
        });
        
        cmbVmOperand1 = new javax.swing.JComboBox();
        cmbVmOperand1.setEnabled(false);
        cmbVmOperand1.setName("cmbVmOperand1"); // NOI18N
        
        jLabel7 = new javax.swing.JLabel();
        jLabel7.setText(resources.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N
        jLabel8 = new javax.swing.JLabel();
        jLabel8.setText(resources.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N
        jLabel9 = new javax.swing.JLabel();
        jLabel9.setText(resources.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N
        
        btngVmOperand1 = new javax.swing.ButtonGroup();
        btngVmOperand2 = new javax.swing.ButtonGroup();
        btngVmOperand1.add(rbtnVmOperand1Txt);
        btngVmOperand1.add(rbtnVmOperand1Cmb);
        btngVmOperand2.add(rbtnVmOperand2Txt);
        btngVmOperand2.add(rbtnVmOperand2Cmb);

        pnlVmApproval = new javax.swing.JPanel();
        pnlVmApproval.setName("pnlVmApproval"); // NOI18N
        
        jLabel10 = new javax.swing.JLabel();
        jLabel10.setText(resources.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        jLabel16 = new javax.swing.JLabel();
        jLabel16.setText(resources.getString("jLabel16.text")); // NOI18N
        jLabel16.setName("jLabel16"); // NOI18N

        jLabel20 = new javax.swing.JLabel();
        jLabel20.setText(resources.getString("jLabel20.text")); // NOI18N
        jLabel20.setName("jLabel20"); // NOI18N
        
        lblVirtualMetricName = new javax.swing.JLabel();
//      lblVirtualMetricName.setFont(resourceMap.getFont("lblVirtualMetricName.font")); // NOI18N
        lblVirtualMetricName.setText(resources.getString("lblVirtualMetricName.text")); // NOI18N
        lblVirtualMetricName.setName("lblVirtualMetricName"); // NOI18N

        lblVirtualMetricEquation = new javax.swing.JLabel();
//      lblVirtualMetricEquation.setFont(resourceMap.getFont("lblVirtualMetricEquation.font")); // NOI18N
        lblVirtualMetricEquation.setText(resources.getString("lblVirtualMetricEquation.text")); // NOI18N
        lblVirtualMetricEquation.setName("lblVirtualMetricEquation"); // NOI18N
        
        javax.swing.GroupLayout pnlVmApprovalLayout = new javax.swing.GroupLayout(pnlVmApproval);
        pnlVmApproval.setLayout(pnlVmApprovalLayout);
        pnlVmApprovalLayout.setHorizontalGroup(
            pnlVmApprovalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVmApprovalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlVmApprovalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(pnlVmApprovalLayout.createSequentialGroup()
                        .addGroup(pnlVmApprovalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlVmApprovalLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20))
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlVmApprovalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVirtualMetricName, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                            .addComponent(lblVirtualMetricEquation, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlVmApprovalLayout.setVerticalGroup(
            pnlVmApprovalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVmApprovalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVmApprovalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblVirtualMetricName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(pnlVmApprovalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(lblVirtualMetricEquation, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        
        javax.swing.GroupLayout pnlVmSettingsLayout = new javax.swing.GroupLayout(pnlVmSettings);
        pnlVmSettings.setLayout(pnlVmSettingsLayout);
        pnlVmSettingsLayout.setHorizontalGroup(
            pnlVmSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVmSettingsLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlVmSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(lblVmOperand2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVmSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVmSettingsLayout.createSequentialGroup()
                        .addComponent(rbtnVmOperand2Txt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVmOperand2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnVmOperand2Cmb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbVmOperand2, 0, 167, Short.MAX_VALUE))
                    .addComponent(cmbVmMetricOperator, 0, 286, Short.MAX_VALUE)
                    .addComponent(txtVmMetricName, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addGroup(pnlVmSettingsLayout.createSequentialGroup()
                        .addComponent(rbtnVmOperand1Txt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVmOperand1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnVmOperand1Cmb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbVmOperand1, 0, 167, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlVmSettingsLayout.setVerticalGroup(
            pnlVmSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVmSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlVmSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtVmMetricName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVmSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbVmMetricOperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlVmSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVmSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9)
                        .addComponent(rbtnVmOperand1Txt)
                        .addGroup(pnlVmSettingsLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(pnlVmSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbVmOperand1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rbtnVmOperand1Cmb))))
                    .addComponent(txtVmOperand1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlVmSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rbtnVmOperand2Txt)
                    .addGroup(pnlVmSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtVmOperand2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlVmSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbVmOperand2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnVmOperand2Cmb)))
                    .addComponent(lblVmOperand2))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        pnlVmCardLayout.add(pnlVmSettings, "card3");
        pnlVmCardLayout.add(pnlVmApproval, "card2");
        
        pnlVmHeader = new javax.swing.JPanel();
        pnlVmHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlVmHeader.setName("pnlVmHeader"); // NOI18N

        jLabel19 = new javax.swing.JLabel();
//        jLabel19.setFont(resourceMap.getFont("jLabel19.font")); // NOI18N
        jLabel19.setText(resources.getString("jLabel19.text")); // NOI18N
        jLabel19.setName("jLabel19"); // NOI18N

        javax.swing.GroupLayout pnlVmHeaderLayout = new javax.swing.GroupLayout(pnlVmHeader);
        pnlVmHeader.setLayout(pnlVmHeaderLayout);
        pnlVmHeaderLayout.setHorizontalGroup(
            pnlVmHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVmHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(267, Short.MAX_VALUE))
        );
        pnlVmHeaderLayout.setVerticalGroup(
            pnlVmHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVmHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addContainerGap())
        );
        
        pnlVmButtons = new javax.swing.JPanel();
        pnlVmButtons.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlVmButtons.setName("pnlVmButtons"); // NOI18N
        
        btnVmBack = new javax.swing.JButton();
        btnVmBack.addActionListener(buttonExecutor);
        btnVmBack.setActionCommand("vitualMetricBack"); // NOI18N
        btnVmBack.setText(resources.getString("btnVmBack.text")); // NOI18N
        btnVmBack.setName("btnVmBack"); // NOI18N

        btnVmNext = new javax.swing.JButton();
        btnVmNext.addActionListener(buttonExecutor);
        btnVmNext.setActionCommand("virtualMetricWizardNext"); // NOI18N
        btnVmNext.setText(resources.getString("btnVmNext.text")); // NOI18N
        btnVmNext.setName("btnVmNext"); // NOI18N
        
        cancelVirtualMetricButton = new javax.swing.JButton();
        cancelVirtualMetricButton.addActionListener(buttonExecutor);
        cancelVirtualMetricButton.setActionCommand("closeVirtualMetricDialog"); // NOI18N
        cancelVirtualMetricButton.setText(resources.getString("cancelVirtualMetricButton.text")); // NOI18N
        cancelVirtualMetricButton.setName("cancelVirtualMetricButton"); // NOI18N
        
        javax.swing.GroupLayout pnlVmButtonsLayout = new javax.swing.GroupLayout(pnlVmButtons);
        pnlVmButtons.setLayout(pnlVmButtonsLayout);
        pnlVmButtonsLayout.setHorizontalGroup(
            pnlVmButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVmButtonsLayout.createSequentialGroup()
                .addContainerGap(181, Short.MAX_VALUE)
                .addComponent(btnVmBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVmNext)
                .addGap(26, 26, 26)
                .addComponent(cancelVirtualMetricButton)
                .addContainerGap())
        );
        pnlVmButtonsLayout.setVerticalGroup(
            pnlVmButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVmButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cancelVirtualMetricButton)
                .addComponent(btnVmNext)
                .addComponent(btnVmBack, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        
        javax.swing.GroupLayout virtualMetricWizardDialogLayout = new javax.swing.GroupLayout(virtualMetricWizardDialog.getContentPane());
        virtualMetricWizardDialog.getContentPane().setLayout(virtualMetricWizardDialogLayout);
        virtualMetricWizardDialogLayout.setHorizontalGroup(
            virtualMetricWizardDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(virtualMetricWizardDialogLayout.createSequentialGroup()
                .addGroup(virtualMetricWizardDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(virtualMetricWizardDialogLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(virtualMetricWizardDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlVmCardLayout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                            .addComponent(pnlVmHeader, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(virtualMetricWizardDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlVmButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        virtualMetricWizardDialogLayout.setVerticalGroup(
            virtualMetricWizardDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(virtualMetricWizardDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlVmHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlVmCardLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlVmButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
	}
	
	public void createThresholdDialog()
	{
        thresholdWizardDialog = new javax.swing.JDialog();
        thresholdWizardDialog.setTitle(resources.getString("thresholdWizardDialog.title")); // NOI18N
        thresholdWizardDialog.setAlwaysOnTop(true);
        thresholdWizardDialog.setName("thresholdWizardDialog"); // NOI18N
        thresholdWizardDialog.setResizable(false);
        
        pnlthresholdWizardMain = new javax.swing.JPanel();
        pnlthresholdWizardMain.setName("pnlthresholdWizardMain"); // NOI18N
        
        pnlThresholdSettingsCardLayout = new javax.swing.JPanel();
        pnlThresholdSettingsCardLayout.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlThresholdSettingsCardLayout.setName("pnlThresholdSettingsCardLayout"); // NOI18N
        pnlThresholdSettingsCardLayout.setLayout(new java.awt.CardLayout());
        
        pnlThresholdSettings = new javax.swing.JPanel();
        pnlThresholdSettings.setName("pnlThresholdSettings"); // NOI18N
        jLabel12 = new javax.swing.JLabel();
        jLabel12.setText(resources.getString("jLabel12.text")); // NOI18N
        jLabel12.setName("jLabel12"); // NOI18N

        jLabel13 = new javax.swing.JLabel();
        jLabel13.setText(resources.getString("jLabel13.text")); // NOI18N
        jLabel13.setName("jLabel13"); // NOI18N

        jLabel14 = new javax.swing.JLabel();
        jLabel14.setText(resources.getString("jLabel14.text")); // NOI18N
        jLabel14.setName("jLabel14"); // NOI18N

        jLabel15 = new javax.swing.JLabel();
        jLabel15.setText(resources.getString("jLabel15.text")); // NOI18N
        jLabel15.setName("jLabel15"); // NOI18N
        
        lblThresholdOperand2 = new javax.swing.JLabel();
        lblThresholdOperand2.setText(resources.getString("lblThresholdOperand2.text")); // NOI18N
        lblThresholdOperand2.setName("lblThresholdOperand2"); // NOI18N

        cmbThresholdOperator = new javax.swing.JComboBox();
        cmbThresholdOperator.setName("cmbThresholdOperator"); // NOI18N
        cmbThresholdOperator.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbThresholdOperatorItemStateChanged(evt);
            }
        });

        cmbThresholdMetricList = new javax.swing.JComboBox();
        cmbThresholdMetricList.setToolTipText(resources.getString("cmbThresholdMetricList.toolTipText")); // NOI18N
        cmbThresholdMetricList.setName("cmbThresholdMetricList"); // NOI18N
        
        cmbRiskLevels = new javax.swing.JComboBox();
        cmbRiskLevels.setName("cmbRiskLevels"); // NOI18N
        
        rbtnThresholdOperatorOneTxt = new javax.swing.JRadioButton();
        rbtnThresholdOperatorOneTxt.setSelected(true);
        rbtnThresholdOperatorOneTxt.setText(resources.getString("rbtnThresholdOperatorOneTxt.text")); // NOI18N
        rbtnThresholdOperatorOneTxt.setName("rbtnThresholdOperatorOneTxt"); // NOI18N
        rbtnThresholdOperatorOneTxt.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbtnThresholdOperatorOneTxtStateChanged(evt);
            }
        });
        
        txtThresholdOperator1 = new javax.swing.JTextField();
        txtThresholdOperator1.setText(resources.getString("txtThresholdOperator1.text")); // NOI18N
        txtThresholdOperator1.setName("txtThresholdOperator1"); // NOI18N
        
        rbtnThresholdOperator1Cmb = new javax.swing.JRadioButton();
        rbtnThresholdOperator1Cmb.setText(resources.getString("rbtnThresholdOperator1Cmb.text")); // NOI18N
        rbtnThresholdOperator1Cmb.setName("rbtnThresholdOperator1Cmb"); // NOI18N
        
        rbtnThresholdOperator2Txt = new javax.swing.JRadioButton();
        rbtnThresholdOperator2Txt.setSelected(true);
        rbtnThresholdOperator2Txt.setName("rbtnThresholdOperator2Txt"); // NOI18N
        rbtnThresholdOperator2Txt.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbtnThresholdOperator2TxtStateChanged(evt);
            }
        });
        
        txtThresholdOperator2 = new javax.swing.JTextField();
        txtThresholdOperator2.setName("txtThresholdOperator2"); // NOI18N
        
        rbtnThresholdOperator2Cmb = new javax.swing.JRadioButton();
        rbtnThresholdOperator2Cmb.setName("rbtnThresholdOperator2Cmb"); // NOI18N
        
        cmbThresholdOperator1 = new javax.swing.JComboBox();
        cmbThresholdOperator1.setEnabled(false);
        cmbThresholdOperator1.setName("cmbThresholdOperator1"); // NOI18N

        cmbThresholdOperator2 = new javax.swing.JComboBox();
        cmbThresholdOperator2.setEnabled(false);
        cmbThresholdOperator2.setName("cmbThresholdOperator2"); // NOI18N

        btngFirstOperand = new javax.swing.ButtonGroup();
        btngFirstOperand.add(rbtnThresholdOperatorOneTxt);
        btngFirstOperand.add(rbtnThresholdOperator1Cmb);
        btngSecondOperand = new javax.swing.ButtonGroup();
        btngSecondOperand.add(rbtnThresholdOperator2Txt);
        btngSecondOperand.add(rbtnThresholdOperator2Cmb);

        javax.swing.GroupLayout pnlThresholdSettingsLayout = new javax.swing.GroupLayout(pnlThresholdSettings);
        pnlThresholdSettings.setLayout(pnlThresholdSettingsLayout);
        pnlThresholdSettingsLayout.setHorizontalGroup(
            pnlThresholdSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThresholdSettingsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlThresholdSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(lblThresholdOperand2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThresholdSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbThresholdOperator, 0, 263, Short.MAX_VALUE)
                    .addComponent(cmbThresholdMetricList, 0, 263, Short.MAX_VALUE)
                    .addComponent(cmbRiskLevels, 0, 263, Short.MAX_VALUE)
                    .addGroup(pnlThresholdSettingsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlThresholdSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlThresholdSettingsLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnThresholdOperatorOneTxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtThresholdOperator1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtnThresholdOperator1Cmb))
                            .addGroup(pnlThresholdSettingsLayout.createSequentialGroup()
                                .addComponent(rbtnThresholdOperator2Txt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtThresholdOperator2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtnThresholdOperator2Cmb)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlThresholdSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbThresholdOperator1, 0, 148, Short.MAX_VALUE)
                            .addComponent(cmbThresholdOperator2, 0, 148, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlThresholdSettingsLayout.setVerticalGroup(
            pnlThresholdSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThresholdSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThresholdSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cmbRiskLevels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThresholdSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cmbThresholdMetricList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pnlThresholdSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cmbThresholdOperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThresholdSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlThresholdSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlThresholdSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rbtnThresholdOperatorOneTxt)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlThresholdSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rbtnThresholdOperator1Cmb)
                            .addComponent(txtThresholdOperator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cmbThresholdOperator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlThresholdSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThresholdSettingsLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(pnlThresholdSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnThresholdOperator2Txt)
                            .addGroup(pnlThresholdSettingsLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlThresholdSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtThresholdOperator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlThresholdSettingsLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(pnlThresholdSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbThresholdOperator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rbtnThresholdOperator2Cmb)))))))
                    .addGroup(pnlThresholdSettingsLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblThresholdOperand2)))
                .addGap(11, 11, 11))
        );
        
        pnlThresholdSettingsCardLayout.add(pnlThresholdSettings, "card2");
        
        
        pnlThresholdApprove = new javax.swing.JPanel();
        pnlThresholdApprove.setName("pnlThresholdApprove"); // NOI18N
        
        lblThresholdExpression = new javax.swing.JLabel();
        lblThresholdExpression.setFont(GUIUtilities.getResourceFont(resources, "lblThresholdExpression.font")); // NOI18N
        lblThresholdExpression.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThresholdExpression.setText(resources.getString("lblThresholdExpression.text")); // NOI18N
        lblThresholdExpression.setName("lblThresholdExpression"); // NOI18N

        lblThresholdRiskLevel = new javax.swing.JLabel();
        lblThresholdRiskLevel.setFont(GUIUtilities.getResourceFont(resources, "lblThresholdRiskLevel.font")); // NOI18N
        lblThresholdRiskLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThresholdRiskLevel.setText(resources.getString("lblThresholdRiskLevel.text")); // NOI18N
        lblThresholdRiskLevel.setName("lblThresholdRiskLevel"); // NOI18N

        jLabel18 = new javax.swing.JLabel();
        jLabel18.setText(resources.getString("jLabel18.text")); // NOI18N
        jLabel18.setName("jLabel18"); // NOI18N

        javax.swing.GroupLayout pnlThresholdApproveLayout = new javax.swing.GroupLayout(pnlThresholdApprove);
        pnlThresholdApprove.setLayout(pnlThresholdApproveLayout);
        pnlThresholdApproveLayout.setHorizontalGroup(
            pnlThresholdApproveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThresholdApproveLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThresholdApproveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblThresholdExpression, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addComponent(lblThresholdRiskLevel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        pnlThresholdApproveLayout.setVerticalGroup(
            pnlThresholdApproveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThresholdApproveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblThresholdRiskLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblThresholdExpression, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        pnlThresholdSettingsCardLayout.add(pnlThresholdApprove, "card3");
        
        pnlThresholdWizardHeader = new javax.swing.JPanel();
        pnlThresholdWizardHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlThresholdWizardHeader.setName("pnlThresholdWizardHeader"); // NOI18N

        jLabel17 = new javax.swing.JLabel();
        jLabel17.setFont(GUIUtilities.getResourceFont(resources, "jLabel17.font")); // NOI18N
        jLabel17.setText(resources.getString("jLabel17.text")); // NOI18N
        jLabel17.setName("jLabel17"); // NOI18N

        javax.swing.GroupLayout pnlThresholdWizardHeaderLayout = new javax.swing.GroupLayout(pnlThresholdWizardHeader);
        pnlThresholdWizardHeader.setLayout(pnlThresholdWizardHeaderLayout);
        pnlThresholdWizardHeaderLayout.setHorizontalGroup(
            pnlThresholdWizardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThresholdWizardHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addContainerGap(215, Short.MAX_VALUE))
        );
        pnlThresholdWizardHeaderLayout.setVerticalGroup(
            pnlThresholdWizardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThresholdWizardHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addContainerGap())
        );
        
        pnlThresholdWizardButtons = new javax.swing.JPanel();
        pnlThresholdWizardButtons.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlThresholdWizardButtons.setName("pnlThresholdWizardButtons"); // NOI18N
        
        btnThresholdWizardBack = new javax.swing.JButton();
        btnThresholdWizardBack.addActionListener(buttonExecutor);
        btnThresholdWizardBack.setActionCommand("thresholdWizardBackButton"); // NOI18N
        btnThresholdWizardBack.setText(resources.getString("btnThresholdWizardBack.text")); // NOI18N
        btnThresholdWizardBack.setName("btnThresholdWizardBack"); // NOI18N

        btnThresholdWizardNext = new javax.swing.JButton();
        btnThresholdWizardNext.addActionListener(buttonExecutor);
        btnThresholdWizardNext.setActionCommand("thresholdWizardNextButton"); // NOI18N
        btnThresholdWizardNext.setText(resources.getString("btnThresholdWizardNext.text")); // NOI18N
        btnThresholdWizardNext.setName("btnThresholdWizardNext"); // NOI18N

        btnThresholdWizardCancel = new javax.swing.JButton();
        btnThresholdWizardCancel.addActionListener(buttonExecutor);
        btnThresholdWizardCancel.setActionCommand("closeThresholdWizardDialog"); // NOI18N
        btnThresholdWizardCancel.setText(resources.getString("btnThresholdWizardCancel.text")); // NOI18N
        btnThresholdWizardCancel.setName("btnThresholdWizardCancel"); // NOI18N
        
        javax.swing.GroupLayout pnlThresholdWizardButtonsLayout = new javax.swing.GroupLayout(pnlThresholdWizardButtons);
        pnlThresholdWizardButtons.setLayout(pnlThresholdWizardButtonsLayout);
        pnlThresholdWizardButtonsLayout.setHorizontalGroup(
            pnlThresholdWizardButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThresholdWizardButtonsLayout.createSequentialGroup()
                .addContainerGap(177, Short.MAX_VALUE)
                .addComponent(btnThresholdWizardBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThresholdWizardNext)
                .addGap(18, 18, 18)
                .addComponent(btnThresholdWizardCancel)
                .addContainerGap())
        );
        pnlThresholdWizardButtonsLayout.setVerticalGroup(
            pnlThresholdWizardButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThresholdWizardButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnThresholdWizardCancel)
                .addComponent(btnThresholdWizardNext)
                .addComponent(btnThresholdWizardBack))
        );
        
        javax.swing.GroupLayout pnlthresholdWizardMainLayout = new javax.swing.GroupLayout(pnlthresholdWizardMain);
        pnlthresholdWizardMain.setLayout(pnlthresholdWizardMainLayout);
        pnlthresholdWizardMainLayout.setHorizontalGroup(
            pnlthresholdWizardMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlthresholdWizardMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlthresholdWizardMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlThresholdSettingsCardLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlThresholdWizardHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlThresholdWizardButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlthresholdWizardMainLayout.setVerticalGroup(
            pnlthresholdWizardMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlthresholdWizardMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlThresholdWizardHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnlThresholdSettingsCardLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlThresholdWizardButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        javax.swing.GroupLayout thresholdWizardDialogLayout = new javax.swing.GroupLayout(thresholdWizardDialog.getContentPane());
        thresholdWizardDialog.getContentPane().setLayout(thresholdWizardDialogLayout);
        thresholdWizardDialogLayout.setHorizontalGroup(
            thresholdWizardDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlthresholdWizardMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        thresholdWizardDialogLayout.setVerticalGroup(
            thresholdWizardDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlthresholdWizardMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
	}
	
	private void createFilterDialog()
	{
        filterWizardDialog = new javax.swing.JDialog();
        filterWizardDialog.setTitle(resources.getString("filterWizardDialog.title")); // NOI18N
        filterWizardDialog.setModal(true);
        filterWizardDialog.setName("filterWizardDialog"); // NOI18N
        filterWizardDialog.setResizable(false);
        
        pnlFilterButtons = new javax.swing.JPanel();
        pnlFilterButtons.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlFilterButtons.setName("pnlFilterButtons"); // NOI18N

        btnApplyFilter = new javax.swing.JButton();
        btnApplyFilter.addActionListener(buttonExecutor);
        btnApplyFilter.setActionCommand("filterWizardApplyButton"); // NOI18N
        btnApplyFilter.setText(resources.getString("btnApplyFilter.text")); // NOI18N
        btnApplyFilter.setName("btnApplyFilter"); // NOI18N
        
        btnCancelFilter = new javax.swing.JButton();
        btnCancelFilter.addActionListener(buttonExecutor);
        btnCancelFilter.setActionCommand("filterWizardCancelButton"); // NOI18N
        btnCancelFilter.setText(resources.getString("btnCancelFilter.text")); // NOI18N
        btnCancelFilter.setName("btnCancelFilter"); // NOI18N
        
        javax.swing.GroupLayout pnlFilterButtonsLayout = new javax.swing.GroupLayout(pnlFilterButtons);
        pnlFilterButtons.setLayout(pnlFilterButtonsLayout);
        pnlFilterButtonsLayout.setHorizontalGroup(
            pnlFilterButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFilterButtonsLayout.createSequentialGroup()
                .addContainerGap(235, Short.MAX_VALUE)
                .addComponent(btnApplyFilter)
                .addGap(18, 18, 18)
                .addComponent(btnCancelFilter)
                .addGap(11, 11, 11))
        );
        pnlFilterButtonsLayout.setVerticalGroup(
            pnlFilterButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilterButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnCancelFilter)
                .addComponent(btnApplyFilter))
        );
        
        pnlFilterMain = new javax.swing.JPanel();
        pnlFilterMain.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlFilterMain.setName("pnlFilterMain"); // NOI18N
        
        jLabel22 = new javax.swing.JLabel();
        jLabel22.setText(resources.getString("jLabel22.text")); // NOI18N
        jLabel22.setName("jLabel22"); // NOI18N

        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane2.setName("jScrollPane2"); // NOI18N

        listAllMetrics = new javax.swing.JList();
        listAllMetrics.setName("listAllMetrics"); // NOI18N
        listAllMetrics.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listAllMetricsValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listAllMetrics);

        btnTransferToFilter = new javax.swing.JButton();
        btnTransferToFilter.addActionListener(buttonExecutor);
        btnTransferToFilter.setActionCommand("transferHeadersToFilter"); // NOI18N
        btnTransferToFilter.setText(resources.getString("btnTransferToFilter.text")); // NOI18N
        btnTransferToFilter.setName("btnTransferToFilter"); // NOI18N
        
        btnTransferAllToFilter = new javax.swing.JButton();
        btnTransferAllToFilter.addActionListener(buttonExecutor);
        btnTransferAllToFilter.setActionCommand("transferAllHeadersToFilter"); // NOI18N
        btnTransferAllToFilter.setText(resources.getString("btnTransferAllToFilter.text")); // NOI18N
        btnTransferAllToFilter.setName("btnTransferAllToFilter"); // NOI18N
        
        btnTransferLeft = new javax.swing.JButton();
        btnTransferLeft.addActionListener(buttonExecutor);
        btnTransferLeft.setActionCommand("transferHeadersToLeft"); // NOI18N
        btnTransferLeft.setText(resources.getString("btnTransferLeft.text")); // NOI18N
        btnTransferLeft.setName("btnTransferLeft"); // NOI18N
        
        btnTransferAllToLeft = new javax.swing.JButton();
        btnTransferAllToLeft.addActionListener(buttonExecutor);
        btnTransferAllToLeft.setActionCommand("transferAllHeadersToLeft"); // NOI18N
        btnTransferAllToLeft.setText(resources.getString("btnTransferAllToLeft.text")); // NOI18N
        btnTransferAllToLeft.setName("btnTransferAllToLeft"); // NOI18N
        
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane3.setName("jScrollPane3"); // NOI18N
        listFilterMetrics = new javax.swing.JList();
        listFilterMetrics.setName("listFilterMetrics"); // NOI18N
        listFilterMetrics.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listFilterMetricsValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listFilterMetrics);
        
        javax.swing.GroupLayout pnlFilterMainLayout = new javax.swing.GroupLayout(pnlFilterMain);
        pnlFilterMain.setLayout(pnlFilterMainLayout);
        pnlFilterMainLayout.setHorizontalGroup(
            pnlFilterMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilterMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFilterMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFilterMainLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                        .addGroup(pnlFilterMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFilterMainLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(btnTransferToFilter, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                            .addGroup(pnlFilterMainLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlFilterMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTransferAllToFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnTransferLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                                    .addComponent(btnTransferAllToLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlFilterMainLayout.setVerticalGroup(
            pnlFilterMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilterMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFilterMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addGroup(pnlFilterMainLayout.createSequentialGroup()
                        .addComponent(btnTransferToFilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTransferLeft)
                        .addGap(26, 26, 26)
                        .addComponent(btnTransferAllToFilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTransferAllToLeft)))
                .addContainerGap())
        );
        
        pnlFilterHeader = new javax.swing.JPanel();
        pnlFilterHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlFilterHeader.setName("pnlFilterHeader"); // NOI18N

        jLabel21 = new javax.swing.JLabel();
        jLabel21.setFont(GUIUtilities.getResourceFont(resources, "jLabel21.font")); // NOI18N
        jLabel21.setText(resources.getString("jLabel21.text")); // NOI18N
        jLabel21.setName("jLabel21"); // NOI18N

        javax.swing.GroupLayout pnlFilterHeaderLayout = new javax.swing.GroupLayout(pnlFilterHeader);
        pnlFilterHeader.setLayout(pnlFilterHeaderLayout);
        pnlFilterHeaderLayout.setHorizontalGroup(
            pnlFilterHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilterHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(258, Short.MAX_VALUE))
        );
        pnlFilterHeaderLayout.setVerticalGroup(
            pnlFilterHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFilterHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addContainerGap())
        );
        
        javax.swing.GroupLayout filterWizardDialogLayout = new javax.swing.GroupLayout(filterWizardDialog.getContentPane());
        filterWizardDialog.getContentPane().setLayout(filterWizardDialogLayout);
        filterWizardDialogLayout.setHorizontalGroup(
            filterWizardDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterWizardDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filterWizardDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFilterButtons, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFilterMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFilterHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        filterWizardDialogLayout.setVerticalGroup(
            filterWizardDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterWizardDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFilterHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFilterMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFilterButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
	}
	
	private void jComboBoxChooseAlgorithmItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxChooseAlgorithmItemStateChanged
        wekaAlgorithmType = jComboBoxChooseAlgorithm.getItemAt(jComboBoxChooseAlgorithm.getSelectedIndex()).toString();
    }//GEN-LAST:event_jComboBoxChooseAlgorithmItemStateChanged

	// <editor-fold defaultstate="collapsed" desc="Actions">

	public void switchWorkspace() {
		File repositoryFile = PrestGuiApp.getProjectDirectoryFromUser();
		if (repositoryFile != null) {
			ApplicationProperties.set("repositorylocation", repositoryFile
					.getAbsolutePath());
			ApplicationProperties.reCreatePropertiesFile(repositoryFile.getAbsolutePath().toString() + repositoryFile.separator.toString());
			JOptionPane
					.showMessageDialog(
							analysisResultsPanel,
							"Changes will not be effective until you restart the tool!",
							"Switch Workspace", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void switchView()
	{
		if (analysisResultsPanel.isVisible())
		{
			analysisResultsPanel.setVisible(false);
			predictionPanel.setVisible(true);
		}
		else {
				analysisResultsPanel.setVisible(true);
				predictionPanel.setVisible(false);
		}
		
		mainPanel.validate();
	}
	
	public void switchMetricView(int id)
	{
		for (int i = 0; i < metricsPanels.length; i++)
			metricsPanels[i].setVisible(id == i);
		resultsDataPanel.validate();
	}
	
	private void doAddProject()
	{
		packageExplorer.addNewProject();
	}

	private void doDeleteProject()
	{
		packageExplorer.deleteProject();
	}
	
	private void doParseProject()
	{
		packageExplorer.parseProject();
	}
	
	private void doTableTransfer()
	{
		packageExplorer.transferResults();
	}
	
	private void doCVS2Arff()
	{
		packageExplorer.convertCsvToArff();
	}
	
	private void rbtnSuppliedTestSetActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:
		// event_rbtnSuppliedTestSetActionPerformed
		disableAllUnnecessaryForCategorizer();
		// btnTestSet.setEnabled(true);
	}


	private void updateCategorizerList() {

		//listCategorizers.removeAll();

		Vector<Categorizer> catList = categorizerExecutor.getCategorizers();
		List<String> itemList = new ArrayList<String>();
		if (catList != null) {

			int size = catList.size();

			for (int i = 0; i < size; i++) {
				itemList.add("Categorizer_" + (i + 1));
			}

			//listCategorizers.setListData(itemList.toArray());
		}
	}

	private void cmbMetricGroupsItemStateChanged(java.awt.event.ItemEvent evt) {// GEN
		// -
		// FIRST
		// :
		// event_cmbMetricGroupsItemStateChanged
		if (evt.getStateChange() == ItemEvent.SELECTED) {
			CardLayout cards = (CardLayout) (metricsCardLayoutPanel.getLayout());

			if (cmbMetricGroups.getSelectedItem().equals("File Metrics"))
				cards.show(metricsCardLayoutPanel, "card2");
			else if (cmbMetricGroups.getSelectedItem()
					.equals("Package Metrics"))
				cards.show(metricsCardLayoutPanel, "card3");
			else if (cmbMetricGroups.getSelectedItem().equals("Method Metrics"))
				cards.show(metricsCardLayoutPanel, "card4");
			else
				cards.show(metricsCardLayoutPanel, "card5");
		}

	}// GEN-LAST:event_cmbMetricGroupsItemStateChanged

	private void rbtnVmOperand1CmbItemStateChanged(java.awt.event.ItemEvent evt) {// GEN
		// -
		// FIRST
		// :
		// event_rbtnVmOperand1CmbItemStateChanged
		if (evt.getStateChange() == ItemEvent.SELECTED) {
			if (rbtnVmOperand1Cmb.isSelected())
				cmbVmOperand1.setEnabled(true);
			else
				txtVmOperand1.setEnabled(true);
		}
	}// GEN-LAST:event_rbtnVmOperand1CmbItemStateChanged

	private void rbtnVmOperand2CmbItemStateChanged(java.awt.event.ItemEvent evt) {// GEN
		// -
		// FIRST
		// :
		// event_rbtnVmOperand2CmbItemStateChanged
		if (evt.getStateChange() == ItemEvent.SELECTED) {
			if (rbtnVmOperand2Cmb.isSelected())
				cmbVmOperand2.setEnabled(true);
			else
				txtVmOperand2.setEnabled(true);
		}
	}// GEN-LAST:event_rbtnVmOperand2CmbItemStateChanged

	private void cmbVmMetricOperatorItemStateChanged(
			java.awt.event.ItemEvent evt) {// GEN-FIRST:
		// event_cmbVmMetricOperatorItemStateChanged
		virtualMetricOperand2Visibility();

			}// GEN-LAST:event_cmbVmMetricOperatorItemStateChanged

	private void rbtnThresholdOperatorOneTxtStateChanged(
			javax.swing.event.ChangeEvent evt) {// GEN-FIRST:
		// event_rbtnThresholdOperatorOneTxtStateChanged
		if (((JRadioButton) evt.getSource()).isSelected()) {
			txtThresholdOperator1.setEnabled(true);
			cmbThresholdOperator1.setEnabled(false);
		} else {
			txtThresholdOperator1.setEnabled(false);
			cmbThresholdOperator1.setEnabled(true);
		}
	}// GEN-LAST:event_rbtnThresholdOperatorOneTxtStateChanged

	private void rbtnThresholdOperator2TxtStateChanged(
			javax.swing.event.ChangeEvent evt) {// GEN-FIRST:
		// event_rbtnThresholdOperator2TxtStateChanged
		if (((JRadioButton) evt.getSource()).isSelected()) {
			txtThresholdOperator2.setEnabled(true);
			cmbThresholdOperator2.setEnabled(false);
		} else {
			txtThresholdOperator2.setEnabled(false);
			cmbThresholdOperator2.setEnabled(true);
		}
	}// GEN-LAST:event_rbtnThresholdOperator2TxtStateChanged

	private void rbtnVmOperand1TxtStateChanged(javax.swing.event.ChangeEvent evt) {// GEN
		// -
		// FIRST
		// :
		// event_rbtnVmOperand1TxtStateChanged
		if (((JRadioButton) evt.getSource()).isSelected()) {
			txtVmOperand1.setEnabled(true);
			cmbVmOperand1.setEnabled(false);

		} else {
			txtVmOperand1.setEnabled(false);
			cmbVmOperand1.setEnabled(true);
		}
	}// GEN-LAST:event_rbtnVmOperand1TxtStateChanged

	private void rbtnVmOperand2TxtStateChanged(javax.swing.event.ChangeEvent evt) {// GEN
		// -
		// FIRST
		// :
		// event_rbtnVmOperand2TxtStateChanged
		if (((JRadioButton) evt.getSource()).isSelected()) {
			txtVmOperand2.setEnabled(true);
			cmbVmOperand2.setEnabled(false);
		} else {
			txtVmOperand2.setEnabled(false);
			cmbVmOperand2.setEnabled(true);
		}
	}// GEN-LAST:event_rbtnVmOperand2TxtStateChanged

	private void cmbThresholdOperatorItemStateChanged(
			java.awt.event.ItemEvent evt) {// GEN-FIRST:
		// event_cmbThresholdOperatorItemStateChanged
		thresholdOperand2Visibility();
	}// GEN-LAST:event_cmbThresholdOperatorItemStateChanged

	private void listAllMetricsValueChanged(
			javax.swing.event.ListSelectionEvent evt) {// GEN-FIRST:
		// event_listAllMetricsValueChanged
		if (evt.getValueIsAdjusting() == false) {
			if (listAllMetrics.getSelectedIndex() == -1) {
				btnTransferToFilter.setEnabled(false);

			} else {
				btnTransferToFilter.setEnabled(true);
			}

			if (listAllMetrics.getComponentCount() == 0)
				btnTransferAllToFilter.setEnabled(false);
			else
				btnTransferAllToFilter.setEnabled(true);
		}
	}// GEN-LAST:event_listAllMetricsValueChanged

	private void listFilterMetricsValueChanged(
			javax.swing.event.ListSelectionEvent evt) {// GEN-FIRST:
		// event_listFilterMetricsValueChanged
		if (evt.getValueIsAdjusting() == false) {
			if (listFilterMetrics.getSelectedIndex() == -1) {
				btnTransferLeft.setEnabled(false);
			} else {
				btnTransferLeft.setEnabled(true);
			}

			if (listFilterMetrics.getComponentCount() == 0)
				btnTransferAllToLeft.setEnabled(false);
			else
				btnTransferAllToLeft.setEnabled(true);
		}
	}// GEN-LAST:event_listFilterMetricsValueChanged

	public void showAboutBox() {
		if (aboutBox == null) 
		{
			aboutBox = new PrestGuiAboutBox(this);
			aboutBox.setLocationRelativeTo(this);
		}
		
		aboutBox.setVisible(true);
	}

	public void openDataFile() {
		JFileChooser fileChooser = new JFileChooser();
		File currentDirectory;
		try {
			currentDirectory = new File(ApplicationProperties
					.get("repositorylocation"));

			if (currentDirectory != null) {
				fileChooser.setCurrentDirectory(currentDirectory);
				fileChooser.setDialogTitle("Select arff file");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				ExtensionFileFilter fileFilter = new ExtensionFileFilter(
						"arff files only", "ARFF");
				fileChooser.setFileFilter(fileFilter);
				int returnVal = fileChooser.showOpenDialog(null);

				File dir = null;

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					dir = fileChooser.getSelectedFile();
				}
				try {
					Arff2DataSet arff2DataSet = new Arff2DataSet(dir
							.getAbsolutePath());
					arffDataSet = arff2DataSet.reader();
					packageExplorer.displayMetrics(pnlDataFile, arffDataSet);
					CardLayout cards = (CardLayout) (pnlDataCardLayout
							.getLayout());
					cards.show(pnlDataCardLayout, "card3");
					Components.dataFileActive = true;

				} catch (Exception ex) {
					Logger.getLogger(PrestGuiView.class.getName()).log(
							Level.SEVERE, null, ex);
				} 
			} 
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null,
					"Please select a project first!", "Select Project",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	public DataSet openDataSetFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Select arff file");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		ExtensionFileFilter fileFilter = new ExtensionFileFilter(
				"arff files only", "ARFF");
		fileChooser.setFileFilter(fileFilter);
		int returnVal = fileChooser.showOpenDialog(null);
		DataSet newDataSet = null;
		File dir = null;
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			dir = fileChooser.getSelectedFile();
		}
		try {
			Arff2DataSet arff2DataSet = new Arff2DataSet(dir.getAbsolutePath());
			newDataSet = arff2DataSet.reader();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(PrestGuiView.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (Exception e) {
			System.out.println(" **** ex " + e.getMessage());
			e.printStackTrace();
		}
		return newDataSet;
	}

	public void defineThreshold() {
		if (packageExplorer.isResultsTransferred()) {
			thresholdWizardFillComboBoxes();
			thresholdWizardDialog.pack();
			centerDialog(thresholdWizardDialog);
			thresholdWizardDialog.setVisible(true);
		} else
			JOptionPane.showMessageDialog(null,
					"Please select a project to add threshold",
					"Select Project", JOptionPane.ERROR_MESSAGE);
	}

	public void defineVirtualMetric() {
		if (packageExplorer.isResultsTransferred()) {
			virtualMetricWizardFillComboBoxes();
			virtualMetricWizardDialog.pack();
			centerDialog(virtualMetricWizardDialog);
			virtualMetricWizardDialog.setVisible(true);
		} else
			JOptionPane.showMessageDialog(null,
					"Please select a project to add threshold",
					"Select Project", JOptionPane.ERROR_MESSAGE);
	}

	private void centerDialog(JDialog dlg)
	{
		Dimension sDim = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (sDim.width - dlg.getWidth()) / 2;
		int y = (sDim.height - dlg.getHeight()) / 2;
		dlg.setLocation(new Point(x, y));
	}
	
	public class ThresholdActionAdapter implements ActionListener {

		private int column;

		public ThresholdActionAdapter(int column) {
			super();
			this.column = column;
		}

		public void actionPerformed(ActionEvent e) {
			int selectedMetricGroup = Components.getSelectedMetricGroupIndex();
			DataSet ds = null;
			ds = ParserExecutor.getDataSetByMetricGroup(selectedMetricGroup,
					ParserExecutor.getCurrentLanguage(),
					Components.dataFileActive);
			DataHeader dataHeader = ds.getDataHeaders()[column - 1];
			// defineThreshold(dataHeader.getLabel());
		}
	}

	// </editor-fold>

	/**
	 * Disables all unnecessary categorizer build fields
	 */
	private void disableAllUnnecessaryForCategorizer() {
		List<JComponent> componentList = new ArrayList<JComponent>();


		ComponentState.setEnabledDisabled(componentList, false);
	}

	public void setStaticComponents() {
		ParserExecutor.setMainPanel(this.mainPanel);
		Components.packageMetricsDataSetPanel = this.packageMetricsDataSetPanel;
		Components.fileMetricsDataSetPanel = this.fileMetricsDataSetPanel;
		Components.classMetricsDataSetPanel = this.classMetricsDataSetPanel;
		Components.methodMetricsDataSetPanel = this.methodMetricsDataSetPanel;
		Components.mbMetricGroups = this.metricsMenuButton;
//		Components.languageRadioButtonGroupPanel = this.pnlLanguageRadioPanel;
		Components.languageButtonGroup = this.btngLanguageGroup;
		Components.classMetricsThresholdPanel = this.classMetricsThresholdPanel;
		Components.fileMetricsThresholdPanel = this.fileMetricsThresholdPanel;
		Components.methodMetricsThresholdPanel = this.methodMetricsThresholdPanel;
		Components.packageMetricsThresholdPanel = this.methodMetricsThresholdPanel;
		Components.analysisToolBar = analysisToolbar;
		Components.languageSet = null;
		Components.categorizerActive = false;
		Components.resultsDataPanel = this.resultsDataPanel;
//		Components.pnlCategorizeButtons = this.pnlCategorizeButtons;
//		Components.btnCategorize = this.btnCategorize;
//		Components.btnLoadCategorizer = this.btnLoadCategorizer;
//		Components.btnStoreCategorizer = this.btnStoreCategorizer;
	}

	private DataSet activeDataSet() {
		int selectedMetricType = metricsMenuButton.getActionIndex();
		// TODO: RADIO BUTTON'DAN ALMA OLAYINI YAP
		Language lang = Language.JAVA;// radioButtondan alinacak
		return ParserExecutor.getDataSetByMetricGroup(selectedMetricType, lang,
				Components.dataFileActive);
	}

	private JPanel activeDataSetPanel() {
		switch (metricsMenuButton.getActionIndex()) 
		{
			case 0:
				return packageMetricsDataSetPanel;
			case 1:
				return fileMetricsDataSetPanel;
			case 2:
				return classMetricsDataSetPanel;
			case 3:
				return methodMetricsDataSetPanel;
			default:
				return null;
		}
	}

	private JPanel activeThresholdPanel() {
		switch (metricsMenuButton.getActionIndex()) 
		{
			case 0:
				return packageMetricsThresholdPanel;
			case 1:
				return fileMetricsThresholdPanel;
			case 2:
				return classMetricsThresholdPanel;
			case 3:
				return methodMetricsThresholdPanel;
			default:
				return null;
		}
	}

	private JTabbedPane activeTabbedPane() {
		switch (metricsMenuButton.getActionIndex()) 
		{
			case 0:
				return packageMetricsTabbedPane;
			case 1:
				return fileMetricsTabbedPane;
			case 2:
				return classMetricsTabbedPane;
			case 3:
				return methodMetricsTabbedPane;
			default:
				return null;
		}
	}

	public File getCategorizerDirectoryFromUser() {
		File currentDirectory = new File(ApplicationProperties
				.get("repositorylocation")
				+ File.separator + packageExplorer.getProjectDirectory().getName());
		JFileChooser fileChooser = new JFileChooser(currentDirectory);
		fileChooser.setDialogTitle("Select folder for repository");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnVal = fileChooser.showOpenDialog(null);

		File dir = null;
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			dir = fileChooser.getSelectedFile();
		}
		return dir;
	}

	public void loadCategorizer() {
		try {
			File file = getCategorizerDirectoryFromUser();
			DataContext storedContext = DataContext.readFromFile(file
					.getAbsolutePath());
			if (storedContext != null) {
				for (int i = 0; i < 4; i++) {
					String selectedMetric = metricsMenuButton.getActionText(i);
					selectedMetric = selectedMetric.replace(" ", "");
					DataContext relatedPart = storedContext
							.getNode(selectedMetric);
					if (relatedPart != null) {
						staticCategorizer = new StaticCategorizer();
						staticCategorizer.load(relatedPart);
						staticCategorizer.getDataSet().setDataItems(
								activeDataSet().getDataItems());
						ParserExecutor.setDataSetByMetricGroup(i,
								ParserExecutor.getCurrentLanguage(),
								staticCategorizer.getDataSet());
						staticCategorizer.buildCategorizer();
						analysisToolbar.setMenuButtonSelection(metricsMenuButton, i, okMark);
						switchMetricView(i);
						JOptionPane.showMessageDialog(dataSplitPanel,
								"Categorizer loaded successfully!",
								"Load Result", JOptionPane.INFORMATION_MESSAGE);
						packageExplorer.displayMetrics(activeDataSetPanel(), activeDataSet());
//						JTabbedPane jTabbedPane = (JTabbedPane) activeDataSetPanel().getParent();
//						jTabbedPane.setSelectedIndex(0);
						displayThresholds(activeThresholdPanel(),activeDataSet());
//						btnCategorize.setVisible(true);
						break;
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void categorize() {
		try {

			staticCategorizer = new StaticCategorizer();
			staticCategorizer.loadDataSet(activeDataSet());
			staticCategorizer.buildCategorizer();
			packageExplorer.displayMetrics(activeDataSetPanel(),
					activeDataSet());
			JTabbedPane jTabbedPane = (JTabbedPane) activeDataSetPanel()
					.getParent();
			jTabbedPane.setSelectedIndex(0);

		} catch (Exception ex) {
			Logger.getLogger(PrestGuiView.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		//btnStoreCategorizer.setVisible(true);
	}

	public void storeCategorizer() {
		try {
			DataContext context = new DataContext();
			String selectedMetric = metricsMenuButton.getActionText(metricsMenuButton.getActionIndex());
			selectedMetric = selectedMetric.replace(" ", "");
			staticCategorizer.setTitle(selectedMetric);
			context.add(selectedMetric, staticCategorizer.store());
			context.writeToFile(ApplicationProperties.get("repositorylocation")
					+ File.separator + packageExplorer.getProjectDirectory().getName()
					+ File.separator +"categorizer"
					+ Calendar.getInstance().getTimeInMillis() + ".xml");
			JOptionPane.showMessageDialog(null,
					"Categorizer stored successfully!", "Store Result",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception ex) {
			Logger.getLogger(PrestGuiView.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	// <editor-fold defaultstate="collapsed" desc="Threshold & Virtual Metric
	// Wizard methods">

	private void thresholdWizardFillComboBoxes() {
		riskLevels();
		attributesComboBoxValues(activeDataSet(), cmbThresholdMetricList);
		attributesComboBoxValues(activeDataSet(), cmbThresholdOperator1);
		attributesComboBoxValues(activeDataSet(), cmbThresholdOperator2);
		thresholdOperators();
		CardLayout cards = (CardLayout) (pnlThresholdSettingsCardLayout
				.getLayout());
		cards.show(pnlThresholdSettingsCardLayout, "card2");
		btnThresholdWizardNext.setText("Next");
	}

	private void thresholdWizardFillComboBoxesWithSelected(String label) {
		riskLevels();
		attributesComboBoxValuesWithSelected(activeDataSet(),
				cmbThresholdMetricList, label);
		attributesComboBoxValues(activeDataSet(), cmbThresholdOperator1);
		attributesComboBoxValues(activeDataSet(), cmbThresholdOperator2);
		thresholdOperators();
		CardLayout cards = (CardLayout) (pnlThresholdSettingsCardLayout
				.getLayout());
		cards.show(pnlThresholdSettingsCardLayout, "card2");
		btnThresholdWizardNext.setText("Next");
	}

	private void riskLevels() {
		List<String> riskLevelsArray = new ArrayList<String>();
		riskLevelsArray = getRiskLevels(activeDataSet());
		riskLevelsArray.add(0, "Please select risk level");
		cmbRiskLevels.setModel(new DefaultComboBoxModel(riskLevelsArray
				.toArray()));
	}

	private List<String> getRiskLevels(DataSet dataSet) {
		int classIndex = dataSet.getClassIndex();

		if (classIndex == -1) {
			for (int i = dataSet.getDataHeaders().length - 1; i >= 0; i--) {
				if (dataSet.getDataHeaders()[i].isNominal()) {
					classIndex = i;
					break;
				}
			}
		}

		String[] riskArray = dataSet.getDataHeaders()[classIndex]
				.getAvailableValue();
		List<String> returnList = new ArrayList<String>();

		for (String s : riskArray) {
			returnList.add(s);
		}

		return returnList;
	}

	private void thresholdOperators() {
		cmbThresholdOperator.addItem("Please select an operator");
		cmbThresholdOperator
				.addItem((String) (categorizer.core.ThresholdOperator.LT
						.operator())
						+ "         LESS THAN");
		cmbThresholdOperator
				.addItem((String) (categorizer.core.ThresholdOperator.GT
						.operator())
						+ "         GREATER THAN");
		cmbThresholdOperator
				.addItem((String) (categorizer.core.ThresholdOperator.LTE
						.operator())
						+ "       LESS THAN OR EQUAL");
		cmbThresholdOperator
				.addItem((String) (categorizer.core.ThresholdOperator.GTE
						.operator())
						+ "       GREATER THAN OR EQUAL");
		cmbThresholdOperator
				.addItem((String) (categorizer.core.ThresholdOperator.EQU
						.operator())
						+ "          EQUAL");
		cmbThresholdOperator
				.addItem((String) (categorizer.core.ThresholdOperator.BTW
						.operator())
						+ "       BETWEEN");
		cmbThresholdOperator.setSelectedIndex(0);
	}

	private void virtualMetricWizardFillComboBoxes() {
		txtVmMetricName.setText("");
		txtVmOperand1.setText("");
		txtVmOperand2.setText("");
		virtualMetricOperators();
		attributesComboBoxValues(activeDataSet(), cmbVmOperand1);
		attributesComboBoxValues(activeDataSet(), cmbVmOperand2);
		CardLayout cards = (CardLayout) (pnlVmCardLayout.getLayout());
		cards.show(pnlVmCardLayout, "card3");
		btnVmNext.setText("Next");
	}

	private void virtualMetricOperators() {
		cmbVmMetricOperator.addItem("Please select an operator");
		cmbVmMetricOperator
				.addItem((String) (categorizer.core.MetricOperator.ADD
						.operator())
						+ "    ADD");
		cmbVmMetricOperator
				.addItem((String) (categorizer.core.MetricOperator.SUB
						.operator())
						+ "    SUBTRACT");
		cmbVmMetricOperator
				.addItem((String) (categorizer.core.MetricOperator.MUL
						.operator())
						+ "    MULTIPLICATE");
		cmbVmMetricOperator
				.addItem((String) (categorizer.core.MetricOperator.DIV
						.operator())
						+ "    DIVIDE");
		cmbVmMetricOperator
				.addItem((String) (categorizer.core.MetricOperator.POW
						.operator())
						+ "    POWER OF");
		cmbVmMetricOperator
				.addItem((String) (categorizer.core.MetricOperator.EXP
						.operator())
						+ "    EXPONENT OF");
		cmbVmMetricOperator
				.addItem((String) (categorizer.core.MetricOperator.LOG
						.operator())
						+ "    LOGARITHM OF");
		cmbVmMetricOperator
				.addItem((String) (categorizer.core.MetricOperator.NOT
						.operator())
						+ "    NOT");
		cmbVmMetricOperator.setSelectedIndex(0);
	}

	private void attributesComboBoxValues(DataSet dataSet, JComboBox comboBox) {
		List<String> dataHeadersArray = new ArrayList<String>();
		dataHeadersArray.add("Please select a metric");
		for (DataHeader dh : dataSet.getDataHeaders()) {
			dataHeadersArray.add(dh.getLabel());
		}
		comboBox.setModel(new DefaultComboBoxModel(dataHeadersArray.toArray()));
		comboBox.setSelectedIndex(0);
	}

	private void attributesComboBoxValuesWithSelected(DataSet dataSet,
			JComboBox comboBox, String label) {
		List<String> dataHeadersArray = new ArrayList<String>();
		dataHeadersArray.add("Please select a metric");
		int index = 0;
		int selectedIndex = 0;
		for (DataHeader dh : dataSet.getDataHeaders()) {
			dataHeadersArray.add(dh.getLabel());
			if (dh.getLabel().equals(label)) {
				selectedIndex = index;
			}
			index++;
		}
		comboBox.setModel(new DefaultComboBoxModel(dataHeadersArray.toArray()));
		comboBox.setSelectedIndex(selectedIndex);
	}

	private void thresholdOperand2Visibility() {
		if (cmbThresholdOperator.getSelectedIndex() == 6) {
			lblThresholdOperand2.setEnabled(true);
			rbtnThresholdOperator2Txt.setEnabled(true);
			txtThresholdOperator2.setEnabled(true);
			rbtnThresholdOperator2Cmb.setEnabled(true);
			cmbThresholdOperator2.setEnabled(false);
		} else {
			lblThresholdOperand2.setEnabled(false);
			rbtnThresholdOperator2Txt.setEnabled(false);
			txtThresholdOperator2.setEnabled(false);
			rbtnThresholdOperator2Cmb.setEnabled(false);
			cmbThresholdOperator2.setEnabled(false);
		}

	}

	private void virtualMetricOperand2Visibility() {
		if (cmbVmMetricOperator.getSelectedIndex() == 0
				|| cmbVmMetricOperator.getSelectedIndex() == 6
				|| cmbVmMetricOperator.getSelectedIndex() == 7
				|| cmbVmMetricOperator.getSelectedIndex() == 8) {
			lblVmOperand2.setEnabled(false);
			rbtnVmOperand2Txt.setEnabled(false);
			txtVmOperand2.setEnabled(false);
			rbtnVmOperand2Cmb.setEnabled(false);
			cmbVmOperand2.setEnabled(false);
		} else {
			lblVmOperand2.setEnabled(true);
			rbtnVmOperand2Txt.setEnabled(true);
			txtVmOperand2.setEnabled(true);
			rbtnVmOperand2Cmb.setEnabled(true);
			cmbVmOperand2.setEnabled(false);
		}
	}

	private void createNewThreshold(JPanel thresholdPanel, DataSet dataSet) {
		DataHeader attributeHeader = dataSet
				.getDataHeader(cmbThresholdMetricList.getSelectedItem()
						.toString());

		Threshold threshold = new Threshold();
		threshold.setDataHeader(attributeHeader);
		threshold.setOperands(thresholdOperands);
		threshold.setOperator(thresholdOperator);
		threshold.setClassValue(cmbRiskLevels.getSelectedItem().toString());

		attributeHeader.addThreshold(threshold);

		displayThresholds(thresholdPanel, dataSet);
	}

	private void displayThresholds(JPanel panel, DataSet dataSet) {
		panel.removeAll();

		List<ThresholdContent> thresholdList = new ArrayList<ThresholdContent>();

		HashMap hashMap = dataSet.getThresholds();
		DataHeader[] dataHeaders = dataSet.getDataHeaders();
		for (DataHeader dataHeader : dataHeaders) {
			if (hashMap.get(dataHeader.getLabel()) != null) {
				Threshold[] thresholds = (Threshold[]) hashMap.get(dataHeader
						.getLabel());
				for (Threshold threshold : thresholds) {
					ThresholdContent thresholdContent = new ThresholdContent();
					thresholdContent.setThresholdDataHeader(dataHeader
							.getLabel());
					thresholdContent.setThresholdOperator(threshold
							.getOperator().operator());
					if (threshold.getOperands()[0].isDataHeader())
						thresholdContent
								.setThresholdFirstOperand(((DataHeader) (threshold
										.getOperands()[0].getOperandValue()))
										.getLabel());
					else
						thresholdContent.setThresholdFirstOperand(threshold
								.getOperands()[0].getOperandValue().toString());
					if (thresholdContent.getThresholdOperator().equals("<>")) {
						if (threshold.getOperands()[1].isDataHeader())
							thresholdContent
									.setThresholdSecondOperand(((DataHeader) (threshold
											.getOperands()[1].getOperandValue()))
											.getLabel());
						else
							thresholdContent
									.setThresholdSecondOperand(threshold
											.getOperands()[1].getOperandValue()
											.toString());
					}
					thresholdContent.setThresholdRiskLevel(threshold
							.getClassValue());

					thresholdList.add(thresholdContent);
				}
			}
		}

		ThresholdTableModel thresholdTableModel = new ThresholdTableModel(
				thresholdList);
		JTable table = new JTable(thresholdTableModel);

		ThresholdTableMouseListener mouseListener = new ThresholdTableMouseListener(
				table);
		table.addMouseListener(mouseListener);

    	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setAutoCreateRowSorter(false);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setVisible(true);
		javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
		panel.setLayout(null);
		panelLayout.setHorizontalGroup(panelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				panelLayout.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane,
								javax.swing.GroupLayout.DEFAULT_SIZE, 500,
								Short.MAX_VALUE)));
		panelLayout.setVerticalGroup(panelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				panelLayout.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane,
								javax.swing.GroupLayout.DEFAULT_SIZE, 500,
								Short.MAX_VALUE)));
		panel.setLayout(panelLayout);
		thresholdTableModel.fireTableDataChanged();
		panel.repaint();
		activeTabbedPane().setSelectedIndex(1);
	}

	public void thresholdWizardNextButton() {
		doubleOperands = false;

		if (btnThresholdWizardNext.getText().equals("Finish")) {
			createNewThreshold(activeThresholdPanel(), activeDataSet());
			//btnCategorize.setVisible(true);
			thresholdWizardDialog.dispose();
		} else {
			thresholdOperands = new Operand[2];

			String expression = "";
			String operator = "";
			thresholdSelectedMetric = cmbThresholdMetricList.getSelectedItem()
					.toString();

			switch (cmbThresholdOperator.getSelectedIndex()) {
			case 1:
				thresholdOperator = ThresholdOperator.LT;
				operator = " < ";
				break;
			case 2:
				thresholdOperator = ThresholdOperator.GT;
				operator = " > ";
				break;
			case 3:
				thresholdOperator = ThresholdOperator.LTE;
				operator = " <= ";
				break;
			case 4:
				thresholdOperator = ThresholdOperator.GTE;
				operator = " >= ";
				break;
			case 5:
				thresholdOperator = ThresholdOperator.EQU;
				operator = "=";
				break;
			case 6:
				thresholdOperator = ThresholdOperator.BTW;
				// expression = thresholdOperand1 + " <= " +
				// thresholdSelectedMetric + " <= " + thresholdOperand2;
				doubleOperands = true;
				break;
			}

			if (rbtnThresholdOperatorOneTxt.isSelected()) {
				thresholdOperand1 = txtThresholdOperator1.getText();
				thresholdOperands[0] = new Operand(false, Double
						.parseDouble(thresholdOperand1));
			} else {
				thresholdOperand1 = cmbThresholdOperator1.getSelectedItem()
						.toString();
				thresholdOperands[0] = new Operand(true, activeDataSet()
						.getDataHeader(thresholdOperand1));
			}

			if (doubleOperands) {
				if (rbtnThresholdOperator2Txt.isSelected()) {
					thresholdOperand2 = txtThresholdOperator2.getText();
					thresholdOperands[1] = new Operand(false, Double
							.parseDouble(thresholdOperand2));
				} else {
					thresholdOperand2 = cmbThresholdOperator2.getSelectedItem()
							.toString();
					thresholdOperands[1] = new Operand(true, activeDataSet()
							.getDataHeader(thresholdOperand2));
				}

				expression = thresholdOperand1 + " <= "
						+ thresholdSelectedMetric + " <= " + thresholdOperand2;
			} else
				expression = thresholdSelectedMetric + operator
						+ thresholdOperand1;

			lblThresholdExpression.setText(expression);
			lblThresholdRiskLevel.setText("Risk Level: "
					+ cmbRiskLevels.getSelectedItem().toString());
			CardLayout cards = (CardLayout) (pnlThresholdSettingsCardLayout
					.getLayout());
			cards.show(pnlThresholdSettingsCardLayout, "card3");
			btnThresholdWizardBack.setEnabled(true);
			btnThresholdWizardNext.setText("Finish");
		}
	}

	public void thresholdWizardBackButton() {

		CardLayout cards = (CardLayout) (pnlThresholdSettingsCardLayout
				.getLayout());
		cards.show(pnlThresholdSettingsCardLayout, "card2");
		btnThresholdWizardBack.setEnabled(false);
		btnThresholdWizardNext.setText("Next");

	}

	private void addNewMetricToTable(JPanel panel, DataSet dataSet) {
		VirtualMetric virtualMetric = new VirtualMetric(virtualMetricOperator,
				virtualMetricName, virtualMetricOperands);
		dataSet = virtualMetric.modifySet(dataSet);
		packageExplorer.displayMetrics(panel, dataSet);
	}

	public void virtualMetricWizardNext() {
		if (btnVmNext.getText().equals("Finish")) {
			addNewMetricToTable(activeDataSetPanel(), activeDataSet());
			virtualMetricWizardDialog.dispose();
		} else {
			virtualMetricOperands = new Operand[2];
			virtualMetricName = txtVmMetricName.getText();
			lblVirtualMetricName.setText(virtualMetricName);

			String expression = "";

			if (rbtnVmOperand1Txt.isSelected()) {
				virtualMetricOperand1 = txtVmOperand1.getText();
				virtualMetricOperands[0] = new Operand(false, Double
						.parseDouble(virtualMetricOperand1));
			} else {
				virtualMetricOperand1 = cmbVmOperand1.getSelectedItem()
						.toString();
				virtualMetricOperands[0] = new Operand(true,
						virtualMetricOperand1);
				// virtualMetricOperands[0] = new
				// Operand(true,activeDataSet().getDataHeader(
				// virtualMetricOperand1));
			}

			if (rbtnVmOperand2Txt.isSelected()) {
				virtualMetricOperand2 = txtVmOperand2.getText();
				virtualMetricOperands[1] = new Operand(false, Double
						.parseDouble(virtualMetricOperand2));
			} else {
				virtualMetricOperand2 = cmbVmOperand2.getSelectedItem()
						.toString();
				virtualMetricOperands[1] = new Operand(true,
						virtualMetricOperand2);
				// virtualMetricOperands[1] = new
				// Operand(true,activeDataSet().getDataHeader(
				// virtualMetricOperand2));
			}

			switch (cmbVmMetricOperator.getSelectedIndex()) {
			case 1:
				virtualMetricOperator = MetricOperator.ADD;
				expression = virtualMetricOperand1 + " + "
						+ virtualMetricOperand2;
				break;
			case 2:
				virtualMetricOperator = MetricOperator.SUB;
				expression = virtualMetricOperand1 + " - "
						+ virtualMetricOperand2;
				break;
			case 3:
				virtualMetricOperator = MetricOperator.MUL;
				expression = virtualMetricOperand1 + " * "
						+ virtualMetricOperand2;
				break;
			case 4:
				virtualMetricOperator = MetricOperator.DIV;
				expression = virtualMetricOperand1 + " / "
						+ virtualMetricOperand2;
				break;
			case 5:
				virtualMetricOperator = MetricOperator.POW;
				expression = virtualMetricOperand1 + " ^ "
						+ virtualMetricOperand2;
				break;
			case 6:
				virtualMetricOperator = MetricOperator.EXP;
				expression = "exp(" + virtualMetricOperand1 + ")";
				break;
			case 7:
				virtualMetricOperator = MetricOperator.LOG;
				expression = "log(" + virtualMetricOperand1 + ")";
				break;
			case 8:
				virtualMetricOperator = MetricOperator.NOT;
				expression = "not(" + virtualMetricOperand1 + ")";
				break;
			}

			lblVirtualMetricEquation.setText(expression);

			CardLayout cards = (CardLayout) (pnlVmCardLayout.getLayout());
			cards.show(pnlVmCardLayout, "card2");
			btnVmBack.setEnabled(true);
			btnVmNext.setText("Finish");
		}
	}

	public void vitualMetricBack() {
		CardLayout cards = (CardLayout) (pnlVmCardLayout.getLayout());
		cards.show(pnlVmCardLayout, "card3");
		btnVmBack.setEnabled(false);
		btnVmNext.setText("Next");
	}

	public void closeVirtualMetricDialog() {
		if (virtualMetricWizardDialog != null) {
			virtualMetricWizardDialog.dispose();
		}
	}

	public void closeThresholdWizardDialog() {
		if (thresholdWizardDialog != null) {
			thresholdWizardDialog.dispose();
		}
	}

	public void transferHeadersToFilter() {
		int[] indices = listAllMetrics.getSelectedIndices();
		for (int i = indices.length - 1; i >= 0; i--) {
			String header = (String) leftListModel.get(indices[i]);
			leftListModel.remove(indices[i]);
			rightListModel.addElement(header);
		}
	}

	public void transferHeadersToLeft() {
		int[] indices = listFilterMetrics.getSelectedIndices();
		for (int i = indices.length - 1; i >= 0; i--) {
			String header = (String) rightListModel.get(indices[i]);
			rightListModel.remove(indices[i]);
			leftListModel.addElement(header);
		}

	}

	public void transferAllHeadersToFilter() {
		for (int i = leftListModel.getSize() - 1; i >= 0; i--) {
			rightListModel.addElement(leftListModel.remove(i));
		}
	}

	public void transferAllHeadersToLeft() {
		for (int i = rightListModel.getSize() - 1; i >= 0; i--) {
			leftListModel.addElement(rightListModel.remove(i));
		}
	}

	public void defineNewFilter() {
		if (packageExplorer.isResultsTransferred()) {
			filterWizardFillHeaderList();
			filterWizardDialog.pack();
			centerDialog(filterWizardDialog);
			filterWizardDialog.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null,
					"Please select a project to add threshold",
					"Select Project", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void filterWizardFillHeaderList() {
		leftListModel = new DefaultListModel();
		listAllMetrics.setModel(leftListModel);

		rightListModel = new DefaultListModel();
		listFilterMetrics.setModel(rightListModel);

		DataHeader[] dataHeaders = activeDataSet().getDataHeaders();
		for (DataHeader dataHeader : dataHeaders) {
			leftListModel.addElement(dataHeader.getLabel());
		}
	}

	public void filterWizardCancelButton() {
		if (filterWizardDialog != null) {
			filterWizardDialog.dispose();
		}
	}

	public void filterWizardApplyButton() {
		DataSet dataSet = activeDataSet();
		LogFilter logFilter;

		for (int i = rightListModel.getSize() - 1; i >= 0; i--) {
			try {
				Option[] options = new Option[1];
				options[0] = new Option();
				options[0].setValue(String
						.valueOf(dataSet.getDataHeaderIndex(rightListModel
								.remove(i).toString())));

				logFilter = new LogFilter(options);
				dataSet = logFilter.filter(dataSet);
			} catch (Exception ex) {
				Logger.getLogger(PrestGuiView.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}

		filterWizardDialog.dispose();
		packageExplorer.displayMetrics(activeDataSetPanel(), activeDataSet());
	}

	public void createClassifierWizard() {
		JDialog frame = new JDialog(null, "Categorizer Definition Wizard",
				Dialog.ModalityType.APPLICATION_MODAL);
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		DynamicCategorizerWizard catWizard = new DynamicCategorizerWizard(frame);
		frame.getContentPane().add(catWizard.getSplitPane());
		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}
	
	public void openTrainingFile() {
		JFileChooser fileChooser = new JFileChooser();
		File currentDirectory;
		try {
			currentDirectory = new File(ApplicationProperties
					.get("repositorylocation"));

			if (currentDirectory != null) {
				fileChooser.setCurrentDirectory(currentDirectory);
				fileChooser.setDialogTitle("Select arff file");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				ExtensionFileFilter fileFilter = new ExtensionFileFilter(
						"arff files only", "ARFF");
				fileChooser.setFileFilter(fileFilter);
				int returnVal = fileChooser.showOpenDialog(null);

				File dir = null;

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					dir = fileChooser.getSelectedFile();
				}
				try {
					trainingSetPath = dir.getAbsolutePath();
					jTextArea1.append("\nTraining File Loaded : " +dir.getAbsolutePath());
				} catch (Exception ex) {
					Logger.getLogger(PrestGuiView.class.getName()).log(
							Level.SEVERE, null, ex);
				} 
			} 
		} catch (Exception e1) {
			//do something
		}
	}
	
	public void openTestFile() {
		JFileChooser fileChooser = new JFileChooser();
		File currentDirectory;
		try {
			currentDirectory = new File(ApplicationProperties
					.get("repositorylocation"));

			if (currentDirectory != null) {
				fileChooser.setCurrentDirectory(currentDirectory);
				fileChooser.setDialogTitle("Select arff file");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				ExtensionFileFilter fileFilter = new ExtensionFileFilter(
						"arff files only", "ARFF");
				fileChooser.setFileFilter(fileFilter);
				int returnVal = fileChooser.showOpenDialog(null);

				File dir = null;

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					dir = fileChooser.getSelectedFile();
				}
				try {
					testSetPath = dir.getAbsolutePath();
					jTextArea1.append("\nTest File Loaded : " +dir.getAbsolutePath());
				} catch (Exception ex) {
					Logger.getLogger(PrestGuiView.class.getName()).log(
							Level.SEVERE, null, ex);
				} 
			} 
		} catch (Exception e1) {
			//do something
		}
	}
	
	public void startWeka() {
		String output  = "";
		if(((testSetPath == null || trainingSetPath == null) &&  wekaCrossValidate == "false") ||
				(testSetPath == null && trainingSetPath == null &&  wekaCrossValidate == "true")){
			JOptionPane.showMessageDialog(null,
					"Load training and test sets first.", "Store Result",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			setWekaParameters(predictionToolbar.getMenuButtonSet(wekaAtrbsMenuButton));
			output = WekaRunner.runWeka(trainingSetPath,testSetPath,wekaAlgorithmType,wekaPreProcess,wekaCrossValidate,wekaLogFilter);
			jTextArea1.append("\n" +output);
		}
	}

	// </editor-fold>

	public class CategorizerListMouseListener extends MouseAdapter {

		public CategorizerListMouseListener() {
			super();
		}

		public void mouseReleased(MouseEvent e) {
			JList source = (JList) e.getSource();
			int selectedIndex = source.getSelectedIndex();
			String displayText = "";
			if (selectedIndex != -1) {
				Categorizer selectedCategorizer = (Categorizer) ParserExecutor
						.getCategorizerExecutor().getCategorizers().get(
								selectedIndex);
				if (selectedCategorizer != null) {
					displayText = selectedCategorizer.getConfusionMatrix()
							.toString();
					PerformanceMetric[] performanceMetrics = selectedCategorizer
							.getPerformanceMetrics();
					if (performanceMetrics != null) {
						for (int i = 0; i < performanceMetrics.length; i++) {
							try {
								displayText += "\n"
										+ performanceMetrics[i].toString();
							} catch (Exception ex) {

							}
						}
					}
					Components.confuseMatrixDisplayArea.setText(displayText);

					if (e.isPopupTrigger()) {
						JPopupMenu popup = new JPopupMenu();
						JMenuItem storeCategorizer = new JMenuItem("Store");
						storeCategorizer
								.addActionListener(new StoreCategorizerAdapter(
										selectedCategorizer));
						popup.add(storeCategorizer);
						popup.show(e.getComponent(), e.getX(), e.getY());
					}
				}
			}
		}
	}

	public class StoreCategorizerAdapter implements ActionListener {

		private Categorizer categorizer;

		public StoreCategorizerAdapter(Categorizer categorizer) {
			this.categorizer = categorizer;
		}

		public void actionPerformed(ActionEvent e) {
			try {
				DataContext context = new DataContext();
				categorizer.setTitle("categorizerai");
				context.add("categorizerai", categorizer.store());
				context.writeToFile(ApplicationProperties
						.get("repositorylocation")
						+ File.separator + ""
						+ packageExplorer.getProjectDirectory().getName()
						+ File.separator + "categorizer_"
						+ categorizer.getClassName()
						+ ".xml");
				JOptionPane.showMessageDialog(null,
						"Categorizer stored successfully!", "Store Result",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception ex) {
				Logger.getLogger(PrestGuiView.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}

		public Categorizer getCategorizer() {
			return categorizer;
		}

		public void setCategorizer(Categorizer categorizer) {
			this.categorizer = categorizer;
		}

	}

    public void crossValidateAction() {
    	if(chkboxCrossValidate.isSelected())
    		wekaCrossValidate = "true";
    	else
    		wekaCrossValidate = "false";
    }
    
    public void normalizeDataAction() {
    	if (jCheckBoxNormalize.isSelected())
    		wekaPreProcess = "normalize";
    	else
    		wekaPreProcess = "false";
    }
    
    public void logFilterAction() {
    	if(chkboxLogFilter.isSelected())
    		wekaLogFilter = "true";
    	else
    		wekaLogFilter = "false";
    }

    private void setWekaParameters(int[] parSet)
    {
    	// set parameters to initial values
    	wekaPreProcess = "false";
    	wekaCrossValidate = "false";
    	wekaLogFilter = "false";
    	
    	if (parSet != null)
    		for (int i = 0; i < parSet.length; i++)
    			switch (parSet[i])
    			{
    				case WA_CRSVALD:
    					wekaCrossValidate = "true";
    					break;
    				case WA_NORMALIZE:
    					wekaPreProcess = "normalize";
    					break;
    				case WA_LOGFILTER:
    					wekaLogFilter = "true";
    			}
    }
    
	public void actionPerformed(ActionEvent evt)
	{
		Object src = evt.getSource();
		if (src instanceof JComponent)
		{
			Integer tag = (Integer) ((JComponent) src).getClientProperty(TAGPROPERTY);
			if (tag != null)
				handleAction(tag.intValue());
		}
	}
	
	private void handleAction(int id)
	{
		switch (id)
		{
			case MI_ADDPROJECT:
				doAddProject();
				break;
			case MI_PARSEPROJECT:
				doParseProject();
				updateProjectInfoDisplay();
				break;
			case MI_TABLETRANSFER:
				doTableTransfer();
				break;
			case MI_CVS2ARFF:
				doCVS2Arff();
				break;
			case MI_DELETEPROJECT:
				doDeleteProject();
				break;
			case MI_SWITCHWS:
				switchWorkspace();
				break;
			case MI_EXIT:
				disposeView();
				break;
			case MI_NEWTHRESHOLD:
				defineThreshold();
				break;
			case MI_NEWVMETRIC:
				defineVirtualMetric();
				break;
			case MI_FILTER:
				defineNewFilter();
				break;
			case MI_ABOUT:
				showAboutBox();
				break;
		}
		
	}
	
	public void updateProjectInfoDisplay()
	{
		String toDisplay = "";
		String currProj = ApplicationProperties.get("CurrentProject");
		if(currProj.compareTo("") == 0)
			toDisplay = toDisplay + "Current Project: " + " No project has been parsed in this session yet!";
		else
			toDisplay = toDisplay + "Current Project: " + ApplicationProperties.get("CurrentProject");
		projectInfoDisplay.setText(toDisplay);
	}

	public void windowActivated(WindowEvent arg0)
	{
	}

	public void windowClosed(WindowEvent arg0)
	{
	}

	public void windowClosing(WindowEvent arg0)
	{
		disposeView();
	}

	public void windowDeactivated(WindowEvent arg0)
	{
	}

	public void windowDeiconified(WindowEvent arg0)
	{
	}

	public void windowIconified(WindowEvent arg0)
	{
	}

	public void windowOpened(WindowEvent arg0)
	{
	}

	public void popupMenuCanceled(PopupMenuEvent e)
	{
	}

	public void popupMenuWillBecomeInvisible(PopupMenuEvent e)
	{
	}

	public void popupMenuWillBecomeVisible(PopupMenuEvent e)
	{
		Object source = e.getSource();
		if (source instanceof JPopupMenu)
		{
			JPopupMenu menu = (JPopupMenu) source;
			for (int i = 0; i < menu.getComponentCount(); i++)
			{
				Component item = menu.getComponent(i);
				if (item instanceof JMenuItem)
				{
					JMenuItem mItem = (JMenuItem) item;
					Integer id = (Integer) mItem.getClientProperty(TAGPROPERTY);
					boolean enabled = (id != null) ? isMenuItemEnabled(id.intValue()) : true;
					item.setEnabled(enabled);
				}
			}
		}
		
	}

	private boolean isMenuItemEnabled(int id)
	{
		switch (id)
		{
			case MI_ADDPROJECT:
			case MI_TABLETRANSFER:
			case MI_CVS2ARFF:
			case MI_DELETEPROJECT:
			case MI_SWITCHWS:
			case MI_NEWTHRESHOLD:
			case MI_NEWVMETRIC:
			case MI_FILTER:
			case MI_PARSEPROJECT:
				return analysisResultsPanel.isVisible();
		}
		
		return true;
	}

	public boolean checkControlStatus(JComponent source, int ctrlID, JComponent component, int itemID)
	{
		switch (ctrlID)
		{
			case MI_ADDPROJECT:
			case MI_PARSEPROJECT:
			case MI_DELETEPROJECT:
			case MI_SWITCHWS:
			case MI_NEWTHRESHOLD:
			case MI_NEWVMETRIC:
			case MI_FILTER:
				return isMenuItemEnabled(ctrlID);
				
			case MI_LANGUAGES:
				return isLanguageAvailable(itemID);
			
			case MI_LOADSTORE:
				return Components.categorizerActive;
			
		}
		
		return true;
	}

	private boolean isLanguageAvailable(int lIndex)
	{
		if (Components.languageSet != null)
			for (int i = 0; i < Components.languageSet.length; i++)
				if (lIndex == Components.languageSet[i])
					return true;
		
		return false;
	}
	
	public void controlAction(JComponent source, int ctrlID, JComponent component, int itemID)
	{
		switch (ctrlID)
		{
			case MI_ADDPROJECT:
			case MI_PARSEPROJECT:
			case MI_DELETEPROJECT:
			case MI_SWITCHWS:
			case MI_NEWTHRESHOLD:
			case MI_NEWVMETRIC:
			case MI_FILTER:
				handleAction(ctrlID);
				break;
				
			case MI_METRICS:
				switchMetricView(itemID);
				break;
				
			case MI_LOADSTORE:
				switch (itemID)
				{
					case 1:
						categorize();
						break;
					case 2:
						loadCategorizer();
						break;
					case 3:
						storeCategorizer();
						break;
				}
				break;
				
			case MI_SWITCHVW:
				switchView();
				break;
				
			case MI_LANGUAGES:
				packageExplorer.setCurrentLanguage(itemID);
				break;
				
			case MI_LOADDATA:
				switch (itemID)
				{
					case 1:
						openTrainingFile();
						break;
					case 2:
						openTestFile();
						break;
				}
				break;
				
			case MI_PREDOPTS:
				break;
				
			case MI_ALGORITHM:
				wekaAlgorithmType = ((MenuButton) component).getActionText(itemID);
				break;
				
			case MI_RUNPRED:
				startWeka();
				break;
				
			case MI_SOFTLAB:
				showAboutBox();
				break;
		}
	}

	public void controlContentChange(JComponent source, int ctrlID, JComponent component)
	{
	}

	public void controlContentProcess(JComponent source, int ctrlID, JComponent component)
	{
	}

	public boolean filterControl(JComponent source, int ctrlID, JComponent component, int itemID)
	{
		return true;
	}
}
