/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package console;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.ApplicationProperties;
import common.ArffUtils;
import common.DirectoryListing;
import executor.ParserExecutor;
import common.CsvToArff;
import predictor.WekaRunner;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.CSVLoader;

import org.apache.log4j.Logger;

public class PackageExplorer {

	static Logger logger = Logger.getLogger(PrestConsoleApp.class.getName());
	private HashMap<String, File> projectNamesHashMap = new HashMap<String, File>();
	private File projectDirectory;

	public PackageExplorer() {
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
			output = new BufferedWriter(new FileWriter(
					new File(ApplicationProperties.get("repositorylocation")
							+ File.separator + projectDirectory.getName()
							+ File.separator + "project.metadata")));
			output.write(projectDirectory.getAbsolutePath());
		} catch (Exception ex) {
		} finally {
			try {
				output.close();
			} catch (IOException ex) {
			}
		}
	}

	@SuppressWarnings("unchecked")
	public boolean searchRepository(File newDirectory) {
		common.DirectoryListing dlx = new DirectoryListing();
		dlx.visitAllOneLevelDirs(new File(ApplicationProperties
				.get("repositorylocation")
				+ File.separator));
		List dirNames = dlx.getDirNames();
		List<File> dirList = dirNames;
		if (dirList != null) {
			for (File projectDir : dirList) {
				if (projectDir.getName().equals(newDirectory.getName())) {
					logger.info(" *** " + projectDir.getName() + " "
							+ newDirectory.getName());
					return true;
				}
			}
		}
		return false;
	}

	public void addNewProjectCmd(String projectDirectoryStr) {
		File projectDirectory = new File(projectDirectoryStr);
		if (projectDirectory != null) {
			if (!searchRepository(projectDirectory)) {
				new File(ApplicationProperties.get("repositorylocation") + File.separator
						+ projectDirectory.getName()).mkdirs();
				new File(ApplicationProperties.get("repositorylocation") + File.separator
						+ projectDirectory.getName() + File.separator+ "parse_results")
						.mkdirs();
				new File(ApplicationProperties.get("repositorylocation") + File.separator
						+ projectDirectory.getName() + File.separator +"arff_files").mkdirs();
				createMetadataForProject(projectDirectory);
			} else {
				logger.warn("The project you tried to add has already been added!");
			}
		}
	}

	public void parseManualCmd(String projectDirectoryStr, String freeze, String fileCsvPath, String methodCsvPath, String classCsvPath) {
		int result;
		try {
			File projectDirectory = new File(projectDirectoryStr);
			result = ParserExecutor.parseDirectoryCmd(projectDirectory, fileCsvPath, methodCsvPath, classCsvPath, freeze);
			if (result == ParserExecutor.PARSING_SUCCESSFUL) {
				logger.info("Project parsed successfully.");
//				DefectMatcher.main(new String[] {projectDirectory.getName(), releaseLabel, ApplicationProperties
//						.get("repositorylocation")
//						+ File.separator
//						+ projectDirectory.getName()
//						+ File.separator + "parse_results"});
			} else {
				logger.error("There was an error while parsing the project.");
			}
		} catch (Exception ex) {

		}
	}
	

	
	public void convertCsvToArff(String fileName, String outputPath) {
		CsvToArff c = new CsvToArff();
		try {
			CsvToArff cCommand = new CsvToArff();
			cCommand.csvToArffCommand(fileName, outputPath);
		} catch (Exception eCtoArff) {
			logger.error("csv File name wrong or file corrupt!");
		}
	}
	/* This function applies log filtering on metric values.
	 * input: filename (at file level) 
	 * output: (true) if new file with log-filtered attributes
	 * IMPORTANT!!: Due to hard-coded attribute indices, this function works for file level only.
	 * */
	public boolean logFiltering(String filename)
	{
		ArffLoader loader = new ArffLoader();
		Instances data;
		BufferedWriter writer = null;
		boolean methodLevel = false;
	    try 
	    {
	    	logger.info(filename);
			loader.setSource(new File(filename));
			data = loader.getDataSet();
			data.setClassIndex(data.numAttributes()-1);
			if(data.attribute(2).name().equals("Method Name"))
				methodLevel = true;
			
			Instances newdata = new Instances(data, data.numInstances());
			
			for(int j=0; j<data.numAttributes(); j++)
			{
			//	System.out.println("Attribute: " + j);
				for(int i=0; i<data.numInstances(); i++)
				{
			//		System.out.println("Instance: " + i);
					if(j==0) //Filename
					{
						newdata.add(data.instance(i));
						newdata.instance(i).setValue(j, data.instance(i).stringValue(j));
					}
					else if (j==1) //File ID
						newdata.instance(i).setValue(j, data.instance(i).value(j));
					else if (j==data.numAttributes()-1) //Class attribute
						newdata.instance(i).setClassValue(data.instance(i).stringValue(j));
					else
					{
						if(methodLevel)
						{
							if(j!= 2 && j!=3)
							{
								if(data.instance(i).value(j) != 0)
									newdata.instance(i).setValue(j, Math.log(data.instance(i).value(j)));
								else
									newdata.instance(i).setValue(j, Math.log(0.0001));
							}
						}
						else
						{
							if(data.instance(i).value(j) != 0)
								newdata.instance(i).setValue(j, Math.log(data.instance(i).value(j)));
							else
								newdata.instance(i).setValue(j, Math.log(0.0001));
						}
					}
				}
			}
		
			logger.info("Writing to new file...");
			String outFile = filename.substring(0, filename.lastIndexOf(".")); 
			logger.info(outFile);
			writer = new BufferedWriter(new FileWriter(outFile + "_LF.arff"));
						
			writer.write(newdata.toString());
    	    writer.flush();
    	    writer.close();
    	    logger.info("Log filter is applied to " + filename + " successfully");
		} 
	    catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Log filter could not be processed due to IOException");
			e.printStackTrace();
			return false;
		}
	    
	    return true;  
	}

	/* this function takes values at method level 
	 * and aggregates them up to file level.
	 * input: filename (method level)
	 * output: (true) if new file with aggregated values
	 * */
	public boolean aggregateMethod2File(String file)
	{
		return ArffUtils.aggregateMethod2File(file);
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
	
	public String predict(String trainFile,String testFile, String resultPath, String fileFilter, String changeDiff) {
		String wekaAlgorithmType = "Naive Bayes";
		String wekaPreProcess = "none";
		String wekaCrossValidate = "no";
		String wekaLogFilter = "no";
		String retStr = "";
		int diffSpan;
		try
		{
			diffSpan = Integer.parseInt(changeDiff);
		}
		catch (Exception e)
		{
			diffSpan = 5;
		}
		retStr = WekaRunner.runWeka(trainFile,testFile,wekaAlgorithmType,wekaPreProcess,wekaCrossValidate,wekaLogFilter, resultPath, fileFilter, diffSpan); 
		return retStr;
	}
	
	public void addChanges(String sourceRoot, String arffFile, String changesFile, String freeze, String resultPath) {
		ArffUtils.addChanges(sourceRoot, arffFile, changesFile, Integer.parseInt(freeze.charAt(7) + "" + freeze.charAt(9) + freeze.charAt(10)), resultPath);
	}

	
	public void setRepoCmd(String repoPath)
	{
		ApplicationProperties.setRepositoryLocation(null, repoPath);
		
	}
}
