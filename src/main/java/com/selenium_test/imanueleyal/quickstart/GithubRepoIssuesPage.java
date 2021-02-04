package com.selenium_test.imanueleyal.quickstart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GithubRepoIssuesPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[4]/div/main/div[2]/div/div/div[2]/div[2]/a")
	WebElement newIssueLinkButton;
	
	
	public GithubRepoIssuesPage(WebDriver driver) {
		
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}
	
	public WebElement newIssueGetter()
	{
		return this.newIssueLinkButton;
	}
	
	public void newIssueButtonClick()
	{
		this.newIssueLinkButton.click();		
	}


}
