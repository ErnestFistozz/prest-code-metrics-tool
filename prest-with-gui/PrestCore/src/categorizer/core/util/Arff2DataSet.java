package categorizer.core.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Pattern;

import categorizer.core.DataField;
import categorizer.core.DataHeader;
import categorizer.core.DataItem;
import categorizer.core.DataSet;
import categorizer.core.UnsupportedDataContextException;

import common.DataContext;

/**
 * Class to read data from files given in arff format, and create the
 * corresponding DataSet object
 * 
 * @author secil.karagulle
 * @author ovunc.bozcan
 */

public class Arff2DataSet {

	private File f;

	private FileInputStream inS;

	private BufferedReader br;

	private DataSet dataSet;

	private DataContext dataContext;

	private DataHeader[] dataHeaders;

	Vector dataHeaderNodes;

	private DataItem[] dataItems;

	Vector dataItemNodes;

	public Arff2DataSet(String fileDirectory) throws FileNotFoundException {

		f = new File(fileDirectory);

		if (!(f.exists()))
			throw new FileNotFoundException();

		else {
			inS = new FileInputStream(f);
			br = new BufferedReader(new InputStreamReader(inS));
		}
	}

	private boolean containsOnlyNumbers(String str) {

		// It can't contain only numbers if it's null or empty...
		if (str == null || str.length() == 0)
			return false;

		for (int i = 0; i < str.length(); i++) {

			// If we find a non-digit character we return false.
			if (!(Character.isDigit(str.charAt(i)) || str.charAt(i) == '.'))
				return false;
		}

		return true;
	}

	/**
	 * @param line
	 * @return true if the given line is either a commented or a n empty line
	 */
	private boolean isNegligible(String line) {

		if (line.startsWith("%") || line.equals(""))
			return true;
		else
			return false;
	}

	/**
	 * @throws IOException
	 * @throws UnsupportedDataContextException
	 *             reads DataHeaders which appear as attributes inbetween
	 *             "@relation" and "@data" lines in the arff file
	 */
	public void readDataHeaders() throws IOException,
			UnsupportedDataContextException {

		String line;
		dataHeaderNodes = new Vector();
		StringTokenizer st;
		Pattern pt;

		while (((line = br.readLine()) != null)
				&& !(line.startsWith("@DATA") || line.startsWith("@data"))) {

			if (!isNegligible(line)
					&& !line.startsWith("@attribute 'Package Name'")
					&& !line.startsWith("@attribute 'File Name'")
					&& !line.startsWith("@attribute 'Method Name'")
					&& !line.startsWith("@attribute 'Class Name'")) {
				DataHeader dataHeader = new DataHeader();

				if (line.contains("{")) // then the data header is a nominal one
					dataHeader.setNominal(true);

				else
					dataHeader.setNominal(false);

				// st = new StringTokenizer(line, " ");
				pt = Pattern.compile("[,\\s]+");
				String[] splittedLine = pt.split(line);

				// if( (st.nextToken().contains("@")) ); // @attribute is read,
				// do nothing
				if (splittedLine[0].contains("@"))
					;

				// dataHeader.setLabel(st.nextToken()); // set the label of the
				// DataHeader to the second token
				dataHeader.setLabel(splittedLine[1]);

				if (dataHeader.isNominal()) {

					Vector<String> availableValueVector = new Vector<String>();

					// while(st.hasMoreTokens()){
					for (int i = 2; i < splittedLine.length; i++) {
						// String value = st.nextToken();
						String value = splittedLine[i];
						if (value.startsWith("{"))
							value = value.substring(1);
						if (value.endsWith(",") || value.endsWith("}"))
							value = value.substring(0, value.length() - 1);
						// value.replace("{", "");
						// value.replace(",", "");
						// value.replace("}", "");
						availableValueVector.add(value);
					}

					String[] availableValueArray = new String[availableValueVector
							.size()];

					for (int i = 0; i < availableValueArray.length; i++) {
						availableValueArray[i] = availableValueVector.get(i);
					}
					dataHeader.setAvailableValue(availableValueArray);
				}

				dataHeaderNodes.add(dataHeader);
			}
		}

		dataHeaders = new DataHeader[dataHeaderNodes.size()];

		for (int i = 0; i < dataHeaderNodes.size(); i++) {
			// DataHeader dataHeader = new DataHeader();

			// dataHeader.load((DataContext)dataHeaderNodes.get(i));

			// dataHeaders[i] = dataHeader;
			dataHeaders[i] = (DataHeader) dataHeaderNodes.get(i);
		}
	}

	/**
	 * @throws IOException
	 *             reads DataItems which appear after the "@data" line in arff
	 *             file. Each DataItem is equal to a line of strings seperated
	 *             by commas, and each DataField is each of these strings
	 * 
	 */
	public void readDataItems() throws IOException {

		String line;
		Vector dataItemNodes = new Vector();
		StringTokenizer st;
		Pattern pt;

		while ((line = br.readLine()) != null) {

			if (!isNegligible(line)) {

				DataItem dataItem = new DataItem();
				DataField[] dataFields = new DataField[dataHeaderNodes.size()];

				pt = Pattern.compile("[,\\s]+");
				String[] splittedLine = pt.split(line);
				int colCount = 0;
				for (int i = 0; i < splittedLine.length; i++) {
					if (containsOnlyNumbers(splittedLine[i])
							|| splittedLine[i].startsWith("false")) {
						DataField dataField = new DataField();
						dataField.setDataHeader(dataHeaders[colCount]);
						dataField.load(splittedLine[i]);
						dataFields[colCount] = dataField;
						colCount++;
					}
				}

				dataItem.setDataFields(dataFields);
				dataItem.setDataHeaders(dataHeaders);
				dataItemNodes.add(dataItem);
			}
		}

		dataItems = new DataItem[dataItemNodes.size()];

		for (int i = 0; i < dataItemNodes.size(); i++) {
			// DataItem dataItem = new DataItem();
			// dataItem.load((DataContext)dataItemNodes.get(i));
			// dataItems[i] = dataItem;
			dataItems[i] = (DataItem) dataItemNodes.get(i);
		}
	}

	public DataSet reader() throws IOException, UnsupportedDataContextException {

		String line;
		String token;

		if (br.equals(null)) // if the file is empty
			throw new IOException();

		else
			// else, create the corresponding DataSet
			dataSet = new DataSet();

		while ((line = br.readLine()) != null) {

			if (!(isNegligible(line))) {

				if (line.startsWith("@RELATION")
						|| line.startsWith("@relation")) {

					readDataHeaders();
					dataSet.setDataHeaders(dataHeaders); // put these
					// DataHeaders in
					// the DataSet
				}

				readDataItems();
				dataSet.setDataItems(dataItems);
			}
		}
		return dataSet;
	}

	/**
	 * RegEx içeren bir String split örneği
	 * 
	 * @param args
	 * @throws Exception
	 */
	// public static void main(String[] args) throws Exception {
	// // Create a pattern to match breaks
	// Pattern p = Pattern.compile("[,\\s]+");
	// // Split input with the pattern
	// String[] result =
	// p.split("one,two, three four , five , ");
	// for (int i=0; i<result.length; i++)
	// System.out.println(i + " : " + result[i]);
	// }
}
