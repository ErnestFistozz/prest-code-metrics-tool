package parser.PLSql.MetricsRelatedFiles;

import java.util.Vector;

public class PLSqlPackageMetrics {
	public Vector<PLSqlMethodMetrics> methodMetrics;
	public PLSqlCommonMetrics packageContent;
	
	public PLSqlPackageMetrics(){
		methodMetrics = new Vector<PLSqlMethodMetrics>();
		packageContent = new PLSqlCommonMetrics();
	}
	
	public PLSqlPackageMetrics(PLSqlCommonMetrics commonMetrics,
			Vector<PLSqlMethodMetrics> methodMetrics2) {
		this.packageContent = commonMetrics;
		methodMetrics = new Vector<PLSqlMethodMetrics>(methodMetrics2);
	}

	public void addMethod(PLSqlMethodMetrics newMethod){
		methodMetrics.add(newMethod);
	}
}
