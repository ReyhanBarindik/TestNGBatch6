package com.syntax.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	    System.out.println("Test started."+result.getName());
	  }

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed."+result.getName());
		CommonMethods.takeScreenshot("Passed/"+result.getName());
	 }
	
	@Override
	 public void onTestFailure(ITestResult result) {
		System.out.println("Test failed."+result.getName());  
		CommonMethods.takeScreenshot("Failed/"+result.getName());
	 }
	
	
	
	
	
	
	
}
