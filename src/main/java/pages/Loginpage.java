package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import baseClass.elementType;

import baseClass.baseclass;


public class Loginpage extends baseclass{
	
	public void getusername() {
		WebElement UserName = findelements(elementType.Xpath, "//input[@name = 'txt_unam']");
		type(UserName, "sylix");
	}
	
	public void getPassword() {
		WebElement Password = findelements(elementType.Xpath, "//input[@name = 'txt_pass']");
		type(Password, "admin");
	}
	public void submit() {
		WebElement Submitbutton = findelements(elementType.Name, "Button3");
		click(Submitbutton);
	}
	}
	
	
	
	
