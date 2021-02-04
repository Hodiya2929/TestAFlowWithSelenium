package com.selenium_test.imanueleyal.quickstart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GithubMainRepoPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[4]/div/main/div[1]/nav/ul/li[2]/a")
	WebElement issuesTabLink;
	
	public GithubMainRepoPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ossuesTabLinkClick()
	{
		this.issuesTabLink.click();
	}

}
