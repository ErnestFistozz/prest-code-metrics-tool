/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import parser.enumeration.Language;

/**
 *
 * @author Gürhan
 */
public class ExcelSheet {
    
    public static final int C_CSV_FILE = 0;
    public static final int JAVA_CSV_FILE = 1;
    
    private String sheetName;
    private List<String> functionNames;
    private List<String> functionIds;
    private List<String> calleeIds;

    public ExcelSheet(File csvfile, int type) {
        
        if(type == C_CSV_FILE) {
            int count = 0;
            try {
                //use buffering, reading one line at a time
                //FileReader always assumes default encoding is OK!
                BufferedReader input = new BufferedReader(new FileReader(csvfile));
                sheetName = Language.C.getDisplayName() + " Call Graph";
                functionNames = new ArrayList<String>();
                functionIds = new ArrayList<String>();
                calleeIds = new ArrayList<String>();
                try {
                    String line = null; //not declared within while loop
                    
                    while ((line = input.readLine()) != null) {
                        if(count >= 1){
                            line = line.trim();
                            int firstIndex = line.indexOf(",");
                            functionNames.add(line.substring(0, firstIndex));
                            functionIds.add(Integer.toString(count));
                            String strCalleeIds = line.substring(firstIndex + 1);
                            String resultingCalleeList = null;
                            int index = 0;
                            StringTokenizer st = new StringTokenizer(strCalleeIds, ",");
                            
                            while(st.hasMoreTokens()) {
                                String token = st.nextToken();
                                if(!token.equals(0)){
                                    if(resultingCalleeList != null){
                                        resultingCalleeList += ",";
                                    }
                                    resultingCalleeList += String.valueOf(index);
                                }
                                index++;
                            }
                            calleeIds.add(resultingCalleeList);
                        }
                        count++;
                    }
                } finally {
                    input.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if(type == JAVA_CSV_FILE) {
            int count = 0;
            try {
                //use buffering, reading one line at a time
                //FileReader always assumes default encoding is OK!
                BufferedReader input = new BufferedReader(new FileReader(csvfile));
                
                sheetName = Language.JAVA.getDisplayName() + " Call Graph";
                functionNames = new ArrayList<String>();
                functionIds = new ArrayList<String>();
                calleeIds = new ArrayList<String>();
                
                try {
                    String line = null; //not declared within while loop
                    
                    while ((line = input.readLine()) != null) {
                        if(count >= 3){
                            line = line.trim();
                            String result[] = line.split(",",3);	// divide the line into 3 pieces
                            String functionName = result[0];		// first piece is the name of the function
                            String functionId = result[1];			// second piece will be the name of the function
                            String calleeIdsStr = result[2];		// third piece will be the callee ids
                            	
                            functionNames.add(functionName);		// add the function name to the list
                            functionIds.add(functionId);			// add the function id to the list
                            calleeIds.add(calleeIdsStr);			// add the function's callees to the list
                        }
                        count++;
                    }
                } finally {
                    input.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }

    public ExcelSheet(String sheetName, List<String> functionNames, List<String> functionIds, List<String> calleeIds) {
        this.sheetName = sheetName;
        this.functionNames = functionNames;
        this.functionIds = functionIds;
        this.calleeIds = calleeIds;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }
    
    public List<String> getCalleeIds() {
        return calleeIds;
    }

    public void setCalleeIds(List<String> calleeIds) {
        this.calleeIds = calleeIds;
    }

    public List<String> getFunctionNames() {
        return functionNames;
    }

    public void setFunctionNames(List<String> functionNames) {
        this.functionNames = functionNames;
    }
    
    public void setFunctionIds(List<String> functionIds) {
        this.functionIds = functionIds;
    }
    
    public List<String> getFunctionIds() {
        return this.functionIds;
    }
    
    

}
