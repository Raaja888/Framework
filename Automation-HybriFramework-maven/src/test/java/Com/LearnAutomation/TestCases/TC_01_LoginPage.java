package Com.LearnAutomation.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Com.LearnAutomation.Pages.BaseClass;
import Com.LearnAutomation.Pages.LoginPage;

  

public class TC_01_LoginPage extends BaseClass {
	
	@Test
	public void  loginpageApp()
	{// Report is available
		
		logger =report.createTest("Login to HRM");
		//ExcelDataProvider excel = new ExcelDataProvider();
		LoginPage log = PageFactory.initElements(driver, LoginPage.class);
		//log.EnterDetails("Admin", "admin123");
		
		logger.info("Starting Application");
		log.EnterDetails(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
		logger.pass("Login done succesfully");
		
	}
	

}
