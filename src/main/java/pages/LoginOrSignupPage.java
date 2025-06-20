package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginOrSignupPage extends PageBase {

	public LoginOrSignupPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/h2")
	public WebElement newusermessage;
	@FindBy(name = "name")
	WebElement nametxt;
	@FindBy(xpath =  "//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
	WebElement emailtxt;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/button")
	WebElement signupbtn;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div[1]/form/input[2]")
	WebElement loginmailtxt;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div[1]/form/input[3]")
	WebElement passwordtxt;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div[1]/form/button")
	WebElement loginbtn;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div[1]/h2")
	public WebElement registeredusermessage;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div[1]/form/p")
	public WebElement errormessage;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/p")
	public WebElement errormessage1;
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a")
	WebElement contactusbtn;
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")
	WebElement cartlink;
	public void userRegister(String name,String email) {
		setTExtElementText(nametxt, name);
		setTExtElementText(emailtxt, email);
		clickbutton(signupbtn);
	}
	public void userLogin(String email,String password) {
		setTExtElementText(loginmailtxt, email);
		setTExtElementText(passwordtxt, password);
		clickbutton(loginbtn);
	}
	public void userOpenContactUsPage() {
		clickbutton(contactusbtn);
	}
	public void navigateToCartPage() {
		clickbutton(cartlink);
	}

}
