package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;

public class UserAddSubscription extends TestBase {
	HomePage homepage;
	Faker faker=new Faker();
	String subscripemail=faker.internet().emailAddress();
	@Test
	public void userCanAddSubscription() throws InterruptedException {
		homepage=new HomePage(driver);
		homepage.pressConsent();
		homepage.scrollToBottom();
		Assert.assertTrue(homepage.subscriptiontitle.isDisplayed());
		System.out.println(homepage.subscriptiontitle.getText());
		homepage.addSubscriptionEmail(subscripemail);
		System.out.println(subscripemail);
		assertEquals(homepage.successmessage.getText(),"You have been successfully subscribed!");
		System.out.println(homepage.successmessage.getText());
	}
}
