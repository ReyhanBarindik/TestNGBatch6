package com.syntax.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class TitleLogoAndLoginValidation extends CommonMethods {

	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}

	@Test
	public void titleValidation() throws Exception {
       String expectedTitle= "Human Management System";
       String actalTitle= driver.getTitle();
       if (expectedTitle.equals(actalTitle)) {
    	   System.out.println("Test Passed!");
       }else {
    	   System.out.println("Test Failed!");
    	   throw new Exception();
       }
       wait(2);
	}

	@Test
	public void logoValidation() throws Exception {
		String logoPath= "//div[@id='divLogo']/img";
        WebElement logo= driver.findElement(By.xpath(logoPath));
        boolean isDisplay = logo.isDisplayed();
        if (isDisplay) {
        	System.out.println("Test Case Passed!");
        }else {
        	System.out.println("Test Case Failed!");
        	throw new Exception();
        }
        wait(2);
	}

	@Test
	public void validLogin() {
    WebElement username = driver.findElement(By.id("txtUsername"));
    sendText(username, ConfigsReader.getProperty("username"));
    
    WebElement password= driver.findElement(By.id("txtPassword"));
    sendText(password, ConfigsReader.getProperty("password"));
    
    waitAndClick(driver.findElement(By.id("btnLogin")));
    wait(2);
	} 

	@AfterMethod
	public void quitBrowser () {
		tearDown();
	}
	
}
