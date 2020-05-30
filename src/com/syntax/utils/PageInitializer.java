package com.syntax.utils;

import com.syntax.pages.AddEmployeePageElements;

import com.syntax.pages.DashBoardPageElements;
import com.syntax.pages.LoginPageElements;
import com.syntax.pages.PersonalDetailsPageElements;

// initializes all pages class and stores references in static variables 
// that will call called/used in test classes

public class PageInitializer extends BaseClass{

	// easily accesible --> make global 
	public static LoginPageElements login;
	public static DashBoardPageElements dashboard;
	public static AddEmployeePageElements addEmp;
	public static PersonalDetailsPageElements pdetails;
	
	public static void initialize () {
		
	    login = new LoginPageElements();
	    dashboard = new DashBoardPageElements ();
	    addEmp = new AddEmployeePageElements ();
	    pdetails = new PersonalDetailsPageElements ();
	    
	    
	    
	}
	
	
	
	
}
