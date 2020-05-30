package com.syntax.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntax.pages.AddEmployeePageElements;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class HW_1 extends CommonMethods{

	/*
	 * Automate user stories below: 
	 * US 12678 As an Admin I should be able to create
	 * login credentials while adding employee
	 * 
	 * US 67789 As an admin while adding employee if I leave required fields empty I
	 * should see “Required” message Note: first name and last name are required
	 * fields
	 * 
	 */

	@Test (priority = 1 , groups = "smoke")
	public void createLoginCredentials() {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmp();
		addEmp.addEmployeeInHMR(ConfigsReader.getProperty("empFirstName"), ConfigsReader.getProperty("empMiddleName"), ConfigsReader.getProperty("empLastName"));
		addEmp.createLoginDetails(ConfigsReader.getProperty("empUserName"), ConfigsReader.getProperty("ePassword"),ConfigsReader.getProperty("confirmPassword"));
		
	}
	
	@Test (priority =2)
	public void requirements () {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmp();
		addEmp.addEmployeeInHMR(ConfigsReader.getProperty("employeeFirstname"), ConfigsReader.getProperty("employeeMiddlename"), ConfigsReader.getProperty("employeeLastname"));
		jsClick(addEmp.saveEmp);
	    
	    String expectedMessageForFirstname="Required";
	    String actualMessageForFirstname= addEmp.requiredFirstName.getText();
	    
	    Assert.assertEquals(actualMessageForFirstname, expectedMessageForFirstname, "Error Messages text doesn't match");
	    
	    String expectedMessageForLastname="Required";
	    String actualMessageForLastname= addEmp.requiredLastName.getText();
	    
	    Assert.assertEquals(actualMessageForLastname, expectedMessageForLastname, "Error Messages text doesn't match");
	    
	    
	    
	}
	
	
	
	
	
	
	
	
}
