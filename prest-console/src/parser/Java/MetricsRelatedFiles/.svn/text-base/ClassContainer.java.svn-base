package parser.Java.MetricsRelatedFiles;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import common.NodePair;
import common.data.DataContext;

/*
 * this class contains all the packages of the project
 * */
public class ClassContainer
{

	LinkedHashMap<String, PackageMetrics> packages = new LinkedHashMap<String, PackageMetrics>();

	// returns the package with the desired name
	public PackageMetrics getPackage(String packageToReturn)
	{
		return packages.get(packageToReturn);

	}

	public PackageMetrics deletePackage(String packageToReturn)
	{
		return packages.remove(packageToReturn);
	}

	// adds the new package and returns the newly added package
	public PackageMetrics addPackage(String packageName)
	{
		PackageMetrics controlPackage = packages.get(packageName);
		if (controlPackage == null)
			packages.put(packageName, new PackageMetrics(packageName));
		return packages.get(packageName);
	}

	// returns the name of the packages in the form of an iterator of strings
	public Iterator<String> getPackageNames()
	{
		return packages.keySet().iterator();
	}

	public List<String> getPackageMetrics(PackageMetrics pm)
	{
		List<String> l = new ArrayList<String>();
		l.add(pm.getNameNode().getValue().toString());
		l.add(pm.getIdNode().getValue().toString());
		l.add(pm.getCyclomaticComplexityNode().getValue().toString());
		l.add(pm.getDecisionDensityNode().getValue().toString());
		l.add(pm.getEssentialDensityNode().getValue().toString());
		l.add(pm.getBranchCountNode().getValue().toString());
		l.add(pm.getConditionCountNode().getValue().toString());
		l.add(pm.getCylomaticDensityNode().getValue().toString());
		l.add(pm.getDecisionCountNode().getValue().toString());
		l.add(pm.getEssentialComplexityNode().getValue().toString());
		l.add(pm.getLOCNode().getValue().toString());
		l.add(pm.getTotalOperandsNode().getValue().toString());
		l.add(pm.getTotalOperatorsNode().getValue().toString());
		l.add(pm.getUniqueOperandsCountNode().getValue().toString());
		l.add(pm.getUniqueOperatorsCountNode().getValue().toString());
		l.add(pm.getHalsteadDifficultyNode().getValue().toString());
		l.add(pm.getHalsteadLengthNode().getValue().toString());
		l.add(pm.getHalsteadLevelNode().getValue().toString());
		l.add(pm.getHalsteadProgrammingEffortNode().getValue().toString());
		l.add(pm.getHalsteadProgrammingTimeNode().getValue().toString());
		l.add(pm.getHalsteadVolumeNode().getValue().toString());
		l.add(pm.getMaintenanceSeverityNode().getValue().toString());
		return l;

	}

	public List<String> getFileMetrics(FileMetrics fm)
	{
		List<String> l = new ArrayList<String>();
		// l.add(fm.getNameNode().getValue().toString());
		l.add(fm.getNameNode().getValue().toString());
		l.add(fm.getIdNode().getValue().toString());
		l.add(fm.getCyclomaticComplexityNode().getValue().toString());
		l.add(fm.getDecisionDensityNode().getValue().toString());
		l.add(fm.getEssentialDensityNode().getValue().toString());
		l.add(fm.getBranchCountNode().getValue().toString());
		l.add(fm.getConditionCountNode().getValue().toString());
		l.add(fm.getCylomaticDensityNode().getValue().toString());
		l.add(fm.getDecisionCountNode().getValue().toString());
		l.add(fm.getEssentialComplexityNode().getValue().toString());
		l.add(fm.getLOCNode().getValue().toString());
		l.add(fm.getTotalOperandsNode().getValue().toString());
		l.add(fm.getTotalOperatorsNode().getValue().toString());
		l.add(fm.getUniqueOperandsCountNode().getValue().toString());
		l.add(fm.getUniqueOperatorsCountNode().getValue().toString());
		l.add(fm.getHalsteadDifficultyNode().getValue().toString());
		l.add(fm.getHalsteadLengthNode().getValue().toString());
		l.add(fm.getHalsteadLevelNode().getValue().toString());
		l.add(fm.getHalsteadProgrammingEffortNode().getValue().toString());
		l.add(fm.getHalsteadProgrammingTimeNode().getValue().toString());
		l.add(fm.getHalsteadVolumeNode().getValue().toString());
		l.add(fm.getMaintenanceSeverityNode().getValue().toString());
		return l;

	}

	public List<String> getClassMetrics(ClassMetrics cm, FileMetrics fm)
	{
		List<String> l = new ArrayList<String>();
		l.add(fm.getNameNode().getValue().toString());
		l.add(fm.getIdNode().getValue().toString());
		l.add(cm.getNameNode().getValue().toString());
		l.add(cm.getIdNode().getValue().toString());
		l.add(cm.getStartLineNode().getValue().toString());
		l.add(cm.getEndLineNode().getValue().toString());
		l.add(cm.getCyclomaticComplexityNode().getValue().toString());
		l.add(cm.getDecisionDensityNode().getValue().toString());
		l.add(cm.getEssentialDensityNode().getValue().toString());
		l.add(cm.getBranchCountNode().getValue().toString());
		l.add(cm.getConditionCountNode().getValue().toString());
		l.add(cm.getCylomaticDensityNode().getValue().toString());
		l.add(cm.getDecisionCountNode().getValue().toString());
		l.add(cm.getEssentialComplexityNode().getValue().toString());
		l.add(cm.getLOCNode().getValue().toString());
		l.add(cm.getTotalOperandsNode().getValue().toString());
		l.add(cm.getTotalOperatorsNode().getValue().toString());
		l.add(cm.getUniqueOperandsCountNode().getValue().toString());
		l.add(cm.getUniqueOperatorsCountNode().getValue().toString());
		l.add(cm.getHalsteadDifficultyNode().getValue().toString());
		l.add(cm.getHalsteadLengthNode().getValue().toString());
		l.add(cm.getHalsteadLevelNode().getValue().toString());
		l.add(cm.getHalsteadProgrammingEffortNode().getValue().toString());
		l.add(cm.getHalsteadProgrammingTimeNode().getValue().toString());
		l.add(cm.getHalsteadVolumeNode().getValue().toString());
		l.add(cm.getMaintenanceSeverityNode().getValue().toString());
		l.add(cm.getCouplingBetweenObjectsNode().getValue().toString());
		l.add(cm.getFanInNode().getValue().toString());
		l.add(cm.getNumberOfChildrenNode().getValue().toString());
		l.add(cm.getPercentageOfPubDataNode().getValue().toString());
		l.add(cm.getResponseForClassNode().getValue().toString());
		l.add(cm.getWeightedMethodsNode().getValue().toString());
		return l;

	}

	public List<String> getMethodMetrics(MethodMetrics mm, FileMetrics fm, ClassMetrics cm)
	{
		List<String> l = new ArrayList<String>();
		l.add(fm.getNameNode().getValue().toString());
		l.add(fm.getIdNode().getValue().toString());
		l.add(cm.getNameNode().getValue().toString());
		l.add(mm.getNameNode().getValue().toString());
		l.add(mm.getIdNode().getValue().toString());
		l.add(cm.getStartLineNode().getValue().toString());
		l.add(cm.getEndLineNode().getValue().toString());
		l.add(mm.getCyclomaticComplexityNode().getValue().toString());
		l.add(mm.getDecisionDensityNode().getValue().toString());
		l.add(mm.getEssentialDensityNode().getValue().toString());
		l.add(mm.getBranchCountNode().getValue().toString());
		l.add(mm.getConditionCountNode().getValue().toString());
		l.add(mm.getCylomaticDensityNode().getValue().toString());
		l.add(mm.getDecisionCountNode().getValue().toString());
		l.add(mm.getEssentialComplexityNode().getValue().toString());
		l.add(mm.getLOCNode().getValue().toString());
		l.add(mm.getTotalOperandsNode().getValue().toString());
		l.add(mm.getTotalOperatorsNode().getValue().toString());
		l.add(mm.getUniqueOperandsCountNode().getValue().toString());
		l.add(mm.getUniqueOperatorsCountNode().getValue().toString());
		l.add(mm.getHalsteadDifficultyNode().getValue().toString());
		l.add(mm.getHalsteadLengthNode().getValue().toString());
		l.add(mm.getHalsteadLevelNode().getValue().toString());
		l.add(mm.getHalsteadProgrammingEffortNode().getValue().toString());
		l.add(mm.getHalsteadProgrammingTimeNode().getValue().toString());
		l.add(mm.getHalsteadVolumeNode().getValue().toString());
		l.add(mm.getMaintenanceSeverityNode().getValue().toString());
		l.add(mm.getFormalParametersNode().getValue().toString());
		l.add(mm.getCallPairLengthNode().getValue().toString());
		return l;
	}

	public List<String> getPackageNameList()
	{
		List<String> list = new ArrayList<String>();
		Iterator<String> it = packages.keySet().iterator();
		while (it.hasNext())
		{
			list.add(it.next());
		}
		return list;
	}

	// returns the class to be found or null if the class is not present in the
	// project
	public ClassMetrics findClass(String classToFind)
	{
		Iterator<String> packageIterator = packages.keySet().iterator();
		while (packageIterator.hasNext())
		{
			PackageMetrics currentPackage = packages.get(packageIterator.next());

			Iterator<String> fileIterator = currentPackage.files.keySet().iterator();

			while (fileIterator.hasNext())
			{
				FileMetrics currentFile = currentPackage.files.get(fileIterator.next());
				Iterator<String> classIterator = currentFile.classes.keySet().iterator();
				while (classIterator.hasNext())
				{
					String classKey = classIterator.next();
					if (classKey.compareTo(classToFind) == 0 || classKey.endsWith("." + classToFind)
							|| classToFind.endsWith("." + classKey) || classToFind.endsWith(classKey))
						return currentFile.getClass(classKey);
				}
			}
		}
		return null;
	}

	// returns the method to be found or it returns -1 if the method is not
	// present
	public int findMethod(String methodName)
	{

		for (Iterator<String> packIterator = packages.keySet().iterator(); packIterator.hasNext();)
		{
			PackageMetrics pack = packages.get(packIterator.next());
			for (Iterator<String> fileIterator = pack.files.keySet().iterator(); fileIterator.hasNext();)
			{
				FileMetrics file = pack.files.get(fileIterator.next());
				for (Iterator<String> classIterator = file.classes.keySet().iterator(); classIterator.hasNext();)
				{
					ClassMetrics currentClass = file.getClass(classIterator.next());
					Iterator<String> methodIterator = currentClass.methods.keySet().iterator();
					while (methodIterator.hasNext())
					{
						MethodMetrics method = currentClass.getMethod(methodIterator.next());
						if (methodName.endsWith(currentClass.name + "." + method.name))
						{
							return method.getId();
						}

					}
				}
			}
		}
		return -1;
	}

	public ConvertToString getConvertToString()
	{
		ConvertToString output = new ConvertToString();

		for (Iterator<String> pk = getPackageNames(); pk.hasNext();)
		{
			PackageMetrics pm = getPackage(pk.next());
			output.addPackageInfo(pm);

			for (Iterator<String> fk = pm.getFileNames(); fk.hasNext();)
			{
				FileMetrics fm = pm.getFile(fk.next());
				output.addFileInfo(fm, pm.getId());

				for (Iterator<String> ck = fm.getClassNames(); ck.hasNext();)
				{
					ClassMetrics cm = fm.getClass(ck.next());
					output.addClassInfo(cm, pm.getId(), fm.getId());

					for (Iterator<String> mk = cm.getMethodNames(); mk.hasNext();)
					{
						MethodMetrics mm = cm.getMethod(mk.next());
						output.addMethodInfo(mm, pm.getId(), fm.getId(), cm.getId(), cm.getName(), this);
					}
				}
			}
		}

		return output;
	}

	public DataContext getDataContextFormat()
	{
		DataContext dataContext = new DataContext();

		for (String packageName : getPackageNameList())
		{
			dataContext.add(packageName, new DataContext());
			PackageMetrics pm = getPackage(packageName);
			addPackageInfo(dataContext.getNode(packageName), pm);

			for (String fileName : pm.getFileNameList())
			{
				dataContext.getNode(packageName).add(fileName, new DataContext());
				FileMetrics fm = pm.getFile(fileName);
				addFileInfo(dataContext.getNode(packageName).getNode(fileName), fm, pm.getIdNode());

				for (String className : fm.getClassNameList())
				{
					dataContext.getNode(packageName).getNode(fileName).add(className, new DataContext());
					ClassMetrics cm = fm.getClass(className);
					addClassInfo(dataContext.getNode(packageName).getNode(fileName).getNode(className), cm, pm.getIdNode(), fm
							.getIdNode());

					for (String methodName : cm.getMethodNameList())
					{
						dataContext.getNode(packageName).getNode(fileName).getNode(className).add(methodName, new DataContext());
						MethodMetrics mm = cm.getMethod(methodName);
						addMethodInfo(dataContext.getNode(packageName).getNode(fileName).getNode(className).getNode(methodName),
								mm, pm.getIdNode(), fm.getIdNode(), cm.getIdNode(), cm.getNameNode(), this);
						cm.deleteMethod(methodName);
					}
					fm.deleteClass(className);
				}
				pm.deleteFile(fileName);
			}
			this.deletePackage(packageName);
		}

		return dataContext;
	}

	public void addPackageInfo(DataContext dataContext, PackageMetrics packageMetricsToAdd)
	{
		dataContext.add(packageMetricsToAdd.getNameNode());
		dataContext.add(packageMetricsToAdd.getIdNode());
		dataContext.add(packageMetricsToAdd.getCylomaticDensityNode());
		dataContext.add(packageMetricsToAdd.getDecisionDensityNode());
		dataContext.add(packageMetricsToAdd.getEssentialDensityNode());

		dataContext.add(packageMetricsToAdd.getBranchCountNode());
		dataContext.add(packageMetricsToAdd.getConditionCountNode());
		dataContext.add(packageMetricsToAdd.getCyclomaticComplexityNode());
		dataContext.add(packageMetricsToAdd.getDecisionCountNode());
		dataContext.add(packageMetricsToAdd.getEssentialComplexityNode());

		dataContext.add(packageMetricsToAdd.getLOCNode());
		dataContext.add(packageMetricsToAdd.getTotalOperandsNode());
		dataContext.add(packageMetricsToAdd.getTotalOperatorsNode());
		dataContext.add(packageMetricsToAdd.getUniqueOperandsCountNode());
		dataContext.add(packageMetricsToAdd.getUniqueOperatorsCountNode());

		dataContext.add(packageMetricsToAdd.getHalsteadDifficultyNode());
		dataContext.add(packageMetricsToAdd.getHalsteadLengthNode());
		dataContext.add(packageMetricsToAdd.getHalsteadLevelNode());
		dataContext.add(packageMetricsToAdd.getHalsteadProgrammingEffortNode());
		dataContext.add(packageMetricsToAdd.getHalsteadProgrammingTimeNode());

		dataContext.add(packageMetricsToAdd.getHalsteadVolumeNode());
		dataContext.add(packageMetricsToAdd.getMaintenanceSeverityNode());
	}

	public void addFileInfo(DataContext dataContext, FileMetrics fileMetricsToAdd, NodePair packageId)
	{
		dataContext.add(fileMetricsToAdd.getNameNode());
		dataContext.add(fileMetricsToAdd.getIdNode());
		// dataContext.add(packageId);
		dataContext.add(fileMetricsToAdd.getCylomaticDensityNode());
		dataContext.add(fileMetricsToAdd.getDecisionDensityNode());
		dataContext.add(fileMetricsToAdd.getEssentialDensityNode());

		dataContext.add(fileMetricsToAdd.getBranchCountNode());
		dataContext.add(fileMetricsToAdd.getConditionCountNode());
		dataContext.add(fileMetricsToAdd.getCyclomaticComplexityNode());
		dataContext.add(fileMetricsToAdd.getDecisionCountNode());
		dataContext.add(fileMetricsToAdd.getEssentialComplexityNode());
		dataContext.add(fileMetricsToAdd.getLOCNode());
		dataContext.add(fileMetricsToAdd.getTotalOperandsNode());
		dataContext.add(fileMetricsToAdd.getTotalOperatorsNode());
		dataContext.add(fileMetricsToAdd.getUniqueOperandsCountNode());
		dataContext.add(fileMetricsToAdd.getUniqueOperatorsCountNode());
		dataContext.add(fileMetricsToAdd.getHalsteadDifficultyNode());
		dataContext.add(fileMetricsToAdd.getHalsteadLengthNode());
		dataContext.add(fileMetricsToAdd.getHalsteadLevelNode());
		dataContext.add(fileMetricsToAdd.getHalsteadProgrammingEffortNode());
		dataContext.add(fileMetricsToAdd.getHalsteadProgrammingTimeNode());
		dataContext.add(fileMetricsToAdd.getHalsteadVolumeNode());
		dataContext.add(fileMetricsToAdd.getMaintenanceSeverityNode());

	}

	public void addClassInfo(DataContext dataContext, ClassMetrics classMetricsToAdd, NodePair packageId, NodePair fileId)
	{

		dataContext.add(classMetricsToAdd.getNameNode());
		dataContext.add(classMetricsToAdd.getIdNode());
		// dataContext.add(packageId);
		// dataContext.add(fileId);
		dataContext.add(classMetricsToAdd.getCylomaticDensityNode());

		dataContext.add(classMetricsToAdd.getDecisionDensityNode());
		dataContext.add(classMetricsToAdd.getEssentialDensityNode());
		dataContext.add(classMetricsToAdd.getBranchCountNode());
		dataContext.add(classMetricsToAdd.getConditionCountNode());
		dataContext.add(classMetricsToAdd.getCyclomaticComplexityNode());

		dataContext.add(classMetricsToAdd.getDecisionCountNode());
		dataContext.add(classMetricsToAdd.getEssentialComplexityNode());
		dataContext.add(classMetricsToAdd.getLOCNode());
		dataContext.add(classMetricsToAdd.getTotalOperandsNode());
		dataContext.add(classMetricsToAdd.getTotalOperatorsNode());

		dataContext.add(classMetricsToAdd.getUniqueOperandsCountNode());
		dataContext.add(classMetricsToAdd.getUniqueOperatorsCountNode());
		dataContext.add(classMetricsToAdd.getHalsteadDifficultyNode());
		dataContext.add(classMetricsToAdd.getHalsteadLengthNode());
		dataContext.add(classMetricsToAdd.getHalsteadLevelNode());

		dataContext.add(classMetricsToAdd.getHalsteadProgrammingEffortNode());
		dataContext.add(classMetricsToAdd.getHalsteadProgrammingTimeNode());
		dataContext.add(classMetricsToAdd.getHalsteadVolumeNode());
		dataContext.add(classMetricsToAdd.getMaintenanceSeverityNode());
		dataContext.add(classMetricsToAdd.getCouplingBetweenObjectsNode());

		dataContext.add(classMetricsToAdd.getFanInNode());
		dataContext.add(classMetricsToAdd.getNumberOfChildrenNode());
		dataContext.add(classMetricsToAdd.getPercentageOfPubDataNode());
		dataContext.add(classMetricsToAdd.getResponseForClassNode());
		dataContext.add(classMetricsToAdd.getWeightedMethodsNode());
	}

	public void addMethodInfo(DataContext dataContext, MethodMetrics methodMetricsToAdd, NodePair packageId, NodePair fileId,
			NodePair classId, NodePair className, ClassContainer container)
	{
		if (methodMetricsToAdd.name.contains("implicitConstructor"))
			return;

		NodePair nameNode = new NodePair(methodMetricsToAdd.getNameNode().getName(), methodMetricsToAdd.getNameNode().getValue());
		dataContext.add(nameNode);
		dataContext.add(methodMetricsToAdd.getIdNode());
		// dataContext.add(packageId);
		// dataContext.add(fileId);
		// dataContext.add(classId);

		dataContext.add(methodMetricsToAdd.getCylomaticDensityNode());
		dataContext.add(methodMetricsToAdd.getDecisionDensityNode());
		dataContext.add(methodMetricsToAdd.getEssentialDensityNode());
		dataContext.add(methodMetricsToAdd.getBranchCountNode());
		dataContext.add(methodMetricsToAdd.getConditionCountNode());

		dataContext.add(methodMetricsToAdd.getCyclomaticComplexityNode());
		dataContext.add(methodMetricsToAdd.getDecisionCountNode());
		dataContext.add(methodMetricsToAdd.getEssentialComplexityNode());
		dataContext.add(methodMetricsToAdd.getLOCNode());
		dataContext.add(methodMetricsToAdd.getTotalOperandsNode());

		dataContext.add(methodMetricsToAdd.getTotalOperatorsNode());
		dataContext.add(methodMetricsToAdd.getUniqueOperandsCountNode());
		dataContext.add(methodMetricsToAdd.getUniqueOperatorsCountNode());
		dataContext.add(methodMetricsToAdd.getHalsteadDifficultyNode());
		dataContext.add(methodMetricsToAdd.getHalsteadLengthNode());

		dataContext.add(methodMetricsToAdd.getHalsteadLevelNode());
		dataContext.add(methodMetricsToAdd.getHalsteadProgrammingEffortNode());
		dataContext.add(methodMetricsToAdd.getHalsteadProgrammingTimeNode());
		dataContext.add(methodMetricsToAdd.getHalsteadVolumeNode());
		dataContext.add(methodMetricsToAdd.getMaintenanceSeverityNode());
		//
		//		dataContext.add(methodMetricsToAdd.getFormalParametersNode());
		//		dataContext.add(methodMetricsToAdd.getCallPairLengthNode());
	}

	// FILE

	private static String tab(int tab)
	{
		String ret = "";
		for (int i = 0; i < tab; i++)
		{
			ret += DataContext.kOffset;
		}
		return ret;
	}

	private static String xmlTagOpenStringForName(String name, int tab)
	{
		name = DataContext.replaceProblemCharacters(name);
		return tab(tab) + DataContext.bgn_mark + name + DataContext.cls + "\n";
	}

	private static String xmlTagOpenStringForNameAndType(String name, String type, int tab)
	{
		if (type == null)
			type = "java.lang.String";
		name = DataContext.replaceProblemCharacters(name);
		return tab(tab) + DataContext.bgn_mark + name + DataContext.type_s + type + DataContext.trm;
	}

	private static String xmlTagCloseStringForName(String name, int tab)
	{
		name = DataContext.replaceProblemCharacters(name);
		return tab(tab) + DataContext.end_mark + name + DataContext.cls + "\n";
	}

	private static String xmlLeafNode(String name, String type, String value, int tab)
	{
		value = value.replace("<", DataContext.LESSTHAN).replace(">", DataContext.GREATERTHAN);
		return xmlTagOpenStringForNameAndType(name, type, tab) + value + xmlTagCloseStringForName(name, 0);
	}

	public static byte[] getNodeBytes(NodePair node, int tab)
	{
		return xmlLeafNode(node.getName(), null, (String) node.getValue(), tab).getBytes();
	}

	public void writeToFileAsXml(String xmlFileName) throws Exception
	{
		BufferedOutputStream out = null;
		try
		{

			out = new BufferedOutputStream(new FileOutputStream(xmlFileName));
			out.write(DataContext.kBaseXML.getBytes());
			out.write(xmlTagOpenStringForName(DataContext.kRootName, 0).getBytes());

			for (Iterator<String> pk = getPackageNames(); pk.hasNext();)
			{
				String packageName = pk.next();

				out.write(xmlTagOpenStringForName(packageName, 1).getBytes());
				out.flush();

				PackageMetrics pm = getPackage(packageName);
				writePackageInfo(out, pm, 2);// package metricleri

				for (Iterator<String> fk = pm.getFileNames(); fk.hasNext();)
				{
					String fileName = fk.next();

					out.write(xmlTagOpenStringForName(fileName, 2).getBytes());
					out.flush();

					FileMetrics fm = pm.getFile(fileName);
					writeFileInfo(out, fm, 3);

					for (Iterator<String> ck = fm.getClassNames(); ck.hasNext();)
					{
						String className = ck.next();

						out.write(xmlTagOpenStringForName(className, 3).getBytes());
						out.flush();

						ClassMetrics cm = fm.getClass(className);
						writeClassInfo(out, cm, 4);

						for (Iterator<String> mk = cm.getMethodNames(); mk.hasNext();)
						{
							String methodName = mk.next();

							out.write(xmlTagOpenStringForName(methodName, 4).getBytes());

							MethodMetrics mm = cm.getMethod(methodName);
							writeMethodInfo(out, mm, 5);
							out.flush();

							out.write(xmlTagCloseStringForName(methodName, 4).getBytes());
						}
						out.write(xmlTagCloseStringForName(className, 3).getBytes());
					}
					out.write(xmlTagCloseStringForName(fileName, 2).getBytes());
				}
				out.write(xmlTagCloseStringForName(packageName, 1).getBytes());
			}
			out.write(xmlTagCloseStringForName(DataContext.kRootName, 0).getBytes());

			out.flush();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			out.flush();
			out.close();
		}
	}

	public void writePackageInfo(BufferedOutputStream out, PackageMetrics packageMetricsToAdd, int tab) throws Exception
	{
		out.write(getNodeBytes(packageMetricsToAdd.getNameNode(), tab));
		out.write(getNodeBytes(packageMetricsToAdd.getIdNode(), tab));
		out.write(getNodeBytes(packageMetricsToAdd.getCylomaticDensityNode(), tab));
		out.write(getNodeBytes(packageMetricsToAdd.getDecisionDensityNode(), tab));
		out.write(getNodeBytes(packageMetricsToAdd.getEssentialDensityNode(), tab));

		out.write(getNodeBytes(packageMetricsToAdd.getBranchCountNode(), tab));
		out.write(getNodeBytes(packageMetricsToAdd.getConditionCountNode(), tab));
		out.write(getNodeBytes(packageMetricsToAdd.getCyclomaticComplexityNode(), tab));
		out.write(getNodeBytes(packageMetricsToAdd.getDecisionCountNode(), tab));
		out.write(getNodeBytes(packageMetricsToAdd.getEssentialComplexityNode(), tab));

		out.write(getNodeBytes(packageMetricsToAdd.getLOCNode(), tab));
		out.write(getNodeBytes(packageMetricsToAdd.getTotalOperandsNode(), tab));
		out.write(getNodeBytes(packageMetricsToAdd.getTotalOperatorsNode(), tab));
		out.write(getNodeBytes(packageMetricsToAdd.getUniqueOperandsCountNode(), tab));
		out.write(getNodeBytes(packageMetricsToAdd.getUniqueOperatorsCountNode(), tab));

		out.write(getNodeBytes(packageMetricsToAdd.getHalsteadDifficultyNode(), tab));
		out.write(getNodeBytes(packageMetricsToAdd.getHalsteadLengthNode(), tab));
		out.write(getNodeBytes(packageMetricsToAdd.getHalsteadLevelNode(), tab));
		out.write(getNodeBytes(packageMetricsToAdd.getHalsteadProgrammingEffortNode(), tab));
		out.write(getNodeBytes(packageMetricsToAdd.getHalsteadProgrammingTimeNode(), tab));

		out.write(getNodeBytes(packageMetricsToAdd.getHalsteadVolumeNode(), tab));
		out.write(getNodeBytes(packageMetricsToAdd.getMaintenanceSeverityNode(), tab));
	}

	public void writeFileInfo(BufferedOutputStream out, FileMetrics fileMetricsToAdd, int tab) throws Exception
	{
		out.write(getNodeBytes(fileMetricsToAdd.getNameNode(), tab));
		out.write(getNodeBytes(fileMetricsToAdd.getIdNode(), tab));
		out.write(getNodeBytes(fileMetricsToAdd.getCylomaticDensityNode(), tab));
		out.write(getNodeBytes(fileMetricsToAdd.getDecisionDensityNode(), tab));
		out.write(getNodeBytes(fileMetricsToAdd.getEssentialDensityNode(), tab));

		out.write(getNodeBytes(fileMetricsToAdd.getBranchCountNode(), tab));
		out.write(getNodeBytes(fileMetricsToAdd.getConditionCountNode(), tab));
		out.write(getNodeBytes(fileMetricsToAdd.getCyclomaticComplexityNode(), tab));
		out.write(getNodeBytes(fileMetricsToAdd.getDecisionCountNode(), tab));
		out.write(getNodeBytes(fileMetricsToAdd.getEssentialComplexityNode(), tab));
		out.write(getNodeBytes(fileMetricsToAdd.getLOCNode(), tab));
		out.write(getNodeBytes(fileMetricsToAdd.getTotalOperandsNode(), tab));
		out.write(getNodeBytes(fileMetricsToAdd.getTotalOperatorsNode(), tab));
		out.write(getNodeBytes(fileMetricsToAdd.getUniqueOperandsCountNode(), tab));
		out.write(getNodeBytes(fileMetricsToAdd.getUniqueOperatorsCountNode(), tab));
		out.write(getNodeBytes(fileMetricsToAdd.getHalsteadDifficultyNode(), tab));
		out.write(getNodeBytes(fileMetricsToAdd.getHalsteadLengthNode(), tab));
		out.write(getNodeBytes(fileMetricsToAdd.getHalsteadLevelNode(), tab));
		out.write(getNodeBytes(fileMetricsToAdd.getHalsteadProgrammingEffortNode(), tab));
		out.write(getNodeBytes(fileMetricsToAdd.getHalsteadProgrammingTimeNode(), tab));
		out.write(getNodeBytes(fileMetricsToAdd.getHalsteadVolumeNode(), tab));
		out.write(getNodeBytes(fileMetricsToAdd.getMaintenanceSeverityNode(), tab));

	}

	public void writeClassInfo(BufferedOutputStream out, ClassMetrics classMetricsToAdd, int tab) throws Exception
	{

		out.write(getNodeBytes(classMetricsToAdd.getNameNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getIdNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getCylomaticDensityNode(), tab));

		out.write(getNodeBytes(classMetricsToAdd.getDecisionDensityNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getEssentialDensityNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getBranchCountNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getConditionCountNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getCyclomaticComplexityNode(), tab));

		out.write(getNodeBytes(classMetricsToAdd.getDecisionCountNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getEssentialComplexityNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getLOCNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getTotalOperandsNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getTotalOperatorsNode(), tab));

		out.write(getNodeBytes(classMetricsToAdd.getUniqueOperandsCountNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getUniqueOperatorsCountNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getHalsteadDifficultyNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getHalsteadLengthNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getHalsteadLevelNode(), tab));

		out.write(getNodeBytes(classMetricsToAdd.getHalsteadProgrammingEffortNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getHalsteadProgrammingTimeNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getHalsteadVolumeNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getMaintenanceSeverityNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getCouplingBetweenObjectsNode(), tab));

		out.write(getNodeBytes(classMetricsToAdd.getFanInNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getNumberOfChildrenNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getPercentageOfPubDataNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getResponseForClassNode(), tab));
		out.write(getNodeBytes(classMetricsToAdd.getWeightedMethodsNode(), tab));
	}

	public void writeMethodInfo(BufferedOutputStream out, MethodMetrics methodMetricsToAdd, int tab) throws Exception
	{
		if (methodMetricsToAdd.name.contains("implicitConstructor"))
			return;

		NodePair nameNode = new NodePair(methodMetricsToAdd.getNameNode().getName(), methodMetricsToAdd.getNameNode().getValue());
		out.write(getNodeBytes(nameNode, tab));
		out.write(getNodeBytes(methodMetricsToAdd.getIdNode(), tab));

		out.write(getNodeBytes(methodMetricsToAdd.getCylomaticDensityNode(), tab));
		out.write(getNodeBytes(methodMetricsToAdd.getDecisionDensityNode(), tab));
		out.write(getNodeBytes(methodMetricsToAdd.getEssentialDensityNode(), tab));
		out.write(getNodeBytes(methodMetricsToAdd.getBranchCountNode(), tab));
		out.write(getNodeBytes(methodMetricsToAdd.getConditionCountNode(), tab));

		out.write(getNodeBytes(methodMetricsToAdd.getCyclomaticComplexityNode(), tab));
		out.write(getNodeBytes(methodMetricsToAdd.getDecisionCountNode(), tab));
		out.write(getNodeBytes(methodMetricsToAdd.getEssentialComplexityNode(), tab));
		out.write(getNodeBytes(methodMetricsToAdd.getLOCNode(), tab));
		out.write(getNodeBytes(methodMetricsToAdd.getTotalOperandsNode(), tab));

		out.write(getNodeBytes(methodMetricsToAdd.getTotalOperatorsNode(), tab));
		out.write(getNodeBytes(methodMetricsToAdd.getUniqueOperandsCountNode(), tab));
		out.write(getNodeBytes(methodMetricsToAdd.getUniqueOperatorsCountNode(), tab));
		out.write(getNodeBytes(methodMetricsToAdd.getHalsteadDifficultyNode(), tab));
		out.write(getNodeBytes(methodMetricsToAdd.getHalsteadLengthNode(), tab));

		out.write(getNodeBytes(methodMetricsToAdd.getHalsteadLevelNode(), tab));
		out.write(getNodeBytes(methodMetricsToAdd.getHalsteadProgrammingEffortNode(), tab));
		out.write(getNodeBytes(methodMetricsToAdd.getHalsteadProgrammingTimeNode(), tab));
		out.write(getNodeBytes(methodMetricsToAdd.getHalsteadVolumeNode(), tab));
		out.write(getNodeBytes(methodMetricsToAdd.getMaintenanceSeverityNode(), tab));

		out.write(getNodeBytes(methodMetricsToAdd.getFormalParametersNode(), tab));
		out.write(getNodeBytes(methodMetricsToAdd.getCallPairLengthNode(), tab));

	}

	public void writeToFileAsXls(String xmlFileName, String packageCsvFileName, String fileCsvFileName, String classCsvFileName,
			String methodCsvFileName) throws Exception
	{
		BufferedOutputStream outP = null;
		BufferedOutputStream outC = null;
		BufferedOutputStream outF = null;
		BufferedOutputStream outM = null;

		try
		{
			FileOutputStream fosP = new FileOutputStream(packageCsvFileName);
			FileOutputStream fosC = new FileOutputStream(classCsvFileName);
			FileOutputStream fosF = new FileOutputStream(fileCsvFileName);
			FileOutputStream fosM = new FileOutputStream(methodCsvFileName);

			outP = new BufferedOutputStream(fosP);
			outF = new BufferedOutputStream(fosF);
			outC = new BufferedOutputStream(fosC);
			outM = new BufferedOutputStream(fosM);

			outP.write("Package Name,".getBytes());
			outP.write("Package Id,".getBytes());
			outP.write("Cyclometric Density,".getBytes());
			outP.write("Decision Density,".getBytes());
			outP.write("Essential Density,".getBytes());
			outP.write("Branch Count,".getBytes());
			outP.write("Condition Count,".getBytes());
			outP.write("Cyclometric Complexity,".getBytes());
			outP.write("Decision Count,".getBytes());
			outP.write("Essential Complexity,".getBytes());
			outP.write("LOC,".getBytes());
			outP.write("Total Operands,".getBytes());
			outP.write("Total Operators,".getBytes());
			outP.write("Unique Operands Count,".getBytes());
			outP.write("Unique Operators Count,".getBytes());
			outP.write("Halstead Difficulty,".getBytes());
			outP.write("Halstead Length,".getBytes());
			outP.write("Halstead Level,".getBytes());
			outP.write("Halstead Programming Effort,".getBytes());
			outP.write("Halstead Programming Time,".getBytes());
			outP.write("Halstead Volume,".getBytes());
			outP.write("Maintenance Severity,".getBytes());
			outP.write("Defected?(false/true)\n".getBytes());
			outP.flush();

			//			outF.write("File Name,".getBytes());
			//			outF.write("File Id,".getBytes());
			//			outF.write("PD.MM.FL.001,".getBytes());
			//			outF.write("PD.MM.FL.004,".getBytes());
			//			outF.write("PD.MM.FL.006,".getBytes());
			//			outF.write("PD.SM.FL.002,".getBytes());
			//			outF.write("PD.SM.FL.004,".getBytes());
			//			outF.write("PD.MM.FL.002,".getBytes());
			//			outF.write("PD.SM.FL.005,".getBytes());
			//			outF.write("PD.MM.FL.005,".getBytes());
			//			outF.write("PD.SM.FL.001,".getBytes());
			//			outF.write("PD.SM.FL.012,".getBytes());
			//			outF.write("PD.SM.FL.013,".getBytes());
			//			outF.write("PD.SM.FL.014,".getBytes());
			//			outF.write("PD.SM.FL.015,".getBytes());
			//			outF.write("PD.HM.FL.004,".getBytes());
			//			outF.write("PD.HM.FL.001,".getBytes());
			//			outF.write("PD.HM.FL.003,".getBytes());
			//			outF.write("PD.HM.FL.006,".getBytes());
			//			outF.write("PD.HM.FL.008,".getBytes());
			//			outF.write("PD.HM.FL.002,".getBytes());
			//			outF.write("PD.MM.FL.007,".getBytes());
			//			outF.write("Defected?(false/true) \n".getBytes());

			outF.write("File Name,".getBytes());
			outF.write("File Id,".getBytes());
			outF.write("Cyclometric Complexity,".getBytes());
			outF.write("Decision Density,".getBytes());
			outF.write("Essential Density,".getBytes());
			outF.write("Branch Count,".getBytes());
			outF.write("Condition Count,".getBytes());
			outF.write("Cyclometric Density,".getBytes());
			outF.write("Decision Count,".getBytes());
			outF.write("Essential Complexity,".getBytes());
			outF.write("LOC,".getBytes());
			outF.write("Total Operands,".getBytes());
			outF.write("Total Operators,".getBytes());
			outF.write("Unique Operands Count,".getBytes());
			outF.write("Unique Operators Count,".getBytes());
			outF.write("Halstead Difficulty,".getBytes());
			outF.write("Halstead Length,".getBytes());
			outF.write("Halstead Level,".getBytes());
			outF.write("Halstead Programming Effort,".getBytes());
			outF.write("Halstead Programming Time,".getBytes());
			outF.write("Halstead Volume,".getBytes());
			outF.write("Maintenance Severity,".getBytes());
			outF.write("Defected?(false/true) \n".getBytes());

			outF.flush();

			//			outC.write("File Path,".getBytes());
			//			outC.write("File Id,".getBytes());
			//			outC.write("Class Name,".getBytes());
			//			outC.write("Class Id,".getBytes());
			//			outC.write("StartLine,".getBytes());
			//			outC.write("EndLine,".getBytes());
			//			outC.write("PD.MM.CL.002,".getBytes());
			//			outC.write("PD.MM.CL.004,".getBytes());
			//			outC.write("PD.MM.CL.006,".getBytes());
			//			outC.write("PD.SM.CL.002,".getBytes());
			//			outC.write("PD.SM.CL.004,".getBytes());
			//			outC.write("PD.MM.CL.001,".getBytes());
			//			outC.write("PD.SM.CL.005,".getBytes());
			//			outC.write("PD.MM.CL.005,".getBytes());
			//			outC.write("PD.SM.CL.001,".getBytes());
			//			outC.write("PD.SM.CL.012,".getBytes());
			//			outC.write("PD.SM.CL.013,".getBytes());
			//			outC.write("PD.SM.CL.014,".getBytes());
			//			outC.write("PD.SM.CL.015,".getBytes());
			//			outC.write("PD.HM.CL.004,".getBytes());
			//			outC.write("PD.HM.CL.001,".getBytes());
			//			outC.write("PD.HM.CL.003,".getBytes());
			//			outC.write("PD.HM.CL.006,".getBytes());
			//			outC.write("PD.HM.CL.008,".getBytes());
			//			outC.write("PD.HM.CL.002,".getBytes());
			//			outC.write("PD.MM.CL.007,".getBytes());
			//			outC.write("PD.OM.XX.004,".getBytes());
			//			outC.write("PD.XX.XX.011,".getBytes());
			//			outC.write("PD.OM.XX.005,".getBytes());
			//			outC.write("PD.XX.XX.012,".getBytes());
			//			outC.write("PD.OM.XX.003,".getBytes());
			//			outC.write("PD.OM.XX.007,".getBytes());
			//			outC.write("Defected?(false/true) \n".getBytes());

			outC.write("File Path,".getBytes());
			outC.write("File Id,".getBytes());
			outC.write("Class Name,".getBytes());
			outC.write("Class Id,".getBytes());
			outC.write("StartLine,".getBytes());
			outC.write("EndLine,".getBytes());
			outC.write("Cyclometric Density,".getBytes());
			outC.write("Decision Density,".getBytes());
			outC.write("Essential Density,".getBytes());
			outC.write("Branch Count,".getBytes());
			outC.write("Condition Count,".getBytes());
			outC.write("Cyclometric Complexity,".getBytes());
			outC.write("Decision Count,".getBytes());
			outC.write("Essential Complexity,".getBytes());
			outC.write("LOC,".getBytes());
			outC.write("Total Operands,".getBytes());
			outC.write("Total Operators,".getBytes());
			outC.write("Unique Operands Count,".getBytes());
			outC.write("Unique Operators Count,".getBytes());
			outC.write("Halstead Difficulty,".getBytes());
			outC.write("Halstead Length,".getBytes());
			outC.write("Halstead Level,".getBytes());
			outC.write("Halstead Programming Effort,".getBytes());
			outC.write("Halstead Programming Time,".getBytes());
			outC.write("Halstead Volume,".getBytes());
			outC.write("Maintenance Severity,".getBytes());
			outC.write("Coupling Between Objects,".getBytes());
			outC.write("Fan In,".getBytes());
			outC.write("Number of Children,".getBytes());
			outC.write("Percentage of Pub Data,".getBytes());
			outC.write("Response for Class,".getBytes());
			outC.write("Weighted Methods,".getBytes());
			outC.write("Defected?(false/true) \n".getBytes());

			outC.flush();

			//			outM.write("File Name,".getBytes());
			//			outM.write("File Id,".getBytes());
			//			outM.write("Class Name,".getBytes());
			//			outM.write("Method Name,".getBytes());
			//			outM.write("Method Id,".getBytes());
			//			outM.write("StartLine,".getBytes());
			//			outM.write("EndLine,".getBytes());
			//			outM.write("PD.MM.MD.002,".getBytes());
			//			outM.write("PD.MM.MD.004,".getBytes());
			//			outM.write("PD.MM.MD.006,".getBytes());
			//			outM.write("PD.SM.MD.002,".getBytes());
			//			outM.write("PD.SM.MD.004,".getBytes());
			//			outM.write("PD.MM.MD.001,".getBytes());
			//			outM.write("PD.SM.MD.005,".getBytes());
			//			outM.write("PD.MM.MD.005,".getBytes());
			//			outM.write("PD.SM.MD.001,".getBytes());
			//			outM.write("PD.SM.MD.012,".getBytes());
			//			outM.write("PD.SM.MD.013,".getBytes());
			//			outM.write("PD.SM.MD.014,".getBytes());
			//			outM.write("PD.SM.MD.015,".getBytes());
			//			outM.write("PD.HM.MD.004,".getBytes());
			//			outM.write("PD.HM.MD.001,".getBytes());
			//			outM.write("PD.HM.MD.003,".getBytes());
			//			outM.write("PD.HM.MD.006,".getBytes());
			//			outM.write("PD.HM.MD.008,".getBytes());
			//			outM.write("PD.HM.MD.002,".getBytes());
			//			outM.write("PD.MM.MD.007,".getBytes());
			//			outM.write("Defected?(false/true)\n".getBytes());

			outM.write("File Name,".getBytes());
			outM.write("File Id,".getBytes());
			outM.write("Class Name,".getBytes());
			outM.write("Method Name,".getBytes());
			outM.write("Method Id,".getBytes());
			outM.write("StartLine,".getBytes());
			outM.write("EndLine,".getBytes());
			outM.write("Cyclometric Density,".getBytes());
			outM.write("Decision Density,".getBytes());
			outM.write("Essential Density,".getBytes());
			outM.write("Branch Count,".getBytes());
			outM.write("Condition Count,".getBytes());
			outM.write("Cyclometric Complexity,".getBytes());
			outM.write("Decision Count,".getBytes());
			outM.write("Essential Complexity,".getBytes());
			outM.write("LOC,".getBytes());
			outM.write("Total Operands,".getBytes());
			outM.write("Total Operators,".getBytes());
			outM.write("Unique Operands Count,".getBytes());
			outM.write("Unique Operators Count,".getBytes());
			outM.write("Halstead Difficulty,".getBytes());
			outM.write("Halstead Length,".getBytes());
			outM.write("Halstead Level,".getBytes());
			outM.write("Halstead Programming Effort,".getBytes());
			outM.write("Halstead Programming Time,".getBytes());
			outM.write("Halstead Volume,".getBytes());
			outM.write("Maintenance Severity,".getBytes());
			outM.write("Formal Parameters,".getBytes());
			outM.write("Call Pair Length,".getBytes());
			outM.write("Defected?(false/true)\n".getBytes());

			outM.flush();

			int packageCount = 0;
			int fileCount = 0;
			int classCount = 0;
			int methodCount = 0;

			// package metrics level
			for (Iterator<String> pk = getPackageNames(); pk.hasNext();)
			{
				packageCount++;
				String packageName = pk.next();
				PackageMetrics pm = getPackage(packageName);
				List<String> packageMetricList = getPackageMetrics(pm);

				// first 22 for package metrics
				for (int j = 0; j < packageMetricList.size(); j++)
				{
					if (j + 1 < packageMetricList.size())
					{
						outP.write((packageMetricList.get(j) + ",").getBytes());
					}
					else
					{
						outP.write(packageMetricList.get(j).getBytes());
					}
				}
				outP.write(",false\n".getBytes());
				outP.flush();
				// file metrics level

				for (Iterator<String> fk = pm.getFileNames(); fk.hasNext();)
				{
					fileCount++;
					String fileName = fk.next();
					FileMetrics fm = pm.getFile(fileName);
					List<String> fileMetricList = getFileMetrics(fm);
					for (int k = 0; k < fileMetricList.size(); k++)
					{
						if (k + 1 < fileMetricList.size())
						{
							outF.write((fileMetricList.get(k) + ",").getBytes());
						}
						else
						{
							outF.write(fileMetricList.get(k).getBytes());
						}
					}
					outF.write(",false\n".getBytes());
					outF.flush();
					// class metrics level

					for (Iterator<String> ck = fm.getClassNames(); ck.hasNext();)
					{

						classCount++;
						String className = ck.next();
						ClassMetrics cm = fm.getClass(className);
						if (cm.equals(null))
						{
							continue;
						}
						List<String> classMetricList = getClassMetrics(cm, fm);
						for (int x = 0; x < classMetricList.size(); x++)
						{

							if (x + 1 < classMetricList.size())
							{
								outC.write((classMetricList.get(x) + ",").getBytes());
							}
							else
							{
								outC.write(classMetricList.get(x).getBytes());
							}
						}
						outC.write(",false\n".getBytes());
						outC.flush();

						// Method metrics level

						for (Iterator<String> mk = cm.getMethodNames(); mk.hasNext();)
						{

							String methodName = mk.next();
							MethodMetrics mm = cm.getMethod(methodName);
							if (!mm.getName().equals("implicitConstructor"))
							{

								methodCount++;
								List<String> methodMetricList = getMethodMetrics(mm, fm, cm);

								for (int z = 0; z < methodMetricList.size(); z++)
								{

									if (z + 1 < methodMetricList.size())
									{
										outM.write((methodMetricList.get(z) + ",").getBytes());
									}
									else
									{
										outM.write(methodMetricList.get(z).getBytes());
									}
								}

								outM.write(",false\n".getBytes());
								outM.flush();
							}
						}
					}
				}

			}

			outP.close();
			outF.close();
			outM.close();
			outC.close();

		}
		catch (Exception e)
		{
			outP.close();
			outF.close();
			outM.close();
			outC.close();
			e.printStackTrace();
		}

	}

}
