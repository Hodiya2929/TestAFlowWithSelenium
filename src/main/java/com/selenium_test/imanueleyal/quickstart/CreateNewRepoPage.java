package com.selenium_test.imanueleyal.quickstart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewRepoPage {

	WebDriver driver;
	
	
	@FindBy(xpath = "/html/body/div[4]/main/div/form/div[2]/auto-check/dl/dd[1]/input")
	WebElement newRepositoryName;
	
	@FindBy(xpath = "/html/body/div[4]/main/div/form/div[4]/dl/dd/input")
	WebElement newRepositoryDescription;
	
	@FindBy(xpath = "/html/body/div[4]/main/div/form/div[4]/button")
	WebElement createNewRepoButton;
	
	public WebElement getNewRepoInputRef()
	{
		return this.newRepositoryName;
	}
	
	public WebElement getNewRepoButton()
	{
		return this.createNewRepoButton;
	}
	
	public CreateNewRepoPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setNewRepoName(String repoName)
	{
		this.newRepositoryName.sendKeys(repoName);
	}
	
	public void setNewRepoDescription(String repoDescription)
	{
		this.newRepositoryDescription.sendKeys(repoDescription);
	}
	
	public void createNewRepoButtonClick()
	{
		this.createNewRepoButton.click();
	}
	
	public void creatANewRepo(String repoName, String repoDescription)
	{
		this.setNewRepoName(repoName);
		this.setNewRepoDescription(repoDescription);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(createNewRepoButton));	
		this.createNewRepoButtonClick();
	}
	
}
