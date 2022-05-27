package com.ajio.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajio.generalUtililies.WebdriverRepository;

public class ProductDetailPage {
	public ProductDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='  prod-content']//div[@class='size-variant-block']//div[@class='slick-initialized slick-slider size-swatch-slick oval']//div[@class='slick-list']//div[@class='slick-slide slick-active size-swatch']//div[@class='oval size-variant-item size-instock ']//span[.='4-5Y']")
	private WebElement sizeBox;
	
	@FindBy(xpath = "//div[@class='btn-gold']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "//div[@class='popup-blk cart-blk']//div[@class='ic-cart ']")
	private WebElement cartBtn;
	
	@FindBy(xpath = "//div[@class='delete-btn']")
	private WebElement deletBtn;
	
	@FindBy(xpath = "//div[@class='card-delete-button']//div[@class='delete-btn']")
	private WebElement deletConfirmBtn;
	
	public void addToCartAndRemove(WebDriver driver, String partialTitle) throws InterruptedException
	{
		WebdriverRepository.switchToWindows(driver, partialTitle);
        sizeBox.click();
		Thread.sleep(1000);
    	addToCartBtn.click();
    	Thread.sleep(5000);
    	cartBtn.click();
		deletBtn.click();
		deletConfirmBtn.click();
	}
}
