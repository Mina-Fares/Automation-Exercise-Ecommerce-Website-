package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase {

	public CartPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "cart_info_table")
	WebElement productstable;
	@FindBy(xpath = "//*[@id=\"product-1\"]/td[4]/button")
	public WebElement quantitytxt;
	@FindBy(xpath = "//*[@id=\"do_action\"]/div[1]/div/div/a")
	WebElement proceedbtn;
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
	WebElement registerOrloginbtn;
	@FindBy(xpath = "//*[@id=\"product-1\"]/td[6]/a")
	WebElement removelink1;
	@FindBy(xpath = "//*[@id=\"product-2\"]/td[6]/a")
	WebElement removelink2;
	@FindBy(xpath = "//*[@id=\"empty_cart\"]/p")
	public WebElement emptymessage;
	public void verifyProducts() {
		List<WebElement> rows=productstable.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			List<WebElement> cols=row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				System.out.println(col.getText()+"\t");
			}
			System.out.println();
		}	
	}
	public void userCanProceedToCheckout() {
		clickbutton(proceedbtn);
	}
	public void userNavigateToSignupOrLoginPage() {
		clickbutton(registerOrloginbtn);
	}
	public void removeproducts() {
		clickbutton(removelink1);
		clickbutton(removelink2);
	}
	public void verifyProductsInCartPage(int productsnumber) {
		List<WebElement> cartitems=driver.findElements(By.className("cart_product"));
		if(cartitems.size()==productsnumber) {
			System.out.println("Checked: products in cart equal what you chose");
		}
		else {
			System.out.println("You need to check your order again");
		}
	}
}
