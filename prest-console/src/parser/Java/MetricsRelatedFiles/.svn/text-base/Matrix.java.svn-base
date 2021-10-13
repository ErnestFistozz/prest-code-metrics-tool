package parser.Java.MetricsRelatedFiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Matrix {
	CellArray cols = null;
	CellArray rows = null;
	int cellSize = 0;

	public void addMethod(String name) {
		if (cols == null && rows == null) {
			rows = new CellArray(name);
			cols = new CellArray(name);

			rows.head = new Cell();
			cols.head = rows.head;

			rows.head.col = cols;
			cols.head.row = rows;
		} else {
			addRow(name);
			addCol(name);
		}
	}

	@Override
	public String toString() {

		cellSize = getCellSize();
		String outPut = "";
		int identity = 0; // will be used to identify the functions that in
		// function call graph

		try {
			String func_call_graph = "C:\\callGraphWithIds.csv";
			FileWriter func_call_graph_fstream = new FileWriter(func_call_graph);
			BufferedWriter func_call_graph_writer = new BufferedWriter(
					func_call_graph_fstream);

			CellArray colIter = cols;
			for (; colIter != null; colIter = colIter.next) {
				++identity;
				outPut += colIter.name + ": " + identity + ", ";
			}

			// now we have the names and id's of the functions in call graph
			// first we write the header line that includes the names and id's
			func_call_graph_writer.write(outPut);
			func_call_graph_writer.newLine();

			CellArray rowIter = rows;
			for (; rowIter != null; rowIter = rowIter.next) {

				// after writing the header initialize the outPut string for new
				// entries
				// also initialize the identity, so that while incrementing it
				// again,
				// the id's will correspond to the right functions
				outPut = "";
				identity = 0;

				Cell cell = rowIter.head;
				outPut += rowIter.name + ": ";
				for (; cell != null; cell = cell.right) {
					++identity;
					// if they are connected, write the identity of the
					// connected function
					// else do not write anything
					outPut += (cell.isConnected) ? (identity + ", ") : ("");
				}
				// now we have the names and id's of the functions that were
				// called
				// we write the function name and those functions' ids that were
				// called
				func_call_graph_writer.write(outPut);
				func_call_graph_writer.newLine();
			}
			func_call_graph_writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// return the last value of output so as to indicate successful
		// complettion
		return outPut;
	}

	private int getCellSize() {
		int size = 0;
		CellArray rowIter = rows;
		for (; rowIter != null; rowIter = rowIter.next) {
			if (size < rowIter.name.length())
				size = rowIter.name.length();
		}
		return size;
	}

	public boolean setCellValue(String row, String col, boolean value) {
		CellArray rowIter = rows;
		for (; rowIter != null; rowIter = rowIter.next) {
			if (rowIter.name.compareTo(row) != 0)
				continue;
			else {
				Cell up = rowIter.head;
				for (; up != null; up = up.right) {
					if (up.col.name.compareTo(col) == 0) {
						up.isConnected = value;
						return true;
					}
				}
			}
		}

		return false;
	}

	private void addCol(String name) {
		CellArray colIter = cols;
		for (; colIter.next != null; colIter = colIter.next) {
			if (colIter.name.compareTo(name) == 0)
				return;
		}

		if (colIter.name.compareTo(name) == 0)
			return;

		colIter.next = new CellArray(name);
		colIter.next.head = new Cell();

		colIter.next.head.col = colIter.next;
		colIter.next.head.row = colIter.head.row;
		colIter.head.right = colIter.next.head;

		Cell left = colIter.head;
		Cell right = colIter.next.head;
		for (; left.below != null; left = left.below, right = right.below) {
			right.below = new Cell();
			right.below.row = left.below.row;
			right.below.col = right.col;

			left.below.right = right.below;
		}
	}

	private void addRow(String name) {
		CellArray rowIter = rows;
		for (; rowIter.next != null; rowIter = rowIter.next) {
			if (rowIter.name.compareTo(name) == 0)
				return;
		}

		if (rowIter.name.compareTo(name) == 0)
			return;

		rowIter.next = new CellArray(name);
		rowIter.next.head = new Cell();

		rowIter.next.head.row = rowIter.next;
		rowIter.next.head.col = rowIter.head.col;
		rowIter.head.below = rowIter.next.head;

		Cell up = rowIter.head;
		Cell down = rowIter.next.head;
		for (; up.right != null; up = up.right, down = down.right) {
			down.right = new Cell();
			down.right.col = up.right.col;
			down.right.row = down.row;
			up.right.below = down.right;
		}
	}
}
