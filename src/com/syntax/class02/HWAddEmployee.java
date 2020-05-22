package com.syntax.class02;

import org.testng.Assert;
import org.testng.annotations.*;

import com.syntax.pages.AddEmployee;
import com.syntax.pages.LoginPageElements;
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

	@BeforeMethod
	public void openChromeBrowser() {
		setUp();	
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	@Test 
	public void login() {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		waitAndClick(login.loginBtn);

	}

	@Test 
	public void verifyLabels() {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		waitAndClick(login.loginBtn);

		AddEmployee emp = new AddEmployee();
		waitAndClick(emp.pim);
		waitAndClick(emp.addEmp);
		boolean employeeFirstNameIsDisplay = emp.empFirstName.isDisplayed();
		Assert.assertTrue(employeeFirstNameIsDisplay, "Employee's first name is Displayed.");
		boolean employeeLastNameIsDisplay = emp.empLastName.isDisplayed();
		Assert.assertTrue(employeeLastNameIsDisplay, "Employee's last name is Displayed.");
		boolean employeeIdIsDisplay = emp.employeeId.isDisplayed();
		Assert.assertTrue(employeeIdIsDisplay, "Employee'Id is Displayed.");

	}

	@Test
	public void addEmployee() {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		waitAndClick(login.loginBtn);
		
		AddEmployee emp = new AddEmployee();
		waitAndClick(emp.pim);
		waitAndClick(emp.addEmp);
		sendText(emp.empFirstName, ConfigsReader.getProperty("employeeFirstname"));
		sendText(emp.empLastName, ConfigsReader.getProperty("employeeLastname"));
		sendText(emp.addPhoto, ConfigsReader.getProperty("filePath"));
		waitAndClick(emp.saveEmp);
	}

	@Test
	public void verifyEmployeeAdded() {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		waitAndClick(login.loginBtn);
		
		AddEmployee emp2 = new AddEmployee();
		waitAndClick(emp2.pim);
		waitAndClick(emp2.addEmp);

		sendText(emp2.empFirstName, ConfigsReader.getProperty("employeeFirstname"));
		sendText(emp2.empLastName, ConfigsReader.getProperty("employeeLastname"));
		sendText(emp2.addPhoto, ConfigsReader.getProperty("filePath"));
		String expectedEmployeeId = emp2.employeeId.getAttribute("value");
		
		waitAndClick(emp2.saveEmp);
		
		String actualEmployeeId=emp2.personalID.getAttribute("value");
		Assert.assertEquals(actualEmployeeId, expectedEmployeeId, "Employee has Not been added.");

	}

}
