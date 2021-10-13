package parser.PLSql.PLSqlParserRelatedFiles;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import parser.PLSql.MetricsRelatedFiles.PLSqlCommonMetrics;
import parser.PLSql.MetricsRelatedFiles.PLSqlConstants;
import parser.PLSql.MetricsRelatedFiles.PLSqlContainer;
import parser.PLSql.MetricsRelatedFiles.PLSqlFileMetrics;
import parser.PLSql.MetricsRelatedFiles.PLSqlMethodMetrics;
import parser.PLSql.MetricsRelatedFiles.PLSqlPackageMetrics;
import parser.enumeration.Language;
import parser.parserinterface.IParser;

import common.data.DataContext;

public class PLSqlParserExecuter implements IParser {
	Language language = Language.PLSQL;
	//String workspace = "default_PLSQL_workspace";
	String className = "default_PLSQL_class";

	public PLSqlParserExecuter() {
		super();
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;		
	}

	public DataContext startExecution(String[] files,
			String projectName, String xmlFileName, String packageCsvFileName,
			String fileCsvFileName, String classCsvFileName,
			String methodCsvFileName) throws Exception {

		SoftwareMetrics.addAllStaticRules();

		//DataContext generalDC = new DataContext();
		//generalDC.add(workspace, new DataContext());
		//DataContext metrics = generalDC.getNode(workspace);
		DataContext metrics = new DataContext();

		//********************************************************************
		//prepare cvs files
		prepareCsv(fileCsvFileName, packageCsvFileName, methodCsvFileName);
		
		for (int i = 0; i < files.length; i++) {
			//File currentFile = new File(files[i]);
			String fileAddress = files[i];

			//PLSQL Container
			PLSqlContainer plsqlContainer = new PLSqlContainer();

			//START: File correction & back up
			String originalFile = fileAddress + ".original";
			copyfile(fileAddress, originalFile);
			correctFile(fileAddress);
			
			//START: collect metrics from PLSQL source file
			try{
				//initialize (reset) PLSqlContainer
				SoftwareMetrics.resetPLSqlContainer();

				SoftwareMetrics.start(fileAddress, "Source", 0);
				InputStream in = new FileInputStream(fileAddress);
				PLSqlLexer lexer = new PLSqlLexer(new DataInputStream(in));
				PLSqlParser parser = new PLSqlParser(lexer);
				parser.start_rule();
			}
			catch(Exception e){
				System.err.println("Exception: "+e);
				e.printStackTrace();
				System.err.println("Problem Parsing File: " + fileAddress);
			}
			finally{
				SoftwareMetrics.finishAll();
				plsqlContainer = SoftwareMetrics.getPLSqlContainer();
				
//				copyfile(originalFile, fileAddress);
//				deletefile(originalFile);
				//END: File correction & back up
			}
			//END: collect metrics from PLSQL source file

			//START: fill the DataContext

			for (int j = 0; j < plsqlContainer.fileMetrics.size(); j++) {
				PLSqlFileMetrics currentFileMetrics = plsqlContainer.fileMetrics.elementAt(j);
				//get the DataContext of file
				PLSqlCommonMetrics currentFileContent = currentFileMetrics.fileContent;
				DataContext fileMetric = currentFileContent.convertToDataContext();
				metrics.add(currentFileContent.getName(), fileMetric);

				DataContext currentFileDataContext = metrics.getNode(currentFileContent.getName());
				for (int k = 0; k < currentFileMetrics.packageMetrics.size(); k++) {
					PLSqlPackageMetrics currentPackageMetrics = currentFileMetrics.packageMetrics.elementAt(k);
					//get the DataContext of Package
					PLSqlCommonMetrics currentPackageContent = currentPackageMetrics.packageContent;
					DataContext packageMetric = currentPackageContent.convertToDataContext();
					currentFileDataContext.add(currentPackageContent.getName(), packageMetric);

					DataContext currentPackageDataContext = currentFileDataContext.getNode(currentPackageContent.getName());
					
					//add empty class for the xml file
					//necessary due to inconsistency with java and c formats
					currentPackageDataContext.add(className,new DataContext());
					DataContext currentClassDataContext = currentPackageDataContext.getNode(className);
					
					for (int l = 0; l < currentPackageMetrics.methodMetrics.size(); l++) {
						PLSqlMethodMetrics currentMethodMetrics = currentPackageMetrics.methodMetrics.elementAt(l);
						//get the DataContext of Method
						PLSqlCommonMetrics currentMethodContent = currentMethodMetrics.methodContent;
						DataContext methodMetric = currentMethodContent.convertToDataContext();
						currentClassDataContext.add(currentMethodContent.getName(), methodMetric);
					}
				}
			}
			//END: fill the DataContext

			//write cvs files
			writeCsv(plsqlContainer, fileCsvFileName, packageCsvFileName, methodCsvFileName);
		}
		//********************************************************************
		//write xml file
		metrics.writeToFile(xmlFileName);

		return metrics;
	}

	public void prepareCsv(String fileCsvFileName, String packageCsvFileName, String methodCsvFileName) throws IOException{
		BufferedOutputStream outP = null;
		BufferedOutputStream outF = null;
		BufferedOutputStream outM = null;
		final String defected = "Defected?(false/true)";
		try {

			//prepare file csv
			outF = new BufferedOutputStream(new FileOutputStream(
					fileCsvFileName));
			outF.write("File_Name,".getBytes());
			//outF.write("File Id,".getBytes());
			for (int i = 0; i < PLSqlConstants.MAX_COLUMNS; i++) {
				outF.write((PLSqlConstants.COLUMN_NAMES[i]+",").getBytes());
			}
			outF.write((defected+"\n").getBytes());
			outF.flush();


			//prepare package csv
			outP = new BufferedOutputStream(new FileOutputStream(
					packageCsvFileName));
			outP.write("Package_Name,".getBytes());
			//outF.write("File Id,".getBytes());
			for (int i = 0; i < PLSqlConstants.MAX_COLUMNS; i++) {
				outP.write((PLSqlConstants.COLUMN_NAMES[i]+",").getBytes());
			}
			outP.write((defected+"\n").getBytes());
			outP.flush();


			//prepare method csv
			outM = new BufferedOutputStream(new FileOutputStream(
					methodCsvFileName));
			outM.write("File_Name,".getBytes());
			//outF.write("File Id,".getBytes());
			for (int i = 0; i < PLSqlConstants.MAX_COLUMNS; i++) {
				outM.write((PLSqlConstants.COLUMN_NAMES[i]+",").getBytes());
			}
			outM.write((defected+"\n").getBytes());
			outM.flush();
		}
		catch (Exception e) {			
			outP.close();
			outF.close();
			outM.close();
			e.printStackTrace();
		}
		finally{
			outP.close();
			outF.close();
			outM.close();
		}
	}
	public void writeCsv(PLSqlContainer plsqlContainer, String fileCsvFileName, String packageCsvFileName, String methodCsvFileName) throws Exception{
		
		BufferedOutputStream outP = null;
		BufferedOutputStream outF = null;
		BufferedOutputStream outM = null;
		final boolean append = true;
		try {
			/*
			//prepare file csv
			outF = new BufferedOutputStream(new FileOutputStream(
					fileCsvFileName,append));
			outF.write("File Name,".getBytes());
			//outF.write("File Id,".getBytes());
			for (int i = 0; i < PLSqlConstants.MAX_COLUMNS; i++) {
				outF.write((PLSqlConstants.COLUMN_NAMES[i]+",").getBytes());
			}
			outF.write("\n".getBytes());
			outF.flush();


			//prepare package csv
			outP = new BufferedOutputStream(new FileOutputStream(
					packageCsvFileName,append));
			outP.write("File Name,".getBytes());
			//outF.write("File Id,".getBytes());
			for (int i = 0; i < PLSqlConstants.MAX_COLUMNS; i++) {
				outP.write((PLSqlConstants.COLUMN_NAMES[i]+",").getBytes());
			}
			outP.write("\n".getBytes());
			outP.flush();


			//prepare method csv
			outM = new BufferedOutputStream(new FileOutputStream(
					methodCsvFileName,append));
			outM.write("File Name,".getBytes());
			//outF.write("File Id,".getBytes());
			for (int i = 0; i < PLSqlConstants.MAX_COLUMNS; i++) {
				outM.write((PLSqlConstants.COLUMN_NAMES[i]+",").getBytes());
			}
			outM.write("\n".getBytes());
			outM.flush();
			*/
			//OPEN CSV FILES
			outF = new BufferedOutputStream(new FileOutputStream(
					fileCsvFileName,append));
			outP = new BufferedOutputStream(new FileOutputStream(
					packageCsvFileName,append));
			outM = new BufferedOutputStream(new FileOutputStream(
					methodCsvFileName,append));
			
			//START: fill the csv files
			
			//write file metrics
			for (int i = 0; i < plsqlContainer.fileMetrics.size(); i++) {				
				String[] fileMetrics;
				if(PLSqlConstants.roundTheDoubles)
					fileMetrics = plsqlContainer.fileMetrics.elementAt(i).fileContent.getAllMetrics_Rounded();
				else
					fileMetrics = plsqlContainer.fileMetrics.elementAt(i).fileContent.getAllMetrics();
				
				for (int j = 0; j < fileMetrics.length; j++) {
					outF.write((fileMetrics[j]+",").getBytes());
				}
				outF.write("false".getBytes());
				outF.write("\n".getBytes());

				
				//write package metrics
				for (int j = 0; j < plsqlContainer.fileMetrics
				.elementAt(i).packageMetrics.size(); j++) {					
					String[] packageMetrics;
					if(PLSqlConstants.roundTheDoubles)
						packageMetrics = plsqlContainer.fileMetrics
					.elementAt(i).packageMetrics.elementAt(j).packageContent
					.getAllMetrics_Rounded();
					else
						packageMetrics = plsqlContainer.fileMetrics
						.elementAt(i).packageMetrics.elementAt(j).packageContent
						.getAllMetrics();
					
					for (int k = 0; k < packageMetrics.length; k++) {
						outP.write((packageMetrics[k] + ",").getBytes());
					}
					outP.write("false".getBytes());
					outP.write("\n".getBytes());

					
					//write method metrics
					for (int k = 0; k < plsqlContainer.fileMetrics
					.elementAt(i).packageMetrics.elementAt(j).methodMetrics.size(); k++) {						
						String[] methodMetrics;
						if(PLSqlConstants.roundTheDoubles)
							methodMetrics = plsqlContainer.fileMetrics
						.elementAt(i).packageMetrics.elementAt(j).methodMetrics.elementAt(k).methodContent.getAllMetrics_Rounded();
						else
							methodMetrics = plsqlContainer.fileMetrics
							.elementAt(i).packageMetrics.elementAt(j).methodMetrics.elementAt(k).methodContent.getAllMetrics();
						
						for (int l = 0; l < methodMetrics.length; l++) {
							outM.write((methodMetrics[l] + ",").getBytes());
						}
						outM.write("false".getBytes());
						outM.write("\n".getBytes());
					}//end of method metrics
				}//end of package metrics
			}//end of file metrics
			
			outF.flush();
			outP.flush();
			outM.flush();
			//END: fill the csv files
		} catch (Exception e) {			
			outP.close();
			outF.close();
			outM.close();
			e.printStackTrace();
		}
		finally{
			outP.close();
			outF.close();
			outM.close();
		}
	}
	private static String removeDBSign(String strLine){
		int index = strLine.indexOf('@');
		if(-1 == index)
			return strLine;
		String lineToWrite = strLine.substring(0, index);
		boolean flag = true;
		for (int i = index; i < strLine.length(); i++) {
			if (flag) {
				char nxtCh = strLine.charAt(i);
				if (' ' == nxtCh || '(' == nxtCh || ';' == nxtCh) {
					lineToWrite += nxtCh;
					flag = false;
				}
			}
			else{
				lineToWrite += removeDBSign(strLine.substring(i));
				break;
			}
		}
		return lineToWrite;
	}
	private static void copyfile(String srFile, String dtFile){
		try{
			File f1 = new File(srFile);
			File f2 = new File(dtFile);
			InputStream in = new FileInputStream(f1);

			//For Append the file.
			//OutputStream out = new FileOutputStream(f2,true);

			//For Overwrite the file.
			OutputStream out = new FileOutputStream(f2);

			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0){
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
			System.out.println("File copied.");
		}
		catch(FileNotFoundException ex){
			System.out.println(ex.getMessage() + " in the specified directory.");
			//System.exit(0);
		}
		catch(IOException e){
			System.out.println(e.getMessage());      
		}
	}
	private static void deletefile(String file){
		File f1 = new File(file);
		boolean success = f1.delete();
		if (!success){
			System.err.println("Deletion failed.");
		}
		else{
			System.out.println("File: " + file + " deleted.");
		}
	}
	private static void correctFile(String fileAddress) {
		String tempAdrs = fileAddress+".temp";
		try{
			// Open the file that is the first 
			// command line parameter
			FileInputStream fstream = new FileInputStream(fileAddress);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			//OUTPUT FILE
			FileOutputStream ostream = new FileOutputStream(tempAdrs);
			DataOutputStream out = new DataOutputStream(ostream);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));


			String strLine="", lineToWrite="";
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
				boolean changed = false;

				//if contains @
				if(-1 != strLine.indexOf('@')){
					if(changed){
						lineToWrite = removeDBSign(lineToWrite);
					}
					else{
						lineToWrite = removeDBSign(strLine);
						changed = true;
					}
				}
				if(-1 != strLine.indexOf('%')){
					if(changed){
						lineToWrite = lineToWrite.replaceAll("%", "-");
					}
					else{
						lineToWrite = strLine.replaceAll("%", "-");
						changed = true;
					}
				}
				if(!changed){
					lineToWrite = strLine;
				}
				bw.write(lineToWrite);
				bw.newLine();
			}
			bw.flush();
			//Close the input stream
			in.close();
			//Close the output stream
			out.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}finally{
			//copyfile(tempAdrs, fileAddress);
			//deletefile(tempAdrs);
		}
	}
}
