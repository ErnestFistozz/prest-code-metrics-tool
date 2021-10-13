package parser.Java.MetricsRelatedFiles;

import java.util.Formatter;
import java.util.Locale;
import java.util.LinkedList;

public class ConvertToString {
	// Note that call-graph related functions&info are kept here
	Matrix callGraph;
	StringBuilder callGraphToExport;
	Formatter f;
	LinkedList<String> funcCallGraphAsString = new LinkedList<String>();

	StringBuilder packageInfo;
	Formatter formatOfPackageInfo;

	StringBuilder fileInfo;
	Formatter formatOfFileInfo;

	StringBuilder classInfo;
	Formatter formatOfClassInfo;

	StringBuilder methodInfo;
	Formatter formatOfMethodInfo;

	// below is the constructor for that class
	public ConvertToString() {
		callGraph = new Matrix();

		callGraphToExport = new StringBuilder();
		f = new Formatter(callGraphToExport, Locale.ROOT);
		f.format("%9s | %9s\n", "Caller", "Callee");
		f.format("%9s | %9s\n", "_________", "_________");

		packageInfo = new StringBuilder();
		formatOfPackageInfo = new Formatter(packageInfo, Locale.US);
		packageInfo.append("name                       string\n"
				+ "Id                         int\n"
				+ "CylomaticDensity           double\n"
				+ "DecisionDensity            double\n"
				+ "EssentialDensity           double\n"
				+ "BranchCount                int\n"
				+ "ConditionCount             int\n"
				+ "CyclomaticComplexity       int\n"
				+ "DecisionCount              int\n"
				+ "EssentialComplexity        int\n"
				+ "Loc                        int\n"
				+ "TotalOperands              int\n"
				+ "TotalOperators             int\n"
				+ "UniqueOperandsNumber       int\n"
				+ "UniqueOperatorsNumber      int\n"
				+ "HalsteadProgramDifficulty  double\n"
				+ "HalsteadProgramLenght      int\n"
				+ "HalsteadProgramLevel       double\n"
				+ "HalsteadProgrammingEffort  double\n"
				+ "HalsteadProgrammingTime    double\n"
				+ "HalsteadProgramVolume      double\n"
				+ "MaintenanceSeverity        double\n");

		fileInfo = new StringBuilder();
		formatOfFileInfo = new Formatter(fileInfo, Locale.US);
		fileInfo.append("name                       string\n"
				+ "Id                         int\n"
				+ "package                    int\n"
				+ "CylomaticDensity           double\n"
				+ "DecisionDensity            double\n"
				+ "EssentialDensity           double\n"
				+ "BranchCount                int\n"
				+ "ConditionCount             int\n"
				+ "CyclomaticComplexity       int\n"
				+ "DecisionCount              int\n"
				+ "EssentialComplexity        int\n"
				+ "Loc                        int\n"
				+ "TotalOperands              int\n"
				+ "TotalOperators             int\n"
				+ "UniqueOperandsNumber       int\n"
				+ "UniqueOperatorsNumber      int\n"
				+ "HalsteadProgramDifficulty  double\n"
				+ "HalsteadProgramLenght      int\n"
				+ "HalsteadProgramLevel       double\n"
				+ "HalsteadProgrammingEffort  double\n"
				+ "HalsteadProgrammingTime    double\n"
				+ "HalsteadProgramVolume      double\n"
				+ "MaintenanceSeverity        double\n");

		classInfo = new StringBuilder();
		formatOfClassInfo = new Formatter(classInfo, Locale.US);
		classInfo.append("name                       string\n"
				+ "Id                         int\n"
				+ "package                    int\n"
				+ "file                       int\n"
				+ "CylomaticDensity           double\n"
				+ "DecisionDensity            double\n"
				+ "EssentialDensity           double\n"
				+ "BranchCount                int\n"
				+ "ConditionCount             int\n"
				+ "CyclomaticComplexity       int\n"
				+ "DecisionCount              int\n"
				+ "EssentialComplexity        int\n"
				+ "Loc                        int\n"
				+ "TotalOperands              int\n"
				+ "TotalOperators             int\n"
				+ "UniqueOperandsNumber       int\n"
				+ "UniqueOperatorsNumber      int\n"
				+ "HalsteadProgramDifficulty  double\n"
				+ "HalsteadProgramLenght      int\n"
				+ "HalsteadProgramLevel       double\n"
				+ "HalsteadProgrammingEffort  double\n"
				+ "HalsteadProgrammingTime    double\n"
				+ "HalsteadProgramVolume      double\n"
				+ "MaintenanceSeverity        double\n"
				+ "CouplingBetweenObjects     int\n"
				+ "FanIn                      int\n"
				+ "NumberOfchildren           int\n"
				+ "PercentageOfPubData        double\n"
				+ "ResponseForClass           int\n"
				+ "WeightedMethods            int\n"

		);

		methodInfo = new StringBuilder();
		formatOfMethodInfo = new Formatter(methodInfo, Locale.US);
		methodInfo.append("name                       string\n"
				+ "Id                         int\n"
				+ "package                    int\n"
				+ "file                       int\n"
				+ "class                      int\n"
				+ "CylomaticDensity           double\n"
				+ "DecisionDensity            double\n"
				+ "EssentialDensity           double\n"
				+ "BranchCount                int\n"
				+ "ConditionCount             int\n"
				+ "CyclomaticComplexity       int\n"
				+ "DecisionCount              int\n"
				+ "EssentialComplexity        int\n"
				+ "Loc                        int\n"
				+ "TotalOperands              int\n"
				+ "TotalOperators             int\n"
				+ "UniqueOperandsNumber       int\n"
				+ "UniqueOperatorsNumber      int\n"
				+ "HalsteadProgramDifficulty  double\n"
				+ "HalsteadProgramLenght      int\n"
				+ "HalsteadProgramLevel       double\n"
				+ "HalsteadProgrammingEffort  double\n"
				+ "HalsteadProgrammingTime    double\n"
				+ "HalsteadProgramVolume      double\n"
				+ "MaintenanceSeverity        double\n"
				+ "FormalParameters           int\n"
				+ "CallPairNumber             int\n");

	}

	public void addPackageInfo(PackageMetrics packageMetricsToAdd) {
		formatOfPackageInfo.format("%21s, %3d, %5.1f, %5.1f, %5.1f, "
				+ "%4d, %4d, %4d, %4d, %3d, " + "%6d, %4d, %4d, %3d, %2d, "
				+ "%6.2f, %4d, %6.3f, %8.3f, %7.3f, " + "%6.3f, %6.2f \n",
				packageMetricsToAdd.getName(),
				packageMetricsToAdd.getId(),
				packageMetricsToAdd.getCylomaticDensity(), // density olcak
				packageMetricsToAdd.getDecisionDensity(),
				packageMetricsToAdd.getEssentialDensity(), // density olcak

				packageMetricsToAdd.getBranchCount(), packageMetricsToAdd
						.getConditionCount(), packageMetricsToAdd
						.getCyclomaticComplexity(), packageMetricsToAdd
						.getDecisionCount(), packageMetricsToAdd
						.getEssentialComplexity(),

				packageMetricsToAdd.getLOC(), packageMetricsToAdd
						.getTotalOperands(), packageMetricsToAdd
						.getTotalOperators(), packageMetricsToAdd
						.getUniqueOperandsCount(), packageMetricsToAdd
						.getUniqueOperatorsCount(),

				packageMetricsToAdd.getHalsteadDifficulty(),
				packageMetricsToAdd.getHalsteadLength(), packageMetricsToAdd
						.getHalsteadLevel(), packageMetricsToAdd
						.getHalsteadProgrammingEffort(), packageMetricsToAdd
						.getHalsteadProgrammingTime(),

				packageMetricsToAdd.getHalsteadVolume(), packageMetricsToAdd
						.getMaintenanceSeverity());
	}

	public void addFileInfo(FileMetrics fileMetricsToAdd, int packageId) {
		formatOfFileInfo
				.format(
						"%21s, %3d, %3d, %5.1f, %5.1f, %5.1f, %4d, %4d, %4d, %4d, %3d, %6d, %4d, %4d, %3d, %2d, %6.2f, %4d, %6.3f, %8.3f, %7.3f, %6.3f, %6.2f \n",
						fileMetricsToAdd.getName(), fileMetricsToAdd.getId(),
						packageId, fileMetricsToAdd.getCylomaticDensity(),
						fileMetricsToAdd.getDecisionDensity(), fileMetricsToAdd
								.getEssentialDensity(),

						fileMetricsToAdd.getBranchCount(), fileMetricsToAdd
								.getConditionCount(), fileMetricsToAdd
								.getCyclomaticComplexity(), fileMetricsToAdd
								.getDecisionCount(), fileMetricsToAdd
								.getEssentialComplexity(), fileMetricsToAdd
								.getLOC(), fileMetricsToAdd.getTotalOperands(),
						fileMetricsToAdd.getTotalOperators(), fileMetricsToAdd
								.getUniqueOperandsCount(), fileMetricsToAdd
								.getUniqueOperatorsCount(), fileMetricsToAdd
								.getHalsteadDifficulty(), fileMetricsToAdd
								.getHalsteadLength(), fileMetricsToAdd
								.getHalsteadLevel(), fileMetricsToAdd
								.getHalsteadProgrammingEffort(),
						fileMetricsToAdd.getHalsteadProgrammingTime(),
						fileMetricsToAdd.getHalsteadVolume(), fileMetricsToAdd
								.getMaintenanceSeverity());
	}

	public void addClassInfo(ClassMetrics classMetricsToAdd, int packageId,
			int fileId) {
		formatOfClassInfo.format("%21s, %3d, %3d, %3d, %5.1f,"
				+ " %5.1f, %5.1f, %4d, %4d, %4d, "
				+ "%4d, %3d, %6d, %4d, %4d, " + "%3d, %2d, %6.2f, %4d, %6.3f, "
				+ "%8.3f, %7.3f, %6.3f, %6.2f, %2d, "
				+ "%2d, %2d, %4.2f, %2d, %2d \n", classMetricsToAdd.name,
				classMetricsToAdd.getId(), packageId, fileId, classMetricsToAdd
						.getCylomaticDensity(),

				classMetricsToAdd.getDecisionDensity(), classMetricsToAdd
						.getEssentialDensity(), classMetricsToAdd
						.getBranchCount(), classMetricsToAdd
						.getConditionCount(), classMetricsToAdd
						.getCyclomaticComplexity(),

				classMetricsToAdd.getDecisionCount(), classMetricsToAdd
						.getEssentialComplexity(), classMetricsToAdd.getLOC(),
				classMetricsToAdd.getTotalOperands(), classMetricsToAdd
						.getTotalOperators(),

				classMetricsToAdd.getUniqueOperandsCount(), classMetricsToAdd
						.getUniqueOperatorsCount(), classMetricsToAdd
						.getHalsteadDifficulty(), classMetricsToAdd
						.getHalsteadLength(), classMetricsToAdd
						.getHalsteadLevel(),

				classMetricsToAdd.getHalsteadProgrammingEffort(),
				classMetricsToAdd.getHalsteadProgrammingTime(),
				classMetricsToAdd.getHalsteadVolume(), classMetricsToAdd
						.getMaintenanceSeverity(), classMetricsToAdd
						.getCouplingBetweenObjects(),

				classMetricsToAdd.getFanIn(), classMetricsToAdd
						.getNumberOfChildren(), classMetricsToAdd
						.getPercentageOfPubData(), classMetricsToAdd
						.getResponseForClass(), classMetricsToAdd
						.getWeightedMethods());
	}

	public void addMethodInfo(MethodMetrics methodMetricsToAdd, int packageId,
			int fileId, int classId, String className, ClassContainer container) {
		int callee = -1;
		String tempString = ""; // keeps the csv formatted function call graph
								// row

		if (methodMetricsToAdd.name.contains("implicitConstructor"))
			return;

		callGraph.addMethod(className + "." + methodMetricsToAdd.name);

		String calls[] = methodMetricsToAdd.getCallPair();

		tempString += className + "." + methodMetricsToAdd.name;
		for (int i = 0; i < calls.length; i++) {
			tempString += "," + calls[i];
			callGraph.addMethod(calls[i]);
			callGraph.setCellValue(className + "." + methodMetricsToAdd.name,
					calls[i], true);

			callee = container.findMethod(calls[i]);
			if (callee != -1)
				f.format("%9d | %9d\n", methodMetricsToAdd.getId(), callee);

		}
		funcCallGraphAsString.addLast(tempString);

		formatOfMethodInfo
				.format(
						"%21s, %3d, %3d, %3d, %3d, %5.1f, %5.1f, %5.1f, %4d, %4d, %4d, %4d, %3d, %6d, %4d, %4d, %3d, %2d, %6.2f, %4d, %6.3f, %8.3f, %7.3f, %6.3f, %6.2f,%2d, %2d \n",
						className + "." + methodMetricsToAdd.name,
						methodMetricsToAdd.getId(), packageId, fileId, classId,

						methodMetricsToAdd.getCylomaticDensity(),
						methodMetricsToAdd.getDecisionDensity(),
						methodMetricsToAdd.getEssentialDensity(),
						methodMetricsToAdd.getBranchCount(), methodMetricsToAdd
								.getConditionCount(),

						methodMetricsToAdd.getCyclomaticComplexity(),
						methodMetricsToAdd.getDecisionCount(),
						methodMetricsToAdd.getEssentialComplexity(),
						methodMetricsToAdd.getLOC(), methodMetricsToAdd
								.getTotalOperands(),

						methodMetricsToAdd.getTotalOperators(),
						methodMetricsToAdd.getUniqueOperandsCount(),
						methodMetricsToAdd.getUniqueOperatorsCount(),
						methodMetricsToAdd.getHalsteadDifficulty(),
						methodMetricsToAdd.getHalsteadLength(),

						methodMetricsToAdd.getHalsteadLevel(),
						methodMetricsToAdd.getHalsteadProgrammingEffort(),
						methodMetricsToAdd.getHalsteadProgrammingTime(),
						methodMetricsToAdd.getHalsteadVolume(),
						methodMetricsToAdd.getMaintenanceSeverity(),

						methodMetricsToAdd.getFormalParameters(),
						methodMetricsToAdd.getCallPair().length);
	}

	public String getCallGraph() {
		return callGraph.toString();
	}

	public String getCallGraphToExport() {
		return callGraphToExport.toString();
	}

	public String getPackageInfo() {
		return packageInfo.toString();
	}

	public String getFileInfo() {
		return fileInfo.toString();
	}

	public String getClassInfo() {
		return classInfo.toString();
	}

	public String getMethodInfo() {
		return methodInfo.toString();
	}

	public LinkedList<String> getFuncCallGraphAsString() {
		return funcCallGraphAsString;
	}
}
