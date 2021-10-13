package parser.PLSql.MetricsRelatedFiles;

import java.util.Vector;

public class PLSqlContainer {
	public Vector<PLSqlFileMetrics> fileMetrics;
	
	public PLSqlContainer(){
		fileMetrics = new Vector<PLSqlFileMetrics>();
	}
	
	public PLSqlContainer(Vector<PLSqlFileMetrics> fileMetrics){
		this.fileMetrics = fileMetrics;
	}
	
	public void addFile(Vector<PLSqlFileMetrics> newFileVector){
		for (int i = 0; i < newFileVector.size(); i++) {
			fileMetrics.add(newFileVector.elementAt(i));
		}
	}
	
}
