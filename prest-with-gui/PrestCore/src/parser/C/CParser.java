package parser.C;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;

import parser.C.constants.CConstants;
import parser.C.fileops.ConvertToDataContext;
import parser.C.fileops.Module;
import parser.C.fileops.Parser;
import parser.C.fileops.SourceFile;
import parser.enumeration.Language;
import parser.parserinterface.IParser;

import common.DataContext;
import definitions.application.ApplicationProperties;

public class CParser implements IParser {

	Language language = Language.C;
	String workspace = "default_C_workspace";
	String className = "default_C_class";

	public String CALLGRAPHFILE;

	public CParser() {

	}

	// the following linked list will keep all the modules
	// in all the source files
	public LinkedList<Module> allModules = new LinkedList<Module>();
	// added by ekrem
	// the following 2D array will contain the function call matrix
	public String functionCallMatrix[][];

	public DataContext startExecution(String[] files, String projectName,String xmlFileName, String packageCsvFileName,
		    String fileCsvFileName, String classCsvFileName, String methodCsvFileName)
			throws Exception {
		CALLGRAPHFILE = ApplicationProperties.get("repositorylocation") + File.separator + projectName + File.separator +"callGraph" + "_"
				+ Language.C.getLangName() + ".csv";

		DataContext general = new DataContext();
		general.add(workspace, new DataContext());
		DataContext metrics = general.getNode(workspace);
		for (int i = 0; i < files.length; i++) {
			File currentFile = new File(files[i]);
			Parser parser = new Parser(currentFile);
			LinkedList<Module> modules = parser.getModules();
			SourceFile sf = parser.getSourceFile();
			DataContext fileMetrics = ConvertToDataContext
					.createMetricsDataContext(sf,
							CConstants.FILE_METRICS_HEADER);
			metrics.add(currentFile.getName(), fileMetrics);
			Iterator<Module> itr2 = modules.iterator();

			DataContext currentFileDataContext = metrics.getNode(currentFile
					.getName());
			while (itr2.hasNext()) {
				Module m = itr2.next();
				if (m.isHasBlock() && (m.getType() == Module.FUNCTION)
						&& !(m.getName().equalsIgnoreCase(""))) {
					DataContext moduleMetrics = ConvertToDataContext
							.createMetricsDataContext(m,
									CConstants.MODULE_METRICS_HEADER);
					currentFileDataContext.add(className + "/" + m.getName(),
							moduleMetrics);
					// this module is a function module
					// so add it to allModules
					allModules.add(m);
				}
			}
		}

		// the following function will make a csv file
		// which will contain the function call matrix
		buildFunctionCallMatrix(CALLGRAPHFILE);

		general.writeToFile(xmlFileName);
		return general;

	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	/**
	 * added as a patch to build a function call matrix
	 */
	public void buildFunctionCallMatrix(String fileName) {
		int dimension;
		// get the size of the array
		dimension = allModules.size();
		// create the 2D array of strings
		functionCallMatrix = new String[dimension + 1][dimension + 1];
		// define an iterator for allModules
		Iterator<Module> allModulesItr = allModules.iterator();

		// assign * to 0*0 position of the 2D array
		functionCallMatrix[0][0] = "*";
		// copy the names of the modules to the edges of the 2D array
		for (int i = 1; i <= dimension; i++) {
			functionCallMatrix[i][0] = allModulesItr.next().getName();
			functionCallMatrix[0][i] = functionCallMatrix[i][0];
		}

		Iterator<Module> allModulesItr2 = allModules.iterator();

		for (int i = 1; i <= dimension; i++) {
			Module moduleToCheck = new Module();
			moduleToCheck = allModulesItr2.next();
			// System.out.println( "\n" );
			for (int j = 1; j <= dimension; j++) {

				if (moduleToCheck.getCalledFunctions().contains(
						functionCallMatrix[0][j])) {
					functionCallMatrix[i][j] = "1";
				} else {
					functionCallMatrix[i][j] = "0";
				}
			}
		}

		try {
			File functionCallMatrixFile = new File(fileName);
			functionCallMatrixFile.createNewFile();
			FileOutputStream fosFuncCallMatrix = new FileOutputStream(
					functionCallMatrixFile);

			StringBuffer line = new StringBuffer("");
			for (int i = 0; i <= dimension; i++) {
				for (int j = 0; j <= dimension; j++) {
					line.append(functionCallMatrix[i][j]);
					line.append(",");
				}
				line.append("\n");
				fosFuncCallMatrix.write(line.toString().getBytes());
				line.delete(0, line.length());
			}
			fosFuncCallMatrix.close();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

	}

}
