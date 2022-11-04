package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.baseclass;
import pages.Loginpage;

public class LoginPagetest extends baseclass{
	

	
	Loginpage Login_page = new Loginpage();
	
	@Test
	public void ValidLogin() {
		type(Login_page.getusername(), "sylix");
		type(Login_page.getPassword(), "admin");
		click(Login_page.submit());
	}

}
