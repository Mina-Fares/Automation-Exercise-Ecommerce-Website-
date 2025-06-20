package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class VerifyScrollUpUsingArrowButtonAndScrollDownFunctionality extends TestBase {
	HomePage homepage;
	@Test
	public void userCanScrollUpUsingArrowButtonAndScrollDownFunctionality() {
		homepage=new HomePage(driver);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.automationexercise.com/"));
		System.out.println(driver.getCurrentUrl());
		homepage.pressConsent();
		homepage.scrollToBottom();
		assertTrue(homepage.subscriptiontitle.getText().equalsIgnoreCase("Subscription"));
		System.out.println(homepage.subscriptiontitle.getText());
		homepage.scrollToUpInHomePage();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(homepage.message));
		assertEquals(homepage.message.getText(),"Full-Fledged practice website for Automation Engineers");
		System.out.println(homepage.message.getText());
	}
}
