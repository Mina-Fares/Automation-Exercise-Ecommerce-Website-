package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
	WebElement LoginOrSignupbtn;
	@FindBy(xpath = "/html/body/div/div[2]/div[2]/div[2]/div[2]/button[1]")
	WebElement consentbtn;
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a")
	WebElement contactusbtn;
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
	WebElement testcaseslink;
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
	WebElement productslink;
	@FindBy(xpath = "//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")
	public WebElement subscriptiontitle;
	@FindBy(id = "susbscribe_email")
	WebElement subscripemailtxt;
	@FindBy(xpath = "//*[@id=\"success-subscribe\"]/div")
	public WebElement successmessage;
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")
	WebElement cartlink;
	@FindBy(xpath = "//*[@id=\"accordian\"]/div[1]/div[1]/h4/a")
	WebElement category1link;
	@FindBy(xpath = "//*[@id=\"Women\"]/div/ul/li[1]/a")
	WebElement subcategory1link;
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div[2]/h2")
	WebElement recommendedtitle;
	@FindBy(xpath = "//*[@id=\"recommended-item-carousel\"]/div/div[2]/div[1]/div/div/div/a")
	WebElement recommendedlink1;
	@FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")
	WebElement viewcardbtn;
	@FindBy(xpath = "//*[@id=\"slider-carousel\"]/div/div[1]/div[1]/h2")
	public WebElement message;
	@FindBy(id = "scrollUp")
	WebElement uplink;
	public void openLoginOrSignupPage() {
		clickbutton(LoginOrSignupbtn);
	}
	public void pressConsent() {
		clickbutton(consentbtn);
	}
	public void openContactUsPage() {
		clickbutton(contactusbtn);
	}
	public void openTestCasesPage() {
		clickbutton(testcaseslink);
	}
	public void openProductsPage() {
		clickbutton(productslink);
	}
	public void scrollToSubscriptionSection() {
		scrollToBottom();
	}
	public void addSubscriptionEmail(String email) {
		subscripemailtxt.sendKeys(email);
		subscripemailtxt.submit();
	}
	public void openCartPage() {
		clickbutton(cartlink);
	}
	public void chooseCategoryAndSubcategory() {
		clickbutton(category1link);
		clickbutton(subcategory1link);
	}
	public void scrollToProductsSection() {
		scrollTo();
	}
	public void addToCartFromRecommendedItems() {
		scrollTo(recommendedtitle);
		clickbutton(recommendedlink1);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(viewcardbtn));
		clickbutton(viewcardbtn);
		
	}
	public void scrollToBottomInHomePage() {
		scrollToBottom();
	}
	public void scrollToUpInHomePage() {
		clickbutton(uplink);
	}
	public void scrollToTopWithoutButton() {
		scrollToTop();
	}
}
