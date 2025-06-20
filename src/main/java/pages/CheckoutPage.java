package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageBase {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//*[@id=\"ordermsg\"]/textarea")
	WebElement descriptiontxt;
	@FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[7]/a")
	WebElement placeorderbtn;
	@FindBy(xpath = "//*[@id=\"address_delivery\"]/li[2]")
	public WebElement fullname1;
	@FindBy(xpath = "//*[@id=\"address_delivery\"]/li[4]")
	public WebElement address1;
	@FindBy(xpath = "//*[@id=\"address_invoice\"]/li[2]")
	public WebElement fullname2;
	@FindBy(xpath = "//*[@id=\"address_invoice\"]/li[4]")
	public WebElement address2;
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
	WebElement deletebtn;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2")
	public WebElement deletemessage;
	public void userWritesHisDicription(String discriptionmsg) {
		setTExtElementText(descriptiontxt,discriptionmsg);
	}
	public void userCanPlaceHisOrder() {
		clickbutton(placeorderbtn);
	}
	public void userCanDeleteHisAccount() {
		clickbutton(deletebtn);
	}
}
