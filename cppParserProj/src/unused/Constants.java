package unused;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Tomi
 */
public class Constants
{
	public static final String specialChars = "/*-+";
	public static final String[] keywordArray = {
			"alignas", // C++11
			"alignof", // C++11
			"and",
			"and_eq",
			"asm",
			"auto",
			"bitand",
			"bitor",
			"bool",
			"break",
			"case",
			"catch",
			"char",
			"char16_t", // C++11
			"char32_t",
			"class",
			"compl",
			"const",
			"constexpr", // C++11
			"const_cast",
			"continue",
			"decltype", // C++11
			"default", "delete", "do", "double", "dynamic_cast", "else",
			"enum", "explicit", "export", "extern", "false", "float", "for",
			"friend", "goto",
			"if",
			"inline",
			"int",
			"long",
			"mutable",
			"namespace",
			"new",
			"noexcept", // C++11
			"not",
			"not_eq",
			"nullptr", // C++11
			"operator", "or", "or_eq", "private", "protected", "public",
			"register", "reinterpret_cast", "return", "short",
			"signed",
			"sizeof",
			"static",
			"static_assert", // C++11
			"static_cast", "struct", "switch",
			"template",
			"this",
			"thread_local", // C++11
			"throw", "true", "try", "typedef", "typeid", "typename", "union",
			"unsigned", "using", "virtual", "void", "volatile", "wchar_t",
			"while", "xor", "xor_eq" };

	public static final String[] twoCharOperators = { "::", "+=", "-=", "*=",
			"/=", "%=", "^=", "&=", "|=",
			// "<<", //These two were left out because operator overloading
			// might cause parsing issues
			// ">>", // eg compare cout<<"hello; and
			// std::vector<std::pair<std::string, int>> values;
			"==", "!=", "<=", ">=", "&&", "||", "++", "--", "->" };

	public static final String[] simpleTypeArray = { "bool", "char",
			"char16_t", "char32_t", "double", "float", "int", "long", "short",
			"signed", "unsigned", "void", "wchar_t"

	};

	public static final String[] threeCharOperator = {};

	public static final List<String> keywords = new ArrayList<String>(
			Arrays.asList(keywordArray));
	public static final List<String> simpleTypes = new ArrayList<String>(
			Arrays.asList(simpleTypeArray));

	public static boolean isTwoCharOperator(String str)
	{
		int l = twoCharOperators.length;
		for (int i = 0; i < l; i++)
		{
			if (twoCharOperators[i].contentEquals(str))
			{
				return true;
			}
		}
		return false;
	}

	public static boolean isKeyword(String str)
	{
		int i = Collections.binarySearch(keywords, str);
		if (i >= 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Can the given character be used in C++ variable name? Returns true for
	 * letters a-z, A-Z, 0-9 and _
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isValidNameChar(char c)
	{
		if ((c >= 'a') && (c <= 'z'))
		{
			return true;
		}
		else if ((c >= 'A') && (c <= 'Z'))
		{
			return true;
		}
		else if ((c >= '0') && (c <= '9'))
		{
			return true;
		}
		else if (c == '_')
		{
			return true;
		}
		return false;
	}

	public static boolean isPrimitiveType(String str)
	{
		int i = Collections.binarySearch(simpleTypes, str);
		if (i >= 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean isSpecialChar(char c)
	{
		if (((c) >= 33) && ((c) <= 47))
		{
			return true;
		}
		else if (((c) >= 58) && ((c) <= 64))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	/**
	 * This method checks if the given token is a word that can be a
	 * name(variable, class...)
	 */
	public static boolean isWordToken(String token)
	{
		if (token.isEmpty())
		{
			return false;
		}
		char c = token.charAt(0);
		if (!Constants.isValidNameChar(c))
		{
			return false;
		}
		else
		{
			if ((c >= '0') && (c <= '9'))
			{
				return false;
			}
		}
		return true;
	}
}
