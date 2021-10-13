/**
 * 
 */
package parser.Java.MetricsRelatedFiles;

import java.util.HashMap;

/**
 * @author Ekrem
 * 
 */
public class Symbols {
	HashMap<String, String> symbols = new HashMap<String, String>();

	public void addSymbol(String id, String type) {
		if (type.contains(".")) {
			type = type.substring(type.lastIndexOf(".") + 1);
		}

		symbols.put(id, type);
	}

	public String getSymbol(String id) {
		return symbols.get(id);
	}
}
