package com.selenium_test.imanueleyal.quickstart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverInit {
	
	private final static String CHROMEPATH = "C:/BrowserDrivers/chromedriver.exe";
	private final static String FIREFOXPATH = "C:/BrowserDrivers/geckodriver.exe";
	
	
	public static WebDriver initBrowser(BrowserNames browser) throws Exception {
		
		WebDriver driver = null; 
		
		if(browser.equals(BrowserNames.CHROME))
		{
			initChromeDriver(driver);
			driver = new ChromeDriver();
			
			
		}
		
		else if(browser.equals(BrowserNames.FIREFOX))
		{
			initFireFoxDriver(driver);
			driver = new FirefoxDriver();
			
			
		}
		
		if(driver == null)
		{
			throw new Exception("WebDriver wasn't properly initialize. Only Chrome and FireFox are available");
		}
						
		return driver;
	}

	private static void initFireFoxDriver(WebDriver driver) {
		
		System.setProperty("webdriver.gecko.driver", FIREFOXPATH);
	}

	private static void initChromeDriver(WebDriver driver) {
		
		System.setProperty("webdriver.chrome.driver", CHROMEPATH);
	}

}
