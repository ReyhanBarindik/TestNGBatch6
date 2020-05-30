package com.syntax.class03;

import org.testng.Assert;
import org.testng.annotations.*;

import com.syntax.pages.AddEmployeePageElements;
import com.syntax.pages.DashBoardPageElements;
import com.syntax.pages.LoginPageElements;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class DataProviderTask extends CommonMethods {


	@Test (dataProvider= "getData1", groups="regression")
	public void addMultipleEmployee(String employeeFirstname , String employeeLastname) {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		waitAndClick(login.loginBtn);

		DashBoardPageElements emp = new DashBoardPageElements();
		waitAndClick(emp.pim);
		waitAndClick(emp.addEmp);
		AddEmployeePageElements emp1 = new AddEmployeePageElements ();
		sendText(emp1.empFirstName, employeeFirstname);
		sendText(emp1.empLastName,employeeLastname );
		

		String expectedEmployeeId = emp1.employeeId.getAttribute("value");
		waitAndClick(emp1.saveEmp);

		String actualEmployeeId = emp1.personalID.getAttribute("value");
		Assert.assertEquals(actualEmployeeId, expectedEmployeeId);

	}

	@DataProvider 
	public Object[][] getData1() {

		Object[][] data = { { "Yunus", "Yakut" }, { "Gulsum", "Inci" }, { "Selma", "Karapicak" } };
        
		wait(2);
		return data;
	}

}
