package Com.LearnAutomation.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider()
	  {
		
		try 
		{
			    
			File src = new File("./Configurations/Config.properties");
			
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}  
		
		catch (Exception e) 
		{
			
			System.out.println("not able to load configuration:" + e.getMessage());
		}
		
	}
	
	public String getDatafromConfig(String keytosearch)
	{
		return pro.getProperty(keytosearch); 
		
		
	}

	public String getBrowser(WebDriver driver)
	{
		return pro.getProperty("Browser");
	}
	
	public String geturl(WebDriver driver)
	{
		
		return pro.getProperty("qaURL");
		
	}

}
