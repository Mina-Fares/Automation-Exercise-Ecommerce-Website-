package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	protected static WebDriver driver;
	private JavascriptExecutor js;
	//Create constructor
	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver,this);
		PageBase.driver=driver;
		this.js = (JavascriptExecutor) driver;
	}
	protected static void clickbutton(WebElement button) {
		button.click();
	}
	protected static void setTExtElementText(WebElement textElement,String value ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(textElement));
		textElement.sendKeys(value);
	}
	public void scrollTo(){
		js.executeScript("scrollBy(0,1000)");
	}
	public void scrollToBottom(){
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public void clickWithJS(WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", element);
	    js.executeScript("arguments[0].click();", element);
	}

	public void hideAds() {
	    js.executeScript("document.querySelectorAll('iframe[id^=\"aswift\"]').forEach(el => el.style.display = 'none');");
	}
	public void scrollTo(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public void scrollToTop() {
		js.executeScript("window.scrollTo(0, 0);");
	}
}
