package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class deneme extends CommonMethods {

	
	@Test
	public void validLogin () {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}
	
	@Test
	public void invalidLogin () {
		Assert.assertTrue(false);
	}
	
	
	
}
