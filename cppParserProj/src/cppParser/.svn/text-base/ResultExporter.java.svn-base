package cppParser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import cppParser.utils.LOCMetrics;
import cppParser.utils.Log;
import cppStructures.CppClass;
import cppStructures.CppFile;
import cppStructures.CppFunc;
import cppStructures.CppFuncParam;
import cppStructures.CppNamespace;
import cppStructures.CppScope;

/**
 * This class is responsible for reading the metric results from
 * ParsedObjectManager and exporting them to a file.
 * http://tools.ietf.org/html/rfc4180
 * 
 * @author Tomi
 */
public class ResultExporter
{
	private static final String separator = ",";
	private String outputDir;
	private BufferedWriter writer;
	private boolean includeStructs = false;

	public ResultExporter(String outputDir, boolean includeStructs)
	{
		this.includeStructs = includeStructs;
		if (includeStructs)
		{
			Log.d("Including structs");
		}
		else
		{
			Log.d("Excluding structs");
		}
		this.outputDir = outputDir;

		if (!outputDir.isEmpty())
		{
			char c = outputDir.charAt(outputDir.length() - 1);
			if ((c != '\\') || (c != '/'))
			{
				this.outputDir += "/";
			}
		}
		else
		{
			this.outputDir = FileLoader.getTargetPath() + File.separator;
		}
	}

	public void exportAll()
	{
		Log.d("Exporting to " + outputDir);
		try
		{
			exportFileMetrics();
			exportFunctionMetrics();
			exportNamespaces();
			exportClassMetrics();
		}
		catch (IOException ex)
		{
			Log.d("Error: " + ex.getMessage());
		}
	}

	// Includes LOC metrics for each file,
	public void exportFileMetrics() throws IOException
	{
		try
		{
			writer = new BufferedWriter(new FileWriter(outputDir
					+ "FileMetrics.csv"));
			writeFileMetrics(writer);
			writer.close();

		}
		catch (IOException ex)
		{
			Logger.getLogger(ResultExporter.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	// Includes functions/methods and their Halstead and complexity metrics
	public void exportFunctionMetrics() throws IOException
	{
		writer = new BufferedWriter(new FileWriter(outputDir
				+ "FunctionMetrics.csv"));
		writeFunctionMetrics(writer);
		writer.close();
	}

	// Known namespaces
	public void exportNamespaces() throws IOException
	{
		writer = new BufferedWriter(
				new FileWriter(outputDir + "Namespaces.csv"));
		writeNamespaces(writer);
		writer.close();
	}

	// Classes and OO Metrics
	public void exportClassMetrics() throws IOException
	{
		writer = new BufferedWriter(new FileWriter(outputDir
				+ "ClassMetrics.csv"));
		writeClassMetrics(writer);
		writer.close();

	}

	private void writeFileMetrics(BufferedWriter writer) throws IOException
	{

		writer.write("File name"
				+ separator
				+ "Physical LOC"
				+ separator
				+ "Logical LOC"
				+ separator
				+ "Empty Lines"
				+ separator
				+
				// "commentOnlyLines"+separator+
				// "commentedCodeLines"+separator+
				"Comment Lines" + separator + "Operators" + separator
				+ "Operands" + separator + "Unique operators" + separator
				+ "Unique operands" + separator +

				"Calculated length" + separator + "Delivered bugs" + separator
				+ "Vocabulary" + separator +

				"Volume" + separator + "Difficulty" + separator + "Effort"
				+ separator + "Time to program" + separator +

				"Level" + separator + "Intelligent content" + separator
				+ "Cyclomatic complexity");

		for (CppFile file : ParsedObjectManager.getInstance().getFiles())
		{
			LOCMetrics l = file.getLOCMetrics();
			CppFunc otherMetrics = file.getOtherMetrics();
			writer.write("\n");
			writer.write("\""
					+ l.file
					+ "\""
					+ separator
					+ (l.codeOnlyLines + l.commentedCodeLines)
					+ ","
					+ l.logicalLOC
					+ separator
					+ l.emptyLines
					+ separator
					+
					// +l.commentLines + separator
					// +l.commentedCodeLines + separator
					(l.commentLines + l.commentedCodeLines)
					+ otherMetrics.getOperatorCount() + separator
					+ otherMetrics.getOperandCount() + separator
					+ otherMetrics.getUniqueOperatorCount() + separator
					+ otherMetrics.getUniqueOperandCount() + separator +

					otherMetrics.getLength() + separator
					+ otherMetrics.getDeliveredBugs() + separator
					+ otherMetrics.getVocabulary() + separator +

					otherMetrics.getVolume() + separator
					+ otherMetrics.getDifficulty() + separator
					+ otherMetrics.getEffort() + separator
					+ otherMetrics.getTimeToProgram() + separator +

					otherMetrics.getLevel() + separator
					+ otherMetrics.getIntContent() + separator
					+ otherMetrics.getCyclomaticComplexity());
		}
		writer.write("\n");

	}

	private LOCMetrics getProjectLevelLOCMetrics()
	{
		LOCMetrics projectLevelMetrics = new LOCMetrics();
		for (CppFile file : ParsedObjectManager.getInstance().getFiles())
		{
			LOCMetrics l = file.getLOCMetrics();
			projectLevelMetrics.codeOnlyLines += l.codeOnlyLines;
			projectLevelMetrics.commentLines += l.commentLines;
			projectLevelMetrics.commentedCodeLines += l.commentedCodeLines;
			projectLevelMetrics.emptyLines += l.emptyLines;
			projectLevelMetrics.logicalLOC += l.logicalLOC;
		}
		return projectLevelMetrics;
	}

	private void writeClassMetrics(BufferedWriter writer) throws IOException
	{
		writer.write("File " + separator + "Namespace" + separator
				+ "Class name" + separator + "Direct parents" + separator
				+ "Children" + separator + "Number of children" + separator
				+ "Depth of inheritance" + separator
				+ "Weighted methods per class" + separator +

				"Physical LOC" + separator + "Logical LOC" + separator
				+ "Comment lines" + separator + "Empty lines" + separator +

				"Sum function PLOC" + separator + "Sum function LLOC"
				+ separator + "Sum function comment lines" + separator
				+ "Sum function empty lines" + separator + "Sum operators"
				+ separator + "Sum operands" + separator
				+ "Sum unique operators" + separator + "Sum unique operands"
				+ separator + "Sum calculated length" + separator
				+ "Sum delivered bugs" + separator + "Sum vocabulary"
				+ separator + "Sum length" + separator + "Sum volume"
				+ separator + "Sum difficulty" + separator + "Sum effort"
				+ separator + "Sum time to program" + separator
				+ "Sum delivered bugs" + separator + "Sum level" + separator
				+ "Sum intelligent content" + separator
				+ "Sum function complexity" + separator +

				"Average function PLOC" + separator + "Average function LLOC"
				+ separator + "Average function comment lines" + separator
				+ "Average function empty lines" + separator
				+ "Average operators" + separator + "Average operands"
				+ separator + "Average unique operators" + separator
				+ "Average unique operands" + separator
				+ "Average calculated length" + separator
				+ "Average delivered bugs" + separator + "Average vocabulary"
				+ separator + "Average length" + separator + "Average volume"
				+ separator + "Average difficulty" + separator
				+ "Average effort" + separator + "Average time to program"
				+ separator + "Average delivered bugs" + separator
				+ "Average level" + separator + "Average intelligent content"
				+ separator + "Average function complexity");
		if (includeStructs)
		{
			writer.write(separator + "Type");
		}

		String parents, children, type = "";

		for (CppScope cc : ParsedObjectManager.getInstance().getScopes())
		{
			if (cc instanceof CppClass)
			{
				if (cc.type == CppScope.STRUCT)
				{
					if (includeStructs)
					{
						type = "struct";
					}
					else
					{
						continue;
					}
				}
				else if (cc.type == CppScope.CLASS)
				{
					type = "class";
				}

				CppClass c = (CppClass) cc;
				String namespace = getNamespace(c);
				parents = getParents(c);
				children = getChildren(c);
				int funcs = c.getFunctions().size();
				writer.write("\n");
				writer.write(c.nameOfFile
						+ separator
						+ namespace
						+ separator
						+ "\""
						+ c.getName()
						+ "\""
						+ separator
						+ parents
						+ separator
						+ children
						+ separator
						+ c.children.size()
						+ separator
						+ c.getDepthOfInheritance()
						+ separator
						+ funcs
						+ separator
						+ (c.getLOCMetrics().codeOnlyLines + c.getLOCMetrics().commentedCodeLines)
						+ separator
						+ c.getLOCMetrics().logicalLOC
						+ separator
						+ (c.getLOCMetrics().commentLines + c.getLOCMetrics().commentedCodeLines)
						+ separator + c.getLOCMetrics().emptyLines + separator +

						c.sumFuncPLOC + separator + c.sumFuncLLOC + separator
						+ c.sumFuncCommentLines + separator
						+ c.sumFuncEmptyLines + separator +

						c.sumOperators + separator + c.sumOperands + separator
						+ c.sumUniqueOperators + separator
						+ c.sumUniqueOperands + separator +

						c.sumCalculatedLength + separator + c.sumDeliveredBugs
						+ separator
						+

						c.sumVocabulary
						+ separator
						+ c.sumLength
						+ separator
						+ c.sumVolume
						+ separator
						+ c.sumDifficulty
						+ separator
						+ c.sumEffort
						+ separator
						+ c.sumTimeToProgram
						+ separator
						+ c.sumDeliveredBugs
						+ separator
						+ c.sumLevel
						+ separator
						+ c.sumIntContent
						+ separator
						+ c.sumFuncCC
						+ separator
						+
						// /Averages
						((double) c.sumFuncPLOC / (funcs > 0 ? funcs : 1)) + separator
						+ ((double) c.sumFuncLLOC / (funcs > 0 ? funcs : 1)) + separator
						+ ((double) c.sumFuncCommentLines / (funcs > 0 ? funcs : 1)) + separator
						+ ((double) c.sumFuncEmptyLines / (funcs > 0 ? funcs : 1)) + separator +

						((double) c.sumOperators / (funcs > 0 ? funcs : 1)) + separator
						+ ((double) c.sumOperands / (funcs > 0 ? funcs : 1)) + separator
						+ ((double) c.sumUniqueOperators / (funcs > 0 ? funcs : 1)) + separator
						+ ((double) c.sumUniqueOperands / (funcs > 0 ? funcs : 1)) + separator +

						(c.sumCalculatedLength / (funcs > 0 ? funcs : 1)) + separator
						+ (c.sumDeliveredBugs / (funcs > 0 ? funcs : 1)) + separator +

						(c.sumVocabulary / (funcs > 0 ? funcs : 1)) + separator
						+ (c.sumLength / (funcs > 0 ? funcs : 1)) + separator
						+ (c.sumVolume / (funcs > 0 ? funcs : 1)) + separator
						+ (c.sumDifficulty / (funcs > 0 ? funcs : 1)) + separator
						+ (c.sumEffort / (funcs > 0 ? funcs : 1)) + separator
						+ (c.sumTimeToProgram / (funcs > 0 ? funcs : 1)) + separator
						+ (c.sumDeliveredBugs / (funcs > 0 ? funcs : 1)) + separator
						+ (c.sumLevel / (funcs > 0 ? funcs : 1)) + separator
						+ (c.sumIntContent / (funcs > 0 ? funcs : 1)) + separator
						+ ((double) c.sumFuncCC / (funcs > 0 ? funcs : 1))

				);
				if (includeStructs)
				{
					writer.write(separator + type);
				}
			}
		}

	}

	private void writeProjectLOC(BufferedWriter writer) throws IOException
	{
		LOCMetrics l = getProjectLevelLOCMetrics();
		writer.write("Total Physical LOC" + separator + "Total Logical LOC"
				+ separator + "Total Empty Lines" + separator +
				// "commentOnlyLines"+separator+
				// "commentedCodeLines"+separator+
				"Total Comment Lines");
		writer.write("\n");
		writer.write((l.codeOnlyLines + l.commentedCodeLines) + ","
				+ l.logicalLOC + separator
				+ (l.commentLines + l.commentedCodeLines) + separator +
				// +l.commentLines + separator
				// +l.commentedCodeLines + separator

				l.emptyLines);

	}

	private void writeNamespaces(BufferedWriter writer) throws IOException
	{
		// String parameters = "";
		writeProjectLOC(writer);
		writer.write(
		// "File"+separator+
		"\n" + "Name" + separator + "Number of Variables" + separator
				+ "Number of Functions");
		writer.write("\n");

		for (CppScope scope : ParsedObjectManager.getInstance().getScopes())
		{
			if (scope.type == CppScope.NAMESPACE)
			{
				String name;
				if (scope.name.contains(","))
				{
					name = "\"" + scope.name + "\"";
				}
				else
				{
					name = scope.name;
				}
				writer.write(
				// scope.nameOfFile+separator+
				name + separator + scope.getMembers().size() + separator
						+ scope.getFunctions().size());
				writer.write("\n");
				/*
				 * writer.write("variablesType"+separator+"variableName");
				 * writer.write("\n"); for(MemberVariable
				 * var:scope.getMembers())
				 * writer.write(var.getType()+separator+var
				 * .getPointer()+var.getName()); writer.write("\n");
				 * writer.write
				 * ("returnType"+separator+"functionName"+separator+"parameters"
				 * ); writer.write("\n");
				 */
				/*
				 * for(CppFunc func:scope.getFunctions()){ int i=0;
				 * parameters="\""; for(CppFuncParam param:func.parameters){
				 * parameters+=param.type; if(i<(func.parameters.size()-1))
				 * parameters+=","; i++; } parameters+="\"";
				 * if(parameters.contentEquals("\"void\"") ||
				 * parameters.contentEquals("\"\"")) parameters="";
				 * writer.write(func.getType()+separator+
				 * func.getName()+separator+ parameters ); writer.write("\n"); }
				 * writer.write("\n");
				 */
			}
		}
	}

	private void writeFunctionMetrics(BufferedWriter writer) throws IOException
	{
		String parameters;
		writer.write("File" + separator + "Return type" + separator
				+ "Function name" + separator + "Operator count" + separator
				+ "Operand count" + separator + "Unique Operator Count"
				+ separator + "Unique Operand Count" + separator + "Vocabulary"
				+ separator + "Length" + separator + "Volume" + separator
				+ "Difficulty" + separator + "Effort" + separator
				+ "Programming time" + separator + "Deliver Bugs" + separator
				+ "Level" + separator + "Intelligent content" + separator
				+ "Cyclomatic Complexity" + separator + "Physical LOC"
				+ separator + "Logical LOC" + separator +
				// "Code only lines" + separator +
				"Comment lines" + separator +
				// "Commented code lines" + separator +
				"Empty lines" + "\n");

		for (CppScope scope : ParsedObjectManager.getInstance().getScopes())
		{
			for (CppFunc func : scope.getFunctions())
			{
				int i = 0;
				parameters = "\"";
				for (CppFuncParam param : func.parameters)
				{
					parameters += param.type;
					if (i < (func.parameters.size() - 1))
					{
						parameters += ",";
					}
					i++;
				}
				parameters += "\"";
				if (parameters.contentEquals("\"void\"")
						|| parameters.contentEquals("\"\""))
				{
					parameters = "";
				}
				writer.write(func.fileOfFunc
						+ separator
						+ func.getType()
						+ separator
						+ func.getName()
						+ parameters
						+ separator
						+ func.getOperatorCount()
						+ separator
						+ func.getOperandCount()
						+ separator
						+ func.getUniqueOperatorCount()
						+ separator
						+ func.getUniqueOperandCount()
						+ separator
						+ func.getVocabulary()
						+ separator
						+ func.getLength()
						+ separator
						+ func.getVolume()
						+ separator
						+ func.getDifficulty()
						+ separator
						+ func.getEffort()
						+ separator
						+ func.getTimeToProgram()
						+ separator
						+ func.getDeliveredBugs()
						+ separator
						+ func.getLevel()
						+ separator
						+ func.getIntContent()
						+ separator
						+ func.getCyclomaticComplexity()
						+ separator
						+ (func.getLOCMetrics().commentedCodeLines + func
								.getLOCMetrics().codeOnlyLines) + separator
						+ func.getLOCMetrics().logicalLOC
						+ separator
						+
						// func.getLOCMetrics().codeOnlyLines + separator +
						(func.getLOCMetrics().commentedCodeLines + func
								.getLOCMetrics().commentLines) + separator +
						// func.getLOCMetrics().commentedCodeLines + separator +
						func.getLOCMetrics().emptyLines);
				writer.write("\n");
			}
		}
	}

	/**
	 * Method extracts all parents from given class and returns them as String
	 * which contains eg "parent1, parent2". Quotes are included unless class
	 * has no parents then empty String is returned
	 * 
	 * @param c
	 * @return
	 */
	private String getParents(CppClass c)
	{
		String parents = "";
		if (c.parents.isEmpty())
		{
			parents = "";
		}
		else
		{
			int x = 0;
			parents = "\"";

			for (CppScope p : c.parents)
			{
				parents += p.getName();
				if (x < (c.parents.size() - 1))
				{
					parents += ",";
				}
				x++;
			}
			parents += "\"";
		}
		return parents;
	}

	/**
	 * Gives the namespace as string of given class
	 * 
	 * @param c
	 * @return
	 */
	private String getNamespace(CppClass c)
	{
		String namespace = "";
		CppNamespace ns = c.namespace;

		while (true)
		{
			if (ns != null)
			{
				if (ns.name.contentEquals("__MAIN__") || ns.name.isEmpty())
				{
					break;
				}
				else
				{
					namespace = ns.name + "::" + namespace;
				}
				ns = ns.namespace;
			}
			else
			{
				break;
			}
		}
		if (!namespace.isEmpty())
		{
			namespace = "\"" + namespace + "\"";
		}
		return namespace;
	}

	/**
	 * Returns children of parameter c as comma separated string
	 * 
	 * @param c
	 * @return
	 */
	private String getChildren(CppClass c)
	{
		String children;
		if (c.children.isEmpty())
		{
			children = "";
		}
		else
		{
			int x = 0;
			children = "\"";
			for (CppScope p : c.children)
			{
				children += p.getName();
				if (x < (c.children.size() - 1))
				{
					children += ",";
				}
				x++;
			}
			children += "\"";
		}
		return children;
	}
}