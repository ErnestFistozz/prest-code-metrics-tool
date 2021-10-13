package common;


import java.io.*;
import org.w3c.dom.*;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.InputSource;

public class test {

    /**
     * @param args
     */
    public static void main(String[] args) {
	
	try {

	    DocumentBuilderFactory bagOfWordsFac = DocumentBuilderFactory.newInstance();
	    DocumentBuilder bagOfWordsBuilder = bagOfWordsFac.newDocumentBuilder();
	    //to be made parametric
	    
	    FileInputStream fileInputStream = new FileInputStream(new File("test") );
	    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
	    InputSource inputSource = new InputSource(inputStreamReader);
	    
			Document bagOfWords = bagOfWordsBuilder.parse(inputSource);

	    System.out.println(bagOfWords.getChildNodes().item(0).getChildNodes().item(1).getChildNodes().item(3).getTextContent());
		
	}catch(Exception e) {
		e.printStackTrace();
	}

    }

}
