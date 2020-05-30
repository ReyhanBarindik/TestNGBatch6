package com.syntax.class02;

import org.testng.Assert;
import org.testng.annotations.*;

import com.syntax.pages.AddEmployeePageElements;


import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class HWAddEmployee extends CommonMethods {

	/*
	 * Open chrome browser Go to
	 * "http://166.62.36.207/humanresources/symfony/web/index.php/ auth/login" Login
	 * into the application 4.Click on Add Employee 5.Verify labels: Full Name,
	 * Employee Id, Photograph are displayed 6. Provide Employee First and Last Name
	 * 7. Add a picture to the profile 8. Verify Employee has been added
	 * successfully 9. Close the browser
	 */

	/*@BeforeMethod
	public void openChromeBrowser() {
		setUp();	
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
*/
	
	@Test (priority = 1)
	public void login() {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
        
	}

	@Test (priority = 2)
	public void verifyLabels() {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmp();
		
		AddEmployeePageElements emp1 = new AddEmployeePageElements();
		boolean employeeFirstNameIsDisplay = emp1.empFirstName.isDisplayed();
		Assert.assertTrue(employeeFirstNameIsDisplay, "Employee's first name is Displayed.");
		boolean employeeLastNameIsDisplay = emp1.empLastName.isDisplayed();
		Assert.assertTrue(employeeLastNameIsDisplay, "Employee's last name is Displayed.");
		boolean employeeIdIsDisplay = emp1.employeeId.isDisplayed();
		Assert.assertTrue(employeeIdIsDisplay, "Employee'Id is Displayed.");

	}

	@Test(priority = 3)
	public void addEmployee() {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmp();
		
		AddEmployeePageElements emp1 = new AddEmployeePageElements();
		sendText(emp1.empFirstName, ConfigsReader.getProperty("employeeFirstname"));
		sendText(emp1.empLastName, ConfigsReader.getProperty("employeeLastname"));
		sendText(emp1.addPhoto, ConfigsReader.getProperty("filePath"));
		waitAndClick(emp1.saveEmp);
	}

	@Test(priority = 4)
	public void verifyEmployeeAdded() {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmp();
		
		AddEmployeePageElements emp2 = new AddEmployeePageElements();
		sendText(emp2.empFirstName, ConfigsReader.getProperty("employeeFirstname"));
		sendText(emp2.empLastName, ConfigsReader.getProperty("employeeLastname"));
		sendText(emp2.addPhoto, ConfigsReader.getProperty("filePath"));
		String expectedEmployeeId = emp2.employeeId.getAttribute("value");
		
		waitAndClick(emp2.saveEmp);
		
		String actualEmployeeId=emp2.personalID.getAttribute("value");
		Assert.assertEquals(actualEmployeeId, expectedEmployeeId, "Employee has Not been added.");

	}

}
