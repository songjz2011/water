package com.nfschina.fourjoy.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;

/**
 * Created with IntelliJ IDEA.
 * User: Aaron
 * Date: 13-10-24
 * Time: 下午12:19
 * To change this template use File | Settings | File Templates.
 */
public class POIUtil {
    public static String getCellValue(HSSFRow row, int no) {
        HSSFCell cell =  row.getCell(no);
        if(cell==null){
            return "";
        }
        String result ="";
        try{
            result = row.getCell(no).getStringCellValue();
        }catch(IllegalStateException e){
            row.getCell(no).setCellType(Cell.CELL_TYPE_STRING);
            result = row.getCell(no).getStringCellValue();
        }
        return result;
    }
    
    public static void setCellValue(HSSFRow row, int no, String value) {
        HSSFCell cell =  row.getCell(no);
        if(cell!=null){
        	row.getCell(no).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(no).setCellValue(value);
        }
    }
}
