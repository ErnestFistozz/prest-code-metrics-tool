package parser.Jsp;

//This class converts script content of jsp files

import au.id.jericho.lib.html.Segment;
import au.id.jericho.lib.html.Source;
import au.id.jericho.lib.html.StartTagType;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;


public class JspToJavaConvertor {

	private String script = "";

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
					jspInputFile.lastIndexOf(File.separator) + 1, jspInputFile
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

		} catch (Exception ex) {
			System.out
					.println("JSP conversion error.");

		}
		return this.script;
	}

}
