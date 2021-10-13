package parser.Jsp;

//This class converts script content of jsp files

import au.id.jericho.lib.html.Segment;
import au.id.jericho.lib.html.Source;
import au.id.jericho.lib.html.StartTagType;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import common.monitor.Logger;

import executor.ParserExecutor;

public class JspToJavaConvertor {

	private String script = "";
	private String fileName;

	public JspToJavaConvertor() {
	}

	public String getScript() {
		return this.script;
	}

	public void setScript(String value) {
		this.script = value;
	}

	@SuppressWarnings("unchecked")
	public String GetScriptsFromJSPFile(String jspInputFile) {
		FileInputStream fis = null;// new FileInputStream(JSPfilePathName);
		String className = "";
		try {
			fis = new FileInputStream(jspInputFile);

			className = jspInputFile.substring(
					jspInputFile.lastIndexOf('\\') + 1, jspInputFile
							.lastIndexOf('.'));
			this.script = this.script.concat("public class " + className
					+ " { public " + className + "() {");

			au.id.jericho.lib.html.Source source = new Source(fis);
			List<au.id.jericho.lib.html.Tag> segments;
			segments = source.findAllTags(StartTagType.SERVER_COMMON);

			for (java.util.Iterator<au.id.jericho.lib.html.Tag> i = segments
					.iterator(); i.hasNext();) {
				Segment segment = i.next();
				if (segment.charAt(2) != '@') {
					if (segment.charAt(2) == '=') {
						String temp = segment.toString();
						temp = temp.replaceFirst("=", "x=");
						temp = temp.trim().replace("\\" + "\"", "");
						temp = temp.trim().replace("<b>", "y");
						temp = temp.trim().replace("</b>", "z");
						temp = temp.concat(";".trim());
						this.script = this.script.concat(temp);
						
					} else {
						String temp = segment.toString();
						temp = temp.trim().replace("\\" + "\"", "");
						temp = temp.concat(";".trim());
						this.script = this.script.concat(temp);
					}
				}
			}

			this.script = this.script.replace("<%=", "");
			this.script = this.script.replace("<%", "");
			this.script = this.script.replace("%>", "");
			this.script = this.script.replace("\\" + "\"", "\"");
			this.script = this.script.trim();
			this.script = this.script.concat("} }");
			fis.close();
//			System.out.println(this.script); // print out the script to see
			// the resulting string

		} catch (Exception ex) {
			System.out
					.println("Bunu gorduysen, Java parser JSP kodu icin kullanilirken hata verdi!");
			Logger.error(ParserExecutor.class.getName() + " "
					+ "error in converting jsp to java");
		}
		return this.script;
	}

}

//package parser.Jsp;
//
////This class converts script content of jsp files
//
//import au.id.jericho.lib.html.Segment;
//import au.id.jericho.lib.html.Source;
//import au.id.jericho.lib.html.StartTagType;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.io.BufferedInputStream;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.List;
//
//import common.monitor.Logger;
//
//import executor.ParserExecutor;
//
//public class JspToJavaConvertor {
//
//	private String script = "";
//	private String fileName;
//
//	public JspToJavaConvertor() {
//	}
//
//	public String getScript() {
//		return this.script;
//	}
//
//	public void setScript(String value) {
//		this.script = value;
//	}
//
//	@SuppressWarnings("unchecked")
//	public String GetScriptsFromJSPFile(String jspInputFile) {
//		FileInputStream fis = null;// new FileInputStream(JSPfilePathName);
//		String className = "";
//		try {
//			fis = new FileInputStream(jspInputFile);
//
//			className = jspInputFile.substring(
//					jspInputFile.lastIndexOf(File.separator) + 1, jspInputFile
//							.lastIndexOf('.'));
//			this.script = this.script.concat("public class " + className
//					+ " { public " + className + "() {");
//
//			au.id.jericho.lib.html.Source source = new Source(fis);
//			List<au.id.jericho.lib.html.Tag> segments;
//			segments = source.findAllTags(StartTagType.SERVER_COMMON);
//
//			for (java.util.Iterator<au.id.jericho.lib.html.Tag> i = segments
//					.iterator(); i.hasNext();) {
//				Segment segment = i.next();
//				if (segment.charAt(2) != '@') {
//					if (segment.charAt(2) == '=') {
//						String temp = segment.toString();
//						temp = temp.replaceFirst("=", "x=");
//						temp = temp.trim().replace("\\" + "\"", "");
//						temp = temp.trim().replace("<b>", "y");
//						temp = temp.trim().replace("</b>", "z");
//						temp = temp.concat(";".trim());
//						this.script = this.script.concat(temp);
//						
//					} else {
//						String temp = segment.toString();
//						temp = temp.trim().replace("\\" + "\"", "");
//						temp = temp.concat(";".trim());
//						this.script = this.script.concat(temp);
//					}
//				}
//			}
//
//			this.script = this.script.replace("<%=", "");
//			this.script = this.script.replace("<%", "");
//			this.script = this.script.replace("%>", "");
//			this.script = this.script.replace("\\" + "\"", "\"");
//			this.script = this.script.trim();
//			this.script = this.script.concat("} }");
//			fis.close();
////			System.out.println(this.script); // print out the script to see
//			// the resulting string
//
//		} catch (Exception ex) {
//			System.out
//					.println("Bunu gorduysen, Java parser JSP kodu icin kullanilirken hata verdi!");
//			Logger.error(ParserExecutor.class.getName() + " "
//					+ "error in converting jsp to java");
//		}
//		return this.script;
//	}
//
//}
