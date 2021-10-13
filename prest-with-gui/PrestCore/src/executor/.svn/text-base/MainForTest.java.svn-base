package executor;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import parser.C.CParser;
import parser.Cpp.cppParser.CPPParserExecutor;
import parser.Java.JavaParserRelatedFiles.JavaParser;
import parser.enumeration.Language;
import parser.parserinterface.IParser;
import parser.parserinterface.ParserInterfaceAndFileList;

import common.DataContext;
import common.DirectoryListing;
import common.MetricGroup;
import common.NodePair;

public class MainForTest {

	public static final String target_file = "test";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		File projectDirectory = getProjectDirectoryFromUser();

		try {
			parseDirectory(projectDirectory);
		} catch (Exception e) {
			System.out.println("exception");
		}

		System.out.println("done");
	}

	/**
	 * @author G�rhan, Caner
	 * @param projectDirectory
	 */
	private static void parseDirectory(File projectDirectory) throws Exception {

		List<ParserInterfaceAndFileList> parserList = new ArrayList<ParserInterfaceAndFileList>();

		parserList = findAppropriateParsers(projectDirectory);

		informParserWithUser(parserList);

		DataContext result = new DataContext();

		for (ParserInterfaceAndFileList parserAndFiles : parserList) {
			DataContext thisOne = parseProject(parserAndFiles.getParser(),
					parserAndFiles.getFileList());
//			result.append(thisOne);
		}

//		result.writeToFile(target_file);

	}

	private static IParser confirmParserWithUser(File projectDirectory,
			IParser parser, List<File> fileList) {

		if (parser != null) {

			Object[] options = { "YES", "NO", "CANCEL" };
			int decision;

			decision = JOptionPane.showOptionDialog(null,
					"Project will be parsed by "
							+ parser.getLanguage().getLangName()
							+ " Parser.\nDo you want to continue?",
					"Parser Language Selection",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			if (decision == 1) {

			} else if (decision == 2) {
				fileList.clear();
				return null;
			}
		} else {
			Object[] options = { "YES", "CANCEL" };
			int decision;

			decision = JOptionPane.showOptionDialog(null,
					"Prest can not find an appropriate parser for your project.\n"
							+ "Do you want to select the parser manually?",
					"Parser Language Selection", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			if (decision == 0) {

			} else if (decision == 1) {
				fileList.clear();
				return null;
			}
		}

		return parser;
	}

	private static void informParserWithUser(
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

	private static List<ParserInterfaceAndFileList> findAppropriateParsers(
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

	private static IParser constructParser(Language lang) {
		if (lang.equals(Language.JAVA)) {
			return new JavaParser(System.in);
		} else if (lang.equals(Language.C)) {
			return new CParser();
		} else if (lang.equals(Language.CPP)) {
			return new CPPParserExecutor();
		} else {
			return null;
		}
	}

	private static File getProjectDirectoryFromUser() {
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

	private static DataContext parseProject(IParser aParser, List<File> fileList)
			throws Exception {

		if (aParser != null && fileList != null) {
			String[] fileNames = new String[fileList.size()];
			for (int index = 0; index < fileList.size(); index++) {
				fileNames[index] = fileList.get(index).getAbsolutePath();
			}

			DataContext metrics = null;
			try {
				} catch (Exception e) {
				e.printStackTrace();
			}

			return metrics;

		} else {
			return null;
		}
	}
	
/*
	public static void processMetrics(DataContext metrics) {

		List<MetricGroup> packageMetrics = new ArrayList<MetricGroup>();
		List<MetricGroup> fileMetrics = new ArrayList<MetricGroup>();
		List<MetricGroup> classMetrics = new ArrayList<MetricGroup>();
		List<MetricGroup> methodMetrics = new ArrayList<MetricGroup>();

		Iterator<String> packageIterator = metrics.iterator();
		while (packageIterator.hasNext()) {
			String packageKey = packageIterator.next();
			MetricGroup packageMetricGroup = new MetricGroup();
			packageMetricGroup.setGroupName(packageKey);
			DataContext packageCandidate = metrics.getNode(packageKey);
			if (packageCandidate != null) {

				Iterator<String> fileIterator = packageCandidate.iterator();
				while (fileIterator.hasNext()) {
					String fileKey = fileIterator.next();
					MetricGroup fileMetricGroup = new MetricGroup();
					fileMetricGroup.setGroupName(fileKey);
					DataContext fileCandidate = packageCandidate
							.getNode(fileKey);
					if (fileCandidate == null) {
						Object fileObject = packageCandidate
								.getFirstNodeValue(fileKey);
						if (fileObject != null) {
							String valuefile = fileObject.toString();
							NodePair aMetric = new NodePair(fileKey, valuefile);
							packageMetricGroup.addToMetricList(aMetric);
						}
					} else {

						Iterator<String> classIterator = fileCandidate.iterator();
						while (classIterator.hasNext()) {
							String classKey = classIterator.next();
							MetricGroup clasMetricGroup = new MetricGroup();
							clasMetricGroup.setGroupName(classKey);
							DataContext classCandidate = fileCandidate
									.getNode(classKey);
							if (classCandidate == null) {
								Object classObject = fileCandidate
										.getFirstNodeValue(classKey);
								if (classObject != null) {
									String valueclas = classObject.toString();
									NodePair aMetric = new NodePair(classKey,
											valueclas);
									fileMetricGroup.addToMetricList(aMetric);
								}
							} else {

								Iterator<String> methodIterator = classCandidate.iterator();
								while (methodIterator.hasNext()) {
									String methodKey = methodIterator.next();
									DataContext methodCandidate = classCandidate
											.getNode(methodKey);
									if (methodCandidate == null) {
										Object methodObject = classCandidate
												.getFirstNodeValue(methodKey);
										if (methodObject != null) {
											String valuemethod = methodObject
													.toString();
											NodePair aMetric = new NodePair(
													methodKey, valuemethod);
											clasMetricGroup
													.addToMetricList(aMetric);
										}
									} else {
										MetricGroup methodMetricGroup = new MetricGroup();
										methodMetricGroup
												.setGroupName(methodKey);
										Iterator<String> insideMethodIterator = methodCandidate.iterator();
										while (insideMethodIterator.hasNext()) {
											String methodMetric = insideMethodIterator
													.next();
											String value = (String) methodCandidate
													.getFirstNodeValue(methodMetric);
											NodePair aMetric = new NodePair(
													methodMetric, value);
											methodMetricGroup
													.addToMetricList(aMetric);
										}
										if (methodMetricGroup.getNodePairList()
												.size() > 0) {
											methodMetrics
													.add(methodMetricGroup);
										}
									}
								}
							}
							if (clasMetricGroup.getNodePairList().size() > 0)
								classMetrics.add(clasMetricGroup);
						}
					}
					if (fileMetricGroup.getNodePairList().size() > 0)
						fileMetrics.add(fileMetricGroup);
				}

			}
			if (packageMetricGroup.getNodePairList().size() > 0)
				packageMetrics.add(packageMetricGroup);

		}

	}
*/
}
