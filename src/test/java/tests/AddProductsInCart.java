package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class AddProductsInCart extends TestBase {
	HomePage homepage;
	ProductsPage productspage;
	CartPage cartpage;
	@Test
	public void userCanAddProductsToCart() {
		homepage=new HomePage(driver);
		productspage=new ProductsPage(driver);
		cartpage=new CartPage(driver);
		homepage.pressConsent();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.automationexercise.com/"));
		homepage.openProductsPage();
		Assert.assertTrue(driver.getCurrentUrl().contains("products"));
		System.out.println(driver.getCurrentUrl());
		productspage.userAddProductsToCart();
		assertTrue(driver.getCurrentUrl().contains("cart"));
		cartpage.verifyProducts();
	}
}
