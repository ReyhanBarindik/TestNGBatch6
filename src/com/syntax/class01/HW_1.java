package com.syntax.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.syntax.pages.LoginPageElements;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class HW_1 extends CommonMethods {
// Validate that Welcome Admin is displayed

	@BeforeMethod
	public void login() {
		setUp();
	}

	@Test
	public void welcomeAdminDisplay() {

		/*WebElement username = driver.findElement(By.id("txtUsername"));
		sendText(username, ConfigsReader.getProperty("username"));

		WebElement password = driver.findElement(By.id("txtPassword"));
		sendText(password, ConfigsReader.getProperty("password"));

		WebElement login = driver.findElement(By.id("btnLogin"));
		waitAndClick(login);
        */
		LoginPageElements login= new LoginPageElements ();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		waitAndClick(login.loginBtn);
		
		WebElement welcomeAdmin = driver.findElement(By.id("welcome"));
		String text = welcomeAdmin.getText();
		boolean isDisplay = welcomeAdmin.isDisplayed();
		if (isDisplay) {
			System.out.println("Test Case passed. " + text + " is displayed.");
		} else {
			System.err.println("Test Case failed. " + text + " is Not displayed.");
		}

	}
       @AfterMethod
       public void closeBrowser () {
    	   //tearDown();
       }
}
