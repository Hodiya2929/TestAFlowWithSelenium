package com.selenium_test.imanueleyal.quickstart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GithubUserPageNoRepos {

	WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[4]/div/aside/div[2]/div[1]/div/div/a[1]")
	WebElement createRepoButton;
	
	public WebElement getCreateNewRepoButton()
	{
		return this.createRepoButton;
	}
	
	public GithubUserPageNoRepos(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void creatRepoButtonClick()
	{
		createRepoButton.click();
	}
}
