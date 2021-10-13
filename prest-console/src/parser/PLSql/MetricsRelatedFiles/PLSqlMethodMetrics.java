package parser.PLSql.MetricsRelatedFiles;

public class PLSqlMethodMetrics {
	public PLSqlCommonMetrics methodContent;
	
	public PLSqlMethodMetrics(){
		methodContent = new PLSqlCommonMetrics();
	}
	public PLSqlMethodMetrics(PLSqlCommonMetrics methodContent){
		this.methodContent = methodContent;
	}
}
