package com.ajio.generalUtililies;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * This repository is used to perform common web driver functions
 * @author USER
 *
 */
public class WebdriverRepository 
{
	/**
	 * This method is used to launch the application
	 * @param driver
	 * @param url
	 */
	public static void launchApplication(WebDriver driver, String url)
	{
		driver.get(url);
	}
	/**
	 * This method is used to achive syncronization implicit wait
	 * @param driver
	 * @param time
	 */
	public static void implicitWait(WebDriver driver, long time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public static void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to scroll the browser to particular element
	 * @param driver
	 * @param element
	 */
	public static void scrollToElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",element);
	}
	/**
	 * This method is used to handle the dropdown
	 * @param element
	 * @param value
	 */
	public static void dropdown(WebElement element, String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	/**
	 * This method is used to switch to one window to other
	 * @param driver
	 * @param title
	 */
	public static void switchToWindows(WebDriver driver, String title)
	{
		Set<String> adress = driver.getWindowHandles();
		for(String address:adress)
		{
			driver.switchTo().window(address);
			if(driver.getTitle().contains(title))
			{
				break;
			}
		}
	}
	/**
	 * This method is used to close the browser
	 * @param driver
	 */
	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}
	public static String takeAScreenshot(WebDriver driver, String filename)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String datetime=JavaRepository.getDate();
		File dst=new File("./Screenshort/"+filename+datetime+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dst.getAbsolutePath();
	}
}
