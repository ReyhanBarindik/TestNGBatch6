package com.syntax.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static Workbook wBook;
	private static Sheet sheet;
	
	public static void openExcel (String filePath, String sheetName) {
		
		try {
			FileInputStream fis = new FileInputStream(filePath);
			try {
				wBook=new XSSFWorkbook(fis);
				sheet=wBook.getSheet(sheetName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	
	public static int colCount () {
		return sheet.getRow(0).getLastCellNum();
	}
	
	public static String getCellData (int rowIndex, int cellIndex) {
		return sheet.getRow(rowIndex).getCell(cellIndex).toString();
	}
	public static Object[][] excelIntoArray (String filePath, String sheetName) {   // bunu call yapacagiz 
		openExcel (filePath, sheetName);
		
		Object [][] data= new Object [rowCount()-1][colCount()]; //rowCount()-1 cunku header'i istemiyoruz username in oldugu yere username yazmiyoruz tabiki
		
		for (int i=1; i<rowCount(); i++) {
			for (int y=0; y<colCount(); y++) {
				data[i-1][y]= getCellData(i,y); // data olusturuyoruz array yazarken array in satiri bos kalmamasi lazim 
			}
		}
		return data;
	}
	
	
	
	
}
