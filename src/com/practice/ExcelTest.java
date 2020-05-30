package com.practice;


import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;

public class ExcelTest  {
    
	public static void main (String [] args) {
	
	Object[][] data=ExcelUtility.excelIntoArray(Constants.TEST_DATA_FILEPATH, "Sheet1");
	
	for (Object [] row : data) {
		for (Object cell: row) {
			System.out.print(cell+"  ");
		}
		System.out.println();
	}
	
}
}
