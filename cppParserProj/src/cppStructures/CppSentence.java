package cppStructures;

import java.util.ArrayList;

/**
 * Represents a "sentence" in the source code. A sentence can be a variable
 * declaration, operation etc., anything that happens inside a function or in a
 * header.
 * 
 * @author Harri
 * 
 */
public class CppSentence
{
	// The raw list of tokens that make up this sentence
	public String[] tokens;

	// Preprocessor directives that make this sentence conditional
	public ArrayList<String> ppConditions = new ArrayList<String>();
}
