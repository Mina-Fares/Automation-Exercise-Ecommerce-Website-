package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductsPage;

public class ViewBrandProducts extends TestBase {
	HomePage homepage;
	ProductsPage productspage;
	@Test
	public void userCanViewCategoryProducts() {
		homepage=new HomePage(driver);
		productspage=new ProductsPage(driver);
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
		homepage.pressConsent();
		homepage.openProductsPage();
		productspage.scrollTo(productspage.brandstitle);
		Assert.assertTrue(productspage.brandstitle.getText().contains("BRANDS"));
		System.out.println(productspage.brandstitle.getText());
		productspage.chooseFirstBrand();
		Assert.assertTrue(productspage.brand1title.getText().contains("POLO"));
		System.out.println(productspage.brand1title.getText());	
		productspage.scrollTo(productspage.brand2name);
		productspage.chooseSecondBrand();
		Assert.assertTrue(productspage.brand2title.getText().contains("H&M"));
		System.out.println(productspage.brand2title.getText());		
	}
}
