package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends PageBase {
	JavascriptExecutor js;
	public ProductsPage(WebDriver driver) {
		super(driver);
		this.js=(JavascriptExecutor) driver;
	}
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/h2")
	public WebElement productstitle;
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a")
	WebElement product1link;
	@FindBy(id = "search_product")
	WebElement searchbox;
	@FindBy(id = "submit_search")
	WebElement submitbtn;
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/h2")
	public WebElement searchmessage;
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/img")
	WebElement product1img;
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/img")
	WebElement product2img;
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a")
	WebElement addlink1;
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a")
	WebElement addlink2;
	@FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[3]/button")
	WebElement continuebtn;
	@FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a")
	WebElement viewcartbtn;
	@FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div/h2")
	public WebElement categorytitle;
	@FindBy(xpath = "//*[@id=\"accordian\"]/div[2]/div[1]/h4/a")
	WebElement category2link;
	@FindBy(xpath = "//*[@id=\"Men\"]/div/ul/li[1]/a")
	WebElement subcategory2link;
	@FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div/h2")
	public WebElement category2tilte;
	@FindBy(xpath = "//div[@class='brands_products']//a[contains(text(),'Polo')]")
	WebElement brand1name;
	@FindBy(xpath = "//div[@class='brands_products']//a[contains(text(),'H&M')]")
	public WebElement brand2name;
	@FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div/div[3]/h2")
	public WebElement brandstitle;
	@FindBy(xpath = "//h2[contains(text(),'Brand - Polo Products')]")
	public WebElement brand1title;
	@FindBy(xpath = "//h2[contains(text(),'Brand - H&M Products')]")
	public WebElement brand2title;
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")
	public WebElement cartlink;
	public void viewProduct() {
		scrollTo(product1link);
		clickWithJS(product1link);
	}
	public void userCanSearchforproduct(String clothingtype) {
		searchbox.sendKeys(clothingtype);
		submitbtn.click();
	}
	public void userAddProductsToCart() {
		Actions actions=new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		scrollTo();
		hideAds();
		actions.moveToElement(product1img).perform();
		wait.until(ExpectedConditions.elementToBeClickable(addlink1));
		clickWithJS(addlink1);
		clickWithJS(continuebtn);
		actions.moveToElement(product2img).perform();
		wait.until(ExpectedConditions.elementToBeClickable(addlink2));
		clickWithJS(addlink2);
		clickWithJS(viewcartbtn);
	}
	public void userChooseCategoryAndSubcategory() {
		clickbutton(category2link);
		clickbutton(subcategory2link);
	}
	public void chooseFirstBrand() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(brand1name));
		clickWithJS(brand1name);
	}
	public void chooseSecondBrand() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(brand2name));
		clickWithJS(brand2name);
	}
	@Override
	public void scrollTo(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public int verifySearchedProducts(String searchsubject) throws InterruptedException {
		List<WebElement> productcards=driver.findElements(By.className("single-products"));
		System.out.println("Total jeans products found: " + productcards.size());
		boolean found=false;
		int addedcount=0;
		for (WebElement card : productcards) {
			String productname=card.findElement(By.tagName("p")).getText();
			if(productname.contains("Jeans")) {
				found=true;
				System.out.println("Found element: "+productname+"\t");
				hideAds();
				scrollTo(card);
				Actions actions = new Actions(driver);
	            actions.moveToElement(card).perform();
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	            WebElement productoverlay = card.findElement(By.className("product-overlay"));
	            wait.until(ExpectedConditions.visibilityOf(productoverlay));
				WebElement addToCartBtn = productoverlay.findElement(By.linkText("Add to cart"));
				scrollTo(addToCartBtn);
				clickWithJS(addToCartBtn);
				clickWithJS(driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")));
				addedcount++;
			}
		}
		if(!found) {
			System.out.println("No element contains "+searchsubject);
		}
		return addedcount;
	}
	public void navigateToCartPage() {
		clickbutton(cartlink);
	}
	
}
