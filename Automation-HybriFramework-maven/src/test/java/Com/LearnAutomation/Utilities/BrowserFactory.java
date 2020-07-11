package Com.LearnAutomation.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	
		
	public static WebDriver driver;
   
	public static  WebDriver  StartApp(String browserName,String appURL)
		
	{
		if(browserName.equals("Chrome"))
		{
			 WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver.exe", "./Automation-HybriFramework-maven/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		
		else if (browserName.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver.exe", "./Automation-HybriFramework-maven/Drivers/geckodriver.exe");
			
			driver = new FirefoxDriver();
		}
		
		
		else if(browserName.equals("IE"))
		{
			 WebDriverManager.iedriver().setup();
			 //System.setProperty("webdriver.ie.driver","./Automation-HybriFramework-maven/Drivers/IEDriverServer.exe");  
			driver = new InternetExplorerDriver();
			
		}
		
		
		else
		{
			System.out.println("Please check the browser");
		}
		
		
	    driver.get(appURL);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;
}
	
	
	public  static  void quitBrowser( )
	{
		driver.quit();
	}
}