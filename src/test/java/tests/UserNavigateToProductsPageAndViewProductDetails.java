package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

public class UserNavigateToProductsPageAndViewProductDetails extends TestBase {
	HomePage homepage;
	ProductsPage productspage;
	ProductDetailsPage productpage;
	@Test
	public void UserCanNavigateToProductsPageAndViewProductDetails() {
		homepage=new HomePage(driver);
		productspage=new ProductsPage(driver);
		productpage=new ProductDetailsPage(driver);
		homepage.pressConsent();
		homepage.openProductsPage();
		Assert.assertTrue(driver.getCurrentUrl().contains("products"));
		System.out.println(driver.getCurrentUrl());
		assertTrue(productspage.productstitle.isDisplayed());
		System.out.println(productspage.productstitle.getText());
		productspage.viewProduct();
		assertTrue(productpage.productname.isDisplayed());
		System.out.println(productpage.productname.getText());
		assertTrue(productpage.category.isDisplayed());
		System.out.println(productpage.category.getText());
		assertTrue(productpage.price.isDisplayed());
		System.out.println(productpage.price.getText());
		assertTrue(productpage.availability.isDisplayed());
		System.out.println(productpage.availability.getText());
		assertTrue(productpage.condition.isDisplayed());
		System.out.println(productpage.condition.getText());
		assertTrue(productpage.brand.isDisplayed());
		System.out.println(productpage.brandname.getText());
	}
	

}
