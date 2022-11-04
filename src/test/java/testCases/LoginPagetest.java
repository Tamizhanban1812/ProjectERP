package testCases;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseClass.Browser;
import baseClass.Datadriven;
import baseClass.baseclass;
import dev.failsafe.internal.util.Assert;
import pages.Loginpage;

public class LoginPagetest extends baseclass{
	

	
	Loginpage Login_page = new Loginpage();
	
	@BeforeMethod
	public void setup() throws FileNotFoundException, IOException {
		launchBrowser(Browser.Chrome);
		geturl(prop("url"));
		
	}
	
	@Test(dataProvider = "logindata", dataProviderClass = Datadriven.class)
	public void ValidLogin(String Email, String Password) {
		type(Login_page.getusername(), Email);
		type(Login_page.getPassword(), Password);
		click(Login_page.submit());
		String currentpageurl = geturl();
		assertEquals("http://www.brm.tremplintech.in/web_pages/ord_reg.aspx", currentpageurl);
	}
	
	@AfterMethod
	public void teardown() {
		quit();
	}
}
