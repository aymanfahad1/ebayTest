package ebay.reusable;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReporterNG {
	
	public static ExtentReports getReportObject() //Static means you don't have to declare object of this class
	{   ExtentReports extent;
		String file = System.getProperty("user.dir")+ "//reports//index.html";
		 ExtentSparkReporter reporter = new ExtentSparkReporter(file);
		 reporter.config().setReportName("Web Automations Results");
		 reporter.config().setDocumentTitle("Test Results");
		 
		 extent = new ExtentReports();
		 extent.attachReporter(reporter);
		 extent.setSystemInfo("Tester", "Ayman");
		 return extent;
	}

}
