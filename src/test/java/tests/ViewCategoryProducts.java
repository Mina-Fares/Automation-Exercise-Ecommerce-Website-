package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductsPage;

public class ViewCategoryProducts extends TestBase {
	HomePage homepage;
	ProductsPage productspage;
	@Test
	public void userCanViewCategoryProducts() {
		homepage=new HomePage(driver);
		productspage=new ProductsPage(driver);
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
		homepage.pressConsent();
		homepage.scrollToProductsSection();
		homepage.chooseCategoryAndSubcategory();
		assertTrue(driver.getCurrentUrl().contains("category_products"));
		System.out.println(driver.getCurrentUrl());
		assertTrue(productspage.categorytitle.getText().contains("WOMEN"));
		assertTrue(productspage.categorytitle.getText().contains("DRESS"));
		System.out.println(productspage.categorytitle.getText());
		homepage.scrollToProductsSection();
		productspage.userChooseCategoryAndSubcategory();
		assertTrue(productspage.category2tilte.getText().contains("MEN"));
		assertTrue(productspage.category2tilte.getText().contains("TSHIRTS"));
		System.out.println(productspage.category2tilte.getText());
	}
}
