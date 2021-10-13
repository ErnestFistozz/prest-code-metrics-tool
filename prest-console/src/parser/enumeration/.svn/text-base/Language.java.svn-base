package parser.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum Language {
	
    JAVA ("Java", "Java", new String[]{".java",".jsp"}),
    C ("C", "C", new String[]{".c"}),
    CPP ("Cpp", "C++", new String[]{".cpp"}),
    //JSP ("Jsp", "Jsp", new String[]{".java",".jsp"}),
    PLSQL("PlSql","PL/SQL",new String[]{".pkb"})
    //CSHARP ("CSharp", "C#", ".cs")
    ;

    Language(String langName, String displayName, String[] extensions){
            this.langName = langName;
            this.displayName = displayName;
            this.extensions = extensions;
    }

    private final String langName;
    private final String displayName;
    private final String[] extensions;
    public static final List<Language> LIST = new ArrayList<Language>();

    static {
            LIST.add(JAVA);
            LIST.add(C);
            LIST.add(CPP);
           // LIST.add(JSP);
            LIST.add(PLSQL);
            //LIST.add(CSHARP);
    }

    public String getLangName() {
            return langName;
    }

    public String[] getExtensions() {
            return extensions;
    }
    
    public String getDisplayName() {
        return displayName;
    }

}