package com.ajio.generalUtililies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver staticdriver;
	public WebDriver driver;
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeclass(String browser,String url) 
	{
		String timeout = FileRepository.featchProperties("timeout");
		long longtimeout=Long.parseLong(timeout);
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--disable-notifications");
			driver=new ChromeDriver(opt);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions(); 
			firefoxOptions.addPreference("dom.webnotifications.enabled",false);
			driver=new FirefoxDriver(firefoxOptions);
			break;
		}
		staticdriver=driver;
		WebdriverRepository.launchApplication(driver, url);
		WebdriverRepository.maximizeBrowser(driver);
		WebdriverRepository.implicitWait(driver, longtimeout);
		
	}
	@BeforeSuite
	public void basicMethod()
	{
		FileRepository.openPropertyFile(Iconstantpath.PROPERTYPATH);
		
	}
	
	@AfterClass
	public void closeApllication()
	{
		WebdriverRepository.closeBrowser(driver);
	}

	
}
