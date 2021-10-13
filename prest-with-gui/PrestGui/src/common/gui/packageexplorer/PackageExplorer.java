/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.gui.packageexplorer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import java.awt.Cursor;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;


import parser.enumeration.Language;
import categorizer.core.DataSet;
//Turkcell custom
import com.turkcelltech.prest.defect.DefectMatcher;
import common.DirectoryListing;
import common.ExcelOutput;
import common.ExcelSheet;
import common.ParseResult;
import common.gui.actions.TableMouseListener;
import common.gui.models.DataSetToTableModel;
import common.gui.models.ExtendedTreeNode;
import common.gui.statics.Components;
import common.gui.packageexplorer.ColorAwareTableCellRenderer;
import common.monitor.Logger;
import definitions.application.ApplicationProperties;
import definitions.metrics.MetricTypeNames;
import executor.ParserExecutor;
import common.CsvToArff;
import predictor.WekaRunner;

public class PackageExplorer {

	private static final Object Object = null;

	private JScrollPane repositoryTreeScrollPane;

	private JTree repositoryTree;

	private HashMap<String, File> projectNamesHashMap = new HashMap<String, File>();

	private File projectDirectory;

	private ExtendedTreeNode rootNode;

	private DefaultTreeModel treeModel;

	private String lastParsedProjectPath = null;

	private boolean resultsTransferred;

	private boolean dataSetLoaded;

	public PackageExplorer() {
		this.resultsTransferred = true;
	}

	public void generateRepositoryTree(JSplitPane mainContentSplitPanel) {

		repositoryTreeScrollPane = new javax.swing.JScrollPane();
		repositoryTreeScrollPane.setName("repositoryTreeScrollPane");
		mainContentSplitPanel.setLeftComponent(repositoryTreeScrollPane);
		repositoryTree = new javax.swing.JTree();
		rootNode = new ExtendedTreeNode("Repository Projects");
		treeModel = new DefaultTreeModel(rootNode);
		repositoryTree.setModel(treeModel);

		repositoryTree.setName("repositoryTree"); // NOI18N
		repositoryTree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
		MouseListener treeMouseListener = new TreeMouseListener();
		repositoryTree.addMouseListener(treeMouseListener);
		repositoryTreeScrollPane.setViewportView(repositoryTree);

	}

	public void traverseRepository() {
		common.DirectoryListing dlx = new DirectoryListing();
		dlx.visitAllFiles_Filtered(new File(ApplicationProperties
				.get("repositorylocation")
				+ File.separator), ".metadata");
		List<File> metadataList = dlx.getFilteredFileNames();

		for (File metadata : metadataList) {
			String fullPath = readMetadataForProject(metadata);
			File projectDir = new File(fullPath);
			ExtendedTreeNode projectNode = new ExtendedTreeNode(fullPath,
					projectDir.getName(), true);
			common.DirectoryListing dl = new DirectoryListing();
			dl.visitAllFiles(projectDir);
			List<File> list = dl.getFileNames();
			String[] fileNames = new String[list.size()];

			projectNode = addNodes(projectNode, projectDir, fullPath, true);

			if (projectNode != null) {
				for (int index = 0; index < list.size(); index++) {
					fileNames[index] = list.get(index).getPath();
				}

				rootNode.add(projectNode);
				projectNamesHashMap.put(projectDir.getName(), projectDir);
				treeModel.reload();
			} else {
				common.monitor.Logger.error(fullPath
						+ "does not contain a valid project");
			}
		}
	}

	public String predict(String trainFile,String testFile) {
		String wekaAlgorithmType = "Naive Bayes";
		String wekaPreProcess = "none";
		String wekaCrossValidate = "no";
		String wekaLogFilter = "no";
		return WekaRunner.runWeka(trainFile,testFile,wekaAlgorithmType,wekaPreProcess,wekaCrossValidate,wekaLogFilter);
	}
	public String readMetadataForProject(File projectDirectory) {
		StringBuffer contents = new StringBuffer();

		try {
			// use buffering, reading one line at a time
			// FileReader always assumes default encoding is OK!
			BufferedReader input = new BufferedReader(new FileReader(
					projectDirectory));
			try {
				String line = null; // not declared within while loop
				/*
				 * readLine is a bit quirky : it returns the content of a line
				 * MINUS the newline. it returns null only for the END of the
				 * stream. it returns an empty String if two newlines appear in
				 * a row.
				 */
				while ((line = input.readLine()) != null) {
					contents.append(line);
					// contents.append(System.getProperty("line.separator"));
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return contents.toString();
	}

	public void createMetadataForProject(File projectDirectory) {
		Writer output = null;
		try {
			// FileWriter always assumes default encoding is OK!
			File directoryToCreate = new File(ApplicationProperties
					.get("repositorylocation")
					+ File.separator.toString()
					+ projectDirectory.getName());

			// if the current directory does not exist, then we create it
			if (!directoryToCreate.exists()) {
				directoryToCreate.mkdir();
			}

			output = new BufferedWriter(new FileWriter(new File(
					ApplicationProperties.get("repositorylocation")
							+ File.separator
							+ projectDirectory.getName()
							+ File.separator
							+ "project.metadata")));
			output.write(projectDirectory.getAbsolutePath());
		} catch (Exception ex) {
			Logger.error(PackageExplorer.class.getName()
					+ " createMetadataForProject " + ex.getMessage());
		} finally {
			try {
				output.close();
			} catch (IOException ex) {
				Logger.error(PackageExplorer.class.getName()
						+ "exception in closing the metadata file after write"
						+ ex.getMessage());
			}
		}
	}

	public File getProjectDirectoryFromUser() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Select folder to parse");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fileChooser.showOpenDialog(null);

		File dir = null;
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			dir = fileChooser.getSelectedFile();
		}
		return dir;
	}

	public boolean searchRepository(File newDirectory) {
		common.DirectoryListing dlx = new DirectoryListing();
		dlx.visitAllOneLevelDirs(new File(ApplicationProperties
				.get("repositorylocation")
				+ File.separator));
		List<File> dirList = dlx.getDirNames();
		if (dirList != null) {
			for (File projectDir : dirList) {
				if (projectDir.getName().equals(newDirectory.getName())) {
					System.out.println(" *** " + projectDir.getName() + " "
							+ newDirectory.getName());
					return true;
				}
			}
		}
		return false;
	}

	public void addNewProject() {
		projectDirectory = getProjectDirectoryFromUser();
		if (projectDirectory != null) {
			if (!searchRepository(projectDirectory)) {
				generatePackageExplorer(projectDirectory);
				new File(ApplicationProperties.get("repositorylocation") + File.separator
						+ projectDirectory.getName()).mkdirs();
				new File(ApplicationProperties.get("repositorylocation") + File.separator
						+ projectDirectory.getName() + File.separator + "parse_results")
						.mkdirs();
				new File(ApplicationProperties.get("repositorylocation") + File.separator
						+ projectDirectory.getName() + File.separator + "arff_files").mkdirs();
				createMetadataForProject(projectDirectory);
			} else {
				JOptionPane.showMessageDialog(null,
						"The project you have selected is already opened!",
						"Already Opened", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void addNewProjectCmd(String projectDirectoryStr) {
		File projectDirectory = new File(projectDirectoryStr);
		if (projectDirectory != null) {
			if (!searchRepository(projectDirectory)) {
				generatePackageExplorerCmd(projectDirectory);
				new File(ApplicationProperties.get("repositorylocation") + File.separator
						+ projectDirectory.getName()).mkdirs();
				new File(ApplicationProperties.get("repositorylocation") + File.separator
						+ projectDirectory.getName() + File.separator + "parse_results")
						.mkdirs();
				new File(ApplicationProperties.get("repositorylocation") + projectDirectory.separator
						+ projectDirectory.getName() + File.separator + "arff_files").mkdirs();
				createMetadataForProject(projectDirectory);
			} else {
				System.out
						.println("ERROR: The project you tried to add has already been added!");
			}
		}
	}

	
	
	public void generatePackageExplorer(File projectDirectory) {
		ExtendedTreeNode projectNode = new ExtendedTreeNode(projectDirectory
				.getName());
		projectNode.setProjectPath(projectDirectory.getAbsolutePath());
		common.DirectoryListing dl = new DirectoryListing();
		dl.visitAllFiles(projectDirectory);
		List<File> list = dl.getFileNames();
		String[] fileNames = new String[list.size()];
		projectNode = addNodes(projectNode, projectDirectory, projectDirectory
				.getAbsolutePath(), true);

		for (int index = 0; index < list.size(); index++) {
			fileNames[index] = list.get(index).getPath();
		}
		rootNode.add(projectNode);
		projectNamesHashMap.put(projectDirectory.getName(), projectDirectory);
		treeModel.reload();
	}

	public void generatePackageExplorerCmd(File projectDirectory) {
		ExtendedTreeNode projectNode = new ExtendedTreeNode(projectDirectory
				.getName());
		projectNode.setProjectPath(projectDirectory.getAbsolutePath());
		common.DirectoryListing dl = new DirectoryListing();
		dl.visitAllFiles(projectDirectory);
		List<File> list = dl.getFileNames();
		String[] fileNames = new String[list.size()];
		projectNode = addNodes(projectNode, projectDirectory, projectDirectory
				.getAbsolutePath(), true);

		for (int index = 0; index < list.size(); index++) {
			fileNames[index] = list.get(index).getPath();
		}
	}

	private ExtendedTreeNode addNodes(ExtendedTreeNode curTop, File dir,
			String fullPath, boolean isProjectNode) {
		String curPath = dir.getPath();
		String curShortPath = dir.getName();
		ExtendedTreeNode curDir = new ExtendedTreeNode(fullPath, curShortPath,
				isProjectNode);

		Vector ol = new Vector();
		String[] tmp = dir.list();
		if (tmp != null) {
			if (curTop != null) { // should only be null at root
				curTop.add(curDir);
			}
			for (int i = 0; i < tmp.length; i++) {
				ol.addElement(tmp[i]);
			}
			Collections.sort(ol, String.CASE_INSENSITIVE_ORDER);
			File f;
			Vector files = new Vector();
			// Make two passes, one for Dirs and one for Files. This is #1.
			for (int i = 0; i < ol.size(); i++) {
				String thisObject = (String) ol.elementAt(i);
				String newPath;
				if (curPath.equals(".")) {
					newPath = thisObject;
				} else {
					newPath = curPath + File.separator + thisObject;
				}
				if ((f = new File(newPath)).isDirectory()) {
					addNodes(curDir, f, null, false);
				} else {
					files.addElement(thisObject);
				}
			}
			// Pass two: for files.
			for (int fnum = 0; fnum < files.size(); fnum++) {
				curDir.add(new ExtendedTreeNode(files.elementAt(fnum)));
			}
		} else {
			curDir = null;
			Logger.error(curPath + "does not contain a valid project");
		}
		return curDir;
	}

	public void parseManual() {
		int result;
		try {
			result = ParserExecutor.parseDirectory(projectDirectory);
			if (result == ParserExecutor.PARSING_SUCCESSFUL) {
				JOptionPane.showMessageDialog(null,
						"Project parsed successfully.", "Parse Result",
						JOptionPane.INFORMATION_MESSAGE);
				lastParsedProjectPath = projectDirectory.getAbsolutePath();
				displayAllMetrics();
				ApplicationProperties.set("CurrentProject", projectDirectory
						.getName());
			} else {
				JOptionPane.showMessageDialog(null,
						"There was an error while parsing the project.",
						"Parse Result", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception ex) {
			Logger.error("Exception in parsing project: "
					+ projectDirectory.getName() + " " + ex.getMessage());
		}
	}

	public void parseManualCmd(String projectDirectoryStr, String releaseLabel) {
		int result;
		try {
			File projectDirectory = new File(projectDirectoryStr);
			result = ParserExecutor.parseDirectoryCmd(projectDirectory);
			
			if (result == ParserExecutor.PARSING_SUCCESSFUL) {
				System.out.println("Project parsed successfully.");
				lastParsedProjectPath = projectDirectory.getAbsolutePath();
//Turkcell custom
				DefectMatcher.main(new String[] {projectDirectory.getName(), releaseLabel, ApplicationProperties
						.get("repositorylocation")
						+ "/"
						+ projectDirectory.getName()
						+ "/"+ "parse_results"});
								
			} else {
				System.out
						.println("There was an error while parsing the project.");
			}
		} catch (Exception ex) {
			Logger.error("Exception in parsing project: "
					+ projectDirectory.getName()  + ex.getMessage());
		}
	}


/*	public void parseManualCmd(String projectDirectoryStr) {
		int result;
		try {
			File projectDirectory = new File(projectDirectoryStr);
			result = ParserExecutor.parseDirectoryCmd(projectDirectory);
			
			if (result == ParserExecutor.PARSING_SUCCESSFUL) {
				System.out.println("Project parsed successfully.");
				lastParsedProjectPath = projectDirectory.getAbsolutePath();
			} else {
				System.out
						.println("There was an error while parsing the project.");
			}
		} catch (Exception ex) {
			Logger.error("Exception in parsing project: "
					+ projectDirectory.getName()  + ex.getMessage());
		}
	}*/

	public void convertCsvToArff() {
		CsvToArff c = new CsvToArff();
		try {
			c.convertProject(new File(ApplicationProperties
					.get("repositorylocation")
					+ File.separator + projectDirectory.getName()));
			JOptionPane.showMessageDialog(null,
					"Files converted successfully.", "Parse Result",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception eCtoArff) {
			Logger.error("Exception in converting Csv to Arff: "
					+ projectDirectory.getName() + " " + eCtoArff.getMessage());
		}
	}
	//for usage from the command line...
	public void convertCsvToArff(String fileName) {
		CsvToArff c = new CsvToArff();
		try {
			CsvToArff cCommand = new CsvToArff();
			cCommand.csvToArffCommand(fileName);
			System.out.println(fileName + "converted successfully...");
		} catch (Exception eCtoArff) {
			System.out.println("Error: File name wrong or file corrupt!");
		}
	}

	public TreePath getSelectedPath(int mousePositionX, int mousePositionY) {
		return this.repositoryTree.getPathForLocation(mousePositionX,
				mousePositionY);
	}

	public void setLastParsedProjectPathAsCurrentDirectory() {
		this.lastParsedProjectPath = projectDirectory.getAbsolutePath();
	}

	public String getLastParsedProjectPath() {
		return lastParsedProjectPath;
	}

	public void setLastParsedProjectPath(String lastParsedProjectPath) {
		this.lastParsedProjectPath = lastParsedProjectPath;
	}

	public JScrollPane getRepositoryTreeScrollPane() {
		return repositoryTreeScrollPane;
	}

	public void setRepositoryTreeScrollPane(JScrollPane repositoryTreeScrollPane) {
		this.repositoryTreeScrollPane = repositoryTreeScrollPane;
	}

	public JTree getRepositoryTree() {
		return repositoryTree;
	}

	public void setRepositoryTree(JTree repositoryTree) {
		this.repositoryTree = repositoryTree;
	}

	public HashMap<String, File> getProjectNamesHashMap() {
		return projectNamesHashMap;
	}

	public void setProjectNamesHashMap(HashMap<String, File> projectNamesHashMap) {
		this.projectNamesHashMap = projectNamesHashMap;
	}

	public File getProjectDirectory() {
		return projectDirectory;
	}

	public void setProjectDirectory(File projectDirectory) {
		this.projectDirectory = projectDirectory;
	}

	public ExtendedTreeNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(ExtendedTreeNode rootNode) {
		this.rootNode = rootNode;
	}

	public DefaultTreeModel getTreeModel() {
		return treeModel;
	}

	public void setTreeModel(DefaultTreeModel treeModel) {
		this.treeModel = treeModel;
	}

	public boolean isResultsTransferred() {
		return resultsTransferred;
	}

	public void setResultsTransferred(boolean resultsTransferred) {
		this.resultsTransferred = resultsTransferred;
	}

	public boolean isDataSetLoaded() {
		return dataSetLoaded;
	}

	public void setDataSetLoaded(boolean dataSetLoaded) {
		this.dataSetLoaded = dataSetLoaded;
	}

	public void displayMetrics(JPanel panel, DataSet ds) {
		panel.removeAll();
		if (ds != null) {

			DataSetToTableModel tableModel = new DataSetToTableModel(ds);
			if (tableModel.isInitializedSuccessfully()) {
				JTable table = new JTable(tableModel);
				table.setDefaultRenderer(java.lang.Object.class,
						new ColorAwareTableCellRenderer());
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.setAutoCreateRowSorter(false);
				table.setColumnSelectionAllowed(true);
				table.setRowSelectionAllowed(false);
				TableColumn column = null;
				column = table.getColumnModel().getColumn(0);
				int maxSize = (((String) column.getHeaderValue()).length() * 7);

				for (int i = 1; i < table.getColumnModel().getColumnCount(); i++) {
					column = table.getColumnModel().getColumn(i);
					maxSize = (((String) column.getHeaderValue()).length() * 7);

					int rowCounter = table.getRowCount() - 1;
					for (int j = 0; j < rowCounter; j++) {

						int cellSize = ((String.valueOf(table.getValueAt(j, i)))
								.length() * 7);
						if (cellSize > maxSize) {
							maxSize = cellSize;
						}
					}
					column.setPreferredWidth(maxSize);
				}

				MouseListener popupListener = new TableMouseListener(table);
				table.getTableHeader().addMouseListener(popupListener);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setViewportView(table);
				scrollPane.setVisible(true);
				javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(
						panel);
				panel.setLayout(null);
				panelLayout.setHorizontalGroup(panelLayout.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						panelLayout.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										500, Short.MAX_VALUE)));
				panelLayout.setVerticalGroup(panelLayout.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						panelLayout.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										500, Short.MAX_VALUE)));
				panel.setLayout(panelLayout);
				tableModel.fireTableDataChanged();
				dataSetLoaded = true;
			}
		}

		Components.categorizerActive = true;
		Components.analysisToolBar.checkControls();
		panel.repaint();
	}

	public class TreeMouseListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			int selRow = repositoryTree.getRowForLocation(e.getX(), e.getY());
			TreePath selPath = repositoryTree.getPathForLocation(e.getX(), e
					.getY());
			if (selRow != -1 && selPath != null) {
				repositoryTree.setSelectionPath(selPath);
				ExtendedTreeNode selectedNode = (ExtendedTreeNode) selPath
						.getLastPathComponent();
				if (selectedNode.isIsProjectNode()) {
					String projectPath = selectedNode.getProjectPath();
					projectDirectory = new File(projectPath);
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			TreePath selPath = repositoryTree.getPathForLocation(e.getX(), e
					.getY());
			if (e.isPopupTrigger()) {
				if (selPath != null) {
					ExtendedTreeNode selectedNode = (ExtendedTreeNode) selPath
							.getLastPathComponent();
					if (selectedNode != null) {
						if (selectedNode.isRoot()) {
							JPopupMenu popup = new JPopupMenu();
							JMenuItem menuItem1 = new JMenuItem("Add Project");
							menuItem1.addActionListener(new AddNewProject());
							popup.add(menuItem1);
							popup.show(e.getComponent(), e.getX(), e.getY());
						} else if (selectedNode.isIsProjectNode()) {
							JPopupMenu popup = new JPopupMenu();
							// JMenuItem menuItem1 = new JMenuItem("Parse");
							// menuItem1
							// .addActionListener(new ParseProjectAdapter());
							// popup.add(menuItem1);
							JMenuItem menuItem2 = new JMenuItem(
									"Transfer Results To Table");
							menuItem2
									.addActionListener(new TransferResultsAdapter());
							popup.add(menuItem2);
							JMenuItem menuItem3 = new JMenuItem("Delete");
							menuItem3
									.addActionListener(new DeleteProjectAdapter(
											selPath));
							popup.add(menuItem3);
							JMenuItem menuItem5 = new JMenuItem(
									"Convert Project Csv to Arff");
							menuItem5.addActionListener(new CsvToArffAdapter());
							popup.add(menuItem5);
							popup.show(e.getComponent(), e.getX(), e.getY());
							try {
								String projectPath = selectedNode
										.getProjectPath();
								projectDirectory = new File(projectPath);
							} catch (Exception e1) {
								Logger.error(TreeMouseListener.class.getName()
										+ " " + e1.getMessage());
								projectDirectory = null;
							}
						}
					} else {
						JPopupMenu popup = new JPopupMenu();
						JMenuItem menuItem1 = new JMenuItem("Add Project");
						menuItem1.addActionListener(new AddNewProject());
						menuItem1.setEnabled(true);
						popup.add(menuItem1);
						popup.show(e.getComponent(), e.getX(), e.getY());
					}
				} else {
					JPopupMenu popup = new JPopupMenu();
					JMenuItem menuItem1 = new JMenuItem("Add Project");
					menuItem1.addActionListener(new AddNewProject());
					menuItem1.setEnabled(true);
					popup.add(menuItem1);
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		}
	}

	public class AddNewProject implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			addNewProject();
		}
	}

	public class DeleteProjectAdapter implements ActionListener {

		public TreePath selPath;

		public DeleteProjectAdapter(TreePath selPath) {
			this.selPath = selPath;

		}

		public void actionPerformed(ActionEvent e) {
			deleteProject(selPath);
		}
	}

	public void deleteProject() {
		ExtendedTreeNode node = (ExtendedTreeNode) repositoryTree
				.getLastSelectedPathComponent();
		if (node != null)
			deleteProject(node);
	}

	public void deleteProject(TreePath selPath) {
		ExtendedTreeNode node = (ExtendedTreeNode) selPath
				.getLastPathComponent();
		if (node != null)
			deleteProject(node);
	}

	public void deleteProject(ExtendedTreeNode node) {
		Object[] options = { "YES", "CANCEL" };
		int decision;

		decision = JOptionPane
				.showOptionDialog(
						null,
						"Do you want to delete this project and all related data from your repository?",
						"Delete From Repository", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		if (decision == 0) {
			String projectPath = ApplicationProperties
					.get("repositorylocation")
					+ File.separator + (String) node.getUserObject();
			if (projectPath == null || projectPath.equals("")) {
				JOptionPane
						.showMessageDialog(
								null,
								"An error occured during the removal of project from repository.",
								"Delete Error", JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					File folderToDelete = new File(projectPath);
					deleteDir(folderToDelete);
					ExtendedTreeNode parentNode = (ExtendedTreeNode) (node
							.getParent());
					if (parentNode == null)
						return;
					parentNode.remove(node);
					((DefaultTreeModel) repositoryTree.getModel())
							.reload(parentNode);
					// traverseRepository();
					System.out.println("test repaint");
					Components.fileMetricsDataSetPanel.removeAll();
					Components.classMetricsDataSetPanel.removeAll();
					Components.methodMetricsDataSetPanel.removeAll();
					Components.packageMetricsDataSetPanel.removeAll();
					Components.resultsDataPanel.repaint();

				} catch (Exception e1) {
					JOptionPane
							.showMessageDialog(
									null,
									"An error occured during the removal of project from repository.",
									"Delete Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if (decision == 1) {
		}
	}

	public boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		// The directory is now empty so delete it
		return dir.delete();
	}

	// public class ParseProjectAdapter implements ActionListener {
	//
	// public void actionPerformed(ActionEvent e) {
	// parseProject();
	// }
	//
	// }

	public void parseProject() {
		Components.resultsDataPanel.setCursor(Cursor
				.getPredefinedCursor(Cursor.WAIT_CURSOR));
		parseManual();
		displayAllMetrics();
		Components.resultsDataPanel.setCursor(Cursor
				.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		generateCallGraph();
	}

	public void generateCallGraph() {
		ExtendedTreeNode node = (ExtendedTreeNode) repositoryTree
				.getLastSelectedPathComponent();

		if (node == null) {
			return;
		} else {
			common.DirectoryListing dlx = new DirectoryListing();
			dlx.visitAllFiles_Filtered(new File(ApplicationProperties
					.get("repositorylocation")
					+ File.separator + projectDirectory.getName() + File.separator), ".csv");
			List<ExcelSheet> excelSheets = new ArrayList<ExcelSheet>();
			List<File> tempFileList = dlx.getFilteredFileNames();
			if (tempFileList != null) {
				for (File csvfile : tempFileList) {
					ExcelSheet newSheet = null;
					if (csvfile.getName().contains("_C.csv")) { // if it is
						// a C
						// project
						newSheet = new ExcelSheet(csvfile, // add a sheet
								ExcelSheet.C_CSV_FILE);

						excelSheets.add(newSheet);

						csvfile.delete();
					} else if (csvfile.getName().contains("_Java.csv")) { // if
						// it
						// is a
						// Java
						// Project
						newSheet = new ExcelSheet(csvfile, // add a sheet
								ExcelSheet.JAVA_CSV_FILE);

						excelSheets.add(newSheet);
						csvfile.delete();
					}

				}

				if (excelSheets.size() > 0) {
					String callGraphFileName = ApplicationProperties
							.get("repositorylocation")
							+ File.separator
							+ projectDirectory.getName()
							+ File.separator +"functionCallGraph.xls";
					ExcelOutput.generateCallGraphExcelWithIds(
							callGraphFileName, excelSheets);
				}

			}

		}
	}

	public class CsvToArffAdapter implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Components.resultsDataPanel.setCursor(Cursor
					.getPredefinedCursor(Cursor.WAIT_CURSOR));
			convertCsvToArff();
			Components.resultsDataPanel.setCursor(Cursor
					.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}

	}

	public class TransferResultsAdapter implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			transferResults();
		}
	}

	public void transferResults() {
		ExtendedTreeNode node = (ExtendedTreeNode) repositoryTree
				.getLastSelectedPathComponent();

		if (node == null) {
			return;
		} else {
			// if(lastParsedProjectPath != null &&
			// lastParsedProjectPath.equals(node.getProjectPath())){
			// displayAllMetrics();
			// } else {
			boolean hasOldResults = false;
			List<Calendar> lastParseDateList = new ArrayList<Calendar>();
			List<Language> parsedLanguageList = new ArrayList<Language>();
			for (Language lang : Language.LIST) {
				Calendar lastParseDate = checkParseResult(lang,
						projectDirectory);
				if (lastParseDate != null) {
					hasOldResults = true;
					lastParseDateList.add(lastParseDate);
					parsedLanguageList.add(lang);
				}
			}
			if (hasOldResults) {
				// uc option
				Object[] options = { "Use old results", "Parse Now", "Cancel" };
				int decision;
				SimpleDateFormat formatter = new SimpleDateFormat(
						"dd.MM.yyyy HH:mm");
				decision = JOptionPane
						.showOptionDialog(
								null,
								"An old parse result from "
										+ formatter.format(lastParseDateList
												.get(0).getTime())
										+ " exists for this project.\nDo you want to use it or re-parse the project?",
								"Parser Result Selection",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options,
								options[0]);

				if (decision == 0) {
					List<String> fileList = new ArrayList<String>();
					for (int i = 0; i < parsedLanguageList.size(); i++) {
						String fileName = ApplicationProperties
								.get("repositorylocation")
								+ File.separator
								+ projectDirectory.getName()
								+ File.separator +"parseResult_"
								+ parsedLanguageList.get(i).getLangName()
								+ "_"
								+ lastParseDateList.get(i).getTimeInMillis()
								+ ".xml";
						fileList.add(fileName);
					}
					ParserExecutor.fillWithOldResults(fileList,
							parsedLanguageList);
					displayAllMetrics();
				} else if (decision == 1) {
					parseManual();
					displayAllMetrics();
				}
			} else {
				Object[] options = { "Parse Now", "Cancel" };
				int decision;

				decision = JOptionPane
						.showOptionDialog(
								null,
								"No parse result exists for this project.\nDo you want to parse the project now?",
								"Parser Result Selection",
								JOptionPane.OK_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options,
								options[0]);

				if (decision == 0) {
					parseManual();
					displayAllMetrics();
				}
			}
			// }
		}
		resultsTransferred = true;
		Components.dataFileActive = false;
	}

	private Calendar checkParseResult(Language lang, File projectDirectory) {
		common.DirectoryListing dlx = new DirectoryListing();
		dlx.visitAllFiles_Filtered(new File(ApplicationProperties
				.get("repositorylocation")
				+ File.separator + projectDirectory.getName() + File.separator), ".xml");
		List<File> tempResultList = dlx.getFilteredFileNames();
		List<File> parserResultList = new ArrayList<File>();
		for (File file : tempResultList) {
			if (file.getName().contains("_" + lang.getLangName() + "_")) {
				parserResultList.add(file);
			}
		}
		if (parserResultList != null) {
			if (parserResultList.size() > 0) {
				File aResult = parserResultList.get(0);
				String name = aResult.getName();
				String strDateInLong = null;
				StringTokenizer st = new StringTokenizer(name, "_");
				int count = 0;
				while (st.hasMoreTokens()) {
					strDateInLong = st.nextToken();
					if (count == 2) {
						break;
					}
					count++;
				}
				strDateInLong = strDateInLong.replaceAll(".xml", "");
				long max = Long.parseLong(strDateInLong);
				for (int i = 1; i < parserResultList.size(); i++) {
					File anotherResult = parserResultList.get(i);
					String anotherName = anotherResult.getName();
					String strDateInLong2 = null;
					StringTokenizer st2 = new StringTokenizer(anotherName, "_");
					int count2 = 0;
					while (st2.hasMoreTokens()) {
						strDateInLong2 = st2.nextToken();
						if (count2 == 2) {
							break;
						}
						count2++;
					}
					strDateInLong2 = strDateInLong2.replaceAll(".xml", "");
					long max2 = Long.parseLong(strDateInLong2);
					if (max2 > max) {
						max = max2;
					}
				}
				Calendar lastDate = Calendar.getInstance();
				lastDate.setTimeInMillis(max);
				return lastDate;
			}
		}
		return null;
	}

	public void updateLanguageSet() {
		List resList = ParserExecutor.getParserResultList();
		Components.languageSet = resList != null ? new int[resList.size()]
				: null;
		int counter = 0;
		for (ParseResult parseResult : ParserExecutor.getParserResultList()) {
			String langName = parseResult.getParserLanguage().getDisplayName();
			int langIndex = -1;
			for (int i = 0; i < Language.LIST.size(); i++)
				if (langName.equals(Language.LIST.get(i).getDisplayName())) {
					langIndex = i;
					break;
				}

			if (langIndex > 0) {
				Components.languageSet[counter] = langIndex;
				if (counter == 0) {
					ParserExecutor.setCurrentLanguage(parseResult
							.getParserLanguage());
					counter++;
				}

			}
		}

		Components.analysisToolBar.checkControls();
	}

	// public void updateLanguagePanel() {
	// JPanel panel = Components.languageRadioButtonGroupPanel;
	// Components.languageButtonGroup = new ButtonGroup();
	// panel.removeAll();
	// panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
	// int counter = 0;
	// for (ParseResult parseResult : ParserExecutor.getParserResultList()) {
	// JRadioButton rButton = new JRadioButton(parseResult
	// .getParserLanguage().getDisplayName());
	// if (counter == 0) {
	// rButton.setSelected(true);
	// ParserExecutor.setCurrentLanguage(parseResult
	// .getParserLanguage());
	// counter++;
	// }
	// rButton.addActionListener(new ActionListener() {
	// public void actionPerformed(ActionEvent e) {
	// rButtonPressed(e);
	// }
	// });
	// Components.languageButtonGroup.add(rButton);
	// panel.add(rButton);
	// }
	// panel.repaint();
	// }
	//
	// private void rButtonPressed(ActionEvent evt) {
	// JRadioButton rbtn = (JRadioButton) evt.getSource();
	// if (rbtn != null) {
	// for (Language lang : Language.LIST) {
	// if (rbtn.getText().equals(lang.getDisplayName())) {
	// setCurrentLanguage(lang);
	// break;
	// }
	// }
	// }
	// }

	public void setCurrentLanguage(int lang) {
		if (lang < Language.LIST.size())
			setCurrentLanguage(Language.LIST.get(lang));
	}

	public void setCurrentLanguage(Language lang) {
		displayAllMetrics(lang);
		ParserExecutor.setCurrentLanguage(lang);
	}

	public void displayAllMetrics() {
		if (ParserExecutor.getParserResultList() != null) {
			updateLanguageSet();
			ParseResult firstResult = ParserExecutor.getParserResultList().get(
					0);
			displayMetrics(Components.fileMetricsDataSetPanel, firstResult
					.getDataSetByMetricType(MetricTypeNames.FILE_METRICS));
			displayMetrics(Components.classMetricsDataSetPanel, firstResult
					.getDataSetByMetricType(MetricTypeNames.CLASS_METRICS));
			displayMetrics(Components.methodMetricsDataSetPanel, firstResult
					.getDataSetByMetricType(MetricTypeNames.METHOD_METRICS));
			displayMetrics(Components.packageMetricsDataSetPanel, firstResult
					.getDataSetByMetricType(MetricTypeNames.PACKAGE_METRICS));
			Components.resultsDataPanel.validate();
			// CardLayout cards = (CardLayout) Components.resultsDataPanel
			// .getLayout();
			// cards.show(Components.pnlDataCardLayout, "card4");
		}
	}

	public void displayAllMetrics(Language lang) {
		if (ParserExecutor.getParserResultList() != null) {
			for (ParseResult result : ParserExecutor.getParserResultList()) {
				if (result.getParserLanguage().equals(lang)) {
					ParserExecutor.setCurrentLanguage(lang);
					displayMetrics(
							Components.fileMetricsDataSetPanel,
							result
									.getDataSetByMetricType(MetricTypeNames.FILE_METRICS));
					displayMetrics(
							Components.classMetricsDataSetPanel,
							result
									.getDataSetByMetricType(MetricTypeNames.CLASS_METRICS));
					displayMetrics(
							Components.methodMetricsDataSetPanel,
							result
									.getDataSetByMetricType(MetricTypeNames.METHOD_METRICS));
					displayMetrics(
							Components.packageMetricsDataSetPanel,
							result
									.getDataSetByMetricType(MetricTypeNames.PACKAGE_METRICS));
				}
			}
		}
	}
}
