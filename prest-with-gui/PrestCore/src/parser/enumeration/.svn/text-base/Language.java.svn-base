package parser.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum Language {
	
    JAVA ("Java", "Java", ".java"),
    C ("C", "C", ".c"),
    CPP ("Cpp", "C++", ".cpp"),
    JSP ("Jsp", "Jsp", ".jsp"),
    PLSQL("PlSql","PL/SQL",".pkb")
;

    Language(String langName, String displayName, String extension){
            this.langName = langName;
            this.displayName = displayName;
            this.extension = extension;
    }

    private final String langName;
    private final String displayName;
    private final String extension;
    public static final List<Language> LIST = new ArrayList<Language>();

    static {
            LIST.add(JAVA);
            LIST.add(C);
            LIST.add(CPP);
            LIST.add(JSP);
            LIST.add(PLSQL);
    }

    public String getLangName() {
            return langName;
    }

    public String getExtension() {
            return extension.toLowerCase();
    }
    
    public String getDisplayName() {
        return displayName;
    }

}