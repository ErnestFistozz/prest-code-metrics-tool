package executor;

import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import parser.C.CParser;
import parser.Cpp.cppParser.CPPParserExecutor;
import parser.Java.JavaParserRelatedFiles.JavaParser;
import parser.PLSql.PLSqlParserRelatedFiles.PLSqlParserExecuter;
import parser.enumeration.Language;
import parser.parserinterface.IParser;
import parser.parserinterface.ParserInterfaceAndFileList;

import common.ApplicationProperties;
import common.DirectoryListing;
import common.ParseResult;
import common.data.DataContext;
import org.apache.log4j.Logger;

import console.PrestConsoleApp;

public class ParserExecutor
{

	private static List<ParseResult> parserResultList = new ArrayList<ParseResult>();
	private static Language currentLanguage;
	public static final int PARSING_SUCCESSFUL = 0;
	public static final int PARSING_CANCELLED = 1;
	static Logger logger = Logger.getLogger(PrestConsoleApp.class.getName());

	// same as the parseDirectory function, but altered for the command line
	// execution
	public static int parseDirectoryCmd(File projectDirectory, String fileCsvPath, String methodCsvPath, String classCsvPath, String freezeName)
			throws Exception
	{

		List<ParserInterfaceAndFileList> parserList = new ArrayList<ParserInterfaceAndFileList>();

		parserList = findAppropriateParsers(projectDirectory);
		
		//if freeze parameter provided project name set to freeze name
		String projDir = "";
		if(freezeName.equals(""))
			projDir = projectDirectory.getName();
		else
			projDir = freezeName;
		
		if (parserList == null)
		{
			return PARSING_CANCELLED;
		}
		else
		{
			parserResultList.clear();
			parserResultList = new ArrayList<ParseResult>();
			for (ParserInterfaceAndFileList parserAndFiles : parserList)
			{
				DataContext thisOne = parseProject(parserAndFiles.getParser(), parserAndFiles.getFileList(), projDir, fileCsvPath, methodCsvPath, classCsvPath);
				if (thisOne == null)
				{

				}
				else
				{
					parserResultList.add(new ParseResult(parserAndFiles.getParser().getLanguage(), thisOne));
				}
			}
			return PARSING_SUCCESSFUL;
		}
	}

	public static List<ParserInterfaceAndFileList> findAppropriateParsers(File projectDirectory)
	{
		List<ParserInterfaceAndFileList> parserList = new ArrayList<ParserInterfaceAndFileList>();

		for (Language lang : Language.LIST)
		{
			DirectoryListing dl = new DirectoryListing();
			List<File> fileList = new ArrayList<File>();
			for (String l : lang.getExtensions())
			{
				dl.visitAllFiles_Filtered(projectDirectory, l);
				fileList.addAll(dl.getFilteredFileNames());
			}
			
			if (fileList != null && fileList.size() > 0)
			{

				IParser parser = constructParser(lang);

				if (parser != null)
				{
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

	public static IParser constructParser(Language lang)
	{
		if (lang.equals(Language.JAVA))
		{

			return new JavaParser(System.in);
		}
		else if (lang.equals(Language.C))
		{
			return new CParser();
		}
		else if (lang.equals(Language.CPP))
		{
			return new CPPParserExecutor();
		}
//		else if (lang.equals(Language.JSP))
//		{
//			return new JavaParser(System.in);
//		}
		else if (lang.equals(Language.PLSQL))
		{
			return new PLSqlParserExecuter();
		}
		else
		{
			return null;
		}
	}

	public static DataContext parseProject(IParser aParser, List<File> fileList, String projectName, String fileCsvPath,
			String methodCsvPath, String classCsvPath) throws Exception
	{

		if (aParser != null && fileList != null)
		{
			String[] fileNames = new String[fileList.size()];
			for (int index = 0; index < fileList.size(); index++)
			{
				fileNames[index] = fileList.get(index).getAbsolutePath();
			}

			DataContext metrics = null;
			try
			{
				Date now = new Date();
				DateFormat df = DateFormat.getDateTimeInstance();
				String nowStr = df.format(now);
				nowStr = nowStr.replaceAll(" ", "-");
				nowStr = nowStr.replaceAll(":", ".");

				String xmlFileName = ApplicationProperties.get("repositorylocation") + File.separator + projectName
						+ File.separator + "parse_results" + File.separator + "parseResult" + "_"
						+ aParser.getLanguage().getLangName() + "_" + nowStr + ".xml";

				String packageCsvFileName = ApplicationProperties.get("repositorylocation") + File.separator + projectName
						+ File.separator + "parse_results" + File.separator + "parseResult" + "_"
						+ aParser.getLanguage().getLangName() + "_" + nowStr + "PACKAGE.csv";

				String methodCsvFileName = "";
				if (methodCsvPath.equals(""))
				{
					methodCsvFileName = ApplicationProperties.get("repositorylocation") + File.separator + projectName
							+ File.separator + "parse_results" + File.separator + "parseResult" + "_"
							+ aParser.getLanguage().getLangName() + "_" + nowStr + "METHOD.csv";
				}
				else
				{
					methodCsvFileName = methodCsvPath;
				}

				String fileCsvFileName = "";

				if (fileCsvPath.equals(""))
				{
					fileCsvFileName = ApplicationProperties.get("repositorylocation") + File.separator + projectName
							+ File.separator + "parse_results" + File.separator + "parseResult" + "_"
							+ aParser.getLanguage().getLangName() + "_" + nowStr + "FILE.csv";
				}
				else
				{
					fileCsvFileName = fileCsvPath;
				}

				String classCsvFileName = "";

				if (classCsvPath.equals(""))
				{
					classCsvFileName = ApplicationProperties.get("repositorylocation") + File.separator + projectName
							+ File.separator + "parse_results" + File.separator + "parseResult" + "_"
							+ aParser.getLanguage().getLangName() + "_" + nowStr + "CLASS.csv";
				}
				else
				{
					classCsvFileName = classCsvPath;
				}

				metrics = aParser.startExecution(fileNames, projectName, xmlFileName, packageCsvFileName, fileCsvFileName,
						classCsvFileName, methodCsvFileName);
			}
			catch (Exception e)
			{
				logger.error("Error while writing to files.");
			}

			return metrics;

		}
		else
		{
			return null;
		}
	}

	public static void fillWithOldResults(List<String> oldParseResultFiles, List<Language> langList)
	{
		for (int l = 0; l < parserResultList.size(); l++)
		{
			parserResultList.set(l, null);
		}
		parserResultList.clear();
		parserResultList = new ArrayList<ParseResult>();
		for (int i = 0; i < oldParseResultFiles.size(); i++)
		{
			DataContext metrics = null;
			try
			{
				metrics = DataContext.readFromFile(oldParseResultFiles.get(i));
			}
			catch (Exception e)
			{
				System.out.println("Error reading " + oldParseResultFiles.get(i));
			}
			if (metrics != null)
			{
				ParseResult result = new ParseResult(langList.get(i), metrics);
				if (result != null)
				{
					parserResultList.add(result);
				}
			}
		}
	}

	public static List<ParseResult> getParserResultList()
	{
		return parserResultList;
	}

	public static void setParserResultList(List<ParseResult> parserResultList)
	{
		ParserExecutor.parserResultList = parserResultList;
	}

	public static Language getCurrentLanguage()
	{
		return currentLanguage;
	}

	public static void setCurrentLanguage(Language currentLanguage)
	{
		ParserExecutor.currentLanguage = currentLanguage;
	}
}
