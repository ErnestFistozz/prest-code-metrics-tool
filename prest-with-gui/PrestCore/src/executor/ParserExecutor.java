package executor;

import categorizer.core.CategorizerExecutor;
import java.io.File;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import parser.C.CParser;
import parser.Cpp.cppParser.CPPParserExecutor;
import parser.Java.JavaParserRelatedFiles.JavaParser;
import parser.Jsp.JspToJavaConvertor;
import parser.PLSql.PLSqlParserRelatedFiles.PLSqlParserExecuter;
import parser.enumeration.Language;
import parser.parserinterface.IParser;
import parser.parserinterface.ParserInterfaceAndFileList;
import categorizer.core.DataSet;

import common.DataContext;
import common.DirectoryListing;
import common.ParseResult;
import common.monitor.Logger;
import definitions.application.ApplicationProperties;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class ParserExecutor {

	private static List<ParseResult> parserResultList = new ArrayList<ParseResult>();
	private static DataSet arffDataSet;
	private static Language currentLanguage;
	private static JPanel mainPanel;
	private static CategorizerExecutor categorizerExecutor;
	public static final int PARSING_SUCCESSFUL = 0;
	public static final int PARSING_CANCELLED = 1;

	public static void main(String[] args) {

		File projectDirectory = getProjectDirectoryFromUser();
		
		try {
			parseDirectory(projectDirectory);
		} catch (Exception e) {
			System.out.println("exception");
		}

		System.out.println("done");
	}

	public static int parseDirectory(File projectDirectory) throws Exception {

		List<ParserInterfaceAndFileList> parserList = new ArrayList<ParserInterfaceAndFileList>();

		parserList = findAppropriateParsers(projectDirectory);
		showParserSelectionDialog(parserList);

		if (parserList == null) {
			return PARSING_CANCELLED;
		} else {
			parserResultList.clear();
			System.out.println("project directory:"+ projectDirectory
					.getName());
			parserResultList = new ArrayList<ParseResult>();
			for (ParserInterfaceAndFileList parserAndFiles : parserList) {
				DataContext thisOne = parseProject(parserAndFiles.getParser(),
						parserAndFiles.getFileList(), projectDirectory
								.getName());
				if (thisOne == null) {
					Logger.error("Error in parsing with: "
							+ parserAndFiles.getParser().getLanguage()
									.getLangName());
				} else {
					parserResultList.add(new ParseResult(parserAndFiles
							.getParser().getLanguage(), thisOne));
				}
			}
			return PARSING_SUCCESSFUL;
		}
	}

	// same as the parseDirectory function, but altered for the command line
	// execution
	public static int parseDirectoryCmd(File projectDirectory) throws Exception {

		List<ParserInterfaceAndFileList> parserList = new ArrayList<ParserInterfaceAndFileList>();

		parserList = findAppropriateParsers(projectDirectory);

		if (parserList == null) {
			return PARSING_CANCELLED;
		} else {
			parserResultList.clear();
			parserResultList = new ArrayList<ParseResult>();
			
			for (ParserInterfaceAndFileList parserAndFiles : parserList) {
				DataContext thisOne = parseProject(parserAndFiles.getParser(),
						parserAndFiles.getFileList(), projectDirectory
								.getName());
				if (thisOne == null) {
					Logger.error("Error in parsing with: "
							+ parserAndFiles.getParser().getLanguage()
									.getLangName());
				} else {
					parserResultList.add(new ParseResult(parserAndFiles
							.getParser().getLanguage(), thisOne));
				}
			}
			return PARSING_SUCCESSFUL;
		}
	}

	public static void confirmParserWithUser(
			List<ParserInterfaceAndFileList> parserList) {

		if (parserList != null) {
			Object[] options = { "OK" };

			String message = "Project will be parsed by ";
			for (ParserInterfaceAndFileList pf : parserList) {
				message += pf.getParser().getLanguage().getLangName() + ", ";
			}
			message = message.substring(0, message.length() - 2);

			JOptionPane.showOptionDialog(null, message,
					"Parser Language Selection", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		}

	}

	public static List<ParserInterfaceAndFileList> findAppropriateParsers(
			File projectDirectory) {
		List<ParserInterfaceAndFileList> parserList = new ArrayList<ParserInterfaceAndFileList>();

		for (Language lang : Language.LIST) {
			DirectoryListing dl = new DirectoryListing();
			List<File> fileList = new ArrayList<File>();
			dl.visitAllFiles_Filtered(projectDirectory, lang.getExtension());
			fileList.addAll(dl.getFilteredFileNames());
			if (fileList != null && fileList.size() > 0) {

				IParser parser = constructParser(lang);

				if (parser != null) {
					parser.setLanguage(lang);
					ParserInterfaceAndFileList pf = new ParserInterfaceAndFileList();
					pf.setParser(parser);
					pf.setFileList(fileList);
					parserList.add(pf);
				}
			}
		}
		return parserList;
	}

	public static IParser constructParser(Language lang) {
		if (lang.equals(Language.JAVA)) {
			return new JavaParser(System.in);
		} else if (lang.equals(Language.C)) {
			return new CParser();
		} else if (lang.equals(Language.CPP)) {
			return new CPPParserExecutor();
		} else if (lang.equals(Language.JSP)) {
			return new JavaParser(System.in);
		} else if (lang.equals(Language.PLSQL)) {
			return new PLSqlParserExecuter();
		} else {
			return null;
		}
	}

	public static File getProjectDirectoryFromUser() {
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

	public static DataContext parseProject(IParser aParser,
			List<File> fileList, String projectName) throws Exception {
		String fileSeparator = "";

		if (aParser != null && fileList != null) {
			String[] fileNames = new String[fileList.size()];
			for (int index = 0; index < fileList.size(); index++) {
				fileNames[index] = fileList.get(index).getAbsolutePath();
				
				// just for once get the separator for the current operating system
				if(index == 0){
					fileSeparator = fileList.get(index).separator.toString();
				}
			}

			DataContext metrics = null;
			try {
				File directoryToCreate = new File (ApplicationProperties
				.get("repositorylocation")
				+ fileSeparator
				+ projectName
				+ fileSeparator+ "parse_results");
				
				// if the directory does not exist, then we create it
				if (!directoryToCreate.exists()) {
					directoryToCreate.mkdir();
				}
				
				String xmlFileName = ApplicationProperties
						.get("repositorylocation")
						+ fileSeparator
						+ projectName
						+ fileSeparator+ "parse_results"+ fileSeparator +"parseResult"
						+ "_"
						+ aParser.getLanguage().getLangName()
						+ "_"
						+ Calendar.getInstance().getTimeInMillis() + ".xml";
				String packageCsvFileName = ApplicationProperties
						.get("repositorylocation")
						+ fileSeparator
						+ projectName
						+ fileSeparator+ "parse_results"+ fileSeparator +"parseResult"
						+ "_"
						+ aParser.getLanguage().getLangName()
						+ "_"
						+ Calendar.getInstance().getTimeInMillis()
						+ "PACKAGE.csv";
				String fileCsvFileName = ApplicationProperties
						.get("repositorylocation")
						+ fileSeparator
						+ projectName
						+ fileSeparator+ "parse_results"+ fileSeparator +"parseResult"
						+ "_"
						+ aParser.getLanguage().getLangName()
						+ "_"
						+ Calendar.getInstance().getTimeInMillis() + "FILE.csv";
				String classCsvFileName = ApplicationProperties
						.get("repositorylocation")
						+ fileSeparator
						+ projectName
						+ fileSeparator+ "parse_results"+ fileSeparator +"parseResult"
						+ "_"
						+ aParser.getLanguage().getLangName()
						+ "_"
						+ Calendar.getInstance().getTimeInMillis()
						+ "CLASS.csv";
				String methodCsvFileName = ApplicationProperties
						.get("repositorylocation")
						+ fileSeparator
						+ projectName
						+ fileSeparator+ "parse_results"+ fileSeparator +"parseResult"
						+ "_"
						+ aParser.getLanguage().getLangName()
						+ "_"
						+ Calendar.getInstance().getTimeInMillis()
						+ "METHOD.csv";

				metrics = aParser.startExecution(fileNames, projectName,
						xmlFileName, packageCsvFileName, fileCsvFileName,
						classCsvFileName, methodCsvFileName);
			} catch (Exception e) {
				Logger.error(ParserExecutor.class.getName() + " "
						+ "error in parsing " + projectName + " "
						+ e.getMessage());
			}

			return metrics;

		} else {
			return null;
		}
	}

	public static void fillWithOldResults(List<String> oldParseResultFiles,
			List<Language> langList) {
		for (int l = 0; l < parserResultList.size(); l++) {
			parserResultList.set(l, null);
		}
		parserResultList.clear();
		parserResultList = new ArrayList<ParseResult>();
		for (int i = 0; i < oldParseResultFiles.size(); i++) {
			DataContext metrics = null;
			try {
				metrics = DataContext.readFromFile(oldParseResultFiles.get(i));
			} catch (Exception e) {
				System.out.println("Error reading "
						+ oldParseResultFiles.get(i));
			}
			if (metrics != null) {
				ParseResult result = new ParseResult(langList.get(i), metrics);
				if (result != null) {
					parserResultList.add(result);
				}
			}
		}
	}

	public static DataSet getDataSetByMetricGroup(int metricType,
			Language givenLang, boolean dataSetOpened) {
		DataSet ds = null;

		if (dataSetOpened)
			return arffDataSet;
		else {
			if (parserResultList != null) {
				for (ParseResult parseResult : parserResultList) {
					if (parseResult.getParserLanguage().equals(givenLang)) {
						return parseResult.getDataSetByMetricType(metricType);
					}
				}
			}
		}
		return ds;
	}

	public static void setDataSetByMetricGroup(int metricType,
			Language givenLang, DataSet ds) {
		if (parserResultList != null) {
			for (ParseResult parseResult : parserResultList) {
				if (parseResult.getParserLanguage().equals(givenLang)) {
					parseResult.setDataSetByMetricType(metricType, ds);
				}
			}
		}
	}

	public static void showParserSelectionDialog(
			List<ParserInterfaceAndFileList> parserList) {
		final JDialog dialog = new JDialog();
		dialog.setTitle("Parser Language Selection");
		dialog.setModal(true);
		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		dialog.setLocationRelativeTo(mainPanel);
		dialog.setLocation((dialog.getX() - 50), (dialog.getY() - 10));
		dialog.setPreferredSize(new Dimension(430, 200));
		// Create and set up the content pane.
		ParserLanguageCheckBoxDialog newContentPane = new ParserLanguageCheckBoxDialog(
				parserList, dialog);
		newContentPane.setOpaque(true); // content panes must be opaque
		dialog.getContentPane().add(newContentPane.getJPane());

		// Display the window
		dialog.pack();
		dialog.setVisible(true);
	}

	public static List<ParseResult> getParserResultList() {
		return parserResultList;
	}

	public static void setParserResultList(List<ParseResult> parserResultList) {
		ParserExecutor.parserResultList = parserResultList;
	}

	public static JPanel getMainPanel() {
		return mainPanel;
	}

	public static void setMainPanel(JPanel mainPanel) {
		ParserExecutor.mainPanel = mainPanel;
	}

	public static DataSet getArffDataSet() {
		return arffDataSet;
	}

	public static void setArffDataSet(DataSet arffDataSet) {
		ParserExecutor.arffDataSet = arffDataSet;
	}

	public static CategorizerExecutor getCategorizerExecutor() {
		return categorizerExecutor;
	}

	public static void setCategorizerExecutor(
			CategorizerExecutor categorizerExecutor) {
		ParserExecutor.categorizerExecutor = categorizerExecutor;
	}

	public static class ParserLanguageCheckBoxDialog extends JPanel implements
			ActionListener {

		public JButton continueButton;
		public List<ParserInterfaceAndFileList> parserList;
		public List<JCheckBox> checkBoxList;
		public JLabel selectLabel;
		public JPanel jPane;
		public JDialog jDialog;

		public ParserLanguageCheckBoxDialog(
				List<ParserInterfaceAndFileList> parserList, JDialog jDialog) {
			this.jDialog = jDialog;
			this.parserList = parserList;
			checkBoxList = new ArrayList<JCheckBox>();
			for (ParserInterfaceAndFileList parserInterfaceAndFileList : parserList) {
				JCheckBox checkBox = new JCheckBox(parserInterfaceAndFileList
						.getParser().getLanguage().getLangName());
				checkBox.setHorizontalAlignment(SwingConstants.CENTER);
				checkBox.setSelected(true);
				checkBoxList.add(checkBox);
			}
			jPane = new JPanel();

			SpringLayout layout = new SpringLayout();
			jPane.setLayout(layout);

			selectLabel = new JLabel(
					"Please select the parser languages you want to use for the project:");

			continueButton = new JButton("Continue");
			continueButton.addActionListener(this);

			jPane.add(selectLabel);
			for (JCheckBox checkBox : checkBoxList) {
				jPane.add(checkBox);
			}
			jPane.add(continueButton);

			layout.putConstraint(SpringLayout.WEST, selectLabel, 20,
					SpringLayout.WEST, jPane);
			layout.putConstraint(SpringLayout.NORTH, selectLabel, 30,
					SpringLayout.NORTH, jPane);
			int initial = 10;
			for (JCheckBox checkBox : checkBoxList) {
				layout.putConstraint(SpringLayout.WEST, checkBox, initial,
						SpringLayout.WEST, jPane);
				layout.putConstraint(SpringLayout.NORTH, checkBox, 20,
						SpringLayout.SOUTH, selectLabel);
				initial += 60;
			}
			layout.putConstraint(SpringLayout.WEST, continueButton, 200,
					SpringLayout.WEST, jPane);
			layout.putConstraint(SpringLayout.NORTH, continueButton, 100,
					SpringLayout.NORTH, jPane);
		}

		public JPanel getJPane() {
			return jPane;
		}

		public void setJPane(JPanel jPane) {
			this.jPane = jPane;
		}

		public void actionPerformed(ActionEvent e) {
			getSelectedParsers();
			this.jDialog.dispose();
		}

		public void getSelectedParsers() {

			List<ParserInterfaceAndFileList> returnList = new ArrayList<ParserInterfaceAndFileList>();
			for (int i = 0; i < checkBoxList.size(); i++) {
				if (checkBoxList.get(i).isSelected()) {
					returnList.add(parserList.get(i));
				}
			}
			parserList.clear();
			for (ParserInterfaceAndFileList item : returnList) {
				parserList.add(item);
			}

		}
	}

	public static Language getCurrentLanguage() {
		return currentLanguage;
	}

	public static void setCurrentLanguage(Language currentLanguage) {
		ParserExecutor.currentLanguage = currentLanguage;
	}
}
