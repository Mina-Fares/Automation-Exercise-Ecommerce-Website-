package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

public class VerifyProductQuantityInCart extends TestBase {
	HomePage homepage;
	ProductsPage productspage;
	CartPage cartpage;
	ProductDetailsPage productpage;
	Faker faker=new Faker();
	String randomquantity=faker.number().digit();
	@Test
	public void userCanVerifyProductQuantityInCart() {
		homepage=new HomePage(driver);
		productspage=new ProductsPage(driver);
		cartpage=new CartPage(driver);
		productpage=new ProductDetailsPage(driver);
		homepage.pressConsent();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.automationexercise.com/"));
		homepage.openProductsPage();
		Assert.assertTrue(driver.getCurrentUrl().contains("products"));
		System.out.println(driver.getCurrentUrl());
		productspage.viewProduct();
		productpage.modifyProductQuantity(randomquantity);
		productpage.addToCart();
		productpage.viewCart();
		assertTrue(driver.getCurrentUrl().contains("cart"));
		assertEquals(cartpage.quantitytxt.getText(),randomquantity);
		System.out.println(cartpage.quantitytxt.getText());
	}
}
