package baseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basicFunctions {
	
	
	

	public static final String c = "chrome";
	public static final String e = "edge";
	public static final String f = "firefox";
	WebDriver driver;
	public void testcriteria(String Value) {
		switch (Value.toLowerCase()) {
		case c:
			WebDriverManager.chromedriver().setup();
			break;
		case e:
			WebDriverManager.edgedriver().setup();
			break;
		case f:
			WebDriverManager.firefoxdriver().setup();
			break;
		default:
			System.out.println("No such driver is existing");
			break;
		}
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

}
