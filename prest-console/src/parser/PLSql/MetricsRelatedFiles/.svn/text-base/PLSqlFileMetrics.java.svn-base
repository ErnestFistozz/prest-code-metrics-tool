package parser.PLSql.MetricsRelatedFiles;

import java.util.Vector;

public class PLSqlFileMetrics {
	public Vector<PLSqlPackageMetrics> packageMetrics;
	public PLSqlCommonMetrics fileContent;
	
	public PLSqlFileMetrics(){
		packageMetrics = new Vector<PLSqlPackageMetrics>();
	}
	
	public PLSqlFileMetrics(PLSqlCommonMetrics commonMetrics,
			Vector<PLSqlPackageMetrics> packageMetrics2) {
		this.fileContent = commonMetrics;
		packageMetrics = new Vector<PLSqlPackageMetrics>(packageMetrics2);
	}

	public void addPackage(PLSqlPackageMetrics newPackage){
		packageMetrics.add(newPackage);
	}
	
	public void writePackageCsv(String packageCsvFileName) throws Exception{
		
	}
}
