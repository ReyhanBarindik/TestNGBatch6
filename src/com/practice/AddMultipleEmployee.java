package com.practice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;
import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;

public class AddMultipleEmployee extends CommonMethods {

	@Test (dataProvider = "getData")
	public void addMultipleEmployee(String empFirstN, String empMiddleN, String empLastN, String empUserName, String ePassword, String rePassword) {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmp();
        addEmp.addEmployeeInHMR(empFirstN, empMiddleN, empLastN);
        addEmp.createLoginDetails(empUserName, ePassword, rePassword);
        
        
        String actFirstName = addEmp.empFirstName.getAttribute("value");
        Assert.assertEquals(actFirstName, empFirstN, "Name Mismatched");
        takeScreenshot("Screenshots","Hrm2",empFirstN,empLastN);
	}
	
	@DataProvider
	public Object [][] getData (){
		return ExcelUtility.excelIntoArray(Constants.TEST_DATA_FILEPATH, "Sheet1");
	}
	
	
	
	
	
	
	
}
