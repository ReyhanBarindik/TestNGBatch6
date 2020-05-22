package com.syntax.class03;

import org.testng.Assert;
import org.testng.annotations.*;

import com.syntax.pages.AddEmployee;
import com.syntax.pages.LoginPageElements;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class DataProviderTask extends CommonMethods {

	@BeforeMethod
	public void openChromeBrowser() {
		setUp();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	@Test
	public void addMultipleEmployee() {
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

		String expectedEmployeeId = emp.employeeId.getAttribute("value");
		waitAndClick(emp.saveEmp);

		String actualEmployeeId = emp.personalID.getAttribute("value");
		Assert.assertEquals(actualEmployeeId, expectedEmployeeId);

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = { { "Yunus", "Yakut" }, { "Gulsum", "Inci" }, { "Selma", "Karapicak" } };
        
		wait(2);
		return data;
	}

}
