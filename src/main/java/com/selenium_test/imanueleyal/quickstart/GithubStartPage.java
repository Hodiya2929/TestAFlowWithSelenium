package com.selenium_test.imanueleyal.quickstart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GithubStartPage {
	

	WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[1]/header/div/div[2]/div[2]/a[1]")
	WebElement signInLink;
	
	public WebElement getSignInLinkWebElement()
	{
		return this.signInLink;
	}
	
	public GithubStartPage(WebDriver driver)
	
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void signInLinkClick()
	{
		signInLink.click();
	}
	

}
