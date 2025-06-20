package tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.AccountInformationPage;
import pages.HomePage;
import pages.LoginOrSignupPage;
import pages.MyAccountPage;

public class UserRegisteration extends TestBase {
	HomePage homepage;
	LoginOrSignupPage page;
	AccountInformationPage accountpage;
	MyAccountPage mypage;
	Faker faker=new Faker();
	String name=faker.name().username();
	String email=faker.internet().emailAddress();
	String password=faker.number().digits(8);
	Random random=new Random();
	int day=random.nextInt(30)+0;
	String[] months = {
			"January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December"
	};
	String randomMonth = months[faker.random().nextInt(12)];
	int year=random.nextInt(124)+0;
	String firstname=faker.name().firstName();
	String lastname=faker.name().lastName();
	String company=faker.company().name();
	String address=faker.address().fullAddress();
	int country=random.nextInt(6)+0;
	String state=faker.address().state();
	String city=faker.address().city();
	String zipcode=faker.address().zipCode();
	String mobilenuber=faker.phoneNumber().cellPhone();
	@Test
	public void UserCanRegisterSuccessfully() {
		homepage=new HomePage(driver);
		page=new LoginOrSignupPage(driver);
		accountpage=new AccountInformationPage(driver);
		mypage=new MyAccountPage(driver);
		homepage.pressConsent();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
		System.out.println(driver.getCurrentUrl());
		homepage.openLoginOrSignupPage();
		Assert.assertEquals(page.newusermessage.getText(),"New User Signup!");
		System.out.println(page.newusermessage.getText());
		page.userRegister(name,email);
		Assert.assertEquals(accountpage.pagetitle.getText(),"ENTER ACCOUNT INFORMATION");
		System.out.println(accountpage.pagetitle.getText());
		accountpage.hideAds();
		accountpage.userEntersHisData(password, day,randomMonth,year,firstname,lastname,company,address,country,state,city, zipcode,mobilenuber);
		Assert.assertTrue(accountpage.confirmationmessage.getText().contains("ACCOUNT CREATED!"));
		System.out.println(accountpage.confirmationmessage.getText());
		accountpage.redirectToTheNextPage();
		Assert.assertEquals(mypage.message.getText(),"Logged in as "+name);
		System.out.println(mypage.message.getText());
		mypage.userCanDeleteHisAccount();
		Assert.assertEquals(mypage.deletemessage.getText(),"ACCOUNT DELETED!");
		System.out.println(mypage.deletemessage.getText());
		mypage.userRedirectToHomePage();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
		System.out.println(driver.getCurrentUrl());
		
	}
}


