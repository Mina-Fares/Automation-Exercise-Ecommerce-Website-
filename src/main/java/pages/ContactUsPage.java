package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{
	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2")
	public WebElement welcomemessage;
	@FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[1]/input")
	WebElement nametxt;
	@FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[2]/input")
	WebElement emailtxt;
	@FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[3]/input")
	WebElement subjecttxt;
	@FindBy(id = "message")
	WebElement messagetxt;
	@FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[5]/input")
	WebElement choosebtn;
	@FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[6]/input")
	WebElement submitbtn;
	@FindBy(xpath = "//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]")
	public WebElement successmessage;
	@FindBy(xpath = "//*[@id=\"form-section\"]/a")
	WebElement homebtn;
	public void userFillContactForm(String name,String email,String subject,String message,String filename) {
		String filepath=System.getProperty("user.dir")+"\\Uploads\\"+filename;
		setTExtElementText(nametxt,name);
		setTExtElementText(emailtxt,email);
		setTExtElementText(subjecttxt,subject);
		setTExtElementText(messagetxt,message);
		choosebtn.sendKeys(filepath);
		clickWithJS(submitbtn);
	}
	public void userNavigateToHomePage() {
		clickbutton(homebtn);
	}
}
