package seleniumBase;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import baseClass.baseclass;

public class SelBase extends baseclass {

	@BeforeSuite
	private void syso() {
		System.out.println("Before Suite");
		startreport();

	}

	@AfterSuite
	public void aso(){
		System.out.println("After Suite");
		closereport();
	}
 
	

}
