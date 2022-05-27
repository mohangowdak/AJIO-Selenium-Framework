package com.ajio.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ajio.generalUtililies.WebdriverRepository;

public class KidsPage {
	public KidsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@href='/s/15-16-years-4075-99651']")
	private WebElement scrollElement;
	
	@FindBy(xpath = "//a[@href='/s/starting-at-rs-199-4691-77081']")
	private WebElement selectImg;
	
	public void clickOnSection(WebDriver driver)
	{
		WebdriverRepository.scrollToElement(driver, scrollElement);
		selectImg.click();
	}
}
