package com.selenium_test.imanueleyal.quickstart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GithubRepoNewIssuePage {
		
	WebDriver driver;
	                 
	@FindBy(xpath = "//*[@id=\"issue_title\"]")
	WebElement newIssueTitle;

	@FindBy(xpath = "//*[@id=\"issue_body\"]")
	WebElement newIssueComment;
	
	@FindBy(xpath = "//*[@class=\"btn btn-primary\"]")
	WebElement newIssueSubmitButton;
	
	
	public GithubRepoNewIssuePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); //initialize all elements in page
	}
	
	public WebElement issueTitleGetter()
	{
		return this.newIssueTitle;
	}
	
	public void setNewIssueTitle(String issueTitle)
	{
		this.newIssueTitle.sendKeys(issueTitle);
	}
	
	public void setNewIssueComment(String issueComment)
	{
		this.newIssueComment.sendKeys(issueComment);
	}
	
	public void newIssueButtonClick()
	{
		this.newIssueSubmitButton.click();
	}
	
	public void createANewIssueInRepo(String issueTitle, String issueComment)
	{
		
		this.setNewIssueTitle(issueTitle);
		this.setNewIssueComment(issueComment);
		
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(newIssueSubmitButton));
		this.newIssueButtonClick();
	}
}
