package common;

import weka.core.Instances;
import weka.core.converters.CSVLoader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import org.apache.log4j.Logger;

import console.PrestConsoleApp;

public class CsvToArff {

	static Logger logger = Logger.getLogger(PrestConsoleApp.class.getName());

    public CsvToArff() {
    }

    public void convertProject(File projectPath) throws Exception {
	File csvSources = new File(projectPath.getPath() + File.separator +"parse_results" + File.separator);
	String[] projectFiles = csvSources.list();

	for (int i = 0; i < projectFiles.length; i++) {
	    if (projectFiles[i].endsWith("csv")
		    && !projectFiles[i].startsWith("callGraph_Java")) {
		this.csvToArff(projectPath.getPath() + File.separator +  "parse_results" + File.separator
			+ projectFiles[i], projectFiles[i], projectPath
			.getPath());
	    }

	}

    }

    public int csvToArffCommand(String csvFilePath, String outputPath) {
    	try {
    	    CSVLoader loader = new CSVLoader();
    	    loader.setSource(new File(csvFilePath));
    	    Instances data = loader.getDataSet();
    	    String path = csvFilePath.substring(0, csvFilePath
    				    .lastIndexOf(File.separator));
    	    String fileName = csvFilePath.substring(csvFilePath.lastIndexOf(File.separator)+1);
    	    String outputFile = "";
    	    
    	    if(outputPath == null)
    	    	outputFile = path.substring(0,path.lastIndexOf(File.separator))
				    + File.separator +"arff_files" + File.separator
				    + fileName.substring(0, fileName
					    .lastIndexOf('.')) + ".arff";
			else
				outputFile = outputPath;
    	    
    	    BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
    	    
    	    writer.write(data.toString());
    	    writer.flush();
    	    writer.close();
    	    logger.info(csvFilePath + " converted successfully.");
    	} catch (Exception e) {
    		
    	    logger.error(e.getMessage());
    	}
    	return 1;
        }
    private int csvToArff(String csvFilePath, String csvFileName,
	    String projectPath) {
	try {
	    CSVLoader loader = new CSVLoader();
	    loader.setSource(new File(csvFilePath));
	    Instances data = loader.getDataSet();
	    BufferedWriter writer = new BufferedWriter(new FileWriter(
		    projectPath
			    + File.separator +"arff_files" + File.separator
			    + csvFileName.substring(0, csvFileName
				    .lastIndexOf('.')) + ".arff"));
	    writer.write(data.toString());
	    writer.flush();
	    writer.close();

	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
	return 1;
    }
}