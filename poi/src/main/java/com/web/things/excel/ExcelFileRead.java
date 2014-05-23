package com.web.things.excel;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * <pre>
 * 类描述
 * </pre>
 * 
 * @author songjz
 * @time 2014年5月23日
 */
public class ExcelFileRead {

	public void read() {
		String filePath = ExcelFileRead.class.getResource("aa.xls").getPath();
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(filePath);
			POIFSFileSystem fs = new POIFSFileSystem(inputStream);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			// 设备 sheet页
			HSSFSheet sheet = wb.getSheetAt(0);
			// sheet页的名称
			System.out.println(sheet.getSheetName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ExcelFileRead().read();
	}

}
