package Com.LearnAutomation.Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Com.LearnAutomation.Utilities.BrowserFactory;
import Com.LearnAutomation.Utilities.ConfigDataProvider;
import Com.LearnAutomation.Utilities.ExcelDataProvider;
import Com.LearnAutomation.Utilities.Helpers;
public class BaseClass {
	
	public WebDriver driver;
	
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentHtmlReporter extent;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void setUpSuite()
	{
		Reporter.log("Setting up and Test Started, true",true);
		excel =new ExcelDataProvider();
		config = new ConfigDataProvider();
		extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+ "/Reports/HRTool.html"+ Helpers.getCurrentDateTime()+ ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Setting done-Test Can be Started",true );
		
	}
	
	@BeforeClass	
	
	public void setUp()
	
	{ Reporter.log("Trying to start Browser",true);
		driver = BrowserFactory.StartApp(config.getBrowser(driver), config.geturl(driver));
		Reporter.log("Browser started and application uis uop abd running",true);
		
	}
	
	@AfterClass
	
	public void teardown() 
	
	
	{    BrowserFactory.quitBrowser();
		
		}
	
		
	@AfterMethod
	
	public void teardowmMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//Helpers.CaptureScreenShot();
		logger.fail("Failed case", MediaEntityBuilder.createScreenCaptureFromPath(Helpers.CaptureScreenShot()).build());	
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			//Helpers.CaptureScreenShot();
		logger.pass("Failed case", MediaEntityBuilder.createScreenCaptureFromPath(Helpers.CaptureScreenShot()).build());
			
		}
		
		else if(result.getStatus()==ITestResult.SKIP)
		{
			//Helpers.CaptureScreenShot();
		logger.skip("Skiiped case", MediaEntityBuilder.createScreenCaptureFromPath(Helpers.CaptureScreenShot()).build());
			
		}
		
		report.flush();
	}
}

