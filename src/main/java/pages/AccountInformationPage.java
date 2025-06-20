package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountInformationPage extends PageBase {

	public AccountInformationPage(WebDriver driver) {
		super(driver);
	}
	public JavascriptExecutor js=(JavascriptExecutor) driver;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/h2")
	public WebElement pagetitle;
	@FindBy(id = "id_gender1")
	WebElement gender1btn;
	@FindBy(id = "id_gender2")
	WebElement gender2btn;
	@FindBy(id = "password")
	WebElement passwordtxt;
	@FindBy(id = "days")
	WebElement dayslist;
	@FindBy(id = "months")
	WebElement monthslist;
	@FindBy(id = "years")
	WebElement yearslist;
	@FindBy(id = "newsletter")
	WebElement checkbox1;
	@FindBy(id = "optin")
	WebElement checkbox2;
	@FindBy(id = "first_name")
	WebElement firstnametxt;
	@FindBy(id = "last_name")
	WebElement lastnametxt;
	@FindBy(id = "company")
	WebElement companytxt;
	@FindBy(id = "address1")
	WebElement address1txt;
	@FindBy(id = "country")
	WebElement countrylist;
	@FindBy(id = "state")
	WebElement statetxt;
	@FindBy(id = "city")
	WebElement citytxt;
	@FindBy(id = "zipcode")
	WebElement zipcodetxt;
	@FindBy(id = "mobile_number")
	WebElement mobilenumbertxt;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/form/button")
	WebElement createbtn;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2")
	public WebElement confirmationmessage;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
	WebElement continuebtn;
	public void userEntersHisData(String password,int day,String month,
			int year,String firstname,String lastname,String companyname,
			String address,int country,String state,String city,String zipcode,String mobilenumber) {
		clickbutton(gender1btn);
		setTExtElementText(passwordtxt,password);
		Select selectday=new Select(dayslist);
		selectday.selectByIndex(day);
		Select selectmonth=new Select(monthslist);
		selectmonth.selectByVisibleText(month);
		Select selectyear=new Select(yearslist);
		selectyear.selectByIndex(year);
		hideAds();
		clickWithJS(checkbox1);
		clickWithJS(checkbox2);
		setTExtElementText(firstnametxt, firstname);
		setTExtElementText(lastnametxt, lastname);
		setTExtElementText(companytxt, companyname);
		setTExtElementText(address1txt, address);
		Select selectcountry=new Select(countrylist);
		selectcountry.selectByIndex(country);
		setTExtElementText(statetxt, state);
		setTExtElementText(citytxt, city);
		setTExtElementText(zipcodetxt, zipcode);
		setTExtElementText(mobilenumbertxt, mobilenumber);
		clickWithJS(createbtn);
	}
	public void redirectToTheNextPage() {
		clickbutton(continuebtn);
	}
}
