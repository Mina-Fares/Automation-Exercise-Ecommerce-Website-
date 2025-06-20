package tests;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

public class UserSearchForProduct extends TestBase {
	HomePage homepage;
	ProductsPage productspage;
	ProductDetailsPage productpage;
	Faker faker=new Faker();
	Random random=new Random();
	String[] clothes= {"Shirt", "T-Shirt", "Dress", "Jeans", "Jacket", "Skirt", "Blouse"};
	String randomtype=clothes[faker.random().nextInt(7)];
	
	@Test
	public void UserCanNavigateToProductsPageAndSearchForProduct() {
		homepage=new HomePage(driver);
		productspage=new ProductsPage(driver);
		productpage=new ProductDetailsPage(driver);
		homepage.pressConsent();
		homepage.openProductsPage();
		Assert.assertTrue(driver.getCurrentUrl().contains("products"));
		System.out.println(driver.getCurrentUrl());
		assertTrue(productspage.productstitle.isDisplayed());
		System.out.println(productspage.productstitle.getText());
		productspage.userCanSearchforproduct(randomtype);
		Assert.assertEquals(productspage.searchmessage.getText(),"SEARCHED PRODUCTS");
		System.out.println(productspage.searchmessage.getText());
	}
	

}
