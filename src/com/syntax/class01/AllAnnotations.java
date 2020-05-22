package com.syntax.class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnnotations {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I am Before Suite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("I am Before Test");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("I am Before Class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I am before Method");
	}

	@Test (priority =2)
	public void testMethod1() {
		System.out.println("I am Test 1");
	}

	@Test (priority =1)
	public void testMethod2() {
		System.out.println("I am Test 2");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("I am after Method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("I am after Class");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("I am after Test");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("I am After Suite");
	}

}
