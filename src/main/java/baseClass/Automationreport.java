package baseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Automationreport {

	public static void main(String[] args) {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Newextentreport.html");
		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		ExtentTest test = report.createTest("Check in login Validity");
		test.pass("The page is ok");
		test.pass("The page is logging in");
		report.flush();
	}

}
