package com.selenium_test.imanueleyal.quickstart;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

public class LoginAndCreateFirstRepoTest {
	
	WebDriver driver;
	WebDriverWait wait;
	
	CreateNewRepoPage githubNewRepoPage;
	GithubLogin githubLoginPage;
	GithubMainRepoPage githubMainRepoPage;
	GithubRepoIssuesPage githubRepoIssuesPage;
	GithubRepoNewIssuePage githubRepoNewIssuePage;
	GithubStartPage githubStartPage;
	GithubUserPageNoRepos githubUserPageNoRepo;
	GithubIssuesTab githubIssuesTab;
	
	 
	@BeforeTest	
	public void setup()
	{
		try {
			//For Mozilla choose BrowserNames.FIREFOX. For Chrome choose BrowserNames.CHROME
			driver = WebDriverInit.initBrowser(BrowserNames.CHROME);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver,30); 
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	
	@Test(priority=0)	
	public void goToGithubWebSite()
	{
		  driver.get("https://github.com/join");
		  driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void clickOnSignInButton()
	{
		
		githubStartPage = new GithubStartPage(driver);
		
		wait.until(ExpectedConditions.elementToBeClickable(githubStartPage.getSignInLinkWebElement()));
		
		githubStartPage.signInLinkClick();
	}
	
	@Test (priority = 2)
	public void loginToGithub() throws ParserConfigurationException, IOException, SAXException
	{
		
		githubLoginPage = new GithubLogin(driver);
		
		wait.until(ExpectedConditions.elementToBeClickable(githubLoginPage.getSignInSubmit()));		
		IdenticationDetails identificationDoc = new IdenticationDetails();
		identificationDoc.parseXmlUserData();
		
		String userName = identificationDoc.getUserName();
		String password = identificationDoc.getPassword();
		
		githubLoginPage.loginWithNameAndPass(userName, password);		
	}
	
	@Test(priority = 3)
	public void goToCreatePage()
	{
		
		githubUserPageNoRepo = new GithubUserPageNoRepos(driver);
		
		Duration fourMinutes = Duration.ofMinutes(4);
		Duration threeSeconds = Duration.ofSeconds(4);
		
		   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(fourMinutes)
			       .pollingEvery(threeSeconds)
			       .ignoring(NoSuchElementException.class);

		   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       return githubUserPageNoRepo.getCreateNewRepoButton();
			     }
			   });
		   
		   githubUserPageNoRepo.creatRepoButtonClick();
	}
	
	@Test(priority = 4)
	public void createNewProject()
	{
		githubNewRepoPage = new CreateNewRepoPage(driver) ;
		
		wait.until(ExpectedConditions.visibilityOf(githubNewRepoPage.getNewRepoInputRef()));
		
		
		githubNewRepoPage.creatANewRepo("AweSome Github website automation", "This TC automate the steps: login to Github website, create a new repository and set a new issue ");
	}
	
	@Test(priority = 5)
	public void clickOnIssuesTab()
	{
		githubIssuesTab = new GithubIssuesTab(driver);
		wait.until(ExpectedConditions.elementToBeClickable(githubIssuesTab.issuesTabGetter()));
		
		githubIssuesTab.issuesTabClick();
	}
	
	@Test(priority = 6)
	public void clickOnNewIssueButton()
	{
		 githubRepoIssuesPage = new GithubRepoIssuesPage(driver);
		 wait.until(ExpectedConditions.elementToBeClickable(githubRepoIssuesPage.newIssueGetter()));
		 
		 githubRepoIssuesPage.newIssueButtonClick();
	}
	
	@Test(priority = 7)
	public void setAnNewIssue()
	{
		 githubRepoNewIssuePage = new GithubRepoNewIssuePage(driver);
		 wait.until(ExpectedConditions.visibilityOf( githubRepoNewIssuePage.issueTitleGetter()));
		 
		 githubRepoNewIssuePage.createANewIssueInRepo("Need Add A TC To Delete Repositories", "There is a TC to create the first repository - neww to have a TC to delete it");
		 
	}
	@Test(priority = 8)
	public void closeTheBrowser()
	{
		driver.close();
	}

}
