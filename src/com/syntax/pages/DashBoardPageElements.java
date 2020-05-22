package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class DashBoardPageElements {

	@FindBy(id = "welcome")

	public WebElement welcome;

	@FindBy(xpath = "//div[@id='branding']/a[1]/img")

	public WebElement logo;

	public DashBoardPageElements() {

		PageFactory.initElements(BaseClass.driver, this);

	}

}
