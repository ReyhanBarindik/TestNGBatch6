package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

public class DashBoardPageElements extends CommonMethods {

	@FindBy(id = "welcome")
	public WebElement welcome;

	@FindBy(xpath = "//div[@id='branding']/a[1]/img")
	public WebElement logo;

	
	@FindBy(id="menu_pim_viewPimModule")
	public WebElement pim;

	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmp;

	
	public DashBoardPageElements() {

		PageFactory.initElements(BaseClass.driver, this);

	}
	
	public void navigateToAddEmp () {
		jsClick(pim);
		jsClick(addEmp);
	}

}
