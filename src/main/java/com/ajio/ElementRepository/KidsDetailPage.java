package com.ajio.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajio.generalUtililies.WebdriverRepository;

public class KidsDetailPage {
	public KidsDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//select")
	private WebElement priceDropdown;
	
	@FindBy(xpath = "//span[.='brands']")
	private WebElement brandsLink;
	
	@FindBy(xpath = "//span[.='category']")
	private WebElement scrollElement;
	
	@FindBy(xpath = "//label[@class='facet-linkname facet-linkname-brand facet-linkname-3pin']")
	private WebElement brand1Lable;
	
	@FindBy(xpath = "//label[@class='facet-linkname facet-linkname-brand facet-linkname-612 League']")
	private WebElement brand2Lable;
	
	@FindBy(xpath = "//label[@class='facet-linkname facet-linkname-brand facet-linkname-AARIKA GIRLS ETHNIC']")
	private WebElement brand3Lable;
	
	@FindBy(xpath = "//div[.='Pack of 2 Graphic Print Round-Neck T-shirt']/../div[@class='brand']")
	private WebElement product1brand;
	
	@FindBy(xpath = "//div[.='Typographic Printed Crew-Neck T-shirt']/../div[@class='brand']")
	private WebElement product2brand;
	
	@FindBy(xpath = "//div[.='Micro Print Shirt with Waistcoat']/../div[@class='brand']")
	private WebElement product3brand;
	
	@FindBy(xpath = "//div[.='Pack of 2 Graphic Print Round-Neck T-shirt']")
	private WebElement product1name;
	
	@FindBy(xpath = "//div[.='Typographic Printed Crew-Neck T-shirt']")
	private WebElement product2name;
	
	@FindBy(xpath = "//div[.='Micro Print Shirt with Waistcoat']")
	private WebElement product3name;
	
	@FindBy(xpath = "//div[.='Pack of 2 Graphic Print Round-Neck T-shirt']/..//span[@class='price  ']")
	private WebElement product1Price;
	
	@FindBy(xpath = "//div[.='Typographic Printed Crew-Neck T-shirt']/..//span[@class='price  ']")
	private WebElement product2Price;
	
	@FindBy(xpath = "//div[.='Micro Print Shirt with Waistcoat']/..//span[@class='price  ']")
	private WebElement product3Price;
	
	public void applyFilters(WebDriver driver, String partialTitle, String value) throws InterruptedException
	{
		WebdriverRepository.switchToWindows(driver, partialTitle);
		WebdriverRepository.dropdown(priceDropdown, value);
		brandsLink.click();
		WebdriverRepository.scrollToElement(driver, scrollElement);
		Thread.sleep(1000);
		brand1Lable.click();
		Thread.sleep(1000);
		brand2Lable.click();
		Thread.sleep(2000);
		brand3Lable.click();
		String brand1 = product1brand.getText();
		System.out.println(brand1);
		String productname1 = product1name.getText();
		System.out.println(productname1);
		String price1 = product1Price.getText();
		System.out.println(price1);
		String brand2 = product2brand.getText();
		System.out.println(brand2);
		String productname2 =product2name.getText();
		System.out.println(productname2);
		String price2 =product2Price.getText();
		System.out.println(price2);
		String brand3 = product3brand.getText();
		System.out.println(brand3);
		String productname3 = product3name.getText();
		System.out.println(productname3);
		String price3 = product3Price.getText();
		System.out.println(price3);
		product3name.click();
	}
}
