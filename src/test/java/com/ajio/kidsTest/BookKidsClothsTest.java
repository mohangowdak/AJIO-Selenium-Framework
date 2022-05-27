package com.ajio.kidsTest;

import org.testng.annotations.Test;

import com.ajio.ElementRepository.HomePage;
import com.ajio.ElementRepository.KidsDetailPage;
import com.ajio.ElementRepository.KidsPage;
import com.ajio.ElementRepository.ProductDetailPage;
import com.ajio.generalUtililies.BaseClass;

public class BookKidsClothsTest extends BaseClass
{
	@Test
	public  void bookKidsClothsTest() throws InterruptedException 
	{
		HomePage hp=new HomePage(driver);
		KidsPage kp=new KidsPage(driver);
		KidsDetailPage kdp=new KidsDetailPage(driver);
		ProductDetailPage pdp=new ProductDetailPage(driver);
		hp.clickOnKids();
		kp.clickOnSection(driver);
		kdp.applyFilters(driver, "Starting At Rs 199", "prce-desc");
		pdp.addToCartAndRemove(driver, "White & Maroon Shirts for Boys");
	}
}
