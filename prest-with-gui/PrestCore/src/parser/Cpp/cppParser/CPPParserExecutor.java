package parser.Cpp.cppParser;

import java.util.Iterator;

import metricCollector.Collector;
import metricCollector.JavaClassMetrics;
import metricCollector.JavaFileMetrics;
import metricCollector.JavaMethodMetrics;
import metricCollector.JavaPackageMetrics;
import parser.Java.MetricsRelatedFiles.ClassContainer;
import parser.enumeration.Language;
import parser.parserinterface.IParser;

import common.DataContext;
import common.monitor.Logger;

public class CPPParserExecutor implements IParser {

	public CPPParserExecutor() {
		super();
	}

	Language language = Language.CPP;

	public DataContext startExecution(String fileNames[], String projectName,
			String xmlFileName, String packageCsvFileName,
		    String fileCsvFileName, String classCsvFileName, String methodCsvFileName) {

		CPPParser parser = new CPPParser(System.in);

		ClassContainer con = parser.IdentifyModules(fileNames);
		try {
			con.writeToFileAsXml(xmlFileName);
			con.writeToFileAsXls(xmlFileName, packageCsvFileName,
				    fileCsvFileName, classCsvFileName, methodCsvFileName); // converts the given xml to csv file
		} catch (Exception e) {
			System.out.println("file exception");
			e.printStackTrace();
			Logger.error(e.getMessage());
		}
		return con.getDataContextFormat();
	}

	/*
	 * public static void main(String args[]) { JFileChooser fileChooser = new
	 * JFileChooser(); fileChooser.setDialogTitle("Select folder to parse
	 * (CPP)"); fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	 * int returnVal = fileChooser.showOpenDialog(null);
	 * 
	 * File dir = null; if (returnVal == JFileChooser.APPROVE_OPTION) { dir =
	 * fileChooser.getSelectedFile(); }
	 * 
	 * DirectoryListing dl = new DirectoryListing();
	 * dl.visitAllFiles_Filtered(dir, "cpp"); List<File> list =
	 * dl.getFilteredFileNames(); String[] fileNames = new String[list.size()];
	 * for (int index = 0; index < list.size(); index++) { fileNames[index] =
	 * list.get(index).getAbsolutePath(); }
	 * 
	 * CPPParser parser = new CPPParser(System.in);
	 * 
	 * Collector col = parser.IdentifyModules(fileNames);
	 * 
	 * for (Iterator<String> pk = col.getPackageNames(); pk.hasNext();) {
	 * JavaPackageMetrics pm = col.getPackage(pk.next());
	 * System.out.printf("%s\n", pm.Name());
	 * 
	 * for (Iterator<String> fk = pm.getFileNames(); fk.hasNext();) {
	 * JavaFileMetrics fm = pm.getFile(fk.next()); System.out.printf("\t%s\n",
	 * fm.Name());
	 * 
	 * for (Iterator<String> ck = fm.getClassNames(); ck.hasNext();) {
	 * JavaClassMetrics cm = fm.getClass(ck.next());
	 * System.out.printf("\t\t%s\n", cm.Name()); for (Iterator<String> mk =
	 * cm.getMethodNames(); mk .hasNext();) { JavaMethodMetrics mm =
	 * cm.getMethod(mk.next()); System.out.printf("\t\t\t%s\n", mm.Name()); } } } } }
	 */

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
}
