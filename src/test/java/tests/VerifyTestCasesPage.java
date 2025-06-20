package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.TestCasesPage;

public class VerifyTestCasesPage extends TestBase {
	HomePage homepage;
	TestCasesPage testpage;
	@Test
	public void userCanNavigateToTestCasesPage() {
		homepage=new HomePage(driver);
		testpage=new TestCasesPage(driver);
		homepage.pressConsent();
		homepage.openTestCasesPage();
		Assert.assertTrue(driver.getCurrentUrl().contains("test_cases"));
		System.out.println(driver.getCurrentUrl());
		assertTrue(testpage.message.getText().contains("Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:"));
		System.out.println(testpage.message.getText());
	}
}
