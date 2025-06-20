package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

public class AddReviewOnProduct extends TestBase {
	HomePage homepage;
	ProductsPage productspage;
	ProductDetailsPage productpage;
	Faker faker=new Faker();
	String name=faker.name().username();
	String mail=faker.internet().emailAddress();
	String message=faker.lorem().paragraph(4);
	@Test
	public void userCanAddReviewOnProduct() {
		homepage=new HomePage(driver);
		productspage=new ProductsPage(driver);
		productpage=new ProductDetailsPage(driver);
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
		homepage.pressConsent();
		homepage.openProductsPage();
		productspage.viewProduct();
		assertTrue(driver.getCurrentUrl().contains("product_details"));
		productpage.writeReview(name,mail,message);
		assertTrue(productpage.confirmationmessage.isDisplayed());
		System.out.println(productpage.confirmationmessage.getText());
	}
}
