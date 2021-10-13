/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common;

import common.monitor.Logger;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;


/**
 *
 * @author Gürhan
 */
public class ExcelOutput {

    
    public static void generateCallGraphExcelWithIds (String fileName, List<ExcelSheet> sheetList) {
        
        try {
            HSSFWorkbook wb = new HSSFWorkbook();
            for(ExcelSheet excelSheet : sheetList){
            
                int rowNum = 2;
                HSSFSheet sheet = wb.createSheet(excelSheet.getSheetName());

                HSSFRow columnHeaderRow = sheet.createRow(rowNum);
                
                // identify the column headers
                createColumnHeaderCell("CALLER_NAME",wb, columnHeaderRow, (short) 2, HSSFCellStyle.ALIGN_CENTER);
                createColumnHeaderCell("CALLER_ID",wb, columnHeaderRow, (short) 3, HSSFCellStyle.ALIGN_CENTER);
                createColumnHeaderCell("CALLEE_ID",wb, columnHeaderRow, (short) 4, HSSFCellStyle.ALIGN_CENTER);
                
                rowNum++;
                
                int maxColNum = 0;
                for(int i = 0 ; i < excelSheet.getFunctionNames().size() ; i++) {
                    List<String> calleeIdList = new ArrayList<String>(); 
                    String currentIdList = excelSheet.getCalleeIds().get(i);
                    StringTokenizer st = new StringTokenizer(currentIdList,",");
                    while (st.hasMoreTokens()) {
                        calleeIdList.add(st.nextToken());
                    }

                    HSSFRow row = sheet.createRow(rowNum);
                    
                    createRegularCell(excelSheet.getFunctionNames().get(i),wb, row, 
                            (short) 2, HSSFCellStyle.ALIGN_CENTER);
                    
                    createRegularCell(excelSheet.getFunctionIds().get(i),wb, row, 
                            (short) 3, HSSFCellStyle.ALIGN_RIGHT);
                    

                    int j = 0;
                    for(j = 0 ; j < calleeIdList.size() ; j++){
                        createRegularCell(calleeIdList.get(j),wb, row,
                                (short)(4 + j), HSSFCellStyle.ALIGN_RIGHT);
                    }
                    if((4+j)> maxColNum){
                        maxColNum = 4 + j;
                    }
                    rowNum++;
                }

                for(int i = 0 ; i < maxColNum ; i++){
                    sheet.autoSizeColumn((short)i);
                }
            }

            // Write the output to a file
            FileOutputStream fileOut = new FileOutputStream(fileName);
            wb.write(fileOut);
            fileOut.close();
            
           // JOptionPane.showMessageDialog(null, "Function Call Graph generated successfully!", "Call Graph Generation!", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Function Call Graph could not be generated successfully!", "Call Graph Generation!", JOptionPane.WARNING_MESSAGE);
        	
            Logger.error(ExcelOutput.class.getName() + " error at generating call graph excel file " +
                    e.getMessage());
        }
    }
    
    

    /**
     * Creates a cell and aligns it a certain way.
     *
     * @param wb        the workbook
     * @param row       the row to create the cell in
     * @param column    the column number to create the cell in
     * @param align     the alignment for the cell.
     */
    private static void createRegularCell(String cellValue, 
            HSSFWorkbook wb, HSSFRow row, short column, short align)
    {
        HSSFCell cell = row.createCell(column);
        cell.setCellValue(cellValue);
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setAlignment(align);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cell.setCellStyle(cellStyle);
    }
    
        /**
     * Creates a cell and aligns it a certain way.
     *
     * @param wb        the workbook
     * @param row       the row to create the cell in
     * @param column    the column number to create the cell in
     * @param align     the alignment for the cell.
     */
    private static void createSpeciesCell(String cellValue, HSSFWorkbook wb, HSSFRow row, short column, short align)
    {
        HSSFCell cell = row.createCell(column);
        cell.setCellValue(cellValue);
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(HSSFColor.LAVENDER.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setAlignment(align);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cell.setCellStyle(cellStyle);
    }
    
            /**
     * Creates a cell and aligns it a certain way.
     *
     * @param wb        the workbook
     * @param row       the row to create the cell in
     * @param column    the column number to create the cell in
     * @param align     the alignment for the cell.
     */
    private static void createColumnHeaderCell(String cellValue, HSSFWorkbook wb, HSSFRow row, short column, short align)
    {
        HSSFCell cell = row.createCell(column);
        cell.setCellValue(cellValue);
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(HSSFColor.LAVENDER.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setAlignment(align);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THICK);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THICK);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THICK);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THICK);
        cell.setCellStyle(cellStyle);
    }


}
