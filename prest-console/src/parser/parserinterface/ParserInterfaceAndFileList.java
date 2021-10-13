package parser.parserinterface;

import java.io.File;
import java.util.List;

public class ParserInterfaceAndFileList {
    private IParser parser;
    private List<File> fileList;

    public IParser getParser() {
            return parser;
    }

    public void setParser(IParser parser) {
            this.parser = parser;
    }

    public List<File> getFileList() {
            return fileList;
    }

    public void setFileList(List<File> fileList) {
            this.fileList = fileList;
    }
}
