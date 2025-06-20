package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;

public class AddToCartFromRecommendedItems extends TestBase {
	HomePage homepage;
	CartPage cartpage;
	@Test
	public void userCanAddToCartFromRecommendedItems() {
		homepage=new HomePage(driver);
		cartpage=new CartPage(driver);
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
		homepage.pressConsent();
		homepage.addToCartFromRecommendedItems();
		assertTrue(driver.getCurrentUrl().contains("cart"));
		cartpage.verifyProducts();
	}
}
