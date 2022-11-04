package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import baseClass.elementType;

import baseClass.baseclass;


public class Loginpage extends baseclass{
	
	public WebElement getusername() {
		WebElement UserName = findelements(elementType.Xpath, "//input[@name = 'txt_unam']");
		return UserName;
	}
	
	public WebElement getPassword() {
		WebElement Password = findelements(elementType.Xpath, "//input[@name = 'txt_pass']");
		return Password;
	}
	public WebElement submit() {
		WebElement Submitbutton = findelements(elementType.Name, "Button3");
		return Submitbutton;
	}
	}
	
	
	
	
