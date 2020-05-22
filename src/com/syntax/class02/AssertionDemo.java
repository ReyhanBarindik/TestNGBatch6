package com.syntax.class02;

import org.testng.Assert;
import org.testng.annotations.*;

import com.syntax.utils.CommonMethods;

public class AssertionDemo extends CommonMethods {

	
	@BeforeMethod
	public void openBrowserAndNavigete () {
		setUp();
	}
	@AfterMethod
	public void closeDriver () {
		tearDown();
	}
	
	@Test
	public void titleValidation () {
		String expectedTitle = "Human Management System";
		String actualTitle= driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title does not match");
	}
	
	
	
	
	
}
