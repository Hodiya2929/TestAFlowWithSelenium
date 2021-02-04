package com.selenium_test.imanueleyal.quickstart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GithubLogin {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"login_field\"]")
	WebElement userNameInput;

	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement passwordInput;
	
	@FindBy(xpath = "//*[@class=\"btn btn-primary btn-block\"]")
	WebElement signInSubmit;
	
	public WebElement getSignInSubmit() {
		return this.signInSubmit;
	}
	
	public GithubLogin(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); //initialize all elements in page
	}
	
	public void setNameInUserNameInput(String userName)
	{
		this.userNameInput.sendKeys(userName);
	}
	
	public void setPassInPassInput(String password)
	{
		this.passwordInput.sendKeys(password);
	}
	
	public void clickLogin()
	{
		this.signInSubmit.click();
	}
	
	public void loginWithNameAndPass(String userName, String password)
	{
		this.setNameInUserNameInput(userName);
		this.setPassInPassInput(password);
		this.clickLogin();
	}
	
}
