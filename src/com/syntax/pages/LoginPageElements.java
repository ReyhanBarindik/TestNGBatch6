package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

public class LoginPageElements extends CommonMethods {

	@FindBy(id = "txtUsername")
	public WebElement username;

	@FindBy(name = "txtPassword")
	public WebElement password;

	@FindBy(id = "btnLogin")
	public WebElement loginBtn;

	@FindBy(xpath = "//div[@id='divLogo']/img")
	public WebElement logo;

	@FindBy(id = "spanMessage")
	public WebElement errorMsg;

	@FindBy(id = "spanMessage")
	public WebElement errorMessage;

	public LoginPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

	// if we would be keeping elements as private
	// then we will need to create public getters and setters
	// so we can access page elements from test classes

	//setter
	public void sendUsername(String uid) {
		sendText(username, uid);
	}

	//getter
	public WebElement getUsername() {
		return username;
	}

	public void login(String uid, String pwd) {
		sendText(username, uid);
		sendText(password, pwd);
		waitAndClick(loginBtn);

	}

}
