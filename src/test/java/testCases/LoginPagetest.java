package testCases;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import baseClass.Browser;
import baseClass.Datadriven;
import baseClass.baseclass;
import dev.failsafe.internal.util.Assert;
import pages.Loginpage;

public class LoginPagetest extends baseclass{
	
	Loginpage Login_page = PageFactory.initElements(driver, Loginpage.class);
	
	@BeforeMethod
	public void setup() throws FileNotFoundException, IOException {
		launchBrowser(Browser.Chrome);
		geturl(prop("url"));
		testcreate("Login Page Validity", "Tam", "Smoke");
	}
	
	@Test(dataProvider = "logindata", dataProviderClass = Datadriven.class)
	public void ValidLogin(String Email, String Password) throws IOException {
		//type(Login_page.UserName, Email);
		//type(Login_page.Password, Password);
		//click(Login_page.Submitbutton);
		//String currentpageurl = geturl();
		//String Actualurl = "http://www.brm.tremplintech.in/web_pages/ord_reg.aspx";
		if(Actualurl == currentpageurl) {
			teststatus("pass");
		}
		else {
			teststatus("fail");
			takesscreenshotmethod("Loginpage");
		}
		
	}
	
	@AfterMethod
	public void teardown() {
		quit();
	}
	
}


