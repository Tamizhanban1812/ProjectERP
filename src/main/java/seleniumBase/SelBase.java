package seleniumBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import baseClass.Browser;
import baseClass.baseclass;

public class SelBase extends baseclass {

	
	
	@BeforeSuite
	public void setup() {
		launchBrowser(Browser.Chrome);
		geturl("http://www.brm.tremplintech.in/web_pages/login.aspx");
	}
	
	@AfterSuite
	public void teardown() {
		quit();
	}
 
	

}
