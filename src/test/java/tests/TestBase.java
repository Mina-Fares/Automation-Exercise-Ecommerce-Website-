package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;


public class TestBase{
	public static WebDriver driver;
	@BeforeSuite
	@Parameters(("browser"))
	public void startDriver(@Optional("chrome") String browsername) {
		String downloadpath=System.getProperty("user.dir")+"\\Downloads";
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			HashMap<String, Object> chromeprefs=new HashMap<String, Object>();
			chromeprefs.put("profile.default.content_settings.popups",0);
			chromeprefs.put("download.default_directory",downloadpath);
			options.setExperimentalOption("prefs", chromeprefs);
			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-features=PreloadMediaEngagementData,AutoplayIgnoreWebAudio");
			options.addArguments("--disable-site-isolation-trials");
			options.addArguments("--disable-blink-features=AutomationControlled");
			driver=new ChromeDriver(options);	
		}
		
		
		else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();	
			
		}
		else if (browsername.equalsIgnoreCase("chrome-headless")) {
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver(options);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://www.automationexercise.com/");
	}
	@AfterSuite()
	public void stopDriver() {
		driver.quit();
	}
	//Take screenshot when test case fail then add it to the screenshots folder
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) throws IOException {
		if (ITestResult.FAILURE==result.getStatus()) {
			System.out.println("Failed");
			System.out.println("Taking screenshot......");
			Helper.CaptureScreenshot(driver,result.getName());
		}
		
	}

}
