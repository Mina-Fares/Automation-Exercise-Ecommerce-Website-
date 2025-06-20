package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
	WebElement logoutbtn;
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")
	public WebElement message;
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
	WebElement deletebtn;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2")
	public WebElement deletemessage;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
	WebElement continuebtn;
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")
	WebElement cartlink;
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
	WebElement productslink;
	public void userCanDeleteHisAccount() {
		clickbutton(deletebtn);
	}
	public void userRedirectToHomePage() {
		clickbutton(continuebtn);
	}
	public void userCanLogout() {
		clickbutton(logoutbtn);
	}
	public void userCanNavigateToCartPage() {
		clickbutton(cartlink);
	}
	public void userCanNavigateToProductsPage() {
	clickbutton(productslink);	
	}
	

}
