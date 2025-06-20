package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Year;
import java.util.Random;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.AccountInformationPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginOrSignupPage;
import pages.MyAccountPage;
import pages.PaymentPage;
import pages.ProductsPage;

public class PlaceOrderAndRegisterWhileCheckout extends TestBase {
	HomePage homepage;
	ProductsPage productspage;
	CartPage cartpage;
	LoginOrSignupPage page;
	AccountInformationPage mypage;
	MyAccountPage myaccountpage;
	CheckoutPage checkkoutpage;
	PaymentPage paymentpage;
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
	String mobilenumber=faker.phoneNumber().cellPhone();
	String discriptionmsg=faker.lorem().paragraph(4);
	String cardnumber=faker.finance().creditCard();
	String cvc = String.format("%03d", faker.number().numberBetween(0, 999));
	String month = String.format("%02d",faker.number().numberBetween(1, 12));
	int currentYear = Year.now().getValue();
	int expirationYear = faker.number().numberBetween(currentYear, currentYear + 6);
	String yearforpay=String.format("%02d",expirationYear%100);
	@Test
	public void userCanPlaceOrderAndRegisterWhileCheckout() {
		homepage=new HomePage(driver);
		productspage=new ProductsPage(driver);
		cartpage=new CartPage(driver);
		page=new LoginOrSignupPage(driver);
		mypage=new AccountInformationPage(driver);
		myaccountpage=new MyAccountPage(driver);
		checkkoutpage=new CheckoutPage(driver);
		paymentpage=new PaymentPage(driver);
		assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
		homepage.pressConsent();
		homepage.openProductsPage();
		productspage.userAddProductsToCart();
		assertTrue(driver.getCurrentUrl().contains("cart"));
		cartpage.userCanProceedToCheckout();
		cartpage.userNavigateToSignupOrLoginPage();
		page.userRegister(name,email);
		mypage.userEntersHisData(password,day,randomMonth,year,firstname,lastname,company,address,country,state,city,zipcode,mobilenumber);
		assertEquals(mypage.confirmationmessage.getText(),"ACCOUNT CREATED!");
		mypage.redirectToTheNextPage();
		assertEquals(myaccountpage.message.getText(),"Logged in as "+name);
		myaccountpage.userCanNavigateToCartPage();
		cartpage.userCanProceedToCheckout();
		checkkoutpage.userWritesHisDicription(discriptionmsg);
		checkkoutpage.userCanPlaceHisOrder();
		paymentpage.userEntersHisCardInformation(name,cardnumber,cvc,month,yearforpay);
		assertEquals(paymentpage.confirmatiommessage.getText(),"Congratulations! Your order has been confirmed!");
		myaccountpage.userCanDeleteHisAccount();
		assertEquals(myaccountpage.deletemessage.getText(),"ACCOUNT DELETED!");
	}
}
