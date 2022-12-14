package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Loginpage;

public class baseclass {
	
	public static WebDriver driver;
	public static ExtentReports  extent;
	public static ExtentTest Test;
	 
	public void launchBrowser(Browser Browsername) {
		switch (Browsername) {
		case Chrome:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case Edge:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case FireFox:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("No such driver is existing");
			break;
		}
	}
	
	public void geturl (String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}
	
	public void close() {
		driver.close();
	}
	
	public void quit() {
		driver.quit();
	}
	
	public WebElement findelements (elementType elementtype, String Value) {
		switch (elementtype) {
		case ID:
			return driver.findElement(By.id(Value));	
		case Name:
			return driver.findElement(By.name(Value));	
		case Xpath:
			return driver.findElement(By.xpath(Value));  
		default:
			break;
		}
		return null;
	}
	
	public void type (WebElement element, String value) {
	element.clear();
	element.sendKeys(value);
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public String geturl() {
		return driver.getCurrentUrl();
	}
	
	public String prop(String Key) throws FileNotFoundException, IOException {
		Properties property = new Properties();
		property.load(new FileInputStream("./property.properties"));
		String Value = property.getProperty(Key);
		return Value;
	}
	
	public void startreport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Testreport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	public void closereport() {
		extent.flush();
	}
	
	public void testcreate(String Desc, String Author, String Category) {
		Test = extent.createTest(Desc);
		Test.assignAuthor(Author);
		Test.assignCategory(Category);
	}
	
	public void teststatus(String Status) {
		switch (Status) {
		case "pass":
			Test.pass("The test is passed");
			break;
		case "fail":
			Test.fail("The test is failed");
			break;
		default:
			break;
		}
	}
	
	public void takesscreenshotmethod(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trgt = new File ("./" + filename + ".png");
		Files.copy(src, trgt);
	}
	
}
