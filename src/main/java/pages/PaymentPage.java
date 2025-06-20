package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends PageBase {

	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//*[@id=\"payment-form\"]/div[1]/div/input")
	WebElement nameoncardtxt;
	@FindBy(xpath = "//*[@id=\"payment-form\"]/div[2]/div/input")
	WebElement cardnumbertxt;
	@FindBy(xpath = "//*[@id=\"payment-form\"]/div[3]/div[1]/input")
	WebElement cvctxt;
	@FindBy(xpath = "//*[@id=\"payment-form\"]/div[3]/div[2]/input")
	WebElement monthtxt;
	@FindBy(xpath = "//*[@id=\"payment-form\"]/div[3]/div[3]/input")
	WebElement yeartxt;
	@FindBy(id = "submit")
	WebElement paybtn;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/p")
	public WebElement confirmatiommessage;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/a")
	WebElement downloadbtn;
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
	WebElement deletebtn;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2")
	public WebElement deletemessage;
	public void userEntersHisCardInformation(String nameoncard,String cardnumber,String cvc,String month,String year) {
		setTExtElementText(nameoncardtxt, nameoncard);
		setTExtElementText(cardnumbertxt,cardnumber);
		setTExtElementText(cvctxt, cvc);
		setTExtElementText(monthtxt, month);
		setTExtElementText(yeartxt, year);
		clickWithJS(paybtn);
	}
	public void userCanDownloadInvoice() {
		clickbutton(downloadbtn);
	}
	public void userCandeleteHisAccount() {
		clickbutton(deletebtn);
	}
	

}
