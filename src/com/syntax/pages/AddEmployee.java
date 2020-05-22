package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class AddEmployee {

	@FindBy(id="menu_pim_viewPimModule")
	public WebElement pim;

	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmp;

	@FindBy(id = "firstName")
	public WebElement empFirstName;

	@FindBy(id = "lastName")
	public WebElement empLastName;

	@FindBy(id = "employeeId")
	public WebElement employeeId;

	@FindBy(id="photofile")
	public WebElement addPhoto;
	
	@FindBy(id = "btnSave")
	public WebElement saveEmp;
	
	@FindBy(id="personal_txtEmployeeId")
	public WebElement personalID;
	
	@FindBy (xpath="//div[@id='sidebar']/div/h1")
	public WebElement addedEmployee;

	public AddEmployee() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
