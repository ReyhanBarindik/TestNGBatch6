package com.syntax.class03;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class DataProviderRecap extends CommonMethods {

	
	
	@Test(dataProvider = "getData", groups ="regression")
	
	public void addEmployee(String firstName, String middleName, String lastName, String userName, String password,
			String rePassword) {
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmp();
		addEmp.addEmployeeInHMR(firstName, middleName, lastName);
		addEmp.createLoginDetails(userName, password, rePassword);
		String actEmpFullName = driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		String expEmpFullName = firstName + " " + middleName + " " + lastName;
		
		Assert.assertEquals(actEmpFullName, expEmpFullName, "Name Mismatch");
		
		
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = { { "Selma", "Ka", "Karapicak", "SelmaHanim", "SelmaKaA@#4598","SelmaKaA@#4598"}, 
				{ "Senel", "Du", "Duman","SenelHanim","SenelDUMAN@#90","SenelDUMAN@#90" }, 
				{ "Turker", "Do", "Dogruer","TurkerBey","turkerDOG@#78","turkerDOG@#78" },
				{ "Yunus", "Ya", "Yakut","YunusBey","yunusYAKUT@#56","yunusYAKUT@#56" }, 
				{ "Gulsum", "In", "Ince","GulsumHanim","GulsumINCE23#@","GulsumINCE23#@"}

		};

		return data;

	}

}
