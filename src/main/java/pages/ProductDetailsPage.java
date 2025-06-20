package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2")
	public WebElement productname;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]")
	public WebElement category;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span")
	public WebElement price;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]/b")
	public WebElement availability;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]/b")
	public WebElement condition;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]/b")
	public WebElement brand;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]/a/span")
	public WebElement brandname;
	@FindBy(id = "quantity")
	WebElement quantitytxt;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button")
	WebElement addlink;
	@FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a")
	WebElement viewcartbtn;
	@FindBy(id = "name")
	WebElement reviewname;
	@FindBy(id = "email")
	WebElement reviewmail;
	@FindBy(id = "review")
	WebElement reviewmessage;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[3]/div[1]/ul/li/a")
	WebElement reviewsectiontitle;
	@FindBy(id = "button-review")
	WebElement submitreviewbtn;
	@FindBy(xpath = "//*[@id=\"review-section\"]/div/div/span")
	public WebElement confirmationmessage;
	public void modifyProductQuantity(String quantity) {
		quantitytxt.clear();
		quantitytxt.sendKeys(quantity);
	}
	public void addToCart() {
		clickbutton(addlink);
	}
	public void viewCart() {
		clickbutton(viewcartbtn);
	}
	public void writeReview(String name,String mail,String message) {
		scrollTo(reviewsectiontitle);
		setTExtElementText(reviewname,name);
		setTExtElementText(reviewmail, mail);
		setTExtElementText(reviewmessage, message);
		clickbutton(submitreviewbtn);
		
	}
}
