package parser.Java.MetricsRelatedFiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SparseMatrix {

	private int lastIndex = 0;

	// bu listelerdeki elemanlar farklý farklý objeler degil.
	// ayný objeye point eden pointerlar.
	// bu yuzden fazla yer kaplamýyor.
	private List<NameAndIdTreeNode> nameList = new ArrayList<NameAndIdTreeNode>();
	// id'den name'e en hýzlý arrayde ulasýlýr (1 zamanda)

	private NameAndIdTreeNode nameAndIdTreeRoot = null;
	// name'den id'ye treeden (logN zamanda)

	private HashMap<Integer, HashSet<Integer>> matchList = new HashMap<Integer, HashSet<Integer>>();

	// call listesi name listesine göre cok daha kucuk. hashmap daha avantajlý
	// (N/15 zamanda) (hatta bazen 1 zamanda)

	public void addItem(String name, int myId) {
		NameAndIdTreeNode newNode = new NameAndIdTreeNode();
		newNode.id = myId;
		newNode.name = name;
		boolean added = false;
		if (nameAndIdTreeRoot == null) {
			nameAndIdTreeRoot = newNode;
			added = true;
		} else {
			added = NameAndIdTreeNode.put(nameAndIdTreeRoot, newNode);
		}
		if (added) {
			nameList.add(newNode);
			// 0 1 2 3 sýrayla eklemeli
			//lastIndex++;
		}
	}

	public void addMatch(String caller, String callee) {
		int callerId = getIdOf(caller);
		int calleeId = getIdOf(callee);

		HashSet<Integer> call = matchList.get(callerId);
		if (call != null) {
			call.add(calleeId);
		} else {
			HashSet<Integer> cleeLst = new HashSet<Integer>();
			cleeLst.add(calleeId);
			matchList.put(callerId, cleeLst);
		}
	}

	private int getIdOf(String name) {
		return NameAndIdTreeNode.getIdOf(nameAndIdTreeRoot, name);
	}

	public void writeToFile(String fileName, ClassContainer conta) throws Exception { 
		// class container is imported so as to get the id's of functions
		// those id's are required while finding the callees of a caller function in function call graph
		
		String func_call_graph = fileName;
		FileWriter func_call_graph_fstream = new FileWriter(func_call_graph);
		BufferedWriter func_call_graph_writer = new BufferedWriter(
				func_call_graph_fstream);

		for (int i = 0; i < nameList.size(); i++) {
			func_call_graph_writer.write(nameList.get(i).name + ":"
					+ nameList.get(i).id + ", ");
		}
		func_call_graph_writer.newLine();
		func_call_graph_writer.newLine();
		func_call_graph_writer
				.write("CALLER_NAME,CALLER_ID,CALLEE_ID");
		func_call_graph_writer.newLine();

		for (int i = 0; i < nameList.size(); i++) {
			
			String callerMethodName = nameList.get(i).name;					// get caller methods name
			int callerMethodId = conta.findMethod(callerMethodName);		// get caller methods id
			
			func_call_graph_writer.write(callerMethodName + ",");   		// then print out the caller's name
			func_call_graph_writer.write(callerMethodId + ",");				// and caller's id
			
			HashSet<Integer> calleeSet = getCalleeSetOf(callerMethodId);	// get callee id's into a list
			
			if (calleeSet != null) {
				Iterator<Integer> iterator = calleeSet.iterator();			// get callee id's into an interator

				while (iterator.hasNext()) {
					func_call_graph_writer.write(iterator.next() + ",");	// write each callee id with commas in between
				}
			}
			
			func_call_graph_writer.newLine();								// once caller and its callee id's are written
																			// print a new line and continue the cycle
		}

		func_call_graph_writer.close();										// when all the caller-callee pairs are written
																			// close the csv file
	}

	private HashSet<Integer> getCalleeSetOf(int callerId) {
		return matchList.get(callerId);

	}

}
