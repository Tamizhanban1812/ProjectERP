package baseClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Loginpage;

public class baseclass {
	
	public static WebDriver driver;
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
	
}
