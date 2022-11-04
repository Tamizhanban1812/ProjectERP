package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import baseClass.baseclass;
import pages.Loginpage;

public class LoginPagetest extends baseclass{
	

	
	Loginpage Login_page = new Loginpage();
	
	@Test
	public void ValidLogin() {
		Login_page.getusername();
		Login_page.getPassword();
		Login_page.submit();
	}

}
